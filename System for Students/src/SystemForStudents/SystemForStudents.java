package SystemForStudents;

import java.util.Scanner;

public class SystemForStudents {

    public static void menu() {
        System.out.println("Welcome to the Grading and Absence Management System");
        System.out.println("Enter 'Grades' for Adding Grades of Students");
        System.out.println("Enter 'Absences' for Adding Number of Absence for Students");
        System.out.println("Enter 'Exit' for exiting from the system");
        System.out.print("Please Enter your choice: ");
    }

    public static void handleGrades(Scanner sc) {
        System.out.println("** Grades Of Students **");
        System.out.print("Please enter the name of your course (ex: Math-101): ");
        String course = sc.next();
        System.out.print("Please enter the number of students in " + course + ": ");
        int numStudents = sc.nextInt();

        for (int i = 1; i <= numStudents; i++) {
            System.out.println("Student " + i);
            System.out.print("Enter Student ID: ");
            int studentId = sc.nextInt();
            int firstGrade = getValidGrade(sc, "first", 30);
            int secondGrade = getValidGrade(sc, "second", 30);
            int finalGrade = getValidGrade(sc, "final", 40);

            int totalGrade = firstGrade + secondGrade + finalGrade;
            System.out.println("Student ID: " + studentId);
            System.out.print("Final Grade: " + totalGrade);
            displayGrade(totalGrade);
        }
    }

    public static int getValidGrade(Scanner sc, String examName, int maxScore) {
        System.out.print("Enter grades of " + examName + " exam: ");
        int grade = sc.nextInt();
        while (grade < 0 || grade > maxScore) {
            System.out.println("Invalid input! (must be between 0 and " + maxScore + "). Please try again:");
            grade = sc.nextInt();
        }
        return grade;
    }

    public static void displayGrade(int totalGrade) {
        if (totalGrade > 90) {
            System.out.println(" (A), has been added to the system");
        } else if (totalGrade > 80) {
            System.out.println(" (B), has been added to the system");
        } else if (totalGrade > 70) {
            System.out.println(" (C), has been added to the system");
        } else if (totalGrade > 60) {
            System.out.println(" (D), has been added to the system");
        } else {
            System.out.println(" (F), has been added to the system");
        }
    }

    public static void handleAbsences(Scanner sc) {
        System.out.println("** Number of Absences for Students **");
        System.out.print("Please enter the name of your course (ex: Math-101): ");
        String course = sc.next();
        System.out.print("Please enter the number of students in " + course + ": ");
        int numStudents = sc.nextInt();

        for (int i = 1; i <= numStudents; i++) {
            System.out.println("Student " + i);
            System.out.print("Enter Student ID: ");
            int studentId = sc.nextInt();
            System.out.print("Enter number of absences: ");
            int absences = sc.nextInt();

            while (absences < 0) {
                System.out.println("Invalid input! (must be >= 0). Please try again:");
                System.out.print("Enter number of absences: ");
                absences = sc.nextInt();
            }

            System.out.println("Student ID: " + studentId);
            displayAbsences(absences);
        }
    }

    public static void displayAbsences(int absences) {
        if (absences < 8) {
            System.out.println("Number of absences: " + absences + " (Without Warning), has been added to the system");
        } else if (absences == 8) {
            System.out.println("Number of absences: " + absences + " (First Warning), has been added to the system");
        } else {
            System.out.println("Number of absences: " + absences + " (Second Warning), has been added to the system");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            menu();
            String choice = sc.next();

            if (choice.equalsIgnoreCase("Exit")) {
                break;
            } else if (choice.equalsIgnoreCase("Grades")) {
                handleGrades(sc);
            } else if (choice.equalsIgnoreCase("Absences")) {
                handleAbsences(sc);
            } else {
                System.out.println("Wrong selection! Please try again.");
            }
        }

        sc.close();
    }
}
