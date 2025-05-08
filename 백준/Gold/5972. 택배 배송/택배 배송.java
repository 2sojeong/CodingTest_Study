import java.io.*;
import java.util.*;

public class Main {

    private static int N,M;
    private static int[] distance;
    private static class Node implements Comparable<Node>{
        int t;
        int weight;

        public Node(int t, int weight){
            this.t = t;
            this.weight = weight;
        }

        public int compareTo(Node node){
            return this.weight - node.weight;
        }
    }

    private static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        distance = new int[N+1];
        for(int i = 0; i < N+1; i++){
            graph.add(new ArrayList<>());
            distance[i] = Integer.MAX_VALUE;
        }
        distance[1] = 0;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b,c));
            graph.get(b).add(new Node(a,c));
        }

        find();
        System.out.print(distance[N]);
    }

    private static void find(){
            PriorityQueue<Node> queue = new PriorityQueue<>();
            queue.add(new Node(1,0));

            while(!queue.isEmpty()){
                Node now = queue.poll();

                for(Node next : graph.get(now.t)){
                    if(distance[next.t] > distance[now.t] + next.weight){
                        distance[next.t] = distance[now.t] + next.weight;
                        queue.add(new Node(next.t, distance[next.t]));
                    }
                }
            }
    }
}
