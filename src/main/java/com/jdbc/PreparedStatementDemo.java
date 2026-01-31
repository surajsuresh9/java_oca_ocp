package com.jdbc;

import java.sql.*;
import java.util.TimeZone;

public class PreparedStatementDemo {
    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
        String url = "jdbc:postgresql://localhost:5432/phonebook_db?user=admin&password=admin";
        try (Connection con = DriverManager.getConnection(url)) {
            System.out.println("Connected to DB");

            // SELECT
            PreparedStatement ps = con.prepareStatement("SELECT * FROM contacts");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String phNo = rs.getString("ph_no");
                System.out.println(id + " - " + firstName + " " + lastName + " : " + phNo);
            }

            // INSERT
            PreparedStatement ps2 = con.prepareStatement(
                    "INSERT INTO contacts (first_name, last_name, ph_no) VALUES (?,?,?)"
            );
            ps2.setString(1, "John");
            ps2.setString(2, "Wayne");
            ps2.setString(3, "9988123488");
            int i = ps2.executeUpdate();
            if (i > 0) {
                System.out.println("A record was inserted successfully");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
