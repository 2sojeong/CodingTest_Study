import java.util.*;
import java.io.*;

public class Main {
    private static int N;
    private static String[] words;
    private static ArrayList<Integer>[] index = new ArrayList[26];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        words = new String[N];

        for(int i = 0; i < 26; i++){
            index[i] = new ArrayList<>();
        }

        for(int i = 0; i < N; i++){
            words[i] = br.readLine();
        }
        find();

    }

    private static void find(){
        int result1 = 0;
        int result2 = 0;
        int max = 0;
        for(int i = 0; i < N; i++){
            String str1 = words[i];
            for(int j = i + 1; j < N; j++){
                int cnt = 0;
                String str2 = words[j];
                int size = Math.min(str1.length(), str2.length());

                for(int z = 0; z < size; z++){
                    if(str1.charAt(z) == str2.charAt(z)) cnt++;
                    else break;
                }

                if(cnt > max){
                    result1 = i;
                    result2 = j;
                    max = cnt;
                }
            }
        }

        System.out.println(words[result1]);
        System.out.print(words[result2]);
    }
}
