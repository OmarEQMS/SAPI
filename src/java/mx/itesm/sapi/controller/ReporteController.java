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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.itesm.sapi.bean.rendimiento.Rendimiento;
import mx.itesm.sapi.service.RendimientoServicioImpl;

/**
 *
 * @author julioguzman
 */
@WebServlet(name = "ReporteController", urlPatterns = {"/ReporteController"})
public class ReporteController extends HttpServlet {

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

        response.setContentType("text/html;charset=UTF-8");

        String key = request.getParameter("key");

        String now = request.getParameter("fecha");

        System.out.println("Key: ".concat(key));

        System.out.println("Fecha: ".concat(now));

        PrintWriter out = response.getWriter();

        switch (key) {

            case "mostrarVisitaMes":

                //Servicio
                RendimientoServicioImpl rendimientoVisitasPorMes = new RendimientoServicioImpl();

                Rendimiento visitasPorMes = new Rendimiento();

                visitasPorMes = rendimientoVisitasPorMes.mostrarVisitaMes(2, Date.valueOf(now));

                out.print(new Gson().toJson(visitasPorMes));

                break;

            case "mostrarVisitaEdad":

                //Servicio
                RendimientoServicioImpl rendimientoServicioEdad = new RendimientoServicioImpl();

                ArrayList<Rendimiento> rendimientoPorEdad = new ArrayList<>();
                rendimientoPorEdad = rendimientoServicioEdad.mostrarVisitaEdad(2, Date.valueOf(now));

                out.print(new Gson().toJson(rendimientoPorEdad));

                break;

            case "mostrarVisitaEscolaridad": {

                //Servicio
                RendimientoServicioImpl rendimientoServicioEscolaridad = new RendimientoServicioImpl();

                ArrayList<Rendimiento> rendimientoPorEscolaridad = new ArrayList<>();
                rendimientoPorEscolaridad = rendimientoServicioEscolaridad.mostrarVisitaEscolaridad(2, Date.valueOf(now));

                out.print(new Gson().toJson(rendimientoPorEscolaridad));

                break;

            }
            
            case "mostrarVisitaLugarResidencia": {
            
                //Servicio
                RendimientoServicioImpl rendimientoServicioLugarResidencia = new RendimientoServicioImpl();
                
                ArrayList<Rendimiento> rendimientoPorLugar = new ArrayList<>();
                rendimientoPorLugar = rendimientoServicioLugarResidencia.mostrarVisitaLugarResidencia(2, Date.valueOf(now));
                
                out.print(new Gson().toJson(rendimientoPorLugar));
                
                break;
            
            }
            
            
            case "mostrarVisitaNivelSocioEconomico": {
                
                //Servicio
                RendimientoServicioImpl rendimientoServicioNivelSocioEconomico = new RendimientoServicioImpl();
                
                ArrayList<Rendimiento> rendimientoPorNivel = new ArrayList<>();
                rendimientoPorNivel = rendimientoServicioNivelSocioEconomico.mostrarVisitaNivelSocioEconomico(2, Date.valueOf(now));
                
                out.print(new Gson().toJson(rendimientoPorNivel));
                
                break;
            
            }
            
            case "mostrarVisitaDecisionPreconsulta": {
                
                //Servicio
                RendimientoServicioImpl rendimientoServicioDecisionPre = new RendimientoServicioImpl();
                
                ArrayList<Rendimiento> rendimientoPorDecision = new ArrayList<>();
                rendimientoPorDecision = rendimientoServicioDecisionPre.mostrarVisitaDecisionPreconsulta(2, Date.valueOf(now));
                
                out.print(new Gson().toJson(rendimientoPorDecision));
            
                
                break;
            }
            
            case "mostrarVisitaResultadoPatologia": {
                
                //Servicio
                RendimientoServicioImpl rendimientoServicioResPatologia = new RendimientoServicioImpl();
                
                ArrayList<Rendimiento> rendimientoPorResPatologia  = new ArrayList<>();
                rendimientoPorResPatologia = rendimientoServicioResPatologia.mostrarVisitaResultadoPatologia(2, Date.valueOf(now));
                
                out.print(new Gson().toJson(rendimientoPorResPatologia));
                
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
