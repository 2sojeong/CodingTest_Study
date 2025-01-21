
import java.util.*;
import java.io.*;

public class Main {

    public static int N;
    public static int M;
    public static int[] arr = new int[9];

    public static void main(String args[]) throws IOException{
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
            if(checkMax(arr) < i){
                arr[k] = i;
                bt(k + 1);
                arr[k] = 0;
            
            }
        }
    }

    static int checkMax(int[] arr){
        int max = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(max < arr[i]){
                max = arr[i];
            }
        }
        return max;
    }
}
