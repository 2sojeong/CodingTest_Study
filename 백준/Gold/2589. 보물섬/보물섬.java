import java.util.*;
import java.io.*;

public class Main {
    private static Character[][] map;
    private static int[] dx = {0,0,-1,1};
    private static int[] dy = {1,-1,0,0};
    private static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private static ArrayList<Node> landMap = new ArrayList<>();
    private static int count = 0;
    private static int result = Integer.MIN_VALUE;
    private static boolean[][] visit;
    private static int N,M;
    private static Queue<Node> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new Character[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                Character c = temp.charAt(j);
                map[i][j] = c;

                if (c == 'L') {
                    landMap.add(new Node(i, j));
                }
            }
        }

        for(Node start : landMap) {
            result = Math.max(result, bfs(start));
        }

        System.out.print(result);

    }

    private static int bfs(Node start) {
        count = 0;
        visit = new boolean[N][M];
        int[][] dis = new int[N][M];
        queue.add(new Node(start.x, start.y));
        visit[start.x][start.y] = true;
        while(!queue.isEmpty()) {
            Node temp = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < N && ny < M && !visit[nx][ny] && map[nx][ny] == 'L') {
                    visit[nx][ny] = true;
                    dis[nx][ny] = dis[temp.x][temp.y] + 1;
                    count = Math.max(count, dis[nx][ny]);
                    queue.add(new Node(nx,ny));
                }
            }
        }
        return count;
    }

}
