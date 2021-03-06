/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import javax.swing.JOptionPane;

/**
 *
 * @author Marlon Paulo
 */
public class TelaLogin extends javax.swing.JFrame {

    /**
     * Creates new form TelaLogin
     */
    public TelaLogin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonAcessar = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldUsuario = new javax.swing.JTextField();
        jPasswordFieldSenha = new javax.swing.JPasswordField();
        jLabelLogoTelaLogin = new javax.swing.JLabel();
        jLabelFundoLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jButtonAcessar.setText("Acessar");
        jButtonAcessar.setSelected(true);
        jButtonAcessar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcessarActionPerformed(evt);
            }
        });
        jButtonAcessar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonAcessarKeyPressed(evt);
            }
        });
        getContentPane().add(jButtonAcessar);
        jButtonAcessar.setBounds(70, 220, 110, 23);

        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSair);
        jButtonSair.setBounds(210, 220, 120, 23);

        jLabel1.setText("Login:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 150, 40, 14);

        jLabel2.setText("Senha:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 190, 40, 14);
        getContentPane().add(jTextFieldUsuario);
        jTextFieldUsuario.setBounds(70, 140, 290, 30);
        getContentPane().add(jPasswordFieldSenha);
        jPasswordFieldSenha.setBounds(70, 180, 290, 30);

        jLabelLogoTelaLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Logo MP Tela Login.png"))); // NOI18N
        getContentPane().add(jLabelLogoTelaLogin);
        jLabelLogoTelaLogin.setBounds(150, 10, 170, 130);

        jLabelFundoLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundotelaLogin.png"))); // NOI18N
        getContentPane().add(jLabelFundoLogin);
        jLabelFundoLogin.setBounds(0, 0, 500, 375);

        setSize(new java.awt.Dimension(515, 414));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAcessarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAcessarActionPerformed
       if(jTextFieldUsuario.getText().equals("admin") && jPasswordFieldSenha.getText().equals("1234")){ 
        TelaPrincipal tela = new TelaPrincipal();
        tela.setVisible(true);
        dispose();
        } else {
           JOptionPane.showMessageDialog(rootPane, "Senha ou Usuario Invalido !!!!!!!!");
       }
    }//GEN-LAST:event_jButtonAcessarActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
       System.exit(0);
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jButtonAcessarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonAcessarKeyPressed
        if(jTextFieldUsuario.getText().equals("admin") && jPasswordFieldSenha.getText().equals("1234")){ 
        TelaPrincipal tela = new TelaPrincipal();
        tela.setVisible(true);
        dispose();
        } else {
           JOptionPane.showMessageDialog(rootPane, "Senha ou Usuario Invalido !!!!!!!!");
       }
    }//GEN-LAST:event_jButtonAcessarKeyPressed

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
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAcessar;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelFundoLogin;
    private javax.swing.JLabel jLabelLogoTelaLogin;
    private javax.swing.JPasswordField jPasswordFieldSenha;
    private javax.swing.JTextField jTextFieldUsuario;
    // End of variables declaration//GEN-END:variables
}
