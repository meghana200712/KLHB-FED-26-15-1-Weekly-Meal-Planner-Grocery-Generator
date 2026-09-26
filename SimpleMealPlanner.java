import java.util.ArrayList;
import java.util.Scanner;

public class SimpleMealPlanner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Days of the week
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        
        // Array to hold meals for each day
        String[] meals = new String[7];

        // List to collect all grocery items
        ArrayList<String> groceryList = new ArrayList<>();

        System.out.println("=== WEEKLY MEAL PLANNER ===");
        System.out.println("Enter a meal for each day of the week.\n");

        // Step 1: Input meals for each day
        for (int i = 0; i < days.length; i++) {
            System.out.print("Enter meal for " + days[i] + ": ");
            meals[i] = scanner.nextLine();
        }

        // Step 2: Input ingredients for the grocery list
        System.out.println("\n=== GROCERY LIST GENERATOR ===");
        System.out.println("Enter grocery items needed for these meals (Type 'done' when finished):");

        while (true) {
            System.out.print("Add item: ");
            String item = scanner.nextLine();

            // Stop taking input if user types 'done'
            if (item.equalsIgnoreCase("done")) {
                break;
            }

            if (!item.trim().isEmpty()) {
                groceryList.add(item);
            }
        }

        // Step 3: Display the Weekly Meal Plan
        System.out.println("\n=================================");
        System.out.println("       YOUR WEEKLY MEAL PLAN     ");
        System.out.println("=================================");
        for (int i = 0; i < days.length; i++) {
            System.out.println(days[i] + ": " + meals[i]);
        }

        // Step 4: Display the Grocery List
        System.out.println("\n=================================");
        System.out.println("         GROCERY LIST            ");
        System.out.println("=================================");
        if (groceryList.isEmpty()) {
            System.out.println("No items added to the grocery list.");
        } else {
            for (int i = 0; i < groceryList.size(); i++) {
                System.out.println((i + 1) + ". " + groceryList.get(i));
            }
        }

        scanner.close();
    }
}