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
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Base64;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

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
import mx.itesm.sapi.bean.diagnostico.RegistroDiagnostico;
import mx.itesm.sapi.bean.formulario.EstudioFormulario;
import mx.itesm.sapi.bean.formulario.LlamadaPaciente;
import mx.itesm.sapi.bean.gestionPaciente.Biopsia;
import mx.itesm.sapi.bean.gestionPaciente.BloqueParafina;
import mx.itesm.sapi.bean.formulario.MFormularioGeneral;
import mx.itesm.sapi.bean.formulario.ReporteNavegadora;
import mx.itesm.sapi.bean.calendario.FullCalendar;
import mx.itesm.sapi.bean.calendario.MCalendarioNavegadora;
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
import mx.itesm.sapi.bean.gestionPaciente.LugarDelCuerpo;
import mx.itesm.sapi.bean.gestionPaciente.OtroResultadoPatologia;

import mx.itesm.sapi.bean.gestionPaciente.Paciente;
import mx.itesm.sapi.bean.gestionPaciente.PacienteAlergia;
import mx.itesm.sapi.bean.gestionPaciente.PacienteMedicoTitular;
import mx.itesm.sapi.bean.gestionPaciente.PacienteSeguro;
import mx.itesm.sapi.bean.gestionPaciente.ProgramaPaciente;
import mx.itesm.sapi.bean.gestionPaciente.TipoBiopsia;
import mx.itesm.sapi.bean.gestionTratamiento.PacienteTratamientoPrevio;
import mx.itesm.sapi.bean.moduloGestionMedico.Empleado;

import mx.itesm.sapi.bean.persona.Cuenta;
import mx.itesm.sapi.bean.persona.Direccion;
import mx.itesm.sapi.bean.persona.InformacionGeneralPersona;
import mx.itesm.sapi.bean.persona.Login;
import mx.itesm.sapi.bean.persona.Persona;
import mx.itesm.sapi.bean.persona.Pic;

import mx.itesm.sapi.service.EstudioFormularioServicioImpl;
import mx.itesm.sapi.service.diagnostico.EstadiajeTNMServiceImpl;
import mx.itesm.sapi.service.diagnostico.RegistroDiagnosticoServiceImpl;
import mx.itesm.sapi.service.gestionPaciente.BiopsiaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.BloqueParafinaServicioImpl;
import mx.itesm.sapi.service.MFormularioGeneralServicioImpl;
import mx.itesm.sapi.service.ReporteNavegadoraServicioImpl;
import mx.itesm.sapi.service.CalendarioServicioImpl;
import mx.itesm.sapi.service.MCalendarioNavegadoraServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.CategoriaEstudioServicioImpl;
import mx.itesm.sapi.service.MFormularioGeneralServicioImpl;
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
import mx.itesm.sapi.service.gestionPaciente.Ki67ServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.LaminillaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.LlamadaCitaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.LugarDelCuerpoServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.OtroResultadoPatologiaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteAlergiaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteMedicoTitularServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteSeguroServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.ProgramaPacienteServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.TipoBiopsiaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.TipoDocumentoServicioImpl;
import mx.itesm.sapi.service.gestionTratamiento.PacienteTratamientoPrevioServiceImpl;
import mx.itesm.sapi.service.moduloGestionMedico.EmpleadoServicioImpl;

import mx.itesm.sapi.service.persona.CuentaServicioImpl;
import mx.itesm.sapi.service.persona.DireccionServicioImpl;
import mx.itesm.sapi.service.persona.LoginServicioImpl;
import mx.itesm.sapi.service.persona.PersonaServicioImpl;
import mx.itesm.sapi.service.persona.PicServicioImpl;

import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

import org.apache.commons.io.IOUtils;

