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
public class BeansEspecialidades {
    private int idEspec;
    private String Especilizacao;

    public int getIdEspec() {
        return idEspec;
    }

    public void setIdEspec(int idEspec) {
        this.idEspec = idEspec;
    }

    public String getEspecilizacao() {
        return Especilizacao;
    }

    public void setEspecilizacao(String Especilizacao) {
        this.Especilizacao = Especilizacao;
    }

    @Override
    public String toString() {
        return getEspecilizacao(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
