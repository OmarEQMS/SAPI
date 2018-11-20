/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.gestionPaciente;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author Alex
 */
public class DocumentoEstudio {

    private int idDocumentoEstudio;
    private int idEstudio;
    private int idEstadoEstudio;
    private int idPaciente;
    private int idBirads;
    private int idLugarDelCuerpo;
    private byte[] archivo;
    private int previo;
    private int estatus;
    private Date fechaEstudioResultado;
    private int idCita;



    public DocumentoEstudio() {
    }

    @Override
    public String toString() {
        String str = "DocumentoEstudio [idDocumentoEstudio:".concat(String.valueOf(idDocumentoEstudio))
                .concat("idEstadoEstudio:").concat(String.valueOf(idEstadoEstudio))
                .concat("idPaciente:").concat(String.valueOf(idPaciente))
                .concat("idEstudio:").concat(String.valueOf(idEstudio))
                .concat("idBirads:").concat(String.valueOf(idBirads))
                .concat("archivo:").concat(String.valueOf(archivo))
                .concat("previo:").concat(String.valueOf(previo))
                .concat("estatus:").concat(String.valueOf(estatus))
                .concat(",fechaEstudioResultado:").concat(String.valueOf(fechaEstudioResultado))
                .concat("idLugarDelCuerpo:").concat(String.valueOf(idLugarDelCuerpo))
                .concat("]");

        return str;

    }

   

    public int getIdDocumentoEstudio() {
        return idDocumentoEstudio;
    }

    public void setIdDocumentoEstudio(int idDocumentoEstudio) {
        this.idDocumentoEstudio = idDocumentoEstudio;
    }

    public int getIdEstadoEstudio() {
        return idEstadoEstudio;
    }

    public void setIdEstadoEstudio(int idEstadoEstudio) {
        this.idEstadoEstudio = idEstadoEstudio;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdEstudio() {
        return idEstudio;
    }

    public void setIdEstudio(int idEstudio) {
        this.idEstudio = idEstudio;
    }

    public int getIdBirads() {
        return idBirads;
    }

    public void setIdBirads(int idBirads) {
        this.idBirads = idBirads;
    }

    public byte[] getArchivo() {
        return archivo;
    }

    public void setArchivo(byte[] archivo) {
        this.archivo = archivo;
    }

    public int getPrevio() {
        return previo;
    }

    public void setPrevio(int previo) {
        this.previo = previo;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public void setIdLugarDelCuerpo(int idLugarDelCuerpo) {
        this.idLugarDelCuerpo = idLugarDelCuerpo;
    }

    public int getIdLugarDelCuerpo() {
        return idLugarDelCuerpo;
    }

    public Date getFechaEstudioResultado() {
        return fechaEstudioResultado;
    }

    public void setFechaEstudioResultado(Date fechaEstudioResultado) {
        this.fechaEstudioResultado = fechaEstudioResultado;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

}
