/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.gestionPaciente;

import java.sql.Timestamp;

/**
 *
 * @author Alex
 */
public class LlamadaCita {

	private int idLlamadaCita;
	private int idCita;
	private int idEmpleado;
	private Timestamp fecha;
	private int llamada;
	private int estatus;
        private String comentario;

    public LlamadaCita() {}
    
    @Override
    public String toString(){

    	String str= "LlamadaCita [idLlamadaCita:".concat(String.valueOf(idLlamadaCita))
    		.concat(",idCita:").concat(String.valueOf(idCita))
    		.concat(",idEmpleado:").concat(String.valueOf(idEmpleado))
    		.concat(",fecha:").concat(String.valueOf(fecha))
    		.concat(",llamada:").concat(String.valueOf(llamada))
    		.concat(",estatus:").concat(String.valueOf(estatus))
                .concat(",comentario:").concat(comentario)
    		.concat("]");
    	return str;


    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getIdLlamadaCita() {
        return idLlamadaCita;
    }

    public void setIdLlamadaCita(int idLlamadaCita) {
        this.idLlamadaCita = idLlamadaCita;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public int getLlamada() {
        return llamada;
    }

    public void setLlamada(int llamada) {
        this.llamada = llamada;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    
    
    
}
