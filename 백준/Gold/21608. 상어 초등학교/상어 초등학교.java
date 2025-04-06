import java.io.*;
import java.util.*;

/*
    1. 좋아하는 학생이 많은 수 (내림차순)
    2. 빈 칸이 많은 수 (내림차순)
    3. 행의 번호가 작은 수 (오름차순)
    4. 열의 번호가 작은 수 (오름차순)
  --------------------------------
  필요한 함수
    N = 교실의 크기
    int[] student = 학생 번호
    int[][] map = 교실 자리
    int[][] favorite = 좋아하는 학생 배열
    int[] dx = 방향
    int[] dy = 방향
    class Seat = 좌표, 친구, 빈 칸 저장하는 클래스
    PriorityQueue = 우선순위 큐로 자리 배치할 좌표 저장

 */
public class Main {
    private static int N;
    private static int[] student;
    private static int[][] map;
    private static int[][] favorite;

    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    private static class Seat implements Comparable<Seat> {
        int x;
        int y;
        int friendCnt;
        int emptyCnt;

        public Seat(int x, int y, int friendCnt, int emptyCnt) {
            this.x = x;
            this.y = y;
            this.friendCnt = friendCnt;
            this.emptyCnt = emptyCnt;
        }

        @Override
        public int compareTo(Seat o) {
            if (friendCnt != o.friendCnt) return -(friendCnt - o.friendCnt);

            if (emptyCnt != o.emptyCnt) return -(emptyCnt - o.emptyCnt);

            if (x != o.x) return x - o.x;

            return y - o.y;
        }

    }

    private static PriorityQueue<Seat> queue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        student = new int[N * N];
        map = new int[N][N];
        favorite = new int[N * N+1][4];

        for (int i = 0; i < N * N; i++) {
            st = new StringTokenizer(br.readLine());

            int studentNum = Integer.parseInt(st.nextToken());
            student[i] = studentNum;

            favorite[studentNum][0] = Integer.parseInt(st.nextToken());
            favorite[studentNum][1] = Integer.parseInt(st.nextToken());
            favorite[studentNum][2] = Integer.parseInt(st.nextToken());
            favorite[studentNum][3] = Integer.parseInt(st.nextToken());
        }
        solve();

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result += getScore(i, j);
            }
        }
        System.out.print(result);
    }

    private static int getScore(int x, int y) {
        int number = map[x][y];
        int nx, ny, cnt = 0;

        for (int a : favorite[number]) {
            for (int i = 0; i < 4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                if (map[nx][ny] == a) {
                    cnt++;
                }

            }
        }
        return calculate(cnt);
    }

    private static int calculate(int cnt) {
        if (cnt == 0)
            return 0;
        if (cnt == 1)
            return 1;
        if (cnt == 2)
            return 10;
        if (cnt == 3)
            return 100;
        return 1000;
    }

    private static void solve() {
        for (int i = 0; i < student.length; i++) {
            makeSit(student[i]);
            queue.clear();
        }
    }

    private static void makeSit(int number) {
        int near, friend;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                near = 0;
                friend = 0;
                if (map[i][j] != 0) continue;

                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                    for (int a : favorite[number]) {
                        if (a == map[nx][ny]) {
                            friend++;
                        }
                    }

                    if (map[nx][ny] == 0) {
                        near++;
                    }
                }
                queue.add(new Seat(i, j, friend, near));
            }
        }

        Seat cur = queue.poll();
        map[cur.x][cur.y] = number;
    }

}