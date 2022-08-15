package Model;

public class Person {
    private int id;
    private String firstName;
    private String secondName;
    private int age;
    private String city;
    private String company;
    private String language;
    private int salary;

    public Person() {
    }

    public Person(String firstName, String secondName, int age, String city, String company, String language, int salary) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.city = city;
        this.company = company;
        this.language = language;
        this.salary = salary;
    }

    public Person(int id, String firstName, String secondName, int age, String city, String company, String language, int salary) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.city = city;
        this.company = company;
        this.language = language;
        this.salary = salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public String getCompany() {
        return company;
    }

    public String getLanguage() {
        return language;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", company='" + company + '\'' +
                ", language='" + language + '\'' +
                ", salary=" + salary +
                '}';
    }
}
