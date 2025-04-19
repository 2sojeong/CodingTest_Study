import java.util.*;

class Solution {
    
    private static char[] string;
    private static char[] temp;
    private static int answer = 0;
    public int solution(String s) {

        string = new char[s.length()];
        for(int i  = 0; i < string.length; i++){
            string[i] = s.charAt(i);
        }
       
        
        for(int i = 0; i < string.length; i++){
            rotateLeft();
            check();
        }
    
        return answer;
    }
    
    
    private static void rotateLeft(){
        temp = new char[string.length];
        for(int i = 0; i < string.length - 1; i++){
            temp[i] = string[i+1];
        }
        temp[string.length-1] = string[0];
        string = temp;
    }
    
    private static void check(){
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < temp.length; i++){
            char c = temp[i];
            if (stack.isEmpty()) {
                    stack.push(c);
                } else if (c == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if (c == '}' && stack.peek() == '{') {
                    stack.pop();
                } else if (c == ']' && stack.peek() == '[') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        
        if(stack.isEmpty()){
            answer ++;
        }
        }
    
}