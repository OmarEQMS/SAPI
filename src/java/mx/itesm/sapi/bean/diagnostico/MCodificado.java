/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.diagnostico;

import java.io.Serializable;

/**
 *
 * @author Diego
 */
public class MCodificado implements Serializable{
    private int idMCodifciado;
    private String nombre;
    private int status;

    public int getIdMCodifciado() {
        return idMCodifciado;
    }

    public void setIdMCodifciado(int idMCodifciado) {
        this.idMCodifciado = idMCodifciado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
}
