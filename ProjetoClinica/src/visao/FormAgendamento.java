/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import model.Bean.BeansAgendamento;
import model.Bean.BeansMedico;
import model.Bean.BeansPaciente;
import model.dao.AgendamentoDAO;
import model.dao.PacienteDAO;
import java.sql.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Marlon Paulo
 */
public class FormAgendamento extends javax.swing.JFrame {

    /**
     * Creates new form FormAgendamento
     */
    
    int codMed;
    
    
    public FormAgendamento() {
        initComponents();
        preencherComboBoxMedico();
        readJtablePacientes();
    }
    
    public void readJtablePacientes(){
        DefaultTableModel modeloPac = (DefaultTableModel) jTablePacientesAgendamento.getModel();
        
        modeloPac.setNumRows(0);
        
        AgendamentoDAO adao = new AgendamentoDAO();
        
        for(BeansPaciente bP: adao.readPaciente()){
            modeloPac.addRow(new Object[]{
                bP.getCodPac(),
                bP.getNomePac(),
                bP.getRg()
            });
        }
    }
    
    public void readJTablePacientesByNome(String pesquisa){
        DefaultTableModel modelo = (DefaultTableModel) jTablePacientesAgendamento.getModel();
        
        modelo.setNumRows(0);
        
        AgendamentoDAO adao = new AgendamentoDAO();
        
        for(BeansPaciente m: adao.readPacienteByNome(pesquisa)){
            
            modelo.addRow(new Object[]{
               m.getCodPac(),
               m.getNomePac(),
               m.getRg()
               
            });
        }
    }
    
