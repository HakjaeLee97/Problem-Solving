import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] permarr, nums;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		nums = new int[N];
		
		for(int i = 0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] calc = new int[4];
		st = new StringTokenizer(br.readLine()," ");
		for(int i =0; i<4;i++) {
			calc[i] = Integer.parseInt(st.nextToken());		
		}

		perm(1,nums[0],calc);
		System.out.println(max);
		System.out.println(min);
		br.close();
	}

	public static void perm(int depth, int result, int[] calc) {
		if(depth ==N) {
			if(result > max) max = result;
			if(result < min) min = result;
			
			return;
		}
		for(int i = 0; i<4; i++) {
			if(calc[i] > 0) {
				calc[i]--;
				switch(i) {
				case 0://덧셈
					perm(depth+1, result + nums[depth], calc);
					break;
				case 1://뺄셈
					perm(depth+1, result - nums[depth], calc);
					break;
				case 2://곱셈
					perm(depth+1, result * nums[depth], calc);
					break;
				case 3://나눗셈
					perm(depth+1, result / nums[depth], calc);
					break;
				}
				calc[i]++;
			}
		}
			
	}
}
