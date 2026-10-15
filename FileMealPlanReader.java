import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileMealPlanReader {
public static void main(String[] args) {
try {
BufferedReader reader = new BufferedReader(
new FileReader("mealplan.txt")
);

String line;

System.out.println("Saved Weekly Meal Plan:");

while ((line = reader.readLine()) != null) {
System.out.println(line);
}

reader.close();
} catch (IOException e) {
System.out.println(
"Unable to read mealplan.txt. Check whether the file exists."
);
}
}
}