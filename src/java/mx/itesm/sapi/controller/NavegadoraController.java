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

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
import mx.itesm.sapi.service.gestionPaciente.PacienteNavegadoraServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteNecesidadEspecialServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteServiceImpl;

import mx.itesm.sapi.service.gestionPaciente.CitaEmpleadoServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.CitaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.ComentarioCitaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.DocumentoEstudioServicioImpl;

import mx.itesm.sapi.service.gestionPaciente.DocumentoInicialServicioImpl;

import mx.itesm.sapi.service.gestionPaciente.EstadoPacientePacienteServiceImpl;
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
                            System.out.println("########### Formulario de la navegadora ###########");

                            /**
                             * DECLARACION DE ATRIBUTOS
                             */
                            int idPacientePotencial = 30;
                            int idCuenta = 63;
                            int idNavegadora = 2;//Navegadora

                            /**
                             *
                             * INICIO DECLARACION DE SERVICIOS
                             */
                            PacienteServicioImpl pacienteServicioImpl = new PacienteServicioImpl();
                            Paciente paciente = pacienteServicioImpl.mostrarPaciente(idPacientePotencial);

                            PacienteMedicoTitularServicioImpl pacienteMedicoTitularServicioImpl = new PacienteMedicoTitularServicioImpl();

                            EmpleadoServicioImpl empleadoServicioImpl = new EmpleadoServicioImpl();
                            Empleado empleado = new Empleado();

                            CitaEmpleadoServicioImpl citaEmpleadoServicioImpl = new CitaEmpleadoServicioImpl();

                            EstadoPacientePacienteServiceImpl estadoPacientePacienteServicioImpl = new EstadoPacientePacienteServiceImpl();

                            CitaServicioImpl citaServicioImpl = new CitaServicioImpl();
                            Cita cita = new Cita();

                            LaminillaServicioImpl laminillaServicioImpl = new LaminillaServicioImpl();

                            BloqueParafinaServicioImpl bloqueParafinaServicioImpl = new BloqueParafinaServicioImpl();

                            PacienteAlergiaServicioImpl pacienteAlergiaServicioImpl = new PacienteAlergiaServicioImpl();

                            PacienteSeguroServicioImpl pacienteSeguroServicioImpl = new PacienteSeguroServicioImpl();
                            PacienteSeguro pacienteSeguro = new PacienteSeguro();

                            DocumentoEstudioServicioImpl documentoEstudioServicioImpl = new DocumentoEstudioServicioImpl();

                            PacienteTratamientoPrevioServiceImpl pacienteTratamientoPrevioServiceImpl = new PacienteTratamientoPrevioServiceImpl();
                            PacienteTratamientoPrevio pacienteTratamientoPrevio = new PacienteTratamientoPrevio();

                            BiopsiaServicioImpl biopsiaServicioImpl = new BiopsiaServicioImpl();
                            Biopsia biopsia = new Biopsia();

                            ProgramaPacienteServicioImpl programaPacienteServicioImpl = new ProgramaPacienteServicioImpl();
                            ProgramaPaciente programaPaciente = new ProgramaPaciente();

                            LlamadaCitaServicioImpl LlamadaCitaServicioImpl = new LlamadaCitaServicioImpl();
                            LlamadaCita llamadaCita = new LlamadaCita();

                            ComentarioCitaServicioImpl comentarioCitaServicioImpl = new ComentarioCitaServicioImpl();
                            ComentarioCita comentarioCita = new ComentarioCita();

                            EstadiajeTNMServiceImpl estadiajeTNMServiceImpl = new EstadiajeTNMServiceImpl();
                            EstadiajeTNM estadiajeTNM = new EstadiajeTNM();

                            OtroResultadoPatologiaServicioImpl otroResultadoServicio = new OtroResultadoPatologiaServicioImpl();

                            /**
                             * NUEVOS SERVICIOS (OMAR)
                             */
                            /**
                             * FIN DECLARACION DE SERVICIOS
                             */
                            //PANTALLA 1 DEL FORMULARIO
                            //PRZ
                            String prz = null;
                            prz = request.getParameter("prz-expediente");

                            if (prz.length() > 0) {

                                System.out.println("PRZ ".concat(prz));

                                paciente.setPrz(prz);
                                pacienteServicioImpl.actualizarPaciente(paciente);

                            } else {
                                System.out.println("Sin PRZ");
                            }

                            //Tabla pacienteMedicoTitular
                            //MEDICO ADSCRITO
                            String medicoAdscritoRequest;
                            int medicoAdscrito = 0;
                            medicoAdscritoRequest = request.getParameter("medico-adscrito");

                            if (medicoAdscritoRequest != null) {
                                medicoAdscrito = Integer.parseInt(medicoAdscritoRequest);
                                System.out.println("Medico adscrito " + (medicoAdscrito));
                                int idEmpleado = empleadoServicioImpl.mostrarEmpleadoPersona(medicoAdscrito).getIdEmpleado();
                                int idCita = citaServicioImpl.mostrarCitaPreconsultaPacientePotencial(idPacientePotencial).getIdCita();
                                System.out.println("La cita es " + idCita);
                                /*DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                                Calendar cal = Calendar.getInstance();
                                System.out.println(dateFormat.format(cal.getTime()));
                                Date inicio = Date.valueOf(dateFormat.format(cal.getTime()));

                                 */

                                LocalDate inicio = java.time.LocalDate.now();
                                Date inicioDate = Date.valueOf(inicio);
                                System.out.println(inicioDate);
                                PacienteMedicoTitular pacienteMedicoTitular;
                                pacienteMedicoTitular = pacienteMedicoTitularServicioImpl.mostrarPacienteMedicoTitularIdPacientePosicion(idPacientePotencial, 2);

                                if (pacienteMedicoTitular != null) {

                                    pacienteMedicoTitular.setIdPaciente(idPacientePotencial);
                                    pacienteMedicoTitular.setIdEmpleado(idEmpleado);
                                    pacienteMedicoTitular.setInicio(inicioDate);
                                    //Si ya existe un registro, lo borro lógicamente y luego agrego el nuevo
                                    pacienteMedicoTitularServicioImpl.borradoLogicoPacienteMedicoTitular(pacienteMedicoTitular.getIdPacienteMedicoTitular());
                                    pacienteMedicoTitularServicioImpl.agregarPacienteMedicoTitular(pacienteMedicoTitular);

                                } else {

                                    pacienteMedicoTitular = new PacienteMedicoTitular();
                                    pacienteMedicoTitular.setIdPaciente(idPacientePotencial);
                                    pacienteMedicoTitular.setIdEmpleado(idEmpleado);
                                    pacienteMedicoTitular.setInicio(inicioDate);
                                    pacienteMedicoTitularServicioImpl.agregarPacienteMedicoTitular(pacienteMedicoTitular);
                                }
                                //checkbox adscritoPresente
                                int adscritoPresente = 1;
                                if (request.getParameterMap().containsKey("noAdscrito") == true) {
                                    adscritoPresente = 0;
                                }

                                /**
                                 * Asignación de adscrito presente en tabla
                                 * CitaEmpleado
                                 */
                                CitaEmpleado citaEmpleado = citaEmpleadoServicioImpl.mostrarCitaEmpleadoIdEmpleado(idEmpleado);

                                if (citaEmpleado != null) {
                                    citaEmpleado.setAdscritoPresente(adscritoPresente);
                                    citaEmpleado.setIdEmpleado(idEmpleado);
                                    citaEmpleado.setIdCita(idCita);
                                    citaEmpleadoServicioImpl.borradoLogicoCitaEmpleado(citaEmpleado.getIdCitaEmpleado());
                                    citaEmpleadoServicioImpl.agregarCitaEmpleado(citaEmpleado);
                                } else {
                                    citaEmpleado = new CitaEmpleado();
                                    citaEmpleado.setAdscritoPresente(adscritoPresente);
                                    citaEmpleado.setIdEmpleado(idEmpleado);
                                    citaEmpleado.setIdCita(idCita);
                                    citaEmpleadoServicioImpl.agregarCitaEmpleado(citaEmpleado);
                                }
                                //citaEmpleadoServicioImpl.agregarCitaEmpleado(citaEmpleado);

                                System.out.println("Adscrito Presente ".concat(String.valueOf(adscritoPresente)));

                            } else {
                                System.out.println("Sin médico adscrito");
                            }

                            //MEDICO RADIOLOGO
                            String medicoRadiologoRequest = request.getParameter("medico-radiologo");
                            int medicoRadiologo;

                            System.out.println("Estoy en medico radiologo");

                            if (medicoRadiologoRequest != null) {
                                medicoRadiologo = Integer.parseInt(medicoRadiologoRequest);
                                System.out.println("Medico radiologo " + (medicoRadiologo));
                                int idEmpleado = empleadoServicioImpl.mostrarEmpleadoPersona(medicoRadiologo).getIdEmpleado();
                                int idCita = citaServicioImpl.mostrarCitaPreconsultaPacientePotencial(idPacientePotencial).getIdCita();

                                LocalDate inicio = java.time.LocalDate.now();
                                Date inicioDate = Date.valueOf(inicio);
                                System.out.println(inicioDate);

                                PacienteMedicoTitular pacienteMedicoTitular = pacienteMedicoTitularServicioImpl.mostrarPacienteMedicoTitularIdPacientePosicion(idPacientePotencial, 11);

                                if (pacienteMedicoTitular != null) {
                                    pacienteMedicoTitular.setIdPaciente(idPacientePotencial);
                                    pacienteMedicoTitular.setIdEmpleado(idEmpleado);
                                    pacienteMedicoTitular.setInicio(inicioDate);
                                    pacienteMedicoTitularServicioImpl.borradoLogicoPacienteMedicoTitular(pacienteMedicoTitular.getIdPacienteMedicoTitular());
                                    pacienteMedicoTitularServicioImpl.agregarPacienteMedicoTitular(pacienteMedicoTitular);

                                } else {

                                    pacienteMedicoTitular = new PacienteMedicoTitular();
                                    pacienteMedicoTitular.setIdPaciente(idPacientePotencial);
                                    pacienteMedicoTitular.setIdEmpleado(idEmpleado);
                                    pacienteMedicoTitular.setInicio(inicioDate);
                                    pacienteMedicoTitularServicioImpl.agregarPacienteMedicoTitular(pacienteMedicoTitular);

                                }

                                //checkbox adscritoPresente
                                int adscritoPresente = 1;
                                if (request.getParameterMap().containsKey("noAdscrito") == true) {
                                    adscritoPresente = 0;
                                }

                                /**
                                 * Asignación de radiologo presente en tabla
                                 * CitaEmpleado (para fines practicos es el
                                 * mismo atributo que el del medico adscrito)
                                 */
                                CitaEmpleado citaEmpleado = citaEmpleadoServicioImpl.mostrarCitaEmpleadoIdEmpleado(idEmpleado);

                                if (citaEmpleado != null) {
                                    citaEmpleado.setAdscritoPresente(adscritoPresente);
                                    citaEmpleado.setIdEmpleado(idEmpleado);
                                    citaEmpleado.setIdCita(idCita);
                                    citaEmpleadoServicioImpl.borradoLogicoCitaEmpleado(citaEmpleado.getIdCitaEmpleado());
                                    citaEmpleadoServicioImpl.agregarCitaEmpleado(citaEmpleado);
                                } else {
                                    citaEmpleado = new CitaEmpleado();
                                    citaEmpleado.setAdscritoPresente(adscritoPresente);
                                    citaEmpleado.setIdEmpleado(idEmpleado);
                                    citaEmpleado.setIdCita(idCita);
                                    citaEmpleadoServicioImpl.agregarCitaEmpleado(citaEmpleado);
                                }
                                //citaEmpleadoServicioImpl.agregarCitaEmpleado(citaEmpleado);

                                System.out.println("Adscrito Presente ".concat(String.valueOf(adscritoPresente)));

                            } else {
                                System.out.println("Sin médico adscrito");
                            }

                            //MEDICO RESIDENTE------------------ *************************NO ESTÁ HECHO********
                            String medicoResidente = null;
                            medicoResidente = request.getParameter("medico-residente");
                            if (medicoResidente != null && medicoResidente.length() > 0) {
                                System.out.println("Medico Residente ".concat(medicoResidente));
                            } else {
                                System.out.println("sin médico residente");
                            }

                            //TIPO PACIENTE 
                            int tipoPaciente = -1;

                            String tipoPacienteRequest = request.getParameter("tipoPaciente");

                            if (tipoPacienteRequest != null) {
                                EstadoPacientePaciente estadoPacientePaciente = estadoPacientePacienteServicioImpl.mostrarEstadoPacientePacienteIdPaciente(idPacientePotencial);

                                tipoPaciente = Integer.parseInt(tipoPacienteRequest);
                                estadoPacientePaciente.setSegundaOpinion(tipoPaciente);
                                estadoPacientePaciente.setIdEmpleado(idNavegadora);
                                estadoPacientePacienteServicioImpl.actualizarEstadoPacientePaciente(estadoPacientePaciente);
                                System.out.println(estadoPacientePaciente);
                                System.out.println("Tipo Paciente " + (tipoPaciente));
                            } else {
                                System.out.println("Sin tipoPaciente");
                            }

                            //FECHA DE NAVEGACION
                            //Tipo de navegacion
                            Date dateNavegacion = null;
                            String fechaNavegacionRequest = request.getParameter("fechaNavegacion");
                            System.out.println(fechaNavegacionRequest);

                            if (fechaNavegacionRequest != null && fechaNavegacionRequest.length() > 0) {
                                dateNavegacion = Date.valueOf(fechaNavegacionRequest);
                                Timestamp fechaNavegacion = new Timestamp(dateNavegacion.getTime());
                                Cita citaNavegacionPacientePotencial = citaServicioImpl.mostrarCitaNavegacionPacientePotencial(idPacientePotencial);

                                System.out.println(citaNavegacionPacientePotencial);
                                citaNavegacionPacientePotencial.setFechaReal(fechaNavegacion);
                                citaNavegacionPacientePotencial.setIdEstudio(1);
                                citaNavegacionPacientePotencial.setIdTipoTratamiento(1);

                                System.out.println(citaNavegacionPacientePotencial);

                                citaServicioImpl.actualizarCita(citaNavegacionPacientePotencial);

                                System.out.println(citaNavegacionPacientePotencial);

                                System.out.println("Fecha Navegacion " + (fechaNavegacion));
                            } else {
                                System.out.println("Sin fecha Navegacion");
                            }

                            //FECHA DE PRECONSULTA
                            //
                            Date datePreconsulta = null;
                            Timestamp fechaPreConsulta = null;

                            String fechaPreConsultaRequest = (request.getParameter("fechaConsulta"));
                            if (fechaPreConsultaRequest != null && fechaPreConsultaRequest.length() > 0) {
                                datePreconsulta = Date.valueOf(fechaPreConsultaRequest);
                                fechaPreConsulta = new Timestamp(datePreconsulta.getTime());

                                Cita citaPreConsultaPacientePotencial = citaServicioImpl.mostrarCitaPreconsultaPacientePotencial(idPacientePotencial);

                                citaPreConsultaPacientePotencial.setFechaReal(fechaPreConsulta);
                                citaPreConsultaPacientePotencial.setIdEstudio(1);
                                citaPreConsultaPacientePotencial.setIdTipoTratamiento(1);

                                citaServicioImpl.actualizarCita(citaPreConsultaPacientePotencial);

                                System.out.println("Fecha Consulta " + (fechaPreConsulta));
                            } else {
                                System.out.println("Sin fecha preconsulta");
                            }

                            //FIN PRIMERA PANTALLA
                            //NIVEL EDUCATIVO
                            int nivelEducativo = 0;
                            String nivelEducativoRequest = (request.getParameter("nivelEducativo"));
                            if (nivelEducativoRequest != null) {
                                nivelEducativo = Integer.parseInt(nivelEducativoRequest);
                                System.out.println("Nivel educativo " + (nivelEducativo));
                                paciente = pacienteServicioImpl.mostrarPaciente(idPacientePotencial);
                                paciente.setIdEscolaridad(nivelEducativo);
                                pacienteServicioImpl.actualizarPaciente(paciente);
                            } else {
                                System.out.println("Sin nivel educativo");
                            }

                            //ALERGIAS
                            String alergias = null;
                            alergias = request.getParameter("alergias");
                            if (alergias.length() > 0 && alergias != null) {

                                PacienteAlergia pacienteAlergia = pacienteAlergiaServicioImpl.mostrarPacienteAlergiaIdPaciente(idPacientePotencial);
                                System.out.println("Alergias: ".concat(alergias));

                                if (pacienteAlergia != null) {
                                    pacienteAlergia.setIdPaciente(idPacientePotencial);
                                    pacienteAlergia.setIdAlergia(1);
                                    pacienteAlergia.setAlergia(alergias);
                                    pacienteAlergiaServicioImpl.borradoLogicoPacienteAlergia(pacienteAlergia.getIdPacienteAlergia());
                                    pacienteAlergiaServicioImpl.agregarPacienteAlergia(pacienteAlergia);

                                } else {
                                    pacienteAlergia = new PacienteAlergia();
                                    pacienteAlergia.setIdPaciente(idPacientePotencial);
                                    pacienteAlergia.setIdAlergia(1);
                                    pacienteAlergia.setAlergia(alergias);
                                    pacienteAlergiaServicioImpl.agregarPacienteAlergia(pacienteAlergia);
                                }

                            } else {

                                System.out.println("Sin alergias");
                            }

                            //ESTADO HORMONAL
                            int estadoHormonal = -1;
                            String estadoHormonalRequest = request.getParameter("estadoHormonal");
                            if (estadoHormonalRequest != null) {
                                estadoHormonal = Integer.parseInt(estadoHormonalRequest);
                                paciente = pacienteServicioImpl.mostrarPaciente(idPacientePotencial);
                                paciente.setPosMenopausia(estadoHormonal);
                                pacienteServicioImpl.actualizarPaciente(paciente);
                                System.out.println("EstadoHormonal " + (estadoHormonal));
                            } else {
                                System.out.println("Sin estado hormonal");
                            }

                            //SEGURO POPULAR
                            //PacienteSeguro
                            int tieneSeguroPopular = 0;
                            if (request.getParameterMap().containsKey("tieneSeguroPopular")) {
                                tieneSeguroPopular = 1;
                            }
                            System.out.println("Tiene seguroPopular ".concat(String.valueOf(tieneSeguroPopular)));

                            if (tieneSeguroPopular == 1) {

                                pacienteSeguro = pacienteSeguroServicioImpl.mostrarPacienteSeguroIdPaciente(idPacientePotencial);
                                int nombreSeguro = -1;
                                String numeroSeguro = null;
                                numeroSeguro = request.getParameter("numSeguro");
                                String nombreSeguroRequest = request.getParameter("tiene-seguro");

                                if (pacienteSeguro != null) {
                                    //Actualizar
                                    if (nombreSeguroRequest != null) {
                                        nombreSeguro = Integer.parseInt(nombreSeguroRequest);
                                        pacienteSeguro.setIdSeguro(nombreSeguro);
                                        if (numeroSeguro != null) {
                                            pacienteSeguro.setNoSeguro(numeroSeguro);
                                            System.out.println("Número seguro ".concat(numeroSeguro));
                                        } else {
                                            pacienteSeguro.setNoSeguro(null);
                                            System.out.println("Sin número de seguro");
                                        }
                                        pacienteSeguroServicioImpl.actualizarPacienteSeguro(pacienteSeguro);
                                        System.out.println("Nombre seguro " + (nombreSeguro));
                                    } else {
                                        System.out.println("Sin seguro");
                                    }

                                } else {
                                    //Agregar
                                    if (nombreSeguroRequest != null) {
                                        pacienteSeguro = new PacienteSeguro();
                                        nombreSeguro = Integer.parseInt(nombreSeguroRequest);
                                        pacienteSeguro.setIdSeguro(nombreSeguro);
                                        pacienteSeguro.setIdPaciente(idPacientePotencial);
                                        if (numeroSeguro != null) {
                                            pacienteSeguro.setNoSeguro(numeroSeguro);
                                            System.out.println("Número seguro ".concat(numeroSeguro));
                                        } else {
                                            System.out.println("Sin número de seguro");
                                        }
                                        pacienteSeguroServicioImpl.agregarPacienteSeguro(pacienteSeguro);
                                        System.out.println("Nombre seguro " + (nombreSeguro));
                                    } else {
                                        System.out.println("Sin seguro");
                                    }
 
                                }

                            }
//AUXILIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
                            /*
                            //MASTOGRAFIA PREVIA
                            //Se agrega en documentoEstudio
                            int primeraMasto = 0;
                            //29 es el idEstudio
                            //

                            if (request.getParameterMap().containsKey("primeraMasto")) {
                                System.out.println("Entre a la masto");
                                primeraMasto = 1;
                                int idCitaPre = citaServicioImpl.mostrarCitaPreconsultaPacientePotencial(idPacientePotencial).getIdCita();
                                DocumentoEstudio documentoEstudioPrimeraMasto = documentoEstudioServicioImpl.mostrarDocumentoEstudioPacienteEstudio(idPacientePotencial, 29);

                                if (documentoEstudioPrimeraMasto != null) {
                                    System.out.println("No hay que hacer nada");
                                } else {
                                    //HARCODEO
                                    documentoEstudioPrimeraMasto = new DocumentoEstudio();
                                    documentoEstudioPrimeraMasto.setIdEstudio(29);
                                    documentoEstudioPrimeraMasto.setIdPaciente(idPacientePotencial);
                                    documentoEstudioPrimeraMasto.setIdEstadoEstudio(1);
                                    documentoEstudioPrimeraMasto.setIdCita(idCitaPre);
                                    //HARCODEO
                                    //ESTOS DOS ESTAN HARCODEADOS!!!!! SE NECESITA CHECAR QUÉ ONDA
                                    documentoEstudioPrimeraMasto.setIdBirads(8);
                                    documentoEstudioPrimeraMasto.setIdLugarDelCuerpo(2);

                                    System.out.println(documentoEstudioPrimeraMasto);

                                    documentoEstudioServicioImpl.agregarDocumentoEstudio(documentoEstudioPrimeraMasto);
                                }
                            } else {
                                DocumentoEstudio documentoEstudioPrimeraMasto = documentoEstudioServicioImpl.mostrarDocumentoEstudioPacienteEstudio(idPacientePotencial, 29);
                                if (documentoEstudioPrimeraMasto != null) {
                                    documentoEstudioServicioImpl.borradoLogicoDocumentoEstudio(documentoEstudioPrimeraMasto.getIdDocumentoEstudio());
                                }

                            }
                            System.out.println("Masto antes del INCan ".concat(String.valueOf(primeraMasto)));
*/
                            //PacienteTratamientoPrevio
                            //Cirugia previa
                            int tieneCirugiaPrevia = 0;
                            //Verifica si hay cirugía previa
                            if (request.getParameterMap().containsKey("tiene-cirugia")) {

                                PacienteTratamientoPrevio cirugiaPrevia = pacienteTratamientoPrevioServiceImpl.mostrarPacienteTratamientoPrevioTratamiento(idPacientePotencial, 3);

                                if (cirugiaPrevia != null) {
                                    //Actualiza
                                    cirugiaPrevia.setIdPaciente(idPacientePotencial);
                                    //Setea la fecha 
                                    Date fechaCirugiaPrevia = null;
                                    String fechaCirugiaPreviaRequest = request.getParameter("fecha-cirugia");

                                    if (fechaCirugiaPreviaRequest != null) {
                                        fechaCirugiaPrevia = Date.valueOf(fechaCirugiaPreviaRequest);
                                        cirugiaPrevia.setFecha(fechaCirugiaPrevia);
                                        System.out.println("Fecha Cirugia " + (fechaCirugiaPrevia));
                                    } else {
                                        System.out.println("Sin fecha de cirguía");
                                    }
                                    //Setea el id del tipoTratamiento de cirugias
                                    int nombreCirugiaPrevia = 0;
                                    String nombreCirugiaPreviaRequest = request.getParameter("cirugia");

                                    if (nombreCirugiaPreviaRequest != null) {
                                        nombreCirugiaPrevia = Integer.parseInt(nombreCirugiaPreviaRequest);
                                        cirugiaPrevia.setIdTipoTratamiento(nombreCirugiaPrevia);
                                        System.out.println("Nombre cirguia " + (nombreCirugiaPrevia));
                                    } else {
                                        System.out.println("Sin nombre cirguia previa");
                                    }
                                    //Setea el comentario de la cirugia
                                    String detalleCirugiaPrevia = null;
                                    detalleCirugiaPrevia = request.getParameter("detalle-cirugia");
                                    if (detalleCirugiaPrevia != null) {
                                        cirugiaPrevia.setComentarios(detalleCirugiaPrevia);
                                        System.out.println("Detalle Cirguia ".concat(detalleCirugiaPrevia));
                                    } else {
                                        System.out.println("Sin detalles de cirguía");
                                    }
                                    System.out.println("Tiene cirugía previa ".concat(String.valueOf(tieneCirugiaPrevia)));

                                    pacienteTratamientoPrevioServiceImpl.actualizarPacienteTratamientoPrevio(cirugiaPrevia);

                                } else {
                                    cirugiaPrevia = new PacienteTratamientoPrevio();
                                    cirugiaPrevia.setIdPaciente(idPacientePotencial);
                                    //Setea la fecha 
                                    Date fechaCirugiaPrevia = null;
                                    String fechaCirugiaPreviaRequest = request.getParameter("fecha-cirugia");

                                    if (fechaCirugiaPreviaRequest != null) {
                                        fechaCirugiaPrevia = Date.valueOf(fechaCirugiaPreviaRequest);
                                        cirugiaPrevia.setFecha(fechaCirugiaPrevia);
                                        System.out.println("Fecha Cirugia " + (fechaCirugiaPrevia));
                                    } else {
                                        System.out.println("Sin fecha de cirguía");
                                    }
                                    //Setea el id del tipoTratamiento de cirugias
                                    int nombreCirugiaPrevia = 0;
                                    String nombreCirugiaPreviaRequest = request.getParameter("cirugia");

                                    if (nombreCirugiaPreviaRequest != null) {
                                        nombreCirugiaPrevia = Integer.parseInt(nombreCirugiaPreviaRequest);
                                        cirugiaPrevia.setIdTipoTratamiento(nombreCirugiaPrevia);
                                        System.out.println("Nombre cirguia " + (nombreCirugiaPrevia));
                                    } else {
                                        System.out.println("Sin nombre cirguia previa");
                                    }
                                    //Setea el comentario de la cirugia
                                    String detalleCirugiaPrevia = null;
                                    detalleCirugiaPrevia = request.getParameter("detalle-cirugia");
                                    if (detalleCirugiaPrevia != null) {
                                        cirugiaPrevia.setComentarios(detalleCirugiaPrevia);
                                        System.out.println("Detalle Cirguia ".concat(detalleCirugiaPrevia));
                                    } else {
                                        System.out.println("Sin detalles de cirguía");
                                    }
                                    System.out.println("Tiene cirugía previa ".concat(String.valueOf(tieneCirugiaPrevia)));

                                    pacienteTratamientoPrevioServiceImpl.agregarPacienteTratamientoPrevio(cirugiaPrevia);
                                }
                            }

                            //QUIMIOTERAPIA
                            int tieneQuimioterapiaPrevia = 0; //ESTE QUEDA SIN FUNCIONAMIENTO?????
                            if (request.getParameterMap().containsKey("tiene-quimioterapia")) {

                                // System.out.println("Quimioterapia Previa ".concat(String.valueOf(tieneQuimioterapiaPrevia)));
                                PacienteTratamientoPrevio quimioterapiaPrevia = pacienteTratamientoPrevioServiceImpl.mostrarPacienteTratamientoPrevioTratamiento(idPacientePotencial, 1);

                                if (quimioterapiaPrevia != null) {
                                    quimioterapiaPrevia.setIdPaciente(idPacientePotencial);
                                    quimioterapiaPrevia.setIdTipoTratamiento(1);
                                    String fechaQuimioterapiaPreviaRequest = request.getParameter("fecha-quimioterapia");

                                    if (fechaQuimioterapiaPreviaRequest != null) {

                                        Date fechaQuimioterapiaPreviaDate = Date.valueOf(fechaQuimioterapiaPreviaRequest);
                                        quimioterapiaPrevia.setFecha(fechaQuimioterapiaPreviaDate);
                                        System.out.println("Fecha quimioterapia previa ".concat(fechaQuimioterapiaPreviaRequest));
                                    } else {
                                        System.out.println("Sin fecha  quimio previa");
                                    }
                                    String numeroCiclosRequest = request.getParameter("quimioterapia");
                                    int numeroCiclos = 0;

                                    if (numeroCiclosRequest != null) {
                                        numeroCiclos = Integer.parseInt(numeroCiclosRequest);
                                        System.out.println("Numero de ciclos quimioterapia" + numeroCiclos);
                                        quimioterapiaPrevia.setCiclos(numeroCiclos);

                                    } else {
                                        System.out.println("Sin Numero de ciclos quimioterapia");
                                    }

                                    String detalleQuimioterapiaPrevia = null;
                                    detalleQuimioterapiaPrevia = request.getParameter("detalle-quimioterapia");

                                    if (detalleQuimioterapiaPrevia != null) {
                                        System.out.println("Detalle quimioterapia ".concat(detalleQuimioterapiaPrevia));
                                        quimioterapiaPrevia.setComentarios(detalleQuimioterapiaPrevia);
                                    } else {
                                        System.out.println("Sin detalle quimioterapia previa");
                                    }

                                    pacienteTratamientoPrevioServiceImpl.actualizarPacienteTratamientoPrevio(quimioterapiaPrevia);

                                } else {
                                    quimioterapiaPrevia = new PacienteTratamientoPrevio();
                                    quimioterapiaPrevia.setIdPaciente(idPacientePotencial);
                                    quimioterapiaPrevia.setIdTipoTratamiento(1);
                                    String fechaQuimioterapiaPrevia = null;
                                    fechaQuimioterapiaPrevia = request.getParameter("fecha-quimioterapia");

                                    if (fechaQuimioterapiaPrevia != null) {
                                        Date fechaQuimioterapiaPreviaDate = Date.valueOf(fechaQuimioterapiaPrevia);
                                        quimioterapiaPrevia.setFecha(fechaQuimioterapiaPreviaDate);
                                        System.out.println("Fecha quimioterapia previa ".concat(fechaQuimioterapiaPrevia));
                                    } else {
                                        System.out.println("Sin fecha  quimio previa");
                                    }

                                    int numeroCiclos = 0;
                                    String numeroCiclosRequest = request.getParameter("quimioterapia");

                                    if (numeroCiclosRequest != null) {
                                        numeroCiclos = Integer.parseInt(numeroCiclosRequest);
                                        System.out.println("Numero de ciclos quimioterapia" + numeroCiclos);
                                        quimioterapiaPrevia.setCiclos(numeroCiclos);

                                    } else {
                                        System.out.println("Sin Numero de ciclos quimioterapia");
                                    }

                                    String detalleQuimioterapiaPrevia = null;
                                    detalleQuimioterapiaPrevia = request.getParameter("detalle-quimioterapia");

                                    if (detalleQuimioterapiaPrevia != null) {
                                        System.out.println("Detalle quimioterapia ".concat(detalleQuimioterapiaPrevia));
                                        quimioterapiaPrevia.setComentarios(detalleQuimioterapiaPrevia);
                                    } else {
                                        System.out.println("Sin detalle quimioterapia previa");
                                    }

                                    pacienteTratamientoPrevioServiceImpl.agregarPacienteTratamientoPrevio(quimioterapiaPrevia);
                                }
                            }
                            //RADIOTERAPIA

                            int tieneRadioterapiaPrevia = 0;
                            if (request.getParameterMap().containsKey("tiene-radioterapia")) {

                                // System.out.println("Radioterapia previa ".concat(String.valueOf(tieneRadioterapiaPrevia)));
                                PacienteTratamientoPrevio radioterapiaPrevia = pacienteTratamientoPrevioServiceImpl.mostrarPacienteTratamientoPrevioTratamiento(idPacientePotencial, 7);

                                if (radioterapiaPrevia != null) {
                                    radioterapiaPrevia.setIdPaciente(idPacientePotencial);
                                    radioterapiaPrevia.setIdTipoTratamiento(7);

                                    String fechaRadioterapiaPrevia = null;
                                    fechaRadioterapiaPrevia = request.getParameter("fecha-radioterapia");

                                    if (fechaRadioterapiaPrevia != null) {
                                        Date fechaRadioterapiaPreviaDate = Date.valueOf(fechaRadioterapiaPrevia);
                                        System.out.println("Fecha de radioterapia ".concat(fechaRadioterapiaPrevia));
                                        radioterapiaPrevia.setFecha(fechaRadioterapiaPreviaDate);
                                    } else {
                                        System.out.println("Sin fecha radio previa");
                                    }

                                    int numeroCiclos = 0;
                                    String numeroCiclosRequest = (request.getParameter("radioterapia"));
                                    if (numeroCiclosRequest != null) {
                                        numeroCiclos = Integer.parseInt(request.getParameter("radioterapia"));
                                        System.out.println("Numero ciclos radioterapia " + (numeroCiclos));
                                        radioterapiaPrevia.setCiclos(numeroCiclos);
                                    } else {
                                        System.out.println("sin Numero ciclos radioterapia");
                                    }

                                    String detalleRadioterapiaPrevia = null;
                                    detalleRadioterapiaPrevia = request.getParameter("detalle-radioterapia");
                                    if (detalleRadioterapiaPrevia != null && detalleRadioterapiaPrevia.length() > 0) {
                                        System.out.println("Detalle radioterapia ".concat(detalleRadioterapiaPrevia));
                                        radioterapiaPrevia.setComentarios(detalleRadioterapiaPrevia);
                                    } else {
                                        System.out.println("Sin detalle radio previa");
                                    }
                                    pacienteTratamientoPrevioServiceImpl.actualizarPacienteTratamientoPrevio(radioterapiaPrevia);

                                } else {
                                    radioterapiaPrevia = new PacienteTratamientoPrevio();
                                    radioterapiaPrevia.setIdPaciente(idPacientePotencial);
                                    radioterapiaPrevia.setIdTipoTratamiento(7);
                                    String fechaRadioterapiaPrevia = null;
                                    fechaRadioterapiaPrevia = request.getParameter("fecha-radioterapia");

                                    if (fechaRadioterapiaPrevia != null) {
                                        Date fechaRadioterapiaPreviaDate = Date.valueOf(fechaRadioterapiaPrevia);
                                        System.out.println("Fecha de radioterapia ".concat(fechaRadioterapiaPrevia));
                                        radioterapiaPrevia.setFecha(fechaRadioterapiaPreviaDate);
                                    } else {
                                        System.out.println("Sin fecha radio previa");
                                    }

                                    int numeroCiclos = 0;
                                    String numeroCiclosRequest = (request.getParameter("radioterapia"));
                                    if (numeroCiclosRequest != null) {
                                        numeroCiclos = Integer.parseInt(request.getParameter("radioterapia"));
                                        System.out.println("Numero ciclos radioterapia " + (numeroCiclos));
                                        radioterapiaPrevia.setCiclos(numeroCiclos);
                                    } else {
                                        System.out.println("sin Numero ciclos radioterapia");
                                    }

                                    String detalleRadioterapiaPrevia = null;
                                    detalleRadioterapiaPrevia = request.getParameter("detalle-radioterapia");
                                    if (detalleRadioterapiaPrevia != null && detalleRadioterapiaPrevia.length() > 0) {
                                        System.out.println("Detalle radioterapia ".concat(detalleRadioterapiaPrevia));
                                        radioterapiaPrevia.setComentarios(detalleRadioterapiaPrevia);
                                    } else {
                                        System.out.println("Sin detalle radio previa");
                                    }

                                    pacienteTratamientoPrevioServiceImpl.agregarPacienteTratamientoPrevio(radioterapiaPrevia);

                                }
                            }

                            //CHECAR MAÑANA, HACE BORRADO LOGICO PERO NO SE DONDE
                            //MASTOGRAFIA Previa
                            //DocumentoPrevio
                            int tieneMastografiaPrevia = 0;
                            if (request.getParameterMap().containsKey("tiene-mastografia")) {

                                //RAUL-SP FALTA PEDIRSELO!!!!!!!!!
                                //HARCODEO
                                DocumentoEstudio documentoEstudioPrevioMastografia = documentoEstudioServicioImpl.mostrarDocumentoEstudioPacienteEstudio(idPacientePotencial, 29);
                                int idCitaPreconsulta = citaServicioImpl.mostrarCitaPreconsultaPacientePotencial(idPacientePotencial).getIdCita();
                                if (documentoEstudioPrevioMastografia != null) {
                                    documentoEstudioPrevioMastografia.setIdPaciente(idPacientePotencial);
                                    documentoEstudioPrevioMastografia.setPrevio(1);
                                    documentoEstudioPrevioMastografia.setIdEstadoEstudio(1);
                                    //aqui no se harcodea pq ya está el registro con ese id
                                    documentoEstudioPrevioMastografia.setIdEstudio(29);
                                    documentoEstudioPrevioMastografia.setIdBirads(8);
                                    documentoEstudioPrevioMastografia.setIdLugarDelCuerpo(2);
                                    documentoEstudioPrevioMastografia.setIdCita(idCitaPreconsulta);

                                    String tipoMastografiaPreviaRequest = request.getParameter("tipoMastografia");
                                    int tipoMastografiaPrevia = 0;

                                    if (tipoMastografiaPreviaRequest != null) {
                                        tipoMastografiaPrevia = Integer.parseInt(tipoMastografiaPreviaRequest);
                                        documentoEstudioPrevioMastografia.setIdBirads(tipoMastografiaPrevia);
                                        System.out.println("Tipo Mastrografia previa " + (tipoMastografiaPrevia));
                                    } else {
                                        System.out.println("Sin masto previa");
                                    }

                                    Date fechaMastografiaPrevia = null;
                                    String fechaMastografiaPreviaRequest = request.getParameter("fechaPreMasto");
                                    if (fechaMastografiaPreviaRequest != null) {
                                        fechaMastografiaPrevia = Date.valueOf(fechaMastografiaPreviaRequest);
                                        documentoEstudioPrevioMastografia.setFechaEstudioResultado(fechaMastografiaPrevia);
                                        System.out.println("Fecha mastografia previa " + (fechaMastografiaPrevia));
                                    } else {
                                        System.out.println(" SIN Fecha mastografia previa ");
                                    }
                                    documentoEstudioServicioImpl.actualizarDocumentoEstudio(documentoEstudioPrevioMastografia);

                                } else {

                                    documentoEstudioPrevioMastografia = new DocumentoEstudio();

                                    documentoEstudioPrevioMastografia.setIdPaciente(idPacientePotencial);
                                    documentoEstudioPrevioMastografia.setPrevio(1);
                                    documentoEstudioPrevioMastografia.setIdEstadoEstudio(1);
                                    //aqui no se harcodea pq ya está el registro con ese id
                                    documentoEstudioPrevioMastografia.setIdEstudio(29);

                                    documentoEstudioPrevioMastografia.setIdBirads(8);
                                    documentoEstudioPrevioMastografia.setIdLugarDelCuerpo(2);
                                    documentoEstudioPrevioMastografia.setIdCita(idCitaPreconsulta);

                                    String tipoMastografiaPreviaRequest = request.getParameter("tipoMastografia");
                                    int tipoMastografiaPrevia = 0;

                                    if (tipoMastografiaPreviaRequest != null) {
                                        tipoMastografiaPrevia = Integer.parseInt(tipoMastografiaPreviaRequest);
                                        documentoEstudioPrevioMastografia.setIdBirads(tipoMastografiaPrevia);
                                        System.out.println("Tipo Mastrografia previa " + (tipoMastografiaPrevia));
                                    } else {
                                        System.out.println("Sin masto previa");
                                    }

                                    Date fechaMastografiaPrevia = null;
                                    String fechaMastografiaPreviaRequest = request.getParameter("fechaPreMasto");
                                    if (fechaMastografiaPreviaRequest != null) {
                                        fechaMastografiaPrevia = Date.valueOf(fechaMastografiaPreviaRequest);
                                        documentoEstudioPrevioMastografia.setFechaEstudioResultado(fechaMastografiaPrevia);
                                        System.out.println("Fecha mastografia previa " + (fechaMastografiaPrevia));
                                    } else {
                                        System.out.println(" SIN Fecha mastografia previa ");
                                    }
                                    documentoEstudioServicioImpl.agregarDocumentoEstudio(documentoEstudioPrevioMastografia);
                                }
                            }

                            //CHECAR MAÑANA, HACE BORRADO LOGICO PERO NO SE DONDE
                            //ULTRASONIDO Previo
                            //DocumentoEstudio
                            int tieneUltrasonidoPrevio = 0;
                            if (request.getParameterMap().containsKey("tiene-ultrasonido-mama")) {

                                DocumentoEstudio documentoEstudioPrevioUltrasonido = documentoEstudioServicioImpl.mostrarDocumentoEstudioPacienteEstudio(idPacientePotencial, 27);
                                int idCitaPreconsulta = citaServicioImpl.mostrarCitaPreconsultaPacientePotencial(idPacientePotencial).getIdCita();

                                if (documentoEstudioPrevioUltrasonido != null) {

                                    documentoEstudioPrevioUltrasonido.setIdPaciente(idPacientePotencial);
                                    documentoEstudioPrevioUltrasonido.setPrevio(1);
                                    documentoEstudioPrevioUltrasonido.setIdEstadoEstudio(1);
                                    //Aqui no se harcodea pq ya está en el registro
                                    documentoEstudioPrevioUltrasonido.setIdEstudio(27);
                                    documentoEstudioPrevioUltrasonido.setIdCita(idCitaPreconsulta);

                                    documentoEstudioPrevioUltrasonido.setIdBirads(8);
                                    documentoEstudioPrevioUltrasonido.setIdLugarDelCuerpo(2);

                                    int tipoUltrasonidoPrevio = 0;
                                    String tipoUltrasonidoPrevioRequest = request.getParameter("tipoUltrasonidoMama");

                                    if (tipoUltrasonidoPrevioRequest != null) {
                                        tipoUltrasonidoPrevio = Integer.parseInt(tipoUltrasonidoPrevioRequest);
                                        documentoEstudioPrevioUltrasonido.setIdBirads(tipoUltrasonidoPrevio);
                                        System.out.println("Tipo ultrasonido " + (tipoUltrasonidoPrevio));
                                    } else {
                                        System.out.println("Sin tipo ultrasonido");
                                    }

                                    Date fechaUltrasonidoPrevio = null;
                                    String fechaUltrasonidoPrevioRequest = request.getParameter("fechaPreUsg");

                                    if (fechaUltrasonidoPrevioRequest != null) {
                                        fechaUltrasonidoPrevio = Date.valueOf(fechaUltrasonidoPrevioRequest);
                                        documentoEstudioPrevioUltrasonido.setFechaEstudioResultado(fechaUltrasonidoPrevio);
                                        System.out.println("Fecha ultrasonido previo " + (fechaUltrasonidoPrevio));
                                    } else {
                                        System.out.println("Sin fecha ultrasonido previo");
                                    }

                                    documentoEstudioServicioImpl.actualizarDocumentoEstudio(documentoEstudioPrevioUltrasonido);
                                } else {

                                    documentoEstudioPrevioUltrasonido = new DocumentoEstudio();

                                    documentoEstudioPrevioUltrasonido.setIdPaciente(idPacientePotencial);
                                    documentoEstudioPrevioUltrasonido.setPrevio(1);
                                    documentoEstudioPrevioUltrasonido.setIdEstadoEstudio(1);

                                    //Se harcodea el idEstudio
                                    documentoEstudioPrevioUltrasonido.setIdEstudio(27);
                                    documentoEstudioPrevioUltrasonido.setIdBirads(8);
                                    documentoEstudioPrevioUltrasonido.setIdLugarDelCuerpo(2);
                                    documentoEstudioPrevioUltrasonido.setIdCita(idCitaPreconsulta);

                                    int tipoUltrasonidoPrevio = 0;
                                    String tipoUltrasonidoPrevioRequest = request.getParameter("tipoUltrasonidoMama");

                                    if (tipoUltrasonidoPrevioRequest != null) {
                                        tipoUltrasonidoPrevio = Integer.parseInt(tipoUltrasonidoPrevioRequest);
                                        documentoEstudioPrevioUltrasonido.setIdBirads(tipoUltrasonidoPrevio);
                                        System.out.println("Tipo ultrasonido " + (tipoUltrasonidoPrevio));
                                    } else {
                                        System.out.println("Sin tipo ultrasonido");
                                    }

                                    Date fechaUltrasonidoPrevio = null;
                                    String fechaUltrasonidoPrevioRequest = request.getParameter("fechaPreUsg");

                                    if (fechaUltrasonidoPrevioRequest != null) {
                                        fechaUltrasonidoPrevio = Date.valueOf(fechaUltrasonidoPrevioRequest);
                                        documentoEstudioPrevioUltrasonido.setFechaEstudioResultado(fechaUltrasonidoPrevio);
                                        System.out.println("Fecha ultrasonido previo " + (fechaUltrasonidoPrevio));
                                    } else {
                                        System.out.println("Sin fecha ultrasonido previo");
                                    }
                                    documentoEstudioServicioImpl.agregarDocumentoEstudio(documentoEstudioPrevioUltrasonido);
                                }
                            }

                            //Resultado de patologia
                            //Biopsia y OtrosResultados
                            int resultadoPatologia = 0;
                            String resultadoPatologiaRequest = request.getParameter("resultadoAnterior-patologia");

                            String otroReportePatologia = null;
                            otroReportePatologia = request.getParameter("introducirOtroResultadoPatologia");
                            if (resultadoPatologiaRequest != null) {
                                resultadoPatologia = Integer.parseInt(resultadoPatologiaRequest);
                                Biopsia biopsiaResultado = new Biopsia();
                                //Busca la bipsia
                                biopsiaResultado = biopsiaServicioImpl.mostrarBiopsiaIdPaciente(idPacientePotencial);

                                OtroResultadoPatologia otroResultado = new OtroResultadoPatologia();

                                if (biopsiaResultado != null) {
                                    //Si hay biopasia se actualiza
                                    biopsiaResultado.setIdTipoHistologico(resultadoPatologia);
                                    
                                    biopsiaResultado.setIdLugarDelCuerpo(1);
                                    biopsiaResultado.setIdTipoBiopsia(1);
                                    biopsiaResultado.setIdHer2(1);
                                    biopsiaResultado.setIdReceptorProgesterona(1);
                                    biopsiaResultado.setIdReceptorEstrogeno(1);
                                    biopsiaResultado.setIdFish(1);
                                    biopsiaResultado.setIdKi67(1);
                                   // biopsiaResultado.setIdTipoHistologico(5);
                                    biopsiaResultado.setIdGradoHistologico(1);
                                    
                                    biopsiaServicioImpl.actualizarBiopsia(biopsiaResultado);
                                    otroResultado.setIdBiopsia(biopsiaResultado.getIdPaciente());

                                    if (resultadoPatologia == 16 && otroReportePatologia != null) {
                                        otroResultado.setNombre(otroReportePatologia);
                                    }
                                    otroResultadoServicio.agregarOtroResultadoPatologia(otroResultado);

                                } else {
                                    //Si no hay se inserta

                                    biopsiaResultado = new Biopsia();

                                    biopsiaResultado.setIdPaciente(idPacientePotencial);
                                    biopsiaResultado.setIdTipoHistologico(resultadoPatologia);
                                    
                                    biopsiaResultado.setIdLugarDelCuerpo(1);
                                    biopsiaResultado.setIdTipoBiopsia(1);
                                    biopsiaResultado.setIdHer2(1);
                                    biopsiaResultado.setIdReceptorProgesterona(1);
                                    biopsiaResultado.setIdReceptorEstrogeno(1);
                                    biopsiaResultado.setIdFish(1);
                                    biopsiaResultado.setIdKi67(1);
                                    //biopsiaResultado.setIdTipoHistologico(5);
                                    biopsiaResultado.setIdGradoHistologico(1);
                                    

                                    int idBiopsiaResultado = biopsiaServicioImpl.agregarBiopsia(biopsiaResultado);
                                    otroResultado.setIdBiopsia(idBiopsiaResultado);
                                    if (resultadoPatologia == 16 && otroReportePatologia != null) {
                                        otroResultado.setNombre(otroReportePatologia);
                                    }
                                    otroResultadoServicio.agregarOtroResultadoPatologia(otroResultado);

                                }

                                System.out.println("Resultado de patología " + (resultadoPatologia));
                            } else {
                                System.out.println("Sin resultados de patología");
                            }
                            //LAMINILLAS
                            int entregaLaminillas = 0;
                            if (request.getParameterMap().containsKey("entregaLaminillas")) {

                                //RAUL- SP falta decirle!!!!!!!!!1
                                Laminilla laminilla = laminillaServicioImpl.mostrarLaminillaPaciente(idPacientePotencial);

                                if (laminilla != null) {
                                    int numeroLaminillas = 0;
                                    try {
                                        numeroLaminillas = Integer.parseInt(request.getParameter("numLaminillas"));
                                        int idBiopsia = biopsiaServicioImpl.mostrarBiopsiaPreviaPaciente(idPacientePotencial, 1).getIdBiopsia();
                                        laminilla.setIdBiopsia(idBiopsia);
                                        laminilla.setCantidad(numeroLaminillas);

                                    } catch (Exception ex) {
                                        System.out.println("Exception Número laminillas ".concat(ex.getMessage()));
                                    }
                                    System.out.println("Numero de laminillas ".concat(String.valueOf(numeroLaminillas)));

                                    String serieLaminillas = null;
                                    serieLaminillas = request.getParameter("serieLaminillas");
                                    if (serieLaminillas != null && serieLaminillas.length() > 0) {
                                        //AQUI ES .setSerie, no??????????
                                        laminilla.setNombre(serieLaminillas);
                                        System.out.println("Serie laminillas ".concat(serieLaminillas));
                                    } else {
                                        System.out.println("Sin serie laminillas");
                                    }

                                    laminillaServicioImpl.actualizarLaminilla(laminilla);
                                } else {
                                    int numeroLaminillas = 0;
                                    try {
                                        numeroLaminillas = Integer.parseInt(request.getParameter("numLaminillas"));
                                        int idBiopsia = biopsiaServicioImpl.mostrarBiopsiaPreviaPaciente(idPacientePotencial, 1).getIdBiopsia();
                                        laminilla.setIdBiopsia(idBiopsia);
                                        laminilla.setCantidad(numeroLaminillas);

                                    } catch (Exception ex) {
                                        System.out.println("Exception Número laminillas ".concat(ex.getMessage()));
                                    }
                                    System.out.println("Numero de laminillas ".concat(String.valueOf(numeroLaminillas)));

                                    String serieLaminillas = null;
                                    serieLaminillas = request.getParameter("serieLaminillas");
                                    if (serieLaminillas != null && serieLaminillas.length() > 0) {
                                        //AQUI ES .setSerie, no??????????
                                        laminilla.setNombre(serieLaminillas);
                                        System.out.println("Serie laminillas ".concat(serieLaminillas));
                                    } else {
                                        System.out.println("Sin serie laminillas");
                                    }

                                    laminillaServicioImpl.agregarLaminilla(laminilla);
                                }
                            }
                            //-----------------------------------hasta aqui 
                            //BLOQUES PARAFINA
                            int entregaBloquesParafina = 0;
                            if (request.getParameterMap().containsKey("entregaBloques")) {

                                //RAUL- SP falta decirle!!!!!!!
                                BloqueParafina bloqueParafina = bloqueParafinaServicioImpl.mostrarBloqueParafinaPaciente(idPacientePotencial);

                                if (bloqueParafina != null) {
                                    int numeroBloquesParafina = 0;
                                    try {
                                        numeroBloquesParafina = Integer.parseInt(request.getParameter("numBloques"));
                                        int idBiopsia = biopsiaServicioImpl.mostrarBiopsiaPreviaPaciente(idPacientePotencial, 1).getIdBiopsia();
                                        bloqueParafina.setIdBiopsia(idBiopsia);
                                        bloqueParafina.setCantidad(numeroBloquesParafina);
                                    } catch (Exception ex) {
                                        System.out.println("Exception Bloques de parafina ".concat(ex.getMessage()));
                                    }
                                    System.out.println("Numero de bloques de parafina ".concat(String.valueOf(numeroBloquesParafina)));

                                    String serieBloquesParagina = null;
                                    serieBloquesParagina = request.getParameter("serieBloques");
                                    if (serieBloquesParagina != null) {

                                        System.out.println("Serie bloques parafina ".concat(serieBloquesParagina));
                                        bloqueParafina.setSerie(serieBloquesParagina);
                                    } else {
                                        System.out.println("Sin bloques parafina");
                                    }
                                    bloqueParafinaServicioImpl.actualizarBloqueParafina(bloqueParafina);
                                } else {
                                    int numeroBloquesParafina = 0;
                                    try {
                                        numeroBloquesParafina = Integer.parseInt(request.getParameter("numBloques"));
                                        int idBiopsia = biopsiaServicioImpl.mostrarBiopsiaPreviaPaciente(idPacientePotencial, 1).getIdBiopsia();
                                        bloqueParafina.setIdBiopsia(idBiopsia);
                                        bloqueParafina.setCantidad(numeroBloquesParafina);
                                    } catch (Exception ex) {
                                        System.out.println("Exception Bloques de parafina ".concat(ex.getMessage()));
                                    }
                                    System.out.println("Numero de bloques de parafina ".concat(String.valueOf(numeroBloquesParafina)));

                                    String serieBloquesParagina = null;
                                    serieBloquesParagina = request.getParameter("serieBloques");
                                    if (serieBloquesParagina != null) {

                                        System.out.println("Serie bloques parafina ".concat(serieBloquesParagina));
                                        bloqueParafina.setSerie(serieBloquesParagina);
                                    } else {
                                        System.out.println("Sin bloques parafina");
                                    }
                                    bloqueParafinaServicioImpl.agregarBloqueParafina(bloqueParafina);
                                }
                            }

                            /*
                            //BIOPSIAS                            
                            String biopsias = request.getParameter("biopsias");
                            System.out.println("Biopsias ".concat(biopsias));

                            JsonParser parser = new JsonParser();
                            Object obj = parser.parse(biopsias);
                            JsonArray array = (JsonArray) obj;
                            for (int i = 0; i < array.size(); i++) {
                                System.out.println("JSON " + i);
                                JsonObject json = (JsonObject) array.get(i);
                                System.out.println("json ".concat(json.toString()));
                            }

                            //RAYOS X
                            String rayosxs = request.getParameter("rayosxs");
                            System.out.println("rayosxs ".concat(rayosxs));

                            JsonParser parserRayosxs = new JsonParser();
                            Object objRayosx = parserRayosxs.parse(biopsias);
                            JsonArray arrayRayosx = (JsonArray) objRayosx;
                            for (int i = 0; i < arrayRayosx.size(); i++) {
                                System.out.println("JSON " + i);
                                JsonObject json = (JsonObject) arrayRayosx.get(i);
                                System.out.println("json ".concat(json.toString()));
                            }

                            //Ultrasonidos
                            String ultrasonidos = null;
                            ultrasonidos = request.getParameter("ultrasonidos");
                            System.out.println("ultrasonidos ".concat(ultrasonidos));

                            JsonParser parserUltrasonidos = new JsonParser();
                            Object objUltrasonidos = parserUltrasonidos.parse(ultrasonidos);
                            JsonArray arrayUltrasonidos = (JsonArray) objUltrasonidos;
                            for (int i = 0; i < arrayUltrasonidos.size(); i++) {
                                System.out.println("JSON " + i);
                                JsonObject json = (JsonObject) arrayUltrasonidos.get(i);
                                System.out.println("json ".concat(json.toString()));
                            }

                            //Medicina Nuclear
                            String medicinasNucleares = null;
                            medicinasNucleares = request.getParameter("medicinasNucleares");
                            System.out.println("medicinasNucleares ".concat(medicinasNucleares));

                            JsonParser parserMedicinasNucleares = new JsonParser();
                            Object objMedicinasNucleares = parserMedicinasNucleares.parse(medicinasNucleares);
                            JsonArray arrayMedicinasNucleares = (JsonArray) objMedicinasNucleares;
                            for (int i = 0; i < arrayMedicinasNucleares.size(); i++) {
                                System.out.println("JSON " + i);
                                JsonObject json = (JsonObject) arrayMedicinasNucleares.get(i);
                                System.out.println("json ".concat(json.toString()));
                            }

                            //Laboratorios
                            String laboratorios = null;
                            laboratorios = request.getParameter("laboratorios");
                            System.out.println("laboratorios ".concat(laboratorios));

                            JsonParser parserLaboratorios = new JsonParser();
                            Object objLaboratorios = parserLaboratorios.parse(medicinasNucleares);
                            JsonArray arrayLaboratorios = (JsonArray) objLaboratorios;
                            for (int i = 0; i < arrayLaboratorios.size(); i++) {
                                System.out.println("JSON " + i);
                                JsonObject json = (JsonObject) arrayLaboratorios.get(i);
                                System.out.println("json ".concat(json.toString()));
                            }

                            //Valoraciones
                            String valoraciones = null;
                            valoraciones = request.getParameter("valoraciones");
                            System.out.println("valoraciones ".concat(valoraciones));

                            JsonParser parserValoraciones = new JsonParser();
                            Object objValoraciones = parserValoraciones.parse(valoraciones);
                            JsonArray arrayValoraciones = (JsonArray) objValoraciones;
                            for (int i = 0; i < arrayValoraciones.size(); i++) {
                                System.out.println("JSON " + i);
                                JsonObject json = (JsonObject) arrayValoraciones.get(i);
                                System.out.println("json ".concat(json.toString()));
                            }

                            //Espirometrias
                            String espirometrias = null;
                            espirometrias = request.getParameter("espirometrias");
                            System.out.println("espirometrias ".concat(espirometrias));

                            JsonParser parserEspirometrias = new JsonParser();
                            Object objEspirometrias = parserEspirometrias.parse(espirometrias);
                            JsonArray arrayEspirometrias = (JsonArray) objEspirometrias;
                            for (int i = 0; i < arrayEspirometrias.size(); i++) {
                                System.out.println("JSON " + i);
                                JsonObject json = (JsonObject) arrayEspirometrias.get(i);
                                System.out.println("json ".concat(json.toString()));
                            }

                            //Electrocardiogramas
                            String electrocardiogramas = null;
                            electrocardiogramas = request.getParameter("electrocardiogramas");
                            System.out.println("electrocardiogramas ".concat(electrocardiogramas));

                            JsonParser parserElectrocardiogramas = new JsonParser();
                            Object objElectrocardiogramas = parserElectrocardiogramas.parse(electrocardiogramas);
                            JsonArray arrayElectrocardiogramas = (JsonArray) objElectrocardiogramas;
                            for (int i = 0; i < arrayElectrocardiogramas.size(); i++) {
                                System.out.println("JSON " + i);
                                JsonObject json = (JsonObject) arrayElectrocardiogramas.get(i);
                                System.out.println("json ".concat(json.toString()));
                            }

                            //Ecocardiogramas
                            String ecocardiogramas = null;
                            ecocardiogramas = request.getParameter("ecocardiogramas");
                            System.out.println("ecocardiogramas ".concat(ecocardiogramas));

                            JsonParser parserEcocardiogramas = new JsonParser();
                            Object objEcocardiogramas = parserEcocardiogramas.parse(ecocardiogramas);
                            JsonArray arrayEcocardiogramas = (JsonArray) objEcocardiogramas;
                            for (int i = 0; i < arrayEcocardiogramas.size(); i++) {
                                System.out.println("JSON " + i);
                                JsonObject json = (JsonObject) arrayEcocardiogramas.get(i);
                                System.out.println("json ".concat(json.toString()));
                            }

                            //Trabajos sociales
                            String trabajosSociales = null;
                            trabajosSociales = request.getParameter("trabajosSociales");
                            System.out.println("trabajosSociales ".concat(trabajosSociales));

                            JsonParser parserTrabajosSociales = new JsonParser();
                            Object objTrabajosSociales = parserTrabajosSociales.parse(trabajosSociales);
                            JsonArray arrayTrabajosSociales = (JsonArray) objTrabajosSociales;
                            for (int i = 0; i < arrayTrabajosSociales.size(); i++) {
                                System.out.println("JSON " + i);
                                JsonObject json = (JsonObject) arrayTrabajosSociales.get(i);
                                System.out.println("json ".concat(json.toString()));
                            }

                            //Programas
                            String programas = null;
                            programas = request.getParameter("programas");
                            System.out.println("programas ".concat(programas));

                            JsonParser parserProgramas = new JsonParser();
                            Object objProgramas = parserProgramas.parse(programas);
                            JsonArray arrayProgramas = (JsonArray) objProgramas;
                            for (int i = 0; i < arrayProgramas.size(); i++) {
                                System.out.println("JSON " + i);
                                JsonObject json = (JsonObject) arrayProgramas.get(i);
                                System.out.println("json ".concat(json.toString()));
                            }

                            //Otros Estudios
                            String otrosEstudios = null;
                            otrosEstudios = request.getParameter("otrosEstudios");
                            System.out.println("otrosEstudios ".concat(otrosEstudios));

                            JsonParser parserOtrosEstudios = new JsonParser();
                            Object objOtrosEstudios = parserOtrosEstudios.parse(otrosEstudios);
                            JsonArray arrayOtrosEstudios = (JsonArray) objOtrosEstudios;
                            for (int i = 0; i < arrayOtrosEstudios.size(); i++) {
                                System.out.println("JSON " + i);
                                JsonObject json = (JsonObject) arrayOtrosEstudios.get(i);
                                System.out.println("json ".concat(json.toString()));
                            }

                            //Pantalla 4
                            int pacienteResultados = 0;
                            if (request.getParameterMap().containsKey("resultadosCheckbox")) {
                                pacienteResultados = 1;
                            }
                            System.out.println("pacienteResultados ".concat(String.valueOf(pacienteResultados)));

                            String decisionPreconsulta = null;
                            decisionPreconsulta = request.getParameter("decisionPreconsulta");
                            if (decisionPreconsulta != null && decisionPreconsulta.length() > 0) {
                                System.out.println("Decision Preconsulta ".concat(decisionPreconsulta));
                            } else {
                                System.out.println("Sin decision preconsulta ");
                            }

                            String fechaDecisionPreconsulta = null;
                            fechaDecisionPreconsulta = request.getParameter("fecha-decisionPreconsulta");
                            if (fechaDecisionPreconsulta != null && fechaDecisionPreconsulta.length() > 0) {
                                System.out.println("fechaDecisionPreconsulta ".concat(fechaDecisionPreconsulta));
                            } else {
                                System.out.println("Sin fecha decisión preconsulta");
                            }

                            String nivelSocioeconomico = null;
                            nivelSocioeconomico = request.getParameter("nivelSocioeconomico");
                            if (nivelSocioeconomico != null && nivelSocioeconomico.length() > 0) {
                                System.out.println("Nivel socioeconomico ".concat(nivelSocioeconomico));
                            } else {
                                System.out.println("Sin nivel socioeconomico ");
                            }

                            //Llamadas de la preconsulta
                            int llamadaPaciente = 0;
                            if (request.getParameterMap().containsKey("seLlamo")) {
                                llamadaPaciente = 1;
                            }
                            System.out.println("se Llamo ".concat(String.valueOf(llamadaPaciente)));

                            String llamadas = null;
                            llamadas = request.getParameter("llamadasCita");
                            if (llamadas != null && llamadas.length() > 0) {
                                System.out.println("llamadas ".concat(llamadas));
                            } else {
                                System.out.println("llamadas ");
                            }

                            JsonParser parserLlamadas = new JsonParser();
                            Object objLlamadas = parserLlamadas.parse(llamadas);
                            JsonArray arrayLlamadas = (JsonArray) objLlamadas;
                            for (int i = 0; i < arrayLlamadas.size(); i++) {
                                System.out.println("JSON " + i);
                                JsonObject json = (JsonObject) arrayLlamadas.get(i);
                                System.out.println("json ".concat(json.toString()));
                            }

                            //Comentarios de incidencias
                            String comentariosIncidencias = null;
                            comentariosIncidencias = request.getParameter("comentarios");
                            if (comentariosIncidencias != null && comentariosIncidencias.length() > 0) {
                                System.out.println("Comentarios".concat(comentariosIncidencias));
                            } else {
                                System.out.println("sin comentariosIncidencias ");
                            }

                            //Comentarios Médicos
                            String comentariosMedico = null;
                            comentariosMedico = request.getParameter("comentariosMedico");
                            if (comentariosMedico != null && comentariosMedico.length() > 0) {
                                System.out.println("comentariosMedico ".concat(comentariosMedico));
                            } else {
                                System.out.println("sin comentariosMedico ");
                            }

                            //PANTALLA 5    
                            String etapaClinica = null;
                            etapaClinica = request.getParameter("etapaClinica");
                            if (etapaClinica != null && etapaClinica.length() > 0) {
                                System.out.println("Estapa clinica ".concat(etapaClinica));
                            } else {
                                System.out.println("sin etapaClinica ");
                            }

                            String resultadoMastrografia = null;
                            resultadoMastrografia = request.getParameter("tipoMastografia");
                            if (resultadoMastrografia != null && resultadoMastrografia.length() > 0) {
                                System.out.println("resultadoMastrografia ".concat(resultadoMastrografia));
                            } else {
                                System.out.println("sin resultadoMastrografia ");
                            }

                            String resultadoUltrasonido = null;
                            resultadoUltrasonido = request.getParameter("tipoUSG");
                            if (resultadoUltrasonido != null && resultadoUltrasonido.length() > 0) {
                                System.out.println("resultadoUltrasonido ".concat(resultadoUltrasonido));
                            } else {
                                System.out.println("sin resultadoUltrasonido ");
                            }

                            String tCodificado = null;
                            tCodificado = request.getParameter("tumorPrimarioT");
                            if (tCodificado != null && tCodificado.length() > 0) {
                                System.out.println("T ".concat(tCodificado));
                            } else {
                                System.out.println("sin tCodificado ");
                            }

                            String nCodificado = null;
                            nCodificado = request.getParameter("gangliosN");
                            if (nCodificado != null && nCodificado.length() > 0) {
                                System.out.println("N ".concat(nCodificado));
                            } else {
                                System.out.println("sin nCodificado ");
                            }

                            String mCodificado = null;
                            mCodificado = request.getParameter("metastasisM");
                            if (mCodificado != null && mCodificado.length() > 0) {
                                System.out.println("M ".concat(mCodificado));
                            } else {
                                System.out.println("sin mCodificado ");
                            }

                            String resultadoPatologiaPantalla5 = null;
                            resultadoPatologiaPantalla5 = request.getParameter("resultado-patologia");
                            if (resultadoPatologiaPantalla5 != null && resultadoPatologiaPantalla5.length() > 0) {
                                System.out.println("Resultado resultadoPatologiaPantalla5 ".concat(resultadoPatologiaPantalla5));
                            } else {
                                System.out.println("sin resultadoPatologiaPantalla5 ");
                            }

                            String gradoHistologico = null;
                            gradoHistologico = request.getParameter("grado-histologico");
                            if (gradoHistologico != null && gradoHistologico.length() > 0) {
                                System.out.println("Grado gradoHistologico ".concat(gradoHistologico));
                            } else {
                                System.out.println("sin gradoHistologico ");
                            }

                            String receptorHer2 = null;
                            receptorHer2 = request.getParameter("receptor-her2");
                            if (receptorHer2 != null && receptorHer2.length() > 0) {
                                System.out.println("receptorHer2 ".concat(receptorHer2));
                            } else {
                                System.out.println("sin receptorHer2 ");
                            }

                            String receptorFish = null;
                            receptorFish = request.getParameter("receptor-fish");
                            if (receptorFish != null && receptorFish.length() > 0) {
                                System.out.println("receptorFish ".concat(receptorFish));
                            } else {
                                System.out.println("sin receptorFish ");
                            }

                            String receptorRe = null;
                            receptorRe = request.getParameter("receptor-re");
                            if (receptorRe != null && receptorRe.length() > 0) {
                                System.out.println("receptorRe ".concat(receptorRe));
                            } else {
                                System.out.println("sin receptorRe ");
                            }

                            String receptorRp = null;
                            receptorRp = request.getParameter("receptor-rp");
                            if (receptorRp != null && receptorRp.length() > 0) {
                                System.out.println("receptorRp ".concat(receptorRp));
                            } else {
                                System.out.println("sin etapaClinica ");
                            }

                            String ki67 = null;
                            ki67 = request.getParameter("ki67");
                            if (ki67 != null && ki67.length() > 0) {
                                System.out.println("ki67 ".concat(ki67));
                            } else {
                                System.out.println("sin ki67 ");
                            }

                            
                             */
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
