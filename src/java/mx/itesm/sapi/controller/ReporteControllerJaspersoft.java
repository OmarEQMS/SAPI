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
import javax.servlet.http.HttpSession;
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
        HttpSession sesion = request.getSession(true);
        if(sesion.getAttribute("idCuenta")== null)
        {
            request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response); //Lo redirecciono al login
            System.out.println("estoy en el if");
        }else
        {
            int keyRol = (int) sesion.getAttribute("idRol");
            
            switch(keyRol) {
                case 4: {
                    String key = request.getParameter("key");
                    switch (key) {
                        case "generar-reporte1": {
                            //Estos datos los deberia tener la sesion
                            //int idPaciente = 62, idEmpleado = 40, keyRol = 4;
                            
                            int idPaciente = (int) sesion.getAttribute("idPacientePotencialForm");
                            int idEmpleado = (int) sesion.getAttribute("idEmpleadoNavegadora");
                            String report = "/mx/itesm/sapi/reportes/reporte/ReporteNavegadoraMitad.jasper";
                            InputStream input = getClass().getResourceAsStream(report);
                            List<ReporteNavegadora> reporteNavegadoraFields = new ArrayList<>();
                            
                            System.out.println("idPaciente: " + idPaciente);
                            System.out.println("idEmpledo: " + idEmpleado);
                            System.out.println("idRol: " + keyRol);
                            //ReporteNavegadora reporteNavegadora;
                            ReporteNavegadoraServicioImpl reportenavegadoraServicioImpl = new ReporteNavegadoraServicioImpl();
                            ReporteNavegadora reporteNavegadora = reportenavegadoraServicioImpl.mostrarReporteNavegadora(idPaciente, idEmpleado, keyRol);

                            if (reporteNavegadora != null) {
                                System.out.println("Se guardaron datos estaticos");
                            } else {
                                System.out.println("ESTA NULL");
                            }

                            reporteNavegadoraFields.add(reporteNavegadora);
                            System.out.println("El dato que esta en la lista:" + (reporteNavegadoraFields.get(0)).toString());

                            System.out.println("El size de reporteNavegadoraFields: " + reporteNavegadoraFields.size());

                            JRDataSource data = new JRBeanCollectionDataSource(reporteNavegadoraFields);

                            try {
                                String attach ="attachment; filename=ReportePRZ:" + String.valueOf(idPaciente)+".pdf";
                                response.setContentType("application/pdf");
                                response.addHeader("content-disposition", attach);
                                System.out.println("Entra al try ");
                                byte[] bytes = JasperRunManager.runReportToPdf(input, null, data);

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
                        case "generar-reporte2": {
                            //Estos datos los deberia tener la sesion
                            //int idPaciente = 62, idEmpleado = 40, keyRol = 4;
                            
                            int idPaciente = (int) sesion.getAttribute("idPacientePotencialForm");
                            int idEmpleado = (int) sesion.getAttribute("idEmpleadoNavegadora");

                            String report = "/mx/itesm/sapi/reportes/reporte/ReporteNavegadoraCompleto.jasper";
                            InputStream input = getClass().getResourceAsStream(report);
                            List<ReporteNavegadora> reporteNavegadoraFields = new ArrayList<>();

                            //ReporteNavegadora reporteNavegadora;
                            ReporteNavegadoraServicioImpl reportenavegadoraServicioImpl = new ReporteNavegadoraServicioImpl();
                            ReporteNavegadora reporteNavegadora = reportenavegadoraServicioImpl.mostrarReporteNavegadora(idPaciente, idEmpleado, keyRol);

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

                            for (int x = 0; x < llamada.size(); x++) {
                                llamadaPaciente = new LlamadaPaciente();
                                llamadaPaciente.setFecha(String.valueOf(new Date(((llamada.get(x)).getFecha()).getTime())));
                                llamadaPaciente.setMotivo((llamada.get(x)).getComentario());
                                llamadas.add(llamadaPaciente);
                            }

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
                                String attach ="attachment; filename=ReporteCompletoPRZ:" + String.valueOf(idPaciente)+".pdf";
                                response.setContentType("application/pdf");
                                response.addHeader("content-disposition", attach);
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
                    break;
                }
                case 2:
                {
                    String key = request.getParameter("key");
                    switch (key) {
                        case "generar-reporteformulario": {
                            
                            int idPaciente = (int) sesion.getAttribute("idPaciente");
                            int idEmpleado = (int) sesion.getAttribute("idEmpleado");

                            String report = "/mx/itesm/sapi/reportes/reporte/ReporteNavegadoraMitad.jasper";
                            InputStream input = getClass().getResourceAsStream(report);
                            List<ReporteNavegadora> reporteNavegadoraFields = new ArrayList<>();

                            //ReporteNavegadora reporteNavegadora;
                            ReporteNavegadoraServicioImpl reportenavegadoraServicioImpl = new ReporteNavegadoraServicioImpl();
                            ReporteNavegadora reporteNavegadora = reportenavegadoraServicioImpl.mostrarReporteNavegadora(idPaciente, idEmpleado, keyRol);

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

                            for (int x = 0; x < llamada.size(); x++) {
                                llamadaPaciente = new LlamadaPaciente();
                                llamadaPaciente.setFecha(String.valueOf(new Date(((llamada.get(x)).getFecha()).getTime())));
                                llamadaPaciente.setMotivo((llamada.get(x)).getComentario());
                                llamadas.add(llamadaPaciente);
                            }

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
                                String attach ="attachment; filename=ReporteCompleto" + String.valueOf(idPaciente)+".pdf";
                                response.setContentType("application/pdf");
                                response.addHeader("content-disposition", attach);
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
