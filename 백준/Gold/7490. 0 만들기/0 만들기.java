import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static int T;
    private static int n;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            n = Integer.parseInt(br.readLine());
            bt(1,1,"1");
            sb.append("\n");

        }

        System.out.print(sb.toString());
    }

    private static void bt(int num, int len, String str){

        if(len == n){
            if(calculate(str) == 0){
                sb.append(str+'\n');
            }
            return;
        }

        bt(num+1, len+1,str + " " + (num+1));
        bt(num+1, len+1,str + "+" + (num+1));
        bt(num+1, len+1,str + "-" + (num+1));

    }

    private static int calculate(String str){
        str = str.replaceAll(" ","");
        Iterator<Integer> it = Arrays.stream(str.split("[+,-]"))
                .map(Integer::parseInt)
                .collect(Collectors.toList()).iterator();

        int result = it.next();
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '+'){
                result += it.next();
            }
            else if(str.charAt(i) == '-'){
                result -= it.next();
            }
        }

        return result;
    }


}
