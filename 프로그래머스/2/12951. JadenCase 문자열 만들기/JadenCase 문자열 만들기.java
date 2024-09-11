class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        boolean isFirstChar = true;  

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == ' ') {
                answer.append(ch);
                isFirstChar = true;  
            } else if (isFirstChar) {
                answer.append(Character.toUpperCase(ch)); 
                isFirstChar = false;
            } else {
                answer.append(Character.toLowerCase(ch));  
            }
        }

        return answer.toString();
    }
}