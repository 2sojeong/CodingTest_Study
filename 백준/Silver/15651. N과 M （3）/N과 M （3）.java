import java.util.*;
import java.io.*;

public class Main {

    public static int N;
    public static int M;
    public static int[] arr = new int[8];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        bt(0);
        System.out.println(sb);

    }

    static void bt(int k){
        if(k == M){
            for(int i = 0; i < M; i++){
                sb.append(arr[i]+" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 1; i <= N; i++){
            arr[k] = i;
            bt(k + 1);
            arr[k] = 0;
        }
    }



}
