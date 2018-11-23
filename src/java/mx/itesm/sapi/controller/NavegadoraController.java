/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import java.util.List;

//import java.util.Date;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import mx.itesm.sapi.autocomplete.AutocompletadoServicioImpl;
import mx.itesm.sapi.bean.diagnostico.EstadiajeTNM;
import mx.itesm.sapi.bean.gestionPaciente.Biopsia;
import mx.itesm.sapi.bean.gestionPaciente.BloqueParafina;
import mx.itesm.sapi.bean.gestionPaciente.CategoriaEstudio;
import mx.itesm.sapi.bean.gestionPaciente.PacienteNavegadora;
import mx.itesm.sapi.bean.gestionPaciente.PacienteNecesidadEspecial;
import mx.itesm.sapi.bean.gestionPaciente.TipoDocumento;
import mx.itesm.sapi.bean.gestionPaciente.Cita;
import mx.itesm.sapi.bean.gestionPaciente.CitaEmpleado;
import mx.itesm.sapi.bean.gestionPaciente.ComentarioCita;
import mx.itesm.sapi.bean.gestionPaciente.DocumentoEstudio;
import mx.itesm.sapi.bean.gestionPaciente.DocumentoInicial;
import mx.itesm.sapi.bean.gestionPaciente.EstadoPacientePaciente;
import mx.itesm.sapi.bean.gestionPaciente.Estudio;
import mx.itesm.sapi.bean.gestionPaciente.Laminilla;

import mx.itesm.sapi.bean.gestionPaciente.LlamadaCita;
import mx.itesm.sapi.bean.gestionPaciente.OtroResultadoPatologia;

import mx.itesm.sapi.bean.gestionPaciente.Paciente;
import mx.itesm.sapi.bean.gestionPaciente.PacienteAlergia;
import mx.itesm.sapi.bean.gestionPaciente.PacienteMedicoTitular;
import mx.itesm.sapi.bean.gestionPaciente.PacienteSeguro;
import mx.itesm.sapi.bean.gestionPaciente.ProgramaPaciente;
import mx.itesm.sapi.bean.gestionTratamiento.PacienteTratamientoPrevio;
import mx.itesm.sapi.bean.moduloGestionMedico.Empleado;

import mx.itesm.sapi.bean.persona.Cuenta;
import mx.itesm.sapi.bean.persona.Direccion;
import mx.itesm.sapi.bean.persona.InformacionGeneralPersona;
import mx.itesm.sapi.bean.persona.Login;
import mx.itesm.sapi.bean.persona.Persona;
import mx.itesm.sapi.bean.persona.Pic;
import mx.itesm.sapi.service.diagnostico.EstadiajeTNMServiceImpl;
import mx.itesm.sapi.service.gestionPaciente.BiopsiaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.BloqueParafinaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.CategoriaEstudioServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteNavegadoraServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteNecesidadEspecialServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteServiceImpl;

import mx.itesm.sapi.service.gestionPaciente.CitaEmpleadoServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.CitaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.ComentarioCitaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.DocumentoEstudioServicioImpl;

import mx.itesm.sapi.service.gestionPaciente.DocumentoInicialServicioImpl;

import mx.itesm.sapi.service.gestionPaciente.EstadoPacientePacienteServiceImpl;
import mx.itesm.sapi.service.gestionPaciente.EstudioServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.LaminillaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.LlamadaCitaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.OtroResultadoPatologiaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteAlergiaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteMedicoTitularServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteSeguroServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.ProgramaPacienteServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.TipoDocumentoServicioImpl;
import mx.itesm.sapi.service.gestionTratamiento.PacienteTratamientoPrevioServiceImpl;
import mx.itesm.sapi.service.moduloGestionMedico.EmpleadoServicioImpl;

import mx.itesm.sapi.service.persona.CuentaServicioImpl;
import mx.itesm.sapi.service.persona.DireccionServicioImpl;
import mx.itesm.sapi.service.persona.LoginServicioImpl;
import mx.itesm.sapi.service.persona.PersonaServicioImpl;
import mx.itesm.sapi.service.persona.PicServicioImpl;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author Admin
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50)

@WebServlet(name = "NavegadoraController", urlPatterns = {"/NavegadoraController"})
public class NavegadoraController extends HttpServlet {

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

        response.setContentType("text/html;charset=UTF-8");
        String key = request.getParameter("key");

        HttpSession sesion = request.getSession(true);

