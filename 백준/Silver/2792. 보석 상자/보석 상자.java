
import java.util.*;
import java.io.*;
public class Main {
    private static int N,M;
    private static int left = 1;
    private static int right = Integer.MIN_VALUE;
    private static int[] jewel;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        jewel = new int[M];

        for(int i = 0; i < M; i++){
            jewel[i] = Integer.parseInt(br.readLine());
            right = Math.max(right,jewel[i]);
        }

        share();
    }

    private static void share(){
        while(left < right){
            int mid = (left + right) / 2;

            if(check(mid) > N){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
    System.out.print(right);
    }

    private static int check(int mid){
        int cnt = 0;

        for(int i = 0; i < M; i++){
            if(jewel[i] % mid == 0){
                cnt += jewel[i] / mid;
            }
            else{
                cnt += jewel[i]/mid + 1;
            }
        }

        return cnt;
    }
}
