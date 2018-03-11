package com.ictproject.student.ulti;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {

    public static Connection getRemoteConnection() {
        if (System.getenv("sonstephendo-ictjavaproject-5983632") != null) {
            try {
                Class.forName("org.mysql.Driver");
                String dbName = System.getenv("students");
                String userName = System.getenv("sonstephendo");
                String password = System.getenv("");
                String hostname = System.getenv("sonstephendo-ictjavaproject-5983632");
                String port = System.getenv("3306");

                String jdbcUrl = "jdbc:mysql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password;
                System.out.println(jdbcUrl);
//                logger.trace("Getting remote connection with connection string from environment variables.");
                Connection con = DriverManager.getConnection(jdbcUrl);
//                logger.info("Remote connection successful.");
                return con;
            }
            catch (ClassNotFoundException | SQLException e) {
//                logger.warn(e.toString());
                e.printStackTrace();
            }
        }
        return null;
    }

}
