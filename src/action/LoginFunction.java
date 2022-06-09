package action;

import javax.swing.Action;
import javax.swing.JOptionPane;

import view.MainLayout;
import view.LoginForm;

public class LoginFunction extends LoginForm{
  private String nim;
  private String password;
  public LoginFunction(){
    btn_register.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
          btn_registerActionPerformed(evt);
      }
    });
    btn_login.addActionListener(new java.awt.event.ActionListener(){
      public void actionPerformed(java.awt.event.ActionEvent evt){
      btn_loginActionPerformed(evt);
      }
    });
  }
  public void btn_loginActionPerformed(java.awt.event.ActionEvent evt){
    this.nim = getNim();
    this.password =getPassword();
    if (nim.equals("admin")&&password.equals("admin")){
      this.dispose();
      MainLayout main =new MainLayout();
      main.setVisible(true);
    }
    else{
      JOptionPane.showMessageDialog(null, "Username atau password yang anda masukkan salah");
    }
  }
  private void btn_registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registerActionPerformed
    RegisterFunction registerForm = new RegisterFunction();
    registerForm.setLocationRelativeTo(this);
    registerForm.setVisible(true);
    this.dispose();
  }//GEN-LAST:event_btn_loginActionPerformed


  public static void main(String[] args) {
    LoginForm loginForm = new LoginFunction();
  }
  
}
