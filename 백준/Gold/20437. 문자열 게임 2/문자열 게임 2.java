import java.io.*;
import java.util.*;
public class Main {
    private static int T;
    private static int K;
    private static String W;
    private static int max, min;
    private static ArrayList<Integer>[] alpha = new ArrayList[26];
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());


        for(int i = 0; i < T; i++){
            W = br.readLine();
            char[] arr = W.toCharArray();
            K = Integer.parseInt(br.readLine());
            for(int j = 0; j < 26; j++){
                alpha[j] = new ArrayList<>();
            }
            for(int j = 0; j < arr.length; j++){
                alpha[arr[j] - 97].add(j);
            }
             min = Integer.MAX_VALUE;
             max = Integer.MIN_VALUE;
            for(int j = 0; j < 26; j++){
                if(alpha[j].size() >= K){
                    find(j);
                }
            }
            if(max == Integer.MIN_VALUE)
                sb.append("-1").append("\n");
            else
                sb.append(min).append(" ").append(max).append("\n");
        }

        System.out.print(sb);
    }


    private static void find(int i){
        int minIndex, maxIndex;
        for(int j = K-1; j < alpha[i].size(); j++){
            minIndex = alpha[i].get(j-K+1);
            maxIndex = alpha[i].get(j);

            min = Math.min(min, (maxIndex - minIndex + 1));
            max = Math.max(max, (maxIndex - minIndex + 1));
        }

    }
}
