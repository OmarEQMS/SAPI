/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.EstadoPacientePaciente;

/**
 *
 * @author urieldiaz
 */
public interface EstadoPacientePacienteService {
    public EstadoPacientePaciente getEstadoPacientePaciente(int idEstadoPacientePaciente);
    public List<EstadoPacientePaciente> getAllEstadoPacientePaciente();
    public boolean saveEstadoPacientePaciente(EstadoPacientePaciente estadoPacientePaciente);
    public boolean deleteEstadoPacientePaciente(int idEstadoPacientePaciente);
    public boolean updateEstadoPacientePaciente(EstadoPacientePaciente EstadoPacientePaciente);
}
