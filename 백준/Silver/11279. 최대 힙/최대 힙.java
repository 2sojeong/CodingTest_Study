
import java.util.*;
import java.io.*;

public class Main {

    private static int N;
    private static List<Integer> num;
    private static PriorityQueue<Integer> queue;
    private static StringBuilder sb = new StringBuilder();

    private static BufferedReader br;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        queue = new PriorityQueue<>(Collections.reverseOrder());

        num();


    }

    private static void num() throws IOException{

        for(int i = 0; i < N; i++){
            int temp = Integer.parseInt(br.readLine());

            if(temp == 0){
                if(queue.isEmpty()){
                    sb.append(0);
                    sb.append("\n");
                }
                else {
                    sb.append(queue.poll()).append("\n");
                }
            }
            else{
                queue.offer(temp);
            }
        }
        System.out.print(sb);
    }
}
