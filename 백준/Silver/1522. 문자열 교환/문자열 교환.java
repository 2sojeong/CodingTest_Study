import java.io.*;

public class Main {
    private static int aCnt = 0;
    private static String string;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        string = br.readLine();

        for(int i = 0; i < string.length(); i++){
            if(string.charAt(i) == 'a'){
                aCnt ++;
            }
        }

        count();
    }

    private static void count(){
        int cnt = Integer.MAX_VALUE;

        for(int i = 0; i < string.length(); i++){
            int bCnt = 0;
            for(int j = i; j < aCnt + i; j++){
                if(string.charAt(j % string.length()) == 'b'){
                    bCnt ++;
                }
            }
            cnt = Math.min(cnt, bCnt);
        }

        System.out.print(cnt);

    }
}
