import java.security.Key;
import java.util.*;
import java.io.*;

public class Main {

    private static int N, M, K;
    private static int[][] map;
    private static boolean[][][] visit;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static int answer = -1;

    private static class Node {
        int x;
        int y;
        int d;
        int cnt;

        public Node(int x, int y, int d, int cnt) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visit = new boolean[K + 1][N][M];

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = temp.charAt(j) - '0';
            }
        }
        try{
            bfs();
            System.out.print(answer);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private static void bfs() {
        visit[0][0][0] = true;
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(0, 0, 1, 0));

        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            if (temp.x == N - 1 && temp.y == M - 1) {
                answer = temp.d;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if (check(nx, ny)) {

                    //벽이 아닌 경우
                    if (map[nx][ny] == 0 && !visit[temp.cnt][nx][ny]) {
                        visit[temp.cnt][nx][ny] = true;
                        queue.add(new Node(nx, ny, temp.d + 1, temp.cnt));
                    }
                    //벽인 경우
                    if (map[nx][ny] == 1 && temp.cnt < K && !visit[temp.cnt + 1][nx][ny]) {
                        visit[temp.cnt + 1][nx][ny] = true;
                        queue.add(new Node(nx, ny, temp.d + 1, temp.cnt + 1));

                    }

                }
            }
        }
    }

    private static boolean check(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }

}
