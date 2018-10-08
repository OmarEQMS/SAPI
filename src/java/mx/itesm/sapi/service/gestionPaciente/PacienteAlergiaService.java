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
public interface PacienteAlergiaService {
    public PacienteAlergia getPacienteAlergia(int idPacienteAlergia);
    public List<PacienteAlergia> getAllPacienteAlergia();
    public boolean savePacienteAlergia(PacienteAlergia pacienteAlergia);
    public boolean updatePacienteAlergia(PacienteAlergia pacienteAlergia);
    public boolean deletePacienteAlergia(int idPacienteAlergia);
}
