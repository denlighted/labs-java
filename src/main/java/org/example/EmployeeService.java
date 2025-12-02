package org.example;

import java.sql.*;

public class EmployeeService {

    public static void getAllEmployees() {
        String query = "SELECT * FROM employers";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("List of all employees:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String lastName = rs.getString("last_name");
                String firstName = rs.getString("first_name");
                String position = rs.getString("position");
                int departmentId = rs.getInt("departments_id");
                System.out.printf("ID: %d, Name: %s %s, Position: %s, Department ID: %d%n",
                        id, firstName, lastName, position, departmentId);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getEmployeesByDepartment(int departmentId) {
        String query = "SELECT * FROM employers WHERE departments_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, departmentId);
            ResultSet rs = stmt.executeQuery();

            System.out.println("\nEmployees in Department " + departmentId + ":");
            while (rs.next()) {
                int id = rs.getInt("id");
                String lastName = rs.getString("last_name");
                String firstName = rs.getString("first_name");
                String position = rs.getString("position");
                System.out.printf("ID: %d, Name: %s %s, Position: %s%n", id, firstName, lastName, position);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteEmployee(int employeeId) {
        String deleteTasksQuery = "DELETE FROM tasks WHERE employee_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(deleteTasksQuery)) {

            stmt.setInt(1, employeeId);
            stmt.executeUpdate();
            String deleteEmployeeQuery = "DELETE FROM employers WHERE id = ?";
            try (PreparedStatement stmt2 = conn.prepareStatement(deleteEmployeeQuery)) {
                stmt2.setInt(1, employeeId);
                int rowsAffected = stmt2.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Employee deleted successfully!");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
