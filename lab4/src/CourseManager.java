import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Comparator;

public class CourseManager implements ManagerCourseOperations {
    String name;
    String description;
    Professor teacher;
    List<Course> courses;
    public CourseManager() {
        Connection conn = null;
        courses = new ArrayList<Course>();
    }
    double grades[] = {7.6, 8.7, 9.3, 6.4, 8.1};
    double gradesProfessor[] = {7, 7.1, 7.2, 7.3, 7.8, 5.4};
    public void AddCourse(Course course) {
        int newLength = courses.size() + 1;
        Course[] aux = new Course[newLength];
        int index = 0;
        for(Course c : courses) {
            aux[index++] = c;
        }
        aux[index] = course;
        this.courses = List.of(new Course[newLength]);
        System.arraycopy(aux,0,courses, 0,newLength);

    }

    public void enrollStudent(String courseName,Student student)
    {
        Course targetCourse = null;
        for(Course course : courses){
            if(course.name.equals(courseName)) {
                targetCourse = course;
                break;
            }
        }
        if(targetCourse != null){
            targetCourse.addStudent(student);
            System.out.println(student + "a fost inscris la" + courseName);
        }
        else System.out.println("Cursul cu numele" + courseName + "nu exista");

    }

    public List<Student> listStudentsInCourse(String courseName)
    {
        Course targetCourse = null;
        for(Course course : courses) {
            if(course.name.equals(courseName)){
                targetCourse = course;
                break;
            }
        }
        if (targetCourse != null) {
            return new ArrayList<Student>(targetCourse.getEnrolledStudents());
        } else {
            return new ArrayList<Student>();
        }
    }
    public double calculateAverageGradeForCourse(String courseName, double[] grades) {
        Course targetCourse = null;
        for (Course course : courses) {
            if (course.name.equals(courseName)) {
                targetCourse = course;
                break;
            }
        }

        if (targetCourse != null) {
            if (grades.length > 0) {
                double sum = 0.0;
                for (double grade : grades) {
                    sum += grade;
                }
                return sum / grades.length;
            } else {
                System.out.println("Nu exista note pentru " + courseName);
                return 0.0;
            }
        } else {
            System.out.println("Cursul " + courseName + " nu exista.");
            return 0.0;
        }
    }

    public double calculateAverageProfessorGrade(double[] gradesProfessor) {
        if (gradesProfessor.length == 0) {
            return 0.0; // Return 0 for an empty array or handle as needed
        }

        double sum = 0.0;
        for (double gradeProfessor : gradesProfessor) {
            sum += gradeProfessor;
        }

        return sum / gradesProfessor.length;
    }

    public void DisplayCoursesToConsole() {
        for (Course c : courses) {
            System.out.println(c);
        }
    }

    public void UpdateCourse(Course course) {
    System.out.println("Update Course");
    }

    public void DeletedCourse(Course course) {
    System.out.println("Deleted Coruse");
    }
    public Map<String, List<Student>> groupStudentsByGroupNumber() {
        Map<String, List<Student>> groupedStudents = new HashMap<>();

        for (Course course : courses) {
            for (Student student : course.getEnrolledStudents()) {
                String groupNumber = student.getGroup();

                if (!groupedStudents.containsKey(groupNumber)) {
                    groupedStudents.put(groupNumber, new ArrayList<>());
                }

                groupedStudents.get(groupNumber).add(student);
            }
        }

        return groupedStudents;
    }
    public void sortCourses(String sortBy) {
        Comparator<Course> comparator = null;

        switch (sortBy.toLowerCase()) {
            case "name":
                comparator = Comparator.comparing(Course::getName);
                break;
            case "professor":
                comparator = Comparator.comparing(course -> course.getProfessor().getName());
                break;
            case "enrolled":
                comparator = Comparator.comparing(course -> course.getEnrolledStudents().size());
                break;
            default:
                System.out.println("Invalid sort option. Please choose between 'name', 'professor', or 'enrolled'.");
                return;
        }

        courses.sort(comparator);
    }
    public Course findCourseByName(String name) {
        for (Course course : courses) {
            if (course.getName().equals(name)) {
                return course;
            }
        }
        return null;
    }
}