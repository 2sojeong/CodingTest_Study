import java.util.*;
import java.io.*;

public class Main {
    private static class Node{
        int from;
        int to;
        int len;
        public Node(int from, int to, int len) {
            this.from = from;
            this.to = to;
            this.len = len;
        }
    }

    private static int[][] map;
    private static int V, E;
    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        map = new int[V+1][V+1];

        for(int i = 0; i < V+1; i++) {
            for(int j = 0; j < V+1; j++) {
                map[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i= 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[a][b] = c;
        }

        for(int k = 1; k < V+1; k++) {
            for(int i = 1; i < V+1; i++) {
                for(int j = 1; j < V+1; j++) {
                    if(map[i][k] != Integer.MAX_VALUE && map[k][j] != Integer.MAX_VALUE && map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i != j && map[i][j] != Integer.MAX_VALUE && map[j][i] != Integer.MAX_VALUE) {
                    result = Math.min(result, map[i][j] + map[j][i]);
                }
            }
        }

        System.out.print(result == Integer.MAX_VALUE ? -1 : result);
    }

}
