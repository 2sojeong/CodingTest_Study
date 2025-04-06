import java.io.*;
import java.util.*;

/*
    초기에 구름 위치 (N-1,0) (N-1,1) (N-2,0) (N-2,1)
    1. 구름 이동
    2. 구름 있는 칸 바구니 물 양 + 1
    3. 구름이 사라짐
    4. 물이 증가한 칸의 대각선 거리에 물이 있는 칸 수 만큼 + 물
    5. 구름이 있던 칸 제외 , 바구니 물의 양 2 이상이면 구름 생기고, 2 줄어듬
 */
public class Main {

    private static int N,M;
    private static int[][] map;
    private static boolean[][] visit;
    private static ArrayList<int[]> cloudidx = new ArrayList<>();
    private static int[] dx = {-1,-1,1,1};
    private static int[] dy = {-1,1,-1,1};
    private static final int[] move_dx = {0, -1, -1, -1, 0, 1, 1, 1}; // 1~8번 방향
    private static final int[] move_dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visit = new boolean[N][N];
        map = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cloudidx.add(new int[]{N-1,0});
        cloudidx.add(new int[]{N-1,1});
        cloudidx.add(new int[]{N-2,0});
        cloudidx.add(new int[]{N-2,1});


        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            moveCloud(dir,num);
            rain();
            plusWater();
            makeCloud();
        }

        getTotal();
    }

    /*
        구름 이동 함수
     */
    private static void moveCloud(int dir, int num){
        visit = new boolean[N][N];
        ArrayList<int[]> tempCloud = new ArrayList<>();

        for (int[] c : cloudidx) {
            int x = (c[0] + move_dx[dir - 1] * num) % N;
            int y = (c[1] + move_dy[dir - 1] * num) % N;

            if (x < 0) x += N;
            if (y < 0) y += N;

            tempCloud.add(new int[]{x, y});
            visit[x][y] = true;
        }

        cloudidx = tempCloud;
    }


    /*
        비 내리고 바구니 물 양 + 1
        구름 사라짐
     */
    private static void rain(){
        for(int[] temp  : cloudidx){
            map[temp[0]][temp[1]] += 1;
          
        }

    }

    /*
        대각선 물 바구니 수 체크
     */
    private static int checkWater(int x, int y){
        int cnt = 0;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

            if(map[nx][ny] != 0){
                cnt ++;
            }
        }

        return cnt;
    }
    /*
        물복사버그 마범
     */
    private static void plusWater(){
        for(int[] temp : cloudidx){
            int x = temp[0];
            int y = temp[1];

            int cnt = checkWater(x,y);

            map[x][y] += cnt;
        }
        cloudidx.clear();
    }

    /*
        2 이상에 구름 생김 && 2만큼 줄어듬
     */
    private static void makeCloud(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] >= 2 && !visit[i][j]){
                    map[i][j] -= 2;
                    cloudidx.add(new int[]{i,j});
                }
            }
        }
    }

    private static void getTotal(){
        int result = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                result += map[i][j];
            }
        }
        System.out.print(result);
    }
}
