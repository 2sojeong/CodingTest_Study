import java.util.*;
import java.io.*;

public class Main {

    private static BufferedReader br;
    private static int N;

    private static StringBuilder sb = new StringBuilder();

    private static PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
    private static PriorityQueue<Integer> min = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        program();
    }

    private static void program() throws IOException{

        for(int i = 0; i < N; i++){
            int temp = Integer.parseInt(br.readLine());
            if(max.size() == min.size()){
                max.add(temp);
            }
            else{
                min.add(temp);
            }

            if(!max.isEmpty() && !min.isEmpty()){
                if(max.peek() > min.peek()){
                    int num = max.poll();
                    max.offer(min.poll());
                    min.offer(num);
                }
            }
            sb.append(max.peek()+"\n");

        }
        System.out.print(sb);
    }
}
