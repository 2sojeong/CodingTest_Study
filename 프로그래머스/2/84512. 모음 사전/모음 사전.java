import java.util.*;
import java.io.*;

class Solution {
    private static String[] alpha= {"A", "E", "I","O","U"};
    private static ArrayList<String> list = new ArrayList<>();
    
    public int solution(String word) {
        
        int answer = 0;
        bt(0,"");
        Collections.sort(list);
        answer = list.indexOf(word) + 1;
        return answer;
    }
    
    private static void bt(int depth, String str){
        if(depth >= 5){
            return;
        }
        for(int i = 0; i < 5; i++){
            list.add(str+alpha[i]);
            bt(depth+1, str+alpha[i]);
        }
    }
}