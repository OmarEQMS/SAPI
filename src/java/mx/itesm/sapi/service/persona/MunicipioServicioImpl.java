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
import mx.itesm.sapi.bean.persona.Municipio;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Angel GTZ
 */
public class MunicipioServicioImpl implements MunicipioServicio {

    @Override
    public boolean borradoLogicoMunicipio(int idMunicipio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Municipio mostrarMunicipio(int idMunicipio) {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        Municipio municipio = null;

        //Call del store procedure
        String stProcedure = "mostrarMunicipio(?)";

        try {
            municipio = new Municipio();
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idMunicipio);

            rs = cstmt.executeQuery();

            rs.next();
            municipio.setIdMunicipio(rs.getInt("idMunicipio"));
            municipio.setNombre(rs.getString("nombre"));
            municipio.setIdEstado(rs.getInt("idEstado"));
            municipio.setEstatus(rs.getInt("estatus"));

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {

            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            municipio = null;
        }
        return municipio;
    }

    @Override
    public List<Municipio> mostrarMunicipio() {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        List<Municipio> municipios = null;

        try {
            municipios = new ArrayList<>();
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall("mostrarListasMunicipio()");
            rs = cstmt.executeQuery();
            Municipio municipio;

            while (rs.next()) {

                municipio = new Municipio();

                municipio.setIdMunicipio(rs.getInt("idMunicipio"));
                municipio.setNombre(rs.getString("nombre"));
                municipio.setIdEstado(rs.getInt("idEstado"));
                municipio.setEstatus(rs.getInt("estatus"));

                municipios.add(municipio);

            }

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            municipios = null;
        }

        return municipios;
    }

    @Override
    public int agregarMunicipio(Municipio municipio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizarMunicipio(Municipio municipio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
