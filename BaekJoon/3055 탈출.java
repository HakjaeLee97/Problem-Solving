package b3055;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int R,C;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	static class water{
		int x;
		int y;
		water(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static Queue<water> waters;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[R][C];
		int x= -1, y = -1; //고슴도치의 위치
		waters = new LinkedList<>();
		
		for(int i =0; i<R; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j =0; j<C;j++) {
				if(map[i][j] == 'S') {
					x = i;
					y = j;
				}else if(map[i][j] == '*') {
					waters.offer(new water(i,j));
				}
			}
		}
		int ans = bfs(map,x,y);
		if( ans != -1) System.out.print(ans);
		else System.out.print("KAKTUS");
		br.close();
		
		
		
	}
	public static void water(char[][] map, boolean[][] v) { //물이 차게 함
		for(int i = 0, size = waters.size(); i<size; i++) {
			water w = waters.poll();
			for(int d =0; d<4; d++) {
				int nx = w.x + dx[d];
				int ny = w.y + dy[d];
				if(nx<0 || nx >=R || ny <0 || ny>= C ||map[nx][ny] != '.'|| v[nx][ny]) continue;
				map[nx][ny] = '*'; 
				waters.offer(new water(nx,ny));
			}
		}
	}
	public static int bfs(char[][] map, int x, int y) {
		boolean[][] v = new boolean[R][C];
		Queue<int[]> q = new LinkedList<>();
		v[x][y] = true;
		q.offer(new int[] {x,y,0});
		
		int nowtime = 0;
		water(map,v);
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			if(cur[2] > nowtime) {
				water(map,v); // 고슴도치가 움직이기 전에 물이 퍼짐
				nowtime = cur[2];
			}
			for(int i =0; i<4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if(nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == '*' || map[nx][ny] == 'X' || v[nx][ny]) continue;
				if(map[nx][ny] == 'D') {
					return ++nowtime;
				}
				q.offer(new int[] {nx,ny,nowtime+1});
				v[nx][ny] = true;
			}
		}
		return -1;
	}
}
