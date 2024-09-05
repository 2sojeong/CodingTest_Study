
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        Queue<Integer> q=new LinkedList<>();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int cnt=1;
        for(int i=1;i<=n;i++){
            q.add(i);
        }
       while (true) {
            if(q.size()==1){
                System.out.println(q.peek());
                break;
            }
            else{
                 q.remove(q.peek());
                 q.add(q.peek());
                 q.remove(q.peek());
            }
       }
    }
}
