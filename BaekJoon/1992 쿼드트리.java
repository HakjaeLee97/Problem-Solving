package b1992;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		
		for(int i =0; i<N; i++) {
			char[] tmp = br.readLine().toCharArray();
//			String[] tmp = br.readLine().split("");
			for(int j=0; j<N; j++) {
				arr[i][j] = tmp[j]-'0';
//				arr[i][j] = Integer.parseInt(tmp[j]);
			}
		}
		compress(arr,0,0,N);
		System.out.print(sb);
		
		br.close();
	}
	public static void compress(int[][] arr,int x, int y, int length) {

		int check = arr[x][y];
			for(int i = x; i<x+length; i++) {//모든 영역이 check인지 검사
				for(int j = y; j<y+length; j++) {
					if(arr[i][j] !=check) { //아닐 경우 분할된 영역을 검사
						sb.append("(");
						compress(arr,x,y,length/2);
						compress(arr,x,y+length/2,length/2);
						compress(arr,x+length/2,y,length/2);
						compress(arr,x+length/2,y+length/2,length/2);
						sb.append(")");
						return;
					}
				}
			}
			sb.append(check);		
	}
}
