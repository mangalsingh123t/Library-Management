import java.sql.*;

public class JDBC {
    String url;
    String userName;
    String pass;
    Connection connection;

    PreparedStatement stmt;

    public void setConnection() {
        try{
        url = "jdbc:mysql://localhost/library_managment";
        userName = "root";
        pass = "7410";
        Class.forName("com.mysql.cj.jdbc.Driver");

        connection = DriverManager.getConnection(url, userName, pass);
        System.out.println("Connection Succesfull : ");
        }catch(Exception e){
            System.out.println("Error in Connection : ");
        }
    }
}

