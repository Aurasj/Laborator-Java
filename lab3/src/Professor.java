public class Professor extends Person {

    @Override
    public String toString() {
        return "Professor{" + "name=" + name + ", surname=" +
                surname + '}';
    }

    public Professor(String name, String surname) {
        this.name = name;
        this.surname = surname;

    }
    public String getFullname()
    {
        return name + " " + surname;
    }


}