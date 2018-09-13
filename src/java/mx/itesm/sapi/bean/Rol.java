/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean;

import java.io.Serializable;

/**
 *
 * @author Angel GTZ
 */
public class Rol implements Serializable{
    private int idRol;
    private String nombre;
    
    public Rol(){}
        @Override
    public String toString(){
        return "Rol [idRol:".concat(String.valueOf(idRol)).concat(",nombre:").concat(nombre)
                                                                             .concat("]");
    } 

    public int getIdRol(){
        return idRol;
    }
    /**   Set id rol
    public void setIdRol(int idRol){
        this.idRol=idRol;
    }
    */
    public String getNombre() {
       return nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
   
}
