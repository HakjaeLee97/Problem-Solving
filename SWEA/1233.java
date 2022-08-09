package s1233;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

	public static class Node{
		String value;
		int index;
		int left;
		int right;
		public Node(int index, String value, int left, int right) {
			this.index = index;
			this.value = value;
			this.left = left;
			this.right = right;
		}
		public Node(int index, String value, int left) {
			this.index = index;
			this.value = value;
			this.left = left;
			this.right = -1;
		}
		public Node(int index, String value) {
			this.index = index;
			this.value = value;
			this.left = -1;
			this.right = -1;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int tc =1; tc<=10; tc++) {
			int N = Integer.parseInt(br.readLine());
			ArrayList<Node> tree = new ArrayList<>();
			for(int i=1; i<N+1; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int index = Integer.parseInt(st.nextToken());
				String value = st.nextToken();
				if(st.hasMoreTokens()) { // left가 있을 떄
					int left = Integer.parseInt(st.nextToken());
					if(st.hasMoreTokens()) {// right까지 있을 때
						int right = Integer.parseInt(st.nextToken());
						tree.add(new Node(index,value,left,right));
					} else {
						tree.add(new Node(index,value,left));				
					}
				} else {
					tree.add(new Node(index,value));				
				}
			}
			boolean result = true;
			for(int i = 0; i< tree.size(); i++) {
				Node now = tree.get(i);
				char tmp = now.value.charAt(0);
				if(now.left != -1) {
					if(now.right == -1) { // 왼쪽 자식 노드는 있고 오른쪽 자식 노드는 없음
						result = false;
						break;
					} else { // 왼쪽과 오른쪽 자식 노드가 있을 때는 연산자여야 함
						if (tmp != '+' && tmp != '-' && tmp != '*' && tmp != '/') {
							result = false;
							break;
						}
					}
				}
				else { //리프노드일때는 숫자여야 함
					if(tmp == '+' || tmp == '-' || tmp == '*' || tmp == '/') {
						result= false;
						break;
					}
				}
			}
			sb.append("#").append(tc).append(" ");
			if(result == true) {
				sb.append(1);
			}
			else {
				sb.append(0);
			}
			sb.append("\n");
		}
		System.out.print(sb);

		br.close();
	}

}
