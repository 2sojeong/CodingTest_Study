import java.io.*;
import java.util.*;
public class Main {
    private static int N,M,K;
    private static int[][] map;
    private static int[] dice = new int[]{0,1,2,3,4,5,6};
    // 동 : 0,  남 : 1 , 서 : 2, 북 : 3
    private static int[] dx = {0,1,0,-1};
    private static int[] dy = {1,0,-1,0};
    private static int dir = 0;
    private static int answer = 0;
    private static int x = 0, y = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve();
    }

    private static void solve(){
        for(int i = 0; i < K; i++){

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(nx < 0 || ny < 0 || nx >= N || ny >= M){
                dir = (dir + 2) % 4;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }

            rollDice(dir);
            x = nx;
            y = ny;
            answer += bfs(x,y);
            int A = dice[6];
            int B = map[x][y];

            if(A > B){
                dir += 1;
                if(dir == 4) dir = 0;
            }
            else if(A < B){
                dir -= 1;
                if(dir == -1) dir = 3;
            }
        }
        System.out.print(answer);
    }
    /*
        주사위 굴리는 함수
     */
    private static void rollDice(int dir){
        int temp;
        switch (dir){
            //동
            case 0 :
                temp = dice[1];
                dice[1] = dice[4];
                dice[4] = dice[6];
                dice[6] = dice[3];
                dice[3] = temp;
                break;

            //남
            case 1 :
                temp = dice[1];
                dice[1] = dice[2];
                dice[2] = dice[6];
                dice[6] = dice[5];
                dice[5] = temp;
                break;

            //서
            case 2 :
                temp = dice[1];
                dice[1] = dice[3];
                dice[3] = dice[6];
                dice[6] = dice[4];
                dice[4] = temp;
                break;

            //북
            case 3 :
                temp = dice[1];
                dice[1] = dice[5];
                dice[5] = dice[6];
                dice[6] = dice[2];
                dice[2] = temp;
                break;
        }
    }

    /*
        점수 탐색
     */
    private static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    private static int bfs(int x, int y){
        int cnt = 1;
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visit = new boolean[N][M];
        visit[x][y] = true;
        queue.add(new Node(x,y));

        while(!queue.isEmpty()){
            Node temp = queue.poll();

            for(int i = 0; i < 4; i++){
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < N && ny < M && !visit[nx][ny] && map[x][y] == map[nx][ny]){
                    visit[nx][ny] = true;
                    cnt ++;
                    queue.add(new Node(nx,ny));
                }
            }
        }
        return cnt * map[x][y];
    }

}
