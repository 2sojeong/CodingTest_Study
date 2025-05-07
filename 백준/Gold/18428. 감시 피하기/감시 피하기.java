import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static Character[][] map;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static int cntS = 0;
    private static int result = Integer.MAX_VALUE;

    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new Character[N][N];

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }

        bt(0);
        System.out.print("NO");

    }


    private static void bt(int depth) {
        if (depth == 3) {
            int cnt;
            boolean[][] visit = new boolean[N][N];
            Queue<Node> queue = new LinkedList<>();
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    if (map[x][y] == 'T') {
                        queue.add(new Node(x, y));
                    }
                }
            }


            cnt = bfs(queue);
            if (cnt == 0) {
                System.out.print("YES");
                System.exit(0);
            }
            result = Math.min(cnt, result);
            return;

        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'X') {
                    map[i][j] = 'O';
                    bt(depth + 1);
                    map[i][j] = 'X';
                }
            }
        }
    }

    private static int bfs(Queue<Node> queue) {
        cntS = 0;

        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if (check(nx, ny) && map[nx][ny] != 'O') {
                    findS(nx, ny, i);

                }
            }
        }
        return cntS;
    }

    private static boolean check(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }

    private static void findS(int x, int y, int dir) {
        if (map[x][y] == 'S') {
            cntS++;
            return;
        }

        x += dx[dir];
        y += dy[dir];
        if (check(x, y) && map[x][y] != 'O') {
            findS(x, y, dir);
        }
    }
}
