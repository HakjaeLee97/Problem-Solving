import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		long[] A = new long[N];
		for(int i =0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine()," ");
		long B = Integer.parseInt(st.nextToken());
		long C = Integer.parseInt(st.nextToken());
		
		long answer = N;
		
		for(int i =0; i<N; i++) {
			long tmp = (A[i] -B)<=0? 0: A[i]-B;
			answer+= (tmp % C) == 0?(tmp / C):(tmp / C)+1;
		}
		System.out.println(answer);
		br.close();
	}

}
