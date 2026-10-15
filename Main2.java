
import java.util.Scanner;

public class LeftoverMealPlanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("LEFTOVER MEAL PLANNER");
        System.out.print("Do you have rice? (yes/no): ");
        String rice = sc.nextLine();

        System.out.print("Do you have vegetables? (yes/no): ");
        String vegetables = sc.nextLine();

        System.out.print("Do you have eggs? (yes/no): ");
        String eggs = sc.nextLine();

        if (rice.equalsIgnoreCase("yes")
                && vegetables.equalsIgnoreCase("yes")) {
            System.out.println("Suggested meal: Vegetable Fried Rice");
        } else if (rice.equalsIgnoreCase("yes")
                && eggs.equalsIgnoreCase("yes")) {
            System.out.println("Suggested meal: Egg Rice");
        } else if (vegetables.equalsIgnoreCase("yes")) {
            System.out.println("Suggested meal: Vegetable Curry");
        } else if (eggs.equalsIgnoreCase("yes")) {
            System.out.println("Suggested meal: Egg Omelette");
        } else {
            System.out.println("Suggested meal: Plan a meal using available ingredients.");
        }

        sc.close();
    }
}
