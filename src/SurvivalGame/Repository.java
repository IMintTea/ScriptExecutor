package SurvivalGame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "INSERT Login (Account_Name, Email, Password) VALUES ('" + Name +"','" + Email + "','" + Password + "')";
            ResultSet rs = stmt.executeQuery(sql);

            rs.close();
            stmt.close();
            con.close();

        }catch (Exception e) {
            System.out.println("Error in the repository: " + e);
        }

    }
//    public static void CreateAccount(String Name, String Email, String Password) {
//        try {
//            Connection con = DriverManager.getConnection("jdbc:mySql//localhost:1527/SurvivalGameDatabase", "", "");
//            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
//
//            String sql = "Select * From Login";
//            ResultSet rs = stmt.executeQuery(sql);
//            int newIdNum = -1;
//            if (rs.last()) {
//                newIdNum = rs.getInt("AccountID") + 1;
//            }
//
//            sql = "Insert into Login (Account_Name, Email, Password) Values ('" + Name +"','" + Email + "','" + Password + "')";
//            stmt.executeUpdate(sql);
//
//            rs.close();
//            stmt.close();
//            con.close();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

}
