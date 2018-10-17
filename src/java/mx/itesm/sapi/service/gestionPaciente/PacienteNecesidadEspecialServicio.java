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
public interface PacienteNecesidadEspecialServicio {
    public PacienteNecesidadEspecial mostrarPacienteNecesidadEspecial(int idPacienteNecesidadEspecial);
    public List<PacienteNecesidadEspecial> mostrarPacienteNecesidadEspecial();
    public int agregarPacienteNecesidadEspecial(PacienteNecesidadEspecial pacienteNecesidadEspecial);
    public boolean borradoLogicoPacienteNecesidadEspecial(int idPacienteNecesidadEspecial);
    public boolean actualizarPacienteNecesidadEspecial(PacienteNecesidadEspecial pacienteNecesidadEspecial);
}
