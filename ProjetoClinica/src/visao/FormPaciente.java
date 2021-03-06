/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Bean.BeansEspecialidades;
import model.Bean.BeansPaciente;
import model.dao.PacienteDAO;

/**
 *
 * @author Marlon Paulo
 */
public class FormPaciente extends javax.swing.JFrame {

    public static int flag = 0;
    public static boolean flagBairro;
    
    public FormPaciente() {
        initComponents();
        
        readJtablePacientes();
        
    }

    
    public void preencherBairros(){
        
        Connection con = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
         try {
            
            stmt = con.prepareStatement("SELECT *FROM bairros order by nomebairro ");
            rs = stmt.executeQuery();
            
            
            while (rs.next()) {
              
               jComboBoxBairro.addItem(rs.getString("nomebairro"));
               
                
            }
            
                
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao passar as especializaçoes para o ComboBox Bairros"+ ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
  
    }
    
    public void readJtablePacientes(){
        DefaultTableModel modeloPac = (DefaultTableModel) jTablePaciente.getModel();
        
        modeloPac.setNumRows(0);
        
        PacienteDAO p = new PacienteDAO();
        
        for(BeansPaciente bP: p.read()){
            modeloPac.addRow(new Object[]{
                bP.getCodPac(),
                bP.getNomePac(),
                bP.getRg(),
                bP.getTel(),
                bP.getRua(),
                bP.getCep(),
                bP.getNomeBairro(),
                bP.getNasc(),
                bP.getComplemento()
            });
        }
    }
    
    public void readJtablePacientesByNome(String pesquisa){
        DefaultTableModel modeloPac = (DefaultTableModel) jTablePaciente.getModel();
        
        modeloPac.setNumRows(0);
        
        PacienteDAO p = new PacienteDAO();
        
        for(BeansPaciente bP: p.readByNome(pesquisa)){
            modeloPac.addRow(new Object[]{
                bP.getCodPac(),
                bP.getNomePac(),
                bP.getRg(),
                bP.getTel(),
                bP.getRua(),
                bP.getCep(),
                bP.getNomeBairro(),
                bP.getNasc(),
                bP.getComplemento()
            });
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldPesquisa = new javax.swing.JTextField();
        jButtonPesquisa = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePaciente = new javax.swing.JTable();
        jButtonNovo = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonAlterar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldRua = new javax.swing.JTextField();
        jTextFieldComplemento = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxBairro = new javax.swing.JComboBox<>();
        jTextFieldNomePac = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jTextFieldCEP = new javax.swing.JTextField();
        jTextFieldRG = new javax.swing.JTextField();
        jTextFieldNasc = new javax.swing.JTextField();
        jTextFieldTel = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabelFundoCadastroPaciente = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setEnabled(false);
        jPanel1.setLayout(null);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nome:");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 80, 40, 14);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Nascimento:");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel1.add(jLabel3);
        jLabel3.setBounds(520, 30, 70, 14);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("RG:");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel1.add(jLabel4);
        jLabel4.setBounds(220, 30, 30, 14);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Telefone:");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel1.add(jLabel5);
        jLabel5.setBounds(530, 80, 60, 14);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Pesquisa:");
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel1.add(jLabel11);
        jLabel11.setBounds(20, 320, 60, 14);

        jTextFieldPesquisa.setBackground(new java.awt.Color(240, 240, 240));
        jPanel1.add(jTextFieldPesquisa);
        jTextFieldPesquisa.setBounds(90, 310, 560, 30);

        jButtonPesquisa.setText("Pesquisar");
        jButtonPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisaActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonPesquisa);
        jButtonPesquisa.setBounds(680, 310, 87, 36);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(477, 764, 100, 100);

        jTablePaciente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "RG", "Telefone", "Rua", "CEP", "Bairro", "Nascimento", "Complemento"
            }
        ));
        jTablePaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePacienteMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTablePaciente);
        jTablePaciente.getColumnModel().getColumn(0).setPreferredWidth(1);
        jTablePaciente.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTablePaciente.getColumnModel().getColumn(2).setPreferredWidth(4);
        jTablePaciente.getColumnModel().getColumn(3).setPreferredWidth(20);
        jTablePaciente.getColumnModel().getColumn(4).setPreferredWidth(100);
        jTablePaciente.getColumnModel().getColumn(5).setPreferredWidth(4);
        jTablePaciente.getColumnModel().getColumn(6).setPreferredWidth(100);
        jTablePaciente.getColumnModel().getColumn(7).setPreferredWidth(10);
        jTablePaciente.getColumnModel().getColumn(8).setPreferredWidth(100);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(10, 360, 1160, 150);

        jButtonNovo.setText("Novo");
        jButtonNovo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonNovoMouseClicked(evt);
            }
        });
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonNovo);
        jButtonNovo.setBounds(120, 520, 87, 36);

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.setEnabled(false);
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSalvar);
        jButtonSalvar.setBounds(230, 520, 87, 36);

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setEnabled(false);
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonCancelar);
        jButtonCancelar.setBounds(330, 520, 87, 36);

        jButtonAlterar.setText("Alterar");
        jButtonAlterar.setEnabled(false);
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAlterar);
        jButtonAlterar.setBounds(440, 520, 87, 36);

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.setEnabled(false);
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonExcluir);
        jButtonExcluir.setBounds(540, 520, 87, 36);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Complemento:");
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel1.add(jLabel8);
        jLabel8.setBounds(0, 180, 90, 14);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Rua:");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel1.add(jLabel7);
        jLabel7.setBounds(30, 130, 30, 14);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Bairro:");
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel1.add(jLabel10);
        jLabel10.setBounds(30, 230, 40, 14);

        jTextFieldRua.setBackground(new java.awt.Color(240, 240, 240));
        jTextFieldRua.setEnabled(false);
        jPanel1.add(jTextFieldRua);
        jTextFieldRua.setBounds(60, 120, 440, 28);

        jTextFieldComplemento.setBackground(new java.awt.Color(240, 240, 240));
        jTextFieldComplemento.setEnabled(false);
        jPanel1.add(jTextFieldComplemento);
        jTextFieldComplemento.setBounds(90, 170, 730, 32);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("CEP:");
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel1.add(jLabel9);
        jLabel9.setBounds(550, 130, 40, 14);

        jComboBoxBairro.setEnabled(false);
        jComboBoxBairro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxBairroMouseClicked(evt);
            }
        });
        jComboBoxBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxBairroActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxBairro);
        jComboBoxBairro.setBounds(90, 220, 410, 30);

        jTextFieldNomePac.setEnabled(false);
        jPanel1.add(jTextFieldNomePac);
        jTextFieldNomePac.setBounds(60, 70, 440, 30);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Codigo:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(10, 30, 50, 14);

        jTextFieldCodigo.setBackground(new java.awt.Color(240, 240, 240));
        jTextFieldCodigo.setEnabled(false);
        jPanel1.add(jTextFieldCodigo);
        jTextFieldCodigo.setBounds(60, 20, 150, 30);

        jTextFieldCEP.setEnabled(false);
        jPanel1.add(jTextFieldCEP);
        jTextFieldCEP.setBounds(590, 120, 230, 30);

        jTextFieldRG.setEnabled(false);
        jPanel1.add(jTextFieldRG);
        jTextFieldRG.setBounds(250, 20, 250, 30);

        jTextFieldNasc.setEnabled(false);
        jPanel1.add(jTextFieldNasc);
        jTextFieldNasc.setBounds(590, 20, 230, 30);

        jTextFieldTel.setEnabled(false);
        jPanel1.add(jTextFieldTel);
        jTextFieldTel.setBounds(590, 70, 230, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(20, 40, 1180, 570);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Cadastro de Paciente");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(540, 10, 165, 22);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botao-voltar.png"))); // NOI18N
        jButton1.setToolTipText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(20, 0, 50, 40);

        jLabelFundoCadastroPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundo_telaprincipal.jpg"))); // NOI18N
        getContentPane().add(jLabelFundoCadastroPaciente);
        jLabelFundoCadastroPaciente.setBounds(0, 0, 1220, 640);

        setSize(new java.awt.Dimension(1237, 681));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        TelaPrincipal tela = new TelaPrincipal();
        dispose();
        tela.setVisible(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBoxBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxBairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxBairroActionPerformed

    private void jComboBoxBairroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxBairroMouseClicked
        jComboBoxBairro.removeAllItems();
        preencherBairros();
    }//GEN-LAST:event_jComboBoxBairroMouseClicked

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        PacienteDAO pacDAO = new PacienteDAO();
        BeansPaciente bP = new BeansPaciente();

        if(jTablePaciente.getSelectedRow() != -1){

            bP.setCodPac(Integer.parseInt(jTextFieldCodigo.getText()));

            pacDAO.delete(bP);

            jTextFieldCEP.setText("");
            jTextFieldNasc.setText("");
            jTextFieldRG.setText("");
            jTextFieldTel.setText("");
            jComboBoxBairro.removeAllItems();
            jTextFieldComplemento.setText("");
            jTextFieldNomePac.setText("");
            jTextFieldPesquisa.setText("");
            jTextFieldRua.setText("");
            jTextFieldCodigo.setText("");

            readJtablePacientes();

        }else{
            JOptionPane.showMessageDialog(null, "clique em algum cadastro");
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed

        flag = 2;
        jButtonSalvar.setEnabled(true);
        jButtonCancelar.setEnabled(true);
        jButtonAlterar.setEnabled(false);
        jButtonExcluir.setEnabled(true);
        jButtonNovo.setEnabled(false);

        jTextFieldNomePac.setEnabled(true);
        jTextFieldNasc.setEnabled(true);
        jTextFieldRG.setEnabled(true);
        jTextFieldTel.setEnabled(true);
        jTextFieldRua.setEnabled(true);
        jTextFieldCEP.setEnabled(true);
        jTextFieldComplemento.setEnabled(true);
        jComboBoxBairro.setEnabled(true);
        jComboBoxBairro.setEnabled(true);
        preencherBairros();

    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        jButtonSalvar.setEnabled(false);
        jButtonCancelar.setEnabled(false);
        jButtonNovo.setEnabled(true);
        jButtonAlterar.setEnabled(false);
        jButtonExcluir.setEnabled(false);

        jTextFieldCodigo.setText("");
        jTextFieldCEP.setText("");
        jTextFieldNasc.setText("");
        jTextFieldRG.setText("");
        jTextFieldTel.setText("");
        jComboBoxBairro.removeAllItems();
        jTextFieldComplemento.setText("");
        jTextFieldNomePac.setText("");
        jTextFieldPesquisa.setText("");
        jTextFieldRua.setText("");
        jTextFieldCEP.setEnabled(false);
        jTextFieldNasc.setEnabled(false);
        jTextFieldRG.setEnabled(false);
        jTextFieldTel.setEnabled(false);
        jComboBoxBairro.setEnabled(false);
        jTextFieldComplemento.setEnabled(false);
        jTextFieldNomePac.setEnabled(false);
        jTextFieldPesquisa.setEnabled(false);
        jTextFieldRua.setEnabled(false);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        PacienteDAO pacDAO = new PacienteDAO();
        BeansPaciente bP = new BeansPaciente();

        if(flag == 1){
            jButtonSalvar.setEnabled(false);
            jButtonCancelar.setEnabled(false);
            jButtonAlterar.setEnabled(false);
            jButtonExcluir.setEnabled(false);
            jButtonNovo.setEnabled(true);

            try {

                bP.setNomePac(jTextFieldNomePac.getText());
                
                bP.setNasc(Integer.parseInt(jTextFieldNasc.getText()));
                bP.setRg(Integer.parseInt(jTextFieldRG.getText()));
                bP.setTel(Integer.parseInt(jTextFieldTel.getText()));
                bP.setRua(jTextFieldRua.getText());
                bP.setCep(Integer.parseInt(jTextFieldCEP.getText()));
                bP.setComplemento(jTextFieldComplemento.getText());

                bP.setNomeBairro(jComboBoxBairro.getSelectedItem().toString());

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "erro antes de salvar " + e);
            }
            pacDAO.create(bP);

        }else{
            try {

                bP.setNomePac(jTextFieldNomePac.getText());
                bP.setNasc(Integer.parseInt(jTextFieldNasc.getText()));
                bP.setRg(Integer.parseInt(jTextFieldRG.getText()));
                bP.setTel( Integer.parseInt(jTextFieldTel.getText()));
                bP.setRua(jTextFieldRua.getText());
                bP.setCep(Integer.parseInt(jTextFieldCEP.getText()));
                bP.setComplemento(jTextFieldComplemento.getText());

                bP.setCodPac(Integer.parseInt(jTextFieldCodigo.getText()));

                bP.setNomeBairro(jComboBoxBairro.getSelectedItem().toString());

                jButtonSalvar.setEnabled(false);
                jButtonCancelar.setEnabled(false);
                jButtonAlterar.setEnabled(false);
                jButtonExcluir.setEnabled(false);
                jButtonNovo.setEnabled(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "erro antes de editar " + e);
            }

            pacDAO.editar(bP);
        }

        jTextFieldCodigo.setText("");
        jTextFieldCEP.setText("");
        jTextFieldNasc.setText("");
        jTextFieldRG.setText("");
        jTextFieldTel.setText("");
        jComboBoxBairro.removeAllItems();
        jTextFieldComplemento.setText("");
        jTextFieldNomePac.setText("");
        jTextFieldPesquisa.setText("");
        jTextFieldRua.setText("");
        jTextFieldCodigo.setEnabled(false);
        jTextFieldCEP.setEnabled(false);
        jTextFieldNasc.setEnabled(false);
        jTextFieldRG.setEnabled(false);
        jTextFieldTel.setEnabled(false);
        jComboBoxBairro.removeAllItems();
        jTextFieldComplemento.setEnabled(false);
        jTextFieldNomePac.setEnabled(false);
        jTextFieldPesquisa.setEnabled(false);
        jTextFieldRua.setEnabled(false);

        readJtablePacientes();

    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        flagBairro = false;
        flag = 1;
        jButtonSalvar.setEnabled(true);
        jButtonCancelar.setEnabled(true);
        jButtonAlterar.setEnabled(false);
        jButtonExcluir.setEnabled(false);
        jButtonNovo.setEnabled(false);

        jTextFieldNomePac.setEnabled(true);
        jTextFieldNasc.setEnabled(true);
        jTextFieldRG.setEnabled(true);
        jTextFieldTel.setEnabled(true);
        jTextFieldRua.setEnabled(true);
        jTextFieldCEP.setEnabled(true);
        jTextFieldComplemento.setEnabled(true);
        jComboBoxBairro.setEnabled(true);

        jTextFieldCEP.setText("");
        jTextFieldNasc.setText("");
        jTextFieldRG.setText("");
        jTextFieldTel.setText("");
        jComboBoxBairro.removeAllItems();
        jTextFieldComplemento.setText("");
        jTextFieldNomePac.setText("");
        jTextFieldPesquisa.setText("");
        jTextFieldRua.setText("");
        jTextFieldCodigo.setText("");

        jComboBoxBairro.removeAllItems();
        preencherBairros();

    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonNovoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonNovoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonNovoMouseClicked

    private void jTablePacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePacienteMouseClicked
        BeansPaciente BP = new BeansPaciente();
        PacienteDAO pDAO = new PacienteDAO();

        jButtonAlterar.setEnabled(true);
        jButtonCancelar.setEnabled(true);
        jButtonNovo.setEnabled(false);
        jButtonExcluir.setEnabled(true);
        jButtonSalvar.setEnabled(true);

        jTextFieldCodigo.setText(jTablePaciente.getValueAt(jTablePaciente.getSelectedRow(), 0).toString());
        jTextFieldNomePac.setText(jTablePaciente.getValueAt(jTablePaciente.getSelectedRow(), 1).toString());
        jTextFieldRG.setText(jTablePaciente.getValueAt(jTablePaciente.getSelectedRow(), 2).toString());
        jTextFieldTel.setText(jTablePaciente.getValueAt(jTablePaciente.getSelectedRow(), 3).toString());
        jTextFieldRua.setText(jTablePaciente.getValueAt(jTablePaciente.getSelectedRow(), 4).toString());
        jTextFieldCEP.setText(jTablePaciente.getValueAt(jTablePaciente.getSelectedRow(), 5).toString());
        jComboBoxBairro.removeAllItems();
        jComboBoxBairro.addItem(jTablePaciente.getValueAt(jTablePaciente.getSelectedRow(), 6).toString());
        jTextFieldNasc.setText(jTablePaciente.getValueAt(jTablePaciente.getSelectedRow(), 7).toString());
        jTextFieldComplemento.setText(jTablePaciente.getValueAt(jTablePaciente.getSelectedRow(), 8).toString());

    }//GEN-LAST:event_jTablePacienteMouseClicked

    private void jButtonPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisaActionPerformed
        readJtablePacientesByNome(jTextFieldPesquisa.getText());
    }//GEN-LAST:event_jButtonPesquisaActionPerformed

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
            java.util.logging.Logger.getLogger(FormPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPaciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonPesquisa;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox<String> jComboBoxBairro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelFundoCadastroPaciente;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTablePaciente;
    private javax.swing.JTextField jTextFieldCEP;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldComplemento;
    private javax.swing.JTextField jTextFieldNasc;
    private javax.swing.JTextField jTextFieldNomePac;
    private javax.swing.JTextField jTextFieldPesquisa;
    private javax.swing.JTextField jTextFieldRG;
    private javax.swing.JTextField jTextFieldRua;
    private javax.swing.JTextField jTextFieldTel;
    // End of variables declaration//GEN-END:variables
}
