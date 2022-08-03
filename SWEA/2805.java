import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc =1; tc<T+1; tc++) {
			int N = Integer.parseInt(br.readLine());
			//int[][] farm = new int[N][N];
			int sum = 0;
			for(int i = 0; i< N; i++) {
				String[] tmp = br.readLine().split("");
				//StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					if( ( N- (Math.abs(i - (N/2) )*2) )/2 >= Math.abs(j - (N/2))) {
						sum+= Integer.parseInt(tmp[j]);
					}
					//farm[i][j] = Integer.parseInt(st.nextToken());
				}
			} // 입력받기
			sb.append("#").append(tc).append(" ").append(sum).append("\n");
			//N/2 + 1 - 1= 2
			
					
		}
		System.out.print(sb);
	}

}
