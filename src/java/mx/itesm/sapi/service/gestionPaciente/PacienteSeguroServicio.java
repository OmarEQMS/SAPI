/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.PacienteSeguro;
/**
 *
 * @author Alex
 */
public interface PacienteSeguroServicio {
    public PacienteSeguro mostrarPacienteSeguro(int idPacienteSeguro);
    public List<PacienteSeguro> mostrarPacienteSeguro();
    public int agregarPacienteSeguro(PacienteSeguro pacienteSeguro);
    public boolean actualizarPacienteSeguro(PacienteSeguro ppacienteSeguroiso);
    public boolean borradoLogicoPacienteSeguro(int idPacienteSeguro);
}
