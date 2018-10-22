/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.persona;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.itesm.sapi.bean.persona.Pic;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Diego
 */
public class PicServicioImpl implements PicServicio {

    @Override
    public int agregarPic(Pic pic) {
                
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
                        
        //Id para devolver
        int id = -1;
        
        //Aquí va el call del procedure
        String stProcedure="CALL agregarPic(?,?,?,?)";
        
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            
            //Aquí van los sets
            
            cstmt.setInt(1,pic.getIdPersona());
            cstmt.setBinaryStream(2,pic.getContenido());
            cstmt.setInt(3,pic.getTamano());
            cstmt.setString(4,pic.getTipo());
            
            rs = cstmt.executeQuery();
            
            rs.next();
            
            id = rs.getInt(1);
            
            System.out.println("Llegó, el id es: " + id);
            
            rs.close();
            cstmt.close();
            conn.close();
            
        }catch(SQLException ex){
            id = -1;
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return id;
    }

    @Override
    public Pic mostrarPic(int idPic) {
        
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        Pic pic = null;
        
        //Call del stored procedure
        String stProcedure="CALL mostrarPic(?)";
        
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            pic = new Pic();
            
            cstmt.setInt(1, idPic);
            rs = cstmt.executeQuery();
            
            rs.next();
            pic.setIdPic(rs.getInt(1));
            pic.setIdPersona(rs.getInt(2));
            pic.setContenido(rs.getBinaryStream(3));
            pic.setTamano(rs.getInt(4));
            pic.setTipo(rs.getString(5));
            pic.setEstatus(rs.getInt(6));
            
            rs.close();
            cstmt.close();
            conn.close();
           
        }catch(SQLException ex){
            pic = null;
            System.out.println("ID: " + idPic);
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return pic;
    }

    @Override
    public List<Pic> mostrarPic() {
        
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        List<Pic> tiposTratamiento = null;
        
        //Call del stored procedure
        String stProcedure="CALL mostrarListaPic(?)";
        
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            tiposTratamiento = new ArrayList<>();
            
            rs = cstmt.executeQuery();
            Pic pic;
            
            while(rs.next()){
                pic = new Pic();
                pic.setIdPic(rs.getInt(1));
                pic.setIdPersona(rs.getInt(2));
                pic.setContenido(rs.getBinaryStream(3));
                pic.setTamano(rs.getInt(4));
                pic.setTipo(rs.getString(5));
                pic.setEstatus(rs.getInt(6));

                tiposTratamiento.add(pic);
            }
            
            rs.close();
            cstmt.close();
            conn.close();
            
        }catch(SQLException ex) {
           tiposTratamiento = null;
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return tiposTratamiento;
    }

    @Override
    public boolean actualizarPic(Pic pic) {
        
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        boolean exito = false;
        
        //Call del store procedure
        String stProcedure="CALL actualizarPic(?,?,?,?)";
        
        
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            
            cstmt.setInt(1, pic.getIdPic());
            cstmt.setInt(2, pic.getIdPersona());
            cstmt.setBinaryStream(3, pic.getContenido());
            cstmt.setInt(4, pic.getTamano());
            cstmt.setString(5, pic.getTipo());
            cstmt.setInt(6, pic.getEstatus());
            
            rs = cstmt.executeQuery();
            
            rs.next();
            
            exito = rs.getBoolean(1);
            
            rs.close();
            cstmt.close();
            conn.close();
            
        }catch(SQLException ex){
            exito = false;
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return exito;
    }

    @Override
    public boolean borradoLogicoPic(int idPic) {
        
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        boolean exito = false;
        
        //Call del store procedure
        String stProcedure="CALL borradoLogicoPic(?)";
        
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            
            cstmt.setInt(1, idPic);
            
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
