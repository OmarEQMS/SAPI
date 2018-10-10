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
public class TipoSangre implements Serializable{
    private int idTipoSangre;
    private String nombre;
    private int estatus;
    
      public TipoSangre(){}
    
    @Override
    public String toString(){
        return "Tipo de sangre [idTipoSangre:".concat(String.valueOf(idTipoSangre)).concat(",nombre:").concat(nombre)
       .concat(",estatus:").concat(String.valueOf(estatus)).concat("]");

    } 
    public int getIdTipoSangre(){
        return idTipoSangre;
    }
    //Set id estadocivil
    public void setIdTipoSangre(int idTipoSangre){
        this.idTipoSangre=idTipoSangre;
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
