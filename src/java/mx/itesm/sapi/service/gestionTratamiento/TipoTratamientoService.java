/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionTratamiento;

import java.util.List;
import mx.itesm.sapi.bean.gestionTratamiento.PacienteTratamientoPrevio;
import mx.itesm.sapi.bean.gestionTratamiento.TipoTratamiento;

/**
 *
 * @author Admin
 */
public interface TipoTratamientoService {
    
    public int agregarTipoTratamiento(TipoTratamiento tipoTratamiento); //
    public TipoTratamiento mostrarTipoTratamiento(int idTipoTratamiento);
    public List<TipoTratamiento> mostrarTipoTratamiento();
    public boolean actualizarTipoTratamiento(TipoTratamiento tipoTratamiento);
    public boolean borradoLogicoTipoTratamiento(int idTipoTratamiento);
    public List<TipoTratamiento> mostrarTratamientoCirugia();
    
}
