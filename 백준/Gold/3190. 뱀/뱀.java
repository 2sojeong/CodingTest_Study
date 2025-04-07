import java.util.*;
import java.io.*;

/*
    1. 시작 위치ㅣ 0,0
    2. 방향으로 + 1씩 이동
    3. 사과를 만나면 사과제거 후 길이 늘어남
    4. 벽 or 자기 몸에 닿으면 끝
 */
public class Main {
    // 보드 크기, 사과 수, 변환 횟수
    private static int N, K, L;
    private static int[][] board;
    private static ArrayList<int[]> appleIndex = new ArrayList<>();
    private static HashMap<Integer, String> change = new HashMap<>();
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            board[x][y] = 2;
            appleIndex.add(new int[]{x, y});
        }

        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String direction = st.nextToken();

            change.put(time, direction);
        }


        move();
    }


    /*
        이동하는 함수
     */
    private static void move() {
        int x = 0;
        int y = 0;
        int dir = 0;
        int time = 0;
        queue.add(0);
        while (true) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            time++;

            if (nx < 0 || ny < 0 || nx > N - 1 || ny > N - 1 || queue.contains(nx * N + ny)) {
                break;
            }
            if (board[nx][ny] == 2) {
                board[nx][ny] = 0;
                queue.add(nx * N + ny);
            } else {
                queue.add(nx * N + ny);
                queue.poll();
            }

            if (change.containsKey(time)) {
                String temp = change.get(time);
                if (temp.equals("D")) {
                    dir += 1;
                    if (dir == 4) dir = 0;
                } else {
                    dir -= 1;
                    if (dir == -1) dir = 3;
                }
            }
            x = nx;
            y = ny;
        }
        System.out.print(time);

    }


}
