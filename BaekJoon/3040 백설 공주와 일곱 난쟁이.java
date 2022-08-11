package b3040;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main { 
	static int[] nums = new int[9];
	static int[] perm = new int[9];
	static boolean[] visited = new boolean[9];
	static ArrayList<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 9; i++) {
			//nums[i] = Integer.parseInt(br.readLine());
			list.add(Integer.parseInt(br.readLine()));
		}
		//comb(0,0);
		twopointer();
	}
	
	public static void twopointer() {
		Collections.sort(list);
		int sum = 0;
		for(int i : list) sum+=i;
		sum -= 100;
		int start = 0;
		int end = 8;
		
		while(start <= end) {
			if(sum > list.get(start) + list.get(end))start++;
			else if(sum < list.get(start) + list.get(end)) end--;
			else break;
		}
		for(int i = 0; i < 9; i++) {
			if( i != start && i!= end) System.out.println(list.get(i));
		}
	}
	
	
	public static void comb(int depth,int start) { // 조합을 이용
		if(depth == 7) {
			int sum = 0;
			for(int i = 0; i < 7; i++) {
				sum += perm[i];
			}
			if (sum == 100) {
				for(int i = 0; i < 7; i++) {
					System.out.println(perm[i]);
				}
			}
			return;
		}
		
		for(int i = start; i< 9; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			perm[depth] = nums[i];
			comb(depth+1,i+1);
			visited[i] = false;
		}
	}
}

