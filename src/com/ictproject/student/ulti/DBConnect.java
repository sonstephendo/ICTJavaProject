package com.ictproject.student.ulti;

import com.ictproject.student.MainApp;
import com.ictproject.student.model.User;
import com.ictproject.student.view.modules.ProfileController;

import java.sql.*;

/**
 * Helper Class, Using mysql-connector to working with mysql database
 */
// TODO: 09/03/2018 (Loading: Done, Storing: todo
public class DBConnect extends Configs{
    protected Connection con;
    private Statement st;
    private ResultSet rs;

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    private ProfileController profileController;

    public void setProfileController(ProfileController profileController) {
        this.profileController = profileController;
    }

    public Connection getConnect() {
        final String url = "jdbc:mysql://" + Configs.dbhost + ":" + Configs.dbport + "/" + Configs.dbname + "?autoReconnect=true&useSSL=false";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, Configs.dbuser, Configs.dbpass);
            st = con.createStatement();
            return con;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
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

    public void readData() throws SQLException {
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
