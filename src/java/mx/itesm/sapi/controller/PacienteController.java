/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mx.itesm.sapi.bean.calendario.FullCalendar;
import mx.itesm.sapi.bean.gestionPaciente.Biopsia;
import mx.itesm.sapi.bean.gestionPaciente.Cita;
import mx.itesm.sapi.bean.gestionPaciente.CitaEmpleado;
import mx.itesm.sapi.bean.gestionPaciente.ComentarioCita;
import mx.itesm.sapi.bean.gestionPaciente.DocumentoEstudio;
import mx.itesm.sapi.bean.gestionPaciente.DocumentoInicial;
import mx.itesm.sapi.bean.gestionPaciente.EstadoPacientePaciente;
import mx.itesm.sapi.bean.gestionPaciente.LlamadaCita;
import mx.itesm.sapi.bean.gestionPaciente.Paciente;
import mx.itesm.sapi.bean.gestionPaciente.PacienteAlergia;
import mx.itesm.sapi.bean.gestionPaciente.PacienteMedicoTitular;
import mx.itesm.sapi.bean.gestionPaciente.PacienteNavegadora;
import mx.itesm.sapi.bean.gestionPaciente.PacienteNecesidadEspecial;
import mx.itesm.sapi.bean.gestionPaciente.PacienteSeguro;
import mx.itesm.sapi.bean.gestionPaciente.ProgramaPaciente;
import mx.itesm.sapi.bean.gestionTratamiento.AuditoriaTratamientoPaciente;
import mx.itesm.sapi.bean.gestionTratamiento.PacienteTratamientoPrevio;
import mx.itesm.sapi.bean.persona.Cuenta;
import mx.itesm.sapi.bean.persona.Direccion;
import mx.itesm.sapi.bean.persona.Login;
import mx.itesm.sapi.bean.persona.Persona;
import mx.itesm.sapi.service.CalendarioServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.BiopsiaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.CitaEmpleadoServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.CitaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.ComentarioCitaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.DocumentoEstudioServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.DocumentoInicialServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.EstadoPacientePacienteServiceImpl;
import mx.itesm.sapi.service.gestionPaciente.LlamadaCitaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteAlergiaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteNavegadoraServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteNecesidadEspecialServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteSeguroServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.ProgramaPacienteServicioImpl;
import mx.itesm.sapi.service.persona.CuentaServicioImpl;
import mx.itesm.sapi.service.persona.DireccionServicioImpl;
import mx.itesm.sapi.service.persona.LoginServicioImpl;
import mx.itesm.sapi.service.persona.PersonaServicioImpl;

/**
 *
 * @author julioguzman
 */
@WebServlet(name = "PacienteController", urlPatterns = {"/PacienteController"})
public class PacienteController extends HttpServlet {

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

        //response.setContentType("text/html;charset=UTF-8");
        String key = request.getParameter("key");
       

        PrintWriter out = response.getWriter();

