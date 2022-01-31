package SurvivalGame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Launcher.Launcher;
import Launcher.SignIn;

public class Repository {

    private static final String DatabaseLocation = System.getProperty("user.dir") + "\\SurvivalGameDatabase.accdb";

    public static Connection getConnection() {
        try {
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + DatabaseLocation, "", "");
            return con;

        } catch (Exception e) {
            System.out.println("Error in the repository class: " + e);
        }return null;
    }

    public static void inputSignUpDetails(String Name, String Email, String Password) {
        try {

            Connection con = getConnection();

            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "INSERT INTO LoginTbl (Account_Name, Email, Password) VALUES ('" + Name +"','" + Email + "','" + Password + "')";
            stmt.executeUpdate(sql);

            stmt.close();
            con.close();

        }catch (Exception e) {
            System.out.println("Error in the repository: " + e);
        }

    }

    public static ResultSet login(String Email, String Password){
        ResultSet rs;
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "SELECT * FROM LoginTbl WHERE Email = '" + Email + "' AND password ='" + Password + "'";
            rs = stmt.executeQuery(sql);


            rs.close();
            con.close();
            return rs;
        }catch (Exception e) {
            System.out.println("Error in the repository: " + e);
        }
        return null;
    }


}
