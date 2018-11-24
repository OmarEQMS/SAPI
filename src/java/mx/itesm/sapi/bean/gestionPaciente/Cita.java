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
    private int idPaciente;
    private int idEstadoCita;
    private int idImportanciaCita;
    private int idPiso;
    private int idTipoTratamiento;
    private int idEstudio;
    private int idMotivoConsulta;
    private Timestamp fechaProgramada;
    private Timestamp fechaReal;
    private int estatus;
    private byte[] archivo;
    private String hospitalProcedencia;
    private Timestamp fechaSolicitud;

    public Cita() {
    }

    @Override
    public String toString() {
        String str = "Cita [idCita".concat(String.valueOf(idCita))
                .concat(",idTipoCita:").concat(String.valueOf(idTipoCita))
                .concat(",idPaciente:").concat(String.valueOf(idPaciente))
                .concat(",idEstadoCita:").concat(String.valueOf(idEstadoCita))
                .concat(",idImportanciaCita:").concat(String.valueOf(idImportanciaCita))
                .concat(",idTipoTratamiento:").concat(String.valueOf(idTipoTratamiento))
                .concat(",idEstudio:").concat(String.valueOf(idEstudio))
                .concat(",idMotivoConsulta:").concat(String.valueOf(idMotivoConsulta))
                .concat(",fechaProgramada:").concat(String.valueOf(fechaProgramada))
                .concat(",fechaReal:").concat(String.valueOf(fechaReal))
                .concat(",archivo:").concat(String.valueOf(archivo))
                .concat(",hospitalProcedencia:").concat(String.valueOf(hospitalProcedencia))
                .concat(",fechaSolicitud:").concat(String.valueOf(fechaSolicitud))
                .concat(",estatus:").concat(String.valueOf(estatus))
                .concat("]");

        return str;

    }

    public byte[] getArchivo() {
        return archivo;
    }

    public void setArchivo(byte[] archivo) {
        this.archivo = archivo;
    }

    public String getHospitalProcedencia() {
        return hospitalProcedencia;
    }

    public void setHospitalProcedencia(String hospitalProcedencia) {
        this.hospitalProcedencia = hospitalProcedencia;
    }

    public Timestamp getFechaSolicitud() {
        return fechaSolicitud;
    }
    
    public void setIdImportanciaCita(int idImportanciaCita) {
        this.idImportanciaCita = idImportanciaCita;
    }

    public int getIdImportanciaCita() {
        return idImportanciaCita;
    }

    public void setFechaSolicitud(Timestamp fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public int getIdTipoTratamiento() {
        return idTipoTratamiento;
    }

    public void setIdTipoTratamiento(int idTipoTratamiento) {
        this.idTipoTratamiento = idTipoTratamiento;
    }

    public int getIdEstudio() {
        return idEstudio;
    }

    public void setIdEstudio(int idEstudio) {
        this.idEstudio = idEstudio;
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

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
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

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public Timestamp getFechaProgramada() {
        return fechaProgramada;
    }

    public void setFechaProgramada(Timestamp fechaProgramada) {
        this.fechaProgramada = fechaProgramada;
    }

    public Timestamp getFechaReal() {
        return fechaReal;
    }

    public void setFechaReal(Timestamp fechaReal) {
        this.fechaReal = fechaReal;
    }

    public int getIdPiso() {
        return idPiso;
    }

    public void setIdPiso(int idPiso) {
        this.idPiso = idPiso;
    }

}
