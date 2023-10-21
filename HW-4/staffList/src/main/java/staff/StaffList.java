package staff;

import java.util.ArrayList;

public class StaffList {
    private ArrayList<Employee> list = new ArrayList<>();

    /**
     * метод добавляет нового сотрудника в справочник
     * @param person
     */
    public void add(Employee person) {
        list.add(person);
    }

    /**
     * Метод, который ищет сотрудника по стажу
     *
     * @param minExp - мин стаж
     * @param maxExp - макс стаж
     * @return список(ArrayList)
     */
    public ArrayList<Employee> findByExperience(int minExp, int maxExp) {
        ArrayList<Employee> result = new ArrayList<>();

        for (Employee emp : list) {
            if (emp.getExperience() >= minExp && emp.getExperience() <= maxExp)
                result.add(emp);
        }
        return result;
    }

    /**
     * Метод, который ищет сотрудника по минимальному стажу
     *
     * @param minExp - мин стаж
     * @return список(ArrayList)
     */
    public ArrayList<Employee> findByExperience(int minExp) {
        return findByExperience(minExp, 100);
    }

    /**
     * Метод, который ищет сотрудников по имени
     *
     * @param byName - имя
     * @return список сотрудников
     */
    public StaffList findByName(String byName) {
        StaffList result = new StaffList();

        for (Employee emp : list) {
            if (emp.getName().contains(byName))
                result.add(emp);
        }
        return result;
    }

    /**
     * Метод, который ищет сотрудника по табельному номеру
     *
     * @param id - табельный номер
     * @return - Emloyee
     */
    public Employee getById(int id) {
        for (Employee emp : list
        ) {
            if (emp.getId().equals(id))
                return emp;
        }
        return null;
    }

    /**
     * Метод выводит список сотрудников с номерами телефонов
     * @return - строка
     */
    public String printPhoneList() {
        StringBuilder result = new StringBuilder();
        for (Employee emp : list
        ) {
            result.append(String.format("%d. %s, тел. %s\n",emp.getId(), emp.getName(), emp.getPhone()));
        }
        return result.toString();
    }

    @Override
    public String toString() {
        return "StaffList{\n" +
                list +
                '}';
    }
}
