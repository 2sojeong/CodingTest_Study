import java.util.*;
import java.io.*;

public class Main {
    private static int N, K;
    private static long[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long sum = 0;
        int start = 0;
        int end = K - 1;
        

        for(int i = 0; i < K; i++) {
            sum += arr[i];
        }
        long result = sum;
        
        while(end < N - 1) {
            result = Math.max(result, sum);

            start ++;
            end ++;
            sum -= arr[start - 1];
            sum += arr[end];

        }

        result = Math.max(result, sum);
        System.out.print(result);
    }
}
