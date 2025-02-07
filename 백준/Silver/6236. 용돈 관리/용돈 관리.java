import java.io.*;
import java.util.*;

/*
현우는 용돈을 효율적으로 활용하고 돈을 펑펑 쓰지 않기 위해서 앞으로 N일 동안 자신이 매일 사용할 금액을 계산하고, 정확히 통장에서 M번, K원 씩 출금해서 사용하기로 결정했습니다.
현재 수중에 있는 금액으로 하루를 보낼 수 있다면 그대로 소비합니다. 부족하다면, 수중에 있는 금액은 통장에 넣은 뒤 K원을 인출해서 하루를 생활합니다.
이때, 현우가 매번 출금할 금액 K원의 최솟값을 구하는 프로그램을 작성해주세요.
 */
public class Main {

    private static int N,M, left, right;
    private static int[] coin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        coin = new int[N];
        right = 0;
        left = 0;

        for(int i = 0; i < N; i++){
            coin[i] = Integer.parseInt(br.readLine());
            right += coin[i];
            left = Math.max(left, coin[i]);
        }

        find();

    }

    private static void find(){
        int answer = 0;
        while(left <= right){
            int mid = (left + right) / 2;

            if(check(mid)){
                answer = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        System.out.print(answer);
    }

    private static boolean check(int mid){
        int cnt = 1;
        int money = mid;
        for(int i = 0; i < N; i++){
            if(coin[i] <= money){
                money -= coin[i];
            }
            else if(coin[i] > money){
                cnt += 1;
                money = mid - coin[i];
            }
        }
        if(M >= cnt){
            return true;
        }

        return false;
    }
}
