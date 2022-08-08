package s9229;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int best;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc<=T; tc++ ) {
			best = -1;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] snack = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<N; i++) {
				snack[i] = Integer.parseInt(st.nextToken());
			}
			boolean[] visited = new boolean[N];
			int[] picked = new int[2];
			
			comb(snack,picked,visited,N,M,0,0);
			sb.append("#").append(tc).append(" ").append(best).append("\n");
		}
		System.out.print(sb);
	}
	public static void comb(int[] snack,int[] picked, boolean[] visited,int N,int M, int start,int cnt) {
		int answer = -1;
		if(cnt == 2) {
			answer =  picked[0] + picked[1];
			if(answer <= M) {
				best = Math.max(answer,best);
			}
			return;
			
		}
		
		for(int i = start; i<N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			picked[cnt] = snack[i];
			comb(snack,picked,visited,N,M,i+1,cnt+1);
			visited[i] = false;
		}
	}
	

}


/*static void comb(int depth, int start) {
	if(depth == R) {
		System.out.println(Arrays.toString(b));
		C++;
		return;
	}
	for(int i = start; i< N; i++) {
		if(!v[i]) {
		v[i] = true;
		b[depth] = a[i];
		comb(depth+1,i+1);
			v[i] = false;
		}
	}
}*/