/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.moduloGestionMedico;

import java.util.List;
import mx.itesm.sapi.bean.moduloGestionMedico.EquipoEmpleado;

/**
 *
 * @author feror
 */
public interface EquipoEmpleadoServicio {
    public int agregarEquipoEmpleado(EquipoEmpleado equipoEmpleado);
    public EquipoEmpleado mostrarEquipoEmpleado(int idEquipoEmpleado);
    public List<EquipoEmpleado> mostrarEquipoEmpleado();
    public boolean borradoLogicoEquipoEmpleado(int idEquipoEmpleado);
    public boolean actualizarEquipoEmpleado(EquipoEmpleado equipoEmpleado);
}
