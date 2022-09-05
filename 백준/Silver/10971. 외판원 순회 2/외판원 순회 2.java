import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int best = 	Integer.MAX_VALUE;
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		
		for(int i = 0; i< N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean[] visited = new boolean[N];
		visited[0] = true;
		dfs(arr,0,0,visited,0);
			
		System.out.println(best);
		br.close();
		
	}
	public static void dfs(int[][] arr, int depth,int dist, boolean[] visited, int now) {
		if(dist > best) return;
		if(depth == N-1) {
			if(arr[now][0] > 0) {
				best = Math.min(best, dist+arr[now][0]);
			}
			return;
		}
		for(int i = 0; i<N; i++) {
			if(visited[i] || arr[now][i] == 0) continue;
			visited[i] = true;
			dfs(arr,depth+1,dist+arr[now][i],visited,i);
			visited[i] = false;
		}
	}

}
