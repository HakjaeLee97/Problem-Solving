public class Main {

	public static void main(String[] args) throws Exception {
		int N = read();
		int S = read();
		int[] arr = new int[N+1];
		
		for(int i =0; i<N;i++) {
			arr[i] = read();
		}
		

		int left = 0;
		int right = 0;
		int sum = 0;
		int answer = Integer.MAX_VALUE;
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
	
	private static int read() throws Exception {

	    int c, n = System.in.read() & 15;

	    while ((c = System.in.read()) > 32)
	        n = (n << 3) + (n << 1) + (c & 15);

	    if (c == 13) System.in.read();

	    return n;

	}


}
