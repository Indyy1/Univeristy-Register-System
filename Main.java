import java.util.Optional;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // List of Student objects
        List<Student> students = Arrays.asList(
            // Example students with their names, student number, course taken, module, and age
            new Student("Afia", "228607", "Fine Art", "Sculpting", 19),
            new Student("Andre", "446732", "Bio Med", "Anatomy and Development", 26),
            new Student("Megan", "879036", "Computer Science", "Functional Programming", 18)
        );

        // Using the .map() function to create a Stream<Integer> for the student ages
        Stream<Integer> ageStream = students.stream().map(Student::getAge);

        // Using .min() and .max() for the oldest and youngest students
        Optional<Integer> minAge = ageStream.min(Integer::compareTo);

        // Create a new stream for maxAge operation
        Stream<Integer> newAgeStream = students.stream().map(Student::getAge);
        Optional<Integer> maxAge = newAgeStream.max(Integer::compareTo);

        // Sorting the Stream with .sorted()
        List<Integer> sortedAges = students.stream().map(Student::getAge).sorted().collect(Collectors.toList());

        // Add all ages into one integer
        Optional<Integer> totalAge = students.stream().map(Student::getAge).reduce(Integer::sum);

        // Checking if the students are all enrolled onto the Computer Science course
        // Storing a boolean variable for the result
        boolean allComputerScience = areAllStudentsEnrolledOnComputerScience(students.stream());

        System.out.println("Are the students all enrolled onto the Computer Science course? " + allComputerScience);
    }

    // Method that returns either true or false if the students are all enrolled onto Computer Science
    private static boolean areAllStudentsEnrolledOnComputerScience(Stream<Student> studentStream) {
        // Checking whether students are enrolled onto the Computer Science course
        return studentStream.allMatch(student -> student.getCourse().equals("Computer Science"));
    }
}

record Student(String name, String id, String course, String module, int age) {}
