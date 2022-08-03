import java.io.*;
public class Solution {
	public static void main(String[] args) throws Exception {	
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());	
		for (int tc = 1; tc < T+1 ; tc++) {
			int result = 0;
			Boolean flipped = false;
			String mem = br.readLine();
			for(int i =0; i < mem.length(); i++) {
				if(mem.charAt(i) == '1' && flipped == false) {
					result++;
					flipped = true;
				} else if(mem.charAt(i)== '0' && flipped == true) {
					result++;
					flipped = false;
				}
			}
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
}