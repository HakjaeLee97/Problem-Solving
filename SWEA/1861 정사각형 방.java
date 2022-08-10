package s1861;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Solution {
 
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
        int T = Integer.parseInt(br.readLine());
         
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            boolean[][] visited = new boolean[N][N];
             
            for (int i = 0; i <N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());                   
                }
            }
             
            int answer = 0;
            int max_move = 0;
            for (int i = 0; i <N; i++) {
                for (int j = 0; j < N; j++) {
                    if(visited[i][j] == false) {
    //                  int move =  bfs(map,i,j,N);
                        int move =  DFS(i,j,N,map,1,visited);
                        if(move > max_move) {
                            max_move = move;
                            answer = map[i][j];
                        }else if(move == max_move) {
                            if(answer > map[i][j]) {
                                answer = map[i][j];
                            }
                        }
                    }
                }
            }       
            sb.append("#").append(tc).append(" ").append(answer).append(" ").append(max_move).append("\n");
        }
        System.out.print(sb);
    }
     
    public static int bfs(int[][] map, int x, int y, int N) {
        int[] dx = new int[] {1,-1,0,0};
        int[] dy = new int[] {0,0,1,-1};
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[] {x,y});
        int count = 0;
        while(!q.isEmpty()) {
            count++;
            int[] now = q.poll();
            for(int i = 0; i<4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx < 0 | nx>=N || ny < 0 || ny>= N) continue;
                if(map[nx][ny] == map[now[0]][now[1]] + 1) {
                    q.add(new int[] {nx,ny});
                }
            }
        }   
        return count;
    }
    static int DFS(int x, int y,int N, int[][] map, int cnt, boolean[][] visited) {
        int[] dx = new int[] {1,-1,0,0};
        int[] dy = new int[] {0,0,1,-1};
        int nx, ny;
        int result = cnt;
        visited[x][y] = true;
        for(int d=0;d<4;d++) {
            nx = x + dx[d];
            ny = y + dy[d];
              
            if(nx < 0 | nx>=N || ny < 0 || ny>= N) continue;
            if(map[nx][ny] == map[x][y] + 1) {
                result = DFS(nx,ny,N,map,cnt+1,visited);
            }
        }
        return result;
              
    }
}