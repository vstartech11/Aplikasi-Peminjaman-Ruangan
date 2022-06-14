package action;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.TableModel;

public class Koneksi {
    Connection conn = null;
    ResultSet rs = null;
    Statement st = null;

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

    public ResultSet tabel(String a, JTable b) {
        koneksi();
        try {
            st = conn.createStatement();
            rs = st.executeQuery(a);
            while (rs.next()) {
                b.add(b, new String[] {});
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

        return null;

    }
}
