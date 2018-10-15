/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.moduloGestionMedico;

import java.io.Serializable;

/**
 *
 * @author feror
 */
public class MedicoEspecialidad implements Serializable{
    private int idMedicoEspecialidad;
    private int idEmpleado;
    private int idEspecialidad;
    private String cedulaProfesional;
    private int estatus;
    
    public MedicoEspecialidad(){}
    
    @Override
    public String toString(){
        return "MedicoEspecialidad [idMedicoEspecialidad:"
                .concat(String.valueOf(idMedicoEspecialidad))
                .concat(",cedula profesional:").concat(cedulaProfesional)
                .concat(",estatus:").concat(String.valueOf(estatus)).concat("]");

    } 

    public int getIdMedicoEspecialidad() {
        return idMedicoEspecialidad;
    }

    public void setIdMedicoEspecialidad(int idMedicoEspecialidad) {
        this.idMedicoEspecialidad = idMedicoEspecialidad;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getCedulaProfesional() {
        return cedulaProfesional;
    }

    public void setCedulaProfesional(String cedulaProfesional) {
        this.cedulaProfesional = cedulaProfesional;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }
    
}
