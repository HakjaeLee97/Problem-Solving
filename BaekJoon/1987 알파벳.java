package b1987;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int best,R,C;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0}; 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		char[][] board = new char[R][C];
		
		for(int i= 0; i<R;i++) {
			board[i] = br.readLine().toCharArray();
		}
		boolean[] visited = new boolean[26];
		solve(0,0,0, board,visited);
		System.out.println(best);
		br.close();
	}
	public static void solve(int x, int y, int count, char[][] board, boolean[] visited) {
		//pruning
//		if(visited[board[x][y] -'A']) return;
//		boolean[] newv = Arrays.copyOf(visited, 26); 
		visited[board[x][y]-'A'] = true;
		//칸을 지난 수 갱신 후 best 갱신
		best = Math.max(++count, best);
		
		for(int i = 0; i<4; i++) {
			int nx = x +dx[i];
			int ny = y +dy[i];
			if(nx<0 || ny<0 || nx>=R || ny>= C ||visited[board[nx][ny] -'A']) continue;
			solve(nx,ny,count,board,visited);
			
		}
		visited[board[x][y]-'A'] = false;
		
	}

}
