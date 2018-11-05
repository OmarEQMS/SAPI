/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.DocumentoEstudio;

/**
 *
 * @author Oscar Miranda
 */
public interface DocumentoEstudioServicio {

    public DocumentoEstudio mostrarDocumentoEstudio(int idDocumentoEstudio);

    public DocumentoEstudio mostrarDocumentoEstudioIdPaciente(int idPaciente);

    public List<DocumentoEstudio> mostrarDocumentoEstudio();

    public List<DocumentoEstudio> mostrarDocumentoEstudioIdEspecifico(int idPaciente);

    public int agregarDocumentoEstudio(DocumentoEstudio documentoEstudio);

    public boolean borradoLogicoDocumentoEstudio(int idDocumentoEstudio);

    public boolean actualizarDocumentoEstudio(DocumentoEstudio documentoEstudio);

}
