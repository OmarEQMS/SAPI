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
    private int idTCodifciado;
    private String nombre;
    private int status;

    @Override
    public String toString() {
        return "TCodificado{" + "idTCodifciado=" + idTCodifciado + ", nombre=" + nombre + ", status=" + status + '}';
    }

    public int getIdTCodifciado() {
        return idTCodifciado;
    }

    public void setIdTCodifciado(int idTCodifciado) {
        this.idTCodifciado = idTCodifciado;
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
