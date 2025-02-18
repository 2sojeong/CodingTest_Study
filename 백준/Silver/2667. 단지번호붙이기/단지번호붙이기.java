import java.io.*;
import java.util.*;
public class Main {

    private static int N;
    private static int[][] map;
    private static int[] dx = {0,0,-1,1};
    private static int[] dy = {1,-1,0,0};
    private static boolean[][] visit;
    private static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N][N];

        for(int i = 0; i < N; i++){
            String temp = br.readLine();
            for(int j = 0; j < N; j++){
                map[i][j] = temp.charAt(j) - '0';
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 1 && !visit[i][j]) bfs(i,j);
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        for(Integer n : result){
            System.out.println(n);
        }

    }

    private static void bfs(int x, int y){
        visit[x][y] = true;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x,y));
        int cnt = 1;
        while(!queue.isEmpty()){
            Node temp = queue.poll();

            for(int i = 0; i < 4; i++){
               int nx = temp.x + dx[i];
               int ny = temp.y + dy[i];

               if(check(nx,ny)){
                   visit[nx][ny] = true;
                   queue.add(new Node(nx,ny));
                   cnt ++;
               }
            }

        }
        result.add(cnt);

    }

    private static boolean check(int x, int y){
        return x >= 0 && y >= 0 && x < N && y < N && !visit[x][y] && map[x][y] == 1;
     }

    private static class Node{
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;

        }
    }

}
