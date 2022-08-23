package b1759;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int L,C;
	static String[] comb, input;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		input = br.readLine().split(" ");
		comb = new String[L];
		Arrays.sort(input);
		combination(0,0,0);
		

	}
	public static void combination(int depth, int start, int cnt) {
		if(depth == L) {
			if(cnt > 0 && cnt<=L-2) { //모음이 1개 이상,  자음이 2개 이상
				for(String s : comb)System.out.print(s);
				System.out.println();
			}
			return;
		}
		for(int i = start; i<C; i++) {
			comb[depth] = input[i];
			if(input[i].equals("a") || input[i].equals("e")||input[i].equals("i")||input[i].equals("o")||input[i].equals("u") ) {
				combination(depth+1,i+1,cnt+1);
			}else {
				combination(depth+1,i+1,cnt);				
			}
		}
	}

}
