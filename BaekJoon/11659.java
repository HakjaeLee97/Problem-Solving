package b11659;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] num = new int[N];
		st = new StringTokenizer(br.readLine());
		int tmp = 0;
		for(int i =0; i<N;i++) {
			tmp += Integer.parseInt(st.nextToken());
			num[i] = tmp;
		}

		int start = 0;
		int end = 0;

		for(int i = 0; i<M; i++){

			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken())-2;
			end = Integer.parseInt(st.nextToken()) -1;
			if (start < 0) {
				sb.append(num[end]).append("\n");
			}else {
				sb.append(num[end] - num[start]).append("\n");
			}
		}
		System.out.println(sb);
		br.close();
	}

}
