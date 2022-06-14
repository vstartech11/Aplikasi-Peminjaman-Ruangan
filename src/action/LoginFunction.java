package action;

import javax.swing.JOptionPane;
import java.sql.*;
import view.MainLayout;
import view.LoginForm;
import view.Register;
import java.awt.event.*;

public class LoginFunction extends LoginForm {
  Connection conn = null;
  ResultSet rs = null;
  Statement st = null;

  public LoginFunction() {
    conn = Koneksi.koneksi();
    getCenter();
    nim_field.setEditable(true);
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
    nim_field.addKeyListener(new KeyAdapter() {
      public void keyPressed(KeyEvent ke) {
        if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
          nim_field.setEditable(true);
        } else {
          nim_field.setEditable(false);
        }
      }
    });
  }

  private void getCenter() {
    setLocationRelativeTo(null);
  }

  public void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {
    String sql = "select * from tblUser where nim='" + getNim() + "' and password='" + getPassword() + "'";
    try {
      st = conn.createStatement();
      rs = st.executeQuery(sql);
      if (rs.next()) {
        MainLayout s = new MainMethod(rs.getString("nim"), rs.getString("nama"), rs.getString("status"));
        JOptionPane.showMessageDialog(null, "Berhasil tersambung");
        s.setVisible(true);
        conn.close();
        dispose();
      } else {
        JOptionPane.showMessageDialog(null, "NIM atau Password Salah !");
      }
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e);
    }
  }

  private void btn_registerActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_registerActionPerformed
    Register registerForm = new RegisterFunction();
    registerForm.setVisible(true);
    this.dispose();
  }// GEN-LAST:event_btn_loginActionPerformed

  public static void main(String[] args) {
    LoginForm s = new LoginFunction();
    s.setVisible(true);
  }

}
