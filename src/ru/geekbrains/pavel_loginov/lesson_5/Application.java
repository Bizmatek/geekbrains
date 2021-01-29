package ru.geekbrains.pavel_loginov.lesson_5;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Application app = new Application();
        app.execute();
        System.out.println();
        app.executeWithCollectionsAndStreamAPI();

    }

    public void execute() {
        Employee[] employeeArray = new Employee[5];
        employeeArray[0] = new Employee("Ivanov Ivan", "manager", "ivanov@testmail.ru", "999999999", 100000, 41);
        employeeArray[1] = new Employee("Petrov Petr", "junior developer", "@testmail.ru", "888888888", 7000, 36);
        employeeArray[2] = new Employee("Fedorov Fedor", "senior developer", "@testmail.ru", "777777777", 50000, 52);
        employeeArray[3] = new Employee("Alexeev Alexey", "Testing engineer", "@testmail.ru", "666666666", 15000, 24);
        employeeArray[4] = new Employee("Pavlov Pavel", "Business analyst", "@testmail.ru", "555555555", 10000, 29);

        System.out.println("Array of employees older then 40");
        for (Employee employee : employeeArray) {
            if (employee.getAge() > 40) {
                System.out.println(employee);
            }
        }

    }

    public void executeWithCollectionsAndStreamAPI() {
        System.out.println("List of employees older then 40");
        List<Employee> employeeList = List.of(
                new Employee("Ivanov Ivan", "manager", "ivanov@testmail.ru", "999999999", 100000, 41),
                new Employee("Petrov Petr", "junior developer", "@testmail.ru", "888888888", 7000, 36),
                new Employee("Fedorov Fedor", "senior developer", "@testmail.ru", "777777777", 50000, 52),
                new Employee("Alexeev Alexey", "Testing engineer", "@testmail.ru", "666666666", 15000, 24),
                new Employee("Pavlov Pavel", "Business analyst", "@testmail.ru", "555555555", 10000, 29)
        );

        employeeList.stream().filter(e -> e.getAge() > 40).forEach(System.out::println);
    }
}
