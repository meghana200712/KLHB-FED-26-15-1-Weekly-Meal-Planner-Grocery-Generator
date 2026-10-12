
import java.util.ArrayList;
import java.util.Scanner;
public class AddRemoveMeal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> meals = new ArrayList<>();
        int choice;
        do {
            System.out.println("\n=== MEAL MANAGER ===");
            System.out.println("1. Add Meal");
            System.out.println("2. View Meals");
            System.out.println("3. Update Meal");
            System.out.println("4. Remove Meal");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter meal name: ");
                    meals.add(sc.nextLine());
                    System.out.println("Meal added successfully.");
                    break;
                case 2:
                    if (meals.isEmpty()) {
                        System.out.println("No meals available.");
                    } else {
                        for (int i = 0; i < meals.size(); i++) {
                            System.out.println((i + 1) + ". " + meals.get(i));
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter meal number to update: ");
                    int update = sc.nextInt();
                    sc.nextLine();
                    if (update >= 1 && update <= meals.size()) {
                        System.out.print("Enter new meal name: ");
                        meals.set(update - 1, sc.nextLine());
                        System.out.println("Meal updated successfully.");
                    } else {
                        System.out.println("Invalid meal number.");
                    }
                   break;
                case 4:
                    System.out.print("Enter meal number to remove: ");
                    int remove = sc.nextInt();
                    sc.nextLine();
                    if (remove >= 1 && remove <= meals.size()) {
                        meals.remove(remove - 1);
                        System.out.println("Meal removed successfully.");
                    } else {
                        System.out.println("Invalid meal number.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting Meal Manager.");
                    break;
                default:
               System.out.println("Invalid choice.");
            }
        } while (choice != 5);
        sc.close();
    }
}
