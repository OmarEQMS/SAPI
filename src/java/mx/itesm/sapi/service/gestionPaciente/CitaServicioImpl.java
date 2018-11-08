/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.Cita;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Oscar Miranda
 */
public class CitaServicioImpl implements CitaServicio {

    @Override
    public Cita mostrarCita(int idCita) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL mostrarCita(?)";
        Cita cita = null;

        try {
            conn = Conexion.getConnection();
            cita = new Cita();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idCita);

            rs = cstmt.executeQuery();
            rs.next();

            cita.setIdCita(rs.getInt("idCita"));
            cita.setIdTipoCita(rs.getInt("idTipoCita"));
            cita.setIdPaciente(rs.getInt("idPaciente"));
            cita.setIdEstadoCita(rs.getInt("idEstadoCita"));
            cita.setIdImportanciaCita(rs.getInt("idImportanciaCita"));
            cita.setIdPiso(rs.getInt("idPiso"));
            cita.setIdTipoTratamiento(rs.getInt("idTipoTratamiento"));
            cita.setIdEstudio(rs.getInt("idEstudio"));
            cita.setIdMotivoConsulta(rs.getInt("idMotivoConsulta"));
            cita.setFechaProgramada((rs.getTimestamp("fechaProgramada")));
            cita.setFechaReal((rs.getTimestamp("fechaReal")));
            cita.setEstatus(rs.getInt("estatus"));
            cita.setArchivo(rs.getBytes("archivo"));
            cita.setHospitalProcedencia(rs.getString("hospitalProcedencia"));
            cita.setFechaSolicitud((rs.getTimestamp("fechaSolicitud")).toString());

