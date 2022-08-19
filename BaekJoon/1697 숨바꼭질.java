package b1697;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] visited = new int[100001];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		System.out.println(bfs(N,K,0));
		br.close();
	
	}
	public static int bfs(int N,int K, int time) {
		
		Queue<int[]> q = new ArrayDeque<>();
		visited[N] = 1;
		
		q.offer(new int[] {N,0});
		while(!q.isEmpty()) {
			int[] now = q.poll();
			if(now[0] == K) {
				return now[1];
			}
			
			int nexttime = now[1] + 1;

			int next = now[0] * 2;
			if(!(next < 0 || next > 100000 || visited[next] == 1  )) {
				visited[next] = 1;
				q.offer(new int[] {next,nexttime});
			}
			next = now[0] * 2;
			if(!(next < 0 || next > 100000 || visited[next] == 1)) {
				visited[next] = 1;
				q.offer(new int[] {next,nexttime});
			}
				
			next = now[0] + 1;
			if(!(next < 0 || next > 100000 || visited[next] == 1 )) {
				visited[next] = 1;
				q.offer(new int[] {next,nexttime});
			}
			
			next = now[0] - 1;
			if(!( next < 0 || next > 100000 || visited[next] == 1 )) {
				visited[next] =1;
				q.offer(new int[] {next,nexttime});
			}
		
		}

		
		return 0;
		
	}
	
}
