package action;

import view.LoginForm;
import view.MainLayout;

public class MainMethod extends MainLayout {
    private String status = null;
    private String nama = null;
    private String nim = null;

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

        logoutMenu.setEnabled(false);
        peminjamanMenu.setEnabled(false);
        rekapMenu.setEnabled(false);
        if (this.status.equals("ADMIN")) {
            setPengelolaanVisibility(true);
        } else {
            setPengelolaanVisibility(false);
        }
    }

    private void loginMenuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_loginMenuActionPerformed
        LoginForm login = new LoginFunction();
        login.setVisible(true);
    }

    public static void main(String[] args) {
        MainLayout mainLayout = new MainMethod();
        mainLayout.setVisible(true);
    }
}
