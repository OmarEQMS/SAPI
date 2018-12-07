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
import javax.servlet.http.HttpSession;
import mx.itesm.sapi.bean.rendimiento.Rendimiento;
import mx.itesm.sapi.service.EstadisticaServicioImpl;
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

        //Recibe Fechas
        String fecha1 = request.getParameter("fecha1");
        String fecha2 = request.getParameter("fecha2");

        //Imprime parametros para pruebas
        System.out.println("Key: ".concat(key));
        System.out.println("Fecha1: ".concat(fecha1));
        System.out.println("Fecha2: ".concat(fecha2));

        PrintWriter out = response.getWriter();
        HttpSession sesion = request.getSession(true);
        int idEmpleadoNavegadora = (int) sesion.getAttribute("idEmpleadoNavegadora");
        if (sesion.getAttribute("idCuenta") == null) {
            request.setAttribute("status", "");
            request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
        } else {
            switch (key) {

                case "mostrarVisitaMes": {

                    //Servicio
                    RendimientoServicioImpl rendimientoVisitasPorMes = new RendimientoServicioImpl();

                    Rendimiento visitasPorMes = new Rendimiento();

                    visitasPorMes = rendimientoVisitasPorMes.mostrarVisitaRango(idEmpleadoNavegadora, Date.valueOf(fecha1), Date.valueOf(fecha2));

                    out.print(new Gson().toJson(visitasPorMes));

                    break;
                }
                case "mostrarVisitaEdad": {

                    //Servicio
                    RendimientoServicioImpl rendimientoServicioEdad = new RendimientoServicioImpl();

                    ArrayList<Rendimiento> rendimientoPorEdad = new ArrayList<>();

                    rendimientoPorEdad = rendimientoServicioEdad.mostrarVisitaEdad(idEmpleadoNavegadora, Date.valueOf(fecha1), Date.valueOf(fecha2));

                    out.print(new Gson().toJson(rendimientoPorEdad));

                    break;
                }
                case "mostrarVisitaEscolaridad": {

                    //Servicio
                    RendimientoServicioImpl rendimientoServicioEscolaridad = new RendimientoServicioImpl();

                    ArrayList<Rendimiento> rendimientoPorEscolaridad = new ArrayList<>();

                    rendimientoPorEscolaridad = rendimientoServicioEscolaridad.mostrarVisitaEscolaridad(idEmpleadoNavegadora, Date.valueOf(fecha1), Date.valueOf(fecha2));

                    out.print(new Gson().toJson(rendimientoPorEscolaridad));

                    break;

                }

                case "mostrarVisitaLugarResidencia": {

                    //Servicio
                    RendimientoServicioImpl rendimientoServicioLugarResidencia = new RendimientoServicioImpl();

                    ArrayList<Rendimiento> rendimientoPorLugar = new ArrayList<>();

                    rendimientoPorLugar = rendimientoServicioLugarResidencia.mostrarVisitaLugarResidencia(idEmpleadoNavegadora, Date.valueOf(fecha1), Date.valueOf(fecha2));

                    out.print(new Gson().toJson(rendimientoPorLugar));

                    break;

                }

                case "mostrarVisitaNivelSocioEconomico": {

                    //Servicio
                    RendimientoServicioImpl rendimientoServicioNivelSocioEconomico = new RendimientoServicioImpl();

                    ArrayList<Rendimiento> rendimientoPorNivel = new ArrayList<>();

                    rendimientoPorNivel = rendimientoServicioNivelSocioEconomico.mostrarVisitaNivelSocioEconomico(idEmpleadoNavegadora, Date.valueOf(fecha1), Date.valueOf(fecha2));

                    out.print(new Gson().toJson(rendimientoPorNivel));

                    break;

                }

                case "mostrarVisitaDecisionPreconsulta": {

                    //Servicio
                    RendimientoServicioImpl rendimientoServicioDecisionPre = new RendimientoServicioImpl();

                    ArrayList<Rendimiento> rendimientoPorDecision = new ArrayList<>();

                    rendimientoPorDecision = rendimientoServicioDecisionPre.mostrarVisitaDecisionPreconsulta(idEmpleadoNavegadora, Date.valueOf(fecha1), Date.valueOf(fecha2));

                    out.print(new Gson().toJson(rendimientoPorDecision));

                    break;
                }

                case "mostrarVisitaResultadoPatologia": {

                    //Servicio
                    RendimientoServicioImpl rendimientoServicioResPatologia = new RendimientoServicioImpl();

                    ArrayList<Rendimiento> rendimientoPorResPatologia = new ArrayList<>();

                    rendimientoPorResPatologia = rendimientoServicioResPatologia.mostrarVisitaResultadoPatologia(idEmpleadoNavegadora, Date.valueOf(fecha1), Date.valueOf(fecha2));

                    out.print(new Gson().toJson(rendimientoPorResPatologia));

                    break;

                }
                /**
                 *
                 * @author Angel GTZ
                 */     

                case "mostrarEstadisticaMes": {

                    //Servicio
                    EstadisticaServicioImpl estadisticaPorMes = new EstadisticaServicioImpl();

                    Rendimiento visitasPorMes = new Rendimiento();

                    visitasPorMes = estadisticaPorMes.mostrarEstadisticaRango(Date.valueOf(fecha1), Date.valueOf(fecha2));

                    out.print(new Gson().toJson(visitasPorMes));

                    break;
                }
                case "mostrarEstadisticaEdad": {

                    //Servicio
                    EstadisticaServicioImpl estadisticaServicioEdad = new EstadisticaServicioImpl();

                    ArrayList<Rendimiento> estadisticaPorEdad = new ArrayList<>();

                    estadisticaPorEdad = estadisticaServicioEdad.mostrarEstadisticaEdad(Date.valueOf(fecha1), Date.valueOf(fecha2));

                    out.print(new Gson().toJson(estadisticaPorEdad));

                    break;
                }
                case "mostrarEstadisticaEscolaridad": {

                    //Servicio
                    EstadisticaServicioImpl estadisticaServicioEscolaridad = new EstadisticaServicioImpl();

                    ArrayList<Rendimiento> estadisticaPorEscolaridad = new ArrayList<>();

                    estadisticaPorEscolaridad = estadisticaServicioEscolaridad.mostrarEstadisticaEscolaridad(Date.valueOf(fecha1), Date.valueOf(fecha2));

                    out.print(new Gson().toJson(estadisticaPorEscolaridad));

                    break;

                }

                case "mostrarEstadisticaLugarResidencia": {

                    //Servicio
                    EstadisticaServicioImpl estadisticaServicioLugarResidencia = new EstadisticaServicioImpl();

                    ArrayList<Rendimiento> estadisticaPorLugar = new ArrayList<>();

                    estadisticaPorLugar = estadisticaServicioLugarResidencia.mostrarEstadisticaLugarResidencia(Date.valueOf(fecha1), Date.valueOf(fecha2));

                    out.print(new Gson().toJson(estadisticaPorLugar));

                    break;

                }

                case "mostrarEstadisticaNivelSocioEconomico": {

                    //Servicio
                    EstadisticaServicioImpl estadisticaServicioNivelSocioEconomico = new EstadisticaServicioImpl();

                    ArrayList<Rendimiento> estadisticaPorNivel = new ArrayList<>();

                    estadisticaPorNivel = estadisticaServicioNivelSocioEconomico.mostrarEstadisticaNivelSocioEconomico(Date.valueOf(fecha1), Date.valueOf(fecha2));

                    out.print(new Gson().toJson(estadisticaPorNivel));

                    break;

                }

                case "mostrarEstadisticaDecisionPreconsulta": {

                    //Servicio
                    EstadisticaServicioImpl estadisticaServicioDecisionPre = new EstadisticaServicioImpl();

                    ArrayList<Rendimiento> estadisticaPorDecision = new ArrayList<>();

                    estadisticaPorDecision = estadisticaServicioDecisionPre.mostrarEstadisticaDecisionPreconsulta(Date.valueOf(fecha1), Date.valueOf(fecha2));

                    out.print(new Gson().toJson(estadisticaPorDecision));

                    break;
                }

                case "mostrarEstadisticaResultadoPatologia": {

                    //Servicio
                    EstadisticaServicioImpl estadisticaServicioResPatologia = new EstadisticaServicioImpl();

                    ArrayList<Rendimiento> estadisticaPorResPatologia = new ArrayList<>();

                    estadisticaPorResPatologia = estadisticaServicioResPatologia.mostrarEstadisticaResultadoPatologia(Date.valueOf(fecha1), Date.valueOf(fecha2));

                    out.print(new Gson().toJson(estadisticaPorResPatologia));

                    break;

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
