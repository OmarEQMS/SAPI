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
import mx.itesm.sapi.bean.persona.Cuenta;
import mx.itesm.sapi.service.persona.CuentaServicioImpl;

/**
 *
 * @author Angel GTZ
 */
@WebServlet(name = "RecuperarController", urlPatterns = {"/RecuperarController"})
public class RecuperarController extends HttpServlet {

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

        System.out.println("RecuperarController Method ".concat(request.getMethod()));

        String key = request.getParameter("key");

        System.out.println("URL RecuperarController: ".concat(request.getRequestURL().toString()));

        switch (key) {

            case "cambiarContrasena": {

                /**
                 * Aqui tomamos las contraseñas las comparamos para ver si son
                 * iguales y de ser asi se le actualiza en la base de datos
                 */
                //lo que esta comentado es haciendo la sesion aqui
                //HttpSession sesion = request.getSession(true);
                String contra = request.getParameter("password");
                String contra2 = request.getParameter("password2");
                int idCuenta = Integer.parseInt(request.getParameter("idCita"));
                CuentaServicioImpl cuentaServiceImpl = new CuentaServicioImpl();
                //Cuenta cuenta = cuentaServiceImpl.mostrarCuenta((int) sesion.getAttribute("idPersona"));

                if (contra.equals(contra2)) {

                    CuentaServicioImpl cuentaServicio = new CuentaServicioImpl();

                    Cuenta cuenta = cuentaServicio.mostrarCuenta(idCuenta);

                    cuenta.setPassword(contra);

                    cuentaServicio.actualizarCuenta(cuenta);
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
