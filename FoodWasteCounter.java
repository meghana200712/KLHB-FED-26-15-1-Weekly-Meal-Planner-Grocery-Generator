
import java.util.Scanner;

public class FoodWasteCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double total = 0;

        System.out.println("WEEKLY FOOD WASTE COUNTER");
        System.out.println("-------------------------");

        for (int i = 1; i <= 7; i++) {
            System.out.print("Enter food wasted on day " + i + " in grams: ");
            double waste = sc.nextDouble();

            if (waste < 0) {
                System.out.println("Invalid quantity. Using 0 grams.");
                waste = 0;
            }

            total = total + waste;
        }

        System.out.println("\nWEEKLY REPORT");
        System.out.println("Total food waste: " + total + " grams");
        System.out.println("Average daily waste: " + total / 7 + " grams");

        if (total > 1000) {
            System.out.println("Suggestion: Reduce food waste by planning portions.");
        } else {
            System.out.println("Good job! Keep reducing food waste.");
        }

        sc.close();
    }
}
