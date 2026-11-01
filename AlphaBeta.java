
public class AlphaBeta {

    static int minimax(int depth, int index,
                       boolean isMax,
                       int[] values,
                       int alpha, int beta) {

        if (depth == 3)
            return values[index];

        if (isMax) {

            int best = Integer.MIN_VALUE;

            for (int i = 0; i < 2; i++) {

                int val = minimax(depth + 1,
                    index * 2 + i, false,
                    values, alpha, beta);

                best = Math.max(best, val);
                alpha = Math.max(alpha, best);

                if (beta <= alpha)
                    break;
            }

            return best;

        } else {

            int best = Integer.MAX_VALUE;

            for (int i = 0; i < 2; i++) {

                int val = minimax(depth + 1,
                    index * 2 + i, true,
                    values, alpha, beta);

                best = Math.min(best, val);
                beta = Math.min(beta, best);

                if (beta <= alpha)
                    break;
            }

            return best;
        }
    }

    public static void main(String[] args) {

        int[] values = {3, 5, 6, 9, 1, 2, 0, -1};

        int result = minimax(
            0, 0, true, values,
            Integer.MIN_VALUE,
            Integer.MAX_VALUE
        );

        System.out.println("Optimal value: " + result);
    }
}
