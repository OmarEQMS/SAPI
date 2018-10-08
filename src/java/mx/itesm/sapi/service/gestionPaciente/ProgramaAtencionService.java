/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.ProgramaAtencion;

/**
 *
 * @author urieldiaz
 */
public interface ProgramaAtencionService {
    public ProgramaAtencion mostrarProgramaAtencion(int idProgramaAtencion);
    public List<ProgramaAtencion> mostrarAllProgramaAtencion();
    public boolean agregarProgramaAtencion(ProgramaAtencion programaAtencion);
    public boolean borrarProgramaAtencion(int idProgramaAtencion);
    public boolean actualizarProgramaAtencion(ProgramaAtencion programaAtencion);
}
