import java.io.*;
import java.util.*;

class Solution {
    
    public static boolean[][] visit = new boolean[101][101];
    public static int res;
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
    public static int N;
    public static int M;
    
    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;

        
        bfs(maps);
        if(res == 0){
            return -1;
        }
        return res;
    }
    
    static void bfs(int[][] map){
        Queue<Node> queue = new LinkedList<>();
        visit[0][0] = true;
        queue.add(new Node(0,0,1));
        
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            
            if(cur.x == N-1 && cur.y == M-1){
                res = cur.t;
            }
            
            for(int i = 0; i < 4; i++){
                int x = cur.x + dx[i];
                int y = cur.y + dy[i];
                
                if(check(x,y,map)){
                    visit[x][y]=true;
                    queue.add(new Node(x,y,cur.t + 1));
                }
            }
        }
    }
    
    static boolean check(int x, int y, int[][] map){
        return x >= 0 && x < N && y >= 0 && y < M && !visit[x][y] && map[x][y] == 1;
    }
    
    static class Node {
        int x;
        int y;
        int t;
        
        public Node (int x, int y, int t){
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }
}