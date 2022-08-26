package s1767;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static class core{
		int x;
		int y;
		public core(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int best,maxcore; //전선 길이의 최소합, 연결된 최대 코어 수
	static int[] seq;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0}; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc =1; tc<= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			ArrayList<core> cores = new ArrayList<>();
			best = Integer.MAX_VALUE;
			maxcore = Integer.MIN_VALUE;
			for(int i = 0; i<N; i++) {
				StringTokenizer st =new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(arr[i][j] == 1 && !(i == 0 || i == N-1 || j == 0 || j == N-1)) {
						cores.add(new core(i,j));
					}
				}
			}
			
			seq = new int[cores.size()];
			
			comb(0,arr,N,cores,0);
			sb.append("#").append(tc).append(" ").append(best).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	public static void comb(int depth,int[][] arr, int N, ArrayList<core> cores, int start) {
		if(depth == cores.size()) {
			calc(cores,N,0,0,arr,0);
			return;
		}
		for(int i = start, size = cores.size(); i<size; i++) {
			seq[depth] = i;
			comb(depth+1,arr,N,cores,i+1);
		}
	}
	public static void calc(ArrayList<core> cores, int N, int depth, int score, int[][] arr,int connected) {

		if((cores.size()-depth + connected < maxcore) && score>=best) return;//백트래킹
		if(depth == cores.size()) {//끝까지 돌았음
			return;
		}
		core cur = cores.get(seq[depth]);

			boolean flag = false;
			for(int j = 0; j<4; j++) { // 4가지 방향에 대해 전선 잇기
				//우 좌 하 상 순서로 탐색
				int[][] tmp = new int[N][N]; //전선을 잇기 전 배열 저장
				for(int i = 0; i<N;i++) {
					tmp[i] = Arrays.copyOf(arr[i], N);
				} //배열 복사
				
				int length = 1;
				while(true) {
					int nx = cur.x + dx[j]*length;
					int ny = cur.y + dy[j]*length;
					if(nx< 0 || nx>=N || ny < 0 || ny>= N) { // 전선이 끝까지 이어짐
						if(connected + 1 > maxcore) {
							best =  score+length-1;
							maxcore = connected + 1;
						} else if(connected + 1 == maxcore) {
							best = Math.min(best, score+length-1);
							maxcore = connected + 1;
						}
						calc(cores,N,depth+1,score+length-1,arr,connected + 1); //다음 코어에 대해 조사
						break;
					}
					if(arr[nx][ny] == 1 || arr[nx][ny] == 2) { //코어(1) 또는 전선(2)를 만남
						break;
					}
					arr[nx][ny] = 2; //전선 설치
					flag = true;
					length++;
				}
				if(flag) {
					for(int i = 0; i<N;i++) {
						arr[i] = Arrays.copyOf(tmp[i], N);
					} //배열 복구
				}
			}
//			또는 이번 프로세서에선 전선을 연결하지 않음
			if (maxcore < cores.size())calc(cores,N,depth+1,score,arr,connected);
			
		}
	

}

