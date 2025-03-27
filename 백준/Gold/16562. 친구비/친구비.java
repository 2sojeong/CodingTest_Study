import java.io.*;
import java.util.*;

public class Main {
    private static int N, M, K;
    private static int[] money;
    private static int[] friend;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        money = new int[N + 1];
        friend = new int[N+1];
        st = new StringTokenizer(br.readLine());

        for(int i = 1; i < N + 1; i++) {
            money[i] = Integer.parseInt(st.nextToken());
            friend[i] = i;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int tempA = Integer.parseInt(st.nextToken());
            int tempB = Integer.parseInt(st.nextToken());

            union(tempA,tempB);
        }

        int[] setFriend = Arrays.stream(friend).distinct().toArray();
        int result = K;
        for(int i = 1; i <= N; i++){
            if(friend[i] == i){
                K -= money[i];
                if(K >= 0)
                    answer += money[i];
                else answer = -1;
            }
        }

        if(answer == -1){
            System.out.print("Oh no");
        }
        else{
            System.out.print(answer);
        }
    }

    private static void union(int a, int b){
        int na = find(a);
        int nb = find(b);

        if(na != nb){
            if(money[na] > money[nb]){
                friend[na] = nb;
            }
            else{
                friend[nb] = na;
            }
        }
    }

    private static int find(int a){
        if(friend[a] == a){
            return a;
        }
        return friend[a] = find(friend[a]);
    }
}
