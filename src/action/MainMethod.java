package action;

import view.LoginForm;
import view.MainLayout;
import view.PeminjamanRuanganLayout;


public class MainMethod extends MainLayout {

    public MainMethod() {
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

    public MainMethod(String nim, String nama, String status) {
        this.showNama.setText(nama);
        this.showNim.setText(nim);
        this.showStatus.setText(status);

        loginMenu.setEnabled(false);

        if (status.equals("ADMIN")) {
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
    }

    private void logoutMenuActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    private void loginMenuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_loginMenuActionPerformed
        LoginForm login = new LoginFunction();
        login.setVisible(true);
    }

    private void peminjamanMenuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_loginMenuActionPerformed
        PeminjamanRuanganLayout peminjaman = new PeminjamanFunction();
        peminjaman.setVisible(true);
    }

    public static void main(String[] args) {
        MainLayout mainLayout = new MainMethod("dawd", "Dawd", "ADMIN");
        mainLayout.setVisible(true);
    }
}
