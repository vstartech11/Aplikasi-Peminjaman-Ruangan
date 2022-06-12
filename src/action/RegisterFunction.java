package action;

import java.sql.*;
import javax.swing.JOptionPane;
import view.Register;
import view.LoginForm;

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
    }

    public void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_registerButtonActionPerformed
        this.nama = getNama();
        this.nim = getNIM();
        this.email = getEmail();
        this.password = getPassword();
        this.noTelp = getNoHP();
        String sql = "insert into tblUser(nim,nama,email,noTelp,password,status) values ('" + nim + "','" + nama
                + "','" + email + "','" + noTelp + "','" + password + "','USER')";

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

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_backButtonActionPerformed
        LoginForm s = new LoginFunction();
        s.setVisible(true);
        dispose();
    }

    public static void main(String[] args) {
        Register register = new RegisterFunction();
        register.setVisible(true);
    }
}
