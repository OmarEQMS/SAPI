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
import java.util.ArrayList;
import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.PacienteMedicoTitular;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Angel GTZ
 */
public class PacienteMedicoTitularServicioImpl implements PacienteMedicoTitularServicio{

    @Override
    public PacienteMedicoTitular mostrarPacienteMedicoTitular(int idPacienteMedicoTitular) {
           Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        PacienteMedicoTitular pacienteMedicoTitular = null;

        //Call del store procedure
        String stProcedure = "mostrarPacienteMedicoTitular(?)";

        try {
            pacienteMedicoTitular = new PacienteMedicoTitular();
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idPacienteMedicoTitular);

            rs = cstmt.executeQuery();

            rs.next();
            
            pacienteMedicoTitular.setIdPacienteMedicoTitular(rs.getInt("idPacienteMedicoTitular"));
            pacienteMedicoTitular.setIdPaciente(rs.getInt("idPaciente"));
            pacienteMedicoTitular.setIdEmpleado(rs.getInt("idEmpleado"));
            pacienteMedicoTitular.setInicio(rs.getTimestamp("inicio"));
            pacienteMedicoTitular.setFin(rs.getTimestamp("fin"));
            pacienteMedicoTitular.setEstatus(rs.getInt("estatus"));
            
        
            rs.close();
            cstmt.close();
            conn.close();
        }catch(SQLException ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            pacienteMedicoTitular= null;
        }
        return pacienteMedicoTitular;
        
    }

    @Override
    public List<PacienteMedicoTitular> mostrarPacienteMedicoTitular() {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        List<PacienteMedicoTitular> pacienteMedicoTitulars = null;

        try {
            pacienteMedicoTitulars = new ArrayList<>();
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall("mostrarListapacienteMedicoTitular()");
            rs = cstmt.executeQuery();
            PacienteMedicoTitular pacienteMedicoTitular;

            while (rs.next()) {

                pacienteMedicoTitular = new PacienteMedicoTitular();
                 pacienteMedicoTitular.setIdPacienteMedicoTitular(rs.getInt("idPacienteMedicoTitular"));
            pacienteMedicoTitular.setIdPaciente(rs.getInt("idPaciente"));
            pacienteMedicoTitular.setIdEmpleado(rs.getInt("idEmpleado"));
            pacienteMedicoTitular.setInicio(rs.getTimestamp("inicio"));
            pacienteMedicoTitular.setFin(rs.getTimestamp("fin"));
            pacienteMedicoTitular.setEstatus(rs.getInt("estatus"));

                pacienteMedicoTitulars.add(pacienteMedicoTitular);

            }

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            pacienteMedicoTitulars = null;
        }

        return pacienteMedicoTitulars;
    }

    @Override
    public int agregarPacienteAlergia(PacienteMedicoTitular pacienteMedicoTitular) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizarPacienteMedicoTitular(PacienteMedicoTitular pacienteMedicoTitular) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean borradoLogicoPacienteMedicoTitular(int idPacienteMedicoTitular) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
