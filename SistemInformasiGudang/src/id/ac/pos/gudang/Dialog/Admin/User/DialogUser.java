/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.Dialog.Admin.User;

import id.ac.pos.gudang.Form.FormAdmin;
import id.ac.pos.gudang.dao.admin.UserDAO;
import id.ac.pos.gudang.daoimpl.admin.UserDAOImpl;
import id.ac.pos.gudang.entity.User;
import id.ac.pos.gudang.tablemodel.admin.UserTM;
import java.awt.Dialog;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Oyoy
 */
public class DialogUser extends javax.swing.JDialog {

    /**
     * Creates new form DialogUser
     */
    private User user;
    private UserDAO dao;
    private ArrayList<User> arrayUser;

    public void getData() {
        dao = new UserDAOImpl();
        arrayUser = dao.getUser();

        UserTM userTableModel = new UserTM();
        userTableModel.setDataUser(arrayUser);

        tableUser.setModel(userTableModel);
    }

    public DialogUser(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        getData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableUser = new javax.swing.JTable();
        buttonTambahUser = new javax.swing.JButton();
        buttonHapusUser = new javax.swing.JButton();
        buttonUbahUser = new javax.swing.JButton();
        buttonRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tableUser.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableUser);

        buttonTambahUser.setText("Tambah");
        buttonTambahUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTambahUserActionPerformed(evt);
            }
        });

        buttonHapusUser.setText("Hapus");
        buttonHapusUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusUserActionPerformed(evt);
            }
        });

        buttonUbahUser.setText("Ubah");
        buttonUbahUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUbahUserActionPerformed(evt);
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
                        .addComponent(buttonTambahUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonHapusUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonUbahUser, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonRefresh)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonTambahUser)
                    .addComponent(buttonHapusUser)
                    .addComponent(buttonUbahUser)
                    .addComponent(buttonRefresh))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonTambahUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTambahUserActionPerformed
        // TODO add your handling code here:
        DialogTambahUser dtu = new DialogTambahUser(null, true);
        dtu.setLocationRelativeTo(null);
        dtu.setVisible(true);
        getData();
    }//GEN-LAST:event_buttonTambahUserActionPerformed

    private void buttonHapusUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHapusUserActionPerformed
        // TODO add your handling code here:
        int baris = tableUser.getSelectedRow();
        if (baris >= 0) {
            String nik = tableUser.getValueAt(baris, 3).toString();
            String namaUser = tableUser.getValueAt(baris, 1).toString();
            int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin "
                    + "menghapus Username dengan user : " + nik
                    + " dengan Nama User " + namaUser
                    + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (ok == 0) {
                dao = new UserDAOImpl();
                dao.hapusUser(nik);
                getData();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Anda harus memilih dahulu user "
                    + "yang akan dihapus !");
            getData();
        }
        JOptionPane.showMessageDialog(this, "Data berhasil dihapus");
        getData();
    }//GEN-LAST:event_buttonHapusUserActionPerformed

    private void buttonUbahUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUbahUserActionPerformed
        // TODO add your handling code here:
        int baris = tableUser.getSelectedRow();
        if (baris >= 0) {
            //mengambil user dari baris table
            User userTerpilih = arrayUser.get(baris);
            FormAdmin admin = new FormAdmin();
            //munculkan dialog
            DialogUbahUser duu = new DialogUbahUser(admin, true, userTerpilih);
            duu.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
            duu.setLocationRelativeTo(null);
            duu.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Anda Harus Memilih Terlebih Dahulu User Yang Akan Diubah!");
        }
    }//GEN-LAST:event_buttonUbahUserActionPerformed

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
            java.util.logging.Logger.getLogger(DialogUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogUser dialog = new DialogUser(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton buttonHapusUser;
    private javax.swing.JButton buttonRefresh;
    private javax.swing.JButton buttonTambahUser;
    private javax.swing.JButton buttonUbahUser;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableUser;
    // End of variables declaration//GEN-END:variables
}
