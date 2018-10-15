
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.moduloGestionMedico;

import java.util.List;
import mx.itesm.sapi.bean.moduloGestionMedico.EquipoEmpleado;
import mx.itesm.sapi.bean.moduloGestionMedico.MedicoEspecialidad;

/**
 *
 * @author feror
 */
public interface MedicoEspecialidadServicio {
    
    public int agregarMedicoEspecialidad(MedicoEspecialidad medicoEspecialidad);
    public MedicoEspecialidad mostrarMedicoEspecialidad(int idMedicoEspecialidad);
    public List<MedicoEspecialidad> mostrarMedicoEspecialidad();
    public boolean borradoLogicoMedicoEspecialidad(int idMedicoEspecialidad);
    public boolean actualizarMedicoEspecialidad(MedicoEspecialidad medicoEspecialidad);
    
}
