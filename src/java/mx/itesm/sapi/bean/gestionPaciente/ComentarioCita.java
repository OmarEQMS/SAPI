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
public class ComentarioCita {

	private int idComentarioCita;
	private String comentario;
	private int idCita;
	private int navegadora;
	private int estatus;

    public ComentarioCita() {}

    @Override 
    public String toString(){
    	String str="ComentarioCita [idComentarioCita:".concat(String.valueOf(idComentarioCita))
    		.concat(",comentario:").concat(comentario)
    		.concat(",idCita:").concat(String.valueOf(idCita))
    		.concat(",navegadora:").concat(String.valueOf(navegadora))
    		.concat(",estatus:").concat(String.valueOf(estatus))
    		.concat("]");

    	return str;
    }

    public int getIdComentarioCita() {
        return idComentarioCita;
    }

    public void setIdComentarioCita(int idComentarioCita) {
        this.idComentarioCita = idComentarioCita;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public int getNavegadora() {
        return navegadora;
    }

    public void setNavegadora(int navegadora) {
        this.navegadora = navegadora;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }
    
    
    
}
