import java.util.*;
import java.io.*;

public class Main {
    private static int N;
    private static int[] map;
    private static ArrayList<Integer> answer = new ArrayList<>();
    private static BufferedReader br;
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        input();
        setLine();
        print();
    }

    private static void input() throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1];

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i < N + 1; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void setLine() {
        for(int i = N; i > 0 ; i--) {
            int f = map[i];
            answer.add(f, i);
        }
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();
        for(Integer i : answer) {
            sb.append(i).append(" ");
        }
        System.out.print(sb.toString().trim());
    }
}
