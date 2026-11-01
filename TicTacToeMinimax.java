
import java.util.Scanner;

public class TicTacToeMinimax {

    static char[] board = {
        '1','2','3',
        '4','5','6',
        '7','8','9'
    };

    static char AI = 'X';
    static char HUMAN = 'O';

    static void printBoard() {

        System.out.println();

        for (int i = 0; i < 9; i++) {

            System.out.print(board[i] + " ");

            if (i % 3 == 2)
                System.out.println();
        }

        System.out.println();
    }

    static boolean checkWin(char player) {

        int[][] win = {
            {0,1,2}, {3,4,5}, {6,7,8},
            {0,3,6}, {1,4,7}, {2,5,8},
            {0,4,8}, {2,4,6}
        };

        for (int[] w : win) {

            if (board[w[0]] == player &&
                board[w[1]] == player &&
                board[w[2]] == player)
                return true;
        }

        return false;
    }

    static boolean isFull() {

        for (int i = 0; i < 9; i++)
            if (board[i] != 'X' && board[i] != 'O')
                return false;

        return true;
    }

    static int minimax(boolean isMax) {

        if (checkWin(AI))
            return 10;

        if (checkWin(HUMAN))
            return -10;

        if (isFull())
            return 0;

        if (isMax) {

            int best = -1000;

            for (int i = 0; i < 9; i++) {

                if (board[i] != 'X' && board[i] != 'O') {

                    char temp = board[i];
                    board[i] = AI;

                    best = Math.max(best, minimax(false));

                    board[i] = temp;
                }
            }

            return best;

        } else {

            int best = 1000;

            for (int i = 0; i < 9; i++) {

                if (board[i] != 'X' && board[i] != 'O') {

                    char temp = board[i];
                    board[i] = HUMAN;

                    best = Math.min(best, minimax(true));

                    board[i] = temp;
                }
            }

            return best;
        }
    }

    static void aiMove() {

        int bestValue = -1000;
        int bestMove = -1;

        for (int i = 0; i < 9; i++) {

            if (board[i] != 'X' && board[i] != 'O') {

                char temp = board[i];
                board[i] = AI;

                int value = minimax(false);

                board[i] = temp;

                if (value > bestValue) {
                    bestValue = value;
                    bestMove = i;
                }
            }
        }

        if (bestMove != -1)
            board[bestMove] = AI;

        System.out.println("AI played!");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Tic Tac Toe using Minimax");
        System.out.println("You are O, AI is X");

        while (true) {

            printBoard();

            System.out.print("Enter position (1-9): ");
            int pos = sc.nextInt() - 1;

            if (pos < 0 || pos >= 9 ||
                board[pos] == 'X' || board[pos] == 'O') {

                System.out.println("Invalid move!");
                continue;
            }

            board[pos] = HUMAN;

            if (checkWin(HUMAN)) {
                printBoard();
                System.out.println("You win!");
                break;
            }

            if (isFull()) {
                printBoard();
                System.out.println("Game Draw!");
                break;
            }

            aiMove();

            if (checkWin(AI)) {
                printBoard();
                System.out.println("AI wins!");
                break;
            }

            if (isFull()) {
                printBoard();
                System.out.println("Game Draw!");
                break;
            }
        }

        sc.close();
    }
}
