import java.io.*;
import java.util.*;

public class Main {
    private static int K;
    private static int[] rotate;
    private static int[][] num = new int[5][8];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 4; i ++){
            String temp = br.readLine();
            for(int j = 0; j < 8; j++){
                num[i][j] = temp.charAt(j) - '0';
            }
        }

        int K = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken()) - 1;
            int direction = Integer.parseInt(st.nextToken());
            operation(number,direction);
        }

        int answer = 0;

        for(int i = 0; i < 4; i++){
            answer += Math.pow(2,i) * num[i][0];
        }
        System.out.print(answer);

    }

    private static void operation(int idx, int dir){
        // 왼쪽 : 0 ~ idx -1
        leftSide(idx - 1, -dir);

        // 오른쪽 : idx ~ 3
        rightSide(idx + 1, -dir);

        rotate(idx, dir);
    }

    private static void leftSide(int idx, int dir){
        if(idx < 0) return;
        if(num[idx][2] == num[idx + 1][6]) return;
        leftSide(idx - 1, -dir);
        rotate(idx,dir);
    }

    private static void rightSide(int idx, int dir){
        if(idx > 3) return;
        if(num[idx][6] == num[idx-1][2]) return;
        rightSide(idx + 1, -dir);
        rotate(idx, dir);
    }
    private static void rotate(int number, int dir){
        //시계방향
        if(dir == 1){
            int temp = num[number][7];
            for(int i = 7; i > 0; i--){
                num[number][i] = num[number][i-1];
            }
            num[number][0] = temp;
        }
        //반시계방향
        else{
            int temp = num[number][0];
            for(int i = 0; i < 7; i++){
                num[number][i] = num[number][i+1];
            }
            num[number][7] = temp;
        }
    }


}
