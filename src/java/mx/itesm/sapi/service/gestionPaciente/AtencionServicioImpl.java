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
import mx.itesm.sapi.bean.gestionPaciente.Atencion;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author urieldiaz
 */
public class AtencionServicioImpl implements AtencionServicio{

    @Override
    public Atencion mostrarAtencionServicio(int idAtencionServicio) {
        Connection conn = Conexion.getConnection();
         CallableStatement cstmt;
         
         String stProcedure= "---";
         Atencion atencion = new Atencion();
     
        try {
            
            cstmt = conn.prepareCall(stProcedure);                                    
            cstmt.setInt(4, idAtencionServicio);            
                                   
            ResultSet rs = cstmt.executeQuery();
            rs.next();
            atencion.setIdAtencion(rs.getInt("idAtencion"));
            atencion.setIdPaciente(rs.getInt("idPaciente"));
            atencion.setIdEmpleado(rs.getInt("idEmpleado"));
            atencion.setMedicoSustituto(rs.getInt("medicoSustituto"));
            atencion.setEstatus(rs.getInt("estatus"));
            atencion.setMedicoPresente(rs.getInt("medicoPresente"));
            
            conn.close();
            cstmt.close();
            rs.close();
            
        } catch (SQLException e) {
           System.out.println("ERROR mostrarAlergia" + e.getMessage());          
            return null;
        }   
        return atencion;
    }

    @Override
    public List<Atencion> mostrarAllAtencionServicio() {
        Connection conn = Conexion.getConnection();
        CallableStatement cstmt;
        
        List <Atencion> atenciones = new ArrayList();
        
        //Call the store procedure
        String stProcedure="---";
        try{
            cstmt = conn.prepareCall(stProcedure);
            ResultSet rs = cstmt.executeQuery();
            Atencion atencion; 
           
            while(rs.next()){
                atencion = new Atencion();
                
                atencion.setIdAtencion(rs.getInt("idAtencion"));
                atencion.setIdPaciente(rs.getInt("idPaciente"));
                atencion.setIdEmpleado(rs.getInt("idEmpleado"));
                atencion.setMedicoSustituto(rs.getInt("medicoSustituto"));
                atencion.setEstatus(rs.getInt("estatus"));
                atencion.setMedicoPresente(rs.getInt("medicoPresente"));
                
                atenciones.add(atencion);
            }
            rs.close();
            cstmt.close();
            conn.close();
        }catch(SQLException e){
            System.out.println("ERROR mostrarAllAtencionServicio"+e.getMessage());
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return atenciones;
    }

    @Override
    public boolean agregarAtencion(Atencion atencion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    public boolean deleteAtencion(int idAtencion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizarAtencion(Atencion atencion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean borradoLogicoAtencion(int idAtencion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
