/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package action;

import java.util.List;
import java.util.ArrayList;

import javax.swing.JOptionPane;
// import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

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
        getTable();
        jPanel9.setVisible(false);
        jPanel2.setVisible(false);
        System.out.println(tabelPengelolaan.getRowCount());

        // for (int i = 0; i < tabelPengelolaan.getRowCount(); i++) {
        // listkode.add(tabelPengelolaan.getValueAt(i, 0));
        // }
        cariButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariButtonActionPerformed(evt);
            }
        });
        okButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        kembaliButton2.addActionListener(new java.awt.event.ActionListener() {
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

    private void getTable() {
        String[] judul = { "Kode Peminjaman", "NIM", "Nama Ruangan", "Tanggal Pinjam", "Sesi",
                "Keterangan Peminjaman" };
        model = new DefaultTableModel(judul, 0);
        tabelPengelolaan.setModel(model);
        tabelPengelolaan.isEditing();
        tabelPengelolaan.getColumnModel().getColumn(0).setPreferredWidth(150);
        tabelPengelolaan.getColumnModel().getColumn(1).setPreferredWidth(100);
        tabelPengelolaan.getColumnModel().getColumn(2).setPreferredWidth(150);
        tabelPengelolaan.getColumnModel().getColumn(3).setPreferredWidth(200);
        tabelPengelolaan.getColumnModel().getColumn(4).setPreferredWidth(100);
        tabelPengelolaan.getColumnModel().getColumn(5).setPreferredWidth(500);
        String sql = "select tblPeminjaman.kodePinjam, tblPeminjaman.nim, tblRuangan.namaRuangan, tblPeminjaman.tglPinjam, tblPeminjaman.ketSesi, tblPeminjaman.ketPinjam from tblPeminjaman join tblRuangan on tblPeminjaman.idRuangan=tblRuangan.idRuangan";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                model.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6) });
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    private void cariButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (kodeInput2.getText().equals(null)) {
            JOptionPane.showMessageDialog(null, "Kolom Kode Pinjam Tidak Boleh Kosong !");
        } else {
            String sql = "select tblPeminjaman.kodePinjam, tblPeminjaman.nim, tblRuangan.namaRuangan, tblPeminjaman.tglPinjam, tblPeminjaman.ketSesi, tblPeminjaman.ketPinjam from tblPeminjaman join tblRuangan on tblPeminjaman.idRuangan=tblRuangan.idRuangan where tblPeminjaman.kodePinjam='" + kodeInput2.getText() + "'";
            try {
                st = conn.createStatement();
                rs = st.executeQuery(sql);
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Data ditemukan");
                    namaRuanganInput.setText(rs.getString(3));
                    tanggalPinjamInput.setText(rs.getString(4));
                    sesiInput.setText(rs.getString(5));
                    ketPeminjamanInputArea.setText(rs.getString(6));
                    jPanel9.setVisible(true);
                } else
                    JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        // String kode = kodeInput2.getText();
        // System.out.println(kode);
        // for (int i = 0; i < listkode.size(); i++) {
        // if (kode.equals(listkode.get(i))) {
        // System.out.println("Berhasil mas");
        // baristeerpilih = i;
        // jPanel9.setVisible(true);
        // break;
        // } else {

        // }
        // }
    }

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {
        boolean hapus = hapusRadioButton2.isSelected();
        boolean edit = editRadioButton2.isSelected();
        if (hapus == true) { // fungsi untuk menghapus peminjaman ruangan dari sisi admin

            jPanel9.setVisible(false);
            model.removeRow(baristeerpilih);
        } else if (edit == true) {
            jPanel9.setVisible(false);
            jPanel2.setVisible(true);
        }
    }

    private void kembaliButtonActionPerformed(java.awt.event.ActionEvent evt) {
        jPanel9.setVisible(false);
        kodeInput2.setText("");
    }

    private void simpanButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String namaRuangan = namaRuanganInput.getText();
        String tanggalPinjam = tanggalPinjamInput.getText();
        String ketPeminjaman = ketPeminjamanInputArea.getText();
        String sesi = sesiInput.getText();
        model.setValueAt(namaRuangan, baristeerpilih, 3);
        model.setValueAt(tanggalPinjam, baristeerpilih, 4);
        model.setValueAt(sesi, baristeerpilih, 5);
        model.setValueAt(ketPeminjaman, baristeerpilih, 6);
        jPanel2.setVisible(false);
        namaRuanganInput.setText("");
        tanggalPinjamInput.setText("");
        sesiInput.setText("");
        kodeInput2.setText("");
    }

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {

        jPanel2.setVisible(false);
        kodeInput2.setText("");
    }

    public static void main(String[] args) {
        Pengelolaan kelola = new PengelolaanFunction();
        kelola.setVisible(true);
    }
}
