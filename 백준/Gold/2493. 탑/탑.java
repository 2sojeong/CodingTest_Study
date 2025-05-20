import java.util.*;
import java.io.*;
public class Main {
    private static int N;
    private static int[] map;
    private static StringBuilder sb = new StringBuilder();
    private static class Tower{
        int index;
        int height;

        private Tower(int index, int height){
            this.index = index;
            this.height = height;
        }
    }
    private static Stack<Tower> stack = new Stack<>();
    private static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i < N+1; i++){
            map[i] = Integer.parseInt(st.nextToken());

            while(!stack.isEmpty() && stack.peek().height < map[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                sb.append("0 ");
            }
            else{
                sb.append(stack.peek().index).append(" ");
            }

            stack.push(new Tower(i,map[i]));
        }
        System.out.print(sb);
    }

}
