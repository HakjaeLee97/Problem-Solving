import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	
	public static class point{
		int x;
		int y;
		public point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	static int best = Integer.MIN_VALUE;
	static 	ArrayList<point> virus = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		ArrayList<point> lst = new ArrayList<>();
	
		
		//입력받기
		for(int i = 0; i<N; i++) {
			st= new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) {
					lst.add(new point(i,j));
				}else if(map[i][j] == 2) {
					virus.add(new point(i,j));
				}
				
			}
		}
		comb(0,0,N,M,map,lst);
		System.out.println(best);
		br.close();
		
	}
	//벽 3개를 세우는 경우의 수 : 조합
	
	public static void comb(int depth,int start, int N, int M, int[][] map, ArrayList<point> lst) {
		if(depth == 3) {
			int[][] copymap = new int[N][M];
			for(int i = 0; i<N;i++) {
				copymap[i] = Arrays.copyOf(map[i], M);
			}
			spread(copymap,N,M);
			int res = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(copymap[i][j] == 0) {
						res++;
					}
				}
			}
			best = Math.max(best, res);
			return;
		}
		
		
		for(int i = start; i<lst.size(); i++) {
			point cur = lst.get(i);
			map[cur.x][cur.y] = 1;
			comb(depth+1, i+1, N, M, map, lst);
			map[cur.x][cur.y]= 0; 
		}
		
		
	}
	
	public static void spread(int[][] map, int N, int M) {
		Queue<point> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][M];
		
		
		
		for(int i = 0; i<virus.size();i++) {
			point cur = virus.get(i);
			q.offer(cur);
			visited[cur.x][cur.y] = true;
		}
		
		while(!q.isEmpty()) {
			point cur = q.poll();
			map[cur.x][cur.y]= 1; 
			for(int i =0; i<4;i++) {
				
				int nx = cur.x + dx [i];
				int ny = cur.y + dy[i];
				if(nx <0  || nx>= N || ny<0 || ny>= M || visited[nx][ny] || map[nx][ny] != 0) continue;
				q.offer(new point(nx,ny));
				visited[nx][ny] = true;
			}
		}
	}
}
