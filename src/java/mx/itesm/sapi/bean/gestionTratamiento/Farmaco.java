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
public class Farmaco implements Serializable {
   
    private int idFarmaco;
    private String nombre;
    private int estatus;

    public Farmaco() {
    }

    public int getIdFarmaco() {
        return idFarmaco;
    }

    public void setIdFarmaco(int id) {
        this.idFarmaco = id;
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
        
        
        return "Farmaco: ID: ".concat(Integer.toString(idFarmaco)).concat(", Nombre: ").concat(nombre).concat(", Estatus: ").concat(Integer.toString(estatus));
        
        
        
    }
    
    
}
