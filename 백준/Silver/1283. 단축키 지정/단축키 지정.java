import java.util.*;
import java.io.*;

public class Main {
    private static int N;
    private static String[] arr;
    private static int[] shortcut;
    private static Set<Character> used = new HashSet<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new String[N];
        shortcut = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = br.readLine();
            shortcut[i] = -1;
        }

        shortCut();
        for(int i = 0; i < N; i++) {
            int t = shortcut[i];
            if(t == -1) {
                System.out.println(arr[i]);
                continue;
            }

            for(int j = 0; j < arr[i].length(); j++) {
                if(j == t) {
                    System.out.print("["+arr[i].charAt(j)+"]");
                    continue;
                }
                System.out.print(arr[i].charAt(j));
            }
            System.out.println();
        }
    }

    private static void shortCut() {
        for(int i = 0; i < N; i++) {
            String line = arr[i];
            String[] temp = line.split(" ");
            int indexLine = 0;
            boolean assigned = false;
            for(String word : temp){
                char c = Character.toLowerCase(word.charAt(0));
                if(!used.contains(c)) {
                    used.add(c);
                    shortcut[i] = indexLine;
                    assigned = true;
                    break;
                }
                indexLine += word.length() + 1;
            }

            // 아무것도 지정하지 않은 경우
            if(!assigned) {
                for(int j = 0; j < line.length(); j++) {
                    char c = Character.toLowerCase(line.charAt(j));
                    if(c != ' ' && !used.contains(c)) {
                        used.add(c);
                        shortcut[i] = j;
                        break;
                    }
                }
            }
        }
    }
}
