import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int M;

    public static boolean[][] visit=new boolean[101][101];

    public static int[][] map=new int[101][101];

    public static int res;

    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= N; i++){
            String temp = br.readLine();
            for(int j = 1; j <= M ; j++){
                map[i][j] = temp.charAt(j-1) - '0';
            }
        }

  

        bfs();
        System.out.print(res);


    }

    static void bfs(){
        Queue<Node> queue = new LinkedList<>();
        visit[1][1] = true;
        queue.add(new Node(1,1,1));

        while (!queue.isEmpty()){

            Node cur = queue.poll();

            if(cur.x == N && cur.y == M){
                res = cur.t;
            }
            for(int i = 0; i < 4; i++){
                int x = cur.x + dx[i];
                int y = cur.y + dy[i];

                if(check(x,y)){
                    visit[x][y] = true;
                    queue.add(new Node(x,y,cur.t +1));
                }

            }
        }
    }

    static boolean check(int x, int y){
        return x >= 1 && x <= N && y >=1 && y <= M && !visit[x][y] && map[x][y] == 1;
    }

    static class Node {
        int x;
        int y;
        int t;

        public Node(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }
}
