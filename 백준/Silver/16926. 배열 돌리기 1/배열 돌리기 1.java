import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int M;
    public static int R;
    public static int B;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();

    public static int[][] map;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int [N][M];

        for(int r = 0; r < N; r++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        // Flatten
        B = Math.min(N, M)/2;
        int[][] bands = new int[B][];
        for(int i = 0; i < B; i++){
            int [] band = new int [2 * (N-1 - (2*i)) + 2 * (M-1 - (2*i))];
            for(int h = 0; h < (M-1) - (i*2); h++) {
                band[h] = map[i][h+i];
                band[h + (N-1) + (M-1) - (i*4)] = map[N-1 - i][M-1 - i-h];
            }
            for(int v = 0; v < (N-1) - (i*2); v++) {
                band[v + M-1 - (i*2)] = map[i+v][M-1 - i];
                band[v + (N-1 - (2*i)) + 2 * (M-1 - (2*i))] = map[N-1 - i - v][i];
            }
            bands[i] = band;
        }

        // Rotate
        for(int b = 0; b < B; b++){
            int [] band = new int [bands[b].length];
            for(int i = 0; i < band.length; i++) band[i] = bands[b][(i+R)%band.length];
            bands[b] = band;
        }

        // Rollback
        for(int i = 0; i < B; i++){
            int [] band = bands[i];
            for(int h = 0; h < (M-1) - (i*2); h++) {
                map[i][h+i] = band[h];
                map[N-1 - i][M-1 - i-h] = band[h + (N-1) + (M-1) - (i*4)];
            }
            for(int v = 0; v < (N-1) - (i*2); v++) {
                map[i+v][M-1 - i] = band[v + M-1 - (i*2)];
                map[N-1 - i - v][i] = band[v + (N-1 - (2*i)) + 2 * (M-1 - (2*i))];
            }
        }

        for(int [] ma : map){
            for(int m : ma)  sb.append(m + " ");
            sb.append("\n");
        }
        System.out.print(sb);
    }
}