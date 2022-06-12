package action;

import view.Register;
import view.MainLayout;

public class MainMethod extends MainLayout {
    private String status;

    public MainMethod(String nim, String nama, String status) {
        this.status = status;

        System.out.println(this.status);
        if (this.status.equals("ADMIN")) {
            setPengelolaanVisibility(true);
        } else {
            setPengelolaanVisibility(false);
        }
        // logoutMenu.addActionListener(new java.awt.event.ActionListener() {
        // public void actionPerformed(java.awt.event.ActionEvent evt) {

        // }
        // });
    }

    public static void main(String[] args) {
    }
}
