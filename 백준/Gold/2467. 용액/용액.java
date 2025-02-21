import java.util.*;
import java.io.*;
public class Main {
    private static int N;
    private static int[] num;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        find();
    }

    private static void find(){
        int left = 0;
        int right = N - 1;
        int max = Integer.MAX_VALUE;
        int n1 = 0, n2 = 0;
        while (left < right){
            int temp = num[left] + num[right];

            if(max > Math.abs(temp)){
                max = Math.abs(temp);
                n1 = num[left];
                n2 = num[right];
            }

            if(temp > 0){
                right --;
            }
            if(temp < 0){
                left ++;
            }
            if(temp == 0){
                n1 = num[left];
                n2 = num[right];
                break;
            }
        }
        System.out.print(n1 + " "+n2);
    }
}
