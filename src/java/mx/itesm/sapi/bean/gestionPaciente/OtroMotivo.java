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
public class OtroMotivo {

	private int idOtroMotivo;
	private int idCita;
	private String nombre;
	private int estatus;
    
    public OtroMotivo() {}
    
    @Override
    public String toString(){
    	String str="OtroMotivo [idOtroMotivo".concat(String.valueOf(idOtroMotivo))
    		.concat(",idCita:").concat(String.valueOf(idCita))
    		.concat(",nombre:").concat(nombre)
    		.concat(",estatus:").concat(String.valueOf(estatus))
    		.concat("]");
    	return str;
    }

    public int getIdOtroMotivo() {
        return idOtroMotivo;
    }

    public void setIdOtroMotivo(int idOtroMotivo) {
        this.idOtroMotivo = idOtroMotivo;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
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
