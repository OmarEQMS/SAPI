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
public class NCodificado implements Serializable{
    private int idNCodificado;
    private String nombre;
    private int estatus;

    @Override
    public String toString() {
        return "NCodificado{" + "idNCodificado=" + idNCodificado + ", nombre=" + nombre + ", estatus=" + estatus + '}';
    }

    public int getIdNCodificado() {
        return idNCodificado;
    }

    public void setIdNCodificado(int idNCodificado) {
        this.idNCodificado = idNCodificado;
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

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }
    
    
}