        switch (key) {

            case "obtenerEventos":

                System.out.println("El id paciente es:" + idPaciente);

                //Servicio
                CalendarioServicioImpl csi = new CalendarioServicioImpl();

                //Lista Calendarios
                List<FullCalendar> calendarios = csi.mostrarEventos(Integer.parseInt(idPaciente));

                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");

                out.print(new Gson().toJson(calendarios));

                break;

            case "agregarEvento":

                out.print("hola");

                break;

            //Author Angel Gtz
            case "eliminarCuentaPacientePotencial": {
                HttpSession sesion = request.getSession(true); //Veo si tiene sesion iniciada
                if (sesion.getAttribute("idCuenta") == null) { //no tiene sesion iniciada
                    // request.setAttribute("status", "");
                    request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response); //Lo redirecciono al login
                    return;
                } else {
                    //Elimino su cuenta (borrrado logico)
                    //Obtengo los id's perifericos de la sesion
                    int idCuenta = (int) sesion.getAttribute("idCuenta");
                    int idPaciente = (int) sesion.getAttribute("idPaciente");
                    int idPersona = (int) sesion.getAttribute("idPersona");

                    // creo los objetos de las tablas a modificar su estatus
                    CuentaServicioImpl cuentaServicio = new CuentaServicioImpl();
                    Cuenta cuenta = cuentaServicio.mostrarCuenta(idCuenta);

                    PersonaServicioImpl personaServicio = new PersonaServicioImpl();
                    Persona persona = personaServicio.mostrarPersona(idPersona);

                    PacienteServicioImpl pacienteServicio = new PacienteServicioImpl();
                    Paciente paciente = pacienteServicio.mostrarPaciente(idPaciente);

                    LoginServicioImpl loginServicio = new LoginServicioImpl();
                    Login login = loginServicio.mostrarLogin(idCuenta);

                    DireccionServicioImpl direccionServicio = new DireccionServicioImpl();
                    Direccion direccion = direccionServicio.mostrarDireccion(persona.getIdDireccion());

                    PicServicioImpl picServicio = new PicServicioImpl();
                    Pic pic = picServicio.mostrarPic(idPersona);

                    EstadoPacientePacienteServiceImpl estadoPacientePacienteServicio = new EstadoPacientePacienteServiceImpl();
                    EstadoPacientePaciente estadoPacientePaciente = estadoPacientePacienteServicio.mostrarEstadoPacientePaciente(idPaciente);

                    CitaServicioImpl citaServicio = new CitaServicioImpl();
                    Cita cita = citaServicio.mostrarCita(idPaciente);

                    ComentarioCitaServicioImpl comentarioCitaServicio = new ComentarioCitaServicioImpl();
                    ComentarioCita comentarioCita = comentarioCitaServicio.mostrarComentarioCita(cita.getIdCita());

                    CitaEmpleadoServicioImpl citaEmpleadoServicio = new CitaEmpleadoServicioImpl();
                    CitaEmpleado citaEmpleado = citaEmpleadoServicio.mostrarCitaEmpleado(cita.getIdCita());

                    LlamadaCitaServicioImpl llamadaCitaServicio = new LlamadaCitaServicioImpl();
                    LlamadaCita llamadaCita = llamadaCitaServicio.mostrarLlamadaCita(cita.getIdCita());

                    PacienteMedicoTitularServicioImpl pacienteMedicoTitularServicio = new PacienteMedicoTitularServicioImpl();
                    PacienteMedicoTitular pacienteMedicoTitular = pacienteMedicoTitularServicio.mostrarPacienteMedicoTitular(idPaciente);

                    PacienteNavegadoraServicioImpl pacienteNavegadoraServicio = new PacienteNavegadoraServicioImpl();
                    PacienteNavegadora pacienteNavegadora = pacienteNavegadoraServicio.mostrarPacienteNavegadora(idPaciente);

                    DocumentoInicialServicioImpl documentoInicialServicio = new DocumentoInicialServicioImpl();
                    DocumentoInicial documentoInicial = documentoInicialServicio.mostrarDocumentoInicial(idPaciente);

                    PacienteNecesidadEspecialServicioImpl pacienteNecesidadEspecialServicio = new PacienteNecesidadEspecialServicioImpl();
                    PacienteNecesidadEspecial pacienteNecesidadEspecial = pacienteNecesidadEspecialServicio.mostrarPacienteNecesidadEspecial(idPaciente);

                    PacienteAlergiaServicioImpl pacienteAlergiaServicio = new PacienteAlergiaServicioImpl();
                    PacienteAlergia pacienteAlergia = pacienteAlergiaServicio.mostrarPacienteAlergia(idPaciente);
                    
                    DocumentoEstudioServicioImpl documentoEstudioServicio = new DocumentoEstudioServicioImpl();
                    DocumentoEstudio documentoEstudio = documentoEstudioServicio.mostrarDocumentoEstudio(idPaciente);
                    
                    PacienteSeguroServicioImpl pacienteSeguroServicio = new PacienteSeguroServicioImpl();
                    PacienteSeguro pacienteSeguro = pacienteSeguroServicio.mostrarPacienteSeguro(idPaciente);
                    
                    BiopsiaServicioImpl biopsiaServicio = new BiopsiaServicioImpl();
                    Biopsia biopsia = biopsiaServicio.mostrarBiopsia(idPaciente);
                    
                    OtroResultadoPatologiaServicioImpl otroResultadoPatologiaServicio = new OtroResultadoPatologiaServicioImpl();
                    OtroResultadoPatologia otroResultadoPatologia = OtroResultadoPatologiaServicio.mostrarOtroResultadoPatologia(biopsia.getIdBiopsia());
                    
                    TratamientoPacienteServicioImpl tratamientoPacienteServicio = new TratamientoPacienteServicioImpl();
                    TratamientoPaciente tratamientoPaciente = tratamientoPacienteServicio.mostrarTratamientoPaciente(idPaciente);
                            
                    AuditoriaTratamientoPacienteServicioImpl auditoriaTratamientoPacienteServicio = new AuditoriaTratamientoPacienteServicioImpl();
                    AuditoriaTratamientoPaciente auditoriaTratamientoPaciente = auditoriaTratamientoPacienteServicio.mostrarAuditoriaTratamientoPaciente(tratamientoPaciente.getIdTratamientoPaciente());
                     
                    ProgramaPacienteServicioImpl programaPacienteServicio = new ProgramaPacienteServicioImpl();
                    ProgramaPaciente programaPaciente = programaPacienteServicio.mostrarProgramaPaciente(idPaciente);
                    
                    PacienteTratamientoPrevioServicioImpl pacienteTratamientoPrevioServicio = new PacienteTratamientoPrevioServicioImpl();
                    PacienteTratamientoPrevio pacienteTratamientoPrevio = pacienteTratamientoPrevioServicio.mostrarPacienteTratamientoPrevio(idPaciente);
                    
                            

                    //Implemento el borrado logico llamando a su objetoServicio despues al procesos almacenado y al final al id del objeto
                    pacienteAlergiaServicio.borradoLogicoPacienteAlergia(pacienteAlergia.getIdPacienteAlergia());
                    pacienteNecesidadEspecialServicio.borradoLogicoPacienteNecesidadEspecial(pacienteNecesidadEspecial.getIdNecesidadEspecial());
                    documentoInicialServicio.borradoLogicoDocumentoInicial(documentoInicial.getIdDocumentoInicial());
                    pacienteNavegadoraServicio.borradoLogicoPacienteNavegadora(pacienteNavegadora.getIdPacienteNavegadora());
                    pacienteMedicoTitularServicio.borradoLogicoPacienteMedicoTitular(pacienteMedicoTitular.getIdPacienteMedicoTitular());
                    llamadaCitaServicio.borradoLogicoLlamadaCita(llamadaCita.getIdLlamadaCita());
                    citaEmpleadoServicio.borradoLogicoCitaEmpleado(citaEmpleado.getIdCitaEmpleado());
                    comentarioCitaServicio.borradoLogicoComentarioCita(comentarioCita.getIdComentarioCita());
                    citaServicio.borradoLogicoCita(cita.getIdCita());
                    estadoPacientePacienteServicio.borradoLogicoEstadoPacientePaciente(estadoPacientePaciente.getIdEstadoPacientePaciente());
                    picServicio.borradoLogicoPic(pic.getIdPic());
                    direccionServicio.borradoLogicoDireccion(direccion.getIdDireccion());
                    loginServicio.borradoLogicoLogin(login.getIdLogin());
                    pacienteServicio.borradoLogicoPaciente(paciente.getIdCuenta());
                    personaServicio.borradoLogicoPersona(persona.getIdPersona());
                    cuentaServicio.borradoLogicoCuenta(cuenta.getIdCuenta());
                    documentoEstudioServicio.borradoLogicoDocumentoEstudio(documentoEstudio.getIdDocumentoEstudio());
                    

                    //Al no tener cuenta se le redirecciona al login
                    request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);

                }

                //Comentario para hacer commit x2 xdxdxd
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
