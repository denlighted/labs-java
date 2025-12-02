package org.example;

import java.sql.*;

public class TaskService {

    public static void getAllTasks() {
        String query = "SELECT * FROM tasks";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("\nList of all tasks:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String taskDescription = rs.getString("task_description");
                int employeeId = rs.getInt("employee_id");
                System.out.printf("ID: %d, Task: %s, Employee ID: %d%n", id, taskDescription, employeeId);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addTask(int employeeId, String taskDescription) {
        String query = "INSERT INTO tasks (task_description, employee_id) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, taskDescription);
            stmt.setInt(2, employeeId);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Task added successfully!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getTasksByEmployee(int employeeId) {
        String query = "SELECT * FROM tasks WHERE employee_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, employeeId);
            ResultSet rs = stmt.executeQuery();

            System.out.println("\nTasks for Employee ID " + employeeId + ":");
            while (rs.next()) {
                int taskId = rs.getInt("id");
                String taskDescription = rs.getString("task_description");
                System.out.printf("Task ID: %d, Task: %s%n", taskId, taskDescription);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
