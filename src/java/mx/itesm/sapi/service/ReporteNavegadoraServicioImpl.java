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
import mx.itesm.sapi.bean.moduloGestionMedico.TablaMedicoAdministrador;
import mx.itesm.sapi.service.gestionPaciente.EstadoPacientePacienteServiceImpl;
import mx.itesm.sapi.service.moduloGestionMedico.EmpleadoServicioImpl;
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
        String stProcedure3 = "CALL mostrarNombreEmpleado(?)";
        
        ReporteNavegadora reporteNavegadora = new ReporteNavegadora();
        EmpleadoServicioImpl empleadoServicioImpl = new EmpleadoServicioImpl();
        
        try{
            conn = Conexion.getConnection();
            reporteNavegadora = new ReporteNavegadora();
            cstmt = conn.prepareCall(stProcedure1);
            cstmt.setInt(1, idPaciente);
            
            rs = cstmt.executeQuery();
            System.out.println("Ejecuta el 1 store procedure");
            rs.next();  
            
            if (!(rs.getString("v_PRZ") == null))
                reporteNavegadora.setPrz(rs.getString("v_PRZ"));
            else
                reporteNavegadora.setPrz("");
            
            if(!(rs.getString("v_fechaNavegacion") == null))
                reporteNavegadora.setFechaNavegacion(String.valueOf(rs.getDate("v_fechaNavegacion")));
            else
                reporteNavegadora.setFechaNavegacion("");
            
            if(!(rs.getString("v_fechaConsulta") == null))
                reporteNavegadora.setFechaConsulta(String.valueOf(rs.getDate("v_fechaConsulta")));
            else
                reporteNavegadora.setFechaConsulta("");
            
            if(!(rs.getString("v_tipoPaciente") == null))
            {
                if(rs.getInt("v_tipoPaciente")==0)
                    reporteNavegadora.setTipoPaciente("Primera vez");
                 else
                    reporteNavegadora.setTipoPaciente("Segunda Opinion");
            }else
                reporteNavegadora.setTipoPaciente("");
            
            
            if(!(rs.getString("v_medicoAdsctio") == null))
                reporteNavegadora.setMedicoAdscrito(rs.getString("v_medicoAdsctio"));
            else
                reporteNavegadora.setMedicoAdscrito("");
            
            if(!(rs.getString("v_medicoRadiologo") == null))
                reporteNavegadora.setMedicoRadiologo(rs.getString("v_medicoRadiologo"));
            else
                reporteNavegadora.setMedicoRadiologo("");
            
            if(!(rs.getString("v_medicoResidente") == null))
                reporteNavegadora.setMedicoResidente(rs.getString("v_medicoResidente"));
            else
                reporteNavegadora.setMedicoResidente("");
            
            if(!(rs.getString("v_noAdscrito") == null))
                reporteNavegadora.setNoAdscrito(String.valueOf(rs.getBoolean("v_noAdscrito")));
            else
                reporteNavegadora.setNoAdscrito("");
            
            if(!(rs.getString("v_noRadiologo") == null))
                reporteNavegadora.setNoRadiologo(String.valueOf(rs.getBoolean("v_noRadiologo")));
            else
                reporteNavegadora.setNoRadiologo("");
            
            if(!(rs.getString("v_escolaridad") == null))
                reporteNavegadora.setEscolaridad(rs.getString("v_escolaridad"));
            else
                reporteNavegadora.setEscolaridad("");
            
            if(!(rs.getString("v_alergias") == null))
                reporteNavegadora.setAlergias(rs.getString("v_alergias"));
            else
                reporteNavegadora.setAlergias("");
            
            if(!(rs.getString("v_estadoHormonal") == null)){
                if(rs.getInt("v_estadoHormonal")==2)
                    reporteNavegadora.setEstadoHormonal("PosMenopaucia");
                else
                    reporteNavegadora.setEstadoHormonal("PreMenopaucia");
            }else
                    reporteNavegadora.setEstadoHormonal("");
            
            if(!(rs.getString("v_tipoSeguro") == null))
                reporteNavegadora.setSeguro(rs.getString("v_tipoSeguro"));
            else
                reporteNavegadora.setSeguro("");
            
            if(!(rs.getString("v_numeroSeguro") == null))
                reporteNavegadora.setNoSeguro(rs.getString("v_numeroSeguro"));
            else
                reporteNavegadora.setNoSeguro("");
            
            if(!(rs.getString("v_mastografiaPreINCAN") == null))
            {
                if(rs.getInt("v_mastografiaPreINCAN") == 0)
                    reporteNavegadora.setMastografiaPreINCAN("No");
                else
                    reporteNavegadora.setMastografiaPreINCAN("Sí");
            }else
                    reporteNavegadora.setMastografiaPreINCAN("");
            
            if(!(rs.getString("v_cirugiaFecha") == null))
                reporteNavegadora.setCirugiaFecha(String.valueOf(rs.getDate("v_cirugiaFecha")));
            else
                reporteNavegadora.setCirugiaFecha("");
            
            if(!(rs.getString("v_cirugiaTipo") == null))
                reporteNavegadora.setCirugiaTipo(rs.getString("v_cirugiaTipo"));
            else
                reporteNavegadora.setCirugiaTipo("");
            
            if(!(rs.getString("v_cirugiaComentario") == null))
                reporteNavegadora.setCirugiaComentario(rs.getString("v_cirugiaComentario"));
            else
                reporteNavegadora.setCirugiaComentario("");
            
            if(!(rs.getString("v_quimioterapiaFecha") == null))
                reporteNavegadora.setQuimioterapiaFecha(String.valueOf(rs.getDate("v_quimioterapiaFecha")));
            else
                reporteNavegadora.setQuimioterapiaFecha("");
            
            if(!(rs.getString("v_quimioterapiaCiclo") == null))
                reporteNavegadora.setQuimioterapiaCiclo(String.valueOf(rs.getInt("v_quimioterapiaCiclo")));
            else
                reporteNavegadora.setQuimioterapiaCiclo("");
            
            if(!(rs.getString("v_quimioterapiaComentario") == null))
                reporteNavegadora.setQuimioterapiaComentario(rs.getString("v_quimioterapiaComentario"));
            else
                reporteNavegadora.setQuimioterapiaComentario("");
            
            if(!(rs.getString("v_radioterapiaFecha") == null))
                reporteNavegadora.setRadioterapiaFecha(String.valueOf(rs.getDate("v_radioterapiaFecha")));
            else
                reporteNavegadora.setRadioterapiaFecha("");
            
            if(!(rs.getString("v_radioterapiaCiclo") == null))
                reporteNavegadora.setRadioterapiaCiclo(String.valueOf(rs.getInt("v_radioterapiaCiclo")));
            else
                reporteNavegadora.setRadioterapiaCiclo("");
            
            if(!(rs.getString("v_radioterapiaComentario") == null))
                reporteNavegadora.setRadioterapiaComentario(rs.getString("v_radioterapiaComentario"));
            else
                reporteNavegadora.setRadioterapiaComentario("");
            
            if(!(rs.getString("v_mastografiaBiradsNombre") == null))
                reporteNavegadora.setMastografiaBiradsNombre(rs.getString("v_mastografiaBiradsNombre"));
            else
                reporteNavegadora.setMastografiaBiradsNombre("");
            
            if(!(rs.getString("v_mastografiaBiradsFecha") == null))
                reporteNavegadora.setMastografiaBiradsFecha(String.valueOf(rs.getDate("v_mastografiaBiradsFecha")));
            else
                reporteNavegadora.setMastografiaBiradsFecha("");
            
            if(!(rs.getString("v_ultrasonidoBiradsNombre") == null))
                reporteNavegadora.setUltrasonidoBiradsNombre(rs.getString("v_ultrasonidoBiradsNombre"));
            else
                reporteNavegadora.setUltrasonidoBiradsNombre("");
            
            if(!(rs.getString("v_ultrasonidoBiradsFecha") == null))
                reporteNavegadora.setUltrasonidoBiradsFecha(String.valueOf(rs.getDate("v_ultrasonidoBiradsFecha")));
            else
                reporteNavegadora.setUltrasonidoBiradsFecha("");
            
            if(!(rs.getString("v_resultadoPatologia") == null))
                reporteNavegadora.setResultadoPatologia(rs.getString("v_resultadoPatologia"));
            else
                reporteNavegadora.setResultadoPatologia("");
            
            if(!(rs.getString("v_otroResultado") == null))
                reporteNavegadora.setOtroResultado(rs.getString("v_otroResultado"));
            else
                reporteNavegadora.setOtroResultado("");
            
            if(!(rs.getString("v_serieParafina") == null))
                reporteNavegadora.setSerieParafina(rs.getString("v_serieParafina"));
            else
                reporteNavegadora.setSerieParafina("");
            
            if(!(rs.getString("v_cantidadParafina") == null))
                reporteNavegadora.setCantidadParafina(String.valueOf(rs.getInt("v_cantidadParafina")));
            else
                reporteNavegadora.setCantidadParafina("");
            
            if(!(rs.getString("v_serieLaminillas") == null))
                reporteNavegadora.setSerieLaminillas(rs.getString("v_serieLaminillas"));
            else
                reporteNavegadora.setSerieLaminillas("");
            
            if(!(rs.getString("v_cantidadLaminillas") == null))
                reporteNavegadora.setCantidadLaminillas(String.valueOf(rs.getInt("v_cantidadLaminillas")));
            else
                reporteNavegadora.setCantidadLaminillas("");
            
            if(!(rs.getString("v_fechaFin") == null))
                reporteNavegadora.setFechaFin(String.valueOf(rs.getDate("v_fechaFin")));
            else
                reporteNavegadora.setFechaFin("");
            
            if(!(rs.getString("v_decisionCosulta") == null))
                reporteNavegadora.setDecisionConsulta(rs.getString("v_decisionCosulta"));
            else
                reporteNavegadora.setDecisionConsulta("");
            
            if(!(rs.getString("v_socioeconomico") == null))
                reporteNavegadora.setSocioeconomico(rs.getString("v_socioeconomico"));
            else
                reporteNavegadora.setSocioeconomico("");
            
            if(!(rs.getString("v_comentarioIncidencia") == null))
                reporteNavegadora.setComentarioIncidencia(rs.getString("v_comentarioIncidencia"));
            else
                reporteNavegadora.setComentarioIncidencia("");
            
            
           if(!(rs.getString("v_comentarioMedico") == null)) 
                   reporteNavegadora.setComentarioMedico(rs.getString("v_comentarioMedico"));
               else
                   reporteNavegadora.setComentarioMedico("");
           
            if(!(rs.getString("v_T") == null))
                reporteNavegadora.setT(rs.getString("v_T"));
            else
                reporteNavegadora.setT("");
            
            if(!(rs.getString("v_N") == null))
                reporteNavegadora.setN(rs.getString("v_N"));
            else
                reporteNavegadora.setN("");
            
            if(!(rs.getString("v_M") == null))
                reporteNavegadora.setM(rs.getString("v_M"));
            else
                reporteNavegadora.setM("");
            
            if(!(rs.getString("v_etapaClinica") == null))
                reporteNavegadora.setEtapaClinica(rs.getString("v_etapaClinica"));
            else
                reporteNavegadora.setEtapaClinica("");
            
            if(!(rs.getString("v_ultra") == null))
                reporteNavegadora.setUltra(rs.getString("v_ultra"));         
            else
                reporteNavegadora.setUltra("");
            
            if(!(rs.getString("v_masto") == null))
                reporteNavegadora.setMasto(rs.getString("v_masto"));
            else
                reporteNavegadora.setMasto("");
            
            if(!(rs.getString("v_her2") == null))
                reporteNavegadora.setHer2(rs.getString("v_her2"));
            else
                reporteNavegadora.setHer2("");
            
            if(!(rs.getString("v_rp") == null))
                reporteNavegadora.setRp(rs.getString("v_rp"));
            else
                reporteNavegadora.setRp("");
            
            if(!(rs.getString("v_re") == null))
                reporteNavegadora.setRe(rs.getString("v_re"));
            else
                reporteNavegadora.setRe("");
            
            if(!(rs.getString("v_fish") == null))
                reporteNavegadora.setFish(rs.getString("v_fish"));
            else
                reporteNavegadora.setFish("");
            
            if(!(rs.getString("v_ki67") == null))
                reporteNavegadora.setKi67(rs.getString("v_ki67"));
            else
                reporteNavegadora.setKi67("");
            
            if(!(rs.getString("v_gradoH") == null))
                reporteNavegadora.setGradoH(rs.getString("v_gradoH"));
            else
                reporteNavegadora.setGradoH("");
            
            if(!(rs.getString("v_resultadoPatologiaPost") == null))
                reporteNavegadora.setResultadoPatologiaPost(rs.getString("v_resultadoPatologiaPost"));
            else
                reporteNavegadora.setResultadoPatologiaPost("");
            System.out.println("Llena el bean del primer store procedure");
            
            cstmt = conn.prepareCall(stProcedure2);
            cstmt.setInt(1, idPaciente);
            
            rs = cstmt.executeQuery();
            System.out.println("Ejectuta el 2 store procedure");
            rs.next();
            
            
            
            //reporteNavegadora.setNavegadora("Navegadora");//dato de prueba
            //Procedimineto almacenado
            if(!(rs.getString("v_nombre") == null))
                reporteNavegadora.setNombre(rs.getString("v_nombre"));
            else
                reporteNavegadora.setNombre("");
            
            if(!(rs.getString("v_edad") == null))
                reporteNavegadora.setEdad(String.valueOf(rs.getInt("v_edad")));
            else
                reporteNavegadora.setEdad("");
            
            if(!(rs.getString("v_fechaNacimiento") == null))
                reporteNavegadora.setFechaNacimiento(String.valueOf(rs.getDate("v_fechaNacimiento")));
            else
                reporteNavegadora.setFechaNacimiento("");
            
            if(!(rs.getString("v_genero") == null))
                reporteNavegadora.setGenero(rs.getString("v_genero"));
            else
                reporteNavegadora.setGenero("");
            
            if(!(rs.getString("v_ciudad") == null))
                reporteNavegadora.setCiudad(rs.getString("v_ciudad"));
            else
                reporteNavegadora.setCiudad("");
            
            if(!(rs.getString("v_estado") == null))
                reporteNavegadora.setEstado(rs.getString("v_estado"));
            else
                reporteNavegadora.setEstado("");
            
            if(!(rs.getString("v_telefono") == null))
                reporteNavegadora.setTelefono(rs.getString("v_telefono"));
            else
                reporteNavegadora.setTelefono("");
            
            
            if(!(rs.getString("v_resultados") == null))
            {
                 if(rs.getInt("v_resultados") == 1)
                    reporteNavegadora.setResultado("Sí");
                 else
                    reporteNavegadora.setResultado("No");
            }
                else
                    reporteNavegadora.setResultado("");
            
            System.out.println("Llena el bean del 2 store procedure");
            cstmt = conn.prepareCall(stProcedure3);
            cstmt.setInt(1, idEmpleado);
            
            rs = cstmt.executeQuery();
            System.out.println("Ejecuta el 3 store procedure");
            rs.next();
            
            reporteNavegadora.setNavegadora(rs.getString("nombre").concat(" ").concat(rs.getString("primerApellido")).concat(" ").concat(rs.getString("segundoApellido")));
            System.out.println("Llena el bean del 3 store procedure");
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
