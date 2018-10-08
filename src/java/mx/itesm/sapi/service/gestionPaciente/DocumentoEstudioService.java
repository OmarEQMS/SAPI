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
    public DocumentoEstudio getDocumentoEstudio(int idDocumentoEstudio);
    public List<DocumentoEstudio> getAllDocumentoEstudio();
    public boolean saveDocumentoEstudio(DocumentoEstudio documentoEstudio);
    public boolean deleteDocumentoEstudio(int idDocumentoEstudio);
    public boolean updateDocumentoEstudio(DocumentoEstudio documentoEstudio);
    
}
