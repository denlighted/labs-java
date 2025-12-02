package org.example;

public class Main {

    public static void main(String[] args) {
        // Приклад використання функцій

        // Отримати всіх співробітників
        EmployeeService.getAllEmployees();

        // Отримати всі завдання
        TaskService.getAllTasks();

        // Отримати співробітників певного відділу
        EmployeeService.getEmployeesByDepartment(1); // Вивести співробітників з відділу 1

        // Додати завдання для співробітника
        TaskService.addTask(1, "Fix bugs in software");

        // Отримати завдання для певного співробітника
        TaskService.getTasksByEmployee(1);

        // Видалити співробітника
        EmployeeService.deleteEmployee(10); // Видалити співробітника з ID 10
    }
}
