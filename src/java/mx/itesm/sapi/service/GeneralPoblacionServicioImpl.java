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
                temp.setBiopsiaINCanEtapa(rs.getString("INCan_Etapa"));
                temp.setBiopsiaINCanT(rs.getString("INCan_T"));
                temp.setBiopsiaINCanN(rs.getString("INCan_N"));
                temp.setBiopsiaINCanM(rs.getString("INCan_M"));
                
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
                
                NestedStProcedure = "CALL mostrarPoblacionEstudiosPrevios(?)";
                NestedCstmt = conn.prepareCall(NestedStProcedure);
                NestedCstmt.setInt(1, rs.getInt("idPaciente"));
                NestedRs = NestedCstmt.executeQuery();
                NestedRs.next();
                    temp.setEstudioPrevioMastografia(NestedRs.getString("BiradsMastografia"));
                    temp.setEstudioPrevioMastografiaFecha(NestedRs.getDate("FechaMastografia"));
                    temp.setEstudioPrevioUSG(NestedRs.getString("BiradsUsg"));
                    temp.setEstudioPrevioUSGFecha(NestedRs.getDate("FechaUsg"));
                    temp.setEstudioPrevioRadioCiclos(NestedRs.getInt("CiclosRadiografia"));
                    temp.setEstudioPrevioRadioFecha(NestedRs.getDate("FechaRadiografia"));
                    temp.setEstudioPrevioQuimioCiclos(NestedRs.getInt("CiclosQuimioterapia"));
                    temp.setEstudioPrevioQuimioFecha(NestedRs.getDate("FechaQuimioterapia"));
                    temp.setEstudioPrevioCirugiaTipo(NestedRs.getString("TipoCirugia"));
                    temp.setEstudioPrevioCirugiaFecha(NestedRs.getDate("FechaCirugia"));
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
                }
                NestedRs.close();
                NestedRs.close();
                
                NestedStProcedure = "CALL mostrarPoblacionEstudiosINCan(?)";
                NestedCstmt = conn.prepareCall(NestedStProcedure);
                NestedCstmt.setInt(1, rs.getInt("idPaciente"));
                NestedRs = NestedCstmt.executeQuery();
                NestedRs.next();
                    temp.setEstudioINCanMastografia(NestedRs.getString("BiradsMastografia"));
                    temp.setEstudioINCanMastografiaFecha(NestedRs.getDate("FechaMastografia"));
                    temp.setEstudioINCanUSG(NestedRs.getString("BiradsUSG"));
                    temp.setEstudioINCanUSGFecha(NestedRs.getDate("FechaUSG"));
                    temp.setEstudioINCanRadiografia(NestedRs.getDate("FechaRadio"));
                    temp.setEstudioINCanTomografia(NestedRs.getDate("FechaTomo"));
                    temp.setEstudioINCanMr(NestedRs.getDate("FechaMr"));
                    temp.setEstudioINCanTransvaginal(NestedRs.getDate("FechaTransvaginal"));
                    temp.setEstudioINCanAbdominal(NestedRs.getDate("FechaAbdominal"));
                    temp.setEstudioINCanTiroides(NestedRs.getDate("FechaTiroideo"));
                    temp.setEstudioINCanPelvico(NestedRs.getDate("FechaPelvico"));
                    temp.setEstudioINCanHepatico(NestedRs.getDate("FechaHepatico"));
                    temp.setEstudioINCanPet(NestedRs.getDate("FechaPet"));
                    temp.setEstudioINCanMuga(NestedRs.getDate("FechaMuga"));
                    temp.setEstudioINCanGamma(NestedRs.getDate("FechaGamma"));
                    temp.setEstudioINCanLaboratorio(NestedRs.getDate("FechaLaboratorio"));
                    temp.setEstudioINCanCardio(NestedRs.getDate("FechaCardio"));
                    temp.setEstudioINCanAnestesica(NestedRs.getDate("FechaAnestesica"));
                    temp.setEstudioINCanInhaloterapia(NestedRs.getDate("FechaInhalo"));
                    temp.setEstudioINCanElectro(NestedRs.getDate("FechaElectro"));
                    temp.setEstudioINCanEco(NestedRs.getDate("FechaEco"));
                    temp.setProgramaINCanTrabajoSocial(NestedRs.getDate("FechaTrabajoSocial"));
                    temp.setProgramaINCanMujeresJovenes(NestedRs.getDate("FechaMujerJoven"));
                    temp.setProgramaINCanNutricion(NestedRs.getDate("FechaNutricion"));
                    temp.setProgramaINCanGenetica(NestedRs.getDate("FechaGenetica"));
                NestedRs.close();
                NestedRs.close();
                
                NestedStProcedure = "CALL mostrarPoblacionBiopsiaINCan(?)";
                NestedCstmt = conn.prepareCall(NestedStProcedure);
                NestedCstmt.setInt(1, rs.getInt("idPaciente"));
                NestedRs = NestedCstmt.executeQuery();
                if (NestedRs.next()){
                    temp.setBiopsiaINCanGradoHistologico(NestedRs.getString("BiopsiaINCan_GradoHistologico"));
                    temp.setBiopsiaINCanHer2(NestedRs.getString("BiopsiaINCan_Her2"));
                    temp.setBiopsiaINCanFish(NestedRs.getString("BiopsiaINCan_Fish"));
                    temp.setBiopsiaINCanKi67(NestedRs.getString("BiopsiaINCan_Ki67"));
                    temp.setBiopsiaINCanRe(NestedRs.getString("BiopsiaINCan_RE"));
                    temp.setBiopsiaINCanRp(NestedRs.getString("BiopsiaINCan_RP"));
                }
                NestedRs.close();
                NestedRs.close();
                
                NestedStProcedure = "CALL mostrarPoblacionPreconsulta(?)";
                NestedCstmt = conn.prepareCall(NestedStProcedure);
                NestedCstmt.setInt(1, rs.getInt("idPaciente"));
                NestedRs = NestedCstmt.executeQuery();
                if (NestedRs.next()){
                    if (NestedRs.getInt("Preconsulta_SegundaOpinion") == 0)temp.setPreconsultaSegundaOpcion("Primera vez");
                    else temp.setPreconsultaSegundaOpcion("Segunda Opinión");
                    temp.setPreconsultaFechaDecision(NestedRs.getDate("Preconsulta_FechaDecision"));
                    temp.setPreconsultaDecision(NestedRs.getString("Preconsulta_Decision"));
                }
                NestedRs.close();
                NestedRs.close();
                
                NestedStProcedure = "CALL mostrarPoblacionCirugiasINCan(?)";
                NestedCstmt = conn.prepareCall(NestedStProcedure);
                NestedCstmt.setInt(1, rs.getInt("idPaciente"));
                NestedRs = NestedCstmt.executeQuery();
                NestedRs.next();
                    temp.setCirugiasINCanMasectomiaFecha(NestedRs.getDate("FechaMasectomia"));
                    temp.setCirugiasINCanConservadoraFecha(NestedRs.getDate("FechaConservadora"));
                    temp.setCirugiasINCanReconstruccionFecha(NestedRs.getDate("FechaReconstruccion"));
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
                if (temp.getBiopsiaINCanEtapa() == null)temp.setBiopsiaINCanEtapa("NA");
                if (temp.getBiopsiaINCanT() == null)temp.setBiopsiaINCanT("NA");
                if (temp.getBiopsiaINCanN() == null)temp.setBiopsiaINCanN("NA");
                if (temp.getBiopsiaINCanM() == null)temp.setBiopsiaINCanM("NA");
                if (temp.getBiopsiaINCanGradoHistologico() == null)temp.setBiopsiaINCanGradoHistologico("NA");
                if (temp.getBiopsiaINCanHer2( )== null)temp.setBiopsiaINCanHer2("NA");
                if (temp.getBiopsiaINCanFish() == null)temp.setBiopsiaINCanFish("NA");
                if (temp.getBiopsiaINCanKi67() == null)temp.setBiopsiaINCanKi67("NA");
                if (temp.getBiopsiaINCanRe() == null)temp.setBiopsiaINCanRe("NA");
                if (temp.getBiopsiaINCanRp() == null)temp.setBiopsiaINCanRp("NA");
                if (temp.getPreconsultaSegundaOpcion() == null)temp.setPreconsultaSegundaOpcion("NA");
                if (temp.getPreconsultaFechaDecision() == null)temp.setPreconsultaFechaDecision(Date.valueOf("1900-01-01"));
                if (temp.getPreconsultaDecision() == null)temp.setPreconsultaDecision("NA");
                if (temp.getSillaRuedas() == null)temp.setSillaRuedas("NA");
                if (temp.getBastón() == null)temp.setBastón("NA");
                if (temp.getOxigeno() == null)temp.setOxigeno("NA");
                if (temp.getCamilla() == null)temp.setCamilla("NA");
                if (temp.getBiopsiaPreviaLaminillas() == null)temp.setBiopsiaPreviaLaminillas("NA");
                if (temp.getBiopsiaPreviaBloques() == null)temp.setBiopsiaPreviaBloques("NA");
                if (temp.getBiopsiaPreviaTipo() == null)temp.setBiopsiaPreviaTipo("NA");
                if (temp.getBiopsiaPreviaLugarCuerpo() == null)temp.setBiopsiaPreviaLugarCuerpo("NA");
                if (temp.getBiopsiaPreviaFecha() == null)temp.setBiopsiaPreviaFecha(Date.valueOf("1900-01-01"));
                if (temp.getEstudioINCanMastografia() == null)temp.setEstudioINCanMastografia("NA");
                if (temp.getEstudioINCanMastografiaFecha() == null)temp.setEstudioINCanMastografiaFecha(Date.valueOf("1900-01-01"));
                if (temp.getEstudioINCanUSG() == null)temp.setEstudioINCanUSG("NA");
                if (temp.getEstudioINCanUSGFecha() == null)temp.setEstudioINCanUSGFecha(Date.valueOf("1900-01-01"));
                if (temp.getEstudioINCanRadiografia() == null)temp.setEstudioINCanRadiografia(Date.valueOf("1900-01-01"));
                if (temp.getEstudioINCanTomografia() == null)temp.setEstudioINCanTomografia(Date.valueOf("1900-01-01"));
                if (temp.getEstudioINCanMr() == null)temp.setEstudioINCanMr(Date.valueOf("1900-01-01"));
                if (temp.getEstudioINCanTransvaginal() == null)temp.setEstudioINCanTransvaginal(Date.valueOf("1900-01-01"));
                if (temp.getEstudioINCanAbdominal() == null)temp.setEstudioINCanAbdominal(Date.valueOf("1900-01-01"));
                if (temp.getEstudioINCanTiroides() == null)temp.setEstudioINCanTiroides(Date.valueOf("1900-01-01"));
                if (temp.getEstudioINCanPelvico() == null)temp.setEstudioINCanPelvico(Date.valueOf("1900-01-01"));
                if (temp.getEstudioINCanHepatico() == null)temp.setEstudioINCanHepatico(Date.valueOf("1900-01-01"));
                if (temp.getEstudioINCanPet() == null)temp.setEstudioINCanPet(Date.valueOf("1900-01-01"));
                if (temp.getEstudioINCanMuga() == null)temp.setEstudioINCanMuga(Date.valueOf("1900-01-01"));
                if (temp.getEstudioINCanGamma() == null)temp.setEstudioINCanGamma(Date.valueOf("1900-01-01"));
                if (temp.getEstudioINCanLaboratorio() == null)temp.setEstudioINCanLaboratorio(Date.valueOf("1900-01-01"));
                if (temp.getEstudioINCanCardio() == null)temp.setEstudioINCanCardio(Date.valueOf("1900-01-01"));
                if (temp.getEstudioINCanAnestesica() == null)temp.setEstudioINCanAnestesica(Date.valueOf("1900-01-01"));
                if (temp.getEstudioINCanInhaloterapia() == null)temp.setEstudioINCanInhaloterapia(Date.valueOf("1900-01-01"));
                if (temp.getEstudioINCanElectro() == null)temp.setEstudioINCanElectro(Date.valueOf("1900-01-01"));
                if (temp.getEstudioINCanEco() == null)temp.setEstudioINCanEco(Date.valueOf("1900-01-01"));
                if (temp.getProgramaINCanTrabajoSocial() == null)temp.setProgramaINCanTrabajoSocial(Date.valueOf("1900-01-01"));
                if (temp.getProgramaINCanMujeresJovenes() == null)temp.setProgramaINCanMujeresJovenes(Date.valueOf("1900-01-01"));
                if (temp.getProgramaINCanNutricion() == null)temp.setProgramaINCanNutricion(Date.valueOf("1900-01-01"));
                if (temp.getProgramaINCanGenetica() == null)temp.setProgramaINCanGenetica(Date.valueOf("1900-01-01"));
                if (temp.getEstudioPrevioMastografia() == null)temp.setEstudioPrevioMastografia("NA");
                if (temp.getEstudioPrevioMastografiaFecha() == null)temp.setEstudioPrevioMastografiaFecha(Date.valueOf("1900-01-01"));
                if (temp.getEstudioPrevioUSG() == null)temp.setEstudioPrevioUSG("NA");
                if (temp.getEstudioPrevioUSGFecha() == null)temp.setEstudioPrevioUSGFecha(Date.valueOf("1900-01-01"));
                if (temp.getEstudioPrevioRadioCiclos() == null)temp.setEstudioPrevioRadioCiclos(-1);
                if (temp.getEstudioPrevioRadioFecha() == null)temp.setEstudioPrevioRadioFecha(Date.valueOf("1900-01-01"));
                if (temp.getEstudioPrevioQuimioCiclos() == null)temp.setEstudioPrevioQuimioCiclos(-1);
                if (temp.getEstudioPrevioQuimioFecha() == null)temp.setEstudioPrevioQuimioFecha(Date.valueOf("1900-01-01"));
                if (temp.getEstudioPrevioCirugiaTipo() == null)temp.setEstudioPrevioCirugiaTipo("NA");
                if (temp.getEstudioPrevioCirugiaFecha() == null)temp.setEstudioPrevioCirugiaFecha(Date.valueOf("1900-01-01"));
                if (temp.getCirugiasINCanMasectomiaFecha() == null)temp.setCirugiasINCanMasectomiaFecha(Date.valueOf("1900-01-01"));
                if (temp.getCirugiasINCanConservadoraFecha() == null)temp.setCirugiasINCanConservadoraFecha(Date.valueOf("1900-01-01"));
                if (temp.getCirugiasINCanReconstruccionFecha() == null)temp.setCirugiasINCanReconstruccionFecha(Date.valueOf("1900-01-01"));
                
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
