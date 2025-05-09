import java.io.*;
import java.util.*;

public class Main {
    private static int N,M;
    private static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        map = new int[N+1][N+1];

        StringTokenizer st;
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 1; j <= N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i <= N; i++) {
            map[i][i] = 1;
        }
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (map[i][k] == 1 && map[k][j] == 1) {
                        map[i][j] = 1;
                    }
                }
            }
        }

        st = new StringTokenizer(br.readLine());

        int[] city = new int[M];

        for(int i = 0; i < M; i++){
            city[i] = Integer.parseInt(st.nextToken());
        }

        int start = city[0];

        for(int i = 1; i < M; i++){
            if(map[start][city[i]] == 0){
                System.out.print("NO");
                System.exit(0);
            }
        }


        System.out.print("YES");
    }
}
