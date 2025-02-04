import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
          
       
        
        return search(times, n);
    }
    
    private static long search(int[] times, int n){
        long left = 0;
        long right = times[times.length-1] * (long)n;
        long answer = 0;
        
        while(left <= right){
            long mid = (left+right) / 2;
            
            if(check(times, mid, n)){
                answer = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1; 
            }
        }
        
        return answer;
    }
    
    private static boolean check(int times[], long mid, int  n){
        long amount = 0;
        
        for(int i = 0; i < times.length; i++){
            amount += mid/times[i];    
        }
        if(amount >= n) return true;
        else return false;
    }
}