import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc = 1; tc<11; tc++) {
			int dump = Integer.parseInt(br.readLine());
			int[] box = new int[100];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i< 100; i++) {
				box[i]= Integer.parseInt(st.nextToken());
			}
			int max= -1;
			int min = 101;
			int min_idx = -1;
			int max_idx = -1;
			int result = -1;
			for(int i = 0; i< dump ; i++) {
				max = -1;
				min = 101;
				min_idx = -1;
				max_idx = -1;
				result = -1;
						
				for(int j= 0; j < 100; j++) {
					if (box[j] > max) {
						max = box[j];
						max_idx = j;
					} if(box[j]<min) {
						min = box[j];
						min_idx = j;
					}
				}
				if(box[max_idx] == box[min_idx]) break;
				box[max_idx]--;
				box[min_idx]++;
				
				
			}
			max = -1;
			min = 101;
			min_idx = -1;
			max_idx = -1;
			result = -1;
			
			for(int j= 0; j < 100; j++) {
				if (box[j] > max) {
					max = box[j];
					max_idx = j;
				} else if(box[j]<min) {
					min = box[j];
					min_idx = j;
				}
			}
			result = box[max_idx] - box[min_idx];

			System.out.printf("#%d %d%n",tc,result);
			
		}
	}

}
