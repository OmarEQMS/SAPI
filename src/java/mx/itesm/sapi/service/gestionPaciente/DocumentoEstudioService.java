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
 * @author urieldiaz
 */
public interface DocumentoEstudioService {
    public DocumentoEstudio mostrarDocumentoEstudio(int idDocumentoEstudio);
    public List<DocumentoEstudio> mostrarAllDocumentoEstudio();
    public boolean agregarDocumentoEstudio(DocumentoEstudio documentoEstudio);
    public boolean borrarDocumentoEstudio(int idDocumentoEstudio);
    public boolean actualizarDocumentoEstudio(DocumentoEstudio documentoEstudio);
    
}
