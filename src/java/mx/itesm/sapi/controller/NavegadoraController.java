/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.controller;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Base64;

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

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
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
                            
                            int idDocumentoInicial = (int) sesion.getAttribute("idDocumentoInicialVista");
                            String comentario = request.getParameter("comentario");
                            
                            System.out.println("rechazar Documento");
                            System.out.println("id Documento ".concat(String.valueOf(idDocumentoInicial)));
                            System.out.println("motivo rechazo  ".concat(String.valueOf(comentario)));

                            DocumentoInicialServicioImpl documentoInicialServicioImpl = new DocumentoInicialServicioImpl();
                            boolean rechazado = documentoInicialServicioImpl.agregarRechazoDocumento(idDocumentoInicial, comentario);
                            //ESto es para el correo
                         
                            int idPersona =  request.getParameter("idpersona");
                            PersonaServicioImpl personaServicio = PersonaServicioImpl();
                            Persona persona = personaServicio.mostrarPersona(idPersona);
                            
                            try {
                                config.load(getClass().getResourceAsStream("/mail.properties"));
                                Session session = Session.getInstance(config,
                                        new javax.mail.Authenticator() {
                                    protected PasswordAuthentication getPasswordAuthentication() {
                                        return new PasswordAuthentication("sapi.prueba@gmail.com", "prueba.Sapi1");

                                    }
                                });

                                //System.out.println("despues del try");
                                Message message = new MimeMessage(session);
                                message.setFrom(new InternetAddress("sapi.prueba@gmail.com"));
                                message.setRecipients(Message.RecipientType.TO,
                                        InternetAddress.parse(persona.getCorreo()));
                                message.setSubject("Recuperar Conraseña");
                                //message.setText("Esto no es spam :)");

                                //Estos deberían ir como parametros dentro de la función de enviar correo
                                //String mail = "tucorreo@mail.com";
                                //String contrasena = "tucontrasena";
                                MimeBodyPart mimeBodyPart = new MimeBodyPart();
                                mimeBodyPart.setContent("<b>Estimado usuario, usted ha solicitado Recuperar su Contraseña</b></br>".
                                        concat("<b>Su token para iniciar sesion es:  ").
                                        concat(comentario), "text/html");

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
                                request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);

                            } catch (Exception ex) {
                                System.out.println("catch de envia correo");
                                System.out.println(this.getClass().toString().concat(ex.getMessage()));
                            }
                            //Hasta aqui
                               System.out.println("Se rechazo ".concat(String.valueOf(rechazado)));
                            PrintWriter out = response.getWriter();
                            out.print(rechazado);
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
