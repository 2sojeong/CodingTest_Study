
import java.util.*;
import java.io.*;

public class Main {
    private static int N,K;
    private static boolean[] visit = new boolean[100001];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs();

    }

    private static void bfs(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(N,0));
        visit[N] = true;
        while (!queue.isEmpty()){

            Node temp = queue.poll();
            visit[temp.x] = true;

            if(temp.x == K){
                System.out.print(temp.t);
                return;
            }

            if(check(temp.x * 2)){
                if(!visit[temp.x*2]){
                    queue.add(new Node(temp.x*2, temp.t));

                }

            }

            if(check(temp.x - 1)){
                if(!visit[temp.x-1]){
                    queue.add(new Node(temp.x-1, temp.t+1));

                }

            }

            if(check(temp.x+1)){
                if(!visit[temp.x+1]){
                    queue.add(new Node(temp.x+1, temp.t+1));

                }

            }


        }
    }

    private static boolean check(int x){
        return x >= 0 && x <= 100000;
    }

    private static class Node{
        int x;
        int t;

        public Node(int x, int t){
            this.x = x;
            this.t = t;
        }
    }
}
