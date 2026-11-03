package dao;

import com.sun.xml.internal.ws.api.ha.HaInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {


    private static final String HOST = "127.0.0.1";
    private static final  int PORT = 1433;
    private static final String DATABASENAME = "Northwind2021";
    private static final String PASSWORD = System.getenv().getOrDefault("DB_PASSWORD", "change-me");
    private static final String USERNAME = "sa";

// String.format("jdbc:mysql://%s:%d/%s",HOST,PORT,DB_NAME)
// jdbc:sqlserver://<host>:<port>;databaseName=<اسم القاعدة>
public static Connection getConnection() throws SQLException {
     String urlDatabase = String.format("jdbc:sqlserver://%s:%d;databaseName=%s;encrypt=true;trustServerCertificate=true" ,HOST,PORT , DATABASENAME);


     Connection connection = DriverManager.getConnection(urlDatabase , USERNAME , PASSWORD);
    return  connection ;
}


}
