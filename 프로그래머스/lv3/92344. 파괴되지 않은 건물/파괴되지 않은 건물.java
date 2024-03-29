class Solution {
public static int solution(int[][] board, int[][] skill) {
    	int n = board.length;
    	int m = board[0].length;
        int[][] psum = new int[n+1][m+1];
        
        
    	for(int i = 0, size = skill.length; i<size; i++) {
    		
			if(skill[i][0] == 1) {
				//r1 c1
				psum[skill[i][1]][skill[i][2]] -= skill[i][5];
				//r1 c2
				psum[skill[i][1]][skill[i][4]+1] += skill[i][5];
				//r2 c1
				psum[skill[i][3]+1][skill[i][2]] += skill[i][5];
				//r2 c2
				psum[skill[i][3]+1][skill[i][4]+1] -= skill[i][5]; 
			} else {
				//r1 c1
				psum[skill[i][1]][skill[i][2]] += skill[i][5];
				//r1 c2
				psum[skill[i][1]][skill[i][4]+1] -= skill[i][5];
				//r2 c1
				psum[skill[i][3]+1][skill[i][2]] -= skill[i][5];
				//r2 c2
				psum[skill[i][3]+1][skill[i][4]+1] += skill[i][5]; 
			}
    	}
    	//누적합 처리
    	for(int i = 0; i<n; i++) {
    		for(int j = 1; j<m;j++) {
    			psum[i][j] += psum[i][j-1];
    		}
    	}
    	for(int i = 0; i<n; i++) {
    		for(int j = 1; j<m;j++) {
    			psum[j][i] += psum[j-1][i];
    		}
    	}
    		
    	int answer = 0;
    	for(int i = 0; i<n; i++) {
    		for(int j = 0; j<m;j++) {
    			if(board[i][j] + psum[i][j]>0) {
    				answer++;
    			}
    				
    		}
    	}
     
        return answer;
    }
}