public class StudentGrade implements Comparable<StudentGrade>{
    private final int studentNumber;
    private double grade;

    public StudentGrade(int studentNumber, double grade) {
        this.studentNumber = studentNumber;
        this.grade = grade;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public int compareTo(StudentGrade o) {
        return Double.compare(this.getGrade(), o.getGrade());
    }
}
