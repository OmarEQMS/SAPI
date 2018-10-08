/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.PacienteNavegadora;

/**
 *
 * @author urieldiaz
 */
public interface PacienteNavegadoraService {
    public PacienteNavegadora mostrarPacienteNavegadora(int idPacienteNavegadora);
    public List<PacienteNavegadora> mostrarAllPacienteNavegadora();
    public boolean agregarPacienteNavegadora(PacienteNavegadora pacienteNavegadora);
    public boolean actualizarPacienteNavegadora(PacienteNavegadora pacienteNavegadora);
    public boolean borrarPacienteNavegadora(int idPacienteNavegadora);
}
