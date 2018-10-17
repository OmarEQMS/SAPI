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
public class EstadoEstudio {

	private int idEstadoEstudio;
	private String nombre;
	private int estatus;

    public EstadoEstudio() {}
    
    @Override
    public String toString(){
    	String str = "EstadoEstudio [idEstadoEstudio".concat(String.valueOf(idEstadoEstudio))
    		.concat(",nombre:").concat(nombre)
    		.concat(",estatus:").concat(String.valueOf(estatus))
    		.concat("]");
    	return str;	
    }

    public int getIdEstadoEstudio() {
        return idEstadoEstudio;
    }

    public void setIdEstadoEstudio(int idEstadoEstudio) {
        this.idEstadoEstudio = idEstadoEstudio;
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
