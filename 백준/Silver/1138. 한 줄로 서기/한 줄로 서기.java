import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int[] seq = new int[N];
		int tmp,cnt;
		for (int i = 0; i < N; i++) {
			tmp = Integer.parseInt(st.nextToken());
			cnt = 0;
			for(int j=0; j<N;j++) {
				if(seq[j] == 0) {
					if(cnt == tmp) {
						seq[j] = i+1;
						break;			
					}
					cnt++;
				}
				
			}
		}
		for (int i = 0; i < N; i++) {
			System.out.print(seq[i]);
			System.out.print(" ");
		}
		br.close();
		
	}

}
