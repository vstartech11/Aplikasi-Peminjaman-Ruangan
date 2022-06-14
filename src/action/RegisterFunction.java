package action;

import java.sql.*;
import javax.swing.JOptionPane;
import view.Register;
import view.LoginForm;
import java.awt.event.*;

public class RegisterFunction extends Register {
    Connection conn = null;
    ResultSet rs = null;
    Statement st = null;
    int rows = 0;

    public RegisterFunction() {
        getCenter();
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

    private void getCenter() {
        setLocationRelativeTo(null);
    }

    public void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_registerButtonActionPerformed
        String sql = "insert into tblUser(nim,nama,email,noTelp,password,status) values ('" + getNIM() + "','"
                + getNama()
                + "','" + getEmail() + "','" + getNoHP() + "','" + getPassword() + "','USER')";

        if (!isValidEmailAddress(getEmail())) {
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
}
