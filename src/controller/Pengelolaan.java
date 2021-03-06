/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import java.util.ArrayList;

import javax.swing.JOptionPane;
// import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import view.PengelolaanLayout;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author USER
 */
public class Pengelolaan extends PengelolaanLayout {
    List<String> listkode = new ArrayList<String>();
    DefaultTableModel model;
    private User user;
    private Main mainMethod;
    Connection conn = null;
    ResultSet rs = null;
    Statement st = null;

    public Pengelolaan(User user, Main mainMethod) {
        this.user = user;
        this.mainMethod = mainMethod;
        conn = Koneksi.koneksi();
        getTable();
        jPanel9.setVisible(false);
        jPanel2.setVisible(false);

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
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
    }

    // private String getIdRuangan(String a) {
    //     String id = null;
    //     String sql = "select idRuangan from tblRuangan where namaRuangan='" + a + "'";
    //     try {
    //         st = conn.createStatement();
    //         rs = st.executeQuery(sql);
    //         if (rs.next()) {
    //             id = rs.getString(1);
    //         }
    //     } catch (Exception e) {
    //         // TODO: handle exception
    //     }
    //     return id;
    // }

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
            String sql = "select tblPeminjaman.kodePinjam, tblPeminjaman.nim, tblRuangan.namaRuangan, tblPeminjaman.tglPinjam, tblPeminjaman.ketSesi, tblPeminjaman.ketPinjam from tblPeminjaman join tblRuangan on tblPeminjaman.idRuangan=tblRuangan.idRuangan where tblPeminjaman.kodePinjam='"
                    + kodeInput2.getText() + "'";
            try {
                st = conn.createStatement();
                rs = st.executeQuery(sql);
                if (rs.next()) {
                    kodeInput2.setEnabled(false);
                    JOptionPane.showMessageDialog(null, "Data ditemukan");
                    namaRuanganInput.addItem(rs.getString(3));
                    namaRuanganInput.setSelectedItem(rs.getString(3));
                    final java.sql.Date dateNew = java.sql.Date.valueOf(rs.getString(4));
                    tanggalPinjamInput.setDate(dateNew);
                    sesiInput.addItem(rs.getString(5));
                    sesiInput.setSelectedItem(rs.getString(5));
                    ketPeminjamanInputArea.setText(rs.getString(6));
                    jPanel9.setVisible(true);
                } else
                    JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {
        boolean hapus = hapusRadioButton2.isSelected();
        boolean edit = editRadioButton2.isSelected();
        if (hapus == true) { // fungsi untuk menghapus peminjaman ruangan dari sisi admin
            hapusData();
        } else if (edit == true) {
            jPanel9.setVisible(false);
            jPanel2.setVisible(true);
        }
    }

    private void hapusData() {
        String sql = "delete from tblPeminjaman where kodePinjam='" + kodeInput2.getText() + "'";
        try {
            st = conn.createStatement();
            int row = st.executeUpdate(sql);
            if (row != 0) {
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
                hapusRadioButton2.setSelected(false);
                kodeInput2.setText(null);
                PengelolaanLayout kelola = new Pengelolaan(user, this.mainMethod);
                kelola.setVisible(true);
                this.dispose();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    private void kembaliButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    private void simpanButtonActionPerformed(java.awt.event.ActionEvent evt) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String newDate = formatter.format(tanggalPinjamInput.getDate());

        if (namaRuanganInput.getSelectedItem().equals("") || tanggalPinjamInput.getDate().equals("")
                || sesiInput.getSelectedItem().equals("") || isRadioButtonSelected() == false
                || ketPeminjamanInputArea.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "gagal");
        } else {
            // database di sini
            String sql = "update tblPeminjaman set tglPinjam='"
                    + newDate + "',ketPinjam='" + ketPeminjamanInputArea.getText()
                    + "' where kodePinjam='"
                    + kodeInput2.getText() + "'";
            try {
                st = conn.createStatement();
                int row = st.executeUpdate(sql);
                if (row != 0) {
                    JOptionPane.showMessageDialog(null, "MIE SUKSES ISI 1");
                    PengelolaanLayout kelola = new Pengelolaan(user, this.mainMethod);
                    kelola.setVisible(true);
                    this.dispose();
                }
            } catch (Exception e) {
                // TODO: handle exception
            }

            // ini fungsi lain
            editRadioButton2.setSelected(false);
            hapusRadioButton2.setSelected(false);
            ketPeminjamanInputArea.setText("");
            jPanel2.setVisible(false);
            jPanel9.setVisible(false);
        }
    }

    private boolean isRadioButtonSelected() {
        if (this.editRadioButton2.isSelected() || this.hapusRadioButton2.isSelected()) {
            return true;
        }
        return false;
    }

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
        jPanel2.setVisible(false);
        kodeInput2.setText("");
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }
}
