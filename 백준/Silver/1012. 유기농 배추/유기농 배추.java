import java.io.*;
import java.util.*;
public class Main
{
    public static int[][] arr;
    public static boolean[][] visit;
    public static int M;
    public static int N;
    public static int K;
    public static void main(String[] args) throws IOException
    {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(br.readLine());
        for(int i=0;i<num;i++){
        StringTokenizer st=new StringTokenizer(br.readLine()," ");
         M=Integer.parseInt(st.nextToken());
         N=Integer.parseInt(st.nextToken());
         K=Integer.parseInt(st.nextToken());

        arr=new int[51][51];
        visit=new boolean[51][51];
        int bug=0;
        //배추 위치를 1로 표시   
        for(int j=0;j<K;j++){
            StringTokenizer st1=new StringTokenizer(br.readLine()," ");
            int a=Integer.parseInt(st1.nextToken());
            int b=Integer.parseInt(st1.nextToken());
            arr[a][b]=1;
        }

        for(int x=0;x<M;x++){
            for(int y=0;y<N;y++){
                if(arr[x][y]==1 && !visit[x][y]){
                    bug++;
                    DFS(x,y);
                }
            }
        }
        System.out.println(bug);
        }

    }

    public static void DFS(int x, int y){
        int[] dx={0,0,-1,1};
        int[] dy={-1,1,0,0};
        visit[x][y]=true;
        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(nx>=0 && ny>=0 && nx<M && ny<N && !visit[nx][ny] && arr[nx][ny]==1){
                DFS(nx,ny);
            }
        }
    }
}