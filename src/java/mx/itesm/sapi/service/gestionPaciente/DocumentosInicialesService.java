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
    public DocumentosIniciales mostrarDocumentosIniciales(int idDocumentosIniciales);
    public List<DocumentosIniciales> mostrarAllDocumentosIniciales();
    public boolean agregarDocumentosIniciales(DocumentosIniciales documentosIniciales);
    public boolean borradoLogicoDocumentosIniciales(int idDocumentosIniciales);
    public boolean actualizarDocumentosIniciales(DocumentosIniciales documentosIniciales);
}
