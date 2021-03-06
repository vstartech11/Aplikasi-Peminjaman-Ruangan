package controller;

import javax.swing.JOptionPane;
import java.sql.*;
import view.MainLayout;
import view.LoginLayout;
import view.RegisterLayout;
import java.awt.event.*;

public class Login extends LoginLayout {
  Connection conn = null;
  ResultSet rs = null;
  Statement st = null;

  public Login() {
    conn = Koneksi.koneksi();
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

  public void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {
    User login = new User(nim_field.getText(), String.valueOf(pass_field.getPassword()));
    String sql = "select * from tblUser where nim='" + login.getNim() + "' and password='" + login.getPassword() + "'";
    try {
      st = conn.createStatement();
      rs = st.executeQuery(sql);
      if (rs.next()) {
        User user = new User(rs.getString("nim"), rs.getString("nama"), rs.getString("email"), rs.getString("noTelp"), rs.getString("password"), rs.getString("status"));
        MainLayout s = new Main(user);
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
    RegisterLayout registerForm = new Register();
    registerForm.setVisible(true);
    this.dispose();
  }// GEN-LAST:event_btn_loginActionPerformed

  public static void main(String[] args) {
    LoginLayout s = new Login();
    s.setVisible(true);
  }

}
