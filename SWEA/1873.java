package s1873;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <T+1; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			String[][] map = new String[H][W];
			for(int i =0; i<H; i++) {
				map[i] = br.readLine().split("");
			}
			int tank_x = -1;
			int tank_y = -1;
			boolean shot = true;
			for(int i= 0; i< H; i++) {
				for(int j = 0; j<W; j++) {
					if (map[i][j].equals("^") || map[i][j].equals("v") || map[i][j].equals("<") || map[i][j].equals(">") ) {
						tank_x = j;
						tank_y = i;
					}
				}
			}
			
			int N = Integer.parseInt(br.readLine());
			String[] input = br.readLine().split("");
			for(int i=0; i<N; i++) {
				if(input[i].equals("U")) {
					if((tank_y-1 )>=0 && map[tank_y-1][tank_x].equals(".")) {
						tank_y--;
						map[tank_y][tank_x] = "^";
						map[tank_y+1][tank_x] = ".";
					}
					else {
						map[tank_y][tank_x] = "^";
					}
				}
				else if(input[i].equals("D")) {
					if((tank_y+1 )<H && map[tank_y+1][tank_x].equals(".")) {
						tank_y++;
						map[tank_y][tank_x] = "v";
						map[tank_y-1][tank_x] = ".";
					}
					else {
						map[tank_y][tank_x] = "v";
					}
					
				}
				else if(input[i].equals("L")) {
					if((tank_x-1 )>=0 && map[tank_y][tank_x-1].equals(".")) {
						tank_x--;
						map[tank_y][tank_x] = "<";
						map[tank_y][tank_x+1] = ".";
					}
					else {
						map[tank_y][tank_x] = "<";
					}
					
				}
				else if(input[i].equals("R")) {
					if((tank_x+1 )<W && map[tank_y][tank_x+1].equals(".")) {
						tank_x++;
						map[tank_y][tank_x] = ">";
						map[tank_y][tank_x-1] = ".";
					}
					else {
						map[tank_y][tank_x] = ">";
					}
					
				}
				else {
					shot = true;
					int d = 1;
					if(map[tank_y][tank_x].equals("^")) {
						while (shot) {
							if (tank_y -d < 0 ) {
								shot = false;
							}
							else if (map[tank_y-d][tank_x].equals("#")) {
								
								shot = false;
							}
							else if (map[tank_y-d][tank_x].equals("*")) {
								map[tank_y-d][tank_x] = ".";
								shot = false;
							}
							d++;
						}
					}
					else if(map[tank_y][tank_x].equals("v")) {
						while (shot) {
							if (tank_y +d >= H ) {
								shot = false;
							}
							else if (map[tank_y+d][tank_x].equals("#")) {
								
								shot = false;
							}
							else if (map[tank_y+d][tank_x].equals("*")) {
								map[tank_y+d][tank_x] = ".";
								shot = false;
							}
							d++;
						}
						
					}
					else if(map[tank_y][tank_x].equals(">")) {
						while (shot) {
							if (tank_x +d >= W ) {
								shot = false;
							}
							else if (map[tank_y][tank_x+d].equals("#")) {
								
								shot = false;
							}
							else if (map[tank_y][tank_x+d].equals("*")) {
								map[tank_y][tank_x+d] = ".";
								shot = false;
							}
							d++;
						}
						
					}
					else {
						while (shot) {
							if (tank_x -d < 0 ) {
								shot = false;
							}
							else if (map[tank_y][tank_x-d].equals("#")) {
								
								shot = false;
							}
							else if (map[tank_y][tank_x-d].equals("*")) {
								map[tank_y][tank_x-d] = ".";
								shot = false;
							}
							d++;
						}
						
					}
				}
			}
			sb.append("#").append(tc).append(" ");
			for(int i =0; i<H; i++) {
				for(int j =0; j<W;j++) {
					sb.append(map[i][j]);
					
				}
				sb.append("\n");
			}
			
		}
		System.out.print(sb);
	}

}
