/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.DocumentoInicial;

/**
 *
 * @author urieldiaz
 */
public interface DocumentosInicialesService {
    public DocumentoInicial mostrarDocumentosIniciales(int idDocumentosIniciales);
    public List<DocumentoInicial> mostrarAllDocumentosIniciales();
    public boolean agregarDocumentosIniciales(DocumentoInicial documentosIniciales);
    public boolean borradoLogicoDocumentosIniciales(int idDocumentosIniciales);
    public boolean actualizarDocumentosIniciales(DocumentoInicial documentosIniciales);
}
