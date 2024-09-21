import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int arr[][]=new int[501][501];

        for(int i=1;i<=n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine()," ");
            for(int j=1;j<=i;j++){
                arr[i][j]= Integer.parseInt(st.nextToken());
            }
        }
        

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++) {
                arr[i][j]=arr[i][j]+Math.max(arr[i-1][j],arr[i-1][j-1]);
            }
        }
        
        int max=arr[n][n];
        for(int i=1;i<=n;i++){
            if(max<=arr[n][i]){
                max=arr[n][i];
            }
        }
        System.out.print(max);
    }
}
