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
public class Ki67 {
    private int idKi67;
    private String nombre;
    private int estatus;
    
     public Ki67() {}
    
    @Override 
    public String toString(){
        String str= "Ki67 [idKi67:".concat(String.valueOf(idKi67))
                .concat(",nombre:").concat(nombre)
                .concat(",estatus:").concat(String.valueOf(estatus))
                .concat("]");
        return str;
    }

    public int getIdKi67() {
        return idKi67;
    }

    public void setIdKi67(int idKi67) {
        this.idKi67 = idKi67;
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
