public class WeeklyMealPlan {

    public static void main(String[] args) {

        String[] days = {
            "Monday",
            "Tuesday",
            "Wednesday",
            "Thursday",
            "Friday",
            "Saturday",
            "Sunday"
        };

        String[] meals = {
            "Idli",
            "Dosa",
            "Rice",
            "Chapati",
            "Biryani",
            "Pasta",
            "Fried Rice"
        };

        System.out.println("===== WEEKLY MEAL PLAN =====");

        for (int i = 0; i < days.length; i++) {
            System.out.println(days[i] + " : " + meals[i]);
        }
    }
}