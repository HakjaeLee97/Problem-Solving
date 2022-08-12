package s4012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[][] synergy;
	static int[] foodsA;
	static int[] foodsB;
	static boolean[] selected;
	static int best, N;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb= new StringBuilder();
		
		
		for(int tc =1 ; tc<= T; tc++) {
			N = Integer.parseInt(br.readLine());
			foodsA = new int[N/2];
			foodsB = new int[N/2];
			synergy = new int[N][N];
			best= Integer.MAX_VALUE;
			selected = new boolean[N];
			for(int i = 0; i< N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for(int j = 0; j < N; j++) {
					synergy[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			comb(0,0);
			sb.append("#").append(tc).append(" ").append(best).append("\n");
			
			
		}
		System.out.print(sb);
		
		
	}
	public static void comb(int depth, int start) {
		if(depth == N/2) {
			int idx1 = 0;
			int idx2 = 0;
			for(int i = 0; i< N; i++) {
				if(selected[i]) {
					foodsA[idx1++] = i;
				}else {
					foodsB[idx2++] = i;
				}
			}
			calc();
			return;
		}
		
		for(int i = start; i< N; i++) {
			if(selected[i]) continue;
			selected[i] = true;
			comb(depth+1,i+1);
			selected[i] = false;
		}
	}
	public static void calc() {
		int food1 = 0;
		int food2 = 0;
		for(int i = 0; i< N/2; i++) {
			for(int j = 0; j < N/2; j++) {
				if (i == j) continue;
				food1 += synergy[foodsA[i]][foodsA[j]];
				food2 += synergy[foodsB[i]][foodsB[j]];
			}
		}
		int result = Math.abs(food2- food1);
		best = Math.min(result, best)
;		
	}
}
