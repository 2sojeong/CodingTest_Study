import java.util.*;
import java.io.*;
public class Main {
    private static int N;
    private static String s;
    private static String answer;
    private static boolean[] firstOn;
    private static boolean[] firstOff;
    private static boolean[] answerArr;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        s = br.readLine();
        answer = br.readLine();
        firstOn = new boolean[N];
        firstOff = new boolean[N];
        answerArr = new boolean[N];

        for(int i = 0; i < N; i++){
            firstOn[i] = s.charAt(i) != '0';
            firstOff[i] = s.charAt(i) != '0';
            answerArr[i] = answer.charAt(i) != '0';
        }

        greedy(1,0,firstOff);
        greedy(1,1,changeSwitch(0,firstOn));

        System.out.print(min == Integer.MAX_VALUE ? -1 : min);
    }

    private static void greedy(int index, int cnt, boolean[] arr){
        if(index == N){
            if(arr[index - 1] == answerArr[index - 1]){
                min = Math.min(min,cnt);
            }
            return;
        }

        if(arr[index - 1] != answerArr[index - 1]){
            greedy(index + 1, cnt + 1, changeSwitch(index,arr));
        }
        else{
            greedy(index + 1, cnt, arr);
        }
    }


    private static boolean[] changeSwitch(int idx, boolean[] arr){
        for(int i = idx - 1; i <= idx + 1; i++){
            if(0 <= i && i < N){
                arr[i] = !arr[i];
            }
        }
        return arr;
    }
}
