/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.moduloGestionPaciente;

/**
 *
 * @author Alex
 */
public class EstadoPaciente {

	private int idEstadoPaciente;
	private String nombre;
	private int estatus;
    
    public EstadoPaciente() {}
    
    @Override
    public String toString(){
    	String str="EstadoPaciente [idEstadoPaciente".concat(String.valueOf(idEstadoPaciente))
    		.concat(",nombre:").concat(nombre)
    		.concat(",estatus:").concat(String.valueOf(estatus))
    		.concat("]");

    	return str;
    }

    public int getIdEstadoPaciente() {
        return idEstadoPaciente;
    }

    public void setIdEstadoPaciente(int idEstadoPaciente) {
        this.idEstadoPaciente = idEstadoPaciente;
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
