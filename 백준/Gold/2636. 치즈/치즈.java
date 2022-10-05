import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[][] map = new int[H][W];
		//치즈의 칸 개수
		int count = 0;
		
		for(int i = 0; i<H;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) count++;
			}
		}
		int time = 0;
		Queue<int[]> q = new ArrayDeque<int[]>();
		Queue<int[]> to_melt = new ArrayDeque<>();
		boolean[][] visited = new boolean[H][W];
		
		while(count>0) {
			//이번 단계에 녹은 개수
			int melted = 0;
			for (int i = 0; i < H; i++) {
				Arrays.fill(visited[i], false);
			}
			
			q.offer(new int[] {0,0});
			visited[0][0] = true;
			
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				for (int d = 0; d < 4; d++) {
					int nx = cur[0] + dx[d];
					int ny = cur[1] + dy[d];
					if(nx<0||nx >= H || ny <0 || ny>= W || visited[nx][ny]) continue;

					if(map[nx][ny] == 0) {
						q.offer(new int[] {nx,ny});
					}else {
						to_melt.offer(new int[] {nx,ny});
					}
					visited[nx][ny] = true;
				}
			}
			
			while(!to_melt.isEmpty()) {
				int[] cur = to_melt.poll();
				melted++;
				map[cur[0]][cur[1]] = 0;
			}
			
			
			time++;
			if(melted == count) {
				break;
			}else {
				count -= melted;
			}
		}
		System.out.println(time);
		System.out.println(count);
	}

}
