import java.util.*;
import java.io.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        //i는 세로 , j는 가로
        for(int i = 3; i < total; i++){
            int j = total / i ;
            
            if (total % i == 0 && j >= 3){
                if(j < i){
                    continue;
                }
                if((j-2) * (i-2) == yellow){
                    answer[0] = j;
                    answer[1] = i;
                    return answer;
                }
            }
        }
        return answer;
    }
}