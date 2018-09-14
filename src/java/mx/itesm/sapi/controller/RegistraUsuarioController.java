/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.controller;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.itesm.sapi.bean.Cuenta;
import mx.itesm.sapi.bean.Direccion;
import mx.itesm.sapi.bean.Persona;
import mx.itesm.sapi.service.CuentaServicioImpl;
import mx.itesm.sapi.service.DireccionServicioImpl;
import mx.itesm.sapi.service.PersonaServicioImpl;

/**
 *
 * @author Admin
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
        
        PrintWriter out = response.getWriter();
       
         //Servicios
        PersonaServicioImpl _registroServicio= new PersonaServicioImpl();
        CuentaServicioImpl _rSC = new CuentaServicioImpl();
        DireccionServicioImpl _rSD = new DireccionServicioImpl();
        
        
        //Verifica existencia de usuario
        String usuario  =   request.getParameter("usuario");
        
        
        
        
        
        String nombre=request.getParameter("nombre");
        String apellido1 =request.getParameter("apellido1");
        String apellido2 =request.getParameter("apellido2");
        String telefono = request.getParameter("telefono");
        String curp =request.getParameter("curp");
        String correo =request.getParameter("correo");   
        int estadoCivil =Integer.parseInt(request.getParameter("estadoCivil"));
        int municipio =Integer.parseInt(request.getParameter("municipio"));
        int estado =Integer.parseInt(request.getParameter("estado"));
        String colonia =request.getParameter("colonia");        
        String calle =request.getParameter("calle");        
        String noExterior =request.getParameter("noExterior");
        String noInterior =request.getParameter("noInterior");
        String contraseña1 =request.getParameter("pass1");
        String contraseña2 =request.getParameter("pass2");
        String fechaNacimiento=request.getParameter("fechaNacimiento");
        
       
        Persona per=new Persona();
        Cuenta cuenta=new Cuenta();
        Direccion dir=new Direccion();
        
        //Set persona
        per.setNombre(nombre);
        per.setTelefono(telefono);
        per.setApellido1(apellido1);
        per.setApellido2(apellido2);
        per.setCorreo(correo);
        per.setCurp(curp);
        per.setIdEstado(estado);
        per.setIdEstadoCivil(estadoCivil);
        per.setIdMunicipio(municipio);
        per.setFechaNacimiento(fechaNacimiento);
        
        //Por arregalar
        per.setEdad(0);
        //Por arreglar
        
        //Por arreglar
        per.setIdRol(1);
        //Por arreglar
       
        
        //Set cuenta
        cuenta.setPassword(contraseña1);
        cuenta.setUsuario(usuario);
      
        
        //DIRECCION
        dir.setCalle(calle);
        dir.setColonia(colonia);
        dir.setNoExterior(noExterior);
        dir.setNoInterior(noInterior);
        
 

        per.toString();
                          
        //Checo si el usuario existe
        if(_rSC.existsUsuario(usuario)){
            
           out.print("UsuarioAlreadyExists");
           
        }else{
            //Si no existe, lo inserto
            out.print("UsuarioDoesntExist");
           
        int id=_registroServicio.savePersona(per);
                
        if(id>0){
               
                cuenta.setIdPersona(id);
                dir.setIdPersona(id);
                _rSC.saveCuenta(cuenta);
                _rSD.saveDireccion(dir);
                
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