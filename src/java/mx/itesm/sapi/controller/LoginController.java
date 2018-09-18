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
import mx.itesm.sapi.bean.Cuenta;
import mx.itesm.sapi.service.LoginServicioImpl;

/**
 *
 * @author julioguzman
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

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

        switch (key) {

            case "verificar": {

                String usuario = request.getParameter("usuario");
                String password = request.getParameter("password");
                

                if (usuario == null || password == null) {

                } else {

                    //Verificiar que el usuario exista, que contraseña
                    //sea correcta y que este habilitado
                    Cuenta cuenta = new Cuenta();

                    cuenta.setUsuario(usuario);
                    cuenta.setPassword(password);
                    

                    LoginServicioImpl cs = new LoginServicioImpl();
                    cuenta = cs.verificaCredenciales(cuenta);
                    

                    if (cuenta.getIdCuenta() != 0) {

                        //Obtener la sesion
                        HttpSession sesion = request.getSession(true);
                        
                        // @Autor: Alexis España: Obtiene la fecha de Login
                        long lDateTime = sesion.getCreationTime();
                        
                        // @Autor: Alexis España: Le inserta la fecha de login al objeto Cuenta
                        cuenta.setLoginDateTime(lDateTime);
                        cs.InsertLoginDateTime(cuenta);
                        
                        
                        /*//Escribir los valores de sesion
                        //(idCuenta, nombre, rol, status)
                        sesion.setAttribute("idCuenta", cuenta.getIdPersona());
                        sesion.setAttribute("idRol", cuenta.getIdRol());

                        PersonaServicioImpl psi = new PersonaServicioImpl();
                        Persona persona = psi.getPersona(cuenta.getIdCuenta());

                        sesion.setAttribute("nombre", persona.getNombre());

                        //Redirigir al usuario  al dashboard "correspondiente al"
                        request.getRequestDispatcher("/WEB-INF/dashboard.jsp")
                                .forward(request, response);*/

                        PrintWriter out = response.getWriter();
                        out.print("success");

                    } else {
                        
                        /*request.getRequestDispatcher("/WEB-INF/index.html")
                                .forward(request, response);*/
                        
                        PrintWriter out = response.getWriter();
                        out.print("doesntExist");
                        
                    }

                }

                break;

            }

            case "cerrar-sesion": {
                
                

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
