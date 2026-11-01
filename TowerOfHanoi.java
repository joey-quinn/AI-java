
import java.util.Scanner;

public class TowerOfHanoi {

    static int count = 0;

    static void solve(int n, char source,
                      char auxiliary, char destination) {

        if (n == 1) {
            System.out.println(
                "Move disk 1 from " +
                source + " to " + destination
            );
            count++;
            return;
        }

        solve(n - 1, source, destination, auxiliary);

        System.out.println(
            "Move disk " + n + " from " +
            source + " to " + destination
        );

        count++;

        solve(n - 1, auxiliary, source, destination);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of disks: ");
        int n = sc.nextInt();

        solve(n, 'A', 'B', 'C');

        System.out.println("Total moves: " + count);

        sc.close();
    }
}
