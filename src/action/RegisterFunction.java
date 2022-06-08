package action;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JOptionPane;
import view.Register;


public class RegisterFunction extends Register{
    private String nama;
    private int nim;
    private String email;
    private String password;
    private int noHP;
    private String username;

    public RegisterFunction(){
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });
        
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            backButtonActionPerformed(evt);
            }
        });
    }

    public void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        this.nama = getNama();
        this.username = getUsername();
        this.nim = getNIM();
        this.email = getEmail();
        this.password = getPassword();
        this.noHP = getNoHP();
        int jawab = JOptionPane.showConfirmDialog(null, "Apakah data yang anda masukkan sudah benar?");
        // 0 : yes
        // 1 : no
        // 2: cancel
        switch(jawab){
            case JOptionPane.YES_OPTION:
                setVisible(false);
                MainMethod layout = new MainMethod(this.username);
                // layout.mainSetUsername(this.username);
                // layout.adminOrNot();
                layout.setLocationRelativeTo(this);
                layout.setVisible(true);
                break;
            case JOptionPane.YES_NO_CANCEL_OPTION:
                break;
                
        }
    }
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        LoginFunction loginForm = new LoginFunction();
        loginForm.setLocationRelativeTo(this);
        loginForm.setVisible(true);
        this.setVisible(false);
    }
}
