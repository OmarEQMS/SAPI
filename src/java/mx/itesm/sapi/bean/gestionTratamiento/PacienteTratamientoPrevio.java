/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.gestionTratamiento;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author Admin
 */
public class PacienteTratamientoPrevio implements Serializable {
   
    private int idPacienteTratamientoPrevio;
    private int idPaciente;
    private int idTipoTratamiento;
    private Date fecha;
    private String comentarios;
    private int estatus;
    private int ciclos;
    
    public PacienteTratamientoPrevio() {
    }

    @Override 
    public String toString(){
        return "pacienteTratamiento ID: ".concat(Integer.toString(idPacienteTratamientoPrevio)).concat(", idPaciente: ").concat(Integer.toString(idPaciente)).concat(", idTratamiento: ")
                .concat(Integer.toString(idTipoTratamiento)).concat(", fecha: ").concat(fecha.toString()).concat(", comentarios: ").concat(comentarios).concat(", estatus: ").concat(Integer.toString(estatus));
    }

    public int getIdPacienteTratamientoPrevio() {
        return idPacienteTratamientoPrevio;
    }

    public void setIdPacienteTratamientoPrevio(int idPacienteTratamientoPrevio) {
        this.idPacienteTratamientoPrevio = idPacienteTratamientoPrevio;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdTipoTratamiento() {
        return idTipoTratamiento;
    }

    public void setIdTipoTratamiento(int idTipoTratamiento) {
        this.idTipoTratamiento = idTipoTratamiento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public int getCiclos() {
        return ciclos;
    }

    public void setCiclos(int ciclos) {
        this.ciclos = ciclos;
    }
    
}
