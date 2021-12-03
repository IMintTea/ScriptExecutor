package SurvivalGame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Repository {

    private static final String DatabaseLocation = System.getProperty("user.dir") + "\\SurvivalGameDatabase.accdb";
    private static Connection con;

    public static Connection getConnection() {
        try {
            con = DriverManager.getConnection("jdbc:mySql//" + DatabaseLocation, "", "");
            return con;

        } catch (Exception e) {
            System.out.println("Error in the repository class: " + e);
        }return null;
    }

    public static void inputSignUpDetails(String Name, String Email, String Password) {
        try {
            String sql = "INSERT Login (Account_Name, Email, Password) VALUES ('" + Name +"','" + Email + "','" + Password + "')";
            ResultSet justDoIt;

        }catch (Exception e) {
            System.out.println("Error in the repository: " + e);
        }

    }

}
