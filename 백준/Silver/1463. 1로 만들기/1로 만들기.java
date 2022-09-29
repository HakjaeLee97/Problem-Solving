import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1]; // 인덱스 1부터 시작
		dp[1] = 0;
		for(int i = 2; i<=N; i++) {
			int min = dp[i-1]+1;
			if(i%3 == 0) min = Math.min(min, dp[i/3]+1);
			if(i%2 == 0) min = Math.min(min, dp[i/2]+1);
			dp[i] = min;
		}
		System.out.println(dp[N]);
		br.close();
	}

}