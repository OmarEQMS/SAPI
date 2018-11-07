/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.PacienteAlergia;

/**
 *
 * @author urieldiaz
 */
public interface PacienteAlergiaServicio {
    public PacienteAlergia mostrarPacienteAlergia(int idPacienteAlergia);
        public PacienteAlergia mostrarPacienteAlergiaIdPaciente(int idPaciente);
    public List<PacienteAlergia> mostrarPacienteAlergia();
    public int agregarPacienteAlergia(PacienteAlergia pacienteAlergia);
    public boolean actualizarPacienteAlergia(PacienteAlergia pacienteAlergia);
    public boolean borradoLogicoPacienteAlergia(int idPacienteAlergia);
}
