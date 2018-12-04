/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Properties;
import java.util.ResourceBundle;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mx.itesm.sapi.bean.gestionPaciente.EstadoPacientePaciente;
import mx.itesm.sapi.bean.moduloGestionMedico.Empleado;
import mx.itesm.sapi.bean.moduloGestionMedico.EmpleadoPosicion;
import mx.itesm.sapi.bean.moduloGestionMedico.Especialidad;
import mx.itesm.sapi.bean.moduloGestionMedico.Identificadores;
import mx.itesm.sapi.bean.moduloGestionMedico.MedicoEspecialidad;
import mx.itesm.sapi.bean.moduloGestionMedico.Posicion;
import mx.itesm.sapi.bean.moduloGestionMedico.RestringirEmpleado;
import mx.itesm.sapi.bean.moduloGestionPaciente.Paciente;
import mx.itesm.sapi.bean.persona.Cuenta;
import mx.itesm.sapi.bean.persona.Direccion;
import mx.itesm.sapi.bean.persona.Persona;
import mx.itesm.sapi.bean.persona.Pic;

import mx.itesm.sapi.service.persona.CuentaServicioImpl;
import mx.itesm.sapi.service.persona.DireccionServicioImpl;
import mx.itesm.sapi.service.persona.PersonaServicioImpl;

import mx.itesm.sapi.service.gestionPaciente.EstadoPacientePacienteServiceImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteServiceImpl;
import mx.itesm.sapi.service.moduloGestionMedico.EmpleadoPosicionServicioImpl;
import mx.itesm.sapi.service.moduloGestionMedico.EmpleadoServicioImpl;
import mx.itesm.sapi.service.moduloGestionMedico.EspecialidadServicioImpl;
import mx.itesm.sapi.service.moduloGestionMedico.MedicoEspecialidadServicioImpl;
import mx.itesm.sapi.service.moduloGestionMedico.PosicionServicioImpl;

import mx.itesm.sapi.service.persona.PicServicioImpl;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author Who is admin?
 */
@WebServlet(name = "RegistraUsuarioController", urlPatterns = {"/RegistraUsuarioController"})
public class RegistraUsuarioController extends HttpServlet {

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

        /**
         * Fernanda Orduña y Pablo Lugo <3
         *
         * Controlador de Registro Uusuario Permite a un usuario registrar un
         * usuario con credenciales únicas.
         *
         */
        /**
         * Recepción de parametro key que permite escoger un case en el Switch
         * Declaración PrintWriter para imprimir respuestas
         */
        PrintWriter out = response.getWriter();
        String key = request.getParameter("key");

        /**
         * Declaración de servicios para la inserción en tablas. Las tablas son
         * Persona, Cuenta, Dirección, Paciente, EstadoPacientePaciente
         */
        /**
         * Declaración de sesión
         */
        HttpSession sesion = request.getSession(true);

        PersonaServicioImpl _registroServicio = new PersonaServicioImpl();
        CuentaServicioImpl _rSC = new CuentaServicioImpl();
        DireccionServicioImpl _rSD = new DireccionServicioImpl();
        PacienteServiceImpl pacienteServicio = new PacienteServiceImpl();
        EstadoPacientePacienteServiceImpl estadoPaPaServicio = new EstadoPacientePacienteServiceImpl();
        EmpleadoServicioImpl empleadoServicioImpl = new EmpleadoServicioImpl();
        PosicionServicioImpl posicionServicioImpl = new PosicionServicioImpl();
        EmpleadoPosicionServicioImpl empleadoPosicionServicioImpl = new EmpleadoPosicionServicioImpl();
        EspecialidadServicioImpl especialidadServicioImpl = new EspecialidadServicioImpl();
        MedicoEspecialidadServicioImpl medicoEspecialidadServicioImpl = new MedicoEspecialidadServicioImpl();

