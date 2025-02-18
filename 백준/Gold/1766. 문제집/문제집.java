import java.io.*;
import java.util.*;


public class Main {
    private static int N,M;
    private static List<Integer>[] num;
    private static int[] dis;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dis = new int[N+1];
        num = new ArrayList[N+1];

        for(int i = 1; i <= N; i++){
            num[i] = new ArrayList<>();
            dis[i] = 0;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            num[start].add(end);
            dis[end] ++;
        }

        solve();
    }


    private static void solve(){
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i = 1; i <= N; i++){
            if(dis[i] == 0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            Integer temp = queue.poll();
            sb.append(temp+" ");
            for(Integer now : num[temp]){
                dis[now]--;
                if(dis[now] == 0){
                    queue.add(now);
                }
            }
        }

        System.out.print(sb);
    }
}