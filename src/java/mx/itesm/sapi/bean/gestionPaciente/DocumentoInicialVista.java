/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.gestionPaciente;

import java.io.InputStream;

/**
 *
 * @author urieldiaz
 */
public class DocumentoInicialVista {
    private int idDocumentoInicial;
    private String tipoDocumento;
    private String tipoArchivo;
    private String nombreDocumento;
    private InputStream archivo;
    private int aprobado;

    public DocumentoInicialVista() {
    }

    @Override
    public String toString() {
        return "DocumentoInicialVista{" + "idDocumentoInicial=" + idDocumentoInicial + ", tipoDocumento=" + tipoDocumento + ", tipoArchivo=" + tipoArchivo + ", nombreDocumento=" + nombreDocumento + ", aprobado=" + aprobado + '}';
    }

    public int getIdDocumentoInicial() {
        return idDocumentoInicial;
    }

    public void setIdDocumentoInicial(int idDocumentoInicial) {
        this.idDocumentoInicial = idDocumentoInicial;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getTipoArchivo() {
        return tipoArchivo;
    }

    public void setTipoArchivo(String tipoArchivo) {
        this.tipoArchivo = tipoArchivo;
    }

    public String getNombreDocumento() {
        return nombreDocumento;
    }

    public void setNombreDocumento(String nombreDocumento) {
        this.nombreDocumento = nombreDocumento;
    }

    public InputStream getArchivo() {
        return archivo;
    }

    public void setArchivo(InputStream archivo) {
        this.archivo = archivo;
    }

    public int getAprobado() {
        return aprobado;
    }

    public void setAprobado(int aprobado) {
        this.aprobado = aprobado;
    }
    
    
    
    
}
