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
public class TipoHistologico {

	private int idTipoHistologico;
	private String nombre;
	private int estatus;


    public TipoHistologico() {}
    
    @Override
    public String toString(){

    	String str="TipoHistologico [idTipoHistologico".concat(String.valueOf(idTipoHistologico))
    		.concat(",nombre:").concat(nombre)
    		.concat(",estatus:").concat(String.valueOf(estatus))
    		.concat("]");

    	return str;

    }

    public int getIdTipoHistologico() {
        return idTipoHistologico;
    }

    public void setIdTipoHistologico(int idTipoHistologico) {
        this.idTipoHistologico = idTipoHistologico;
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
