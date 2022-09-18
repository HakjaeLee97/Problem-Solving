class Solution {
    public String solution(String[] survey, int[] choices) {
    	String answer = "";
    	int[] result = new int[4];
    	for(int i = 0, size = survey.length; i<size; i++) {
    		switch(survey[i].charAt(0)) {
    		case 'R':
    			result[0] -= choices[i]-4;
    			break;
    		case 'T':
    			result[0] += choices[i]-4;
    			break;
    		case 'C':
    			result[1] -= choices[i]-4;
    			break;
    		case 'F':
    			result[1] += choices[i]-4;
    			break;
    		case 'J':
    			result[2] -= choices[i]-4;
    			break;
    		case 'M':
    			result[2] += choices[i]-4;
    			break;
    		case 'A':
    			result[3] -= choices[i]-4;
    			break;
    		case 'N':
    			result[3] += choices[i]-4;
    			break;
    		}
    	}
    	if(result[0] >= 0) answer+="R";
    	else answer+="T";
    	if(result[1] >= 0) answer+="C";
    	else answer+="F";
    	if(result[2] >= 0) answer+="J";
    	else answer+="M";
    	if(result[3] >= 0) answer+="A";
    	else answer+="N";
    	
    	
        return answer;
    }
}