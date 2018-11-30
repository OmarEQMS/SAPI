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
    public ArrayList<ArrayList<String>> mostrarPoblacionGeneral() {
        
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        ArrayList<ArrayList<String>> PoblacionGeneral = new ArrayList<>();
        PoblacionGeneral.add(GeneralPoblacion.tableHeaderRStudio());
        //Call del store procedure
        String stProcedure = "CALL mostrarPoblacionGeneral()";
        
        try {
            
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();

            while (rs.next()){
                GeneralPoblacion temp = new GeneralPoblacion();
                Integer idPaciente = rs.getInt("idPaciente");
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
                temp.setConsultaTipo(rs.getString("Consulta_Tipo"));
                temp.setConsultaEstado(rs.getString("Consulta_Estado"));
                temp.setConsultaMotivo(rs.getString("Consulta_Motivo"));
                temp.setConsultaComentario(rs.getString("Consulta_Comentario"));
                temp.setConsultaFecha(rs.getDate("Consulta_Fecha"));
                temp.setConsultaDiagnosticoFecha(rs.getDate("Consulta_FechaDiagnostico"));
                
                String NestedStProcedure = "CALL mostrarPoblacionNecesidadesEspeciales(?)";
                CallableStatement NestedCstmt = conn.prepareCall(NestedStProcedure);
                NestedCstmt.setInt(1, idPaciente);
                ResultSet NestedRs = NestedCstmt.executeQuery();
                NestedRs.next();
                    temp.setSillaRuedas(NestedRs.getString("SillaDeRuedas"));
                    temp.setBastón(NestedRs.getString("Baston"));
                    temp.setOxigeno(NestedRs.getString("Oxigeno"));
                    temp.setCamilla(NestedRs.getString("Camilla"));
                NestedRs.close();
                NestedRs.close();
                
                NestedStProcedure = "CALL mostrarPoblacionMedicosCita(?)";
                NestedCstmt = conn.prepareCall(NestedStProcedure);
                NestedCstmt.setInt(1, rs.getInt("idCita"));
                NestedRs = NestedCstmt.executeQuery();
                NestedRs.next();
                    temp.setConsultaAdscritoNombre(NestedRs.getString("MedicosCita_Adscrito"));
                    if (NestedRs.getInt("MedicosCita_AdscritoPresente") == 0) temp.setConsultaAdscritoPresente("No");
                    else temp.setConsultaAdscritoPresente("Sí");
                    temp.setConsultaRadiologoNombre(NestedRs.getString("MedicosCita_Radiologo"));
                    if (NestedRs.getInt("MedicosCita_RadiologoPresente") == 0) temp.setConsultaRadiologoPresente("No");
                    else temp.setConsultaRadiologoPresente("Sí");
                NestedRs.close();
                NestedRs.close();
                
                NestedStProcedure = "CALL mostrarPoblacionEstudiosPrevios(?)";
                NestedCstmt = conn.prepareCall(NestedStProcedure);
                NestedCstmt.setInt(1, idPaciente);
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
                NestedCstmt.setInt(1, idPaciente);
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
                NestedCstmt.setInt(1, idPaciente);
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
                NestedCstmt.setInt(1, idPaciente);
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
                NestedCstmt.setInt(1, idPaciente);
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
                NestedCstmt.setInt(1, idPaciente);
                NestedRs = NestedCstmt.executeQuery();
                NestedRs.next();
                    temp.setCirugiasINCanMasectomiaFecha(NestedRs.getDate("FechaMasectomia"));
                    temp.setCirugiasINCanConservadoraFecha(NestedRs.getDate("FechaConservadora"));
                    temp.setCirugiasINCanReconstruccionFecha(NestedRs.getDate("FechaReconstruccion"));
                NestedRs.close();
                NestedRs.close();
                
                PoblacionGeneral.add(temp.toStringRStudio());
                System.out.println(PoblacionGeneral.size());
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
