import java.io.*;
import java.util.*;

public class Main {

    private static int N, M;
    private static int[][] map;
    private static int[] dx = {0,0,1,-1};
    private static int[] dy = {1,-1,0,0};
    private static class Node {
        int x;
        int y;
        int t;

        public Node (int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }
    private static Queue<Node> queue = new LinkedList<>();
    private static boolean[][] visit;
    private static BufferedReader br;
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visit = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            String temp = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = temp.charAt(j) - '0';
            }
        }
        bfs();
    }

    private static void bfs() {
        queue.add(new Node(0,0,1));
        visit[0][0] = true;

        while(!queue.isEmpty()) {
            Node temp = queue.poll();

            if(temp.x == N - 1 && temp.y == M - 1) {
                System.out.print(temp.t);
                return;
            }
            for(int i = 0; i < 4; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if(check(nx,ny)) {
                    visit[nx][ny] = true;
                    queue.add(new Node(nx,ny,temp.t + 1));
                }
            }
        }
    }

    private static boolean check(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M && !visit[x][y] && map[x][y] == 1;
    }
}
