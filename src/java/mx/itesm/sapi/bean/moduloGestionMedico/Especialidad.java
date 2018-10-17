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
public class Especialidad implements Serializable{
    private int idEspecialidad;
    private String nombre;
    private int subEspecialidad;
    private int estatus;
    
    public Especialidad(){}
    
    @Override
    public String toString(){
        return "Especialidad [Especialidad:".concat(String.valueOf(idEspecialidad)).concat(",nombre:").concat(nombre).concat("]");

    } 

    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSubEspecialidad() {
        return subEspecialidad;
    }

    public void setSubEspecialidad(int subEspecialidad) {
        this.subEspecialidad = subEspecialidad;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }
    
    
}
