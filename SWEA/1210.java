import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc =1; tc<11; tc++) {
			int[][] ladder = new int[100][100];
			br.readLine();
			for(int i = 0; i<100;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j<100; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i =0; i<100; i++) {
/*				if (ladder[0][i] == 1) { // 출발점을 찾음
					if(down(ladder,i)) {
						System.out.printf("#%d %d%n",tc,i);
						break;
					}
				}*/
				if (ladder[99][i] == 2) { // 도착점을 찾음
					System.out.printf("#%d %d%n",tc,up(ladder,i));
				}
			}
		}
	}
	public static boolean down(int[][] ladder, int pos) {
		int cur = 1;
		int nx = pos;
		while(cur<100) {
			if (pos == 0) {
				if(ladder[cur][pos+1] == 1) { 
					while(ladder[cur][nx] == 1) {	
						nx++;
						if (nx>=100) {
							break;
						}
					}
					pos = --nx;
				}
			}
			else if (pos == 99) {
				if(ladder[cur][pos-1] == 1) {
					while(ladder[cur][nx] == 1) {	
						nx--;
						if(nx<0) {
							break;
						}
					}
					pos = ++nx;
				}
			} 
			else {
				if(ladder[cur][pos+1] == 1) { 
					while(ladder[cur][nx] == 1) {
						nx++;
						if(nx >=100) {
							break;
						}
					}
					pos = --nx;
				}else if(ladder[cur][pos-1] == 1) {
					while(ladder[cur][nx] == 1) {	
						nx--;
						if(nx<0) {
							break;
						}
					}
					pos = ++nx;
				}
			}
			cur++;
		}
		if (ladder[--cur][pos] == 2) {
			return true;
		}
		else
			return false;
		
	}


	public static int up(int[][] ladder, int pos) {
		int cur = 99;
		int nx = pos;
		while(cur>0) {
			if (pos == 0) {
				if(ladder[cur][pos+1] == 1) { 
					while(ladder[cur][nx] == 1) {	
						nx++;
						if (nx>=100) {
							break;
						}
					}
					pos = --nx;
				}
			}
			else if (pos == 99) {
				if(ladder[cur][pos-1] == 1) {
					while(ladder[cur][nx] == 1) {	
						nx--;
						if(nx<0) {
							break;
						}
					}
					pos = ++nx;
				}
			} 
			else {
				if(ladder[cur][pos+1] == 1) { 
					while(ladder[cur][nx] == 1) {
						nx++;
						if(nx >=100) {
							break;
						}
					}
					pos = --nx;
				}else if(ladder[cur][pos-1] == 1) {
					while(ladder[cur][nx] == 1) {	
						nx--;
						if(nx<0) {
							break;
						}
					}
					pos = ++nx;
				}
			}
			cur--;
		}
		return nx;
	}

}
