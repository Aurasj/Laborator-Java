public class Professor extends Person {

    @Override
    public String toString() {
        return "Professor{" + "name=" + name + ", surname=" +
                surname + '}';
    }

    @Override
    public int compareTo(Student other) {
        return 0;
    }

    public Professor(String name, String surname) {
        this.name = name;
        this.surname = surname;

    }
    public String getFullname()
    {
        return name + " " + surname;
    }

    public String getName() {
        return this.name;
    }

}