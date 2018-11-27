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
import java.util.ArrayList;

import mx.itesm.sapi.bean.formulario.MFormularioGeneral;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Angel GTZ
 */
public class MFormularioGeneralServicioImpl implements MFormularioGeneralServicio {

    @Override
    public MFormularioGeneral mostrarFormularioGeneralNavegadora(int idPaciente) {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        MFormularioGeneral mFormularioGeneral = null;

        //Call del store procedure
        String stProcedure = "CALL mostrarFormularioNavegadora(?)";

        try {
            mFormularioGeneral = new MFormularioGeneral();
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idPaciente);

            rs = cstmt.executeQuery();

            rs.next();

            mFormularioGeneral.setPrz(rs.getString("v_PRZ"));
            mFormularioGeneral.setFechaNavegacion(rs.getDate("v_fechaNavegacion"));
            mFormularioGeneral.setFechaConsulta(rs.getDate("v_fechaConsulta"));
            mFormularioGeneral.setTipoPaciente(rs.getBoolean("v_tipoPaciente"));
            mFormularioGeneral.setMedicoAdscrito(rs.getString("v_medicoAdsctio"));
            mFormularioGeneral.setMedicoRadiologo(rs.getString("v_medicoRadiologo"));
            mFormularioGeneral.setMedicoResidente(rs.getString("v_medicoResidente"));
            mFormularioGeneral.setNoAdscrito(rs.getBoolean("v_noAdscrito"));
            mFormularioGeneral.setNoRadiologo(rs.getBoolean("v_noRadiologo"));
            mFormularioGeneral.setNoResidente(rs.getBoolean("v_noResidente"));
            mFormularioGeneral.setEscolaridad(rs.getString("v_escolaridad"));
            mFormularioGeneral.setAlergias(rs.getString("v_alergias"));
            mFormularioGeneral.setEstadoHormonal(rs.getBoolean("v_estadoHormonal"));
            mFormularioGeneral.setSeguro(rs.getString("v_tipoSeguro"));
            mFormularioGeneral.setNoSeguro(rs.getString("v_numeroSeguro"));
            mFormularioGeneral.setMastografiaPreINCAN(rs.getBoolean("v_mastografiaPreINCAN"));
            mFormularioGeneral.setCirugiaFecha(rs.getDate("v_cirugiaFecha"));
            mFormularioGeneral.setCirugiaTipo(rs.getString("v_cirugiaTipo"));
            mFormularioGeneral.setCirugiaComentario(rs.getString("v_cirugiaComentario"));
            mFormularioGeneral.setQuimioterapiaFecha(rs.getDate("v_quimioterapiaFecha"));
            mFormularioGeneral.setQuimioterapiaCiclo(rs.getInt("v_quimioterapiaCiclo"));
            mFormularioGeneral.setQuimioterapiaComentario(rs.getString("v_quimioterapiaComentario"));
            mFormularioGeneral.setRadioterapiaFecha(rs.getDate("v_radioterapiaFecha"));
            mFormularioGeneral.setRadioterapiaCiclo(rs.getInt("v_radioterapiaCiclo"));
            mFormularioGeneral.setRadioterapiaComentario(rs.getString("v_radioterapiaComentario"));
            mFormularioGeneral.setMastografiaBiradsNombre(rs.getString("v_mastografiaBiradsNombre"));
            mFormularioGeneral.setMastografiaBiradsFecha(rs.getDate("v_mastografiaBiradsFecha"));
            mFormularioGeneral.setUltrasonidoBiradsNombre(rs.getString("v_ultrasonidoBiradsNombre"));
            mFormularioGeneral.setUltrasonidoBiradsFecha(rs.getDate("v_ultrasonidoBiradsFecha"));
            mFormularioGeneral.setResultadoPatologia(rs.getString("v_resultadoPatologia"));
            mFormularioGeneral.setOtroResultado(rs.getString("v_otroResultado"));
            mFormularioGeneral.setSerieParafina(rs.getString("v_serieParafina"));
            mFormularioGeneral.setCantidadParafina(rs.getInt("v_cantidadParafina"));
            mFormularioGeneral.setSerieLaminillas(rs.getString("v_serieLaminillas"));
            mFormularioGeneral.setCantidadLaminillas(rs.getInt("v_cantidadLaminillas"));
            mFormularioGeneral.setT(rs.getString("v_T"));
            mFormularioGeneral.setN(rs.getString("v_N"));
            mFormularioGeneral.setM(rs.getString("v_M"));
            mFormularioGeneral.setFechaFin(rs.getDate("v_fechaFin"));
            mFormularioGeneral.setDecisionCosulta(rs.getString("v_decisionCosulta"));
            mFormularioGeneral.setSocioeconomico(rs.getString("v_socioeconomico"));
            mFormularioGeneral.setComentarioIncidencia(rs.getString("v_comentarioIncidencia"));
            mFormularioGeneral.setComentarioMedico(rs.getString("v_comentarioMedico"));
            mFormularioGeneral.setEtapaClinica(rs.getString("v_etapaClinica"));
            mFormularioGeneral.setUltra(rs.getString("v_ultra"));
            mFormularioGeneral.setMasto(rs.getString("v_masto"));
            mFormularioGeneral.setHer2(rs.getString("v_her2"));
            mFormularioGeneral.setRp(rs.getString("v_rp"));
            mFormularioGeneral.setRe(rs.getString("v_re"));
            mFormularioGeneral.setFish(rs.getString("v_fish"));
            mFormularioGeneral.setKi67(rs.getString("v_ki67"));
            mFormularioGeneral.setGradoH(rs.getString("v_gradoH"));
            mFormularioGeneral.setResultadoPatologiaPost(rs.getString("v_resultadoPatologiaPost"));

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return mFormularioGeneral;
    }

