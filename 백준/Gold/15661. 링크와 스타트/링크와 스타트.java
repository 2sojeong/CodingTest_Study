import java.util.*;
import java.io.*;
public class Main {

    private static int N;
    private static boolean[] visit;
    private static int[][] map;
    private static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        visit = new boolean[N+1];
        map = new int[N+1][N+1];

        for(int i = 1; i < N+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < N+1; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i < N; i++){
            bt(1,0,i);
        }
        System.out.print(answer);
    }


    private static void bt(int start, int depth, int len){

        if(len == N){
            answer = Math.min(answer,count());
            return;
        }

        for(int i = start; i < N+1; i++){
            if(!visit[i]){
                visit[i] = true;
                bt(i+1,depth+1,len+1);
                visit[i] = false;
            }
        }
    }


    private static int count(){
        int start = 0;
        int link = 0;

        for(int i = 1; i < N+1; i++){
            for(int j = i+1; j <N+1; j++){
                if(visit[i] != visit[j]) continue;

                if(visit[i]){
                    start += map[i][j] + map[j][i];
                }
                else{
                    link += map[i][j] + map[j][i];
                }
            }
        }



        return Math.abs(start - link);
    }

}

