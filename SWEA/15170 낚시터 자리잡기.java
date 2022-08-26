package s15170;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int mindist;
	static int[] seq;
	static boolean[] visited ;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc =1; tc<= T; tc++) {
			mindist = Integer.MAX_VALUE;
			seq = new int[3];
			visited = new boolean[3];
			int N =Integer.parseInt(br.readLine());
			int[][] gates = new int[3][2]; //게이트의 위치와 대기자 배열
			for(int i = 0; i<3;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				gates[i][0] = Integer.parseInt(st.nextToken());
				gates[i][1] = Integer.parseInt(st.nextToken());
			}
			perm(0,gates,N);
			sb.append("#").append(tc).append(" ").append(mindist).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	public static void dfs(int[][] gates, int N, int dist, boolean[] land, int depth) {
		if(depth == 3) {// 3개의 게이트를 전부 돌았음
			mindist = Math.min(mindist, dist);
			return;
		}
		int pos = gates[seq[depth]][0]; //게이트의 위치
		for(int j=0, size = gates[seq[depth]][1]; j<size-1; j++) { // 마지막 사람 전까지 체크
			int cur1 = pos, cur2 = pos; // 게이트의 위치부터 조사 시작
			while(cur1 >= 1 || cur2 <= N) {
				if(cur1 == 0) cur1 = 1;
				if(cur2 == N+1) cur2 = N;
				
				if(land[cur1] == false) {
					land[cur1] = true;
					dist += Math.abs(cur1-pos) + 1;
					break;
				}
				else if(land[cur2] == false) {
					land[cur2] = true;
					dist += Math.abs(cur2-pos) + 1;
					break;
				}else {
					cur1--;cur2++;
				}
			}
		}
		//마지막 사람의 경우 선택지가 2개
		int cur1 = pos, cur2 = pos; // 게이트의 위치부터 조사 시작
		while(cur1 >= 1 || cur2 <= N) {
			if(cur1 == 0) cur1 = 1;
			if(cur2 == N+1) cur2 = N;
			
			if(land[cur1] == false) {
				boolean[] tmp = Arrays.copyOf(land, N+1);
				land[cur1] = true;
				dfs(gates,N,dist+Math.abs(cur1-pos) + 1,land ,depth+1);
				land = tmp;
			}
			if(land[cur2] == false) {
				boolean[] tmp = Arrays.copyOf(land, N+1);
				land[cur2] = true;
				dfs(gates,N,dist+Math.abs(cur2-pos) + 1,land,depth +1 );
				land = tmp;
			}if(land[cur1] && land[cur2]) {
				cur1--;cur2++;
			}else {
				break;
			}
		}
				
			
		
	}
	public static void perm(int depth, int[][] gates, int N) {
		if(depth == 3) {
			dfs(gates,N,0, new boolean[N+1],0);
			return;
		}
		for(int i =0; i<3; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			seq[depth] = i;
			perm(depth+1,gates,N);
			visited[i] = false;
		}
	}
	
}
