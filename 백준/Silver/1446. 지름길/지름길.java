import java.io.*;
import java.util.*;
public class Main {
    private static int N;
    private static int D;

    private static int[] dp;

    private static class Shortcut {
        int end;
        int distance;

        public Shortcut(int end, int distance) {
            this.end = end;
            this.distance = distance;
        }
    }
    private static Map<Integer,ArrayList<Shortcut>> load = new HashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        dp = new int[D+1];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            load.computeIfAbsent(s, key -> new ArrayList<>()).add(new Shortcut(e,d));
        }

        dp();
        System.out.print(dp[D]);
    }


    private static void dp() {
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 0; i <= D; i++) {
            if(i > 0)dp[i] = Math.min(dp[i], dp[i-1] + 1);

            for(Integer s : load.keySet()) {
                ArrayList<Shortcut> temp = load.get(s);
                for(Shortcut t : temp) {
                    if(s == i && t.end <= D) {
                        dp[t.end] = Math.min(dp[t.end], dp[s] + t.distance);
                    }
                }
            }
        }
    }
}
