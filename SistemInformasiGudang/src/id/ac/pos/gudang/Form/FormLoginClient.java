/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.Form;

import id.ac.pos.gudang.Dialog.DialogIpAddress;
import id.ac.pos.gudang.entity.User;
import id.ac.pos.gudang.utility.DatabaseConnectivity;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Oyoy
 */
public class FormLoginClient extends javax.swing.JFrame {

    /**
     * Creates new form FormLogin
     */
    Connection con;
    PreparedStatement state = null;
    ResultSet rs;
    String sql;

    public FormLoginClient() throws IOException, InterruptedException {
        initComponents();
        fieldNik.requestFocus();
        try {
            String path = new File(".").getCanonicalPath();
            File file = new File(path + "\\alamat_ip.txt");

            if (!file.exists()) {
                FileWriter fw = new FileWriter(path + "\\alamat_ip.txt");
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("");
                bw.close();

                file.setReadOnly();
            }

            
        } catch (IOException ex) {
            Logger.getLogger(FormLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
//        con = DatabaseConnectivity.getConnection();
//        System.out.println(con);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator2 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jTextField3 = new javax.swing.JTextField();
        ip_address = new javax.swing.JButton();
        labelUsername = new javax.swing.JLabel();
        fieldPassword = new javax.swing.JPasswordField();
        fieldNik = new javax.swing.JTextField();
        labelPassword = new javax.swing.JLabel();
        buttonReset = new javax.swing.JButton();
        buttonLogin = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jTextField3.setText("jTextField3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ip_address.setText("Ip Address Server");
        ip_address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ip_addressActionPerformed(evt);
            }
        });
        getContentPane().add(ip_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, -1, 30));

        labelUsername.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        labelUsername.setText("NIK");
        getContentPane().add(labelUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 70, 30));

        fieldPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldPasswordKeyPressed(evt);
            }
        });
        getContentPane().add(fieldPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 140, 160, 30));

        fieldNik.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldNikKeyPressed(evt);
            }
        });
        getContentPane().add(fieldNik, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 100, 160, 30));

        labelPassword.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        labelPassword.setText("Password");
        getContentPane().add(labelPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, 70, 30));

        buttonReset.setText("Reset");
        buttonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonResetActionPerformed(evt);
            }
        });
        getContentPane().add(buttonReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 177, 80, -1));

        buttonLogin.setText("Login");
        buttonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoginActionPerformed(evt);
            }
        });
        getContentPane().add(buttonLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 177, 80, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonResetActionPerformed
        // TODO add your handling code here:
        fieldNik.setText("");
        fieldPassword.setText("");
    }//GEN-LAST:event_buttonResetActionPerformed

    private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoginActionPerformed
        // TODO add your handling code here:
        try {
            con = DatabaseConnectivity.getConnection();

            if (con != null) {

                sql = "SELECT * FROM tb_user WHERE nik='" + fieldNik.getText()
                        + "' AND password='" + fieldPassword.getText() + "' AND status='0'";

                state = con.prepareStatement(sql);
                rs = state.executeQuery();
                //validasi
                if (rs.next()) {
                    if (fieldPassword.getText().equals(rs.getString("password"))
                            && fieldNik.getText().equals(rs.getString("nik"))
                            && "FL".equals(rs.getString("hak_akses"))) {
                        JOptionPane.showMessageDialog(null, "Login Sukses !");
                        FormHome fh = new FormHome(rs.getString("nama_user"), rs.getString("nik"));
                        fh.setVisible(true);
                        this.setVisible(false); //form login akan tertutup
                    } else if (fieldPassword.getText().equals(rs.getString("password"))
                            && fieldNik.getText().equals(rs.getString("nik"))
                            && "AD".equals(rs.getString("hak_akses"))) {
                        JOptionPane.showMessageDialog(null, "Login Sukses !");
                        FormAdmin fa = new FormAdmin();
                        fa.setVisible(true);
                        this.setVisible(false); //form login akan tertutup
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "                Login Gagal! \n NIK atau Password Salah!", "", 1);
                    fieldNik.setText(null);//set nilai txtUser menjadi kosong
                    fieldPassword.setText(null);//set nilai txtPass menjadi kosong
                    fieldNik.requestFocus();
                }

            } else {
                JOptionPane.showMessageDialog(null, "                IP Address Server salah!", "", 1);
                con.close();
            }
        } catch (SQLException | IOException | InterruptedException ex) {
            Logger.getLogger(FormLoginClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonLoginActionPerformed

    private void fieldNikKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNikKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            fieldPassword.requestFocus();
        }
    }//GEN-LAST:event_fieldNikKeyPressed

    private void fieldPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldPasswordKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            buttonLogin.doClick();
        }
    }//GEN-LAST:event_fieldPasswordKeyPressed

    private void ip_addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ip_addressActionPerformed
        // TODO add your handling code here:
        DialogIpAddress address = null;
        try {
            address = new DialogIpAddress(this, true);
        } catch (IOException ex) {
            Logger.getLogger(FormLoginClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        address.setLocationRelativeTo(this);
        address.setVisible(true);
    }//GEN-LAST:event_ip_addressActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        try {
            com.jtattoo.plaf.noire.NoireLookAndFeel.setTheme("Large-Font", "Java Swing", "");
            UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormLoginClient fl = null;
                try {
                    fl = new FormLoginClient();
                } catch (IOException | InterruptedException ex) {
                    Logger.getLogger(FormLoginClient.class.getName()).log(Level.SEVERE, null, ex);
                }
                fl.setLocationRelativeTo(null);
                fl.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton buttonLogin;
    private javax.swing.JButton buttonReset;
    private javax.swing.JTextField fieldNik;
    private javax.swing.JPasswordField fieldPassword;
    private javax.swing.JButton ip_address;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel labelPassword;
    private javax.swing.JLabel labelUsername;
    // End of variables declaration//GEN-END:variables

}