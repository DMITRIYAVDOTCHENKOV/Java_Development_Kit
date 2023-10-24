package seminar4.hw;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//Создать справочник сотрудников
//        Необходимо:
//        Создать класс справочник сотрудников, который содержит внутри коллекцию сотрудников - каждый сотрудник должен иметь следующие атрибуты:
//        Табельный номер
//        Номер телефона
//        Имя
//        Стаж
//        Добавить метод, который ищет сотрудника по стажу (может быть список)
//        Добавить метод, который выводит номер телефона сотрудника по имени (может быть список)
//        Добавить метод, который ищет сотрудника по табельному номеру
//        Добавить метод добавление нового сотрудника в справочник
public class Main {
    public static void main(String[] args) {
        EmployeeDirectory directory = new EmployeeDirectory();
        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Выберите действие:");
            System.out.println("1. Добавить сотрудника");
            System.out.println("2. Поиск сотрудника по стажу");
            System.out.println("3. Поиск номера телефона сотрудника по имени");
            System.out.println("4. Поиск сотрудника по табельному номеру");
            System.out.println("0. Выход");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введите табельный номер сотрудника: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Введите номер телефона сотрудника: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Введите имя сотрудника: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите стаж сотрудника: ");
                    int experience = scanner.nextInt();
                    scanner.nextLine();

                    Employee employee = new Employee(id, phoneNumber, name, experience);
                    directory.addEmployee(employee);
                    System.out.println("Сотрудник добавлен.");
                    try {
                        BufferedWriter writer = new BufferedWriter(new FileWriter("employee_data.txt", true));
                        writer.write(employee.toFileString());
                        writer.newLine();
                        writer.close();
                    } catch (IOException e) {
                        System.out.println("Ошибка при записи в файл.");
                    }
                    break;

                case 2:
                    System.out.print("Введите стаж для поиска: ");
                    int experienceToSearch = scanner.nextInt();
                    scanner.nextLine();

                    ArrayList<Employee> employeesWithExperience = directory.searchByExperience(experienceToSearch);
                    System.out.println("Сотрудники со стажем " + experienceToSearch + ":");
                    for (Employee emp : employeesWithExperience) {
                        System.out.println(emp);
                    }
                    break;

                case 3:
                    System.out.print("Введите имя для поиска номера телефона: ");
                    String nameToSearch = scanner.nextLine();

                    ArrayList<String> phoneNumbersByName = directory.searchPhoneNumberByName(nameToSearch);
                    System.out.println("Номера телефонов сотрудников с именем " + nameToSearch + ":");
                    for (String s : phoneNumbersByName) {
                        System.out.println(s);
                    }
                    break;

                case 4:
                    System.out.print("Введите табельный номер для поиска сотрудника: ");
                    int idToSearch = scanner.nextInt();
                    scanner.nextLine();

                    Employee employeeById = directory.searchById(idToSearch);
                    if (employeeById != null) {
                        System.out.println("\nИнформация о сотруднике с табельным номером " +idToSearch + ":");
                        System.out.println(employeeById);
                    } else {
                        System.out.println("\nСотрудник с табельным номером " + idToSearch + " не найден.");
                    }
                    break;

                case 0:
                    System.out.println("Программа завершена.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
                    break;
            }
        }


    }
}
