import java.util.*;
import java.io.*;
public class Main {
    private static int N,M;
    private static int[] arr;
    private static int total = 0;
    private static class Edge implements Comparable<Edge>{
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o){
            return this.weight - o.weight;
        }

    }

    private static PriorityQueue<Edge> queue = new PriorityQueue<>();
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1];

        for(int i = 1; i < N+1; i++){
            arr[i] = i;
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            queue.add(new Edge(a,b,c));
        }

        solve();
    }

    private static void solve(){
        int temp = 0 ;
        while(!queue.isEmpty()){
            Edge edge = queue.poll();

            int na = find(edge.start);
            int nb = find(edge.end);
            int w = edge.weight;

            if(na != nb){
                union(na,nb);
                total += w;
                temp = w;
            }
        }
        System.out.print(total - temp);
    }

    private static void union(int a, int b){
        if(a > b){
            arr[b] = a;
        }
        else{
            arr[a] = b;
        }
    }
    private static int find(int a){
        if(arr[a] == a){
            return a;
        }
        return arr[a] = find(arr[a]);
    }
}

