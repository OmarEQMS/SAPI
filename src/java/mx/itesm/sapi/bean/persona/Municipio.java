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
public class Municipio implements Serializable {
    private int idMunicipio;
    private String nombre;
    private int idEstado;
    private int estatus;
    
    public Municipio(){}
    
        @Override
    public String toString(){
        return "Municipio [idMunicipio:".concat(String.valueOf(idMunicipio)).concat(",nombre:").concat(nombre)
       .concat(",idEstado:").concat(String.valueOf(idEstado))
       .concat(",estatus:").concat(String.valueOf(estatus)).concat("]");
    } 

    public int getIdMunicipio(){    
        return idMunicipio;
    }
      
    public void setIdMunicipio(int idMunicipio){
        this.idMunicipio=idMunicipio;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public int getIdEstado() {
        return idEstado;
    }
    public void setIdEstado(int idEstado){
        this.idEstado=idEstado;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }
    
    
}
