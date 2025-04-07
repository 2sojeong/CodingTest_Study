import java.util.*;
import java.io.*;

public class Main {
    private static int N,M,K;
    private static int[][] map;
    private static int[] order;
    private static int[] mapdx = {0,0,-1,1};
    private static int[] mapdy = {1,-1,0,0};
    private static int[] dice = new int[]{0,0,0,0,0,0,0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        order = new int[K];
        map = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++){
            order[i] = Integer.parseInt(st.nextToken());
        }
        solve(x,y);
    }

    private static void solve(int x, int y){
        for(int o : order){
            //지도
            int mapnx = x + mapdx[o-1];
            int mapny = y + mapdy[o-1];

            if(mapnx < 0 || mapny < 0 || mapnx >= N || mapny >= M){
                continue;
            }

            rollDice(o);

            if(map[mapnx][mapny] == 0){
                map[mapnx][mapny] = dice[6];
            }
            else{
                dice[6] = map[mapnx][mapny];
                map[mapnx][mapny] = 0;
            }
            x = mapnx;
            y = mapny;
            System.out.println(dice[1]);
        }
    }

    private static void rollDice(int dir){
        int temp;
        switch (dir){
            //오른쪽
            case 1:
                temp = dice[1];
                dice[1] = dice[4];
                dice[4] = dice[6];
                dice[6] = dice[3];
                dice[3] = temp;
                break;

            case 2:
                temp = dice[1];
                dice[1] = dice[3];
                dice[3] = dice[6];
                dice[6] = dice[4];
                dice[4] = temp;
                break;

            case 3:
                temp = dice[1];
                dice[1] = dice[5];
                dice[5] = dice[6];
                dice[6] = dice[2];
                dice[2] = temp;
                break;

            case 4:
                temp = dice[1];
                dice[1] = dice[2];
                dice[2] = dice[6];
                dice[6] = dice[5];
                dice[5] = temp;
                break;

        }
    }
}
