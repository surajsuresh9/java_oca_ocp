package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;

public class JDBCDemo {
    /*
            - Java Database Connectivity (JDBC)
                - accesses the data from the relational database
                - relational database organizes data into tables consisting of rows and columns
                    - this is how JDBC will access and process the data
                - to interact with relational database we use SQL (Structure Query language)
                - there are many dialects (flavors of SQL)
                    - e.g: PostGreSQL, MySQL, SQLite, Oracle SQL, Apache Derby, H2, etc

            - Create, Read, Update, Delete (CRUD)
                - CREATE - inserts a new row into the table
                - SELECT - retrieves (reads) data from the table
                - UPDATE - changes data in 0 or more rows in the table
                - DELETE - deletes 0 or more rows from the table

            - Simple JDBC URL
                - jdbc:postgresql://localhost:5432/phonebook_db
            {protocol}:{subprotocol}:{subname}
                - instead of localhost you can use IP address
                    - jdbc:postgresql://127.0.0.1:5432/phonebook_db
                - if using default port with localhost, it can be omitted
                    - jdbc:postgresql://localhost/phonebook_db
                - when connecting to remote host, we can use hostname, port or IP, but with poet:
                    - jdbc:postgresql://192.168.1.177:5432/phonebook_db

            - Advanced JDBC URL
                - JDBC url can contain other features like username, password, enable ssl encryption,etc.
                    - jdbc:postgresql://localhost/phonebook_db?user=admin?password=admin
                    - jdbc:postgresql://localhost/phonebook_db?ssl=true
                - In order to use JDBC, java.sql.* needs to be imported

     */
    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
        System.out.println(java.util.TimeZone.getDefault().getID());
        System.out.println("Connecting to PostgresSQL DB");
        String url = "jdbc:postgresql://localhost:5432/phonebook_db?user=admin&password=admin";
        try (Connection con = DriverManager.getConnection(url)) {
            if (con != null) {
                System.out.println("Connected to PostgresSQL DB");
            } else {
                System.out.println("Connection failed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
