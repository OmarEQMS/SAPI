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
import mx.itesm.sapi.bean.gestionPaciente.Paciente;
import mx.itesm.sapi.bean.persona.Cuenta;
import mx.itesm.sapi.bean.persona.Persona;
import mx.itesm.sapi.service.LoginServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteServicioImpl;
import mx.itesm.sapi.service.persona.PersonaServicioImpl;

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
        System.out.println("Key: ".concat(key));
        switch (key) {

            case "verificar": {

                String usuario = request.getParameter("usuario");
                String password = request.getParameter("password");
                
                System.out.println("Usuario".concat(usuario).concat(" password: ").concat(password));
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
                        
                        System.out.println("controler:" . concat(String.valueOf(cuenta.getIdCuenta())));

                        //Obtener la sesion
                        HttpSession sesion = request.getSession(true);
                        
                        // @Autor: Alexis España: Obtiene la fecha de Login
                        long lDateTime = sesion.getCreationTime();
                        
                        // @Autor: Alexis España: Le inserta la fecha de login al objeto Cuenta

                        //cuenta.setLoginDateTime(lDateTime);
                        //cs.InsertLoginDateTime(cuenta);

                        //cuenta.setLoginDateTime(lDateTime);                        
                        //cs.InsertLoginDateTime(cuenta);
                                                                                                
                        //Se establece el id del rol de la cuenta
                        int idCuenta = cuenta.getIdCuenta();
                        int rolCuenta =  cuenta.getIdRol();
                        
                        /*Escribir los valores de sesion*/                                                
                        //(idCuenta, nombre, rol, status)
                        sesion.setAttribute("idCuenta", idCuenta);
                        sesion.setAttribute("idRol",rolCuenta);

                        PersonaServicioImpl personaServicioImpl = new PersonaServicioImpl();
                        Persona persona = personaServicioImpl.mostrarPersona(cuenta.getIdPersona());
                        
                        sesion.setAttribute("idPersona", persona.getIdPersona());
                        sesion.setAttribute("nombre", persona.getNombre());
                        sesion.setAttribute("primerApellido", persona.getPrimerApellido());
                        sesion.setAttribute("segundoApellido", persona.getSegundoApellido());
                        sesion.setAttribute("imagen", persona.getImagen());
                        
                        System.out.println("Rol cuenta:".concat(String.valueOf(rolCuenta)).concat(" ").concat(String.valueOf(cuenta.getIdRol())));
                             
                        //EL SWITCH REDIRIGE SEGÚN EL ROL DE LA CUENTA
                        switch(rolCuenta)
                        {
                            /* CASE 1 PARA PACIENTE POTENCIAL*/
                            case 1:
                            {
                                
                               PacienteServicioImpl pacienteServicioImpl = new PacienteServicioImpl();
                               Paciente paciente = pacienteServicioImpl.mostrarPacientePotencial(idCuenta);
                               
                               System.out.println(String.valueOf(paciente.getIdPaciente()).concat(" ").concat(String.valueOf(paciente.getIdCuenta())).concat(" ").concat(String.valueOf(sesion.getAttribute("idCuenta"))));
                               
                               //System.out.println("Redirigir al dashboard de potencial ".concat(persona.toString()));
                                /*
                                //Redirigir al usuario  al dashboard "correspondiente al"
                                request.getRequestDispatcher("/WEB-INF/dashboard.jsp")
                                .forward(request, response);
                                */
                             break; 
                            }      
                            case 2:
                            {
                             break;
                            }      
                            case 3:
                            {
                             break;
                            }      
                            case 4:
                            {
                             break;
                            }                                    
                        }                       

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
