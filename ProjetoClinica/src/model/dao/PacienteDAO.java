/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.PreparedStatement;
import java.sql.Connection;
import connection.ConnectionFactory;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Bean.BeansEspecialidades;

import model.Bean.BeansPaciente;

/**
 *
 * @author Marlon Paulo
 */
public class PacienteDAO {
   
    
    
    public void create(BeansPaciente p){
        Connection con = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO pacientes (paci_nome,paci_rg,paci_telefone,paci_rua,paci_cep,paci_complemento,paci_nasc,paci_bairro)VALUES(?,?,?,?,?,?,?,?)");
            stmt.setString(1, p.getNomePac());
            stmt.setInt(2, p.getRg());
            stmt.setInt(3, p.getTel());
            stmt.setString(4, p.getRua());
            stmt.setInt(5, p.getCep());
            stmt.setString(6, p.getComplemento());
            stmt.setInt(7, p.getNasc());
            stmt.setString(8, p.getNomeBairro());
            
            
            stmt.executeUpdate();
             JOptionPane.showMessageDialog(null, "salvo com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
                
    }
    
    public List<BeansPaciente> read() {

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
    
    
    public List<BeansPaciente> readByNome(String pesquisa) {

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
    
    
    
    public void delete(BeansPaciente p) {

        Connection con = new ConnectionFactory().getConnection();

        PreparedStatement stmt = null;
        try {

            stmt = con.prepareStatement("DELETE FROM pacientes WHERE paci_codigo = ?");

            stmt.setInt(1, p.getCodPac());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void editar(BeansPaciente p) {

        Connection con = new ConnectionFactory().getConnection();

        PreparedStatement stmt = null;
        try {

            stmt = con.prepareStatement("UPDATE pacientes SET paci_nome = ?,paci_rg = ?,paci_telefone = ?,paci_rua = ?,paci_cep = ?,paci_complemento = ?,paci_nasc = ?,paci_bairro = ? WHERE paci_codigo = ? ");
            stmt.setString(1, p.getNomePac());
            stmt.setInt(2, p.getRg());
            stmt.setInt(3, p.getTel());
            stmt.setString(4, p.getRua());
            stmt.setInt(5, p.getCep());
            stmt.setString(6, p.getComplemento());
            stmt.setInt(7, p.getNasc());
            stmt.setString(8, p.getNomeBairro());
            
            stmt.setInt(9, p.getCodPac());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}