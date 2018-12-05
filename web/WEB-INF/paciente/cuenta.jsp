<%-- 
    Document   : cuenta
    Created on : 18-oct-2018, 15:41:30
    Author     : urieldiaz, julioguzman, shannonrosas
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <title>SAPI | Inicio</title>

        <link href="lib/bootstrap/css/bootstrap.css" rel="stylesheet" />
        <link href="lib/fontawesome/css/all.css" rel="stylesheet" />
        <link href='lib/fullcalendar/fullcalendar.css' rel='stylesheet' />
        <link href="lib/tooltipster/dist/css/tooltipster.bundle.min.css" rel="stylesheet" />
        <link href="lib/tooltipster/dist/css/plugins/tooltipster/sideTip/themes/tooltipster-sideTip-shadow.min.css" rel="stylesheet"
              />
        <link href="lib/datatables/datatables.min.css" rel="stylesheet" type="text/css" />
        <script src="lib/jquery/jquery-3.3.1.js" type="application/javascript"></script>
        <script src="lib/jquery/jqueryPostGo.js" type="application/javascript"></script>
        <script src="lib/popper/popper.min.js" type="application/javascript"></script>
        <script src="lib/bootstrap/js/bootstrap.js" type="application/javascript"></script>
        <script src='lib/moment/moment.min.js' type="application/javascript"></script>
        <script src='lib/fullcalendar/fullcalendar.js' type="application/javascript"></script>
        <script src="lib/fullcalendar/locale-all.js"></script>
        <script src="lib/sweetalert/dist/sweetalert.min.js"></script>
        <script src="lib/tooltipster/dist/js/tooltipster.bundle.min.js" type="text/javascript"></script>
        <script src="lib/datatables/datatables.min.js" type="text/javascript"></script>

        <link rel="stylesheet" href="css/stylePaciente.css">

        <script src="js/calendarPaciente.js"></script>
        <script src="js/appPaciente.js"></script>
        <script src="js/ajaxPaciente.js"></script>         

    </head>

    <body>

        <div class="wrapper">

            

            <!-- SIDEBAR -->
            <nav id="sidebar">

                <div class="sidebar-header">

                    <div class="row text-center justify-content-center mt-2">
                        <div class="col-12">
                            <img src="img/logoSapi.png" style="width: 70%; display:block; margin:auto;" alt="">
                        </div>
                    </div>

                </div>

                <div class="profile">
                    <div class="row">
                        <div class="col-12 mb-2 mt-4">
                            <!-- <img src="img/user.png" class="imagenPerfil" alt=""> -->
                            <img src="data:image/jpeg;base64,${sessionScope.base64Img}" class="imagenPerfil edit-image" width="66px" height="66px" alt="">
                        </div>
                    </div>
                    <div class="row justify-content-center mb-2">
                        <div class="col-6 text-center">
                            <span class="textoSidebar m-0">${sessionScope.nombre} ${sessionScope.primerApellido}</span>
                            <span class="textoSidebar userSidebar m-0">@${sessionScope.usuario}</span>
                        </div>
                    </div>
                    <div class="row justify-content-center">
                        <div class="col-2 text-center">
                            <a class="iconoSidebar irACuenta" title="Mi Cuenta"><i class="fas fa-cog"></i></a>
                        </div>

                        <div class="col-2">
                            <a class="iconoSidebar" id="salirCuenta1" title="Cerrar Sesión"><i class="fas fa-power-off"></i></a>
                        </div>
                    </div>
                </div>

                <div class="row justify-content-center">
                    <div class="col-12 text-center">
                        <hr style="background-color:white !important">
                    </div>
                </div>

                <!-- MENU PRINCIPAL ENLACES -->
                <ul class="list-unstyled components">

                    <li id="irMisCitas"><a><i class="far fa-user"></i>Mis citas</a></li>
                    <li id="irACuenta" class="irACuenta"><a><i class="far fa-user irACuenta"></i>Mi Cuenta</a></li>
                    <li id="irATratamientos"><a><i class="far fa-user"></i>Mis Tratamientos</a></li>
                    <li id="salirCuenta"><a><i class="fas fa-sign-out-alt"></i>Cerrar Sesión</a></li>

                </ul>

            </nav>

            <div class="loading-screenGuardar" id="loading-screen" style="display: none">
                <img src="img/loading.svg">
                <p class="clear">Guardando tu información, por favor espere...</p>
            </div>

            <!-- CONTENIDO PRINCIPAL  -->

            <div id="content">

                <!-- MENU -->

                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <div class="container-fluid">

                        <button id="sidebarCollapse" class="btn boton-collapse">
                            <i class="fas fa-align-justify"></i>
                        </button>

                        <span class="pull-right d-block">
                            <span style="color:#6c6f80">Hola, </span>
                            <span style="font-weight:700; color:#6c6f80;">${sessionScope.nombre} ${sessionScope.primerApellido}
                            </span>
                        </span>

                    </div>
                </nav>

                <!-- **************************************************************** -->
                <!-- ***** A PARTIR DE AQUI ESCRIBEN EL CODIGO QUE QUIERAN..... ***** -->
                <!-- **************************************************************** -->

                <div class="row mb-3">
                    <div class="col-12 text-right">
                        <span class="iconoHome mr-2">
                            <i class="fas fa-home"></i>
                        </span>
                        <span>
                            <a id="irAInicioPaciente" class="colorMoradoLight">Inicio</a>
                        </span>
                        -
                        <span class="colorGlobal">Mi Cuenta</span>
                    </div>
                </div>

                <!-- Jumbotron Titulo -->

                <div class="jumbotron jumbotron-fluid p-2">
                    <div class="container">
                        <h1 class="display-4 tituloMiCuenta text-center m-0">Mi cuenta</h1>
                    </div>
                </div>

                <!-- Contenido del contenedor blanco -->
                <div class="card mt-3">
                    <div class="card-body">

                        <form>

                            <!-- Imagen -->
                            <div class="form-group row justify-content-center">
                                <div class="col-12 text-center">
                                    <!--  <label for="file-input">
                                          <img src="img/user.png" class="edit-image" alt="Click aquí" title="Click aquí" width="200px" height="200px">
                                      </label>
                                      <input type="file" class="editar-imagen" id="file-input" /> -->

                                    <input type="file" class="editar-imagen" id="file-input" name="file-image"/>
                                    <label for="file-input">
                                        <img src="data:image/jpeg;base64,${sessionScope.base64Img}" id="ImagenPerfil" class="edit-image" alt="Click aquí" title="Click aquí" width="200px" height="200px">
                                    </label>

                                </div>
                            </div>
                            <div class="row mb-4">
                                <div class="col-12 text-center">
                                    <h4 class="FotoPerfil text-secondary" style="font-size:17px;">Edita tu foto de perfil</h4>
                                    <span class="text-danger" id="error-imgPerfil">No es una extensión válida. Puedes subir un archivo .jpg o .png</span>
                                </div>
                            </div>

                            <!-- 1 -->
                            <div class="form-group row justify-content-center">
                                <div class="col-xl-4 col-lg-4 col-md-4 col-sm-8 col-8">
                                    <label for="name">Nombre</label>
                                    <input type="text" class="form-control" id="name" value="${sessionScope.nombre}" readonly />
                                </div>
                                <div class="col-xl-4 col-lg-4 col-md-4 col-sm-8 col-8">
                                    <label for="surname1">Primer Apellido</label>
                                    <input type="text" class="form-control" id="surname1" value="${sessionScope.primerApellido}" readonly />
                                </div>

                            </div>

                            <!-- 2 -->
                            <div class="form-group row justify-content-center">
                                <div class="col-xl-4 col-lg-4 col-md-4 col-sm-8 col-8">
                                    <label for="surname2">Segundo Apellido</label>
                                    <input type="text" class="form-control" id="surname2" value="${sessionScope.segundoApellido}" readonly />
                                </div>
                                <div class="col-xl-4 col-lg-4 col-md-4 col-sm-8 col-8">
                                    <label for="username">Usuario</label>
                                    <input type="text" class="form-control" id="username" value="${sessionScope.usuario}" readonly />
                                </div>
                            </div>
                            <!-- 3 -->

                            <!-- 3 -->
                            <div class="form-group row justify-content-center">
                                <div class="col-xl-4 col-lg-4 col-md-4 col-sm-8 col-8">
                                    <label for="myEmail">Correo</label>
                                    <input type="text" class="form-control" id="correo" name="correo" value="${sessionScope.correo}" placeholder="Introduzca su correo" required />
                                    <span class="text-danger error-correo" id="error-correo">Formato incorrecto, introduce un mínimo de 2 y un máximo de 254 caracteres. Ejemplo: ejemplo@ejemplo.com</span>
                                    <span class="text-warning" id="errorCorreoRepetido">El correo ya existe.</span>
                                </div>
                                <div class="col-xl-4 col-lg-4 col-md-4 col-sm-8 col-8">
                                    <label for="numExpediente">Número de Expediente</label>
                                    <input type="text" class="form-control" id="noExpediente" value="${sessionScope.expediente}" name="noExpediente" placeholder="Introduce numero de expediente" />
                                    <span class="text-danger error-noExpediente" id="error-noExpediente">El formato no es correcto, deben ser 9 caracteres y solo los 3 primeros pueden empezar con letras.</span>
                                </div>
                            </div>

                            <!-- 4 -->
                            <div class="form-group row justify-content-center">
                                <div class="col-xl-4 col-lg-4 col-md-4 col-sm-8 col-8">
                                    <label for="telephoneNum">Teléfono</label>
                                    <input type="text" class="form-control" value="${sessionScope.telefono}" id="telefono" name="telefono" placeholder="Introduce teléfono"
                                           required />
                                    <span class="text-danger" id="error-tel">El formato no es correcto, deben ser 10 dígitos.</span>
                                </div>

                                <div class="col-xl-4 col-lg-4 col-md-4 col-sm-8 col-8">

                                    <label class="form-check-label" for="etapaClinica">Etapa Clínica</label>
                                    <div class="input-group">
                                        <input type="hidden" value="${sessionScope.etapaCli}" id="selectEtapa"/>
                                        <select class="form-control mt-2" id="etapaClinica" name="etapaClinica" >
                                            <option disabled selected>Seleccione etapa clínica</option>
                                            <c:forEach items="${etapas}" var="etapa">  
                                                <option value="<c:out value='${etapa.idEtapaClinica}'/>" ><c:out value='${etapa.nombre}'/> </option>
                                            </c:forEach>
                                        </select>
                                    </div>

                                </div>
                            </div>

                            <div class="form-group row justify-content-center">
                                <div class="col-xl-4 col-lg-4 col-md-4 col-sm-8 col-8">
                                    <label>Tipo de sangre</label>
                                    <input type="hidden" value="${sessionScope.tipoSangre}" id="selectSangre"/>
                                    <select class="form-control" id="tipoSangre" name="tipoSangre" >
                                        <option disabled selected>Seleccione tipo de sangre</option>
                                        <c:forEach items="${tipoSangre}" var="sangre">  
                                            <option value="<c:out value='${sangre.idTipoSangre}'/>" ><c:out value='${sangre.nombre}'/> </option>
                                        </c:forEach>                                             
                                    </select>
                                </div>
                                <div class="col-xl-4 col-lg-4 col-md-4 col-sm-8 col-8">
                                    <label for="myPRZ">PRZ</label>
                                    <input type="text" class="form-control" id="myPRZ" value="${sessionScope.prz}" readonly/>
                                </div>
                            </div>

                            <div class="row mb-3" id="error-datosRepetidos">
                                <div class="col-12 text-center">
                                    <span class="text-warning">Estás tratando de registrar datos existentes. <br> Revisa de nuevo.</span>
                                </div>
                            </div>

                            <!-- 5 -->
                            <div class="form-group row justify-content-center mt-4">
                                <div class="col-xl-4 col-lg-4 col-md-7 col-sm-5 col-10">
                                    <button type="button" class="btn btn-outline-success btn-block" id="guardarCambios" style="border-radius:20px">
                                        <i class="fas fa-save mr-1"></i>
                                        Guardar Cambios</button>
                                </div>
                            </div>


                            <!-- 6 -->
                            <div class="form-group row justify-content-center mt-3">
                                <div class="col-xl-4 col-lg-4 col-md-7 col-sm-5 col-10">
                                    <button type="button" class="btn btn-outline-info btn-block" id="btn-contraseña" style="border-radius:20px" data-toggle="modal"
                                            data-target="#modalCambiarContraseña">
                                        <i class="fas fa-key mr-1"></i>
                                        Cambiar Contraseña</button>
                                </div>
                            </div>

                            <div class="row justify-content-center">
                                <div class="col-8 text-center">
                                    <hr>
                                </div>
                            </div>

                            <div class="form-group row justify-content-center mt-4">
                                <div class="col-xl-4 col-lg-4 col-md-7 col-sm-5 col-10">
                                    <button type="button" class="btn btn-outline-danger btn-block" style="border-radius:20px" id="eliminarCuenta" >
                                        <i class="fas fa-trash-alt mr-1"></i>
                                        Eliminar Cuenta</button>

                                </div>

                        </form>

                    </div>
                </div>

            </div>

            <!-- ********** MODAL EDITAR CONTRASEÑA **********-->
            <div class="modal fade" id="modalCambiarContraseña" tabindex="-1" data-keyboard="false" data-backdrop="static" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Cambiar contraseña</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <div class="form-row">
                                <div class="form-group col-12">
                                    <label for="name">Contraseña</label>
                                    <div id="cambio1Contrasena" class="input-group-append bg-white">
                                        <input type="password" class="form-control" id="password" placeholder="Ingresa tu nueva contraseña" />
                                        <div class="input-group-text border-left-0 rounded-left bg-white"><i class="far fa-eye"></i></div>
                                    </div>
                                </div>
                            </div>
                            <div class="row" id="error-contrasena">
                                <div class="col-12">
                                    <span class="text-danger">La contraseña debe tener al menos 1 número, 1 letra minúscula, 1 mayúscula y una extensión de 8 a 14 caracteres.</span>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-12">
                                    <label for="name">Confirma tu contraseña</label>
                                    <div id="cambio2Contrasena" class="input-group-append bg-white">
                                        <input type="password" class="form-control" id="password2" placeholder="Reingresa tu nueva contraseña" />
                                        <div class="input-group-text border-left-0 rounded-left bg-white"><i class="far fa-eye"></i></div>
                                    </div>
                                </div>
                            </div>
                            <div class="row" id ="noEqualPasswordsError">
                                <div class="col-12">
                                    <span class="text-warning">Las contraseñas no son iguales.</span>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger passwordCleaner" style="border-radius: 20px" data-dismiss="modal">Cancelar</button>
                            <button type="button" class="btn btn-primary" id="btn-updatePassword" style="border-radius: 20px">Cambiar contraseña</button>
                        </div>
                    </div>
                </div>
            </div>
            <!-- ******* FIN MODAL EDITAR CONTRASEÑA ********-->

        </div>
        <script type="module" src="js/validacionesPaciente.js"></script> 
    </body>

</html>