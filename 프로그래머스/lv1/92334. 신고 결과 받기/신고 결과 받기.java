import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
class Solution {
    public static int[] solution(String[] id_list, String[] report, int k) {
    	StringTokenizer st;
    	int size = id_list.length;
    	int[] answer = new int[size];
    	HashMap<String, ArrayList<Object>> hm = new HashMap<>(size);
    	//각 이름별로 신고당한회수, 신고자 목록이 들어간다.
    	for(int i = 0; i<size; i++) {
    		hm.put(id_list[i], new ArrayList<>());
    		hm.get(id_list[i]).add(0);
    	}
        for(int i = 0,len = report.length; i<len; i++){
            st= new StringTokenizer(report[i]," ");
            String a = st.nextToken(); //신고자
            String b = st.nextToken(); // 피신고자
            if(hm.get(b).contains(a) == false) {
            	int now = (int)hm.get(b).get(0) + 1;
            	hm.get(b).set(0,now);
            	hm.get(b).add(a);
            }
        }
        
        for(String key : hm.keySet()) {
        	if((int)hm.get(key).get(0) >= k) {
        		for(int i = 1; i<hm.get(key).size();i++) {
        			for(int j= 0; j<size; j++) {
        				if(hm.get(key).get(i).equals(id_list[j])) {
        					answer[j]++;
        				}
        				
        			}
        			
        		}
        	}
        }
        
        return answer;
    }
}