import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] belt = new int[N];
		for(int i = 0; i<N; i++) {
			belt[i] = Integer.parseInt(br.readLine());
		}
		
		int best = 0;
		HashSet<Integer> set = new HashSet<>(d);
		
		for(int i = 0; i<N; i++) {//각 벨트의 점에서 시작
			set.clear();
			for(int j= 0; j<k;j++) { //연속으로 k개를 먹음
				set.add(belt[(i+j)%N]);
			}
			set.add(c);
			best = Math.max(best, set.size());
		}
		System.out.println(best);
		br.close();
	}

}
