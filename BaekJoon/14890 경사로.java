package b14890;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		boolean[][] inclined = new boolean[N][N];
		for(int i =0; i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int result = 0; //지나갈 수 있는 길의 개수
		
		outer : for(int i =0; i<N; i++) {//각 행별로 지나갈수있는지 체크
			int tmp = map[i][0];
			for(int j = 1; j<N; j++) {
				if(Math.abs(map[i][j] - tmp) > 1) { //높이 차이가 2이상일 때 
					continue outer;
				}else if(map[i][j] - tmp == -1 ) {//내려가는 경사로 설치 시도
					if(inclined[i][j] == false) { 
			
						tmp = map[i][j];
						boolean isok = true;
						for(int k = 0; k<L; k++) {
							if(j+k>=N || map[i][j+k] != tmp) {
								isok = false;
								break;
							}
						}
						if(isok) { //경사로 설치 성공
							for(int k = 0; k<L; k++) {
								inclined[i][j+k] = true;
							}
							tmp = map[i][j];//tmp 갱신
						}else {
							continue outer;
						}
					}
				}else if(map[i][j] - tmp == 1 ) {//올라가는 경사로 설치 시도
					if(inclined[i][j] == false) { 
			
						tmp = map[i][j-1];
						boolean isok = true;
						for(int k = 0; k<L; k++) {
							if(j-1-k < 0 || map[i][j-1-k] != tmp || inclined[i][j-1-k]) {
								isok = false;
								break;
							}
						}
						if(isok) { //경사로 설치 성공
							for(int k = 0; k<L; k++) {
								inclined[i][j-1-k] = true;
							}
							tmp = map[i][j];//tmp 갱신
						}else {
							continue outer;
						}
					}
				tmp = map[i][j];//tmp 갱신
				}
			}
			result++;
		}
		for(int i = 0; i<N;i++) {
			Arrays.fill(inclined[i], false);
		}
			
		
		outer : for(int i =0; i<N; i++) {//각 열별로 지나갈수있는지 체크
			int tmp = map[0][i];
			for(int j = 1; j<N; j++) {
				if(Math.abs(map[j][i] - tmp) > 1) { //높이 차이가 2이상일 때 
					continue outer;
				}else if(map[j][i] - tmp == -1 ) {//내려가는 경사로 설치 시도
					if(inclined[j][i] == false) { 
						
						tmp = map[j][i];
						boolean isok = true;
						for(int k = 0; k<L; k++) {
							if(j+k>=N || map[j+k][i] != tmp) {
								isok = false;
								break;
							}
						}
						if(isok) { //경사로 설치 성공
							for(int k = 0; k<L; k++) {
								inclined[j+k][i] = true;
							}
							tmp = map[j][i];//tmp 갱신
						}else {
							continue outer;
						}
					}
				}else if(map[j][i] - tmp == 1 ) {//올라가는 경사로 설치 시도
					if(inclined[j][i] == false) { 
						
						tmp = map[j-1][i];
						boolean isok = true;
						for(int k = 0; k<L; k++) {
							if(j-1-k < 0 || map[j-1-k][i] != tmp || inclined[j-1-k][i]) {
								isok = false;
								break;
							}
						}
						if(isok) { //경사로 설치 성공
							for(int k = 0; k<L; k++) {
								inclined[j-1-k][i] = true;
							}
							tmp = map[j][i];//tmp 갱신
						}else {
							continue outer;
						}
					}
					tmp = map[j][i];//tmp 갱신
				}
			}
			result++;
		}
		System.out.println(result);
		br.close();
	}
}