import java.util.*;
import java.io.*;

public class Main {
    private static int N,M;
    private static int left = Integer.MIN_VALUE;
    private static int right = 0;

    private static int[] num;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            num[i] = Integer.parseInt(st.nextToken());
            right += num[i];
            left = Math.max(left,num[i]);
        }
        find(left,right);
    }

    private static void find(int left, int right){

        while(left < right){
            int mid = (left + right) / 2;
            if(check(mid) > M){
                left = mid + 1;
            }
            else{
                right = mid;
            }


        }
        System.out.print(left);
    }

    private static int check(int mid){
        int cnt = 1;
        int remain = mid;

        for(int i = 0; i < N; i++){
            if(remain < num[i]){
                remain = mid;
                cnt++;
            }
            remain -= num[i];
        }

        return cnt;
    }
}
