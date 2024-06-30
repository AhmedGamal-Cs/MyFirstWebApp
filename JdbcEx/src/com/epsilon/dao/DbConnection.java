
package com.epsilon.dao;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbConnection {
    
    public static Connection getConnection() throws Exception{
        Connection conn = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/MyDb","root","22904110");
        if(conn != null){
            System.out.println("Connected");
        }else{
            System.out.println("ERRRRRRRRRROOOOORRRRRRRR");
        }
        return conn;
    }
    
    public static void closeConnection(Connection conn) throws SQLException{
        conn.close();
    }
}
