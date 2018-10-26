/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import mx.itesm.sapi.bean.calendario.FullCalendar;
import mx.itesm.sapi.bean.diagnostico.EtapaClinica;
import mx.itesm.sapi.bean.diagnostico.RegistroDiagnostico;
import mx.itesm.sapi.bean.gestionPaciente.Paciente;
import mx.itesm.sapi.bean.gestionTratamiento.TipoTratamiento;
import mx.itesm.sapi.bean.gestionTratamiento.Tratamiento;
import mx.itesm.sapi.bean.gestionTratamiento.TratamientoPaciente;
import mx.itesm.sapi.bean.persona.Cuenta;
import mx.itesm.sapi.bean.persona.Persona;
import mx.itesm.sapi.bean.persona.Pic;
import mx.itesm.sapi.service.CalendarioServicioImpl;
import mx.itesm.sapi.service.diagnostico.EtapaClinicaServiceImpl;
import mx.itesm.sapi.service.diagnostico.RegistroDiagnosticoServiceImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteServicioImpl;
import mx.itesm.sapi.service.gestionTratamiento.TipoTratamientoServiceImpl;
import mx.itesm.sapi.service.gestionTratamiento.TratamientoPacienteServiceImpl;
import mx.itesm.sapi.service.gestionTratamiento.TratamientoServiceImpl;
import mx.itesm.sapi.service.persona.CuentaServicioImpl;
import mx.itesm.sapi.service.persona.PersonaServicioImpl;
import mx.itesm.sapi.service.persona.PicServicioImpl;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author julioguzman
 *
 *
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50)

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

        response.setContentType("text/html;charset=UTF-8");
        String key = request.getParameter("key");
        String idPaciente = request.getParameter("idPaciente");

        PrintWriter out = response.getWriter();

        System.out.println("la key esssss");
        System.out.println(key);

        HttpSession sesion = request.getSession(true); //Veo si tiene sesion iniciada
        if (sesion.getAttribute("idCuenta") == null) { //no tiene sesion iniciada
            // request.setAttribute("status", "");
            request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response); //Lo redirecciono al login
            System.out.println("estoy en el if");
            return;
        } else {
            //Si tiene sesion iniciada
            int keyRol = (int) sesion.getAttribute("idRol");
            switch (keyRol) {
                case 5: {
                    System.out.println("estoy en el case 5");
                    switch (key) {

                        case "obtenerEventos":

                            System.out.println("El id paciente es:" + idPaciente);

                            //Servicio
                            CalendarioServicioImpl csi = new CalendarioServicioImpl();

                            //Lista Calendarios
                            List<FullCalendar> calendarios = csi.mostrarEventos(Integer.parseInt(idPaciente));

                            response.setContentType("application/json");
                            response.setCharacterEncoding("UTF-8");

                            out.print(new Gson().toJson(calendarios));

                            break;

                        case "agregarEvento":

                            out.print("hola");

                            break;

                        case "cambiarDatos": {

                            String correo = request.getParameter("correo");
                            String noExpediente = request.getParameter("noExpediente");
                            String telefono = request.getParameter("telefono");
                            String etapaClinica = request.getParameter("etapaClinica");
                            int tipoSangre = Integer.parseInt(request.getParameter("tipoSangre"));

                            Part part = request.getPart("file-image");

                            //No se valida el telefono ni el correo aquí? Lo validamos nosotros o el front?
                            PersonaServicioImpl personaServicioImpl = new PersonaServicioImpl();
                            Persona persona = personaServicioImpl.mostrarPersona((int) sesion.getAttribute("idPersona"));

                            PacienteServicioImpl pacienteServicioImpl = new PacienteServicioImpl();
                            Paciente paciente = pacienteServicioImpl.mostrarPacientePotencial((int) sesion.getAttribute("idCuenta"));

                            if ((int) part.getSize() > 0) {
                                PicServicioImpl picServiceImpl = new PicServicioImpl();
                                Pic pic = new Pic();

                                pic.setIdPersona((int) sesion.getAttribute("idPersona"));
                                pic.setContenido(part.getInputStream());
                                pic.setTamano((int) part.getSize());
                                pic.setTipo(part.getContentType());

                                picServiceImpl.agregarPic(pic);

                                InputStream imagen = pic.getContenido();
                                byte[] bytes = IOUtils.toByteArray(imagen);
                                String base64String = Base64.getEncoder().encodeToString(bytes);

                                sesion.setAttribute("base64Img", base64String);
                                System.out.println("Debió actualizar la imagen en la sesión");
                            }

                            int idPaciente2 = pacienteServicioImpl.mostrarPacientePotencial((int) sesion.getAttribute("idCuenta")).getIdPaciente();

                            RegistroDiagnosticoServiceImpl registroDiagnosticoServicioImpl = new RegistroDiagnosticoServiceImpl();
                            System.out.println("El idPaciente despues de registro: " + idPaciente2);
                            RegistroDiagnostico registroDiagnostico = registroDiagnosticoServicioImpl.mostrarRegistroDiagnosticoPaciente(idPaciente2);

                            System.out.println("Ya pase registro");

                            persona.setCorreo(correo);
                            persona.setTelefono(telefono);
                            persona.setIdTipoSangre(tipoSangre);

                            System.out.println("lo que tengo es:");
                            System.out.println(persona.getCorreo());
                            System.out.println(persona.getTelefono());

                            System.out.println("la etapa es" + etapaClinica);
                            registroDiagnostico.setIdEtapaClinica(Integer.parseInt(etapaClinica));
                            paciente.setExpediente(noExpediente);

                            personaServicioImpl.actualizarPersona(persona);
                            pacienteServicioImpl.actualizarPaciente(paciente);

                            if (registroDiagnosticoServicioImpl.actualizarRegistroDiagnostico(registroDiagnostico)) {
                                System.out.println("Si se actualiza");
                            } else {
                                System.out.println("No se hizo compa");
                            }

                            sesion.setAttribute("correo", persona.getCorreo());
                            sesion.setAttribute("telefono", persona.getTelefono());

                            request.setAttribute("correo", sesion.getAttribute("correo"));
                            request.setAttribute("telefono", sesion.getAttribute("telefono"));

                            request.getRequestDispatcher("/WEB-INF/potencial/cuentaPaciente.jsp").forward(request, response);

                        }

                        break;

                        case "cambiarContrasena": {

                            if (sesion.getAttribute("idCuenta") == null) { //no tiene sesion iniciada
                                // request.setAttribute("status", "");
                                request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response); //Lo redirecciono al login
                                return;
                            } else {
                                int idCuenta = (int) sesion.getAttribute("idCuenta");
                                String contrasena = request.getParameter("password");
                                String contrasena2 = request.getParameter("password2");

                                if (contrasena.equals(contrasena2)) {

                                    CuentaServicioImpl cuentaServicio = new CuentaServicioImpl();

                                    Cuenta cuenta = cuentaServicio.mostrarCuenta(idCuenta);

                                    cuenta.setPassword(contrasena);

                                    cuentaServicio.actualizarCuenta(cuenta);
                                }

                            }
                        }
                        break;

                        case "agregarTratamiento": {

                            System.out.println("entro a la key Agregar tratamiento");
                            if (sesion.getAttribute("idCuenta") == null) { //no tiene sesion iniciada
                                // request.setAttribute("status", "");
                                request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response); //Lo redirecciono al login
                                return;
                            } else {
                                
                                
                                int idTipoTratamiento = Integer.parseInt(request.getParameter("idTipoTratamiento"));
                                Date fechaInicio = Date.valueOf(request.getParameter("fechaInicio"));
                                int idPaciente2 = (int) sesion.getAttribute("idPaciente");

                                TratamientoPacienteServiceImpl tratamientoPacienteServiceImpl = new TratamientoPacienteServiceImpl();
                                TratamientoPaciente tratamientoPaciente = new TratamientoPaciente();

                                tratamientoPaciente.setIdTipoTratamiento(idTipoTratamiento);
                                tratamientoPaciente.setFechaInicio(fechaInicio);
                                tratamientoPaciente.setIdPaciente(idPaciente2);

                                tratamientoPacienteServiceImpl.agregarTratamientoPaciente(tratamientoPaciente);

                            }

                        }
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
