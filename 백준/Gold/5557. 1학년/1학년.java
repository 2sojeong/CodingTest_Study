import java.util.*;
import java.io.*;

public class Main {

    private static int N;
    private static int[] arr;
    private static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        dp = new long[N][21];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp();
    }

    public static void dp() {
        dp[0][arr[0]] = 1;

        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < 21; j++) {

                int tempP = j + arr[i+1];
                int tempM = j - arr[i+1];

                if (tempP >= 0 && tempP <= 20) {
                    dp[i+1][tempP] += dp[i][j];
                }
                if (tempM >= 0 && tempM <= 20) {
                    dp[i+1][tempM] += dp[i][j];
                }

            }
        }

        System.out.print(dp[N-2][arr[N-1]]);

    }
}
