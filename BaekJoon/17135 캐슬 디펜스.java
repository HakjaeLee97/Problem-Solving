package b17135;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static class enemy{
		int x,y;

		public enemy(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}

	static int best, N,M,D;
	static int[] archer = new int[3]; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		enemy[] enemies = new enemy[255];
		int enemycnt = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < M; j++) {
				int tmp =  Integer.parseInt(st.nextToken());
				map[i][j] = tmp;
				if(tmp == 1) {
					enemies[enemycnt++] = new enemy(i,j);
				}
			}
		}
		comb(map,0,0,enemies,enemycnt);
		System.out.println(best);
		br.close();
		
		
		
	}
	
	public static void comb(int[][] map,int depth, int start , enemy[] enemies,int enemycnt) {
		if (depth == 3) {
			best = Math.max(dogame(map,archer,enemies,enemycnt),best);
			return;
		}
		for(int i =start; i<M; i++) {
			archer[depth] = i;
			comb(map,depth+1,i+1,enemies,enemycnt);
		}
		
	}
	public static int dogame(int[][] map, int[] archer, enemy[] enemies,int enemycnt ) { //세 궁수의 좌표
		int killcnt = 0;
		int endcnt = 0;
		int turncnt = 0;
		
		int[] nowdead = new int[3];
		boolean[] isdead = new boolean[enemycnt];
		
		while(endcnt < enemycnt) {
			Arrays.fill(nowdead, -1);
			for(int i = 0; i<3; i++) { //각 궁수마다
				int tmp = Integer.MAX_VALUE;
				int enmidx = -1; //가장 가까운 적
				for(int j =0; j< enemycnt; j++) { //모든 적을 검사
					int d = dist(archer[i],enemies[j]) - turncnt;
					if(d <= D && isdead[j] == false) { //적과의 거리가 사정거리 내
						if (d < tmp) { //가장 가까운 적임
							tmp = d;
							enmidx = j;
						}else if(d == tmp) { //거리가 같으면 가장 왼쪽인지 검사
							if(enemies[j].y < enemies[enmidx].y) {
								tmp = d;
								enmidx = j;
							}
						}
					}
				}
				if(enmidx != -1 ) { //사정거리 내 적이 있을 때

					nowdead[i] = enmidx;
				}
			}
			for(int i = 0; i< 3; i++) {
				if(nowdead[i] != -1 && isdead[nowdead[i]] == false) {
					isdead[nowdead[i]] = true;
					killcnt++;
					endcnt++;
				}
				
			}
			turncnt++;
			for(int i =0; i< enemycnt; i++) { 
				if(enemies[i].x + turncnt >= N && isdead[i] == false) {
					endcnt++;
					isdead[i] = true;
				}
			}
		}
		
		return killcnt;
	}
	
	public static int dist(int i, enemy enm) {
		return (N - enm.x) + Math.abs(i-enm.y); 
	}
}	
