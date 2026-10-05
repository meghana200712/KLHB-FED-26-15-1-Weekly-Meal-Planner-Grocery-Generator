import java.util.Scanner;
public class MealTypePlanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] days = {
            "Monday",
            "Tuesday",
            "Wednesday",
            "Thursday",
            "Friday",
            "Saturday",
            "Sunday"
        };
        String[] breakfast = new String[7];
        String[] lunch = new String[7];
        String[] dinner = new String[7];
        String[] snacks = new String[7];
        System.out.println("===== WEEKLY MEAL PLANNER =====");
            for (int i = 0; i < days.length; i++) {
            System.out.println("\nEnter meals for " + days[i]);
            System.out.print("Breakfast: ");
            breakfast[i] = sc.nextLine();
            System.out.print("Lunch: ");
            lunch[i] = sc.nextLine();
            System.out.print("Dinner: ");
            dinner[i] = sc.nextLine();
            System.out.print("Snacks: ");
            snacks[i] = sc.nextLine();
        }
        System.out.println("\n======================================");
        System.out.println("          YOUR WEEKLY MEAL PLAN       ");
        System.out.println("======================================");
        for (int i = 0; i < days.length; i++) {
            System.out.println("\n" + days[i]);
            System.out.println("Breakfast : " + breakfast[i]);
            System.out.println("Lunch     : " + lunch[i]);
            System.out.println("Dinner    : " + dinner[i]);
            System.out.println("Snacks    : " + snacks[i]);
        }

        sc.close();
    }
}

