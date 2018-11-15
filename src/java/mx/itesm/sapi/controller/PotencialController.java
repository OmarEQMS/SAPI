/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.controller;

import com.google.gson.Gson;
import static com.sun.xml.bind.util.CalendarConv.formatter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Base64;
import java.util.ResourceBundle;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import mx.itesm.sapi.bean.calendario.FullCalendar;
import mx.itesm.sapi.bean.persona.Cuenta;
import mx.itesm.sapi.bean.persona.Direccion;
import mx.itesm.sapi.bean.persona.Persona;
import mx.itesm.sapi.bean.persona.Pic;
import mx.itesm.sapi.bean.gestionPaciente.DocumentoInicial;
import mx.itesm.sapi.bean.gestionPaciente.Cita;
import mx.itesm.sapi.bean.gestionPaciente.CitaEmpleado;
import mx.itesm.sapi.bean.gestionPaciente.ComentarioCita;
import mx.itesm.sapi.bean.gestionPaciente.EstadoPacientePaciente;
import mx.itesm.sapi.bean.gestionPaciente.LlamadaCita;
import mx.itesm.sapi.bean.gestionPaciente.OtroMotivo;

import mx.itesm.sapi.bean.gestionPaciente.Paciente;
import mx.itesm.sapi.bean.gestionPaciente.PacienteAlergia;
import mx.itesm.sapi.bean.gestionPaciente.PacienteMedicoTitular;
import mx.itesm.sapi.bean.gestionPaciente.PacienteNavegadora;
import mx.itesm.sapi.bean.gestionPaciente.PacienteNecesidadEspecial;

import mx.itesm.sapi.bean.persona.Login;
import mx.itesm.sapi.service.gestionPaciente.CitaEmpleadoServicioImpl;

import mx.itesm.sapi.bean.gestionPaciente.SolicitudPreconsulta;
import mx.itesm.sapi.service.CalendarioServicioImpl;

import mx.itesm.sapi.service.persona.CuentaServicioImpl;
import mx.itesm.sapi.service.persona.PersonaServicioImpl;
import mx.itesm.sapi.service.persona.PicServicioImpl;

import mx.itesm.sapi.service.gestionPaciente.CitaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.ComentarioCitaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.DocumentoInicialServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.EstadoPacientePacienteServiceImpl;
import mx.itesm.sapi.service.gestionPaciente.LlamadaCitaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.OtroMotivoServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteNecesidadEspecialServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.SolicitudPreconsultaServicioImpl;

import mx.itesm.sapi.service.gestionPaciente.PacienteAlergiaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteMedicoTitularServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteNavegadoraServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteNecesidadEspecialServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteServiceImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteServicioImpl;
import mx.itesm.sapi.service.persona.DireccionServicioImpl;
import mx.itesm.sapi.service.persona.LoginServicioImpl;

//Checar los de las librerias de clases Apache
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author Fernanda Orduña
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50)
@WebServlet(name = "PotencialController", urlPatterns = {"/PotencialController"})
public class PotencialController extends HttpServlet {

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

        System.out.println("PotencialController Method ".concat(request.getMethod()));
        System.out.println("URL PotencialController: ".concat(request.getRequestURL().toString()));
        String key = null;
        try {
            key = request.getParameter("key");
            System.out.println("Key: ".concat(key));
        } catch (Exception ex) {
            System.out.println("SIN KEY PotencialController");
        }

        switch (key) {

            case "registrarCuenta": {

                /**
                 * Inicio de servicios
                 */
                // PersonaServicioImpl personaServicio = new PersonaServicioImpl();
                // CuentaServicioImpl cuentaServicio = new CuentaServicioImpl();
                // DireccionServicioImpl direccionServicio = new DireccionServicioImpl();
                //Reibe los parametros de persona
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
                String usuario = request.getParameter("usuario");

                //Inicialización de objeto persona
                Persona per = new Persona();

                per.setNombre(nombre);
                per.setTelefono(telefono);

                per.setPrimerApellido(apellido1);
                per.setSegundoApellido(apellido2);
                per.setCorreo(correo);
                per.setCurp(curp);
                //per.setIdEstado(estado);
                per.setIdEstadoCivil(estadoCivil);
                per.setIdMunicipio(municipio);
                //per.setFechaNacimiento(fechaNacimiento);

                //Set cuenta
                //Inicilizacion de cuenta
                Cuenta cuenta = new Cuenta();

                cuenta.setPassword(contraseña1);
                cuenta.setUsuario(usuario);

                //DIRECCION
                Direccion dir = new Direccion();

                dir.setCalle(calle);
                dir.setColonia(colonia);
                dir.setNoExterior(noExterior);
                dir.setNoInterior(noInterior);

                // int id = personaServicio.agregarPersona(per);
/*
                if (id > 0) {

                    cuenta.setIdPersona(id);
                    cuentaServicio.agregarCuenta(cuenta);
                    dir.setIdPersona(id);
                    direccionServicio.agregarDireccion(dir);
                    
                }
                 */
                break;
            }

            case "InicioPotencial": {

                request.getRequestDispatcher("/WEB-INF/potencial/index.jsp").forward(request, response);
                break;
            }

            case "guardarCambios": {
                System.out.println("Llegó al case de GuardarCambios");

                String correo = request.getParameter("myEmail");
                String telefono = request.getParameter("telephoneNum");
                Part part = request.getPart("file-image");

                System.out.println("Correo: ".concat(correo));
                System.out.println("Telefono: ".concat(telefono));

                HttpSession sesion = request.getSession(true); //Veo si tiene sesion iniciada
                if (sesion.getAttribute("idCuenta") == null) { //no tiene sesion iniciada
                    // request.setAttribute("status", "");
                    request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response); //Lo redirecciono al login                    
                } else { //Si tiene sesion iniciada
                    int keyRol = (int) sesion.getAttribute("idRol");
                    switch (keyRol) {
                        case 1: {

                            System.out.println("Entro al controller en guardarCambios");

                            //No se valida el telefono ni el correo aquí? Lo validamos nosotros o el front?
                            PersonaServicioImpl personaServiceImpl = new PersonaServicioImpl();
                            Persona persona = personaServiceImpl.mostrarPersona((int) sesion.getAttribute("idPersona"));

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

                            persona.setCorreo(correo);
                            persona.setTelefono(telefono);

                            personaServiceImpl.actualizarPersona(persona);

                        }

                    }
                }
                break;

            }

