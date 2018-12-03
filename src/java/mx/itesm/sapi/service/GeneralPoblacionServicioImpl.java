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
        String stProcedure = "CALL mostrarPoblacion()";
        
        try {
            
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();

            while (rs.next()){
                GeneralPoblacion temp = new GeneralPoblacion();
                temp.setNombrePersona(rs.getString("General_Nombre"));
                temp.setPrimerApellido(rs.getString("General_primerApellido"));
                temp.setSegundoApellido(rs.getString("General_segundoApellido"));
                temp.setCurp(rs.getString("General_curp"));
                temp.setTelefono(rs.getString("General_telefono"));
                temp.setCorreo(rs.getString("General_correo"));
                temp.setTipoSangre(rs.getString("General_TipoDeSangre"));
                temp.setEstado(rs.getString("General_NombreEstado"));
                temp.setMunicipio(rs.getString("General_NombreMunicipio"));
                temp.setFechaNacimiento(rs.getDate("General_fechaNacimiento"));
                temp.setEstadoCivil(rs.getString("General_NombreEstadoCivil"));
                temp.setSexo(rs.getString("General_NombreSexo"));
                temp.setEscolaridad(rs.getString("General_NivelEducativo"));
                temp.setEscolaridad(rs.getString("General_NivelSocioeconomico"));
                temp.setPrz(rs.getString("General_prz"));
                temp.setNoExpediente(rs.getString("General_expediente"));
                temp.setSeguro(rs.getString("General_NombreSeguro"));
                temp.setNoSeguroPopular(rs.getString("General_noSeguro"));
                temp.setAlergias(rs.getString("General_alergia"));
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
                temp.setSillaRuedas(rs.getString("SillaDeRuedas"));
                temp.setBastón(rs.getString("Baston"));
                temp.setOxigeno(rs.getString("Oxigeno"));
                temp.setCamilla(rs.getString("Camilla"));
                temp.setConsultaAdscritoNombre(rs.getString("MedicosCita_Adscrito"));
                switch (rs.getInt("MedicosCita_AdscritoPresente")) {
                    case 0:temp.setConsultaAdscritoPresente("No");break;
                    case 1:temp.setConsultaAdscritoPresente("Sí");break;
                    default:temp.setConsultaAdscritoPresente("NA");break;
                }
                temp.setConsultaRadiologoNombre(rs.getString("MedicosCita_Radiologo"));
                switch (rs.getInt("MedicosCita_RadiologoPresente")) {
                    case 0:temp.setConsultaRadiologoPresente("No");break;
                    case 1:temp.setConsultaRadiologoPresente("Sí");break;
                    default:temp.setConsultaRadiologoPresente("NA");break;
                }
                temp.setEstudioPrevioMastografia(rs.getString("EstudioPrevio_BiradsMastografia"));
                temp.setEstudioPrevioMastografiaFecha(rs.getDate("EstudioPrevio_FechaMastografia"));
                temp.setEstudioPrevioUSG(rs.getString("EstudioPrevio_BiradsUsg"));
                temp.setEstudioPrevioUSGFecha(rs.getDate("EstudioPrevio_FechaUsg"));
                temp.setEstudioPrevioRadioCiclos(rs.getInt("EstudioPrevio_CiclosRadiografia"));
                temp.setEstudioPrevioRadioFecha(rs.getDate("EstudioPrevio_FechaRadiografia"));
                temp.setEstudioPrevioQuimioCiclos(rs.getInt("EstudioPrevio_CiclosQuimioterapia"));
                temp.setEstudioPrevioQuimioFecha(rs.getDate("EstudioPrevio_FechaQuimioterapia"));
                temp.setEstudioPrevioCirugiaTipo(rs.getString("EstudioPrevio_TipoCirugia"));
                temp.setEstudioPrevioCirugiaFecha(rs.getDate("EstudioPrevio_FechaCirugia"));
                temp.setBiopsiaPreviaLaminillas(rs.getString("BiopsiaPrevia_Laminillas"));
                temp.setBiopsiaPreviaBloques(rs.getString("BiopsiaPrevia_Bloques"));
                temp.setBiopsiaPreviaTipo(rs.getString("BiopsiaPrevia_Tipo"));
                temp.setBiopsiaPreviaLugarCuerpo(rs.getString("BiopsiaPrevia_LugarCuerpo"));
                temp.setBiopsiaPreviaFecha(rs.getDate("BiopsiaPrevia_Fecha"));
                temp.setEstudioINCanMastografia(rs.getString("EstudioINCan_BiradsMastografia"));
                temp.setEstudioINCanMastografiaFecha(rs.getDate("EstudioINCan_FechaMastografia"));
                temp.setEstudioINCanUSG(rs.getString("EstudioINCan_BiradsUSG"));
                temp.setEstudioINCanUSGFecha(rs.getDate("EstudioINCan_FechaUSG"));
                temp.setEstudioINCanRadiografia(rs.getDate("EstudioINCan_FechaRadio"));
                temp.setEstudioINCanTomografia(rs.getDate("EstudioINCan_FechaTomo"));
                temp.setEstudioINCanMr(rs.getDate("EstudioINCan_FechaMr"));
                temp.setEstudioINCanTransvaginal(rs.getDate("EstudioINCan_FechaTransvaginal"));
                temp.setEstudioINCanAbdominal(rs.getDate("EstudioINCan_FechaAbdominal"));
                temp.setEstudioINCanTiroides(rs.getDate("EstudioINCan_FechaTiroideo"));
                temp.setEstudioINCanPelvico(rs.getDate("EstudioINCan_FechaPelvico"));
                temp.setEstudioINCanHepatico(rs.getDate("EstudioINCan_FechaHepatico"));
                temp.setEstudioINCanPet(rs.getDate("EstudioINCan_FechaPet"));
                temp.setEstudioINCanMuga(rs.getDate("EstudioINCan_FechaMuga"));
                temp.setEstudioINCanGamma(rs.getDate("EstudioINCan_FechaGamma"));
                temp.setEstudioINCanLaboratorio(rs.getDate("EstudioINCan_FechaLaboratorio"));
                temp.setEstudioINCanCardio(rs.getDate("EstudioINCan_FechaCardio"));
                temp.setEstudioINCanAnestesica(rs.getDate("EstudioINCan_FechaAnestesica"));
                temp.setEstudioINCanInhaloterapia(rs.getDate("EstudioINCan_FechaInhalo"));
                temp.setEstudioINCanElectro(rs.getDate("EstudioINCan_FechaElectro"));
                temp.setEstudioINCanEco(rs.getDate("EstudioINCan_FechaEco"));
                temp.setProgramaINCanTrabajoSocial(rs.getDate("Programa_FechaTrabajoSocial"));
                temp.setProgramaINCanMujeresJovenes(rs.getDate("Programa_FechaMujerJoven"));
                temp.setProgramaINCanNutricion(rs.getDate("Programa_FechaNutricion"));
                temp.setProgramaINCanGenetica(rs.getDate("Programa_FechaGenetica"));
                temp.setBiopsiaINCanGradoHistologico(rs.getString("BiopsiaINCan_GradoHistologico"));
                temp.setBiopsiaINCanHer2(rs.getString("BiopsiaINCan_Her2"));
                temp.setBiopsiaINCanFish(rs.getString("BiopsiaINCan_Fish"));
                temp.setBiopsiaINCanKi67(rs.getString("BiopsiaINCan_Ki67"));
                temp.setBiopsiaINCanRe(rs.getString("BiopsiaINCan_RE"));
                temp.setBiopsiaINCanRp(rs.getString("BiopsiaINCan_RP"));
                switch (rs.getInt("Preconsulta_SegundaOpinion")) {
                    case 0: temp.setPreconsultaSegundaOpcion("Primera vez");break;
                    case 1: temp.setPreconsultaSegundaOpcion("Segunda Opinión");break;
                    default: temp.setPreconsultaSegundaOpcion("NA"); break;
                }
                temp.setPreconsultaFechaDecision(rs.getDate("Preconsulta_FechaDecision"));
                temp.setPreconsultaDecision(rs.getString("Preconsulta_Decision"));
                temp.setCirugiasINCanMasectomiaFecha(rs.getDate("FechaMasectomia"));
                temp.setCirugiasINCanConservadoraFecha(rs.getDate("FechaConservadora"));
                temp.setCirugiasINCanReconstruccionFecha(rs.getDate("FechaReconstruccion"));
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
    @Override
    public boolean actualizarPoblacionGeneral() {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        //Call del store procedure
        String stProcedure = "CALL actualizarPoblacion()";
        
        try {
            
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            
            rs.close();
            cstmt.close();
            conn.close();
            return true;

        } catch (SQLException ex) {
            System.out.println("GeneralPoblacionServicioImpl mostrarPoblacionGeneral");
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            return false;
        }
    }
    
}
