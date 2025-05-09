import java.util.*;
import java.io.*;

class Solution {

    private static PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
    private static int answer = 0;
    public int solution(int[] priorities, int location) {
        for(int i = 0; i < priorities.length; i++){
            queue.add(priorities[i]);
        }
        
        process(location, priorities);
        return answer;
    }
    
    private static void process(int location, int[] p){
 
        while(!queue.isEmpty()){            
         
            for(int j = 0; j < p.length; j++){
                if(p[j] == queue.peek()){
                    queue.poll();
                    answer ++;
                    if(j == location){
                        return;
                    }
                    
                
                }
                
            }
        }
    }
}