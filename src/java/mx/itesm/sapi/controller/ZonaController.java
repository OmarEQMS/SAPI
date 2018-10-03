/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.itesm.sapi.bean.persona.CodigoPostal;
import mx.itesm.sapi.bean.persona.Estado;
import mx.itesm.sapi.bean.persona.EstadoCivil;
import mx.itesm.sapi.bean.persona.Municipio;
import mx.itesm.sapi.service.ZonaServicioImpl;

/**
 *
 * @author feror
 */
@WebServlet(name = "ZonaController", urlPatterns = {"/ZonaController"})
public class ZonaController extends HttpServlet {

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

        /////////////////////////////////////////////////////        
        String key = request.getParameter("key");

        switch (key) {

            case "getByEstado": {

                //Recoge desde el ajax
                int idEstado = Integer.parseInt(request.getParameter("idEstado"));
                Estado estado = new Estado();

                estado.setIdEstado(idEstado);

                ZonaServicioImpl psi = new ZonaServicioImpl();

                List<Municipio> municipios = psi.getMunicipios(estado);

                request.setAttribute("municipios", municipios);

                PrintWriter out = response.getWriter();

                Gson json = new Gson();
                out.print(json.toJson(municipios));
                

                break;

            }

            case "getRegistro": {
                //Cargar los estados
                ZonaServicioImpl zsi = new ZonaServicioImpl();
                List<Estado> allEstados = zsi.getEstados();
                List<EstadoCivil> estados = zsi.getEstadoCivil();
                request.setAttribute("estadoCivil", estados);
                request.setAttribute("estados", allEstados);
                request.getRequestDispatcher("/WEB-INF/registro.jsp").forward(request, response);
                break;
            }
            case "getEstadoyMunicipio": {
               String numeroCP = request.getParameter("numeroCP");
                CodigoPostal CP = new CodigoPostal();

                CP.setNumero(numeroCP);
                ZonaServicioImpl zsi = new ZonaServicioImpl();
                List<String> estadoyMunicipio = zsi.getEstadoyMunicipio(CP);
                
                PrintWriter out = response.getWriter();

                Gson json = new Gson();
                out.print(json.toJson(estadoyMunicipio));
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
