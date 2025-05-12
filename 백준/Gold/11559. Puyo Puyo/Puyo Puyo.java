import java.util.*;
import java.io.*;
public class Main {
    private static Character[][] map = new Character[12][6];
    private static int[] dx = {0,0,1,-1};
    private static int[] dy = {1,-1,0,0};

    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private static boolean[][] visit;
    private static ArrayList<Node> list;
    private static int answer = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 12; i++){
            String temp = br.readLine();
            for(int j = 0; j < 6; j++){
                map[i][j] = temp.charAt(j);
            }
        }

        while(true){
            visit = new boolean[12][6];
            boolean isFinished = true;
            for(int i = 0; i < 12; i++){
                for(int j = 0; j < 6; j++){
                    if(map[i][j] != '.' && !visit[i][j]){
                        list = new ArrayList<>();
                        findPuyo(i,j,map[i][j]);

                        if(list.size() >= 4){
                            isFinished = false;
                            for(int s = 0; s < list.size(); s++){
                                map[list.get(s).x][list.get(s).y] = '.';
                            }
                        }
                    }
                }
            }

            if(isFinished) break;
            answer ++;
            downPuyo();
        }
        System.out.println(answer);
    }

    //터지는 뿌요 탐색하는 함수
    private static void findPuyo(int x, int y, Character c){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x,y));
        list.add(new Node(x,y));
        visit[x][y] = true;
        while(!queue.isEmpty()){
            Node temp = queue.poll();

            for(int i = 0; i < 4; i++){
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if(nx >= 0 && nx < 12 && ny >= 0 && ny < 6 && map[nx][ny] == c && !visit[nx][ny]){
                    visit[nx][ny] = true;
                    queue.add(new Node(nx,ny));
                    list.add(new Node(nx,ny));
                }
            }
        }

    }

    //뿌요 재배치 함수
    private static void downPuyo(){
        for(int i = 0; i < 6; i++){
            Queue<Character> q = new LinkedList<>();
            for(int j = 11; j >= 0 ; j--){
                if(map[j][i] != '.'){
                    q.add(map[j][i]);
                }
            }

            for(int j = 11; j >= 0; j--){
                if(!q.isEmpty()){
                    map[j][i] = q.poll();
                }
                else{
                    map[j][i] = '.';
                }
            }
        }

    }

}
