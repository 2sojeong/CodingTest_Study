import java.util.*;
import java.io.*;

public class Main {

    public static int M;
    public static int N;
    public static int res;
    public static int[][] map = new int[1001][1001];
    public static boolean[][] visit = new boolean[1001][1001];

    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};

    public static Queue<Node> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }



        for(int i =0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 1){
                    queue.add(new Node(i,j,0));
                }
            }
        }

        bfs();
    }

    static void bfs(){
        int day = 0;
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            day = cur.d;
            for(int i = 0; i < 4; i++){
                int newx = cur.x + dx[i];
                int newy = cur.y + dy[i];

                if(check(newx, newy)){
                    map[newx][newy] = 1;
                    visit[newx][newy] = true;
                    queue.add(new Node(newx,newy, cur.d+1));
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

    static boolean checkTomato() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }
    static boolean check(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < M && !visit[x][y] && map[x][y] == 0;
    }
    static class Node{
        int x;
        int y;

        int d;

        public Node(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;

        }
    }
}
