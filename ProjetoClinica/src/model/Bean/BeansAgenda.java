/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Bean;

import java.util.Date;

/**
 *
 * @author Marlon Paulo
 */
public class BeansAgenda {
    private int codigo;
    private String nome;
    private String turno;
    private Date Data;
    private String status;
    private String Medico;
    private String Motivo;

    public String getMotivo() {
        return Motivo;
    }

    public void setMotivo(String Motivo) {
        this.Motivo = Motivo;
    }
    
    
    
    //"codigo","Nome","Turno","Data","Status","Medico"

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

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public Date getData() {
        return Data;
    }

    public void setData(Date Data) {
        this.Data = Data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMedico() {
        return Medico;
    }

    public void setMedico(String Medico) {
        this.Medico = Medico;
    }
}
