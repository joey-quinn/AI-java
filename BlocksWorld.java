
import java.util.*;

public class BlocksWorld {

    static Stack<String> plan = new Stack<>();

    public static void main(String[] args) {

        System.out.println("Initial State:");
        System.out.println("A is on Table");
        System.out.println("B is on Table");
        System.out.println("C is on A");

        // Goal stack planning

        plan.push("STACK A ON B");
        plan.push("PICKUP A");
        plan.push("PUTDOWN C");
        plan.push("UNSTACK C FROM A");

        System.out.println("\nExecuting Plan:");

        while (!plan.isEmpty()) {

            String action = plan.pop();

            System.out.println(action);
        }

        System.out.println("\nGoal State Achieved:");

        System.out.println("A is on B");
        System.out.println("B is on Table");
        System.out.println("C is on Table");
    }
}
