import java.util.*;
import java.io.*;
public class Main {
    private static int K,N;
    private static long[] num;
    private static long right = Integer.MIN_VALUE;
    private static long result = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        num = new long[K];

        for(int i = 0; i < K; i++){
            num[i] = Integer.parseInt(br.readLine());
            right = Math.max(right,num[i]);
        }
        right ++;

       find();
    }


    private static void find(){
        long left = 1;

        while (left < right){
            long mid = (left + right)/2;

            if(check(mid) >= N){
                left = mid+1;
            }

            else{
                right = mid;
            }
        }

        System.out.print(left-1);
    }

    private static long check(long mid){
        long cnt = 0;

        for(int i = 0; i < K; i++){
            cnt = cnt + (num[i]/mid);
        }

        return cnt;
    }
}
