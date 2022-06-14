package action;

import java.sql.*;
import javax.swing.*;

public class Koneksi {
    Connection conn = null;

    public static Connection koneksi() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=dbRuang;integratedSecurity=false;trustServerCertificate=true;",
                    "bintang", "441840");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }
}
