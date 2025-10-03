import java.util.*;
import java.io.*;

public class Main {
    private static int F,S,G,U,D;
    private static class Node{
        int floor;
        int depth;

        public Node(int f, int d) {
            this.floor = f;
            this.depth = d;
        }
    }
    private static Queue<Node> queue = new LinkedList<>();
    private static int[] map;
    private static int answer = -1;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[F+1];

        bfs();
        System.out.print(answer == -1 ? "use the stairs" : answer);
    }

    private static void bfs() {
        queue.add(new Node(S,0));

        while(!queue.isEmpty()) {
            Node temp = queue.poll();

            if(temp.floor == G) {
                answer = temp.depth;
                return;
            }

            int tempU = temp.floor + U;
            int tempD = temp.floor - D;
            if(tempU <= F && map[tempU] == 0) {
                map[tempU] = 1;
                queue.add(new Node(tempU, temp.depth+1));
            }

            if(tempD >= 1 && map[tempD] == 0) {
                map[tempD] = 1;
                queue.add(new Node(tempD, temp.depth+1));
            }
        }
    }
}
