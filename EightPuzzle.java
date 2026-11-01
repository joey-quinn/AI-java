
import java.util.*;

public class EightPuzzle {

    static class Node {
        int[][] board;
        int g, h;
        Node parent;

        Node(int[][] b, int g, Node p) {
            board = new int[3][3];

            for (int i = 0; i < 3; i++)
                board[i] = b[i].clone();

            this.g = g;
            this.parent = p;
            this.h = heuristic(board);
        }

        int f() {
            return g + h;
        }
    }

    static int[][] goal = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 0}
    };

    static int heuristic(int[][] b) {
        int count = 0;

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (b[i][j] != 0 &&
                    b[i][j] != goal[i][j])
                    count++;

        return count;
    }

    static String key(int[][] b) {
        String s = "";
        for (int[] row : b)
            for (int x : row)
                s += x;
        return s;
    }

    static void printBoard(int[][] b) {
        for (int[] row : b)
            System.out.println(Arrays.toString(row));
        System.out.println();
    }

    static void solve(int[][] start) {

        PriorityQueue<Node> pq =
            new PriorityQueue<>(
                (a, b) -> Integer.compare(a.f(), b.f())
            );

        HashSet<String> visited = new HashSet<>();

        pq.add(new Node(start, 0, null));

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!pq.isEmpty()) {

            Node current = pq.poll();
            String k = key(current.board);

            if (visited.contains(k))
                continue;

            visited.add(k);

            if (current.h == 0) {
                System.out.println("Solution found!");

                Stack<Node> path = new Stack<>();
                while (current != null) {
                    path.push(current);
                    current = current.parent;
                }

                while (!path.isEmpty())
                    printBoard(path.pop().board);

                return;
            }

            int x = 0, y = 0;

            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++)
                    if (current.board[i][j] == 0) {
                        x = i;
                        y = j;
                    }

            for (int i = 0; i < 4; i++) {

                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < 3 &&
                    ny >= 0 && ny < 3) {

                    int[][] next = new int[3][3];

                    for (int r = 0; r < 3; r++)
                        next[r] = current.board[r].clone();

                    next[x][y] = next[nx][ny];
                    next[nx][ny] = 0;

                    if (!visited.contains(key(next)))
                        pq.add(new Node(next,
                            current.g + 1, current));
                }
            }
        }

        System.out.println("No solution found!");
    }

    public static void main(String[] args) {

        int[][] start = {
            {1, 2, 3},
            {4, 0, 6},
            {7, 5, 8}
        };

        solve(start);
    }
}

