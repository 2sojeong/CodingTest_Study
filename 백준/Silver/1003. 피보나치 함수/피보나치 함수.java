import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        Integer[][] arr=new Integer[41][2];
        arr[0][0]=1;
        arr[0][1]=0;
        arr[1][0]=0;
        arr[1][1]=1;
        for(int i=0;i<n;i++){
            int tep=Integer.parseInt(br.readLine());
            for(int j=2;j<=tep;j++){
                arr[j][0]=arr[j-1][0]+arr[j-2][0];
                arr[j][1]=arr[j-1][1]+arr[j-2][1];
            }
            System.out.println(arr[tep][0]+" "+arr[tep][1]);
        }

    }

}
