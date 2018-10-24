/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.persona;

import java.io.InputStream;
import java.io.Serializable;

/**
 *
 * @author Diego
 */
public class Pic implements Serializable {
    
    private int idPic;
    private int idPersona;
    private InputStream contenido;
    private int tamano;
    private String tipo;
    private int estatus;
    
    @Override
    public String toString() {
        return "Pic{" + "idPic=" + idPic + ", idPersona=" + idPersona + ", contenido=" + contenido + ", tamano=" + tamano + ", tipo=" + tipo + ", estatus=" + estatus + '}';
    }

    public int getIdPic() {
        return idPic;
    }

    public void setIdPic(int idPic) {
        this.idPic = idPic;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public InputStream getContenido() {
        return contenido;
    }

    public void setContenido(InputStream contenido) {
        this.contenido = contenido;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }
    
    
    
}
