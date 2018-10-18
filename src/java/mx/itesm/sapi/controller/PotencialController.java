/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mx.itesm.sapi.bean.persona.Estado;
import mx.itesm.sapi.bean.persona.Cuenta;
import mx.itesm.sapi.bean.persona.Direccion;
import mx.itesm.sapi.bean.persona.Persona;

import mx.itesm.sapi.bean.persona.EstadoCivil;
import mx.itesm.sapi.bean.persona.Municipio;
import mx.itesm.sapi.service.ZonaServicioImpl;
import mx.itesm.sapi.service.persona.CuentaServicioImpl;
import mx.itesm.sapi.service.persona.PersonaServicioImpl;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Base64;
import javax.servlet.http.Part;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author feror
 */
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
            }
            break;

            case "InicioPotencial": {

                request.getRequestDispatcher("/WEB-INF/potencial/index.jsp").forward(request, response);
            }
            break;

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
                        }
                        break;
                    }
                }

            }
            break;

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
            }
            break;
            //Desde aqui se sube guarda y muestra una imagen se debe cambiar por el nombre 
            //de la tabla donde se guardan las imagenes
            
             case "upload": {
                if (ServletFileUpload.isMultipartContent(request)) {
                    Part part = request.getPart("archivo");

                   
                    InputStream contenido = part.getInputStream();
                    PersonaServicioImpl person = new PersonaServicioImpl();

                    Persona persona = new Persona();
                    persona.setImagen(contenido);
                    

                    
                    // request.setCharacterEncoding("UTF-8");
                    PrintWriter out = response.getWriter();
                    if (person.actualizarPersona(persona)) {
                        out.print("success");

                    } else {
                        out.print("error");
                    }
                }
             }
                break;
                
                case "download":{
                ArchivoServicioImpl asi = new ArchivoServicioImpl();
               Archivo archivo = asi.downloadFile(1);
                OutputStream out = response.getOutputStream();
                
                response.setContentType("application/octet-stream");
                response.setHeader("Content-Disposition", "attachment;filename=".concat(archivo.getNombre()));
                
                out.write(IOUtils.toByteArray(archivo.getContenido()));
                out.flush();
               
                //imprimir bytes
                
                break;
            }
            case "show":{
                 ArchivoServicioImpl asi = new ArchivoServicioImpl();
               Archivo archivo = asi.downloadFile(1);
                PrintWriter out = response.getWriter();
                
                response.setContentType("application/octet-stream");
        
                byte[] bytes = IOUtils.toByteArray(archivo.getContenido());
               String base64String = Base64.getEncoder().encodeToString(bytes);
               
               out.print(base64String);
                
                
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
                
               
               
            }

            break;
            
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
               
           }
           
           break;
            
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
