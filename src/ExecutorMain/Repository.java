package ExecutorMain;

import Launcher.SignUp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Repository {

    private static final String DatabaseLocation = System.getProperty("user.dir") + "\\ExecutorDatabase.accdb";

    public static Connection getConnection() {
        try {
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + DatabaseLocation, "", "");
            return con;

        } catch (Exception e) {
            System.out.println("Error in the repository class: " + e);
        }return null;
    }

    public static boolean checkExistingDetails(String Name, String Email){
        ResultSet rs;
        Boolean exists = null;
        try {
            Connection con =getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String checkExistingRecordsSql = "SELECT Email FROM LoginTbl WHERE EXISTS (SELECT Email FROM LoginTbl WHERE Email = '"+ Email +"' )";

            rs = stmt.executeQuery(checkExistingRecordsSql);
            if (rs.next()){
                System.out.println("An account with that email already exists please Try another Email");
                exists = true;
                return true;
            }else {
                exists = false;
            }
            con.close();
            return false;

        }catch (Exception e) {
            System.out.println("Error in the repository: " + e);
        }
        return exists;
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

    public static Boolean login(String Email, String Password){
        ResultSet rs;
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "SELECT * FROM LoginTbl WHERE Email = '" + Email + "' AND password ='" + Password + "'";


            rs = stmt.executeQuery(sql);
            if (rs.next()){
                System.out.println("Validlogin");

            return true;
            }


            con.close();
            return false;

        }catch (Exception e) {
            System.out.println("Error in the repository: " + e);
        }

        return null;
    }


}