        /**
         * Declaración de objetos para la manipulación en el b ack. Los bean son
         * Persona, Cuenta, Dirección, Paciente, EstadoPacientePaciente
         */
        Persona per = new Persona();
        Cuenta cuenta = new Cuenta();
        Direccion dir = new Direccion();
        Paciente pac = new Paciente();
        EstadoPacientePaciente estadoPaPa = new EstadoPacientePaciente();
        Empleado empleado = new Empleado();
        Posicion posicion;
        Especialidad especialidad;
        MedicoEspecialidad medicoEspecialidad = new MedicoEspecialidad();
        EmpleadoPosicion empleadoPosicion = new EmpleadoPosicion();

        switch (key) {

            case "repiteCurp": {

                /**
                 * El case repiteCurp tiene como función verificar la unicidad
                 * del Curp ingresado por parte del Usuario. Se recibe como
                 * parametro el curp. Se utiliza el metodo existsCurp del
                 * servicio PersonaServcioImpl que verficia la unicidad en la
                 * base de datos. Devuelve la respuesta sobre la unicidad del
                 * curp con un objeto PrintWriter
                 */
                String curp = request.getParameter("curp");
                System.out.println("El curp es: ".concat(curp));

                //Checo si el usuario existe
                if (_registroServicio.existsCurp(curp)) {
                    System.out.println("El CURP EXISTE");
                    out.print("CurpAlreadyExists");

                } else {

                    //Si no existe, lo inserto
                    System.out.println("El CURP NO Existe");
                    out.print("CurpDoesntExist");

                }

            }
            break;

            case "repiteUsuario": {

                /**
                 * El case repiteUsuario tiene como función verificar la
                 * unicidad del Usuario ingresado por parte del Usuario. Se
                 * recibe como parametro el usuario. Se utiliza el metodo
                 * existsUsuario del servicio CuentaServcioImpl que verficia la
                 * unicidad en la base de datos. Devuelve la respuesta sobre la
                 * unicidad del curp con un objeto PrintWriter
                 */
                String usuario = request.getParameter("usuario");

                System.out.println("entré al case repiteUsuario");

                //Checo si el usuario existe
                if (_rSC.existsUsuario(usuario)) {

                    out.print("UsuarioAlreadyExists");

                } else {

                    //Si no existe, lo inserto
                    out.print("UsuarioDoesntExist");

                }
            }
            break;

            case "repiteNoEmpleado": {

                String noEmpleado = request.getParameter("noEmpleado");
                
                EmpleadoServicioImpl empleadoServicio = new EmpleadoServicioImpl();
                
                //Checo si el usuario existe
                if (empleadoServicio.existsNoEmpleado(noEmpleado)) {

                    out.print("NoEmpleadoAlreadyExists");

                } else {

                    //Si no existe, lo inserto
                    out.print("NoEmpleadoDoesntExist");

                }
            }
            break;
            
            case "repiteCorreo": {

                String correo = request.getParameter("correo");

                //Checo si el usuario existe
                if (_registroServicio.existsCorreo(correo)) {

                    out.print("CorreoAlreadyExists");

                } else {

                    //Si no existe, lo inserto
                    out.print("CorreoDoesntExist");

                }
            }
            break;

            case "registraUsuario": {

                /**
                 * El case registraUsuario tiene como función la inserción de
                 * los datos del Usuario, en las tablas Persona, Cuenta,
                 * Paciente y EstadoPacientePaciente. Se reciben como Parametros
                 * los inputs del achivo registro.jsp. Se convierten algunos
                 * variables para después ser seteadas en sus respectivos
                 * objetos. Se prosigue a insertar los objetos haciendo uso de
                 * los Servicios y Objetos previamente declarados. El orden de
                 * inserción es el siguiente (Cada inserción recibe un "id"
                 * necesario para la siguiente inserción): Dirección, Persona,
                 * Cuenta, Paciente, EstadoPacientePaciente. Al finalizar la
                 * inserción se ejecuta el método enviCorreo(String mail);
                 */
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

                Date fn = Date.valueOf(fechaNacimiento);

                per.setFechaNacimiento(fn);

                String usuario = request.getParameter("usuario");

                per.setNombre(nombre);
                per.setTelefono(telefono);

                per.setPrimerApellido(apellido1);
                per.setSegundoApellido(apellido2);
                per.setCorreo(correo);
                per.setCurp(curp);
                per.setIdEstadoCivil(estadoCivil);
                per.setIdMunicipio(municipio);

                long unixTimestamp = Instant.now().getEpochSecond();
                System.out.println(String.valueOf(unixTimestamp));

                //Set cuenta
                cuenta.setPassword(contraseña1);
                cuenta.setUsuario(usuario);
                cuenta.setToken(String.valueOf(unixTimestamp));
                cuenta.setIdRol(1);//Rol 1 corresponde a paciente potencial.

                //DIRECCION
                dir.setCalle(calle);
                dir.setColonia(colonia);
                dir.setNoExterior(noExterior);
                dir.setNoInterior(noInterior);

                int idD = _rSD.agregarDireccion(dir);

                System.out.println("El id de direccion es: ".concat(Integer.toString(idD)));
                int idC;
                int idPac;
                int idEsPaPa;

                if (idD > 0) {

                    per.setIdDireccion(idD);
                    int idP = _registroServicio.agregarPersona(per);

                    System.out.println("idPersona: " + idP);

                    if (idP > 0) {
                        cuenta.setIdPersona(idP);
                        idC = _rSC.agregarCuenta(cuenta);
                        System.out.println("idCuenta: " + idC);

                        if (idC > 0) {

                            idPac = pacienteServicio.agregarPacienteRegistro(idC);

                            idEsPaPa = estadoPaPaServicio.agregarEstadoPacientePacienteRegistro(idPac);
                            System.out.println("idPac: " + idPac);
                            System.out.println("idEsPaPa " + idEsPaPa);
                            if (idEsPaPa > 0) {
                                System.out.println("va a agregar imagen");
                                PicServicioImpl picServiceImpl = new PicServicioImpl();
                                Pic pic = new Pic();

                                pic = picServiceImpl.mostrarPicDefault();
                                pic.setIdPersona(idP);

                                picServiceImpl.agregarPic(pic);
                                System.out.println("agrego imagen");
                                enviaCorreo(usuario, correo);
                            }
                            out.print(idPac);

                        }
                    }

                }

                break;
            }
            case "agregarMedico": {
                ResourceBundle sapiProperties = ResourceBundle.getBundle("mx.itesm.sapi.properties.catalogos");

                int idRolMedico = Integer.parseInt(sapiProperties.getString("Medico"));
                int idTumoresMamarios = Integer.parseInt(sapiProperties.getString("TumoresMamarios"));

                String nombre = request.getParameter("nombre");
                String apellido1 = request.getParameter("primerApellido");
                String apellido2 = request.getParameter("segundoApellido");
                String telefono = request.getParameter("telefono");
                String correo = request.getParameter("correo");
                String noEmpleado = request.getParameter("noEmpleado");
                String especialidadAgregar = request.getParameter("especialidad");
                String posicionMedico = request.getParameter("posicion");
                String cedula = request.getParameter("cedula");
                String contraseña = request.getParameter("password");

                RestringirEmpleado restringirEmpleado = new RestringirEmpleado();

                restringirEmpleado.setNombre(nombre);
                restringirEmpleado.setPrimerApellido(apellido1);
                restringirEmpleado.setSegundoApellido(apellido2);
                restringirEmpleado.setTelefono(telefono);
                restringirEmpleado.setCorreo(correo);
                restringirEmpleado.setRol(idRolMedico);
                restringirEmpleado.setUsuario(noEmpleado);

                Identificadores identificadores = empleadoServicioImpl.restringirEmpleado(restringirEmpleado);

                //Si la misma cuenta ya existe no se permitirá registrar
                PrintWriter permitir = response.getWriter();

                if (identificadores.getIdCuenta() > 0) {
                    permitir.print("Existe");
                    System.out.println("Ya existe la cuenta de médico");
                    break;
                }

                System.out.println(nombre);
                System.out.println(apellido1);
                System.out.println(apellido2);
                System.out.println(telefono);
                System.out.println(correo);
                System.out.println(noEmpleado);
                System.out.println(especialidadAgregar);
                System.out.println(cedula);
                System.out.println(contraseña);

                per.setNombre(nombre);
                per.setPrimerApellido(apellido1);
                per.setSegundoApellido(apellido2);
                per.setTelefono(telefono);
                per.setCorreo(correo);

                long unixTimestamp = Instant.now().getEpochSecond();

                cuenta.setToken(String.valueOf(unixTimestamp));
                cuenta.setUsuario(noEmpleado);
                cuenta.setIdRol(idRolMedico);
                cuenta.setPassword(contraseña);
                cuenta.setIdEmpleado((int) sesion.getAttribute("idEmpleado"));

                empleado.setNoEmpleado(noEmpleado);
                empleado.setIdDepartamentoDepartamentoInterno(idTumoresMamarios);

                int idPersona = identificadores.getIdPersona();

                if (idPersona == 0) {
                    idPersona = _registroServicio.agregarMedico(per, idRolMedico);
                }

                int idCuenta = identificadores.getIdCuenta();
                int idEmpleado = identificadores.getEmpleado();

                System.out.println("idPersona: ".concat(String.valueOf(idPersona)));
                if (idPersona > 0) {
                    PicServicioImpl picServiceImpl = new PicServicioImpl();

                    Pic pic = picServiceImpl.mostrarPicDefault();
                    pic.setIdPersona(idPersona);
                    picServiceImpl.agregarPic(pic);

                    cuenta.setIdPersona(idPersona);
                    if (idCuenta == 0) {
                        idCuenta = _rSC.agregarCuenta(cuenta);
                    }

                    if (idCuenta > 0) {
                        empleado.setIdCuenta(idCuenta);
                        if (idEmpleado == 0) {
                            idEmpleado = empleadoServicioImpl.agregarEmpleado(empleado);
                        }

                        System.out.println("idCuenta: ".concat(String.valueOf(idCuenta)));
                        if (idEmpleado > 0) {
                            System.out.println("idEmpleado: ".concat(String.valueOf(idEmpleado)));

                            posicion = posicionServicioImpl.mostrarPosicion(posicionMedico);
                            especialidad = especialidadServicioImpl.mostrarEspecialidadPorNombre(especialidadAgregar);

                            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

                            empleadoPosicion.setIdEmpleado(idEmpleado);
                            empleadoPosicion.setIdPosicion(posicion.getIdPosicion());
                            empleadoPosicion.setInicio(timestamp);

                            medicoEspecialidad.setIdEspecialidad(especialidad.getIdEspecialidad());
                            medicoEspecialidad.setIdEmpleado(idEmpleado);
                            medicoEspecialidad.setCedulaProfesional(cedula);

                            int idEmpleadoPosicionServicio = empleadoPosicionServicioImpl.agregarEmpleadoPosicion(empleadoPosicion);
                            int idMedicoEspecialidad = medicoEspecialidadServicioImpl.agregarMedicoEspecialidad(medicoEspecialidad);

                            System.out.println("Final :D");
                            System.out.println("idPersona: ".concat(String.valueOf(idPersona)));
                            System.out.println("idCuenta: ".concat(String.valueOf(idCuenta)));
                            System.out.println("idEmpleado: ".concat(String.valueOf(idEmpleado)));
                            System.out.println("idEmpleadoPosicion: ".concat(String.valueOf(idEmpleadoPosicionServicio)));
                            System.out.println("idMedicoEspecialidad: ".concat(String.valueOf(idMedicoEspecialidad)));

                            if (idEmpleado > 0 && idEmpleadoPosicionServicio > 0) {
                                permitir.print(idEmpleado);
                            } else {
                                permitir.print("0");
                            }

                        }

                    }

                }

                break;
            }
            case "agregarAdministrador": {
                ResourceBundle sapiProperties = ResourceBundle.getBundle("mx.itesm.sapi.properties.catalogos");

                int idRolAdmin = Integer.parseInt(sapiProperties.getString("Administrador"));
                int idTumoresMamarios = Integer.parseInt(sapiProperties.getString("TumoresMamarios"));

                String nombre = request.getParameter("nombre");
                String apellido1 = request.getParameter("primerApellido");
                String apellido2 = request.getParameter("segundoApellido");
                String telefono = request.getParameter("telefono");
                String correo = request.getParameter("correo");
                String noEmpleado = request.getParameter("noEmpleado");
                String especialidadAgregar = request.getParameter("especialidad");
                String posicionMedico = request.getParameter("posicion");
                String cedula = request.getParameter("cedula");
                String contraseña = request.getParameter("password");

                RestringirEmpleado restringirEmpleado = new RestringirEmpleado();

                restringirEmpleado.setNombre(nombre);
                restringirEmpleado.setPrimerApellido(apellido1);
                restringirEmpleado.setSegundoApellido(apellido2);
                restringirEmpleado.setTelefono(telefono);
                restringirEmpleado.setCorreo(correo);
                restringirEmpleado.setRol(idRolAdmin);
                restringirEmpleado.setUsuario(noEmpleado);

                Identificadores identificadores = empleadoServicioImpl.restringirEmpleado(restringirEmpleado);

                //Si la misma cuenta ya existe no se permitirá registrar
                PrintWriter permitir = response.getWriter();

                if (identificadores.getIdCuenta() > 0) {
                    permitir.print("Existe");
                    System.out.println("Ya existe la cuenta de admin");
                    break;
                }

                System.out.println(nombre);
                System.out.println(apellido1);
                System.out.println(apellido2);
                System.out.println(telefono);
                System.out.println(correo);
                System.out.println(noEmpleado);
                System.out.println(especialidadAgregar);
                System.out.println(cedula);
                System.out.println(contraseña);

                per.setNombre(nombre);
                per.setPrimerApellido(apellido1);
                per.setSegundoApellido(apellido2);
                per.setTelefono(telefono);
                per.setCorreo(correo);

                long unixTimestamp = Instant.now().getEpochSecond();

                cuenta.setToken(String.valueOf(unixTimestamp));
                cuenta.setUsuario(noEmpleado);
                cuenta.setIdRol(idRolAdmin);
                cuenta.setPassword(contraseña);
                
                cuenta.setIdEmpleado((int) sesion.getAttribute("idEmpleado"));

                empleado.setNoEmpleado(noEmpleado);
                empleado.setIdDepartamentoDepartamentoInterno(idTumoresMamarios);

                int idPersona = identificadores.getIdPersona();

                if (idPersona == 0) {
                    idPersona = _registroServicio.agregarMedico(per, idRolAdmin);
                }

                int idCuenta = identificadores.getIdCuenta();
                int idEmpleado = identificadores.getEmpleado();

                System.out.println("idPersona: ".concat(String.valueOf(idPersona)));
                if (idPersona > 0) {
                    PicServicioImpl picServiceImpl = new PicServicioImpl();

                    Pic pic = picServiceImpl.mostrarPicDefault();
                    pic.setIdPersona(idPersona);
                    picServiceImpl.agregarPic(pic);

                    cuenta.setIdPersona(idPersona);
                    if (idCuenta == 0) {
                        idCuenta = _rSC.agregarCuenta(cuenta);
                    }

                    if (idCuenta > 0) {
                        empleado.setIdCuenta(idCuenta);
                        if (idEmpleado == 0) {
                            idEmpleado = empleadoServicioImpl.agregarEmpleado(empleado);
                        }

                        System.out.println("idCuenta: ".concat(String.valueOf(idCuenta)));
                        if (idEmpleado > 0) {
                            System.out.println("idEmpleado: ".concat(String.valueOf(idEmpleado)));

                            posicion = posicionServicioImpl.mostrarPosicion(posicionMedico);
                            especialidad = especialidadServicioImpl.mostrarEspecialidadPorNombre(especialidadAgregar);

                            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

                            empleadoPosicion.setIdEmpleado(idEmpleado);
                            empleadoPosicion.setIdPosicion(posicion.getIdPosicion());
                            empleadoPosicion.setInicio(timestamp);

                            medicoEspecialidad.setIdEspecialidad(especialidad.getIdEspecialidad());
                            medicoEspecialidad.setIdEmpleado(idEmpleado);
                            medicoEspecialidad.setCedulaProfesional(cedula);

                            int idEmpleadoPosicionServicio = empleadoPosicionServicioImpl.agregarEmpleadoPosicion(empleadoPosicion);
                            int idMedicoEspecialidad = medicoEspecialidadServicioImpl.agregarMedicoEspecialidad(medicoEspecialidad);

                            System.out.println("Final :D");
                            System.out.println("idPersona: ".concat(String.valueOf(idPersona)));
                            System.out.println("idCuenta: ".concat(String.valueOf(idCuenta)));
                            System.out.println("idEmpleado: ".concat(String.valueOf(idEmpleado)));
                            System.out.println("idEmpleadoPosicion: ".concat(String.valueOf(idEmpleadoPosicionServicio)));
                            System.out.println("idMedicoEspecialidad: ".concat(String.valueOf(idMedicoEspecialidad)));

                            out.print(idEmpleado);
                        }

                    }

                }

                break;
            }
            case "agregarNavegadora": {
                ResourceBundle sapiProperties = ResourceBundle.getBundle("mx.itesm.sapi.properties.catalogos");

                int idRolNavegadora = Integer.parseInt(sapiProperties.getString("Navegadora"));
                int idTumoresMamarios = Integer.parseInt(sapiProperties.getString("TumoresMamarios"));

                String nombre = request.getParameter("nombre");
                String apellido1 = request.getParameter("primerApellido");
                String apellido2 = request.getParameter("segundoApellido");
                String telefono = request.getParameter("telefono");
                String correo = request.getParameter("correo");
                String noEmpleado = request.getParameter("noEmpleado");
                String especialidadAgregar = request.getParameter("especialidad");
                String posicionNavegadora = "Navegadora";
                String cedula = request.getParameter("cedula");
                String contraseña = request.getParameter("password");

                RestringirEmpleado restringirEmpleado = new RestringirEmpleado();

                restringirEmpleado.setNombre(nombre);
                restringirEmpleado.setPrimerApellido(apellido1);
                restringirEmpleado.setSegundoApellido(apellido2);
                restringirEmpleado.setTelefono(telefono);
                restringirEmpleado.setCorreo(correo);
                restringirEmpleado.setRol(idRolNavegadora);
                restringirEmpleado.setUsuario(noEmpleado);

                Identificadores identificadores = empleadoServicioImpl.restringirEmpleado(restringirEmpleado);

                //Si la misma cuenta ya existe no se permitirá registrar
                PrintWriter permitir = response.getWriter();

                if (identificadores.getIdCuenta() > 0) {
                    permitir.print("Existe");
                    System.out.println("Ya existe la cuenta de navegadora");
                    break;
                }

                System.out.println(nombre);
                System.out.println(apellido1);
                System.out.println(apellido2);
                System.out.println(telefono);
                System.out.println(correo);
                System.out.println(noEmpleado);
                System.out.println(especialidadAgregar);
                System.out.println(cedula);
                System.out.println(contraseña);

                per.setNombre(nombre);
                per.setPrimerApellido(apellido1);
                per.setSegundoApellido(apellido2);
                per.setTelefono(telefono);
                per.setCorreo(correo);

                long unixTimestamp = Instant.now().getEpochSecond();

                cuenta.setToken(String.valueOf(unixTimestamp));
                cuenta.setUsuario(noEmpleado);
                cuenta.setIdRol(idRolNavegadora);
                cuenta.setPassword(contraseña);
                cuenta.setIdEmpleado((int) sesion.getAttribute("idEmpleado"));

                System.out.println("Rol ".concat(String.valueOf(idRolNavegadora)));
                if (idRolNavegadora == 2) {
                    break;
                }

                empleado.setNoEmpleado(noEmpleado);
                empleado.setIdDepartamentoDepartamentoInterno(idTumoresMamarios);

                int idPersona = identificadores.getIdPersona();

                if (idPersona == 0) {
                    idPersona = _registroServicio.agregarMedico(per, idRolNavegadora);
                }

                int idCuenta = identificadores.getIdCuenta();
                int idEmpleado = identificadores.getEmpleado();

                System.out.println("idPersona: ".concat(String.valueOf(idPersona)));
                if (idPersona > 0) {
                    PicServicioImpl picServiceImpl = new PicServicioImpl();

                    Pic pic = picServiceImpl.mostrarPicDefault();
                    pic.setIdPersona(idPersona);
                    picServiceImpl.agregarPic(pic);

                    cuenta.setIdPersona(idPersona);

                    if (idCuenta == 0) {
                        idCuenta = _rSC.agregarCuenta(cuenta);
                    }

                    if (idCuenta > 0) {
                        empleado.setIdCuenta(idCuenta);

                        if (idEmpleado == 0) {
                            idEmpleado = empleadoServicioImpl.agregarEmpleado(empleado);
                        }

                        System.out.println("idCuenta: ".concat(String.valueOf(idCuenta)));
                        if (idEmpleado > 0) {
                            System.out.println("idEmpleado: ".concat(String.valueOf(idEmpleado)));

                            posicion = posicionServicioImpl.mostrarPosicion(posicionNavegadora);
                            especialidad = especialidadServicioImpl.mostrarEspecialidadPorNombre(especialidadAgregar);

                            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

                            empleadoPosicion.setIdEmpleado(idEmpleado);
                            empleadoPosicion.setIdPosicion(posicion.getIdPosicion());
                            empleadoPosicion.setInicio(timestamp);

                            medicoEspecialidad.setIdEspecialidad(especialidad.getIdEspecialidad());
                            medicoEspecialidad.setIdEmpleado(idEmpleado);
                            medicoEspecialidad.setCedulaProfesional(cedula);

                            int idEmpleadoPosicionServicio = empleadoPosicionServicioImpl.agregarEmpleadoPosicion(empleadoPosicion);
                            int idMedicoEspecialidad = medicoEspecialidadServicioImpl.agregarMedicoEspecialidad(medicoEspecialidad);

                            System.out.println("Final :D");
                            System.out.println("idPersona: ".concat(String.valueOf(idPersona)));
                            System.out.println("idCuenta: ".concat(String.valueOf(idCuenta)));
                            System.out.println("idEmpleado: ".concat(String.valueOf(idEmpleado)));
                            System.out.println("idEmpleadoPosicion: ".concat(String.valueOf(idEmpleadoPosicionServicio)));
                            System.out.println("idMedicoEspecialidad: ".concat(String.valueOf(idMedicoEspecialidad)));

                            if (idEmpleado > 0 && idEmpleadoPosicionServicio > 0) {
                                permitir.print(idEmpleado);
                                enviaCorreo(noEmpleado, correo);
                            } else {
                                permitir.print("0");
                            }
                        }

                    }

                }

                break;
            }

        }
    }

    protected void enviaCorreo(String usuario, String correo) {

        /**
         * El metodo enviaCorreo tiene como función el envío de un correo de
         * confirmación al Usuario registrado. Se recibe como parametro el
         * correo del Usuario. Mediante una cuenta ya introduciida dentro del
         * codigo se envía el correo. El contenido del correo puede ser
         * configurado en el mimeBodyPart.
         */
        System.out.println("estoy en el metodo");
        Properties config = new Properties();

        try {

            config.load(getClass().getResourceAsStream("/mail.properties"));
            Session session = Session.getInstance(config,
                    new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("sapi.prueba@gmail.com", "prueba.Sapi1");

                }
            });

            System.out.println("despues del try");
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("sapi.prueba@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(correo));
            message.setSubject("Prueba de mail de sapo");
            //message.setText("Esto no es spam :)");

            //Estos deberían ir como parametros dentro de la función de enviar correo
            //String mail = "tucorreo@mail.com";
            //String contrasena = "tucontrasena";
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent("<b>Bienvenido a sapi, estos son tus datos :)</b></br>".
                    concat("<b>Usuario: ").
                    concat(usuario), "text/html");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);

            Path path = Files.createTempFile(null, ".properties");
            File file = new File(path.toString());

            OutputStream outputStream = new FileOutputStream(file);
            IOUtils.copy(getClass().getResourceAsStream("/mail.properties"), outputStream);
            outputStream.close();

            //Comente este attach fail porque de lo contrario no se hace bien el set content de arriba (lo de los datos de usuario)
            // mimeBodyPart.attachFile(file);
            message.setContent(multipart);
            Transport.send(message);

        } catch (Exception ex) {
            System.out.println("catch de envia correo");
            System.out.println(this.getClass().toString().concat(ex.getMessage()));
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
