import java.util.*;
import java.io.*;

public class Main {

    public static int N;
    public static int M;

    public static int num = 1;

    public static int[] arr = new int[11];

    public static boolean[] isused = new boolean[11];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        bt(0);


    }

    static void bt(int k){
        if(k == M){
            for(int i = 0; i < M; i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }

        for(int i = 1; i <= N; i++){
            if(!isused[i]){
                arr[k] = i;
                isused[i] = true;
                bt(k+1);
                isused[i] = false;
            }
        }
    }
}
