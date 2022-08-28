package b14889;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
    static int[][] synergy;
    static int[] teamA;
    static int[] teamB;
    static boolean[] selected;
    static int best, N;
     
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
         
         
        N = Integer.parseInt(br.readLine());
        teamA = new int[N/2];
        teamB = new int[N/2];
        synergy = new int[N][N];
        best= Integer.MAX_VALUE;
        selected = new boolean[N];
        for(int i = 0; i< N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j = 0; j < N; j++) {
                synergy[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        comb(0,0);
        System.out.println(best);
             
         
         
    }
    public static void comb(int depth, int start) {
        if(depth == N/2) {
            int idx1 = 0;
            int idx2 = 0;
            for(int i = 0; i< N; i++) {
                if(selected[i]) {
                    teamA[idx1++] = i;
                }else {
                    teamB[idx2++] = i;
                }
            }
            calc();
            return;
        }
         
        for(int i = start; i< N; i++) {
            if(selected[i]) continue;
            selected[i] = true;
            //foodsA[depth] = i;
            comb(depth+1,i+1);
            selected[i] = false;
        }
    }
    public static void calc() {
        int food1 = 0;
        int food2 = 0;
        for(int i = 0; i< N/2; i++) {
            for(int j = 0; j < N/2; j++) {
                if (i == j) continue;
                food1 += synergy[teamA[i]][teamA[j]];
                food2 += synergy[teamB[i]][teamB[j]];
            }
        }
        int result = Math.abs(food2- food1);
        best = Math.min(result, best)
;       
    }
}