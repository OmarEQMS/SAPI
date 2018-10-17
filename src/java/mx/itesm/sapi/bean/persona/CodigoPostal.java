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
public class CodigoPostal implements Serializable {
    private int idCodigoPostal;
    private int idMunicipio;
    private String numero;
    private int estatus;
    
    public CodigoPostal(){}
    
    @Override
    public String toString(){
        return "Codigo Postal [idCodigoPostal:".concat(String.valueOf(idCodigoPostal)).concat(",idMunicipio:").concat(String.valueOf(idMunicipio))
                .concat(",numero:").concat(numero) 
                .concat(",estatus:").concat(String.valueOf(estatus)).concat("]");

    } 

    public int getIdCodigoPostal(){
        return idCodigoPostal;
    }
    
    //Set id codigo postal
    public void setIdCodigoPostal(int idCodigoPostal){
        this.idCodigoPostal=idCodigoPostal;
    }
    

    public String getNumero() {
       return numero;
    }
    public void setNumero(String numero){
        this.numero=numero;
    }
    public int getIdMunicipio() {
        return idMunicipio;
    }
    public void setIdMunicipio(int idMunicipio){
        this.idMunicipio=idMunicipio;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }
    
}
