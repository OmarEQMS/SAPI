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
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.itesm.sapi.bean.moduloGestionMedico.Empleado;
import mx.itesm.sapi.bean.moduloGestionMedico.Identificadores;
import mx.itesm.sapi.bean.moduloGestionMedico.RestringirEmpleado;
import mx.itesm.sapi.bean.moduloGestionMedico.TablaAdministradorAdministrador;
import mx.itesm.sapi.bean.moduloGestionMedico.TablaMedicoAdministrador;
import mx.itesm.sapi.service.persona.CuentaServicioImpl;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Fernanda Orduña & Pablo Lugo <3
 */
public class EmpleadoServicioImpl implements EmpleadoServicio {

    
    @Override
    public int agregarEmpleado(Empleado empleado) {
        Connection conn = Conexion.getConnection();

        CallableStatement cstmt;

        int id = 0;
        //Aquí va el call del procedure
        String stProcedure = "CALL agregarEmpleado(?,?,?)";

        try {

            cstmt = conn.prepareCall(stProcedure);

            //Aquí van los sets
            //cstmt.setInt(1,empleado.getIdEmpleado());
            cstmt.setInt(1, empleado.getIdDepartamentoDepartamentoInterno());
            cstmt.setString(2, empleado.getNoEmpleado());
            cstmt.setInt(3, empleado.getIdCuenta());

            //Aquí va el registerOutParameter
            //cstmt.registerOutParameter(12,Types.INTEGER);            

            ResultSet rs = cstmt.executeQuery();
            rs.next();
            id = rs.getInt(1);

            cstmt.close();

        } catch (SQLException ex) {

            System.out.println("Estoy en el catch de agregarEmpleado");
            System.out.println(ex.getMessage());

        }

        return id;
    }
    
