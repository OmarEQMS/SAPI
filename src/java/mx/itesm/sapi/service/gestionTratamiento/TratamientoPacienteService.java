/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionTratamiento;

import java.util.List;
import mx.itesm.sapi.bean.gestionTratamiento.TratamientoPaciente;

/**
 *
 * @author Admin
 */
public interface TratamientoPacienteService {

    public int agregarTratamientoPaciente(TratamientoPaciente tratamientoPaciente);

    public TratamientoPaciente mostrarTratamientoPaciente(int idTratamientoPaciente);

    public TratamientoPaciente mostrarTratamientoPacienteIdPaciente(int idPaciente);

    public List<TratamientoPaciente> mostrarTratamientoPaciente();

    public List<TratamientoPaciente> mostrarTratamientoPacienteIdEspecifico(int idPaciente);

    public boolean actualizarTratamientoPaciente(TratamientoPaciente tratamientoPaciente);

    public boolean borradoLogicoTratamientoPaciente(int idTratamientoPaciente);
}
