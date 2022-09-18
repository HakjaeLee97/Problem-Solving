import java.util.Arrays;
class Solution {
    public static int solution(int[] queue1, int[] queue2) {
//그리디?
    	long sum1 = Arrays.stream(queue1).sum();
    	long sum2 = Arrays.stream(queue2).sum();
    	
    	int size1 = queue1.length;
    	int size2 = queue2.length;
    	
    	int idx1 = 0;
    	int idx2 = 0;
    	
    	int maxcount = size1*3;
    	
    	if((sum1 +sum2)%2 == 1) return -1;
    	
    	int answer = 0;
    	
    	while(idx1 < size1 || idx2 < size2) {
    		if(sum1 == sum2) return answer;
    		if(idx1 >= size1) {
    			if(sum1> sum2) {
    				
    				sum2 += queue2[idx1-size1];
    				sum1 -= queue2[idx1++ -size1];
    			}else {
    				sum1 += queue2[idx2];
    				sum2 -= queue2[idx2++];
    			}
    			
    		}else if(idx2 >= size2) {
    			if(sum1> sum2) {
    				sum2 += queue1[idx1];
    				sum1 -= queue1[idx1++];
    			}else {
    				sum1 += queue1[idx2-size2];
    				sum2 -= queue1[idx2++ - size2];
    			}
    			
    		}else {
    			
    			if(sum1> sum2) {
    				sum2 += queue1[idx1];
    				sum1 -= queue1[idx1++];
    			}else {
    				sum1 += queue2[idx2];
    				sum2 -= queue2[idx2++];
    			}
    		}
    		
    		answer++;
    		

    	}
    	
        return -1;
    }
}