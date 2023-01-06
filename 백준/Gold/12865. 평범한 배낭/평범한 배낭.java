import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args)  throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] items = new int[N+1][2]; // 무게, 가치 순
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			items[i][0] = Integer.parseInt(st.nextToken());
			items[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[][] bag = new int[N+1][K+1];
		
		for (int i = 1; i <= K; i++) { // 무게
			for (int j = 1; j <= N; j++) { //물건
				bag[j][i] = bag[j-1][i];
				if(i >= items[j][0]) {
					bag[j][i] = Math.max(bag[j-1][i], items[j][1] + bag[j-1][i-items[j][0]] );
				} 
			}
		}
		System.out.println(bag[N][K]);
		br.close();
	}

}