        //COMENTARIO PARA COMMIT: TEAM LUGO ORDUÑA <3
        if (sesion.getAttribute("idCuenta") == null) { //no tiene sesion iniciada
            // request.setAttribute("status", "");
            request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response); //Lo redirecciono al login
            System.out.println("estoy en el if");
            return;
        } else {

            int keyRol = (int) sesion.getAttribute("idRol");

            switch (keyRol) {

                case 4: {

                    switch (key) {

                        case "cambiarDatos": {

                            String correo = request.getParameter("correo");
                            String telefono = request.getParameter("telefono");

                            Part part = request.getPart("file-image");

                            //No se valida el telefono ni el correo aquí? Lo validamos nosotros o el front?
                            PersonaServicioImpl personaServicioImpl = new PersonaServicioImpl();
                            Persona persona = personaServicioImpl.mostrarPersona((int) sesion.getAttribute("idPersona"));

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

                            System.out.println("Ya pase registro");

                            persona.setCorreo(correo);
                            persona.setTelefono(telefono);

                            personaServicioImpl.actualizarPersona(persona);

                            sesion.setAttribute("correo", persona.getCorreo());
                            sesion.setAttribute("telefono", persona.getTelefono());

                            request.setAttribute("correo", sesion.getAttribute("correo"));
                            request.setAttribute("telefono", sesion.getAttribute("telefono"));

                            request.getRequestDispatcher("/WEB-INF/potencial/cuentaPaciente.jsp").forward(request, response);

                            break;
                        }

                        case "eliminarCuentaNavegadora": {
                            System.out.println("Si llego aqui navegadora");

                            /**
                             * Veo si tiene sesion iniciada
                             */
                            if (sesion.getAttribute("idCuenta") == null) { //no tiene sesion iniciada
                                // request.setAttribute("status", "");
                                request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
                                /**
                                 * Lo redirecciono al login
                                 */
                                return;
                            } else {
                                /**
                                 * Elimino su cuenta (borrrado logico)
                                 */
                                /**
                                 * Obtengo los id's de sue cuenta y llogin de la
                                 * sesion
                                 */
                                int idCuenta = (int) sesion.getAttribute("idCuenta");
                                System.out.println(idCuenta);

                                CuentaServicioImpl cuentaServicio = new CuentaServicioImpl();

                                LoginServicioImpl loginServicio = new LoginServicioImpl();
                                if (loginServicio.mostrarLoginIdCuenta(idCuenta) != null) {
                                    Login login = loginServicio.mostrarLoginIdCuenta(idCuenta);
                                    loginServicio.borradoLogicoLogin(login.getIdLogin());
                                }

                                if (cuentaServicio.mostrarCuenta(idCuenta) != null) {
                                    Cuenta cuenta = cuentaServicio.mostrarCuenta(idCuenta);

                                    cuentaServicio.borradoLogicoCuenta(cuenta.getIdCuenta());
                                }

                                /**
                                 * Al no tener cuenta se le redirecciona al
                                 * login
                                 */
                                request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);

                            }
                            break;
                        }

                        case "reporteRendimientoNavegadora": {
                            /**
                             * Author: Angel Gutiérrez Al inicio checa si tiene
                             * sesion de no ser asi se redirecciona al loin.
                             * Despues se tomra el id de la navegadora para
                             * generar una lista de los pacientes que aprobo o
                             * modifico su formulario
                             *
                             */
                            if (sesion.getAttribute("idCuenta") == null) {

                                request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
                                return;
                            } else {
                                int idNavegadora = (int) sesion.getAttribute("idEmpleado");

                            }

                            break;
                        }

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
                                    PrintWriter out = response.getWriter();
                                    out.print("success");
                                }

                            }
                            break;
                        }

                        case "agregar-paciente": {

                            PrintWriter out = response.getWriter();
                            out.print("hola");

                            break;
                        }

                        case "aprobarDocumento": {
                            int idDocumentoInicial = (int) sesion.getAttribute("idDocumentoInicialVista");
                            System.out.println("Aprobar Documento");
                            System.out.println("id Documento ".concat(String.valueOf(idDocumentoInicial)));

                            DocumentoInicialServicioImpl documentoInicialServicioImpl = new DocumentoInicialServicioImpl();
                            boolean aprobado = documentoInicialServicioImpl.agregarAprobacionDocumento(idDocumentoInicial);

                            System.out.println("Se aprobo ".concat(String.valueOf(aprobado)));
                            PrintWriter out = response.getWriter();
                            out.print(aprobado);
                            break;
                        }
                        case "rechazarDocumento": {
                            //FALTA LA CORRECIÓN DE URI

                            int idDocumentoInicial = (int) sesion.getAttribute("idDocumentoInicialVista");
                            String comentario = request.getParameter("comentario");
                            System.out.println("rechazar Documento");
                            System.out.println("id Documento ".concat(String.valueOf(idDocumentoInicial)));
                            System.out.println("motivo rechazo  ".concat(String.valueOf(comentario)));

                            DocumentoInicialServicioImpl documentoInicialServicioImpl = new DocumentoInicialServicioImpl();
                            DocumentoInicial documentoInicial = documentoInicialServicioImpl.mostrarDocumentoInicial(idDocumentoInicial);

                            TipoDocumentoServicioImpl tipoDocumentoServicioImpl = new TipoDocumentoServicioImpl();
                            TipoDocumento tipoDocumento = tipoDocumentoServicioImpl.mostrarTipoDocumento(documentoInicial.getIdTipoDocumento());

                            boolean rechazado = documentoInicialServicioImpl.agregarRechazoDocumento(idDocumentoInicial, comentario);
                            //ESto es para el correo

                            int pacientePotencial = (int) sesion.getAttribute("idPacientePotencialAtendido");
                            PersonaServicioImpl personaServicio = new PersonaServicioImpl();
                            Persona persona = personaServicio.mostrarPersonaPorIdPaciente(pacientePotencial);

                            Properties config = new Properties();
                            String correo = persona.getCorreo();
                            System.out.println("Correo potencial ".concat(correo));
                            try {
                                config.load(getClass().getResourceAsStream("/mail.properties"));
                                Session session = Session.getInstance(config,
                                        new javax.mail.Authenticator() {
                                    protected PasswordAuthentication getPasswordAuthentication() {
                                        return new PasswordAuthentication("sapi.prueba@gmail.com", "prueba.Sapi1");

                                    }
                                });

                                System.out.println("despues del try");
                                Message message = new MimeMessage(session);
                                message.setFrom(new InternetAddress("sapi.prueba@gmail.com"));
                                message.setRecipients(Message.RecipientType.TO,
                                        InternetAddress.parse(correo));
                                message.setSubject("Documento rechazado");
                                //message.setText("Esto no es spam :)");

                                //Estos deberían ir como parametros dentro de la función de enviar correo
                                //String mail = "tucorreo@mail.com";
                                //String contrasena = "tucontrasena";
                                String mensaje = "Estimada(o) ".concat(persona.getNombre()).concat(" el equipo del INCan le informa; él tipo de documento \"")
                                        .concat(tipoDocumento.getNombre()).concat("\" con nombre \"").concat(documentoInicial.getNombre()).concat("\" ha sido rechazado. ")
                                        .concat("A continuación le explicamos los motivos: ").concat(comentario).concat(". <br> Por su atención, <br><br> Muchas gracias.")
                                        .concat("Atte. nombre y domicilios reservados.");
                                MimeBodyPart mimeBodyPart = new MimeBodyPart();
                                mimeBodyPart.setContent(mensaje, "text/html");

                                Multipart multipart = new MimeMultipart();
                                multipart.addBodyPart(mimeBodyPart);

                                Path path = Files.createTempFile(null, ".properties");
                                File file = new File(path.toString());

                                OutputStream outputStream = new FileOutputStream(file);
                                IOUtils.copy(getClass().getResourceAsStream("/mail.properties"), outputStream);
                                outputStream.close();

                                //Comente este attach fail porque de lo contrario no se hace bien el set content de arriba (lo de los datos de usuario)
                                // mimeBodyPart.attachFile(file);
                                message.setContent(multipart);
                                Transport.send(message);

                                //request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
                                System.out.println("Fin del try enviar correo");

                            } catch (Exception ex) {
                                System.out.println("catch de envia correo");
                                System.out.println(this.getClass().toString().concat(ex.getMessage()));
                            }

                            break;
                        }

                        case "descargarArchivo": {

                            int idDocumento = Integer.parseInt(request.getParameter("idDocumento"));

                            System.out.println("El documento del id es: " + idDocumento);

                            DocumentoInicialServicioImpl documentoInicialServicioImpl = new DocumentoInicialServicioImpl();
                            DocumentoInicial documentoInicial = documentoInicialServicioImpl.mostrarDocumentoInicial(idDocumento);
                            OutputStream out = response.getOutputStream();

                            if (documentoInicial.getArchivo() == null) {
                                System.out.println("valio madre");
                            } else {
                                System.out.println("si hay algo");
                            }

                            response.setContentType(documentoInicial.getTipo());

                            System.out.println(documentoInicial.getTipo());
                            response.setHeader("Content-Disposition", "attachment;filename=".concat(documentoInicial.getNombre())); //Forzar descarga

                            out.write(IOUtils.toByteArray(documentoInicial.getArchivo()));
                            out.flush();

                            break;

                        }

                        case "aprobar-paciente": {

                            int idPaciente = Integer.parseInt(request.getParameter("idPaciente"));
                            String fechaNav = request.getParameter("fechaNavegacion").concat(" 07:30:00");
                            String fechaCon = request.getParameter("fechaConsulta").concat(" 07:30:00");
                            int segundaOpinion = Integer.parseInt(request.getParameter("tipoPaciente"));

                            System.out.println(idPaciente);
                            System.out.println(fechaNav);
                            System.out.println(fechaCon);
                            System.out.println(segundaOpinion);

                            //Falta obtener los datos, y falta asignarlos en el servicio
                            CitaServicioImpl citaServicio = new CitaServicioImpl();

                            PrintWriter out = response.getWriter();

                            if (citaServicio.aprobarPaciente(idPaciente, fechaNav, fechaCon, segundaOpinion)) {
                                out.print("success");

                            }

                            break;
                        }

                        case "eliminar-paciente": {

                            int idPaciente = Integer.parseInt(request.getParameter("idPaciente"));

                            System.out.println(idPaciente);

                            PacienteServiceImpl pacienteServicio = new PacienteServiceImpl();

                            int idCuenta = pacienteServicio.obtenerCuenta(idPaciente);
                            int idPersona = pacienteServicio.obtenerPersona(idCuenta);

                            System.out.println(idPaciente);
                            System.out.println(idCuenta);
                            System.out.println(idPersona);

                            /**
                             * creo los objetos de las tablas a modificar su
                             * estatus
                             */
                            /**
                             * Se comprueba que los objetos no sean nulos o
                             * vacios para crearlos al crearlos si tienen
                             * dependencia ciclan para buscar todos los datos
                             * que tienen encadenados para proseguir con el
                             * borrado logico en la base de datos
                             */
                            CuentaServicioImpl cuentaServicio = new CuentaServicioImpl();

                            PersonaServicioImpl personaServicio = new PersonaServicioImpl();

                            Persona persona = personaServicio.mostrarPersona(idPersona);
                            personaServicio.borradoLogicoPersona(persona.getIdPersona());

                            if (pacienteServicio.mostrarPaciente(idPaciente) != null) {

                                Paciente paciente = pacienteServicio.mostrarPaciente(idPaciente);
                                pacienteServicio.borradoLogicoPaciente(paciente.getIdCuenta());
                            }

                            LoginServicioImpl loginServicio = new LoginServicioImpl();
                            if (loginServicio.mostrarLoginIdCuenta(idCuenta) != null) {
                                Login login = loginServicio.mostrarLoginIdCuenta(idCuenta);
                                loginServicio.borradoLogicoLogin(login.getIdLogin());
                            }
                            DireccionServicioImpl direccionServicio = new DireccionServicioImpl();
                            if (direccionServicio.mostrarDireccion(persona.getIdDireccion()) != null) {
                                Direccion direccion = direccionServicio.mostrarDireccion(persona.getIdDireccion());
                                direccionServicio.borradoLogicoDireccion(direccion.getIdDireccion());
                            }
                            PicServicioImpl picServicio = new PicServicioImpl();
                            if (picServicio.mostrarPic(idPersona) != null) {
                                Pic pic = picServicio.mostrarPic(idPersona);
                                picServicio.borradoLogicoPic(pic.getIdPic());
                            }
                            EstadoPacientePacienteServiceImpl estadoPacientePacienteServicio = new EstadoPacientePacienteServiceImpl();
                            if (estadoPacientePacienteServicio.mostrarEstadoPacientePacienteIdPaciente(idPaciente) != null) {
                                EstadoPacientePaciente estadoPacientePaciente = estadoPacientePacienteServicio.mostrarEstadoPacientePacienteIdPaciente(idPaciente);
                                estadoPacientePacienteServicio.borradoLogicoEstadoPacientePaciente(estadoPacientePaciente.getIdEstadoPacientePaciente());
                            }

                            CitaServicioImpl citaServicio = new CitaServicioImpl();
                            if (citaServicio.mostrarCitaIdEspecifico(idPaciente) != null) {

                                List<Cita> citas = new ArrayList<>();

                                citas = citaServicio.mostrarCitaIdEspecifico(idPaciente);
                                int citasTotales = citas.size() - 1;

                                int idCita = 0;
                                while (citasTotales > -1) {

                                    System.out.println(citasTotales);
                                    idCita = citas.get(citasTotales).getIdCita();

                                    System.out.println(idCita);

                                    ComentarioCitaServicioImpl comentarioCitaServicio = new ComentarioCitaServicioImpl();
                                    if (comentarioCitaServicio.mostrarComentarioCitaIdCita(idCita) != null) {
                                        ComentarioCita comentarioCita = comentarioCitaServicio.mostrarComentarioCitaIdCita(idCita);
                                        comentarioCitaServicio.borradoLogicoComentarioCita(comentarioCita.getIdComentarioCita());
                                    }

                                    CitaEmpleadoServicioImpl citaEmpleadoServicio = new CitaEmpleadoServicioImpl();
                                    if (citaEmpleadoServicio.mostrarCitaEmpleadoIdCita(idCita) != null) {
                                        CitaEmpleado citaEmpleado = citaEmpleadoServicio.mostrarCitaEmpleadoIdCita(idCita);
                                        citaEmpleadoServicio.borradoLogicoCitaEmpleado(citaEmpleado.getIdCitaEmpleado());
                                    }

                                    LlamadaCitaServicioImpl llamadaCitaServicio = new LlamadaCitaServicioImpl();
                                    if (llamadaCitaServicio.mostrarLlamadaCitaIdCita(idCita) != null) {
                                        LlamadaCita llamadaCita = llamadaCitaServicio.mostrarLlamadaCitaIdCita(idCita);
                                        llamadaCitaServicio.borradoLogicoLlamadaCita(llamadaCita.getIdLlamadaCita());
                                    }

                                    citaServicio.borradoLogicoCita(idCita);

                                    citasTotales = citasTotales - 1;
                                    System.out.println(citasTotales);
                                }
                            }

                            PacienteMedicoTitularServicioImpl pacienteMedicoTitularServicio = new PacienteMedicoTitularServicioImpl();
                            if (pacienteMedicoTitularServicio.mostrarPacienteMedicoTitularIdPaciente(idPaciente) != null) {
                                PacienteMedicoTitular pacienteMedicoTitular = pacienteMedicoTitularServicio.mostrarPacienteMedicoTitularIdPaciente(idPaciente);
                                pacienteMedicoTitularServicio.borradoLogicoPacienteMedicoTitular(pacienteMedicoTitular.getIdPacienteMedicoTitular());
                            }

                            PacienteNavegadoraServicioImpl pacienteNavegadoraServicio = new PacienteNavegadoraServicioImpl();
                            if (pacienteNavegadoraServicio.mostrarPacienteNavegadoraIdPaciente(idPaciente) != null) {
                                PacienteNavegadora pacienteNavegadora = pacienteNavegadoraServicio.mostrarPacienteNavegadoraIdPaciente(idPaciente);
                                pacienteNavegadoraServicio.borradoLogicoPacienteNavegadora(pacienteNavegadora.getIdPacienteNavegadora());

                            }
                            DocumentoInicialServicioImpl documentoInicialServicio = new DocumentoInicialServicioImpl();
                            if (documentoInicialServicio.mostrarDocumentoInicialIdPaciente(idPaciente) != null) {
                                DocumentoInicial documentoInicial = documentoInicialServicio.mostrarDocumentoInicialIdPaciente(idPaciente);
                                documentoInicialServicio.borradoLogicoDocumentoInicial(documentoInicial.getIdDocumentoInicial());

                            }
                            PacienteNecesidadEspecialServicioImpl pacienteNecesidadEspecialServicio = new PacienteNecesidadEspecialServicioImpl();
                            if (pacienteNecesidadEspecialServicio.mostrarPacienteNecesidadEspecialIdPaciente(idPaciente) != null) {
                                PacienteNecesidadEspecial pacienteNecesidadEspecial = pacienteNecesidadEspecialServicio.mostrarPacienteNecesidadEspecialIdPaciente(idPaciente);
                                pacienteNecesidadEspecialServicio.borradoLogicoPacienteNecesidadEspecial(pacienteNecesidadEspecial.getIdNecesidadEspecial());

                            }
                            PacienteAlergiaServicioImpl pacienteAlergiaServicio = new PacienteAlergiaServicioImpl();
                            if (pacienteAlergiaServicio.mostrarPacienteAlergiaIdPaciente(idPaciente) != null) {
                                PacienteAlergia pacienteAlergia = pacienteAlergiaServicio.mostrarPacienteAlergiaIdPaciente(idPaciente);
                                pacienteAlergiaServicio.borradoLogicoPacienteAlergia(pacienteAlergia.getIdPacienteAlergia());
                            }

                            if (cuentaServicio.mostrarCuenta(idCuenta) != null) {
                                Cuenta cuenta = cuentaServicio.mostrarCuenta(idCuenta);

                                cuentaServicio.borradoLogicoCuenta(cuenta.getIdCuenta());
                            }

                            break;

                        }

                        case "obtener-paciente": {

                            int idPaciente = Integer.parseInt(request.getParameter("idPaciente"));

                            PersonaServicioImpl personaServicio = new PersonaServicioImpl();

                            InformacionGeneralPersona datos = personaServicio.mostrarInformacionGeneralPersona(idPaciente);

                            PrintWriter out = response.getWriter();
                            out.print(new Gson().toJson(datos));

                            break;

                        }

                        case "actualizar-paciente": {

                            int idPaciente = Integer.parseInt(request.getParameter("idPaciente"));

                            InformacionGeneralPersona datos = new InformacionGeneralPersona();

                            String nombre = request.getParameter("nombre");
                            String apellido1 = request.getParameter("apellido1");
                            String apellido2 = request.getParameter("apellido2");
                            String curp = request.getParameter("curp");
                            String fechaNacimiento = request.getParameter("fechaNacimiento");
                            String usuario = request.getParameter("usuario");
                            int estadoCivil = Integer.parseInt(request.getParameter("estadoCivil"));
                            String calle = request.getParameter("calle");
                            String noInterior = request.getParameter("noInterior");
                            String noExterior = request.getParameter("noExterior");
                            int estado = Integer.parseInt(request.getParameter("estado"));
                            int municipio = Integer.parseInt(request.getParameter("municipio"));
                            String telefono = request.getParameter("telefono");
                            String correo = request.getParameter("correo");
                            String colonia = request.getParameter("colonia");

                            Date fn = Date.valueOf(fechaNacimiento);

                            datos.setNombre(nombre);
                            datos.setPrimerApellido(apellido1);
                            datos.setSegundoApellido(apellido2);
                            datos.setCurp(curp);
                            datos.setFechaNacimiento(fn);
                            datos.setUsuario(usuario);
                            datos.setIdEstadoCivil(estadoCivil);
                            datos.setCalle(calle);
                            datos.setNoInt(noInterior);
                            datos.setNoExt(noExterior);
                            datos.setIdEstado(estado);
                            datos.setIdMunicipio(municipio);
                            datos.setTelefono(telefono);
                            datos.setCorreo(correo);
                            datos.setColonia(colonia);

                            PersonaServicioImpl personaServicio = new PersonaServicioImpl();
                            personaServicio.actualizarInformacionGeneralPersona(idPaciente, datos);

                            break;

                        }

                        case "btn-save": {
                            // OMAR
                            System.out.println("########### Formulario de la navegadora ###########");
                            /**
                             * DECLARACION DE ATRIBUTOS
                             */
                            int idPacientePotencial = 4;
                            int idCuenta = 19;
                            int idNavegadora = 1;//Navegadora

                            CitaServicioImpl citaServicioImpl = new CitaServicioImpl();
                            Cita cita = new Cita();

                            EstudioServicioImpl estudioServicio = new EstudioServicioImpl();
                            Estudio estudio = new Estudio();

                            CategoriaEstudioServicioImpl categoriaEstudioServicio = new CategoriaEstudioServicioImpl();
                            CategoriaEstudio categoriaEstudio = new CategoriaEstudio();

                            CitaServicioImpl citaServicio = new CitaServicioImpl();

                            //PANTALLA 3
                            JsonParser parser = new JsonParser();

                            cita.setIdPaciente(idPacientePotencial);
                            cita.setIdTipoCita(1); // Estudio
                            cita.setIdEstadoCita(3); // Pendiente
                            cita.setIdImportanciaCita(1); // 1
                            cita.setIdMotivoConsulta(5); // Otro
                            cita.setIdTipoTratamiento(1); // TO DO : Quimioterapia?
                            cita.setIdPiso(1); // TO DO : 

                            //BIOPSIAS                            
                            String biopsias = request.getParameter("biopsias");
                            System.out.println("Biopsias ".concat(biopsias));
                            Object obj = parser.parse(biopsias);
                            JsonArray array = (JsonArray) obj;
                            for (int i = 0; i < array.size(); i++) {
                                JsonObject json = (JsonObject) array.get(i);
                                int id = Integer.parseInt(json.get("id").toString());
                                String accion = json.get("accion").toString();
                                accion = accion.substring(1, accion.length() - 1);
                                String fecha = json.get("fecha").toString();
                                fecha = fecha.substring(1, fecha.length() - 1);
                                String tipo = json.get("tipo").toString();
                                tipo = tipo.substring(1, tipo.length() - 1);
                                switch (accion) {
                                    case "agregar": {
                                        estudio = estudioServicio.mostrarEstudio(tipo);
                                        if(estudio==null){break;}
                                        cita.setIdEstudio(estudio.getIdEstudio());
                                        cita.setFechaProgramada(fechaStringToTimestamp(fecha));
                                        citaServicio.agregarCita(cita);
                                        break;
                                    }
                                    case "actualizar": {
                                        cita.setIdCita(id);
                                        estudio = estudioServicio.mostrarEstudio(tipo);
                                        if(estudio==null){break;}
                                        cita.setIdEstudio(estudio.getIdEstudio());
                                        cita.setFechaProgramada(fechaStringToTimestamp(fecha));
                                        citaServicio.actualizarCita(cita);
                                        break;
                                    }
                                    case "eliminar": {
                                        citaServicio.borradoLogicoCita(id);
                                        break;
                                    }
                                }
                            }

                            //RAYOS X
                            String rayosxs = request.getParameter("rayosxs");
                            System.out.println("rayosxs ".concat(rayosxs));
                            Object objRayosx = parser.parse(rayosxs);
                            JsonArray arrayRayosx = (JsonArray) objRayosx;
                            for (int i = 0; i < arrayRayosx.size(); i++) {
                                JsonObject json = (JsonObject) arrayRayosx.get(i);
                                int id = Integer.parseInt(json.get("id").toString());
                                String accion = json.get("accion").toString();
                                accion = accion.substring(1, accion.length() - 1);
                                String fecha = json.get("fecha").toString();
                                fecha = fecha.substring(1, fecha.length() - 1);
                                String tipo = json.get("tipo").toString();
                                tipo = tipo.substring(1, tipo.length() - 1);
                                switch (accion) {
                                    case "agregar": {
                                        estudio = estudioServicio.mostrarEstudio(tipo);
                                        if(estudio==null){break;}
                                        cita.setIdEstudio(estudio.getIdEstudio());
                                        cita.setFechaProgramada(fechaStringToTimestamp(fecha));
                                        citaServicio.actualizarCita(cita);
                                        break;
                                    }
                                    case "actualizar": {
                                        cita.setIdCita(id);
                                        estudio = estudioServicio.mostrarEstudio(tipo);
                                        if(estudio==null){break;}
                                        cita.setIdEstudio(estudio.getIdEstudio());
                                        cita.setFechaProgramada(fechaStringToTimestamp(fecha));
                                        citaServicio.agregarCita(cita);
                                        break;
                                    }
                                    case "eliminar": {
                                        citaServicio.borradoLogicoCita(id);
                                        break;
                                    }
                                }
                            }

                            //Ultrasonidos
                            String ultrasonidos = request.getParameter("ultrasonidos");
                            System.out.println("ultrasonidos ".concat(ultrasonidos));
                            Object objUltrasonidos = parser.parse(ultrasonidos);
                            JsonArray arrayUltrasonidos = (JsonArray) objUltrasonidos;
                            for (int i = 0; i < arrayUltrasonidos.size(); i++) {
                                JsonObject json = (JsonObject) arrayUltrasonidos.get(i);
                                int id = Integer.parseInt(json.get("id").toString());
                                String accion = json.get("accion").toString();
                                accion = accion.substring(1, accion.length() - 1);
                                String fecha = json.get("fecha").toString();
                                fecha = fecha.substring(1, fecha.length() - 1);
                                String parte = json.get("parte").toString();
                                parte = parte.substring(1, parte.length() - 1);
                                switch (accion) {
                                    case "agregar": {
                                        estudio = estudioServicio.mostrarEstudio(parte);
                                        if(estudio==null){break;}
                                        cita.setIdEstudio(estudio.getIdEstudio());
                                        cita.setFechaProgramada(fechaStringToTimestamp(fecha));
                                        citaServicio.agregarCita(cita);
                                        break;
                                    }
                                    case "actualizar": {
                                        cita.setIdCita(id);
                                        estudio = estudioServicio.mostrarEstudio(parte);
                                        if(estudio==null){break;}
                                        cita.setIdEstudio(estudio.getIdEstudio());
                                        cita.setFechaProgramada(fechaStringToTimestamp(fecha));
                                        citaServicio.actualizarCita(cita);
                                        break;
                                    }
                                    case "eliminar": {
                                        citaServicio.borradoLogicoCita(id);
                                        break;
                                    }
                                }
                            }

                            //Medicina Nuclear
                            String medicinasNucleares = request.getParameter("medicinasNucleares");
                            System.out.println("medicinasNucleares ".concat(medicinasNucleares));
                            Object objMedicinasNucleares = parser.parse(medicinasNucleares);
                            JsonArray arrayMedicinasNucleares = (JsonArray) objMedicinasNucleares;
                            for (int i = 0; i < arrayMedicinasNucleares.size(); i++) {
                                JsonObject json = (JsonObject) arrayMedicinasNucleares.get(i);
                                int id = Integer.parseInt(json.get("id").toString());
                                String accion = json.get("accion").toString();
                                accion = accion.substring(1, accion.length() - 1);
                                String fecha = json.get("fecha").toString();
                                fecha = fecha.substring(1, fecha.length() - 1);
                                String medicinaNuclear = json.get("medicinaNuclear").toString();
                                medicinaNuclear = medicinaNuclear.substring(1, medicinaNuclear.length() - 1);
                                switch (accion) {
                                    case "agregar": {
                                        estudio = estudioServicio.mostrarEstudio(medicinaNuclear);
                                        if(estudio==null){break;}
                                        cita.setIdEstudio(estudio.getIdEstudio());
                                        cita.setFechaProgramada(fechaStringToTimestamp(fecha));
                                        citaServicio.agregarCita(cita);
                                        break;
                                    }
                                    case "actualizar": {
                                        cita.setIdCita(id);
                                        estudio = estudioServicio.mostrarEstudio(medicinaNuclear);
                                        if(estudio==null){break;}
                                        cita.setIdEstudio(estudio.getIdEstudio());
                                        cita.setFechaProgramada(fechaStringToTimestamp(fecha));
                                        citaServicio.actualizarCita(cita);
                                        break;
                                    }
                                    case "eliminar": {
                                        citaServicio.borradoLogicoCita(id);
                                        break;
                                    }
                                }
                            }

                            //Laboratorios
                            String laboratorios = request.getParameter("laboratorios");
                            System.out.println("laboratorios ".concat(laboratorios));
                            Object objLaboratorios = parser.parse(laboratorios);
                            JsonArray arrayLaboratorios = (JsonArray) objLaboratorios;
                            for (int i = 0; i < arrayLaboratorios.size(); i++) {
                                JsonObject json = (JsonObject) arrayLaboratorios.get(i);
                                int id = Integer.parseInt(json.get("id").toString());
                                String accion = json.get("accion").toString();
                                accion = accion.substring(1, accion.length() - 1);
                                String fecha = json.get("fecha").toString();
                                fecha = fecha.substring(1, fecha.length() - 1);
                                switch (accion) {
                                    case "agregar": {
                                        cita.setIdEstudio(1); // TO DO
                                        cita.setFechaProgramada(fechaStringToTimestamp(fecha));
                                        citaServicio.agregarCita(cita);
                                        break;
                                    }
                                    case "actualizar": {
                                        cita.setIdCita(id);
                                        cita.setIdEstudio(1); // TO DO
                                        cita.setFechaProgramada(fechaStringToTimestamp(fecha));
                                        citaServicio.actualizarCita(cita);
                                        break;
                                    }
                                    case "eliminar": {
                                        citaServicio.borradoLogicoCita(id);
                                        break;
                                    }
                                }
                            }

                            //Valoraciones
                            String valoraciones = request.getParameter("valoraciones");
                            System.out.println("valoraciones ".concat(valoraciones));
                            Object objValoraciones = parser.parse(valoraciones);
                            JsonArray arrayValoraciones = (JsonArray) objValoraciones;
                            for (int i = 0; i < arrayValoraciones.size(); i++) {
                                JsonObject json = (JsonObject) arrayValoraciones.get(i);
                                int id = Integer.parseInt(json.get("id").toString());
                                String accion = json.get("accion").toString();
                                accion = accion.substring(1, accion.length() - 1);
                                String fecha = json.get("fecha").toString();
                                fecha = fecha.substring(1, fecha.length() - 1);
                                String valoracion = json.get("valoracion").toString();
                                valoracion = valoracion.substring(1, valoracion.length() - 1);
                                switch (accion) {
                                    case "agregar": {
                                        estudio = estudioServicio.mostrarEstudio(valoracion);
                                        if(estudio==null){break;}
                                        cita.setIdEstudio(estudio.getIdEstudio());
                                        cita.setFechaProgramada(fechaStringToTimestamp(fecha));
                                        citaServicio.agregarCita(cita);
                                        break;
                                    }
                                    case "actualizar": {
                                        cita.setIdCita(id);
                                        estudio = estudioServicio.mostrarEstudio(valoracion);
                                        if(estudio==null){break;}
                                        cita.setIdEstudio(estudio.getIdEstudio());
                                        cita.setFechaProgramada(fechaStringToTimestamp(fecha));
                                        citaServicio.actualizarCita(cita);
                                        break;
                                    }
                                    case "eliminar": {
                                        citaServicio.borradoLogicoCita(id);
                                        break;
                                    }
                                }
                            }

                            //Espirometrias
                            String espirometrias = request.getParameter("espirometrias");
                            System.out.println("espirometrias ".concat(espirometrias));
                            Object objEspirometrias = parser.parse(espirometrias);
                            JsonArray arrayEspirometrias = (JsonArray) objEspirometrias;
                            for (int i = 0; i < arrayEspirometrias.size(); i++) {
                                JsonObject json = (JsonObject) arrayEspirometrias.get(i);
                                int id = Integer.parseInt(json.get("id").toString());
                                String accion = json.get("accion").toString();
                                accion = accion.substring(1, accion.length() - 1);
                                String fecha = json.get("fecha").toString();
                                fecha = fecha.substring(1, fecha.length() - 1);
                                switch (accion) {
                                    case "agregar": {
                                        cita.setIdEstudio(1); // TO DO
                                        cita.setFechaProgramada(fechaStringToTimestamp(fecha));
                                        citaServicio.agregarCita(cita);
                                        break;
                                    }
                                    case "actualizar": {
                                        cita.setIdCita(id);
                                        cita.setIdEstudio(1); // TO DO
                                        cita.setFechaProgramada(fechaStringToTimestamp(fecha));
                                        citaServicio.actualizarCita(cita);
                                        break;
                                    }
                                    case "eliminar": {
                                        citaServicio.borradoLogicoCita(id);
                                        break;
                                    }
                                }
                            }

                            //Electrocardiogramas
                            String electrocardiogramas = request.getParameter("electrocardiogramas");
                            System.out.println("electrocardiogramas ".concat(electrocardiogramas));
                            Object objElectrocardiogramas = parser.parse(electrocardiogramas);
                            JsonArray arrayElectrocardiogramas = (JsonArray) objElectrocardiogramas;
                            for (int i = 0; i < arrayElectrocardiogramas.size(); i++) {
                                JsonObject json = (JsonObject) arrayElectrocardiogramas.get(i);
                                int id = Integer.parseInt(json.get("id").toString());
                                String accion = json.get("accion").toString();
                                accion = accion.substring(1, accion.length() - 1);
                                String fecha = json.get("fecha").toString();
                                fecha = fecha.substring(1, fecha.length() - 1);
                                switch (accion) {
                                    case "agregar": {
                                        cita.setIdEstudio(1); // TO DO
                                        cita.setFechaProgramada(fechaStringToTimestamp(fecha));
                                        citaServicio.agregarCita(cita);
                                        break;
                                    }
                                    case "actualizar": {
                                        cita.setIdCita(id);
                                        cita.setIdEstudio(1); // TO DO
                                        cita.setFechaProgramada(fechaStringToTimestamp(fecha));
                                        citaServicio.actualizarCita(cita);
                                        break;
                                    }
                                    case "eliminar": {
                                        citaServicio.borradoLogicoCita(id);
                                        break;
                                    }
                                }
                            }

                            //Ecocardiogramas
                            String ecocardiogramas = request.getParameter("ecocardiogramas");
                            System.out.println("ecocardiogramas ".concat(ecocardiogramas));
                            Object objEcocardiogramas = parser.parse(ecocardiogramas);
                            JsonArray arrayEcocardiogramas = (JsonArray) objEcocardiogramas;
                            for (int i = 0; i < arrayEcocardiogramas.size(); i++) {
                                JsonObject json = (JsonObject) arrayEcocardiogramas.get(i);
                                int id = Integer.parseInt(json.get("id").toString());
                                String accion = json.get("accion").toString();
                                accion = accion.substring(1, accion.length() - 1);
                                String fecha = json.get("fecha").toString();
                                fecha = fecha.substring(1, fecha.length() - 1);
                                switch (accion) {
                                    case "agregar": {
                                        cita.setIdEstudio(1); // TO DO
                                        cita.setFechaProgramada(fechaStringToTimestamp(fecha));
                                        citaServicio.agregarCita(cita);
                                        break;
                                    }
                                    case "actualizar": {
                                        cita.setIdCita(id);
                                        cita.setIdEstudio(1); // TO DO
                                        cita.setFechaProgramada(fechaStringToTimestamp(fecha));
                                        citaServicio.actualizarCita(cita);
                                        break;
                                    }
                                    case "eliminar": {
                                        citaServicio.borradoLogicoCita(id);
                                        break;
                                    }
                                }
                            }

                            //Trabajos sociales
                            String trabajosSociales = request.getParameter("trabajosSociales");
                            System.out.println("trabajosSociales ".concat(trabajosSociales));
                            Object objTrabajosSociales = parser.parse(trabajosSociales);
                            JsonArray arrayTrabajosSociales = (JsonArray) objTrabajosSociales;
                            for (int i = 0; i < arrayTrabajosSociales.size(); i++) {
                                JsonObject json = (JsonObject) arrayTrabajosSociales.get(i);
                                int id = Integer.parseInt(json.get("id").toString());
                                String accion = json.get("accion").toString();
                                accion = accion.substring(1, accion.length() - 1);
                                String fecha = json.get("fecha").toString();
                                fecha = fecha.substring(1, fecha.length() - 1);
                                switch (accion) {
                                    case "agregar": {
                                        cita.setIdEstudio(1); // TO DO
                                        cita.setFechaProgramada(fechaStringToTimestamp(fecha));
                                        citaServicio.agregarCita(cita);
                                        break;
                                    }
                                    case "actualizar": {
                                        cita.setIdCita(id);
                                        cita.setIdEstudio(1); // TO DO
                                        cita.setFechaProgramada(fechaStringToTimestamp(fecha));
                                        citaServicio.actualizarCita(cita);
                                        break;
                                    }
                                    case "eliminar": {
                                        citaServicio.borradoLogicoCita(id);
                                        break;
                                    }
                                }
                            }

                            //Programas
                            String programas = request.getParameter("programas");
                            System.out.println("programas ".concat(programas));
                            Object objProgramas = parser.parse(programas);
                            JsonArray arrayProgramas = (JsonArray) objProgramas;
                            for (int i = 0; i < arrayProgramas.size(); i++) {
                                JsonObject json = (JsonObject) arrayProgramas.get(i);
                                int id = Integer.parseInt(json.get("id").toString());
                                String accion = json.get("accion").toString();
                                accion = accion.substring(1, accion.length() - 1);
                                String fecha = json.get("fecha").toString();
                                fecha = fecha.substring(1, fecha.length() - 1);
                                String programa = json.get("programa").toString();
                                programa = fecha.substring(1, programa.length() - 1);
                                switch (accion) {
                                    case "agregar": {
                                        estudio = estudioServicio.mostrarEstudio(programa);
                                        if(estudio==null){break;}
                                        cita.setIdEstudio(estudio.getIdEstudio());
                                        cita.setFechaProgramada(fechaStringToTimestamp(fecha));
                                        citaServicio.agregarCita(cita);
                                        break;
                                    }
                                    case "actualizar": {
                                        cita.setIdCita(id);
                                        estudio = estudioServicio.mostrarEstudio(programa);
                                        if(estudio==null){break;}
                                        cita.setIdEstudio(estudio.getIdEstudio());
                                        cita.setFechaProgramada(fechaStringToTimestamp(fecha));
                                        citaServicio.actualizarCita(cita);
                                        break;
                                    }
                                    case "eliminar": {
                                        citaServicio.borradoLogicoCita(id);
                                        break;
                                    }
                                }
                            }

                            //Otros Estudios
                            String otrosEstudios = request.getParameter("otrosEstudios");
                            System.out.println("otrosEstudios ".concat(otrosEstudios));
                            Object objOtrosEstudios = parser.parse(otrosEstudios);
                            JsonArray arrayOtrosEstudios = (JsonArray) objOtrosEstudios;
                            for (int i = 0; i < arrayOtrosEstudios.size(); i++) {
                                JsonObject json = (JsonObject) arrayOtrosEstudios.get(i);
                                int id = Integer.parseInt(json.get("id").toString());
                                String accion = json.get("accion").toString();
                                accion = accion.substring(1, accion.length() - 1);
                                String fecha = json.get("fecha").toString();
                                fecha = fecha.substring(1, fecha.length() - 1);
                                String otroEstudio = json.get("otroEstudio").toString();
                                otroEstudio = fecha.substring(1, otroEstudio.length() - 1);
                                switch (accion) {
                                    case "agregar": {
                                        estudio = estudioServicio.mostrarEstudio(otroEstudio);
                                        if(estudio==null){break;}
                                        cita.setIdEstudio(estudio.getIdEstudio());
                                        cita.setFechaProgramada(fechaStringToTimestamp(fecha));
                                        citaServicio.agregarCita(cita);
                                        break;
                                    }
                                    case "actualizar": {
                                        cita.setIdCita(id);
                                        estudio = estudioServicio.mostrarEstudio(otroEstudio);
                                        if(estudio==null){break;}
                                        cita.setIdEstudio(estudio.getIdEstudio());
                                        cita.setFechaProgramada(fechaStringToTimestamp(fecha));
                                        citaServicio.actualizarCita(cita);
                                        break;
                                    }
                                    case "eliminar": {
                                        citaServicio.borradoLogicoCita(id);
                                        break;
                                    }
                                }
                            }

                            break;
                        }

                        case "autocompleteBiopsia": {

                            AutocompletadoServicioImpl autocompletadoServicioImpl = new AutocompletadoServicioImpl();

                            break;
                        }

                        case "autocompleteRayosX": {

                            AutocompletadoServicioImpl autocompletadoServicioImpl = new AutocompletadoServicioImpl();

                            List<Estudio> estudios = autocompletadoServicioImpl.mostrarEstudioRayosX();

                            PrintWriter out = response.getWriter();

                            Gson json = new Gson();
                            out.print(json.toJson(estudios));

                            break;

                        }

                        case "autocompleteUltraSonido": {

                            AutocompletadoServicioImpl autocompletadoServicioImpl = new AutocompletadoServicioImpl();

                            List<Estudio> estudios = autocompletadoServicioImpl.mostrarEstudioUltrasonido();

                            PrintWriter out = response.getWriter();

                            Gson json = new Gson();
                            out.print(json.toJson(estudios));

                            break;

                        }

                        case "autocompleteMedicinaNuclear": {

                            AutocompletadoServicioImpl autocompletadoServicioImpl = new AutocompletadoServicioImpl();

                            List<Estudio> estudios = autocompletadoServicioImpl.mostrarEstudioMedicinaNuclear();

                            PrintWriter out = response.getWriter();

                            Gson json = new Gson();
                            out.print(json.toJson(estudios));

                            break;

                        }
                        case "autocompleteValoracion": {

                            AutocompletadoServicioImpl autocompletadoServicioImpl = new AutocompletadoServicioImpl();

                            List<Estudio> estudios = autocompletadoServicioImpl.mostrarEstudioValoracion();

                            PrintWriter out = response.getWriter();

                            Gson json = new Gson();
                            out.print(json.toJson(estudios));

                            break;

                        }
                        case "autocompletePrograma": {

                            AutocompletadoServicioImpl autocompletadoServicioImpl = new AutocompletadoServicioImpl();

                            List<Estudio> estudios = autocompletadoServicioImpl.mostrarEstudioProgramas();

                            PrintWriter out = response.getWriter();

                            Gson json = new Gson();
                            out.print(json.toJson(estudios));

                            break;

                        }

                    }

                    break;
                }

            }

        }
    }

    public Timestamp fechaStringToTimestamp(String fecha) {
        Timestamp timestamp = null;        
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = dateFormat.parse(fecha);
            timestamp = new Timestamp(date.getTime());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(timestamp.toString());
        return timestamp;
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