    public void preencherComboBoxMedico(){
        
        AgendamentoDAO dao = new AgendamentoDAO();
        
        for(BeansMedico bM: dao.readMedico()){
                jComboBoxMedico.addItem(bM);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldPaciente = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePacientesAgendamento = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxTurno = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxMedico = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jButtonFinalizarAgendamento = new javax.swing.JButton();
        jButtonCancelarAgendamento = new javax.swing.JButton();
        jTextFieldMotivo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButtonVoltar = new javax.swing.JButton();
        jButtonAgendados = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(null);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Paciente:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 20, 60, 14);
        jPanel1.add(jTextFieldPaciente);
        jTextFieldPaciente.setBounds(80, 10, 380, 30);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/procurar.png"))); // NOI18N
        jButton1.setToolTipText("pesquisar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(470, 10, 38, 40);

        jTablePacientesAgendamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome", "RG"
            }
        ));
        jTablePacientesAgendamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePacientesAgendamentoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablePacientesAgendamento);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(28, 54, 480, 170);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Turno:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 260, 40, 14);

        jComboBoxTurno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Matutino", "Vespertino", "Noturno" }));
        jPanel1.add(jComboBoxTurno);
        jComboBoxTurno.setBounds(70, 250, 106, 30);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Data:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(240, 260, 30, 14);
        jPanel1.add(jDateChooser);
        jDateChooser.setBounds(270, 250, 239, 30);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Medico:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 310, 50, 14);

        jComboBoxMedico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxMedicoMouseClicked(evt);
            }
        });
        jComboBoxMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMedicoActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxMedico);
        jComboBoxMedico.setBounds(70, 300, 441, 29);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Motivo:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(30, 370, 40, 14);

        jButtonFinalizarAgendamento.setText("Finalizar Agendamento");
        jButtonFinalizarAgendamento.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonFinalizarAgendamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFinalizarAgendamentoActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonFinalizarAgendamento);
        jButtonFinalizarAgendamento.setBounds(60, 500, 141, 23);

        jButtonCancelarAgendamento.setText("Cancelar Agendamento");
        jButtonCancelarAgendamento.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonCancelarAgendamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarAgendamentoActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonCancelarAgendamento);
        jButtonCancelarAgendamento.setBounds(290, 500, 145, 23);
        jPanel1.add(jTextFieldMotivo);
        jTextFieldMotivo.setBounds(30, 400, 482, 96);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(60, 60, 550, 560);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Agendamento");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(280, 10, 109, 22);

        jButtonVoltar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonVoltar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botao-voltar.png"))); // NOI18N
        jButtonVoltar.setToolTipText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonVoltar);
        jButtonVoltar.setBounds(10, 10, 48, 49);

        /*
        jButtonAgendados.setBackground(new java.awt.Color(255, 255, 255));
        */
        jButtonAgendados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/notebook.png"))); // NOI18N
        jButtonAgendados.setToolTipText("Agendados");
        jButtonAgendados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgendadosActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAgendados);
        jButtonAgendados.setBounds(620, 10, 60, 50);
        jButtonAgendados.setBackground(new java.awt.Color(255,255,255));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundo_telaprincipal.jpg"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(-6, -6, 700, 690);

        setSize(new java.awt.Dimension(704, 723));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
      TelaPrincipal tela = new TelaPrincipal();
      dispose();
      tela.setVisible(true);
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jComboBoxMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMedicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxMedicoActionPerformed

    private void jButtonFinalizarAgendamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinalizarAgendamentoActionPerformed
        AgendamentoDAO adao = new AgendamentoDAO();
        BeansAgendamento agenda = new BeansAgendamento();
        
        if(jTablePacientesAgendamento.getSelectedRow() != -1){
            
            try {
                
            
        agenda.setAgenda_codPac((int) jTablePacientesAgendamento.getValueAt(jTablePacientesAgendamento.getSelectedRow(), 0));
        
        agenda.setAgenda_turno(jComboBoxTurno.getSelectedItem().toString());
        agenda.setAgenda_data(jDateChooser.getDate());
        
        BeansMedico medico = (BeansMedico) jComboBoxMedico.getSelectedItem();
        agenda.setAgenda_codMedico(medico);
        
        agenda.setAgenda_motivo(jTextFieldMotivo.getText());
        agenda.setAgenda_status("aberto");
        
        adao.create(agenda);
        
        jTextFieldPaciente.setText("");
        jComboBoxMedico.removeAllItems();
        jComboBoxTurno.removeAllItems();
        jTextFieldMotivo.setText("");
        
        readJtablePacientes();
        
        
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro ao enviar os beans:     "+e);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "escolhe um paciente");
        }
        
        
    }//GEN-LAST:event_jButtonFinalizarAgendamentoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        readJTablePacientesByNome(jTextFieldPaciente.getText());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTablePacientesAgendamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePacientesAgendamentoMouseClicked
        // TODO add your handling code here:
        jTextFieldPaciente.setText((String) jTablePacientesAgendamento.getValueAt(jTablePacientesAgendamento.getSelectedRow(), 1));
       // JOptionPane.showMessageDialog(null, "codigo pac "+  jTablePacientesAgendamento.getValueAt(jTablePacientesAgendamento.getSelectedRow(), 0));
    }//GEN-LAST:event_jTablePacientesAgendamentoMouseClicked

    private void jButtonCancelarAgendamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarAgendamentoActionPerformed
        // TODO add your handling code here:
        jTextFieldPaciente.setText("");
        jComboBoxMedico.removeAllItems();
        jComboBoxTurno.removeAllItems();
        jTextFieldMotivo.setText("");
        
        readJtablePacientes();
    }//GEN-LAST:event_jButtonCancelarAgendamentoActionPerformed

    private void jComboBoxMedicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxMedicoMouseClicked
        // TODO add your handling code here:
        jComboBoxMedico.removeAllItems();
        preencherComboBoxMedico();
    }//GEN-LAST:event_jComboBoxMedicoMouseClicked

    private void jButtonAgendadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgendadosActionPerformed
        FormAgenda tela = new FormAgenda();
        dispose();
        tela.setVisible(true);
    }//GEN-LAST:event_jButtonAgendadosActionPerformed

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
            java.util.logging.Logger.getLogger(FormAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormAgendamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAgendados;
    private javax.swing.JButton jButtonCancelarAgendamento;
    private javax.swing.JButton jButtonFinalizarAgendamento;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JComboBox<Object> jComboBoxMedico;
    private javax.swing.JComboBox<String> jComboBoxTurno;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePacientesAgendamento;
    private javax.swing.JTextField jTextFieldMotivo;
    private javax.swing.JTextField jTextFieldPaciente;
    // End of variables declaration//GEN-END:variables
}
