import java.util.Scanner;

public class VaccumCleaner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char a, b;
        char position;

        System.out.print("Enter status of Room A (D/C): ");
        a = sc.next().charAt(0);

        System.out.print("Enter status of Room B (D/C): ");
        b = sc.next().charAt(0);

        System.out.print("Enter starting position (A/B): ");
        position = sc.next().toUpperCase().charAt(0);

        while (a == 'D' || b == 'D') {

            if (position == 'A') {
                if (a == 'D') {
                    System.out.println("Room A is Dirty. Sucking...");
                    a = 'C';
                } else {
                    System.out.println("Room A is Clean. Moving Right...");
                    position = 'B';
                }
            }

            else if (position == 'B') {
                if (b == 'D') {
                    System.out.println("Room B is Dirty. Sucking...");
                    b = 'C';
                } else {
                    System.out.println("Room B is Clean. Moving Left...");
                    position = 'A';
                }
            }
        }

        System.out.println("Both rooms are clean!");
        System.out.println("Performance: Cleaning completed.");
        sc.close();
    }
}
    

