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
import mx.itesm.sapi.bean.gestionPaciente.LlamadaCita;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Uriel Díaz
 */
public class LlamadaCitaServicioImpl implements LlamadaCitaServicio {
    
    @Override
    public LlamadaCita mostrarLlamadaCita(int idLlamadaCita) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        LlamadaCita llamadaCita = null;
        String stProcedure = "CALL mostrarLlamadaCita(?)";
        try {
            conn = Conexion.getConnection();
            llamadaCita = new LlamadaCita();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idLlamadaCita);
            rs = cstmt.executeQuery();
            rs.next();

            llamadaCita.setIdLlamadaCita(rs.getInt("idLlamadaCita"));
            llamadaCita.setIdCita(rs.getInt("idCita"));
            llamadaCita.setIdEmpleado(rs.getInt("idEmpleado"));
            llamadaCita.setFecha(rs.getTimestamp("fecha"));
            llamadaCita.setLlamada(rs.getInt("llamada"));
            llamadaCita.setEstatus(rs.getInt("estatus"));

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            llamadaCita = null;
        }
        return llamadaCita;
    }

    @Override
    public List<LlamadaCita> mostrarLlamadaCita() {
        Connection conn;
        List<LlamadaCita> llamadaCitas = new ArrayList<>();
        CallableStatement cstmt;
        String stProcedure = "CALL mostrarListaLlamadaCita()";

        ResultSet rs;

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            LlamadaCita llamadaCita;

            while (rs.next()) {
                llamadaCita = new LlamadaCita();
                llamadaCita.setIdLlamadaCita(rs.getInt("idLllamadaCita"));
                llamadaCita.setIdCita(rs.getInt("idCita"));
                llamadaCita.setIdEmpleado(rs.getInt("idEmpleado"));
                llamadaCita.setFecha(rs.getTimestamp("fecha"));
                llamadaCita.setLlamada(rs.getInt("llamada"));
                llamadaCita.setEstatus(rs.getInt("estatus"));

                llamadaCitas.add(llamadaCita);
            }

            rs.close();
            cstmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            llamadaCitas = null;
        }
        return llamadaCitas;
    }

    @Override
    public int agregarLlamadaCita(LlamadaCita llamadaCita) {
        Connection conn; 
        ResultSet rs;
        CallableStatement cstmt;
        int id = -1;
        String stPrcedure="CALL agregarLlamadaCita(?, ?, ?, ?)";
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stPrcedure);
            
            cstmt.setInt(1, llamadaCita.getIdLlamadaCita());
            cstmt.setInt(2, llamadaCita.getIdCita());
            cstmt.setInt(3, llamadaCita.getIdEmpleado());
            cstmt.setTimestamp(4, llamadaCita.getFecha() );
            cstmt.setInt(5, llamadaCita.getLlamada());
            cstmt.setInt(6, llamadaCita.getEstatus());

            
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
    public boolean actualizarLlamadaCita(LlamadaCita llamadaCita) {
       Connection conn;
        CallableStatement cstmt;
        String stProcedure = "CALL actualizarLlamadaCita(?, ?, ?, ?)";
        boolean exito= false;
        ResultSet rs;
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            
            cstmt.setInt(1, llamadaCita.getIdLlamadaCita());
            cstmt.setInt(2, llamadaCita.getIdCita());
            cstmt.setInt(3, llamadaCita.getIdEmpleado());
            cstmt.setTimestamp(4, llamadaCita.getFecha() );
            cstmt.setInt(5, llamadaCita.getLlamada());
            cstmt.setInt(6, llamadaCita.getEstatus() );
            
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
    public boolean borradoLogicoLlamadaCita(int idLlamadaCita) {
         Connection conn; 
        CallableStatement cstmt;
        String stProcedure = "CALL actualizarLlamadaCita(?)";
        boolean exito = false;
        ResultSet rs;
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idLlamadaCita);
            
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
    public LlamadaCita mostrarLlamadaCitaIdCita(int idCita) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        LlamadaCita llamadaCita = new LlamadaCita();
        String stProcedure = "CALL mostrarLlamadaCitaIdCita(?)";
        
        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idCita);
            rs = cstmt.executeQuery();
            rs.next();

            llamadaCita.setIdLlamadaCita(rs.getInt("idLllamadaCita"));
            llamadaCita.setIdCita(rs.getInt("idCita"));
            llamadaCita.setIdEmpleado(rs.getInt("idEmpleado"));
            llamadaCita.setFecha(rs.getTimestamp("fecha"));
            llamadaCita.setLlamada(rs.getInt("llamada"));
            llamadaCita.setEstatus(rs.getInt("estatus"));

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            llamadaCita = null;
        }
        return llamadaCita;
    }

    @Override
    public List<LlamadaCita> mostrarLlamaCitaPreconsultaPaciente(int idPaciente) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL mostrarLlamadaCitaPreconsultaPaciente(?)";
        List<LlamadaCita> llamadasCita = new ArrayList();
        
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idPaciente);
        
            rs = cstmt.executeQuery();
            LlamadaCita llamadaCita;
            
            while(rs.next())
            {
                llamadaCita = new LlamadaCita();
                llamadaCita.setIdLlamadaCita(rs.getInt("idLlamadaCita"));
                llamadaCita.setIdCita(rs.getInt("idCita"));
                llamadaCita.setIdEmpleado(rs.getInt("idEmpleado"));
                llamadaCita.setFecha(rs.getTimestamp("fecha"));
                llamadaCita.setLlamada(rs.getInt("llamada"));
                llamadaCita.setEstatus(rs.getInt("estatus"));
            }
        }catch(SQLException ex)
        {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            llamadasCita = null;
        }
        return llamadasCita;
    }

}
