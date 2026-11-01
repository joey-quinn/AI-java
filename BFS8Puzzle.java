
import java.util.*;

public class BFS8Puzzle {

    static String goal = "123456780";

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static String swap(String s, int i, int j) {
        char[] a = s.toCharArray();
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        return new String(a);
    }

    static void bfs(String start) {

        Queue<String> q = new LinkedList<>();
        Map<String, String> parent = new HashMap<>();

        q.add(start);
        parent.put(start, null);

        while (!q.isEmpty()) {

            String current = q.poll();

            if (current.equals(goal)) {
                printPath(parent, goal);
                return;
            }

            int zero = current.indexOf('0');
            int x = zero / 3;
            int y = zero % 3;

            for (int i = 0; i < 4; i++) {

                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < 3 &&
                    ny >= 0 && ny < 3) {

                    int next = nx * 3 + ny;
                    String child = swap(current, zero, next);

                    if (!parent.containsKey(child)) {
                        parent.put(child, current);
                        q.add(child);
                    }
                }
            }
        }

        System.out.println("No solution found!");
    }

    static void printPath(Map<String, String> parent,
                          String goal) {

        Stack<String> path = new Stack<>();

        String current = goal;

        while (current != null) {
            path.push(current);
            current = parent.get(current);
        }

        System.out.println("Solution using BFS:");

        while (!path.isEmpty()) {
            String s = path.pop();

            for (int i = 0; i < 9; i++) {
                System.out.print(s.charAt(i) + " ");
                if (i % 3 == 2)
                    System.out.println();
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        String start = "123406758";

        bfs(start);
    }
}
