import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
   public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
       long tep[]=new long[n+1];
        tep[0]=0;
        tep[1]=1;
        for(int i=2;i<=n;i++){
            tep[i]=tep[i-1]+tep[i-2];
        }
        System.out.print(tep[n]);
    }

}
