import java.awt.image.AreaAveragingScaleFilter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Main {
	
	public static class node{
		public node(int i, int j) {
			this.x = i;
			this.y = j;
		}
		int x;
		int y;
	}
	static boolean flag = false;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] map = new int[9][9];
		for(int i = 0; i<9; i++) {
			map[i] = Stream.of(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
		}
		ArrayList<node> lst = new ArrayList<>();
		
		for(int i = 0; i<9;i++) {
			for(int j = 0; j<9; j++) {
				if(map[i][j] == 0) {
					lst.add(new node(i,j));
				}
			}
		}
		int n = lst.size();
		dfs(0,n, map,lst);
		
		

		br.close();
	}
	public static void solve(int x, int y, int[][] map) {
		boolean[] possible = new boolean[10];
		for(int i = 0; i<9; i++) {
			possible[map[x][i]] = true;
			possible[map[i][y]] = true;
		}
		//속해있는 3x3 삼각형
		int sx = x/3;
		int sy = y/3;
		
		for(int i = sx*3; i<3+(sx*3); i++) {
			for(int j=sy*3; j<3+(sy*3); j++) {
				possible[map[i][j]] = true;
			}
		}
		for(int i = 1; i<= 9; i++) {
			if(possible[i] == false) {
				map[x][y] = i;
				break;
			}
		}
		
	}
	public static void dfs(int depth, int n, int[][] map, ArrayList<node> lst ) {
		if(flag) return;
		if(depth == n) {
			StringBuilder sb=  new StringBuilder();
			for(int i = 0; i<9; i++) {
				for(int j = 0; j<9; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
			System.out.print(sb);
			flag = true;
			return;
		}
		node cur = lst.get(depth);
		
		boolean[] possible = new boolean[10];
		for(int i = 0; i<9; i++) {
			possible[map[cur.x][i]] = true;
			possible[map[i][cur.y]] = true;
		}
		//속해있는 3x3 삼각형
		int sx = cur.x/3;
		int sy = cur.y/3;
		
		for(int i = sx*3; i<3+(sx*3); i++) {
			for(int j=sy*3; j<3+(sy*3); j++) {
				possible[map[i][j]] = true;
			}
		}
		for(int i = 1; i<= 9; i++) {
			if(possible[i] == false) {
				map[cur.x][cur.y] = i;
				dfs(depth+1,n,map,lst);
				map[cur.x][cur.y] = 0;
			}
		}
		return;
		
	}

}
