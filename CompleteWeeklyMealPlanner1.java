
import java.util.*;
import java.io.*;

public class CompleteWeeklyMealPlanner1 {

    static Scanner sc = new Scanner(System.in);

    static String[] days = {
        "Monday", "Tuesday", "Wednesday", "Thursday",
        "Friday", "Saturday", "Sunday"
    };

    static String[] mealTypes = {
        "Breakfast", "Lunch", "Dinner", "Snacks"
    };

    static String[][] mealPlan = new String[7][4];
    static ArrayList<String> groceries = new ArrayList<>();
    static HashMap<String, java.lang.Integer> pantry = new HashMap<>();
    static ArrayList<Recipe> recipes = new ArrayList<>();

    static double weeklyBudget = 0;
    static double totalFoodWaste = 0;

    static class Recipe {
        String name;
        String ingredients;
        double protein;

        Recipe(String name, String ingredients, double protein) {
            this.name = name;
            this.ingredients = ingredients;
            this.protein = protein;
        }

        void display() {
            System.out.println("Recipe: " + name);
            System.out.println("Ingredients: " + ingredients);
            System.out.println("Protein: " + protein + " grams per serving");
        }
    }

    static void initializeMeals() {
        String[][] defaults = {
            {"Idli", "Rice", "Chapati", "Fruit"},
            {"Dosa", "Vegetable Rice", "Dal Rice", "Nuts"},
            {"Poha", "Curd Rice", "Paneer Curry", "Banana"},
            {"Upma", "Chapati", "Vegetable Pulao", "Biscuits"},
            {"Pongal", "Rice", "Biryani", "Apple"},
            {"Dosa", "Fried Rice", "Pasta", "Nuts"},
            {"Puri", "Meals", "Chapati", "Fruit"}
        };

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 4; j++) {
                mealPlan[i][j] = defaults[i][j];
            }
        }

        recipes.add(new Recipe("Vegetable Rice", "Rice, vegetables, oil", 5));
        recipes.add(new Recipe("Paneer Curry", "Paneer, tomato, onion", 15));
        recipes.add(new Recipe("Dal Rice", "Rice, dal, spices", 8));
    }

    static int readInt() {
        while (true) {
            try {
                return java.lang.Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Enter a valid whole number: ");
            }
        }
    }

    static double readDouble() {
        while (true) {
            try {
                double value = Double.parseDouble(sc.nextLine().trim());

                if (Double.isFinite(value)) {
                    return value;
                }
            } catch (NumberFormatException e) {
            }

            System.out.print("Enter a valid number: ");
        }
    }

    static int readIntAfterPrompt(String prompt) {
        System.out.print(prompt);
        return readInt();
    }

    static double readDoubleAfterPrompt(String prompt) {
        System.out.print(prompt);
        return readDouble();
    }

    static void viewMealPlan() {
        System.out.println("\nWEEKLY MEAL PLAN");

        for (int i = 0; i < 7; i++) {
            System.out.println("\n" + days[i]);

            for (int j = 0; j < 4; j++) {
                System.out.println(mealTypes[j] + ": " + mealPlan[i][j]);
            }
        }
    }

    static void updateMeal() {
        System.out.println("\nSelect a day:");

        for (int i = 0; i < 7; i++) {
            System.out.println((i + 1) + ". " + days[i]);
        }

        int day = readIntAfterPrompt("Enter day number: ");

        if (day < 1 || day > 7) {
            System.out.println("Invalid day!");
            return;
        }

        System.out.println("\nSelect meal type:");

        for (int i = 0; i < 4; i++) {
            System.out.println((i + 1) + ". " + mealTypes[i]);
        }

        int type = readIntAfterPrompt("Enter meal type number: ");

        if (type < 1 || type > 4) {
            System.out.println("Invalid meal type!");
            return;
        }

        System.out.print("Enter new meal: ");
        String meal = sc.nextLine().trim();

        if (meal.isEmpty()) {
            System.out.println("Meal name cannot be empty.");
            return;
        }

        mealPlan[day - 1][type - 1] = meal;
        System.out.println("Meal updated successfully!");
    }

    static void manageRecipes() {
        System.out.println("\n1. Add recipe");
        System.out.println("2. View recipes");
        System.out.println("3. Search recipe");

        int choice = readIntAfterPrompt("Choose option: ");

        if (choice == 1) {
            System.out.print("Recipe name: ");
            String name = sc.nextLine().trim();

            System.out.print("Ingredients: ");
            String ingredients = sc.nextLine().trim();

            double protein = readDoubleAfterPrompt(
                "Protein per serving (grams): ");

            if (name.isEmpty() || ingredients.isEmpty() || protein < 0) {
                System.out.println("Enter valid recipe details.");
                return;
            }

            recipes.add(new Recipe(name, ingredients, protein));
            System.out.println("Recipe added successfully!");

        } else if (choice == 2) {
            if (recipes.isEmpty()) {
                System.out.println("No recipes available.");
                return;
            }

            for (Recipe recipe : recipes) {
                recipe.display();
                System.out.println();
            }

        } else if (choice == 3) {
            System.out.print("Enter recipe name to search: ");
            String search = sc.nextLine().trim();

            boolean found = false;

            for (Recipe recipe : recipes) {
                if (recipe.name.equalsIgnoreCase(search)) {
                    recipe.display();
                    found = true;
                }
            }

            if (!found) {
                System.out.println("Recipe not found.");
            }

        } else {
            System.out.println("Invalid option!");
        }
    }

    static void managePantry() {
        System.out.println("\n1. Add or update ingredient");
        System.out.println("2. View pantry");
        System.out.println("3. Check ingredient");

        int choice = readIntAfterPrompt("Choose option: ");

        if (choice == 1) {
            System.out.print("Ingredient name: ");
            String name = sc.nextLine().trim();

            int quantity = readIntAfterPrompt("Quantity in grams: ");

            if (name.isEmpty() || quantity < 0) {
                System.out.println("Enter valid ingredient details.");
                return;
            }

            pantry.put(name, java.lang.Integer.valueOf(quantity));
            System.out.println("Pantry updated!");

        } else if (choice == 2) {
            if (pantry.isEmpty()) {
                System.out.println("Pantry is empty.");
                return;
            }

            for (String item : pantry.keySet()) {
                System.out.println(item + ": " + pantry.get(item) + " grams");
            }

        } else if (choice == 3) {
            System.out.print("Enter ingredient name: ");
            String name = sc.nextLine().trim();

            if (pantry.containsKey(name)) {
                System.out.println(name + ": " + pantry.get(name) + " grams");
            } else {
                System.out.println("Ingredient not found.");
            }

        } else {
            System.out.println("Invalid option!");
        }
    }

    static void manageGroceries() {
        System.out.println("\n1. Add grocery");
        System.out.println("2. View grocery list");
        System.out.println("3. Calculate quantity for more people");

        int choice = readIntAfterPrompt("Choose option: ");

        if (choice == 1) {
            System.out.print("Enter grocery item: ");
            String item = sc.nextLine().trim();

            if (item.isEmpty()) {
                System.out.println("Grocery name cannot be empty.");
                return;
            }

            for (String grocery : groceries) {
                if (grocery.equalsIgnoreCase(item)) {
                    System.out.println("Duplicate item not added.");
                    return;
                }
            }

            groceries.add(item);
            System.out.println("Grocery added!");

        } else if (choice == 2) {
            System.out.println("\nGROCERY LIST");

            if (groceries.isEmpty()) {
                System.out.println("No grocery items added.");
                return;
            }

            for (String item : groceries) {
                System.out.println("- " + item);
            }

        } else if (choice == 3) {
            double quantity = readDoubleAfterPrompt(
                "Enter quantity for one person: ");

            int count = readIntAfterPrompt("Enter number of people: ");

            if (quantity < 0 || count < 1) {
                System.out.println("Invalid quantity or people count.");
                return;
            }

            System.out.println("Total required quantity: " + (quantity * count));

        } else {
            System.out.println("Invalid option!");
        }
    }

    static void calculateBudget() {
        double total = 0;

        for (String day : days) {
            double cost = readDoubleAfterPrompt(
                "Enter total food cost for " + day + ": Rs. ");

            if (cost < 0) {
                System.out.println("Cost cannot be negative.");
                return;
            }

            total += cost;
        }

        weeklyBudget = total;

        System.out.println("Weekly food budget: Rs. " + weeklyBudget);
        System.out.printf("Average daily cost: Rs. %.2f%n", weeklyBudget / 7);
    }

    static void calculateProtein() {
        if (recipes.isEmpty()) {
            System.out.println("No recipes available.");
            return;
        }

        System.out.println("\nAvailable recipes:");

        for (int i = 0; i < recipes.size(); i++) {
            System.out.println((i + 1) + ". " + recipes.get(i).name);
        }

        int choice = readIntAfterPrompt("Select recipe number: ");

        if (choice < 1 || choice > recipes.size()) {
            System.out.println("Invalid recipe number!");
            return;
        }

        int servings = readIntAfterPrompt("Number of servings: ");

        if (servings < 1) {
            System.out.println("Servings must be at least 1.");
            return;
        }

        Recipe selected = recipes.get(choice - 1);

        System.out.println("Estimated total protein: "
            + (selected.protein * servings) + " grams");
    }

    static void trackFoodWaste() {
        double waste = readDoubleAfterPrompt("Enter food waste in grams: ");

        if (waste < 0) {
            System.out.println("Waste cannot be negative.");
            return;
        }

        totalFoodWaste += waste;

        System.out.println("Total recorded food waste: "
            + totalFoodWaste + " grams");
    }

    static void planBiryani() {
        System.out.println("\n1. Chicken");
        System.out.println("2. Mutton");
        System.out.println("3. Vegetable");
        System.out.println("4. Paneer");

        int choice = readIntAfterPrompt("Enter choice: ");

        if (choice < 1 || choice > 4) {
            System.out.println("Invalid choice!");
            return;
        }

        int count = readIntAfterPrompt("Number of people: ");

        if (count < 1) {
            System.out.println("People count must be at least 1.");
            return;
        }

        String[] types = {"Chicken", "Mutton", "Vegetable", "Paneer"};

        System.out.println("\n" + types[choice - 1] + " Biryani");
        System.out.println("For " + count + " people:");
        System.out.println("Rice: " + (100L * count) + " grams");

        if (choice == 1 || choice == 2) {
            System.out.println("Meat: " + (150L * count) + " grams");
        } else if (choice == 3) {
            System.out.println("Vegetables: " + (150L * count) + " grams");
        } else {
            System.out.println("Paneer: " + (150L * count) + " grams");
        }

        System.out.println("Onion: " + (50L * count) + " grams");
        System.out.println("Oil: " + (15L * count) + " ml");
    }

    static void saveMealPlan() {
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("mealplan.txt"))) {

            writer.write("WEEKLY MEAL PLAN");
            writer.newLine();

            for (int i = 0; i < 7; i++) {
                writer.newLine();
                writer.write(days[i]);
                writer.newLine();

                for (int j = 0; j < 4; j++) {
                    writer.write(mealTypes[j] + ": " + mealPlan[i][j]);
                    writer.newLine();
                }
            }

            writer.newLine();
            writer.write("GROCERY LIST");
            writer.newLine();

            for (String item : groceries) {
                writer.write(item);
                writer.newLine();
            }

            System.out.println("Meal plan saved to mealplan.txt!");

        } catch (IOException e) {
            System.out.println("Error saving meal plan.");
        }
    }

    static void readMealPlan() {
        try (BufferedReader reader = new BufferedReader(
                new FileReader("mealplan.txt"))) {

            String line;

            System.out.println("\nSAVED MEAL PLAN");

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("File not found. Save a meal plan first.");
        }
    }

    public static void main(String[] args) {
        initializeMeals();

        while (true) {
            System.out.println("\n===== WEEKLY MEAL PLANNER =====");
            System.out.println("1. View weekly meal plan");
            System.out.println("2. Update a meal");
            System.out.println("3. Recipe manager");
            System.out.println("4. Pantry inventory");
            System.out.println("5. Grocery list and quantities");
            System.out.println("6. Weekly food budget");
            System.out.println("7. Calculate recipe protein");
            System.out.println("8. Track food waste");
            System.out.println("9. Biryani ingredient planner");
            System.out.println("10. Save meal plan");
            System.out.println("11. Read saved meal plan");
            System.out.println("0. Exit");

            int choice = readIntAfterPrompt("Enter your choice: ");

            switch (choice) {
                case 1:
                    viewMealPlan();
                    break;
                case 2:
                    updateMeal();
                    break;
                case 3:
                    manageRecipes();
                    break;
                case 4:
                    managePantry();
                    break;
                case 5:
                    manageGroceries();
                    break;
                case 6:
                    calculateBudget();
                    break;
                case 7:
                    calculateProtein();
                    break;
                case 8:
                    trackFoodWaste();
                    break;
                case 9:
                    planBiryani();
                    break;
                case 10:
                    saveMealPlan();
                    break;
                case 11:
                    readMealPlan();
                    break;
                case 0:
                    System.out.println("Thank you for using the planner!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
