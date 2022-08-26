package b2252;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node{
		int vertex;
		Node next;
		public Node(int vertex, Node next) {
			this.vertex = vertex;
			this.next = next;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Node[] g = new Node[N+1];
		int[] indegree = new int[N+1];
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			g[a] = new Node(b,g[a]);
			indegree[b]++;
		}
		
		Queue<Integer> q = new ArrayDeque<Integer>();
		for(int i = 1; i<=N; i++) {
			if(indegree[i] == 0) q.offer(i);
		}
		while(!q.isEmpty()) {
			int i = q.poll();
			
			sb.append(i).append(" ");
			for(Node tmp = g[i]; tmp != null; tmp = tmp.next) {
				if(--indegree[tmp.vertex] == 0) q.offer(tmp.vertex);
			}
		}
		System.out.println(sb);
		br.close();
		
	}

}
