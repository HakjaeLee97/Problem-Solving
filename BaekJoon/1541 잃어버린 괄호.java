package b1541;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(),"-+",true);
		String eq[] = new String[50];
		int index = 0;
		while(st.hasMoreTokens()) {
			eq[index++] = st.nextToken();
		}
		
		
		int result = 0;
		
		int tmp = 0;
		boolean flag = false;
		for(int i =0; i<index; i++) {
			if(eq[i].equals("+")) {
				continue;
			}else if(eq[i].equals("-")) {
				if(flag == false) flag = true;
				else {
					result -= tmp;
					tmp = 0;
				}
			}else {
				if(flag)tmp += Integer.parseInt(eq[i]);
				else result+= Integer.parseInt(eq[i]);
			}
		}
		result -= tmp;
		System.out.println(result);
		br.close();
	}

}
