/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
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
                temp.setEscolaridad(rs.getString("NivelEducativo"));
                temp.setEscolaridad(rs.getString("NivelSocioeconomico"));
                temp.setPrz(rs.getString("prz"));
                temp.setNoExpediente(rs.getString("expediente"));
                temp.setSeguro(rs.getString("NombreSeguro"));
                temp.setNoSeguroPopular(rs.getString("noSeguro"));
                temp.setAlergias(rs.getString("alergia"));
                temp.setBiopsiaINCanGradoHistologico(rs.getString("BiopsiaINCan_GradoHistologico"));
                temp.setBiopsiaINCanHer2(rs.getString("BiopsiaINCan_Her2"));
                temp.setBiopsiaINCanFish(rs.getString("BiopsiaINCan_Fish"));
                temp.setBiopsiaINCanKi67(rs.getString("BiopsiaINCan_Ki67"));
                temp.setBiopsiaINCanRe(rs.getString("BiopsiaINCan_RE"));
                temp.setBiopsiaINCanRp(rs.getString("BiopsiaINCan_RP"));
                
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
                
                NestedStProcedure = "CALL mostrarPoblacionBiopsiaPrevia(?)";
                NestedCstmt = conn.prepareCall(NestedStProcedure);
                NestedCstmt.setInt(1, rs.getInt("idPaciente"));
                NestedRs = NestedCstmt.executeQuery();
                if (NestedRs.next()){
                    temp.setBiopsiaPreviaLaminillas(NestedRs.getString("Laminillas"));
                    temp.setBiopsiaPreviaBloques(NestedRs.getString("Bloques"));
                    temp.setBiopsiaPreviaTipo(NestedRs.getString("nombreTipo"));
                    temp.setBiopsiaPreviaLugarCuerpo(NestedRs.getString("nombreLugarCuerpo"));
                    temp.setBiopsiaPreviaFecha(NestedRs.getDate("Fecha"));
                } else {
                    temp.setBiopsiaPreviaLaminillas("NA");
                    temp.setBiopsiaPreviaBloques("NA");
                    temp.setBiopsiaPreviaTipo("NA");
                    temp.setBiopsiaPreviaLugarCuerpo("NA");
                    temp.setBiopsiaPreviaFecha(Date.valueOf("1900-01-01"));
                }
                NestedRs.close();
                NestedRs.close();
                
                if (temp.getNombrePersona() == null)temp.setNombrePersona("NA");
                if (temp.getPrimerApellido() == null)temp.setPrimerApellido("NA");
                if (temp.getSegundoApellido() == null)temp.setSegundoApellido("NA");
                if (temp.getCurp() == null)temp.setCurp("NA");
                if (temp.getTelefono() == null)temp.setTelefono("NA");
                if (temp.getCorreo() == null)temp.setCorreo("NA");
                if (temp.getTipoSangre() == null)temp.setTipoSangre("NA");
                if (temp.getEstado() == null)temp.setEstado("NA");
                if (temp.getMunicipio() == null)temp.setMunicipio("NA");
                if (temp.getFechaNacimiento() == null)temp.setFechaNacimiento(Date.valueOf("1900-01-01"));
                if (temp.getEstadoCivil() == null)temp.setEstadoCivil("NA");
                if (temp.getSexo() == null)temp.setSexo("NA");
                if (temp.getEscolaridad() == null)temp.setEscolaridad("NA");
                if (temp.getNivelSocioeconomico() == null)temp.setNivelSocioeconomico("NA");
                if (temp.getPrz() == null)temp.setPrz("NA");
                if (temp.getNoExpediente() == null)temp.setNoExpediente("NA");
                if (temp.getSeguro() == null)temp.setSeguro("NA");
                if (temp.getNoSeguroPopular() == null || !temp.getSeguro().equals("Seguro Popular"))temp.setNoSeguroPopular("NA");
                if (temp.getAlergias() == null)temp.setAlergias("NA");
                if (temp.getBiopsiaINCanGradoHistologico() == null)temp.setBiopsiaINCanGradoHistologico("NA");
                if (temp.getBiopsiaINCanHer2( )== null)temp.setBiopsiaINCanHer2("NA");
                if (temp.getBiopsiaINCanFish() == null)temp.setBiopsiaINCanFish("NA");
                if (temp.getBiopsiaINCanKi67() == null)temp.setBiopsiaINCanKi67("NA");
                if (temp.getBiopsiaINCanRe() == null)temp.setBiopsiaINCanRe("NA");
                if (temp.getBiopsiaINCanRp() == null)temp.setBiopsiaINCanRp("NA");
                if (temp.getSillaRuedas() == null)temp.setSillaRuedas("NA");
                if (temp.getBastón() == null)temp.setBastón("NA");
                if (temp.getOxigeno() == null)temp.setOxigeno("NA");
                if (temp.getCamilla() == null)temp.setCamilla("NA");
                
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
