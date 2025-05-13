import java.util.*;
import java.io.*;
public class Main {
    private static int N,M;
    private static Character[][] map;
    private static int[] dx = {0,0,1,-1};
    private static int[] dy = {1,-1,0,0};
    private static int answer = -1;
    private static class TwoCoin{
        int x1;
        int y1;
        int x2;
        int y2;
        int cnt;
        public TwoCoin(int x1, int y1, int x2, int y2, int cnt){
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.cnt = cnt;
        }
    }
    private static class Coin{
        int x1;
        int y1;
        public Coin(int x1, int y1){
            this.x1 = x1;
            this.y1 = y1;
        }
    }
    private static Coin firstCoin, secondCoin;
    private static Queue<TwoCoin> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new Character[N][M];

        for(int i = 0; i < N; i++){
            String temp = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = temp.charAt(j);
                if(map[i][j] == 'o' && firstCoin == null){
                    firstCoin = new Coin(i,j);
                }
                else if(map[i][j] == 'o' && firstCoin != null){
                    secondCoin = new Coin(i,j);
                }
            }
        }

        bfs();
        System.out.print(answer);
    }

    private static void bfs(){
        queue.add(new TwoCoin(firstCoin.x1, firstCoin.y1, secondCoin.x1, secondCoin.y1, 1));

        while(!queue.isEmpty()){
            TwoCoin temp = queue.poll();

            int x1 = temp.x1;
            int y1 = temp.y1;
            int x2 = temp.x2;
            int y2 = temp.y2;
            int cnt = temp.cnt;

            if(cnt > 10){
                return;
            }

            for(int i = 0; i < 4; i++){
                int nx1 = x1 + dx[i];
                int ny1 = y1 + dy[i];
                int nx2 = x2 + dx[i];
                int ny2 = y2 + dy[i];

                //동전 1 이동 가능한지 체크
                if(check(nx1,ny1) && map[nx1][ny1] == '#'){
                    nx1 = x1;
                    ny1 = y1;
                }

                //동전 2 이동 가능한지 체크
                if(check(nx2,ny2) && map[nx2][ny2] == '#'){
                    nx2 = x2;
                    ny2 = y2;
                }


                int twoCoinOut = 0;

                if(!check(nx1,ny1)){
                    twoCoinOut ++;
                }

                if(!check(nx2,ny2)){
                    twoCoinOut++;
                }

                if(twoCoinOut == 1){
                    answer = cnt;
                    return;
                }
                else if(twoCoinOut == 0){
                    queue.add(new TwoCoin(nx1,ny1,nx2,ny2,cnt + 1));
                }
            }
        }

    }

    private static boolean check(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < M;
    }


}
