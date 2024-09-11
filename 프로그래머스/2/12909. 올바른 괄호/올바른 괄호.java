import java.io.*;
import java.util.Stack;
class Solution {
    boolean solution(String s) {
        Stack<Character> stack=new Stack<>();
        boolean answer = true;
        
         for(int j=0;j<s.length();j++){
                char ch=s.charAt(j);
                if(ch=='('){
                    stack.push(ch);
                }
                else{
                    if(stack.empty()){
                        stack.push(ch);
                        break;
                    }
                    else{
                        stack.pop();
                    }
                }
            }
            if(stack.empty()){
                answer=true;
            }
            else{
                answer=false;
            }
    return answer;
    }
}