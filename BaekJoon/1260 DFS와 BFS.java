package b1260;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N  = Integer.parseInt(st.nextToken());
		int M  = Integer.parseInt(st.nextToken());
		int V  = Integer.parseInt(st.nextToken());
		
		int[][] g = new int[N+1][N+1];
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			g[start][end] = 1;
			g[end][start] = 1;
		}
		
		boolean[] visited=  new boolean[N+1];
		
		dfs(V,g,visited);
		System.out.println();
		Arrays.fill(visited, false);
		bfs(V,g,visited);
		
		br.close();
		
	}
	public static void dfs(int v, int[][] g, boolean[] visited) {
		
		visited[v] = true;
		System.out.print(v +" ");
		
		for(int i = 1; i< g[v].length; i++) {
			if(visited[i] == false && g[v][i] == 1) {
				dfs(i,g,visited);
			}
		}
	}
	
	public static void bfs(int v, int[][] g, boolean[] visited) {
		
		Queue<Integer> q = new ArrayDeque<Integer>();
		q.offer(v);
		visited[v] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			System.out.print(now +" ");
			for(int i = 1; i< g[now].length; i++) {
				if(visited[i] == false && g[now][i] == 1) {
					q.offer(i);
					visited[i] = true;
				}
			}
		}	
	}
}
