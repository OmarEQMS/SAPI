/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Base64;
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
import javax.json.Json;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import jdk.nashorn.internal.parser.JSONParser;
import mx.itesm.sapi.bean.diagnostico.RegistroDiagnostico;
import mx.itesm.sapi.bean.gestionPaciente.Cita;
import mx.itesm.sapi.bean.gestionPaciente.CitaEmpleado;
import mx.itesm.sapi.bean.gestionPaciente.ComentarioCita;
import mx.itesm.sapi.bean.gestionPaciente.DocumentoInicial;
import mx.itesm.sapi.bean.gestionPaciente.DocumentoInicialTipoDocumento;
import mx.itesm.sapi.bean.gestionPaciente.EstadoPacientePaciente;
import mx.itesm.sapi.bean.gestionPaciente.LlamadaCita;
import mx.itesm.sapi.bean.gestionPaciente.Paciente;
import mx.itesm.sapi.bean.gestionPaciente.PacienteAlergia;
import mx.itesm.sapi.bean.gestionPaciente.PacienteMedicoTitular;
import mx.itesm.sapi.bean.gestionPaciente.PacienteNavegadora;
import mx.itesm.sapi.bean.gestionPaciente.PacienteNecesidadEspecial;
import mx.itesm.sapi.bean.gestionPaciente.TipoDocumento;
import mx.itesm.sapi.bean.persona.Cuenta;
import mx.itesm.sapi.bean.persona.Direccion;
import mx.itesm.sapi.bean.persona.InformacionGeneralPersona;
import mx.itesm.sapi.bean.persona.Login;
import mx.itesm.sapi.bean.persona.Persona;
import mx.itesm.sapi.bean.persona.Pic;
import mx.itesm.sapi.service.diagnostico.RegistroDiagnosticoServiceImpl;
import mx.itesm.sapi.service.gestionPaciente.CitaEmpleadoServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.CitaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.ComentarioCitaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.DocumentoInicialServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.DocumentoInicialTipoDocumentoServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.EstadoPacientePacienteServiceImpl;
import mx.itesm.sapi.service.gestionPaciente.LlamadaCitaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteAlergiaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteMedicoTitularServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteNavegadoraServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteNecesidadEspecialServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteServiceImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.TipoDocumentoServicioImpl;
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
                            
                            TipoDocumentoServicioImpl tipoDocumentoServicioImpl  = new TipoDocumentoServicioImpl();
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
                        
                        case "btn-save":
                        {
                                  
                            System.out.println("########### Formulario de la navegadora ###########");
                            
                            int idPacientePotencial = 4;
                            int idCuenta = 19;
                            //PANTALLA 1 DEL FORMULARIO
                            
                            String prz = null;
                            prz = request.getParameter("prz-expediente");   
                            if(prz != null && prz.length() > 0)
                            {
                                System.out.println("PRZ ".concat(prz));
                                                                                                                                
                                PacienteServicioImpl pacienteServicioImpl = new PacienteServicioImpl();
                                System.out.println("Se actualizó ".concat(
                                String.valueOf(pacienteServicioImpl.actualizarPrz(idPacientePotencial, prz))));
                                
                            }
                            else{
                                System.out.println("Sin PRZ");
                            }                                
                            
                            int adscritoPresente = 1;
                            if(request.getParameterMap().containsKey("noAdscrito") == true)
                                adscritoPresente = 0;
                            System.out.println("Adscrito Presente ".concat(String.valueOf(adscritoPresente)));
                                                        
                            String tipoPaciente = null;
                                    tipoPaciente = request.getParameter("tipoPaciente");
                            if(tipoPaciente != null && tipoPaciente.length() > 0)          
                            {
                                System.out.println("Tipo Paciente ".concat(tipoPaciente));
                            }
                            else{
                                System.out.println("Sin tipoPacinete");
                            }
                                                        
                            String medicoRadiologo = null;
                                    medicoRadiologo = request.getParameter("medico-radiologo");
                            if(medicoRadiologo != null && medicoRadiologo.length() > 0)
                            {
                                System.out.println("Medico Radiologo ".concat(medicoRadiologo));
                            }
                            else{
                                System.out.println("Sin médico Radiologo");
                            }
                            
                            int radiologoSustituto = 0;
                            if(request.getParameterMap().containsKey("esSustituto") == true);
                                radiologoSustituto = 1;
                            System.out.println("Radiologo Sustituto ".concat(String.valueOf(radiologoSustituto)));
                                
                            
                            String fechaNavegacion = null;
                            fechaNavegacion = request.getParameter("fechaNavegacion");
                            if(fechaNavegacion != null && fechaNavegacion.length() > 0)
                            {
                                System.out.println("Fecha Navegación ".concat(fechaNavegacion));
                            }
                            else{
                                System.out.println("Sin fecha de navegación");
                            }
                            
                            
                            String medicoResidente = null;
                                    medicoResidente = request.getParameter("medico-residente");
                            if(medicoResidente != null && medicoResidente.length() > 0)
                            {
                                System.out.println("Medico Residente ".concat(medicoResidente));
                            }
                            else{
                                System.out.println("sin médico residente");
                            }
                            
                            
                            String fechaPreConsulta = null;
                                    fechaPreConsulta = request.getParameter("fechaConsulta");
                            if(fechaPreConsulta != null && fechaPreConsulta.length() > 0)
                            {
                                System.out.println("Fecha Consulta ".concat(fechaPreConsulta));
                            }
                            else{
                                System.out.println("Sin fecha preconsulta");
                            }
                            
                            
                            String nivelEducativo = null;
                                    nivelEducativo = request.getParameter("nivelEducativo");
                            if(nivelEducativo != null && nivelEducativo.length() > 0)
                            {
                                System.out.println("Nivel educativo ".concat(nivelEducativo));
                            }else
                            {
                                System.out.println("Sin nivel educativo");
                            }
                                                        
                            String alergias = null;
                                    alergias = request.getParameter("alergias");
                            if(alergias != null && alergias.length() > 0)
                            {
                                System.out.println("Alergias: ".concat(alergias));
                            }else
                            {
                                System.out.println("Sin alergias");
                            }
                            
                            String estadoHormonal = null;
                                    estadoHormonal = request.getParameter("estadoHormonal");
                            if(estadoHormonal != null && estadoHormonal.length() > 0)
                            {
                                System.out.println("EstadoHormonal ".concat(estadoHormonal));
                            }else
                            {   
                                System.out.println("Sin estado hormonal");
                            }
                            
                            int tieneSeguroPopular = 0;
                            if(request.getParameterMap().containsKey("tieneSeguroPopular"))
                                tieneSeguroPopular = 1;
                            System.out.println("Tiene seguroPopular ".concat(String.valueOf(tieneSeguroPopular)));
                            
                            
                            String nombreSeguro = null;
                                    nombreSeguro = request.getParameter("tiene-seguro");
                            if(nombreSeguro != null && nombreSeguro.length() > 0)
                            {
                                System.out.println("Nombre seguro ".concat(nombreSeguro));
                            }else
                            {
                                System.out.println("Sin seguro");
                            }
                            
                            
                            String numeroSeguro = null;
                                    numeroSeguro = request.getParameter("numSeguro");
                            
                            if(numeroSeguro != null && numeroSeguro.length() > 0)
                            {
                                System.out.println("Número seguro ".concat(numeroSeguro));
                            }else
                            {
                                System.out.println("Sin número de seguro");
                            }

                                                        
                            int primeraMasto = 0;
                            if(request.getParameterMap().containsKey("primeraMasto"))
                                primeraMasto = 1;
                            System.out.println("Masto antes del INCan ".concat(String.valueOf(primeraMasto)));
                            
                                                        
                            int tieneCirugiaPrevia = 0;
                            if(request.getParameterMap().containsKey("tiene-cirugia"))
                                tieneCirugiaPrevia = 1;
                            System.out.println("Tiene cirugía previa ".concat(String.valueOf(tieneCirugiaPrevia)));
                            
                            
                            
                            String fechaCirugiaPrevia = null;
                                    fechaCirugiaPrevia = request.getParameter("fecha-cirugia");
                            if(fechaCirugiaPrevia != null && fechaCirugiaPrevia.length() > 0)
                            {
                                System.out.println("Fecha Cirugia ".concat(fechaCirugiaPrevia));
                            }else
                            {
                                System.out.println("Sin fecha de cirguía");
                            }
                            
                                                        
                            String nombreCirugiaPrevia = null;
                                    nombreCirugiaPrevia = request.getParameter("cirugia");
                            if(nombreCirugiaPrevia != null && nombreCirugiaPrevia.length() > 0)
                            {
                                System.out.println("Nombre cirguia ".concat(nombreCirugiaPrevia));
                            }else
                            {
                                System.out.println("Sin nombre cirguia previa");
                            }
                            
                            String detalleCirugiaPrevia = null;
                                    detalleCirugiaPrevia = request.getParameter("detalle-cirugia");
                            if(detalleCirugiaPrevia != null && detalleCirugiaPrevia.length() > 0)
                            {
                                System.out.println("Detalle Cirguia ".concat(detalleCirugiaPrevia));
                            }else
                            {
                                System.out.println("Sin detalles de cirguía");
                            }
                                                                                    
                            
                            
                            int tieneQuimioterapiaPrevia = 0;                            
                            if(request.getParameterMap().containsKey("tiene-quimioterapia"))
                                tieneQuimioterapiaPrevia = 1;
                            System.out.println("Quimioterapia Previa ".concat(String.valueOf(tieneQuimioterapiaPrevia)));
                            
                            String fechaQuimioterapiaPrevia = null;
                                    fechaQuimioterapiaPrevia = request.getParameter("fecha-quimioterapia");
                            if(fechaQuimioterapiaPrevia != null && fechaQuimioterapiaPrevia.length() > 0)
                            {
                            System.out.println("Fecha quimioterapia previa ".concat(fechaQuimioterapiaPrevia));
                            }else
                            {
                                System.out.println("Sin fecha  quimio previa");
                            }
                            
                            String nombreQuimioterapiaPrevia = null;
                                    nombreQuimioterapiaPrevia = request.getParameter("quimioterapia");
                            if(nombreQuimioterapiaPrevia != null && nombreQuimioterapiaPrevia.length() > 0)
                            {
                            System.out.println("Nombre de la quimioterapia previa".concat(nombreQuimioterapiaPrevia));
                            }else
                            {
                                System.out.println("Sin quimio previa");
                            }
                                    
                            
                            String detalleQuimioterapiaPrevia = null;
                                    detalleQuimioterapiaPrevia = request.getParameter("detalle-quimioterapia");
                            if(detalleQuimioterapiaPrevia != null && detalleQuimioterapiaPrevia.length() > 0)
                            {
                            System.out.println("Detalle quimioterapia previa ".concat(detalleQuimioterapiaPrevia));
                            }else
                            {
                                System.out.println("Sin detalles quimio previa");
                            }
                            
                            
                            
                            int tieneRadioterapiaPrevia = 0;
                            if(request.getParameterMap().containsKey("tiene-radioterapia"))
                                tieneRadioterapiaPrevia = 1;
                            System.out.println("Radioterapia previa ".concat(String.valueOf(tieneRadioterapiaPrevia)));
                            
                            String fechaRadioterapiaPrevia = null;
                                    fechaRadioterapiaPrevia = request.getParameter("fecha-radioterapia");
                            if(fechaRadioterapiaPrevia != null && fechaRadioterapiaPrevia.length() > 0)
                            {
                                System.out.println("Fecha de radioterapia ".concat(fechaRadioterapiaPrevia));
                            }else
                            {
                                System.out.println("Sin fecha radio previa");
                            }
                            
                            
                            String nombreRadioterapiaPrevia = null;
                                    nombreRadioterapiaPrevia = request.getParameter("radioterapia");
                            if(nombreRadioterapiaPrevia != null && nombreRadioterapiaPrevia.length() > 0)
                            {
                                System.out.println("Nombre radioterapia ".concat(nombreRadioterapiaPrevia));
                            }else
                            {
                                System.out.println("sin nombreRadioterapiaPrevia");
                            }
                            
                            String detalleRadioterapiaPrevia = null;
                                    detalleRadioterapiaPrevia = request.getParameter("detalle-radioterapia");
                            if(detalleRadioterapiaPrevia != null && detalleRadioterapiaPrevia.length() > 0)
                            {
                            System.out.println("Detalle radioterapia ".concat(detalleRadioterapiaPrevia));
                            }else{
                                System.out.println("Sin detalle radio previa");
                            }
                            
                            
                            
                            int tieneMastografiaPrevia = 0;
                            if(request.getParameterMap().containsKey("tiene-mastografia"))
                                tieneMastografiaPrevia = 1;
                            System.out.println("Mastografia previa ".concat(String.valueOf(tieneMastografiaPrevia)));
                            
                            String tipoMastografiaPrevia = null;
                                    tipoMastografiaPrevia = request.getParameter("tipoMastografia");
                            if(tipoMastografiaPrevia != null && tipoMastografiaPrevia.length() > 0)
                            {
                                System.out.println("Tipo Mastrografia previa ".concat(tipoMastografiaPrevia));
                            }else
                            {
                                System.out.println("Sin masto previa");
                            }
                            
                            
                            String fechaMastografiaPrevia = null;
                            fechaMastografiaPrevia = request.getParameter("fechaPreMasto");
                            if(fechaMastografiaPrevia != null && fechaMastografiaPrevia.length() > 0)
                            {
                            System.out.println("Fecha mastografia previa ".concat(fechaMastografiaPrevia));
                            }else
                            {
                                System.out.println(" SIN Fecha mastografia previa ");
                            }
                            
                            
                            
                            int tieneUltrasonidoPrevio = 0;
                            if(request.getParameterMap().containsKey("tiene-ultrasonido-mama"))
                                tieneUltrasonidoPrevio = 1;
                            System.out.println("Ultrasonido previo ".concat(String.valueOf(tieneUltrasonidoPrevio)));
                            
                            String tipoUltrasonidoPrevio = null;
                            tipoUltrasonidoPrevio = request.getParameter("tipoUltrasonidoMama");
                            if(tipoUltrasonidoPrevio != null && tipoUltrasonidoPrevio.length() > 0)
                            {
                               System.out.println("Tipo ultrasonido ".concat(tipoUltrasonidoPrevio)); 
                            }else
                            {
                                System.out.println("Sin tipo ultrasonido");
                            }
                            
                            String fechaUltrasonidoPrevio = null;
                                    fechaUltrasonidoPrevio = request.getParameter("fechaPreUsg");
                            if(fechaUltrasonidoPrevio != null && fechaUltrasonidoPrevio.length() > 0)
                            {
                            System.out.println("Fecha ultrasonido previo ".concat(fechaUltrasonidoPrevio));
                            }else
                            {
                                System.out.println("Sin fecha ultrasonido previo");
                            }
                            
                            
                            
                            
                            String resultadoPatologia = null;
                                    resultadoPatologia = request.getParameter("resultadoAnterior-patologia");
                            if(resultadoPatologia != null && resultadoPatologia.length() > 0)
                            {
                                System.out.println("Resultado de patología ".concat(resultadoPatologia));
                            }else
                            {
                                System.out.println("Sin resultados de patología");
                            }
                            
                            
                            
                            
                            String otroReportePatologia = null;
                                    otroReportePatologia = request.getParameter("introducirOtroResultadoPatologia");
                            if(otroReportePatologia != null && otroReportePatologia.length() > 0)
                            {
                            System.out.println("Otro resultado de patlogía".concat(otroReportePatologia));
                            }else
                            {
                                System.out.println("Sin otro resultado patología");
                            }
                            
                            
                            
                            
                            
                            
                            int entregaLaminillas = 0;
                            if(request.getParameterMap().containsKey("entregaLaminillas"))
                                entregaLaminillas = 1;
                            System.out.println("Laminillas ".concat(String.valueOf(entregaLaminillas)));
                            
                            
                            int numeroLaminillas = 0;
                            try{
                                numeroLaminillas = Integer.parseInt(request.getParameter("numLaminillas"));
                            }catch(Exception ex)
                            {
                                System.out.println("Exception Número laminillas ".concat(ex.getMessage()));
                            }
                            System.out.println("Numero de laminillas ".concat(String.valueOf(numeroLaminillas)));                            
                            
                            
                            String serieLaminillas = null;
                                    serieLaminillas = request.getParameter("serieLaminillas");
                            if(serieLaminillas != null && serieLaminillas.length() > 0)
                            {
                                System.out.println("Serie laminillas ".concat(serieLaminillas));
                            }else
                            {
                                System.out.println("Sin serie laminillas");
                            }
                            
                            
                            
                            int entregaBloquesParafina = 0;
                            if(request.getParameterMap().containsKey("entregaBloques"))
                                entregaBloquesParafina = 1;
                            System.out.println("Bloques parafina ".concat(String.valueOf(entregaBloquesParafina)));
                                                        
                            int numeroBloquesParafina = 0;
                            try
                            {
                                numeroBloquesParafina = Integer.parseInt(request.getParameter("numBloques"));
                            }
                            catch(Exception ex)
                            {
                                System.out.println("Exception Bloques de parafina ".concat(ex.getMessage()));
                            }
                            System.out.println("Numero de bloques de parafina ".concat(String.valueOf(numeroBloquesParafina)));
                            
                            String serieBloquesParagina = null;
                                    serieBloquesParagina = request.getParameter("serieBloques");
                            if(serieBloquesParagina != null && serieBloquesParagina.length() > 0)
                            {
                            System.out.println("Serie bloques parafina ".concat(serieBloquesParagina));
                            }else
                            {
                                System.out.println("Sin bloques parafina");
                            }
                             
                                                        
                            //BIOPSIAS                            
                            String biopsias = request.getParameter("biopsias");
                            System.out.println("Biopsias ".concat(biopsias));
                            
                                                        
                            JsonParser parser = new JsonParser();
                            Object obj = parser.parse(biopsias);
                            JsonArray array = (JsonArray) obj;
                            for(int i = 0; i < array.size(); i++)
                            {
                                System.out.println("JSON "+i);
                                JsonObject json = (JsonObject) array.get(i);
                                System.out.println("json ".concat(json.toString()));
                            }
                            
                            
                            //RAYOS X
                            String rayosxs = request.getParameter("rayosxs");
                            System.out.println("rayosxs ".concat(rayosxs));
                            
                                                        
                            JsonParser parserRayosxs = new JsonParser();
                            Object objRayosx = parserRayosxs.parse(biopsias);
                            JsonArray arrayRayosx = (JsonArray) objRayosx;
                            for(int i = 0; i < arrayRayosx.size(); i++)
                            {
                                System.out.println("JSON "+i);
                                JsonObject json = (JsonObject) arrayRayosx.get(i);
                                System.out.println("json ".concat(json.toString()));
                            }
                            
                            
                            //Ultrasonidos
                            String ultrasonidos = null;
                            ultrasonidos  = request.getParameter("ultrasonidos");
                            System.out.println("ultrasonidos ".concat(ultrasonidos));
                            
                                                        
                            JsonParser parserUltrasonidos = new JsonParser();
                            Object objUltrasonidos = parserUltrasonidos.parse(ultrasonidos);
                            JsonArray arrayUltrasonidos = (JsonArray) objUltrasonidos;
                            for(int i = 0; i < arrayUltrasonidos.size(); i++)
                            {
                                System.out.println("JSON "+i);
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
                            for(int i = 0; i < arrayMedicinasNucleares.size(); i++)
                            {
                                System.out.println("JSON "+i);
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
                            for(int i = 0; i < arrayLaboratorios.size(); i++)
                            {
                                System.out.println("JSON "+i);
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
                            for(int i = 0; i < arrayValoraciones.size(); i++)
                            {
                                System.out.println("JSON "+i);
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
                            for(int i = 0; i < arrayEspirometrias.size(); i++)
                            {
                                System.out.println("JSON "+i);
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
                            for(int i = 0; i < arrayElectrocardiogramas.size(); i++)
                            {
                                System.out.println("JSON "+i);
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
                            for(int i = 0; i < arrayEcocardiogramas.size(); i++)
                            {
                                System.out.println("JSON "+i);
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
                            for(int i = 0; i < arrayTrabajosSociales.size(); i++)
                            {
                                System.out.println("JSON "+i);
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
                            for(int i = 0; i < arrayProgramas.size(); i++)
                            {
                                System.out.println("JSON "+i);
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
                            for(int i = 0; i < arrayOtrosEstudios.size(); i++)
                            {
                                System.out.println("JSON "+i);
                                JsonObject json = (JsonObject) arrayOtrosEstudios.get(i);
                                System.out.println("json ".concat(json.toString()));
                            } 
                            
                            //Pantalla 4
                            
                            int pacienteResultados = 0;
                            if(request.getParameterMap().containsKey("resultadosCheckbox"))
                                pacienteResultados = 1;
                            System.out.println("pacienteResultados ".concat(String.valueOf(pacienteResultados)));
                            
                            
                            
                            String decisionPreconsulta = null;
                            decisionPreconsulta = request.getParameter("decisionPreconsulta");
                            if(decisionPreconsulta != null && decisionPreconsulta.length() > 0)
                            {
                                System.out.println("Decision Preconsulta ".concat(decisionPreconsulta));
                            }else
                            {
                                System.out.println("Sin decision preconsulta ");
                            }
                            
                            
                            
                            String fechaDecisionPreconsulta = null;
                            fechaDecisionPreconsulta = request.getParameter("fecha-decisionPreconsulta");
                            if(fechaDecisionPreconsulta != null && fechaDecisionPreconsulta.length() > 0)
                            {
                                System.out.println("fechaDecisionPreconsulta ".concat(fechaDecisionPreconsulta));
                            }else
                            {
                                System.out.println("Sin fecha decisión preconsulta");
                            }
                                   
                            
                            String nivelSocioeconomico = null;
                            nivelSocioeconomico = request.getParameter("nivelSocioeconomico");
                            if(nivelSocioeconomico != null && nivelSocioeconomico.length() > 0)
                            {
                                System.out.println("Nivel socioeconomico ".concat(nivelSocioeconomico));
                            }else
                            {
                                System.out.println("Sin nivel socioeconomico ");
                            }                            
                            
                            
                            //Llamadas de la preconsulta
                            
                            int llamadaPaciente = 0;
                            if(request.getParameterMap().containsKey("seLlamo"))
                                llamadaPaciente = 1;
                            System.out.println("se Llamo ".concat(String.valueOf(llamadaPaciente)));
                            
                                                                                    
                            String llamadas = null;
                            llamadas = request.getParameter("llamadasCita");
                            if(llamadas != null && llamadas.length() > 0)
                            {
                                System.out.println("llamadas ".concat(llamadas));
                            }else
                            {
                                System.out.println("llamadas ");
                            }             
                            
                            
                                                        
                            JsonParser parserLlamadas = new JsonParser();
                            Object objLlamadas = parserLlamadas.parse(llamadas);
                            JsonArray arrayLlamadas = (JsonArray) objLlamadas;
                            for(int i = 0; i < arrayLlamadas.size(); i++)
                            {
                                System.out.println("JSON "+i);
                                JsonObject json = (JsonObject) arrayLlamadas.get(i);
                                System.out.println("json ".concat(json.toString()));
                            }
                            
                            
                            //Comentarios de incidencias
                            String comentariosIncidencias = null;
                            comentariosIncidencias = request.getParameter("comentarios");
                             if(comentariosIncidencias != null && comentariosIncidencias.length() > 0)
                            {
                                System.out.println("Comentarios".concat(comentariosIncidencias));
                            }else
                            {
                                System.out.println("sin comentariosIncidencias ");
                            }                                      
                            
                            
                            //Comentarios Médicos
                            String comentariosMedico = null;
                            comentariosMedico = request.getParameter("comentariosMedico");
                             if(comentariosMedico != null && comentariosMedico.length() > 0)
                            {
                                System.out.println("comentariosMedico ".concat(comentariosMedico));
                            }else
                            {
                                System.out.println("sin comentariosMedico ");
                            }                                       
                            
                            
                            
                            //PANTALLA 5    
                            String etapaClinica = null;
                            etapaClinica = request.getParameter("etapaClinica");
                             if(etapaClinica != null && etapaClinica.length() > 0)
                            {
                                System.out.println("Estapa clinica ".concat(etapaClinica));
                            }else
                            {
                                System.out.println("sin etapaClinica ");
                            }        
                                                         
                            
                            String resultadoMastrografia = null;
                            resultadoMastrografia = request.getParameter("tipoMastografia");
                             if(resultadoMastrografia != null && resultadoMastrografia.length() > 0)
                            {
                                System.out.println("resultadoMastrografia ".concat(resultadoMastrografia));
                            }else
                            {
                                System.out.println("sin resultadoMastrografia ");
                            }      
                            
                            
                            String resultadoUltrasonido = null;
                            resultadoUltrasonido = request.getParameter("tipoUSG");
                             if(resultadoUltrasonido != null && resultadoUltrasonido.length() > 0)
                            {
                                System.out.println("resultadoUltrasonido ".concat(resultadoUltrasonido));
                            }else
                            {
                                System.out.println("sin resultadoUltrasonido ");
                            }      
                            
                            
                            String tCodificado = null;
                            tCodificado = request.getParameter("tumorPrimarioT");
                             if(tCodificado != null && tCodificado.length() > 0)
                            {
                                System.out.println("T ".concat(tCodificado));
                            }else
                            {
                                System.out.println("sin tCodificado ");
                            }      
                            
                            
                            String nCodificado = null;
                            nCodificado = request.getParameter("gangliosN");
                             if(nCodificado != null && nCodificado.length() > 0)
                            {
                                System.out.println("N ".concat(nCodificado));
                            }else
                            {
                                System.out.println("sin nCodificado ");
                            }      
                            
                            
                            String mCodificado = null;
                            mCodificado = request.getParameter("metastasisM");
                             if(mCodificado != null && mCodificado.length() > 0)
                            {
                                System.out.println("M ".concat(mCodificado));
                            }else
                            {
                                System.out.println("sin mCodificado ");
                            }      
                             
                            
                            String resultadoPatologiaPantalla5 = null;
                            resultadoPatologiaPantalla5 = request.getParameter("resultado-patologia");
                             if(resultadoPatologiaPantalla5 != null && resultadoPatologiaPantalla5.length() > 0)
                            {
                                System.out.println("Resultado resultadoPatologiaPantalla5 ".concat(resultadoPatologiaPantalla5));
                            }else
                            {
                                System.out.println("sin resultadoPatologiaPantalla5 ");
                            }      
                            
                            
                            String gradoHistologico = null;
                            gradoHistologico = request.getParameter("grado-histologico");
                             if(gradoHistologico != null && gradoHistologico.length() > 0)
                            {
                                System.out.println("Grado gradoHistologico ".concat(gradoHistologico));
                            }else
                            {
                                System.out.println("sin gradoHistologico ");
                            }      
                            
                            
                            String receptorHer2 = null;
                            receptorHer2 = request.getParameter("receptor-her2");
                             if(receptorHer2 != null && receptorHer2.length() > 0)
                            {
                                System.out.println("receptorHer2 ".concat(receptorHer2));
                            }else
                            {
                                System.out.println("sin receptorHer2 ");
                            }      
                            
                            
                            String receptorFish = null;
                            receptorFish = request.getParameter("receptor-fish");
                             if(receptorFish != null && receptorFish.length() > 0)
                            {
                                System.out.println("receptorFish ".concat(receptorFish));
                            }else
                            {
                                System.out.println("sin receptorFish ");
                            }      
                            
                            
                            String receptorRe = null;
                            receptorRe = request.getParameter("receptor-re");
                             if(receptorRe != null && receptorRe.length() > 0)
                            {
                                System.out.println("receptorRe ".concat(receptorRe));
                            }else
                            {
                                System.out.println("sin receptorRe ");
                            }      
                            
                            
                            String receptorRp = null;
                            receptorRp = request.getParameter("receptor-rp");
                             if(receptorRp != null && receptorRp.length() > 0)
                            {
                                System.out.println("receptorRp ".concat(receptorRp));
                            }else
                            {
                                System.out.println("sin etapaClinica ");
                            }      
                            
                            
                            String ki67 = null;
                            ki67 = request.getParameter("ki67");
                             if(ki67 != null && ki67.length() > 0)
                            {
                                System.out.println("ki67 ".concat(ki67));
                            }else
                            {
                                System.out.println("sin ki67 ");
                            }                                  
                                                        
                                                                                    
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
