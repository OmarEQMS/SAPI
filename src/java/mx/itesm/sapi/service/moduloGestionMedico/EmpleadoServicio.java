/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.moduloGestionMedico;

import java.util.List;
import mx.itesm.sapi.bean.moduloGestionMedico.Empleado;

/**
 *
 * @author feror
 */
public interface EmpleadoServicio {
    public int agregarEmpleado(Empleado empleado);
    public Empleado mostrarEmpleado(int idEmpleado);
    public List<Empleado> mostrarEmpleado();
    public boolean borradoLogicoEmpleado(int idEmpleado);
    public boolean actualizarEmpleado(Empleado empleado);
}
