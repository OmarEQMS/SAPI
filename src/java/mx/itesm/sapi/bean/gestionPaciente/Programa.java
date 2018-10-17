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
public class Programa {

	private int idPrograma;
	private String nombre;
	private int estatus;
    
    public Programa() {}
    
    @Override
    public String toString(){
    	String str="Programa [idPrograma:".concat(String.valueOf(idPrograma))
    		.concat(",nombre:").concat(nombre)
    		.concat(",estatus:").concat(String.valueOf(estatus))
    		.concat("]");

    	return str;
    }

    public int getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(int idPrograma) {
        this.idPrograma = idPrograma;
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
