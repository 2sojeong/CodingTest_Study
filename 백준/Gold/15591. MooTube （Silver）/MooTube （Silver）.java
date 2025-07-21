import java.util.*;
import java.io.*;
public class Main {
    private static int N, Q;
    private static List<List<Node>> graph = new ArrayList<>();
    private static class Node {
        int to;
        int usado;

        public Node(int to, int usado) {
            this.to = to;
            this.usado = usado;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, u));
            graph.get(b).add(new Node(a, u));
        }

        for(int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());

            int k = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            bfs(k,start);
        }
    }

    private static void bfs(int k, int start) {
        boolean[] visit = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();
        visit[start] = true;
        q.add(start);

        int count = 0;
        while(!q.isEmpty()) {
            int now = q.poll();

            for(Node next : graph.get(now)) {
                if(!visit[next.to] && next.usado >= k) {
                    visit[next.to] = true;
                    q.add(next.to);
                    count ++;
                }
            }
        }

        System.out.println(count);
    }
}
