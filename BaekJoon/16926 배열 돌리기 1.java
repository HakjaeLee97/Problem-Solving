package b16926;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i <R; i++) rotate(arr,N,M);

		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.print(sb);	
		br.close();
	}
	
	public static void rotate(int[][] arr,int N, int M) {
		
		for(int depth = 0; depth < Math.min(N, M)/2 ; depth++) {
			
			int tmp = arr[depth][depth]; // 저장용 
			
			for (int i = depth; i <M-depth-1 ; i++) { // 위 방향 회전
				arr[depth][i] = arr[depth][i+1];
			}

			for (int i = depth; i <N-depth-1; i++) { // 오른쪽 회전
				arr[i][M-1-depth] = arr[i+1][M-1-depth];
			}
			
			for (int i = M-1-depth; i >depth ; i--) { // 아래 방향 회전
				arr[N-1-depth][i] = arr[N-1-depth][i-1];
			}
			
			for (int i = N-1-depth; i >depth+1; i--) { // 왼쪽 회전
				arr[i][depth] = arr[i-1][depth];
			}

			arr[depth+1][depth] = tmp;
		}
	}
}
