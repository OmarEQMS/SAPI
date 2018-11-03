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
 * @author julioguzman
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
        System.out.println("En paciente controller es"+request.getParameter("idPaciente"));
        
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

                            String piso = request.getParameter("piso");
                            String edificio = request.getParameter("edificio");

                            System.out.println("EL PISO ES: " + piso);
                            System.out.println("EL EDIFICIO ES: " + edificio);

                            String fechaProgramada = request.getParameter("fechaProgramada");

                            Cita cita = new Cita();

                            cita.setIdTipoCita(Integer.parseInt(tipo));
                            cita.setIdPaciente(Integer.parseInt(idPacienteS));
                            cita.setIdEstadoCita(5);
                            cita.setIdImportanciaCita(idImportancia);
                            cita.setIdPiso(Integer.parseInt(piso));

                            //No se setea
                            //cita.setIdTipoTratamiento(Integer.parseInt(tipo));
                            cita.setFechaProgramada(fechaProgramada);

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

                        case "cambiarDatos": {

                            /** 
                             * Fernanda Orduña y Pablo Lugo
                             * 
                             * El case cambiarDatos se encarga de guardar los cambios que el paciente haya
                             * realizado de los datos correo, número de expediente,
                             * telefono, etapa clínica y tipo de sangre desde Mi Cuenta Paciente
                             */
                            
                            /**
                             * Declaro las variables que reciben los datos como parámetro
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

                            /** 
                             * El case cambiarDatos también se encarga de cambiar la foto de perfil 
                             * del paciente cuando el así lo desee
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
                             * Asigno los nuevos datos a los objetos declarador anteriormente
                             * para poder actualizarlos
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
                             * El case cambiarContraseña se encarga de actualizar la contraseña 
                             * de la cuenta del paciente cuando el así lo desee
                             */

                            if (sesion.getAttribute("idCuenta") == null) { //no tiene sesion iniciada
                                // request.setAttribute("status", "");
                                request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response); //Lo redirecciono al login
                                return;
                            } else {
                                /**
                                 * Declaro las variables que reciben como parámetro la nueva contraseña y el idCuenta
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
                             * El case agregarTratamiento recopila los datos de tipo tratamiento, fecha de inicio
                             * y id paciente para asignárselos a un nuevo objeto de tipo TratamientoPaciente y posteriormente agregárselo
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
                                 * Declaro las variables que recibirán como parámetro el id del tratamiento, la fecha de inicio
                                 * y el idPaciente
                                 */
                                int idTipoTratamiento = Integer.parseInt(request.getParameter("idTipoTratamiento"));
                                Date fechaInicio = Date.valueOf(request.getParameter("fechaInicio"));
                                int idPaciente2 = (int) sesion.getAttribute("idPaciente");
                                System.out.println("Este es el idPaciente tiene que ser esteQQQQ:" + idPaciente2);
                               
                                /**
                                 * Declaro el objeto tratamientoPaciente para posteriormente asignarle los datos 
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
                             * terminarTratamiento es el case encargado de asignar una fecha de fin a 
                             * un objeto de tipo tratamientoPaciente a partir del idTratamientoPaciente que obtiene como parámetro
                             */

                            int idTratamientoPaciente = Integer.parseInt(request.getParameter("idTratamientoPaciente"));
                            System.out.println("Este es el idTratamientoPaciente");
                            Date fechaFin = Date.valueOf(request.getParameter("fechaFin"));

                            TratamientoPacienteServiceImpl tratamientoPacienteServicio = new TratamientoPacienteServiceImpl();

                            TratamientoPaciente tratamientoPaciente = tratamientoPacienteServicio.mostrarTratamientoPaciente(idTratamientoPaciente);

                            /**
                             * Asigno la fecha de fin de tratamiento al objeto tratamientoPaciente
                             */
                            tratamientoPaciente.setFechaFin(fechaFin);
                            System.out.println("Este es el idPaciente tiene que ser de termnar:" + tratamientoPaciente.getIdPaciente());
                            tratamientoPacienteServicio.actualizarTratamientoPaciente(tratamientoPaciente);

                        }
                        break;

                        case "eliminarCuentaPacientePotencial": {

                            if (sesion.getAttribute("idCuenta") == null) {
                                /**
                                 * Si no tiene sesion iniciada
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
                                
                                int idPaciente = Integer.parseInt(request.getParameter("idPaciente"));
                                /**
                                 * creo los objetos de las tablas a modificar su
                                 * estatus
                                 */
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
                                OtroResultadoPatologia otroResultadoPatologia = otroResultadoPatologiaServicio.mostrarOtroResultadoPatologia(biopsia.getIdBiopsia());

                                TratamientoPacienteServiceImpl tratamientoPacienteServicio = new TratamientoPacienteServiceImpl();
                                TratamientoPaciente tratamientoPaciente = tratamientoPacienteServicio.mostrarTratamientoPaciente(idPaciente);

                                AuditoriaTratamientoPacienteServiceImpl auditoriaTratamientoPacienteServicio = new AuditoriaTratamientoPacienteServiceImpl();
                                AuditoriaTratamientoPaciente auditoriaTratamientoPaciente = auditoriaTratamientoPacienteServicio.mostrarAuditoriaTratamientoPaciente(tratamientoPaciente.getIdTratamientoPaciente());

                                ProgramaPacienteServicioImpl programaPacienteServicio = new ProgramaPacienteServicioImpl();
                                ProgramaPaciente programaPaciente = programaPacienteServicio.mostrarProgramaPaciente(idPaciente);

                                PacienteTratamientoPrevioServiceImpl pacienteTratamientoPrevioServicio = new PacienteTratamientoPrevioServiceImpl();
                                PacienteTratamientoPrevio pacienteTratamientoPrevio = pacienteTratamientoPrevioServicio.mostrarPacienteTratamientoPrevio(idPaciente);

                                AlergiaPacienteFarmacoServiceImpl alergiaPacienteFarmacoServicio = new AlergiaPacienteFarmacoServiceImpl();
                                AlergiaPacienteFarmaco alergiaPacienteFarmaco = alergiaPacienteFarmacoServicio.mostrarAlergiaPacienteFarmaco(idPaciente);

                                RegistroDiagnosticoServiceImpl registroDiagnosticoServicio = new RegistroDiagnosticoServiceImpl();
                                RegistroDiagnostico registroDiagnostico = registroDiagnosticoServicio.mostrarRegistroDiagnostico(idPaciente);

                                EstadiajeTNMServiceImpl estadiajeTNMServicio = new EstadiajeTNMServiceImpl();
                                EstadiajeTNM estadiajeTNM = estadiajeTNMServicio.mostrarEstadiajeTNM(registroDiagnostico.getIdRegistroTNM());

                                AuditoriaRegistroDiagnosticoServiceImpl auditoriaRegistroDiagnosticoServicio = new AuditoriaRegistroDiagnosticoServiceImpl();
                                AuditoriaRegistroDiagnostico auditoriaRegistroDiagnostico = auditoriaRegistroDiagnosticoServicio.mostrarAuditoriaRegistroDiagnostico(registroDiagnostico.getIdRegistroDiagnostico());

                                /**
                                 * Implemento el borrado logico llamando a su
                                 * objetoServicio despues al procesos almacenado
                                 * y al final al id del objeto
                                 */
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
                                pacienteSeguroServicio.borradoLogicoPacienteSeguro(pacienteSeguro.getIdPacienteSeguro());
                                biopsiaServicio.borradoLogicoBiopsia(biopsia.getIdBiopsia());
                                otroResultadoPatologiaServicio.borradoLogicoOtroResultadoPatologia(otroResultadoPatologia.getIdOtroResultadoPatologia());
                                tratamientoPacienteServicio.borradoLogicoTratamientoPaciente(tratamientoPaciente.getIdTratamientoPaciente());
                                auditoriaTratamientoPacienteServicio.borradoLogicoAuditoriaTratamientoPaciente(auditoriaTratamientoPaciente.getIdAuditoriaTratamientoPaciente());
                                programaPacienteServicio.borradoLogicoProgramaPaciente(programaPaciente.getIdProgramaPaciente());
                                pacienteTratamientoPrevioServicio.borradoLogicoPacienteTratamientoPrevio(pacienteTratamientoPrevio.getIdPacienteTratamientoPrevio());
                                alergiaPacienteFarmacoServicio.borradoLogicoAlergiaPacienteFarmaco(alergiaPacienteFarmaco.getIdAlergiaPacienteFarmaco());
                                registroDiagnosticoServicio.borradoLogicoRegistroDiagnostico(registroDiagnostico.getIdRegistroDiagnostico());
                                estadiajeTNMServicio.borradoLogicoEstadiajeTNM(estadiajeTNM.getIdRegistroTNM());
                                auditoriaRegistroDiagnosticoServicio.borradoLogicoAuditoriaRegistroDiagnostico(auditoriaRegistroDiagnostico.getIdAuditoriaRegistroDiagnostico());

                                /**
                                 * Al no tener cuenta se le redirecciona al
                                 * login
                                 */
                                request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);

                            }

                            break;
                        }
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
