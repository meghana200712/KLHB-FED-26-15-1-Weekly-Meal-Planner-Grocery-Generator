import java.util.Scanner;

public class MealPlanner {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] meals = new String[7];

        System.out.println("Weekly Meal Planner");

        for (int i = 0; i < 7; i++) {
            System.out.print("Enter meal for Day " + (i + 1) + ": ");
            meals[i] = sc.nextLine();
        }

        System.out.println("\nYour Meal Plan");

        for (int i = 0; i < 7; i++) {
            System.out.println("Day " + (i + 1) + " : " + meals[i]);
        }

        System.out.println("\nGrocery Items Needed:");
        System.out.println("- Rice");
        System.out.println("- Vegetables");
        System.out.println("- Milk");
        System.out.println("- Eggs");
        System.out.println("- Fruits");

        sc.close();
    }
}