package b3109;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {-1,0,1};
	static int dy = 1; 
	static int R,C,cnt, best;
	static boolean check;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[R][C];
		boolean[][] visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i = 0; i<R; i++) {
			check = false;
			dfs(i,0,map,visited);
		}
		System.out.println(cnt);
		br.close();
	}
	public static void dfs(int x, int y,char[][]map,boolean[][] visited) {
		if(y == C-1) {
			cnt++;
			check = true;
			return;
		}

		visited[x][y] = true;
		
			for(int j = 0; j<3; j++) {
				int nx = x + dx[j];
				int ny = y +dy;
				if(nx<0||ny<0||nx>=R||ny>=C||map[nx][ny]=='x'||visited[nx][ny]) continue;
				dfs(nx,ny,map,visited);
				if(check) return;
			}
	}

}
