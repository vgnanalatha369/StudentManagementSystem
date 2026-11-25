
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Student> students = new ArrayList<>();

    public static int readInt(String message) {

        while (true) {
            System.out.print(message);

            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer!");
            }
        }
    }

    public static double readMarks(String message) {

        while (true) {
            System.out.print(message);

            try {
                double marks = Double.parseDouble(sc.nextLine().trim());

                if (marks >= 0 && marks <= 100) {
                    return marks;
                } else {
                    System.out.println("Marks must be between 0 and 100!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter valid numeric marks!");
            }
        }
    }

    public static String readString(String message) {

        while (true) {
            System.out.print(message);

            String value = sc.nextLine().trim();

            if (!value.isEmpty()) {
                return value;
            }

            System.out.println("Input cannot be empty!");
        }
    }

    public static Student searchStudent(int id) {

        for (Student s : students) {
            if (s.getStudentId() == id) {
                return s;
            }
        }

        return null;
    }

    public static void addStudent() {

        int id = readInt("Enter Student ID: ");

        if (searchStudent(id) != null) {
            System.out.println("Student ID already exists!");
            return;
        }

        String name = readString("Enter Student Name: ");
        String dept = readString("Enter Department: ");

        Student s = new Student(id, name, dept);

        System.out.println("\nEnter Subject Marks:");

        double m1 = readMarks("Subject 1: ");
        double m2 = readMarks("Subject 2: ");
        double m3 = readMarks("Subject 3: ");

        s.setMarks(m1, m2, m3);

        students.add(s);

        System.out.println("Student Added Successfully!");
    }

    public static void displayAllStudents() {

        if (students.isEmpty()) {
            System.out.println("No students available!");
            return;
        }

        for (Student s : students) {

            System.out.println("\n===== STUDENT REPORT =====");

            s.displayReport();

            System.out.println("--------------------------");
        }
    }

    public static void searchStudentDetails() {

        int id = readInt("Enter Student ID to Search: ");

        Student s = searchStudent(id);

        if (s != null) {
            System.out.println("\n===== STUDENT FOUND =====");
            s.displayReport();
        } else {
            System.out.println("Student Not Found!");
        }
    }

    public static void updateMarks() {

        int id = readInt("Enter Student ID: ");

        Student s = searchStudent(id);

        if (s == null) {
            System.out.println("Student Not Found!");
            return;
        }

        System.out.println("Enter New Marks:");

        double m1 = readMarks("Subject 1: ");
        double m2 = readMarks("Subject 2: ");
        double m3 = readMarks("Subject 3: ");

        s.setMarks(m1, m2, m3);

        System.out.println("Marks Updated Successfully!");
    }

    public static void deleteStudent() {

        int id = readInt("Enter Student ID to Delete: ");

        Student s = searchStudent(id);

        if (s != null) {
            students.remove(s);
            System.out.println("Student Deleted Successfully!");
        } else {
            System.out.println("Student Not Found!");
        }
    }

    public static void findTopper() {

        if (students.isEmpty()) {
            System.out.println("No Students Available!");
            return;
        }

        Student topper = students.get(0);

        for (Student s : students) {

            if (s.calculateTotal() > topper.calculateTotal()) {
                topper = s;
            }
        }

        System.out.println("\n===== CLASS TOPPER =====");

        topper.displayReport();
    }

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n================================");
            System.out.println("   STUDENT MANAGEMENT SYSTEM");
            System.out.println("================================");

            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student Marks");
            System.out.println("5. Delete Student");
            System.out.println("6. Find Class Topper");
            System.out.println("7. Exit");

            int choice = readInt("Enter Your Choice: ");

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    displayAllStudents();
                    break;

                case 3:
                    searchStudentDetails();
                    break;

                case 4:
                    updateMarks();
                    break;

                case 5:
                    deleteStudent();
                    break;

                case 6:
                    findTopper();
                    break;

                case 7:
                    System.out.println("Thank You for Using Student Management System!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice! Enter 1 to 7.");
            }
        }
    }
}
