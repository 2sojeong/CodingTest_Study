import java.util.*;
import java.io.*;

class Solution {
    private static int[][] map;
    private static int answer = 0;
    public int solution(int n, int[][] results) {
        map = new int[n+1][n+1];
        
        for(int i = 0; i < results.length; i++){
            int winner = results[i][0];
            int looser = results[i][1];
            
            map[winner][looser] = 1;
            map[looser][winner] = -1;
        }
        find(n);
        return answer;
    }
    
    private static void find(int n){
         for(int x = 1; x < n+1; x++){
             for(int y = 1; y < n+1; y++){
                 for(int z = 1; z < n+1; z++){
                     if(map[x][y] == 1 && map[y][z] == 1){
                         map[x][z] = 1;
                         map[z][x] = -1;
                     }
                     if(map[x][y] == -1 && map[y][z] == -1){
                         map[x][z] = -1;
                         map[z][x] = 1;
                     }
                 }
             }
         } 
        
        
        for(int i = 1; i < n+1; i++){
            int cnt = 0;
            for(int j = 1; j < n+1; j++){
                if(map[i][j] != 0){
                    cnt ++;
                }
            }
            
            if(cnt == n-1) answer ++;
        }
        
    }
}