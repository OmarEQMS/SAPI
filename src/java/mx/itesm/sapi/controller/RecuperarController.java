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
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;
import java.util.ResourceBundle;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mx.itesm.sapi.bean.persona.Cuenta;
import mx.itesm.sapi.service.persona.CuentaServicioImpl;

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
import mx.itesm.sapi.bean.persona.Persona;
import mx.itesm.sapi.service.persona.PersonaServicioImpl;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author Angel Guitierrez
 */
@WebServlet(name = "RecuperarController", urlPatterns = {"/RecuperarController"})
public class RecuperarController extends HttpServlet {

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

        System.out.println("RecuperarController Method ".concat(request.getMethod()));

        String key = request.getParameter("key");

        System.out.println("URL RecuperarController: ".concat(request.getRequestURL().toString()));

        switch (key) {

            case "cambiarContrasena": {

                /**
                 * Aqui tomamos las contraseñas las comparamos para ver si son
                 * iguales y de ser asi se le actualiza en la base de datos
                 */
                //lo que esta comentado es haciendo la sesion aqui
                HttpSession sesion = request.getSession(true);
                String contra = request.getParameter("password");
                String contra2 = request.getParameter("password2");

                CuentaServicioImpl cuentaServiceImpl = new CuentaServicioImpl();
                Cuenta cuenta = cuentaServiceImpl.mostrarCuenta((int) sesion.getAttribute("idCuenta"));

                if (contra.equals(contra2)) {

                    CuentaServicioImpl cuentaServicio = new CuentaServicioImpl();

                    // Cuenta cuenta = cuentaServicio.mostrarCuenta(idCuenta);
                    cuenta.setPassword(contra);

                    cuentaServicio.actualizarCuenta(cuenta);
                    System.out.println("RecuperarController case 'cambiarSontrasena'");
                    request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
                }

                break;
            }

            case "recuperarEnviarCorreo": {

                //System.out.println("Estoy en RecuperarController case: recuperarEnviarCorreo");
                Properties config = new Properties();
                String correo = request.getParameter("email");
                
                ResourceBundle sapiProperties = ResourceBundle.getBundle("mx.itesm.sapi.properties.catalogos");
        
                String correoSapi = String.valueOf(sapiProperties.getObject("correoSapi"));
                String contraseñaSapi = String.valueOf(sapiProperties.getObject("contraseñaSapi"));
                //System.out.println("El correo es: ".concat(correo));
                //HttpSession sesion = request.getSession(true);

                CuentaServicioImpl cuenta = new CuentaServicioImpl();
                //System.out.println("El correo es: ".concat(correo));
                String token = cuenta.getToken(correo);
                
                
                Persona persona;
                PersonaServicioImpl personaServicioImpl = new PersonaServicioImpl();
                persona = personaServicioImpl.mostrarPersonaPorCorreo(correo);
                        
                        
                System.out.println("el token es: ".concat(token));
               
                try {
                    config.load(getClass().getResourceAsStream("/mail.properties"));
                    Session session = Session.getInstance(config,
                            new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(correoSapi, contraseñaSapi);

                        }
                    });

                    //System.out.println("despues del try");
                    Message message = new MimeMessage(session);
                    message.setFrom(new InternetAddress(correoSapi));
                    message.setRecipients(Message.RecipientType.TO,
                            InternetAddress.parse(correo));
                    message.setSubject("Recuperar Contraseña");
                    //message.setText("Esto no es spam :)");

                    //Estos deberían ir como parametros dentro de la función de enviar correo
                    //String mail = "tucorreo@mail.com";
                    //String contrasena = "tucontrasena";
                    MimeBodyPart mimeBodyPart = new MimeBodyPart();
                    mimeBodyPart.setContent("<b>Estimada(o) "
                            .concat(persona.getNombre())
                            .concat(", <br><br>usted ha solicitado Recuperar su cuenta.</b></br>")
                            .concat("<b>Su código de recuperación (token) para cambiar su contraseña y acceder a su cuenta es:  ")
                            .concat(token)
                            .concat("<br><br> Por favor siga estas instrucciones para poder reestablecer su contraseña:</br>")
                            .concat("1) Ingresé con su usuario normal en la pantalla de iniciar sesión.")
                            .concat("2) Coloqué en el sitio de contraseña el token que se ha adjuntado en este correo.")
                            .concat("3) Será redirigido a una pantalla para cambiar su contraseña anterior por una nueva.")
                            .concat("4) Inicie sesión con su usuario de siempre y su nueva contraseña."
                            .concat("<br><br><br>Atte. el equipo de SAPI.")), "text/html");

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
                    request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);

                } catch (Exception ex) {
                    System.out.println("catch de envia correo");
                    System.out.println(this.getClass().toString().concat(ex.getMessage()));
                }
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
