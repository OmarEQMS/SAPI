/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service;

import java.util.List;
import mx.itesm.sapi.bean.Empleado;

/**
 *
 * @author Admin
 */
public interface EmpleadoServicio {
 
    public Empleado getEmpleado(int idEmpleado);
    public List<Empleado> getEmpleados();
    public int saveEmpleado(Empleado empleado);
    public boolean deleteEmpleado(int idEmpleado);
    public boolean updateEmpleado(Empleado empelado);
    
}
