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
public class ReceptorEstrogeno {

	private int idReceptorEstrogeno;
	private String nombre;
	private int estatus;

    public ReceptorEstrogeno() {}

    @Override
    public String toString(){
    	String str="ReceptorEstrogeno [idReceptorEstrogeno:".concat(String.valueOf(idReceptorEstrogeno))
    		.concat(",nombre:").concat(nombre)
    		.concat(",estatus:").concat(String.valueOf(estatus))
    		.concat("]");

    	return str;
    }

    public int getIdReceptorEstrogeno() {
        return idReceptorEstrogeno;
    }

    public void setIdReceptorEstrogeno(int idReceptorEstrogeno) {
        this.idReceptorEstrogeno = idReceptorEstrogeno;
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
