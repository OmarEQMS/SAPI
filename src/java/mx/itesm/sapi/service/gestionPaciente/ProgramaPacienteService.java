/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.sql.Connection;
import java.util.List;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.itesm.sapi.util.Conexion;
import mx.itesm.sapi.bean.gestionPaciente.ProgramaPaciente;

/**
 *
 * @author urieldiaz
 */
public interface ProgramaPacienteService {

    public ProgramaPaciente mostrarProgramaPaciente(int idProgramaAtencion);
    public List<ProgramaPaciente> mostrarProgramaPaciente();
    public int agregarProgramaPaciente(ProgramaPaciente programaAtencion);
    public boolean borradoLogicoProgramaPaciente(int idProgramaAtencion);
    public boolean actualizarProgramaPaciente(ProgramaPaciente programaAtencion);
}
