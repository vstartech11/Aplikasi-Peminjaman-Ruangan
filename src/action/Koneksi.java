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

    // public ResultSet query() {
    //     ResultSet rs = null;
    //     Statement st = null;
    //     int curRow = 0;
    //     try {
    //         st = conn.createStatement();
    //         rs = st.executeQuery(sql);
    //         return rs;
    //     } catch (Exception e) {
    //         // TODO: handle exception
    //     }
    // }
}
