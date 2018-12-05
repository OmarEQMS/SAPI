<%-- 
    Document   : registro
    Created on : 14/09/2018, 11:08:13 AM
    Author     : feror, julioguzman, shannonrosas
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

        <div class="crearCuenta" id="loading-screen" style="display: none">
            <img src="img/loading.svg">
            <p class="clear">Creando tu cuenta, por favor espere...</p>
        </div>

        <form class="formulario">

            <h1 class="h3 mb-4 titulo-login text-center">Registro</h1>

            <div id="pantalla1">

                <div class="form-group row">
                    <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12">
                        <input id="nombre" type="text" class="form-control inputGlobal mb-1 useFontAwesomeFamily" placeholder="&#xf007; NOMBRE" autofocus>
                        <span class="text-danger" id="errorNombre">Formato incorrecto, solo caracteres alfabéticos con un mínimo de 2 y un máximo de 255 caracteres.</span>
                    </div>
                </div>

                <div class="form-group row">
                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6">
                        <input id="apellido1" type="text" class="form-control inputGlobal mb-1 useFontAwesomeFamily" placeholder="&#xf007; PRIMER APELLIDO">
                        <span class="text-danger" id="errorApellidoPaterno">Formato incorrecto, solo caracteres alfabéticos con un mínimo de 2 y un máximo de 127 caracteres.</span>
                    </div>

                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6">
                        <input id="apellido2" type="text" class="form-control inputGlobal mb-1 useFontAwesomeFamily" placeholder="&#xf007; SEGUNDO APELLIDO (OPCIONAL)">
                        <span class="text-danger" id="errorApellidoMaterno">Formato incorrecto, solo caracteres alfabéticos con un mínimo de 2 y un máximo de 127 caracteres.</span>
                    </div>
                </div>


                <div class="form-group row">
                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6">
                        <input id="usuario" type="text" class="form-control inputGlobal mb-1 useFontAwesomeFamily" placeholder="&#xf2bd; NOMBRE DE USUARIO">
                        <span class="text-danger" id="errorNombreUsuario">Formato incorrecto, solo caracteres alfanumérico con un mínimo de 4 y un máximo de 16 caracteres.</span>
                        <span class="text-warning" id="errorUsuarioRepetido">El usuario ya existe.</span>
                    </div>
                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6">
                        <input id="correo" type="text" class="form-control inputGlobal mb-1 useFontAwesomeFamily" placeholder="&#xf0e0; CORREO ELECTRÓNICO">
                        <span class="text-danger" id="errorCorreo">El formato no es correcto, introduce un mínimo de 2 y un máximo de 254 caracteres. Ejemplo: ejemplo@ejemplo.com</span>
                        <span class="text-warning" id="errorCorreoRepetido">El correo ya existe.</span>
                    </div>
                </div>


                <div class="form-group row">
                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12">
                        <input id="pass1" type="password" class="form-control inputGlobal mb-1 useFontAwesomeFamily" placeholder="&#xf023; CONTRASEÑA" autofocus>
                        <span class="text-danger" id="errorPass1">Formato incorrecto, la contraseña debe tener al menos 1 número, 1 letra minúscula, 1 mayúscula y una extensión de 8 a 14 caracteres.</span>
                    </div>

                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12">
                        <input id="pass2" type="password" class="form-control inputGlobal mb-1 useFontAwesomeFamily" placeholder="&#xf023; CONFIRMAR CONTRASEÑA">
                        <span class="text-warning" id="noEqualPasswordsError">Las contraseñas no son iguales.</span>
                    </div>

                </div>

            </div>

            <div id="pantalla2">

                <div class="form-group row">
                    <div class="col-xl-4 col-lg-4 col-md-4 col-sm-12">
                        <input id="curp" type="text" class="form-control inputGlobal mb-1 useFontAwesomeFamily" placeholder="&#xf2C2; CURP">

                        <span class="text-danger " id="errorCurp">Formato incorrecto, las letras deben estar en mayúsculas y asegúrate de introducir un CURP válido y sin espacios. Puedes consultarlo 
                            <a class="text-primary " target="_blank" href="https://www.gob.mx/curp/">aquí.</a>
                        </span>
                        <span class="text-warning" id="errorCurpRepetido">El curp ya existe.</span>
                    </div>

                    <div class="col-xl-4 col-lg-4 col-md-4 col-sm-12">
                        <input id="codigoPostal" type="text" class="form-control inputGlobal mb-1 useFontAwesomeFamily" placeholder="&#xf3c5; C.P. (OPCIONAL)">
                        <span class="text-danger" id="errorCodigoPostal">Formato incorrecto, deben ser 5 dígitos.</span>
                        <span class="text-danger" id="error-CPexiste" style="font-size:13px;">El codigo postal no existe.</span>
                    </div>

                    <div class="col-xl-4 col-lg-4 col-md-4 col-sm-12">
                        <input id="telefono" type="text" class="form-control inputGlobal mb-1 useFontAwesomeFamily" placeholder="&#xf095; TELEFONO">
                        <span class="text-danger" id="errorTelefono">Formato incorrecto, deben ser 10 dígitos.</span>
                    </div>
                </div>

                <div class="form-group row">
                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12">
                        <select class="form-control selectStyle" id="estadoCivil">
                            <option selected disabled>ESTADO CIVIL</option>
                            <c:forEach items="${estadoCivil}" var="estadoC">  
                                <option value="<c:out value='${estadoC.idEstadoCivil}'/>"><c:out value='${estadoC.nombre}'/></option>
                            </c:forEach>
                        </select>
                        <span class="text-danger" id="errorECivil">Selecciona una opcion</span>
                    </div>
                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12">
                        <input placeholder="FECHA DE NACIMIENTO" class="selectStyle form-control textbox-n" type="text" onfocus="(this.type = 'date')"  id="fechaNacimiento">
                        <span class="text-danger" id="errorFecha">Fecha incorrecta debes tener entre 16 y 115 años para poder registrarte</span>
                    </div>
                </div>

                <div class="form-group row">
                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12">
                        <select class="form-control selectStyle" id="estado">
                            <option selected disabled>ESTADO</option>
                            <c:forEach items="${estados}" var="estado">  
                                <option value="<c:out value='${estado.idEstado}'/>"><c:out value='${estado.nombre}'/></option>
                            </c:forEach>
                        </select>
                        <span class="text-danger" id="errorEstado">Campo vacío</span>
                    </div>
                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12 municipios">
                        <select class="form-control selectStyle" id="municipio">
                            <option selected disabled>MUNICIPIO</option>

                        </select>
                        <span class="text-danger" id="errorMunicipio">Campo vacío</span>
                    </div>
                </div>

                <div class="form-group row">

                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12">
                        <input id="colonia" type="text" class="form-control inputGlobal mb-1 useFontAwesomeFamily" placeholder="&#xf015; COLONIA (OPCIONAL)" autofocus>
                        <span class="text-danger" id="errorColonia">Formato incorrecto, introducir caracteres alfanuméricos.</span>
                    </div>

                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12">
                        <input id="calle" type="text" class="form-control inputGlobal mb-1 useFontAwesomeFamily" placeholder="&#xf015; CALLE (OPCIONAL)">
                        <span class="text-danger" id="errorCalle">Formato incorrecto, introducir caracteres alfanuméricos.</span>
                    </div>

                </div>

                <div class="form-group row">
                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12">
                        <input id="noExterior" type="text" class="form-control inputGlobal mb-1 useFontAwesomeFamily" placeholder="&#xf3c5; NO.EXT (OPCIONAL)">
                        <span class="text-danger" id="errorNoExterior">Formato incorrecto, solo dígitos.</span>
                    </div>

                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12">
                        <input id="noInterior" type="text" class="form-control inputGlobal mb-1 useFontAwesomeFamily" placeholder="&#xf3c5; NO.INT (OPCIONAL)">
                        <span class="text-danger" id="errorNoInterior">Formato incorrecto, solo dígitos y/o letras.</span>
                    </div>
                </div>

            </div>

            <!-- Input submit -->
            <div class="row mb-3" id="error-campos">
                <div class="col-12 text-center">
                    <span class="text-danger">Completa todos los campos para registrar tu cuenta. </span>
                </div>
            </div>
            
            <div class="row mb-3" id="error-datosRepetidos">
                <div class="col-12 text-center">
                    <span class="text-warning">Estás tratando de registrar datos existentes. <br> Revisa de nuevo.</span>
                </div>
            </div>

            <input type="button" id="btn-continuar" class="btn btn-lg btn-success btn-block btn-continuar" value="CONTINUAR">

            <div class="row">
                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-6 mb-1">
                    <input type="button" id="btn-registro" data-toggle="modal" class="btn btn-lg btn-danger btn-block btn-registro" value="REGISTRARME">
                </div>
                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-6">
                    <input type="button" id="btn-regresar" class="btn btn-lg btn-primary btn-block btn-regresar" value="REGRESAR">
                </div>
            </div>

            <h6 class="text-center mt-4 texto-cuenta mb-0"><span>¿Ya estás registrado?</span> <a href="#" id="regresarIndex">Inicia
                    sesión aquí</a></h6>

            <input type="hidden" id="tipoPaciente">

        </form>

        <!------------------------MODAL TERMINOS Y CONDICIONES---------------------------->
        <div class="modal fade" id="modalTerminos" tabindex="-1" data-keyboard="false" data-backdrop="static" role="dialog" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Aceptar Terminos y Condiciones</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">                    
                        <label> <input type="checkbox" id="acepto-datos"> Acepto que mis datos sean usados para agilizar mi tratamiento</label>
                        <label> <input type="checkbox" id="acepto-datos-anonimos"> Deseo que mis datos sean anonimos despues de haber culminado mi estancia en el instituto</label>
                        <span class="text-danger" id="error-terminos">Para continuar debes de marcar ambos campos.</span>
                    </div>
                    <div class="modal-footer">
                        <button id="btnCancelar" type="button" style="border-radius:20px" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                        <button id="btnAceptar" type="button" style="border-radius:20px" class="btn btn-primary">Aceptar</button>
                    </div>
                </div>
            </div>
        </div>



        <script src="lib/jquery/jquery-3.3.1.js"></script>
        <script src="lib/jquery/jqueryPostGo.js"></script>
        <script src="lib/bootstrap/js/bootstrap.js"></script>
        <script src="lib/popper/popper.min.js"></script>
        <!--script type="application/javascript" src="js/appRegistro.js"></script--> 
        <!--script type="application/javascript" src="js/validaciones.js"></script--> 
        <script type="application/javascript" src="js/app.js"></script> 
        <script src="js/asincrono.js"></script> 
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>


    </body>

</html>
