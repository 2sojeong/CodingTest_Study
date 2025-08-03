import java.util.*;
import java.io.*;

public class Main {
    private static int N, d, k, c;
    private static int[] track;
    private static int[] sushi;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        track = new int[N];
        sushi = new int[d + 1];

        for (int i = 0; i < N; i++) {
            track[i] = Integer.parseInt(br.readLine());

        }

        System.out.print(window());
    }

    private static int window() {
        int type = 0;
        for(int i = 0; i < k; i++) {
            if(sushi[track[i]] <= 0) type ++;
            sushi[track[i]] ++;
        }

        int max = type;
        for(int i = 0; i < N; i++) {
            int end = (i+k) % N; //원형 트랙 고려

            if(--sushi[track[i]] == 0) type --;
            if(sushi[track[end]]++ == 0) type ++;

            max = Math.max(max, type + (sushi[c] == 0 ? 1 : 0));
        }
        return max;
    }
}
