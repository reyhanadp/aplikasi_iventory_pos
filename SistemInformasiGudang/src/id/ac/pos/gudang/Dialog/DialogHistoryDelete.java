/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.Dialog;

import id.ac.pos.gudang.dao.ProdukDAO;
import id.ac.pos.gudang.daoimpl.ProdukDAOImpl;
import id.ac.pos.gudang.entity.Produk;
import id.ac.pos.gudang.tablemodel.HistoryDeleteTM;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Oyoy
 */
public class DialogHistoryDelete extends javax.swing.JDialog {

    /**
     * Creates new form DialogHistoryDelete
     */
    private Produk produk;
    private ProdukDAO dao;
    private ArrayList<Produk> arrayProduk;

    public DialogHistoryDelete(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        getDataHistory();
    }

    private void getDataHistory() {
        dao = new ProdukDAOImpl();
        arrayProduk = dao.getHistoryDelete();

        HistoryDeleteTM historyDeleteTM = new HistoryDeleteTM();
        historyDeleteTM.setDataProduk(arrayProduk);

        tableHistoryDelete.setModel(historyDeleteTM);
    }

    private void hapusHistory() {
        int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin "
                + "menghapus history update "
                + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            ProdukDAO dao = new ProdukDAOImpl();
            boolean sukses = dao.hapusHistoryDelete();

            if (sukses) {
                JOptionPane.showMessageDialog(this, "history berhasil dihapus");
                getDataHistory();
            } else {
                JOptionPane.showMessageDialog(this, "history berhasil dihapus");
                getDataHistory();
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonHapusHistory = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableHistoryDelete = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        buttonHapusHistory.setText("Hapus History");
        buttonHapusHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusHistoryActionPerformed(evt);
            }
        });

        buttonCancel.setText("Cancel");
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });

        tableHistoryDelete.setModel(new javax.swing.table.DefaultTableModel(
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
        tableHistoryDelete.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableHistoryDelete);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonHapusHistory)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCancel)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCancel)
                    .addComponent(buttonHapusHistory))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonHapusHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHapusHistoryActionPerformed
        // TODO add your handling code here:
        hapusHistory();
    }//GEN-LAST:event_buttonHapusHistoryActionPerformed

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_buttonCancelActionPerformed

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
            java.util.logging.Logger.getLogger(DialogHistoryDelete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogHistoryDelete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogHistoryDelete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogHistoryDelete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogHistoryDelete dialog = new DialogHistoryDelete(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonHapusHistory;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableHistoryDelete;
    // End of variables declaration//GEN-END:variables
}