import java.util.Scanner;

public class BiryaniPlanner {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== BIRYANI MEAL & GROCERY PLANNER ===");
        System.out.print("What type of Biryani are you making? (e.g., Chicken, Mutton, Veg, Paneer): ");
        String biryaniType = sc.nextLine().trim();

        System.out.print("How many people are you cooking for? ");
        int people = sc.nextInt();

        System.out.println("\n-------------------------------------");
        System.out.println("GROCERY LIST FOR " + people + " PEOPLE (" + biryaniType.toUpperCase() + " BIRYANI):");
        System.out.println("-------------------------------------");

        // Base ingredients for any biryani
        System.out.println("- Basmati Rice: " + (people * 150) + " grams");
        System.out.println("- Onions: " + (people * 1) + " large");
        System.out.println("- Yogurt (Dahi): " + (people * 50) + " grams");
        System.out.println("- Biryani Masala & Spices (Cloves, Cardamom, Bay Leaf)");
        System.out.println("- Cooking Oil / Ghee");
        System.out.println("- Mint & Coriander leaves");

        // Specific main ingredient based on input
        String typeLower = biryaniType.toLowerCase();
        
        if (typeLower.contains("chicken")) {
            System.out.println("- Chicken: " + (people * 200) + " grams");
        } else if (typeLower.contains("mutton")) {
            System.out.println("- Mutton: " + (people * 200) + " grams");
        } else if (typeLower.contains("paneer")) {
            System.out.println("- Paneer: " + (people * 100) + " grams");
        } else {
            System.out.println("- Mixed Vegetables: " + (people * 150) + " grams");
        }

        System.out.println("\nDon't forget to prepare Raita for serving!");
        sc.close();
    }
}