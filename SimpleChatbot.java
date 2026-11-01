
import java.util.Scanner;

public class SimpleChatbot {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input;

        System.out.println("Chatbot: Hello! I am Java Bot.");
        System.out.println("Chatbot: How can I help you?");

        while (true) {

            System.out.print("You: ");
            input = sc.nextLine().toLowerCase();

            if (input.contains("hello") ||
                input.contains("hi")) {

                System.out.println("Bot: Hello! Nice to meet you.");

            } else if (input.contains("how are you")) {

                System.out.println("Bot: I am fine. How are you?");

            } else if (input.contains("name")) {

                System.out.println("Bot: My name is Java Bot.");

            } else if (input.contains("java")) {

                System.out.println("Bot: Java is an object-oriented programming language.");

            } else if (input.contains("help")) {

                System.out.println("Bot: Sure! Tell me what you need help with.");

            } else if (input.contains("bye")) {

                System.out.println("Bot: Goodbye! Have a nice day.");
                break;

            } else {

                System.out.println("Bot: Sorry, I don't understand.");
            }
        }

        sc.close();
    }
}
