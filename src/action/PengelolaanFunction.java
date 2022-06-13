/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package action;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import view.Pengelolaan;
/**
 *
 * @author USER
 */
public class PengelolaanFunction extends Pengelolaan{
    List listkode = new ArrayList<String>();
    DefaultTableModel model;
    private int baristeerpilih;
    public PengelolaanFunction(){
        String[]judul = {"Kode Peminjaman","NIM","ID Ruangan","Tanggal Pinjam","Sesi","Keterangan Peminjaman"};
        model = new DefaultTableModel(judul,0);
        String[]row1 = {"PJ001","Bintang","1","13-06-2022","4"};
        String[]row2 = {"PJ002","Saman","2","14-06-2022","4"};
        tabelPengelolaan.setModel(model);
        
        tabelPengelolaan.isEditing();
        tabelPengelolaan.getColumnModel().getColumn(0).setPreferredWidth(150);
        tabelPengelolaan.getColumnModel().getColumn(1).setPreferredWidth(100);
        tabelPengelolaan.getColumnModel().getColumn(2).setPreferredWidth(150);
        tabelPengelolaan.getColumnModel().getColumn(3).setPreferredWidth(200);
        tabelPengelolaan.getColumnModel().getColumn(4).setPreferredWidth(100);
        tabelPengelolaan.getColumnModel().getColumn(5).setPreferredWidth(500);
        model.addRow(row1);
        model.addRow(row2);;
        jPanel9.setVisible(false);
        jPanel2.setVisible(false);
        System.out.println(tabelPengelolaan.getRowCount());
        
        for (int i =0;i< tabelPengelolaan.getRowCount();i++){
            listkode.add(tabelPengelolaan.getValueAt(i, 0));
        }
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
    private void cariButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        String kode = kodeInput2.getText();
        System.out.println(kode);
        for (int i =0;i<listkode.size();i++){
        if (kode.equals(listkode.get(i))){
            System.out.println("Berhasil mas");
            baristeerpilih = i;
            jPanel9.setVisible(true);
            break;
        }
        else{
            
        }
        }
    }
    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
    boolean hapus = hapusRadioButton2.isSelected();
    boolean edit = editRadioButton2.isSelected();
    if (hapus == true){ //fungsi untuk menghapus peminjaman ruangan dari sisi admin
        jPanel9.setVisible(false);
    model.removeRow(baristeerpilih);
    }
    else if(edit == true){
    jPanel9.setVisible(false);
    jPanel2.setVisible(true);
    }
    }
    private void kembaliButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        jPanel9.setVisible(false);
        kodeInput2.setText("");
    }
    private void simpanButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        String idRuangan = namaRuanganInput.getText();
        String tanggalPinjam = tanggalPinjamInput.getText();
        String ketPeminjaman = ketPeminjamanInputArea.getText();
        String sesi = sesiInput.getText();
        model.setValueAt(idRuangan, baristeerpilih, 3);
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
        kodeInput.setText("");
    }
    
    public static void main(String[] args) {
        Pengelolaan kelola = new PengelolaanFunction();
        kelola.setVisible(true);
    }
}
