package com.ictproject.student.model;

import com.ictproject.student.MainApp;
import com.ictproject.student.view.modules.ProfileController;

import java.sql.*;

/**
 * Helper Class, Using mysql-connector to working with mysql database
 */
// TODO: 09/03/2018 (Loading: Done, Storing: todo
public class DBConnect {
    protected Connection con;
    private Statement st;
    private ResultSet rs;

    private ProfileController profileController;

    public void setProfileController(ProfileController profileController) {
        this.profileController = profileController;
    }

    public DBConnect() {
        try {
            // change here
            String url = "jdbc:mysql://localhost:3306/students?autoReconnect=true&useSSL=false";
            String user = "root";
            String password = "B2123ilu";

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
//            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void getData(String Names) {
        try {

            String query = "select * from Student WHERE NAME LIKE '%" + Names + "%'";
            rs = st.executeQuery(query);
            System.out.println("Records from Databases");
            readData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getData(int ID) {
        try {

            String query = "select * from Student WHERE Snum = " + Integer.toString(ID);
            rs = st.executeQuery(query);
            System.out.println("Records from Databases");
            readData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readData() throws SQLException {
        while (rs.next()) {

            int Snum = Integer.parseInt(rs.getString(1));
            String Name = rs.getString("Name");
            String Major = rs.getString("Major");
            String Level = rs.getString("Level");
            int Age = Integer.parseInt(rs.getString("Age"));

            profileController.getStudentData().add(new User(Snum, Name, Major, Level, Age));
            System.out.println(Snum +"\t" + Name +"\t" + Major +"\t" + Level +"\t" + Age);
        }
    }
}
