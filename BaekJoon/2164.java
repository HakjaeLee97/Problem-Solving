package b2164;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Deque<Integer> arr = new ArrayDeque<>();
		for(int i =N; i> 0; i--) {
			arr.add(i);
		}
		while(N > 1) {
			arr.removeLast();
			N--;
			if (N ==1) break;
			arr.addFirst(arr.removeLast());
		}
		System.out.println(arr.getFirst());
	}

}
