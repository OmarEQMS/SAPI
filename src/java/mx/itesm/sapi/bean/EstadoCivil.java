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
public class EstadoCivil implements Serializable {
    private int idEstadoCivil;
    private String nombre;
    
    public EstadoCivil(){}
    
    @Override
    public String toString(){
        return "Estado [idEstadoCivil:".concat(String.valueOf(idEstadoCivil)).concat(",nombre:").concat(nombre)
       .concat("]");

    } 
    public int getIdEstadoCivil(){
        return idEstadoCivil;
    }
    /**   Set id estadocivil
    public void setEstadoCivil(int idEstadoCivil){
        this.idEstadoCivil=idEstadoCivil;
    }
    */
    public String getNombre() {
       return nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
  
}
