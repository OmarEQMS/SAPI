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
import mx.itesm.sapi.bean.Persona;
import mx.itesm.sapi.service.PersonaServiceImpl;

/**
 *
 * @author quint
 */
@WebServlet(name = "UsuarioController", urlPatterns = {"/UsuarioController"})
public class UsuarioController extends HttpServlet {

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
        // $_REQUEST['name'];
        // $_POST
        PersonaServiceImpl psi = new PersonaServiceImpl();
        String accion = request.getParameter("accion");
        
        switch(accion){
            case "registrar":{
                String name = request.getParameter("nombre");
                System.out.println("Nombre: ".concat(name));

                Persona persona = new Persona();
                persona.setNombre(name);

                int newID = psi.savePersona(persona);

                PrintWriter out = response.getWriter();
                out.print(newID);
                break;
            }
                
            case "listar":{                
                List<Persona> personas = psi.getPersonas();
                //Enviar la lista jsp
                request.setAttribute("personas", personas);
                request.getRequestDispatcher("/WEB-INF/gestionMedicos.jsp").forward(request, response);
                //response.sendRedirect("gestionMedicos.jsp");
                break;
            }
            case "eliminar":{
                int idU = Integer.parseInt(request.getParameter("id"));
                
                psi.deltePersona(idU);
                
                PrintWriter out = response.getWriter();
                out.print("YES");
                break;
            }
            case "recupera":{
                int idU = Integer.parseInt(request.getParameter("id"));
                
                Persona persona = psi.getPersona(idU);
                
                PrintWriter out = response.getWriter();
                Gson json = new Gson();
                out.print(json.toJson(persona));
                
                break;
            }
            case "actualiza":{
                int idU = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("nombre");
                String apellidos = request.getParameter("apellidos");

                Persona persona = new Persona();
                persona.setIdPersona(idU);
                persona.setNombre(name);
                persona.setApellidos(apellidos);
                
                psi.updatePersona(persona);

                PrintWriter out = response.getWriter();
                out.print("YES");
                
                break;
            }                
            default:{
                
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
