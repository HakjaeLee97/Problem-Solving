import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	

	public static class node{
		int x;
		int y;
		int move;
		String key;
		int keynum;
		public node(int x, int y,int move, String key) {
			super();
			this.x = x;
			this.y = y;
			this.move = move;
			this.key = key;
			this.keynum = Integer.parseInt(key, 2);
		}
		
	}
	
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[N][M];
		boolean[][][] visited= new boolean[N][M][64];
		String key = "000000";
		int keynum = Integer.parseInt(key, 2);
		int answer = -1;
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int start_x = 0;
		int start_y = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == '0') {
					start_x = i;
					start_y = j;
					break;
				}
			}
		}
		
		Queue<node> q = new ArrayDeque<>();
		q.offer(new node(start_x,start_y,0,"000000"));
		visited[start_x][start_y][keynum] = true;
		
		while(!q.isEmpty()) {
			node cur = q.poll();
			for(int i = 0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if(nx<0 || nx>=N || ny<0 || ny>= M || visited[nx][ny][cur.keynum] || map[nx][ny] =='#') continue;
				if(map[nx][ny] == '.' || map[nx][ny] == '0') {
					q.offer(new node(nx,ny,cur.move+1,cur.key));
					visited[nx][ny][cur.keynum] = true;
				}
				//열쇠를 줍는 경우
				else if(map[nx][ny] >='a' && map[nx][ny] <= 'f') {
					keynum = cur.keynum |  1 << (5-(map[nx][ny]-'a'));
					key = Integer.toBinaryString(keynum);
					q.offer(new node(nx,ny,cur.move+1,key));
					visited[nx][ny][keynum] = true;
				}
				//문을 만나는 경우
				else if(map[nx][ny] >='A' && map[nx][ny] <= 'F') {
					keynum = cur.keynum &  1 << (5-(map[nx][ny]-'A'));
					if(keynum >= 1) {
						q.offer(new node(nx,ny,cur.move+1,cur.key));
						visited[nx][ny][cur.keynum] = true;
					}
				}
				//출구를 만나는 경우
				else {
					answer = cur.move+1;
					q.clear();
					break;
				}
			}
		}
		System.out.println(answer);
		br.close();
		
	}

}
