import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int best = Integer.MAX_VALUE;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static boolean flag = false;
	static int[][] g;
	static int INF = 10000000;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int[][] island = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		int index = 1; // 섬의 개수
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//전체 dfs를 돌려서 각 섬마다 숫자를 붙인다.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(island[i][j] == 0 && map[i][j] == 1) {
					dfs(i,j,map,island,visited,index++,N,M);
				}
			}
		}
		
		flag = true; //섬에 이름이 다 지어졌는지 체크하는 플래그
		g = new int[index-1][index-1]; // 인접 행렬 생성
		//인접 행렬 초기화
		for (int i = 0; i < index-1; i++) {
			for (int j = 0; j < index-1; j++) {
				if(i != j) {
					g[i][j] = INF;
				}
			}
		}
		
		//전체 dfs를 돌려서 각 섬에서 다른 섬으로 가는 인접행렬을 구한다.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 1 && visited[i][j] == false) {
					dfs(i,j,map,island,visited,index,N,M);
				}
			}
		}
		//prim 방문횟수 관리용
		boolean[] v = new boolean[index-1];
		int[] minEdge = new int[index-1];
		for (int i = 1; i < index-1; i++) {
			minEdge[i] = INF;
		}
		int result = 0;
		int cnt = 0;
		
		for (int i = 0; i < index-1; i++) {
			int min = INF;
			int minVertex = -1;
			for (int j = 0; j < index-1; j++) {
				if(!v[j]  && min>minEdge[j]) {
					min = minEdge[j];
					minVertex = j;
				}
			}
			if(minVertex == -1) {
				result = -1;
				break;
			}
			v[minVertex] = true;
			
			result += min;
			if(cnt++ == index-1) break;
			for (int j = 0; j < index-1; j++) {
				if(!v[j] && g[minVertex][j] !=0 && minEdge[j] > g[minVertex][j]) {
					minEdge[j] = g[minVertex][j];
				}
			}
		}
		
//		if(best == INF) best = -1;
		System.out.println(result);
		br.close();
		
		
	}
	public static void dfs(int x, int y, int[][] map, int[][] island,boolean[][] visited, int index, int N, int M) {
		if(flag == false) {
			//섬에 이름 짓기
			island[x][y] =index;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx < 0 || nx>= N || ny<0 || ny>=M || island[nx][ny] != 0 || map[nx][ny] == 0) continue;
				dfs(nx,ny,map,island,visited,index,N,M);
			}
		}else {
			//다른섬과의 거리 구하기
			visited[x][y] = true;
			for (int i = 0; i < 4; i++) {
				int dist = 1;
				while(true) {
					int nx = x + dx[i] * dist;
					int ny = y + dy[i] * dist;
					//맵 밖으로 나가면 포기 
					if(nx < 0 || nx>= N || ny<0 || ny>=M || island[nx][ny] == island[x][y]) break;
					//나와 다른 섬을 만남
					if(island[nx][ny] != 0) {
						//다리 길이 조건 체크
						if(dist >= 3) {
							//인접행렬 최신화
							int mindist = Math.min(g[island[x][y]-1][island[nx][ny]-1], dist-1);
							g[island[x][y]-1][island[nx][ny]-1] = mindist;
							g[island[nx][ny]-1][island[x][y]-1] = mindist;
						}
						break;
					}
					dist++;
				}
			}
		}
	}
}
