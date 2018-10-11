/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.TipoDocumento;

/**
 *
 * @author urieldiaz
 */
public interface TipoDocumentoService {
    public TipoDocumento mostrarTipoDocumento(int idTipoDocumento);
    public List<TipoDocumento> mostrarAllTipoDocumento();
    public int agregarTipoDocumento(TipoDocumento tipoDocumento);
    public boolean actualizarTipoDocumento(TipoDocumento tipoDocumento);
    public boolean borradoLogicoTipoDocumento(int idTipoDocumento);
}
