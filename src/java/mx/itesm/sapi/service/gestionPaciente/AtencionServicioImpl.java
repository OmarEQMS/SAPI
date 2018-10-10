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
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.Atencion;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author urieldiaz
 */
public class AtencionServicioImpl implements AtencionServicio{

    @Override
    public Atencion mostrarAtencionServicio(int idAtencion) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure= "---";
        Atencion atencion = null;
     
        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);                                    
            cstmt.setInt(1, idAtencion);
            atencion = new Atencion();
            
            rs = cstmt.executeQuery();
            rs.next();
            
            atencion.setIdAtencion(rs.getInt("idAtencion"));
            atencion.setIdPaciente(rs.getInt("idPaciente"));
            atencion.setIdEmpleado(rs.getInt("idEmpleado"));
            atencion.setMedicoSustituto(rs.getInt("medicoSustituto"));
            atencion.setMedicoPresente(rs.getInt("medicoPresente"));
            atencion.setAdscrito(rs.getInt("adscrito"));
            
            conn.close();
            cstmt.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            atencion = null;
        }   
        return atencion;
    }

    @Override
    public List<Atencion> mostrarAtencionServicio() {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure="---";
        
        List <Atencion> atenciones = null;
        Atencion atencion; 
        
        try{
            conn  = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            atenciones = new ArrayList();
            
            while(rs.next()){
                atencion = new Atencion();
                
                atencion.setIdAtencion(rs.getInt("idAtencion"));
                atencion.setIdPaciente(rs.getInt("idPaciente"));
                atencion.setIdEmpleado(rs.getInt("idEmpleado"));
                atencion.setMedicoSustituto(rs.getInt("medicoSustituto"));
                atencion.setEstatus(rs.getInt("estatus"));
                atencion.setMedicoPresente(rs.getInt("medicoPresente"));
                atencion.setAdscrito(rs.getInt("adscrito"));
                atenciones.add(atencion);
            }
            rs.close();
            cstmt.close();
            conn.close();
        }catch(SQLException ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            atenciones = null;
        }
        return atenciones;
    }

    @Override
    public int agregarAtencion(Atencion atencion) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure="---";
        int id = -1;
        
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1,atencion.getIdPaciente());
            cstmt.setInt(2,atencion.getIdEmpleado());
            cstmt.setInt(3,atencion.getMedicoSustituto());
            cstmt.setInt(4,atencion.getMedicoPresente());
            cstmt.setInt(5, atencion.getAdscrito());
            
            rs = cstmt.executeQuery();
            rs.next();
            id = rs.getInt(1);
            
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
    public boolean actualizarAtencion(Atencion atencion) {
      Connection conn;
      CallableStatement cstmt;
      String stProcedure = "---";
      boolean exito = false;

	try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1,atencion.getIdPaciente());
            cstmt.setInt(2,atencion.getIdEmpleado());
            cstmt.setInt(3,atencion.getMedicoSustituto());
            cstmt.setInt(4,atencion.getMedicoPresente());
            cstmt.setInt(5,atencion.getAdscrito());
            cstmt.registerOutParameter(1, Types.BOOLEAN);
            
            cstmt.executeUpdate();
            exito = cstmt.getBoolean(1);
            
            conn.close();
            cstmt.close();
	}catch(SQLException ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            exito = false;
	}
        return exito;
    }

    @Override
    public boolean borradoLogicoAtencion(int idAtencion) {
        Connection conn;
        CallableStatement cstmt;
        String stProcedure = "---";
        boolean exito = false;

	try{
            conn  = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1,idAtencion);
            cstmt.registerOutParameter(1, Types.BOOLEAN);
            
            cstmt.executeUpdate();
            exito = cstmt.getBoolean(1);
            
            conn.close();
            cstmt.close();
	}catch(SQLException ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            exito = false;
	}
        return exito;
    }
    
}
