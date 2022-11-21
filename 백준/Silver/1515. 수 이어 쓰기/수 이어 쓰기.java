import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args)  throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		int num = 1;
		String cmp = "1";
		boolean flag = false;
		while(true) {
			for(int i = 0; i<cmp.length(); i++) {
				if(N.charAt(0) == cmp.charAt(i)) {
					cmp = cmp.substring(i+1,cmp.length());
					N = N.substring(1);
					flag= true;
					break;
				}
			}
			if(N.equals("")) break;
			if(flag == false) {
				num++;
				cmp += String.valueOf(num);
			}else {
				flag = false;
			}
		}
		System.out.println(num);
		

	}

}
