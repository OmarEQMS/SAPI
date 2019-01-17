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
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import mx.itesm.sapi.bean.calendario.FullCalendar;
import mx.itesm.sapi.bean.gestionPaciente.Cita;
import mx.itesm.sapi.bean.persona.Cuenta;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Julio Badillo
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
                
                if(rs.getString("idTorre").equals("1")){
                    calendario.setColor("#6c757d");
                }else if(rs.getString("idTorre").equals("2") && rs.getString("Piso").equals("0")){ //planta baja
                    calendario.setColor("#17a2b8");
                }else if(rs.getString("idTorre").equals("2") && rs.getString("Piso").equals("1")){ //primer piso
                    calendario.setColor("#ffc107");                   
                }else if(rs.getString("idTorre").equals("2") && rs.getString("Piso").equals("2")){ //segundo piso
                    calendario.setColor("#FF53A9");
                }else{
                    calendario.setColor("#eb5865");
                }
                
                
                calendario.setEdificio(rs.getString("idTorre"));
                calendario.setPiso(rs.getString("Piso"));
                
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
    public int agregarEvento(Cita cita, String edificio) {
            
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;
        
        int id = -1;

        String stProcedure = "CALL agregarCita(?,?,?,?,?,?,?,?,?,?)";
        
        try{
            
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            
            cstmt.setInt(1, cita.getIdTipoCita());
            cstmt.setInt(2, cita.getIdPaciente());
            cstmt.setInt(3, cita.getIdEstadoCita());
            cstmt.setInt(4, cita.getIdImportanciaCita());
            cstmt.setInt(5, cita.getIdPiso());
            cstmt.setNull(6, java.sql.Types.INTEGER);
            cstmt.setNull(7, java.sql.Types.INTEGER);
            cstmt.setNull(8, java.sql.Types.INTEGER);
            cstmt.setTimestamp(9, cita.getFechaProgramada());
            cstmt.setTimestamp(10, cita.getFechaReal());
            //cstmt.setString(11, edificio);
  
            
            rs = cstmt.executeQuery();
            rs.next();
            id = rs.getInt(1);
            conn.close();
            rs.close();
            cstmt.close();
            
            
        }catch(SQLException ex){
            
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            id = -1;
            
        }
        
        return id;
    }

    @Override
    public List<FullCalendar> mostrarEventosResultados() {
        
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;
        
        List<FullCalendar> eventos = null;
        
        try{
            
            eventos = new ArrayList<>();
            conn = Conexion.getConnection();
            
            //llamar al procedimiento que te devuelva las citas
            cstmt = conn.prepareCall("CALL mostrarCitasPacienteR()");
            
            rs = cstmt.executeQuery();
            
            FullCalendar calendario;
            
            while(rs.next()){
                
                calendario = new FullCalendar();
                calendario.setTitle(rs.getString("nombre").concat(" ").concat(rs.getString("primerApellido")));
                calendario.setStart(rs.getString("fechaReal"));
                
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

    
}
