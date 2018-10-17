/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionTratamiento;

import java.util.List;
import mx.itesm.sapi.bean.gestionTratamiento.FarmacoTipoTratamiento;

/**
 *
 * @author Admin
 */
public interface FarmacoTipoTratamientoService {
    
    public int agregarFarmacoTipoTratamiento(FarmacoTipoTratamiento farmacoTipoTratamiento); //
    public FarmacoTipoTratamiento mostrarFarmacoTipoTratamiento(int idFarmacoTipoTratamiento);
    public List<FarmacoTipoTratamiento> mostrarFarmacoTipoTratamiento();
    public boolean actualizarFarmacoTipoTratamiento(FarmacoTipoTratamiento farmacoTipoTratamiento);
    public boolean borradoLogicoFarmacoTipoTratamiento(int idFarmacoTipoTratamiento);
}
