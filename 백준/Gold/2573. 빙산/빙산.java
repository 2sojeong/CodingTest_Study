import java.util.*;
import java.io.*;

public class Main {
    private static int N, M;
    private static int[][] map;
    private static boolean[][] visit;
    private static int[] dx = {0,0,1,-1};
    private static int[] dy = {1,-1,0,0};
    private static int answer = 1;
    private static class Node{
        int x;
        int y;
        int t;

        public Node(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visit = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;
        while(true) {
            answer = 0;
            visit = new boolean[N][M];

            // 덩어리 수 세기
            for(int i = 0; i < N; i++) {
                for(int j = 0 ; j < M; j++) {
                    if(map[i][j] != 0 && !visit[i][j]) {
                        bfs(i,j);
                        answer ++;
                    }
                }
            }

            if(answer == 0){ // 빙산이 없는 경우
                System.out.print(0);
                return;
            }

            if(answer >= 2) { // 빙산이 두 덩어리 이상
                System.out.print(year);
                break;
            }

            // 빙산 녹이기
            melt();
            year ++;

        }

    }

    private static void bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x,y,0));
        visit[x][y] = true;

        while(!queue.isEmpty()) {
            Node temp = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if(check(nx,ny)) {
                    queue.add(new Node(nx,ny,temp.t + 1));
                    visit[nx][ny] = true;
                }

            }
        }
    }

    // 갈 수 있는 위치인지 확인
    private static boolean check(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M && !visit[x][y] && map[x][y] != 0;
    }

    private static void melt() {
        int[][] tempMap = new int[N][M];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] > 0) {
                    int sea = 0;

                    for(int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if(nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0) {
                            sea ++;
                        }
                    }

                    tempMap[i][j] = Math.max(0, map[i][j] - sea);
                }
            }
        }

        map = tempMap;
    }
}
