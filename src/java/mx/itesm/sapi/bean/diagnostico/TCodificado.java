/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.diagnostico;

/**
 *
 * @author Diego
 */
public class TCodificado {
    private int idTCodificado;
    private String nombre;
    private int estatus;

    @Override
    public String toString() {
        return "TCodificado{" + "idTCodificado=" + idTCodificado + ", nombre=" + nombre + ", estatus=" + estatus + '}';
    }

    public int getIdTCodificado() {
        return idTCodificado;
    }

    public void setIdTCodificado(int idTCodificado) {
        this.idTCodificado = idTCodificado;
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
