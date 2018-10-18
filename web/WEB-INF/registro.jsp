<%-- 
    Document   : registro
    Created on : 14/09/2018, 11:08:13 AM
    Author     : feror
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="mx.itesm.sapi.bean.persona.EstadoCivil"%>
<%@page import="mx.itesm.sapi.bean.persona.Estado"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <%-- Hace rereferencia al conjunto de reglas --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Registro</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ"
        crossorigin="anonymous">
    <link rel="stylesheet" href="lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="css/stylesRegistro.css">
    
</head>

<body>

    <form class="formulario">

        <h1 class="h3 mb-4 titulo-login text-center">Registro</h1>

        <div id="pantalla1">

            <div class="form-group row">
                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12">
                    <input id="nombre" type="text" class="form-control inputGlobal mb-1 useFontAwesomeFamily" placeholder="&#xf007; NOMBRE" autofocus>
                    <span class="text-danger" id="errorNombre">Formato incorrecto</span>
                </div>
            </div>

            <div class="form-group row">
                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6">
                    <input id="apellido1" type="text" class="form-control inputGlobal mb-1 useFontAwesomeFamily" placeholder="&#xf007; APELLIDO PATERNO">
                    <span class="text-danger" id="errorApellidoPaterno">Formato incorrecto</span>
                </div>

                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6">
                    <input id="apellido2" type="text" class="form-control inputGlobal mb-1 useFontAwesomeFamily" placeholder="&#xf007; APELLIDO MATERNO">
                    <span class="text-danger" id="errorApellidoMaterno">Formato incorrecto</span>
                </div>
            </div>


            <div class="form-group row">
                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6">
                    <input id="usuario" type="text" class="form-control inputGlobal mb-1 useFontAwesomeFamily" placeholder="&#xf2bd; NOMBRE DE USUARIO">
                    <span class="text-danger" id="errorNombreUsuario">Formato incorrecto</span>
                    <span class="text-warning" id="errorUsuarioRepetido">El usuario ya existe</span>
                </div>
                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6">
                    <input id="correo" type="text" class="form-control inputGlobal mb-1 useFontAwesomeFamily" placeholder="&#xf0e0; CORREO ELECTRÓNICO (OPCIONAL)">
                    <span class="text-danger" id="errorCorreo">Formato incorrecto</span>
                </div>
            </div>


            <div class="form-group row">
                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12">
                    <input id="pass1" type="password" class="form-control inputGlobal mb-1 useFontAwesomeFamily" placeholder="&#xf023; CONTRASEÑA" autofocus>
                    <span class="text-danger" id="errorPass1">Formato incorrecto</span>
                </div>
       
                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12">
                    <input id="pass2" type="password" class="form-control inputGlobal mb-1 useFontAwesomeFamily" placeholder="&#xf023; CONFIRMAR CONTRASEÑA">
                    <span class="text-warning" id="noEqualPasswordsError">Las contraseñas no son iguales</span>
                    <span class="text-danger" id="errorPass2">Formato incorrecto</span>
                </div>
                
            </div>

        </div>

        <div id="pantalla2">

            <div class="form-group row">
                <div class="col-xl-4 col-lg-4 col-md-4 col-sm-12">
                    <input id="curp" type="text" class="form-control inputGlobal mb-1 useFontAwesomeFamily" placeholder="&#xf2C2; CURP">
                    <span class="text-danger" id="errorCurp">Formato incorrecto</span>
                </div>
                
                <div class="col-xl-4 col-lg-4 col-md-4 col-sm-12">
                    <input id="codigoPostal" type="text" class="form-control inputGlobal mb-1 useFontAwesomeFamily" placeholder="&#xf3c5; CODIGO POSTAL">
                    <span class="text-danger" id="errorCodigoPostal">Formato incorrecto</span>
                </div>

                <div class="col-xl-4 col-lg-4 col-md-4 col-sm-12">
                    <input id="telefono" type="text" class="form-control inputGlobal mb-1 useFontAwesomeFamily" placeholder="&#xf095; TELEFONO">
                    <span class="text-danger" id="errorTelefono">Formato incorrecto</span>
                </div>
            </div>

            <div class="form-group row">
                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12">
                    <select class="form-control selectStyle" id="estadoCivil">
                        <option selected disabled>Estado civil</option>
                        <c:forEach items="${estadoCivil}" var="estadoC">  
                            <option value="<c:out value='${estadoC.idEstadoCivil}'/>"><c:out value='${estadoC.nombre}'/></option>
                        </c:forEach>
                    </select>
                    <span class="text-danger" id="errorECivil">Selecciona una opcion</span>
                </div>
                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12">
                    <input type="date" id="fechaNacimiento" class="selectStyle form-control">
                    <span class="text-danger" id="errorFecha">Fecha incorrecta</span>
                </div>
            </div>

            <div class="form-group row">
                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12">
                    <select class="form-control selectStyle" id="estado">
                        <option selected disabled>Estado</option>
                        <c:forEach items="${estados}" var="estado">  
                            <option value="<c:out value='${estado.idEstado}'/>"><c:out value='${estado.nombre}'/></option>
                        </c:forEach>
                    </select>
                    <span class="text-danger" id="errorEstado">Fecha incorrecta</span>
                </div>
                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12 municipios">
                    <select class="form-control selectStyle" id="municipio">
                        <option selected disabled>Municipio</option>
                        
                    </select>
                    <span class="text-danger" id="errorMunicipio">Formato Incorrecto</span>
                </div>
            </div>

            <div class="form-group row">

                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12">
                    <input id="colonia" type="text" class="form-control inputGlobal mb-1 useFontAwesomeFamily" placeholder="&#xf015; COLONIA" autofocus>
                    <span class="text-danger" id="errorColonia">Formato incorrecto</span>
                </div>

                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12">
                    <input id="calle" type="text" class="form-control inputGlobal mb-1 useFontAwesomeFamily" placeholder="&#xf015; CALLE">
                    <span class="text-danger" id="errorCalle">Formato incorrecto</span>
                </div>

            </div>

            <div class="form-group row">
                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12">
                    <input id="noExterior" type="text" class="form-control inputGlobal mb-1 useFontAwesomeFamily" placeholder="&#xf3c5; NO.EXT">
                    <span class="text-danger" id="errorNoExterior">Formato incorrecto</span>
                </div>

                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12">
                    <input id="noInterior" type="text" class="form-control inputGlobal mb-1 useFontAwesomeFamily" placeholder="&#xf3c5; NO.INT (Opcional)">
                    <span class="text-danger" id="errorNoInterior">Formato incorrecto</span>
                </div>
            </div>

        </div>

        <!-- Input submit -->
        <input type="button" id="btn-continuar" class="btn btn-lg btn-success btn-block btn-continuar" value="CONTINUAR">
       

        <div class="row">
            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-6 mb-1">
                <input type="button" id="btn-registro" class="btn btn-lg btn-danger btn-block btn-registro" value="REGISTRARME">
            </div>
            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-6">
                <input type="button" id="btn-regresar" class="btn btn-lg btn-primary btn-block btn-regresar" value="REGRESAR">
            </div>
        </div>

        <h6 class="text-center mt-4 texto-cuenta mb-0"><span>Ya estas registrado?</span> <a href="#" id="regresarIndex">Inicia
                sesión aquí</a></h6>
    </form>


    <script src="lib/jquery/jquery-3.3.1.js"></script>
    <script src="lib/jquery/jqueryPostGo.js"></script>
    <script src="lib/bootstrap/js/bootstrap.js"></script>
    <script src="lib/popper/popper.min.js"></script>
    <!--script type="application/javascript" src="js/appRegistro.js"></script--> 
    <!--script type="application/javascript" src="js/validaciones.js"></script--> 
    <script type="application/javascript" src="js/app.js"></script> 
    <script type="module" src="js/asincrono.js"></script> 
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@7.26.29/dist/sweetalert2.all.min.js"></script>
    

</body>

</html>
