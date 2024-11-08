public class People {
    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private int age;

    public People(int id, String surname, String name, String patronymic, int age){
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.age = age;
    }

    public People(String surname, String name, String patronymic, int age) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.age = age;
    }

    @Override
    public String toString() {
        return id + " " + surname + " " + name + " " + patronymic + " " + age;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
