
import java.util.Scanner;

public class WeeklyMealBudget { 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] days = {"Monday", "Tuesday", "Wednesday",
                         "Thursday", "Friday", "Saturday", "Sunday"};

        double total = 0;

        for (int i = 0; i < 7; i++) {
            System.out.println("\n" + days[i]);
            System.out.print("Enter meal name: ");
            String meal = sc.nextLine();

            System.out.print("Enter meal cost: ");
            double cost = sc.nextDouble();
            sc.nextLine();

            total = total + cost;
            System.out.println("Planned meal: " + meal);
        }

        System.out.println("\nWeekly food budget: Rs. " + total);
        System.out.println("Average daily cost: Rs. " + total / 7);

        sc.close();
    }
}
