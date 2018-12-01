/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.moduloGestionMedico;

import java.util.List;
import mx.itesm.sapi.bean.moduloGestionMedico.Empleado;
import mx.itesm.sapi.bean.moduloGestionMedico.Identificadores;
import mx.itesm.sapi.bean.moduloGestionMedico.RestringirEmpleado;
import mx.itesm.sapi.bean.moduloGestionMedico.TablaAdministradorAdministrador;
import mx.itesm.sapi.bean.moduloGestionMedico.TablaMedicoAdministrador;

/**
 *
 * @author Fernanda Orduña & Pablo Lugo
 */
public interface EmpleadoServicio {
    public int agregarEmpleado(Empleado empleado);
    public Empleado mostrarEmpleado(int idEmpleado);
    public Empleado mostrarEmpleadoCuenta(int idCuenta);
    public List<Empleado> mostrarEmpleado();
    public boolean borradoLogicoEmpleado(int idEmpleado);
    public boolean actualizarEmpleado(Empleado empleado);
    public Identificadores restringirEmpleado(RestringirEmpleado restringirEmpleado);
    public List<TablaMedicoAdministrador> mostrarListaEmpleadosAdministrador(int idRol);
    public List<TablaAdministradorAdministrador> mostrarListaAdminAdministrador();
    public TablaMedicoAdministrador mostrarMedicoAdministrador(int idMedico,int idRol);
    public boolean existsNoEmpleado(String noEmpleado);
    public boolean existsNoEmpleado(String noEmpleado, int idEmpleado);
    public boolean relacionMedicoPaciente(int idEmpleado);
}
