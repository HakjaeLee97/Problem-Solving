import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public static class Nation implements Comparable<Nation>{
		int Gold;
		int Silver;
		int Bronze;
		int Index;
		public Nation(int gold, int silver, int bronze, int index) {
			super();
			Gold = gold;
			Silver = silver;
			Bronze = bronze;
			Index = index;
		}
		@Override
		public int compareTo(Nation o) {
			int r = -(this.Gold - o.Gold);
			if(r == 0) {
				r = -(this.Silver - o.Silver);
				if(r == 0) {
					r =-(this.Bronze - o.Bronze);
				}
			}
			return r;
		}
		
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		PriorityQueue<Nation> q = new PriorityQueue<>();
		int G,S,B,I;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			I = Integer.parseInt(st.nextToken());
			G = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			q.add(new Nation(G,S,B,I));
		}
		int rank = 0;
		int cnt = 0;
		G = -1;
		S = -1;
		B = -1;
		for (int i = 0; i < N; i++) {
			Nation n = q.poll();
			if(!(n.Gold == G && n.Silver == S && n.Bronze == B)) {
				if(cnt != 0) {
					rank += cnt;
					cnt = 0;
				}
				rank++;
				G = n.Gold;
				S = n.Silver;
				B = n.Bronze;
			}else {
				cnt++;
			}
			if(n.Index == K) break;
		}
		System.out.println(rank);
		br.close();
	}

}
