
import java.util.Scanner;

public class QuantityCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== INGREDIENT QUANTITY CALCULATOR ===");

        System.out.print("Enter number of people: ");
        int people = sc.nextInt();

        if (people <= 0) {
            System.out.println("Please enter a valid number of people.");
        } else {
            System.out.println("\nIngredients required for " + people + " people:");

            System.out.println("Rice: " + (people * 150) + " grams");
            System.out.println("Vegetables: " + (people * 100) + " grams");
            System.out.println("Onions: " + people);
            System.out.println("Oil: " + (people * 10) + " ml");
        }

        sc.close();
    }
}
