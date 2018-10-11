/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.gestionPaciente;

import java.sql.Timestamp;

/**
 *
 * @author Oscar Miranda
 */
public class PacienteMedicoTitular {
    private int idPacienteMedicoTitular;
    private int idPaciente;
    private int idEmpleado;
    private Timestamp inicio;
    private Timestamp fin;
    private int estatus;
    
    public PacienteMedicoTitular() {}
    
    @Override 
    public String toString(){
        String str= "PacienteMedicoTitular [idPacienteMedicoTitular:".concat(String.valueOf(idPacienteMedicoTitular))
                .concat(",idPaciente:").concat(String.valueOf(idPaciente))
                .concat(",idEmpleado:").concat(String.valueOf(idEmpleado))
                .concat(",inicio:").concat(String.valueOf(inicio))
                .concat(",fin:").concat(String.valueOf(fin))
                .concat(",estatus:").concat(String.valueOf(estatus))
                .concat("]");
        return str;
    }

    public int getIdPacienteMedicoTitular() {
        return idPacienteMedicoTitular;
    }

    public void setIdPacienteMedicoTitular(int idPacienteMedicoTitular) {
        this.idPacienteMedicoTitular = idPacienteMedicoTitular;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
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

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }
    
    
}
