/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import mx.itesm.sapi.bean.formulario.ReporteNavegadora;
import mx.itesm.sapi.bean.gestionPaciente.EstadoPacientePaciente;
import mx.itesm.sapi.bean.persona.Estado;
import mx.itesm.sapi.bean.persona.Municipio;
import mx.itesm.sapi.bean.persona.Sexo;
import mx.itesm.sapi.service.gestionPaciente.EstadoPacientePacienteServiceImpl;
import mx.itesm.sapi.service.moduloGestionMedico.EmpleadoServicioImpl;
import mx.itesm.sapi.service.persona.EstadoServicioImpl;
import mx.itesm.sapi.service.persona.MunicipioServicioImpl;
import mx.itesm.sapi.service.persona.SexoServiciosImpl;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Oscar Miranda
 */
public class ReporteNavegadoraServicioImpl implements ReporteNavegadoraServicio{

    @Override
    public ReporteNavegadora mostrarReporteNavegadora(int idPaciente, int idEmpleado, int idRol) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure1 = "CALL mostrarFormularioNavegadora(?)";
        String stProcedure2 = "CALL mostrarPaciente(?)";
        
        ReporteNavegadora reporteNavegadora = null;
        Sexo sexo = null;
        Municipio municipio = null;
        Estado estado = null;
        SexoServiciosImpl sexoServicioImpl = new SexoServiciosImpl();
        MunicipioServicioImpl municipioServicioImpl = new MunicipioServicioImpl();
        EstadoServicioImpl estadoServicioImpl = new EstadoServicioImpl();
        EmpleadoServicioImpl empleadoServicioImpl = new EmpleadoServicioImpl();
        //TablaMedicoAdministrado tablaMedicoAdministrador = new TablaMedicoAdministrador();
        EstadoPacientePaciente estadoPacientePaciente = new EstadoPacientePaciente();
        EstadoPacientePacienteServiceImpl estadoPacientePacienteServicioImpl = new EstadoPacientePacienteServiceImpl();
        
