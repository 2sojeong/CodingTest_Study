import java.io.*;
import java.util.*;
public class Main {

    private static int N,M;
    private static int[] robot = new int[3];
    private static int[][] map;

    // 북, 남, 서, 동
// 북, 동, 남, 서
    private static int[][] dt = {
            {-1, 0}, // 북
            {0, 1},  // 동
            {1, 0},  // 남
            {0, -1}  // 서
    };

    private static int answer = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        robot[0] = Integer.parseInt(st.nextToken());
        robot[1] = Integer.parseInt(st.nextToken());
        robot[2] = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

       clean();
    }

    private static void clean(){
        int x = robot[0];
        int y = robot[1];
        int dir = robot[2];
        while (true){

            // 1. 현재 칸이 청소되지 않은 경우, 현재 칸을 청소
            if(map[x][y] == 0){
                map[x][y] = 2;
                answer ++;

            }

            boolean cnt = false;
            // 4칸 탐색
            for(int i = 0; i < 4; i++){
                 dir = (dir+3)%4;
                 int nx = x + dt[dir][0];
                 int ny = y + dt[dir][1];
                if(check(nx,ny) && map[nx][ny] == 0){
                    x = nx;
                    y = ny;
                    cnt = true;
                    break;
                }

            }

            if(cnt) continue;
            // 2. 청소할 칸이 없는 경우
            if(cnt == false){

                int backdir = (dir+2)%4;
                int bx = x + dt[backdir][0];
                int by = y + dt[backdir][1];

                if(check(bx,by) && map[bx][by] != 1){
                    x = bx;
                    y = by;
                }
                else{
                    break;
                }
            }


        }

        System.out.print(answer);
    }


    private static boolean check(int x, int y){
        return x >= 0 && x < N && y>= 0 && y < M ;
    }
}
