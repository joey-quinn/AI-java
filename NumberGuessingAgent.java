
import java.util.Scanner;

public class NumberGuessingAgent {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int low = 1;
        int high = 100;
        int guess;
        String feedback;

        System.out.println("Think of a number between 1 and 100.");

        while (low <= high) {

            guess = (low + high) / 2;

            System.out.println("Agent guesses: " + guess);

            System.out.print("Enter feedback (higher/lower/correct): ");
            feedback = sc.next().toLowerCase();

            if (feedback.equals("correct")) {

                System.out.println("Agent guessed correctly!");
                break;

            } else if (feedback.equals("higher")) {

                low = guess + 1;

            } else if (feedback.equals("lower")) {

                high = guess - 1;

            } else {

                System.out.println("Invalid feedback!");
            }
        }

        if (low > high)
            System.out.println("Inconsistent feedback!");

        sc.close();
    }
}
