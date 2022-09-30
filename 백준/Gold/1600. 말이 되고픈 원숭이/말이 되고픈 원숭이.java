import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {0, 1,0,-1};
	static int[] dy = {-1,0,1,0};
	
	static int[] dx2 = {-1,-2, 1, 2,1,2,-1,-2};
	static int[] dy2 = {-2,-1,-2,-1,2,1,2 ,1};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[H][W];
		int best = Integer.MAX_VALUE;
		//남은 말처럼 이동횟수 저장하는 visited
		int[][][] visited = new int[H][W][K+1];
		
		for(int i = 0; i<H;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j= 0; j<W;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {0,0,K,0});
		visited[0][0][K] = 1;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			if(now[0] == H-1 && now[1] == W-1) {
				best = Math.min(best, now[3]);
			}
			if(now[2] > 0) {	
				for(int i = 0; i<8; i++) {
					int nx = now[0] + dx2[i];
					int ny = now[1] + dy2[i];
					if(nx< 0 || nx>= H || ny<0 || ny>= W) continue;
					if( visited[nx][ny][now[2]-1] !=0  || map[nx][ny] == 1) continue;
					q.offer(new int[] {nx,ny,now[2]-1,now[3]+1});
					visited[nx][ny][now[2]-1] = 1;
				}
			}
			for(int i = 0; i<4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				if(nx< 0 || nx>= H || ny<0 || ny>= W) continue;
				if(visited[nx][ny][now[2]] != 0 || map[nx][ny] == 1) continue;
				q.offer(new int[] {nx,ny,now[2],now[3]+1});
				visited[nx][ny][now[2]] = 1;
			}
		}
		if(best == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(best);
		}
		br.close();
		
	}

}
