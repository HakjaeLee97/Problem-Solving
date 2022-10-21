import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		//n번째 큰 수
		int[] max = new int[N];
		Arrays.fill(max, -1_000_000_001);
		int size =  N * N;
		int tmp;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				tmp = Integer.parseInt(st.nextToken());
				for(int k = 0; k<N; k++) {
					if(tmp > max[k]) {
						for (int l = N-1; l > k; l--) {
							max[l] = max[l-1];
						}
						max[k] = tmp;
						break;
					}
				}
			}
		}
		System.out.println(max[N-1]);
		br.close();
	}

}
