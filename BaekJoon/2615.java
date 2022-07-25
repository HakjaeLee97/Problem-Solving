import java.util.Scanner;

public class Main {
	
	public static final int[] dx = {-1,1,0,0,-1,1,1,-1};
	public static final int[] dy = {0,0,-1,1,-1,1,-1,1};
	
	public static boolean check(int[][] pan,int i, int j) {
		int count = 1;
		int dol = pan[i][j];

		for (int k=0; k<8; k++) {
			for (int depth = 1; depth <= 5; depth++) { // 깊이 우선으로 팔방 탐색
				int nx = i + dx[k] *depth;
				int ny = j + dy[k] *depth;
				if( 0<= nx && nx<19 && 0<= ny && ny < 19) {
					if (pan[nx][ny] == dol) {
						count ++;
						//System.out.printf("count : %d x :%d y :%d %n ",count,nx,ny);
					} else {
						break;
					}
					
				}//좌 우 상 하 좌상 우하 우상 좌하 순으로 육목 방지 코드 작성 
				//우 좌 하 상 우하 좌상 좌하 우상
			}
			
/*			if (count == 5) {
				if( k == 0 && i+1 <19 && pan[i+1][j] != pan[i][j]) return true;
				else if( k == 1 && i-1 >=0 && pan[i-1][j] != pan[i][j]) return true;
				else if( k == 2 && j+1 <19 && pan[i][j+1] != pan[i][j]) return true;
				else if( k == 3 && j-1 >=0 && pan[i][j-1] != pan[i][j]) return true;
				else if( k == 4 && i+1 <19 && j+1<19 && pan[i+1][j+1] != pan[i][j]) return true;
				else if( k == 5 && i-1 >= 0 && j-1 >=0 && pan[i-1][j-1] != pan[i][j]) return true;
				else if( k == 6 && i-1 >=0 && j+1< 19&&  pan[i-1][j+1] != pan[i][j]) return true;
				else if( k == 7 && i+1 <19 && j -1 >=0 && pan[i+1][j-1] != pan[i][j]) return true;

			}
			*/
			if (count== 5) {
			switch(k) {
			case 0:
				if( i + 1 >= 19 || pan[i+1][j] != pan[i][j]) return true;
				break;
			case 1:
				if( i-1 <0 || pan[i-1][j] != pan[i][j]) return true;
				break;
			case 2:
				if( j+1 >=19 || pan[i][j+1] != pan[i][j]) return true;
				break;
			case 3:
				if(  j-1 <0 || pan[i][j-1] != pan[i][j]) return true;
				break;
			case 4:
				if(  i+1 >=19 || j+1>=19 || pan[i+1][j+1] != pan[i][j]) return true;
				break;
			case 5:
				if(  i-1 < 0 || j-1 <0 || pan[i-1][j-1] != pan[i][j]) return true;
				break;
			case 6:
				if( i-1 <0 || j+1 >= 19 ||  pan[i-1][j+1] != pan[i][j]) return true;
				break;
			case 7:
				if(  i+1 >=19|| j -1 <0 || pan[i+1][j-1] != pan[i][j]) return true;
				break;
			}
			}
			
			count = 1;
		}
		return false;
	}
	
	public static void checkAndPrint(int[][] pan) {
		for (int j = 0; j < 19; j++) {
			for(int i = 0; i <19; i++) {// 가장 왼쪽의 바둑알을 구해야 하므로 세로줄부터 loop
				if (pan[i][j] != 0) {
					if (check(pan,i,j)) {
						System.out.println(pan[i][j]);
						int resultx = i + 1;
						int resulty = j + 1;
						System.out.println(resultx+" "+resulty);
						return;
					}
				}
			}
		}
		System.out.println(0);
	}
	
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		

		int[][] pan = new int[19][19];
		for (int i = 0; i < 19; i++) {
			for(int j = 0; j <19; j++) {
				pan[i][j] = sc.nextInt();
			}
		} // 입력 받기
	//	System.out.println(check(pan,0,5));
		checkAndPrint(pan);
		
	
		sc.close();
	}

}
