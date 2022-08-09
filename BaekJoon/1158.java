package b1158;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int cnt = N;
		int idx = K - 1;
		
		sb.append("<");
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 1 ; i <=N; i++) {
			list.add(i);
		}
		
		while(cnt > 1) {
			sb.append(list.remove(idx--)).append(", ");
			idx = (idx + K) % --cnt;
		}
		sb.append(list.remove(idx));
		sb.append(">");
		System.out.print(sb);
	}

}

// 1 2 3 4 5 6 7
// 1 2 4 5 6 7 , 2
// 1 2 4 5 7, 4
// 1 4 5 7, 6 % 5
// 1 4 5
// 1 4
// 4
