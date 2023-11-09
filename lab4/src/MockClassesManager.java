public class MockClassesManager {
    public static void populateMockData(CourseManager courseManager) {
        Professor professor1 = new Professor("Mircea" , "Ion");
        Professor professor2 = new Professor("Mihai" , "Viteazu");

        Student student1 = new Student("Aurelian", "Iancu", "4lf522");
        Student student2 = new Student("Dumitru", "Mircea", "4lf522");
        Student student3 = new Student("Ionel", "Mihai", "4lf522");
        Student student4 = new Student("Dorel", "Ion", "4lf522");

        Course course1 = new Course("Ms", "Curs depsre mate multa", professor1, new Student[]{student2,student3});
        Course course2 = new Course("Analiza", "Curs despre mate multa", professor2, new Student[]{student1, student4});

        course1.addStudent(student1);
        course1.addStudent(student2);
        course2.addStudent(student3);
        course2.addStudent(student4);

        courseManager.AddCourse(course1);
        courseManager.AddCourse(course2);
    }
}
