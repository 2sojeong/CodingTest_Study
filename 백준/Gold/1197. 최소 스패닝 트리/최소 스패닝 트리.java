import java.util.*;
import java.io.*;

public class Main {
    private static int V,E;
    private static boolean[] visit;

    private static List<Node>[] list;

    private static int ans = 0;
    private static class Node implements Comparable<Node>{
        int to;
        int cost;

        public Node(int t, int c){
            this.to = t;
            this.cost = c;
        }

        public int compareTo(Node o){
            return this.cost - o.cost;
        }
    }
    private static PriorityQueue<Node> queue = new PriorityQueue<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        visit = new boolean[V+1];
        list = new ArrayList[V+1];

        for(int i = 1; i <= V; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[from].add(new Node(to,cost));
            list[to].add(new Node(from,cost));

        }

        mst();
        System.out.print(ans);
    }

    private static void mst(){
        queue.add(new Node(1,0));

        while(!queue.isEmpty()){
            Node temp = queue.poll();
            int t = temp.to;
            int c = temp.cost;

            if(!visit[t]){
                visit[t] = true;
                ans += c;

                for(Node next : list[t]){
                    if(!visit[next.to]) queue.add(next);
                }
            }
        }
    }
}
