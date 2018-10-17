/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.gestionPaciente;

import java.sql.Timestamp;

/**
 *
 * @author Alex
 */
public class ProgramaPaciente {
    private int idProgramaPaciente;
    private int idPrograma;
    private int idPaciente;
    private Timestamp inicio;
    private Timestamp fin;
    private int estatus;
    
    public ProgramaPaciente() {}
    @Override
    public String toString(){
        String str= "ProgramaPaciente [idProgramaPaciente:".concat(String.valueOf(idProgramaPaciente))
                .concat(",idPrograma:").concat(String.valueOf(idPrograma))
                .concat(",idPaciente:").concat(String.valueOf(idPaciente))
                .concat(",inicio:").concat(String.valueOf(inicio))
                .concat(",fin:").concat(String.valueOf(fin))
                .concat(",estatus:").concat(String.valueOf(estatus))
                .concat("]");
        return str;
    }

    public Timestamp getInicio() {
        return inicio;
    }

    public void setInicio(Timestamp inicio) {
        this.inicio = inicio;
    }

    public Timestamp getFin() {
        return fin;
    }

    public void setFin(Timestamp fin) {
        this.fin = fin;
    }

    public int getIdProgramaPaciente() {
        return idProgramaPaciente;
    }

    public void setIdProgramaPaciente(int idProgramaPaciente) {
        this.idProgramaPaciente = idProgramaPaciente;
    }

    public int getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(int idPrograma) {
        this.idPrograma = idPrograma;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }
    
    
}