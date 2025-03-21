class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        // i 가로, j 세로
        for(int i = 3; i < total; i++){
            int j = total / i;
            
            if(j > i){
                continue;
            }
            if(total % i == 0 && j >= 3){
                if((i-2)*(j-2) == yellow){
                    answer[0] = i;
                    answer[1] = j;
                    return answer;
                }
            }
        }
        return answer;
    }
}