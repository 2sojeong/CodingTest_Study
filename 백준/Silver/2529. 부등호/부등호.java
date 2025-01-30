
import java.util.*;
import java.io.*;


public class Main {

    static int K;
    static String[] sign = new String[10];

    static int[] arr = new int[10];

    static boolean[] visit = new boolean[10];

    static List<String> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < K; i++) {
            sign[i] = st.nextToken();
        }

        bt(0,"");
        Collections.sort(result);
        System.out.println(result.get(result.size()-1));
        System.out.print(result.get(0));
    }
    static void bt(int len, String num) {
        if (len == K+1) {
            result.add(num);
            return;
        }

        for(int i = 0; i < 10; i++){
            if(!visit[i]){
                if(len == 0 || check(num.charAt(num.length()-1)-'0',i,sign[len-1])){
                    visit[i] = true;
                    bt(len+1,num+i);
                    visit[i] = false;
                }
            }
        }
    }


    static boolean check(int a, int b, String c)
    {
        if(c.equals(">")){
            if(a<b) return false;
        }else if(c.equals("<")){
            if(a>b) return false;
        }
        return true;
    }
}
