<%-- 
    Document   : cuentaAdministrador
    Created on : 15-nov-2018, 2:38:27
    Author     : urieldiaz
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <%-- Hace rereferencia al conjunto de reglas --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <title>SAPI | Cuenta</title>
        <link rel="icon" href="img/logo-cancer.ico">


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

        <link rel="stylesheet" href="css/styleAdministrador.css">
        <script src="js/appAdministrador.js"></script>
        <script src="js/ajaxAdministrador.js"></script>


    </head>

    <body>

        <div class="cargandoGuardarCambios" id="loading-screen" style="display: none">
            <img src="img/loading.svg">
            <p class="clear">Guardando cambios, por favor espere...</p>
        </div>

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
                            <a class="iconoSidebar IrAMiCuenta" title="Mi Cuenta"><i class="fas fa-cog"></i></a>
                        </div>

                        <div class="col-2">
                            <a class="iconoSidebar salirCuenta" title="Cerrar Sesión"><i class="fas fa-power-off"></i></a> 
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

                    <li id="IrAGestionMedicos"><a><i class="fas fa-briefcase-medical"></i>Médicos</a></li>

                    <li id="IrAGestionNavegadora"><a><i class="fas fa-calendar-alt"></i>Navegadoras</a></li>

                    <li id="IrAGestionPaciente"><a><i class="fas fa-users"></i>Pacientes</a></li>

                    <li id="IrAGestionAdministrador"><a><i class="fas fa-shield-alt"></i>Administradores</a></li>

                    <li id="IrAMiCuenta"><a><i class="far fa-user"></i>Mi cuenta</a></li>

                    <li id="IrAReasignarMedico"><a><i class="fas fa-sync"></i>Reasignar médico</a></li>

                    <li id="salirCuenta"><a><i class="fas fa-sign-out-alt"></i>Cerrar sesión</a></li>

                </ul>

            </nav>

            <!-- CONTENIDO PRINCIPAL  -->

            <div id="content">

                <!-- MENU -->
                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <div class="container-fluid">

                        <button id="sidebarCollapse" class="btn boton-collapse">
                            <i class="fas fa-align-justify"></i>
                        </button>

                        <span class="pull-right d-block"><span style="color:#6c6f80">Hola, </span><span style="font-weight:700; color:#6c6f80;">${sessionScope.nombre} ${sessionScope.primerApellido}
                            </span></span>
                    </div>
                </nav>

                <!-- Navegacion -->


                <div class="row mb-3">
                    <div class="col-12 text-right">
                        <span class="iconoHome">
                            <i class="fas fa-home"></i>
                        </span>
                        <span>
                            <a class="colorMoradoLight">Administrador</a>
                        </span>
                        -
                        <span class="colorGlobal">Mi Cuenta</span>
                    </div>
                </div>

                <!-- Jumbotron Titulo -->
                <div class="jumbotron jumbotron-fluid p-2">
                    <div class="container">
                        <h1 class="display-4 tituloMisCitas text-center m-0">Mi cuenta</h1>
                    </div>
                </div>

                <!-- PENDIENTE -->
                <input type="hidden" id="idAdmin" value="${sessionScope.idCuenta}">

                <!-- Contenido del contenedor blanco -->
                <div class="card mt-3">
                    <div class="card-body">

                        <form>

                            <!-- Imagen -->
                            <div class="form-group row justify-content-center">
                                <div class="col-12 text-center">
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


                            <!-- 4 -->
                            <div class="form-group row justify-content-center">
                                <div class="col-8">
                                    <label for="username">No. Empleado</label>
                                    <input type="text" class="form-control" id="username" name="username" value="${sessionScope.usuario}" readonly/>
                                    <span class="text-danger error-usuario" id="error-usuario">Formato incorrecto</span>
                                </div>

                                <div class="col-8">
                                    <span class="text-danger error-usuario" id="error-usuario">Formato incorrecto</span>
                                    <span class="text-warning error-usuarioRepetido">El usuario ya existe</span>
                                </div>

                            </div>



                            <!-- 4 -->
                            <div class="form-group row justify-content-center">
                                <div class="col-8">
                                    <label for="correo">Correo</label>
                                    <input type="text" class="form-control" id="correo" name="correo" value="${sessionScope.correo}"/>

                                </div>

                                <div class="col-8">

                                    <span class="text-danger error-correo" id="error-usuario">El formato no es correcto, introduce un mínimo de 2 y un máximo de 254 caracteres. Ejemplo: ejemplo@ejemplo.com</span>
                                    <span class="text-warning error-correoRepetido">El correo ya existe</span>

                                </div>

                            </div>



                            <!-- 6 -->
                            <div class="form-group row justify-content-center mt-4">
                                <div class="col-xl-4 col-lg-4 col-md-4 col-sm-4 col-12">
                                    <button type="button" class="btn btn-outline-success btn-block truncate" style="border-radius:20px" id="guardarCambios"><i class="fas fa-save mr-1"></i>
                                        Guardar Cambios</button>
                                </div>
                            </div>

                        </form>


                        <!-- 7 -->
                        <div class="form-group row justify-content-center mt-3">
                            <div class="col-xl-4 col-lg-4 col-md-4 col-sm-4 col-12">
                                <button type="button" class="btn btn-outline-info btn-block truncate" id="btn-contraseña" style="border-radius:20px" data-toggle="modal"
                                        data-target="#modalCambiarContraseña"><i class="fas fa-key mr-1"></i>
                                    Cambiar Contraseña</button>
                            </div>
                        </div>

                        <!-- ********** MODAL EDITAR CONTRASEÑA **********-->
                        <div class="modal fade" data-keyboard="false" data-backdrop="static" id="modalCambiarContraseña" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog modal-dialog-centered" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">Cambiar contraseña</h5>
                                        <button type="button" class="close cleanerModal" data-dismiss="modal" aria-label="Close">
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
                                        <div class="row" id="noEqualPasswordsError">
                                            <div class="col-12">
                                                <span class="text-warning">Las contraseñas no son iguales.</span>
                                            </div>
                                        </div>

                                    </div>
                                    <div class="modal-footer">

                                        <button type="button" class="btn btn-danger cleanerModal" style="border-radius: 20px"  data-dismiss="modal">Cancelar</button>
                                        <button type="button" class="btn btn-primary" id="btn-updatePassword" style="border-radius: 20px" >Cambiar contraseña</button>

                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- ******* FIN MODAL EDITAR CONTRASEÑA ********-->


                    </div>

                </div>

            </div>
        </div>



    </body>

</html>