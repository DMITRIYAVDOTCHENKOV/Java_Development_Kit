package seminar4.hw;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDirectory {
    private List<Employee> employees;

    public EmployeeDirectory(){
        employees = new ArrayList<>();
    }

    /**
     * Добавляем нового сотрудника
     * @param employee
     */
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    /**
     * ищет сотрудников с заданным стажем и возвращает список.
     * @param experience стаж
     * @return
     */
    public ArrayList<Employee>  searchByExperience(int experience){
        ArrayList<Employee> result = new ArrayList<>();
        for (Employee employee : result) {
            if (employee.getExperience() == experience) {
                result.add(employee);
            }
        }
        return result;
    }

    /**
     * ищем номера сотрудников и возвращаем
     * @param name имя
     * @return
     */
    public ArrayList<String> searchPhoneNumberByName(String name) {
        ArrayList<String> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                result.add(employee.getPhoneNumber());
            }
        }
        return result;
    }

    /**
     * ищет сотрудника по табельному номеру
     * @param id табельный номер
     * @return
     */
    public Employee searchById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }
}


