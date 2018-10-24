/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mx.itesm.sapi.bean.calendario.FullCalendar;
import mx.itesm.sapi.bean.gestionPaciente.Cita;
import mx.itesm.sapi.service.CalendarioServicioImpl;

/**
 *
 * @author julioguzman
 */
@WebServlet(name = "PacienteController", urlPatterns = {"/PacienteController"})
public class PacienteController extends HttpServlet {

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
            throws ServletException, IOException {

        //response.setContentType("text/html;charset=UTF-8");
        String key = request.getParameter("key");
        String idPaciente = request.getParameter("idPaciente");

        PrintWriter out = response.getWriter();

        switch (key) {

            case "obtenerEventos":

                //Servicio
                CalendarioServicioImpl csi = new CalendarioServicioImpl();

                //Lista Calendarios
                List<FullCalendar> calendarios = csi.mostrarEventos(Integer.parseInt(idPaciente));

                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");

                out.print(new Gson().toJson(calendarios));

                break;

            case "agregarEvento":

                int idImportancia;

                String tipo = request.getParameter("tipo");

                if (Integer.parseInt(tipo) == 3) {
                    idImportancia = 1;
                } else {
                    idImportancia = 2;
                }

                String medico = request.getParameter("medico");
        
                String piso = request.getParameter("piso");
                String edificio = request.getParameter("edificio");
                
                System.out.println("EL PISO ES: " + piso);
                System.out.println("EL EDIFICIO ES: " + edificio);

                String fechaProgramada = request.getParameter("fechaProgramada");

                Cita cita = new Cita();              
                
                cita.setIdTipoCita(Integer.parseInt(tipo));
                cita.setIdPaciente(Integer.parseInt(idPaciente));
                cita.setIdEstadoCita(5);
                cita.setIdImportanciaCita(idImportancia);
                cita.setIdPiso(Integer.parseInt(piso));
                
                //No se setea
                //cita.setIdTipoTratamiento(Integer.parseInt(tipo));
                
                cita.setFechaProgramada(fechaProgramada);

                //No se setea porque no hay estudios
                //cita.setIdEstudio();
                
                //No se setea porque esto lo registran los pacientes potenciales
                //cita.setIdMotivoConsulta(idImportancia);
                    
                //No se setea porque es de la navegadora
                //cita.setFechaReal();
                
         
                System.out.println("El id Paciente es: " + cita.getIdPaciente());
                System.out.println("El id estado cita: " +  cita.getIdEstadoCita());
                System.out.println("El id de la importancia: " + cita.getIdImportanciaCita());
                System.out.println("El piso es : " + cita.getIdPiso());
                System.out.println("El edificio es: " + edificio);
                System.out.println("El id del tipo de tratamiento: " + cita.getIdTipoTratamiento());
                System.out.println("Fecha programada: " +  cita.getFechaProgramada());
                
                System.out.println(":::::::NULOS::::::");
                System.out.println("El id motivo consulta es: " + cita.getIdMotivoConsulta());
                System.out.println("El id estudio es: " + cita.getIdEstudio());
                System.out.println("La fecha real: " +  cita.getFechaReal());
                
                
                cita.setEstatus(1);
                
                //Manda a llamar al servicio
                CalendarioServicioImpl nuevaCita = new CalendarioServicioImpl();
                
                int agregado = nuevaCita.agregarEvento(cita, edificio);
                
                System.out.println("FINAL: " + agregado);
                
                /*if(agregado > 0){
                    out.print("success");
                }else{
                    out.print("error");
                }*/
                
                out.print("success");
                
    

                break;

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
        processRequest(request, response);
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
        processRequest(request, response);
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
