import java.util.*;
import java.io.*;

public class Main {

    public static int M;
    public static int N;
    public static int H;

    public static int[] dx = {0,0,0,0,-1,1};
    public static int[] dy = {0,0,1,-1,0,0};
    public static int[] dz = {-1,1,0,0,0,0};
    public static int[][][] box = new int[101][101][101];

    public static Queue<Tomato> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        for(int i = 0; i < H; i++){
            for(int j = 0; j < N; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < M; k++){
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if(box[i][j][k] == 1){
                        queue.add(new Tomato(j,k,i,0));
                    }
                }
            }
        }

        bfs();
    }

    static void bfs(){
        int day = 0;

        while (!queue.isEmpty()){
            Tomato temp = queue.poll();
            day = temp.t;
            for(int i = 0; i < 6; i++){
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];
                int nz = temp.z + dz[i];

                if(check(nx,ny,nz)){
                    box[nz][nx][ny] = 1;
                    queue.add(new Tomato(nx,ny,nz, temp.t+1));
                }
            }
        }

        if(checkTomato()){
            System.out.print(day);
        }
        else{
            System.out.print(-1);
        }

    }

    static boolean checkTomato(){
        for(int i = 0; i < H; i++){
            for(int j = 0; j < N; j++){
                for(int k = 0; k < M; k++){
                    if(box[i][j][k] == 0){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    static boolean check(int x, int y, int z){
        return x >= 0 && x < N && y >= 0 && y < M && z >= 0 && z < H && box[z][x][y] == 0;
    }

    static class Tomato{
        int x;
        int y;
        int z;
        int t;

        public Tomato(int x, int y, int z, int t){
            this.x = x;
            this.y = y;
            this.z = z;
            this.t = t;
        }
    }
}
