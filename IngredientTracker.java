
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IngredientTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<String, Integer> ingredients = new HashMap<>();

        System.out.println("=== INGREDIENT TRACKER ===");
        System.out.println("Enter 4 ingredients and their quantities in grams.");

        for (int i = 1; i <= 4; i++) {
            System.out.print("Enter ingredient name: ");
            String name = sc.nextLine().trim();

            System.out.print("Enter quantity in grams: ");
            int quantity = sc.nextInt();
            sc.nextLine();

            if (quantity < 0 || name.isEmpty()) {
                System.out.println("Invalid input. Try again.");
                i--;
                continue;
            }

            ingredients.put(name, quantity);
        }

        System.out.println("\n=== GROCERY INGREDIENTS ===");

        for (Map.Entry<String, Integer> item : ingredients.entrySet()) {
            System.out.println(item.getKey() + " : "
                    + item.getValue() + " grams");
        }

        sc.close();
    }
}
