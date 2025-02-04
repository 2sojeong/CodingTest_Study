import java.util.*;


class Solution {
    private static int[][] map;
    
    public int solution(int n, int[][] wires) {
        map = new int[n+1][n+1];
        int answer = n;

        for(int i = 0; i < wires.length; i++){
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            map[v1][v2] = 1;
            map[v2][v1] = 1;
        }
        
        for(int i = 0; i < wires.length; i++){
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            map[v1][v2] = 0;
            map[v2][v1] = 0;
            
            answer = Math.min(answer,bfs(n,v1));
            
            map[v1][v2] = 1;
            map[v2][v1] = 1;
            
        }
        
        
        return answer;
    }
    
    private static int bfs(int n, int x){
        boolean[] visit = new boolean[n+1];
        int cnt = 1;
        
        Queue<Integer> queue = new LinkedList<>();
        visit[x] = true;
        queue.add(x);
        
        while(!queue.isEmpty()){
            int temp = queue.poll();
            
            for(int i = 1; i <= n; i++){
                if(map[temp][i] == 1 && !visit[i]){
                    visit[i] = true;
                    queue.add(i);
                    cnt ++;
                }
            }
        }
        
        return (int)Math.abs(cnt - (n-cnt));
    }
}