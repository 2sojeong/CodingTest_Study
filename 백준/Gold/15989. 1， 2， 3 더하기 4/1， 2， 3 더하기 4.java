import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[][] dp = new int[100001][4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int k = 1; k <= 3; k++) {
            dp[0][k] = 1;
        }

        for (int k = 1; k <= 3; k++) {
            for (int i = 1; i <= 10000; i++) {
                dp[i][k] = dp[i][k - 1];
                if (i - k >= 0) {
                    dp[i][k] += dp[i - k][k];
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.println(dp[Integer.parseInt(br.readLine())][3]);
        }
    }
}