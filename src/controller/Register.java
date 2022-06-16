package controller;

import java.sql.*;
import javax.swing.JOptionPane;
import view.RegisterLayout;
import view.LoginLayout;
import java.awt.event.*;

public class Register extends RegisterLayout {
    Connection conn = null;
    ResultSet rs = null;
    Statement st = null;
    int rows = 0;

    public Register() {
        conn = Koneksi.koneksi();
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

        noHp.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                    noHp.setEditable(true);
                } else {
                    noHp.setEditable(false);
                }
            }
        });
        nim.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                    nim.setEditable(true);
                } else {
                    nim.setEditable(false);
                }
            }
        });
    }

    public void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_registerButtonActionPerformed
        User register = new User(nim.getText(), nama.getText(), email.getText(), noHp.getText(), String.valueOf(password.getPassword()), "USER");
        String sql = "insert into tblUser(nim,nama,email,noTelp,password,status) values ('" + register.getNim() + "','"
                + register.getNama()
                + "','" + register.getEmail() + "','" + register.getNoTelpon() + "','" + register.getPassword() + "','USER')";

        if (register.getNama().equals("") || register.getNim().equals("") || register.getEmail().equals("") || register.getNoTelpon().equals("") || register.getPassword().equals("")) {
            JOptionPane.showMessageDialog(null, "Harap isi kolom yang kosong!");
            if(!isValidEmailAddress(register.getEmail())){
                JOptionPane.showMessageDialog(null, "Email tidak valid!");
            }
        } else if(!isValidEmailAddress(register.getEmail())){
            JOptionPane.showMessageDialog(null, "Email tidak valid!");
        } else {
            int jawab = JOptionPane.showConfirmDialog(null, "Apakah data yang anda masukkan sudah benar?");
            // 0 : yes
            // 1 : no
            // 2: cancel
            switch (jawab) {
                case JOptionPane.YES_OPTION:
                    try {
                        st = conn.createStatement();
                        rows = st.executeUpdate(sql);
                        if (rows != 0) {
                            JOptionPane.showMessageDialog(null, "Akun berhasil didaftarkan, Silahkan login ");
                            LoginLayout s = new Login();
                            s.setVisible(true);
                            conn.close();
                            dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "Gagal");
                        }
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                    break;
                case JOptionPane.NO_OPTION:
                    break;
            }
        }
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_backButtonActionPerformed
        LoginLayout s = new Login();
        s.setVisible(true);
        dispose();
    }

    public static boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }
}
