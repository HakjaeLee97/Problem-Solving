package b14501;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =Integer.parseInt(br.readLine());
		int[][] counsel = new int[N][2];
		for(int i= 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			counsel[i][0] =Integer.parseInt(st.nextToken());
			counsel[i][1] =Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[N];
		
		for(int i = 0; i<N; i++) {
			for(int j = i; j>=0; j--) {
				if(counsel[j][0] <= i-j+1) {
					if(j == 0 ) {
						if(counsel[j][1] > dp[i]) {
							dp[i] = counsel[j][1];
						}
					}
					else if(dp[j-1] + counsel[j][1] > dp[i]) {
						dp[i] = dp[j-1] + counsel[j][1];
					}
				}
			}
		}
		System.out.println(dp[N-1]);
		br.close();
	}
}
