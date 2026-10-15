
import java.util.Scanner;

public class MealPlanUpdater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] days = {
            "Monday", "Tuesday", "Wednesday",
            "Thursday", "Friday", "Saturday", "Sunday"
        };

        String[] meals = {
            "Idli", "Rice", "Dosa", "Chapati",
            "Biryani", "Pasta", "Fried Rice"
        };

        System.out.println("Weekly Meal Plan");

        for (int i = 0; i < 7; i++) {
            System.out.println(days[i] + ": " + meals[i]);
        }

        System.out.print("Enter day number to update (1-7): ");
        int day = sc.nextInt();
        sc.nextLine();

        if (day >= 1 && day <= 7) {
            System.out.print("Enter new meal: ");
            meals[day - 1] = sc.nextLine();

            System.out.println("Meal updated successfully!");
            System.out.println(days[day - 1] + ": " + meals[day - 1]);
        } else {
            System.out.println("Invalid day number!");
        }

        sc.close();
    }
}
