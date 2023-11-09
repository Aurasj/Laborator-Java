import java.util.HashSet;
import java.util.Set;

public class Course implements CourseOperations {
    String name;
    String description;
    Professor teacher;
    Set<Student> students;

    public Course(String name, String description,
                  Professor teacher, Student[] studentsArray) {
        this.name = name;
        this.description = description;
        this.teacher = teacher;
        this.students = new HashSet<Student>();
        for (Student student : studentsArray) {
            this.students.add(student);
        }
    }

    public void updateProfessor(Professor teacher){
        this.teacher = teacher;
    }

    public void addStudent(Student student){
        this.students.add(student);
    }

    public Set<Student> getEnrolledStudents() {
        return students;
    }

    @Override
    public String toString() {
        String str = "Course: " + "name=" + name + ", description=" +
                description + ",\nTeacher=" + teacher + ",\nStudents:\n";
        for(Student s : students) {
            str +=s + "\n";
        }

        return str;
    }

    @Override
    public void UpdateProfessor(Professor p) {

    }

    @Override
    public void AddStudent(Student student) {

    }

    @Override
    public void RemoveStudent(Student student) {

    }

    @Override
    public void UpdateStudent(Student student) {

    }

    @Override
    public void UpdateCourse(String name, String description) {

    }
    public String getName() {
        return this.name;
    }

    public Professor getProfessor() {
        return this.teacher;
    }
}