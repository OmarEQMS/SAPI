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
public class Posicion implements Serializable{
    
    private int idPosicion;
    private String nombre;
    private int estatus;
    
    public Posicion(){}
    
    @Override
    public String toString(){
        return "Posicio [idPosicion:".concat(String.valueOf(idPosicion)).concat(",nombre:").concat(nombre).concat(",estatus:").concat(String.valueOf(estatus)).concat("]");

    }

    public int getIdPosicion() {
        return idPosicion;
    }

    public void setIdPosicion(int idPosicion) {
        this.idPosicion = idPosicion;
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
