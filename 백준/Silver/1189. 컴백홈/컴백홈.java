import java.util.*;
import java.io.*;

public class Main {
    private static int R;
    private static int C;
    private static int K;
    private static Character[][] arr;
    private static boolean[][] visit;

    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};
    private static int count = 0;

    private static class Node {
        int x;
        int y;
        int t;

        public Node(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }

    private static Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new Character[R][C];
        visit = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String temp = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = temp.charAt(j);
            }
        }
        visit[R - 1][0] = true;
        dfs(R - 1, 0, 1);
        System.out.print(count);
    }

    private static void dfs(int x, int y, int depth) {
        if (x == 0 && y == C - 1) {
            if (depth == K) count++;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < R && ny >= 0 && ny < C &&
                    !visit[nx][ny] && arr[nx][ny] != 'T') {

                visit[nx][ny] = true;
                dfs(nx, ny, depth + 1);
                visit[nx][ny] = false;
            }
        }
    }
}
