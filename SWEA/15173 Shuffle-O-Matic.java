package b15173;

import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int[] card;
	static int best;
	static boolean[] visited;
	static int[] seq = new int[6];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc =1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			card = new int[N];
			visited = new boolean[N];
			for(int i = 0; i<N;i++) {
				card[i] = Integer.parseInt(st.nextToken());
			}
			best = Integer.MAX_VALUE;
			
			
			if(isAligned()) best = 0;
			else dfs(0);
			best = best == Integer.MAX_VALUE? -1:best;
			sb.append("#").append(tc).append(" ").append(best).append("\n");
		}
		System.out.print(sb);
		br.close();
		
		
 
	}
	public static void dfs(int depth) {
		if(isAligned()) {
			best = Math.min(best, depth);
			return;
		}
		if(depth>=best) {
			return;
		}
		
		if(depth ==6) {
			return;
		}
		for(int i = 1; i<N; i++) { //x가 0이면 셔플에 의미가 없음
			int[] tmp = Arrays.copyOf(card, N);
			seq[depth] = i;
			shuffle(i);
			dfs(depth+1);
			card = Arrays.copyOf(tmp, N);
		}
	}
	public static void shuffle( int x) {
	
		int cur1 = N/2-1;
		int cur2 = N/2-1;
		boolean flag = false;
		for(int i = 0; i<x;i++) {
			int start = cur1;
			int end = cur2;
			for(int j =start; j<=end; j+=2) {	
				if(j == 0)flag = true;
				if(j< 0) {
					continue;
				}
				else if(j+1>=N) {
					continue;
				}
				
				int tmp = card[j];
				card[j] = card[j+1];
				card[j+1] = tmp;
			}
			if(flag == false) {
				cur1--;
				cur2++;
			}else {
				cur1++;
				cur2--;	
			}
		}
	}
	
	public static boolean isAligned() {
		boolean ascending;//오름차순 여부
		if(card[0] < card[1]) {
			ascending = true; 
		}
		else {
			ascending = false;
		}
		for(int i = 1; i<N-1; i++) {
			if(ascending && card[i] > card[i+1]) return false;
			if(ascending == false && card[i] < card[i+1]) return false;
		}
		return true;
	}

}
