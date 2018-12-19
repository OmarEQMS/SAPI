/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

import static java.lang.Integer.parseInt;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Base64;

import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import mx.itesm.sapi.bean.calendario.FullCalendar;
import mx.itesm.sapi.bean.diagnostico.AuditoriaRegistroDiagnostico;
import mx.itesm.sapi.bean.diagnostico.EstadiajeTNM;
import mx.itesm.sapi.bean.diagnostico.RegistroDiagnostico;
import mx.itesm.sapi.bean.gestionPaciente.Biopsia;
import mx.itesm.sapi.bean.gestionPaciente.Cita;
import mx.itesm.sapi.bean.gestionPaciente.CitaEmpleado;
import mx.itesm.sapi.bean.gestionPaciente.ComentarioCita;
import mx.itesm.sapi.bean.gestionPaciente.DocumentoEstudio;
import mx.itesm.sapi.bean.gestionPaciente.DocumentoInicial;
import mx.itesm.sapi.bean.gestionPaciente.EstadoPacientePaciente;
import mx.itesm.sapi.bean.gestionPaciente.LlamadaCita;
import mx.itesm.sapi.bean.gestionPaciente.OtroResultadoPatologia;
import mx.itesm.sapi.bean.gestionPaciente.Paciente;
import mx.itesm.sapi.bean.gestionPaciente.PacienteAlergia;
import mx.itesm.sapi.bean.gestionPaciente.PacienteMedicoTitular;
import mx.itesm.sapi.bean.gestionPaciente.PacienteNavegadora;
import mx.itesm.sapi.bean.gestionPaciente.PacienteNecesidadEspecial;
import mx.itesm.sapi.bean.gestionPaciente.PacienteSeguro;
import mx.itesm.sapi.bean.gestionPaciente.ProgramaPaciente;
import mx.itesm.sapi.bean.gestionTratamiento.AlergiaPacienteFarmaco;
import mx.itesm.sapi.bean.gestionTratamiento.AuditoriaTratamientoPaciente;
import mx.itesm.sapi.bean.gestionTratamiento.PacienteTratamientoPrevio;
import mx.itesm.sapi.bean.gestionTratamiento.TratamientoPaciente;
import mx.itesm.sapi.bean.persona.Cuenta;
import mx.itesm.sapi.bean.persona.Direccion;
import mx.itesm.sapi.bean.persona.Login;
import mx.itesm.sapi.bean.persona.Persona;
import mx.itesm.sapi.bean.persona.Pic;
import mx.itesm.sapi.bean.diagnostico.EtapaClinica;
import mx.itesm.sapi.bean.diagnostico.RegistroDiagnostico;
import mx.itesm.sapi.bean.gestionPaciente.Paciente;
import mx.itesm.sapi.bean.gestionTratamiento.TipoTratamiento;
import mx.itesm.sapi.bean.gestionTratamiento.Tratamiento;
import mx.itesm.sapi.bean.gestionTratamiento.TratamientoPaciente;
import mx.itesm.sapi.bean.persona.Cuenta;
import mx.itesm.sapi.bean.persona.Persona;
import mx.itesm.sapi.bean.persona.Pic;
import mx.itesm.sapi.service.CalendarioServicioImpl;
import mx.itesm.sapi.service.diagnostico.AuditoriaRegistroDiagnosticoServiceImpl;
import mx.itesm.sapi.service.diagnostico.EstadiajeTNMServiceImpl;
import mx.itesm.sapi.service.diagnostico.RegistroDiagnosticoServiceImpl;
import mx.itesm.sapi.service.gestionPaciente.BiopsiaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.CitaEmpleadoServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.CitaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.ComentarioCitaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.DocumentoEstudioServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.DocumentoInicialServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.EstadoPacientePacienteServiceImpl;
import mx.itesm.sapi.service.gestionPaciente.LlamadaCitaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.OtroResultadoPatologiaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteAlergiaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteMedicoTitularServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteNavegadoraServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteNecesidadEspecialServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteSeguroServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteServiceImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.ProgramaPacienteServicioImpl;
import mx.itesm.sapi.service.gestionTratamiento.AlergiaPacienteFarmacoServiceImpl;
import mx.itesm.sapi.service.gestionTratamiento.AuditoriaTratamientoPacienteServiceImpl;
import mx.itesm.sapi.service.gestionTratamiento.PacienteTratamientoPrevioServiceImpl;
import mx.itesm.sapi.service.gestionTratamiento.TratamientoPacienteServiceImpl;
import mx.itesm.sapi.service.persona.CuentaServicioImpl;
import mx.itesm.sapi.service.persona.DireccionServicioImpl;
import mx.itesm.sapi.service.persona.LoginServicioImpl;
import mx.itesm.sapi.service.persona.PersonaServicioImpl;
import mx.itesm.sapi.service.persona.PicServicioImpl;