/**
 *
 * @author Admin
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50)

@WebServlet(name = "NavegadoraController", urlPatterns = {"/NavegadoraController"})
public class NavegadoraController extends HttpServlet {

    private static final ResourceBundle sapiProperties = ResourceBundle.getBundle("mx.itesm.sapi.properties.catalogos");

    ;
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
        request.setCharacterEncoding("UTF-8");

        String key = request.getParameter("key");

        HttpSession sesion = request.getSession(true);

        //COMENTARIO PARA COMMIT: TEAM LUGO ORDUÑA <3
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

                    System.out.println("LA KEY ES " + key);
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

                            int pacientePotencial = (int) sesion.getAttribute("idPacienteAtendido");

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
                        case "mostrarFormularioNavegadora": {

                            int idPaciente;
                            try {
                                idPaciente = (int) sesion.getAttribute("idPacientePotencialForm");
                            } catch (Exception ex) {
                                idPaciente = 0;
                                System.out.println("Sin paaciente para atender aún");
                            }

                            if (idPaciente != 0 && sesion.getAttribute("path") != null) {

                                PersonaServicioImpl personaServicioImpl = new PersonaServicioImpl();
                                Persona personaNombre = personaServicioImpl.mostrarPersonaPorIdPaciente(idPaciente);
                                System.out.println("LA PERSONA ESSSS:" + personaNombre);

                                sesion.setAttribute("nombrePaciente", personaNombre.getNombre());
                                sesion.setAttribute("apellido1Paciente", personaNombre.getPrimerApellido());
                                sesion.setAttribute("apellido2Paciente", personaNombre.getSegundoApellido());

                                System.out.println(sesion.getAttribute("nombrePaciente"));
                                System.out.println(sesion.getAttribute("apellido1Paciente"));
                                System.out.println(sesion.getAttribute("apellido2Paciente"));

                                System.out.println("EL id paciente es: " + idPaciente);

                                ArrayList<MFormularioGeneral> formGeneralList = new ArrayList<>();
                                
                                ArrayList<ArrayList<MFormularioGeneral>> ElJeison = new ArrayList<>();
                               
                                MFormularioGeneralServicioImpl mFormularioGeneralServicioImpl = new MFormularioGeneralServicioImpl();
                                MFormularioGeneral formGeneral = mFormularioGeneralServicioImpl.mostrarFormularioGeneralNavegadora(idPaciente);
                                // System.out.println(formGeneral.getFechaConsulta());
                                 System.out.println(formGeneral.getMedicoAdscrito());
                                if (formGeneral.getMedicoAdscrito() == null) {
                                    formGeneral.setMedicoAdscrito("");
                                }
                                if (formGeneral.getMedicoRadiologo() == null) {
                                    formGeneral.setMedicoRadiologo("");
                                }
                                if (formGeneral.getPrz() == null) {
                                    formGeneral.setPrz("");
                                }
                                if (formGeneral.getFechaNavegacion() == null) {
                                    formGeneral.setFechaNavegacion(Date.valueOf("1900-01-01"));
                                }
                                if (formGeneral.getFechaConsulta() == null) {
                                    formGeneral.setFechaConsulta(Date.valueOf("1900-01-01"));
                                }
                                if (formGeneral.getMedicoResidente() == null) {
                                    formGeneral.setMedicoResidente("");
                                }
                                if (formGeneral.getEscolaridad() == null) {
                                    formGeneral.setEscolaridad("");
                                }
                                // else{formGeneral.setEscolaridad(formGeneral.getEscolaridad().concat(" "));}
                                if (formGeneral.getAlergias() == null) {
                                    formGeneral.setAlergias("");
                                }
                                if (formGeneral.getSeguro() == null) {
                                    formGeneral.setSeguro("");
                                }
                                if (formGeneral.getNoSeguro() == null) {
                                    formGeneral.setNoSeguro("");
                                }
                                if (formGeneral.getCirugiaFecha() == null) {
                                    formGeneral.setCirugiaFecha(Date.valueOf("1900-01-01"));
                                }
                                if (formGeneral.getCirugiaTipo() == null) {
                                    formGeneral.setCirugiaTipo("");
                                }
                                if (formGeneral.getCirugiaComentario() == null) {
                                    formGeneral.setCirugiaComentario("");
                                }
                                if (formGeneral.getQuimioterapiaFecha() == null) {
                                    formGeneral.setQuimioterapiaFecha(Date.valueOf("1900-01-01"));
                                }
                                if (formGeneral.getQuimioterapiaCiclo() <= 0) {
                                    formGeneral.setQuimioterapiaCiclo(-1);
                                }
                                if (formGeneral.getQuimioterapiaComentario() == null) {
                                    formGeneral.setQuimioterapiaComentario("");
                                }
                                if (formGeneral.getRadioterapiaFecha() == null) {
                                    formGeneral.setRadioterapiaFecha(Date.valueOf("1900-01-01"));
                                }
                                if (formGeneral.getRadioterapiaCiclo() <= 0) {
                                    formGeneral.setRadioterapiaCiclo(-1);
                                }
                                if (formGeneral.getRadioterapiaComentario() == null) {
                                    formGeneral.setRadioterapiaComentario("");
                                }
                                if (formGeneral.getMastografiaBiradsNombre() == null) {
                                    formGeneral.setMastografiaBiradsNombre("");
                                }
                                if (formGeneral.getMastografiaBiradsFecha() == null) {
                                    formGeneral.setMastografiaBiradsFecha(Date.valueOf("1900-01-01"));
                                }
                                if (formGeneral.getUltrasonidoBiradsNombre() == null) {
                                    formGeneral.setUltrasonidoBiradsNombre("");
                                }
                                if (formGeneral.getUltrasonidoBiradsFecha() == null) {
                                    formGeneral.setUltrasonidoBiradsFecha(Date.valueOf("1900-01-01"));
                                }
                                if (formGeneral.getResultadoPatologia() == null) {
                                    formGeneral.setResultadoPatologia("");
                                }
                                if (formGeneral.getOtroResultado() == null) {
                                    formGeneral.setOtroResultado("");
                                }
                                if (formGeneral.getSerieParafina() == null) {
                                    formGeneral.setSerieParafina("");
                                }
                                if (formGeneral.getCantidadParafina() <= 0) {
                                    formGeneral.setCantidadParafina(-1);
                                }
                                if (formGeneral.getSerieLaminillas() == null) {
                                    formGeneral.setSerieLaminillas("");
                                }
                                if (formGeneral.getCantidadLaminillas() <= 0) {
                                    formGeneral.setCantidadLaminillas(-1);
                                }
                                if (formGeneral.getT() == null) {
                                    formGeneral.setT("");
                                }
                                if (formGeneral.getN() == null) {
                                    formGeneral.setN("");
                                }
                                if (formGeneral.getM() == null) {
                                    formGeneral.setM("");
                                }
                                if (formGeneral.getFechaFin() == null) {
                                    formGeneral.setFechaFin(Date.valueOf("1900-01-01"));
                                }
                                if (formGeneral.getDecisionCosulta() == null) {
                                    formGeneral.setDecisionCosulta("");
                                }
                                if (formGeneral.getSocioeconomico() == null) {
                                    formGeneral.setSocioeconomico("");
                                }
                                if (formGeneral.getComentarioIncidencia() == null) {
                                    formGeneral.setComentarioIncidencia("");
                                }
                                if (formGeneral.getComentarioMedico() == null) {
                                    formGeneral.setComentarioMedico("");
                                }
                                if (formGeneral.getEtapaClinica() == null) {
                                    formGeneral.setEtapaClinica("");
                                }
                                if (formGeneral.getMasto() == null) {
                                    formGeneral.setMasto("");
                                }
                                if (formGeneral.getUltra() == null) {
                                    formGeneral.setUltra("");
                                }
                                if (formGeneral.getRp() == null) {
                                    formGeneral.setRp("");
                                }
                                if (formGeneral.getRe() == null) {
                                    formGeneral.setRe("");
                                }
                                if (formGeneral.getHer2() == null) {
                                    formGeneral.setHer2("");
                                }
                                if (formGeneral.getFish() == null) {
                                    formGeneral.setFish("");
                                }
                                if (formGeneral.getKi67() == null) {
                                    formGeneral.setKi67("");
                                }
                                if (formGeneral.getGradoH() == null) {
                                    formGeneral.setGradoH("");
                                }
                                if (formGeneral.getResultadoPatologiaPost() == null) {
                                    formGeneral.setResultadoPatologiaPost("");
                                }
                                if(formGeneral.getOtroResultadoPost() == null){
                                    formGeneral.setOtroResultadoPost("");
                                }

                                formGeneralList.add(formGeneral);
                                ElJeison.add(formGeneralList);

                                ArrayList<MFormularioGeneral> formBiopsia = mFormularioGeneralServicioImpl.mostrarFormularioLugarTipoFecha(idPaciente, "Biopsia");
                                ElJeison.add(formBiopsia);

                                ArrayList<MFormularioGeneral> formRayoX = mFormularioGeneralServicioImpl.mostrarFormularioFechaTipo(idPaciente, "Rayos X");
                                ElJeison.add(formRayoX);

                                ArrayList<MFormularioGeneral> formUltraSonido = mFormularioGeneralServicioImpl.mostrarFormularioLugarFecha(idPaciente, "Ultrasonido");
                                ElJeison.add(formUltraSonido);

                                ArrayList<MFormularioGeneral> formMedicinaNuclear = mFormularioGeneralServicioImpl.mostrarFormularioFechaTipo(idPaciente, "Medicina nuclear");
                                ElJeison.add(formMedicinaNuclear);
                                ArrayList<MFormularioGeneral> formLaboratorio = mFormularioGeneralServicioImpl.mostrarFormularioFecha(idPaciente, "Laboratorios");
                                ElJeison.add(formLaboratorio);
                                ArrayList<MFormularioGeneral> formValoracion = mFormularioGeneralServicioImpl.mostrarFormularioFechaTipo(idPaciente, "Valoración");
                                ElJeison.add(formValoracion);
                                ArrayList<MFormularioGeneral> formEspiro = mFormularioGeneralServicioImpl.mostrarFormularioFecha(idPaciente, "Espirometría/Inhaloterapia");
                                ElJeison.add(formEspiro);
                                ArrayList<MFormularioGeneral> formElectro = mFormularioGeneralServicioImpl.mostrarFormularioFecha(idPaciente, "Electrocardiograma");
                                ElJeison.add(formElectro);
                                ArrayList<MFormularioGeneral> formEcocardio = mFormularioGeneralServicioImpl.mostrarFormularioFecha(idPaciente, "Ecocardiograma");
                                ElJeison.add(formEcocardio);
                                ArrayList<MFormularioGeneral> formTrabajoSocial = mFormularioGeneralServicioImpl.mostrarFormularioFecha(idPaciente, "Trabajo social");
                                ElJeison.add(formTrabajoSocial);
                                ArrayList<MFormularioGeneral> formProgramas = mFormularioGeneralServicioImpl.mostrarFormularioFechaTipo(idPaciente, "Programas");
                                ElJeison.add(formProgramas);
                                ArrayList<MFormularioGeneral> formOtros = mFormularioGeneralServicioImpl.mostrarFormularioFechaTipo(idPaciente, "Otros");
                                ElJeison.add(formOtros);

                                ArrayList<MFormularioGeneral> formLlamada = mFormularioGeneralServicioImpl.mostrarFormularioNavegadoraLLamada(idPaciente);
                                ElJeison.add(formLlamada);

                                PrintWriter out = response.getWriter();
                                Gson json = new Gson();
                                System.out.println(json);
                                System.out.println(ElJeison);

                                out.print(json.toJson(ElJeison));
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
                            String fechaNav = request.getParameter("fechaNavegacion").concat(" 07:50:00");
                            String fechaCon = request.getParameter("fechaConsulta").concat(" 07:50:00");
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
                            int idPacientePotencial = (int) sesion.getAttribute("idPacientePotencialForm");;
                            int idNavegadora = (int) sesion.getAttribute("idEmpleadoNavegadora");//Navegadora

                            System.out.println("Paciente " + idPacientePotencial);
                            System.out.println("Navegadora " + idNavegadora);

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

                            ProgramaPacienteServicioImpl programaPacienteServicioImpl = new ProgramaPacienteServicioImpl();
                            ProgramaPaciente programaPaciente = new ProgramaPaciente();

                            LlamadaCitaServicioImpl LlamadaCitaServicioImpl = new LlamadaCitaServicioImpl();
                            LlamadaCita llamadaCita = new LlamadaCita();

                            ComentarioCitaServicioImpl comentarioCitaServicioImpl = new ComentarioCitaServicioImpl();

                            EstadiajeTNMServiceImpl estadiajeTNMServiceImpl = new EstadiajeTNMServiceImpl();
                            EstadiajeTNM estadiajeTNM = new EstadiajeTNM();

                            OtroResultadoPatologiaServicioImpl otroResultadoServicio = new OtroResultadoPatologiaServicioImpl();

                            //SERVICIOS DE OMAR//
                            EstudioServicioImpl estudioServicio = new EstudioServicioImpl();
                            Estudio estudio = new Estudio();

                            DocumentoEstudioServicioImpl documentoEstudioServicio = new DocumentoEstudioServicioImpl();
                            DocumentoEstudio documentoEstudio = new DocumentoEstudio();

                            LugarDelCuerpoServicioImpl lugarDelCuerpoServicio = new LugarDelCuerpoServicioImpl();
                            LugarDelCuerpo lugarDelCuerpo = new LugarDelCuerpo();

                            CategoriaEstudioServicioImpl categoriaEstudioServicio = new CategoriaEstudioServicioImpl();
                            CategoriaEstudio categoriaEstudio = new CategoriaEstudio();

                            CitaServicioImpl citaServicio = new CitaServicioImpl();

                            //FIN DE SERVICIOS DE OMAR
                            //Apartado para registrar interacción navegadora con Paciente
                            PacienteNavegadoraServicioImpl pacienteNavegadoraServicioImpl = new PacienteNavegadoraServicioImpl();
                            PacienteNavegadora pacienteNavegadora = new PacienteNavegadora();

                            pacienteNavegadora.setIdEmpleado(idNavegadora);
                            pacienteNavegadora.setIdPaciente(idPacientePotencial);

                            pacienteNavegadoraServicioImpl.agregarPacienteNavegadora(pacienteNavegadora);

                            /**
                             * NUEVOS SERVICIOS (OMAR)
                             */
                            /**
                             * FIN DECLARACION DE SERVICIOS
                             */
                            String prz = null;
                            prz = request.getParameter("prz-expediente");

                            if (prz.length() > 0) {

                                System.out.println("PRZ ".concat(prz));

                                paciente.setPrz(prz);
                                pacienteServicioImpl.actualizarPrz(paciente);

                            } else {
                                System.out.println("Sin PRZ");
                            }

                            //LISTO
                            //Tabla pacienteMedicoTitular
                            //MEDICO ADSCRITO
                            int adscritoPresenteAdscrito = 1;
                            String medicoAdscritoRequest;
                            int medicoAdscrito = 0;
                            //int idEmpleadoAnteriorAdscrito = 0;
                            medicoAdscritoRequest = request.getParameter("medico-adscrito");

                            if (medicoAdscritoRequest != null) {
                                medicoAdscrito = Integer.parseInt(medicoAdscritoRequest);
                                System.out.println("Medico adscrito " + (medicoAdscrito));
                                int idEmpleadoAdscrito = empleadoServicioImpl.mostrarEmpleadoPersona(medicoAdscrito).getIdEmpleado();
                                int idCitaAdscrito = citaServicioImpl.mostrarCitaPreconsultaPacientePotencial(idPacientePotencial).getIdCita();
                                System.out.println("La cita es " + idCitaAdscrito);

                                LocalDate inicio = java.time.LocalDate.now();
                                Date inicioDate = Date.valueOf(inicio);
                                System.out.println(inicioDate);
                                PacienteMedicoTitular pacienteMedicoTitularAdscrito;
                                pacienteMedicoTitularAdscrito = pacienteMedicoTitularServicioImpl.mostrarPacienteMedicoTitularIdPacientePosicion(idPacientePotencial, 2);

                                if (pacienteMedicoTitularAdscrito != null) {
                                    //nuevo
                                    System.out.println("Voy actualizar el paciente medicoTitular");
                                    pacienteMedicoTitularAdscrito.setIdPaciente(idPacientePotencial);
                                    pacienteMedicoTitularAdscrito.setIdEmpleado(idEmpleadoAdscrito);
                                    pacienteMedicoTitularAdscrito.setInicio(inicioDate);
                                    pacienteMedicoTitularServicioImpl.actualizarPacienteMedicoTitular(pacienteMedicoTitularAdscrito);

                                } else {
                                    System.out.println("Voy agregar el paciente medicoTitular");

                                    pacienteMedicoTitularAdscrito = new PacienteMedicoTitular();
                                    pacienteMedicoTitularAdscrito.setIdPaciente(idPacientePotencial);
                                    pacienteMedicoTitularAdscrito.setIdEmpleado(idEmpleadoAdscrito);
                                    pacienteMedicoTitularAdscrito.setInicio(inicioDate);
                                    pacienteMedicoTitularServicioImpl.agregarPacienteMedicoTitular(pacienteMedicoTitularAdscrito);
                                }
                                //checkbox adscritoPresente
                                adscritoPresenteAdscrito = 1;
                                if (request.getParameterMap().containsKey("noAdscritoAdscrito") == true) {
                                    adscritoPresenteAdscrito = 0;
                                }

                                /**
                                 * Asignación de adscrito presente en tabla
                                 * CitaEmpleado
                                 */
                                //System.out.println("Voys a buscar la citaEmpleado: " + idEmpleadoAnteriorAdscrito);
                                int idEmpleadoPosicionAdscrito = 2;

                                CitaEmpleado citaEmpleadoAdscrito = citaEmpleadoServicioImpl.mostrarCitaEmpleadoPacientePosicion(idPacientePotencial, idEmpleadoPosicionAdscrito);
                                //idEmpleadoAnteriorAdscrito = citaEmpleadoAdscrito.getIdEmpleado();

                                System.out.println("voy a imprimir la pinche cita empleado" + citaEmpleadoAdscrito);
                                System.out.println("ADSCRITO PRESENTEEEE" + adscritoPresenteAdscrito);
                                if (citaEmpleadoAdscrito != null) {

                                    System.out.println("Voy actualizar la cita");
                                    citaEmpleadoAdscrito.setAdscritoPresente(adscritoPresenteAdscrito);
                                    citaEmpleadoAdscrito.setIdEmpleado(idEmpleadoAdscrito);
                                    citaEmpleadoAdscrito.setIdCita(idCitaAdscrito);
                                    System.out.println("la cita empleado antes de actualizar es:" + citaEmpleadoAdscrito);
                                    citaEmpleadoServicioImpl.actualizarCitaEmpleado(citaEmpleadoAdscrito);
                                } else {
                                    System.out.println("Voy agregar la cita");
                                    citaEmpleadoAdscrito = new CitaEmpleado();
                                    citaEmpleadoAdscrito.setAdscritoPresente(adscritoPresenteAdscrito);
                                    citaEmpleadoAdscrito.setIdEmpleado(idEmpleadoAdscrito);
                                    citaEmpleadoAdscrito.setIdCita(idCitaAdscrito);
                                    citaEmpleadoServicioImpl.agregarCitaEmpleado(citaEmpleadoAdscrito);
                                }
                                //citaEmpleadoServicioImpl.agregarCitaEmpleado(citaEmpleado);

                                System.out.println("Adscrito Presente ".concat(String.valueOf(adscritoPresenteAdscrito)));

                            } else {
                                System.out.println("Sin médico adscrito");
                            }

                            //LISTO
                            //MEDICO RADIOLOGO
                            String medicoRadiologoRequest = request.getParameter("medico-radiologo");
                            int medicoRadiologo;
                            //int idEmpleadoAnteriorRadiologo = 0;
                            int adscritoPresenteRadiologo = 1;

                            System.out.println("Estoy en medico radiologo");
                            if (medicoRadiologoRequest != null) {
                                medicoRadiologo = Integer.parseInt(medicoRadiologoRequest);
                                System.out.println("Medico radiologo " + (medicoRadiologo));
                                int idEmpleadoRadiologo = empleadoServicioImpl.mostrarEmpleadoPersona(medicoRadiologo).getIdEmpleado();
                                System.out.println("EL IDEMPLEADO EEEES: " + idEmpleadoRadiologo);
                                int idCitaRadiologo = citaServicioImpl.mostrarCitaPreconsultaPacientePotencial(idPacientePotencial).getIdCita();

                                //checkbox adscritoPresente
                                if (request.getParameterMap().containsKey("noAdscritoRadiologo") == true) {
                                    adscritoPresenteRadiologo = 0;
                                }

                                /**
                                 * Asignación de radiologo presente en tabla
                                 * CitaEmpleado (para fines practicos es el
                                 * mismo atributo que el del medico adscrito)
                                 */
                                int idPosicionRadiologo = 11;

                                CitaEmpleado citaEmpleadoRadiologo = citaEmpleadoServicioImpl.mostrarCitaEmpleadoPacientePosicion(idPacientePotencial, idPosicionRadiologo);
                                //idEmpleadoAnteriorRadiologo = citaEmpleadoRadiologo.getIdEmpleado();

                                if (citaEmpleadoRadiologo != null) {
                                    citaEmpleadoRadiologo.setAdscritoPresente(adscritoPresenteRadiologo);
                                    citaEmpleadoRadiologo.setIdEmpleado(idEmpleadoRadiologo);
                                    citaEmpleadoRadiologo.setIdCita(idCitaRadiologo);
                                    citaEmpleadoServicioImpl.actualizarCitaEmpleado(citaEmpleadoRadiologo);
                                } else {
                                    citaEmpleadoRadiologo = new CitaEmpleado();
                                    citaEmpleadoRadiologo.setAdscritoPresente(adscritoPresenteRadiologo);
                                    citaEmpleadoRadiologo.setIdEmpleado(idEmpleadoRadiologo);
                                    citaEmpleadoRadiologo.setIdCita(idCitaRadiologo);
                                    citaEmpleadoServicioImpl.agregarCitaEmpleado(citaEmpleadoRadiologo);
                                }
                                //citaEmpleadoServicioImpl.agregarCitaEmpleado(citaEmpleado);

                                System.out.println("Adscrito Presente ".concat(String.valueOf(adscritoPresenteRadiologo)));

                            } else {
                                System.out.println("Sin médico radiologo");
                            }

                            //MEDICO RESIDENTE------------------ *************************NO ESTÁ HECHO********
                            String medicoResidenteRequest = null;
                            //int idEmpleadoAnteriorResidente = 0;
                            int medicoResidente;
                            int adscritoPresenteResidente = 1;
                            medicoResidenteRequest = request.getParameter("medico-residente");
                            if (medicoResidenteRequest != null && medicoResidenteRequest.length() > 0) {

                                medicoResidente = Integer.parseInt(medicoResidenteRequest);
                                System.out.println("Medico residente " + (medicoResidente));
                                int idEmpleadoResidente = empleadoServicioImpl.mostrarEmpleadoPersona(medicoResidente).getIdEmpleado();
                                System.out.println("EL IDEMPLEADO EEEES: " + idEmpleadoResidente);
                                int idCitaResidente = citaServicioImpl.mostrarCitaPreconsultaPacientePotencial(idPacientePotencial).getIdCita();

                                //checkbox adscritoPresente
                                if (request.getParameterMap().containsKey("noAdscritoResidente") == true) {
                                    adscritoPresenteResidente = 0;
                                }

                                /**
                                 * Asignación de radiologo presente en tabla
                                 * CitaEmpleado (para fines practicos es el
                                 * mismo atributo que el del medico adscrito)
                                 */
                                int idEmpleadoPosicionResidente = 1;

                                CitaEmpleado citaEmpleadoResidente = citaEmpleadoServicioImpl.mostrarCitaEmpleadoPacientePosicion(idPacientePotencial, idEmpleadoPosicionResidente);
                                //idEmpleadoAnteriorResidente = citaEmpleadoResidente.getIdEmpleado();
                                if (citaEmpleadoResidente != null) {
                                    citaEmpleadoResidente.setAdscritoPresente(adscritoPresenteResidente);
                                    citaEmpleadoResidente.setIdEmpleado(idEmpleadoResidente);
                                    citaEmpleadoResidente.setIdCita(idCitaResidente);
                                    citaEmpleadoServicioImpl.actualizarCitaEmpleado(citaEmpleadoResidente);
                                } else {
                                    citaEmpleadoResidente = new CitaEmpleado();
                                    citaEmpleadoResidente.setAdscritoPresente(adscritoPresenteResidente);
                                    citaEmpleadoResidente.setIdEmpleado(idEmpleadoResidente);
                                    citaEmpleadoResidente.setIdCita(idCitaResidente);
                                    citaEmpleadoServicioImpl.agregarCitaEmpleado(citaEmpleadoResidente);
                                }
                                //citaEmpleadoServicioImpl.agregarCitaEmpleado(citaEmpleado);

                                System.out.println("Adscrito Presente ".concat(String.valueOf(adscritoPresenteResidente)));

                            } else {
                                System.out.println("sin médico residente");
                            }

                            //LISTO
                            //TIPO PACIENTE 
                            int idtipoPaciente = -1;

                            String tipoPacienteRequest = request.getParameter("tipoPaciente");

                            if (tipoPacienteRequest != null) {
                                EstadoPacientePaciente estadoPacientePacienteTipo = estadoPacientePacienteServicioImpl.mostrarEstadoPacientePacienteIdPaciente(idPacientePotencial);

                                idtipoPaciente = Integer.parseInt(tipoPacienteRequest);
                                estadoPacientePacienteTipo.setSegundaOpinion(idtipoPaciente);
                                estadoPacientePacienteTipo.setIdEmpleado(idNavegadora);
                                estadoPacientePacienteServicioImpl.actualizarEstadoPacientePaciente(estadoPacientePacienteTipo);
                                System.out.println(estadoPacientePacienteTipo);
                                //System.out.println("Tipo Paciente " + (tipoPaciente));
                            } else {
                                System.out.println("Sin tipoPaciente");
                            }

                            //LISTO
                            //FECHA DE NAVEGACION
                            //Tipo de navegacion
                            Date dateNavegacion = null;
                            String fechaNavegacionRequest = request.getParameter("fechaNavegacion");
                            System.out.println(fechaNavegacionRequest);

                            if (fechaNavegacionRequest != null && fechaNavegacionRequest.length() > 0) {
                                dateNavegacion = Date.valueOf(fechaNavegacionRequest);
                                Timestamp fechaNavegacion = new Timestamp(dateNavegacion.getTime());
                                Cita citaNavegacionPacientePotencial = citaServicioImpl.mostrarCitaNavegacionPacientePotencial(idPacientePotencial);
                                System.out.println("Fecha Navegacion " + (fechaNavegacion));

                                if (citaNavegacionPacientePotencial != null) {

                                    citaNavegacionPacientePotencial.setFechaReal(fechaNavegacion);
                                    System.out.println(citaNavegacionPacientePotencial);

                                    citaServicioImpl.actualizarCitaFecha(citaNavegacionPacientePotencial);

                                } else {
                                    System.out.println("no existe un registro en cita de fecha de navegacion");
                                }
                            } else {
                                System.out.println("Sin fecha Navegacion");
                            }

                            //FECHA DE PRECONSULTA
                            //LISTO
                            Date datePreconsulta = null;
                            Timestamp fechaPreConsulta = null;

                            String fechaPreConsultaRequest = (request.getParameter("fechaConsulta"));
                            if (fechaPreConsultaRequest != null && fechaPreConsultaRequest.length() > 0) {
                                datePreconsulta = Date.valueOf(fechaPreConsultaRequest);
                                fechaPreConsulta = new Timestamp(datePreconsulta.getTime());

                                Cita citaPreConsultaPacientePotencial = citaServicioImpl.mostrarCitaPreconsultaPacientePotencial(idPacientePotencial);

                                if (citaPreConsultaPacientePotencial != null) {
                                    citaPreConsultaPacientePotencial.setFechaReal(fechaPreConsulta);
                                    System.out.println(citaPreConsultaPacientePotencial);
                                    citaServicioImpl.actualizarCitaFecha(citaPreConsultaPacientePotencial);
                                } else {
                                    System.out.println("no existe un registro de cita de preconsulta para este paciente");
                                }
                                System.out.println("Fecha Consulta " + (fechaPreConsulta));
                            } else {
                                System.out.println("Sin fecha preconsulta");
                            }

                            //LISTO
                            //FIN PRIMERA PANTALLA
                            // INICIO SEGUNDA PANTALA -----------------------------------------------------------------
                            //NIVEL EDUCATIVO
                            int nivelEducativo = 0;
                            String nivelEducativoRequest = (request.getParameter("nivelEducativo"));
                            if (nivelEducativoRequest != null) {
                                nivelEducativo = Integer.parseInt(nivelEducativoRequest);
                                System.out.println("Nivel educativo " + (nivelEducativo));
                                paciente = pacienteServicioImpl.mostrarPaciente(idPacientePotencial);
                                paciente.setIdEscolaridad(nivelEducativo);
                                pacienteServicioImpl.actualizarPacienteEscolaridad(paciente);
                            } else {
                                System.out.println("Sin nivel educativo");
                            }

                            //LISTO
                            //ALERGIAS
                            String alergias = null;
                            alergias = request.getParameter("alergias");
                            if (alergias.length() > 0 && alergias != null) {

                                PacienteAlergia pacienteAlergia = pacienteAlergiaServicioImpl.mostrarPacienteAlergiaIdPaciente(idPacientePotencial);
                                System.out.println("Alergias: ".concat(alergias));

                                if (pacienteAlergia != null) {

                                    pacienteAlergia.setIdAlergia(1);
                                    pacienteAlergia.setAlergia(alergias);
                                    pacienteAlergiaServicioImpl.actualizarPacienteAlergia(pacienteAlergia);

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

                            //LISTO
                            //ESTADO HORMONAL
                            int estadoHormonal = -1;
                            String estadoHormonalRequest = request.getParameter("estadoHormonal");
                            if (estadoHormonalRequest != null) {
                                estadoHormonal = Integer.parseInt(estadoHormonalRequest);
                                paciente = pacienteServicioImpl.mostrarPaciente(idPacientePotencial);
                                paciente.setPosMenopausia(estadoHormonal);
                                pacienteServicioImpl.actualizarPacienteMenopausia(paciente);
                                System.out.println("EstadoHormonal " + (estadoHormonal));
                            } else {
                                System.out.println("Sin estado hormonal");
                            }

                            //LISTO
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

                            //LISTO
                            //MASTOGRAFIA PREVIA
                            //Se agrega en documentoEstudio
                            int primeraMasto = 0;
                            //29 es el idEstudio
                            //

                            if (request.getParameterMap().containsKey("primeraMasto")) {
                                System.out.println("Entre a la masto");
                                primeraMasto = 1;
                                //int idCitaPre = citaServicioImpl.mostrarCitaPreconsultaPacientePotencial(idPacientePotencial).getIdCita();
                                DocumentoEstudio documentoEstudioPrimeraMasto = documentoEstudioServicioImpl.mostrarDocumentoEstudioMastoAntesPreconsulta(idPacientePotencial, 29);
                                // LocalDate inicio = java.time.LocalDate.now();
                                // Date inicioDate = Date.valueOf(inicio);
                                if (documentoEstudioPrimeraMasto != null) {

                                    documentoEstudioPrimeraMasto.setEstatus(1);
                                    documentoEstudioServicioImpl.actualizarDocumentoEstudioMastoAntesPreconsulta(documentoEstudioPrimeraMasto);
                                } else {
                                    //HARCODEO
                                    documentoEstudioPrimeraMasto = new DocumentoEstudio();
                                    documentoEstudioPrimeraMasto.setIdPaciente(idPacientePotencial);

                                    System.out.println(documentoEstudioPrimeraMasto);

                                    documentoEstudioServicioImpl.agregarDocumentoEstudioMastoAntesPreconsulta(documentoEstudioPrimeraMasto);
                                }
                            } else {
                                DocumentoEstudio documentoEstudioPrimeraMasto = documentoEstudioServicioImpl.mostrarDocumentoEstudioPacienteEstudio(idPacientePotencial, 29);
                                if (documentoEstudioPrimeraMasto != null) {
                                    documentoEstudioServicioImpl.borradoLogicoDocumentoEstudio(documentoEstudioPrimeraMasto.getIdDocumentoEstudio());
                                }

                            }
                            System.out.println("Masto antes del INCan ".concat(String.valueOf(primeraMasto)));

                            //LISTO
                            //PacienteTratamientoPrevio
                            //Cirugia previa
                            int tieneCirugiaPrevia = 0;
                            //Verifica si hay cirugía previa
                            if (request.getParameterMap().containsKey("tiene-cirugia")) {

                                PacienteTratamientoPrevio cirugiaPrevia = pacienteTratamientoPrevioServiceImpl.mostrarPacienteTratamientoPrevioTratamiento(idPacientePotencial, 3);

                                if (cirugiaPrevia != null) {
                                    //Actualiza
                                    //cirugiaPrevia.setIdPaciente(idPacientePotencial);
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
//LISTO
                            //QUIMIOTERAPIA
                            int tieneQuimioterapiaPrevia = 0; //ESTE QUEDA SIN FUNCIONAMIENTO?????
                            if (request.getParameterMap().containsKey("tiene-quimioterapia")) {

                                // System.out.println("Quimioterapia Previa ".concat(String.valueOf(tieneQuimioterapiaPrevia)));
                                PacienteTratamientoPrevio quimioterapiaPrevia = pacienteTratamientoPrevioServiceImpl.mostrarPacienteTratamientoPrevioTratamiento(idPacientePotencial, 1);

                                if (quimioterapiaPrevia != null) {
                                    //quimioterapiaPrevia.setIdPaciente(idPacientePotencial);
                                    //quimioterapiaPrevia.setIdTipoTratamiento(1);
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

                                    if (numeroCiclosRequest != null && numeroCiclosRequest.length() > 0) {
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
                            //LISTO
                            //RADIOTERAPIA

                            int tieneRadioterapiaPrevia = 0;
                            if (request.getParameterMap().containsKey("tiene-radioterapia")) {

                                // System.out.println("Radioterapia previa ".concat(String.valueOf(tieneRadioterapiaPrevia)));
                                PacienteTratamientoPrevio radioterapiaPrevia = pacienteTratamientoPrevioServiceImpl.mostrarPacienteTratamientoPrevioTratamiento(idPacientePotencial, 4);

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
                                DocumentoEstudio documentoEstudioPrevioMastografia = documentoEstudioServicioImpl.mostrarDocumentoEstudioPacienteEstudio(idPacientePotencial, 4);
                                if (documentoEstudioPrevioMastografia != null) {

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
                                    documentoEstudioServicioImpl.actualizarDocumentoEstudioEstudioPrevio(documentoEstudioPrevioMastografia);

                                } else {

                                    documentoEstudioPrevioMastografia = new DocumentoEstudio();

                                    documentoEstudioPrevioMastografia.setIdPaciente(idPacientePotencial);
                                    documentoEstudioPrevioMastografia.setIdEstudio(4);

                                    //documentoEstudioPrevioMastografia.setIdCita(idCitaPreconsulta);
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
                                    documentoEstudioServicioImpl.agregarDocumentoEstudioEstudioPrevio(documentoEstudioPrevioMastografia);
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

                                    /*documentoEstudioPrevioUltrasonido.setIdPaciente(idPacientePotencial);
                                    documentoEstudioPrevioUltrasonido.setPrevio(1);
                                    documentoEstudioPrevioUltrasonido.setIdEstadoEstudio(1);
                                    //Aqui no se harcodea pq ya está en el registro
                                    documentoEstudioPrevioUltrasonido.setIdEstudio(27);
                                    documentoEstudioPrevioUltrasonido.setIdCita(idCitaPreconsulta);

                                    documentoEstudioPrevioUltrasonido.setIdBirads(8);
                                    documentoEstudioPrevioUltrasonido.setIdLugarDelCuerpo(2);*/
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

                                    documentoEstudioServicioImpl.actualizarDocumentoEstudioEstudioPrevio(documentoEstudioPrevioUltrasonido);
                                } else {

                                    documentoEstudioPrevioUltrasonido = new DocumentoEstudio();

                                    documentoEstudioPrevioUltrasonido.setIdPaciente(idPacientePotencial);

                                    //Se harcodea el idEstudio
                                    documentoEstudioPrevioUltrasonido.setIdEstudio(27);

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
                                    documentoEstudioServicioImpl.agregarDocumentoEstudioEstudioPrevio(documentoEstudioPrevioUltrasonido);
                                }
                            }

                            //Resultado de patologia
                            //Biopsia y OtrosResultados
                            int resultadoPatologia = 0;
                            int idBiopsia = 0;
                            String resultadoPatologiaRequest = request.getParameter("resultadoAnterior-patologia");

                            String otroReportePatologia = null;
                            otroReportePatologia = request.getParameter("introducirOtroResultadoPatologia");
                            if (resultadoPatologiaRequest != null) {
                                resultadoPatologia = Integer.parseInt(resultadoPatologiaRequest);
                                Biopsia biopsiaResultado = new Biopsia();
                                //Busca la bipsia
                                biopsiaResultado = biopsiaServicioImpl.mostrarBiopsiaIdPaciente(idPacientePotencial);

                                if (biopsiaResultado != null) {
                                    //Si hay biopasia se actualiza
                                    System.out.println("Voy a actualizar biopsia");
                                    biopsiaResultado.setIdTipoHistologico(resultadoPatologia);
                                    System.out.println(biopsiaResultado);
                                    biopsiaServicioImpl.actualizarBiopsiaResultado(biopsiaResultado);
                                    idBiopsia = biopsiaResultado.getIdBiopsia();

                                } else {
                                    //Si no hay se inserta
                                    System.out.println("Voy a agregar biopsia");
                                    biopsiaResultado = new Biopsia();

                                    biopsiaResultado.setIdPaciente(idPacientePotencial);
                                    biopsiaResultado.setIdTipoHistologico(resultadoPatologia);

                                    idBiopsia = biopsiaServicioImpl.agregarBiopsiaResultado(biopsiaResultado);

                                }

                                OtroResultadoPatologia otroResultado = otroResultadoServicio.mostrarOtroResultadoPatologiaIdBiopsia(idBiopsia);
                                if (otroResultado != null) {
                                    if (resultadoPatologia == 16) {
                                        otroResultado.setNombre(otroReportePatologia);
                                    } else {
                                        otroResultado.setNombre("");

                                    }

                                    otroResultadoServicio.actualizarOtroResultadoPatologia(otroResultado);

                                } else {
                                    otroResultado = new OtroResultadoPatologia();
                                    otroResultado.setIdBiopsia(idBiopsia);
                                    if (resultadoPatologia == 16) {
                                        otroResultado.setNombre(otroReportePatologia);
                                    } else {
                                        otroResultado.setNombre("");
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
                                System.out.println("entré a entrega laminillas");
                                //RAUL- SP falta decirle!!!!!!!!!1
                                Laminilla laminilla = laminillaServicioImpl.mostrarLaminillaPaciente(idPacientePotencial);

                                if (laminilla != null) {
                                    System.out.println("estoy en el if de laminillas");

                                    int numeroLaminillas = 0;
                                    String numeroLaminillasRequest = request.getParameter("numLaminillas");
                                    if (numeroLaminillasRequest.length() > 0 && numeroLaminillasRequest != null) {
                                        numeroLaminillas = Integer.parseInt(numeroLaminillasRequest);
                                        int idBiopsiaLaminilla = biopsiaServicioImpl.mostrarBiopsiaPreviaPaciente(idPacientePotencial, 1).getIdBiopsia();
                                        laminilla.setIdBiopsia(idBiopsiaLaminilla);
                                        laminilla.setCantidad(numeroLaminillas);

                                    } else {
                                        System.out.println("Sin Número laminillas ");
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
                                    System.out.println(laminilla);

                                    laminillaServicioImpl.actualizarLaminilla(laminilla);
                                } else {
                                    laminilla = new Laminilla();
                                    System.out.println("estoy en el else de laminillas");
                                    int numeroLaminillas = 0;
                                    String numeroLaminillasRequest = request.getParameter("numLaminillas");
                                    System.out.println("El numero de laminillas es:" + numeroLaminillasRequest);
                                    if (numeroLaminillasRequest.length() > 0 && numeroLaminillasRequest != null) {
                                        numeroLaminillas = Integer.parseInt(numeroLaminillasRequest);
                                        int idBiopsiaLaminilla = biopsiaServicioImpl.mostrarBiopsiaPreviaPaciente(idPacientePotencial, 1).getIdBiopsia();
                                        laminilla.setIdBiopsia(idBiopsiaLaminilla);

                                        laminilla.setCantidad(numeroLaminillas);

                                    } else {
                                        System.out.println("Sin Número laminillas ");
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

                                    System.out.println(laminilla);
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
                                    String numeroBloquesParafinaRequest = request.getParameter("numBloques");

                                    if (numeroBloquesParafinaRequest != null && numeroBloquesParafinaRequest.length() > 0) {
                                        numeroBloquesParafina = Integer.parseInt(numeroBloquesParafinaRequest);
                                        int idBiopsiaBloqueParafina = biopsiaServicioImpl.mostrarBiopsiaPreviaPaciente(idPacientePotencial, 1).getIdBiopsia();
                                        bloqueParafina.setIdBiopsia(idBiopsiaBloqueParafina);
                                        bloqueParafina.setCantidad(numeroBloquesParafina);
                                    }
                                    System.out.println("Numero de bloques de parafina ".concat(String.valueOf(numeroBloquesParafina)));

                                    String serieBloquesParafina = null;
                                    serieBloquesParafina = request.getParameter("serieBloques");
                                    if (serieBloquesParafina != null) {

                                        System.out.println("Serie bloques parafina ".concat(serieBloquesParafina));
                                        bloqueParafina.setSerie(serieBloquesParafina);
                                    } else {
                                        System.out.println("Sin bloques parafina");
                                    }
                                    bloqueParafinaServicioImpl.actualizarBloqueParafina(bloqueParafina);
                                } else {
                                    int numeroBloquesParafina = 0;
                                    String numeroBloquesParafinaRequest = request.getParameter("numBloques");
                                    bloqueParafina = new BloqueParafina();

                                    if (numeroBloquesParafinaRequest != null && numeroBloquesParafinaRequest.length() > 0) {
                                        numeroBloquesParafina = Integer.parseInt(numeroBloquesParafinaRequest);
                                        int idBiopsiaBloqueParafina = biopsiaServicioImpl.mostrarBiopsiaPreviaPaciente(idPacientePotencial, 1).getIdBiopsia();
                                        bloqueParafina.setIdBiopsia(idBiopsiaBloqueParafina);
                                        bloqueParafina.setCantidad(numeroBloquesParafina);
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

                            //HASTA AQUI LLEGA PAGINA 2-----------------------------------------------------------------
                            //INICIO PANTALLA 3 (OMAR) -----------------------------------------------------------------
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
                                String lugar = json.get("lugar").toString();
                                lugar = lugar.substring(1, lugar.length() - 1);
                                switch (accion) {
                                    case "agregar": {
                                        estudio = estudioServicio.mostrarEstudio(tipo);
                                        if (estudio == null) {
                                            break;
                                        }
                                        cita.setIdEstudio(estudio.getIdEstudio());
                                        cita.setFechaProgramada(fechaStringToTimestamp(fecha));
                                        int idCita = citaServicio.agregarCita(cita);

                                        lugarDelCuerpo = lugarDelCuerpoServicio.mostrarLugarDelCuerpo(lugar);
                                        if (lugarDelCuerpo == null) {
                                            lugarDelCuerpo = new LugarDelCuerpo();
                                            lugarDelCuerpo.setNombre(lugar);
                                            lugarDelCuerpoServicio.agregarLugarDelCuerpo(lugarDelCuerpo);
                                            lugarDelCuerpo = lugarDelCuerpoServicio.mostrarLugarDelCuerpo(lugar);
                                        }
                                        documentoEstudio.setIdCita(idCita);
                                        documentoEstudio.setIdPaciente(idPacientePotencial);
                                        documentoEstudio.setIdEstudio(estudio.getIdEstudio());
                                        documentoEstudio.setIdEstadoEstudio(1);
                                        documentoEstudio.setIdBirads(null);
                                        documentoEstudio.setIdLugarDelCuerpo(lugarDelCuerpo.getIdLugarDelCuerpo());
                                        documentoEstudioServicio.agregarDocumentoEstudio(documentoEstudio);
                                        break;
                                    }
                                    case "actualizar": {
                                        cita.setIdCita(id);
                                        estudio = estudioServicio.mostrarEstudio(tipo);
                                        if (estudio == null) {
                                            break;
                                        }
                                        cita.setIdEstudio(estudio.getIdEstudio());
                                        cita.setFechaProgramada(fechaStringToTimestamp(fecha));
                                        citaServicio.actualizarCita(cita);

                                        lugarDelCuerpo = lugarDelCuerpoServicio.mostrarLugarDelCuerpo(lugar);
                                        if (lugarDelCuerpo == null) {
                                            lugarDelCuerpo = new LugarDelCuerpo();
                                            lugarDelCuerpo.setNombre(lugar);
                                            lugarDelCuerpoServicio.agregarLugarDelCuerpo(lugarDelCuerpo);
                                            lugarDelCuerpo = lugarDelCuerpoServicio.mostrarLugarDelCuerpo(lugar);
                                        }
                                        documentoEstudioServicio.actualizarLugarDelCuerpoCita(id, lugarDelCuerpo.getIdLugarDelCuerpo());
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
                                        if (estudio == null) {
                                            break;
                                        }
                                        cita.setIdEstudio(estudio.getIdEstudio());
                                        cita.setFechaProgramada(fechaStringToTimestamp(fecha));
                                        citaServicio.agregarCita(cita);
                                        break;
                                    }
                                    case "actualizar": {
                                        cita.setIdCita(id);
                                        estudio = estudioServicio.mostrarEstudio(tipo);
                                        if (estudio == null) {
                                            break;
                                        }
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
                                        cita.setIdEstudio(27);
                                        cita.setFechaProgramada(fechaStringToTimestamp(fecha));
                                        int idCita = citaServicio.agregarCita(cita);

                                        lugarDelCuerpo = lugarDelCuerpoServicio.mostrarLugarDelCuerpo(parte);
                                        if (lugarDelCuerpo == null) {
                                            lugarDelCuerpo = new LugarDelCuerpo();
                                            lugarDelCuerpo.setNombre(parte);
                                            lugarDelCuerpoServicio.agregarLugarDelCuerpo(lugarDelCuerpo);
                                            lugarDelCuerpo = lugarDelCuerpoServicio.mostrarLugarDelCuerpo(parte);
                                        }
                                        documentoEstudio.setIdCita(idCita);
                                        documentoEstudio.setIdPaciente(idPacientePotencial);
                                        documentoEstudio.setIdEstudio(estudio.getIdEstudio());
                                        documentoEstudio.setIdEstadoEstudio(1);
                                        documentoEstudio.setIdBirads(null);
                                        documentoEstudio.setIdLugarDelCuerpo(lugarDelCuerpo.getIdLugarDelCuerpo());
                                        documentoEstudioServicio.agregarDocumentoEstudio(documentoEstudio);
                                        break;
                                    }
                                    case "actualizar": {
                                        cita.setIdCita(id);
                                        cita.setIdEstudio(27);
                                        cita.setFechaProgramada(fechaStringToTimestamp(fecha));
                                        citaServicio.actualizarCita(cita);

                                        lugarDelCuerpo = lugarDelCuerpoServicio.mostrarLugarDelCuerpo(parte);
                                        if (lugarDelCuerpo == null) {
                                            lugarDelCuerpo = new LugarDelCuerpo();
                                            lugarDelCuerpo.setNombre(parte);
                                            lugarDelCuerpoServicio.agregarLugarDelCuerpo(lugarDelCuerpo);
                                            lugarDelCuerpo = lugarDelCuerpoServicio.mostrarLugarDelCuerpo(parte);
                                        }
                                        documentoEstudioServicio.actualizarLugarDelCuerpoCita(id, lugarDelCuerpo.getIdLugarDelCuerpo());
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
                                        if (estudio == null) {
                                            break;
                                        }
                                        cita.setIdEstudio(estudio.getIdEstudio());
                                        cita.setFechaProgramada(fechaStringToTimestamp(fecha));
                                        citaServicio.agregarCita(cita);
                                        break;
                                    }
                                    case "actualizar": {
                                        cita.setIdCita(id);
                                        estudio = estudioServicio.mostrarEstudio(medicinaNuclear);
                                        if (estudio == null) {
                                            break;
                                        }
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
                                        cita.setIdEstudio(25); // TO DO
                                        cita.setFechaProgramada(fechaStringToTimestamp(fecha));
                                        citaServicio.agregarCita(cita);
                                        break;
                                    }
                                    case "actualizar": {
                                        cita.setIdCita(id);
                                        cita.setIdEstudio(25); // TO DO
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
                                        if (estudio == null) {
                                            break;
                                        }
                                        cita.setIdEstudio(estudio.getIdEstudio());
                                        cita.setFechaProgramada(fechaStringToTimestamp(fecha));
                                        citaServicio.agregarCita(cita);
                                        break;
                                    }
                                    case "actualizar": {
                                        cita.setIdCita(id);
                                        estudio = estudioServicio.mostrarEstudio(valoracion);
                                        if (estudio == null) {
                                            break;
                                        }
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
                                        cita.setIdEstudio(30); // TO DO
                                        cita.setFechaProgramada(fechaStringToTimestamp(fecha));
                                        citaServicio.agregarCita(cita);
                                        break;
                                    }
                                    case "actualizar": {
                                        cita.setIdCita(id);
                                        cita.setIdEstudio(30); // TO DO
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
                                        cita.setIdEstudio(31); // TO DO
                                        cita.setFechaProgramada(fechaStringToTimestamp(fecha));
                                        citaServicio.agregarCita(cita);
                                        break;
                                    }
                                    case "actualizar": {
                                        cita.setIdCita(id);
                                        cita.setIdEstudio(31); // TO DO
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
                                        cita.setIdEstudio(32); // TO DO
                                        cita.setFechaProgramada(fechaStringToTimestamp(fecha));
                                        citaServicio.agregarCita(cita);
                                        break;
                                    }
                                    case "actualizar": {
                                        cita.setIdCita(id);
                                        cita.setIdEstudio(32); // TO DO
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
                                        cita.setIdEstudio(33); // TO DO
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
                                programa = programa.substring(1, programa.length() - 1);
                                switch (accion) {
                                    case "agregar": {
                                        estudio = estudioServicio.mostrarEstudio(programa);
                                        if (estudio == null) {
                                            break;
                                        }
                                        cita.setIdEstudio(estudio.getIdEstudio());
                                        cita.setFechaProgramada(fechaStringToTimestamp(fecha));
                                        citaServicio.agregarCita(cita);
                                        break;
                                    }
                                    case "actualizar": {
                                        cita.setIdCita(id);
                                        estudio = estudioServicio.mostrarEstudio(programa);
                                        if (estudio == null) {
                                            break;
                                        }
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
                                otroEstudio = otroEstudio.substring(1, otroEstudio.length() - 1);
                                switch (accion) {
                                    case "agregar": {
                                        estudio = estudioServicio.mostrarEstudio(otroEstudio);
                                        if (estudio == null) {
                                            estudio = new Estudio();
                                            estudio.setNombre(otroEstudio);
                                            estudio.setIdCategoriaEstudio(7); //Otro
                                            estudioServicio.agregarEstudio(estudio);
                                            estudio = estudioServicio.mostrarEstudio(otroEstudio);
                                        }
                                        cita.setIdEstudio(estudio.getIdEstudio());
                                        cita.setFechaProgramada(fechaStringToTimestamp(fecha));
                                        citaServicio.agregarCita(cita);
                                        break;
                                    }
                                    case "actualizar": {
                                        cita.setIdCita(id);
                                        estudio = estudioServicio.mostrarEstudio(otroEstudio);
                                        if (estudio == null) {
                                            estudio.setNombre(otroEstudio);
                                            estudio.setIdCategoriaEstudio(7); //Otro
                                            estudioServicio.agregarEstudio(estudio);
                                            estudio = estudioServicio.mostrarEstudio(otroEstudio);
                                        }
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

                            //FIN PANTALLA 3 (OMAR) -----------------------------------------------------------------
                            //**************Pantalla 4************
                            //*********estadoPAcientePaciente*************
                            //Paciente Tipo resultados
                            //LLAMADAS       
                            String llamadas = request.getParameter("llamadasCita");
                            System.out.println("Llamadas ".concat(llamadas));
                            Object objLlamadas = parser.parse(llamadas);
                            JsonArray arrayLlamadas = (JsonArray) objLlamadas;
                            for (int i = 0; i < arrayLlamadas.size(); i++) {
                                JsonObject json = (JsonObject) arrayLlamadas.get(i);
                                int id = Integer.parseInt(json.get("id").toString());
                                String accion = json.get("accion").toString();
                                accion = accion.substring(1, accion.length() - 1);
                                String fecha = json.get("fecha").toString();
                                fecha = fecha.substring(1, fecha.length() - 1);
                                String comentario = json.get("motivo").toString();
                                comentario = comentario.substring(1, comentario.length() - 1);
                                int idCita = citaServicio.mostrarCitaNavegacionPacientePotencial(idPacientePotencial).getIdCita();
                                switch (accion) {
                                    case "agregar": {
                                        llamadaCita.setIdCita(idCita);
                                        llamadaCita.setComentario(comentario);
                                        llamadaCita.setIdEmpleado(idNavegadora);
                                        llamadaCita.setFecha(fechaStringToTimestamp(fecha));
                                        LlamadaCitaServicioImpl.agregarLlamadaCita(llamadaCita);
                                        break;
                                    }
                                    case "actualizar": {
                                        llamadaCita.setIdLlamadaCita(id);
                                        llamadaCita.setIdCita(idCita);
                                        llamadaCita.setComentario(comentario);
                                        llamadaCita.setIdEmpleado(idNavegadora);
                                        llamadaCita.setFecha(fechaStringToTimestamp(fecha));
                                        LlamadaCitaServicioImpl.actualizarLlamadaCita(llamadaCita);
                                        break;
                                    }
                                    case "eliminar": {
                                        LlamadaCitaServicioImpl.borradoLogicoLlamadaCita(id);
                                        break;
                                    }
                                }
                            }

                            //Resultados
                            EstadoPacientePaciente estadoPacientePaciente = null;
                            estadoPacientePaciente = estadoPacientePacienteServicioImpl.mostrarEstadoPacientePacienteIdPaciente(idPacientePotencial);
                            estadoPacientePaciente.setIdEmpleado(idNavegadora);

                            int pacienteResultados = 0;
                            if (request.getParameterMap().containsKey("resultadosCheckbox")) {
                                pacienteResultados = 1;
                            }
                            if (estadoPacientePaciente != null) {
                                estadoPacientePaciente.setResultados(pacienteResultados);
                                estadoPacientePacienteServicioImpl.actualizarEstadoPacientePaciente(estadoPacientePaciente);
                            } else {
                                System.out.println("No hay registro de estadoPacientePaciente para el idpaciete: " + idPacientePotencial);
                            }
                            System.out.println("pacienteResultados ".concat(String.valueOf(pacienteResultados)));

                            //Cambio de tipo de paciente
                            int decisionPreconsulta = 0;
                            String decisionPreconsultaRequest = request.getParameter("decisionPreconsulta");

                            System.out.println("LA DECISION PRECOSNULTA QUE RECIBO ES" + decisionPreconsultaRequest);
                            if (decisionPreconsultaRequest != null && decisionPreconsultaRequest.length() > 0) {
                                decisionPreconsulta = Integer.parseInt(decisionPreconsultaRequest);
                                System.out.println("Decision Preconsulta " + (decisionPreconsulta));

                                if (estadoPacientePaciente != null) {
                                    System.out.println("decision preconsultaaa" + decisionPreconsulta);
                                    estadoPacientePaciente.setIdEstadoPaciente(decisionPreconsulta);
                                    estadoPacientePacienteServicioImpl.actualizarEstadoPacientePaciente(estadoPacientePaciente);

                                } else {
                                    System.out.println("No hay registro de estadoPacientePaciente para el idpaciete: " + idPacientePotencial);

                                }
                            } else {
                                System.out.println("Sin decision preconsulta ");
                            }

                            //fecha Decision Preconsulta
                            Date fechaDecisionPreconsulta = null;
                            Timestamp fechaDecisionPreconsultaT = null;

                            String fechaDecisionPreconsultaRequest = request.getParameter("fecha-decisionPreconsulta");
                            System.out.println("FECHAFIIIN" + fechaDecisionPreconsultaRequest);

                            if (fechaDecisionPreconsultaRequest != null && fechaDecisionPreconsultaRequest.length() > 0) {
                                fechaDecisionPreconsulta = Date.valueOf(fechaDecisionPreconsultaRequest);
                                fechaDecisionPreconsultaT = new Timestamp(fechaDecisionPreconsulta.getTime());
                                System.out.println("fechaDecisionPreconsulta " + (fechaDecisionPreconsulta));
                                if (estadoPacientePaciente != null) {

                                    System.out.println("FECHA" + fechaDecisionPreconsultaT);
                                    estadoPacientePaciente.setFechaFin(fechaDecisionPreconsultaT);
                                    estadoPacientePacienteServicioImpl.actualizarEstadoPacientePaciente(estadoPacientePaciente);

                                } else {
                                    System.out.println("No hay registro de estadoPacientePaciente para el idpaciete: " + idPacientePotencial);

                                }

                            } else {
                                System.out.println("Sin fecha decisión preconsulta");
                            }

                            ///*********Paciente**********
                            //Nivel Socioeconomico
                            int nivelSocioeconomico = 0;
                            String nivelSocioeconomicoRequest = request.getParameter("nivelSocioeconomico");

                            if (nivelSocioeconomicoRequest != null && nivelSocioeconomicoRequest.length() > 0) {
                                nivelSocioeconomico = Integer.parseInt(nivelSocioeconomicoRequest);
                                System.out.println("Nivel socioeconomico " + (nivelSocioeconomico));
                                paciente = pacienteServicioImpl.mostrarPaciente(idPacientePotencial);
                                paciente.setIdNivelSocioEconomico(nivelSocioeconomico);
                                pacienteServicioImpl.actualizarPaciente(paciente);
                            } else {
                                System.out.println("Sin nivel socioeconomico ");
                            }

                            //****** ComentarioCita*********
                            int idCitaPreConsulta = 0;
                            idCitaPreConsulta = (citaServicioImpl.mostrarCitaPreconsultaPacientePotencial(idPacientePotencial)).getIdCita();
                            ComentarioCita comentarioCita = new ComentarioCita();
                            comentarioCita = comentarioCitaServicioImpl.mostrarComentarioCitaIdCita(idCitaPreConsulta);
                            //Comentarios de incidencias

                            if (comentarioCita != null) {
                                //Se actualiza
                                String comentariosIncidencias = null;
                                comentariosIncidencias = request.getParameter("comentarios");
                                if (comentariosIncidencias != null && comentariosIncidencias.length() > 0) {
                                    System.out.println("Comentarios".concat(comentariosIncidencias));
                                    comentarioCita.setComentarioIncidencia(comentariosIncidencias);
                                } else {
                                    System.out.println("sin comentariosIncidencias ");
                                }

                                //Comentarios Médicos
                                String comentariosMedico = null;
                                comentariosMedico = request.getParameter("comentariosMedico");
                                if (comentariosMedico != null && comentariosMedico.length() > 0) {
                                    System.out.println("comentariosMedico ".concat(comentariosMedico));
                                    comentarioCita.setComentarioMedico(comentariosMedico);
                                } else {
                                    System.out.println("sin comentariosMedico ");
                                }
                                comentarioCita.setNavegadora(idNavegadora);
                                comentarioCitaServicioImpl.actualizarComentarioCita(comentarioCita);

                            } else {

                                //Se agrega
                                comentarioCita = new ComentarioCita();
                                String comentariosIncidencias = null;
                                comentariosIncidencias = request.getParameter("comentarios");
                                if (comentariosIncidencias != null && comentariosIncidencias.length() > 0) {
                                    System.out.println("Comentarios".concat(comentariosIncidencias));
                                    comentarioCita.setComentarioIncidencia(comentariosIncidencias);
                                } else {
                                    System.out.println("sin comentariosIncidencias ");
                                }

                                //Comentarios Médicos
                                String comentariosMedico = null;
                                comentariosMedico = request.getParameter("comentariosMedico");
                                if (comentariosMedico != null && comentariosMedico.length() > 0) {
                                    System.out.println("comentariosMedico ".concat(comentariosMedico));
                                    comentarioCita.setComentarioMedico(comentariosMedico);
                                } else {
                                    System.out.println("sin comentariosMedico ");
                                }
                                comentarioCita.setIdCita(idCitaPreConsulta);
                                comentarioCita.setNavegadora(idNavegadora);
                                comentarioCitaServicioImpl.agregarComentarioCita(comentarioCita);
                            }

                            //************************PANTALLA 5*************************************
                            //REGISTRO DIAGNOSTICO 
                            RegistroDiagnosticoServiceImpl registroDiagnosticoServiceImpl = new RegistroDiagnosticoServiceImpl();
                            RegistroDiagnostico registroDiagnostico;

                            try {
                                registroDiagnostico = registroDiagnosticoServiceImpl.mostrarRegistroDiagnosticoPaciente(idPacientePotencial);
                                System.out.println("Registro Diagnostico ".concat(registroDiagnostico.toString()));
                            } catch (Exception ex) {
                                registroDiagnostico = new RegistroDiagnostico();
                                System.out.println("Tratar de obtejer registro diagnostico ".concat(ex.getMessage()));
                            }

                            //**************************************************RegistroDiagnostico*************************
                            //Etapa Clinica                                                        
                            int etapaClinica = 0;
                            String etapaClinicaRequest = (request.getParameter("etapaClinica"));
                            //String etapaClinicaRequest="1";
                            System.out.println("LA ETAPA CLINCIA QUE RECIBO ES:" + etapaClinicaRequest);
                            if (etapaClinicaRequest != null && etapaClinicaRequest.length() > 0) {
                                etapaClinica = Integer.parseInt(etapaClinicaRequest);
                                int previoDiagnostico = 0;
                                /*
                                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                                Calendar cal = Calendar.getInstance();
                                System.out.println(dateFormat.format(cal.getTime()));
                                Date fecha = Date.valueOf(dateFormat.format(cal.getTime()));
                                 */
                                LocalDate registro = java.time.LocalDate.now();
                                Date fecha = Date.valueOf(registro);

                                if (registroDiagnostico.getIdRegistroDiagnostico() > 0) {
                                    registroDiagnostico.setFecha(fecha);
                                    registroDiagnostico.setPrevioDiagnostico(previoDiagnostico);
                                    registroDiagnostico.setIdPaciente(idPacientePotencial);
                                    registroDiagnostico.setIdEtapaClinica(etapaClinica);
                                    //registroDiagnosticoServiceImpl.actualizarRegistroDiagnostico(registroDiagnostico);
                                } else {

                                    registroDiagnostico.setPrevioDiagnostico(previoDiagnostico);
                                    registroDiagnostico.setIdPaciente(idPacientePotencial);
                                    registroDiagnostico.setIdEtapaClinica(etapaClinica);
                                    registroDiagnostico.setFecha(fecha);
                                    //registroDiagnosticoServiceImpl.agregarRegistroDiagnostico(registroDiagnostico);
                                }
                                System.out.println("Estapa clinica ".concat(String.valueOf(etapaClinica)
                                ));
                            } else {
                                System.out.println("sin etapaClinica ");
                            }

                            //*******************************EstadiageTNM*****************************
                            //T codificado N Codificado M codificado
                            int tCodificado = 0, nCodificado = 0, mCodificado = 0;
                            String tCodificadoRequest = (request.getParameter("tumorPrimarioT"));
                            String nCodificadoRequest = (request.getParameter("gangliosN"));
                            String mCodificadoRequest = (request.getParameter("metastasisM"));
                            if ((tCodificadoRequest != null && tCodificadoRequest.length() > 0) && (nCodificadoRequest != null
                                    && nCodificadoRequest.length() > 0) && (mCodificadoRequest != null && mCodificadoRequest.length() > 0)) {
                                tCodificado = Integer.parseInt(tCodificadoRequest);
                                nCodificado = Integer.parseInt(nCodificadoRequest);
                                mCodificado = Integer.parseInt(mCodificadoRequest);
                                System.out.println("T " + (tCodificado));
                                System.out.println("N " + (nCodificado));
                                System.out.println("M " + (mCodificado));

                                try {
                                    estadiajeTNM = estadiajeTNMServiceImpl.mostrarEstadiajeTNMPaciente(idPacientePotencial);
                                    System.out.println("Estadiaje ".concat(estadiajeTNM.toString()));
                                } catch (Exception ex) {
                                    estadiajeTNM = new EstadiajeTNM();
                                    System.out.println("Tratar de obtejer estadiaje ".concat(ex.getMessage()));
                                }

                                int idRegistroTNM = 0;
                                if (estadiajeTNM.getIdRegistroTNM() > 0) {

                                    idRegistroTNM = (estadiajeTNMServiceImpl.mostrarEstadiajeTNMPaciente(idPacientePotencial)).getIdRegistroTNM();
                                    estadiajeTNM.setIdRegistroTNM(idRegistroTNM);
                                    estadiajeTNM.setIdTCodificado(tCodificado);
                                    estadiajeTNM.setIdNCodificado(nCodificado);
                                    estadiajeTNM.setIdMCodificado(mCodificado);
                                    estadiajeTNMServiceImpl.actualizarEstadiajeTNM(estadiajeTNM);

                                } else {
                                    estadiajeTNM.setIdTCodificado(tCodificado);
                                    estadiajeTNM.setIdNCodificado(nCodificado);
                                    estadiajeTNM.setIdMCodificado(mCodificado);
                                    idRegistroTNM = estadiajeTNMServiceImpl.agregarEstadiajeTNM(estadiajeTNM);

                                }

                                System.out.println("Regristo TNM ".concat(String.valueOf(idRegistroTNM)));
                                System.out.println("REgistro diagnostico ".concat(registroDiagnostico.toString()));
                                if (registroDiagnostico.getIdRegistroDiagnostico() > 0) {
                                    registroDiagnostico.setIdRegistroTNM(idRegistroTNM);
                                    registroDiagnosticoServiceImpl.actualizarRegistroDiagnostico(registroDiagnostico);
                                } else {
                                    System.out.println("agregar registroDiagnostico ".concat(String.valueOf(registroDiagnostico.getIdRegistroDiagnostico())));
                                    registroDiagnostico.setIdRegistroTNM(idRegistroTNM);
                                    registroDiagnostico.setIdRegistroDiagnostico(registroDiagnosticoServiceImpl.agregarRegistroDiagnostico(registroDiagnostico));
                                    System.out.println("Agregado registroDiagnostico ".concat(String.valueOf(registroDiagnostico.getIdRegistroDiagnostico())));
                                }

                            } else {
                                System.out.println("sin tCodificado o nCodificado o mCodificado ");
                            }

                            //*************************************************Documento Estudio*********************************
                            //Resultado de Mastografia
                            DocumentoEstudio documentoEstudioMastografia = null;

                            int resultadoMastografia = 0;
                            String resultadoMastografiaRequest = (request.getParameter("ResultadoTipoMastografia"));
                            if (resultadoMastografiaRequest != null && resultadoMastografiaRequest.length() > 0) {
                                resultadoMastografia = Integer.parseInt(resultadoMastografiaRequest);

                                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                                Calendar cal = Calendar.getInstance();
                                Date dateMasto = Date.valueOf(dateFormat.format(cal.getTime()));

                                System.out.println(cal.getTime());

                                System.out.println(dateFormat.format(cal.getTime()).concat(" value from  ").concat(resultadoMastografiaRequest));

                                int idEstudio = Integer.parseInt(sapiProperties.getString("EstudioMastografia"));
                                int idLugarDelCuerpo = Integer.parseInt(sapiProperties.getString("mama"));

                                Cita citaPreconsulta = citaServicioImpl.mostrarCitaNavegacionPacientePotencial(idPacientePotencial);

                                System.out.println("Tipo Estudio ".concat(String.valueOf(idEstudio)));

                                documentoEstudioMastografia = documentoEstudioServicioImpl.mostrarDocumentoEstudioMasRecientePaciente(idEstudio, idPacientePotencial);
                                System.out.println("Docu Masto ".concat(documentoEstudioMastografia.toString()));
                                if (documentoEstudioMastografia.getIdDocumentoEstudio() > 0) {
                                    documentoEstudioMastografia.setIdEstudio(idEstudio);
                                    documentoEstudioMastografia.setIdPaciente(idPacientePotencial);
                                    documentoEstudioMastografia.setIdBirads(resultadoMastografia);
                                    documentoEstudioMastografia.setPrevio(0);
                                    documentoEstudioMastografia.setFechaEstudioResultado(dateMasto);
                                    documentoEstudioMastografia.setIdLugarDelCuerpo(idLugarDelCuerpo);
                                    documentoEstudioMastografia.setIdCita(citaPreconsulta.getIdCita());
                                    documentoEstudioMastografia.setEstatus(1);
                                    documentoEstudioServicioImpl.actualizarDocumentoEstudio(documentoEstudioMastografia);
                                } else {
                                    documentoEstudioMastografia.setIdEstudio(idEstudio);
                                    documentoEstudioMastografia.setIdPaciente(idPacientePotencial);
                                    documentoEstudioMastografia.setIdBirads(resultadoMastografia);
                                    documentoEstudioMastografia.setPrevio(0);
                                    documentoEstudioMastografia.setFechaEstudioResultado(dateMasto);
                                    documentoEstudioMastografia.setIdLugarDelCuerpo(idLugarDelCuerpo);
                                    documentoEstudioMastografia.setIdCita(citaPreconsulta.getIdCita());
                                    documentoEstudioServicioImpl.agregarDocumentoEstudio(documentoEstudioMastografia);
                                }
                                System.out.println("resultadoMastografia ".concat(String.valueOf(resultadoMastografia)));
                                System.out.println("Identificador de documentoEstudio ".concat(String.valueOf(documentoEstudioMastografia.getIdDocumentoEstudio())));
                            } else {
                                System.out.println("sin resultadoMastrografia ");
                            }

                            //Resltado Ultrasonido
                            DocumentoEstudio documentoEstudioUSG = null;
                            int resultadoUltrasonido = 0;
                            String resultadoUltrasonidoRequest = (request.getParameter("tipoUSG"));
                            if (resultadoUltrasonidoRequest != null && resultadoUltrasonidoRequest.length() > 0) {
                                resultadoUltrasonido = Integer.parseInt(resultadoUltrasonidoRequest);

                                int idEstudio;
                                int previo = 0;

                                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                                Calendar cal = Calendar.getInstance();
                                Date dateUsg = Date.valueOf(dateFormat.format(cal.getTime()));

                                idEstudio = Integer.parseInt(sapiProperties.getString("EstudioUltrasonido"));
                                int idLugarDelCuerpo = Integer.parseInt(sapiProperties.getString("mama"));

                                Cita citaPreconsulta = citaServicioImpl.mostrarCitaNavegacionPacientePotencial(idPacientePotencial);

                                documentoEstudioUSG = documentoEstudioServicioImpl.mostrarDocumentoEstudioMasRecientePaciente(idEstudio, idPacientePotencial);
                                System.out.println("Docu USG ".concat(documentoEstudioUSG.toString()));
                                if (documentoEstudioUSG.getIdDocumentoEstudio() > 0) {
                                    documentoEstudioUSG.setIdEstudio(idEstudio);
                                    documentoEstudioUSG.setIdPaciente(idPacientePotencial);
                                    documentoEstudioUSG.setIdBirads(resultadoUltrasonido);
                                    documentoEstudioUSG.setPrevio(previo);
                                    documentoEstudioUSG.setIdLugarDelCuerpo(idLugarDelCuerpo);
                                    documentoEstudioUSG.setFechaEstudioResultado(dateUsg);
                                    documentoEstudioUSG.setIdCita(citaPreconsulta.getIdCita());
                                    documentoEstudioUSG.setEstatus(1);
                                    documentoEstudioServicioImpl.actualizarDocumentoEstudio(documentoEstudioUSG);
                                } else {
                                    documentoEstudioUSG.setIdEstudio(idEstudio);
                                    documentoEstudioUSG.setIdPaciente(idPacientePotencial);
                                    documentoEstudioUSG.setIdBirads(resultadoUltrasonido);
                                    documentoEstudioUSG.setPrevio(previo);
                                    documentoEstudioUSG.setIdLugarDelCuerpo(idLugarDelCuerpo);
                                    documentoEstudioUSG.setFechaEstudioResultado(dateUsg);
                                    documentoEstudioUSG.setIdCita(citaPreconsulta.getIdCita());
                                    documentoEstudioServicioImpl.agregarDocumentoEstudio(documentoEstudioUSG);
                                }
                                System.out.println("resultadoUltrasonido " + (resultadoUltrasonido));
                            } else {
                                System.out.println("sin resultadoUltrasonido ");
                            }

                            //*************************************************************Biopsia*************************
                            //Tipo Histologico
                            Biopsia biopsia = biopsiaServicioImpl.mostrarUltimaBiopsiaPaciente(idPacientePotencial);
                            int tipoHistologico = 0;
                            String tipoHistologicoRequest = (request.getParameter("resultado-patologia"));
                            if (tipoHistologicoRequest != null && tipoHistologicoRequest.length() > 0) {
                                tipoHistologico = Integer.parseInt(tipoHistologicoRequest);
                                System.out.println("Resultado resultadoPatologiaPantalla5 " + (tipoHistologico));
                                biopsia.setIdTipoHistologico(tipoHistologico);
                                
                              
                                
                                
                            } else {
                                System.out.println("sin resultadoPatologiaPantalla5 ");
                            }

                            //Grado Histologico
                            int gradoHistologico = 0;
                            String gradoHistologicoRequest = (request.getParameter("grado-histologico"));
                            if (gradoHistologicoRequest != null && gradoHistologicoRequest.length() > 0) {
                                gradoHistologico = Integer.parseInt(gradoHistologicoRequest);
                                System.out.println("Grado gradoHistologico " + (gradoHistologico));
                                biopsia.setIdGradoHistologico(gradoHistologico);
                            } else {
                                System.out.println("sin gradoHistologico ");
                            }

                            //Receptor Her2
                            int receptorHer2 = 0;
                            String receptorHer2Request = (request.getParameter("receptor-her2"));
                            if (receptorHer2Request != null && receptorHer2Request.length() > 0) {
                                receptorHer2 = Integer.parseInt(receptorHer2Request);
                                System.out.println("receptorHer2 " + (receptorHer2));
                                biopsia.setIdHer2(receptorHer2);
                            } else {
                                System.out.println("sin receptorHer2 ");
                            }

                            //Receptor Fish
                            int receptorFish = 0;
                            String receptorFishRequest = (request.getParameter("receptor-fish"));
                            if (receptorFishRequest != null && receptorFishRequest.length() > 0) {
                                receptorFish = Integer.parseInt(receptorFishRequest);
                                System.out.println("receptorFish " + (receptorFish));
                                biopsia.setIdFish(receptorFish);
                            } else {
                                System.out.println("sin receptorFish ");
                            }

                            //Receptor Estrogeno
                            int receptorRe = 0;
                            String receptorReRequest = (request.getParameter("receptor-re"));
                            if (receptorReRequest != null && receptorReRequest.length() > 0) {
                                receptorRe = Integer.parseInt(receptorReRequest);
                                System.out.println("receptorRe " + (receptorRe));
                                biopsia.setIdReceptorEstrogeno(receptorRe);
                            } else {
                                System.out.println("sin receptorRe ");
                            }

                            //Receptor Progesterona
                            int receptorRp = 0;
                            String receptorRpRequest = (request.getParameter("receptor-rp"));
                            if (receptorRpRequest != null && receptorRpRequest.length() > 0) {
                                receptorRp = Integer.parseInt(receptorRpRequest);
                                System.out.println("receptorRp " + (receptorRp));
                                biopsia.setIdReceptorProgesterona(receptorRp);
                            } else {
                                System.out.println("sin etapaClinica ");
                            }

                            //Ki67
                            Ki67ServicioImpl ki67ServicioImpl=new Ki67ServicioImpl();
                            int ki67 = 0;
                            int idKi67 = 0;
                            String ki67Request = (request.getParameter("ki67"));
                            if (ki67Request != null && ki67Request.length() > 0) {
                                ki67 = Integer.parseInt(ki67Request);
                                idKi67=ki67ServicioImpl.mostrarKi67Nombre(ki67).getIdKi67();
                                System.out.println("idki67 " + (idKi67));
                                System.out.println("ki67 " + (ki67));

                                biopsia.setIdKi67(idKi67);
                            } else {
                                System.out.println("sin ki67 ");
                            }

                            if (tipoHistologico != 0 || gradoHistologico != 0 || receptorHer2 != 0 || receptorFish != 0
                                    || receptorRe != 0 || receptorRp != 0 || ki67 != 0) {

                                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                                Calendar cal = Calendar.getInstance();
                                Date dateBiopsia = Date.valueOf(dateFormat.format(cal.getTime()));

                                int biopsiaPrevia = 0;
                                int idTipoBiopsia = Integer.parseInt(sapiProperties.getString("BiopsiaBAAF"));

                                biopsia.setIdTipoBiopsia(idTipoBiopsia);
                                biopsia.setIdPaciente(idPacientePotencial);
                                biopsia.setPrevia(biopsiaPrevia);
                                biopsia.setFechaResultado(dateBiopsia);

                                System.out.println("BIOPSIA ".concat(biopsia.toString()));
                                if (biopsia.getIdBiopsia() > 0) {
                                    biopsiaServicioImpl.actualizarBiopsiaFormulario(biopsia);
                                    
                                    
                                } else {
                                    biopsiaServicioImpl.agregarBiopsiaFormulario(biopsia);
                                }
                                
                                
                                  if(tipoHistologico==16){
                                    String otroResultadoPatologiaPostRequest = request.getParameter("otroResultadoPatologiaPost");
                                    if(otroResultadoPatologiaPostRequest!=null && otroResultadoPatologiaPostRequest.length()>0){
                                        OtroResultadoPatologia otroResultado2 = otroResultadoServicio.mostrarOtroResultadoPatologiaIdBiopsia(biopsia.getIdBiopsia());
                                        
                                        if(otroResultado2!=null){
                                            otroResultado2.setNombre(otroResultadoPatologiaPostRequest);
                                            otroResultadoServicio.actualizarOtroResultadoPatologia(otroResultado2);
                                        }else{
                                            otroResultado2= new OtroResultadoPatologia();
                                            otroResultado2.setIdBiopsia(biopsia.getIdBiopsia());
                                            otroResultado2.setNombre(otroResultadoPatologiaPostRequest);
                                            otroResultadoServicio.agregarOtroResultadoPatologia(otroResultado2);
                                        }
                                    }
                                    
                                }else{
                                    
                                    String otroResultadoPatologiaPostRequest = "";
                                    if(otroResultadoPatologiaPostRequest!=null && otroResultadoPatologiaPostRequest.length()>0){
                                        OtroResultadoPatologia otroResultado2 = otroResultadoServicio.mostrarOtroResultadoPatologiaIdBiopsia(biopsia.getIdBiopsia());
                                        
                                        if(otroResultado2!=null){
                                            otroResultado2.setNombre(otroResultadoPatologiaPostRequest);
                                            otroResultadoServicio.actualizarOtroResultadoPatologia(otroResultado2);
                                        }else{
                                            otroResultado2= new OtroResultadoPatologia();
                                            otroResultado2.setIdBiopsia(biopsia.getIdBiopsia());
                                            otroResultado2.setNombre(otroResultadoPatologiaPostRequest);
                                            otroResultadoServicio.actualizarOtroResultadoPatologia(otroResultado2);
                                        }
                                    }
                                    
                                    
                                }
                                
                            }

                            //Cmbia el idRol del paciente
                            String cambiarRolRequest = request.getParameter("cambiarRol");
                            int cambiarRol;
                            int idCuentaPaciente;
                            if (cambiarRolRequest != null && cambiarRolRequest.length() > 0) {
                                cambiarRol = Integer.parseInt(cambiarRolRequest);
                                if (cambiarRol == 1) {
                                    CuentaServicioImpl cuentaServicioImpl = new CuentaServicioImpl();
                                    Cuenta cuentaPaciente = cuentaServicioImpl.mostrarCuenta(paciente.getIdCuenta());
                                    cuentaPaciente.setIdRol(5);
                                    cuentaServicioImpl.actualizarCuenta(cuentaPaciente);
                                }

                            }

                            break;
                        }

                        case "agregarCitaResultados": {

                            PrintWriter out = response.getWriter();

                            int idPaciente = Integer.parseInt(request.getParameter("idPaciente"));
                            String nombre = request.getParameter("nombre");
                            String fechaCita = request.getParameter("fechaCita");

                            //Servicio
                            MCalendarioNavegadoraServicioImpl navegadoraServicio = new MCalendarioNavegadoraServicioImpl();

                            //Objeto
                            MCalendarioNavegadora mCalendarioNavegadora = new MCalendarioNavegadora();
                            mCalendarioNavegadora.setIdPaciente(idPaciente);
                            mCalendarioNavegadora.setFechaCita(Date.valueOf(fechaCita));

                            int agregado = navegadoraServicio.agregarCitaPaciente(mCalendarioNavegadora);

                            System.out.println("AGREGADO ES: " + agregado);

                            System.out.println(idPaciente);
                            System.out.println(nombre);
                            System.out.println(fechaCita);

                            if (agregado > 0) {
                                out.print("success");
                            }

                            break;

                        }

                        case "obtenerEventosResultados": {

                            PrintWriter out = response.getWriter();

                            //Servicio
                            CalendarioServicioImpl csi = new CalendarioServicioImpl();

                            //Lista Calendarios
                            List<FullCalendar> calendarios = csi.mostrarEventosResultados();

                            response.setContentType("application/json");
                            response.setCharacterEncoding("UTF-8");

                            System.out.println(new Gson().toJson(calendarios));

                            out.print(new Gson().toJson(calendarios));

                            break;

                        }

                        case "autocompleteLugarDelCuerpo": {

                            LugarDelCuerpoServicioImpl lugarDelCuerpoServicioImpl = new LugarDelCuerpoServicioImpl();

                            List<LugarDelCuerpo> lugaresDelCuerpo = lugarDelCuerpoServicioImpl.mostrarLugarDelCuerpo();

                            for (int i = 0; i < lugaresDelCuerpo.size(); i++) {
                                System.out.println(lugaresDelCuerpo.get(i));
                            }

                            PrintWriter out = response.getWriter();

                            Gson json = new Gson();

                            out.print(json.toJson(lugaresDelCuerpo));

                            break;
                        }

                        case "autocompleteBiopsia": {

                            TipoBiopsiaServicioImpl tipoBiopsiaServicioImpl = new TipoBiopsiaServicioImpl();

                            List<TipoBiopsia> tipoBiosiaLista = tipoBiopsiaServicioImpl.mostrarListaTipoBiopsia();

                            PrintWriter out = response.getWriter();

                            Gson json = new Gson();

                            out.print(json.toJson(tipoBiosiaLista));

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

                            out.flush();
                            out.print(json.toJson(estudios));

                            break;

                        }

                        case "autocompleteMedicinaNuclear": {

                            AutocompletadoServicioImpl autocompletadoServicioImpl = new AutocompletadoServicioImpl();

                            List<Estudio> estudios = autocompletadoServicioImpl.mostrarEstudioMedicinaNuclear();

                            PrintWriter out = response.getWriter();

                            Gson json = new Gson();
                            out.flush();
                            out.print(json.toJson(estudios));

                            break;

                        }
                        case "autocompleteValoracion": {

                            AutocompletadoServicioImpl autocompletadoServicioImpl = new AutocompletadoServicioImpl();

                            List<Estudio> estudios = autocompletadoServicioImpl.mostrarEstudioValoracion();

                            PrintWriter out = response.getWriter();

                            Gson json = new Gson();
                            out.flush();
                            out.print(json.toJson(estudios));

                            break;

                        }
                        case "autocompletePrograma": {

                            AutocompletadoServicioImpl autocompletadoServicioImpl = new AutocompletadoServicioImpl();

                            List<Estudio> estudios = autocompletadoServicioImpl.mostrarEstudioProgramas();

                            PrintWriter out = response.getWriter();

                            Gson json = new Gson();
                            out.flush();
                            out.print(json.toJson(estudios));

                            break;

                        }

                        case "cancelarCitaPotencial": {
                            PrintWriter out = response.getWriter();
                            try {

                                int idPaciente = Integer.parseInt(request.getParameter("idPotencial"));
                                System.out.println("idPaciente: " + idPaciente);

                                CitaServicioImpl citaServicio = new CitaServicioImpl();
                                citaServicio.cancelarCitaPreconsulta(idPaciente);
                                System.out.println("Ya la canceló");

                                PersonaServicioImpl personaServicioImpl = new PersonaServicioImpl();
                                Persona personaPaciente = personaServicioImpl.mostrarPersonaPorIdPaciente(idPaciente);

                                PacienteServicioImpl pacienteServicioImpl = new PacienteServicioImpl();
                                Paciente Paciente = pacienteServicioImpl.mostrarPaciente(idPaciente);

                                CuentaServicioImpl cuentaServicioImpl = new CuentaServicioImpl();
                                Cuenta cuenta = cuentaServicioImpl.mostrarCuenta(Paciente.getIdCuenta());

                                enviaCorreo(cuenta.getUsuario(), personaPaciente.getCorreo());

                                out.print("1");
                            } catch (Exception ex) {
                                out.print("0");
                            }
                            break;

                        }

                    }

                    break;
                }

            }

        }
    }

    private Timestamp fechaStringToTimestamp(String fecha) {
        Timestamp timestamp = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = dateFormat.parse(fecha);
            timestamp = new Timestamp(date.getTime());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return timestamp;
    }

    protected void enviaCorreo(String usuario, String correo) {

        /**
         * El metodo enviaCorreo tiene como función el envío de un correo de
         * confirmación al Usuario registrado. Se recibe como parametro el
         * correo del Usuario. Mediante una cuenta ya introduciida dentro del
         * codigo se envía el correo. El contenido del correo puede ser
         * configurado en el mimeBodyPart.
         */
        System.out.println("estoy en el metodo");
        Properties config = new Properties();

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
            message.setSubject("Cita cancelada");
            //message.setText("Esto no es spam :)");

            //Estos deberían ir como parametros dentro de la función de enviar correo
            //String mail = "tucorreo@mail.com";
            //String contrasena = "tucontrasena";
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent("<b>Tu cita de navegacón y preconsulta han sido canceladas.</b></br>".
                    concat("<b>Usuario: ").
                    concat(usuario), "text/html");

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

        } catch (Exception ex) {
            System.out.println("catch de envia correo");
            System.out.println(this.getClass().toString().concat(ex.getMessage()));
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
