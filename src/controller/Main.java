package controller;

import view.LoginLayout;
import view.MainLayout;
import view.PeminjamanLayout;
import view.PengelolaanLayout;
import view.RekapLayout;

public class Main extends MainLayout {
    private User user;

    public Main() {
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

    public Main(User user) {
        this.user = user;

        this.showNama.setText(user.getNama());
        this.showNim.setText(user.getNim());
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
        LoginLayout login = new Login();
        login.setVisible(true);
        this.dispose();
    }

    private void loginMenuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_loginMenuActionPerformed
        LoginLayout login = new Login();
        login.setVisible(true);
        dispose();
    }

    private void peminjamanMenuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_loginMenuActionPerformed
        PeminjamanLayout peminjaman = new Peminjaman(user, new Main(user));
        peminjaman.setVisible(true);
        this.dispose();
    }

    private void pengelolaanMenuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_loginMenuActionPerformed
        PengelolaanLayout pengelolaan = new Pengelolaan(user);
        pengelolaan.setVisible(true);
        this.dispose();
    }

    private void rekapMenuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_loginMenuActionPerformed
        RekapLayout rekapmenu = new Rekap(new Main(user));
        rekapmenu.setVisible(true);
        this.dispose();
    }

    public static void main(String[] args) {
        MainLayout mainLayout = new Main();
        mainLayout.setVisible(true);
    }
}
