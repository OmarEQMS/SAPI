/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.PacienteMedicoTitular;

/**
 *
 * @author Angel Gutierrez
 */
public interface PacienteMedicoTitularServicio {

    public PacienteMedicoTitular mostrarPacienteMedicoTitular(int idPacienteAlergia);

    public PacienteMedicoTitular mostrarPacienteMedicoTitularIdPaciente(int idPaciente);

    public List<PacienteMedicoTitular> mostrarPacienteMedicoTitular();

    public int agregarPacienteMedicoTitular(PacienteMedicoTitular pacienteMedicoTitular);

    public boolean actualizarPacienteMedicoTitular(PacienteMedicoTitular pacienteMedicoTitular);

    public boolean borradoLogicoPacienteMedicoTitular(int idPacienteMedicoTitular);

    public PacienteMedicoTitular mostrarPacienteMedicoTitularIdPacientePosicion(int idPaciente, int idPosicion);

}
