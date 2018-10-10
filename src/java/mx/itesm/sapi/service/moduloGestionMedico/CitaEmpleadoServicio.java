/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.moduloGestionMedico;

import java.util.List;
import mx.itesm.sapi.bean.moduloGestionMedico.CitaEmpleado;

/**
 *
 * @author feror
 */
public interface CitaEmpleadoServicio {

    public int agregarCitaEmpleado(CitaEmpleado citaEmpleado);

    public CitaEmpleado mostrarCitaEmpleado(int idCitaEmpleado);

    public List<CitaEmpleado> mostrarCitasEmpleados();
    public boolean borradoLogicoCitaEmpleado(int idCitaEmpleado);

    public boolean actualizarCitaEmpleado(CitaEmpleado citaEmpelado);

}
