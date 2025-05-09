import java.util.*;

class Solution {
    private static ArrayList<String> routes = new ArrayList<>();
    private static boolean[] visit;
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        Arrays.sort(tickets,(a,b) -> a[1].compareTo(b[1]));
        visit = new boolean[tickets.length];
        dfs(0,"ICN","ICN", tickets);

        
        answer = routes.get(0).split(" ");
        return answer;
    }
    
    private static void dfs(int cnt, String start, String route, String[][] t){
        if(cnt == t.length){
            routes.add(route);
            return;
        }
   
        for(int i = 0; i < t.length; i++){
            if(start.equals(t[i][0]) && !visit[i]){
                visit[i] = true;
                dfs(cnt+1, t[i][1], route+" "+t[i][1], t);
                visit[i] = false;
            }
        }
    }
}