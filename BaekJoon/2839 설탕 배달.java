package b2839;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		
		//방법 1 수학적
/*		int remainder =  N %5;
		switch(remainder) { 
		case 0:
			count = N/5;
			break;
		case 1:
			count = N/5 +1;
			break;
		case 2:
			if(N == 7) count = -1;
			else count = (N-12)/5 +4;
			break;		
		case 3:
			count = N/5 +1;
			break;
		case 4:
			if(N ==4) count = -1;
			else count= (N-9)/5 + 3;
			break;
		}*/
		
		//방법 2 그리디
		while(N>0) {
			if(N % 5 == 0) {
				count += N/5;
				break;
			}
			else {
				N -= 3;
				count++;
			}
			if(N <= -1) count = -1;
		}
		
		System.out.println(count);		
		br.close();
	}
}
