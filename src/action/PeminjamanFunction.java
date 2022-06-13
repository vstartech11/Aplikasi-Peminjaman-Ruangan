package action;

import view.PeminjamanRuanganLayout;
import java.sql.*;
import java.time.LocalDate;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PeminjamanFunction extends PeminjamanRuanganLayout {
    private MainMethod mainMethod;
    Connection conn = null;
    DefaultTableModel model;
    ResultSet rs = null;
    Statement st = null;
    int rows = 0;

    public PeminjamanFunction(MainMethod mainMethod) {
        this.mainMethod = mainMethod;
        conn = Koneksi.koneksi();
        getTabel();
        getGedung();
        this.backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        this.gedungInput.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                gedungInputItemStateChanged(evt);
            }
        });

        this.namaRuanganInput.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                namaRuanganInputItemStateChanged(evt);
            }
        });
    }

    private void getRuang() {
        String sql = "select namaRuangan from tblRuangan where namaRuangan like '"
                + gedungInput.getSelectedItem().toString() + "%'";
        String[] list = {};
        List<String> i = new ArrayList<String>(Arrays.asList(list));
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                i.add(rs.getString(1));
            }
            list = i.toArray(list);
            DefaultComboBoxModel comboR = new DefaultComboBoxModel<String>(list);
            namaRuanganInput.setModel(comboR);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    private String getKode() {
        String sql = "Select kodePinjam from tblPeminjaman where kodePinjam in (select max(kodePinjam) from tblPeminjaman) order by kodePinjam desc";
        String kode = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                int co = rs.getString(1).length();
                String num = rs.getString(1).substring(2, co);
                int n = Integer.parseInt(num);
                n++;
                if (n < 10) {
                    kode = "PJ" + "00" + Integer.toString(n);
                } else if (n < 100) {
                    kode = "PJ" + "0" + Integer.toString(n);
                } else if (n < 1000) {
                    kode = "PJ" + Integer.toString(n);
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return kode;
    }

    private void getGedung() {
        String[] list = { "NONE", "E", "F", "G" };
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

    private String getIdRuangan(String a) {
        String id = null;
        String sql = "select idRuangan from tblRuangan where namaRuangan='" + a + "'";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                id = rs.getString(1);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return id;
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println(getIdRuangan("G102"));
    }

    public void pinjamButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String a = namaRuanganInput.getSelectedItem().toString();
        String sql = "insert into tblPeminjaman(kodePinjam,nim,idRuangan,tglPinjam,ketSesi,ketPinjam) values('"
                + getKode()
                + "','" + this.mainMethod.showNim + "','" + getIdRuangan(a)
                + "','" + LocalDate.now() + "','','Kelas praktikum alpro B')";
    }

    private void gedungInputItemStateChanged(java.awt.event.ItemEvent evt) {
        getRuang();
        // this.namaRuanganInput.setModel(new javax.swing.DefaultComboBoxModel<>(new
        // String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
    }

    private void namaRuanganInputItemStateChanged(java.awt.event.ItemEvent evt) {
        if (namaRuanganInput.getSelectedItem().equals("Item 1")) {
            this.showKeterangan.setText("a");
        } else if (namaRuanganInput.getSelectedItem().equals("Item 2")) {
            this.showKeterangan.setText("b");
        }
    }

}
