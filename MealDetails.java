import java.util.Scanner;
class Meal {
    String mealName;
    String mealType;
    String ingredients;
    Meal(String mealName, String mealType, String ingredients) {
        this.mealName = mealName;
        this.mealType = mealType;
        this.ingredients = ingredients;
    }
    void displayMeal() {
        System.out.println("\n----- MEAL DETAILS -----");
        System.out.println("Meal Name  : " + mealName);
        System.out.println("Meal Type  : " + mealType);
        System.out.println("Ingredients: " + ingredients);
    }
}
public class MealDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("===== MEAL DETAILS =====");
        System.out.print("Enter meal name: ");
        String name = sc.nextLine();
        System.out.print("Enter meal type (Breakfast/Lunch/Dinner/Snacks): ");
        String type = sc.nextLine();
        System.out.print("Enter ingredients: ");
        String ingredients = sc.nextLine();
        Meal meal = new Meal(name, type, ingredients);
        meal.displayMeal();
        sc.close();
    }
}
