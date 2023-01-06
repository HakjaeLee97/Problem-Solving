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
		
		int[] bag = new int[K+1];
		
		for (int i = 1; i <= N; i++) { 
			for (int j = K; j >= items[i][0]; j--) {
					bag[j] = Math.max(bag[j], items[i][1] + bag[j-items[i][0]] );
				
			}
		}
		System.out.println(bag[K]);
		br.close();
	}

}
