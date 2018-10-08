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
    public Alergia getAlergia(int idAlergia) {
        
         Connection conn = Conexion.getConnection();
         CallableStatement callableStatementGetAlergia;
                  
         Alergia alergia = new Alergia();
     
        try {
            
            callableStatementGetAlergia = conn.prepareCall("CALL mostrarAlergia(?)");                                    
            callableStatementGetAlergia.setInt(4, idAlergia);            
                                   
            ResultSet rs = callableStatementGetAlergia.executeQuery();
            rs.next();
            alergia.setIdAlergia(rs.getInt("idAlergia"));
            alergia.setNombre(rs.getString("nombre"));
            alergia.setEstatus(rs.getInt("estatus"));
            
            conn.close();
            callableStatementGetAlergia.close();
            rs.close();
            
        } catch (SQLException ex) {
           System.out.println("Catch AlergiaServicioImpl getAlergia");          
            return null;
        }   
        return alergia;
    }

    @Override
    public Alergia getAlergia(String nombreAlergia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Alergia> getAllAlergias() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean saveAlergia(Alergia alergia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteAlergia(int idAlergia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteAlergia(String nombreAlergia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateAlergia(Alergia alergia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
