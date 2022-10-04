import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int res,best;
	static boolean[] affected;
	static Queue<Integer> q = new ArrayDeque<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int N  = Integer.parseInt(st.nextToken());
			int W  = Integer.parseInt(st.nextToken());
			int H  = Integer.parseInt(st.nextToken());
			int[][] map = new int[H][W];
			res = 0;
			best = Integer.MAX_VALUE;
			affected = new boolean[W];
			for(int i = 0; i<H;i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j = 0 ;j<W;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] != 0)	res ++;
				}
			}
			//W는 최대 12이므로, 완탐 + 백트래킹
			dfs(0,map,N,W,H);
			sb.append("#").append(tc).append(" ").append(best).append("\n");
			
		}
		System.out.print(sb);
		br.close();
	}
	public static void dfs(int depth, int[][] map,int N, int W, int H) {
		if(depth == N) {
			best = Math.min(best, res);
			return;
		}
		for(int j = 0; j<W; j++) {
			for(int i = 0; i<H;i++) {
				if(map[i][j] != 0) { //제일 먼저 만나는 벽돌
					
					int[][] temp = new int[H][W]; //배열 복사
					for(int s=0; s<H;s++) {
						temp[s] = Arrays.copyOf(map[s], W);
					}
					int res_save = res;
					Arrays.fill(affected, false);
					dest(i,j,temp,W,H); //벽돌 파괴 처리
					clear(temp,W,H); // 벽돌 떨어짐 처리
					dfs(depth+1,temp,N,W,H);
					
					res = res_save;
	
					break;
				}
			}
		}
		best = Math.min(best, res);
		
	}
	//벽돌이 파괴되는 처리
	public static void dest(int i, int j, int[][] map,int W, int H) {
		int tmp = map[i][j];
		
		res--;
		map[i][j] = 0;
		affected[j] = true;

		for(int s = 1; s<tmp; s++) {
			for(int d = 0; d<4; d++) {
				int nx = i + dx[d]*s;
				int ny = j + dy[d]*s;
				if(nx < 0 || nx >= H || ny < 0 || ny >= W || map[nx][ny] == 0) continue;
				if(map[nx][ny] == 1) {
					res--;
					affected[ny] = true;
					map[nx][ny]= 0;
				}else {
					dest(nx,ny,map,W,H);
				}
					
			}
		}
		
	}
	//빈자리 벽돌이 떨어지는 처리
	public static void clear(int[][] map,int W, int H) {		
		for(int j = 0; j<W; j++) {
			if(affected[j] == false) continue;
			for(int i= H-1; i>=0; i--) {
				if(map[i][j] != 0) {
					q.offer(map[i][j]);
					map[i][j] = 0;
				}
			}
			int idx = H-1;
			while(!q.isEmpty()) {
				map[idx][j] = q.poll();
				idx--;
			}
		}
	}
}
