package b2493;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		int num = Integer.parseInt(br.readLine());
		
		Stack<int[]> top = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i=0; i<num; i++) {
			int n = Integer.parseInt(st.nextToken());
			
			while(!top.isEmpty()) {
				if(top.peek()[0] < n) 
					top.pop();
				else { 
					sb.append(top.peek()[1]).append(" ");
					break;
				}
			}
			
			if(top.empty()) //탑이 비었다면 0을 출력한다.
				sb.append("0 ");
			top.push(new int[] {n, i+1}); //탑의 높이와 탑의 번호 배열을 저장
		}
		System.out.print(sb);
			
	}

}
