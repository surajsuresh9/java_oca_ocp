package com.jdbc;

public class ResourceLeaksDemo {
    /*
            - Database Resources
                - database resources are expensive and are easily multiplied
                    - e.g: imagine everytime we fetch something from the DB, we open a connection and never close it
                - for that reason its important to close te resources after operation is done
                - when closing tehr resources order is important
                    1. ResultSet, e.g rs.close()
                    2. PreparedStatement or CallableStatement, e.g stmt.close()
                    3. Connection, e.g conn.close()

            - Using try-with-resources
                - recommended way of working with try-with-resources
                    - in this way, all resources will be closed automatically after we are done
                - but order is important
                    - try-with-resources closes the resources in the reverse order from which they are initialized

                try (Connection con = DriverManager.getConnection(url);
                     PreparedStatement ps = con.prepareStatement(sql);
                     Resultset rs = ps.executeQuery();
                ){...}

     */
}
