package lesson6;

public class PersonalDetails {
    private int id;
    private double age;
    private  String name;

    public PersonalDetails(int id, double age) {
        this.id = id;
        this.age = age;
    }

    private  String family;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public PersonalDetails(int id, double age, String name, String family) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.family = family;
    }

    public PersonalDetails() {
    }

    @Override
    public String toString() {
        return "PersonalDetails{" +
                "id='" + id + '\'' +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", family='" + family + '\'' +
                '}';
    }
}
