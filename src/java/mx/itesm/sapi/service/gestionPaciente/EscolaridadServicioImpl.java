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
import mx.itesm.sapi.bean.gestionPaciente.Escolaridad;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Oscar Miranda
 */
public class EscolaridadServicioImpl implements EscolaridadServicio {

    @Override
    public int agregarEscolaridad(Escolaridad escolaridad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean borradoLogicoEscolaridad(int idEscolaridad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizarEscolaridad(Escolaridad escolaridad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Escolaridad> mostrarEscolaridades() {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        //List<Persona> personas = null;
        List<Escolaridad> escolaridades = null;

        try {
            escolaridades = new ArrayList<>();
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall("CALL mostrarListaEscolaridad(?)");
            rs = cstmt.executeQuery();
            Escolaridad escolaridad;

            while (rs.next()) {  

                escolaridad = new Escolaridad();
                escolaridad.setIdEscolaridad(rs.getInt("idEscolaridad"));
                escolaridad.setNombre(rs.getString("nombre"));
                escolaridad.setEstatus(rs.getInt("estatus"));

                escolaridades.add(escolaridad);

            }
        } catch (Exception ex) {
            System.out.println("PersonaServicioImpl mostrarPersona");
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }

        return escolaridades;
    }
    
}
