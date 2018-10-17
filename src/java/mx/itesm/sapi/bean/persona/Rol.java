/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.persona;

import java.io.Serializable;

/**
 *
 * @author Angel GTZ
 */
public class Rol implements Serializable{
    private int idRol;
    private String nombre;
    private int estatus;
    
    public Rol(){}
        @Override
    public String toString(){
        return "Rol [idRol:".concat(String.valueOf(idRol)).concat(",nombre:").concat(nombre).concat(",estatus:")
                                                          .concat(String.valueOf(estatus)).concat("]");
    } 

    public int getIdRol(){
        return idRol;
    }
    
    public void setIdRol(int idRol){
        this.idRol=idRol;
    }
    
    public String getNombre() {
       return nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }
   
}
