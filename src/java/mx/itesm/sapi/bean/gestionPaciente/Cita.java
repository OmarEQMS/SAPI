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
public class Cita {

	private int idCita;
	private int idTipoCita;
	private int idAtencion;
	private int idEstadoCita;
	private int idMotivoConsulta;
	private int idImportanciaCita;
	private int idTipoEstudio;
	private Timestamp fechaProgramada;
        private Timestamp fechaReal;
	private int estatus;


    public Cita() {}

    @Override
    public String toString(){
    	String str="Cita [idCita".concat(String.valueOf(idCita))
    		.concat(",idTipoCita:").concat(String.valueOf(idTipoCita))
    		.concat(",idAtencion:").concat(String.valueOf(idAtencion))
    		.concat(",idEstadoCita:").concat(String.valueOf(idEstadoCita))
    		.concat(",idMotivoConsulta:").concat(String.valueOf(idMotivoConsulta))
    		.concat(",idImportanciaCita:").concat(String.valueOf(idImportanciaCita))
    		.concat(",idTipoEstudio:").concat(String.valueOf(idTipoEstudio))
    		.concat(",fechaProgramada:").concat(String.valueOf(fechaProgramada))
                .concat(",fechaReal:").concat(String.valueOf(fechaReal))
    		.concat(",estatus:").concat(String.valueOf(estatus))
    		
    		.concat("]");

    	return str;

    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public int getIdTipoCita() {
        return idTipoCita;
    }

    public void setIdTipoCita(int idTipoCita) {
        this.idTipoCita = idTipoCita;
    }

    public int getIdAtencion() {
        return idAtencion;
    }

    public void setIdAtencion(int idAtencion) {
        this.idAtencion = idAtencion;
    }

    public int getIdEstadoCita() {
        return idEstadoCita;
    }

    public void setIdEstadoCita(int idEstadoCita) {
        this.idEstadoCita = idEstadoCita;
    }

    public int getIdMotivoConsulta() {
        return idMotivoConsulta;
    }

    public void setIdMotivoConsulta(int idMotivoConsulta) {
        this.idMotivoConsulta = idMotivoConsulta;
    }

    public int getIdImportanciaCita() {
        return idImportanciaCita;
    }

    public void setIdImportanciaCita(int idImportanciaCita) {
        this.idImportanciaCita = idImportanciaCita;
    }

    public int getIdTipoEstudio() {
        return idTipoEstudio;
    }

    public void setIdTipoEstudio(int idTipoEstudio) {
        this.idTipoEstudio = idTipoEstudio;
    }

    public Timestamp getFechaProgramada() {
        return fechaProgramada;
    }

    public void getFechaProgramada(Timestamp fechaProgramada) {
        this.fechaProgramada = fechaProgramada;
    }

     public Timestamp getFechaReal() {
        return fechaReal;
    }

    public void getFechaReal(Timestamp fechaReal) {
        this.fechaReal = fechaReal;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }
    
}
