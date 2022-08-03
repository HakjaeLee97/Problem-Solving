import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc  =0; tc<T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] snail = new int[N][N];
			
			int cnt = 1;
			int depth = 0;
			int end = N * N;
			while ( cnt <= end) {
				for (int i = 0+depth; i<N-depth; i++) {
					snail[0+depth][i] = cnt++;
				}
				if (cnt > end) break;
				for (int i = 1+depth; i<N-depth; i++) {
					snail[i][N-1-depth] =  cnt++;
				}
				if (cnt > end) break;
				for (int i = 1+depth; i<N-depth; i++) {
					snail[N-1-depth][N-1-i] = cnt++;
				}
				if (cnt > end) break;
				for(int i = 1+depth; i<N-1-depth; i++) {
					snail[N-i-1][0+depth] = cnt++;
				} // 한바퀴
				if (cnt > end) break;
				depth++;
				
			}
			System.out.println("#"+(tc+1));
			for (int i =0; i<N; i++) {
				for (int j = 0; j <N; j++) {
					System.out.print(snail[i][j]+" ");
				}
				System.out.println();
			}
			
		}
		
	}

}
