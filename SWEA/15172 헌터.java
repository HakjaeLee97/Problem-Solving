import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static int M,best;
	static int[] seq;
	static boolean[] visited;
	static ArrayList<int[]> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int  tc = 1; tc<=T; tc++) {

			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N+1][N+1];
			list = new ArrayList<>();
			
			for(int i = 1; i<= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for(int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] != 0) {
						list.add(new int[] {i,j,map[i][j]}); 
					}
				}
			}
			M = list.size();
			best = Integer.MAX_VALUE;
			visited = new boolean[M];
			seq = new int[M];
			boolean[] check = new boolean[M+1];
			perm(0,check);
			sb.append("#").append(tc).append(" ").append(best).append("\n");
		}
		System.out.print(sb);
		br.close();
		
		
	}
	public static void perm(int depth,boolean[] check) {
		//같은 숫자에 대해 몬스터(양수)가 먼저 나와야 함
		for(int i = 0; i<depth; i++) {
			if(seq[i] < 0) {				
				if(check[Math.abs(seq[i])] == false) {
					return;
				}
			}else {
				check[seq[i]] = true;//몬스터가 나왔는지 체크		
			}
		}
		if(depth == M) {
			int result = 0;
			int x = 1, y = 1;
			for(int i = 0; i<M; i++) {
				int[] cur = list.get(find(seq[i]));
				result += getdist(x, y, cur[0], cur[1]);
				x = cur[0]; y = cur[1];
			}
			best = Math.min(best, result);
		}
		for(int i = 0; i< M; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			seq[depth] = list.get(i)[2];
			perm(depth+1,check);
			visited[i] = false;
			check[Math.abs(seq[depth])] = false;
		}
	}
	
	public static int getdist(int x1, int y1, int x2, int y2) {
		return(Math.abs(x1-x2) + Math.abs(y1-y2));
	}
	public static int find(int num) {
		//hashmap을 사용하면 더 빠를까?
		for(int i = 0; i<M; i++) {
			int[] cur = list.get(i);
			if(cur[2] == num ) return i;
		}
		return -1;
	}
}
