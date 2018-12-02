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
import java.util.Base64;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mx.itesm.sapi.bean.calendario.MCalendarioNavegadora;
import mx.itesm.sapi.bean.diagnostico.EtapaClinica;
import mx.itesm.sapi.bean.diagnostico.MCodificado;
import mx.itesm.sapi.bean.diagnostico.NCodificado;
import mx.itesm.sapi.bean.diagnostico.RegistroDiagnostico;
import mx.itesm.sapi.bean.diagnostico.TCodificado;
import mx.itesm.sapi.bean.gestionPaciente.BIRADS;
import mx.itesm.sapi.bean.gestionPaciente.DatosPacienteDocumentoInicial;
import mx.itesm.sapi.bean.gestionPaciente.DocumentoInicialTipoDocumento;
import mx.itesm.sapi.bean.gestionPaciente.DocumentoInicialVista;
import mx.itesm.sapi.bean.gestionPaciente.Escolaridad;
import mx.itesm.sapi.bean.gestionPaciente.EstadoPacientePaciente;
import mx.itesm.sapi.bean.gestionPaciente.Fish;
import mx.itesm.sapi.bean.gestionPaciente.GradoHistologico;
import mx.itesm.sapi.bean.gestionPaciente.Her2;
import mx.itesm.sapi.bean.gestionPaciente.NivelSocioeconomico;
import mx.itesm.sapi.bean.gestionPaciente.Paciente;
import mx.itesm.sapi.bean.gestionPaciente.PacienteAdmin;
import mx.itesm.sapi.bean.gestionPaciente.PacientePotencial;
import mx.itesm.sapi.bean.gestionPaciente.ReceptorEstrogeno;
import mx.itesm.sapi.bean.gestionPaciente.ReceptorProgesterona;
import mx.itesm.sapi.bean.gestionPaciente.Seguro;
import mx.itesm.sapi.bean.gestionPaciente.TipoHistologico;
import mx.itesm.sapi.bean.gestionTratamiento.TipoTratamiento;
import mx.itesm.sapi.bean.gestionTratamiento.UnionTratamientoPaciente;
import mx.itesm.sapi.bean.moduloGestionMedico.TablaAdministradorAdministrador;
import mx.itesm.sapi.bean.moduloGestionMedico.TablaMedicoAdministrador;
import mx.itesm.sapi.bean.persona.Cuenta;
import mx.itesm.sapi.bean.persona.Direccion;
import mx.itesm.sapi.bean.persona.Estado;
import mx.itesm.sapi.bean.persona.EstadoCivil;
import mx.itesm.sapi.bean.persona.Municipio;
import mx.itesm.sapi.bean.persona.Persona;
import mx.itesm.sapi.bean.persona.Pic;
import mx.itesm.sapi.bean.persona.TipoSangre;
import mx.itesm.sapi.service.MCalendarioNavegadoraServicioImpl;
import mx.itesm.sapi.service.diagnostico.EtapaClinicaServiceImpl;
import mx.itesm.sapi.service.diagnostico.MCodificadoServiceImpl;
import mx.itesm.sapi.service.diagnostico.NCodificadoServiceImpl;
import mx.itesm.sapi.service.diagnostico.RegistroDiagnosticoServiceImpl;
import mx.itesm.sapi.service.diagnostico.TCodificadoServiceImpl;
import mx.itesm.sapi.service.gestionPaciente.BIRADSServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteServiceImpl;
import mx.itesm.sapi.service.gestionPaciente.DocumentoInicialServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.DocumentoInicialTipoDocumentoServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.EscolaridadServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.EstadoPacientePacienteServiceImpl;
import mx.itesm.sapi.service.gestionPaciente.FishServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.GradoHistologicoServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.Her2ServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.NivelSocioeconomicoServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.ReceptorEstrogenoServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.ReceptorProgesteronaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.SeguroServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.TipoHistologicoServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteServicioImpl;
import mx.itesm.sapi.service.gestionTratamiento.TipoTratamientoServiceImpl;
import mx.itesm.sapi.service.gestionTratamiento.UnionTratamientoPacienteServiceImpl;
import mx.itesm.sapi.service.moduloGestionMedico.EmpleadoServicioImpl;
import mx.itesm.sapi.service.persona.CuentaServicioImpl;
import mx.itesm.sapi.service.persona.EstadoServicioImpl;
import mx.itesm.sapi.service.persona.DireccionServicioImpl;
import mx.itesm.sapi.service.persona.EstadoCivilServicioImpl;
import mx.itesm.sapi.service.persona.MunicipioServicioImpl;

import mx.itesm.sapi.service.persona.PersonaServicioImpl;
import mx.itesm.sapi.service.persona.PicServicioImpl;
import org.apache.commons.io.IOUtils;
import mx.itesm.sapi.service.persona.TipoSangreServicioImpl;

/*
import org.ghost4j.document.PDFDocument;
import org.ghost4j.renderer.SimpleRenderer;*/

/**
 *
 * @author Omar Quintero
 */
@WebServlet(name = "FrontController", urlPatterns = {"/SAPI"})
public class FrontController extends HttpServlet {

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

        System.out.println("URL FrontController: ".concat(request.getRequestURL().toString()));
        System.out.println("FrontController Method ".concat(request.getMethod()));

        String file = request.getParameter("file");
        
