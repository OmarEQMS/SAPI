
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
import java.util.ArrayList;
import java.util.List;
import mx.itesm.sapi.bean.moduloGestionMedico.DepartamentoDepartamentoInterno;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author feror
 */
public class DepartamentoDepartamentoInternoServicioImpl implements DepartamentoDepartamentoInternoServicio {

    @Override
    public int agregarDepartamentoDepartamentoInterno(DepartamentoDepartamentoInterno departamentoDepartamentoInterno) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;

        int id = 0;
        //Aquí va el call del procedure
        String stProcedure = "-------";

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);

            //Aquí van los sets
            cstmt.setInt(1, departamentoDepartamentoInterno.getIdDepartamentoPadre());
            cstmt.setInt(2, departamentoDepartamentoInterno.getIdDepartamento());

            //Aquí va el registerOutParameter
            //cstmt.registerOutParameter(12,Types.INTEGER);
            cstmt.executeUpdate();

            rs = cstmt.getGeneratedKeys();

            rs.next();

            id = rs.getInt(1);

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {

            System.out.println(this.getClass().toString()
                    .concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            id = -1;

        }

        return id;
    }

    @Override
    public DepartamentoDepartamentoInterno mostrarDepartamentoDepartamentoInterno(int idDepartamentoDepartamentoInterno) {

        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;

        DepartamentoDepartamentoInterno departamentoDepartamentoInterno = new DepartamentoDepartamentoInterno();

        //Call del store procedure
        String stProcedure = "-----";

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idDepartamentoDepartamentoInterno);

            rs = cstmt.executeQuery();

            rs.next();
            departamentoDepartamentoInterno.setIdDepartamentoDepartamentoInterno(rs.getInt("idDepartamentoDepartamentoInterno"));
            departamentoDepartamentoInterno.setIdDepartamentoPadre(rs.getInt("idDepartamentoPadre"));
            departamentoDepartamentoInterno.setIdDepartamento(rs.getInt("idDepartamento"));

            rs.close();
            cstmt.close();
            conn.close();
        } catch (SQLException ex) {

            System.out.println(this.getClass().toString()
                    .concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));

            departamentoDepartamentoInterno = null;
        }
        return departamentoDepartamentoInterno;
    }

    @Override
    public List<DepartamentoDepartamentoInterno> mostrarDepartamentoDepartamentoInterno() {

        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;

        List<DepartamentoDepartamentoInterno> departamentosDepartamentosInternos = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall("CALL -----");
            rs = cstmt.executeQuery();
            DepartamentoDepartamentoInterno departamentoDepartamentoInterno;

            while (rs.next()) {

                departamentoDepartamentoInterno = new DepartamentoDepartamentoInterno();

                departamentoDepartamentoInterno.setIdDepartamentoDepartamentoInterno(rs.getInt("idDepartamentoDepartamentoInterno"));
                departamentoDepartamentoInterno.setIdDepartamentoPadre(rs.getInt("idDepartamentoPadre"));
                departamentoDepartamentoInterno.setIdDepartamento(rs.getInt("idDepartamento"));

                departamentosDepartamentosInternos.add(departamentoDepartamentoInterno);

            }

            rs.close();
            cstmt.close();
            conn.close();

        } catch (Exception ex) {

            System.out.println(this.getClass().toString()
                    .concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            departamentosDepartamentosInternos = null;
        }

        return departamentosDepartamentosInternos;
    }

    @Override
    public boolean borradoLogicoDepartamentoDepartamentoInterno(int idDepartamentoDepartamentoInterno) {

        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;

        //Call del store procedure
        String stProcedure = "";

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);

            cstmt.setInt(1, idDepartamentoDepartamentoInterno);

            rs = cstmt.executeQuery();

            rs.next();

            return rs.getBoolean(1);

        } catch (SQLException ex) {
            System.out.println(this.getClass().toString()
                    .concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            return false;
        }
    }

    @Override
    public boolean actualizarDepartamentoDepartamentoInterno(DepartamentoDepartamentoInterno departamentoDepartamentoInterno) {
        Connection conn = Conexion.getConnection();

        CallableStatement cstmt;

        //Call del store procedure
        String stProcedure = "";

        try {

            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, departamentoDepartamentoInterno.getIdDepartamentoDepartamentoInterno());
            cstmt.setInt(2, departamentoDepartamentoInterno.getIdDepartamentoPadre());
            cstmt.setInt(3, departamentoDepartamentoInterno.getIdDepartamento());

            ResultSet rs = cstmt.executeQuery();

            rs.next();

            return rs.getBoolean(1);

        } catch (SQLException ex) {
            System.out.println(this.getClass().toString()
                    .concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            return false;
        }
    }

}
