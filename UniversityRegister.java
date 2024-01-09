import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class UniversityRegister {
    public final List<Student> students;

    public UniversityRegister(List<Student> students) {
        this.students = new ArrayList<>(students);
    }

    public UniversityRegister addStudent(Student student) {
        List<Student> newStudentList = new ArrayList<>(students);
        newStudentList.add(student);
        return new UniversityRegister(newStudentList);
    }

    public UniversityRegister unenrollStudent(String studentId) {
        List<Student> newStudentList = students.stream()
                .filter(student -> !student.getStudentId().equals(studentId))
                .collect(Collectors.toList());

        if (newStudentList.size() == students.size()) {
            throw new NoSuchElementException("Failed to find student with student ID: " + studentId);
        }

        return new UniversityRegister(newStudentList);
    }

    // Query students by a given criterion
    public List<Student> queryStudents(Predicate<Student> predicate) {
        return students.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    // Additional query methods

    // Query students by course and sort by marks in ascending order

    // Change this so that it only sorts by marks
    public List<Student> sortStudentsByMarks() {
        return students.stream()
                .sorted(Comparator.comparingDouble(Student::getMarks))
                .collect(Collectors.toList());
    }

    // Query students with marks above a certain threshold
    public List<Student> findStudentsWithMarksAboveThreshold(double threshold) {
        return students.stream()
                .filter(student -> student.getMarks() > threshold)
                .collect(Collectors.toList());
    }

    // Organize students by module
    public Map<String, List<Student>> organizeStudentsByModule(String course) {
        return students.stream()
                .filter(student -> student.getCourseTaken().equals(course))
                .collect(Collectors.groupingBy(Student::getModuleTaken));
    }

    // Calculate the average marks of all students
    public double calculateAverageMarks() {
        return students.stream()
                .mapToDouble(Student::getMarks)
                .average()
                .orElse(0.0);
    }

    // May not be needed as the students are listed in the student class
    // List all students
    public List<Student> listStudents() {
        return Collections.unmodifiableList(students);
    }

    // Additional query methods

    // ...
}
