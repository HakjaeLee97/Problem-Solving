package b1753;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader( System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int K =Integer.parseInt(br.readLine())-1;
		
		ArrayList<int[]>[] arr = new ArrayList[V];
		
		for(int i =0; i<E; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int u = Integer.parseInt(st.nextToken())-1;
			int v = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			if(arr[u] == null) arr[u] = new ArrayList<>();
			arr[u].add(new int[]{v, w});
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> o1[1]-o2[1]);
		pq.add(new int[] {K,0});
		
		int[] dist = new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[K] = 0;

		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int curV = cur[0];
			int curW = cur[1];
			if(arr[curV] == null ||dist[curV] < curW) continue;
			for(int[] next : arr[curV]) {
				int nextV = next[0];
				int nextW = next[1];
				if(curW + nextW < dist[nextV]) {
					dist[nextV] = curW+nextW;
					pq.offer(new int[] {nextV, dist[nextV]});
				}
			}
		}
		
		for(int i : dist) {
			if(i != Integer.MAX_VALUE) {
				sb.append(i).append("\n");
			}
			else {
				sb.append("INF").append("\n");
			}
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

}
