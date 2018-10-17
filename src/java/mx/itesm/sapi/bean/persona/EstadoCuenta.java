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
public class EstadoCuenta implements Serializable{
    
    private int idEstadoCuenta;
    private String nombre;
    private int estatus;
    
      public EstadoCuenta(){}
    
    @Override
    public String toString(){
        return "Estado de cuenta [idEstadoCuenta:".concat(String.valueOf(idEstadoCuenta)).concat(",nombre:").concat(nombre)
       .concat(",estatus:").concat(String.valueOf(estatus)).concat("]");

    } 

    public void setIdEstadoCuenta(int idEstadoCuenta) {
        this.idEstadoCuenta = idEstadoCuenta;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public int getIdEstadoCuenta() {
        return idEstadoCuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEstatus() {
        return estatus;
    }
    
}
