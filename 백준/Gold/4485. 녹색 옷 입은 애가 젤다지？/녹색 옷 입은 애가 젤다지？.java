import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int prob = 0;
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			
			int[][] map = new int[N][N];
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int[][] dist = new int[N][N];
			boolean[][] visited =new boolean[N][N];
			PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> Integer.compare(o1[2], o2[2]));
			for(int i = 0; i<N; i++) {
				Arrays.fill(dist[i], Integer.MAX_VALUE);
			}
			dist[0][0] = map[0][0];
			pq.offer(new int[] {0,0,map[0][0]});
			while(!pq.isEmpty()) {
				int[] cur = pq.poll();
				int x = cur[0];
				int y = cur[1];
				int min = cur[2];
				if(visited[x][y]) continue;
				visited[x][y] = true;
				if (x == N-1 && y == N-1) break;
				

				for(int d = 0; d<4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					if(nx<0|| ny<0|| nx>=N || ny>=N || visited[nx][ny]) continue;
					if(dist[nx][ny] > min + map[nx][ny]) {
						dist[nx][ny] = min + map[nx][ny];
						pq.offer(new int[] {nx,ny, min + map[nx][ny]});
					}
				}
			}

			prob++;
			sb.append("Problem ").append(prob).append(": ").append(dist[N-1][N-1]).append("\n");
		}
		System.out.print(sb);
		br.close();
	}

}
