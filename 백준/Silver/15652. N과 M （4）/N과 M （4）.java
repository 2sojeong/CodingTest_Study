import java.util.*;
import java.io.*;

public class Main {

    static int M;
    static int N;

    static int[] arr = new int[9];
    static boolean[] visit = new boolean[9];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        bt(0,1);
        System.out.print(sb);
    }

    static void bt(int k, int start){
        if(k == M){
            for(int i = 0; i < M; i++){
                sb.append(arr[i]+" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = start; i <= N; i++){
            if(!visit[k]){
                arr[k] = i;
                visit[k] = true;
                bt(k+1,i);
                visit[k] = false;
            }

        }
    }
}
