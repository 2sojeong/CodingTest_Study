import java.util.*;

class Solution {
    ArrayList<Integer> num = new ArrayList<>();
    private static int answer = 0;
    public int solution(int[] citations) {
        
        for(int i = 0; i < citations.length; i++){
            num.add(citations[i]);
        }
        Arrays.sort(citations);
        find(citations);
        return answer;
    }
    
    private static void find(int[] citations){
        for(int i = 0; i < citations.length; i++){
            int h = citations.length - i;
            
            if(citations[i] >= h){
                answer = h;
                return;
            }
        }
    }
}