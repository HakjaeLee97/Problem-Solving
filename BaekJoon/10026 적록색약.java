package b10026;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static boolean[][] visited1, visited2;
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		char[][] map = new char[N][N];
		visited1 = new boolean[N][N];
		visited2 = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		int ans1=0, ans2 = 0;
		
		for (int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(visited1[i][j] == false) {
					dfs1(map,i,j,map[i][j]); //적록 색약이 아닌 사람
					ans1++;
				}if(visited2[i][j] == false) {
					dfs2(map,i,j,map[i][j]); //적록 색약인사람
					ans2++;
				}
			}
		}
		
		System.out.print(ans1 + " " + ans2);
		
	}
	public static void dfs1(char[][] map, int x, int y, char check) {
		visited1[x][y] = true;
		for(int i =0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx<0 || nx>= N || ny < 0 || ny>=N || visited1[nx][ny] ||map[nx][ny] != check ) continue; 
			dfs1(map,nx,ny,check);
			
		}	
	}
	public static void dfs2(char[][] map, int x, int y, char check) {
		visited2[x][y] = true;

		for(int i =0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(check != 'B') { //적이나 록일때
				if(nx<0 || nx>= N || ny < 0 || ny>=N || visited2[nx][ny] ||map[nx][ny] == 'B' ) continue;
				dfs2(map,nx,ny,check);
				
			}else {
				if(nx<0 || nx>= N || ny < 0 || ny>=N || visited2[nx][ny] ||map[nx][ny] != check ) continue;
				dfs2(map,nx,ny,check);
				
			}
		}
		
	}

}
