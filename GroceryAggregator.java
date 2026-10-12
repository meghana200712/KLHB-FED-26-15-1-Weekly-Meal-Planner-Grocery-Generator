
import java.util.HashMap;
import java.util.Map;

public class GroceryAggregator {
    public static void main(String[] args) {

        HashMap<String, Integer> groceries = new HashMap<>();

        addIngredient(groceries, "Rice", 500);
        addIngredient(groceries, "Onion", 200);
        addIngredient(groceries, "Rice", 300);
        addIngredient(groceries, "Tomato", 150);
        addIngredient(groceries, "Onion", 100);
        addIngredient(groceries, "Rice", 200);

        System.out.println("=== COMBINED GROCERY LIST ===");

        for (Map.Entry<String, Integer> item : groceries.entrySet()) {
            System.out.println(item.getKey() + " : "
                    + item.getValue() + " grams");
        }
    }

    static void addIngredient(
            HashMap<String, Integer> groceries,
            String name,
            int quantity) {

        groceries.put(
            name,
            groceries.getOrDefault(name, 0) + quantity
        );
    }
}
