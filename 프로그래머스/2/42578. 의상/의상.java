import java.util.*;

class Solution {
    private static HashMap<String,Integer> map = new HashMap<>();
    public int solution(String[][] clothes) {
        int answer = 1;
        for(int i = 0; i < clothes.length; i++){
    
            String type = clothes[i][1];
            map.put(type,map.getOrDefault(type,0) + 1);
        }
        
        for(int count : map.values()){
            answer *= (count+1);
        }
        
        return answer - 1;
    }
}