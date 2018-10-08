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
 * @author urieldiaz
 */
public interface EstadoPacienteService {
    public List<EstadoPaciente> getAllEstadoPaciente();
    public boolean saveEstadoPaciente(EstadoPaciente estadoPaciente);
    public boolean deleteEstadoPaciente(int idEstadoPaciente);
    public boolean updateEstadoPaciente(EstadoPaciente estadoPaciente);
}
