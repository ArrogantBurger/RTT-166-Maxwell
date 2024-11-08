package org.example;

import java.sql.*;

public class JDBC_Example {

    public static void main(String[] args) throws ClassNotFoundException {
        String dburl = "jdbc:mysql://localhost:3306/classic_models";

        // this is called a secret
        String user = "root";
        String password = "4UuJ5ErcNRJ7O6VialEZ";

        System.out.println("-------- MySQL JDBC Connection Demo ------------");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(dburl, user, password);
            String SelectSQL = "Select * FROM employees WHERE id = 1056";
            Statement stmt = connection.createStatement();
            ResultSet result =  stmt.executeQuery(SelectSQL);
            while(result.next())
            {
                String EmployeeID  = result.getString("id");
                String fname = result.getString("firstname");
                String lname  = result.getString("lastname");
                System.out.println(EmployeeID +" | " + fname + "|"+ lname );
            }
            connection.close();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }

}
