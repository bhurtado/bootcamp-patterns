package singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlDBClient {

    public static SqlDBClient instance;
    public static Connection connection;
    public String url = "jdbc:jtds:sqlserver://BETTY//SQLEXPRESS:1433;encrypt=true;integratedSecurity=true;";
    public String username="betty";
    public String password="123456";


    private SqlDBClient() throws SQLException {
        try {
            // Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            connection = DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }

    public static Connection getConnection()
    {
        if (connection == null){
            System.out.println("Primera vez");
        }
        return connection;
    }

    public static SqlDBClient getInstance() throws SQLException {
        if (instance == null) {
            instance = new SqlDBClient();
        } else if (getConnection().isClosed()) {
            instance = new SqlDBClient();
        }

        return instance;
    }

}
