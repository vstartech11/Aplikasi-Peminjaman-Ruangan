package action;

import view.LoginForm;
import view.MainLayout;
import view.PeminjamanRuanganLayout;
import view.Pengelolaan;
import view.RekapLayout;

public class MainMethod extends MainLayout {
    private User user;

    public MainMethod() {
        getCenter();
        logoutMenu.setEnabled(false);
        peminjamanMenu.setEnabled(false);
        pengelolaanMenu.setEnabled(false);
        rekapMenu.setEnabled(false);

        loginMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginMenuActionPerformed(evt);
            }
        });
    }

    private void getCenter() {
        setLocationRelativeTo(null);
    }

    public MainMethod(User user) {
        this.user = user;

        this.showNama.setText(this.user.getNama());
        this.showNim.setText(this.user.getNim());
        this.showStatus.setText(user.getStatus());

        loginMenu.setEnabled(false);

        if (user.getStatus().equals("ADMIN")) {
            setPengelolaanVisibility(true);
        } else {
            setPengelolaanVisibility(false);
        }

        logoutMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutMenuActionPerformed(evt);
            }
        });
        peminjamanMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peminjamanMenuActionPerformed(evt);
            }
        });
        pengelolaanMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pengelolaanMenuActionPerformed(evt);
            }
        });
        rekapMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rekapMenuActionPerformed(evt);
            }
        });
    }

    private void logoutMenuActionPerformed(java.awt.event.ActionEvent evt) {
        LoginForm login = new LoginFunction();
        login.setVisible(true);
        this.dispose();
    }

    private void loginMenuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_loginMenuActionPerformed
        LoginForm login = new LoginFunction();
        login.setVisible(true);
        dispose();
    }

    private void peminjamanMenuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_loginMenuActionPerformed
        PeminjamanRuanganLayout peminjaman = new PeminjamanFunction(user, new MainMethod(user));
        peminjaman.setVisible(true);
        this.dispose();
    }

    private void pengelolaanMenuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_loginMenuActionPerformed
        Pengelolaan pengelolaan = new PengelolaanFunction(user);
        pengelolaan.setVisible(true);
        this.dispose();
    }

    private void rekapMenuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_loginMenuActionPerformed
        RekapLayout rekapmenu = new RekapFunction(new MainMethod(user));
        rekapmenu.setVisible(true);
        this.dispose();
    }

    public static void main(String[] args) {
        MainLayout mainLayout = new MainMethod();
        mainLayout.setVisible(true);
    }
}
