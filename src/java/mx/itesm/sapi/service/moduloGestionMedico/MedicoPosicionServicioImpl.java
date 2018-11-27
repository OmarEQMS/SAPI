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
import mx.itesm.sapi.bean.moduloGestionMedico.MedicoPosicion;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author shannonrosas
 */
public class MedicoPosicionServicioImpl implements MedicoPosicionServicio {

    @Override
    public int agregarMedicoPosicion(MedicoPosicion medicoPosicion) {
        Connection conn = Conexion.getConnection();

        CallableStatement cstmt;

        int id = 0;
        //Aquí va el call del procedure
        String stProcedure = "----";       
        ResultSet rs;
                    
        try {
                        
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, medicoPosicion.getIdEmpleado());
            cstmt.setInt(2, medicoPosicion.getIdPosicion());


            rs = cstmt.executeQuery();         
            rs.next();
            id = rs.getInt(1);
            
            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {

            System.out.println("Catch agregarMedicoPosicion");
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));            
        }
        return id;
    }

    @Override
    public MedicoPosicion mostrarMedicoPosicion(int idMedicoPosicion) {
        Connection conn = Conexion.getConnection();

        CallableStatement cstmt;

        MedicoPosicion medicoPosicion = new MedicoPosicion();

        //Call del store procedure
        String stProcedure = "-----";

        try {

            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idMedicoPosicion);
            ResultSet rs = cstmt.executeQuery();

            rs.next();
            medicoPosicion.setIdEmpleadoPosicion(rs.getInt("idMedicoPosicion"));
            medicoPosicion.setIdEmpleado(rs.getInt("idEmpleado"));
            medicoPosicion.setIdPosicion(rs.getInt("idPosicion"));
            medicoPosicion.setInicio(rs.getTimestamp("inicio"));
            medicoPosicion.setTermino(rs.getTimestamp("termino"));
            medicoPosicion.setEstatus(rs.getInt("estatus"));

            return medicoPosicion;
        } catch (SQLException ex) {

            System.out.println("Estoy en el catch de mostrarMedicoEspecialidad");
            System.out.println(ex.getMessage());
            return medicoPosicion;
        }
    }

    @Override
    public MedicoPosicion mostrarMedicoPosicionEmpleado(int idEmpleado) {
        Connection conn = Conexion.getConnection();

        CallableStatement cstmt;

        MedicoPosicion medicoPosicion = new MedicoPosicion();

        //Call del store procedure
        String stProcedure = "CALL mostrarMedicoPosicionEmpleado(?)";

        try {

            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idEmpleado);
            ResultSet rs = cstmt.executeQuery();
            System.out.println("Medico posicion empleado ".concat(cstmt.toString()));
            rs.next();
            
            medicoPosicion.setIdEmpleadoPosicion(rs.getInt("idEmpleadoPosicion"));
            medicoPosicion.setIdEmpleado(rs.getInt("idEmpleado"));
            medicoPosicion.setIdPosicion(rs.getInt("idPosicion"));
            medicoPosicion.setInicio(rs.getTimestamp("inicio"));
            medicoPosicion.setTermino(rs.getTimestamp("termino"));
            medicoPosicion.setEstatus(rs.getInt("estatus"));                      

            //En un merge no borrar esto. No se porque cuando se hace la asignación directa se putea.
            int idEmpleado2 = rs.getInt("idEmpleado");            
            medicoPosicion.setIdEmpleado(idEmpleado2);
           
            
                        
        } catch (SQLException ex) {

            System.out.println("Estoy en el catch de mostrarMedicoPosicionEmpleado");
            System.out.println(ex.getMessage());
            medicoPosicion = null;            
        }
        return medicoPosicion;
    }

    @Override
    public List<MedicoPosicion> mostrarMedicoPosicion() {
        Connection conn = Conexion.getConnection();

        List<MedicoPosicion> medicosPosiciones = new ArrayList<>();
        CallableStatement cstmt;

        try {

            cstmt = conn.prepareCall("CALL -----");
            ResultSet rs = cstmt.executeQuery();
            MedicoPosicion medicoPosicion;

            while (rs.next()) {

                medicoPosicion = new MedicoPosicion();
                
            medicoPosicion.setIdEmpleadoPosicion(rs.getInt("idEmpleadoPosicion"));
            medicoPosicion.setIdEmpleado(rs.getInt("idEmpleado"));
            medicoPosicion.setIdPosicion(rs.getInt("idPosicion"));
            medicoPosicion.setInicio(rs.getTimestamp("inicio"));
            medicoPosicion.setTermino(rs.getTimestamp("termino"));
            medicoPosicion.setEstatus(rs.getInt("estatus"));

                medicosPosiciones.add(medicoPosicion);

            }

            rs.close();
            cstmt.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Estoy en el catch de mostrarEquipoEmpleado");
        }

        return medicosPosiciones;
    }

    @Override
    public boolean borradoLogicoMedicoPosicion(int idMedicoPosicion) {
        Connection conn = Conexion.getConnection();

        CallableStatement cstmt;

        //Call del store procedure
        String stProcedure = "";

        try {

            cstmt = conn.prepareCall(stProcedure);

            cstmt.setInt(1, idMedicoPosicion);

            ResultSet rs = cstmt.executeQuery();

            rs.next();

            return rs.getBoolean(1);

        } catch (SQLException ex) {
            System.out.println("Estoy en el catch de borradoLogicoEquipoEmpleado");
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean actualizarMedicoPosicion(MedicoPosicion medicoPosicion) {
        
        Connection conn = Conexion.getConnection();

        CallableStatement cstmt;

        //Call del store procedure
        String stProcedure = "CALL actualizarMedicoPosicion(?,?)";

        try {

            cstmt = conn.prepareCall(stProcedure);

            cstmt.setInt(1, medicoPosicion.getIdEmpleado());
            cstmt.setInt(2, medicoPosicion.getIdPosicion());
         
            ResultSet rs = cstmt.executeQuery();
            
            rs.next();

            return rs.getBoolean(1);

        } catch (SQLException ex) {
            
            System.out.println(this.getClass().toString()
            .concat(ex.getMessage()));
            
            return false;
        }
    
    }


}
