/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionTratamiento;

import java.util.List;
import mx.itesm.sapi.bean.gestionTratamiento.UnionTratamientoPaciente;

/**
 *
 * @author feror
 */
public interface UnionTratamientoPacienteService {

    public List<UnionTratamientoPaciente> mostrarUnionTratamientoPaciente(int idPaciente);

}
