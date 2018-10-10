/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.moduloGestionMedico;

import java.util.List;
import mx.itesm.sapi.bean.moduloGestionMedico.EmpleadoPosicion;



/**
 *
 * @author feror
 */
public interface EmpleadoPosicionServicio {
    
    public EmpleadoPosicion mostrarEmpleadoPosicion(int idEmpleadoPosicion);
    public List<EmpleadoPosicion> mostrarEmpleadoPosicion();
    public int agregarEmpleadoPosicion(EmpleadoPosicion empleadoPosicion);
    public boolean borradoLogicoEmpleadoPosicion(int idEmpleadoPosicion);
    public boolean actualizarEmpleadoPosicion(EmpleadoPosicion empleadoPosicion);
    
}
