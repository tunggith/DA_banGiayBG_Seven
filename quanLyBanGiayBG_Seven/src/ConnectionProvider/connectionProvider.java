/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConnectionProvider;
import java.sql.*;
/**
 *
 * @author MSI
 */
public class connectionProvider {
    private static final String DB_SERVER = "localhost";
    private static final String DB_NAME = "DA_banGiay_BG_Seven";
    private static final String DB_USERNAME = "sa";
    private static final String DB_PASSWORD = "12345678";

    private static Connection conn;

    private connectionProvider(){
    }

    public static Connection getConnection() {
        if (conn != null) {
            return conn;
        }

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String strConn = String.format("jdbc:sqlserver://%s;DatabaseName=%s;TrustServerCertificate=true;",
                    DB_SERVER, DB_NAME);
            conn = DriverManager.getConnection(strConn, DB_USERNAME, DB_PASSWORD);
        } catch (Exception ex) {
            ex.printStackTrace();
            conn = null;
        }

        return conn;
    }
    public static void main(String[] args) {
        connectionProvider conn = new connectionProvider();
        System.out.println(conn.getConnection());
    }
}
