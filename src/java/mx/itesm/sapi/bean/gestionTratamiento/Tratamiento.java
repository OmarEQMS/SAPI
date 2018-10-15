/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.gestionTratamiento;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class Tratamiento implements Serializable {
    
    private int idTratamiento;
    private String nombre;
    private int estatus;

    public Tratamiento() {
    }

    public int getIdTratamiento() {
        return idTratamiento;
    }

    public void setIdTratamiento(int idTratamiento) {
        this.idTratamiento = idTratamiento;
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

   
    
    @Override
    public String toString(){
        
        
        return "Tratamiento: ID: ".concat(Integer.toString(idTratamiento)).concat(", Nombre: ").concat(nombre).concat(", Estatus: ").concat(Integer.toString(estatus));
        
        
        
    }
    
    
}