        try{
            conn = Conexion.getConnection();
            reporteNavegadora = new ReporteNavegadora();
            cstmt = conn.prepareCall(stProcedure1);
            cstmt.setInt(1, idPaciente);
            
            rs = cstmt.executeQuery();
            rs.next();
            
            reporteNavegadora.setPrz(rs.getString("v_PRZ"));
            reporteNavegadora.setFechaNavegacion(rs.getDate("v_fechaNavegacion"));
            reporteNavegadora.setFechaConsulta(rs.getDate("v_fechaConsulta"));
            reporteNavegadora.setTipoPaciente(rs.getString("v_tipoPaciente"));
            reporteNavegadora.setMedicoAdscrito(rs.getString("v_medicoAdsctio"));
            reporteNavegadora.setMedicoRadiologo(rs.getString("v_medicoRadiologo"));
            reporteNavegadora.setMedicoResidente(rs.getString("v_medicoResidente"));
            reporteNavegadora.setNoAdscrito(rs.getBoolean("v_noAdscrito"));
            reporteNavegadora.setNoRadiologo(rs.getBoolean("v_noRadiologo"));
            reporteNavegadora.setEscolaridad(rs.getString("v_escolaridad"));
            reporteNavegadora.setAlergias(rs.getString("v_alergias"));
            reporteNavegadora.setEstadoHormonal(rs.getBoolean("v_estadoHormonal"));
            reporteNavegadora.setSeguro(rs.getString("v_tipoSeguro"));
            reporteNavegadora.setNoSeguro(rs.getString("v_numeroSeguro"));
            reporteNavegadora.setMastografiaPreINCAN(rs.getBoolean("v_mastografiaPreINCAN"));
            reporteNavegadora.setCirugiaFecha(rs.getDate("v_cirugiaFecha"));
            reporteNavegadora.setCirugiaTipo(rs.getString("v_cirugiaTipo"));
            reporteNavegadora.setCirugiaComentario(rs.getString("v_cirugiaComentario"));
            reporteNavegadora.setQuimioterapiaFecha(rs.getDate("v_quimioterapiaFecha"));
            reporteNavegadora.setQuimioterapiaCiclo(rs.getInt("v_quimioterapiaCiclo"));
            reporteNavegadora.setQuimioterapiaComentario(rs.getString("v_quimioterapiaComentario"));
            reporteNavegadora.setRadioterapiaFecha(rs.getDate("v_radioterapiaFecha"));
            reporteNavegadora.setRadioterapiaCiclo(rs.getInt("v_radioterapiaCiclo"));
            reporteNavegadora.setRadioterapiaComentario(rs.getString("v_radioterapiaComentario"));
            reporteNavegadora.setMastografiaBiradsNombre(rs.getInt("v_mastografiaBiradsNombre"));
            reporteNavegadora.setMastografiaBiradsFecha(rs.getDate("v_mastografiaBiradsFecha"));
            reporteNavegadora.setUltrasonidoBiradsNombre(rs.getInt("v_ultrasonidoBiradsNombre"));
            reporteNavegadora.setUltrasonidoBiradsFecha(rs.getDate("v_ultrasonidoBiradsFecha"));
            reporteNavegadora.setResultadoPatologia(rs.getString("v_resultadoPatologia"));
            reporteNavegadora.setOtroResultado(rs.getString("v_otroResultado"));
            reporteNavegadora.setSerieParafina(rs.getString("v_serieParafina"));
            reporteNavegadora.setCantidadParafina(rs.getInt("v_cantidadParafina"));
            reporteNavegadora.setSerieLaminillas(rs.getString("v_serieLaminillas"));
            reporteNavegadora.setCantidadLaminillas(rs.getInt("v_cantidadLaminillas"));
            reporteNavegadora.setFechaDecision(String.valueOf(rs.getDate("v_fechaFin")));
            reporteNavegadora.setDecisionCosulta(rs.getString("v_decisionCosulta"));
            reporteNavegadora.setSocioeconomico(rs.getString("v_socioeconomico"));
            reporteNavegadora.setComentarioLLamada(rs.getString("v_comentarioLLamada"));
            reporteNavegadora.setFechaLlamada(rs.getDate("v_fechaLlamada"));
            reporteNavegadora.setComentarioIncidencia(rs.getString("v_comentarioIncidencia"));
            reporteNavegadora.setComentarioMedico(rs.getString("v_comentarioMedico"));
            
            sexo = new Sexo();
            municipio = new Municipio();
            estado = new Estado();
            
            cstmt = conn.prepareCall(stProcedure2);
            cstmt.setInt(1, idPaciente);
            
            rs = cstmt.executeQuery();
            rs.next();
            
            sexo = sexoServicioImpl.mostrarSexo(rs.getInt("idSexo"));
            municipio = municipioServicioImpl.mostrarMunicipio(rs.getInt("idMunicipio"));
            estado = estadoServicioImpl.mostrarEstado(rs.getInt("idEstado"));
            //tablaMedicoAdministrador = empleadoServicioImpl.mostrarMedicoAdministrador(int idEmpleado, int idRol);
            estadoPacientePaciente = estadoPacientePacienteServicioImpl.mostrarEstadoPacientePacienteIdPaciente(idPaciente);
            
            
            reporteNavegadora.setNombre(rs.getString("nombre"));
            reporteNavegadora.setEdad(String.valueOf(rs.getInt("edad")));
            reporteNavegadora.setFechaNacimiento(String.valueOf(rs.getDate("fechaNacimiento")));
            reporteNavegadora.setGenero(sexo.getNombre());
            reporteNavegadora.setCiudad(municipio.getNombre());
            reporteNavegadora.setEstado(estado.getNombre());
            reporteNavegadora.setTelefono(rs.getString("telefono"));
            //reporteNavegadora.setNavegadora(tablaMedicoAdministrador.getNombre());
            if(estadoPacientePaciente.getResultados() == 0)
                reporteNavegadora.setResultado("Sí");
            else
                reporteNavegadora.setResultado("No");
                    
            rs.close();
            cstmt.close();
            conn.close();
        }catch(SQLException ex)
        {
             System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
             reporteNavegadora = null;
        }
        return reporteNavegadora;
    }
    
}
