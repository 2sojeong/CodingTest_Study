import java.util.*;
import java.io.*;

public class Main {
    private static int N,C;
    private static int[] home;
    private static int left, right;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        home = new int[N];

        for(int i = 0; i < N; i++){
            home[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(home);
        left = 1;
        right = home[N-1] - home[0]+1;

        find();

    }

    private static void find(){

        while(left < right){
            int mid = (left+right)/2;

            if(check(mid) >= C){
                left = mid +1;
            }else{
                right = mid;
            }
        }

        System.out.print(left-1);
    }


    private static int check(int mid){
        int cnt = 1;
        int start = home[0];
        for(int i = 1; i < N; i++){
            if(home[i] - start >= mid){
                start = home[i];
                cnt ++;
            }
        }
        return cnt;
    }
}
