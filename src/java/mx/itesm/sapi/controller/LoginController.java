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
import java.util.Base64;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mx.itesm.sapi.bean.gestionPaciente.Paciente;
import mx.itesm.sapi.bean.gestionPaciente.SolicitudPreconsulta;
import mx.itesm.sapi.bean.moduloGestionMedico.Empleado;
import mx.itesm.sapi.bean.moduloGestionMedico.Especialidad;
import mx.itesm.sapi.bean.moduloGestionMedico.MedicoEspecialidad;
import mx.itesm.sapi.bean.persona.Cuenta;
import mx.itesm.sapi.bean.persona.Persona;
import mx.itesm.sapi.bean.persona.Pic;
import mx.itesm.sapi.service.LoginServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.CitaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.EstadoPacientePacienteServiceImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.SolicitudPreconsultaServicioImpl;
import mx.itesm.sapi.service.moduloGestionMedico.EmpleadoServicioImpl;
import mx.itesm.sapi.service.moduloGestionMedico.EspecialidadServicioImpl;
import mx.itesm.sapi.service.moduloGestionMedico.MedicoEspecialidadServicioImpl;
import mx.itesm.sapi.service.persona.CuentaServicioImpl;
import mx.itesm.sapi.service.persona.PersonaServicioImpl;
import mx.itesm.sapi.service.persona.PicServicioImpl;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author Julio Badillo
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

                System.out.println("Login Controller, case 'verificar' Usuario: ".concat(usuario).concat(" password: ").concat(password));
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

                        System.out.println("controler:".concat(String.valueOf(cuenta.getIdCuenta())));

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
                        int rolCuenta = cuenta.getIdRol();
                        String usuarioCuenta = cuenta.getUsuario();

                        /*Escribir los valores de sesion*/
                        //(idCuenta, nombre, rol, status)
                        sesion.setAttribute("idCuenta", idCuenta);
                        sesion.setAttribute("idRol", rolCuenta);
                        sesion.setAttribute("usuario", usuarioCuenta);

                        PersonaServicioImpl personaServicioImpl = new PersonaServicioImpl();
                        Persona persona = personaServicioImpl.mostrarPersona(cuenta.getIdPersona());

                        int idPersona = persona.getIdPersona();
                        String nombre = persona.getNombre(),
                                primerApellido = persona.getPrimerApellido(),
                                segundoApellido = persona.getSegundoApellido();

                        System.out.println("Values ".concat(" " + nombre).concat(" " + primerApellido).concat(" " + segundoApellido));

                        sesion.setAttribute("idSesion", sesion.getId());
                        sesion.setAttribute("idPersona", idPersona);
                        sesion.setAttribute("nombre", nombre);
                        sesion.setAttribute("primerApellido", primerApellido);
                        sesion.setAttribute("segundoApellido", segundoApellido);

                        PicServicioImpl picServicioImpl = new PicServicioImpl();
                        Pic pic = picServicioImpl.mostrarPic(idPersona);

                        InputStream imagen = pic.getContenido();
                        byte[] bytes = IOUtils.toByteArray(imagen);
                        String base64String = Base64.getEncoder().encodeToString(bytes);

                        sesion.setAttribute("base64Img", base64String);

                        //sesion.setAttribute("imagen", persona.getImagen());
                        System.out.println("Rol cuenta:".concat(String.valueOf(rolCuenta)).concat(" ").concat(String.valueOf(cuenta.getIdRol())));

                        //EL SWITCH REDIRIGE SEGÚN EL ROL DE LA CUENTA
                        switch (rolCuenta) {
                            /* CASE 1 PARA PACIENTE POTENCIAL*/
                            case 1: {

                                PacienteServicioImpl pacienteServicioImpl = new PacienteServicioImpl();
                                Paciente paciente = pacienteServicioImpl.mostrarPacientePotencial(idCuenta);
                                sesion.setAttribute("idPaciente", paciente.getIdPaciente());
                                //Redirigir al paciente potencial a su dashboard correspondiente                               

                                request.setAttribute("nombre", sesion.getAttribute("nombre"));
                                request.setAttribute("primerApellido", sesion.getAttribute("primerApellido"));
                                request.setAttribute("segundoApellido", sesion.getAttribute("segundoApellido"));

                                String keyRuta = "potencial/index.jsp";

                                //Si la contraseña no tiene el token de recuperar contraseña se continua al dashboard correspondiente                                                                 
                                try {
                                    System.out.println("Contraseña con token ".concat(cuenta.getToken()));
                                    keyRuta = "recuperar.jsp";
                                } catch (Exception ex) {

                                }

                                sesion.setAttribute("path", keyRuta);

                                String rol = "potencial";
                                //request.setAttribute("rol", rol);

                                response.setContentType("application/json");//Por default se envia un text/html, pero enviaremos un application/json para que se interprete en el ajax del front.

                                int idPacientePotencial = (int) sesion.getAttribute("idPaciente");

                                //Solicitud Documentos Preconsulta
                                SolicitudPreconsulta solicitudPreconsulta;
                                SolicitudPreconsultaServicioImpl solicitudPreconsultaServicioImpl = new SolicitudPreconsultaServicioImpl();
                                solicitudPreconsulta = solicitudPreconsultaServicioImpl.mostrarSolicitudPreconsulta(idPacientePotencial);

                                if (solicitudPreconsulta.getIdentificacion() != null) {
                                    sesion.setAttribute("identificacionOficial", 1);
                                } else {
                                    sesion.setAttribute("identificacionOficial", 0);
                                }
                                if (solicitudPreconsulta.getCurp() != null) {
                                    sesion.setAttribute("curp", 1);
                                } else {
                                    sesion.setAttribute("curp", 0);
                                }
                                if (solicitudPreconsulta.getComprobante() != null) {
                                    sesion.setAttribute("comprobante", 1);
                                } else {
                                    sesion.setAttribute("comprobante", 0);
                                }
                                if (solicitudPreconsulta.getMastografia() != null) {
                                    sesion.setAttribute("resultadoMastografia", 1);
                                } else {
                                    sesion.setAttribute("resultadoMastografia", 0);
                                }
                                if (solicitudPreconsulta.getUltrasonido() != null) {
                                    sesion.setAttribute("resultadoUltrasonido", 1);
                                } else {
                                    sesion.setAttribute("resultadoUltrasonido", 0);
                                }
                                if (solicitudPreconsulta.getBiopsiaPrevia() != null) {
                                    sesion.setAttribute("biopsiaPrevia", 1);
                                } else {
                                    sesion.setAttribute("biopsiaPrevia", 0);
                                }

                                System.out.println("identificacionOficial: " + solicitudPreconsulta.getIdentificacion());
                                System.out.println("curp: " + solicitudPreconsulta.getCurp());
                                System.out.println("comprobante: " + solicitudPreconsulta.getComprobante());
                                System.out.println("resultadoMastografia: " + solicitudPreconsulta.getMastografia());
                                System.out.println("resultadosUltrasonidos: " + solicitudPreconsulta.getUltrasonido());
                                System.out.println("biopsiaPrevia: " + solicitudPreconsulta.getBiopsiaPrevia());

                                Gson json = new Gson();
                                System.out.println("Res Id ".concat(String.valueOf(idPacientePotencial)).concat(json.toJson(solicitudPreconsulta)));

                                PrintWriter out = response.getWriter();

                                out.print(json.toJson(json.toJson(solicitudPreconsulta)));
                                //Fin De Solicitud Documentos Preconsulta

                                //Solicitud Estado Preconsulta
                                CitaServicioImpl citaServicioImpl = new CitaServicioImpl();
                                String estatus = citaServicioImpl.mostrarPreconsultaAceptada(idPacientePotencial);

                                if (estatus == null) {
                                    System.out.println("El paciente no tiene ninguna cita");
                                    sesion.setAttribute("estatus", 0);
                                } else {
                                    System.out.println("El estatus es: " + estatus);

                                    if (estatus.equals("Aprobada")) {
                                        sesion.setAttribute("estatus", 1);
                                        sesion.setAttribute("envioEditable", 1);
                                    }
                                    if (estatus.equals("Cancelada")) {
                                        sesion.setAttribute("estatus", 2);
                                    }
                                    if (estatus.equals("Pendiente")) {
                                        sesion.setAttribute("envioEditable", 1);
                                    }
                                }
                                //Fin DeSolicitud Estado Preconsulta

                                //Solicitud Estado Paciente
                                EstadoPacientePacienteServiceImpl estadoPaPa = new EstadoPacientePacienteServiceImpl();
                                int estadoPaciente = estadoPaPa.estadoPrimeraSegundaVez(idPacientePotencial);
                                System.out.println("EstadoPaciente: " + estadoPaciente);
                                sesion.setAttribute("estadoPaciente", estadoPaciente);
                                //Fin DeSolicitud Estado Paciente

                                request.getRequestDispatcher("/WEB-INF/".concat(sesion.getAttribute("path").toString())).forward(request, response);
                                //request.getRequestDispatcher("/FrontController").forward(request, response);                                                                             

                                System.out.println("Se redirige el potencial. idPaciente " + String.valueOf(paciente.getIdPaciente()).concat(" idCuenta ").concat(String.valueOf(paciente.getIdCuenta())).concat(" Sesión idCuenta ").concat(String.valueOf(sesion.getAttribute("idCuenta"))));

                                break;
                            }
                            case 2: {

                                break;
                            }
                            case 3: {
                                break;
                            }
                            case 4: {
                                // CASE Para Navegadora
                                System.out.println("Cuenta de NAVEGADORA:  ".concat(sesion.getAttribute("nombre").toString()));

                                request.setAttribute("nombre", sesion.getAttribute("nombre"));
                                request.setAttribute("primerApellido", sesion.getAttribute("primerApellido"));
                                request.setAttribute("segundoApellido", sesion.getAttribute("segundoApellido"));

                                String keyRuta = "navegadora/cuentaNavegadora.jsp";

                                //Si la contraseña no tiene el token de recuperar contraseña se continua al dashboard correspondiente                                                                 
                                try {
                                    System.out.println("Contraseña con token ".concat(cuenta.getToken()));
                                    keyRuta = "recuperar.jsp";
                                } catch (Exception ex) {

                                }

                                sesion.setAttribute("path", keyRuta);

                                /*Insert your code here*/
                                PersonaServicioImpl personaServiceImpl = new PersonaServicioImpl();

                                EmpleadoServicioImpl empleadoServicioImpl = new EmpleadoServicioImpl();
                                Empleado empleado = empleadoServicioImpl.mostrarEmpleadoCuenta((int) sesion.getAttribute("idCuenta"));

                                MedicoEspecialidadServicioImpl medicoEspecialidadServicioImpl = new MedicoEspecialidadServicioImpl();
                                MedicoEspecialidad medicoEspecialidad = medicoEspecialidadServicioImpl.mostrarMedicoEspecialidadEmpleado(empleado.getIdEmpleado());

                                EspecialidadServicioImpl especialidadServicioImpl = new EspecialidadServicioImpl();
                                Especialidad especialidad = especialidadServicioImpl.mostrarEspecialidad(medicoEspecialidad.getIdEspecialidad());

                                sesion.setAttribute("nombre", persona.getNombre());
                                sesion.setAttribute("primerApellido", persona.getPrimerApellido());
                                sesion.setAttribute("segundoApellido", persona.getSegundoApellido());
                                sesion.setAttribute("correo", persona.getCorreo());
                                sesion.setAttribute("telefono", persona.getTelefono());
                                sesion.setAttribute("usuario", cuenta.getUsuario());
                                sesion.setAttribute("noEmpleado", empleado.getNoEmpleado());
                                sesion.setAttribute("especialidad", especialidad.getNombre());
                                sesion.setAttribute("cedulaProfesional", medicoEspecialidad.getCedulaProfesional());

                                /*Insert your code here*/
                                request.getRequestDispatcher("/WEB-INF/".concat(sesion.getAttribute("path").toString())).forward(request, response);
                                break;
                            }
                            case 5: {

                                System.out.println("Cuenta de paciente en tratamiento:  ".concat(sesion.getAttribute("nombre").toString()));

                                PacienteServicioImpl pacienteServicioImpl = new PacienteServicioImpl();
                                Paciente paciente = pacienteServicioImpl.mostrarPacientePotencial(idCuenta);
                                //Agregar el idPaciente a la sesión
                                String idPacienteStr = String.valueOf(paciente.getIdPaciente());

                                sesion.setAttribute("idPaciente", idPacienteStr);

                                //Redirigir al paciente potencial a su dashboard correspondiente                               
                                System.out.println("idPaciente ".concat(idPacienteStr));

                                request.setAttribute("idPaciente", sesion.getAttribute("idPaciente"));
                                request.setAttribute("prz", sesion.getAttribute(paciente.getPrz()));
                                request.setAttribute("nombre", sesion.getAttribute("nombre"));
                                request.setAttribute("primerApellido", sesion.getAttribute("primerApellido"));
                                request.setAttribute("segundoApellido", sesion.getAttribute("segundoApellido"));

                                String keyRuta = "paciente/index.jsp";

                                //Si la contraseña no tiene el token de recuperar contraseña se continua al dashboard correspondiente                                                                 
                                try {
                                    System.out.println("Contraseña con token ".concat(cuenta.getToken()));
                                    keyRuta = "recuperar.jsp";
                                } catch (Exception ex) {

                                }

                                sesion.setAttribute("path", keyRuta);

                                PersonaServicioImpl personaServicio = new PersonaServicioImpl();
                                List<Persona> medicos = personaServicio.mostrarMedicos();

                                request.setAttribute("listaMedicos", medicos);

                                request.getRequestDispatcher("/WEB-INF/".concat(sesion.getAttribute("path").toString())).forward(request, response);

                                System.out.println("Se redirige el potencial. idPaciente " + String.valueOf(paciente.getIdPaciente()).concat(" idCuenta ").concat(String.valueOf(paciente.getIdCuenta())).concat(" Sesión idCuenta ").concat(String.valueOf(sesion.getAttribute("idCuenta"))));

                                break;
                            }
                        }

                        //PrintWriter out = response.getWriter();
                        //out.print("success");
                    } else {

                        /*request.getRequestDispatcher("/WEB-INF/index.html")
                                .forward(request, response);*/
                        //request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
                        PrintWriter out = response.getWriter();
                        out.print("LoginError");

                    }

                }

                break;

            }

            case "ir-a-login": {
                request.setAttribute("status", "");
                request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);

                break;

            }

            case "cerrar-sesion": {

                HttpSession sesion = request.getSession(true);

                sesion.invalidate();
                //System.out.println("Salir de la cuenta ".concat(sesion.getAttribute("nombre").toString()));
                System.out.println("Salimos :)");

                request.setAttribute("status", "");
                request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);

                break;

            }

            case "recuperarContra": {

                request.getRequestDispatcher("/WEB-INF/recuperarContrasena.jsp").forward(request, response);

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
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response
    )
            throws ServletException,
            IOException {
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
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response
    )
            throws ServletException,
            IOException {
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
