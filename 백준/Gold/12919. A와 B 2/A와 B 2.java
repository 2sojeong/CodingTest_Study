import java.io.*;
import java.util.*;

public class Main {
    private static String S;
    private static String T;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        T = br.readLine();

       bt(new StringBuilder(T));
       System.out.print("0");

    }

    private static void bt(StringBuilder str){
        if(str.length() == S.length()){
            if(str.toString().equals(S)){
                System.out.print("1");
                System.exit(0);
            }
            return;
        }
        if(str.charAt(str.length()-1) == 'A'){
            StringBuilder sb1 = new StringBuilder(str.substring(0,str.length()-1));
            bt(sb1);
        }
        if(str.charAt(0) == 'B'){
            StringBuilder sb2 = new StringBuilder(str.substring(1,str.length()));
            bt(sb2.reverse());
        }

    }

}
