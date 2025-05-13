import java.util.*;
import java.io.*;
public class Main {
    private static int R, C;
    private static Character[][] map;
    private static boolean[] visit;
    private static int[] dx = {0,0,1,-1};
    private static int[] dy = {1,-1,0,0};

    private static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new Character[R][C];
        visit = new boolean[26];

        for(int i = 0; i < R; i++){
            String temp = br.readLine();
            for(int j = 0; j < C; j++){
                map[i][j] = temp.charAt(j);
            }
        }

        visit[map[0][0] - 'A'] = true;
        dfs(0,0,1);
        System.out.print(answer);
    }

    private static void dfs(int x, int y, int depth) {
        answer = Math.max(answer, depth);

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= R || ny >= C | ny < 0) continue;
            if(visit[map[nx][ny] - 'A']) continue;
            visit[map[nx][ny] - 'A'] = true;
            dfs(nx,ny,depth + 1);
            visit[map[nx][ny] - 'A'] = false;
        }
    }
}
