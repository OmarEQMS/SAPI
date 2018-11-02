/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.gestionPaciente;
import java.io.InputStream;
/**
 *
 * @author Alex
 */
public class DocumentoInicial {

    private int idDocumentoInicial;
    private int idTipoDocumento;
    private int idPaciente;
    private InputStream archivo;
    private String comentario;
    private int aprobado;    
    private String tipo;
    private int tamano;
    private int estatus;
    private String nombre;
    
    public DocumentoInicial() {}
    
    
    @Override
    public String toString(){
        String str ="DocumentoInicial [idDocumentoInicial:".concat(String.valueOf(idDocumentoInicial))
                .concat(",idTipoDocumento").concat(String.valueOf(idTipoDocumento))
                .concat(",idPaciente:").concat(String.valueOf(idPaciente))
                .concat(",archivo:").concat(String.valueOf(archivo))
                .concat(",comentario:").concat(comentario)
                .concat(",aprobado:").concat(String.valueOf(aprobado))
                .concat(",estatus:").concat(String.valueOf(estatus))
                .concat(",tamano:").concat(String.valueOf(tamano))
                .concat(",tipo:").concat(String.valueOf(tipo))
                .concat(",nombre:".concat(nombre))
                .concat("]");
        
        return str;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    
    public int getIdDocumentoInicial() {
        return idDocumentoInicial;
    }

    public void setIdDocumentoInicial(int idDocumentoInicial) {
        this.idDocumentoInicial = idDocumentoInicial;
    }

    public int getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(int idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public InputStream getArchivo() {
        return archivo;
    }

    public void setArchivo(InputStream archivo) {
        this.archivo = archivo;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getAprobado() {
        return aprobado;
    }

    public void setAprobado(int aprobado) {
        this.aprobado = aprobado;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }
    
    
    
}