         HttpSession sesion = request.getSession(true);
        if(file == null && sesion.getAttribute("idCuenta") == null)
        {
            request.setAttribute("status", "");
            request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
        }else if (file != null && sesion.getAttribute("idCuenta") == null){
            request.setAttribute("status", "");
            request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
        }else if ((file == null || file != null) && sesion.getAttribute("idCuenta") != null)
        {
            if (file == null)
                file = sesion.getAttribute("path").toString();                        
            else 
                file = request.getParameter("file");

            if ("jsp".equals(file.substring(file.length() - 3))) {                               

                    //Lo redireciono a su rol
                    int keyRol = (int) sesion.getAttribute("idRol");                                        
                    switch (keyRol) {
                        //PACIENTE POTENCIAL
                        case 1: {
                            String keyRuta = file;
                            switch (keyRuta) {

                                case "potencial/cuentaPaciente.jsp": {

                                    System.out.println("Entro al case de potencial/cuentaPaciente.jsp");
                                    sesion.setAttribute("path", keyRuta);
                                    PersonaServicioImpl personaServiceImpl = new PersonaServicioImpl();
                                    Persona persona = personaServiceImpl.mostrarPersona((int) sesion.getAttribute("idPersona"));

                                    PicServicioImpl picServicioImpl = new PicServicioImpl();
                                    Pic pic = picServicioImpl.mostrarPic((int) sesion.getAttribute("idPersona"));

                                    PacienteServicioImpl pacienteServicioImpl = new PacienteServicioImpl();
                                    Paciente paciente = pacienteServicioImpl.mostrarPacientePotencial(Integer.parseInt(sesion.getAttribute("idCuenta").toString()));

                                    InputStream imagen = pic.getContenido();
                                    byte[] bytes = IOUtils.toByteArray(imagen);
                                    String base64String = Base64.getEncoder().encodeToString(bytes);

                                    sesion.setAttribute("base64Img", base64String);

                                    sesion.setAttribute("prz", paciente.getPrz());
                                    sesion.setAttribute("correo", persona.getCorreo());
                                    sesion.setAttribute("telefono", persona.getTelefono());

                                    request.getRequestDispatcher("/WEB-INF/".concat(keyRuta)).forward(request, response);
                                }
                                break;

                                case "potencial/index.jsp": {
                                    System.out.println("Entro al case de potencial/index.jsp");

                                    sesion.setAttribute("path", keyRuta);
                                    PersonaServicioImpl personaServiceImpl = new PersonaServicioImpl();
                                    Persona persona = personaServiceImpl.mostrarPersona((int) sesion.getAttribute("idPersona"));

                                    PicServicioImpl picServicioImpl = new PicServicioImpl();
                                    Pic pic = picServicioImpl.mostrarPic((int) sesion.getAttribute("idPersona"));

                                    InputStream imagen = pic.getContenido();
                                    byte[] bytes = IOUtils.toByteArray(imagen);
                                    String base64String = Base64.getEncoder().encodeToString(bytes);

                                    sesion.setAttribute("base64Img", base64String);

                                    request.getRequestDispatcher("/WEB-INF/".concat(keyRuta)).forward(request, response); //Lo redirecciono al login

                                }
                                break;

                                case "potencial/misCitas.jsp": {
                                    System.out.println("Entro al case de potencial/misCitas.jsp");

                                    sesion.setAttribute("path", keyRuta);

                                    request.getRequestDispatcher("/WEB-INF/".concat(keyRuta)).forward(request, response);
                                }
                                break;

                                case "potencial/preguntasFrecuentes.jsp": {
                                    System.out.println("Entro al case de potencial/preguntasFrecuentes.jsp");

                                    sesion.setAttribute("path", keyRuta);

                                    request.getRequestDispatcher("/WEB-INF/".concat(keyRuta)).forward(request, response);
                                }

                            }

                            break;
                        }
                        case 2: {
                            /* ADMINISTRADOR */
                            String keyRuta = file;
                            
                            switch(keyRuta){
                                case "administrador/cuentaAdministrador.jsp":
                                {
                                    sesion.setAttribute("path", keyRuta);
                                    request.getRequestDispatcher("/WEB-INF/".concat(keyRuta)).forward(request, response);
                                    break;
                                }
                                case "administrador/gestionMedicos.jsp":
                                {
                                    sesion.setAttribute("path", keyRuta);
                                    
                                    EmpleadoServicioImpl empleadoServicioImpl = new EmpleadoServicioImpl();
                                    List<TablaMedicoAdministrador> medicosAdministrador = empleadoServicioImpl.mostrarListaEmpleadosAdministrador(3);
                                    request.setAttribute("ListaMedicosAdmistrador", medicosAdministrador);
                                    
                                    request.getRequestDispatcher("/WEB-INF/".concat(keyRuta)).forward(request, response);                                    
                                    break;
                                }
                                case "administrador/gestionNavegadora.jsp":
                                {
                                    sesion.setAttribute("path", keyRuta);
                                    EmpleadoServicioImpl empleadoServicioImpl = new EmpleadoServicioImpl();
                                    List<TablaMedicoAdministrador> navegadorasAdministrador = empleadoServicioImpl.mostrarListaEmpleadosAdministrador(4);
                                    request.setAttribute("ListaNavegadorasAdministrador", navegadorasAdministrador);
                                                                                                            
                                    request.getRequestDispatcher("/WEB-INF/".concat(keyRuta)).forward(request, response);
                                    break;
                                }
                                case "administrador/gestionPacientes.jsp":
                                {                                    
                                    sesion.setAttribute("path", keyRuta);
                                    //Lista de pacientes
                                    PacienteServiceImpl pacienteServicio = new PacienteServiceImpl();
                                    List<PacienteAdmin> pacientes = pacienteServicio.mostrarPacientesAdmin();
                                    
                                    for (int i = 0; i < pacientes.size(); i++) {
                                        
                                        if(pacientes.get(i).getPrz().equals("1234567")){
                                            System.out.println("SOY URI Y MI COLOR ES...");
                                            System.out.println(pacienteServicio.mostrarColor(pacientes.get(i).getIdPaciente()));
                                            
                                        }
                                        
                                        if(pacienteServicio.mostrarColor(pacientes.get(i).getIdPaciente()) == 3 || pacienteServicio.mostrarColor(pacientes.get(i).getIdPaciente()) == 4){
                                            pacientes.get(i).setDescargaFormulario(1);
                                        }else{
                                            pacientes.get(i).setDescargaFormulario(0);
                                        }
                                    }
                                    
                                    request.setAttribute("ListaPacientesAdministrador", pacientes);
                                    
                                    //Estado civil
                                    EstadoCivilServicioImpl estadoCivilServicio = new EstadoCivilServicioImpl();
                                    List<EstadoCivil> estadosCiviles = estadoCivilServicio.mostrarEstadoCivil();
                                    request.setAttribute("estadoCivil", estadosCiviles);

                                    //Estados
                                    EstadoServicioImpl estadoServicio = new EstadoServicioImpl();
                                    List<Estado> estados = estadoServicio.mostrarEstado();
                                    request.setAttribute("estado", estados);
                                    
                                    request.getRequestDispatcher("/WEB-INF/".concat(keyRuta)).forward(request, response);
                                    break;
                                }
                                case "administrador/gestionarAdministradores.jsp":
                                {
                                    sesion.setAttribute("path", keyRuta);
                                    //Lista de pacientes
                                    EmpleadoServicioImpl empleadoServicioImpl = new EmpleadoServicioImpl();
                                    List<TablaAdministradorAdministrador> administradores = empleadoServicioImpl.mostrarListaAdminAdministrador();
                                    request.setAttribute("ListaAdministradoresAdmistrador", administradores);
                                    
                                    request.getRequestDispatcher("/WEB-INF/".concat(keyRuta)).forward(request, response);
                                    break;
                                }
                                case "administrador/index.jsp":
                                {
                                    
                                    break;
                                }
                                case "administrador/reAsignarMedico.jsp":
                                {
                                    sesion.setAttribute("path", keyRuta);
                                    /**-------------------Mostrar Lista Médicos---------------------------------------*/
                                    PersonaServicioImpl personaServicioMedicos = new PersonaServicioImpl();
                                    List<Persona> medicos = personaServicioMedicos.mostrarMedicosAdscritos();
                                    request.setAttribute("listaMedicos", medicos);
                                    
                                    request.getRequestDispatcher("/WEB-INF/".concat(keyRuta)).forward(request, response);
                                    break;
                                }
                                 case "administrador/rendimientoNavegadora.jsp": {
                                    sesion.setAttribute("path", keyRuta);
                                     
                                    int idEmpleadoNavegadora = Integer.parseInt(request.getParameter("idNavegadora"));
                                    
                                    EmpleadoServicioImpl empleadoServicioImpl = new EmpleadoServicioImpl();
                                    TablaMedicoAdministrador navegadora = empleadoServicioImpl.mostrarMedicoAdministrador(idEmpleadoNavegadora, 4);
                                    
                                    sesion.setAttribute("nombreNavegadora", navegadora.getNombre());
                                    sesion.setAttribute("primerApellidoNavegadora", navegadora.getPrimerApellido());
                                    sesion.setAttribute("idEmpleadoNavegadora", idEmpleadoNavegadora);
                                                                                                                                                                                                                                                            
                                    request.getRequestDispatcher("/WEB-INF/".concat(keyRuta)).forward(request, response); //Lo redirecciono a su rendimiento
                                    break;

                                }
                            }
                            
                            break;
                        }
                        case 3: {
                            break;
                        }

                        /*NAVEGADORA*/
                        case 4: {
                            String keyRuta = file;
                            sesion.setAttribute("path", keyRuta);
                            switch (keyRuta) {

                                case "navegadora/cuentaNavegadora.jsp": {

                                    PersonaServicioImpl personaServiceImpl = new PersonaServicioImpl();
                                    Persona persona = personaServiceImpl.mostrarPersona((int) sesion.getAttribute("idPersona"));

                                    CuentaServicioImpl cuentaServicioImpl = new CuentaServicioImpl();
                                    Cuenta cuenta = cuentaServicioImpl.mostrarCuenta((int) sesion.getAttribute("idCuenta"));
                                    
                                    PicServicioImpl picServicioImpl = new PicServicioImpl();
                                    Pic pic = picServicioImpl.mostrarPic((int) sesion.getAttribute("idPersona"));

                                    InputStream imagen = pic.getContenido();
                                    byte[] bytes = IOUtils.toByteArray(imagen);
                                    String base64String = Base64.getEncoder().encodeToString(bytes);
                                    
                                    sesion.setAttribute("base64Img", base64String);
                                    
                                    request.getRequestDispatcher("/WEB-INF/".concat(keyRuta)).forward(request, response);

                                    break;
                                }
                                

                                case "navegadora/index.jsp": {
                                    PacienteServiceImpl pacienteServicio = new PacienteServiceImpl();
                                    List<PacientePotencial> pacientes = pacienteServicio.mostrarPacientesPotenciales();
                                    request.setAttribute("listaPacientes", pacientes);

                                    //Estado civil
                                    EstadoCivilServicioImpl estadoCivilServicio = new EstadoCivilServicioImpl();
                                    List<EstadoCivil> estadosCiviles = estadoCivilServicio.mostrarEstadoCivil();
                                    request.setAttribute("estadoCivil", estadosCiviles);

                                    //Estados
                                    EstadoServicioImpl estadoServicio = new EstadoServicioImpl();
                                    List<Estado> estados = estadoServicio.mostrarEstado();
                                    request.setAttribute("estado", estados);

                                    //Pacientes aprobados  
                                    List<PacientePotencial> pacientesAprobados = pacienteServicio.mostrarPacientesPotencialesAprobados();
                                    
                                    for (int i = 0; i < pacientesAprobados.size(); i++) {
                                        pacientesAprobados.get(i).setColor(pacienteServicio.mostrarColor(pacientesAprobados.get(i).getIdPaciente()));                                        
                                        //Recorrer la lista y uno por uno ir asignando los colores
                                    }

                                    request.setAttribute("listaPacientesAprobados", pacientesAprobados);

                                    request.getRequestDispatcher("/WEB-INF/".concat(keyRuta)).forward(request, response); //Lo redirecciono al dashboard navgeadora
                                    break;
                                }
                                case "navegadora/calendar.jsp": {
                                    System.out.println("Index Navegadora ");
                                    PicServicioImpl picServicioImpl = new PicServicioImpl();
                                    Pic pic = picServicioImpl.mostrarPic((int) sesion.getAttribute("idPersona"));

                                    InputStream imagen = pic.getContenido();
                                    byte[] bytes = IOUtils.toByteArray(imagen);
                                    String base64String = Base64.getEncoder().encodeToString(bytes);
                                    
                                    //Pacientes Resultados                      
                                    MCalendarioNavegadoraServicioImpl navegadoraServicio = new MCalendarioNavegadoraServicioImpl();
                                    List<MCalendarioNavegadora> pacientesResultados = navegadoraServicio.mostrarPcientesParaCita();
                                    request.setAttribute("pacientesResultados", pacientesResultados);
                                    
                                    
                                    sesion.setAttribute("base64Img", base64String);
                                    request.getRequestDispatcher("/WEB-INF/".concat(keyRuta)).forward(request, response); //Lo redirecciono al calendario de navgeadora
                                    break;
                                }
                                case "navegadora/rendimiento.jsp": {
                                    
                                    System.out.println("Index Navegadora ");
                                    
                                    PicServicioImpl picServicioImpl = new PicServicioImpl();
                                    Pic pic = picServicioImpl.mostrarPic((int) sesion.getAttribute("idPersona"));

                                    InputStream imagen = pic.getContenido();
                                    byte[] bytes = IOUtils.toByteArray(imagen);
                                    String base64String = Base64.getEncoder().encodeToString(bytes);
                                    
                                    sesion.setAttribute("base64Img", base64String);
                                    
                                    request.getRequestDispatcher("/WEB-INF/".concat(keyRuta)).forward(request, response); //Lo redirecciono a su rendimiento
                                    break;

                                }

                                case "navegadora/documentos.jsp": {
                                    System.out.println("Index Navegadora ");
                                    
                                    PicServicioImpl picServicioImpl = new PicServicioImpl();
                                    Pic pic = picServicioImpl.mostrarPic((int) sesion.getAttribute("idPersona"));

                                    InputStream imagen = pic.getContenido();
                                    byte[] bytes = IOUtils.toByteArray(imagen);
                                    String base64String = Base64.getEncoder().encodeToString(bytes);

                                    sesion.setAttribute("base64Img", base64String);
                                    //DEBUG se cambiará cuando haya routing desde la lista de potenciales.
                                    int idPacientePotencial = 68;
                                    
                                    try
                                    {
                                        idPacientePotencial = Integer.parseInt(request.getParameter("idPacientePotencialAtendido"));
                                    }catch(Exception ex)
                                    {
                                        System.out.println("Catch parameter idPacientePotencial ".concat(ex.getMessage()));
                                        idPacientePotencial = 68;
                                    }         
                                    

                                    PacienteServicioImpl pacienteServicioImpl = new PacienteServicioImpl();
                                    Paciente paciente = pacienteServicioImpl.mostrarPaciente(idPacientePotencial);

                                    CuentaServicioImpl cuentaServicioImpl = new CuentaServicioImpl();
                                    Cuenta cuenta = cuentaServicioImpl.mostrarCuenta(paciente.getIdCuenta());

                                    PersonaServicioImpl personaServiceImpl = new PersonaServicioImpl();
                                    Persona persona = personaServiceImpl.mostrarPersona(cuenta.getIdPersona());

                                    EstadoCivilServicioImpl estadoCivilServicioImpl = new EstadoCivilServicioImpl();
                                    EstadoCivil estadoCivil = estadoCivilServicioImpl.mostrarEstadoCivil(persona.getIdEstadoCivil());

                                    MunicipioServicioImpl municipioServicioImpl = new MunicipioServicioImpl();
                                    Municipio municipio = municipioServicioImpl.mostrarMunicipio(persona.getIdMunicipio());

                                    /*
                                    EspecialidadServicioImpl especialidadServicioImpl = new EspecialidadServicioImpl();
                                    Especialidad especialidad = especialidadServicioImpl.mostrarEspecialidad(medicoEspecialidad.getIdEspecialidad());*/

                                    EstadoServicioImpl estadoServicioImpl = new EstadoServicioImpl();
                                    Estado estado = estadoServicioImpl.mostrarEstado(municipio.getIdEstado());

                                    DireccionServicioImpl direccionServicioImpl = new DireccionServicioImpl();
                                    Direccion direccion = direccionServicioImpl.mostrarDireccion(persona.getIdDireccion());

                                    System.out.println("el id paciente es...." + paciente.getIdPaciente());
                                    sesion.setAttribute("idPaciente", idPacientePotencial);
                                    EstadoPacientePacienteServiceImpl estadoPacientePacienteServiceImpl = new EstadoPacientePacienteServiceImpl();
                                    EstadoPacientePaciente estadoPacientePaciente = estadoPacientePacienteServiceImpl.mostrarEstadoPacientePacienteIdPaciente(paciente.getIdPaciente());

                                    //
                                    DocumentoInicialTipoDocumentoServicioImpl documentoInicialTipoDocumentoServcioImpl = new DocumentoInicialTipoDocumentoServicioImpl();

                                    List<DocumentoInicialTipoDocumento> documentosInicialTipoDocumentos = documentoInicialTipoDocumentoServcioImpl.mostrarDocumentoInicialTipoDocumento(idPacientePotencial);

                                    if (documentosInicialTipoDocumentos.size() > 0) {
                                        System.out.println("Esta llena");
                                    } else {
                                        System.out.println("Esta vacía");
                                    }

                                    request.setAttribute("documentos", documentosInicialTipoDocumentos);

                                    
                                     sesion.setAttribute("nombrePacientePotencial",persona.getNombre());                                                                        
                                    sesion.setAttribute("primerApellidoPacientePotencial", persona.getPrimerApellido());                                                                        
                                    sesion.setAttribute("segundoApellidoPacientePotencial", persona.getSegundoApellido());           
                                    
                                    sesion.setAttribute("estadoCivil", estadoCivil.getNombre());
                                    sesion.setAttribute("fechaNacimiento", persona.getFechaNacimiento());
                                    sesion.setAttribute("municipio", municipio.getNombre());
                                    sesion.setAttribute("estado", estado.getNombre());
                                    sesion.setAttribute("fechaNacimiento", persona.getFechaNacimiento());
                                    sesion.setAttribute("calle", direccion.getCalle());
                                    sesion.setAttribute("colonia", direccion.getColonia());
                                    sesion.setAttribute("noExterior", direccion.getNoExterior());
                                    sesion.setAttribute("noInterior", direccion.getColonia());
                                    // Date fecha = Date.valueOf(cuenta.getFecha().toString());
                                    //String fecha = cuenta.getFecha().toString();
                                    //fecha = fecha.substring(0, 10);

                                    
                                    Timestamp ts = cuenta.getFecha();
                                    Date fecha = new Date(ts.getTime());
                                    sesion.setAttribute("fechaRegistro", fecha);
                                    System.out.println("El id de la cuenta es: " + cuenta.getIdCuenta());
                                    System.out.println("Esta es la fecha registro: " + cuenta.getFecha());
                                    sesion.setAttribute("curp", persona.getCurp());
                                    sesion.setAttribute("telefono", persona.getTelefono());
                                    sesion.setAttribute("correo", persona.getCorreo());
                                    sesion.setAttribute("segundaOpinion", estadoPacientePaciente.getSegundaOpinion());

                                    //sesion.setAttribute("idDocumento", file);
                                    request.getRequestDispatcher("/WEB-INF/".concat(keyRuta)).forward(request, response); //Lo redirecciono a su rendimiento
                                    break;

                                }
                                case "navegadora/verDocumento.jsp": {
                                    System.out.println("navegadora/verDocumento.jsp");

                                    PersonaServicioImpl personaServiceImpl = new PersonaServicioImpl();
                                    Persona persona = personaServiceImpl.mostrarPersona((int) sesion.getAttribute("idPersona"));

                                    CuentaServicioImpl cuentaServicioImpl = new CuentaServicioImpl();
                                    Cuenta cuenta = cuentaServicioImpl.mostrarCuenta((int) sesion.getAttribute("idCuenta"));
                                    
                                    sesion.setAttribute("nombre", persona.getNombre());
                                    sesion.setAttribute("primerApellido", persona.getPrimerApellido());
                                    sesion.setAttribute("segundoApellido", persona.getSegundoApellido());
                                    System.out.println("el correo es:" + persona.getCorreo());
                                    sesion.setAttribute("correo", persona.getCorreo());
                                    sesion.setAttribute("telefono", persona.getTelefono());
                                    sesion.setAttribute("usuario", cuenta.getUsuario());

                                    PicServicioImpl picServicioImpl = new PicServicioImpl();
                                    Pic pic = picServicioImpl.mostrarPic((int) sesion.getAttribute("idPersona"));

                                    InputStream imagen = pic.getContenido();
                                    byte[] bytes = IOUtils.toByteArray(imagen);
                                    String base64String = Base64.getEncoder().encodeToString(bytes);

                                    sesion.setAttribute("base64Img", base64String);

                                                                                                                                                
                                    int idDocumentoInicial;
                                    int idPaciente;
                                    int siguiente;
                                                                        
                                    try
                                    {
                                        idDocumentoInicial = Integer.parseInt(request.getParameter("idDocumentoInicialVista"));
                                        System.out.println("idDocumentoInicial parameter"+idDocumentoInicial);
                                    }catch(Exception ex)
                                    {
                                        System.out.println("Catch parameter idDocumentoInicial ".concat(ex.getMessage()));
                                        idDocumentoInicial = 241;
                                    }
                                     
                                    try
                                    {
                                        idPaciente = Integer.parseInt(request.getParameter("idPacientePotencialAtendido"));
                                    }catch(Exception ex)
                                    {
                                        System.out.println("Catch parameter idPacientePotencial ".concat(ex.getMessage()));
                                        idPaciente = 68;
                                    }                                                                         
                                    try
                                    {
                                        siguiente = Integer.parseInt(request.getParameter("siguiente"));
                                    }catch(Exception ex)
                                    {
                                        System.out.println("Catch parameter siguiente ".concat(ex.getMessage()));
                                        siguiente = 0;
                                    }
                                    
                                    
                                    sesion.setAttribute("idPacientePotencialAtendido", idPaciente);                                                                        
                                    sesion.setAttribute("idDocumentoInicial", idDocumentoInicial);
                                    
                                                                        
                                    PacienteServicioImpl pacienteServicioImpl = new PacienteServicioImpl();
                                    DatosPacienteDocumentoInicial datosPacienteDocumentoInicial = pacienteServicioImpl.mostrarDatosPacienteDocumentoInicial(idPaciente);                                    
                                                                        
                                    sesion.setAttribute("nombrePacientePotencial", datosPacienteDocumentoInicial.getNombre());                                                                        
                                    sesion.setAttribute("primerApellidoPacientePotencial", datosPacienteDocumentoInicial.getPrimerApellido());                                                                        
                                    sesion.setAttribute("segundoApellidoPacientePotencial", datosPacienteDocumentoInicial.getSegundoApellido());                                                                        
                                                                                                                                                                                    
                                    DocumentoInicialServicioImpl documentoInicialServicioImpl = new DocumentoInicialServicioImpl();
                                    DocumentoInicialVista documentoInicialVista = documentoInicialServicioImpl.mostrarDocumentoInicialVista(idDocumentoInicial,idPaciente,siguiente);
                                    
                                    try{
                                        idDocumentoInicial = documentoInicialVista.getIdDocumentoInicial();
                                    }catch(Exception ex)
                                    {
                                        System.out.println("No más documentos");
                                        PrintWriter out = response.getWriter();
                                        out.print("todos");
                                        break;
                                    }
                                                                                                            
                                    System.out.println("Ver Documento id ".concat(String.valueOf(idDocumentoInicial)));
                                    System.out.println("Ver Documento nombre archivo: ".concat(documentoInicialVista.getNombreDocumento()));
                                    System.out.println("Ver Documento extensión archivo ".concat(documentoInicialVista.getTipoArchivo()));
                                    System.out.println("Ver Documento tipo documento ".concat(documentoInicialVista.getTipoDocumento()));
                                    System.out.println("Ver Documento siguiente ".concat(String.valueOf(siguiente)));
                                    
                                    InputStream documento;
                                    String strDocumentoB64;
                                    String extension = documentoInicialVista.getTipoArchivo();
                                    sesion.setAttribute("idDocumentoInicialVista",documentoInicialVista.getIdDocumentoInicial());
                                    sesion.setAttribute("idDocumentoInicial", idDocumentoInicial);
                                    switch(extension)
                                    {
                                        case "image/png":
                                        {             
                                            InputStream imageDoc = documentoInicialVista.getArchivo();                                                                                                                                     
                                            byte[] bytesDocumento = IOUtils.toByteArray(imageDoc);
                                            strDocumentoB64 = Base64.getEncoder().encodeToString(bytesDocumento);                                            
                                                                                                                            
                                            sesion.setAttribute("tipoDocumentoInicial", documentoInicialVista.getTipoDocumento());
                                            sesion.setAttribute("extensionArchivo",1);                                            
                                            sesion.setAttribute("documentB64", strDocumentoB64);
                                            break;
                                        }                                            
                                        case "image/jpeg":
                                        {
                                            InputStream imageDoc = documentoInicialVista.getArchivo();                                                                                                                                     
                                            byte[] bytesDocumento = IOUtils.toByteArray(imageDoc);
                                            strDocumentoB64 = Base64.getEncoder().encodeToString(bytesDocumento);                                            
                                                                                                                            
                                            sesion.setAttribute("tipoDocumentoInicial", documentoInicialVista.getTipoDocumento());
                                            sesion.setAttribute("extensionArchivo",2);                                            
                                            sesion.setAttribute("documentB64", strDocumentoB64);
                                            break;
                                        }
                                        case "application/pdf":
                                        {
                                            try
                                            {
                                            /*    
                                            PDFDocument document = new PDFDocument();
                                            document.load(documentoInicialVista.getArchivo());
                                            
                                            SimpleRenderer renderer = new SimpleRenderer();
                                            renderer.setResolution(300);
                                                                                        
                                            List<Image> images = renderer.render(document);                                                                                                                                    
                                            ByteArrayOutputStream os = new ByteArrayOutputStream();                                            
                                            ImageIO.write((RenderedImage) images.get(0),"png", os); 
                                            */
                                                
                                            InputStream imageDoc = documentoInicialVista.getArchivo();                                                                                                                                     
                                            byte[] bytesDocumento = IOUtils.toByteArray(imageDoc);
                                            strDocumentoB64 = Base64.getEncoder().encodeToString(bytesDocumento);                                            
                                                                                                                            
                                            sesion.setAttribute("tipoDocumentoInicial", documentoInicialVista.getTipoDocumento());
                                            sesion.setAttribute("extensionArchivo",3);                                            
                                            sesion.setAttribute("documentB64", strDocumentoB64);
                                            
                                            }catch(Exception ex)                                            
                                            {
                                                System.out.println("EX pdf Document ".concat(ex.getMessage()));
                                            }
                                                                                                                                    
                                            break;
                                        }
                                    }                                                                                                                                                                                                                        
                                    

                                    request.getRequestDispatcher("/WEB-INF/".concat(keyRuta)).forward(request, response); //Lo redirecciono a su rendimiento
                                    break;
                                }

                                case "navegadora/form.jsp":
                                {
                                    System.out.println("Front Controller case:  Form Navegadora");
                                    
                                    /**-------------------Mostrar Lista Médicos---------------------------------------*/
                                    
                                    PersonaServicioImpl personaServicioMedicos = new PersonaServicioImpl();
                                    List<Persona> medicos = personaServicioMedicos.mostrarMedicosAdscritos();
                                    request.setAttribute("listaMedicos", medicos);
                                    
                                    /**-------------------Mostrar Lista Radiologos---------------------------------------*/
                                    
                                    PersonaServicioImpl personaServicioRadiologos = new PersonaServicioImpl();
                                    List<Persona> radiologos = personaServicioRadiologos.mostrarMedicosRadiologos();
                                    request.setAttribute("listaRadiologos", radiologos);
                                    
                                    /**-------------------Mostrar Lista Escolaridad---------------------------------------*/
                                    
                                    EscolaridadServicioImpl escolaridadServicio = new EscolaridadServicioImpl();
                                    List<Escolaridad> escolaridad = escolaridadServicio.mostrarEscolaridades();
                                    request.setAttribute("listaEscolaridad", escolaridad);
                                    
                                    System.out.println(escolaridad);
                                    
                                    /**-------------------Mostrar Lista Seguros---------------------------------------*/
                                    
                                    SeguroServicioImpl seguroServicio = new SeguroServicioImpl();
                                    List<Seguro> seguro = seguroServicio.mostrarAllSeguro();
                                    request.setAttribute("listaSeguro", seguro);
                                    
                                    System.out.println(seguro);
                                    
                                    /**-------------------Mostrar ista Tipo Cirugia---------------------------------------*/
                                    
                                    TipoTratamientoServiceImpl TipoTratamientoService = new TipoTratamientoServiceImpl();
                                    List<TipoTratamiento> tipoCirugia = TipoTratamientoService.mostrarTratamientoCirugia();
                                    request.setAttribute("listaCirugia", tipoCirugia);
                                    
                                    System.out.println(tipoCirugia);
                                    
                                     /**-------------------Mostrar Lista BI-RADS---------------------------------------*/
                                    
                                    BIRADSServicioImpl BIRADSServicio = new BIRADSServicioImpl();
                                    List<BIRADS> birads = BIRADSServicio.mostrarBIRADS();
                                    request.setAttribute("listaBirads", birads);
                                    
                                    System.out.println(birads);

                                    
                                     /**-------------------Mostrar Lista Tipo Histológico---------------------------------------*/
                                    
                                    TipoHistologicoServicioImpl TipoHistologicoServicio = new TipoHistologicoServicioImpl();
                                    List<TipoHistologico> tipoHistologico = TipoHistologicoServicio.mostraTipoHistologico();
                                    request.setAttribute("listaTipoHistologico", tipoHistologico);
                                    
                                    System.out.println(tipoHistologico);
                                    
                                     /**-------------------Mostrar Lista Nivel Socioeconomico---------------------------------------*/
                                    
                                    NivelSocioeconomicoServicioImpl NivelSocioeconomicoServicio = new NivelSocioeconomicoServicioImpl();
                                    List<NivelSocioeconomico> nivelSocioeconomico = NivelSocioeconomicoServicio.mostrarNivelSocioeconomico();
                                    request.setAttribute("listaNivelSocioEconomico", nivelSocioeconomico);
                                    
                                    System.out.println(nivelSocioeconomico);
                                    
                                    /**-------------------Mostrar Lista Estapa Clínica---------------------------------------*/
                                    
                                    EtapaClinicaServiceImpl etapaServicio = new EtapaClinicaServiceImpl();
                                    List<EtapaClinica> etapas = etapaServicio.mostrarEtapaClinica();
                                    request.setAttribute("listaEtapaClinica", etapas);
                                    
                                    System.out.println(etapas);
                                    
                                    /**-------------------Mostrar Lista T---------------------------------------*/
                                    
                                    TCodificadoServiceImpl TCodificadoService = new TCodificadoServiceImpl();
                                    List<TCodificado> TCodificado = TCodificadoService.mostrarTCodificado();
                                    request.setAttribute("listaT", TCodificado);
                                    
                                    System.out.println(TCodificado);
                                    
                                    /**-------------------Mostrar Lista N---------------------------------------*/
                                    
                                    NCodificadoServiceImpl NCodificadoService = new NCodificadoServiceImpl();
                                    List<NCodificado> NCodificado = NCodificadoService.mostrarNCodificado();
                                    request.setAttribute("listaN", NCodificado);
                                    
                                    System.out.println(NCodificado);
                                    
                                    /**-------------------Mostrar Lista M---------------------------------------*/
                                    
                                    MCodificadoServiceImpl MCodificadoService = new MCodificadoServiceImpl();
                                    List<MCodificado> MCodificado = MCodificadoService.mostrarMCodificado();
                                    request.setAttribute("listaM", MCodificado);
                                    
                                    System.out.println(MCodificado);
                                    
                                    /**-------------------Mostrar Lista Grados Histológico---------------------------------------*/
                                    
                                    GradoHistologicoServicioImpl GradoHistologicoServicio = new GradoHistologicoServicioImpl();
                                    List<GradoHistologico> gradoHistologico = GradoHistologicoServicio.mostrarGradoHistologico();
                                    request.setAttribute("listaGradoHistologico", gradoHistologico);
                                    
                                    System.out.println(gradoHistologico);
                                    
                                    /**-------------------Mostrar Lista HER2----------------------------------------*/
                                    
                                    Her2ServicioImpl Her2Servicio = new Her2ServicioImpl();
                                    List<Her2> her2 = Her2Servicio.mostrarHer2();
                                    request.setAttribute("listaHer2", her2);
                                    
                                    System.out.println(her2);
                                    
                                    /**-------------------Mostrar Lista Fish---------------------------------------*/
                                    
                                    FishServicioImpl FishServicio = new FishServicioImpl();
                                    List<Fish> fish = FishServicio.mostrarFish();
                                    request.setAttribute("listaFish", fish);
                                    
                                    System.out.println(fish);
                                    
                                    /**-------------------Mostrar Lista RE---------------------------------------*/
                                    
                                    ReceptorEstrogenoServicioImpl ReceptorEstrogenoServicio = new ReceptorEstrogenoServicioImpl();
                                    List<ReceptorEstrogeno> RE = ReceptorEstrogenoServicio.mostrarReceptorEstrogeno();
                                    request.setAttribute("listaRE", RE);
                                    
                                    System.out.println(RE);
                                    
                                    /**-------------------Mostrar Lista RP---------------------------------------*/
                                    
                                    ReceptorProgesteronaServicioImpl ReceptorProgesteronaServicio = new ReceptorProgesteronaServicioImpl();
                                    List<ReceptorProgesterona> RP = ReceptorProgesteronaServicio.mostrarAllReceptorProgesterona();
                                    request.setAttribute("listaRP", RP);
                                    
                                    System.out.println(RP);

                                    request.getRequestDispatcher("/WEB-INF/".concat(keyRuta)).forward(request, response);
                                    
                                    break;

                                }

                            }
                            break;

                        }

                        /*PACIENTE EN TRATAMIENTO*/
                        case 5: {

                            String keyRuta = file;
                            switch (keyRuta) {

                                case "paciente/cuenta.jsp": {

                                    PersonaServicioImpl personaServiceImpl = new PersonaServicioImpl();
                                    Persona persona = personaServiceImpl.mostrarPersona((int) sesion.getAttribute("idPersona"));

                                    PacienteServicioImpl pacienteServicioImpl = new PacienteServicioImpl();
                                    Paciente paciente = pacienteServicioImpl.mostrarPacientePotencial(Integer.parseInt(sesion.getAttribute("idCuenta").toString()));

                                    PicServicioImpl picServicioImpl = new PicServicioImpl();
                                    Pic pic = picServicioImpl.mostrarPic((int) sesion.getAttribute("idPersona"));

                                    RegistroDiagnosticoServiceImpl registroDiagnosticoServicio = new RegistroDiagnosticoServiceImpl();
                                    RegistroDiagnostico registro = registroDiagnosticoServicio.mostrarRegistroDiagnosticoPaciente(paciente.getIdPaciente());

                                    //System.out.println("esto es lo que hay en registro");

                                    //System.out.println(registro.getIdEtapaClinica());
                                    //System.out.println(registro.getIdPaciente());
                                    TipoSangreServicioImpl tipoSangreServicio = new TipoSangreServicioImpl();

                                    InputStream imagen = pic.getContenido();
                                    byte[] bytes = IOUtils.toByteArray(imagen);
                                    String base64String = Base64.getEncoder().encodeToString(bytes);

                                    sesion.setAttribute("base64Img", base64String);

                                    sesion.setAttribute("prz", paciente.getPrz());
                                    sesion.setAttribute("correo", persona.getCorreo());
                                    sesion.setAttribute("telefono", persona.getTelefono());

                                    request.setAttribute("nombre", sesion.getAttribute("nombre"));
                                    request.setAttribute("primerApellido", sesion.getAttribute("primerApellido"));
                                    request.setAttribute("segundoApellido", sesion.getAttribute("segundoApellido"));
                                    request.setAttribute("telefono", sesion.getAttribute("telefono"));
                                    request.setAttribute("correo", sesion.getAttribute("correo"));
                                    request.setAttribute("usuario", sesion.getAttribute("usuario"));
                                    request.setAttribute("prz", sesion.getAttribute("prz"));
                                    sesion.setAttribute("tipoSangre", persona.getIdTipoSangre());
                                    try
                                    {
                                        sesion.setAttribute("etapaCli", registro.getIdEtapaClinica());
                                    } catch(Exception es)
                                    {
                                        System.out.println(es);
                                    }
                                    

                                    sesion.setAttribute("expediente", paciente.getExpediente());

                                    EtapaClinicaServiceImpl etapaServicio = new EtapaClinicaServiceImpl();
                                    TipoTratamientoServiceImpl tratamientoServicio = new TipoTratamientoServiceImpl();

                                    List<EtapaClinica> etapas = etapaServicio.mostrarEtapaClinica();
                                    List<TipoTratamiento> tratamientos = tratamientoServicio.mostrarTipoTratamiento();

                                    List<TipoSangre> tipoSangre = tipoSangreServicio.mostrarTipoDeSangre();

                                    request.setAttribute("tipoSangre", tipoSangre);
                                    request.setAttribute("etapas", etapas);
                                    request.setAttribute("tratamientos", tratamientos);

                                    request.getRequestDispatcher("/WEB-INF/".concat(keyRuta)).forward(request, response); //Lo redirecciono al login
                                    break;

                                }

                                case "paciente/misTratamientos.jsp": {

                                    PacienteServicioImpl pacienteServicioImpl = new PacienteServicioImpl();
                                    Paciente paciente = pacienteServicioImpl.mostrarPacientePotencial(Integer.parseInt(sesion.getAttribute("idCuenta").toString()));
                                    
                                    sesion.setAttribute("path", keyRuta);

                                    TipoTratamientoServiceImpl tratamientoServicioImpl = new TipoTratamientoServiceImpl();

                                    List<TipoTratamiento> tratamientos = tratamientoServicioImpl.mostrarTipoTratamiento();

                                    UnionTratamientoPacienteServiceImpl unionTratamientoPacienteServiceImpl = new UnionTratamientoPacienteServiceImpl();

                                    int idPaciente = paciente.getIdPaciente();

                                    List<UnionTratamientoPaciente> unionTratamientosPaciente = unionTratamientoPacienteServiceImpl.mostrarUnionTratamientoPaciente(idPaciente);

                                    for (int i = 0; i < unionTratamientosPaciente.size(); i++) {
                                        unionTratamientosPaciente.get(i).setTerminado();
                                    }

                                    PicServicioImpl picServicioImpl = new PicServicioImpl();
                                    Pic pic = picServicioImpl.mostrarPic((int) sesion.getAttribute("idPersona"));

                                    InputStream imagen = pic.getContenido();
                                    byte[] bytes = IOUtils.toByteArray(imagen);
                                    String base64String = Base64.getEncoder().encodeToString(bytes);

                                    for (int i = 0; i < unionTratamientosPaciente.size(); i++) {
                                        System.out.println(unionTratamientosPaciente.get(i).getIdTratamientoPaciente());
                                    }

                                    
                                    sesion.setAttribute("base64Img", base64String);
                                    System.out.println("en front controller esss" + paciente.getIdPaciente());
                                    sesion.setAttribute("idPaciente", paciente.getIdPaciente());
                                    request.setAttribute("tipoTratamiento", tratamientos);
                                    request.setAttribute("UnionTratamientosPaciente", unionTratamientosPaciente);

                                    
                                    request.getRequestDispatcher("/WEB-INF/".concat(keyRuta)).forward(request, response);
                                    break;
                                }

                                case "paciente/index.jsp": {

                                    PersonaServicioImpl personaServicio = new PersonaServicioImpl();
                                    List<Persona> medicos = personaServicio.mostrarMedicosAdscritos();
                                    request.setAttribute("listaMedicos", medicos);

                                    request.getRequestDispatcher("/WEB-INF/".concat(keyRuta)).forward(request, response);
                                    break;
                                }

                            }
                            break;
                        }

                    }
                

                //System.out.println("filename if ".concat(file));
                // request.getRequestDispatcher("WEB-INF/" + file).forward(request, response);
                // return;
            } else {

                System.out.println("filename else ".concat(file));

                request.getRequestDispatcher("/".concat(file)).forward(request, response);
                return;

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
