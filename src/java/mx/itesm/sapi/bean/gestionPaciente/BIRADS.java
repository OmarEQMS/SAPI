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
public class BIRADS {

    private int idBirads;
    private String nombre;
    private int estatus;
    public BIRADS() {}
    
    @Override 
    public String toString(){
        String str="BIRADS [idBirads:".concat(String.valueOf(idBirads))
                .concat(",nombre:").concat(nombre)
                .concat(",estatus:").concat(String.valueOf(estatus))
                .concat("]");
        return str;
    }

    public int getIdBirads() {
        return idBirads;
    }

    public void setIdBirads(int idBirads) {
        this.idBirads = idBirads;
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
