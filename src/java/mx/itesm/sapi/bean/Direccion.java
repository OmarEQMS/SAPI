/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean;

import java.io.Serializable;

/**
 *
 * @author feror y Angel
 */
public class Direccion implements Serializable{
    
    private int idDireccion;
    private String calle;
    private String noInterior;
    private String noExterior;
    private String colonia;
    private int estatus;
    
    public Direccion(){}
    
    @Override
    public String toString(){
        return "Calle:".concat(calle).concat(",noInterior:").concat(noInterior).concat(",noExterior:").concat(noExterior)
       .concat(",colonia:").concat(colonia).concat(",idPersona:").concat(String.valueOf(estatus)).concat("]");

    } 

    public int getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNoInterior() {
        return noInterior;
    }

    public void setNoInterior(String noInterior) {
        this.noInterior = noInterior;
    }

    public String getNoExterior() {
        return noExterior;
    }

    public void setNoExterior(String noExterior) {
        this.noExterior = noExterior;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    
    
}
