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
 * @author Diego Montoya
 */
public interface MCodificadoService {
    public MCodificado mostrarMCodificado(int idMCodificado);
    List<MCodificado> mostrarMCodificado();
}
