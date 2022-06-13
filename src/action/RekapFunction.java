package action;

import view.RekapLayout;
import java.sql.*;
import javax.swing.table.*;
import java.sql.*;

public class RekapFunction extends RekapLayout {
  Connection conn = null;
  DefaultTableModel model;
  ResultSet rs = null;
  Statement st = null;
  int rows = 0;
  private MainMethod mainMethod;

  public RekapFunction(MainMethod mainMethod) {
    conn = Koneksi.koneksi();
    bersih();
    this.mainMethod = mainMethod;
    this.kembaliButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        kembaliButtonActionPerformed(evt);
      }
    });

    this.cariButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        cariButtonActionPerformed(evt);
      }
    });
  }

  private void kembaliButtonActionPerformed(java.awt.event.ActionEvent evt) {
    this.mainMethod.setVisible(true);
    this.dispose();
  }

  private void cariButtonActionPerformed(java.awt.event.ActionEvent evt) {
    getCari();
  }

  private void getCari() {
    String[] judul = { "Kode Peminjaman", "Nama", "Nama Ruangan", "Fasilitas", "Sesi Pinjam",
        "Tanggal Peminjaman" };
    model = new DefaultTableModel(judul, 0);
    tableContent.setModel(model);
    String sql = "select tblPeminjaman.kodePinjam,tblUser.nama,tblRuangan.namaRuangan,tblFasilitas.namaFasilitas,tblPeminjaman.ketSesi,tblPeminjaman.tglPinjam from tblPeminjaman join tblRuangan on tblPeminjaman.idRuangan=tblRuangan.idRuangan join tblFasilitas on tblRuangan.idFasilitas=tblFasilitas.idFasilitas join tblUser on tblPeminjaman.nim=tblUser.nim where tblPeminjaman.kodepinjam = '"
        + kolomCariInput.getText() + "' or tblUser.nama = '" + kolomCariInput.getText()
        + "' or tblRuangan.namaRuangan = '" + kolomCariInput.getText() + "' or tblFasilitas.namaFasilitas = '"
        + kolomCariInput.getText() + "' or tblPeminjaman.ketSesi = '" + kolomCariInput.getText()
        + "'";
    try {
      st = conn.createStatement();
      rs = st.executeQuery(sql);
      while (rs.next()) {
        model.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
            rs.getString(5),
            rs.getString(6) });
      }
    } catch (Exception e) {
      // TODO: handle exception
    }
  }

  private void bersih() {
    getTabel();
    kolomCariInput.setText(null);
    kolomCariInput.setToolTipText("Silahkan...");
    ;
  }

  private void getTabel() {
    String[] judul = { "Kode Peminjaman", "Nama", "Nama Ruangan", "Fasilitas", "Sesi Pinjam",
        "Tanggal Peminjaman" };
    model = new DefaultTableModel(judul, 0);
    tableContent.setModel(model);
    String sql = "select tblPeminjaman.kodePinjam,tblUser.nama,tblRuangan.namaRuangan,tblFasilitas.namaFasilitas,tblPeminjaman.ketSesi,tblPeminjaman.tglPinjam from tblPeminjaman join tblRuangan on tblPeminjaman.idRuangan=tblRuangan.idRuangan join tblFasilitas on tblRuangan.idFasilitas=tblFasilitas.idFasilitas join tblUser on tblPeminjaman.nim=tblUser.nim";
    try {
      st = conn.createStatement();
      rs = st.executeQuery(sql);
      while (rs.next()) {
        model.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
            rs.getString(5),
            rs.getString(6) });
      }
    } catch (Exception e) {
      // TODO: handle exception
    }
  }

}
