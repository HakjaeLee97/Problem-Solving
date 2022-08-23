package s3289;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] parents;
	
	public static int find(int a) {
		if(a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader( System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int n = Integer.parseInt(st.nextToken());
			parents = new int[n+1];
			
			for(int i =1; i<=n; i++) {
				parents[i] = i;
			}
			int m = Integer.parseInt(st.nextToken());
			for(int i =0; i<m; i++) {
				st = new StringTokenizer(br.readLine()," ");
				if (st.nextToken().equals("0")) { //합집합
					int aroot = find(Integer.parseInt(st.nextToken()));
					int broot = find(Integer.parseInt(st.nextToken()));
					if(aroot != broot) parents[broot] = aroot;
				}else { //같은 집합 체크
					int a = Integer.parseInt(st.nextToken());
					int b = Integer.parseInt(st.nextToken());
					if(find(a) == find(b)) sb.append(1);
					else sb.append(0);
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	

}
