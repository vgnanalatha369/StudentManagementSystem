
public class Student {

    private int studentId;
    private String studentName;
    private String department;
    private double[] marks = new double[3];

    public Student(int studentId, String studentName, String department) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.department = department;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setMarks(double m1, double m2, double m3) {
        marks[0] = m1;
        marks[1] = m2;
        marks[2] = m3;
    }

    public double calculateTotal() {
        return marks[0] + marks[1] + marks[2];
    }

    public double calculateAverage() {
        return calculateTotal() / 3;
    }

    public String calculateGrade() {
        double avg = calculateAverage();

        if (!isPassed())
            return "Fail";
        else if (avg >= 90)
            return "A+";
        else if (avg >= 80)
            return "A";
        else if (avg >= 70)
            return "B";
        else if (avg >= 60)
            return "C";
        else if (avg >= 50)
            return "D";
        else
            return "Fail";
    }

    public boolean isPassed() {
        for (double mark : marks) {
            if (mark < 35) {
                return false;
            }
        }

        return calculateAverage() >= 50;
    }

    public void displayStudent() {
        System.out.println("Student ID  : " + studentId);
        System.out.println("Name        : " + studentName);
        System.out.println("Department  : " + department);
    }

    public void displayReport() {

        displayStudent();

        System.out.println("Subject 1   : " + marks[0] +
                " - " + (marks[0] >= 35 ? "PASS" : "FAIL"));

        System.out.println("Subject 2   : " + marks[1] +
                " - " + (marks[1] >= 35 ? "PASS" : "FAIL"));

        System.out.println("Subject 3   : " + marks[2] +
                " - " + (marks[2] >= 35 ? "PASS" : "FAIL"));

        System.out.println("Total Marks : " + calculateTotal());
        System.out.printf("Average     : %.2f%n", calculateAverage());
        System.out.println("Grade       : " + calculateGrade());
        System.out.println("Result      : " + (isPassed() ? "PASS" : "FAIL"));
    }
}
