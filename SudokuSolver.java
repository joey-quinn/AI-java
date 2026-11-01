
public class SudokuSolver {

    static int[][] grid = {
        {5, 3, 0, 0, 7, 0, 0, 0, 0},
        {6, 0, 0, 1, 9, 5, 0, 0, 0},
        {0, 9, 8, 0, 0, 0, 0, 6, 0},
        {8, 0, 0, 0, 6, 0, 0, 0, 3},
        {4, 0, 0, 8, 0, 3, 0, 0, 1},
        {7, 0, 0, 0, 2, 0, 0, 0, 6},
        {0, 6, 0, 0, 0, 0, 2, 8, 0},
        {0, 0, 0, 4, 1, 9, 0, 0, 5},
        {0, 0, 0, 0, 8, 0, 0, 7, 9}
    };

    static boolean isSafe(int row, int col, int num) {

        for (int i = 0; i < 9; i++) {

            if (grid[row][i] == num ||
                grid[i][col] == num)
                return false;
        }

        int startRow = row - row % 3;
        int startCol = col - col % 3;

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (grid[startRow + i][startCol + j] == num)
                    return false;

        return true;
    }

    static boolean solve() {

        for (int row = 0; row < 9; row++) {

            for (int col = 0; col < 9; col++) {

                if (grid[row][col] == 0) {

                    for (int num = 1; num <= 9; num++) {

                        if (isSafe(row, col, num)) {

                            grid[row][col] = num;

                            if (solve())
                                return true;

                            grid[row][col] = 0;
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    static void printSudoku() {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
                System.out.print(grid[i][j] + " ");

            System.out.println();
        }
    }

    public static void main(String[] args) {

        if (solve()) {
            System.out.println("Sudoku Solution:");
            printSudoku();
        } else {
            System.out.println("No solution exists!");
        }
    }
}

