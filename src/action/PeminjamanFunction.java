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
    public void pinjamButtonActionPerformed(java.awt.event.ActionEvent evt){
        String gedung = gedungInput.getSelectedItem().toString();
        String namaRuangan = namaRuanganInput.getSelectedItem().toString();
        String sesi = sesiInput.getSelectedItem().toString();
        String status = statusShow.getText();
        
    }
    
    public static void main(String[] args) {
        PeminjamanRuanganLayout peminjaman = new PeminjamanFunction();
        peminjaman.setVisible(true);
    }
}
