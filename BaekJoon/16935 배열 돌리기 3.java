package b16935;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int N,M;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i<R; i++) {
			int input = Integer.parseInt(st.nextToken());
			switch(input) {
				case 1: 
					verticalflip();
					break;
				case 2:
					horiflip();
					break;
				case 3:
					rightrot();
					break;
				case 4:
					leftrot();
					break;
				case 5:
					dofive();
					break;
				case 6:
					dosix();
					break;
			}
		}
		


		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.print(sb);	
		br.close();
	}
	
	public static void verticalflip() {
		for(int i = 0; i< N/2; i++) {
			for(int j=0; j<M; j++) {
				int tmp = arr[N-1-i][j];
				arr[N-1-i][j] = arr[i][j];
				arr[i][j] = tmp;
			}
		}
		
	}
	public static void horiflip() {
		for(int i = 0; i< N; i++) {
			for(int j=0; j<M/2; j++) {
				int tmp = arr[i][j];
				arr[i][j] = arr[i][M-j-1];
				arr[i][M-j-1] = tmp;
			}
		}
		
	}
	public static void rightrot() {
		int[][] tmp = new int[M][N];
		for(int i = 0; i<M; i++) {
			for(int j = 0; j<N; j++) {
				tmp[i][j] = arr[N-1-j][i];
			}
		}
		arr = new int[M][N];
		for(int i =0 ; i< M; i++) {
			arr[i] = Arrays.copyOf(tmp[i],N);
		}
		int tmp_n = N;
		N = M;
		M = tmp_n;
	}
	public static void leftrot() {
		int[][] tmp = new int[M][N];
		for(int i = 0; i<M; i++) {
			for(int j = 0; j<N; j++) {
				tmp[i][j] = arr[j][M-1-i];
			}
		}
		arr = new int[M][N];
		for(int i =0 ; i< M; i++) {
			arr[i] = Arrays.copyOf(tmp[i],N);
		}
		int tmp_n = N;
		N = M;
		M = tmp_n;
	}
	public static void dofive() {
		int[][] tmp = new int[N/2][M/2];
		for(int i =0 ; i< N/2; i++) {
			tmp[i] = Arrays.copyOfRange(arr[i], 0, M/2);
		}
		for(int i = 0; i<N/2; i++) {
			for(int j = 0; j < M/2; j++) {
				arr[i][j] = arr[i+N/2][j];
			}
		}
		for(int i = N/2; i<N; i++) {
			for(int j =0; j<M/2;j++ ) {
				arr[i][j] = arr[i][j+M/2];
			}
		}
		for(int i = N/2; i<N; i++) {
			for(int j =M/2; j<M;j++ ) {
				arr[i][j] = arr[i-N/2][j];
			}
		}		
		
		for(int i = 0; i<N/2; i++) {
			for(int j = M/2; j < M; j++) {
				arr[i][j] = tmp[i][j-M/2];
			}
		}
		
		
		
	}
	public static void dosix() {
		
		int[][] tmp = new int[N/2][M/2];
		for(int i =0 ; i< N/2; i++) {
			tmp[i] = Arrays.copyOfRange(arr[i], 0, M/2);
		}
		for(int i = 0; i<N/2; i++) {
			for(int j = 0; j < M/2; j++) {
				arr[i][j] = arr[i][j+M/2];
			}
		}
		for(int i = 0; i<N/2; i++) {
			for(int j = M/2; j < M; j++) {
				arr[i][j] = arr[i+N/2][j];
			}
		}
		for(int i = N/2; i<N; i++) {
			for(int j =M/2; j<M;j++ ) {
				arr[i][j] = arr[i][j-M/2];
			}
		}		
		for(int i = N/2; i<N; i++) {
			for(int j =0; j<M/2;j++ ) {
				arr[i][j] = tmp[i-N/2][j];
			}
		}
		
		
		
		
		
	}
	
}