            conn.close();
            cstmt.close();
            rs.close();

        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            cita = null;
        }
        return cita;
    }

    @Override
    public List<Cita> mostrarCita() {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL mostrarCita()";
        List<Cita> citas = null;
        Cita cita;

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            citas = new ArrayList<>();

            while (rs.next()) {
                cita = new Cita();
                cita.setIdCita(rs.getInt("idCita"));
                cita.setIdTipoCita(rs.getInt("idTipoCita"));
                cita.setIdPaciente(rs.getInt("idPaciente"));
                cita.setIdEstadoCita(rs.getInt("idEstadoCita"));
                cita.setIdImportanciaCita(rs.getInt("idImportanciaCita"));
                cita.setIdTipoTratamiento(rs.getInt("idTipoTratamiento"));
                cita.setIdEstudio(rs.getInt("idEstudio"));
                cita.setIdMotivoConsulta(rs.getInt("idMotivoConsulta"));
                cita.setFechaProgramada((rs.getTimestamp("fechaProgramada")));
                cita.setFechaReal((rs.getTimestamp("fechaReal")));
                cita.setArchivo(rs.getBytes("archivo"));
                cita.setHospitalProcedencia(rs.getString("hospitalProcedencia"));
                cita.setFechaSolicitud((rs.getTimestamp("fechaSolicitud")).toString());

                citas.add(cita);
            }

            conn.close();
            cstmt.close();
            rs.close();

        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            citas = null;
        }
        return citas;
    }

    @Override
    public int agregarCita(Cita cita) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL agregarCita(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int id = -1;

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);

            cstmt.setInt(1, cita.getIdTipoCita());
            cstmt.setInt(2, cita.getIdPaciente());
            cstmt.setInt(3, cita.getIdEstadoCita());
            cstmt.setInt(4, cita.getIdImportanciaCita());
            cstmt.setInt(5, cita.getIdTipoTratamiento());
            cstmt.setInt(6, cita.getIdEstudio());
            cstmt.setInt(7, cita.getIdMotivoConsulta());

            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
                Date parsedDate = dateFormat.parse(cita.getFechaProgramada().toString());
                Timestamp fechaProgramada = new java.sql.Timestamp(parsedDate.getTime());
                cstmt.setTimestamp(8, fechaProgramada);
            } catch (Exception e) { //this generic but you can control nother types of exception
                // look the origin of excption 
            }

            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
                Date parsedDate = dateFormat.parse(cita.getFechaReal().toString());
                Timestamp fechaReal = new java.sql.Timestamp(parsedDate.getTime());
                cstmt.setTimestamp(9, fechaReal);
            } catch (Exception e) { //this generic but you can control nother types of exception
                // look the origin of excption 
            }

            cstmt.setBytes(10, cita.getArchivo());
            cstmt.setString(11, cita.getHospitalProcedencia());

            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
                Date parsedDate = dateFormat.parse(cita.getFechaSolicitud());
                Timestamp fechaSolicitud = new java.sql.Timestamp(parsedDate.getTime());
                cstmt.setTimestamp(12, fechaSolicitud);
            } catch (Exception e) { //this generic but you can control nother types of exception
                // look the origin of excption 
            }

            rs = cstmt.executeQuery();
            rs.next();

            id = rs.getInt(1);

            conn.close();
            cstmt.close();
            rs.close();

        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            id = -1;
        }
        return id;
    }

    @Override
    public boolean borradoLogicoCita(int idCita) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL borradoLogicoCita(?)";
        boolean exito = false;

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);

            cstmt.setInt(1, idCita);

            rs = cstmt.executeQuery();
            rs.next();
            exito = rs.getBoolean(1);

            rs.close();
            conn.close();
            cstmt.close();
        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            exito = false;
        }
        return exito;
    }

    @Override
    public boolean actualizarCita(Cita cita) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL actualizarCita(?,?,?,?,?,?,?,?,?,?,?,?)";
        boolean exito = false;
        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);

            cstmt.setInt(1, cita.getIdTipoCita());
            cstmt.setInt(2, cita.getIdPaciente());
            cstmt.setInt(3, cita.getIdEstadoCita());
            cstmt.setInt(4, cita.getIdImportanciaCita());
            cstmt.setInt(5, cita.getIdTipoTratamiento());
            cstmt.setInt(6, cita.getIdEstudio());
            cstmt.setInt(7, cita.getIdMotivoConsulta());

            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
                Date parsedDate = dateFormat.parse(cita.getFechaProgramada().toString());
                Timestamp fechaProgramada = new java.sql.Timestamp(parsedDate.getTime());
                cstmt.setTimestamp(8, fechaProgramada);
            } catch (Exception e) { //this generic but you can control nother types of exception
                // look the origin of excption 
            }

            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
                Date parsedDate = dateFormat.parse(cita.getFechaReal().toString());
                Timestamp fechaReal = new java.sql.Timestamp(parsedDate.getTime());
                cstmt.setTimestamp(9, fechaReal);
            } catch (Exception e) { //this generic but you can control nother types of exception
                // look the origin of excption 
            }

            cstmt.setBytes(10, cita.getArchivo());
            cstmt.setString(11, cita.getHospitalProcedencia());

            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
                Date parsedDate = dateFormat.parse(cita.getFechaSolicitud());
                Timestamp fechaSolicitud = new java.sql.Timestamp(parsedDate.getTime());
                cstmt.setTimestamp(12, fechaSolicitud);
            } catch (Exception e) { //this generic but you can control nother types of exception
                // look the origin of excption 
            }

            rs = cstmt.executeQuery();
            rs.next();
            exito = rs.getBoolean(1);

            rs.close();
            conn.close();
            cstmt.close();
        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            exito = false;
        }
        return exito;
    }

    @Override
    public int agregarPreconsulta(Cita cita) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL solicitarPreconsulta(?,?,?,?)";
        int id = -1;

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);

            int idPaciente = cita.getIdPaciente();
            int idMotivo = cita.getIdMotivoConsulta();
            String hospitalProcedencia = cita.getHospitalProcedencia();
            Timestamp fechaSolicitud = null;

            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
                Date parsedDate = dateFormat.parse(cita.getFechaSolicitud());
                fechaSolicitud = new java.sql.Timestamp(parsedDate.getTime());

            } catch (Exception e) { //this generic but you can control nother types of exception
                // look the origin of excption 
            }

            System.out.println("Params Preconsulta ".concat(String.valueOf(idPaciente)).concat(" ").concat(String.valueOf(idMotivo)).concat(" ")
                    .concat(" ").concat(hospitalProcedencia).concat(" ").concat(fechaSolicitud.toString()));

            cstmt.setInt(1, idPaciente);
            cstmt.setInt(2, idMotivo);
            cstmt.setString(3, hospitalProcedencia);
            cstmt.setTimestamp(4, fechaSolicitud);

            System.out.println("PROCEDURE ".concat(cstmt.toString()));
            rs = cstmt.executeQuery();
            rs.next();

            id = rs.getInt(1);

            conn.close();
            cstmt.close();
            rs.close();

        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            id = -1;
        }
        return id;
    }

    @Override
    public String mostrarPreconsultaAceptada(int idPacientePotencial) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL mostrarEstadoPreconsulta(?)";
        String estadoCita = null;

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);

            cstmt.setInt(1, idPacientePotencial);
            rs = cstmt.executeQuery();
            rs.next();

            estadoCita = rs.getString("ESTADO_CITA");

            conn.close();
            cstmt.close();
            rs.close();

        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            estadoCita = null;
        }
        return estadoCita;
    }

    @Override
    public boolean cancelarCitaPreconsulta(int idPacientePotencial) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL cancelarCitaPreconsulta(?)";
        boolean exito = false;
        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);

            cstmt.setInt(1, idPacientePotencial);

            rs = cstmt.executeQuery();
            rs.next();
            exito = rs.getBoolean(1);

            rs.close();
            conn.close();
            cstmt.close();
        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            exito = false;
        }
        return exito;
    }

    @Override
    public boolean aprobarPaciente(int idPaciente, String fechaNav, String fechaCon, int segundaOpinion) {

        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL AprobarPaciente(?,?,?,?)";
        boolean exito = false;
        int idCitaNav, idCitaCon;

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);

            Timestamp fechaNavegacion = null;
            Timestamp fechaConsulta = null;

            fechaNavegacion = Timestamp.valueOf(fechaNav);
            fechaConsulta = Timestamp.valueOf(fechaCon);

            cstmt.setInt(1, idPaciente);
            cstmt.setTimestamp(2, fechaNavegacion);
            cstmt.setTimestamp(3, fechaConsulta);
            cstmt.setInt(4, segundaOpinion);

            rs = cstmt.executeQuery();
            rs.next();
            idCitaNav = rs.getInt(1);
            idCitaCon = rs.getInt(2);

            exito = true;

            rs.close();
            conn.close();
            cstmt.close();
        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            exito = false;
        }
        return exito;
    }

    @Override
    public Cita mostrarCitaIdPaciente(int idPaciente) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL mostrarCitaIdPaciente(?)";
        Cita cita = null;

        try {
            conn = Conexion.getConnection();
            cita = new Cita();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idPaciente);

            rs = cstmt.executeQuery();
            rs.next();

            cita.setIdCita(rs.getInt("idCita"));
            cita.setIdTipoCita(rs.getInt("idTipoCita"));
            cita.setIdPaciente(rs.getInt("idPaciente"));
            cita.setIdEstadoCita(rs.getInt("idEstadoCita"));
            cita.setIdImportanciaCita(rs.getInt("idImportanciaCita"));
            cita.setIdPiso(rs.getInt("idPiso"));
            cita.setIdTipoTratamiento(rs.getInt("idTipoTratamiento"));
            cita.setIdEstudio(rs.getInt("idEstudio"));
            cita.setIdMotivoConsulta(rs.getInt("idMotivoConsulta"));

            cita.setFechaProgramada((rs.getTimestamp("fechaProgramada")));
            System.out.println("Pre fechareal");
            cita.setFechaReal((rs.getTimestamp("fechaReal")));
            System.out.println("post fecha real");
            cita.setEstatus(rs.getInt("estatus"));
            cita.setArchivo(rs.getBytes("archivo"));
            cita.setHospitalProcedencia(rs.getString("hospitalProcedencia"));
            cita.setFechaSolicitud((rs.getTimestamp("fechaSolicitud")).toString());

            conn.close();
            cstmt.close();
            rs.close();

        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            cita = null;
        }
        return cita;
    }

    @Override
    public List<Cita> mostrarCitaIdEspecifico(int idPaciente) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL mostrarListaCitaIdEspecifico(?)";
        List<Cita> citas = null;
        Cita cita;

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idPaciente);
            rs = cstmt.executeQuery();
            citas = new ArrayList<>();

            while (rs.next()) {
                cita = new Cita();
                cita.setIdCita(rs.getInt("idCita"));
                cita.setIdTipoCita(rs.getInt("idTipoCita"));
                cita.setIdPaciente(rs.getInt("idPaciente"));
                cita.setIdEstadoCita(rs.getInt("idEstadoCita"));
                cita.setIdImportanciaCita(rs.getInt("idImportanciaCita"));
                cita.setIdPiso(rs.getInt("idPiso"));
                cita.setIdTipoTratamiento(rs.getInt("idTipoTratamiento"));
                cita.setIdEstudio(rs.getInt("idEstudio"));
                cita.setIdMotivoConsulta(rs.getInt("idMotivoConsulta"));
                cita.setFechaProgramada((rs.getTimestamp("fechaProgramada")));
                cita.setFechaReal((rs.getTimestamp("fechaReal")));
                cita.setEstatus(rs.getInt("estatus"));
                cita.setArchivo(rs.getBytes("archivo"));
                cita.setHospitalProcedencia(rs.getString("hospitalProcedencia"));
                cita.setFechaSolicitud((rs.getTimestamp("fechaSolicitud")).toString());

                citas.add(cita);
            }

            conn.close();
            cstmt.close();
            rs.close();

        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            citas = null;
        }
        return citas;
    }

    @Override
    public int citaPendiente(int idPaciente) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL agregarCitaPendiente(?)";
        int id = -1;

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idPaciente);

            rs = cstmt.executeQuery();
            rs.next();

            conn.close();
            cstmt.close();
            rs.close();

        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return id;
    }

}
