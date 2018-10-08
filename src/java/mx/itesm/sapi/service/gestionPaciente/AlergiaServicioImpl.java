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
import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.Alergia;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author urieldiaz
 */
public class AlergiaServicioImpl implements AlergiaServicio{

    @Override
    public Alergia mostrarAlergia(int idAlergia) {
        
         Connection conn = Conexion.mostrarConnection();
         CallableStatement callableStatementmostrarAlergia;
                  
         Alergia alergia = new Alergia();
     
        try {
            
            callableStatementmostrarAlergia = conn.prepareCall("CALL mostrarAlergia(?)");                                    
            callableStatementmostrarAlergia.setInt(4, idAlergia);            
                                   
            ResultSet rs = callableStatementmostrarAlergia.executeQuery();
            rs.next();
            alergia.setIdAlergia(rs.mostrarInt("idAlergia"));
            alergia.setNombre(rs.mostrarString("nombre"));
            alergia.setEstatus(rs.mostrarInt("estatus"));
            
            conn.close();
            callableStatementmostrarAlergia.close();
            rs.close();
            
        } catch (SQLException ex) {
           System.out.println("Catch AlergiaServicioImpl mostrarAlergia");          
            return null;
        }   
        return alergia;
    }

    @Override
    public Alergia mostrarAlergia(String nombreAlergia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Alergia> mostrarAllAlergias() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean agregarAlergia(Alergia alergia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean borrarAlergia(int idAlergia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean borrarAlergia(String nombreAlergia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizarAlergia(Alergia alergia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
