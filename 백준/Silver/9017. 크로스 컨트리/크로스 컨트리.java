import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int  T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			//팀별 완주한 주자의 수
			HashMap<Integer, Integer> runner_team = new HashMap<>();
			//전체 들어온 순서 
			int[] rank = new int[N];
			//팀별 점수 
			HashMap<Integer, Integer> scores = new HashMap<>();
			//팀별 상위4명 여부
			HashMap<Integer, Integer> four = new HashMap<>();
			//팀별 5번째 주자 들어온 순서
			HashMap<Integer, Integer> five = new HashMap<>();
			
			
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				int team = Integer.parseInt(st.nextToken());
				rank[j] = team;
				if(runner_team.containsKey(team)) {
					int nth = runner_team.get(team);
					runner_team.put(team, nth+1);
					if(nth +1 == 5) {
						five.put(team, j);
					}
				}else {
					runner_team.put(team, 1);
					scores.put(team,0);
					four.put(team, 0);
					five.put(team, 0);
				}
			}
			int score = 1;
			for (int j = 0; j < N; j++) {
				if(runner_team.get(rank[j]) == 6) {
					if(four.get(rank[j]) <4) {
						scores.put(rank[j], scores.get(rank[j])+score);
						four.put(rank[j], four.get(rank[j])+1);
					}
					score++;
				}
			}
			int min = Integer.MAX_VALUE;
			int minnum = 0;
			for (int key : scores.keySet()) {
				if(scores.get(key)<min && runner_team.get(key) == 6) {
					min= scores.get(key);
					minnum = key;
				}else if(scores.get(key) == min) {
					if(five.get(key) < five.get(minnum)) {
						minnum = key;
					}
				}
			}
//			bw.write(minnum);
			System.out.println(minnum);
		}
//		bw.flush();
		br.close();
	}

}
