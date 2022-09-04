import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		int[] arr = new int[N+1];
		
		int sum = 0;
		arr[0] = Integer.parseInt(st.nextToken());
		
		for(int i =1; i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
//			sum += arr[i];
//			if(arr[i] == S) { //길이가 1인 부분합
//				System.out.println(1); 
//				System.exit(0);
//			}
		}
		
//		if(sum < S){ //부분합이 불가능
//			System.out.println(0);
//			System.exit(0);
//		}
		int left = 0;
		int right = 0;
		int answer = Integer.MAX_VALUE;
		sum = 0;
		while (left <=N && right <=N) {
			if(sum >= S && answer > right-left) {
				sum -= arr[left];
				answer = right-left;
				left++;
		
			}
			if(sum < S){
				sum += arr[right++];
			}
			else {
				sum-= arr[left++];
			}
		}
		if(answer == Integer.MAX_VALUE) System.out.println(0);
		else{
			System.out.println(answer);
		}
	}

}
