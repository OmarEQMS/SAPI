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
public class CategoriaEstudio {

    private int idCategoriaEstudio;
    private String nombre;
    private int estatus;

    public CategoriaEstudio() {}
    
    @Override
    public String toString(){
    	String str="CategoriaEstudio [idCategoriaEstudio:".concat(String.valueOf(idCategoriaEstudio))
    		.concat(",nombre:").concat(nombre)
    		.concat(",estatus:").concat(String.valueOf(estatus))
    		.concat("]");
        return str;
    }

    public int getIdCategoriaEstudio() {
        return idCategoriaEstudio;
    }

    public void setIdCategoriaEstudio(int idCategoriaEstudio) {
        this.idCategoriaEstudio = idCategoriaEstudio;
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
