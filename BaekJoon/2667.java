package b2667;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			String[] tmp = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(tmp[j]);
			}			
		}
		ArrayList<Integer> list = new ArrayList<>();//각 단지별 집의 수를 저장하는 배열
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 1 && visited[i][j] == false) {
					list.add(dfs(i,j,map,visited,N,0));
				}
			}			
		}
		Collections.sort(list);
		System.out.println(list.size());
		for(int i = 0; i< list.size(); i++) {
			System.out.println(list.get(i));		
		}
		
	}
	
	public static int dfs(int x, int y, int[][] map, boolean[][] visited, int N, int count) {
		visited[x][y] = true;
		count++;
		for(int i =0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx< 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny] == true || map[nx][ny] == 0) continue;
			count = dfs(nx,ny,map,visited,N, count);
		}
		
		
		return count;
	}

}
