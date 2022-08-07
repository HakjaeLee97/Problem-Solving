package s1225;

import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayDeque<Integer> num = new ArrayDeque<>(); 
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc<=10; tc++) {
			br.readLine();
			int cnt = 1;
			int tmp;
			st = new StringTokenizer(br.readLine());
			for(int i =0; i< 8; i++) {
				num.add(Integer.parseInt(st.nextToken()));
			}
			while (true) {
				tmp = num.removeFirst()-cnt++;
				if(tmp > 0) num.addLast(tmp);
				else {
					tmp = 0;
					num.addLast(tmp);
					break;
				}
				if (cnt == 6) cnt = 1;
				
			}
			sb.append("#").append(tc).append(" ");
			for(int i = 0; i<8; i++) {
				sb.append(num.removeFirst()).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
		
	}

}
