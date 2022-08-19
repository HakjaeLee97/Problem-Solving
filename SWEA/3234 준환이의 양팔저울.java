package s3234;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int totalcnt;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		
		for(int tc= 1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			totalcnt = 0;
			int[] w = new int[N];
			int[] weight = new int[N];// 순열의 결과물 배열
			visited = new boolean[N];
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int i = 0; i < N; i++) {
				w[i] = Integer.parseInt(st.nextToken());	
			}	
			perm(0,w,N,weight);
			sb.append("#").append(tc).append(" ").append(totalcnt).append("\n");
		}
		System.out.print(sb);
		br.close();
		
		
	}
	public static void perm(int depth,int[] w, int N, int[] weight) {
		if(depth == N) {
			calc(0,0,0,N,weight);
			return;
		}
		for(int i = 0; i<N; i++) {
			if(visited[i]) continue;
			visited[i] =true;
			weight[depth] = w[i];
			perm(depth+1, w,N,weight);
			visited[i] = false;
			
		}
	}
	public static void calc(int lsum, int rsum, int depth, int N, int[] weight) {
		if(depth == N) {
			if (lsum >= rsum) {
				totalcnt++;
			}
			return;
		}
		calc(lsum+weight[depth],rsum,depth+1,N,weight);
		if(lsum>=rsum+weight[depth]) calc(lsum,rsum+weight[depth],depth+1,N,weight);	
	}

}
