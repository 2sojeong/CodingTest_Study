import java.util.*;
import java.io.*;

public class Main {
    private static int N;
    private static char[][] map;
    private static boolean[][] visit;
    private static int[] dx = {0,0,1,-1};
    private static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visit = new boolean[N][N];
        for(int i = 0; i < N; i++){
            String temp = br.readLine();
            for(int j = 0; j < N; j++){
                map[i][j] = temp.charAt(j);
            }
        }


        int nonnum = 0;
        int onnum = 0;
        // 적록 색약이 아닌 경우
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visit[i][j]){
                    non(i,j);
                    nonnum ++;
                }
            }
        }

        // 적록 색약인 경우
        visit = new boolean[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visit[i][j]){
                    on(i,j);
                    onnum ++;
                }
            }
        }

        System.out.print(nonnum+" "+onnum);



    }

    private static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    private static boolean check(int x, int y){
        return x >= 0 && y >= 0 && x < N && y < N && !visit[x][y];
    }
    private static void non(int x, int y){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x,y));
        visit[x][y] = true;

        while(!queue.isEmpty()){
            Node temp = queue.poll();
            for(int i = 0; i < 4; i++){
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];
                if(check(nx,ny) && map[x][y]==map[nx][ny]){
                    queue.add(new Node(nx,ny));
                    visit[nx][ny] = true;
                }

            }
        }

    }
    private static void on(int x, int y){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x,y));
        visit[x][y] = true;
        char c = map[x][y];
        while(!queue.isEmpty()){
            Node temp = queue.poll();

            for(int i = 0; i < 4; i++){
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];
                if(check(nx,ny)){
                    if(c == 'B' && c == map[nx][ny]){
                        queue.add(new Node(nx,ny));
                        visit[nx][ny] = true;
                    }

                    if(c == 'R' || c == 'G'){
                        if(map[nx][ny] == 'R' || map[nx][ny] == 'G'){
                            queue.add(new Node(nx,ny));
                            visit[nx][ny] = true;
                        }
                    }
                }

            }
        }

    }
    

}
