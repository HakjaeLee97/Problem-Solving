package s3124;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
	static int N;
	static ArrayList<int[]> edges;
	static int[] p;
	
	static void makeSet() {
		p = new int[N];
		for(int i =0; i<N; i++) p[i] = i;
	}
	static int findSet(int a) {
		if(a  == p[a]) return a;
		return p[a] = findSet(p[a]);
	}
	static boolean union(int a,int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot ) return false;
		p[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc = 1; tc<= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			edges = new ArrayList<>();
			for(int i =0; i<E; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int A = Integer.parseInt(st.nextToken())-1;
				int B = Integer.parseInt(st.nextToken())-1;
				int C = Integer.parseInt(st.nextToken());
				edges.add(new int[] {A,B,C});
			}
			Collections.sort(edges, (o1,o2) -> Integer.compare(o1[2], o2[2]));
			makeSet();
			long result = 0;
			int cnt = 0;
			for(int[] edge:edges) {
				if(union(edge[0], edge[1])) {
					result += edge[2];
					if(++cnt == N-1) break;
				}
			}
			sb.append(result).append("\n");
		}
		System.out.print(sb);
	}
}
