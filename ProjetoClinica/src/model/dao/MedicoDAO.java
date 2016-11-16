
package model.dao;

import connection.ConnectionFactory;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Bean.BeansEspecialidades;
import model.Bean.BeansMedico;

/**
 *
 * @author Marlon Paulo
 */
public class MedicoDAO {

    BeansMedico m = new BeansMedico();
    BeansMedico mod = new BeansMedico();

    public void create(BeansMedico m) {

        Connection con = new ConnectionFactory().getConnection();

        PreparedStatement stmt = null;
        try {

            stmt = con.prepareStatement("INSERT INTO medicos(nome,CRM,especialidade)VALUES(?,?,?)");
            stmt.setString(1, m.getNome());
            stmt.setInt(2, m.getCRM());
            stmt.setString(3, m.getEspecialidade());
            //stmt.setInt(4, m.getCodigo());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "salvo com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void delete(BeansMedico m) {

        Connection con = new ConnectionFactory().getConnection();

        PreparedStatement stmt = null;
        try {

            stmt = con.prepareStatement("DELETE FROM medicos WHERE codigo = ?");

            stmt.setInt(1, m.getCodigo());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void editar(BeansMedico m) {

        Connection con = new ConnectionFactory().getConnection();

        PreparedStatement stmt = null;
        try {

            stmt = con.prepareStatement("UPDATE medicos SET nome = ?,CRM = ?, especialidade = ? WHERE codigo = ? ");
            stmt.setString(1, m.getNome());
            stmt.setInt(2, m.getCRM());
            stmt.setString(3, m.getEspecialidade());
            stmt.setInt(4, m.getCodigo());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<BeansMedico> read() {

        Connection con = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<BeansMedico> medicos = new ArrayList<BeansMedico>();

        try {
            stmt = con.prepareStatement("SELECT * FROM medicos");
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
            JOptionPane.showMessageDialog(null, "Erro ao passar a lista");
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return medicos;
    }

    public List<BeansEspecialidades> readEspecialidades() {

        Connection con = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<BeansEspecialidades> especi = new ArrayList<BeansEspecialidades>();

        try {
            stmt = con.prepareStatement("SELECT *FROM especialidades ");
            rs = stmt.executeQuery();

            while (rs.next()) {
                BeansEspecialidades espec = new BeansEspecialidades();

                espec.setIdEspec(rs.getInt("idEspecializacoes"));
                espec.setEspecilizacao(rs.getString("especializacoes"));
                
                especi.add(espec);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao passar as especializaçoes para o ComboBox lista      "+ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return especi;
    }

    public List<BeansMedico> readByNome(String pesquisa) {

        Connection con = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<BeansMedico> medicos = new ArrayList<BeansMedico>();

        try {
            stmt = con.prepareStatement("SELECT * FROM medicos WHERE nome LIKE ?");
            stmt.setString(1, "%" + pesquisa + "%");
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
            JOptionPane.showMessageDialog(null, "Medico nao cadastrado");
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return medicos;
    }

}
