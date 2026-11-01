
import java.util.*;

public class TSPBeamSearch {

    static int[][] dist = {
        {0, 10, 15, 20, 25},
        {10, 0, 35, 25, 17},
        {15, 35, 0, 30, 28},
        {20, 25, 30, 0, 12},
        {25, 17, 28, 12, 0}
    };

    static int n = 5;
    static int beamWidth = 3;

    static int cost(int[] path) {

        int total = 0;

        for (int i = 0; i < n - 1; i++)
            total += dist[path[i]][path[i + 1]];

        total += dist[path[n - 1]][path[0]];

        return total;
    }

    static String key(int[] path) {
        return Arrays.toString(path);
    }

    static void solve() {

        List<int[]> beam = new ArrayList<>();

        beam.add(new int[]{0, 1, 2, 3, 4});
        beam.add(new int[]{0, 2, 1, 3, 4});
        beam.add(new int[]{0, 3, 2, 1, 4});

        int[] bestPath = null;
        int bestCost = Integer.MAX_VALUE;

        for (int iteration = 0; iteration < 100; iteration++) {

            Map<String, int[]> candidates = new HashMap<>();

            for (int[] path : beam) {

                int currentCost = cost(path);

                if (currentCost < bestCost) {
                    bestCost = currentCost;
                    bestPath = path.clone();
                }

                for (int i = 1; i < n; i++) {
                    for (int j = i + 1; j < n; j++) {

                        int[] next = path.clone();

                        int temp = next[i];
                        next[i] = next[j];
                        next[j] = temp;

                        candidates.put(key(next), next);
                    }
                }
            }

            List<int[]> nextBeam =
                new ArrayList<>(candidates.values());

            nextBeam.sort(
                (a, b) -> Integer.compare(cost(a), cost(b))
            );

            beam = new ArrayList<>();

            for (int i = 0;
                 i < Math.min(beamWidth, nextBeam.size()); i++) {

                beam.add(nextBeam.get(i));
            }
        }

        System.out.println("Best Path:");

        for (int city : bestPath)
            System.out.print(city + " ");

        System.out.println("\nMinimum Distance: " + bestCost);
    }

    public static void main(String[] args) {
        solve();
    }
}
