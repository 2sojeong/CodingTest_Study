import java.util.*;
import java.io.*;
public class Main {
    private static int N,M;
    private static int[] num;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N+1];

        for(int i = 1; i <= N; i++){
            num[i] = i;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int check = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(check == 0){
                union(a,b);
            }
            if(check == 1){
                int na = find(a);
                int nb = find(b);

                if(na == nb){
                    System.out.println("YES");
                }
                else{
                    System.out.println("NO");
                }
            }
        }
    }


    private static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a!=b){
            num[b] = a;
        }
    }

    private static int find(int a){
        if(a == num[a])
            return a;
        else{
            return num[a] = find(num[a]);
        }
    }
}
