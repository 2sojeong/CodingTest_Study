import java.util.*;
import java.io.*;

public class Main {

    static int L;
    static int C;

    static String[] arr = new String[16];

    static String[] alpa;

    static StringBuilder sb = new StringBuilder();

    static boolean[] visit = new boolean[16];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alpa = new String[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            alpa[i] = st.nextToken();
        }

        Arrays.sort(alpa);
        bt(0, 0);
        System.out.print(sb);

    }

    static void bt(int k, int start) {
        if (k == L) {
            if(check(arr)){
                for(int i = 0; i < L; i++){
                    sb.append(arr[i]);
                }
                sb.append("\n");
            }
            return;
        }

        for (int i = start; i < C; i++) {
                arr[k] = alpa[i];
                bt(k + 1, i+1);
        }
    }

    static boolean check(String[] pw){
        int mo = 0;
        int ja = 0;
        for (int i = 0; i < L; i++)
            if(pw[i].equals("a") || pw[i].equals("e")||pw[i].equals("i")||pw[i].equals("o")||pw[i].equals("u")){
                mo ++;
            }
            else{
                ja ++;
            }

        return mo >= 1 && ja >= 2;
    }
}
