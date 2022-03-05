import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        // Instantiate the grades map
        List<StudentGrade> grades = new ArrayList<>();

        // Get the day of the week as an integer (Monday = 1, Sunday = 7)
        int dayOfWeek = LocalDate.now().getDayOfWeek().getValue();

        // Get how many points to increase or decrease from the arguments
        double pointsToAlter = Double.parseDouble(args[1]);

        // Read the CSV file, get the file name from the arguments
        Scanner scanner = new Scanner(new File(args[0]));

        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            grades.add(new StudentGrade(Integer.parseInt(line.split(",")[0]),
                    Double.parseDouble(line.split(",")[1])));
        }
        scanner.close();

        // Instantiate the BiasGrading class and start grading
        StudentGrade[] gradeArray = grades.toArray(new StudentGrade[0]);
        BiasedGrading grading = new BiasedGrading(gradeArray, dayOfWeek, pointsToAlter);
        grading.gradeInAnEvilManner();

        // Print the altered array
        for(StudentGrade s : gradeArray) {
            System.out.println(s.getStudentNumber() + "," + s.getGrade());
        }
    }
}