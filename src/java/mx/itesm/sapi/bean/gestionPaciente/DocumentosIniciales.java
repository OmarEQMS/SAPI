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
import java.io.InputStream;
import javafx.scene.text.Text;
public class DocumentosIniciales {

    private int idDocumentosIniciales;
    private int idTipoDocumento;
    private int idPaciente;
    private byte[] archivo;
    private String comentario;
    private int aprobado;
    private int estatus;
    
    public DocumentosIniciales() {}
    
    
    @Override
    public String toString(){
        String str ="DocumentosIniciales [idDocumentosIniciales:".concat(String.valueOf(idDocumentosIniciales))
                .concat(",idTipoDocumento").concat(String.valueOf(idTipoDocumento))
                .concat(",idPaciente:").concat(String.valueOf(idPaciente))
                .concat(",archivo:").concat(String.valueOf(archivo))
                .concat(",comentario:").concat(comentario)
                .concat(",aprobado:").concat(String.valueOf(aprobado))
                .concat(",estatus:").concat(String.valueOf(estatus))
                .concat("]");
        
        return str;
    }

    public int getIdDocumentosIniciales() {
        return idDocumentosIniciales;
    }

    public void setIdDocumentosIniciales(int idDocumentosIniciales) {
        this.idDocumentosIniciales = idDocumentosIniciales;
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

    public byte[] getArchivo() {
        return archivo;
    }

    public void setArchivo(byte[] archivo) {
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
