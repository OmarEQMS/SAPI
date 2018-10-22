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
import java.util.List;
import mx.itesm.sapi.bean.calendario.FullCalendar;
import mx.itesm.sapi.bean.persona.Cuenta;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author julioguzman
 */
public class CalendarioServicioImpl implements CalendarioServicio {

    @Override
    public List<FullCalendar> mostrarEventos(int idPaciente) {
        
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;
        
        List<FullCalendar> eventos = null;
        
        try{
            
            eventos = new ArrayList<>();
            conn = Conexion.getConnection();
            
            //llamar al procedimiento que te devuelva las citas
            cstmt = conn.prepareCall("CALL mostrarEventos(?)");
            cstmt.setInt(1, idPaciente);
            
            rs = cstmt.executeQuery();
            
            FullCalendar calendario;
            
            while(rs.next()){
                
                calendario = new FullCalendar();
                calendario.setTitle(rs.getString("nombre"));
                calendario.setStart(rs.getString("fechaProgramada"));
                calendario.setEnd(rs.getString("fechaProgramada"));
                
                eventos.add(calendario);
                
            }
            
            rs.close();
            cstmt.close();
            conn.close();
            
        }catch (SQLException ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            eventos = null;
        }
        
        return eventos;
     
    }

    @Override
    public int agregarEvento(FullCalendar calendario) {
        
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;
        
        int id = -1;
        
        String stProcedure = "CALL agregarCita(?, ?, ?, ?, ?, ?)";
        
        return 0;
      
    }
    
}
