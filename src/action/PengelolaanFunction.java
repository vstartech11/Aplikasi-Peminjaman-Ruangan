/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package action;

import java.util.List;
import java.util.ArrayList;
// import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import view.Pengelolaan;
import java.sql.*;

/**
 *
 * @author USER
 */
public class PengelolaanFunction extends Pengelolaan {
    List listkode = new ArrayList<String>();
    DefaultTableModel model;
    private int baristeerpilih;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    Statement st = null;
    int rows = 0;

    public PengelolaanFunction() {
        conn = Koneksi.koneksi();
        String[] judul = { "Kode Peminjaman", "Nama", "Kode Ruangan", "Tanggal Pinjam", "Sesi" };
        model = new DefaultTableModel(judul, 0);
        String[] row1 = { "G65", "Bintang", "G203", "13-06-2022", "4" };
        String[] row2 = { "G78", "Saman", "G206", "14-06-2022", "4" };
        tabelPengelolaan.setModel(model);
        String sql = "Select tblRuangan.idRuangan,tblRuangan.namaRuangan,tblFasilitas.namaFasilitas,tblRuangan.kapRuangan,tblRuangan.statSesi1,tblRuangan.statSesi2,tblRuangan.statSesi3,tblRuangan.statSesi4 from tblRuangan join tblFasilitas on tblRuangan.idFasilitas=tblFasilitas.idFasilitas";

        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {

                model.addRow(new String[] { rs.getString(1), "Bintang", rs.getString(2), "13-06-2022", "2" });
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

        model.addRow(row1);
        model.addRow(row2);
        ;
        jPanel1.setVisible(false);
        jPanel2.setVisible(false);
        System.out.println(tabelPengelolaan.getRowCount());

        // for (int i = 0; i < tabelPengelolaan.getRowCount(); i++) {
        // listkode.add(tabelPengelolaan.getValueAt(i, 0));
        // }
        cariButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariButtonActionPerformed(evt);
            }
        });
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        kembaliButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembaliButtonActionPerformed(evt);
            }
        });
        simpanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanButtonActionPerformed(evt);
            }
        });
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

    }

    private void cariButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String kode = kodeInput.getText();
        System.out.println(kode);
        for (int i = 0; i < listkode.size(); i++) {
            if (kode.equals(listkode.get(i))) {
                System.out.println("Berhasil mas");
                baristeerpilih = i;
                jPanel1.setVisible(true);
                break;
            } else {

            }
        }
    }

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {
        boolean hapus = hapusRadioButton.isSelected();
        boolean edit = editRadioButton.isSelected();
        if (hapus == true) { // fungsi untuk menghapus peminjaman ruangan dari sisi admin
            jPanel1.setVisible(false);
            model.removeRow(baristeerpilih);
        } else if (edit == true) {
            jPanel1.setVisible(false);
            jPanel2.setVisible(true);
        }
    }

    private void kembaliButtonActionPerformed(java.awt.event.ActionEvent evt) {
        jPanel1.setVisible(false);
        kodeInput.setText("");
    }

    private void simpanButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String namaRuangan = namaRuanganInput.getText();
        String tanggalPinjam = tanggalPinjamInput.getText();
        String sesi = sesiInput.getText();
        model.setValueAt(namaRuangan, baristeerpilih, 2);
        model.setValueAt(tanggalPinjam, baristeerpilih, 3);
        model.setValueAt(sesi, baristeerpilih, 4);
        jPanel2.setVisible(false);
        namaRuanganInput.setText("");
        tanggalPinjamInput.setText("");
        sesiInput.setText("");
        kodeInput.setText("");
    }

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {

        jPanel2.setVisible(false);
        kodeInput.setText("");
    }

    public static void main(String[] args) {
        Pengelolaan kelola = new PengelolaanFunction();
        kelola.setVisible(true);
    }
}
