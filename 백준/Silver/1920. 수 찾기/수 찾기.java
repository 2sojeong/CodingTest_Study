import java.util.*;
import java.io.*;

public class Main {
    private static int N, M;
    private static HashMap<Integer,Integer> arrN, arrM;
    private static BufferedReader br;
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        arrN = new HashMap<>();
        arrM = new HashMap<>();

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arrN.put(Integer.parseInt(st.nextToken()),i);
        }

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            int temp = Integer.parseInt(st.nextToken());

            if(arrN.containsKey(temp)) {
                sb.append(1).append('\n');
            }
            else{
                sb.append(0).append('\n');
            }
        }


        System.out.print(sb.toString().trim());
    }
}
