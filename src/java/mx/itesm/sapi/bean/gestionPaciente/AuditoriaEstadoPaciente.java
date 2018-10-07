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
public class AuditoriaEstadoPaciente {

    private int idAuditoriaEstadoPaciente;
    private Timestamp fecha;
    private int idEmpleado;
    private int EstadoPacientePaciente;
    private int estatus;

    public AuditoriaEstadoPaciente() {}
    
    @Override 
    public String toString(){
        String str= "AuditoriaEstadoPaciente [idAuditoriaEstadoPaciente:".concat(String.valueOf(idAuditoriaEstadoPaciente))
                .concat(",fecha:").concat(String.valueOf(fecha))
                .concat(",idEmpleado:").concat(String.valueOf(idEmpleado))
                .concat(",EstadoPacientePaciente:").concat(String.valueOf(EstadoPacientePaciente))
                .concat(",estatus:").concat(String.valueOf(estatus))
                .concat("]");
        return str;
    }

    public int getIdAuditoriaEstadoPaciente() {
        return idAuditoriaEstadoPaciente;
    }

    public void setIdAuditoriaEstadoPaciente(int idAuditoriaEstadoPaciente) {
        this.idAuditoriaEstadoPaciente = idAuditoriaEstadoPaciente;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getEstadoPacientePaciente() {
        return EstadoPacientePaciente;
    }

    public void setEstadoPacientePaciente(int EstadoPacientePaciente) {
        this.EstadoPacientePaciente = EstadoPacientePaciente;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }
    
    
    
}
