package action;

import view.LoginForm;
import view.MainLayout;
import view.PeminjamanRuanganLayout;
import view.Pengelolaan;
import view.RekapLayout;

public class MainMethod extends MainLayout {
    private String nim;
    private String nama;
    private String status;

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
        this.nim = nim;
        this.nama = nama;
        this.status = status;
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
        this.dispose();
    }

    private void loginMenuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_loginMenuActionPerformed
        LoginForm login = new LoginFunction();
        login.setVisible(true);
        dispose();
    }

    private void peminjamanMenuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_loginMenuActionPerformed
        PeminjamanRuanganLayout peminjaman = new PeminjamanFunction(new MainMethod(this.nim, this.nama, this.status));
        peminjaman.setVisible(true);
    }

    private void pengelolaanMenuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_loginMenuActionPerformed
        Pengelolaan pengelolaan = new PengelolaanFunction(new MainMethod(this.nim, this.nama, this.status));
        pengelolaan.setVisible(true);
    }

    private void rekapMenuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_loginMenuActionPerformed
        RekapLayout rekapmenu = new RekapFunction(new MainMethod(this.nim, this.nama, this.status));
        rekapmenu.setVisible(true);
    }

    public static void main(String[] args) {
        MainLayout mainLayout = new MainMethod();
        mainLayout.setVisible(true);
    }
}
