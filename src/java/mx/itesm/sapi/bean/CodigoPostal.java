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
public class CodigoPostal implements Serializable {
    private int idCodigoPostal;
    private String numero;
    private int idMunicipio;
    
    public CodigoPostal(){}
    
    @Override
    public String toString(){
        return "Codigo Postal [idCodigoPostal:".concat(String.valueOf(idCodigoPostal)).concat(",numero:").concat(numero)
                                               .concat(",idMunicipio:").concat(String.valueOf(idMunicipio))
                                               .concat("]");

    } 

    public int getIdCodigoPostal(){
        return idCodigoPostal;
    }
    
    /**   Set id codigo postal
    public void setIdCodigoPostal(int idCodigoPostal){
        this.idCodigoPostal=idCodigoPostal;
    }
    */

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
}
