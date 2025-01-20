
import java.util.*;
import java.io.*;

public class Main {


    public static int N;
    public static int K;
    

    public static int[] map = new int[1000001];

    public static boolean[] visit = new boolean[1000001];

    public static Queue<Node> queue = new LinkedList<>();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map[N] = 1;

        bfs();

    }

    static void bfs(){
        visit[N] = true;
        queue.add(new Node(N,0));

        while (!queue.isEmpty()){
            Node temp = queue.poll();
           
            if(temp.x == K) {
                System.out.println(temp.t);
                return;
            }
            int turn = temp.t + 1;
            if(check(temp.x + 1)){
                map[temp.x+ 1] = 1;
                visit[temp.x + 1] = true;
                queue.add(new Node(temp.x+1,turn));
            }
            if(check(temp.x - 1)){
                map[temp.x - 1] = 1;
                visit[temp.x - 1] = true;
                queue.add(new Node(temp.x- 1,turn));
            }
            if(check(temp.x * 2)){
                map[temp.x * 2] = 1;
                visit[temp.x * 2] = true;
                queue.add(new Node(temp.x * 2, turn ));
            }

        }

    }

    static boolean check(int n){
        return n >= 0 && !visit[n] && n <= 100000;
    }

    static class Node{
        int x;
        int t;

        public Node(int x, int t){
            this.x = x;
            this.t = t;
        }
    }
}
