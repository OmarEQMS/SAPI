/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.gestionPaciente;

/**
 *
 * @author A01422575
 */
public class TorreNueva {
    private int idTorreNueva;
    private String nombre;
    private int estatus;
    
    public TorreNueva() {}

    @Override 
    public String toString(){
        String str= "TorreNueva [idTorreNueva:".concat(String.valueOf(idTorreNueva))
                .concat(",nombre:").concat(nombre)
                .concat(",estatus:").concat(String.valueOf(estatus))
                .concat("]");
        return str;
    }

    public int getIdTorreNueva() {
        return idTorreNueva;
    }

    public void setIdTorreNueva(int idTorreNueva) {
        this.idTorreNueva = idTorreNueva;
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
