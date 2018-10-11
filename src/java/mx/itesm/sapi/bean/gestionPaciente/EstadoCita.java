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
public class EstadoCita {

	private int idEstadoCita;
	private String nombre;
	private int estatus;

    public EstadoCita() {}

    @Override
    public String toString(){
    	String str="EstadoCita [idEstadoCita".concat(String.valueOf(idEstadoCita))
    		.concat(",idEstadoCita:").concat(String.valueOf(idEstadoCita))
    		.concat(",nombre:").concat(nombre)
    		.concat(",estatus:").concat(String.valueOf(estatus))
    		.concat("]");	
    		
    	return str;

    }

    public int getIdEstadoCita() {
        return idEstadoCita;
    }

    public void setIdEstadoCita(int idEstadoCita) {
        this.idEstadoCita = idEstadoCita;
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
