import java.util.*;
import java.io.*;

public class Main {
    private static int n, m;
    private static int[][] map;
    private static boolean[] visit;
    private static Stack<Integer> stack = new Stack<>();
    private static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];
        visit = new boolean[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            map[start][end] = 1;
            map[end][start] = 1;
        }
        dfs(a, b, 0);
        System.out.print(answer);
    }

    private static void dfs(int start, int end, int depth) {
        if (start == end) {
            answer = depth;
            return;
        }
        visit[start] = true;
        stack.push(start);

        for (int i = 1; i < n + 1; i++) {
            if (!visit[i] && map[start][i] == 1) {
                dfs(i, end, depth + 1);
            }
        }

    }
}
