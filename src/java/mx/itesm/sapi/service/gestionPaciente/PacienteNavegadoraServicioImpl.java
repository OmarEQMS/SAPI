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
import mx.itesm.sapi.util.Conexion;
import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.PacienteNavegadora;

/**
 *
 * @author urieldiaz
 */
public class PacienteNavegadoraServicioImpl implements PacienteNavegadoraServicio {

    @Override
    public PacienteNavegadora mostrarPacienteNavegadora(int idPacienteNavegadora) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;

        PacienteNavegadora pacienteNavegadora = new PacienteNavegadora();

        String stProcedure = "CALL mostrarPacienteNavegadora(?)";
        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idPacienteNavegadora);
            rs = cstmt.executeQuery();
            rs.next();

            pacienteNavegadora.setIdPacienteNavegadora(rs.getInt("idPaciente"));
            pacienteNavegadora.setIdPaciente(rs.getInt("idCuenta"));
            pacienteNavegadora.setIdEmpleado(rs.getInt("idEscolaridad"));
            pacienteNavegadora.setEstatus(rs.getInt("idSeguro"));

            rs.close();
            cstmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            pacienteNavegadora = null;
        }
        return pacienteNavegadora;
    }

    @Override
    public List<PacienteNavegadora> mostrarPacienteNavegadora() {
        Connection conn;
        List<PacienteNavegadora> listspacienteNavegaora = new ArrayList<>();
        CallableStatement cstmt;
        String stProcedure = "CALL mostrarListaPacienteNavegadora()";

        ResultSet rs;

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            PacienteNavegadora pacienteNavegadora;

            while (rs.next()) {
                pacienteNavegadora = new PacienteNavegadora();
                
                pacienteNavegadora.setIdPacienteNavegadora(rs.getInt("idPaciente"));
                pacienteNavegadora.setIdPaciente(rs.getInt("idCuenta"));
                pacienteNavegadora.setIdEmpleado(rs.getInt("idEscolaridad"));
                pacienteNavegadora.setEstatus(rs.getInt("idSeguro"));

                listspacienteNavegaora.add(pacienteNavegadora);
            }

            rs.close();
            cstmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            listspacienteNavegaora = null;
        }
        return listspacienteNavegaora;

    }

    @Override
    public int agregarPacienteNavegadora(PacienteNavegadora pacienteNavegadora) {
        Connection conn; 
        ResultSet rs;
        CallableStatement cstmt;
        int id = -1;
        String stPrcedure="CALL agregarPacienteNavegadora(?, ?)";
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stPrcedure);
            
            cstmt.setInt(1, pacienteNavegadora.getIdPacienteNavegadora());
            cstmt.setInt(2, pacienteNavegadora.getIdPaciente());
            cstmt.setInt(3, pacienteNavegadora.getIdEmpleado());
            cstmt.setInt(4, pacienteNavegadora.getEstatus() );
            
            
            cstmt.executeUpdate();
            rs = cstmt.getGeneratedKeys();
            rs.next();
            id=rs.getInt(1);
            
            rs.close();
            cstmt.close();
            conn.close();
            
        }catch(SQLException ex){
            
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            id = -1;
        }
        
        return id;
    }

    @Override
    public boolean actualizarPacienteNavegadora(PacienteNavegadora pacienteNavegadora) {
         Connection conn;
        CallableStatement cstmt;
        String stProcedure = "CALL actualizarPacienteNavegadora(?, ?)";
        boolean exito= false;
        ResultSet rs;
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, pacienteNavegadora.getIdPacienteNavegadora());
            cstmt.setInt(2, pacienteNavegadora.getIdPaciente());
            cstmt.setInt(3, pacienteNavegadora.getIdEmpleado());
            cstmt.setInt(4, pacienteNavegadora.getEstatus() );
            
            rs = cstmt.executeQuery();
            
            exito = rs.getBoolean(1);
            
            rs.close();
            cstmt.close();
            conn.close();
        }catch(SQLException ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            exito=false;
        }
        return exito;
    }

    @Override
    public boolean borradoLogicoPacienteNavegadora(int idPacienteNavegadora) {
        Connection conn; 
        CallableStatement cstmt;
        String stProcedure = "CALL borradoLogicoPacienteNavegadora()";
        boolean exito = false;
        ResultSet rs;
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idPacienteNavegadora);
            
            rs = cstmt.executeQuery();
            rs.next();
            
            exito = rs.getBoolean(1);
            
            rs.close();
            cstmt.close();
            conn.close();
        }catch( SQLException ex){
           
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            exito=false;
        }
        return exito;
    }

    @Override
    public PacienteNavegadora mostrarPacienteNavegadoraIdPaciente(int idPaciente) {
    Connection conn;
        CallableStatement cstmt;
        ResultSet rs;

        PacienteNavegadora pacienteNavegadora = new PacienteNavegadora();

        String stProcedure = "CALL mostrarPacienteNavegadoraIdPaciente(?)";
        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idPaciente);
            rs = cstmt.executeQuery();
            rs.next();

            pacienteNavegadora.setIdPacienteNavegadora(rs.getInt("idPaciente"));
            pacienteNavegadora.setIdPaciente(rs.getInt("idCuenta"));
            pacienteNavegadora.setIdEmpleado(rs.getInt("idEscolaridad"));
            pacienteNavegadora.setEstatus(rs.getInt("idSeguro"));

            rs.close();
            cstmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            pacienteNavegadora = null;
        }
        return pacienteNavegadora; 
    }

}
