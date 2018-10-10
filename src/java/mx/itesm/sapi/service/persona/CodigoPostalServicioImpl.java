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
import mx.itesm.sapi.bean.persona.CodigoPostal;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Angel GTZ
 */
public class CodigoPostalServicioImpl implements CodigoPostalServicio {

    @Override
    public CodigoPostal mostrarCodigoPostal(int idCodigoPostal) {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        CodigoPostal codigoPostal=null;

        //Call del store procedure
        String stProcedure = "mostrarCodigoPostal(?)";

        try {
            codigoPostal = new CodigoPostal();
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idCodigoPostal);

            rs = cstmt.executeQuery();

            rs.next();
            codigoPostal.setIdCodigoPostal(rs.getInt("idCodigoPostal"));
            codigoPostal.setNumero(rs.getString("numero"));
            codigoPostal.setIdMunicipio(rs.getInt("idMunicipio"));
            codigoPostal.setEstatus(rs.getInt("estatus"));
            conn.close();
            rs.close();
            cstmt.close();
            
        } catch (SQLException ex) {

           System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            codigoPostal=null;
            
        }
        return codigoPostal;
    }

    @Override
    public List<CodigoPostal> mostrarCodigoPostal() {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

      
        List<CodigoPostal> codigosPostal = null;

        try {
            codigosPostal = new ArrayList<>();
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall("mostrarListaCodigoPostal()");
            rs = cstmt.executeQuery();
            CodigoPostal codigoPostal;

            while (rs.next()) {

                codigoPostal = new CodigoPostal();

                codigoPostal.setIdCodigoPostal(rs.getInt(1));
                codigoPostal.setNumero(rs.getString(2));
                codigoPostal.setIdMunicipio(rs.getInt(3));
                codigoPostal.setEstatus(rs.getInt(4));

                codigosPostal.add(codigoPostal);

            }

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {
           System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            codigosPostal = null;
        }

        return codigosPostal;

    }

    @Override
    public int agregarCodigoPostal(CodigoPostal codigoPostal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizarCodigoPostal(CodigoPostal codigoPostal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean borradoLogicoCodigoPostal(int idCodigoPostal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
