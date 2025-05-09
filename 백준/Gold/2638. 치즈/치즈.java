import java.util.*;
import java.io.*;

public class Main {

    private static int N, M;
    private static int[][] map;
    private static boolean[][] visit;
    private static int totalCnt = 0;
    private static int time = 0;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int n = Integer.parseInt(st.nextToken());
                map[i][j] = n;
                if (n == 1) {
                    totalCnt++;
                    queue.add(new Node(i, j));
                }
            }
        }
        check();
    }

    private static void check() {
        while (totalCnt != 0) {
            time++;
            visit = new boolean[N][M];
            dfs(0, 0);
            melt();
        }
        System.out.print(time);
    }

    private static void melt() {
        Queue<Node> nextQueue = new LinkedList<>();
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            int cnt = 0;

            for (int i = 0; i < 4; i++) {

                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if (map[nx][ny] == 2) {
                    cnt++;
                }
            }

            if(cnt >= 2){
                map[temp.x][temp.y] = 0;
                totalCnt --;
            }
            //녹지 않은 치즈는 다음 큐에 사용하기 위해 저장
            else{
                nextQueue.add(temp);
            }
        }
        
        //안 녹은 치즈 저장
        queue = nextQueue;
    }

    private static void dfs(int x, int y) {
        visit[x][y] = true;
        map[x][y] = 2;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if (visit[nx][ny] || map[nx][ny] == 1) continue;

            dfs(nx, ny);
        }
    }
}
