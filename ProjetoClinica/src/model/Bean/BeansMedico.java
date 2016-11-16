/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Bean;

/**
 *
 * @author Marlon Paulo
 */
public class BeansMedico {
    private String nome;
    private int CRM;
    private String especialidade;
    private int codigo;
    private String Pesquisa;

    public String getPesquisa() {
        return Pesquisa;
    }

    public void setPesquisa(String Pesquisa) {
        this.Pesquisa = Pesquisa;
    }
    



    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCRM() {
        return CRM;
    }

    public void setCRM(int CRM) {
        this.CRM = CRM;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }


    @Override
    public String toString() {
        return getEspecialidade();
    }
    
    
}


