/*
 1. 빨간 공 왼쪽으로
 2. 빨간 공 오른쪽으로
 3. 파란 공 왼쪽으로
 4. 파란 공 오른쪽으로
 */
import java.util.*;
import java.io.*;
public class Main {
    private static int N;
    private static ArrayList<Character> string = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        String temp = br.readLine();
        for(int i = 0; i < N; i++) {
            string.add(temp.charAt(i));
        }

        int redCount = Math.min(redLeft(), redRight());
        int blueCount = Math.min(blueLeft(), blueRight());

        System.out.print(Math.min(redCount, blueCount));
    }

    // 1. 빨간 공 왼쪽으로
    private static int redLeft() {
        int count = 0;
        int Bcount = 0;

        for(Character c : string) {
            if(c == 'B'&& Bcount == 0) {
                Bcount ++;
            }
            if(Bcount > 0 && c == 'R') {
                count ++;
            }
        }
        return count;
    }

    // 2. 빨간 공 오른쪽으로
    private static int redRight() {
        int count = 0;
        int Bcount = 0;

        for(int i = string.size()-1; i >= 0; i--) {
            Character temp = string.get(i);

            if(temp == 'B' && Bcount == 0) {
                Bcount++;
            }
            if(Bcount > 0 && temp == 'R') {
                count ++;
            }
        }
        return count;
    }

    // 3. 파란 공 왼쪽으로
    private static int blueLeft() {
        int count = 0;
        int Rcount = 0;

        for(Character c : string) {
            if(c == 'R'&& Rcount == 0) {
                Rcount ++;
            }
            if(Rcount > 0 && c == 'B') {
                count ++;
            }
        }
        return count;
    }


    // 4. 파란 공 오른쪽으로
    private static int blueRight() {
        int count = 0;
        int Bcount = 0;

        for(int i = string.size()-1; i >= 0; i--) {
            Character temp = string.get(i);

            if(temp == 'R' && Bcount == 0) {
                Bcount++;
            }
            if(Bcount > 0 && temp == 'B') {
                count ++;
            }
        }
        return count;
    }
}
