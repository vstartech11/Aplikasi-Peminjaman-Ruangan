package action;

import javax.swing.JOptionPane;
import java.sql.*;
import view.MainLayout;
import view.LoginForm;

public class LoginFunction extends LoginForm {
  Connection conn = null;
  ResultSet rs = null;
  PreparedStatement pst = null;
  Statement st = null;
  int curRow = 0;
  private String nim;
  private String password;

  public LoginFunction() {
    conn = Koneksi.koneksi();
    btn_register.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btn_registerActionPerformed(evt);
      }
    });
    btn_login.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btn_loginActionPerformed(evt);
      }
    });
  }

  public void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {
    JOptionPane.showMessageDialog(null, "tersambung, " + conn);
    nim = getNim();
    password = getPassword();
    String sql = "select * from tblUser where nim='" + nim + "' and password='" + password + "'";
    try {
      st = conn.createStatement();
      rs = st.executeQuery(sql);
      if (rs.next()) {
        MainLayout s = new MainMethod(rs.getString("nim"), rs.getString("nama"), rs.getString("status"));
        s.setVisible(true);
        conn.close();
        dispose();
      } else {
        JOptionPane.showMessageDialog(null, "NIM atau Password Salah !");
      }
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e);
    }
    // nim = getNim();
    // password = getPassword();
    // try (Connection conn = DriverManager.getConnection(sqlconn, "bintang",
    // "441840")) {

    // st = conn.createStatement();
    // rs = st.executeQuery(sql);
    // System.out.println(conn);
    // if (rs.next()) {
    // MainLayout s = new MainLayout();
    // s.setVisible(true);
    // System.out.println("Sukses");
    // dispose();
    // } else {
    // JOptionPane.showMessageDialog(null, "NIM atau Password salah!");
    // nim_field.setText(null);
    // pass_field.setText(null);
    // }
    // } catch (SQLException e) {
    // System.out.println("Error connection");
    // JOptionPane.showMessageDialog(null, e);
    // }

  }

  private void btn_registerActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_registerActionPerformed
    RegisterFunction registerForm = new RegisterFunction();
    registerForm.setLocationRelativeTo(this);
    registerForm.setVisible(true);
    this.dispose();
  }// GEN-LAST:event_btn_loginActionPerformed

  public static void main(String[] args) {
    LoginForm s = new LoginFunction();
    s.setVisible(true);
  }

}
