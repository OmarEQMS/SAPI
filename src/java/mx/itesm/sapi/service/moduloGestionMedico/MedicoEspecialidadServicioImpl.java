
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
import mx.itesm.sapi.bean.moduloGestionMedico.MedicoEspecialidad;
import mx.itesm.sapi.util.Conexion;

/**
 * 16-Noviembre-2018
 * @author Fernanda Orduña & Pablo Lugo </3 
 */
public class MedicoEspecialidadServicioImpl implements MedicoEspecialidadServicio{

    @Override
    public int agregarMedicoEspecialidad(MedicoEspecialidad medicoEspecialidad) {
        Connection conn = Conexion.getConnection();

        CallableStatement cstmt;

        int id = 0;
        //Aquí va el call del procedure
        String stProcedure = "CALL agregarMedicoEspecialidad(?,?,?)";       
        ResultSet rs;
                    
        try {
                        
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, medicoEspecialidad.getIdEmpleado());
            cstmt.setInt(2, medicoEspecialidad.getIdEspecialidad());
            cstmt.setString(3, medicoEspecialidad.getCedulaProfesional());

            rs = cstmt.executeQuery();
            System.out.println("agregarMedicoEspecialidad ".concat(cstmt.toString()));           
            rs.next();
            id = rs.getInt(1);
            
            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {

            System.out.println("Catch agregarMedicoEspecialidad");
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));            
        }
        return id;
    }

    @Override
    public MedicoEspecialidad mostrarMedicoEspecialidad(int idMedicoEspecialidad) {
        Connection conn = Conexion.getConnection();

        CallableStatement cstmt;

        MedicoEspecialidad medicoEspecialidad = new MedicoEspecialidad();

        //Call del store procedure
        String stProcedure = "-----";

        try {

            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idMedicoEspecialidad);
            ResultSet rs = cstmt.executeQuery();

            rs.next();
            medicoEspecialidad.setIdMedicoEspecialidad(rs.getInt("idMedicoEspecialidad"));
            medicoEspecialidad.setIdEmpleado(rs.getInt("idEmpleado"));
            medicoEspecialidad.setIdEspecialidad(rs.getInt("idEspecialidad"));
            medicoEspecialidad.setCedulaProfesional(rs.getString("cedulaProfesional"));
            medicoEspecialidad.setIdEmpleado(rs.getInt("estatus"));

            return medicoEspecialidad;
        } catch (SQLException ex) {

            System.out.println("Estoy en el catch de mostrarMedicoEspecialidad");
            System.out.println(ex.getMessage());
            return medicoEspecialidad;
        }
    }

    
     @Override
    public MedicoEspecialidad mostrarMedicoEspecialidadEmpleado(int idEmpleado) {
        Connection conn = Conexion.getConnection();

        CallableStatement cstmt;

        MedicoEspecialidad medicoEspecialidad = new MedicoEspecialidad();

        //Call del store procedure
        String stProcedure = "CALL mostrarMedicoEspecialidadEmpleado(?)";

        try {

            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idEmpleado);
            ResultSet rs = cstmt.executeQuery();
            System.out.println("Medico especialidad empleado ".concat(cstmt.toString()));
            rs.next();
            
            medicoEspecialidad.setIdMedicoEspecialidad(rs.getInt("idMedicoEspecialidad"));
            medicoEspecialidad.setIdEmpleado(rs.getInt("idEmpleado"));
            medicoEspecialidad.setIdEspecialidad(rs.getInt("idEspecialidad"));
            medicoEspecialidad.setCedulaProfesional(rs.getString("cedulaProfesional"));
            medicoEspecialidad.setIdEmpleado(rs.getInt("estatus"));                        

            //En un merge no borrar esto. No se porque cuando se hace la asignación directa se putea.
            int idEmpleado2 = rs.getInt("idEmpleado");            
            medicoEspecialidad.setIdEmpleado(idEmpleado2);
           
            
                        
        } catch (SQLException ex) {

            System.out.println("Estoy en el catch de mostrarMedicoEspecialidadEmpleado");
            System.out.println(ex.getMessage());
            medicoEspecialidad = null;            
        }
        return medicoEspecialidad;
    }

    
    @Override
    public List<MedicoEspecialidad> mostrarMedicoEspecialidad() {
        Connection conn = Conexion.getConnection();

        List<MedicoEspecialidad> medicosEspecialidades = new ArrayList<>();
        CallableStatement cstmt;

        try {

            cstmt = conn.prepareCall("CALL -----");
            ResultSet rs = cstmt.executeQuery();
            MedicoEspecialidad medicoEspecialidad;

            while (rs.next()) {

                medicoEspecialidad = new MedicoEspecialidad();

            medicoEspecialidad.setIdMedicoEspecialidad(rs.getInt("idMedicoEspecialidad"));
            medicoEspecialidad.setIdEmpleado(rs.getInt("idEmpleado"));
            medicoEspecialidad.setIdEspecialidad(rs.getInt("idEspecialidad"));
            medicoEspecialidad.setCedulaProfesional(rs.getString("cedulaProfesional"));
            medicoEspecialidad.setIdEmpleado(rs.getInt("estatus"));

                medicosEspecialidades.add(medicoEspecialidad);

            }

            rs.close();
            cstmt.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Estoy en el catch de mostrarEquipoEmpleado");
        }

        return medicosEspecialidades;
    }

    @Override
    public boolean borradoLogicoMedicoEspecialidad(int idMedicoEspecialidad) {
        
        Connection conn = Conexion.getConnection();

        CallableStatement cstmt;

        //Call del store procedure
        String stProcedure = "";

        try {

            cstmt = conn.prepareCall(stProcedure);

            cstmt.setInt(1, idMedicoEspecialidad);

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
    public boolean actualizarMedicoEspecialidad(MedicoEspecialidad medicoEspecialidad) {
        Connection conn = Conexion.getConnection();

        CallableStatement cstmt;

        //Call del store procedure
        String stProcedure = "CALL actualizarMedicoEspecialidad(?,?,?,?)";

        try {

            cstmt = conn.prepareCall(stProcedure);

            cstmt.setInt(1,medicoEspecialidad.getIdMedicoEspecialidad());
            cstmt.setInt(2, medicoEspecialidad.getIdEmpleado());
            cstmt.setInt(3, medicoEspecialidad.getIdEspecialidad());
            cstmt.setString(4, medicoEspecialidad.getCedulaProfesional());
            System.out.println("Actualizar medico especialiad ".concat(cstmt.toString()));            
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
