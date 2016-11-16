/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Bean.BeansAgendamento;
import model.Bean.BeansMedico;
import model.Bean.BeansPaciente;

public class AgendamentoDAO{
    
    int codPac;
    
public List<BeansPaciente> readPaciente() {

        Connection con = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<BeansPaciente> pacientes = new ArrayList<BeansPaciente>();

        try {
            stmt = con.prepareStatement("SELECT * FROM pacientes");
            rs = stmt.executeQuery();

            while (rs.next()) {
                BeansPaciente paci = new BeansPaciente();

                paci.setCodPac(rs.getInt("paci_codigo"));
                paci.setComplemento(rs.getString("paci_complemento"));
                paci.setCep(rs.getInt("paci_cep"));
                paci.setNasc(rs.getInt("paci_nasc"));
                paci.setNomeBairro(rs.getString("paci_bairro"));
                paci.setNomePac(rs.getString("paci_nome"));
                paci.setRg(rs.getInt("paci_rg"));
                paci.setRua(rs.getString("paci_rua"));
                paci.setTel(rs.getInt("paci_telefone"));
                
                
                pacientes.add(paci);
            }
                
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao passar a lista de pesquisa");
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return pacientes;
    }


public List<BeansMedico> readMedico() {

        Connection con = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<BeansMedico> medicos = new ArrayList<BeansMedico>();

        try {
            stmt = con.prepareStatement("SELECT * FROM medicos order by nome");
            rs = stmt.executeQuery();

            while (rs.next()) {
                BeansMedico medico = new BeansMedico();

                
                medico.setCodigo(rs.getInt("codigo"));
                medico.setCRM(rs.getInt("CRM"));
                medico.setEspecialidade(rs.getString("especialidade"));
                medico.setNome(rs.getString("nome"));
                medicos.add(medico);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao passar a lista para o combobox");
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return medicos;
    }

    public List<BeansPaciente> readPacienteByNome(String pesquisa) {

        Connection con = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<BeansPaciente> pacientes = new ArrayList<BeansPaciente>();

        try {
            stmt = con.prepareStatement("SELECT * FROM pacientes WHERE paci_nome LIKE ?");
            stmt.setString(1, "%"+pesquisa+"%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                BeansPaciente paci = new BeansPaciente();

                paci.setCodPac(rs.getInt("paci_codigo"));
                paci.setComplemento(rs.getString("paci_complemento"));
                paci.setCep(rs.getInt("paci_cep"));
                paci.setNasc(rs.getInt("paci_nasc"));
                paci.setNomeBairro(rs.getString("paci_bairro"));
                paci.setNomePac(rs.getString("paci_nome"));
                paci.setRg(rs.getInt("paci_rg"));
                paci.setRua(rs.getString("paci_rua"));
                paci.setTel(rs.getInt("paci_telefone"));
                
                
                pacientes.add(paci);
            }
                
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao passar a lista de pesquisa");
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return pacientes;
    }
    
    public void buscaPaciente(String nome){
        Connection con = null;
        
        con = ConnectionFactory.getConnection();
        PreparedStatement  stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("select paci_codigo where paci_nome = ?");
            stmt.setString(1, nome);
            codPac= rs.getInt("Paci_codigo");
            stmt.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"erro ao prcurar o nome igual paci_nome"+ ex);
        }
        ConnectionFactory.closeConnection(con,stmt,rs);
    }
    
    public void create(BeansAgendamento bA){
        Connection con = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;
        
        //buscaPaciente(bA.getAgenda_nomePac());
        
        try {
            stmt = con.prepareStatement("INSERT INTO agendamento (agendamento_turno,agendamento_data,agendamento_motivo,agendamento_status,agendamento_codpac,agendamento_codmedico)VALUES(?,?,?,?,?,?)");
            
            stmt.setString(1, bA.getAgenda_turno());
            stmt.setDate(2, new java.sql.Date(bA.getAgenda_data().getTime()));
            stmt.setString(3, bA.getAgenda_motivo());
            stmt.setString(4, bA.getAgenda_status());
            stmt.setInt(5, bA.getAgenda_codPac());
            stmt.setInt(6, bA.getAgenda_codMedico().getCodigo());
            
            stmt.executeUpdate();
            
             JOptionPane.showMessageDialog(null, "salvo agendamento com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
                
    }
}