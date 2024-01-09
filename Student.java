import java.util.Objects;

/**
 * Represents a student in the university.
 */
public class Student {

    // Defining the instance variables as final for immutability
    private final String studentName;
    private final String studentId;
    private final String courseTaken;
    private final String moduleTaken;
    private final double marks;

    /**
     * Constructs a new Student with the given parameters.
     *
     * @param studentName The name of the student.
     * @param studentId   The ID of the student.
     * @param courseTaken The course taken by the student.
     * @param moduleTaken The module taken by the student.
     * @throws IllegalArgumentException if any parameter is null
     */
    public Student(String studentName, String studentId, String courseTaken, String moduleTaken) {
        Objects.requireNonNull(studentName, "Student name cannot be null");
        Objects.requireNonNull(studentId, "Student ID cannot be null");
        Objects.requireNonNull(courseTaken, "Course taken cannot be null");
        Objects.requireNonNull(moduleTaken, "Module taken cannot be null");

        this.studentName = studentName;
        this.studentId = studentId;
        this.courseTaken = courseTaken;
        this.moduleTaken = moduleTaken;
        this.marks = 0.0;
    }

    /**
     * Gets the name of the student.
     *
     * @return The name of the student.
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * Gets the ID of the student.
     *
     * @return The ID of the student.
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * Gets the course taken by the student.
     *
     * @return The course taken by the student.
     */
    public String getCourseTaken() {
        return courseTaken;
    }

    /**
     * Gets the module taken by the student.
     *
     * @return The module taken by the student.
     */
    public String getModuleTaken() {
        return moduleTaken;
    }
    
    public double getMarks() {
        return marks;
    }

    public double getAge() {
        return age;
    }

    /**
     * Checks if two students are equal based on their IDs.
     *
     * @param obj The object to compare with.
     * @return true if the students have the same ID, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return studentId.equals(student.studentId);
    }

    /**
     * Generates a hash code based on the student's ID.
     *
     * @return The hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(studentId);
    }
}
