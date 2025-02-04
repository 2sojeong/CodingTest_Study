import java.util.*;

class Solution {
   private static int answer = 0; 
    public int solution(int[] numbers, int target) {
        
        bfs(numbers,target,0,0);
        
        return answer;
    }

    
    private static void bfs(int[] numbers, int target,int depth, int result){
        if(depth == numbers.length){
            if(target == result){
                answer ++;
            }
            return;
        }
        
        int plus = result + numbers[depth];
        int minus = result - numbers[depth];
        
        bfs(numbers, target, depth+1, plus);
        bfs(numbers, target, depth+1, minus);
        
        
    }
    
 
    
}