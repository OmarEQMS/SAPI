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
        
         Connection conn = Conexion.getConnection();
         CallableStatement callableStatementmostrarAlergia;
                  
         Alergia alergia = new Alergia();
     
        try {
            
            callableStatementmostrarAlergia = conn.prepareCall("CALL mostrarAlergia(?)");                                    
            callableStatementmostrarAlergia.setInt(4, idAlergia);            
                                   
            ResultSet rs = callableStatementmostrarAlergia.executeQuery();
            rs.next();
            alergia.setIdAlergia(rs.getInt("idAlergia"));
            alergia.setNombre(rs.getString("nombre"));
            alergia.setEstatus(rs.getInt("estatus"));
            
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
    public boolean borradoLogicoAlergia(int idAlergia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean borradoLogicoAlergia(String nombreAlergia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizarAlergia(Alergia alergia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
