import java.util.*;
import java.io.*;

public class Main {
    private static int N, M;
    private static int[][] map;
    private static boolean[][][] visit;

    private static int[] dx = {0,0,1,-1};
    private static int[] dy = {1,-1,0,0};

    private static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visit = new boolean[2][N][M];
        for(int i = 0; i < N; i++){
            String temp = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = temp.charAt(j) - '0';
            }

        }



        answer = -1;
        dfs(0,0);
        System.out.print(answer);
    }

    private static void dfs(int x, int y){

        visit[0][x][y] = true;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x,y,1,false));

        while(!queue.isEmpty()){
            Node temp = queue.poll();

            if(temp.x == N-1 && temp.y == M-1){
                answer = temp.t;
                return;
            }

            for(int i = 0; i < 4; i++){
                int nx = dx[i] + temp.x;
                int ny = dy[i] + temp.y;

                if(check(nx,ny)){

                    // 1. 벽일때
                    if(map[nx][ny] == 1){
                        // 방문하지 않았을 때 + 아직 벽을 안부섰을때
                        if(!temp.broke){
                            visit[1][nx][ny] = true;
                            queue.add(new Node(nx,ny,temp.t +1,true));
                        }
                    }

                    // 2. 벽이 아닌 경우
                    if(map[nx][ny] == 0){
                        //한번도 안부수고 진행
                        if(!temp.broke){
                            if(!visit[0][nx][ny]){
                                visit[0][nx][ny] = true;
                                queue.add(new Node(nx,ny,temp.t+1,false));
                            }
                        }
                        //한번 부수고 진행
                        else{
                            if(!visit[1][nx][ny]){
                                visit[1][nx][ny] = true;
                                queue.add(new Node(nx,ny, temp.t+1, true));
                            }
                        }
                    }
                }
            }
        }

    }

    private static boolean check(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    private static class Node{
        int x;
        int y;
        int t;

        boolean broke;

        public Node(int x, int y, int t, boolean broke){
            this.x = x;
            this.y = y;
            this.t = t;
            this.broke = broke;
        }
    }
}