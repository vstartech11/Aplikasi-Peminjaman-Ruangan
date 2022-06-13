package action;

import view.RekapLayout;
import java.sql.*;
import javax.swing.table.*;

public class RekapFunction extends RekapLayout {
  Connection conn = null;
  DefaultTableModel model;
  ResultSet rs = null;
  Statement st = null;
  int rows = 0;

  public RekapFunction() {
    conn = Koneksi.koneksi();
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

}
