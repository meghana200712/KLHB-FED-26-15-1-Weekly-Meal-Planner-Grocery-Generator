
import java.util.ArrayList;
import java.util.Scanner;
public class RecipeSearch {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
ArrayList<String> recipes = new ArrayList<>();
recipes.add("Idli");
recipes.add("Dosa");
recipes.add("Biryani");
recipes.add("Pasta");
recipes.add("Fried Rice");
recipes.add("Chapati");
System.out.println("=== RECIPE SEARCH ===");
System.out.print("Enter recipe name to search: ");
String search = sc.nextLine();
boolean found = false;
for (String recipe : recipes) {
if (recipe.equalsIgnoreCase(search.trim())) {
System.out.println("Recipe found: " + recipe);
found = true;
break;
}
}
if (!found) {
System.out.println("Recipe not found.");
}
sc.close();
}
}
