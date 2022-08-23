package b13023;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static ArrayList<Integer>[] g;
	static boolean flag;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		g = new ArrayList[N];
		for(int i =0; i<N;i++) {
			g[i] = new ArrayList<>();
		}
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			g[a].add(b);
			g[b].add(a);
		}
		boolean[] v = new boolean[N];
		for(int i =0; i<N;i++) {
			dfs(1,i,i,v);
			if(flag) break;
		}
		if(flag) System.out.println(1);
		else System.out.println(0);
	}
	public static void dfs(int count, int start,int initial,boolean[] visited) {
		if(flag) return;
		visited[start] = true;
		if(count == 5) {
			flag = true;
			return;
		}
		for(int i =0,size=g[start].size(); i<size;i++) {
			int next = g[start].get(i);
			if(visited[next] ==false) {
				dfs(count +1, next,initial,visited);
				visited[next] = false;
				if(flag) break;
				
			}
		}
		visited[start] = false;
	}

}
