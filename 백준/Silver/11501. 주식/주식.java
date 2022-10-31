import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		int N;
		int[] stock;
		int max;
		long profit;

		//주가를 뒤에서부터 확인하면서 그리디 전략 사용
		//오늘이 최대값이면 갱신
		
		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			max  = 0;
			profit = 0;
			stock  = new int[N];
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				stock[j]= Integer.parseInt(st.nextToken());
			}
			for (int j = N-1; j >= 0; j--) {
				if(stock[j] > max) {
					max = stock[j];
				}else {
					profit += max-stock[j];
				}
			}
			bw.write(Long.toString(profit));
			bw.write("\n");
		}
		bw.flush();
		br.close();
	}
}
