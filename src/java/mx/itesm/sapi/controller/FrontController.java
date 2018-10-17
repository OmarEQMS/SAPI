/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author quint
 */
@WebServlet(name = "FrontController", urlPatterns = {"/SAPI"})
public class FrontController extends HttpServlet {

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

        String file = request.getParameter("file");
        //System.out.println("file:".concat(file));
        if (file == null) {
            HttpSession sesion = request.getSession(true);
            if (sesion.getAttribute("idCuenta") == null) {
                request.setAttribute("status", "");
                request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);

                return;
            } else {
                /*
                int keyRol = Integer.parseInt(sesion.getAttribute("idRol").toString());
                switch (keyRol) {
                    case 1: {
                        request.getRequestDispatcher("WEB-INF/potencial/index.jsp").forward(request, response);
                    }
                }
                
                 */
                return;
            }
        }

        if ("jsp".equals(file.substring(file.length() - 3))) {
            System.out.println("llegue aqui ".concat(file));
            HttpSession sesion = request.getSession(true); //Veo si tiene sesion iniciada
            if (sesion.getAttribute("idCuenta") == null) { //no tiene sesion iniciada
                System.out.println("llegue aqui 2 ".concat(file));
                // request.setAttribute("status", "");
                request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response); //Lo redirecciono al login
                return;
            } else { //Si tiene sesion iniciada
                //Lo redireciono a su rol
                int keyRol = (int) sesion.getAttribute("idRol");
                System.out.println("llegue aqui 3 ".concat(String.valueOf(keyRol)));
                switch (keyRol) {
                    case 1: {
                        String keyRuta = request.getParameter("file");
                        System.out.println("llegue aqui 3.5 ".concat(keyRuta));
                        switch (keyRuta) {

                            case "potencial/cuentaPaciente.jsp": {
                                System.out.println("llegue aqui 4 ".concat(keyRuta));
                                request.setAttribute("nombre", sesion.getAttribute("nombre"));
                                request.setAttribute("primerApellido",sesion.getAttribute("primerApellido"));
                                request.setAttribute("segundoApellido",sesion.getAttribute("segundoApellido"));                                                              
                                request.getRequestDispatcher("/WEB-INF/".concat(keyRuta)).forward(request, response); //Lo redirecciono al login
                                break;
                            }
                        }

                        break;
                    }
                }
            }

            //System.out.println("filename if ".concat(file));
            // request.getRequestDispatcher("WEB-INF/" + file).forward(request, response);
            // return;
        } else {

            System.out.println("filename else ".concat(file));
            request.getRequestDispatcher("/" + file).forward(request, response);
            return;

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
