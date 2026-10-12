
public class ProteinMealPlanner {
    public static void main(String[] args) {

        String[] days = {
            "Monday", "Tuesday", "Wednesday",
            "Thursday", "Friday", "Saturday", "Sunday"
        };

        String[] foods = {
            "Chicken", "Soya", "Eggs",
            "Paneer", "Chicken", "Dal", "Fish"
        };

        int[] protein = {100, 50, 18, 20, 100, 15, 25};

        int totalProtein = 0;

        System.out.println("WEEKLY PROTEIN MEAL PLANNER");
        System.out.println("---------------------------");

        for (int i = 0; i < 7; i++) {
            System.out.println(days[i] + ": Eat " + foods[i]
                    + " - " + protein[i] + " grams protein");

            totalProtein = totalProtein + protein[i];
        }

        System.out.println("---------------------------");
        System.out.println("Total weekly protein: "
                + totalProtein + " grams");

        System.out.println("Average daily protein: "
                + totalProtein / 7 + " grams");

    }
}
