import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer="";
        
        Map<String,Integer> part = new HashMap<>();
      
        
        for(int i = 0; i < participant.length; i++){
            if(part.containsKey(participant[i])){
               
                Integer temp = part.get(participant[i]);
                part.put(participant[i],temp+1);
            }
            else{
                part.put(participant[i],1);
            }
            
        }
        
        for(int i = 0; i < completion.length; i++){
            if(part.containsKey(completion[i])){
                part.put(completion[i],part.get(completion[i])-1);
            }
        }
        
        for(String s : part.keySet()){
            if(part.get(s) > 0){
                answer = s;
                break;
            }
        }

        
        return answer;
    }
}