/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.gestionPaciente;

/**
 *
 * @author Alex
 */
public class Escolaridad {
    
    private int idEscolaridad;
    private String nombre;
    private int estatus;
    
    public Escolaridad() {}
    
    @Override
    public String toString(){
        String str="Escolaridad [idEscolaridad:".concat(String.valueOf(idEscolaridad))
                .concat(",nombre:").concat(nombre)
                .concat(",estatus:").concat(String.valueOf(estatus))
                .concat("]");
    
        return str;
    }

    public int getIdEscolaridad() {
        return idEscolaridad;
    }

    public void setIdEscolaridad(int idEscolaridad) {
        this.idEscolaridad = idEscolaridad;
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
