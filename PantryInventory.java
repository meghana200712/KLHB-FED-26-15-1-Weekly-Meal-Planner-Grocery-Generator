
import java.util.HashMap;
import java.util.Scanner;

public class PantryInventory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> pantry = new HashMap<>();

        System.out.print("How many ingredients do you want to add? ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter ingredient name: ");
            String name = sc.nextLine();

            System.out.print("Enter quantity in grams: ");
            int quantity = sc.nextInt();
            sc.nextLine();

            pantry.put(name, quantity);
        }

        System.out.println("\nPantry Inventory:");
        for (String ingredient : pantry.keySet()) {
            System.out.println(
                ingredient + ": " + pantry.get(ingredient) + " grams"
            );
        }

        System.out.print("\nEnter ingredient to check: ");
        String search = sc.nextLine();

        if (pantry.containsKey(search)) {
            System.out.println(
                search + " available: " + pantry.get(search) + " grams"
            );
        } else {
            System.out.println("Ingredient not found in pantry.");
        }

        sc.close();
    }
}
