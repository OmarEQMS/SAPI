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
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author urieldiaz
 */
public class MedicoPacienteServicioImpl implements MedicoPacienteServicio {

    @Override
    public int reasignarMedicoPaciente(int idPersona1, int idPersona2) {
        Connection conn = Conexion.getConnection();

        CallableStatement cstmt;

        int total  = 0;
        //Aquí va el call del procedure
        String stProcedure = "CALL superReasignarMedicos(?,?)";       
        ResultSet rs;
                    
        try {
                        
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1,idPersona1);
            cstmt.setInt(2,idPersona2);            

            rs = cstmt.executeQuery();
            
            while(rs.next())
            {
               total =  rs.getInt(1);
            }            
            
            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {

            System.out.println("Catch reasignarMedicoPaciente");
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage())); 
            total = 0;
        }
        return total;
    }
    
}
