package s5215;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int best;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			best = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			
			int[][] ingre = new int[N][2];
			for(int i = 0; i< N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				ingre[i][0] = Integer.parseInt(st.nextToken());
				ingre[i][1] = Integer.parseInt(st.nextToken());
			}
			comb(0,0,0,0,0,N,L,ingre);
			sb.append("#").append(tc).append(" ").append(best).append("\n");
		}
		System.out.print(sb);
		
	}
	
	private static void comb(int cnt, int flag,  int start,int score,int calory,int N, int L, int[][] ingre) { // cnt: 직전까지 뽑은 순열에 포함된 수의 개수
		//flag : 선택된 수들의 상태를 비트로 표현하고 있는 비트열(정수)
		//cnt +1번째 해당하는 순열에 포함될 수를 뽑기
		if(calory > L) return;
		best = Math.max(score, best);

		//가능한 모든 수에 대해 시도 (input 배열의 모든 수 시도)
		for(int i =start; i< N;i++) {//선택지
			
			//시도하는 수가 선택되었는지 판단
			if( (flag & 1 << i) != 0) continue;
			//선택되지 않았다면 수를 사용
			//다음 수 뽑으러 가기
			comb(cnt+1, flag | 1 << i , i + 1,score+ingre[i][0],calory+ingre[i][1],N,L,ingre);
		}
	}
}
