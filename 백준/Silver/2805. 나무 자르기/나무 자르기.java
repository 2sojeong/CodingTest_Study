import java.util.*;
import java.io.*;

public class Main {
    private static int N, M;
    private static int[] tree;
    private static BufferedReader br;
    private static StringTokenizer st;
    private static int left, right, mid;
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        tree = new int[N];

        input();
        Arrays.sort(tree);
        findMid();
        System.out.print(right);
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void findMid() {
        left = 0;
        right = tree[N-1];
        while(left <= right) {
            mid = (left + right) / 2;
            long temp = checkMid(mid);

            if(temp >= M) {
                left = mid + 1;
            }
            else if(temp < M) {
                right = mid - 1;
            }
        }
    }

    private static long checkMid(int m) {
        long result = 0;
        for(int i = 0; i < N; i++) {
            if(tree[i] > m) {
                result += tree[i] - m;
            }
        }

        return result;
    }

}

