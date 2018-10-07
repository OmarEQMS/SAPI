/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.diagnostico;

import java.util.List;
import mx.itesm.sapi.bean.diagnostico.NCodificado;

/**
 *
 * @author Diego
 */
public interface NCodificadoService {
    public NCodificado getNCodificado(int idNCodificado);
    List<NCodificado> getNCodificado();
    public boolean agregarNCodificado(NCodificado nCodificado);
    public boolean actualizarNCodificado(int idNCodificado);
    public boolean borradoLogicoNCodificado(int idNCodificado);
}
