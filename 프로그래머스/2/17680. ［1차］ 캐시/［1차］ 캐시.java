import java.util.*;
import java.io.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        for(int i = 0; i < cities.length; i++){
            cities[i] = cities[i].toUpperCase();
        }
        
       int answer = caching(cities, cacheSize);
        return answer;
    }
    
    private static int caching(String[] cities,int cacheSize){
        int answer = 0;
        Queue<String> queue = new LinkedList<>();
        if(cacheSize == 0){
            return 5 * cities.length;
        }
        for(int i = 0; i < cities.length; i++){
          
            //캐시 공간 남아있을때
            if(queue.size() < cacheSize){
                
                 if(queue.contains(cities[i])){
                    queue.remove(cities[i]);
                    queue.offer(cities[i]);
                    answer += 1;
                }
                
                //cache miss 경우
                if(!queue.contains(cities[i])){
                    queue.offer(cities[i]);
                    answer += 5;
                }
            }
            
            //캐시가 다 찼을때
            else{
                //cache hit 경우
                if(queue.contains(cities[i])){
                    queue.remove(cities[i]);
                    queue.offer(cities[i]);
                    answer += 1;
                }
                
                //cache miss 경우
                if(!queue.contains(cities[i])){
                    queue.poll();
                    queue.offer(cities[i]);
                    answer += 5;
                }
            }
            
        }
        
        return answer;
    }
}