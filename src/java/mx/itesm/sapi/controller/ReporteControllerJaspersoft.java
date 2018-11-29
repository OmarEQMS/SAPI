/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.itesm.sapi.bean.formulario.EstudioFormulario;
import mx.itesm.sapi.bean.formulario.LlamadaPaciente;
import mx.itesm.sapi.bean.formulario.ReporteNavegadora;
import mx.itesm.sapi.bean.gestionPaciente.LlamadaCita;
import mx.itesm.sapi.service.EstudioFormularioServicioImpl;
import mx.itesm.sapi.service.ReporteNavegadoraServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.LlamadaCitaServicioImpl;

import mx.itesm.sapi.util.Conexion;
import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

/**
 *
 * @author Alex
 */
@WebServlet(name = "ReporteControllerJaspersoft", urlPatterns = {"/ReporteControllerJaspersoft"})
public class ReporteControllerJaspersoft extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, JRException {
        String key = request.getParameter("key");
        switch (key) {
            case "pruebaSAPI": {
                System.out.println("Entra a el reporte buenon");
                //Estos datos los deberia tener la sesion
                //int idPaciente = 62, idEmpleado = 40, idRol = 4;
                String report = "/mx/itesm/sapi/reportes/reporte/ReporteNavegadorav2.0.jasper";
                InputStream input = getClass().getResourceAsStream(report);
                List<ReporteNavegadora> reporteNavegadoraFields = new ArrayList<>();
                //ReporteNavegadora reporteNavegadora;

                ReporteNavegadora reporteNavegadora = new ReporteNavegadora();

                try {

                    reporteNavegadora.setPrz("v_PRZ");
                    reporteNavegadora.setFechaNavegacion("v_fechaNavegacion");
                    reporteNavegadora.setFechaConsulta("v_fechaConsulta");
                    reporteNavegadora.setTipoPaciente("Segunda Opinion");
                    reporteNavegadora.setMedicoAdscrito("v_medicoAdsctio");
                    reporteNavegadora.setMedicoRadiologo("v_medicoRadiologo");
                    reporteNavegadora.setMedicoResidente("v_medicoResidente");
                    reporteNavegadora.setNoAdscrito("v_noAdscrito");
                    reporteNavegadora.setNoRadiologo("v_noRadiologo");
                    reporteNavegadora.setEscolaridad("v_escolaridad");
                    reporteNavegadora.setAlergias("v_alergias");
                    reporteNavegadora.setEstadoHormonal("PosMenopaucia");
                    reporteNavegadora.setSeguro("v_tipoSeguro");
                    reporteNavegadora.setNoSeguro("v_numeroSeguro");
                    reporteNavegadora.setMastografiaPreINCAN("Sí");
                    reporteNavegadora.setCirugiaFecha("v_cirugiaFecha");
                    reporteNavegadora.setCirugiaTipo("v_cirugiaTipo");
                    reporteNavegadora.setCirugiaComentario("v_cirugiaComentario");
                    reporteNavegadora.setQuimioterapiaFecha("v_quimioterapiaFecha");
                    reporteNavegadora.setQuimioterapiaCiclo("v_quimioterapiaCiclo");
                    reporteNavegadora.setQuimioterapiaComentario("v_quimioterapiaComentario");
                    reporteNavegadora.setRadioterapiaFecha("v_radioterapiaFecha");
                    reporteNavegadora.setRadioterapiaCiclo("v_radioterapiaCiclo");
                    reporteNavegadora.setRadioterapiaComentario("v_radioterapiaComentario");
                    reporteNavegadora.setMastografiaBiradsNombre("v_mastografiaBiradsNombre");
                    reporteNavegadora.setMastografiaBiradsFecha("v_mastografiaBiradsFecha");
                    reporteNavegadora.setUltrasonidoBiradsNombre("v_ultrasonidoBiradsNombre");
                    reporteNavegadora.setUltrasonidoBiradsFecha("v_ultrasonidoBiradsFecha");
                    reporteNavegadora.setResultadoPatologia("v_resultadoPatologia");
                    reporteNavegadora.setOtroResultado("v_otroResultado");
                    reporteNavegadora.setSerieParafina("v_serieParafina");
                    reporteNavegadora.setCantidadParafina("v_cantidadParafina");
                    reporteNavegadora.setSerieLaminillas("v_serieLaminillas");
                    reporteNavegadora.setCantidadLaminillas("v_cantidadLaminillas");
                    reporteNavegadora.setFechaFin("v_fechaFin");
                    reporteNavegadora.setDecisionConsulta("v_decisionCosulta");
                    reporteNavegadora.setSocioeconomico("v_socioeconomico");
                    reporteNavegadora.setComentarioIncidencia("v_comentarioIncidencia");
                    reporteNavegadora.setComentarioMedico("v_comentarioMedico");
                    reporteNavegadora.setT("v_T");
                    reporteNavegadora.setN("v_N");
                    reporteNavegadora.setM("v_M");
                    reporteNavegadora.setEtapaClinica("v_etapaClinica");
                    reporteNavegadora.setUltra("v_ultra");
                    reporteNavegadora.setMasto("v_masto");
                    reporteNavegadora.setHer2("v_her2");
                    reporteNavegadora.setRp("v_rp");
                    reporteNavegadora.setRe("v_re");
                    reporteNavegadora.setFish("v_fish");
                    reporteNavegadora.setKi67("v_ki67");
                    reporteNavegadora.setGradoH("v_gradoH");
                    reporteNavegadora.setResultadoPatologiaPost("v_resultadoPatologiaPost");

                    //Procedimineto almacenado
                    reporteNavegadora.setNombre("v_nombre");
                    reporteNavegadora.setEdad("v_edad");
                    reporteNavegadora.setFechaNacimiento("v_fechaNacimiento");
                    reporteNavegadora.setGenero("v_genero");
                    reporteNavegadora.setCiudad("v_ciudad");
                    reporteNavegadora.setEstado("v_estado");
                    reporteNavegadora.setTelefono("v_telefono");
                    reporteNavegadora.setNavegadora("Navegadora");//dato de prueba
                    reporteNavegadora.setResultado("No");

                    if (reporteNavegadora != null) {
                        System.out.println("Se guardaron datos estaticos");
                    } else {
                        System.out.println("ESTA NULL");
                    }

                    reporteNavegadoraFields.add(reporteNavegadora);
                    System.out.println("El dato que esta en la lista:" + reporteNavegadoraFields.get(0).toString());

                    System.out.println("El size de reporteNavegadoraFields: " + reporteNavegadoraFields.size());

                    JRDataSource data = new JRBeanCollectionDataSource(reporteNavegadoraFields);

                    //EstudioFormularioServicioImpl estudioFormularioServicioImpl = new EstudioFormularioServicioImpl();
                    //LlamadaCitaServicioImpl llamadaCitaServicioImpl = new LlamadaCitaServicioImpl();
                    List<EstudioFormulario> biopsias = new ArrayList<>(); //Tipo Fecha Lugar
                    List<EstudioFormulario> rayosX = new ArrayList<>(); //tipo fecha
                    List<EstudioFormulario> ultrasonidos = new ArrayList<>(); //tipo fecha
                    List<EstudioFormulario> medicinasNuclear = new ArrayList<>();//tipo fecha
                    List<EstudioFormulario> valoraciones = new ArrayList<>(); //tipo fecha
                    List<EstudioFormulario> programas = new ArrayList<>(); //tipo fecha
                    List<EstudioFormulario> laboratorios = new ArrayList<>();  //fecha
                    List<EstudioFormulario> electrocardiogramas = new ArrayList<>();//fecha
                    List<EstudioFormulario> ecocardiogramas = new ArrayList<>();//fecha
                    List<EstudioFormulario> trabajoSociales = new ArrayList<>();//fecha
                    List<EstudioFormulario> espirometrias = new ArrayList<>();
                    List<EstudioFormulario> otrosEstudios = new ArrayList<>(); //tipo fecha
                    List<LlamadaCita> llamadas = new ArrayList<>(); //Llamadas

                    EstudioFormulario biopsia = new EstudioFormulario();
                    EstudioFormulario rayoX = new EstudioFormulario();
                    EstudioFormulario ultrasonido = new EstudioFormulario();
                    EstudioFormulario medicinaNuclear = new EstudioFormulario();
                    EstudioFormulario valoracion = new EstudioFormulario();
                    EstudioFormulario programa = new EstudioFormulario();
                    EstudioFormulario laboratorio = new EstudioFormulario();
                    EstudioFormulario electrocardiograma = new EstudioFormulario();
                    EstudioFormulario ecocardiograma = new EstudioFormulario();
                    EstudioFormulario TrabajoSocial = new EstudioFormulario();
                    EstudioFormulario otroEstudio = new EstudioFormulario();
                    EstudioFormulario espirometria = new EstudioFormulario();
                    LlamadaCita llamada = new LlamadaCita();

                    biopsia.setTipo("TipoBiopsia");
                    biopsia.setFecha("fechabiopsia");
                    biopsia.setLugarDelCuerpo("lugarbiopsia");
                    rayoX.setFecha("fecharayosX");
                    rayoX.setTipo("tiporayosX");
                    ultrasonido.setTipo("tipoultra");
                    ultrasonido.setFecha("fechaultra");
                    medicinaNuclear.setTipo("tipomedicina");
                    medicinaNuclear.setFecha("fechamedicina");
                    valoracion.setTipo("tipovaloracion");
                    valoracion.setFecha("fechavaloracion");
                    programa.setTipo("tipoprograma");
                    programa.setFecha("fechaprograma");
                    laboratorio.setFecha("fechalaboratorio");
                    espirometria.setFecha("fechaespiro");
                    electrocardiograma.setFecha("fechaelectro");
                    ecocardiograma.setFecha("fechaeco");
                    TrabajoSocial.setFecha("fechaTrabajo");
                    otroEstudio.setFecha("trabajoSocialFecha");
                    otroEstudio.setTipo("tipootro");
                    //llamada.setFecha("fechaLlamada");
                    llamada.setComentario("motivollamada");
                    

                    biopsias.add(biopsia);
                    rayosX.add(rayoX);
                    ultrasonidos.add(ultrasonido);
                    medicinasNuclear.add(medicinaNuclear);
                    valoraciones.add(valoracion);
                    programas.add(programa);
                    laboratorios.add(laboratorio);
                    electrocardiogramas.add(electrocardiograma);
                    ecocardiogramas.add(ecocardiograma);
                    trabajoSociales.add(TrabajoSocial);
                    otrosEstudios.add(otroEstudio);
                    espirometrias.add(espirometria);
                    llamadas.add(llamada);

                    Map params = new HashMap();
                    params.put("datasetBiopsia", biopsias);
                    params.put("datasetRayosX", rayosX);
                    params.put("datasetUltrasonido", ultrasonidos);
                    params.put("datasetMedicinaNuclear", medicinasNuclear);
                    params.put("datasetLaboratorio", laboratorios);
                    params.put("datasetValoracion", valoraciones);
                    params.put("datasetEspirometria", espirometrias);
                    params.put("datasetElectroCardiograma", electrocardiogramas);
                    params.put("datasetEcocardiograma", ecocardiogramas);
                    params.put("datasetTrabajoSocial", trabajoSociales);
                    params.put("datasetPrograma", programas);
                    params.put("datasetOtro", otrosEstudios);
                    params.put("datasetLlamada", llamadas);
                   
                    response.setContentType("application/pdf");
                    response.addHeader("content-disposition", "attachment; filename=Reporte1.pdf");
                    
                    System.out.println("Entra al try ");
                    byte[] bytes = JasperRunManager.runReportToPdf(input, params, data);
                    for(int i=0; i< bytes.length;i++ )
                        System.out.println(bytes[i]);
                    System.out.println("Corre el JasperSoft");

                    OutputStream os = response.getOutputStream();
                    
                    System.out.println("Prepara la respuesta ");
                    
                    os.write(bytes);
                    os.flush();
                    os.close();
                    
                    

                } catch (Exception ex) {
                    System.out.println(this.getClass().toString().concat(ex.getMessage()));
                }

                break;
            }

            case "generar-reporte": {
                //Estos datos los deberia tener la sesion
                int idPaciente = 62, idEmpleado = 40, idRol = 4;
                String report = "/mx/itesm/sapi/reportes/reporte/ReporteNavegadorav2.0.jasper";
                InputStream input = getClass().getResourceAsStream(report);
                List<ReporteNavegadora> reporteNavegadoraFields = new ArrayList<>();

                //ReporteNavegadora reporteNavegadora;
                ReporteNavegadoraServicioImpl reportenavegadoraServicioImpl = new ReporteNavegadoraServicioImpl();
                ReporteNavegadora reporteNavegadora = reportenavegadoraServicioImpl.mostrarReporteNavegadora(idPaciente, idEmpleado, idRol);

                if (reporteNavegadora != null) {
                    System.out.println("Se guardaron datos estaticos");
                } else {
                    System.out.println("ESTA NULL");
                }

                reporteNavegadoraFields.add(reporteNavegadora);
                System.out.println("El dato que esta en la lista:" + reporteNavegadoraFields.get(0).toString());

                System.out.println("El size de reporteNavegadoraFields: " + reporteNavegadoraFields.size());

                JRDataSource data = new JRBeanCollectionDataSource(reporteNavegadoraFields);

                EstudioFormularioServicioImpl estudioFormularioServicioImpl = new EstudioFormularioServicioImpl();
                LlamadaCitaServicioImpl llamadaCitaServicioImpl = new LlamadaCitaServicioImpl();

                List<EstudioFormulario> biopsias = new ArrayList<>(); //Tipo Fecha Lugar
                List<EstudioFormulario> rayosX = new ArrayList<>(); //tipo fecha
                List<EstudioFormulario> ultrasonido = new ArrayList<>(); //tipo fecha
                List<EstudioFormulario> medicinaNuclear = new ArrayList<>();//tipo fecha
                List<EstudioFormulario> valoracion = new ArrayList<>(); //tipo fecha
                List<EstudioFormulario> programa = new ArrayList<>(); //tipo fecha
                List<EstudioFormulario> laboratorio = new ArrayList<>();  //fecha
                List<EstudioFormulario> electrocardiograma = new ArrayList<>();//fecha
                List<EstudioFormulario> ecocardiograma = new ArrayList<>();//fecha
                List<EstudioFormulario> trabajoSocial = new ArrayList<>();//fecha
                List<EstudioFormulario> otrosEstudios = new ArrayList<>(); //tipo fecha
                List<EstudioFormulario> espirometrias = new ArrayList<>(); //tipo fecha
                List<LlamadaCita> llamada = new ArrayList<>(); //Llamada
                List<LlamadaPaciente> llamadas = new ArrayList<>(); //Llamadas

                biopsias = estudioFormularioServicioImpl.mostrarFormularioDinamicoLTF(idPaciente, "Biopsia");
                rayosX = estudioFormularioServicioImpl.mostrarFormularioDinamicoFechaTipo(idPaciente, "Rayos X");
                ultrasonido = estudioFormularioServicioImpl.mostrarFormularioDinamicoFechaTipo(idPaciente, "Ultrasonido");
                medicinaNuclear = estudioFormularioServicioImpl.mostrarFormularioDinamicoFechaTipo(idPaciente, "Medicina nuclear");
                valoracion = estudioFormularioServicioImpl.mostrarFormularioDinamicoFechaTipo(idPaciente, "Valoración");
                programa = estudioFormularioServicioImpl.mostrarFormularioDinamicoFechaTipo(idPaciente, "Programas");
                laboratorio = estudioFormularioServicioImpl.mostrarFormularioDinamicoFecha(idPaciente, "Laboratorios");
                electrocardiograma = estudioFormularioServicioImpl.mostrarFormularioDinamicoFecha(idPaciente, "Electrocardiogramas");
                ecocardiograma = estudioFormularioServicioImpl.mostrarFormularioDinamicoFecha(idPaciente, "Ecocardiogramas");
                trabajoSocial = estudioFormularioServicioImpl.mostrarFormularioDinamicoFecha(idPaciente, "Trabajos sociales");
                otrosEstudios = estudioFormularioServicioImpl.mostrarFormularioDinamicoFechaTipo(idPaciente, "Otros");
                espirometrias = estudioFormularioServicioImpl.mostrarFormularioDinamicoFecha(idPaciente, "Trabajos sociales");
                llamada = llamadaCitaServicioImpl.mostrarLlamaCitaPreconsultaPaciente(idPaciente);
                LlamadaPaciente llamadaPaciente;
                
                System.out.println("Tamaño de llamada " + llamada.size());
                for (int x = 0; x < llamada.size(); x++) {
                    llamadaPaciente = new LlamadaPaciente();
                    llamadaPaciente.setFecha(String.valueOf(new Date(((llamada.get(x)).getFecha()).getTime())));
                    llamadaPaciente.setMotivo((llamada.get(x)).getComentario());
                    llamadas.add(llamadaPaciente);
                }

                /* Probar que los array tengan valores*/
                System.out.println("Llamadas: " + llamadas.size());

                Map params = new HashMap();
                params.put("datasetBiopsia", biopsias);
                params.put("datasetRayosX", rayosX);
                params.put("datasetUltrasonido", ultrasonido);
                params.put("datasetMedicinaNuclear", medicinaNuclear);
                params.put("datasetValoracion", valoracion);
                params.put("datasetPrograma", programa);
                params.put("datasetLaboratorio", laboratorio);
                params.put("datasetEspirometria", espirometrias);
                params.put("datasetElectroCardiograma", electrocardiograma);
                params.put("datasetEcocardiograma", ecocardiograma);
                params.put("datasetTrabajoSocial", trabajoSocial);
                params.put("datasetOtro", otrosEstudios);
                params.put("datasetLlamada", llamadas);

                try {
                    response.setContentType("application/pdf");
                    response.addHeader("content-disposition", "attachment; filename=Reporte1.pdf");
                    System.out.println("Entra al try ");
                    byte[] bytes = JasperRunManager.runReportToPdf(input, params, data);

                    System.out.println("Corre el JasperSoft");

                    OutputStream os = response.getOutputStream();
                    System.out.println("Prepara la respuesta ");

                    os.write(bytes);
                    os.flush();
                    os.close();
                    //request.getRequestDispatcher("/WEB-INF/potencial/cuentaPaciente.jsp").forward(request, response);

                } catch (Exception ex) {
                    System.out.println(this.getClass().toString().concat(ex.getMessage()));
                }

                break;
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (JRException ex) {
            Logger.getLogger(ReporteControllerJaspersoft.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (JRException ex) {
            Logger.getLogger(ReporteControllerJaspersoft.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
