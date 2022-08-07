package b12891;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=  new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		String str = br.readLine();
		st = new StringTokenizer(br.readLine());
		int[] cond= new int[4];
		for(int i =0; i<4; i++) {
			cond[i] = Integer.parseInt(st.nextToken());
		}
		int result = 0;
		boolean firststring = true;
		for(int j = 0; j < P; j++) {
			if(str.charAt(j) =='A') {
				cond[0] -= 1;
			}else if(str.charAt(j) =='C') {
				cond[1] -= 1;
			}else if(str.charAt(j) =='G') {
				cond[2] -= 1;
			}else if(str.charAt(j) =='T') {
				cond[3] -= 1;
			}
		}
		for(int n : cond) {
			if (n>0) firststring = false;
		}
		if(firststring) result++;
		
		substring : for(int i = 1; i<=S-P; i++) {
			if(str.charAt(i-1) =='A') {
				cond[0] += 1;
			}else if(str.charAt(i-1) =='C') {
				cond[1] += 1;
			}else if(str.charAt(i-1) =='G') {
				cond[2] += 1;
			}else{
				cond[3] += 1;
			}
			if(str.charAt(i+P-1) =='A') {
				cond[0] -= 1;
			}else if(str.charAt(i+P-1) =='C') {
				cond[1] -= 1;
			}else if(str.charAt(i+P-1) =='G') {
				cond[2] -= 1;
			}else {
				cond[3] -= 1;
			}
						
			for(int n : cond) {
				if (n>0) continue substring;
			}
			result++;
		}
		System.out.println(result);
	
				
	}

}
