import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static int[][] map;
    private static int[][] answer;
    private static int answerX, answerY;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static boolean[][] visit;

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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        answer = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2) {
                    answerX = i;
                    answerY = j;
                    answer[i][j] = 0;
                }
            }
        }

        bfs(answerX,answerY);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 1 && !visit[i][j]){
                    System.out.print(-1+" ");
                    continue;
                }
                System.out.print(answer[i][j]+" ");
            }
            System.out.println();
        }


    }

    private static void bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        visit = new boolean[N][M];
        queue.add(new Node(x, y, 0));
        visit[x][y] = true;

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            answer[temp.x][temp.y] = temp.t;
            for (int i = 0; i < 4; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] != 0 && !visit[nx][ny]) {
                    queue.add(new Node(nx, ny, temp.t + 1));
                    visit[nx][ny] = true;
                }
            }

        }
    }
}
