/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.persona;

import java.util.List;
import mx.itesm.sapi.bean.persona.TipoSangre;

/**
 *
 * @author Angel GTZ
 */
public interface TipoSangreServicio {
    public TipoSangre mostrarTipoDeSangre(int idTipoSangre);
    List<TipoSangre> mostrarTipoDeSangre();
    public int agregarTipoSangre(TipoSangre tipoDeSangre);
    public boolean actualizarTipoSangre(TipoSangre tipoSangre);
    public boolean borradoLogicoTipoSangre(int idTipoSangre);
    
}