    @Override
    public Empleado mostrarEmpleado(int idEmpleado) {
        Connection conn = Conexion.getConnection();

        CallableStatement cstmt;

        Empleado empleado = new Empleado();

        //Call del store procedure
        String stProcedure = "CALL mostrarEmpleado(?);";

        try {

            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idEmpleado);
            ResultSet rs = cstmt.executeQuery();

            rs.next();
            empleado.setIdEmpleado(rs.getInt(1));
            empleado.setIdDepartamentoDepartamentoInterno(rs.getInt(2));
            empleado.setNoEmpleado(rs.getString(3));
            empleado.setIdCuenta(rs.getInt(4));
            empleado.setEstatus(rs.getInt(5));

            return empleado;
        } catch (SQLException ex) {

            System.out.println("Estoy en el catch de mostrarEmpleado");
            System.out.println(ex.getMessage());
            return empleado;
        }
    }
    
    
    @Override
    public Empleado mostrarEmpleadoCuenta(int idCuenta) {
        Connection conn = Conexion.getConnection();

        CallableStatement cstmt;

        Empleado empleado = new Empleado();

        //Call del store procedure
        String stProcedure = "CALL mostrarEmpleadoCuenta(?)";

        try {

            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idCuenta);
            ResultSet rs = cstmt.executeQuery();

            rs.next();
            empleado.setIdEmpleado(rs.getInt(1));
            empleado.setIdDepartamentoDepartamentoInterno(rs.getInt(2));
            empleado.setNoEmpleado(rs.getString(3));
            empleado.setEstatus(rs.getInt(4));
            empleado.setIdCuenta(rs.getInt(5));

            return empleado;
        } catch (SQLException ex) {

            System.out.println("Estoy en el catch de mostrarEmpleado");
            System.out.println(ex.getMessage());
            return empleado;
        }
    }

    @Override
    public List<Empleado> mostrarEmpleado() {
        Connection conn = Conexion.getConnection();

        List<Empleado> empleados = new ArrayList<>();
        CallableStatement cstmt;

        try {

            cstmt = conn.prepareCall("CALL -----");
            ResultSet rs = cstmt.executeQuery();
            Empleado empleado;

            while (rs.next()) {

                empleado = new Empleado();

                empleado.setIdEmpleado(rs.getInt(1));
                empleado.setIdDepartamentoDepartamentoInterno(rs.getInt(2));
                empleado.setNoEmpleado(rs.getString(3));
                empleado.setEstatus(rs.getInt(4));

                empleados.add(empleado);

            }

            rs.close();
            cstmt.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Estoy en el catch de mostrarEmpleado");
        }

        return empleados;
    }
    
    

    

    @Override
    public boolean borradoLogicoEmpleado(int idEmpleado) {
        Connection conn = Conexion.getConnection();

        CallableStatement cstmt;

        //Call del store procedure
        String stProcedure = "";

        try {

            cstmt = conn.prepareCall(stProcedure);

            cstmt.setInt(1, idEmpleado);

            ResultSet rs = cstmt.executeQuery();

            rs.next();

            return rs.getBoolean(1);

        } catch (SQLException ex) {
            System.out.println("Estoy en el catch de borradoLogicoEmpleado");
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean actualizarEmpleado(Empleado empleado) {
        Connection conn = Conexion.getConnection();

        CallableStatement cstmt;

        //Call del store procedure
        String stProcedure = "CALL actualizarEmpleado(?,?,?)";

        try {

            cstmt = conn.prepareCall(stProcedure);

            cstmt.setInt(1,empleado.getIdEmpleado());
            cstmt.setInt(2, empleado.getIdDepartamentoDepartamentoInterno());
            cstmt.setString(3, empleado.getNoEmpleado());            
            
            ResultSet rs = cstmt.executeQuery();

            rs.next();

            return rs.getBoolean(1);

        } catch (SQLException ex) {
            System.out.println("Estoy en el catch de actualizarEmpleado");
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public Empleado mostrarEmpleadoPersona(int idPersona) {
        Connection conn = Conexion.getConnection();

        CallableStatement cstmt;

        Empleado empleado = new Empleado();

        //Call del store procedure
        String stProcedure = "CALL mostrarEmpleadoPersona(?)";

        try {

            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idPersona);
            ResultSet rs = cstmt.executeQuery();

            rs.next();
            empleado.setIdEmpleado(rs.getInt(1));
            empleado.setIdDepartamentoDepartamentoInterno(rs.getInt(2));
            empleado.setNoEmpleado(rs.getString(3));
            empleado.setEstatus(rs.getInt(4));
            empleado.setIdCuenta(rs.getInt(5));

            return empleado;
        } catch (SQLException ex) {

            System.out.println("Estoy en el catch de mostrarEmpleado");
            System.out.println(ex.getMessage());
            return empleado;
        }
    }
    
    
    @Override
    public Identificadores restringirEmpleado(RestringirEmpleado restringirEmpleado) {
        Connection conn = Conexion.getConnection();

        Identificadores identificadores = null;
        CallableStatement cstmt;
                                
        //Aquí va el call del procedure
        String stProcedure = "CALL mostrarRestringirEmpleado(?,?,?,?,?,?)";

        try {

            cstmt = conn.prepareCall(stProcedure);                      
            
            cstmt.setString(1, restringirEmpleado.getNombre());
            cstmt.setString(2, restringirEmpleado.getPrimerApellido());
            cstmt.setString(3, restringirEmpleado.getSegundoApellido());
            cstmt.setString(4, restringirEmpleado.getCorreo());
            cstmt.setString(5, restringirEmpleado.getTelefono());                        
            cstmt.setString(6, restringirEmpleado.getUsuario());
            
            System.out.println(" MostrarRestringirEmpleado ".concat(cstmt.toString()));            
            
            ResultSet rs = cstmt.executeQuery();
            rs.next();
            
            identificadores = new Identificadores();
            
            identificadores.setIdPersona(rs.getInt(1));
            identificadores.setIdCuenta(rs.getInt(2));
            identificadores.setEmpleado(rs.getInt(3));
            
            System.out.println(" idPersona ".concat(String.valueOf(identificadores.getIdPersona())));
            System.out.println(" idCuenta ".concat(String.valueOf(identificadores.getIdCuenta())));
            System.out.println(" idEmpleado ".concat(String.valueOf(identificadores.getEmpleado())));
                                          
            cstmt.close();

        } catch (SQLException ex) {

            System.out.println("Estoy en el catch de Restringir Empleado");
            System.out.println(ex.getMessage());
            identificadores = null;
        }

        return identificadores;
    }

    @Override
    public List<TablaMedicoAdministrador> mostrarListaEmpleadosAdministrador(int idRol) {
        Connection conn = Conexion.getConnection();

        List<TablaMedicoAdministrador> medicos = new ArrayList<>();
        CallableStatement cstmt;

        try {

            cstmt = conn.prepareCall("CALL mostrarEmpleadosAdministrador(?)");
            cstmt.setInt(1, idRol);
            ResultSet rs = cstmt.executeQuery();
            TablaMedicoAdministrador medico;

            while (rs.next()) {

                medico = new TablaMedicoAdministrador();
                
                medico.setIdEmpleado(rs.getInt(1));
                medico.setIdCuenta(rs.getInt(2));
                medico.setIdPersona(rs.getInt(3));
                medico.setNombre(rs.getString(4));
                medico.setPrimerApellido(rs.getString(5));
                medico.setSegundoApellido(rs.getString(6));
                medico.setCorreo(rs.getString(7));
                medico.setTelefono(rs.getString(8));
                medico.setUsuario(rs.getString(9));
                medico.setNoEmpleado(rs.getString(10));     
                medico.setNombreEspecialidad(rs.getString(11));
                medico.setCedulaProfesional(rs.getString(12));
                
                                        
                
                medicos.add(medico);
            }

            rs.close();
            cstmt.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Estoy en el catch de mostrar lista médicos ".concat(e.getMessage()));
        }

        return medicos;
    }

    @Override
    public TablaMedicoAdministrador mostrarMedicoAdministrador(int idMedico, int idRol) {
        Connection conn = Conexion.getConnection();

        TablaMedicoAdministrador medico = new TablaMedicoAdministrador();
        CallableStatement cstmt;

        try {

            cstmt = conn.prepareCall("CALL mostrarMedicoAdministrador(?,?)");         
            
            cstmt.setInt(1, idMedico);
            cstmt.setInt(2, idRol);
            
            ResultSet rs = cstmt.executeQuery();
            rs.next();
                                            
                medico.setIdEmpleado(rs.getInt(1));
                medico.setIdCuenta(rs.getInt(2));
                medico.setIdPersona(rs.getInt(3));
                medico.setNombre(rs.getString(4));
                medico.setPrimerApellido(rs.getString(5));
                medico.setSegundoApellido(rs.getString(6));
                medico.setCorreo(rs.getString(7));
                medico.setTelefono(rs.getString(8));
                medico.setUsuario(rs.getString(9));
                medico.setNoEmpleado(rs.getString(10));     
                medico.setNombreEspecialidad(rs.getString(11));
                medico.setCedulaProfesional(rs.getString(12)); 
                medico.setNombrePosicion(rs.getString(13));

            rs.close();
            cstmt.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Estoy en el catch de mostrarMedicoAdministrador ".concat(e.getMessage()));
            medico = null;
        }

        return medico;                
    }

    @Override
    public List<TablaAdministradorAdministrador> mostrarListaAdminAdministrador() {
        Connection conn = Conexion.getConnection();

        List<TablaAdministradorAdministrador> administradores = new ArrayList<>();
        CallableStatement cstmt;

        try {

            cstmt = conn.prepareCall("CALL mostrarAdministradores()");
            ResultSet rs = cstmt.executeQuery();
            TablaAdministradorAdministrador administrador;

            while (rs.next()) {

                administrador = new TablaAdministradorAdministrador();
                
                administrador.setIdEmpleado(rs.getInt(1));
                administrador.setIdCuenta(rs.getInt(2));
                administrador.setIdPersona(rs.getInt(3));
                administrador.setNombre(rs.getString(4));
                administrador.setPrimerApellido(rs.getString(5));
                administrador.setSegundoApellido(rs.getString(6));
                administrador.setCorreo(rs.getString(7));
                administrador.setTelefono(rs.getString(8));
                administrador.setNoEmpleado(rs.getString(9));     
                administrador.setNombreEspecialidad(rs.getString(10));
                administrador.setCedulaProfesional(rs.getString(11));
                
                administradores.add(administrador);
            }

            rs.close();
            cstmt.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Estoy en el catch de mostrar lista administradores ".concat(e.getMessage()));
        }

        return administradores;
    }
    
    @Override
    public boolean existsNoEmpleado(String noEmpleado) {

        Connection conn = Conexion.getConnection();

        CallableStatement cstmt;

        try {

            cstmt = conn.prepareCall("CALL existeNoEmpleado(?,?)");
            cstmt.setString(1, noEmpleado);
            cstmt.registerOutParameter(2, Types.BOOLEAN);

            cstmt.execute();
            return cstmt.getBoolean(2);

        } catch (SQLException ex) {

            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            return false;
        }

    }

    @Override
    public boolean existsNoEmpleado(String noEmpleado, int idEmpleado) {

        Connection conn = Conexion.getConnection();

        CallableStatement cstmt;

        try {
            cstmt = conn.prepareCall("CALL existeNoEmpleadoIdEmpleado(?, ?, ?)");
            cstmt.setString(1, noEmpleado);
            cstmt.setInt(2, idEmpleado);
            cstmt.registerOutParameter(3, Types.BOOLEAN);

            System.out.println("existeCorreoIdPersona: ".concat(cstmt.toString()));
            cstmt.execute();
            return cstmt.getBoolean(3);

        } catch (SQLException ex) {

            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            return false;
        }

    }

    @Override
    public boolean relacionMedicoPaciente(int idEmpleado) {
        Connection conn = Conexion.getConnection();

        CallableStatement cstmt;

        try {
            cstmt = conn.prepareCall("CALL relacionMedicoPaciente(?, ?)");
            cstmt.setInt(1, idEmpleado);
            cstmt.registerOutParameter(2, Types.BOOLEAN);

            cstmt.execute();
            return cstmt.getBoolean(2);

        } catch (SQLException ex) {

            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            return false;
        }
    }

}