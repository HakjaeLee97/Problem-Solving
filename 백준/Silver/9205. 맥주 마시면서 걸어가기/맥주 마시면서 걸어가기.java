import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	//문제 해석
	//한번에 1000m 갈 수 있음
	//편의점 도달시마다 1000m 리필
	public static class pos{
		int x;
		int y;
		boolean visited = false;
		public pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		public pos(int x, int y, boolean visited) {
			super();
			this.x = x;
			this.y = y;
			this.visited = visited;
		}
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		ArrayList<pos> lst = new ArrayList<>();
		Queue<pos> q = new ArrayDeque<>();
		for (int i = 0; i < t; i++) {
			lst.clear();
			int n = Integer.parseInt(br.readLine());
			st=  new StringTokenizer(br.readLine()," ");
			int start_x = Integer.parseInt(st.nextToken());
			int start_y = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				st=  new StringTokenizer(br.readLine()," ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				lst.add(new pos(x,y));
			}
			
			st=  new StringTokenizer(br.readLine()," ");
			int end_x = Integer.parseInt(st.nextToken());
			int end_y = Integer.parseInt(st.nextToken());
			
			q.offer(new pos(start_x,start_y,true));
			boolean flag= false;
			
			while(!q.isEmpty()) {
				pos cur = q.poll();
				if(Math.abs(cur.x - end_x) + Math.abs(cur.y - end_y) <= 1000) {
					flag = true;
					q.clear();
					break;
				}
				for(int j = 0, size= lst.size(); j<size; j++) {
					pos dest = lst.get(j);
					if(dest.visited) continue;
					if(Math.abs(cur.x - dest.x) + Math.abs(cur.y - dest.y) <= 1000) {
						q.offer(dest);
						dest.visited = true;
					}
				}
			}
			if(flag) {
				sb.append("happy\n");
			}else {
				sb.append("sad\n");
			}
			
		}
		System.out.print(sb);
		br.close();
	}

}
