import java.io.*;
import java.util.*;
public class Main {
    private static int t,n,k;
    private static int[] num;
    private static StringTokenizer st;
    private static List<Integer> ans = new ArrayList<>();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++){
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            num = new int[n];

            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                num[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(num);
          
            int left = 0;
            int right = n-1;

            find(left,right);

        }

        for(Integer a:ans){
            System.out.println(a);
        }
    }

    private static void find(int left, int right){
        int max = Integer.MAX_VALUE;
        int cnt = 0;
        while(left < right){
            int temp = num[left] + num[right];

            if(temp < k){
                left ++;
            }else{
                right --;
            }
            //새로운 max값이 갱신되면 cnt 리셋
            if(max > Math.abs(k-temp)){
                max = Math.abs(k-temp);
                cnt = 1;
            }
            //기존 max 값이랑 현재 계산 값이랑 같으면 cnt 증가
            else if(Math.abs(k-temp) == max){
                cnt ++;
            }
        }

        ans.add(cnt);
    }


}
