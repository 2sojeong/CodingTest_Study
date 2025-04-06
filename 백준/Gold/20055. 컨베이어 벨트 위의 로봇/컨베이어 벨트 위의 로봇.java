import java.io.*;
import java.util.*;

public class Main {

    private static int N, K;
    private static int[] power;
    private static int[] robotIndex;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        robotIndex = new int[N];

        for (int i = 0; i < N; i++) {
            robotIndex[i] = 0;
        }
        power = new int[N * 2];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < power.length; i++) {
            power[i] = Integer.parseInt(st.nextToken());
        }

        belt();
    }

    private static void belt() {
        int level = 0;
        while (true) {
            if (countZero() >= K) {
                break;
            }

            level++;
            move();

            robotMove();

            if (power[0] >= 1) {
                robotIndex[0] = 1;
                power[0] -= 1;
            }

        }

        System.out.print(level);
    }

    private static void move() {
        int temp = power[power.length-1];

        for (int i = power.length - 1; i > 0; i--) {
            power[i] = power[i - 1];
        }
        power[0] = temp;

        int temp1 = robotIndex[N-1];

        for (int i = robotIndex.length - 1; i > 0; i--) {
            robotIndex[i] = robotIndex[i - 1];
        }

        robotIndex[0] = temp1;

        robotIndex[N-1] = 0;
    }

    private static void robotMove() {
        for (int i = N - 2; i >= 0; i--) {
            if (robotIndex[i] == 1 && robotIndex[i + 1] == 0 && power[i + 1] >= 1) {
                robotIndex[i] = 0;
                robotIndex[i + 1] = 1;
                power[i + 1]--;

            }
        }

        robotIndex[N - 1] = 0;
    }

    private static int countZero() {
        int cnt = 0;
        for (int i = 0; i < power.length; i++) {
            if (power[i] == 0) {
                cnt++;
            }
        }

        return cnt;
    }

    private static boolean check(int idx) {
        return power[idx + 1] >= 1;
    }

}
