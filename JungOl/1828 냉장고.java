package j1828;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static class chem implements Comparable<chem>{
		int low;
		int high;
		chem(int low, int high){
			this.low = low;
			this.high = high;
		}
		@Override
		public int compareTo(chem o) {
			int r = (this.high - o.high); // 최고온도 오름차순 정렬
			if( r== 0) {
				r = this.low - o.low;
			}
			return r;
		}
		@Override
		public String toString() {
			return this.high + " " +this.low;
		}
	
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		chem[] chems = new chem[N];
		for(int i = 0; i<N; i++){
			st= new StringTokenizer(br.readLine()," ");
			chems[i] = new chem(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(chems);


		int result = N;
		int high = chems[0].high; 
		
		for(int i = 1; i< N; i++){
			if(chems[i].low <= high) { 
				result--;
			}
			else { 
				high = chems[i].high;
			}
		}
		
		System.out.println(result);
		
	}

}
