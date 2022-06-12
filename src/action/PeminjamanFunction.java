package action;

import view.PeminjamanRuanganLayout;

public class PeminjamanFunction extends PeminjamanRuanganLayout{
    public PeminjamanFunction() {
        this.backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        setVisible(false);
    }    
}