import mx.itesm.sapi.service.diagnostico.EtapaClinicaServiceImpl;
import mx.itesm.sapi.service.diagnostico.RegistroDiagnosticoServiceImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteServicioImpl;
import mx.itesm.sapi.service.gestionTratamiento.TipoTratamientoServiceImpl;
import mx.itesm.sapi.service.gestionTratamiento.TratamientoPacienteServiceImpl;
import mx.itesm.sapi.service.gestionTratamiento.TratamientoServiceImpl;
import mx.itesm.sapi.service.persona.CuentaServicioImpl;
import mx.itesm.sapi.service.persona.PersonaServicioImpl;
import mx.itesm.sapi.service.persona.PicServicioImpl;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author Julio Badillo
 *
 *
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50)

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

        response.setContentType("text/html;charset=UTF-8");
        String key = request.getParameter("key");
        System.out.println("En paciente controller es" + request.getParameter("idPaciente"));

        String idPacienteS = request.getParameter("idPaciente");

        PrintWriter out = response.getWriter();

        HttpSession sesion = request.getSession(true);

        if (sesion.getAttribute("idCuenta") == null) { //no tiene sesion iniciada
            // request.setAttribute("status", "");
            request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response); //Lo redirecciono al login
            System.out.println("estoy en el if");
            return;
        } else {
            //Si tiene sesion iniciada
            int keyRol = (int) sesion.getAttribute("idRol");
            switch (keyRol) {
                case 5: {
                    System.out.println("estoy en el case 5");
                    switch (key) {

                        case "obtenerEventos": {

                            System.out.println("El id paciente es:" + idPacienteS);

                            //Servicio
                            CalendarioServicioImpl csi = new CalendarioServicioImpl();

                            //Lista Calendarios
                            List<FullCalendar> calendarios = csi.mostrarEventos(Integer.parseInt(idPacienteS));

                            response.setContentType("application/json");
                            response.setCharacterEncoding("UTF-8");

                            System.out.println(new Gson().toJson(calendarios));

                            out.print(new Gson().toJson(calendarios));
                        }
                        break;

                        case "agregarEvento": {

                            int idImportancia;

                            String tipo = request.getParameter("tipo");

                            if (Integer.parseInt(tipo) == 3) {
                                idImportancia = 1;
                            } else {
                                idImportancia = 2;
                            }

                            String medico = request.getParameter("medico");

                            int piso = Integer.parseInt(request.getParameter("piso"));
                            String edificio = request.getParameter("edificio");

                            System.out.println("EL PISO ES: " + piso);
                            System.out.println("EL EDIFICIO ES: " + edificio);
                            
                            if(edificio.equals("1")){
                                piso = 1;
                            }else{
                                piso = piso + 2;                                
                            }

                            String fechaProgramada = request.getParameter("fechaProgramada");

                            Cita cita = new Cita();

                            cita.setIdTipoCita(Integer.parseInt(tipo));
                            cita.setIdPaciente(Integer.parseInt(idPacienteS));
                            cita.setIdEstadoCita(5);
                            cita.setIdImportanciaCita(idImportancia);
                            cita.setIdPiso(piso);

                            //No se setea
                            //cita.setIdTipoTratamiento(Integer.parseInt(tipo));
                            //No se setea
                            //cita.setIdTipoTratamiento(Integer.parseInt(tipo));
                            cita.setFechaProgramada(Timestamp.valueOf(fechaProgramada));
                            //esto estaba en origin   cita.setFechaProgramada(fechaProgramada);

                            //No se setea porque no hay estudios
                            //cita.setIdEstudio();
                            //No se setea porque esto lo registran los pacientes potenciales
                            //cita.setIdMotivoConsulta(idImportancia);
                            //No se setea porque es de la navegadora
                            //cita.setFechaReal();
                            System.out.println("El id Paciente es: " + cita.getIdPaciente());
                            System.out.println("El id estado cita: " + cita.getIdEstadoCita());
                            System.out.println("El id de la importancia: " + cita.getIdImportanciaCita());
                            System.out.println("El piso es : " + cita.getIdPiso());
                            System.out.println("El edificio es: " + edificio);
                            System.out.println("El id del tipo de tratamiento: " + cita.getIdTipoTratamiento());
                            System.out.println("Fecha programada: " + cita.getFechaProgramada());

                            System.out.println(":::::::NULOS::::::");
                            System.out.println("El id motivo consulta es: " + cita.getIdMotivoConsulta());
                            System.out.println("El id estudio es: " + cita.getIdEstudio());
                            System.out.println("La fecha real: " + cita.getFechaReal());

                            cita.setEstatus(1);

                            //Manda a llamar al servicio
                            CalendarioServicioImpl nuevaCita = new CalendarioServicioImpl();

                            int agregado = nuevaCita.agregarEvento(cita, edificio);

                            System.out.println("FINAL: " + agregado);

                            /*if(agregado > 0){
                    out.print("success");
                }else{
                    out.print("error");
                }*/
                            out.print("success");
                        }

                        break;

                        case "repiteCorreo": {

                            String correo = request.getParameter("correo");
                            int idPersona = (int) sesion.getAttribute("idPersona");

                            PersonaServicioImpl _registroServicio = new PersonaServicioImpl();

                            System.out.println("ENTRA AQUÍ");

                            //Checo si el usuario existe
                            if (_registroServicio.existsCorreo(correo, idPersona)) {
                                System.out.println("EXISTE");
                                out.print("CorreoAlreadyExists");

                            } else {
                                System.out.println("NO EXISTE");
                                //Si no existe, lo inserto
                                out.print("CorreoDoesntExist");

                            }
                        }
                        break;

                        case "eliminarCuentaPaciente": {
                            System.out.println("Si llego aqui paciente");
                            if (sesion.getAttribute("idCuenta") == null) {
                                /**
                                 * Angel Gutiérrez 01/11/2018 Si no tiene sesion
                                 * iniciada
                                 */
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
                                int idPersona = (int) sesion.getAttribute("idPersona");
                                int idPaciente = Integer.parseInt(sesion.getAttribute("idPaciente").toString());
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
                                 * dependencia ciclan para buscar todos los
                                 * datos que tienen encadenados para proseguir
                                 * con el borrado logico en la base de datos
                                 */
                                CuentaServicioImpl cuentaServicio = new CuentaServicioImpl();

                                PersonaServicioImpl personaServicio = new PersonaServicioImpl();

                                Persona persona = personaServicio.mostrarPersona(idPersona);
                                personaServicio.borradoLogicoPersona(persona.getIdPersona());

                                PacienteServiceImpl pacienteServicio = new PacienteServiceImpl();
                                if (pacienteServicio.mostrarPaciente(idPaciente) != null) {

                                    Paciente paciente = pacienteServicio.mostrarPaciente(idPaciente);
                                    pacienteServicio.borradoLogicoPaciente(idPaciente);
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
                                System.out.println("precitas");
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
                                System.out.println("poscitas");
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

                                DocumentoEstudioServicioImpl documentoEstudioServicio = new DocumentoEstudioServicioImpl();
                                if (documentoEstudioServicio.mostrarDocumentoEstudioIdEspecifico(idPaciente) != null) {
                                    List<DocumentoEstudio> docuemntoEstudios = new ArrayList<>();
                                    docuemntoEstudios = documentoEstudioServicio.mostrarDocumentoEstudioIdEspecifico(idPaciente);
                                    int documentosTotales = docuemntoEstudios.size() - 1;
                                    int idDocumento = 0;
                                    while (documentosTotales > -1) {
                                        idDocumento = docuemntoEstudios.get(documentosTotales).getIdDocumentoEstudio();
                                        documentoEstudioServicio.borradoLogicoDocumentoEstudio(idDocumento);
                                        documentosTotales = documentosTotales - 1;
                                    }
                                }

                                PacienteSeguroServicioImpl pacienteSeguroServicio = new PacienteSeguroServicioImpl();
                                if (pacienteSeguroServicio.mostrarPacienteSeguroIdEspecifico(idPaciente) != null) {
                                    List<PacienteSeguro> seguros = new ArrayList<>();
                                    seguros = pacienteSeguroServicio.mostrarPacienteSeguroIdEspecifico(idPaciente);
                                    int segurosTotales = seguros.size() - 1;
                                    int idSeguro = 0;
                                    while (segurosTotales > -1) {
                                        idSeguro = seguros.get(segurosTotales).getIdPacienteSeguro();
                                        pacienteSeguroServicio.borradoLogicoPacienteSeguro(idSeguro);
                                        segurosTotales = segurosTotales - 1;
                                    }

                                }

                                BiopsiaServicioImpl biopsiaServicio = new BiopsiaServicioImpl();
                                if (biopsiaServicio.mostrarAllBiopsiaIdEspecifico(idPaciente) != null) {
                                    List<Biopsia> biopsias = new ArrayList<>();
                                    biopsias = biopsiaServicio.mostrarAllBiopsiaIdEspecifico(idPaciente);
                                    int biopsiasTotales = biopsias.size() - 1;
                                    int idBiopsia = 0;
                                    while (biopsiasTotales > -1) {
                                        idBiopsia = biopsias.get(biopsiasTotales).getIdBiopsia();
                                        OtroResultadoPatologiaServicioImpl otroResultadoPatologiaServicio = new OtroResultadoPatologiaServicioImpl();
                                        if (otroResultadoPatologiaServicio.mostrarOtroResultadoPatologiaIdBiopsia(idBiopsia) != null) {
                                            OtroResultadoPatologia otroResultadoPatologia = otroResultadoPatologiaServicio.mostrarOtroResultadoPatologiaIdBiopsia(idBiopsia);
                                            otroResultadoPatologiaServicio.borradoLogicoOtroResultadoPatologia(otroResultadoPatologia.getIdOtroResultadoPatologia());

                                        }
                                        biopsiaServicio.borradoLogicoBiopsia(idBiopsia);
                                        biopsiasTotales = biopsiasTotales - 1;
                                    }

                                }

                                TratamientoPacienteServiceImpl tratamientoPacienteServicio = new TratamientoPacienteServiceImpl();
                                if (tratamientoPacienteServicio.mostrarTratamientoPacienteIdEspecifico(idPaciente) != null) {
                                    List<TratamientoPaciente> tratamientos = new ArrayList<>();
                                    tratamientos = tratamientoPacienteServicio.mostrarTratamientoPacienteIdEspecifico(idPaciente);
                                    int tratamientosTotales = tratamientos.size() - 1;
                                    int idTratamiento = 0;
                                    while (tratamientosTotales > -1) {
                                        idTratamiento = tratamientos.get(idTratamiento).getIdTipoTratamiento();
                                        AuditoriaTratamientoPacienteServiceImpl auditoriaTratamientoPacienteServicio = new AuditoriaTratamientoPacienteServiceImpl();

                                        if (auditoriaTratamientoPacienteServicio.mostrarAuditoriaTratamientoPacienteIdTratamiento(idTratamiento) != null) {
                                            AuditoriaTratamientoPaciente auditoriaTratamientoPaciente = auditoriaTratamientoPacienteServicio.mostrarAuditoriaTratamientoPacienteIdTratamiento(idTratamiento);
                                            auditoriaTratamientoPacienteServicio.borradoLogicoAuditoriaTratamientoPaciente(auditoriaTratamientoPaciente.getIdAuditoriaTratamientoPaciente());

                                        }
                                        tratamientoPacienteServicio.borradoLogicoTratamientoPaciente(idTratamiento);
                                        tratamientosTotales = tratamientosTotales - 1;
                                    }

                                }

                                ProgramaPacienteServicioImpl programaPacienteServicio = new ProgramaPacienteServicioImpl();
                                if (programaPacienteServicio.mostrarProgramaPacienteIdPaciente(idPaciente) != null) {
                                    List<ProgramaPaciente> programas = new ArrayList<>();
                                    programas = programaPacienteServicio.mostrarProgramaPacienteSeguroIdEspecifico(idPaciente);
                                    int programasTotales = programas.size() - 1;
                                    int idPrograma = 0;
                                    while (programasTotales > -1) {
                                        idPrograma = programas.get(programasTotales).getIdProgramaPaciente();
                                        programaPacienteServicio.borradoLogicoProgramaPaciente(idPrograma);
                                        programasTotales = programasTotales - 1;
                                    }
                                }

                                PacienteTratamientoPrevioServiceImpl pacienteTratamientoPrevioServicio = new PacienteTratamientoPrevioServiceImpl();
                                if (pacienteTratamientoPrevioServicio.mostrarPacienteTratamientoPrevioIdPaciente(idPaciente) != null) {
                                    List<PacienteTratamientoPrevio> tratamientos = new ArrayList<>();
                                    tratamientos = pacienteTratamientoPrevioServicio.mostrarPacienteTratamientoPrevioIdEspecifico(idPaciente);
                                    int tratamientosTotales = tratamientos.size() - 1;
                                    int idTratamiento = 0;
                                    while (tratamientosTotales > - 1) {
                                        idTratamiento = tratamientos.get(tratamientosTotales).getIdPacienteTratamientoPrevio();
                                        pacienteTratamientoPrevioServicio.borradoLogicoPacienteTratamientoPrevio(idTratamiento);
                                        tratamientosTotales = tratamientosTotales - 1;
                                    }
                                }

                                AlergiaPacienteFarmacoServiceImpl alergiaPacienteFarmacoServicio = new AlergiaPacienteFarmacoServiceImpl();
                                if (alergiaPacienteFarmacoServicio.mostrarAlergiaPacienteFarmacoIdPaciente(idPaciente) != null) {
                                    List< AlergiaPacienteFarmaco> alergias = new ArrayList<>();
                                    alergias = alergiaPacienteFarmacoServicio.mostrarAlergiaPacienteFarmacoIdEspecifico(idPaciente);
                                    int alergiasTotales = alergias.size() - 1;
                                    int idAlergias = 0;
                                    while (alergiasTotales > - 1) {
                                        idAlergias = alergias.get(alergiasTotales).getIdAlergiaPacienteFarmaco();
                                        alergiaPacienteFarmacoServicio.borradoLogicoAlergiaPacienteFarmaco(idAlergias);
                                        alergiasTotales = alergiasTotales - 1;
                                    }
                                }

                                RegistroDiagnosticoServiceImpl registroDiagnosticoServicio = new RegistroDiagnosticoServiceImpl();
                                if (registroDiagnosticoServicio.mostrarRegistroDiagnosticoPaciente(idPaciente) != null) {
                                    List< RegistroDiagnostico> registros = new ArrayList<>();
                                    registros = registroDiagnosticoServicio.mostrarRegistroDiagnosticoIdEspecifico(idPaciente);
                                    int registrosTotales = registros.size() - 1;
                                    int idRegistro = 0, idEstadiaje = 0;
                                    while (registrosTotales > - 1) {
                                        idRegistro = registros.get(registrosTotales).getIdRegistroDiagnostico();
                                        idEstadiaje = registros.get(registrosTotales).getIdRegistroTNM();

                                        EstadiajeTNMServiceImpl estadiajeTNMServicio = new EstadiajeTNMServiceImpl();
                                        if (estadiajeTNMServicio.mostrarEstadiajeTNM(idEstadiaje) != null) {
                                            estadiajeTNMServicio.borradoLogicoEstadiajeTNM(idEstadiaje);

                                        }

                                        AuditoriaRegistroDiagnosticoServiceImpl auditoriaRegistroDiagnosticoServicio = new AuditoriaRegistroDiagnosticoServiceImpl();
                                        if (auditoriaRegistroDiagnosticoServicio.mostrarAuditoriaRegistroDiagnosticoIdRegistro(idRegistro) != null) {
                                            AuditoriaRegistroDiagnostico auditoriaRegistro = auditoriaRegistroDiagnosticoServicio.mostrarAuditoriaRegistroDiagnosticoIdRegistro(idRegistro);
                                            auditoriaRegistroDiagnosticoServicio.borradoLogicoAuditoriaRegistroDiagnostico(auditoriaRegistro.getIdAuditoriaRegistroDiagnostico());
                                        }

                                        registroDiagnosticoServicio.borradoLogicoRegistroDiagnostico(idRegistro);
                                        registrosTotales = registrosTotales - 1;
                                    }
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
                        }
                        break;

                        case "cambiarDatos": {

                            /**
                             * Fernanda Orduña y Pablo Lugo
                             *
                             * El case cambiarDatos se encarga de guardar los
                             * cambios que el paciente haya realizado de los
                             * datos correo, número de expediente, telefono,
                             * etapa clínica y tipo de sangre desde Mi Cuenta
                             * Paciente
                             */
                            /**
                             * Declaro las variables que reciben los datos como
                             * parámetro
                             */
                            String correo = request.getParameter("correo");
                            String noExpediente = request.getParameter("noExpediente");
                            String telefono = request.getParameter("telefono");
                            String etapaClinica = request.getParameter("etapaClinica");
                            int tipoSangre = Integer.parseInt(request.getParameter("tipoSangre"));
                            Part part = request.getPart("file-image");
                            
                            

                            //No se valida el telefono ni el correo aquí? Lo validamos nosotros o el front?
                            /**
                             * Declaro los objetos de tipo Persona y Paciente
                             */
                            PersonaServicioImpl personaServicioImpl = new PersonaServicioImpl();
                            Persona persona = personaServicioImpl.mostrarPersona((int) sesion.getAttribute("idPersona"));

                            PacienteServicioImpl pacienteServicioImpl = new PacienteServicioImpl();
                            Paciente paciente = pacienteServicioImpl.mostrarPacientePotencial((int) sesion.getAttribute("idCuenta"));
                            
                            System.out.println("NuevoNoExpediente: ".concat(noExpediente));
                            System.out.println("AntExpediente: ".concat(paciente.getExpediente()));
                            
                            /**
                             * El case cambiarDatos también se encarga de
                             * cambiar la foto de perfil del paciente cuando el
                             * así lo desee
                             */
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

                            int idPaciente2 = pacienteServicioImpl.mostrarPacientePotencial((int) sesion.getAttribute("idCuenta")).getIdPaciente();

                            RegistroDiagnosticoServiceImpl registroDiagnosticoServicioImpl = new RegistroDiagnosticoServiceImpl();
                            System.out.println("El idPaciente despues de registro: " + idPaciente2);
                            RegistroDiagnostico registroDiagnostico = registroDiagnosticoServicioImpl.mostrarRegistroDiagnosticoPaciente(idPaciente2);

                            System.out.println("Ya pase registro");

                            /**
                             * Asigno los nuevos datos a los objetos declarador
                             * anteriormente para poder actualizarlos
                             */
                            persona.setCorreo(correo);
                            persona.setTelefono(telefono);
                            persona.setIdTipoSangre(tipoSangre);

                            System.out.println("la etapa es" + etapaClinica);
                            registroDiagnostico.setIdEtapaClinica(Integer.parseInt(etapaClinica));
                            paciente.setExpediente(noExpediente);

                            personaServicioImpl.actualizarPersona(persona);
                            pacienteServicioImpl.actualizarPaciente(paciente);

                            if (registroDiagnosticoServicioImpl.actualizarRegistroDiagnostico(registroDiagnostico)) {
                                System.out.println("Si se actualiza");
                            } else {
                                System.out.println("No se hizo compa");
                            }

                            sesion.setAttribute("correo", persona.getCorreo());
                            sesion.setAttribute("telefono", persona.getTelefono());

                            request.setAttribute("correo", sesion.getAttribute("correo"));
                            request.setAttribute("telefono", sesion.getAttribute("telefono"));

                            request.getRequestDispatcher("/WEB-INF/potencial/cuentaPaciente.jsp").forward(request, response);

                            break;
                        }

                        case "cambiarContrasena": {

                            /**
                             * El case cambiarContraseña se encarga de
                             * actualizar la contraseña de la cuenta del
                             * paciente cuando el así lo desee
                             */
                            if (sesion.getAttribute("idCuenta") == null) { //no tiene sesion iniciada
                                // request.setAttribute("status", "");
                                request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response); //Lo redirecciono al login
                                return;
                            } else {
                                /**
                                 * Declaro las variables que reciben como
                                 * parámetro la nueva contraseña y el idCuenta
                                 */
                                int idCuenta = (int) sesion.getAttribute("idCuenta");
                                String contrasena = request.getParameter("password");
                                String contrasena2 = request.getParameter("password2");

                                /**
                                 * Comparo que ambas contraseñas sean iguales
                                 */
                                if (contrasena.equals(contrasena2)) {

                                    CuentaServicioImpl cuentaServicio = new CuentaServicioImpl();

                                    Cuenta cuenta = cuentaServicio.mostrarCuenta(idCuenta);
                                    /**
                                     * Asigno la nueva contraseña a la cuenta
                                     */
                                    cuenta.setPassword(contrasena);

                                    cuentaServicio.actualizarCuenta(cuenta);
                                }

                            }
                            break;
                        }

                        case "agregarTratamiento": {

                            /**
                             * El case agregarTratamiento recopila los datos de
                             * tipo tratamiento, fecha de inicio y id paciente
                             * para asignárselos a un nuevo objeto de tipo
                             * TratamientoPaciente y posteriormente agregárselo
                             * al paciente
                             */
                            System.out.println("Entre a agregar tratamiento");
                            System.out.println("entro a la key Agregar tratamiento");
                            if (sesion.getAttribute("idCuenta") == null) { //no tiene sesion iniciada
                                // request.setAttribute("status", "");
                                request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response); //Lo redirecciono al login
                                return;
                            } else {

                                /**
                                 * Declaro las variables que recibirán como
                                 * parámetro el id del tratamiento, la fecha de
                                 * inicio y el idPaciente
                                 */
                                int idTipoTratamiento = Integer.parseInt(request.getParameter("idTipoTratamiento"));
                                Date fechaInicio = Date.valueOf(request.getParameter("fechaInicio"));
                                int idPaciente2 = (int) sesion.getAttribute("idPaciente");
                                System.out.println("Este es el idPaciente tiene que ser esteQQQQ:" + idPaciente2);

                                /**
                                 * Declaro el objeto tratamientoPaciente para
                                 * posteriormente asignarle los datos
                                 * correspondientes al nuevo tratamiento
                                 */
                                TratamientoPacienteServiceImpl tratamientoPacienteServiceImpl = new TratamientoPacienteServiceImpl();
                                TratamientoPaciente tratamientoPaciente = new TratamientoPaciente();

                                tratamientoPaciente.setIdTipoTratamiento(idTipoTratamiento);
                                tratamientoPaciente.setFechaInicio(fechaInicio);
                                tratamientoPaciente.setIdPaciente(idPaciente2);

                                int idTratamientoPaciente = tratamientoPacienteServiceImpl.agregarTratamientoPaciente(tratamientoPaciente);

                                out.flush();
                                out.print(idTratamientoPaciente);
                            }
                            break;
                        }

                        case "terminarTratamiento": {
                            /**
                             * terminarTratamiento es el case encargado de
                             * asignar una fecha de fin a un objeto de tipo
                             * tratamientoPaciente a partir del
                             * idTratamientoPaciente que obtiene como parámetro
                             */

                            int idTratamientoPaciente = Integer.parseInt(request.getParameter("idTratamientoPaciente"));
                            System.out.println("Este es el idTratamientoPaciente");
                            Date fechaFin = Date.valueOf(request.getParameter("fechaFin"));

                            TratamientoPacienteServiceImpl tratamientoPacienteServicio = new TratamientoPacienteServiceImpl();

                            TratamientoPaciente tratamientoPaciente = tratamientoPacienteServicio.mostrarTratamientoPaciente(idTratamientoPaciente);

                            /**
                             * Asigno la fecha de fin de tratamiento al objeto
                             * tratamientoPaciente
                             */
                            tratamientoPaciente.setFechaFin(fechaFin);
                            System.out.println("Este es el idPaciente tiene que ser de termnar:" + tratamientoPaciente.getIdPaciente());
                            tratamientoPacienteServicio.actualizarTratamientoPaciente(tratamientoPaciente);

                        }
                        break;

                    }
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
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response
    )
            throws ServletException,
            IOException {
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
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response
    )
            throws ServletException,
            IOException {
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
