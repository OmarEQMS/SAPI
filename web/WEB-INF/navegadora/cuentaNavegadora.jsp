<%-- 
    Document   : cuentaNavegadora
    Created on : 31-oct-2018, 11:51:06
    Author     : urieldiaz, julioguzman, shannonrosas
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <%-- Hace rereferencia al conjunto de reglas --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>SAPI | Inicio</title>

    <link href="lib/bootstrap/css/bootstrap.css" rel="stylesheet"/>
    <link href="lib/fontawesome/css/all.css" rel="stylesheet"/>
    <link href='lib/fullcalendar/fullcalendar.css' rel='stylesheet'/>
    <link href="lib/tooltipster/dist/css/tooltipster.bundle.min.css" rel="stylesheet" />
    <link href="lib/tooltipster/dist/css/plugins/tooltipster/sideTip/themes/tooltipster-sideTip-shadow.min.css" rel="stylesheet" />
    <link href="lib/datatables/datatables.min.css" rel="stylesheet" type="text/css"/> 
    <script src="lib/jquery/jquery-3.3.1.js" type="application/javascript"></script>
    <script src="lib/jquery/jqueryPostGo.js" type="application/javascript"></script>
    <script src="lib/popper/popper.min.js" type="application/javascript"></script>
    <script src="lib/bootstrap/js/bootstrap.js" type="application/javascript"></script> 
    <script src='lib/moment/moment.min.js' type="application/javascript" ></script>
    <script src='lib/fullcalendar/fullcalendar.js' type="application/javascript"></script>
    <script src="lib/fullcalendar/locale-all.js"></script>
    <script src="lib/sweetalert/dist/sweetalert.min.js"></script>
    <script src="lib/tooltipster/dist/js/tooltipster.bundle.min.js" type="text/javascript" ></script>
    <script src="lib/datatables/datatables.min.js" type="text/javascript"></script>


    <link rel="stylesheet" href="css/styleNavegadora.css">
    <link rel="stylesheet" href="css/styleNavegadoraImg.css">
    <script src="js/appNavegadora.js"></script>    
    <script src="js/ajaxNavegadora.js"></script>
    <script src="js/validacionesNavegadora.js"></script>

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
                        <a class="iconoSidebar" href="" title="Mi Cuenta"><i class="fas fa-cog"></i></a>
                    </div>

                    <div class="col-2">
                        <a class="iconoSidebar" href="" title="Cerrar Sesión" id="salirCuenta2"><i class="fas fa-power-off"></i></a>
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

                <li id="irADashboard"><a><i class="fas fa-home"></i>Inicio</a></li>

                <li id="idACalendario"><a><i class="fas fa-calendar-alt"></i>Calendario</a></li>
                <li id="irARendimiento"><a><i class="fas fa-chart-line"></i>Mi Rendimiento</a></li>

                <li id="irACuenta"><a><i class="far fa-user"></i>Mi Cuenta</a></li>
                
                <li id="irADocumentos"><a><i class="far fa-user"></i>Documentos</a></li>
                
                <li id="salirCuenta"><a><i class="fas fa-sign-out-alt"></i>Cerrar Sesión</a></li>
                

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

                    <span class="pull-right d-block"><span style="color:#6c6f80">Bienvenido, </span><span style="font-weight:700; color:#6c6f80;">${sessionScope.nombre} ${sessionScope.primerApellido}
                            
                        </span> <img src="img/user.png" class="ml-2" style="width: 30px;" alt=""> </span>

                </div>
            </nav>

            <!-- **************************************************************** -->
            <!-- ***** A PARTIR DE AQUI ESCRIBEN EL CODIGO QUE QUIERAN..... ***** -->
            <!-- **************************************************************** -->

            <div class="row mb-3 justify-content-end">
                <div class="col-3 text-center">
                    <span class="iconoHome mr-2" id="irVerForm"><i class="fas fa-home"></i></span><span><a href="index.html" class="colorMoradoLight">Inicio</a></span>
                    - <span class="colorGlobal">Mi Cuenta</span>
                </div>
            </div>

            <!-- Jumbotron Titulo -->

            <div class="jumbotron jumbotron-fluid p-2">
                <div class="container">
                    <h1 class="display-4 tituloPacientes text-center m-0">Mi cuenta</h1>
                </div>
            </div>

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
                            </div>
                        </div>

                        <!-- 1 -->
                        <div class="form-group row justify-content-center">
                            <div class="col-4">
                                <label for="name">Nombre</label>
                                <input type="text" class="form-control" id="name" value="${sessionScope.nombre}" readonly/>
                            </div>
                            <div class="col-4">
                                <label for="employeeNumber">Número de empleado</label>
                                <input type="text" class="form-control" id="employeeNumber" value="${sessionScope.noEmpleado}" readonly/>
                            </div>
                        </div>

                        <!-- 2 -->
                        <div class="form-group row justify-content-center">
                            <div class="col-4">
                                <label for="surname1">Primer Apellido</label>
                                <input type="text" class="form-control" id="surname1" value="${sessionScope.primerApellido}" readonly/>
                            </div>
                            <div class="col-4">
                                <label for="specialty">Especialidad</label>
                                <input type="text" class="form-control" id="specilaty" value="${sessionScope.especialidad}" readonly/>
                            </div>
                        </div>

                        <!-- 3 -->
                        <div class="form-group row justify-content-center">
                            <div class="col-4">
                                <label for="surname2">Segundo Apellido</label>
                                <input type="text" class="form-control" id="surname2" value="${sessionScope.segundoApellido}" readonly/>
                            </div>
                            <div class="col-4">
                                <label for="profesionalLic">Cédula profesional</label>
                                <input type="text" class="form-control" id="profesionalLic" value="${sessionScope.cedulaProfesional}" readonly/>
                            </div>
                        </div>

                        <!-- 4 -->
                        <div class="form-group row justify-content-center">
                            <div class="col-4">
                                <label for="username">Usuario</label>
                                <input type="text" class="form-control" id="username" value="${sessionScope.usuario}" readonly/>
                            </div>
                            <div class="col-4">
                                <label for="telephoneNum">Teléfono</label>
                                <input name="telefono" type="tel" class="form-control" id="telefono" pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" placeholder="123-456-7890"
                                    value="${sessionScope.telefono}" required />
                                 <span class="text-danger" id="error-telefono">El formato no es correcto, deben ser 10 dígitos.</span>
                            </div>
                        </div>

                        <!-- 5 -->
                        <div class="form-group row justify-content-center">
                            <div class="col-8">
                                <label for="myEmail">Correo</label>
                                <input name="correo" type="email" class="form-control" id="correo" value="${sessionScope.correo}" placeholder="Introduzca su correo" required
                                    pattern="[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*@[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*[.][a-zA-Z]{1,5}"
                                />
                                 <span class="text-danger error-correo" id="error-correo">Formato incorrecto</span>
                               
                            </div>                           
                        </div>

                        <!-- 6 -->
                        <div class="form-group row justify-content-center mt-4">
                            <div class="col-4">
                                <button type="button" class="btn btn-outline-success btn-block" style="border-radius:20px" id="guardarCambios"><i class="fas fa-save mr-1"></i>
                                    Guardar Cambios</button>
                            </div>
                        </div>


                        <!-- 7 -->
                        <div class="form-group row justify-content-center mt-3">
                            <div class="col-4">
                                <button type="button" class="btn btn-outline-info btn-block" id="btn-contraseña" style="border-radius:20px" data-toggle="modal"
                                    data-target="#modalCambiarContraseña"><i class="fas fa-key mr-1"></i>
                                    Cambiar Contraseña</button>
                            </div>
                        </div>

                        <div class="row justify-content-center">
                            <div class="col-8 text-center">
                                <hr>
                            </div>
                        </div>


                    </form>

                </div>
            </div>

        </div>

        <!-- ********** MODAL EDITAR CONTRASEÑA **********-->
        <div class="modal fade" id="modalCambiarContraseña" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
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
                                <input type="password" class="form-control" id="password" placeholder="Ingresa tu nueva contraseña" />
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-12">
                                <label for="name">Confirma tu contraseña</label>
                                <input type="password" class="form-control" id="password-confirm" placeholder="Reingresa tu nueva contraseña" />
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" style="border-radius: 20px"  data-dismiss="modal">Cancelar</button>
                        <button type="button" class="btn btn-primary" id="btn-updatePassword" style="border-radius: 20px" >Cambiar contraseña</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- ******* FIN MODAL EDITAR CONTRASEÑA ********-->

    </div>

</body>

</html>
