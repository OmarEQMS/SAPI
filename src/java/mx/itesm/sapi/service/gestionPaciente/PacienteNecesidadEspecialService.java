/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.PacienteNecesidadEspecial;
/**
 *
 * @author urieldiaz
 */
public interface PacienteNecesidadEspecialService {
    public PacienteNecesidadEspecial getPacienteNecesidadEspecial(int idPacienteNecesidadEspecial);
    public List<PacienteNecesidadEspecial> getAllPacienteNecesidadEspecial();
    public boolean savePacienteNecesidadEspecial(PacienteNecesidadEspecial pacienteNecesidadEspecial);
    public boolean deletePacienteNecesidadEspecial(int idPacienteNecesidadEspecial);
    public boolean updatePacienteNecesidadEspecial(PacienteNecesidadEspecial pacienteNecesidadEspecial);
}
