/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionTratamiento;

import java.util.List;
import mx.itesm.sapi.bean.gestionTratamiento.Tratamiento;

/**
 *
 * @author Admin
 */
public interface TratamientoService {
    
    public Tratamiento mostrarTratamiento(int idTratamiento);
    public List<Tratamiento> mostrarTratamiento();
    
}
