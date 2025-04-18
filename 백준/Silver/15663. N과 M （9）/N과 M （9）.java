import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int M;
    static int[] num;
    static int[] arr = new int[9];
    static boolean[] visit = new boolean[9];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        bt(0);
        System.out.print(sb);
    }

    static void bt(int k){

        if(k == M){
            for(int i = 0; i < M; i++){
                    sb.append(arr[i]+" ");
            }
            sb.append("\n");
            return;
        }
        int before = 0;
        for(int i = 0; i < num.length; i++){
            if(!visit[i] && before != num[i]){
                arr[k] = num[i];
                before = num[i];
                visit[i] = true;
                bt(k+1);
                visit[i] = false;
            }

        }
    }
}
