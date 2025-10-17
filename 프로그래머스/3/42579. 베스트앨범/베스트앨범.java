import java.util.*;


class Solution {
    private static class Node implements Comparable<Node>{
        int number;
        int plays;
        
        public Node(int n, int p) {
            this.number = n;
            this.plays = p;
        }
        
        public int compareTo(Node node) {
            if(this.plays == node.plays){
                return this.number - node.number;
            }
            return node.plays - this.plays;
        }
    }
    
    private static HashMap<String, PriorityQueue<Node>> map = new HashMap<>();
    private static Map<String, Integer> sum = new HashMap<>();
    
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        for(int i = 0; i < plays.length; i++) {
            map.putIfAbsent(genres[i], new PriorityQueue<>()); 
            map.get(genres[i]).add(new Node(i, plays[i]));
            
            sum.put(genres[i], sum.getOrDefault(genres[i],0) + plays[i]);
        }
        
        List<String> order = new ArrayList<>(sum.keySet());
        order.sort((a, b) -> sum.get(b) - sum.get(a));
        
        List<Integer> result = new ArrayList<>();
        
        for(String o : order) {
            PriorityQueue<Node> queue = map.get(o);
            
            int count = 0;
            
            while(!queue.isEmpty() && count < 2) {
                result.add(queue.poll().number);
                count++;
            }
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}