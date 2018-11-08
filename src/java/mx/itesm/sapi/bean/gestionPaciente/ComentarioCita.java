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
	private String comentarioIncidencia ;
	private int idCita;
	private int navegadora;
	private int estatus;
        private String comentarioMedico;

    public ComentarioCita() {}

    @Override 
    public String toString(){
    	String str="ComentarioCita [idComentarioCita:".concat(String.valueOf(idComentarioCita))
    		.concat(",comentarioIncidencia :").concat(comentarioIncidencia )
    		.concat(",idCita:").concat(String.valueOf(idCita))
    		.concat(",navegadora:").concat(String.valueOf(navegadora))
    		.concat(",estatus:").concat(String.valueOf(estatus))
                .concat(",comentarioMedico :").concat(comentarioMedico)
    		.concat("]");

    	return str;
    }

    public int getIdComentarioCita() {
        return idComentarioCita;
    }

    public void setIdComentarioCita(int idComentarioCita) {
        this.idComentarioCita = idComentarioCita;
    }

    public String getComentarioIncidencia() {
        return comentarioIncidencia;
    }

    public String getComentarioMedico() {
        return comentarioMedico;
    }

    public void setComentarioIncidencia(String comentarioIncidencia) {
        this.comentarioIncidencia = comentarioIncidencia;
    }

    public void setComentarioMedico(String comentarioMedico) {
        this.comentarioMedico = comentarioMedico;
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
