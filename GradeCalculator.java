package xmf194_lab6;

import java.util.Scanner;

/**
 * The GradeCalculator class calculates the final grade based on quiz, lab, team project, and exam grades.
 * It handles input validation for numeric values and provides appropriate error messages.
 * @author yshvrm - Yash Verma
 */
public class GradeCalculator {

    /**
     * Calculates the total grade based on components and corresponding grades.
     * Handles negative grades, NaN (non-numeric) grades, and missing grades gracefully.
     *
     * @param components The weight of each grade component.
     * @param grades     The grades obtained for each component.
     * @return The total grade or -1.0 if an error in input is detected.
     */
    public static double gradeCalc(double[] components, double[] grades) {
        double total = 0;

        // Iterate through each grade component and calculate the total grade
        for (int i = 0; i < grades.length; i++) {
            // Check for negative grades or NaN (non-numeric) grades
            if (grades[i] < 0 || Double.isNaN(grades[i])) {
                // Return -1.0 to indicate an error in input
                System.out.println("Error: Invalid grade detected. Grades must be non-negative numeric values.");
                return -1.0;
            }
            total += (grades[i] * components[i]);
        }

        // Check for missing grades
        for (int i = 0; i < grades.length; i++) {
            if (Double.isNaN(grades[i])) {
                // Print a warning message for missing grades
                System.out.println("Warning: Missing grade detected. Assigning a default value of 0.0.");
                grades[i] = 0.0; // Set a default value, you can choose another default if needed
            }
        }

        return total;
    }

    /**
     * The main method collects input from the user and calculates the final grade.
     *
     * @param args The command line arguments (not used in this program).
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Arrays to store grades for each component
        double[] labs = new double[6];
        double[] quizzes = new double[6];
        double[] exams = new double[2];
        double[] grades = new double[4];

        // Components and their weightage
        String[] components = { "Quizzes(6)", "Labs(6)", "Team Project", "Exams(2)" };
        double[] percentage = { 0.14, 0.36, 0.20, 0.30 };

        System.out.println("<<<<<<<<Grade Calculator>>>>>>>>\n\n\nQuiz Grades:");

        // Temporary variable to store quiz grades sum
        double temp = 0.0;

        // Quizzes input
        for (int i = 1; i <= quizzes.length; i++) {
            System.out.printf("\nQuiz #%d: ", i);
            while (!scan.hasNextDouble()) {
                // Handle non-numeric input gracefully
                System.out.println("Invalid input. Please enter a valid numeric value.");
                scan.nextLine(); // Consume the invalid input
                System.out.printf("Quiz #%d: ", i); // Retry the same quiz
            }
            quizzes[i - 1] = scan.nextDouble();
            temp += quizzes[i - 1];
        }
        grades[0] = (temp / quizzes.length);

        // Lab input
        double ltemp = 0.0;
        System.out.println("\n\nLab Grades:\n");
        for (int i = 1; i <= labs.length; i++) {
            System.out.printf("Lab #%d: ", i);
            while (!scan.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a valid numeric value.");
                scan.nextLine();
                System.out.printf("Lab #%d: ", i);
            }
            labs[i - 1] = scan.nextDouble();
            ltemp += labs[i - 1];
            System.out.print("\n");
        }
        grades[1] = (ltemp / labs.length);

        // Team Project input
        System.out.print("\nTeam Project Grade: ");
        while (!scan.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid numeric value.");
            scan.nextLine();
            System.out.print("Team Project Grade: ");
        }
        grades[2] = scan.nextDouble();

        // Exam input
        double etemp = 0;
        System.out.println("\n\nExam Grades:\n");
        for (int i = 1; i <= exams.length; i++) {
            System.out.printf("Exam #%d: ", i);
            while (!scan.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a valid numeric value.");
                scan.nextLine();
                System.out.printf("Exam #%d: ", i);
            }
            exams[i - 1] = scan.nextDouble();
            etemp += exams[i - 1];
            System.out.print("\n");
        }
        grades[3] = (etemp / exams.length);

        // Calculate the final grade
        double finalGrade = gradeCalc(percentage, grades);

        // Display the result to the user
        if (finalGrade == -1.0) {
            System.out.println("Invalid input detected. Please check your input values.");
        } else {
            System.out.println("Grade: " + finalGrade);
        }
    }
}
