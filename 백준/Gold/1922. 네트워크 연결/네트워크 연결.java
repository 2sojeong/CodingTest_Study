import java.util.*;
import java.io.*;

public class Main {

    private static int N,M;
    private static class Node implements Comparable<Node>{
        int start;
        int end;
        int weight;

        public Node(int start, int end, int weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o){
            return this.weight - o.weight;
        }
    }

    private static int[] arr;
    private static PriorityQueue<Node> queue = new PriorityQueue<>();
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        arr = new int[N+1];
        for (int i = 1; i < N+1; i++){
            arr[i] = i;
        }

        StringTokenizer st;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            queue.add(new Node(a,b,c));
        }

        connect();
    }

    private static void connect(){
        int sum = 0;
        while(!queue.isEmpty()){
            Node temp = queue.poll();

            int na = find(temp.start);
            int nb = find(temp.end);
            int w = temp.weight;

            if(na != nb){
                union(na,nb);
                sum += w;
            }
        }
        System.out.print(sum);
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
        if(a == arr[a]){
            return a;
        }
            return arr[a] = find(arr[a]);

    }
}
