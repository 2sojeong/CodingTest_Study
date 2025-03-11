import java.util.*;
import java.io.*;

public class Main {
    private static int N,M;
    private static int[] arr;

    private static int answer = 0;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = i;
        }
        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(union(a,b)){
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }

    private static boolean union(int a, int b){
        int na = find(a);
        int nb = find(b);

        if(na == nb){
            return true;
        }

        if(na != nb){
            if(nb > na){
                arr[nb] = na;
            }
            else{
                arr[na] = nb;
            }

        }
        return false;
    }

    private static int find(int a){
        if(a == arr[a]){
            return a;
        }

            return arr[a] = find(arr[a]);

    }
}
