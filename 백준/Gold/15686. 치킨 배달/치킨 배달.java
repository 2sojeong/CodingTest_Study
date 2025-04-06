import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static boolean[] visit;
    private static int[][] map;
    private static ArrayList<int[]> home = new ArrayList<>();
    private static ArrayList<int[]> chickenHome = new ArrayList<>();
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int temp = Integer.parseInt(st.nextToken());
                map[i][j] = temp;

                //집 좌표 저장
                if(temp == 1){
                    home.add(new int[]{i,j});
                }

                //치킨집 좌표 저장
                if(temp == 2){
                    chickenHome.add(new int[]{i,j});
                }
            }
        }

        visit = new boolean[chickenHome.size()];

        bt(0,0);

        System.out.print(answer);
    }


    private static void bt(int depth, int start){
        if(depth == M){
            answer = Math.min(answer,count());
        }

        for(int i = start; i < chickenHome.size(); i++){
            if(!visit[i]){
                visit[i] = true;
                bt(depth + 1, i+1);
                visit[i] = false;
            }
        }


    }
    private static int count(){
        int result = 0;
        for(int i = 0; i < home.size(); i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < chickenHome.size(); j++){
                if(visit[j]){
                    int[] homeidx = home.get(i);
                    int[] chickenidx = chickenHome.get(j);

                    int minTemp = Math.abs(homeidx[0] - chickenidx[0]) + Math.abs(homeidx[1] - chickenidx[1]);

                    min = Math.min(min, minTemp);
                }
            }
            result += min;
        }
        return result;
    }
}
