import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		//n번째 집을 r,g,b로 칠하는 데 드는 비용
		int[][] price = new int[N+1][3];//인덱스는 1부터 시작
		
		StringTokenizer st;
		for(int i =1; i <= N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < 3; j++) {				
				price[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//n번재 집을 r,g,b 로 칠하는 최소값
		int[][] dp = new int[N+1][3]; 
		
		dp[1][0] = price[1][0];
		dp[1][1] = price[1][1];
		dp[1][2] = price[1][2];
		
		for(int i = 2; i<=N; i++){
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + price[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + price[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + price[i][2];
		}
		
		System.out.println(Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]));
		br.close();
		
	}

}