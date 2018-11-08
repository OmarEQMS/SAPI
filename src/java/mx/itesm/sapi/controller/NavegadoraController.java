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
import mx.itesm.sapi.bean.gestionPaciente.EstadoPacientePaciente;
import mx.itesm.sapi.bean.gestionPaciente.Paciente;
import mx.itesm.sapi.bean.gestionPaciente.PacienteMedicoTitular;
import mx.itesm.sapi.bean.persona.Cuenta;
import mx.itesm.sapi.bean.persona.Persona;
import mx.itesm.sapi.bean.persona.Pic;
import mx.itesm.sapi.service.diagnostico.RegistroDiagnosticoServiceImpl;
import mx.itesm.sapi.service.gestionPaciente.CitaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.EstadoPacientePacienteServiceImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteMedicoTitularServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteServicioImpl;
import mx.itesm.sapi.service.persona.CuentaServicioImpl;
import mx.itesm.sapi.service.persona.PersonaServicioImpl;
import mx.itesm.sapi.service.persona.PicServicioImpl;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author Who?
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
        System.out.println("La key es: " + key);
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
                        case "btn-save":{
                           /* 
                            Para jalar un valor NORMAL
                            System.out.println("NavegadoraController, case: guardarP2");
                            String prz = request.getParameter("prz-expediente");
                            String tiene = request.getParameter("nivelEducativo");
                            String alergias = request.getParameter("alergias");
                            System.out.println("prz: "+ prz + ", tiene: "+ tiene+ " alergias: " +alergias);
                            break;                        
                            
                       
                            Para jalar contenido DINAMICO (se usa la key) y se recibe en un arreglo :D 
                            String[] Biopsia = request.getParameterValues("tipo-BiopsiaAdded");
                            String[] fechaBiopsia = request.getParameterValues("fecha-BipsiAdded");
                           
                            for(int i =0 ; i< Biopsia.length;i++){
                                System.out.println(Biopsia[i]);
                            }
                            */
                            PacienteServicioImpl pacienteServicioImpl = new PacienteServicioImpl();
                            Paciente paciente = pacienteServicioImpl.mostrarPaciente(1);
                            
                            if(request.getParameter("prz-expediente") != null){
                                 String prz = request.getParameter("prz-expediente");
                            }
                            if(request.getParameter("nivelEducativo") != null){
                                String nivelE = request.getParameter("nivelEducativo");
                            }
                            if(request.getParameter("estadoHormonal")!=null){
                                String estadoHormonal=request.getParameter("estadoHormonal"); 
                            }
                            if(request.getParameter("nivelSocioeconomico")!=null){
                                String nivelSocioeconomico = request.getParameter("nivelSocioeconomico");
                            }
                            /*
                            Aquí le vamos a meter lista de inputs:
                            
                                PRZ
                                NivelEducativo
                                Estado Hormonal
                                Nivel socioeconómico

                            
                             */

                            PacienteMedicoTitularServicioImpl pacienteMedicoTitularServicioImpl = new PacienteMedicoTitularServicioImpl();
                            PacienteMedicoTitular pacienteMedicoTitular = pacienteMedicoTitularServicioImpl.mostrarPacienteMedicoTitular(1);
                            
                            if(request.getParameter("medico-adscrito")!=null){
                                String medicoAdscrito = request.getParameter("medico-adscrito");
                            }
                            if(request.getParameter("medico-adscrito")!=null){
                                String medicoAdscrito = request.getParameter("medico-adscrito");
                            }
                            if(request.getParameter("medico-radiologo")!=null){
                                String medicoRadiologo = request.getParameter("medico-radiologo");
                            }
                            if(request.getParameter("medico-residente")!=null){
                                String medicoResidente= request.getParameter("medico-residente");
                            }
                            /*
                            
                                Medico Adscrito
                                Medico Radiologo
                                Medico Residente
                            
                            
                            */
                            EstadoPacientePacienteServiceImpl estadoPacientePacienteServicioImpl = new EstadoPacientePacienteServiceImpl();
                            EstadoPacientePaciente estadoPacientePaciente = estadoPacientePacienteServicioImpl.mostrarEstadoPacientePaciente(1);
                            
                            if(request.getParameter("tipoPaciente")!=null){
                               String tipoPaciente = request.getParameter("tipoPaciente"); 
                            }
                            if(request.getParameter("resultadosCheckbox")!=null){
                                String resultadosCheckbox= request.getParameter("resultadosCheckbox");
                            }
                            if(request.getParameter("decisionPreconsulta")!=null){
                                String descicionPreconsulta = request.getParameter("decisionPreconsulta");
                            }
                            if(request.getParameter("fecha-decisionPreconsulta")!=null){
                                String fechaDesicionPreconsulta= request.getParameter("fecha-decisionPreconsulta");
                            }
                            /*
                            
                            Tipo de Paciente
                            Resultados (checkbox)
                            Decisión preconsulta
                            Fecha desicion preconsulta :D 
                            
                            */
                            
                          
                           
                            CitaServicioImpl citaServicioImpl = new CitaServicioImpl();
                            Cita cita = citaServicioImpl.mostrarCita(1);
                            
                            if(request.getParameterValues("tipo-BiopsiaAdded") != null){
                               String[] tipoBiopsias = request.getParameterValues("tipo-BiopsiaAdded"); 
                            }
                            if(request.getParameterValues("fecha-BiopsiaAdded") != null){
                               String[] fechaBiopsias = request.getParameterValues("fecha-BiopsiaAdded"); 
                            }
                            if(request.getParameterValues("parte-BiopsiaAdded") != null){
                               String[] fechaBiopsias = request.getParameterValues("parte-BiopsiaAdded"); 
                            }
                            if(request.getParameterValues("tipo-RayosXAdded") != null){
                               String[] fechaBiopsias = request.getParameterValues("tipo-RayosXAdded"); 
                            }
                            if(request.getParameterValues("fecha-RayosXAdded") != null){
                               String[] fechaBiopsias = request.getParameterValues("fecha-RayosXAdded"); 
                            }
                            
                            if(request.getParameterValues("parteCuerpo-USGAdded") != null){
                               String[] fechaBiopsias = request.getParameterValues("parteCuerpo-USGAdded"); 
                            }
                            if(request.getParameterValues("fecha-USGAdded") != null){
                               String[] fechaBiopsias = request.getParameterValues("fecha-USGAdded"); 
                            }
                            
                            if(request.getParameterValues("mNuclear") != null){
                               String[] fechaBiopsias = request.getParameterValues("mNuclear"); 
                            }
                            if(request.getParameterValues("fecha-mNuclearAdded") != null){
                               String[] fechaBiopsias = request.getParameterValues("fecha-mNuclearAdded"); 
                            }
                            
                            if(request.getParameterValues("fecha-LaboAdded") != null){
                               String[] fechaBiopsias = request.getParameterValues("fecha-LaboAdded"); 
                            } 
                            
                            if(request.getParameterValues("valoracionAdded") != null){
                               String[] fechaBiopsias = request.getParameterValues("valoracionAdded"); 
                            }
                            if(request.getParameterValues("fecha-valoracionAdded") != null){
                               String[] fechaBiopsias = request.getParameterValues("fecha-valoracionAdded"); 
                            }
                            if(request.getParameterValues("fecha-espirometriaAdded") != null){
                               String[] fechaBiopsias = request.getParameterValues("fecha-espirometriaAdded"); 
                            }
                            /*
                            Fecha de navegacion
                            Fecha de consulta
                            
                            ESTUDIOS PRECONSULTA-->
                            Biopsia [tipo, fecha, parte de cuerpo]
                            Rayos x [tipo, fecha]
                            Ultrasonido [parteCuerpo, fecha]
                            Medicina Nuclear [mNuclear, fecha-mNuclear]
                            Laboratorio [fecha-LaboAdded]
                            Valoracion [valoracionAdded, fecha-valoracionAdded]
                            Espirometria [fecha-espirometriaAdded]
                            Electrocardiograma
                            Ecocardiograma
                            TrabajoSocial
                            */

                            
                            PacienteAlergiaServicioImpl pacienteAlergiaServicioImpl = new PacienteAlergiaServicioImpl();
                            PacienteAlergia pacienteAlergia = pacienteAlergiaServicioImpl.mostrarPacienteAlergia(1);
                            
                            if(request.getParameter("alergias") != null){
                                String alergias = request.getParameter("alergias");
                            }
                            /*
                            Alergias
                            */

                         
                            PacienteSeguroServicioImpl pacienteSeguroServicioImpl = new PacienteSeguroServicioImpl();
                            PacienteSeguro pacienteSeguro = pacienteSeguroServicioImpl.mostrarPacienteSeguro(1);
                            /*
                            Cuentas con algún seguro?
                            */

                            DocumentoEstudioServicioImpl documentoEstudioServicioImpl = new DocumentoEstudioServicioImpl();
                            DocumentoEstudio documentoEstudio = documentoEstudioServicioImpl.mostrarDocumentoEstudio(1);
                            /*
                            Mastografia
                            Ultrasonido de mama
                            Resultados de mastografía
                            Resultados del ultrasonido
                            
                            
                            
                            */

                            PacienteTratamientoPrevioServiceImpl pacienteTratamientoPrevioServiceImpl = new PacienteTratamientoPrevioServiceImpl();
                            PacienteTratamientoPrevio pacienteTratamientoPrevio = pacienteTratamientoPrevioServiceImpl.mostrarPacienteTratamientoPrevio(1);
                            /*
                            Cirugía
                            Quimioterapia
                            Radioterapia
                            */
                   
                            BiopsiaServicioImpl biopsiaServicioImpl = new BiopsiaServicioImpl();
                            Biopsia biopsia = biopsiaServicioImpl.mostrarBiopsia(1);
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
                            ProgramaPaciente programaPaciente = programaPacienteServicioImpl.mostrarProgramaPaciente(1);
                            /*
                            ESTUDIOS PRECONSULTA-->Programa
                            */
                            
                            
                            LlamadaCitaServicioImpl LlamadaCitaServicioImpl=new LlamadaCitaServicioImpl();
                            LlamadaCita llamadaCita=LlamadaCitaServicioImpl.mostrarLlamadaCita(1);
                            /*
                            
                            Llamada al paciente

                            */
                            
                            ComentarioCitaServicioImpl comentarioCitaServicioImpl=new ComentarioCitaServicioImpl();
                            ComentarioCita comentarioCita=comentarioCitaServicioImpl.mostrarComentarioCita(1);
                            /*
                            Comentarios y reporte de incidencias
                            Comentarios adicionales del médico
                            */
                            
                            RegistroDiagnosticoServiceImpl registroDiagnosticoServiceImpl =new RegistroDiagnosticoServiceImpl();
                            RegistroDiagnostico registroDiagnostico=registroDiagnosticoServiceImpl.mostrarRegistroDiagnostico(1);
                            /*
                            EtapaClinica
                            */
                                  
                            EstadiajeTNMServiceImpl estadiajeTNMServiceImpl=new EstadiajeTNMServiceImpl();
                            EstadiajeTNM estadiajeTNM=estadiajeTNMServiceImpl.mostrarEstadiajeTNM(1);
                            /*
                            T
                            N
                            M
                            */
                            
                            //EmpleadoServicioImpl empleadoServicioImpl = new EmpleadoServicioImpl();
                            //Empleado empleado = empleadoServicioImpl.mostrarEmpleado(1);
                        
                        }

                        case "guardarP3": {

                            break;

                        }

                    }
                    //Termina key navegadora
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
