import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		int[][][] dp = new int[N][N][3];
		for(int i= 0; i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//dp[a][b] : 가로, 세로, 대각선 (0~2)
		dp[0][1][0] = 1;
		for(int i = 0;i<N;i++) {
			for(int j =0; j<N; j++) {
				if(map[i][j] == 1) continue;
				if(j>=1 && map[i][j-1] != 1) {
					//가로 우측으로 밀기
					dp[i][j][0] += dp[i][j-1][0];
					//대각선 우측으로 밀기
					dp[i][j][0] += dp[i][j-1][2];
				}
				if(i>=1 && map[i-1][j] != 1) {
					//세로 아래로 밀기
					dp[i][j][1] += dp[i-1][j][1];
					//대각선 아래로 밀기
					dp[i][j][1] += dp[i-1][j][2];
				}
				if(i >= 1 && j >= 1 && map[i-1][j-1] != 1 && map[i-1][j] != 1 && map[i][j-1] != 1) {
					//가로 대각선 밀기
					dp[i][j][2] += dp[i-1][j-1][0];
					//세로 대각선 밀기
					dp[i][j][2] += dp[i-1][j-1][1];
					//대각선 대각선 밀기
					dp[i][j][2] += dp[i-1][j-1][2];
				}
			}
		}
		int answer = dp[N-1][N-1][0] + dp[N-1][N-1][1] + dp[N-1][N-1][2];
		System.out.println(answer);
		br.close();
	}

}
