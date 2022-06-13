package action;

import view.PeminjamanRuanganLayout;
import java.sql.*;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.*;

public class PeminjamanFunction extends PeminjamanRuanganLayout {
    Connection conn = null;
    DefaultTableModel model;
    ResultSet rs = null;
    Statement st = null;
    int rows = 0;

    public PeminjamanFunction() {
        conn = Koneksi.koneksi();
        getTabel();
        getGedung();
        this.backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
    }

    private void getGedung() {
        String[] list = { "E", "F", "G", "LAB" };
        DefaultComboBoxModel comboG = new DefaultComboBoxModel<String>(list);
        gedungInput.setModel(comboG);
    }

    private void getTabel() {
        String sql = "Select tblRuangan.idRuangan,tblRuangan.namaRuangan,tblFasilitas.namaFasilitas,tblRuangan.kapRuangan,tblRuangan.statSesi1,tblRuangan.statSesi2,tblRuangan.statSesi3,tblRuangan.statSesi4 from tblRuangan join tblFasilitas on tblRuangan.idFasilitas=tblFasilitas.idFasilitas";
        String[] column = { "Id Ruangan", "Kode Ruangan", "Fasilitas", "Kursi Max", "Sesi 1", "Sesi 2", "Sesi 3",
                "Sesi 4" };
        model = new DefaultTableModel(column, 0);
        tableContent.setModel(model);
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                model.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7), rs.getString(8) });
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();

    }

    public void pinjamButtonActionPerformed(java.awt.event.ActionEvent evt) {
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
