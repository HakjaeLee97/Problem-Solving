package b1074;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int count;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int size=  (int)Math.pow(2, N);
		
		
		z(r,c, size);
		System.out.println(count);
		br.close();
	}
	public static void z(int r, int c, int size) {
		if (size == 2) {
			count += c + ( r *2);
			return;
		}
		
		if(r < size/2) {
			if(c < size/2) { // 첫 사분면에서 찾아야 할 경우
				
				z(r,c,size/2);
				
			}else { // 두번째 사분면에서 찾아야 할 경우

				count += size/2 * size/2;
				z(r,c-size/2,size/2);
			}
		} else {
			if(c < size/2) { // 세번째 사분면에서 찾아야 할 경우
				count += size/ 2 * size;
				z(r-size/2,c,size/2);
			}
			else { //네번째 사분면에서 찾아야 할 경우
				count+= (size/2 * size/2) + (size/2 * size);
				z(r-size/2,c-size/2,size/2);
			}
			
		}

	}

}
