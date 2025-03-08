
import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[] arr;

    private static Set<Integer> sum = new HashSet<>();

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
     

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for(int i : arr){
            for(int j : arr){
                sum.add(i+j);
            }
        }

        find();
    }

    private static void find(){
        for(int k = N-1; k >=0; k--){
            for(int z = 0; z < N; z++){
                int temp = arr[k] - arr[z];
                if(sum.contains(temp)){
                    System.out.print(arr[k]);
                    return;
                }
            }
        }
    }

}
