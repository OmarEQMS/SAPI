/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionTratamiento;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.itesm.sapi.bean.gestionTratamiento.UnionTratamientoPaciente;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author feror
 */
public class UnionTratamientoPacienteServiceImpl implements UnionTratamientoPacienteService {

    @Override
    public List<UnionTratamientoPaciente> mostrarUnionTratamientoPaciente(int idPaciente) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;

        List<UnionTratamientoPaciente> tratamientosPaciente = null;

        //Call del stored procedure
        String stProcedure = "CALL mostrarUnionTratamientoPaciente(?)";

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            tratamientosPaciente = new ArrayList<>();

            cstmt.setInt(1, idPaciente);
            rs = cstmt.executeQuery();
            UnionTratamientoPaciente unionTratamientoPaciente;

            while (rs.next()) {
                unionTratamientoPaciente = new UnionTratamientoPaciente();
                unionTratamientoPaciente.setIdTratamientoPaciente(rs.getInt(1));
                unionTratamientoPaciente.setIdPaciente(rs.getInt(2));
                unionTratamientoPaciente.setIdTipoTratamiento(rs.getInt(3));
                unionTratamientoPaciente.setNombre(rs.getString(4));
                unionTratamientoPaciente.setFechaInicio(rs.getDate(5));
                unionTratamientoPaciente.setFechaFin(rs.getDate(6));
                

                tratamientosPaciente.add(unionTratamientoPaciente);
            }

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {
            tratamientosPaciente = null;
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return tratamientosPaciente;
    }

}
