
import java.util.*;
import java.io.*;

public class Main {
    //컴퓨터 수
    public static int V;
    // 연결 수
    public static int E;

    public static boolean[] visit=new boolean[101];
    public static int[][] arr=new int[101][101];
    public static int cnt=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        V=Integer.parseInt(br.readLine());
        E=Integer.parseInt(br.readLine());
        for(int i=0;i<E;i++){
            StringTokenizer st=new StringTokenizer(br.readLine()," ");
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());

            arr[a][b]=1;
            arr[b][a]=1;
        }

        System.out.print( DFS(1));
      
    }

    private static int DFS(int start){
        visit[start]=true;

        for(int i=1;i<arr.length;i++){
            if(arr[start][i]==1 && visit[i]==false){
                cnt+=1;
                DFS(i);
            }
        }
        return cnt;
    };
}
