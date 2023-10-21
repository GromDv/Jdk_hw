package staff;

public class Employee {
    private static int counter;
    private Integer id;
    private String phone;
    private String name;
    private Integer experience;

    public Integer getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public Integer getExperience() {
        return experience;
    }

    public Employee(String name, String phone, Integer experience) {
        id = counter++;
        this.phone = phone;
        this.name = name;
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", experience=" + experience +
                "}\n";
    }
}
