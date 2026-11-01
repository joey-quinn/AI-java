public class DFSWaterJug {

    static boolean[][] visited = new boolean[5][4];

    static boolean dfs(int a, int b) {

        if (a == 2) {
            System.out.println("Goal Reached: (" + a + "," + b + ")");
            return true;
        }

        if (visited[a][b])
            return false;

        visited[a][b] = true;

        System.out.println("Current State: (" + a + "," + b + ")");

        // 1. Fill 4 litre jug
        if (dfs(4, b))
            return true;

        // 2. Fill 3 litre jug
        if (dfs(a, 3))
            return true;

        // 3. Empty 4 litre jug
        if (dfs(0, b))
            return true;

        // 4. Empty 3 litre jug
        if (dfs(a, 0))
            return true;

        // 5. Pour 4 litre jug into 3 litre jug
        int pour = Math.min(a, 3 - b);
        if (dfs(a - pour, b + pour))
            return true;

        // 6. Pour 3 litre jug into 4 litre jug
        pour = Math.min(b, 4 - a);
        if (dfs(a + pour, b - pour))
            return true;

        return false;
    }

    public static void main(String[] args) {

        System.out.println("Water Jug Problem using DFS");

        if (!dfs(0, 0))
            System.out.println("No solution found!");
    }
}

