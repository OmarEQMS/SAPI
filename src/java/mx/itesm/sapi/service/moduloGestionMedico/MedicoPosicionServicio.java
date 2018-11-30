/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.moduloGestionMedico;

import java.util.List;
import mx.itesm.sapi.bean.moduloGestionMedico.MedicoPosicion;

/**
 *
 * @author shannonrosas
 */
public interface MedicoPosicionServicio {
    
    public int agregarMedicoPosicion(MedicoPosicion medicoPosicion);
    public MedicoPosicion mostrarMedicoPosicion(int idMedicoPosicion);
    public MedicoPosicion mostrarMedicoPosicionEmpleado(int idEmpleado);
    public List<MedicoPosicion> mostrarMedicoPosicion();
    public boolean borradoLogicoMedicoPosicion(int idMedicoPosicion);
    public boolean actualizarMedicoPosicion(MedicoPosicion medicoPosicion);
    
}
