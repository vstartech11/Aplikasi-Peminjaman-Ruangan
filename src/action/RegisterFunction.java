package action;

import java.sql.*;
import javax.swing.JOptionPane;
import view.Register;
import view.LoginForm;
import java.awt.event.*;

public class RegisterFunction extends Register {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    Statement st = null;
    int rows = 0;
    private String nama;
    private String nim;
    private String email;
    private String password;
    private String noTelp;

    public RegisterFunction() {
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
            public void keyPressed(KeyEvent ke){
                String value = noHp.getText();
                int l = value.length();
                if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                    noHp.setEditable(true);
                 } else {
                    noHp.setEditable(false);
                 }
            }
        });
    }

    public void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_registerButtonActionPerformed
        this.nama = getNama();
        this.nim = getNIM();
        this.email = getEmail();
        this.password = getPassword();
        this.noTelp = getNoHP();
        String sql = "insert into tblUser(nim,nama,email,noTelp,password,status) values ('" + nim + "','" + nama
                + "','" + email + "','" + noTelp + "','" + password + "','USER')";

        if(!isValidEmailAddress(email)){
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
                            LoginForm s = new LoginFunction();
                            s.setVisible(true);
                            conn.close();
                            dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "Gagal");
                        }
                    } catch (Exception e) {
                        // TODO: handle exception
                    }

                    // MainMethod layout = new MainMethod(this.username);
                    // layout.mainSetUsername(this.username);
                    // layout.adminOrNot();
                    // layout.setLocationRelativeTo(this);
                    // layout.setVisible(true);
                    break;
                case JOptionPane.NO_OPTION:
                    break;
            }
        }
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_backButtonActionPerformed
        LoginForm s = new LoginFunction();
        s.setVisible(true);
        dispose();
    }

    public static boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
     }

    public static void main(String[] args) {
        Register register = new RegisterFunction();
        register.setVisible(true);
    }
}
