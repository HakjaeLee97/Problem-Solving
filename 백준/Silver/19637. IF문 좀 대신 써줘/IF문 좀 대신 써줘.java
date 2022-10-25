import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int left,right;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[] titles = new String[N];
		int[] highs = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			titles[i] = st.nextToken();
			highs[i]  = Integer.parseInt(st.nextToken());
		}
		//전투력 입력
		for (int i = 0; i < M; i++) {
			int power = Integer.parseInt(br.readLine());
			left = 0;
			right = N-1;
			binSearch(power, highs);

			bw.write(titles[left]);
			bw.write("\n");
		}
		bw.flush();
		br.close();
		
	}
	public static void binSearch(int power, int[] highs) {
		if(left > right){
			return;
		}
		int center = (left + right) / 2;

		if(power > highs[center]) {
			left = center+1;
			binSearch(power,highs);
		}
		
		else  {
			//더 낮은 전투력 칭호에 대해 검사
			right = center -1;
			binSearch(power,highs);
			
		}
		
	}

}
