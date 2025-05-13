import java.util.*;

class Solution {

    private static ArrayList<String> result = new ArrayList<>();
    private static HashMap<String,PriorityQueue<String>> map = new HashMap<>();
    
    public String[] solution(String[][] tickets) {
    
        for(int i = 0; i < tickets.length; i++){
            String from = tickets[i][0];
            String to = tickets[i][1];
            //없으면 큐 새로 만들기
            map.putIfAbsent(from, new PriorityQueue<>());
            map.get(from).add(to);
        }
        
        dfs("ICN");
        return result.toArray(new String[0]);
    }
    
    private static void dfs(String from){
        PriorityQueue<String> queue = map.get(from);
        
        while(queue != null && !queue.isEmpty() ){
            String to = queue.poll();
            dfs(to);
        }
        
        result.add(0,from);        
    }
}