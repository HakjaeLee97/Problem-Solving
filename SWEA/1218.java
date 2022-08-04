package s1218;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <=10; tc++) {
			int N = Integer.parseInt(br.readLine());
			Stack<String> stack = new Stack<>();
			String[] input =  br.readLine().split("");
			boolean isvalid = true;
			try {
				for(int i =0; i<N;i++) {
					if (input[i].equals("{") ) {
						stack.push("{");
					} else if(input[i].equals("[")) {
						stack.push("[");
						
					} else if(input[i].equals("<")) {
						stack.push("<");
						
					} else if(input[i].equals("(")) {
						stack.push("(");
						
					} else if(input[i].equals("}")) {
						if(!stack.pop().equals("{")) {
							isvalid =  false;
						}
					} else if(input[i].equals("]")) {
						if(!stack.pop().equals("[")) {
							isvalid =  false;
						}
						
					} else if(input[i].equals(">")) {
						if(!stack.pop().equals("<")) {
							isvalid =  false;
						}
						
					} else  { // 입력이 ")"일 때
						if(!stack.pop().equals("(")) {
							isvalid =  false;
						}
						
					}
				}
			}catch (EmptyStackException e) {
				isvalid = false;
			}
			if(!stack.isEmpty()) isvalid = false;
			if(isvalid) {
				System.out.printf("#%d %d%n",tc,1);
			} else {
				
				System.out.printf("#%d %d%n",tc,0);
			}
		}
	}

}