            case "cambiarContrasena": {
                HttpSession sesion = request.getSession(true); //Veo si tiene sesion iniciada
                if (sesion.getAttribute("idCuenta") == null) { //no tiene sesion iniciada
                    // request.setAttribute("status", "");
                    request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response); //Lo redirecciono al login

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

                    //Comentario para hacer commit x2 xdxdxd
                }
                break;
            }

            case "solicitarPreconsulta": {
                /**
                 * Uriel Díaz 26/10/2018.
                 *
                 * El presente case funciona cuando un paciente agrega ciertos
                 * atributos y documentos al proceso de solicitud de preconsulta
                 * sin enviarla.
                 *
                 */
                //Obtener la sesion
                HttpSession sesion = request.getSession(true);

                if (sesion.getId() == null) {
                    //TODO 
                } else {

                    Map<String, String> respuestaSolicitud = new HashMap<>();
                    PrintWriter out = response.getWriter();
                    Gson json = new Gson();

                    int idPacientePotencial = (int) sesion.getAttribute("idPaciente");

                    ResourceBundle sapiProperties = ResourceBundle.getBundle("mx.itesm.sapi.properties.catalogos");

                    // ID TipoDocumento inicial
                    int idEstudioPrevio = Integer.parseInt(sapiProperties.getString("EstudioPrevio"));
                    int idBiopsiaPrevia = Integer.parseInt(sapiProperties.getString("BiopsiaPrevia"));
                    int idIdentificacion = Integer.parseInt(sapiProperties.getString("IdentificacionOficial"));
                    int idComprobanteDomicilio = Integer.parseInt(sapiProperties.getString("ComprobanteDomicilio"));
                    int idReferenciaMedico = Integer.parseInt(sapiProperties.getString("ReferenciaMedico"));
                    int idCURP = Integer.parseInt(sapiProperties.getString("CURP"));
                    int idMastografia = Integer.parseInt(sapiProperties.getString("Mastografia"));
                    int idUltrasonido = Integer.parseInt(sapiProperties.getString("Ultrasonido"));

                    //ID TipoCita
                    int idPreconsulta = Integer.parseInt(sapiProperties.getString("Preconsulta"));

                    //ID EstadoCita
                    int idPendiente = Integer.parseInt(sapiProperties.getString("Pendiente"));

                    // ID ImportanciaCita
                    int idImportante = Integer.parseInt(sapiProperties.getString("Importante"));

                    // ID Sexo
                    int idSexoMujer = Integer.parseInt(sapiProperties.getString("Mujer"));
                    int idSexoHombre = Integer.parseInt(sapiProperties.getString("Hombre"));

                    // ID Necesidad Especial
                    int idSillaDeRuedas = Integer.parseInt(sapiProperties.getString("SillaDeRuedas"));
                    int idCamilla = Integer.parseInt(sapiProperties.getString("Baston"));
                    int idBaston = Integer.parseInt(sapiProperties.getString("Oxigeno"));
                    int idOxigeno = Integer.parseInt(sapiProperties.getString("Camilla"));

                    if (ServletFileUpload.isMultipartContent(request)) {
                        System.out.println("Entro a solicitarPreconsulta if ");

                        String masculino = request.getParameter("masculino");
                        System.out.println("Values masculino ".concat(masculino));

                        String femenino = request.getParameter("femenino");
                        System.out.println("Values femenino ".concat(femenino));

                        String sillaDeRuedas = request.getParameter("sillaDeRuedas");
                        System.out.println("Silla ".concat(sillaDeRuedas));

                        String camilla = request.getParameter("camilla");
                        System.out.println("Camilla ".concat(camilla));

                        String baston = request.getParameter("baston");
                        System.out.println("bastón ".concat(baston));

                        String oxigeno = request.getParameter("oxigeno");
                        System.out.println("oxigeno ".concat(oxigeno));

                        String motivoConsulta = request.getParameter("motivoConsulta");
                        System.out.println("motivoConsulta ".concat(motivoConsulta));

                        int biopsia = Integer.parseInt(request.getParameter("biopsia"));
                        System.out.println("biopsia ".concat(String.valueOf(biopsia)));

                        boolean booleanMotivo = true;
                        boolean booleanSexo = true;

                        //Verificar si se seleccionó un motivo
                        if (motivoConsulta.equals("0")) {
                            System.out.println("No motivo :(");
                            booleanMotivo = false;
                        }

                        //Agregar sexo al paciente
                        if (masculino.equals("1")) {
                            PersonaServicioImpl personaServicioImpl = new PersonaServicioImpl();
                            System.out.println("Actualizar a hombre");
                            personaServicioImpl.actualizarSexoPersona(idPacientePotencial, idSexoHombre);

                        } else {
                            if (femenino.equals("1")) {
                                PersonaServicioImpl personaServicioImpl = new PersonaServicioImpl();
                                System.out.println("Actualizar a mujer");
                                personaServicioImpl.actualizarSexoPersona(idPacientePotencial, idSexoMujer);
                            } else {
                                booleanSexo = false;
                            }
                        }

                        //AGREGAR NECESIDADES ESPECIALES AL PACIENTE
                        //Agregar la silla de ruedas, camilla, baston y oxigeno si los necesita
                        if (!sillaDeRuedas.equals("0")) {
                            PacienteNecesidadEspecial pacienteNecesidadEspecial = new PacienteNecesidadEspecial();
                            pacienteNecesidadEspecial.setIdPaciente(idPacientePotencial);
                            pacienteNecesidadEspecial.setIdNecesidadEspecial(idSillaDeRuedas);

                            PacienteNecesidadEspecialServicioImpl pacienteNecesidadEspecialServicio = new PacienteNecesidadEspecialServicioImpl();
                            pacienteNecesidadEspecialServicio.agregarPacienteNecesidadEspecial(pacienteNecesidadEspecial);
                        }
                        if (!camilla.equals("0")) {
                            PacienteNecesidadEspecial pacienteNecesidadEspecial = new PacienteNecesidadEspecial();
                            pacienteNecesidadEspecial.setIdPaciente(idPacientePotencial);
                            pacienteNecesidadEspecial.setIdNecesidadEspecial(idCamilla);

                            PacienteNecesidadEspecialServicioImpl pacienteNecesidadEspecialServicio = new PacienteNecesidadEspecialServicioImpl();
                            pacienteNecesidadEspecialServicio.agregarPacienteNecesidadEspecial(pacienteNecesidadEspecial);
                        }
                        if (!baston.equals("0")) {
                            PacienteNecesidadEspecial pacienteNecesidadEspecial = new PacienteNecesidadEspecial();
                            pacienteNecesidadEspecial.setIdPaciente(idPacientePotencial);
                            pacienteNecesidadEspecial.setIdNecesidadEspecial(idBaston);

                            PacienteNecesidadEspecialServicioImpl pacienteNecesidadEspecialServicio = new PacienteNecesidadEspecialServicioImpl();
                            pacienteNecesidadEspecialServicio.agregarPacienteNecesidadEspecial(pacienteNecesidadEspecial);
                        }
                        if (!oxigeno.equals("0")) {
                            PacienteNecesidadEspecial pacienteNecesidadEspecial = new PacienteNecesidadEspecial();
                            pacienteNecesidadEspecial.setIdPaciente(idPacientePotencial);
                            pacienteNecesidadEspecial.setIdNecesidadEspecial(idOxigeno);

                            PacienteNecesidadEspecialServicioImpl pacienteNecesidadEspecialServicio = new PacienteNecesidadEspecialServicioImpl();
                            pacienteNecesidadEspecialServicio.agregarPacienteNecesidadEspecial(pacienteNecesidadEspecial);
                        }

                        Part partIdentificacion = null;
                        boolean booleanIdentificacion = true;
                        try {
                            partIdentificacion = request.getPart("fileIdentificacion");
                            System.out.println(partIdentificacion.toString());

                        } catch (Exception ex) {
                            booleanIdentificacion = false;
                        }

                        //System.out.println("PartIdentificacion ".concat(partIdentificacion.toString()));
                        //System.out.println("PartIdentificacion lenghtname ".concat(partIdentificacion.getName().length() + " " + partIdentificacion.getSubmittedFileName().length()));
                        //System.out.println("PartIdentificacion type ".concat(partIdentificacion.getContentType()));
                        //String partName = partIdentificacion.getName();
                        InputStream contenidoIdentificacion = null;
                        String strIdentificacion = null;
                        String tipoIdentficacion = null;
                        int tamanoIdentificacion = 0;

                        if (booleanIdentificacion) {
                            if (partIdentificacion.getSubmittedFileName().length() > 0 && (partIdentificacion.getContentType().equals("image/jpeg") || partIdentificacion.getContentType().equals("application/pdf") || partIdentificacion.getContentType().equals("image/png") || partIdentificacion.getContentType().equals(" application/msword") || partIdentificacion.getContentType().equals(" application/msword") || partIdentificacion.getContentType().equals(" application/vnd.ms-excel"))) {

                                strIdentificacion = partIdentificacion.getSubmittedFileName();
                                contenidoIdentificacion = partIdentificacion.getInputStream();
                                tipoIdentficacion = partIdentificacion.getContentType();

                                tamanoIdentificacion = (int) partIdentificacion.getSize();
                                System.out.println("Identificacion ".concat(strIdentificacion).concat(" ").concat(partIdentificacion.getContentType()));
                            }

                        }

                        Part partCURP = null;
                        boolean booleanCURP = true;

                        try {
                            partCURP = request.getPart("fileCURP");
                            System.out.println("Part CURP ".concat(partCURP.getSubmittedFileName()));
                        } catch (Exception ex) {
                            booleanCURP = false;
                        }

                        InputStream contenidoCURP = null;
                        String strCurp = null;
                        String tipoCurp = null;
                        int tamanoCurp = 0;

                        if (booleanCURP) {
                            if (partCURP.getSubmittedFileName().length() > 0 && (partCURP.getContentType().equals("image/jpeg") || partCURP.getContentType().equals("application/pdf") || partCURP.getContentType().equals("image/png") || partCURP.getContentType().equals(" application/msword") || partCURP.getContentType().equals(" application/msword") || partCURP.getContentType().equals(" application/vnd.ms-excel"))) {
                                strCurp = partCURP.getSubmittedFileName();
                                contenidoCURP = partCURP.getInputStream();
                                tipoCurp = partCURP.getContentType();

                                tamanoCurp = (int) partCURP.getSize();
                                System.out.println("nombre del curp ".concat(strCurp));
                            }
                        }

                        Part partComprobanteDomicilio = null;
                        boolean booleanComprobante = true;
                        try {
                            partComprobanteDomicilio = request.getPart("fileComprobanteDomicilio");
                        } catch (Exception ex) {
                            booleanComprobante = false;
                        }

                        InputStream contenidoComprobanteDomicilio = null;
                        String strComprobante = null;
                        String tipoComprobanteDomicilio = null;
                        int tamanoComprobanteDomicilio = 0;

                        if (booleanComprobante) {
                            if (partComprobanteDomicilio.getSubmittedFileName().length() > 0 && (partComprobanteDomicilio.getContentType().equals("image/jpeg") || partComprobanteDomicilio.getContentType().equals("application/pdf") || partComprobanteDomicilio.getContentType().equals("image/png") || partComprobanteDomicilio.getContentType().equals(" application/msword") || partComprobanteDomicilio.getContentType().equals(" application/msword") || partComprobanteDomicilio.getContentType().equals(" application/vnd.ms-excel"))) {

                                strComprobante = partComprobanteDomicilio.getSubmittedFileName();
                                tipoComprobanteDomicilio = partComprobanteDomicilio.getContentType();
                                contenidoComprobanteDomicilio = partComprobanteDomicilio.getInputStream();
                                tamanoComprobanteDomicilio = (int) partComprobanteDomicilio.getSize();
                                System.out.println("comprobante ".concat(strComprobante));
                            }
                        }

                        //Verficiar si se han subido todos
                        if (!booleanIdentificacion || !booleanCURP || !booleanComprobante || !booleanMotivo || !booleanSexo) {

                            out.print("documentosNoSubidos");

                        } else {

                            Part partMastoPrevia = null;
                            boolean booleanMastoPrevia = true;

                            try {
                                partMastoPrevia = request.getPart("fileEstudioPrevioMasto");
                            } catch (Exception ex) {
                                booleanMastoPrevia = false;
                            }

                            InputStream contenidoMastoPrevia = null;
                            String strMastoPrevia = null;
                            String tipoMastoPrevia = null;
                            int tamanoMastoPrevia = 0;

                            if (booleanMastoPrevia) {

                                if (partMastoPrevia.getSubmittedFileName().length() > 0 && (partMastoPrevia.getContentType().equals("image/jpeg") || partMastoPrevia.getContentType().equals("application/pdf") || partMastoPrevia.getContentType().equals("image/png") || partMastoPrevia.getContentType().equals(" application/msword") || partMastoPrevia.getContentType().equals(" application/msword") || partMastoPrevia.getContentType().equals(" application/vnd.ms-excel"))) {

                                    strMastoPrevia = partMastoPrevia.getSubmittedFileName();
                                    tipoMastoPrevia = partMastoPrevia.getContentType();
                                    contenidoMastoPrevia = partMastoPrevia.getInputStream();
                                    tamanoMastoPrevia = (int) partMastoPrevia.getSize();
                                    System.out.println("Masto ".concat(strMastoPrevia));
                                }
                            }

                            Part partUltrasonidoPrevio = null;
                            boolean booleanUltraSonidoPrevio = true;
                            partUltrasonidoPrevio = request.getPart("fileEstudioPrevioUsg");
                            InputStream contenidoPartUltrasonidoPrevio = null;
                            String strUltrasonido = null;
                            String tipoUltrasonido = null;
                            int tamanoUltrasonido = 0;

                            if (booleanUltraSonidoPrevio) {

                                if (partUltrasonidoPrevio.getSubmittedFileName().length() > 0 && (partUltrasonidoPrevio.getContentType().equals("image/jpeg") || partUltrasonidoPrevio.getContentType().equals("application/pdf") || partUltrasonidoPrevio.getContentType().equals("image/png") || partUltrasonidoPrevio.getContentType().equals(" application/msword") || partUltrasonidoPrevio.getContentType().equals(" application/msword") || partUltrasonidoPrevio.getContentType().equals(" application/vnd.ms-excel"))) {

                                    strUltrasonido = partUltrasonidoPrevio.getSubmittedFileName();
                                    contenidoPartUltrasonidoPrevio = partUltrasonidoPrevio.getInputStream();
                                    tipoUltrasonido = partUltrasonidoPrevio.getContentType();
                                    tamanoUltrasonido = (int) partUltrasonidoPrevio.getSize();
                                    System.out.println("USG ".concat(strUltrasonido));
                                }

                            }

                            Part partEstudioBiopsia = null;
                            boolean booleanEstudioBiopsia = true;
                            partEstudioBiopsia = request.getPart("fileEstudioBiopsia");
                            InputStream contenidoEstudioBiopsia = null;
                            String strBiopsia = null;
                            String tipoBiopsia = null;
                            int tamanoBiopsia = 0;

                            if (booleanEstudioBiopsia) {

                                if (partEstudioBiopsia.getSubmittedFileName().length() > 0 && (partEstudioBiopsia.getContentType().equals("image/jpeg") || partEstudioBiopsia.getContentType().equals("application/pdf") || partEstudioBiopsia.getContentType().equals("image/png") || partEstudioBiopsia.getContentType().equals(" application/msword") || partEstudioBiopsia.getContentType().equals(" application/msword") || partEstudioBiopsia.getContentType().equals(" application/vnd.ms-excel"))) {
                                    strBiopsia = partEstudioBiopsia.getSubmittedFileName();

                                    contenidoEstudioBiopsia = partEstudioBiopsia.getInputStream();
                                    tipoBiopsia = partEstudioBiopsia.getContentType();
                                    tamanoBiopsia = (int) partEstudioBiopsia.getSize();
                                    System.out.println("Biopsia ".concat(strBiopsia));
                                }
                            }

                            Part partReferenciaArchivo = null;
                            boolean booleanReferenciaArchivo = true;
                            partReferenciaArchivo = request.getPart("referenciaArchivo");
                            InputStream contenidoReferenciaArchivo = null;
                            String strReferencia = null;
                            String tipoArchivo = null;
                            int tamanoArchivo = 0;

                            if (motivoConsulta.equals("1") || motivoConsulta.equals("4")) {
                                if (booleanReferenciaArchivo == true) {

                                    if (partReferenciaArchivo.getSubmittedFileName().length() > 0 && (partReferenciaArchivo.getContentType().equals("image/jpeg") || partReferenciaArchivo.getContentType().equals("application/pdf") || partReferenciaArchivo.getContentType().equals("image/png") || partReferenciaArchivo.getContentType().equals(" application/msword") || partReferenciaArchivo.getContentType().equals(" application/msword") || partReferenciaArchivo.getContentType().equals(" application/vnd.ms-excel"))) {

                                        strReferencia = partReferenciaArchivo.getSubmittedFileName();
                                        contenidoReferenciaArchivo = partReferenciaArchivo.getInputStream();
                                        tipoArchivo = partReferenciaArchivo.getContentType();
                                        tamanoArchivo = (int) partReferenciaArchivo.getSize();
                                        System.out.println("Referencia médico ".concat(strReferencia));

                                    }
                                }
                            }

                            DocumentoInicial docIdentificacion = null;
                            if (contenidoIdentificacion != null) {

                                docIdentificacion = new DocumentoInicial();
                                docIdentificacion.setIdPaciente(idPacientePotencial);
                                docIdentificacion.setArchivo(contenidoIdentificacion);
                                docIdentificacion.setIdTipoDocumento(idIdentificacion);
                                docIdentificacion.setTipo(tipoIdentficacion);
                                docIdentificacion.setTamano(tamanoIdentificacion);
                                docIdentificacion.setNombre(strIdentificacion);
                                docIdentificacion.setEstatus(1);
                            }

                            DocumentoInicial docCURP = null;
                            if (contenidoCURP != null) {
                                docCURP = new DocumentoInicial();
                                docCURP.setIdPaciente(idPacientePotencial);
                                docCURP.setArchivo(contenidoCURP);
                                docCURP.setIdTipoDocumento(idCURP);
                                docCURP.setTipo(tipoCurp);
                                docCURP.setTamano(tamanoCurp);
                                docCURP.setNombre(strCurp);
                                docCURP.setEstatus(1);
                            }

                            DocumentoInicial docComprobanteDomicilio = null;
                            if (contenidoComprobanteDomicilio != null) {

                                docComprobanteDomicilio = new DocumentoInicial();
                                docComprobanteDomicilio.setIdPaciente(idPacientePotencial);
                                docComprobanteDomicilio.setArchivo(contenidoComprobanteDomicilio);
                                docComprobanteDomicilio.setIdTipoDocumento(idComprobanteDomicilio);
                                docComprobanteDomicilio.setTipo(tipoComprobanteDomicilio);
                                docComprobanteDomicilio.setTamano(tamanoComprobanteDomicilio);
                                docComprobanteDomicilio.setNombre(tipoCurp);
                                docComprobanteDomicilio.setEstatus(1);
                            }

                            DocumentoInicial docMasto = null;
                            if (contenidoMastoPrevia != null) {
                                docMasto = new DocumentoInicial();
                                docMasto.setIdPaciente(idPacientePotencial);
                                docMasto.setArchivo(contenidoMastoPrevia);
                                docMasto.setIdTipoDocumento(idMastografia);
                                docMasto.setTipo(tipoMastoPrevia);
                                docMasto.setTamano(tamanoMastoPrevia);
                                docMasto.setNombre(strMastoPrevia);
                                docMasto.setEstatus(1);
                            }

                            DocumentoInicial docUltraSonido = null;
                            if (contenidoPartUltrasonidoPrevio != null) {
                                docUltraSonido = new DocumentoInicial();
                                docUltraSonido.setIdPaciente(idPacientePotencial);
                                docUltraSonido.setArchivo(contenidoPartUltrasonidoPrevio);
                                docUltraSonido.setIdTipoDocumento(idUltrasonido);
                                docUltraSonido.setTipo(tipoUltrasonido);
                                docUltraSonido.setTamano(tamanoUltrasonido);
                                docUltraSonido.setNombre(strUltrasonido);
                                docUltraSonido.setEstatus(1);
                            }

                            DocumentoInicial docBiopsia = null;
                            if (contenidoEstudioBiopsia != null) {
                                docBiopsia = new DocumentoInicial();
                                docBiopsia.setIdPaciente(idPacientePotencial);
                                docBiopsia.setArchivo(contenidoEstudioBiopsia);
                                docBiopsia.setIdTipoDocumento(idBiopsiaPrevia);
                                docBiopsia.setTipo(tipoBiopsia);
                                docBiopsia.setTamano(tamanoBiopsia);
                                docBiopsia.setNombre(strBiopsia);
                                docBiopsia.setEstatus(1);
                            }

                            //SERVICIOS
                            int idIdentificacionBD = -1;
                            if (docIdentificacion != null) {
                                DocumentoInicialServicioImpl documentoInicialIdentificacion = new DocumentoInicialServicioImpl();
                                idIdentificacionBD = documentoInicialIdentificacion.agregarDocumentoInicialPreconsulta(docIdentificacion);
                            }

                            int idCURPDB = -1;
                            if (docCURP != null) {
                                DocumentoInicialServicioImpl documentoInicialCURP = new DocumentoInicialServicioImpl();
                                idCURPDB = documentoInicialCURP.agregarDocumentoInicialPreconsulta(docCURP);
                            }

                            int idComprobanteDB = -1;
                            if (docComprobanteDomicilio != null) {
                                DocumentoInicialServicioImpl documentoInicialComprobante = new DocumentoInicialServicioImpl();
                                idComprobanteDB = documentoInicialComprobante.agregarDocumentoInicialPreconsulta(docComprobanteDomicilio);
                            }

                            int idMastoDB = -1;
                            if (docMasto != null) {
                                DocumentoInicialServicioImpl documentoInicialMasto = new DocumentoInicialServicioImpl();
                                idMastoDB = documentoInicialMasto.agregarDocumentoInicialPreconsulta(docMasto);
                            }

                            int idUltrasonidoDB = -1;
                            if (docUltraSonido != null) {
                                DocumentoInicialServicioImpl documentoInicialUltrasonido = new DocumentoInicialServicioImpl();
                                idUltrasonidoDB = documentoInicialUltrasonido.agregarDocumentoInicialPreconsulta(docUltraSonido);
                            }

                            int idBiopsiaPreviaDB = -1;
                            if (biopsia == 1 && docBiopsia != null) {
                                DocumentoInicialServicioImpl documentoInicialBiopia = new DocumentoInicialServicioImpl();
                                idBiopsiaPreviaDB = documentoInicialBiopia.agregarDocumentoInicialPreconsulta(docBiopsia);
                            }

                            //Se utilizará para guardar la fecha de solicitud de preconsulta
                            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

                            Cita citaPreconsulta = new Cita();
                            citaPreconsulta.setIdTipoCita(idPreconsulta);
                            citaPreconsulta.setIdPaciente(idPacientePotencial);
                            citaPreconsulta.setIdEstadoCita(idPendiente);
                            citaPreconsulta.setIdImportanciaCita(idImportante);
                            citaPreconsulta.setIdMotivoConsulta(Integer.parseInt(motivoConsulta));
                            citaPreconsulta.setHospitalProcedencia("\'NULL\'");//Se coloca NULL por si no hay otro hospital de referencia y MySQL lo reconozca.

                            switch (motivoConsulta) {
                                case "1": {

                                    DocumentoInicial docReferencia = null;
                                    if (contenidoReferenciaArchivo != null) {
                                        docReferencia = new DocumentoInicial();
                                        docReferencia.setIdPaciente(idPacientePotencial);
                                        docReferencia.setArchivo(contenidoReferenciaArchivo);
                                        docReferencia.setIdTipoDocumento(idReferenciaMedico);
                                        docReferencia.setTipo(tipoArchivo);
                                        docReferencia.setTamano(tamanoArchivo);
                                        docReferencia.setNombre(strReferencia);
                                        docReferencia.setEstatus(1);
                                    }

                                    if (docReferencia != null) {
                                        DocumentoInicialServicioImpl documentoInicialReferencia = new DocumentoInicialServicioImpl();
                                        documentoInicialReferencia.agregarDocumentoInicialPreconsulta(docReferencia);
                                    }
                                    break;
                                }
                                case "4": {

                                    String otroHospital = null;
                                    boolean booleanOtroHospital = true;

                                    try {
                                        otroHospital = request.getParameter("otroHospital");
                                        System.out.println("otro hospital ".concat(otroHospital));
                                    } catch (Exception ex) {
                                        booleanOtroHospital = false;
                                    }

                                    if (booleanOtroHospital) {

                                        citaPreconsulta.setHospitalProcedencia(otroHospital);
                                        DocumentoInicial docReferencia = null;

                                        if (contenidoReferenciaArchivo != null) {
                                            docReferencia = new DocumentoInicial();
                                            docReferencia.setIdPaciente(idPacientePotencial);
                                            docReferencia.setArchivo(contenidoReferenciaArchivo);
                                            docReferencia.setIdTipoDocumento(idReferenciaMedico);
                                            docReferencia.setTipo(tipoArchivo);
                                            docReferencia.setTamano(tamanoArchivo);
                                            docReferencia.setNombre(strReferencia);
                                            docReferencia.setEstatus(1);
                                        }

                                        if (docReferencia != null) {
                                            DocumentoInicialServicioImpl documentoInicialReferencia = new DocumentoInicialServicioImpl();
                                            documentoInicialReferencia.agregarDocumentoInicialPreconsulta(docReferencia);
                                        }
                                    }

                                    break;
                                }
                                default: {
                                    //Continuar
                                    break;
                                }
                            }

                            /*DEBUG*/
                            citaPreconsulta.setFechaSolicitud((timestamp).toString());

                            System.out.println("Cita ".concat(String.valueOf(citaPreconsulta.getIdPaciente())));
                            System.out.println("Cita ".concat(String.valueOf(citaPreconsulta.getIdMotivoConsulta())));
                            System.out.println("Cita ".concat(citaPreconsulta.getHospitalProcedencia()));
                            System.out.println("Cita ".concat(citaPreconsulta.getFechaSolicitud()));

                            CitaServicioImpl citaServicioImpl = new CitaServicioImpl();
                            int idCitaPreconsulta = citaServicioImpl.agregarPreconsulta(citaPreconsulta);

                            System.out.println("Identificacion ".concat(String.valueOf(idIdentificacionBD)));
                            System.out.println("CURP ".concat(String.valueOf(idCURPDB)));
                            System.out.println("Comprobante ".concat(String.valueOf(idComprobanteDB)));
                            System.out.println("Masto ".concat(String.valueOf(idMastoDB)));
                            System.out.println("Ultrasonido ".concat(String.valueOf(idUltrasonidoDB)));
                            System.out.println("Biopsia ".concat(String.valueOf(idBiopsiaPreviaDB)));
                            System.out.println("Preconsulta ".concat(String.valueOf(idCitaPreconsulta)));

                            if ("5".equals(motivoConsulta)) {

                                String otroMotivo = request.getParameter("otroMotivo");
                                System.out.println("Otro motivo: ".concat(otroMotivo));

                                OtroMotivo motivo = new OtroMotivo();
                                motivo.setIdCita(idCitaPreconsulta);
                                motivo.setNombre(otroMotivo);
                                motivo.setEstatus(1);

                                OtroMotivoServicioImpl otroMotivoServicioImpl = new OtroMotivoServicioImpl();
                                otroMotivoServicioImpl.agregarOtroMotivo(motivo);
                            }

                            if (idCitaPreconsulta != 0) {
                                respuestaSolicitud.put("Respuesta", "Si cita");
                            } else {
                                respuestaSolicitud.put("Respuesta", "No cita");
                            }

                            String res = json.toJson(respuestaSolicitud);
                            System.out.println("Res solictud preconsulta".concat(res));
                            out.print(res);

//                            request.getRequestDispatcher("WEB-INF/potencial/index.jsp").forward(request, response);

                        }
                    }
                }
                break;
            }

            /**
             * Author Angel Gtz
             */
            case "eliminarCuentaPacientePotencial": {
                System.out.println("Si llego aqui potencial");
                HttpSession sesion = request.getSession(true);
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
                     * Obtengo los id's perifericos de la sesion
                     */
                    int idCuenta = (int) sesion.getAttribute("idCuenta");
                    int idPaciente = (int) sesion.getAttribute("idPaciente");
                    int idPersona = (int) sesion.getAttribute("idPersona");
                    System.out.println(idPaciente);
                    System.out.println(idCuenta);
                    System.out.println(idPersona);

                    /**
                     * creo los objetos de las tablas a modificar su estatus
                     */
                    /**
                     * Se comprueba que los objetos no sean nulos o vacios para
                     * crearlos al crearlos si tienen dependencia ciclan para
                     * buscar todos los datos que tienen encadenados para
                     * proseguir con el borrado logico en la base de datos
                     */
                    CuentaServicioImpl cuentaServicio = new CuentaServicioImpl();

                    PersonaServicioImpl personaServicio = new PersonaServicioImpl();

                    Persona persona = personaServicio.mostrarPersona(idPersona);
                    personaServicio.borradoLogicoPersona(persona.getIdPersona());

                    PacienteServiceImpl pacienteServicio = new PacienteServiceImpl();
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

                    /**
                     * Al no tener cuenta se le redirecciona al login
                     */
                    request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);

                }
                break;
            }

            case "obtenerEventos": {

                String idPaciente = request.getParameter("idPaciente");
                System.out.println("El idPaciente es: " + idPaciente);
                HttpSession sesion = request.getSession(true); //Veo si tiene sesion iniciada

                //Servicio
                CalendarioServicioImpl csi = new CalendarioServicioImpl();

                //Lista Calendarios
                List<FullCalendar> calendarios = csi.mostrarEventos(Integer.parseInt(idPaciente));

                boolean revisarPre = true;
                boolean revisarNav = true;

                System.out.println("------------------------------------------------------------------------------------------------------------------------------");

                for (FullCalendar calendario : calendarios) {
                    if (calendario.getTitle().equals("Preconsulta") && revisarPre) {
                        System.out.println("La fecha preconsulta es: " + calendario.getStart());
                        sesion.setAttribute("fechaPreConsulta", calendario.getStart());
                        revisarPre = false;
                    }

                    if (calendario.getTitle().equals("Navegación") && revisarNav) {
                        System.out.println("La fecha navegacion es: " + calendario.getStart());
                        sesion.setAttribute("fechaNavegacion", calendario.getStart());
                        revisarNav = false;
                    }
                }

                System.out.println("------------------------------------------------------------------------------------------------------------------------------");

                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");

                PrintWriter out = response.getWriter();
                out.print(new Gson().toJson(calendarios));

                break;

            }
            /*
            case "zonaPorCp": {

                 //Inicio servicios
                //CodigoPostalServicioImpl codigoServicio = new CodigoPostalServicioImpl();
                //MunicipioServicioImpl municipio = new MunicipioServicio();
                //EstadoServicioImpl estado = new EstadoServicioImpl();
                
                //Recibe el codigo postal, 
                String CP=request.getParameter("CP");
                
                 
                //Recupero id del municipio a traves de un servicio de codigo porstal que utiliza un idCp
                int idMunicipio = codigoServicio.darIdMunicipio(CP);
                //Recupero el nombre del municipio
                String nombreMunicipio= municipio.mostrar(idMunicipio).getNombre();
                //Recupero id del estado a traves de un servicio de municipio que utiliza un idMunicpio                
                int idEstado = municipio.darIdEstado(idMunicipio);
                //Recupero nombre del estado a traves de su servicio que requiere un nombre
                String nombreEstado = estado.mostrar(idEstado).getNombre;
                
                //Creo un arraylist necesario para enviarse por el json
                List<String> EstadoyMunicipio = new ArrayList<>();
                 
                //Agrego recuperaciones
                EstadoyMunicipio.add(Integer.toString(idEstado));
                EstadoyMunicipio.add(nombreEstado);
                EstadoyMunicipio.add(Integer.toString(idMunicipio));
                EstadoyMunicipio.add(nombreMunicipio);
                
                //Envio por json
                PrintWriter out = response.getWriter();
                
                Gson json = new Gson();
                out.print(json.toJson(EstadoyMunicipio));                                                
            }

            break;
            case "municipiosPorEstado": {
                
                int idEstado = Integer.parseInt(request.getParameter("idEstado"));
                MunicipioServicioImpl municipio = MunicipioServicioImpl();
                
                List<Municipio> municipios = municipio.getMunicipios(idEstado);
                
                request.setAttribute("municipios", municipios);

                PrintWriter out = response.getWriter();

                Gson json = new Gson();
                out.print(json.toJson(municipios));
                
            }

            break;
           case "listarEstadoCivilyEstados": {

                
                EstadoServicioImpl estado = new EstadoServicioImpl();
                EstadoCivilServicioImpl municipio = new EstadoCivilServicioImpl();
                
                List<Estado> estados = estado.mostrarEstado();
                List<EstadoCivil> estadosCiviles = estadoCivil.mostrarEstadoCivil();
                
                request.setAttribute("estadoCivil", estados);
                request.setAttribute("estados", estadosCiviles);
                
                request.getRequestDispatcher("/WEB-INF/registro.jsp").forward(request, response);
                
               
               break;
            }

            
            
           case "existeUsuario": {
               
               CuentaServicioImpl cuentaServicio = new CuentaServicioImpl();
               
               String usuario = request.getParameter("usuario");

                //Checo si el usuario existe
                if (cuentaServicio.existeUsuario(usuario)) {

                    out.print("UsuarioAlreadyExists");

                } else {

                    //Si no existe, lo inserto
                    out.print("UsuarioDoesntExist");

                }
                break;
           }

                                  
             */

            case "consultarDocumentosPreconsulta": {
                /**
                 * * Uriel Díaz 26/10/2018 Case para saber que datos ya
                 * proporcionó un paciente en la solicitud de preconsulta.
                 *
                 *
                 * Devuelve una instancia de la clase SolicitudPreconsulta.
                 * Todos los valores dentro del objeto son int. Deberían ser
                 * valores de 0 o mayores para sabes cuales ya han sido
                 * considerados para la solicitud.
                 *
                 * El único valor que no se puede dar en esta clase es el motvio
                 * de la preconsulta puesto que puede cambiar durante el tiempo
                 * de recolección de los archivos necesarios para hacer. El
                 * motivo de la preconsulta solo se guardará en la solicitud.
                 *
                 */
                HttpSession sesion = request.getSession(true);

                if (sesion.getId() == null) {
                    //TODO 
                } else {
                    response.setContentType("application/json");//Por default se envia un text/html, pero enviaremos un application/json para que se interprete en el ajax del front.

                    int idPacientePotencial = (int) sesion.getAttribute("idPaciente");

                    SolicitudPreconsulta solicitudPreconsulta;
                    SolicitudPreconsultaServicioImpl solicitudPreconsultaServicioImpl = new SolicitudPreconsultaServicioImpl();
                    solicitudPreconsulta = solicitudPreconsultaServicioImpl.mostrarSolicitudPreconsulta(idPacientePotencial);

                    System.out.println("Consultar documentos");                    

                    if (solicitudPreconsulta.getIdSexo() == 0) {
                        sesion.setAttribute("idSexo", 0);
                    } else {
                        sesion.setAttribute("idSexo", solicitudPreconsulta.getIdSexo());
                    }

                    if (solicitudPreconsulta.getSilla() == 0) {
                        sesion.setAttribute("silla", 0);
                    } else {
                        sesion.setAttribute("silla", solicitudPreconsulta.getSilla());
                    }
                    
                    if (solicitudPreconsulta.getBaston() == 0) {
                        sesion.setAttribute("baston", 0);
                    } else {
                        sesion.setAttribute("baston", solicitudPreconsulta.getBaston());
                    }
                    
                    if (solicitudPreconsulta.getCamilla() == 0) {
                        sesion.setAttribute("camilla", 0);
                    } else {
                        sesion.setAttribute("camilla", solicitudPreconsulta.getCamilla());
                    }
                    
                    if (solicitudPreconsulta.getOxigeno() == 0) {
                        sesion.setAttribute("oxigeno", 0);
                    } else {
                        sesion.setAttribute("oxigeno", solicitudPreconsulta.getOxigeno());
                    }
                    
                    if (solicitudPreconsulta.getIdentificacion() != null) {
                        sesion.setAttribute("identificacionOficial", 1);
                        sesion.setAttribute("identificacionOficialName", solicitudPreconsulta.getIdentificacion());
                    } else {
                        sesion.setAttribute("identificacionOficial", 0);
                    }
                    if (solicitudPreconsulta.getCurp() != null) {
                        sesion.setAttribute("curp", 1);
                        sesion.setAttribute("curpName", solicitudPreconsulta.getCurp());
                    } else {
                        sesion.setAttribute("curp", 0);
                    }
                    if (solicitudPreconsulta.getComprobante() != null) {
                        sesion.setAttribute("comprobante", 1);
                        sesion.setAttribute("comprobanteName", solicitudPreconsulta.getComprobante());
                    } else {
                        sesion.setAttribute("comprobante", 0);
                    }
                    if (solicitudPreconsulta.getMastografia() != null) {
                        sesion.setAttribute("resultadoMastografia", 1);
                        sesion.setAttribute("resultadoMastografiaName", solicitudPreconsulta.getMastografia());
                    } else {
                        sesion.setAttribute("resultadoMastografia", 0);
                    }
                    if (solicitudPreconsulta.getUltrasonido() != null) {
                        sesion.setAttribute("resultadoUltrasonido", 1);
                        sesion.setAttribute("resultadoUltrasonidoName", solicitudPreconsulta.getUltrasonido());
                    } else {
                        sesion.setAttribute("resultadoUltrasonido", 0);
                    }
                    if (solicitudPreconsulta.getBiopsiaPrevia() != null) {
                        sesion.setAttribute("biopsiaPrevia", 1);
                        sesion.setAttribute("biopsiaPreviaName", solicitudPreconsulta.getBiopsiaPrevia());
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

                }
                break;
            }
            case "consultarEstadoPreconsulta": {
                /**
                 * * Uriel Díaz 26/10/2018 Case para saber el estado de una
                 * preconsulta.
                 *
                 * El presente case se utiliza para saber el estado actual de
                 * una solicitud de preconsulta.
                 *
                 * Los valores posibles son:
                 *
                 * Cancelada = 1 Expirada = 2 Pendiente = 3 Perdida = 4 Aprobada
                 * = 5
                 *
                 * El formato de entrega es un json. Ejemplo {estado:Aceptada};
                 */

                HttpSession sesion = request.getSession(true);

                if (sesion.getId() == null) {
                    //TODO 
                } else {

                    int idPacientePotencial = (int) sesion.getAttribute("idPaciente");

                    CitaServicioImpl citaServicioImpl = new CitaServicioImpl();

                    String estatus = citaServicioImpl.mostrarPreconsultaAceptada(idPacientePotencial);

                    if (estatus == null) {
                        System.out.println("El paciente no tiene ninguna cita");
                        sesion.setAttribute("estatus", 0);
                        sesion.setAttribute("envioEditable", 1);
                    } else {

                        System.out.println("El estatus es: " + estatus);

                        if (estatus.equals("Aprobada")) {
                            sesion.setAttribute("estatus", 1);
                            sesion.setAttribute("envioEditable", 1);
                        }
                        if (estatus.equals("Cancelada")) {
                            sesion.setAttribute("estatus", 2);
                            sesion.setAttribute("envioEditable", 0);
                        }
                        if (estatus.equals("Pendiente")) {
                            sesion.setAttribute("envioEditable", 1);
                        }

                    }
                }
                break;
            }
            case "cancelarCita": {
                /**
                 * Angel Gutiérrez 06/11/2018 Se cancelan las citas mediante una
                 * iteración donde se sacan todas las citas y se eliminan en
                 * orden despues de que se crea su objeto
                 */
                HttpSession sesion = request.getSession(true);
                if (sesion.getAttribute("idCuenta") == null) {
                    // request.setAttribute("status", "");
                    request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);

                    return;
                } else {

                    int idPaciente = Integer.parseInt(sesion.getAttribute("idPaciente").toString());
                    System.out.println("idPaciente: " + idPaciente);

                    CitaServicioImpl citaServicio = new CitaServicioImpl();

                    citaServicio.cancelarCitaPreconsulta(idPaciente);

                    System.out.println("Ya la canceló");

                }
                break;
            }

            case "GuardarContinuar": {
                /**
                 * Uriel Díaz 26/10/2018.
                 *
                 * El presente case funciona cuando un paciente agrega ciertos
                 * atributos y documentos al proceso de solicitud de preconsulta
                 * <<<<<<< HEAD sin enviarla. * *
                 */

                System.out.println("Guardar y continuar");

                HttpSession sesion = request.getSession(true);

                if (sesion.getId() == null) {
                    //TODO 
                } else {

                    int idPacientePotencial = (int) sesion.getAttribute("idPaciente");

                    ResourceBundle sapiProperties = ResourceBundle.getBundle("mx.itesm.sapi.properties.catalogos");

                    // ID TipoDocumento inicial
                    int idEstudioPrevio = Integer.parseInt(sapiProperties.getString("EstudioPrevio"));
                    int idBiopsiaPrevia = Integer.parseInt(sapiProperties.getString("BiopsiaPrevia"));
                    int idIdentificacion = Integer.parseInt(sapiProperties.getString("IdentificacionOficial"));
                    int idComprobanteDomicilio = Integer.parseInt(sapiProperties.getString("ComprobanteDomicilio"));
                    int idReferenciaMedico = Integer.parseInt(sapiProperties.getString("ReferenciaMedico"));
                    int idCURP = Integer.parseInt(sapiProperties.getString("CURP"));
                    int idMastografia = Integer.parseInt(sapiProperties.getString("Mastografia"));
                    int idUltrasonido = Integer.parseInt(sapiProperties.getString("Ultrasonido"));

                    //ID TipoCita
                    int idPreconsulta = Integer.parseInt(sapiProperties.getString("Preconsulta"));

                    //ID EstadoCita
                    int idPendiente = Integer.parseInt(sapiProperties.getString("Pendiente"));

                    // ID ImportanciaCita
                    int idImportante = Integer.parseInt(sapiProperties.getString("Importante"));

                    // ID Sexo
                    int idSexoMujer = Integer.parseInt(sapiProperties.getString("Mujer"));
                    int idSexoHombre = Integer.parseInt(sapiProperties.getString("Hombre"));

                    // ID Necesidad Especial
                    int idSillaDeRuedas = Integer.parseInt(sapiProperties.getString("SillaDeRuedas"));
                    int idCamilla = Integer.parseInt(sapiProperties.getString("Baston"));
                    int idBaston = Integer.parseInt(sapiProperties.getString("Oxigeno"));
                    int idOxigeno = Integer.parseInt(sapiProperties.getString("Camilla"));

                    if (ServletFileUpload.isMultipartContent(request)) {
                        System.out.println("Entro a solicitarPreconsulta if ");

                        String masculino = request.getParameter("masculino");
                        System.out.println("Values masculino ".concat(masculino));

                        String femenino = request.getParameter("femenino");
                        System.out.println("Values femenino ".concat(femenino));

                        String sillaDeRuedas = request.getParameter("sillaDeRuedas");
                        System.out.println("Silla ".concat(sillaDeRuedas));

                        String camilla = request.getParameter("camilla");
                        System.out.println("Camilla ".concat(camilla));

                        String baston = request.getParameter("baston");
                        System.out.println("bastón ".concat(baston));

                        String oxigeno = request.getParameter("oxigeno");
                        System.out.println("oxigeno ".concat(oxigeno));

                        String motivoConsulta = request.getParameter("motivoConsulta");
                        System.out.println("motivoConsulta ".concat(motivoConsulta));

                        int biopsia = Integer.parseInt(request.getParameter("biopsia"));
                        System.out.println("biopsia ".concat(String.valueOf(biopsia)));

                        //Agregar sexo al paciente
                        if (masculino.equals("1")) {
                            PersonaServicioImpl personaServicioImpl = new PersonaServicioImpl();
                            System.out.println("Actualizar a hombre");
                            personaServicioImpl.actualizarSexoPersona(idPacientePotencial, idSexoHombre);

                        } else {
                            if (femenino.equals("1")) {
                                PersonaServicioImpl personaServicioImpl = new PersonaServicioImpl();
                                System.out.println("Actualizar a mujer");
                                personaServicioImpl.actualizarSexoPersona(idPacientePotencial, idSexoMujer);
                            }
                        }

                        //AGREGAR NECESIDADES ESPECIALES AL PACIENTE
                        //Agregar la silla de ruedas, camilla, baston y oxigeno si los necesita
                        if (!sillaDeRuedas.equals("0")) {
                            PacienteNecesidadEspecial pacienteNecesidadEspecial = new PacienteNecesidadEspecial();
                            pacienteNecesidadEspecial.setIdPaciente(idPacientePotencial);
                            pacienteNecesidadEspecial.setIdNecesidadEspecial(idSillaDeRuedas);

                            PacienteNecesidadEspecialServicioImpl pacienteNecesidadEspecialServicio = new PacienteNecesidadEspecialServicioImpl();
                            pacienteNecesidadEspecialServicio.agregarPacienteNecesidadEspecial(pacienteNecesidadEspecial);
                        }
                        if (!camilla.equals("0")) {
                            PacienteNecesidadEspecial pacienteNecesidadEspecial = new PacienteNecesidadEspecial();
                            pacienteNecesidadEspecial.setIdPaciente(idPacientePotencial);
                            pacienteNecesidadEspecial.setIdNecesidadEspecial(idCamilla);

                            PacienteNecesidadEspecialServicioImpl pacienteNecesidadEspecialServicio = new PacienteNecesidadEspecialServicioImpl();
                            pacienteNecesidadEspecialServicio.agregarPacienteNecesidadEspecial(pacienteNecesidadEspecial);
                        }
                        if (!baston.equals("0")) {
                            PacienteNecesidadEspecial pacienteNecesidadEspecial = new PacienteNecesidadEspecial();
                            pacienteNecesidadEspecial.setIdPaciente(idPacientePotencial);
                            pacienteNecesidadEspecial.setIdNecesidadEspecial(idBaston);

                            PacienteNecesidadEspecialServicioImpl pacienteNecesidadEspecialServicio = new PacienteNecesidadEspecialServicioImpl();
                            pacienteNecesidadEspecialServicio.agregarPacienteNecesidadEspecial(pacienteNecesidadEspecial);
                        }
                        if (!oxigeno.equals("0")) {
                            PacienteNecesidadEspecial pacienteNecesidadEspecial = new PacienteNecesidadEspecial();
                            pacienteNecesidadEspecial.setIdPaciente(idPacientePotencial);
                            pacienteNecesidadEspecial.setIdNecesidadEspecial(idOxigeno);

                            PacienteNecesidadEspecialServicioImpl pacienteNecesidadEspecialServicio = new PacienteNecesidadEspecialServicioImpl();
                            pacienteNecesidadEspecialServicio.agregarPacienteNecesidadEspecial(pacienteNecesidadEspecial);
                        }

                        Part partIdentificacion = null;
                        boolean booleanIdentificacion = true;
                        try {
                            partIdentificacion = request.getPart("fileIdentificacion");
                            System.out.println(partIdentificacion.toString());

                        } catch (Exception ex) {
                            booleanIdentificacion = false;
                        }

                        //System.out.println("PartIdentificacion ".concat(partIdentificacion.toString()));
                        //System.out.println("PartIdentificacion lenghtname ".concat(partIdentificacion.getName().length() + " " + partIdentificacion.getSubmittedFileName().length()));
                        //System.out.println("PartIdentificacion type ".concat(partIdentificacion.getContentType()));
                        //String partName = partIdentificacion.getName();
                        InputStream contenidoIdentificacion = null;
                        String strIdentificacion = null;
                        String tipoIdentficacion = null;
                        int tamanoIdentificacion = 0;

                        if (booleanIdentificacion) {
                            if (partIdentificacion.getSubmittedFileName().length() > 0 && (partIdentificacion.getContentType().equals("image/jpeg") || partIdentificacion.getContentType().equals("application/pdf") || partIdentificacion.getContentType().equals("image/png") || partIdentificacion.getContentType().equals(" application/msword") || partIdentificacion.getContentType().equals(" application/msword") || partIdentificacion.getContentType().equals(" application/vnd.ms-excel"))) {

                                strIdentificacion = partIdentificacion.getSubmittedFileName();
                                contenidoIdentificacion = partIdentificacion.getInputStream();
                                tipoIdentficacion = partIdentificacion.getContentType();

                                tamanoIdentificacion = (int) partIdentificacion.getSize();
                                System.out.println("Identificacion ".concat(strIdentificacion).concat(" ").concat(partIdentificacion.getContentType()));
                            }

                        }

                        Part partCURP = null;
                        boolean booleanCURP = true;

                        try {
                            partCURP = request.getPart("fileCURP");
                            System.out.println("Part CURP ".concat(partCURP.getSubmittedFileName()));
                        } catch (Exception ex) {
                            booleanCURP = false;
                        }

                        InputStream contenidoCURP = null;
                        String strCurp = null;
                        String tipoCurp = null;
                        int tamanoCurp = 0;

                        if (booleanCURP) {
                            if (partCURP.getSubmittedFileName().length() > 0 && (partCURP.getContentType().equals("image/jpeg") || partCURP.getContentType().equals("application/pdf") || partCURP.getContentType().equals("image/png") || partCURP.getContentType().equals(" application/msword") || partCURP.getContentType().equals(" application/msword") || partCURP.getContentType().equals(" application/vnd.ms-excel"))) {
                                strCurp = partCURP.getSubmittedFileName();
                                contenidoCURP = partCURP.getInputStream();
                                tipoCurp = partCURP.getContentType();

                                tamanoCurp = (int) partCURP.getSize();
                                System.out.println("nombre del curp ".concat(strCurp));
                            }
                        }

                        Part partComprobanteDomicilio = null;
                        boolean booleanComprobante = true;
                        try {
                            partComprobanteDomicilio = request.getPart("fileComprobanteDomicilio");
                        } catch (Exception ex) {
                            booleanComprobante = false;
                        }

                        InputStream contenidoComprobanteDomicilio = null;
                        String strComprobante = null;
                        String tipoComprobanteDomicilio = null;
                        int tamanoComprobanteDomicilio = 0;

                        if (booleanComprobante) {
                            if (partComprobanteDomicilio.getSubmittedFileName().length() > 0 && (partComprobanteDomicilio.getContentType().equals("image/jpeg") || partComprobanteDomicilio.getContentType().equals("application/pdf") || partComprobanteDomicilio.getContentType().equals("image/png") || partComprobanteDomicilio.getContentType().equals(" application/msword") || partComprobanteDomicilio.getContentType().equals(" application/msword") || partComprobanteDomicilio.getContentType().equals(" application/vnd.ms-excel"))) {

                                strComprobante = partComprobanteDomicilio.getSubmittedFileName();
                                tipoComprobanteDomicilio = partComprobanteDomicilio.getContentType();
                                contenidoComprobanteDomicilio = partComprobanteDomicilio.getInputStream();
                                tamanoComprobanteDomicilio = (int) partComprobanteDomicilio.getSize();
                                System.out.println("comprobante ".concat(strComprobante));
                            }
                        }

                        Part partMastoPrevia = null;
                        boolean booleanMastoPrevia = true;

                        try {
                            partMastoPrevia = request.getPart("fileEstudioPrevioMasto");
                        } catch (Exception ex) {
                            booleanMastoPrevia = false;
                        }

                        InputStream contenidoMastoPrevia = null;
                        String strMastoPrevia = null;
                        String tipoMastoPrevia = null;
                        int tamanoMastoPrevia = 0;
                        
                        if (booleanMastoPrevia) {

                            if (partMastoPrevia.getSubmittedFileName().length() > 0 && (partMastoPrevia.getContentType().equals("image/jpeg") || partMastoPrevia.getContentType().equals("application/pdf") || partMastoPrevia.getContentType().equals("image/png") || partMastoPrevia.getContentType().equals(" application/msword") || partMastoPrevia.getContentType().equals(" application/msword") || partMastoPrevia.getContentType().equals(" application/vnd.ms-excel"))) {

                                strMastoPrevia = partMastoPrevia.getSubmittedFileName();
                                tipoMastoPrevia = partMastoPrevia.getContentType();
                                contenidoMastoPrevia = partMastoPrevia.getInputStream();
                                tamanoMastoPrevia = (int) partMastoPrevia.getSize();
                                System.out.println("Masto ".concat(strMastoPrevia));
                            }
                        }

                        Part partUltrasonidoPrevio = null;
                        boolean booleanUltraSonidoPrevio = true;
                        partUltrasonidoPrevio = request.getPart("fileEstudioPrevioUsg");
                        InputStream contenidoPartUltrasonidoPrevio = null;
                        String strUltrasonido = null;
                        String tipoUltrasonido = null;
                        int tamanoUltrasonido = 0;

                        if (booleanUltraSonidoPrevio) {

                            if (partUltrasonidoPrevio.getSubmittedFileName().length() > 0 && (partUltrasonidoPrevio.getContentType().equals("image/jpeg") || partUltrasonidoPrevio.getContentType().equals("application/pdf") || partUltrasonidoPrevio.getContentType().equals("image/png") || partUltrasonidoPrevio.getContentType().equals(" application/msword") || partUltrasonidoPrevio.getContentType().equals(" application/msword") || partUltrasonidoPrevio.getContentType().equals(" application/vnd.ms-excel"))) {

                                strUltrasonido = partUltrasonidoPrevio.getSubmittedFileName();
                                contenidoPartUltrasonidoPrevio = partUltrasonidoPrevio.getInputStream();
                                tipoUltrasonido = partUltrasonidoPrevio.getContentType();
                                tamanoUltrasonido = (int) partUltrasonidoPrevio.getSize();
                                System.out.println("USG ".concat(strUltrasonido));
                            }

                        }

                        Part partEstudioBiopsia = null;
                        boolean booleanEstudioBiopsia = true;
                        partEstudioBiopsia = request.getPart("fileEstudioBiopsia");
                        InputStream contenidoEstudioBiopsia = null;
                        String strBiopsia = null;
                        String tipoBiopsia = null;
                        int tamanoBiopsia = 0;

                        if (booleanEstudioBiopsia) {

                            if (partEstudioBiopsia.getSubmittedFileName().length() > 0 && (partEstudioBiopsia.getContentType().equals("image/jpeg") || partEstudioBiopsia.getContentType().equals("application/pdf") || partEstudioBiopsia.getContentType().equals("image/png") || partEstudioBiopsia.getContentType().equals(" application/msword") || partEstudioBiopsia.getContentType().equals(" application/msword") || partEstudioBiopsia.getContentType().equals(" application/vnd.ms-excel"))) {
                                strBiopsia = partEstudioBiopsia.getSubmittedFileName();

                                contenidoEstudioBiopsia = partEstudioBiopsia.getInputStream();
                                tipoBiopsia = partEstudioBiopsia.getContentType();
                                tamanoBiopsia = (int) partEstudioBiopsia.getSize();
                                System.out.println("Biopsia ".concat(strBiopsia));
                            }
                        }

                        Part partReferenciaArchivo = null;
                        boolean booleanReferenciaArchivo = true;
                        partReferenciaArchivo = request.getPart("referenciaArchivo");
                        InputStream contenidoReferenciaArchivo = null;
                        String strReferencia = null;
                        String tipoArchivo = null;
                        int tamanoArchivo = 0;

                        if (motivoConsulta.equals("1") || motivoConsulta.equals("4")) {
                            if (booleanReferenciaArchivo == true) {

                                if (partReferenciaArchivo.getSubmittedFileName().length() > 0 && (partReferenciaArchivo.getContentType().equals("image/jpeg") || partReferenciaArchivo.getContentType().equals("application/pdf") || partReferenciaArchivo.getContentType().equals("image/png") || partReferenciaArchivo.getContentType().equals(" application/msword") || partReferenciaArchivo.getContentType().equals(" application/msword") || partReferenciaArchivo.getContentType().equals(" application/vnd.ms-excel"))) {

                                    strReferencia = partReferenciaArchivo.getSubmittedFileName();
                                    contenidoReferenciaArchivo = partReferenciaArchivo.getInputStream();
                                    tipoArchivo = partReferenciaArchivo.getContentType();
                                    tamanoArchivo = (int) partReferenciaArchivo.getSize();
                                    System.out.println("Referencia médico ".concat(strReferencia));

                                }
                            }

                        }

                        DocumentoInicial docIdentificacion = null;
                        if (contenidoIdentificacion != null) {

                            docIdentificacion = new DocumentoInicial();
                            docIdentificacion.setIdPaciente(idPacientePotencial);
                            docIdentificacion.setArchivo(contenidoIdentificacion);
                            docIdentificacion.setIdTipoDocumento(idIdentificacion);
                            docIdentificacion.setTipo(tipoIdentficacion);
                            docIdentificacion.setTamano(tamanoIdentificacion);
                            docIdentificacion.setNombre(strIdentificacion);
                            docIdentificacion.setEstatus(1);
                        }

                        DocumentoInicial docCURP = null;
                        if (contenidoCURP != null) {
                            docCURP = new DocumentoInicial();
                            docCURP.setIdPaciente(idPacientePotencial);
                            docCURP.setArchivo(contenidoCURP);
                            docCURP.setIdTipoDocumento(idCURP);
                            docCURP.setTipo(tipoCurp);
                            docCURP.setTamano(tamanoCurp);
                            docCURP.setNombre(strCurp);
                            docCURP.setEstatus(1);
                        }

                        DocumentoInicial docComprobanteDomicilio = null;
                        if (contenidoComprobanteDomicilio != null) {

                            docComprobanteDomicilio = new DocumentoInicial();
                            docComprobanteDomicilio.setIdPaciente(idPacientePotencial);
                            docComprobanteDomicilio.setArchivo(contenidoComprobanteDomicilio);
                            docComprobanteDomicilio.setIdTipoDocumento(idComprobanteDomicilio);
                            docComprobanteDomicilio.setTipo(tipoComprobanteDomicilio);
                            docComprobanteDomicilio.setTamano(tamanoComprobanteDomicilio);
                            docComprobanteDomicilio.setNombre(strComprobante);
                            docComprobanteDomicilio.setEstatus(1);
                        }

                        DocumentoInicial docMasto = null;
                        if (contenidoMastoPrevia != null) {
                            docMasto = new DocumentoInicial();
                            docMasto.setIdPaciente(idPacientePotencial);
                            docMasto.setArchivo(contenidoMastoPrevia);
                            docMasto.setIdTipoDocumento(idMastografia);
                            docMasto.setTipo(tipoMastoPrevia);
                            docMasto.setTamano(tamanoMastoPrevia);
                            docMasto.setNombre(strMastoPrevia);
                            docMasto.setEstatus(1);
                        }

                        DocumentoInicial docUltraSonido = null;
                        if (contenidoPartUltrasonidoPrevio != null) {
                            docUltraSonido = new DocumentoInicial();
                            docUltraSonido.setIdPaciente(idPacientePotencial);
                            docUltraSonido.setArchivo(contenidoPartUltrasonidoPrevio);
                            docUltraSonido.setIdTipoDocumento(idUltrasonido);
                            docUltraSonido.setTipo(tipoUltrasonido);
                            docUltraSonido.setTamano(tamanoUltrasonido);
                            docUltraSonido.setNombre(strUltrasonido);
                            docUltraSonido.setEstatus(1);
                        }

                        DocumentoInicial docBiopsia = null;
                        if (contenidoEstudioBiopsia != null) {
                            docBiopsia = new DocumentoInicial();
                            docBiopsia.setIdPaciente(idPacientePotencial);
                            docBiopsia.setArchivo(contenidoEstudioBiopsia);
                            docBiopsia.setIdTipoDocumento(idBiopsiaPrevia);
                            docBiopsia.setTipo(tipoBiopsia);
                            docBiopsia.setTamano(tamanoBiopsia);
                            docBiopsia.setNombre(strBiopsia);
                            docBiopsia.setEstatus(1);
                        }
                                                

                        //SERVICIOS
                        int idIdentificacionBD = -1;
                        if (docIdentificacion != null) {
                            DocumentoInicialServicioImpl documentoInicialIdentificacion = new DocumentoInicialServicioImpl();
                            idIdentificacionBD = documentoInicialIdentificacion.agregarDocumentoInicialPreconsulta(docIdentificacion);
                        }

                        int idCURPDB = -1;
                        if (docCURP != null) {
                            DocumentoInicialServicioImpl documentoInicialCURP = new DocumentoInicialServicioImpl();
                            idCURPDB = documentoInicialCURP.agregarDocumentoInicialPreconsulta(docCURP);
                        }

                        int idComprobanteDB = -1;
                        if (docComprobanteDomicilio != null) {
                            DocumentoInicialServicioImpl documentoInicialComprobante = new DocumentoInicialServicioImpl();
                            idComprobanteDB = documentoInicialComprobante.agregarDocumentoInicialPreconsulta(docComprobanteDomicilio);
                        }

                        int idMastoDB = -1;
                        if (docMasto != null) {
                            DocumentoInicialServicioImpl documentoInicialMasto = new DocumentoInicialServicioImpl();
                            idMastoDB = documentoInicialMasto.agregarDocumentoInicialPreconsulta(docMasto);
                        }

                        int idUltrasonidoDB = -1;
                        if (docUltraSonido != null) {
                            DocumentoInicialServicioImpl documentoInicialUltrasonido = new DocumentoInicialServicioImpl();
                            idUltrasonidoDB = documentoInicialUltrasonido.agregarDocumentoInicialPreconsulta(docUltraSonido);
                        }

                        int idBiopsiaPreviaDB = -1;
                        if (biopsia == 1 && docBiopsia != null) {
                            DocumentoInicialServicioImpl documentoInicialBiopia = new DocumentoInicialServicioImpl();
                            idBiopsiaPreviaDB = documentoInicialBiopia.agregarDocumentoInicialPreconsulta(docBiopsia);
                        }

                        //Se utilizará para guardar la fecha de solicitud de preconsulta
                        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

                        /* DATOS QUE NO APLICAN PARA ESTE CASE
                        Cita citaPreconsulta = new Cita();
                        citaPreconsulta.setIdTipoCita(idPreconsulta);
                        citaPreconsulta.setIdPaciente(idPacientePotencial);
                        citaPreconsulta.setIdEstadoCita(idPendiente);
                        citaPreconsulta.setIdImportanciaCita(idImportante);
                        citaPreconsulta.setIdMotivoConsulta(Integer.parseInt(motivoConsulta));
                         */
                        
                        
                        switch (motivoConsulta) {
                            case "1": {

                                DocumentoInicial docReferencia = null;
                                if (contenidoReferenciaArchivo != null) {
                                    docReferencia = new DocumentoInicial();
                                    docReferencia.setIdPaciente(idPacientePotencial);
                                    docReferencia.setArchivo(contenidoReferenciaArchivo);
                                    docReferencia.setIdTipoDocumento(idReferenciaMedico);
                                    docReferencia.setTipo(tipoArchivo);
                                    docReferencia.setTamano(tamanoArchivo);
                                    docReferencia.setNombre(strReferencia);
                                    docReferencia.setEstatus(1);
                                }

                                if (docReferencia != null) {
                                    DocumentoInicialServicioImpl documentoInicialReferencia = new DocumentoInicialServicioImpl();
                                    documentoInicialReferencia.agregarDocumentoInicialPreconsulta(docReferencia);
                                }
                                break;
                            }
                            case "4": {

                                /* DATOS QUE NO APLICAN PARA ESTE CASE
                                String otroHospital = request.getParameter("otroHospital");
                                if (otroHospital.length() > 0) {
                                    citaPreconsulta.setHospitalProcedencia(otroHospital);
                                }*/
                                DocumentoInicial docReferencia = null;
                                if (contenidoReferenciaArchivo != null) {
                                    docReferencia = new DocumentoInicial();
                                    docReferencia.setIdPaciente(idPacientePotencial);
                                    docReferencia.setArchivo(contenidoReferenciaArchivo);
                                    docReferencia.setIdTipoDocumento(idReferenciaMedico);
                                    docReferencia.setTipo(tipoArchivo);
                                    docReferencia.setTamano(tamanoArchivo);
                                    docReferencia.setNombre(strReferencia);
                                    docReferencia.setEstatus(1);
                                }

                                if (docReferencia != null) {
                                    DocumentoInicialServicioImpl documentoInicialReferencia = new DocumentoInicialServicioImpl();
                                    documentoInicialReferencia.agregarDocumentoInicialPreconsulta(docReferencia);
                                }

                                break;
                            }
                            default: {
                                //Continuar
                                break;
                            }
                        }

                        /*DEBUG*/
                        //citaPreconsulta.setFechaSolicitud((timestamp).toString());

                        /*
                        CitaServicioImpl citaServicioImpl = new CitaServicioImpl();
                        int idCitaPreconsulta = citaServicioImpl.agregarPreconsulta(citaPreconsulta);
                         */
 /*
                        System.out.println("Identificacion ".concat(String.valueOf(idIdentificacionBD)));
                        System.out.println("CURP ".concat(String.valueOf(idCURPDB)));
                        System.out.println("Comprobante ".concat(String.valueOf(idComprobanteDB)));
                        System.out.println("Masto ".concat(String.valueOf(idMastoDB)));
                        System.out.println("Ultrasonido ".concat(String.valueOf(idUltrasonidoDB)));
                        System.out.println("Biopsia ".concat(String.valueOf(idBiopsiaPreviaDB)));
                        System.out.println("Preconsulta ".concat(String.valueOf(idCitaPreconsulta)));
                         */
 /*
                        if ("5".equals(motivoConsulta)) {
                            System.out.println("Otro motivo");
                            String otroMotivo = request.getParameter("otroMotivo");

                            OtroMotivo motivo = new OtroMotivo();
                            motivo.setIdCita(idCitaPreconsulta);
                            motivo.setNombre(otroMotivo);
                            motivo.setEstatus(1);

                            OtroMotivoServicioImpl otroMotivoServicioImpl = new OtroMotivoServicioImpl();
                            otroMotivoServicioImpl.agregarOtroMotivo(motivo);
                        }
                         */
                                                 
                                                
                        
                        System.out.println("AYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAY");
                        
                        
 
                        //request.getRequestDispatcher("WEB/INF/potencial/index.jsp").forward(request, response);
                    }
                }
                break;
            }

            case "consultarEstadoPaciente": {
                /**
                 * * Diego Montoya 26/10/2018 Case para saber el estado de un
                 * paciente.
                 *
                 * El presente case se utiliza para saber el estado actual de un
                 * paciente.
                 *
                 * Los valores posibles son:
                 *
                 * Primera vez = 0 Segunda opinión = 1
                 *
                 * El formato de entrega es un int.
                 */
                System.out.println("Entra al case de consultarEstadoPaciente");

                HttpSession sesion = request.getSession(true);

                if (sesion.getId() == null) {
                    //TODO 
                } else {

                    int idPacientePotencial = (int) sesion.getAttribute("idPaciente");

                    EstadoPacientePacienteServiceImpl estadoPaPa = new EstadoPacientePacienteServiceImpl();

                    int estadoPaciente = estadoPaPa.estadoPrimeraSegundaVez(idPacientePotencial);
                    System.out.println("EstadoPaciente: " + estadoPaciente);
                    sesion.setAttribute("estadoPaciente", estadoPaciente);

                }
                break;
            }
            case "consultarCitaPendiente": {

                /**
                 * * Shannon Rosas 06/11/2018 Case para saber el si un paciente
                 * tiene su cita pendiente.
                 *
                 * El presente case se utiliza para saber si un paciente tiene
                 * su cita como pendiente.
                 *
                 * Los valores posibles son:
                 *
                 * El formato de entrega es un int.
                 */
                HttpSession sesion = request.getSession(true);

                if (sesion.getId() == null) {
                    //TODO 
                } else {

                    int idPacientePotencial = (int) sesion.getAttribute("idPaciente");

                    CitaServicioImpl pendientePaciente = new CitaServicioImpl();

                    int pacientePendiente = pendientePaciente.citaPendiente(idPacientePotencial);

                    sesion.setAttribute("estadoPendientePaciente", pacientePendiente);

                }
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
