/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.EstadoPaciente;

/**
 *
 * @author Uriel Díaz
 */
public interface EstadoPacienteServicio {
    public EstadoPaciente mostrarEstadoPaciente(int idEstadoPaciente);
    public List<EstadoPaciente> mostrarEstadoPaciente();
    public int agregarEstadoPaciente(EstadoPaciente estadoPaciente);
    public boolean borradoLogicoEstadoPaciente(int idEstadoPaciente);
    public boolean actualizarEstadoPaciente(EstadoPaciente estadoPaciente);
}
