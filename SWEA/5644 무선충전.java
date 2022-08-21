package s5644;

import java.io.*;
import java.util.*;

public class Solution {
	//이동방향 0: 제자리, 1:상 2:우 3:하 4:좌
	static int[] dx = {0,-1,0,1,0};
	static int[] dy = {0,0,1,0,-1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int M = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			
			int[] userA = new int[M];
			int[] userB = new int[M];
			st = new StringTokenizer(br.readLine()," ");
			for(int i =0; i<M; i++) {
				userA[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine()," ");
			for(int i =0; i<M; i++) {
				userB[i] = Integer.parseInt(st.nextToken());
			}
			
			int[][] charger = new int[A][4];
			for(int i =0; i<A; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken())-1;
				int y = Integer.parseInt(st.nextToken())-1;
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				charger[i][0] = y; //y
				charger[i][1] = x; //x
				charger[i][2] = c; //충전 범위
				charger[i][3] = p; //처리량	
			}
			
			
			int result = 0;
			
			int ax = 0;
			int ay = 0; //사용자 a의 위치
			int bx = 9;
			int by = 9; //사용자 b의 위치

			int[] resa = check(ax,ay,charger);
			int[] resb = check(bx,by,charger);

			result += resa[0] + resb[0];
			
			for(int i = 0; i< M; i++) {
				//유저의 움직임

				ax = ax + dx[userA[i]];					
				ay = ay + dy[userA[i]];					

				bx = bx + dx[userB[i]];					
				by = by + dy[userB[i]];					
				
				resa = check(ax,ay,charger);
				resb = check(bx,by,charger);
				
				if( resa[1] != resb[1]) { //둘이 다른 충전기 사용
					result += resa[0] + resb[0];
				} else { //같은 충전기 사용
					result += Math.max(resa[2] + resb[0], resa[0] + resb[2]);
				}
			}
			sb.append("#").append(tc).append(" ").append(result).append("\n");	
		}
		System.out.print(sb);
		br.close();
	}
	
	public static int[] check(int x, int y, int[][] charger) {
		int max =0;
		int second = 0;
		int index = -1;
		for(int i =0, size = charger.length; i<size; i++) {
			if(Math.abs(charger[i][0] - x) + Math.abs(charger[i][1] -y) <= charger[i][2]) {
				if(charger[i][3] > max) {
					second = max;
					max=charger[i][3];
					index = i;
				}
				else if(charger[i][3] > second ) {
					second = charger[i][3];
				}
			}
		}
		return new int[] {max,index,second};
	}
	
}
