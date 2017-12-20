/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.Dialog.Admin.Regional;

import id.ac.pos.gudang.dao.admin.RegionalDAO;
import id.ac.pos.gudang.daoimpl.admin.RegionalDAOImpl;
import id.ac.pos.gudang.entity.Regional;
import id.ac.pos.gudang.tablemodel.admin.RegionalTM;
import java.awt.Dialog;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Oyoy
 */
public class DialogRegional extends javax.swing.JDialog {

    /**
     * Creates new form DialogRegional
     */
    private Regional regional;
    private RegionalDAO dao;
    private ArrayList<Regional> arrayRegional;

    public DialogRegional(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        getData();
    }

    private void getData() {
        dao = new RegionalDAOImpl();
        arrayRegional = dao.getRegional();

        RegionalTM regionalTableModel = new RegionalTM();
        regionalTableModel.setDataRegional(arrayRegional);

        tableRegional.setModel(regionalTableModel);
        fieldCariRegional.setText("");
    }

    private void cariData(String keyword) {
        dao = new RegionalDAOImpl();
        arrayRegional = dao.cariRegional(keyword);

        RegionalTM regionalTableModel = new RegionalTM();
        regionalTableModel.setDataRegional(arrayRegional);

        tableRegional.setModel(regionalTableModel);
    }

    private void refreshData() {
        cariData(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        fieldCariRegional = new javax.swing.JTextField();
        buttonCari = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableRegional = new javax.swing.JTable();
        buttonTambah = new javax.swing.JButton();
        buttonUbah = new javax.swing.JButton();
        buttonHapus = new javax.swing.JButton();
        buttonRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Cari Regional");

        buttonCari.setText("Cari");
        buttonCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCariActionPerformed(evt);
            }
        });

        tableRegional.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableRegional.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableRegional);

        buttonTambah.setText("Tambah");
        buttonTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTambahActionPerformed(evt);
            }
        });

        buttonUbah.setText("Ubah");
        buttonUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUbahActionPerformed(evt);
            }
        });

        buttonHapus.setText("Hapus");
        buttonHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusActionPerformed(evt);
            }
        });

        buttonRefresh.setText("Refresh");
        buttonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 1, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buttonTambah)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonHapus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonUbah)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonRefresh))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fieldCariRegional, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonCari)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fieldCariRegional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonCari))
                    .addComponent(jLabel1))
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonTambah)
                    .addComponent(buttonUbah)
                    .addComponent(buttonHapus)
                    .addComponent(buttonRefresh))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTambahActionPerformed
        // TODO add your handling code here:
        DialogTambahRegional dtr = new DialogTambahRegional(null, rootPaneCheckingEnabled);
        dtr.setLocationRelativeTo(null);
        dtr.setVisible(true);
        refreshData();
        getData();
    }//GEN-LAST:event_buttonTambahActionPerformed

    private void buttonHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHapusActionPerformed
        // TODO add your handling code here:
        int baris = tableRegional.getSelectedRow();
        if (baris >= 0) {
            String idRegional = tableRegional.getValueAt(baris, 0).toString();
            String namaRegional = tableRegional.getValueAt(baris, 1).toString();
            int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin "
                    + "menghapus Regional dengan kode : " + idRegional
                    + " dengan Nama Regional " + namaRegional
                    + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (ok == 0) {
                dao = new RegionalDAOImpl();
                dao.hapusRegional(idRegional);
                getData();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Anda harus memilih dahulu regional "
                    + "yang akan dihapus !");
            getData();
        }
        getData();
    }//GEN-LAST:event_buttonHapusActionPerformed

    private void buttonUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUbahActionPerformed
        // TODO add your handling code here:
        int baris = tableRegional.getSelectedRow();
        if (baris >= 0) {
            // mengambil anggota dari baris table
            Regional regionalTerpilih = arrayRegional.get(baris);

            // munculkan dialog
            DialogUbahRegional dur = new DialogUbahRegional (this, true, regionalTerpilih);
            dur.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
            dur.setLocationRelativeTo(null);
            dur.setVisible(true);
            getData();

        } else {
            JOptionPane.showMessageDialog(this, "Anda Harus Memilih Terlebih Dahulu Regional Yang Akan Diubah!");
        }
    }//GEN-LAST:event_buttonUbahActionPerformed

    private void buttonCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariActionPerformed
        // TODO add your handling code here:
        String keyword = fieldCariRegional.getText();
        
        //lakukan pencarian 
        dao = new RegionalDAOImpl();
        arrayRegional = dao.cariRegional(keyword);
        
        RegionalTM regionalTableModel = new RegionalTM();
        regionalTableModel.setDataRegional(arrayRegional);
        
        tableRegional.setModel(regionalTableModel);
    }//GEN-LAST:event_buttonCariActionPerformed

    private void buttonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRefreshActionPerformed
        // TODO add your handling code here:
        getData();
    }//GEN-LAST:event_buttonRefreshActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DialogRegional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogRegional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogRegional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogRegional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogRegional dialog = new DialogRegional(new javax.swing.JDialog(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCari;
    private javax.swing.JButton buttonHapus;
    private javax.swing.JButton buttonRefresh;
    private javax.swing.JButton buttonTambah;
    private javax.swing.JButton buttonUbah;
    private javax.swing.JTextField fieldCariRegional;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableRegional;
    // End of variables declaration//GEN-END:variables
}
