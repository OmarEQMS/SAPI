/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mx.itesm.sapi.bean.moduloGestionMedico.Empleado;
import mx.itesm.sapi.bean.moduloGestionMedico.Especialidad;
import mx.itesm.sapi.bean.moduloGestionMedico.MedicoEspecialidad;
import mx.itesm.sapi.bean.moduloGestionMedico.TablaMedicoAdministrador;
import mx.itesm.sapi.bean.persona.Cuenta;
import mx.itesm.sapi.bean.persona.Persona;
import mx.itesm.sapi.service.moduloGestionMedico.EmpleadoServicioImpl;
import mx.itesm.sapi.service.moduloGestionMedico.EspecialidadServicioImpl;
import mx.itesm.sapi.service.moduloGestionMedico.MedicoEspecialidadServicioImpl;
import mx.itesm.sapi.service.persona.CuentaServicioImpl;
import mx.itesm.sapi.service.persona.PersonaServicioImpl;

/**
 *
 * @author urieldiaz
 */
@WebServlet(name = "AdministradorController", urlPatterns = {"/AdministradorController"})
public class AdministradorController extends HttpServlet {

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
        
        HttpSession sesion = request.getSession(true);
        
        if(sesion.getAttribute("idCuenta") == null)
        {
              request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response); //Lo redirecciono al login
              System.out.println("Sin sesión");
        }else
        {
                switch(key)
                {
                    case "obtener-medico":
                    {
                        int idMedicoAdministrador = Integer.valueOf(request.getParameter("idMedicoAdministrador"));
                        
                        EmpleadoServicioImpl empleadoServicioImpl = new EmpleadoServicioImpl();
                        TablaMedicoAdministrador medico = empleadoServicioImpl.mostrarMedicoAdministrador(idMedicoAdministrador);
                                                                        
                        PrintWriter out = response.getWriter();
                        out.print(new Gson().toJson(medico));                        
                        break;
                    }
                    case "actualizar-medico":
                    {
                        System.out.println("Actualizar médico");
                        int idMedicoAdministrador = Integer.valueOf(request.getParameter("idMedico"));
                        String nombre = request.getParameter("nombre");
                        String primerApellido = request.getParameter("primerApellido");
                        String segundoApellido = request.getParameter("segundoApellido");
                        String correo = request.getParameter("correo");
                        String telefono = request.getParameter("telefono");
                        String noEmpleado = request.getParameter("noEmpleado");
                        String especialidad = request.getParameter("especialidad");
                        String usuario = request.getParameter("subEspecialidad");
                        String cedula = request.getParameter("cedula");
                         
                        System.out.println("idMEdico admin ".concat(String.valueOf(idMedicoAdministrador)));
                        System.out.println("nombre ".concat(nombre));
                        System.out.println("apellido 1 ".concat(primerApellido));
                        System.out.println("apellido 2 ".concat(segundoApellido));
                        System.out.println("correo  ".concat(correo));
                        System.out.println("telefeno ".concat(telefono) );
                        System.out.println("noEmpleado ".concat(noEmpleado));
                        System.out.println("especialidad ".concat(especialidad));
                        System.out.println("usuario ".concat(usuario));
                        System.out.println("cedula ".concat(cedula));
                        
                        
                        PrintWriter out = response.getWriter();
                        
                                                
                        EmpleadoServicioImpl empleadoServicioImpl = new EmpleadoServicioImpl();
                        TablaMedicoAdministrador medico = empleadoServicioImpl.mostrarMedicoAdministrador(idMedicoAdministrador);
                                                
                        EspecialidadServicioImpl especialidadServicioImpl = new EspecialidadServicioImpl();
                        Especialidad especialidadMedicos = especialidadServicioImpl.mostrarEspecialidadPorNombre(especialidad);
                        
                        MedicoEspecialidadServicioImpl medicoEspecialidadServicioImpl = new MedicoEspecialidadServicioImpl ();
                        MedicoEspecialidad medicoEspecialidad = medicoEspecialidadServicioImpl.mostrarMedicoEspecialidadEmpleado(idMedicoAdministrador);
                        medicoEspecialidad.setCedulaProfesional(cedula);
                        medicoEspecialidad.setIdEspecialidad(especialidadMedicos.getIdEspecialidad());
                        System.out.println(" adminiController medicoEspecialidad ".concat(String.valueOf(medicoEspecialidad.getIdEmpleado())));
                        boolean medicoEspecialidadBoolean = medicoEspecialidadServicioImpl.actualizarMedicoEspecialidad(medicoEspecialidad);
                        
                        
                        PersonaServicioImpl personaServicioImpl = new PersonaServicioImpl();
                        Persona persona = personaServicioImpl.mostrarPersona(medico.getIdPersona());
                        persona.setNombre(nombre);
                        persona.setPrimerApellido(primerApellido);
                        persona.setSegundoApellido(segundoApellido);
                        persona.setCorreo(correo);
                        persona.setTelefono(telefono);
                        boolean personaBoolean = personaServicioImpl.actualizarPersonaMedico(persona);
                        
                        CuentaServicioImpl cuentaServicioImpl = new CuentaServicioImpl();
                        Cuenta cuenta = cuentaServicioImpl.mostrarCuenta(medico.getIdCuenta());
                        cuenta.setUsuario(usuario);
                        boolean cuentaBoolean = cuentaServicioImpl.actualizarCuenta(cuenta);
                                               
                        Empleado empleado = empleadoServicioImpl.mostrarEmpleado(medico.getIdEmpleado());
                        empleado.setNoEmpleado(noEmpleado);
                        boolean empleadoBoolean = empleadoServicioImpl.actualizarEmpleado(empleado);
                                                                        
                        
                        if(medicoEspecialidadBoolean && personaBoolean && cuentaBoolean && empleadoBoolean)
                        {
                            out.print("1");
                        }
                        else
                        {
                            out.print("0");
                        }                        
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
