/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.moduloGestionMedico;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.itesm.sapi.bean.moduloGestionMedico.EmpleadoPosicion;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Fernanda Orduña & Pablo Lugo
 */
public class EmpleadoPosicionServicioImpl implements EmpleadoPosicionServicio {

    @Override
    public EmpleadoPosicion mostrarEmpleadoPosicion(int idEmpleadoPosicion) {
        Connection conn = Conexion.getConnection();

        CallableStatement cstmt;

        EmpleadoPosicion empleadoPosicion = new EmpleadoPosicion();

        //Call del store procedure
        String stProcedure = "-----";

        try {

            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idEmpleadoPosicion);
            ResultSet rs = cstmt.executeQuery();

            rs.next();
            empleadoPosicion.setIdEmpleadoPosicion(rs.getInt(1));
            empleadoPosicion.setIdEmpleado(rs.getInt(2));
            empleadoPosicion.setIdPosicion(rs.getInt(3));
            empleadoPosicion.setInicio(rs.getTimestamp(4));
            empleadoPosicion.setEstatus(rs.getInt(5));

            return empleadoPosicion;
        } catch (SQLException ex) {

            System.out.println("Estoy en el catch de mostrarEmpleadoPosicion");
            System.out.println(ex.getMessage());
            return empleadoPosicion;
        }
    }

    @Override
    public List<EmpleadoPosicion> mostrarEmpleadoPosicion() {
        Connection conn = Conexion.getConnection();

        List<EmpleadoPosicion> empleadosPosiciones = new ArrayList<>();
        CallableStatement cstmt;

        try {

            cstmt = conn.prepareCall("CALL -----");
            ResultSet rs = cstmt.executeQuery();
            EmpleadoPosicion empleadoPosicion;

            while (rs.next()) {

                empleadoPosicion = new EmpleadoPosicion();

                empleadoPosicion.setIdEmpleadoPosicion(rs.getInt(1));
                empleadoPosicion.setIdEmpleado(rs.getInt(2));
                empleadoPosicion.setIdPosicion(rs.getInt(3));
                empleadoPosicion.setInicio(rs.getTimestamp(4));
                empleadoPosicion.setEstatus(rs.getInt(5));

                empleadosPosiciones.add(empleadoPosicion);

            }

            rs.close();
            cstmt.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("ERROR GET ESTADOS" + e.getMessage());
        }

        return empleadosPosiciones;
    }

    @Override
    public int agregarEmpleadoPosicion(EmpleadoPosicion empleadoPosicion) {
        Connection conn = Conexion.getConnection();
        
        CallableStatement cstmt;
        
        int id=0;
        //Aquí va el call del procedure
        String stProcedure="CALL agregarEmpleadoPosicion(?,?,?)";
        
        try{
            
            cstmt = conn.prepareCall(stProcedure);
            
            //Aquí van los sets
           
            //cstmt.setInt(1,empleadoPosicion.getIdEmpleadoPosicion());
            cstmt.setInt(1,empleadoPosicion.getIdEmpleado());
            cstmt.setInt(2,empleadoPosicion.getIdPosicion());
            cstmt.setTimestamp(3,empleadoPosicion.getInicio());            
            
            
            //Aquí va el registerOutParameter
            //cstmt.registerOutParameter(12,Types.INTEGER);
                                    
            ResultSet rs = cstmt.executeQuery();
            
            rs.next();
            
            id=rs.getInt(1); 
           
           cstmt.close();
            
        }catch(SQLException ex){
            
             System.out.println("Estoy en el catch de agregarEmpleadoPosicion");
            System.out.println(ex.getMessage());
            
        }
        
        
        return id;
    }

    @Override
    public boolean borradoLogicoEmpleadoPosicion(int idEmpleadoPosicion) {
        Connection conn = Conexion.getConnection();
        
        CallableStatement cstmt;
        
        //Call del store procedure
        String stProcedure="";
        
        
        
        try{
            
            cstmt = conn.prepareCall(stProcedure);
            
            cstmt.setInt(1,idEmpleadoPosicion);
            
            ResultSet rs = cstmt.executeQuery();
            
            rs.next();
            
           return rs.getBoolean(1);
            
            
        }catch(SQLException ex){
            System.out.println("Estoy en el catch de borradoLogicoEmpleadoPosicion");
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean actualizarEmpleadoPosicion(EmpleadoPosicion empleadoPosicion) {
        Connection conn = Conexion.getConnection();
        
        CallableStatement cstmt;
        
        //Call del store procedure
        String stProcedure="";
        
        
        try{
            
            cstmt = conn.prepareCall(stProcedure);
            
           cstmt.setInt(1,empleadoPosicion.getIdEmpleadoPosicion());
            cstmt.setInt(2,empleadoPosicion.getIdEmpleado());
            cstmt.setInt(3,empleadoPosicion.getIdPosicion());
            cstmt.setTimestamp(4,empleadoPosicion.getInicio());
            cstmt.setInt(5,empleadoPosicion.getEstatus());
            
            
            ResultSet rs = cstmt.executeQuery();
            
            rs.next();
            
           return rs.getBoolean(1);
            
            
        }catch(SQLException ex){
            System.out.println("Estoy en el catch de actualizarEmpleadoPosicion");
            System.out.println(ex.getMessage());
            return false;
        }
    }

}