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
public class Her2 {
    private int idHer2;
    private String nombre;
    private int estatus;
    
    public Her2() {}

    @Override 
    public String toString(){
        String str= "Her2 [idHer2:".concat(String.valueOf(idHer2))
                .concat(",nombre:").concat(nombre)
                .concat(",estatus:").concat(String.valueOf(estatus))
                .concat("]");
        return str;
    }

    public int getIdHer2() {
        return idHer2;
    }

    public void setIdHer2(int idHer2) {
        this.idHer2 = idHer2;
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
