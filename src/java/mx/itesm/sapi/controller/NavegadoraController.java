/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Base64;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import mx.itesm.sapi.bean.diagnostico.EstadiajeTNM;
import mx.itesm.sapi.bean.diagnostico.RegistroDiagnostico;
import mx.itesm.sapi.bean.gestionPaciente.Alergia;
import mx.itesm.sapi.bean.gestionPaciente.Biopsia;
import mx.itesm.sapi.bean.gestionPaciente.BloqueParafina;
import mx.itesm.sapi.bean.gestionPaciente.CategoriaEstudio;
import mx.itesm.sapi.bean.gestionPaciente.Cita;
import mx.itesm.sapi.bean.gestionPaciente.ComentarioCita;
import mx.itesm.sapi.bean.gestionPaciente.DocumentoEstudio;
import mx.itesm.sapi.bean.gestionPaciente.DocumentoInicial;
import mx.itesm.sapi.bean.gestionPaciente.DocumentoInicialTipoDocumento;
import mx.itesm.sapi.bean.gestionPaciente.Escolaridad;
import mx.itesm.sapi.bean.gestionPaciente.EstadoPaciente;
import mx.itesm.sapi.bean.gestionPaciente.EstadoPacientePaciente;
import mx.itesm.sapi.bean.gestionPaciente.Estudio;
import mx.itesm.sapi.bean.gestionPaciente.Laminilla;
import mx.itesm.sapi.bean.gestionPaciente.LlamadaCita;
import mx.itesm.sapi.bean.gestionPaciente.LugarDelCuerpo;
import mx.itesm.sapi.bean.gestionPaciente.Paciente;
import mx.itesm.sapi.bean.gestionPaciente.PacienteAlergia;
import mx.itesm.sapi.bean.gestionPaciente.PacienteMedicoTitular;
import mx.itesm.sapi.bean.gestionPaciente.PacienteSeguro;
import mx.itesm.sapi.bean.gestionPaciente.ProgramaPaciente;
import mx.itesm.sapi.bean.gestionPaciente.Seguro;
import mx.itesm.sapi.bean.gestionPaciente.TipoHistologico;
import mx.itesm.sapi.bean.gestionTratamiento.PacienteTratamientoPrevio;
import mx.itesm.sapi.bean.gestionTratamiento.TipoTratamiento;
import mx.itesm.sapi.bean.gestionTratamiento.Tratamiento;
import mx.itesm.sapi.bean.moduloGestionMedico.Empleado;
import mx.itesm.sapi.bean.persona.Cuenta;
import mx.itesm.sapi.bean.persona.Persona;
import mx.itesm.sapi.bean.persona.Pic;
import mx.itesm.sapi.service.diagnostico.EstadiajeTNMServiceImpl;
import mx.itesm.sapi.service.diagnostico.RegistroDiagnosticoServiceImpl;
import mx.itesm.sapi.service.gestionPaciente.AlergiaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.BiopsiaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.BloqueParafinaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.CategoriaEstudioServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.CitaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.ComentarioCitaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.DocumentoEstudioServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.DocumentoInicialServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.DocumentoInicialTipoDocumentoServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.EscolaridadServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.EstadoPacientePacienteServiceImpl;
import mx.itesm.sapi.service.gestionPaciente.EstadoPacienteServiceImpl;
import mx.itesm.sapi.service.gestionPaciente.EstudioServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.LaminillaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.LlamadaCitaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.LugarDelCuerpoServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteAlergiaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteMedicoTitularServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteSeguroServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.ProgramaPacienteServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.ProgramaServicio;
import mx.itesm.sapi.service.gestionPaciente.SeguroServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.TipoHistologicoServicioImpl;
import mx.itesm.sapi.service.gestionTratamiento.PacienteTratamientoPrevioServiceImpl;
import mx.itesm.sapi.service.gestionTratamiento.TipoTratamientoServiceImpl;
import mx.itesm.sapi.service.gestionTratamiento.TratamientoServiceImpl;
import mx.itesm.sapi.service.moduloGestionMedico.EmpleadoServicioImpl;
import mx.itesm.sapi.service.persona.CuentaServicioImpl;
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
                        case "btn-save": {

                            int idPaciente = (int) sesion.getAttribute("idPaciente");
                            
                            PacienteServicioImpl pacienteServicioImpl = new PacienteServicioImpl();
                            Paciente paciente = pacienteServicioImpl.mostrarPaciente(idPaciente);
                            
                            pacienteServicioImpl.agregarPaciente(paciente);
                            
                            System.out.println("PRZ->");
                            System.out.println("NivelEducativo->");
                            System.out.println("Estado Hormonal->");
                            System.out.println("Nivel socioeconómico->");

                            /*
                            Aquí le vamos a meter lista de inputs:
                            
                                PRZ
                                NivelEducativo
                                Estado Hormonal
                                Nivel socioeconómico

                            
                             */
                            PacienteMedicoTitularServicioImpl pacienteMedicoTitularServicioImpl = new PacienteMedicoTitularServicioImpl();
                            PacienteMedicoTitular pacienteMedicoTitular = new PacienteMedicoTitular();
                            
                            pacienteMedicoTitular.setIdPaciente(idPaciente);
                            
                            pacienteMedicoTitularServicioImpl.agregarPacienteMedicoTitular(pacienteMedicoTitular);
                            
                            System.out.println("Medico Adscrito-->");
                            System.out.println("Medico Radiologo-->");
                            System.out.println("Medico Residente-->");
                            
                            
                            
                            /*
                            
                                Medico Adscrito
                                Medico Radiologo
                                Medico Residente
                            
                            
                             */
                            
                            EstadoPacientePacienteServiceImpl estadoPacientePacienteServicioImpl = new EstadoPacientePacienteServiceImpl();
                            EstadoPacientePaciente estadoPacientePaciente = new EstadoPacientePaciente();
                            
                            estadoPacientePaciente.setIdPaciente(idPaciente);
                            
                            estadoPacientePacienteServicioImpl.agregarEstadoPacientePaciente(estadoPacientePaciente);
                            
                            System.out.println("Tipo de Paciente-->");
                            System.out.println("Resultados (checkbox)-->");
                            System.out.println("Decisión preconsulta-->");
                            
                            /*
                                Tipo de Paciente
                                Resultados (checkbox)
                                Decisión preconsulta
                            */

                            CitaServicioImpl citaServicioImpl = new CitaServicioImpl();
                            Cita cita = new Cita();
                            
                            cita.setIdPaciente(idPaciente);
                            citaServicioImpl.agregarCita(cita);
                            
                            System.out.println("Fecha de navegacion-->");
                            System.out.println("Fecha de consulta-->");
                            
                            System.out.println("Biopsia-->");
                            System.out.println("Rayos x-->");
                            System.out.println("Ultrasonido-->");
                            System.out.println("Medicina Nuclear-->");
                            System.out.println("Laboratorio-->");
                            System.out.println("Valoracion-->");
                            System.out.println("Espirometria-->");
                            System.out.println("Electrocardiograma-->");
                            System.out.println("Ecocardiograma-->");
                            System.out.println("TrabajoSocial-->");
                            
                            /*
                                Fecha de navegacion
                                Fecha de consulta
                            
                                ESTUDIOS PRECONSULTA-->
                                Biopsia
                                Rayos x
                                Ultrasonido
                                Medicina Nuclear
                                Laboratorio
                                Valoracion
                                Espirometria
                                Electrocardiograma
                                Ecocardiograma
                                TrabajoSocial
                             */

                            PacienteAlergiaServicioImpl pacienteAlergiaServicioImpl = new PacienteAlergiaServicioImpl();
                            PacienteAlergia pacienteAlergia = new PacienteAlergia();
                            
                            pacienteAlergia.setIdPaciente(idPaciente);
                            
                            pacienteAlergiaServicioImpl.agregarPacienteAlergia(pacienteAlergia);
                            
                            System.out.println("Alergias-->");
                            /*
                                Alergias
                             */

                            PacienteSeguroServicioImpl pacienteSeguroServicioImpl = new PacienteSeguroServicioImpl();
                            PacienteSeguro pacienteSeguro = new PacienteSeguro();
                            
                            pacienteSeguro.setIdPaciente(idPaciente);
                            pacienteSeguroServicioImpl.agregarPacienteSeguro(pacienteSeguro);
                            
                            System.out.println("Cuentas con algún seguro?-->");
                            /*
                                Cuentas con algún seguro?
                             */

                            DocumentoEstudioServicioImpl documentoEstudioServicioImpl = new DocumentoEstudioServicioImpl();
                            DocumentoEstudio documentoEstudio = new DocumentoEstudio();
                            
                            documentoEstudio.setIdPaciente(idPaciente);
                            
                            documentoEstudioServicioImpl.agregarDocumentoEstudio(documentoEstudio);
                            
                            System.out.println("Mastografia-->");
                            System.out.println("Ultrasonido de mama-->");
                            System.out.println("Resultados de mastografía-->");
                            System.out.println("Resultados del ultrasonido-->");
                            /*
                                Mastografia
                                Ultrasonido de mama
                                Resultados de mastografía
                                Resultados del ultrasonido
                            */

                            PacienteTratamientoPrevioServiceImpl pacienteTratamientoPrevioServiceImpl = new PacienteTratamientoPrevioServiceImpl();
                            PacienteTratamientoPrevio pacienteTratamientoPrevio = new PacienteTratamientoPrevio();
                            
                            pacienteTratamientoPrevio.setIdPaciente(idPaciente);
                            
                            pacienteTratamientoPrevioServiceImpl.agregarPacienteTratamientoPrevio(pacienteTratamientoPrevio);
                            
                            System.out.println("Cirugía-->");
                            System.out.println("Quimioterapia-->");
                            System.out.println("Radioterapia-->");
                            
                            /*
                            Cirugía
                            Quimioterapia
                            Radioterapia
                             */

                            BiopsiaServicioImpl biopsiaServicioImpl = new BiopsiaServicioImpl();
                            Biopsia biopsia = new Biopsia();
                            
                            biopsia.setIdPaciente(idPaciente);
                            
                            biopsiaServicioImpl.agregarBiopsia(biopsia);
                            
                            System.out.println("Resultado o reporte de patologia-->");
                            System.out.println("Laminillas-->");
                            System.out.println("Bloques de parafina-->");
                            System.out.println("Resultado Patologia-->");
                            System.out.println("Grado Histológico-->");
                            System.out.println("Her2-->");
                            System.out.println("Fish-->");
                            System.out.println("RE-->");
                            System.out.println("RP-->");
                            System.out.println("Ki67-->");
                            
                            
                            /*
                            Resultado o reporte de patologia
                            Laminillas
                            Bloques de parafina
                            Resultado Patologia
                            Grado Histológico
                            Her2
                            Fish
                            RE
                            RP
                            Ki67

                             */

                            ProgramaPacienteServicioImpl programaPacienteServicioImpl = new ProgramaPacienteServicioImpl();
                            ProgramaPaciente programaPaciente = new ProgramaPaciente();
                            
                            programaPaciente.setIdPaciente(idPaciente);
                            programaPacienteServicioImpl.agregarProgramaPaciente(programaPaciente);
                            
                            System.out.println("Programa-->");
                            /*
                            ESTUDIOS PRECONSULTA-->Programa
                             */

                            LlamadaCitaServicioImpl LlamadaCitaServicioImpl = new LlamadaCitaServicioImpl();
                            LlamadaCita llamadaCita =new LlamadaCita();
                            
                            llamadaCita.setIdCita(cita.getIdCita());
                            
                            LlamadaCitaServicioImpl.agregarLlamadaCita(llamadaCita);
                            
                            System.out.println("Llamada al paciente-->");
                            /*
                            
                            Llamada al paciente

                             */

                            ComentarioCitaServicioImpl comentarioCitaServicioImpl = new ComentarioCitaServicioImpl();
                            ComentarioCita comentarioCita = new ComentarioCita();
                            
                            comentarioCita.setIdCita(cita.getIdCita());
                            
                            comentarioCitaServicioImpl.agregarComentarioCita(comentarioCita);
                            
                            System.out.println("Comentarios y reporte de incidencias-->");
                            System.out.println("Comentarios adicionales del médico-->");
                            /*
                            Comentarios y reporte de incidencias
                            Comentarios adicionales del médico
                             */

                            RegistroDiagnosticoServiceImpl registroDiagnosticoServiceImpl = new RegistroDiagnosticoServiceImpl();
                            RegistroDiagnostico registroDiagnostico = new RegistroDiagnostico();
                            
                            registroDiagnostico.setIdPaciente(idPaciente);
                            registroDiagnosticoServiceImpl.agregarRegistroDiagnostico(registroDiagnostico);
                            
                            System.out.println("EtapaClinica-->");
                            /*
                            EtapaClinica
                             */

                            EstadiajeTNMServiceImpl estadiajeTNMServiceImpl = new EstadiajeTNMServiceImpl();
                            EstadiajeTNM estadiajeTNM = new EstadiajeTNM();
                            
                            
                            estadiajeTNMServiceImpl.agregarEstadiajeTNM(estadiajeTNM);
                            
                            System.out.println("T-->");
                            System.out.println("N-->");
                            System.out.println("M-->");
                            /*
                            T
                            N
                            M
                             */


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
