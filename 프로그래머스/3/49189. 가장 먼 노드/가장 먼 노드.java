import java.io.*;
import java.util.*;

class Solution {
    private static ArrayList<ArrayList<Node>> map = new ArrayList<>();
    private static int maxD = Integer.MIN_VALUE;
    
    private static class Node implements Comparable<Node>{
        int v;
        int w;
        
        public Node(int v, int w){
            this.v = v;
            this.w = w;
        }
        
        public int compareTo(Node o){
            return this.w - o.w;
        }
    }
    private static PriorityQueue<Node> queue = new PriorityQueue<>();
    private static int[] distance;
    private static int answer = 0;
    public int solution(int n, int[][] edge) {
        distance = new int[n + 1];
    
        for(int i = 0; i < n + 1; i++){
            map.add(new ArrayList<>());
            distance[i] = Integer.MAX_VALUE;
        }
        distance[1] = 0;
        for(int i = 0; i < edge.length; i++){
            int a = edge[i][0];
            int b = edge[i][1];
            int weight = 1;
            map.get(a).add(new Node(b,weight));
            map.get(b).add(new Node(a,weight));
        }
        find();
        for(int t : distance){
            if(t == maxD)
            answer ++;
        }
        return answer;
    }
    
    private static void find(){
        queue.add(new Node(1,0));
        while(!queue.isEmpty()){
            Node now = queue.poll();
            
            for(Node next : map.get(now.v)){
                if(distance[next.v] > distance[now.v] + next.w){
                    distance[next.v] = distance[now.v] + next.w;
                    maxD = Math.max(maxD, distance[next.v]);
                    queue.add(new Node(next.v, distance[next.v]));
                }
            }
        }
    }
}