    @Override
    public ArrayList<MFormularioGeneral> mostrarFormularioLugarTipoFecha(int idPaciente, String nombreEstudio) {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        ArrayList<MFormularioGeneral> citas = new ArrayList<>();

        try {

            conn = Conexion.getConnection();
            cstmt = conn.prepareCall("CALL mostrarFormularioDinamicoLTF(?, ?)");
            cstmt.setInt(1, idPaciente);
            cstmt.setString(2, nombreEstudio);
            rs = cstmt.executeQuery();
            MFormularioGeneral mFormularioGeneral;

            while (rs.next()) {
                //cit.idCita, est.nombre, cit.fechaProgramada, lug.nombre

                mFormularioGeneral = new MFormularioGeneral();
                mFormularioGeneral.setIdCita(rs.getInt("IdCita"));
                mFormularioGeneral.setNombreEstudio(rs.getString("EstudioNombre"));
                mFormularioGeneral.setCitaProgramada(rs.getDate("FechaProgramada"));
                mFormularioGeneral.setLugarCuerpo(rs.getString("LugarCuerpo"));

                citas.add(mFormularioGeneral);

            }

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {

            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            citas = null;
        }

        return citas;
    }

    @Override
    public ArrayList<MFormularioGeneral> mostrarFormularioFechaTipo(int idPaciente, String nombreEstudio) {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        ArrayList<MFormularioGeneral> citas = new ArrayList<>();
        try {

            conn = Conexion.getConnection();
            cstmt = conn.prepareCall("CALL mostrarFormularioDinamicoFechaTipo(?, ?)");
            cstmt.setInt(1, idPaciente);
            cstmt.setString(2, nombreEstudio);
            rs = cstmt.executeQuery();
            MFormularioGeneral mFormularioGeneral;

            while (rs.next()) {
                //cit.idCita, est.nombre, cit.fechaProgramada 
                mFormularioGeneral = new MFormularioGeneral();
                mFormularioGeneral.setIdCita(rs.getInt("IdCita"));
                mFormularioGeneral.setNombreEstudio(rs.getString("EstudioNombre"));
                mFormularioGeneral.setCitaProgramada(rs.getDate("FechaProgramada"));

                citas.add(mFormularioGeneral);

            }

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {

            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            citas = null;
        }

        return citas;
    }

    @Override
    public ArrayList<MFormularioGeneral> mostrarFormularioFecha(int idPaciente, String nombreEstudio) {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        ArrayList<MFormularioGeneral> citas = new ArrayList<>();

        try {

            conn = Conexion.getConnection();
            cstmt = conn.prepareCall("CALL mostrarFormularioDinamicoFecha(?, ?)");
            cstmt.setInt(1, idPaciente);
            cstmt.setString(2, nombreEstudio);
            rs = cstmt.executeQuery();
            MFormularioGeneral mFormularioGeneral;

            while (rs.next()) {
                //cit.idCita, cit.fechaProgramada
                mFormularioGeneral = new MFormularioGeneral();
                mFormularioGeneral.setIdCita(rs.getInt("IdCita"));
                mFormularioGeneral.setCitaProgramada(rs.getDate("FechaProgramada"));

                citas.add(mFormularioGeneral);

            }

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {

            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            citas = null;
        }

        return citas;
    }

    @Override
    public ArrayList<MFormularioGeneral> mostrarFormularioLugarFecha(int idPaciente, String nombreEstudio) {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        ArrayList<MFormularioGeneral> citas = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall("CALL mostrarFormularioDinamicoLTF(?, ?)");
            cstmt.setInt(1, idPaciente);
            cstmt.setString(2, nombreEstudio);
            rs = cstmt.executeQuery();
            MFormularioGeneral mFormularioGeneral;

            while (rs.next()) {

                // cit.idCita, lug.nombre, cit.fechaProgramada
                mFormularioGeneral = new MFormularioGeneral();
                mFormularioGeneral.setIdCita(rs.getInt("IdCita"));
                mFormularioGeneral.setLugarCuerpo(rs.getString("LugarCuerpo"));
                mFormularioGeneral.setCitaProgramada(rs.getDate("FechaProgramada"));

                citas.add(mFormularioGeneral);

            }

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {

            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            citas = null;
        }

        return citas;
    }

    @Override
    public ArrayList<MFormularioGeneral> mostrarFormularioNavegadoraLLamada(int idPaciente) {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        ArrayList<MFormularioGeneral> citas = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall("CALL mostrarFormularioNavegadoraLLamada(?)");
            cstmt.setInt(1, idPaciente);
            rs = cstmt.executeQuery();
            MFormularioGeneral mFormularioGeneral;

            while (rs.next()) {

                // cit.idCita, lug.nombre, cit.fechaProgramada
                mFormularioGeneral = new MFormularioGeneral();
                mFormularioGeneral.setComentarioLLamada(rs.getString("v_comentarioLLamada"));
                mFormularioGeneral.setFechaLlamada(rs.getDate("v_fechaLlamada"));

                citas.add(mFormularioGeneral);

            }

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {

            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            citas = null;
        }

        return citas;
    }

}
