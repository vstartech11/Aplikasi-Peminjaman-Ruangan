package action;
import view.LoginForm;
import view.MainLayout;

public class MainMethod extends MainLayout {

    public MainMethod(){
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

    private void loginMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginMenuActionPerformed
        LoginForm login = new LoginFunction();
        login.setVisible(true);
    }

    public static void main(String[] args) {
        MainLayout mainLayout = new MainMethod();
        mainLayout.setVisible(true);
    }
}
