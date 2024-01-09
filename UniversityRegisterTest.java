import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UniversityRegisterTest {

    private UniversityRegister universityRegister;

    @Before
    public void setUp() {
        
        List<Student> sampleStudents = Arrays.asList(
                new Student("Maya", "387260", "Architecture", "Technology and Environment"),
                new Student("Christelle", "741225", "Product Design", "3D design"),
                new Student("Efua", "005673", "Accounting", "Business Ethics")
               
        );
        universityRegister = new UniversityRegister(sampleStudents);
    }

    @Test
    public void testAddStudent() {
        
        Student newStudent = new Student("Christelle", "741225", "Product Design", "3D design");
        universityRegister = universityRegister.addStudent(newStudent);

        
        assertTrue(universityRegister.listStudents().contains(newStudent));
    }

    @Test
    public void testRemoveStudent() {
        
        String studentIdToRemove = "2";
        universityRegister = universityRegister.unenrollStudent(studentIdToRemove);

        
        assertTrue(universityRegister.listStudents().stream().noneMatch(student -> student.getStudentId().equals(studentIdToRemove)));
    }

    @Test
    public void testQueryStudentsByCourse() {
        
        List<Student> result = universityRegister.findStudentsByCourse("Computer Science");

        
        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(student -> student.getCourseTaken().equals("Computer Science")));
    }

    @Test
    public void testQueryStudentsByModule() {
        
        List<Student> result = universityRegister.queryStudentsByModule("Module1");

        
        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(student -> student.getModuleTaken().equals("Module1")));
    }

    @Test
    public void testOrganizeStudentsByModule() {

        Map<String, List<Student>> organizedByModule = universityRegister.organizeStudentsByModule("Computer Science");

      
        assertEquals(2, organizedByModule.size());
        assertTrue(organizedByModule.containsKey("Module1"));
        assertTrue(organizedByModule.containsKey("Module2"));
    }

    @Test
    public void testQueryStudentsByName() {
        
        List<Student> result = universityRegister.queryStudentsByName("Charlie");
        assertEquals(1, result.size());
        assertEquals("Charlie", result.get(0).getStudentName());
    }

    @Test
    public void testQueryStudentsById() {
       
        List<Student> result = universityRegister.queryStudentsById("1");
        assertEquals(1, result.size());
        assertEquals("Alice", result.get(0).getStudentName());
    }

  

}
