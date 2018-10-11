/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.gestionPaciente;

/**
 *
 * @author Oscar Miranda
 */
public class Fish {
    private int idFish;
    private String nombre;
    private int estatus;
    
    public Fish() {}
    
    @Override 
    public String toString(){
        String str= "Fish [idFish:".concat(String.valueOf(idFish))
                .concat(",nombre:").concat(nombre)
                .concat(",estatus:").concat(String.valueOf(estatus))
                .concat("]");
        return str;
    }

    public int getIdFish() {
        return idFish;
    }

    public void setIdFish(int idFish) {
        this.idFish = idFish;
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
