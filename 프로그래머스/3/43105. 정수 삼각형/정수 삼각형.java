import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.util.StringTokenizer;  
class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        
        for (int i = 1; i < n; i++) {  
            for (int j = 0; j <= i; j++) {  
                if (j == 0) {
                    triangle[i][j] += triangle[i - 1][j];  
                } else if (j == i) {
                    triangle[i][j] += triangle[i - 1][j - 1];  
                } else {
                    triangle[i][j] += Math.max(triangle[i - 1][j], triangle[i - 1][j - 1]);  
                }
            }
        }
        
      
        int max = triangle[n - 1][0];
        for (int i = 1; i < n; i++) {  
            if (max < triangle[n - 1][i]) {  
                max = triangle[n - 1][i];  
            }  
        }  
        
        return max;  
    }
}

