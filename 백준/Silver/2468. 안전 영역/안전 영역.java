import java.util.*;
import java.io.*;

public class Main {

    private static int N;
    private static int[][] map;
    private static StringTokenizer st;

    private static int answer = Integer.MIN_VALUE;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    private static int min = Integer.MAX_VALUE;
    private static int max = Integer.MIN_VALUE;

    private static int[][] cloneMap;

    private static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, map[i][j]);
                max = Math.max(max, map[i][j]);
            }
        }

        dfs(0);
        System.out.print(answer);

    }

    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void bfs(int x, int y) {
        visit[x][y] = true;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));

        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if (check(nx, ny)) {
                    visit[nx][ny] = true;
                    queue.add(new Node(nx, ny));
                }
            }
        }
    }

    private static boolean check(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N && cloneMap[x][y] != 0 && !visit[x][y];
    }

    private static void dfs(int start) {
        if (start > max) {
            return;
        }

        cloneMap = new int[N][N];
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            cloneMap[i] = map[i].clone();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                //물에 잠기는 부분은 0으로 표시
                if (map[i][j] <= start) {
                    cloneMap[i][j] = 0;
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                //0이 아닌 부분은 물에 잠기지 않은 영역
                if (cloneMap[i][j] != 0 && !visit[i][j]) {
                    cnt++;
                    bfs(i, j);
                }
            }
        }

        answer = Math.max(answer, cnt);
        dfs(start + 1);
    }
}
