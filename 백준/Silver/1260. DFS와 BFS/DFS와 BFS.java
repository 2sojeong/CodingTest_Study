
import java.io.*;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        Map<Integer, List<Integer>> temp = new HashMap<>();
        for (int i = 0; i < m; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st1.nextToken());
            if (temp.containsKey(a)) {
                temp.get(a).add(b);
            }
            if (temp.containsKey(b)) {
                temp.get(b).add(a);
            }
            if (!temp.containsKey(a)) {
                temp.put(a, new ArrayList<>());
                temp.get(a).add(b);
            }
            if (!temp.containsKey(b)) {
                temp.put(b, new ArrayList<>());
                temp.get(b).add(a);
            }
        }
        for (Map.Entry<Integer, List<Integer>> entry : temp.entrySet()) {
            Collections.sort(entry.getValue());
        }

        DFS(temp, v);
        System.out.println();
        BFS(temp, v);
    }

    private static void DFS(Map<Integer, List<Integer>> temp, int start) {
        if (!temp.containsKey(start)) {
            System.out.print(start);
            return;
        }
        Stack<Integer> stack = new Stack<>();
        List<Integer> visit = new ArrayList<>();

        stack.add(start);

        while (!stack.isEmpty()) {
            int n = stack.pop();
            //이미 방문했으면
            if (!visit.contains(n)) {
                visit.add(n);
                List<Integer> var = temp.get(n);

                for (int i = var.size() - 1; i >= 0; i--) {
                    stack.add(var.get(i));

                }
            }
        }
        for (var a : visit) {
            System.out.print(a + " ");
        }
    }

    private static void BFS(Map<Integer, List<Integer>> temp, int start) {
        if (!temp.containsKey(start)) {
            System.out.println(start);
            return;
        }
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> visit = new ArrayList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int n = queue.poll();

            if (!visit.contains(n)) {
                visit.add(n);
                List<Integer> var = temp.get(n);
                for (int i = 0; i <= var.size() - 1; i++) {
                    queue.add(var.get(i));

                }
            }
        }
        for (var a : visit) {
            System.out.print(a + " ");
        }
    }
}