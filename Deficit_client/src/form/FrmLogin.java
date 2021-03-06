/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import communication.ClientRequest;
import communication.ServerCommunication;
import communication.ServerResponse;
import constant.Constant;
import domain.User;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Djordje Janjic
 */
public class FrmLogin extends javax.swing.JFrame {

    /**
     * Creates new form FrmLogin
     */
    public FrmLogin() {
        initComponents();
        arrangeForm();
        setLabels();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        lblErrorUsername = new javax.swing.JLabel();
        lblErrorPassword = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        btnRegister = new javax.swing.JButton();
        lblHeader = new javax.swing.JLabel();
        btnClose = new javax.swing.JLabel();
        lblBckg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUsername.setFont(new java.awt.Font("Montserrat Alternates SemiBold", 0, 12)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername.setText("Korisničko ime:");
        jPanel1.add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        lblPassword.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(255, 255, 255));
        lblPassword.setText("Lozinka:");
        jPanel1.add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        txtUsername.setFont(new java.awt.Font("Montserrat Alternates SemiBold", 0, 12)); // NOI18N
        jPanel1.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 160, -1));

        txtPassword.setFont(new java.awt.Font("Montserrat Alternates SemiBold", 0, 12)); // NOI18N
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 160, -1));

        lblErrorUsername.setFont(new java.awt.Font("Montserrat Alternates Light", 0, 12)); // NOI18N
        lblErrorUsername.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorUsername.setText("jLabel3");
        jPanel1.add(lblErrorUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        lblErrorPassword.setFont(new java.awt.Font("Montserrat Alternates Light", 0, 12)); // NOI18N
        lblErrorPassword.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorPassword.setText("jLabel4");
        jPanel1.add(lblErrorPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        btnLogin.setBackground(new java.awt.Color(0, 0, 0));
        btnLogin.setFont(new java.awt.Font("Montserrat Alternates Medium", 0, 14)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Prijavi se");
        btnLogin.setBorder(null);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 160, 30));

        btnRegister.setBackground(new java.awt.Color(0, 0, 0));
        btnRegister.setFont(new java.awt.Font("Montserrat Alternates Medium", 0, 14)); // NOI18N
        btnRegister.setForeground(new java.awt.Color(255, 255, 255));
        btnRegister.setText("Registuj se");
        btnRegister.setBorder(null);
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 160, 30));

        lblHeader.setFont(new java.awt.Font("Montserrat Light", 1, 36)); // NOI18N
        lblHeader.setForeground(new java.awt.Color(255, 255, 255));
        lblHeader.setText("PRIJAVA");
        jPanel1.add(lblHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/x-icon.png"))); // NOI18N
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseMouseClicked(evt);
            }
        });
        jPanel1.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, -1, -1));

        lblBckg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/deficit_bckg.png"))); // NOI18N
        jPanel1.add(lblBckg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        getUserFromForm();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        ClientRequest clientRequest = new ClientRequest();
        clientRequest.setOperation(Constant.STOP_SERVER);
        
        ServerCommunication.getInstance().sendRequest(clientRequest);
        System.exit(0);
    }//GEN-LAST:event_btnCloseMouseClicked

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        new FrmRegister(this, true).setVisible(true);
    }//GEN-LAST:event_btnRegisterActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnClose;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRegister;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblBckg;
    private javax.swing.JLabel lblErrorPassword;
    private javax.swing.JLabel lblErrorUsername;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

    private void arrangeForm() {
        setLocationRelativeTo(null);
        
        // Skidanje title bar-a
        dispose();      
        
        setUndecorated(true);
        setSize(550, 470);
        setVisible(true);
    }

    private void setLabels() {
        lblErrorUsername.setText("");
        lblErrorPassword.setText("");
    }

    private void getUserFromForm() {
        String username = txtUsername.getText().trim();
        String password = String.copyValueOf(txtPassword.getPassword());
        
        setLabels();
        
        if(username.isEmpty())
            lblErrorUsername.setText("Morate uneti korisničko ime!");
        else
            lblErrorUsername.setText("");
        if(password.isEmpty())
            lblErrorPassword.setText("Morate uneti lozinku!");
        else
            lblErrorPassword.setText("");
        
        ClientRequest clientRequest = new ClientRequest();
        clientRequest.setOperation(Constant.GET_USER);
        
        ServerCommunication.getInstance().sendRequest(clientRequest);
        
        ServerResponse serverResponse;
        serverResponse = ServerCommunication.getInstance().getResponse();
        
        List<User> users = (List<User>) serverResponse.getData();
        User logedIn = null;
        for (User user : users) {
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                logedIn = user;
            }
        }
        if(logedIn != null){
            JOptionPane.showMessageDialog(this, "Uspešno ste se ulogovali, "+logedIn.getFirstName());
            this.dispose();
            new FrmMain().setVisible(true);
            return;
        }
        JOptionPane.showMessageDialog(this, "Ne podudaraju se korsiničko ime i lozinka");     
    }
    
    
}
