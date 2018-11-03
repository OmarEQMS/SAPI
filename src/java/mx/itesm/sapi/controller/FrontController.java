/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Base64;
import java.util.Base64;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mx.itesm.sapi.bean.diagnostico.EtapaClinica;
import mx.itesm.sapi.bean.diagnostico.RegistroDiagnostico;
import mx.itesm.sapi.bean.gestionPaciente.DocumentoInicialTipoDocumento;
import mx.itesm.sapi.bean.gestionPaciente.EstadoPacientePaciente;
import mx.itesm.sapi.bean.gestionPaciente.Paciente;
import mx.itesm.sapi.bean.gestionTratamiento.TipoTratamiento;
import mx.itesm.sapi.bean.gestionTratamiento.Tratamiento;
import mx.itesm.sapi.bean.gestionTratamiento.TratamientoPaciente;
import mx.itesm.sapi.bean.gestionTratamiento.UnionTratamientoPaciente;
import mx.itesm.sapi.bean.moduloGestionMedico.Empleado;
import mx.itesm.sapi.bean.moduloGestionMedico.Especialidad;
import mx.itesm.sapi.bean.moduloGestionMedico.MedicoEspecialidad;
import mx.itesm.sapi.bean.persona.Cuenta;
import mx.itesm.sapi.bean.persona.Direccion;
import mx.itesm.sapi.bean.persona.Estado;
import mx.itesm.sapi.bean.persona.EstadoCivil;
import mx.itesm.sapi.bean.persona.Municipio;
import mx.itesm.sapi.bean.persona.Persona;
import mx.itesm.sapi.bean.persona.Pic;
import mx.itesm.sapi.bean.persona.Pic;
import mx.itesm.sapi.bean.persona.TipoSangre;
import mx.itesm.sapi.service.diagnostico.EtapaClinicaServiceImpl;
import mx.itesm.sapi.service.diagnostico.RegistroDiagnosticoServiceImpl;
import mx.itesm.sapi.service.gestionPaciente.DocumentoInicialTipoDocumentoServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.EstadoPacientePacienteServiceImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteServicioImpl;
import mx.itesm.sapi.service.gestionTratamiento.TipoTratamientoServiceImpl;
import mx.itesm.sapi.service.gestionTratamiento.TratamientoPacienteServiceImpl;
import mx.itesm.sapi.service.gestionTratamiento.TratamientoServiceImpl;
import mx.itesm.sapi.service.gestionTratamiento.UnionTratamientoPacienteServiceImpl;
import mx.itesm.sapi.service.moduloGestionMedico.EmpleadoServicioImpl;
import mx.itesm.sapi.service.moduloGestionMedico.EspecialidadServicioImpl;
import mx.itesm.sapi.service.moduloGestionMedico.MedicoEspecialidadServicioImpl;
import mx.itesm.sapi.service.persona.CodigoPostalServicioImpl;
import mx.itesm.sapi.service.persona.CuentaServicioImpl;
import mx.itesm.sapi.service.persona.DireccionServicioImpl;
import mx.itesm.sapi.service.persona.EstadoCivilServicioImpl;
import mx.itesm.sapi.service.persona.EstadoServicioImpl;
import mx.itesm.sapi.service.persona.MunicipioServicioImpl;
import mx.itesm.sapi.service.persona.PersonaServicioImpl;
import mx.itesm.sapi.service.persona.PicServicioImpl;
import org.apache.commons.io.IOUtils;
import mx.itesm.sapi.service.persona.PicServicioImpl;
import mx.itesm.sapi.service.persona.TipoSangreServicioImpl;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author quint
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
        if (file == null) {
            HttpSession sesion = request.getSession(true);
            if (sesion.getAttribute("idCuenta") == null) {
                request.setAttribute("status", "");
                request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
                return;
            } else {
                String strPath = sesion.getAttribute("path").toString();
                System.out.println("FrontController No path ".concat(strPath));
                request.getRequestDispatcher("WEB-INF/".concat(strPath)).forward(request, response);
                //   System.out.println("FrontController Message ".concat(request.getParameter("message")));
            }
        } else {
            if ("jsp".equals(file.substring(file.length() - 3))) {
                HttpSession sesion = request.getSession(true); //Veo si tiene sesion iniciada
                if (sesion.getAttribute("idCuenta") == null) { //no tiene sesion iniciada
                    // request.setAttribute("status", "");
                    request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response); //Lo redirecciono al login
                    return;
                } else { //Si tiene sesion iniciada
                    //Lo redireciono a su rol
                    int keyRol = (int) sesion.getAttribute("idRol");
                    switch (keyRol) {
                        //PACIENTE POTENCIAL
                        case 1: {
                            String keyRuta = request.getParameter("file");
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
                            break;
                        }
                        case 3: {
                            break;
                        }

                        /*NAVEGADORA*/
                        case 4: {
                            String keyRuta = request.getParameter("file");
                            switch (keyRuta) {

                                case "navegadora/cuentaNavegadora.jsp": {

                                    PersonaServicioImpl personaServiceImpl = new PersonaServicioImpl();
                                    Persona persona = personaServiceImpl.mostrarPersona((int) sesion.getAttribute("idPersona"));

                                    CuentaServicioImpl cuentaServicioImpl = new CuentaServicioImpl();
                                    Cuenta cuenta = cuentaServicioImpl.mostrarCuenta((int) sesion.getAttribute("idCuenta"));

                                    /*EmpleadoServicioImpl empleadoServicioImpl = new EmpleadoServicioImpl();
                                    Empleado empleado = empleadoServicioImpl.mostrarEmpleadoCuenta((int) sesion.getAttribute("idCuenta"));

                                    MedicoEspecialidadServicioImpl medicoEspecialidadServicioImpl = new MedicoEspecialidadServicioImpl();
                                    MedicoEspecialidad medicoEspecialidad = medicoEspecialidadServicioImpl.mostrarMedicoEspecialidadEmpleado(empleado.getIdEmpleado());

                                    EspecialidadServicioImpl especialidadServicioImpl = new EspecialidadServicioImpl();
                                    Especialidad especialidad = especialidadServicioImpl.mostrarEspecialidad(medicoEspecialidad.getIdEspecialidad());*/
/*
                                    System.out.println("holiiii");
                                    sesion.setAttribute("nombre", persona.getNombre());
                                    sesion.setAttribute("primerApellido", persona.getPrimerApellido());
                                    sesion.setAttribute("segundoApellido", persona.getSegundoApellido());
                                    System.out.println("el correo es:" + persona.getCorreo());
                                    sesion.setAttribute("correo", persona.getCorreo());
                                    sesion.setAttribute("telefono", persona.getTelefono());
                                    sesion.setAttribute("usuario", cuenta.getUsuario());
                                    //sesion.setAttribute("noEmpleado", empleado.getNoEmpleado());
                                    //sesion.setAttribute("especialidad", especialidad.getNombre());
                                    //sesion.setAttribute("cedulaProfesional", medicoEspecialidad.getCedulaProfesional());

                                    PicServicioImpl picServicioImpl = new PicServicioImpl();
                                    Pic pic = picServicioImpl.mostrarPic((int) sesion.getAttribute("idPersona"));

                                    InputStream imagen = pic.getContenido();
                                    byte[] bytes = IOUtils.toByteArray(imagen);
                                    String base64String = Base64.getEncoder().encodeToString(bytes);

                                    sesion.setAttribute("base64Img", base64String);*/

                                    request.getRequestDispatcher("/WEB-INF/".concat(keyRuta)).forward(request, response);

                                    /*MedicoEspecialidadServicioImpl medicoEspecialidadServicioImpl=new MedicoEspecialidadServicioImpl();
                                    MedicoEspecialidad medicoEspecialidad= medicoEspecialidadServicioImpl.mostrarMedicoEspecialidad(keyRol)
                                     */
                                    break;
                                }

                                case "navegadora/index.jsp":
                                {
                                    System.out.println("Index Navegadora ");
                                    request.getRequestDispatcher("/WEB-INF/".concat(keyRuta)).forward(request, response); //Lo redirecciono al dashboard navgeadora
                                    break;
                                }
                                 case "navegadora/calendar.jsp":
                                {
                                    System.out.println("Index Navegadora ");
                                    request.getRequestDispatcher("/WEB-INF/".concat(keyRuta)).forward(request, response); //Lo redirecciono al calendario de navgeadora
                                    break;
                                }
                                 case "navegadora/rendimiento.jsp":
                                {
                                    System.out.println("Index Navegadora ");
                                    request.getRequestDispatcher("/WEB-INF/".concat(keyRuta)).forward(request, response); //Lo redirecciono a su rendimiento
                                    break;

                                }
                                
                                 case "navegadora/documentos.jsp":
                                {
                                    System.out.println("Index Navegadora ");
                                    
                                    PacienteServicioImpl pacienteServicioImpl= new PacienteServicioImpl();
                                    Paciente paciente=pacienteServicioImpl.mostrarPaciente(1);
                                    
                                    CuentaServicioImpl cuentaServicioImpl = new CuentaServicioImpl();
                                    Cuenta cuenta = cuentaServicioImpl.mostrarCuenta(paciente.getIdCuenta());
                                    
                                    PersonaServicioImpl personaServiceImpl = new PersonaServicioImpl();
                                    Persona persona = personaServiceImpl.mostrarPersona(cuenta.getIdPersona());
                                    
                                    EstadoCivilServicioImpl estadoCivilServicioImpl=new EstadoCivilServicioImpl();
                                    EstadoCivil estadoCivil=estadoCivilServicioImpl.mostrarEstadoCivil(persona.getIdEstadoCivil());
                                    
                                    MunicipioServicioImpl municipioServicioImpl= new MunicipioServicioImpl();
                                    Municipio municipio= municipioServicioImpl.mostrarMunicipio(persona.getIdMunicipio());
                                    
                                    EstadoServicioImpl estadoServicioImpl= new EstadoServicioImpl();
                                    Estado estado= estadoServicioImpl.mostrarEstado(municipio.getIdEstado());
                                    
                                    DireccionServicioImpl direccionServicioImpl = new DireccionServicioImpl();
                                    Direccion direccion= direccionServicioImpl.mostrarDireccion(persona.getIdDireccion());
                                    
                                    System.out.println("el id paciente es...."+paciente.getIdPaciente());
                                    EstadoPacientePacienteServiceImpl estadoPacientePacienteServiceImpl=new EstadoPacientePacienteServiceImpl();
                                    EstadoPacientePaciente estadoPacientePaciente=estadoPacientePacienteServiceImpl.mostrarEstadoPacientePacienteIdPaciente(paciente.getIdPaciente());
                                    
                                    //
                                    DocumentoInicialTipoDocumentoServicioImpl documentoInicialTipoDocumentoServcioImpl = new DocumentoInicialTipoDocumentoServicioImpl();
                                    
                                    List<DocumentoInicialTipoDocumento> documentosInicialTipoDocumentos = documentoInicialTipoDocumentoServcioImpl.mostrarDocumentoInicialTipoDocumento(1);
                                     
                                    if(documentosInicialTipoDocumentos.size()>0){
                                        System.out.println("Esta llena");
                                    }else{
                                        System.out.println("Esta vacía");
                                    }
                                    
                                    request.setAttribute("documentos", documentosInicialTipoDocumentos);
                                    
                                    
                                    sesion.setAttribute("estadoCivil", estadoCivil.getNombre());
                                    sesion.setAttribute("fechaNacimiento", persona.getFechaNacimiento());
                                    sesion.setAttribute("municipio", municipio.getNombre());
                                    sesion.setAttribute("estado", estado.getNombre());
                                    sesion.setAttribute("fechaNacimiento", persona.getFechaNacimiento());
                                    sesion.setAttribute("calle", direccion.getCalle());
                                    sesion.setAttribute("colonia", direccion.getColonia());
                                    sesion.setAttribute("noExterior", direccion.getNoExterior());
                                    sesion.setAttribute("noInterior", direccion.getColonia());
                                    sesion.setAttribute("fechaRegistro", cuenta.getFecha());
                                    sesion.setAttribute("curp", persona.getCurp());
                                    sesion.setAttribute("telefono", persona.getTelefono());
                                    sesion.setAttribute("correo", persona.getCorreo());
                                    sesion.setAttribute("segundaOpinion", estadoPacientePaciente.getSegundaOpinion());
                                    
                                    
                                    
                                    //sesion.setAttribute("idDocumento", file);
                                    request.getRequestDispatcher("/WEB-INF/".concat(keyRuta)).forward(request, response); //Lo redirecciono a su rendimiento
                                    break;

                                }
                            }
                            break;
                        }

                        /*PACIENTE EN TRATAMIENTO*/
                        case 5: {

                            String keyRuta = request.getParameter("file");
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

                                    System.out.println("esto es lo que hay en registro");

                                    System.out.println(registro.getIdEtapaClinica());
                                    System.out.println(registro.getIdPaciente());
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
                                    sesion.setAttribute("etapaCli", registro.getIdEtapaClinica());

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
                                    List<Persona> medicos = personaServicio.mostrarMedicos();

                                    request.setAttribute("listaMedicos", medicos);

                                    request.getRequestDispatcher("/WEB-INF/".concat(keyRuta)).forward(request, response);
                                    break;
                                }

                            }
                            break;
                        }

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
