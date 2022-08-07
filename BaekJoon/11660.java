package b11660;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][N];
		int result;
		
		st = new StringTokenizer(br.readLine());
		
		arr[0][0] = Integer.parseInt(st.nextToken());
		for(int i = 1; i <N; i++) {
			arr[0][i] = Integer.parseInt(st.nextToken()) + arr[0][i-1];
		} // row 0 입력받기
		
		for(int i =1; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken()) + arr[i-1][0];//col 0 입력받기
			
			for(int j = 1; j <N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken()) + arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1];
			}
		}
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken())-1;
			int y1 = Integer.parseInt(st.nextToken())-1;
			int x2 = Integer.parseInt(st.nextToken())-1;
			int y2 = Integer.parseInt(st.nextToken())-1;
			result = arr[x2][y2];
			if(x1 > 0) {
				result -= arr[x1-1][y2] ;
			}
			if(y1 > 0) {
				result -= arr[x2][y1-1];
			}
			if(x1> 0 && y1 > 0) {
				result +=  arr[x1-1][y1-1];
			}

			sb.append(result).append("\n");
		}
		System.out.print(sb);
		
	}

}
