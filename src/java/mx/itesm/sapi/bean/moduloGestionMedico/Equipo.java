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
public class Equipo implements Serializable{
    private int idEquipo;
    private String nombre;
    private int estatus;
    
    public Equipo(){}
    
     @Override
    public String toString(){
        return "Equipo[Equipo:".concat(String.valueOf(idEquipo))
                .concat(",nombre:").concat(nombre).concat(",estatus:").concat(String.valueOf(estatus)).concat("]");

    } 

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }
    
}
