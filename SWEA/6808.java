package s6808;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int win, lose;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");

			int[] cards = new int[9]; //규영이가 받은 카드
			int[] cards_inyoung = new int[9]; //인영이가 받은 카드
			win = 0;
			lose = 0;
			boolean[] inyoung = new boolean[18];
			for(int i = 0; i<9; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				cards[i] = tmp;
				inyoung[tmp-1] = true;
			}
			int cnt = 0;
			for(int i =0; i<18; i++) {
				if(inyoung[i] == false) {
					cards_inyoung[cnt++] = i+1;
				}
			}
			perm(0,cards,cards_inyoung);
			sb.append("#").append(tc).append(" ").append(win).append(" ").append(lose).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	static void perm(int depth, int[] cards, int[] cards_inyoung) {
		if(depth == 9) {
			int result = 0;
			for(int i = 0; i< 9; i++) {
				if(cards_inyoung[i] > cards[i]) {
					result += cards_inyoung[i] + cards[i];
				} else if(cards_inyoung[i] < cards[i]) {
					result -= cards_inyoung[i] + cards[i];
				}
			}
			if(result > 0 ) {
				lose++; // 규영이 패배
			} else if(result < 0) { 
				win++; // 규영이 승
			}
			return;
		}
		for(int i = depth; i< 9; i++) {
			int tmp = cards_inyoung[depth];
			cards_inyoung[depth] = cards_inyoung[i];
			cards_inyoung[i] = tmp;
			perm(depth+1,cards,cards_inyoung);
			cards_inyoung[i] = cards_inyoung[depth];
			cards_inyoung[depth]=tmp;
			
		}
	}
	

}
