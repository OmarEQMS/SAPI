/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.diagnostico;

import java.util.List;
import mx.itesm.sapi.bean.diagnostico.MCodificado;

/**
 *
 * @author Diego
 */
public interface MCodificadoService {
    public MCodificado getMCodificado(int idMCodificado);
    List<MCodificado> getMCodificado();
    public boolean agregarMCodificado(MCodificado mCodificado);
    public boolean actualizarMCodificado(int idMCodificado);
    public boolean borradoLogicoMCodificado(int idMCodificado);
}
