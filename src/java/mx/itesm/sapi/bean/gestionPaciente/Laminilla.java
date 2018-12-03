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
public class Laminilla {
    private int idLaminilla;
    private int idBiopsia;
    private String nombre;
    private int estatus;
    private int cantidad;
    
     public Laminilla() {}
    
    @Override 
    public String toString(){
        String str= "Laminilla [idLaminilla:".concat(String.valueOf(idLaminilla))
                .concat(",idBiopsia:").concat(String.valueOf(idBiopsia))
                .concat(",nombre:").concat(nombre)
                .concat(",estatus:").concat(String.valueOf(estatus))
                .concat(",cantidad:").concat(String.valueOf(cantidad))
                .concat("]");
        return str;
    }

    public int getIdLaminilla() {
        return idLaminilla;
    }

    public void setIdLaminilla(int idLaminilla) {
        this.idLaminilla = idLaminilla;
    }

    public int getIdBiopsia() {
        return idBiopsia;
    }

    public void setIdBiopsia(int idBiopsia) {
        this.idBiopsia = idBiopsia;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
   
}
