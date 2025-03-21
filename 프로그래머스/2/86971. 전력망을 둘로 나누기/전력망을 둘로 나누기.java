import java.util.*;
import java.io.*;

class Solution {
    static int[][] map;
    static boolean[] visit;
    public int solution(int n, int[][] wires) {
        map = new int[n+1][n+1];
        visit = new boolean[n+1];
        int answer = n;
        for(int i = 0; i < wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            
            map[a][b] = 1;
            map[b][a] = 1;
        }
        
        for(int i = 0; i < wires.length; i++){
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            map[v1][v2] = 0;
            map[v2][v1] = 0;
            
            int result = bfs(v1,n);
            answer = Math.min(answer,result);
            map[v1][v2] = 1;
            map[v2][v1] = 1;
        }        
        
        return answer;
    }
    
    static int bfs(int x, int n){
        visit = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        visit[x] = true;
        queue.add(x);
        int cnt = 1;
        while(!queue.isEmpty()){
            int temp = queue.poll();
            
            for(int i = 1; i <= n ; i++){
                if(map[temp][i] == 1 && !visit[i]){
                    visit[i] = true;
                    cnt ++;
                    queue.add(i);
                }
            }
        }
        
        return (int)Math.abs(cnt - (n-cnt));
    }
}