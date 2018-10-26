/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.itesm.sapi.bean.gestionPaciente.EstadoPacientePaciente;
import mx.itesm.sapi.bean.moduloGestionPaciente.Paciente;
import mx.itesm.sapi.bean.persona.Cuenta;
import mx.itesm.sapi.bean.persona.Direccion;
import mx.itesm.sapi.bean.persona.Persona;

import mx.itesm.sapi.service.gestionPaciente.EstadoPacientePacienteServiceImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteServiceImpl;
import mx.itesm.sapi.service.persona.CuentaServicioImpl;
import mx.itesm.sapi.service.persona.DireccionServicioImpl;
import mx.itesm.sapi.service.persona.PersonaServicioImpl;

import mx.itesm.sapi.bean.persona.Pic;
import mx.itesm.sapi.service.persona.CuentaServicioImpl;
import mx.itesm.sapi.service.persona.DireccionServicioImpl;
import mx.itesm.sapi.service.persona.PersonaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.EstadoPacientePacienteServiceImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteServiceImpl;
import mx.itesm.sapi.service.persona.PicServicioImpl;


/**
 *
 * @author Admin
 */
@WebServlet(name = "RegistraUsuarioController", urlPatterns = {"/RegistraUsuarioController"})
public class RegistraUsuarioController extends HttpServlet {

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

        PrintWriter out = response.getWriter();

        //switch con 2 keys
        // 1 key: verificarUsuario
        //2 key: reistroCompleto
        String key = request.getParameter("key");


        //Servicios
        PersonaServicioImpl _registroServicio = new PersonaServicioImpl();
        CuentaServicioImpl _rSC = new CuentaServicioImpl();
        DireccionServicioImpl _rSD = new DireccionServicioImpl();
        PacienteServiceImpl pacienteServicio = new PacienteServiceImpl();
        EstadoPacientePacienteServiceImpl estadoPaPaServicio = new EstadoPacientePacienteServiceImpl();

        //Verifica existencia de usuario
        Persona per = new Persona();
        Cuenta cuenta = new Cuenta();
        Direccion dir = new Direccion();
        Paciente pac = new Paciente();
        EstadoPacientePaciente estadoPaPa = new EstadoPacientePaciente();

        //Set persona
        switch (key) {

            case "repiteCurp": {

                String curp = request.getParameter("curp");
                System.out.println("El curp es: ".concat(curp));

                //Checo si el usuario existe
                if (_registroServicio.existsCurp(curp)) {
                    System.out.println("El CURP EXISTE");
                    out.print("CurpAlreadyExists");

                } else {

                    //Si no existe, lo inserto
                    System.out.println("El CURP NO Existe");
                    out.print("CurpDoesntExist");

                }

            }
            break;

            case "repiteUsuario": {
                String usuario = request.getParameter("usuario");

                //Checo si el usuario existe
                if (_rSC.existsUsuario(usuario)) {

                    out.print("UsuarioAlreadyExists");

                } else {

                    //Si no existe, lo inserto
                    out.print("UsuarioDoesntExist");

                }
            }
            break;

            case "registraUsuario": {

                String nombre = request.getParameter("nombre");
                String apellido1 = request.getParameter("apellido1");
                String apellido2 = request.getParameter("apellido2");
                String telefono = request.getParameter("telefono");
                String curp = request.getParameter("curp");
                String correo = request.getParameter("correo");
                int estadoCivil = Integer.parseInt(request.getParameter("estadoCivil"));
                int municipio = Integer.parseInt(request.getParameter("municipio"));
                int estado = Integer.parseInt(request.getParameter("estado"));
                String colonia = request.getParameter("colonia");
                String calle = request.getParameter("calle");
                String noExterior = request.getParameter("noExterior");
                String noInterior = request.getParameter("noInterior");
                String contraseña1 = request.getParameter("pass1");
                String contraseña2 = request.getParameter("pass2");
                String fechaNacimiento = request.getParameter("fechaNacimiento");

                Date fn = Date.valueOf(fechaNacimiento);

                per.setFechaNacimiento(fn);

                String usuario = request.getParameter("usuario");

                per.setNombre(nombre);
                per.setTelefono(telefono);

                per.setPrimerApellido(apellido1);
                per.setSegundoApellido(apellido2);
                per.setCorreo(correo);
                per.setCurp(curp);
                per.setIdEstadoCivil(estadoCivil);
                per.setIdMunicipio(municipio);
                      
                long unixTimestamp = Instant.now().getEpochSecond();
                System.out.println(String.valueOf(unixTimestamp));

                //Set cuenta
                cuenta.setPassword(contraseña1);
                cuenta.setUsuario(usuario);
                cuenta.setToken(key);

                //DIRECCION
                dir.setCalle(calle);
                dir.setColonia(colonia);
                dir.setNoExterior(noExterior);
                dir.setNoInterior(noInterior);

                int idD = _rSD.agregarDireccion(dir);

                System.out.println("El id de direccion es: ".concat(Integer.toString(idD)));
                int idC;
                int idPac;
                int idEsPaPa;

                if (idD > 0) {

                    per.setIdDireccion(idD);
                    int idP = _registroServicio.agregarPersona(per);
                    System.out.println("idPersona: " + idP);
                    
                    if (idP > 0) {
                        cuenta.setIdPersona(idP);
                        idC = _rSC.agregarCuenta(cuenta);
                        System.out.println("idCuenta: " + idC);
                                
                        if (idC > 0) {

                            idPac = pacienteServicio.agregarPacienteRegistro(idC);

                            idEsPaPa = estadoPaPaServicio.agregarEstadoPacientePacienteRegistro(idPac);
                            System.out.println("idPac: " + idPac);
                            System.out.println("idEsPaPa " + idEsPaPa);
                            if (idEsPaPa > 0) {

                            }

                        }
                        System.out.println("va a agregar imagen");
                        PicServicioImpl picServiceImpl = new PicServicioImpl();
                        Pic pic = new Pic();

                        pic = picServiceImpl.mostrarPicDefault();
                        pic.setIdPersona(idP);

                        picServiceImpl.agregarPic(pic);
                        System.out.println("agrego imagen");
                    }

                }

            }

            break;

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
