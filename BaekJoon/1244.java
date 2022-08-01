import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int switches = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] switchcon = new int[switches];
		for ( int i = 0; i < switches; i++) {
			switchcon[i] = Integer.parseInt(st.nextToken());
		}
		int students = Integer.parseInt(br.readLine());
		for ( int i = 0; i< students; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			int gender = Integer.parseInt(st2.nextToken());
			int index = Integer.parseInt(st2.nextToken()); // 배열은 0이 최초 인덱스이므로 주의
			if (gender == 1) { // 남자
				for (int j = 0; j<switches; j++) {
					if((j+1)%index  == 0) { // 배수 검사
						switchcon[j] = Math.abs(switchcon[j] - 1); // 1이면 0으로, 0이면 1로 바꿈
					}
				}
			} else { // 여자
				switchcon[index-1] = Math.abs(switchcon[index-1] - 1);
				int d = 1; 
				while(((index-1+d) < switches) && ((index-1-d) >= 0) && (switchcon[index-1 + d] == switchcon[index-1 - d])) {
					switchcon[index-1 + d] = Math.abs(switchcon[index-1+d] - 1);
					switchcon[index-1 - d] = Math.abs(switchcon[index-1-d++] - 1);
					
				}
				
			}
		}
		for ( int i = 0; i< switches; i++) {
			sb.append(switchcon[i]).append(" ");
			if ((i+1)%20 == 0) sb.append("\n");
		}
		System.out.println(sb);
	}

}
