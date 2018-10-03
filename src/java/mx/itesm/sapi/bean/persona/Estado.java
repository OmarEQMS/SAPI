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
public class Estado implements Serializable {
    private int idEstado;
    private String nombre;
    private int estatus;
    
    @Override
    public String toString(){
        return "Estado [idEstado:".concat(String.valueOf(idEstado)).concat(",nombre:").concat(nombre)
                                  .concat(",estatus:").concat(String.valueOf(estatus)).concat("]");
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

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }
   
}
