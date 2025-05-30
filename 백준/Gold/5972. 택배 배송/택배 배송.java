import java.io.*;
import java.util.*;

public class Main {
    private static int N,M;
    private static boolean[] visit;
    private static int[] dis;

    private static class Node implements Comparable<Node>{
        int to;
        int cost;

        public Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
        public int compareTo(Node t){
            return this.cost - t.cost;
        }
    }

    private static ArrayList<Node>[] graph;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        dis = new int[N+1];
        visit = new boolean[N+1];

        for(int i = 0; i <= N; i++){
            graph[i] = new ArrayList<>();
            dis[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to,cost));
            graph[to].add(new Node(from,cost));
        }

        find(1);
        System.out.print(dis[N]);
    }

    private static void find(int start){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start,0));
        dis[start] = 0;

        while(!queue.isEmpty()){
            Node temp = queue.poll();

            if(visit[temp.to]) continue;
            visit[temp.to] = true;

            for(Node next : graph[temp.to]){
                if(dis[next.to] > dis[temp.to] + next.cost){
                    dis[next.to] = dis[temp.to] + next.cost;

                    queue.add(new Node(next.to, dis[next.to]));
                }
            }
        }

    }
}
