import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int result;
	public static void main(String[] args) throws Exception { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		//지방 별 예산청구액
		int[] req = new int[N];
		int sum = 0;
		//예산 상한액
		result = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int M = Integer.parseInt(br.readLine());
		
		
		for (int i = 0; i < N; i++) {
			req[i] = Integer.parseInt(st.nextToken());
			sum+= req[i];
			result = Math.max(result, req[i]);
		}
		//모든 요청이 배정 가능할 때
		if(sum <=M ) {
			System.out.println(result);
		}else {
			result = 0;
			binSearch(N,M,0,M,req);
			//이분탐색으로 최선의 상한액을 찾기
			System.out.println(result);
			
		}
		
		
	}
	public static void binSearch(int N, int M,int left, int right, int[] req) {
		int center = (left + right)/ 2;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			if(req[i] < center) {
				sum+= req[i];
			}else {
				sum += center;
			}
		}
		if(sum <= M) {
			result = Math.max(result, center);
		}
		if(left == right) {
			return;
		}else if (sum < M) {
			if(left != center) {
				binSearch(N,M,center,right,req);
			}
		}else if( sum == M) {
			return;
		}else {
			if(right != center) {
				
				binSearch(N,M,left,center,req);
			}
		}
	}

}
