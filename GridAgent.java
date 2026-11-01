import java.util.*;

public class GridAgent {

    static int[][] grid = {
        {0, 0, 1, 0},
        {1, 0, 1, 0},
        {0, 0, 0, 0},
        {0, 1, 1, 0}
    };

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static String[] direction = {
        "UP", "DOWN", "LEFT", "RIGHT"
    };

    static boolean[][] visited = new boolean[4][4];
    static int[][] parentX = new int[4][4];
    static int[][] parentY = new int[4][4];

    static boolean bfs(int sx, int sy, int gx, int gy) {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sx, sy});
        visited[sx][sy] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();

            int x = current[0];
            int y = current[1];

            if (x == gx && y == gy)
                return true;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4
                    && grid[nx][ny] == 0 && !visited[nx][ny]) {

                    visited[nx][ny] = true;
                    parentX[nx][ny] = x;
                    parentY[nx][ny] = y;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int sx = 0, sy = 0;
        int gx = 3, gy = 3;

        if (bfs(sx, sy, gx, gy)) {

            Stack<String> path = new Stack<>();

            int x = gx, y = gy;

            while (x != sx || y != sy) {
                int px = parentX[x][y];
                int py = parentY[x][y];

                if (x < px) path.push("UP");
                else if (x > px) path.push("DOWN");
                else if (y < py) path.push("LEFT");
                else path.push("RIGHT");

                x = px;
                y = py;
            }

            System.out.println("Path found:");
            while (!path.isEmpty())
                System.out.println(path.pop());

        } else {
            System.out.println("No path found!");
        }
    }
}

