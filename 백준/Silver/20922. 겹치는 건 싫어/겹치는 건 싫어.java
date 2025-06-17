import java.util.*;
import java.io.*;
public class Main {
    private static int N, K;
    private static int[] arr;
    private static int[] count;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        count = new int[100001];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        int start = 0;
        int end = 0;

        while (end < N) {
            if(count[arr[end]] < K) {
                count[arr[end]] += 1;
                end ++;
             }else{
                count[arr[start]] -= 1;
                start ++;
            }
            max = Math.max(max, end - start);
        }

        System.out.print(max);
    }
}
