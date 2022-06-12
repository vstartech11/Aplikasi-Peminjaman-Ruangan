/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author HP
 */
public class PeminjamanRuanganLayout extends javax.swing.JFrame {

    /**
     * Creates new form PeminjamanRuanganLayout
     */
    public PeminjamanRuanganLayout() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableContent = new javax.swing.JTable();
        gedungInput = new javax.swing.JComboBox<>();
        gedungText = new javax.swing.JLabel();
        namaRuanganInput = new javax.swing.JComboBox<>();
        namaRuanganText = new javax.swing.JLabel();
        tanggalInput = new com.toedter.calendar.JDateChooser();
        tanggalPinjamText = new javax.swing.JLabel();
        sesiInput = new javax.swing.JComboBox<>();
        sesiText = new javax.swing.JLabel();
        statusText = new javax.swing.JLabel();
        statusShow = new javax.swing.JTextField();
        fileButton = new javax.swing.JButton();
        showFilePath = new javax.swing.JTextField();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Peminjaman");
        setMaximumSize(new java.awt.Dimension(1080, 720));
        setMinimumSize(new java.awt.Dimension(1080, 720));
        setResizable(false);
        setSize(new java.awt.Dimension(1080, 720));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        tableContent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableContent);
        if (tableContent.getColumnModel().getColumnCount() > 0) {
            tableContent.getColumnModel().getColumn(0).setResizable(false);
            tableContent.getColumnModel().getColumn(2).setResizable(false);
        }

        gedungInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { //"G", "E", "F"
    }));
        gedungInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gedungInputActionPerformed(evt);
            }
        });

        gedungText.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        gedungText.setText("Gedung :");

        namaRuanganInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { //"Item 1", "Item 2", "Item 3", "Item 4"
    }));
        namaRuanganInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaRuanganInputActionPerformed(evt);
            }
        });

        namaRuanganText.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        namaRuanganText.setText("Nama Ruangan :");

        tanggalInput.setDateFormatString("dd-MM-yyyy");

        tanggalPinjamText.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tanggalPinjamText.setText("Tanggal Pinjam :");

        sesiInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sesi 1", "Sesi 2", "Sesi 3", "Sesi 4"
    }));
        sesiInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sesiInputActionPerformed(evt);
            }
        });

        sesiText.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        sesiText.setText("Sesi :");

        statusText.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        statusText.setText("Status :");

        statusShow.setEditable(false);
        statusShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusShowActionPerformed(evt);
            }
        });

        fileButton.setText("File");
        fileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileButtonActionPerformed(evt);
            }
        });

        showFilePath.setEditable(false);
        showFilePath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showFilePathActionPerformed(evt);
            }
        });

        backButton.setText("Kembali");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1058, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(namaRuanganText)
                                    .addComponent(gedungText)
                                    .addComponent(tanggalPinjamText)
                                    .addComponent(sesiText)
                                    .addComponent(statusText)
                                    .addComponent(fileButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(sesiInput, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(statusShow)
                                    .addComponent(gedungInput, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(namaRuanganInput, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tanggalInput, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                                    .addComponent(showFilePath))))
                        .addGap(224, 224, 224))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(backButton)
                        .addGap(232, 232, 232)))
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gedungInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gedungText))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namaRuanganInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(namaRuanganText))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tanggalPinjamText)
                    .addComponent(tanggalInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sesiInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sesiText))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusText)
                    .addComponent(statusShow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showFilePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fileButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addComponent(backButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1080, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileButtonActionPerformed
        JFileChooser inputFile = new JFileChooser();
        inputFile.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image file", "jpg", "jpeg", "PNG");
        inputFile.addChoosableFileFilter(filter);

        int checkInput = inputFile.showOpenDialog(null);
        if (checkInput == JFileChooser.APPROVE_OPTION) {
            File f = inputFile.getSelectedFile();

            try {
                Image image = ImageIO.read(f.getAbsoluteFile());

            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            String filepath = f.getAbsolutePath();
            showFilePath.setText(filepath);
        }
    }//GEN-LAST:event_fileButtonActionPerformed

    private void statusShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusShowActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusShowActionPerformed

    private void sesiInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sesiInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sesiInputActionPerformed

    private void namaRuanganInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaRuanganInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaRuanganInputActionPerformed

    private void gedungInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gedungInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gedungInputActionPerformed

    private void showFilePathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showFilePathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_showFilePathActionPerformed

    /**
     * @param args the command line arguments
     */
    // public static void main(String args[]) {
    //     /* Set the Nimbus look and feel */
    //     //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    //     /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
    //      * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
    //      */
    //     try {
    //         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
    //             if ("Nimbus".equals(info.getName())) {
    //                 javax.swing.UIManager.setLookAndFeel(info.getClassName());
    //                 break;
    //             }
    //         }
    //     } catch (ClassNotFoundException ex) {
    //         java.util.logging.Logger.getLogger(PeminjamanRuanganLayout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (InstantiationException ex) {
    //         java.util.logging.Logger.getLogger(PeminjamanRuanganLayout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (IllegalAccessException ex) {
    //         java.util.logging.Logger.getLogger(PeminjamanRuanganLayout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (javax.swing.UnsupportedLookAndFeelException ex) {
    //         java.util.logging.Logger.getLogger(PeminjamanRuanganLayout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     }
    //     //</editor-fold>

    //     /* Create and display the form */
    //     java.awt.EventQueue.invokeLater(new Runnable() {
    //         public void run() {
    //             new PeminjamanRuanganLayout().setVisible(true);
    //         }
    //     });
    // }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton fileButton;
    protected javax.swing.JButton backButton;
    protected javax.swing.JComboBox<String> gedungInput;
    private javax.swing.JLabel gedungText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    protected javax.swing.JComboBox<String> namaRuanganInput;
    private javax.swing.JLabel namaRuanganText;
    protected javax.swing.JComboBox<String> sesiInput;
    private javax.swing.JLabel sesiText;
    protected javax.swing.JTextField showFilePath;
    protected javax.swing.JTextField statusShow;
    private javax.swing.JLabel statusText;
    private javax.swing.JTable tableContent;
    protected com.toedter.calendar.JDateChooser tanggalInput;
    private javax.swing.JLabel tanggalPinjamText;
    // End of variables declaration//GEN-END:variables
}
