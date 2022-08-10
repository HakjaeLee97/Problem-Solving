package b17406;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
		static int N,M,K;
		static int[][] arr;
		static int[][] rot;
		static int best;


		
		
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
				
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		best = Integer.MAX_VALUE;
		
		
		arr = new int[N][M];
		rot = new int[K][3];

		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());				
			}
		}
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				rot[i][j] = Integer.parseInt(st.nextToken());				
			}
		}
		
		perm(0);
		System.out.println(best);
				
	}
	public static void perm(int depth) {
		if(depth == K) {
			int result = rotate_sum();
			if(result < best) best = result;
			return;
		}
		for(int i = depth; i< K; i++) {
			int[] tmp = rot[depth];
			rot[depth] = rot[i];
			rot[i] = tmp;
			perm(depth+1);
			tmp = rot[depth];
			rot[depth] = rot[i];
			rot[i] = tmp;					
		}			
	}
	public static int rotate_sum() {
		int[][] arr_rot=  new int[N][M];
		for(int i = 0; i<N;i++) {
			System.arraycopy(arr[i], 0, arr_rot[i], 0, M);
		}
		
		for(int a = 0; a < K; a++) {
			int r = rot[a][0];
			int c = rot[a][1];
			int s = rot[a][2];	
			for(int depth = 0; depth < s ; depth++) {
				
				int tmp = arr_rot[r-s-1+depth][c+s-1-depth]; // 저장용 
				for (int i = c+s-1-depth; i >c-s-1+depth ; i--) { // 위 방향 회전
					arr_rot[r-s-1+depth][i] = arr_rot[r-s-1+depth][i-1];
				}
	
				for (int i = r-s-1+depth; i <r+s-1 -depth; i++) { // 왼쪽 회전
					arr_rot[i][c-s-1+depth] = arr_rot[i+1][c-s-1+depth];
				}
				
				for (int i = c-s-1+depth; i <c+s-1-depth ; i++) { // 아래 방향 회전
					arr_rot[r+s-1-depth][i] = arr_rot[r+s-1-depth][i+1];
				}
				
				for (int i = r+s-1-depth; i >r-s+depth ; i--) { // 오른쪽 회전
					arr_rot[i][c+s-1-depth] = arr_rot[i-1][c+s-1-depth];
				}
				arr_rot[r-s+depth][c+s-1-depth] = tmp;
	
			}
		}
		int rowsum = Integer.MAX_VALUE;
		for(int i = 0 ; i<N; i++) {
			rowsum = Math.min(Arrays.stream(arr_rot[i]).sum(),rowsum);
		}
		return rowsum;
	}
}
