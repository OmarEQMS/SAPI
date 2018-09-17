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
public class Estado implements Serializable {
    private int idEstado;
    private String nombre;
    
    @Override
    public String toString(){
        return "Estado [idEstado:".concat(String.valueOf(idEstado)).concat(",nombre:").concat(nombre)
                                  .concat("]");
    } 

    public int getIdEstado(){
        return idEstado;
    }

    public void setIdEstado(int idEstado){
        this.idEstado=idEstado;
    }
   

    public String getNombre() {
       return nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
   
}
