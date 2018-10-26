/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.gestionTratamiento;

import java.sql.Date;

/**
 *
 * @author feror
 */
public class UnionTratamientoPaciente {
    private int idTratamientoPaciente;
    private int idPaciente;
    private int idTipoTratamiento;
    private String nombre;
    private Date fechaInicio;
    private Date fechaFin;
    
    
    public UnionTratamientoPaciente(){}
    
     @Override
    public String toString(){
        return "Tratamiento paciente ID: ".concat(Integer.toString(idTratamientoPaciente));
    }

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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    
    
    
}
