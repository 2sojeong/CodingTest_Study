import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int map[]=new int[n+2];
        int dp[]=new int[n+2];
        for(int i=1;i<=n;i++){
            map[i]=Integer.parseInt(br.readLine());
        }


        dp[1]=map[1];
        dp[2]=map[2]+map[1];
        for(int i=3;i<=n;i++){
            dp[i]=Math.max(dp[i-3]+map[i]+map[i-1],dp[i-2]+map[i]);

        }

        System.out.print(dp[n]);
    }
}
