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
public class TratamientoPaciente implements Serializable{
    
    private int idTratamientoPaciente;
    private int idPaciente;
    private int idTipoTratamiento;
    private Date fechaInicio;
    private Date fechaFin;
    private boolean recurrente;
    private boolean previoCirugia;
    private int estatus;

    public int getIdTratamientoPaciente() {
        return idTratamientoPaciente;
    }

    public void setIdTratamientoPaciente(int idTratamientoPaciente) {
        this.idTratamientoPaciente = idTratamientoPaciente;
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

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public boolean getRecurrente() {
        return recurrente;
    }

    public void setRecurrente(boolean recurrente) {
        this.recurrente = recurrente;
    }

    public boolean getPrevioCirugia() {
        return previoCirugia;
    }

    public void setPrevioCirugia(boolean previoCirugia) {
        this.previoCirugia = previoCirugia;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public TratamientoPaciente() {
    }
    
    @Override
    public String toString(){
        return "Tratamiento paciente ID: ".concat(Integer.toString(idTratamientoPaciente).concat(" IdPaciente :").concat(Integer.toString(idPaciente).
                concat(", idTipoTratamiento: ").concat(Integer.toString(idTipoTratamiento)).concat(", fechaInicio: ").concat(fechaInicio.toString()
                        .concat(", fechaFin: ").concat(fechaFin.toString().concat(", fecha: ")
                        .concat(", recurrente: ").concat(Boolean.toString(recurrente).concat(", previoCirugia: ")
                                .concat(Boolean.toString(previoCirugia).concat(", status: ").concat(Integer.toString(estatus))))))));
    }
    
}
