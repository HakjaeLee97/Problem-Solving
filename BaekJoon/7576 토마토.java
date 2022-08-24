package b7576;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] visited;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int M,N;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		M =Integer.parseInt(st.nextToken());
		N =Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		visited = new boolean[N][M];
		int ripecnt = 0; //앞으로 익어야 할 토마토의 개수
		
		for(int i = 0; i<N;i ++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j =0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == -1) visited[i][j] = true;
				if(arr[i][j] == 0) ripecnt++;
			}
		}
		System.out.println(bfs(arr,ripecnt));

		
		
	}
	public static int bfs(int[][] arr,int ripecnt) {
		int day = 0;
		
		Queue<int[]> q = new LinkedList<int[]>();
		for(int i = 0; i<N;i ++) {
			for(int j =0; j<M; j++) {
				if(arr[i][j] == 1) {
					q.offer(new int[] {i,j,0});	
					visited[i][j] = true;
				}
			}
		}
		
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			day = Math.max(day, cur[2]);
			for(int i =0; i<4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if(nx < 0 || nx >= N || ny <0 || ny >= M || visited[nx][ny] || arr[nx][ny] == 1) continue;
				visited[nx][ny] = true;
				q.offer(new int[] {nx,ny, cur[2]+1});
				ripecnt--;
			}
			
		}
		if(ripecnt == 0) return day;
		else return -1;
		
	}

}
