import java.util.*;
import java.io.*;

public class Main {

    private static int t, n;
    private static Point[] points;
    private static boolean[] visit;
    private static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for(int time = 0; time < t; time ++) {
            n = Integer.parseInt(br.readLine());

            points = new Point[n+2];
            visit = new boolean[n+2];

            StringTokenizer st;

            for(int i = 0; i < n + 2; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                points[i] = new Point(x,y);
            }

            int festivalX = points[n+1].x;
            int festivalY = points[n+1].y;

            System.out.println(bfs(festivalX, festivalY));
        }

    }

    private static String bfs(int festivalX, int festivalY){
        Queue<Point> queue = new LinkedList<>();
        visit[0] = true;

        queue.add(new Point(points[0].x, points[0].y));

        while(!queue.isEmpty()) {
            Point temp = queue.poll();

            if(temp.x == festivalX && temp.y == festivalY) {
                return "happy";
            }

            for(int i = 0; i < points.length; i++) {
                if(!visit[i] && dist(temp.x, temp.y, points[i].x, points[i].y) <= 1000) {
                    queue.add(new Point(points[i].x, points[i].y));
                    visit[i] = true;
                }
            }
        }

        return "sad";
    }

    private static int dist(int x1, int y1, int x2, int y2) {
        return Math.abs(x1-x2) + Math.abs(y1-y2);
    }
}
