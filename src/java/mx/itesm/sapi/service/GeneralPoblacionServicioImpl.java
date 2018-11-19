/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import mx.itesm.sapi.util.Conexion;
import mx.itesm.sapi.bean.poblacion.GeneralPoblacion;

/**
 *
 * @author Raul Orihuela
 */
public class GeneralPoblacionServicioImpl implements GeneralPoblacionServicio{

    @Override
    public ArrayList<GeneralPoblacion> mostrarPoblacionGeneral() {
        
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        ArrayList<GeneralPoblacion> PoblacionGeneral = new ArrayList<>();

        //Call del store procedure
        String stProcedure = "CALL mostrarPoblacionGeneral()";
        
        try {
            
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();

            while (rs.next()){
                GeneralPoblacion temp = new GeneralPoblacion();
                temp.setNombrePersona(rs.getString("Nombre"));
                temp.setPrimerApellido(rs.getString("primerApellido"));
                temp.setSegundoApellido(rs.getString("segundoApellido"));
                temp.setCurp(rs.getString("curp"));
                temp.setTelefono(rs.getString("telefono"));
                temp.setCorreo(rs.getString("correo"));
                temp.setTipoSangre(rs.getString("TipoDeSangre"));
                temp.setEstado(rs.getString("NombreEstado"));
                temp.setMunicipio(rs.getString("NombreMunicipio"));
                temp.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                temp.setEstadoCivil(rs.getString("NombreEstadoCivil"));
                temp.setSexo(rs.getString("NombreSexo"));
                temp.setEscolaridad(rs.getString("NivelEdicativo"));
                temp.setPrz(rs.getString("prz"));
                temp.setNoExpediente(rs.getString("expediente"));
                temp.setSeguro(rs.getString("NombreSeguro"));
                temp.setNoSegurooPopular(rs.getString("noSeguro"));
                temp.setAlergias(rs.getString("alergia"));
                
                String NestedStProcedure = "CALL mostrarPoblacionNecesidadesEspeciales(?)";
                CallableStatement NestedCstmt = conn.prepareCall(NestedStProcedure);
                NestedCstmt.setInt(1, rs.getInt("idPaciente"));
                ResultSet NestedRs = NestedCstmt.executeQuery();
                NestedRs.next();
                
                temp.setSillaRuedas(NestedRs.getString("SillaDeRuedas"));
                temp.setBastón(NestedRs.getString("Baston"));
                temp.setOxigeno(NestedRs.getString("Oxigeno"));
                temp.setCamilla(NestedRs.getString("Camilla"));
                
                NestedRs.close();
                NestedRs.close();
                
                PoblacionGeneral.add(temp);
            }
            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {
            System.out.println("GeneralPoblacionServicioImpl mostrarPoblacionGeneral");
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return PoblacionGeneral;
        
    }
    
}
