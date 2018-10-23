/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.controller;

import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mx.itesm.sapi.bean.persona.Cuenta;
import mx.itesm.sapi.bean.persona.Direccion;
import mx.itesm.sapi.bean.persona.Persona;

import mx.itesm.sapi.bean.gestionPaciente.DocumentoInicial;

import mx.itesm.sapi.service.persona.CuentaServicioImpl;
import mx.itesm.sapi.service.persona.PersonaServicioImpl;

import java.io.InputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import mx.itesm.sapi.bean.gestionPaciente.Cita;
import mx.itesm.sapi.service.gestionPaciente.CitaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.DocumentoInicialServicioImpl;
//Checar los de las librerias de clases Apache
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author feror
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
        String key = request.getParameter("key");
        System.out.println(key);
        switch (key) {

            case "registrarCuenta": {

                //Inicio de servicios
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
                String correo = request.getParameter("correo");
                String telefono = request.getParameter("telefono");

                HttpSession sesion = request.getSession(true); //Veo si tiene sesion iniciada
                if (sesion.getAttribute("idCuenta") == null) { //no tiene sesion iniciada
                    // request.setAttribute("status", "");
                    request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response); //Lo redirecciono al login
                    return;
                } else { //Si tiene sesion iniciada
                    int keyRol = (int) sesion.getAttribute("idRol");
                    switch (keyRol) {
                        case 1: {
                            //No se valida el telefono ni el correo aquí? Lo validamos nosotros o el front?
                            PersonaServicioImpl personaServiceImpl = new PersonaServicioImpl();
                            Persona persona = personaServiceImpl.mostrarPersona((int) sesion.getAttribute("idPersona"));

                            persona.setCorreo(correo);
                            persona.setTelefono(telefono);

                            personaServiceImpl.actualizarPersona(persona);

                            sesion.setAttribute("correo", persona.getCorreo());
                            sesion.setAttribute("telefono", persona.getTelefono());

                            request.setAttribute("correo", sesion.getAttribute("correo"));
                            request.setAttribute("correo", sesion.getAttribute("telefono"));

                            request.getRequestDispatcher("/WEB-INF/potencial/cuentaPaciente.jsp").forward(request, response);
                            break;
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

                    //Comentario para hacer commit x2 xdxdxd
                }
                break;
            }

            case "solicitarPreconsulta": {

                //request.getPart("fileCURP").
                //Obtener la sesion
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

                        Part partIdentificacion = request.getPart("fileIdentificacion");
                        String identificacion = partIdentificacion.getSubmittedFileName();
                        String tipoIdentificacion = partIdentificacion.getContentType();
                        InputStream contenidoIdentificacion = partIdentificacion.getInputStream();
                        System.out.println("Identificacion ".concat(identificacion));

                        Part partCURP = request.getPart("fileCURP");
                        String tipo = partCURP.getContentType();
                        String nombre = partCURP.getSubmittedFileName();
                        InputStream contenidoCURP = partCURP.getInputStream();
                        int tamano = (int) partCURP.getSize();
                        System.out.println("nombre del curp ".concat(nombre));

                        Part partComprobanteDomicilio = request.getPart("fileComprobanteDomicilio");
                        String comprobanteDomicilio = partComprobanteDomicilio.getSubmittedFileName();
                        InputStream contenidoComprobanteDomicilio = partComprobanteDomicilio.getInputStream();
                        System.out.println("comprobante ".concat(comprobanteDomicilio));

                        Part partMastoPrevia = request.getPart("fileEstudioPrevioMasto");
                        String stringPartMastoPrevia = partMastoPrevia.getSubmittedFileName();
                        InputStream contenidoMastoPrevia = partMastoPrevia.getInputStream();
                        System.out.println("Masto ".concat(stringPartMastoPrevia));

                        Part partUltrasonidoPrevio = request.getPart("fileEstudioPrevioUsg");
                        String stringpartUltrasonidoPrevio = partUltrasonidoPrevio.getSubmittedFileName();
                        InputStream contenidoPartUltrasonidoPrevio = partUltrasonidoPrevio.getInputStream();
                        System.out.println("USG ".concat(stringpartUltrasonidoPrevio));

                        Part partEstudioBiopsia;
                        String stringPartEstudioBiopsia;
                        InputStream contenidoEstudioBiopsia;

                        if (biopsia == 1) {

                            partEstudioBiopsia = request.getPart("fileEstudioBiopsia");
                            stringPartEstudioBiopsia = partEstudioBiopsia.getSubmittedFileName();
                            contenidoEstudioBiopsia = partEstudioBiopsia.getInputStream();
                            System.out.println("Biopsia ".concat(stringPartEstudioBiopsia));
                        }

                        switch (motivoConsulta) {
                            case "1": {
                                Part partReferenciaArchivo = request.getPart("referenciaArchivo");
                                String stringReferenciaArchivo = partReferenciaArchivo.getSubmittedFileName();
                                InputStream contenidoReferenciaArchivo = partReferenciaArchivo.getInputStream();
                                System.out.println("Referencia médico ".concat(stringReferenciaArchivo));

                                break;
                            }
                            case "2": {
                                break;
                            }
                            case "3": {

                                break;
                            }
                            case "4": {
                                break;
                            }
                            case "5": {
                                break;
                            }
                        }

                        DocumentoInicial docIdentificacion = new DocumentoInicial();
                        if (partIdentificacion != null) {
                            
                            docIdentificacion.setIdPaciente(idPacientePotencial);
                            docIdentificacion.setArchivo(contenidoIdentificacion);
                            docIdentificacion.setIdTipoDocumento(idIdentificacion);
                            docIdentificacion.setEstatus(1);
                        }

                        DocumentoInicial docCURP = new DocumentoInicial();
                        if (partCURP != null) {                            
                            docCURP.setIdPaciente(idPacientePotencial);
                            docCURP.setArchivo(contenidoCURP);
                            docCURP.setIdTipoDocumento(idCURP);
                            docCURP.setEstatus(1);
                        }

                        DocumentoInicial docComprobanteDomicilio = new DocumentoInicial();
                        if (partComprobanteDomicilio != null) {
                            
                            docComprobanteDomicilio.setIdPaciente(idPacientePotencial);
                            docComprobanteDomicilio.setArchivo(contenidoComprobanteDomicilio);
                            docComprobanteDomicilio.setIdTipoDocumento(idComprobanteDomicilio);
                            docComprobanteDomicilio.setEstatus(1);
                        }

                        DocumentoInicial docMasto = new DocumentoInicial();
                        if(partMastoPrevia != null)
                        {                            
                            docMasto.setIdPaciente(idPacientePotencial);
                            docMasto.setArchivo(contenidoMastoPrevia);
                            docMasto.setIdTipoDocumento(idEstudioPrevio);
                            docMasto.setEstatus(1);
                        }
                       
                        DocumentoInicial docUltraSonido = new DocumentoInicial();;
                        if(partUltrasonidoPrevio != null)
                        {                          
                          docUltraSonido.setIdPaciente(idPacientePotencial);
                          docUltraSonido.setArchivo(contenidoPartUltrasonidoPrevio);
                          docUltraSonido.setIdTipoDocumento(idUltrasonido);
                          docUltraSonido.setEstatus(1);
                        }                        
                                   
                        
                        //SERVICIOS
                        int idIdentificacionBD;
                        if(docIdentificacion.getIdDocumentoInicial() > 0)
                        {
                            DocumentoInicialServicioImpl documentoInicialIdentificacion = new DocumentoInicialServicioImpl();
                            idIdentificacionBD = documentoInicialIdentificacion.agregarDocumentoInicialPreconsulta(docIdentificacion);
                        }                                                
                        
                        int idCURPDB;
                        if(docCURP.getIdDocumentoInicial() > 0)
                        {
                            DocumentoInicialServicioImpl documentoInicialCURP = new DocumentoInicialServicioImpl();
                            idCURPDB = documentoInicialCURP.agregarDocumentoInicialPreconsulta(docCURP);
                        }                        

                        int idComprobanteDB;
                        if (docComprobanteDomicilio.getIdDocumentoInicial() > 0) 
                        {
                            DocumentoInicialServicioImpl documentoInicialComprobante = new DocumentoInicialServicioImpl();
                            idComprobanteDB = documentoInicialComprobante.agregarDocumentoInicialPreconsulta(docComprobanteDomicilio);
                        }
                       

                        int idMastoDB;
                        if(docMasto.getIdDocumentoInicial() > 0)
                        {
                            DocumentoInicialServicioImpl documentoInicialMasto = new DocumentoInicialServicioImpl();
                            idMastoDB = documentoInicialMasto.agregarDocumentoInicialPreconsulta(docMasto);
                        }
                        

                        int idUltrasonidoDB;
                        if(docUltraSonido.getIdDocumentoInicial() > 0)
                        {
                            DocumentoInicialServicioImpl documentoInicialUltrasonido = new DocumentoInicialServicioImpl();
                            idUltrasonidoDB = documentoInicialUltrasonido.agregarDocumentoInicialPreconsulta(docUltraSonido);
                        }
                        

                        //DocumentoInicialServicioImpl documentoInicialBiopsia = new DocumentoInicialServicioImpl();
                        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                        

                        Cita citaPreconsulta = new Cita();
                        citaPreconsulta.setIdTipoCita(idPreconsulta);
                        citaPreconsulta.setIdPaciente(idPacientePotencial);
                        citaPreconsulta.setIdEstadoCita(idPendiente);
                        citaPreconsulta.setIdImportanciaCita(idImportante);
                        citaPreconsulta.setIdMotivoConsulta(Integer.parseInt(motivoConsulta));
                        /*DEBUG*/
                        citaPreconsulta.setHospitalProcedencia("ABC");
                        citaPreconsulta.setFechaSolicitud(timestamp);

                        CitaServicioImpl citaServicioImpl = new CitaServicioImpl();
                        int idCitaPreconsulta = citaServicioImpl.agregarPreconsulta(citaPreconsulta);

                        //System.out.println("Identificacion ".concat(String.valueOf(idIdentificacionBD)));
                        //System.out.println("CURP ".concat(String.valueOf(idCURPDB)));
                        //System.out.println("Comprobante ".concat(String.valueOf(idComprobanteDB)));
                        //System.out.println("Masto ".concat(String.valueOf(idMastoDB)));
                        //System.out.println("Ultrasonido ".concat(String.valueOf(idUltrasonidoDB)));
                        System.out.println("Preconsulta ".concat(String.valueOf(idCitaPreconsulta)));

                    }
                }
                break;
            }

            //Desde aqui se sube guarda y muestra una imagen se debe cambiar por el nombre 
            //de la tabla donde se guardan las imagenes

            /*
            case "upload": {
                HttpSession sesion = request.getSession(true); //Veo si tiene sesion iniciada
                if (sesion.getAttribute("idCuenta") == null) {
                    request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response); //Lo redirecciono al login
                    return;
                } else {
                    if (ServletFileUpload.isMultipartContent(request)) {
                        Part part = request.getPart("archivo");
                        int idCuenta = (int) sesion.getAttribute("idCuenta");
                        InputStream contenido = part.getInputStream();
                        PersonaServicioImpl personaServicio = new PersonaServicioImpl();

                        Persona persona = personaServicio.mostrarPersona(idCuenta);
                        persona.setImagen(contenido);

                        // request.setCharacterEncoding("UTF-8");
                        PrintWriter out = response.getWriter();
                        if (personaServicio.actualizarPersona(persona)) {
                            out.print("success");

                        } else {
                            out.print("error");
                        }
                    }
                }
            }
            break;

            case "show": {
                /*
                HttpSession sesion = request.getSession(true); //Veo si tiene sesion iniciada
                if (sesion.getAttribute("idCuenta") == null) {
                    request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response); //Lo redirecciono al login
                    return;
                } else {
                    int idCuenta = (int) sesion.getAttribute("idCuenta");
                    PersonaServicioImpl personaServicio = new PersonaServicioImpl();
                    //Persona persona = personaServicio.mostrarImagen(idCuenta);
                    PrintWriter out = response.getWriter();

                    response.setContentType("application/octet-stream");

                    byte[] bytes = IOUtils.toByteArray(personaServicio.getImagen());
                    String base64String = Base64.getEncoder().encodeToString(bytes);

                    out.print(base64String);
                }
                
                break;
            }
             */
            case "eliminarCuentaP": {
                HttpSession sesion = request.getSession(true); //Veo si tiene sesion iniciada
                if (sesion.getAttribute("idCuenta") == null) { //no tiene sesion iniciada
                    // request.setAttribute("status", "");
                    request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response); //Lo redirecciono al login
                    return;
                } else {
                    //Elimino su cuenta (borrrado logico)
                    int idCuenta = (int) sesion.getAttribute("idCuenta");

                    CuentaServicioImpl cuentaServicio = new CuentaServicioImpl();

                    Cuenta cuenta = cuentaServicio.mostrarCuenta(idCuenta);

                    cuenta.setEstatus(0);

                    cuentaServicio.actualizarCuenta(cuenta);
                    //Al no tener cuenta se le redirecciona al login
                    request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
                }

                //Comentario para hacer commit x2 xdxdxd
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
