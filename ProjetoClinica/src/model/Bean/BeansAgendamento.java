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
public class BeansAgendamento {
    private int agenda_cod;
    private String agenda_turno;
    private Date agenda_data;
    private String agenda_motivo;
    private String agenda_status;
    
    private BeansMedico agenda_codMedico;
    private int agenda_codPac;

    public int getAgenda_codPac() {
        return agenda_codPac;
    }

    public void setAgenda_codPac(int agenda_codPac) {
        this.agenda_codPac = agenda_codPac;
    }

    
    

    
    public Date getAgenda_data() {
        return agenda_data;
    }

    public void setAgenda_data(Date agenda_data) {
        this.agenda_data = agenda_data;
    }
    
    public String getAgenda_status() {
        return agenda_status;
    }

    public void setAgenda_status(String agenda_status) {
        this.agenda_status = agenda_status;
    }

    public int getAgenda_cod() {
        return agenda_cod;
    }

    public void setAgenda_cod(int agenda_cod) {
        this.agenda_cod = agenda_cod;
    }

    public String getAgenda_turno() {
        return agenda_turno;
    }

    public void setAgenda_turno(String agenda_turno) {
        this.agenda_turno = agenda_turno;
    }


    public String getAgenda_motivo() {
        return agenda_motivo;
    }

    public void setAgenda_motivo(String agenda_motivo) {
        this.agenda_motivo = agenda_motivo;
    }

   

    public BeansMedico getAgenda_codMedico() {
        return agenda_codMedico;
    }

    public void setAgenda_codMedico(BeansMedico agenda_codMedico) {
        this.agenda_codMedico = agenda_codMedico;
    }
    
    
}
