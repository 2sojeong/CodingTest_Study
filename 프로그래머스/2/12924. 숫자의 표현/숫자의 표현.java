class Solution {
    public int solution(int n) {
        int answer = 0;
        int tep=0;
        for(int i=1;i<=n;i++){
            tep=0;
            for(int j=i;j<=n;j++){
                 tep += j;  
                if (tep == n) {  
                    answer += 1;
                    break;
                } else if (tep > n) {
                    break;
                }
            }
        }
        return answer;
    }
}