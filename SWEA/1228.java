package s1228;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int tc =1; tc<=10; tc++) {
			int N = Integer.parseInt(br.readLine());
			ArrayList<Integer> nums = new  ArrayList<Integer>(N);
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i<N; i++) {
				nums.add(Integer.parseInt(st.nextToken()));
			}
			int I = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < I; i++) {
				st.nextToken();
				int index = Integer.parseInt(st.nextToken());
				int adding = Integer.parseInt(st.nextToken());
				for(int j = 0; j< adding; j++) {
					nums.add(index++, Integer.parseInt(st.nextToken()));
				}
			}
			sb.append("#").append(tc).append(" ");
			for(int i = 0; i<10; i++ ) {
				sb.append(nums.get(i)).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

}
