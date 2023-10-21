package staff;

public class MainApp {
    public static void main(String[] args) {
        StaffList staff = new StaffList();

        staff.add(new Employee("Ivanov","654654", 25));
        staff.add(new Employee("Petrov","3215498", 15));
        staff.add(new Employee("Sidorov","9849446", 10));
        staff.add(new Employee("Govorov","654879", 5));
        staff.add(new Employee("Svetlov","5468816", 2));

        System.out.println(staff);
        System.out.println();

        System.out.println(staff.findByExperience(10));
        System.out.println();

        System.out.println(staff.findByName("rov").printPhoneList());

        System.out.println(staff.getById(2));
    }
}
