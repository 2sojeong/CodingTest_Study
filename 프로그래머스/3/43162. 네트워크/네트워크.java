import java.util.*;



class Solution {
    private static boolean[] visit = new boolean[201];
    private static Queue<Integer> queue = new LinkedList<>();
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        for(int i = 0; i < n; i++){
            if(!visit[i]){
                bfs(n,computers,visit,i);
                answer +=1;
            }
        }
        return answer;
    }
    
    private static void bfs(int n, int[][] computers, boolean[] visit, int v){
        visit[v] = true;
        queue.add(v);
        
        while(!queue.isEmpty()){
            Integer temp = queue.poll();
            
            for(int i = 0; i < n; i++){
                if(computers[temp][i] == 1 && !visit[i]){
                    queue.add(i);
                    visit[i] = true;
                }
            }
        }
        
    }
}