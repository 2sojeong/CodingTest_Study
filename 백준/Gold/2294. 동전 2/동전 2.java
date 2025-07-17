import java.util.*;
import java.io.*;

public class Main {
    private static int n,k;
    private static int[] dp;
    private static int[] val;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dp = new int[k+1];
        val = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 0; i < n; i++) {
            val[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < n; i++) {
            for (int j = val[i]; j <= k; j++) {
                if (dp[j - val[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - val[i]] + 1);
                }
            }
        }

        if(dp[k] == Integer.MAX_VALUE) {
            System.out.print(-1);
        }
        else{
            System.out.print(dp[k]);
        }
    }
}
