public class Student extends Person{

    int groupNumber;

    public Student(String name, String surname, int groupNumber) {
        this.name = name;
        this.surname = surname;
        this.groupNumber = groupNumber;
    }

    @Override
    public String toString() {

        return "Student{" + "name=" + name + ", surname=" + surname
                + ", groupNumber="  + groupNumber + '}';
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getsurname() {
        return surname;
    }

    public void setsurname(String surname) {
        this.surname = surname;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public String getFullname(){
        return name + " " + surname;
    }
}