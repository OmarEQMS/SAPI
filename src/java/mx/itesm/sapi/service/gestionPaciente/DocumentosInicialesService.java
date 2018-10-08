/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.DocumentosIniciales;

/**
 *
 * @author urieldiaz
 */
public interface DocumentosInicialesService {
    public DocumentosIniciales getDocumentosIniciales(int idDocumentosIniciales);
    public List<DocumentosIniciales> getAllDocumentosIniciales();
    public boolean saveDocumentosIniciales(DocumentosIniciales documentosIniciales);
    public boolean deleteDocumentosIniciales(int idDocumentosIniciales);
    public boolean updateDocumentosIniciales(DocumentosIniciales documentosIniciales);
}
