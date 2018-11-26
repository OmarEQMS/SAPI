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
        String stProcedure2 = "CALL mostrarPacienteCiudadEstadoSexo(?)";
        
        ReporteNavegadora reporteNavegadora = new ReporteNavegadora();
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
            reporteNavegadora.setFechaNavegacion(String.valueOf(rs.getDate("v_fechaNavegacion")));
            reporteNavegadora.setFechaConsulta(String.valueOf(rs.getDate("v_fechaConsulta")));
            if(rs.getInt("v_tipoPaciente")==0){
                reporteNavegadora.setTipoPaciente("Primera vez");
            }else{
                reporteNavegadora.setTipoPaciente("Segunda Opinion");
            }
            reporteNavegadora.setMedicoAdscrito(rs.getString("v_medicoAdsctio"));
            reporteNavegadora.setMedicoRadiologo(rs.getString("v_medicoRadiologo"));
            reporteNavegadora.setMedicoResidente(rs.getString("v_medicoResidente"));
            reporteNavegadora.setNoAdscrito(String.valueOf(rs.getBoolean("v_noAdscrito")));
            reporteNavegadora.setNoRadiologo(String.valueOf(rs.getBoolean("v_noRadiologo")));
            reporteNavegadora.setEscolaridad(rs.getString("v_escolaridad"));
            reporteNavegadora.setAlergias(rs.getString("v_alergias"));
            
            if(rs.getInt("v_estadoHormonal")==2){
                System.out.println("estado hormaonal = 2 ");
                reporteNavegadora.setEstadoHormonal("PosMenopaucia");
            }else{
                reporteNavegadora.setEstadoHormonal("PreMenopaucia");
                System.out.println("estado hormaonal = 1 ");
            }
            reporteNavegadora.setSeguro(rs.getString("v_tipoSeguro"));
            reporteNavegadora.setNoSeguro(rs.getString("v_numeroSeguro"));
            reporteNavegadora.setMastografiaPreINCAN(String.valueOf(rs.getBoolean("v_mastografiaPreINCAN")));
            reporteNavegadora.setCirugiaFecha(String.valueOf(rs.getDate("v_cirugiaFecha")));
            reporteNavegadora.setCirugiaTipo(rs.getString("v_cirugiaTipo"));
            reporteNavegadora.setCirugiaComentario(rs.getString("v_cirugiaComentario"));
            reporteNavegadora.setQuimioterapiaFecha(String.valueOf(rs.getDate("v_quimioterapiaFecha")));
            reporteNavegadora.setQuimioterapiaCiclo(String.valueOf(rs.getInt("v_quimioterapiaCiclo")));
            reporteNavegadora.setQuimioterapiaComentario(rs.getString("v_quimioterapiaComentario"));
            reporteNavegadora.setRadioterapiaFecha(String.valueOf(rs.getDate("v_radioterapiaFecha")));
            reporteNavegadora.setRadioterapiaCiclo(String.valueOf(rs.getInt("v_radioterapiaCiclo")));
            reporteNavegadora.setRadioterapiaComentario(rs.getString("v_radioterapiaComentario"));
            reporteNavegadora.setMastografiaBiradsNombre(rs.getString("v_mastografiaBiradsNombre"));
            reporteNavegadora.setMastografiaBiradsFecha(String.valueOf(rs.getDate("v_mastografiaBiradsFecha")));
            reporteNavegadora.setUltrasonidoBiradsNombre(rs.getString("v_ultrasonidoBiradsNombre"));
            reporteNavegadora.setUltrasonidoBiradsFecha(String.valueOf(rs.getDate("v_ultrasonidoBiradsFecha")));
            reporteNavegadora.setResultadoPatologia(rs.getString("v_resultadoPatologia"));
            reporteNavegadora.setOtroResultado(rs.getString("v_otroResultado"));
            reporteNavegadora.setSerieParafina(rs.getString("v_serieParafina"));
            reporteNavegadora.setCantidadParafina(String.valueOf(rs.getInt("v_cantidadParafina")));
            reporteNavegadora.setSerieLaminillas(rs.getString("v_serieLaminillas"));
            reporteNavegadora.setCantidadLaminillas(String.valueOf(rs.getInt("v_cantidadLaminillas")));
            reporteNavegadora.setFechaFin(String.valueOf(rs.getDate("v_fechaFin")));
            reporteNavegadora.setDecisionCosulta(rs.getString("v_decisionCosulta"));
            reporteNavegadora.setSocioeconomico(rs.getString("v_socioeconomico"));
            reporteNavegadora.setComentarioIncidencia(rs.getString("v_comentarioIncidencia"));
            reporteNavegadora.setComentarioMedico(rs.getString("v_comentarioMedico"));
            reporteNavegadora.setT(rs.getString("v_T"));
            reporteNavegadora.setN(rs.getString("v_N"));
            reporteNavegadora.setM(rs.getString("v_M"));
            reporteNavegadora.setEtapaClinica(rs.getString("v_etapaClinica"));
            reporteNavegadora.setUltra(rs.getString("v_ultra"));         
            reporteNavegadora.setMasto(rs.getString("v_masto"));
            reporteNavegadora.setHer2(rs.getString("v_her2"));
            reporteNavegadora.setRp(rs.getString("v_rp"));
            reporteNavegadora.setRe(rs.getString("v_re"));
            reporteNavegadora.setFish(rs.getString("v_fish"));
            reporteNavegadora.setKi67(rs.getString("v_ki67"));
            reporteNavegadora.setGradoH(rs.getString("v_gradoH"));
            reporteNavegadora.setResultadoPatologiaPost(rs.getString("v_resultadoPatologiaPost"));
            
            sexo = new Sexo();
            municipio = new Municipio();
            estado = new Estado();
            
            cstmt = conn.prepareCall(stProcedure2);
            cstmt.setInt(1, idPaciente);
            
            rs = cstmt.executeQuery();
            rs.next();
            /*
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
            reporteNavegadora.setNavegadora("Navegadora");//dato de prueba
            if(estadoPacientePaciente.getResultados() == 0)
                reporteNavegadora.setResultado("Sí");
            else
                reporteNavegadora.setResultado("No");
                    
*/
            //Procedimineto almacenado
            reporteNavegadora.setNombre(rs.getString("v_nombre"));
            reporteNavegadora.setEdad(String.valueOf(rs.getInt("v_edad")));
            reporteNavegadora.setFechaNacimiento(String.valueOf(rs.getDate("v_fechaNacimiento")));
            reporteNavegadora.setGenero(rs.getString("v_genero"));
            reporteNavegadora.setCiudad(rs.getString("v_ciudad"));
            reporteNavegadora.setEstado(rs.getString("v_estado"));
            reporteNavegadora.setTelefono(rs.getString("v_telefono"));
            reporteNavegadora.setNavegadora("Navegadora");//dato de prueba
            if(rs.getInt("v_resultados") == 1)
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
