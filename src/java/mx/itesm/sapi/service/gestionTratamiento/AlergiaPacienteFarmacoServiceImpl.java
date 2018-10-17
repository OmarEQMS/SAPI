/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionTratamiento;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.itesm.sapi.bean.gestionTratamiento.AlergiaPacienteFarmaco;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Diego
 */
public class AlergiaPacienteFarmacoServiceImpl implements AlergiaPacienteFarmacoService {
    
    @Override
    public int agregarAlergiaPacienteFarmaco(AlergiaPacienteFarmaco alergiaPacienteFarmaco) {
                
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
                        
        //Id para devolver
        int id = -1;
        
        //Aquí va el call del procedure
        String stProcedure="CALL agregarAlergiaPacienteFarmaco(?,?,?,?)";
        
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            
            //Aquí van los sets
            
            cstmt.setInt(1,alergiaPacienteFarmaco.getIdAlergiaPacienteFarmaco());
            cstmt.setInt(2,alergiaPacienteFarmaco.getIdPaciente());
            cstmt.setInt(3,alergiaPacienteFarmaco.getIdFarmaco());
            cstmt.setInt(4, alergiaPacienteFarmaco.getEstatus());
            
            cstmt.executeUpdate();
            
            rs = cstmt.getGeneratedKeys();
            rs.next();
            
            id = cstmt.getInt(1);
           
            rs.close();
            cstmt.close();
            conn.close();
            
        }catch(SQLException ex){
            id = -1;
            System.out.println("IdPaciente: " + alergiaPacienteFarmaco.getIdPaciente());
            System.out.println("Farmaco: " + alergiaPacienteFarmaco.getIdFarmaco());
            System.out.println("Estatus: " + alergiaPacienteFarmaco.getEstatus());
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return id;
    }

    @Override
    public AlergiaPacienteFarmaco mostrarAlergiaPacienteFarmaco(int idAlergiaPacienteFarmaco) {
        
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        AlergiaPacienteFarmaco alergiaPacienteFarmaco = null;
        
        //Call del stored procedure
        String stProcedure="CALL mostrarAlergiaPacienteFarmaco(?)";
        
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            alergiaPacienteFarmaco = new AlergiaPacienteFarmaco();
            
            cstmt.setInt(1, idAlergiaPacienteFarmaco);
            rs = cstmt.executeQuery();
            
            rs.next();
            alergiaPacienteFarmaco.setIdAlergiaPacienteFarmaco(rs.getInt(1));
            alergiaPacienteFarmaco.setIdPaciente(rs.getInt(2));
            alergiaPacienteFarmaco.setIdFarmaco(rs.getInt(3));
            alergiaPacienteFarmaco.setEstatus(rs.getInt(4));
            
            rs.close();
            cstmt.close();
            conn.close();
           
        }catch(SQLException ex){
            alergiaPacienteFarmaco = null;
            System.out.println("ID: " + idAlergiaPacienteFarmaco);
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return alergiaPacienteFarmaco;
    }

    @Override
    public List<AlergiaPacienteFarmaco> mostrarAlergiaPacienteFarmaco() {
        
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        List<AlergiaPacienteFarmaco> alergiasPacienteFarmaco = null;
        
        //Call del stored procedure
        String stProcedure="CALL mostrarListaAlergiaPacienteFarmaco()";
        
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            alergiasPacienteFarmaco = new ArrayList<>();
            
            rs = cstmt.executeQuery();
            AlergiaPacienteFarmaco alergiaPacienteFarmaco;
            
            while(rs.next()){
                alergiaPacienteFarmaco = new AlergiaPacienteFarmaco();
                alergiaPacienteFarmaco.setIdAlergiaPacienteFarmaco(rs.getInt(1));
                alergiaPacienteFarmaco.setIdPaciente(rs.getInt(2));
                alergiaPacienteFarmaco.setIdFarmaco(rs.getInt(3));
                alergiaPacienteFarmaco.setEstatus(rs.getInt(4));

                alergiasPacienteFarmaco.add(alergiaPacienteFarmaco);
            }
            
            rs.close();
            cstmt.close();
            conn.close();
            
        }catch(SQLException ex) {
           alergiasPacienteFarmaco = null;
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return alergiasPacienteFarmaco;
    }

    @Override
    public boolean actualizarAlergiaPacienteFarmaco(AlergiaPacienteFarmaco alergiaPacienteFarmaco) {
        
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        boolean exito = false;
        
        //Call del store procedure
        String stProcedure="CALL actualizarAlergiaPacienteFarmaco(?,?,?,?)";
        
        
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            
            cstmt.setInt(1, alergiaPacienteFarmaco.getIdAlergiaPacienteFarmaco());
            cstmt.setInt(2, alergiaPacienteFarmaco.getIdPaciente());
            cstmt.setInt(3,alergiaPacienteFarmaco.getIdFarmaco());
            cstmt.setInt(4, alergiaPacienteFarmaco.getEstatus());
            
            rs = cstmt.executeQuery();
            
            rs.next();
            
            exito = rs.getBoolean(1);
            
            rs.close();
            cstmt.close();
            conn.close();
            
        }catch(SQLException ex){
            exito = false;
            System.out.println("IdAlergiaPacienteFarmaco: " + alergiaPacienteFarmaco.getIdAlergiaPacienteFarmaco());
            System.out.println("IdPaciente: " + alergiaPacienteFarmaco.getIdPaciente());
            System.out.println("Farmaco: " + alergiaPacienteFarmaco.getIdFarmaco());
            System.out.println("Estatus: " + alergiaPacienteFarmaco.getEstatus());
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return exito;
    }

    @Override
    public boolean borradoLogicoAlergiaPacienteFarmaco(int idAlergiaPacienteFarmaco) {
        
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        boolean exito = false;
        
        //Call del store procedure
        String stProcedure="CALL borradoLogicoAlergiaPacienteFarmaco(?)";
        
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            
            cstmt.setInt(1, idAlergiaPacienteFarmaco);
            
            rs = cstmt.executeQuery();
            
            rs.next();
            
           exito = rs.getBoolean(1);
            
            
        }catch(SQLException ex){
            exito = false;
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return exito;
    }
}
