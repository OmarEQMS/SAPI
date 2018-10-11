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
    private int idMCodificado;
    private String nombre;
    private int estatus;

    @Override
    public String toString() {
        return "MCodificado{" + "idMCodificado=" + idMCodificado + ", nombre=" + nombre + ", status=" + estatus + '}';
    }

    public int getIdMCodificado() {
        return idMCodificado;
    }

    public void setIdMCodificado(int idMCodificado) {
        this.idMCodificado = idMCodificado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int status) {
        this.estatus = status;
    }
    
    
}
