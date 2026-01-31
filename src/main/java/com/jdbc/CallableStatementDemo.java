package com.jdbc;

import java.sql.*;
import java.util.TimeZone;

public class CallableStatementDemo {
    /*
            - Stored Procedures
                - relational database itself can contain pre-defined stored procedures
                - CallableStatement allows you to make use of stored procedures
                - stored procedures differ regarding the params they take
                    - no params
                    - IN - an input param
                    - OUT - an output param
                    - INOUT - a param that serves as input and output
     */
    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
        String url = "jdbc:postgresql://localhost:5432/phonebook_db?user=admin&password=admin";

        try (Connection con = DriverManager.getConnection(url)) {
            System.out.println("Connected to DB");

            // CallableStatement to call procedure with IN and OUT (REFCURSOR)
            String sql = "{ CALL get_phone_by_name_proc(?, ?) }";
            CallableStatement cs = con.prepareCall(sql);
            cs.setString(1, "Akash");               // IN parameter
            cs.registerOutParameter(2, Types.OTHER); // OUT refcursor
            cs.execute();

// Get ResultSet from the OUT refcursor
            ResultSet rs = (ResultSet) cs.getObject(2);
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " - " + rs.getString("first_name") + " " + rs.getString("last_name") + " : " + rs.getString("ph_no"));
            }
            rs.close();
            cs.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}