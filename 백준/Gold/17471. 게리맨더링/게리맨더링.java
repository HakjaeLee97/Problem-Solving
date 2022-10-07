import java.io.*;
import java.util.*;

public class Main{
	
	static boolean[] included;
	static int[] pop;
	static int N,pop_sum;
	static int best = Integer.MAX_VALUE;
	static Queue<Integer> q = new ArrayDeque<>();
	static ArrayList<Integer>[] g;
	
	public static void main(String args[]) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		pop = new int[N];
		included = new boolean[N]; //선거구 1에 포함되었는지 여부
		
		for(int i =0; i<N; i++){
			pop[i] = Integer.parseInt(st.nextToken());
			pop_sum += pop[i]; //전체 인구 수
		}		
		g = new ArrayList[N];//인접 리스트
		for(int i = 0; i<N; i++){
			g[i] = new ArrayList<>();
		}
		for(int i = 0; i<N; i++){
			st = new StringTokenizer(br.readLine(), " ");
			int T = Integer.parseInt(st.nextToken());
			for(int t = 0; t<T; t++){
				g[i].add(Integer.parseInt(st.nextToken())-1);
			}
		}
		//풀이 전략 : 10개의 지역구 중 1개~ 5개를 선거구 1로 뽑는 경우의 수를 다 시도 . 완전 탐색 + 백트래킹
		for(int i = 1; i<=N/2; i++){
			comb(0,0,i);
		}	
		if(best == Integer.MAX_VALUE) best = -1;
		System.out.println(best);
		br.close();
	}
	public static void comb(int depth, int start, int pick){
		if (depth == 	pick){
			calc();
			return;
		}
		for(int i = start; i< N; i++){
			included[i] = true;
			comb(depth+1,i+1,pick);
			included[i] = false;
		}
	}
	//bfs로 이어져있는지 체크와 동시에 인구 수 계산
	public static void calc(){
		int now_pop = 0; //선거구 1의 인구수 
		boolean[] visited = new boolean[N];
		for(int i =0 ; i<N;i++){
			if(included[i]) {
				q.offer(i);
				visited[i] = true;
				now_pop += pop[i];
				break;
			}
		}
		while(!q.isEmpty()){
			int cur = q.poll();
			for(int i = 0, size = g[cur].size(); i<size; i++){
				if(included[g[cur].get(i)] && visited[g[cur].get(i)] == false){
					q.offer(g[cur].get(i));
					now_pop += pop[g[cur].get(i)];
					visited[g[cur].get(i)] = true;
				}
			}
		}
		
		for(int i =0 ; i<N;i++){
			if(included[i] == false) {
				q.offer(i);
				visited[i] = true;
				break;
			}
		}
		while(!q.isEmpty()){
			int cur = q.poll();
			for(int i = 0, size = g[cur].size(); i<size; i++){
				if(included[g[cur].get(i)] == false && visited[g[cur].get(i)] == false){
					q.offer(g[cur].get(i));
					visited[g[cur].get(i)] = true;
				}
			}
		}
        //전부 인접했는지 검사
		for(int i = 0; i<N; i++){
			if(visited[i] == false){
				return;
			}
		}
		//best 갱신
		if(best > Math.abs(pop_sum - now_pop*2)){
			best = Math.abs(pop_sum - now_pop*2);
		}
	}
}
				

		
		