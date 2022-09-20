package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
    static Connection connection;
    public static Connection getConnection(){

        try {
            //load the driver
            Class.forName("com.mysql.jdbc.Driver");
            //create connction
            String user = "root";
            String password = "";
            String url = "jdbc:mysql://localhost:3306/student_project";
            connection = DriverManager.getConnection(url,user,password);

        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;


    }

}
