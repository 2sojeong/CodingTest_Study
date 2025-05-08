import java.util.*;
import java.io.*;

public class Main {
    private static int[] map;
    private static int N,M;
    private static class Node{
        int x;
        int t;

        public Node(int x, int t){
            this.x = x;
            this.t = t;
        }
    }
    private static Queue<Node> queue = new LinkedList<>();
    private static boolean[] visit = new boolean[101];
    public static void main(String[] args) throws IOException{
        map = new int[101];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x] = y;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            map[u] = v;
        }
        bfs();
    }

    private static void bfs(){
        queue.add(new Node(1,0));
        visit[1] = true;

        while(!queue.isEmpty()){
            Node temp = queue.poll();
            visit[temp.x] = true;

            if(temp.x == 100){
                System.out.print(temp.t);
                return;
            }

            int turn = temp.t + 1;

            if(check(temp.x+1)){
             if(map[temp.x+1] == 0){
                 queue.add(new Node(temp.x+1, turn));
             }
             else{
                 queue.add(new Node(map[temp.x+1],turn));
             }
            }
            if(check(temp.x+2)){
                if(map[temp.x+2] == 0){
                    queue.add(new Node(temp.x+2, turn));
                }
                else{
                    queue.add(new Node(map[temp.x+2],turn));
                }
            }
            if(check(temp.x+3)){
                if(map[temp.x+3] == 0){
                    queue.add(new Node(temp.x+3, turn));
                }
                else{
                    queue.add(new Node(map[temp.x+3],turn));
                }
            }
            if(check(temp.x+4)){
                if(map[temp.x+4] == 0){
                    queue.add(new Node(temp.x+4, turn));
                }
                else{
                    queue.add(new Node(map[temp.x+4],turn));
                }
            }
            if(check(temp.x+5)){
                if(map[temp.x+5] == 0){
                    queue.add(new Node(temp.x+5, turn));
                }
                else{
                    queue.add(new Node(map[temp.x+5],turn));
                }
            }
            if(check(temp.x+6)){
                if(map[temp.x+6] == 0){
                    queue.add(new Node(temp.x+6, turn));
                }
                else{
                    queue.add(new Node(map[temp.x+6],turn));
                }
            }


        }

    }

    private static boolean check(int x){
        return x >= 1 && x <= 100 && !visit[x];
    }
}
