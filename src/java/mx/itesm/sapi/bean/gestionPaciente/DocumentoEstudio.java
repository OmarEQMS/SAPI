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
public class DocumentoEstudio {

    private int idDocumentoEstudio;
    private int idEstadoEstudio;
    private int idAtencion;
    private int idTipoEstudio;
    private int idBirads;
    private byte[] archivo;
    private int previo;
    private int estatus;
    private Timestamp fechaEstudioPrevio;

    public DocumentoEstudio() {}

    @Override
    public String toString(){
    	String str="DocumentoEstudio [idDocumentoEstudio:".concat(String.valueOf(idDocumentoEstudio))
    		.concat("idEstadoEstudio:").concat(String.valueOf(idEstadoEstudio))
    		.concat("idAtencion:").concat(String.valueOf(idAtencion))
    		.concat("idTipoEstudio:").concat(String.valueOf(idTipoEstudio))
    		.concat("idBirads:").concat(String.valueOf(idBirads))
    		.concat("archivo:").concat(String.valueOf(archivo))
    		.concat("previo:").concat(String.valueOf(previo))
    		.concat("estatus:").concat(String.valueOf(estatus))
                .concat(",fechaEstudioPrecio:").concat(String.valueOf(fechaEstudioPrevio))
    		.concat("]");

    	return str;
        
    }

    public Timestamp getFechaEstudioPrevio() {
        return fechaEstudioPrevio;
    }

    public void setFechaEstudioPrevio(Timestamp fechaEstudioPrevio) {
        this.fechaEstudioPrevio = fechaEstudioPrevio;
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

    public int getIdAtencion() {
        return idAtencion;
    }

    public void setIdAtencion(int idAtencion) {
        this.idAtencion = idAtencion;
    }

    public int getIdTipoEstudio() {
        return idTipoEstudio;
    }

    public void setIdTipoEstudio(int idTipoEstudio) {
        this.idTipoEstudio = idTipoEstudio;
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
    

}
