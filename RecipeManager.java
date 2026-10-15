import java.util.ArrayList;
import java.util.Scanner;

class Recipe {
    String name;
    String ingredients;

    Recipe(String name, String ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    void display() {
        System.out.println("Recipe: " + name);
        System.out.println("Ingredients: " + ingredients);
    }
}

public class RecipeManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Recipe> recipes = new ArrayList<>();

        System.out.print("How many recipes do you want to add? ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter recipe name: ");
            String name = sc.nextLine();

            System.out.print("Enter ingredients: ");
            String ingredients = sc.nextLine();

            recipes.add(new Recipe(name, ingredients));
        }

        System.out.println("\nSaved Recipes:");
        for (Recipe recipe : recipes) {
            recipe.display();
            System.out.println();
        }

        sc.close();
    }
}