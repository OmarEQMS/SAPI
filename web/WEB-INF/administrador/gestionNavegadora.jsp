<%-- 
    Document   : gestionNavegadora
    Created on : 15-nov-2018, 2:30:33
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

        <link rel="stylesheet" href="css/styleAdministrador.css">
        <script src="js/appAdministrador.js"></script>
        <script src="js/ajaxAdministrador.js"></script>

    </head>

    <body>

        <div class="wrapper">

            <!-- SIDEBAR -->
            <nav id="sidebar">

                <div class="sidebar-header">

<<<<<<< HEAD
                    <div class="row text-center justify-content-center mt-2">
                        <div class="col-12">
                            <img src="../img/logoSapi.png" style="width: 70%; display:block; margin:auto;" alt="">
                        </div>
||||||| merged common ancestors
                <div class="row text-center justify-content-center mt-2">
                    <div class="col-12">
                        <img src="../img/logoSapi.png" style="width: 70%; display:block; margin:auto;" alt="">
=======
                    <div class="row text-center justify-content-center mt-2">
                        <div class="col-12">
                            <img src="img/logoSapi.png" style="width: 70%; display:block; margin:auto;" alt="">
                        </div>
>>>>>>> origin/MontoyaRosas
                    </div>

                </div>

                <div class="profile">

<<<<<<< HEAD
                    <div class="row">
                        <div class="col-12 mb-2 mt-4">
                            <img src="../img/user.png" class="imagenPerfil" alt="">
                        </div>
||||||| merged common ancestors
                <div class="row">
                    <div class="col-12 mb-2 mt-4">
                        <img src="../img/user.png" class="imagenPerfil" alt="">
=======
                    <div class="row">
                        <div class="col-12 mb-2 mt-4">
                            <img src="img/user.png" class="imagenPerfil" alt="">
                        </div>
>>>>>>> origin/MontoyaRosas
                    </div>

<<<<<<< HEAD
                    <div class="row justify-content-center mb-2">
                        <div class="col-6 text-center">
                            <span class="textoSidebar m-0">Julio Badillo</span>
                            <span class="textoSidebar userSidebar m-0">@juliobadillo</span>
                        </div>
||||||| merged common ancestors
                <div class="row justify-content-center mb-2">
                    <div class="col-6 text-center">
                        <span class="textoSidebar m-0">Julio Badillo</span>
                        <span class="textoSidebar userSidebar m-0">@juliobadillo</span>
=======
                    <div class="row justify-content-center mb-2">
                        <div class="col-6 text-center">
                            <span class="textoSidebar m-0">${sessionScope.nombre} ${sessionScope.primerApellido}</span>
                            <span class="textoSidebar userSidebar m-0">@${sessionScope.usuario}</span>
                        </div>
>>>>>>> origin/MontoyaRosas
                    </div>

                    <div class="row justify-content-center">

                        <div class="col-2 text-center">
                            <a class="iconoSidebar" href="" title="Mi Cuenta"><i class="fas fa-cog"></i></a>
                        </div>

                        <div class="col-2">
                            <a class="iconoSidebar" href="" title="Cerrar Sesión"><i class="fas fa-power-off"></i></a>
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

                    <li id="irAInicioAdministrador"><a><i class="fas fa-home"></i>Inicio</a></li>

<<<<<<< HEAD
                    <li id="IrAGestionMedicos"><a><i class="fas fa-briefcase-medical"></i>Gestion médicos</a></li>
||||||| merged common ancestors
                <li id="IrAGestionNavegadora"><a><i class="fas fa-calendar-alt"></i>Gestion navegadoras</a></li>
=======
                    <li id="IrAGestionMedicos"><a><i class="fas fa-briefcase-medical"></i>Médicos</a></li>
>>>>>>> origin/MontoyaRosas

<<<<<<< HEAD
                    <li id="IrAGestionNavegadora"><a><i class="fas fa-calendar-alt"></i>Gestion navegadoras</a></li>
||||||| merged common ancestors
                <li id="IrAGestionPaciente"><a><i class="fas fa-users"></i>Gestion pacientes</a></li>
                
                <li id="IrAGestionAdministrador"><a><i class="fas fa-users"></i>Gestion administradores</a></li>
                
                <li id="IrAMiCuenta"><a><i class="fas fa-users"></i>Mi cuenta</a></li>
=======
                    <li id="IrAGestionNavegadora"><a><i class="fas fa-calendar-alt"></i>Navegadoras</a></li>
>>>>>>> origin/MontoyaRosas

<<<<<<< HEAD
                    <li id="IrAGestionPaciente"><a><i class="fas fa-users"></i>Gestion pacientes</a></li>
||||||| merged common ancestors
                <li id="IrAReasignarMedico"><a><i class="fas fa-sync"></i>Reasignar médico</a></li>
                                                
                <li id="salirCuenta"><a><i class="fas fa-sign-out-alt"></i>Cerrar sesión</a></li>
                
                
            </ul>
=======
                    <li id="IrAGestionPaciente"><a><i class="fas fa-users"></i>Pacientes</a></li>
>>>>>>> origin/MontoyaRosas

<<<<<<< HEAD
                    <li id="IrAGestionAdministrador"><a><i class="fas fa-users"></i>Gestion administradores</a></li>
||||||| merged common ancestors
        </nav>
=======
                    <li id="IrAGestionAdministrador"><a><i class="fas fa-shield-alt"></i>Administradores</a></li>
>>>>>>> origin/MontoyaRosas

<<<<<<< HEAD
                    <li id="IrAMiCuenta"><a><i class="fas fa-users"></i>Mi cuenta</a></li>
||||||| merged common ancestors
        <!-- CONTENIDO PRINCIPAL  -->
=======
                    <li id="IrAMiCuenta"><a><i class="far fa-user"></i>Mi cuenta</a></li>
>>>>>>> origin/MontoyaRosas

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

<<<<<<< HEAD
                        <span class="pull-right d-block"><span style="color:#6c6f80">Bienvenido, </span><span style="font-weight:700; color:#6c6f80;">Julio
                                Badillo
                            </span> <img src="../img/user.png" class="ml-2" style="width: 30px;" alt=""> </span>
||||||| merged common ancestors
            <!-- Gestion -->
=======
                        <span class="pull-right d-block"><span style="color:#6c6f80">Hola, </span><span style="font-weight:700; color:#6c6f80;">${sessionScope.nombre} ${sessionScope.primerApellido}
                            </span></span>
>>>>>>> origin/MontoyaRosas

                    </div>
                </nav>

                <!-- Navegacion -->

<<<<<<< HEAD
                <div class="row mb-3 justify-content-end">
                    <div class="col-3 text-center">
                        <span class="iconoHome mr-2"><i class="fas fa-home"></i></span><span><a href="./index2.html" class="colorMoradoLight">Inicio</a></span>
                        - <span class="colorGlobal">Gestion de Navegadoras</span>
||||||| merged common ancestors
                    <div class="row mb-3">
                        <div class="col-12">
                            <button class="btn btn-morado float-right" data-toggle="modal" data-target="#modalAgregarNavegadora"
                                style="border-radius:20px;"><i class="fas fa-plus-circle mr-2"></i>Agregar Navegadora</button>
                        </div>
=======
                <div class="row mb-3 justify-content-end">
                    <div class="col-3 text-center">
                        <span class="iconoHome mr-2"><i class="fas fa-home"></i></span><span><a id="IrAInicio" class="colorMoradoLight">Inicio</a></span>
                        - <span class="colorGlobal">Gestion de Navegadoras</span>
>>>>>>> origin/MontoyaRosas
                    </div>
                </div>

                <!-- Jumbotron Titulo -->

                <div class="jumbotron jumbotron-fluid p-2">
                    <div class="container">
                        <h1 class="display-4 tituloMisCitas text-center m-0">Gestión de Navegadoras</h1>
                    </div>
                </div>


                <!-- Gestion -->

                <div class="card mt-3">
                    <div class="card-body">

                        <!-- Boton agregar -->

                        <div class="row mb-3">
                            <div class="col-12">
                                <button class="btn btn-morado float-right" data-toggle="modal" data-target="#modalAgregarNavegadora"
                                        style="border-radius:20px;"><i class="fas fa-plus-circle mr-2"></i>Agregar Navegadora</button>
                            </div>
                        </div>

<<<<<<< HEAD
                        <!-- Table -->

                        <table class="table table-striped mt-3" id="tablaNavegadoras">
                            <thead>
                                <tr>
                                    <th scope="col">Nombre</th>
                                    <th scope="col">Correo</th>
                                    <th scope="col">Teléfono</th>
                                    <th scope="col">No. empleado</th>                                
                                    <th scope="col">Especialidad</th>
                                    <th scope="col">Cédula Profesional</th>
                                    <th scope="col">Acciones</th>
                                </tr>
                            </thead>
                            <tbody>

                                <c:forEach items="${ListaNavegadorasAdministrador}" var="navegadora">
                                    <tr>
                                        <td id="nombre-${navegadora.idEmpleado}" value="${navegadora.nombre}" > <c:out value="${navegadora.nombre} ${navegadora.primerApellido} ${navegadora.segundoApellido}"/> </td>
                                        <td id="correo-${navegadora.idEmpleado}" value="${navegadora.correo}" > <c:out value="${navegadora.correo}"/> </td>
                                        <td id="telefono-${navegadora.idEmpleado}" value="${navegadora.telefono}" > <c:out value="${navegadora.telefono}"/> </td>                                
                                        <td id="noEmpleado-${navegadora.idEmpleado}" value="${navegadora.noEmpleado}" > <c:out value="${navegadora.noEmpleado}"/> </td>                                                        
                                        <td id="nombreEspecialidad-${navegadora.idEmpleado}" value="${navegadora.nombreEspecialidad}" > <c:out value="${navegadora.nombreEspecialidad}"/> </td>                                
                                        <td id="cedulaProfesional-${navegadora.idEmpleado}" value="${navegadora.cedulaProfesional}" > <c:out value="${navegadora.cedulaProfesional}"/> </td>                              
                                        <td>
                                            <button class="btn btn-success m-1"
                                                    id="btn-verNavegadora" data-id="${navegadora.idEmpleado}">                                        
                                                <i class="fas fa-chart-line"></i>
                                            </button>
                                            <button class="btn btn-primary btn-editarNavegadora m-1" data-toggle="modal"
                                                    data-target="#modalEditarNavegadora" data-id="${navegadora.idEmpleado}" ><i class="fas fa-edit"></i>
                                            </button>
                                            <button class="btn btn-danger m-1" id="btn-eliminarNavegadora" data-id="${navegadora.idEmpleado}"><i class="fas fa-trash-alt">

                                                </i></button>
                                        </td>
                                    </tr>
                                </c:forEach>                           
                            </tbody>
                        </table>
                    </div>
                </div>
||||||| merged common ancestors
                            <input type="hidden" id="idNavegadora" value="">
=======
                        <!-- Table -->

                        <table class="table table-striped mt-3" id="tablaNavegadoras">
                            <thead>
                                <tr>
                                    <th scope="col">Nombre</th>
                                    <th scope="col">Correo</th>
                                    <th scope="col">Teléfono</th>
                                    <th scope="col">No. empleado</th>                                
                                    <th scope="col">Especialidad</th>
                                    <th scope="col">Cédula Profesional</th>
                                    <th scope="col">Usuario</th>
                                    <th scope="col">Acciones</th>
                                </tr>
                            </thead>
                            <tbody>

                                <c:forEach items="${ListaNavegadorasAdministrador}" var="navegadora">
                                    <tr>
                                        <td>${navegadora.nombre} ${navegadora.primerApellido} ${navegadora.segundoApellido}</td>                                
                                        <td>${navegadora.correo}</td>
                                        <td>${navegadora.telefono}</td>                                
                                        <td>${navegadora.noEmpleado}</td>
                                        <td>${navegadora.nombreEspecialidad}</td>                                
                                        <td>${navegadora.cedulaProfesional }</td>
                                        <td>${navegadora.usuario}</td>                                
                                        <td>
                                            <button class="btn btn-success m-1"
                                                    id="btn-verNavegadora" data-id="${navegadora.idEmpleado}">                                        
                                                <i class="fas fa-chart-line"></i>
                                            </button>
                                            <button class="btn btn-primary btn-editarNavegadora m-1" data-toggle="modal"
                                                    data-target="#modalEditarNavegadora" data-id="${navegadora.idEmpleado}" ><i class="fas fa-edit"></i>
                                            </button>
                                            <button class="btn btn-danger m-1" id="btn-eliminarNavegadora" data-id="${navegadora.idEmpleado}"><i class="fas fa-trash-alt"></i>
                                            </button>
                                        </td>
                                    </tr>
                                </c:forEach>                           
                            </tbody>
                        </table>
                    </div>
                </div>
>>>>>>> origin/MontoyaRosas

                <!-- ********** MODAL EDITAR NAVEGADORA ********** -->
                <div class="modal fade" id="modalEditarNavegadora" tabindex="-1" role="dialog" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">Editar Navegadora</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">

                                <input type="hidden" id="idNavegadora" value="">

                                <!-- FORMULARIO EDITAR NAVEGADORA -->
                                <div class="form-group row">
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-user"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="editar-nombreNavegadora"
                                                   placeholder="Nombre">
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-at"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="editar-correoNavegadora"
                                                   placeholder="Correo">
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-user"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="editar-primerApellidoNavegadora"
                                                   placeholder="Primer Apellido">
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-user"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="editar-segundoApellidoNavegadora"
                                                   placeholder="Segundo apellido">
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-phone"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="editar-telefonoNavegadora"
                                                   placeholder="Teléfono">
                                        </div>
                                    </div>

                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fab fa-slack-hash"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="editar-no-empleadoNavegadora"
                                                   placeholder="No. empleado">
                                        </div>
                                    </div>
                                </div>



<<<<<<< HEAD
                                <div class="form-group row">
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-user-graduate"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="editar-cedulaNavegadora"
                                                   placeholder="Cedula profesional">
||||||| merged common ancestors
                            <div class="form-group row">
                                <div class="col-6">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text"><i class="fas fa-user-graduate"></i></div>
=======
                                <div class="form-group row">
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-user-graduate"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="editar-especialidad" placeholder="Especialidad" list="listEspecialidades">
                                            <datalist id="listEspecialidades"></datalist>
>>>>>>> origin/MontoyaRosas
                                        </div>
                                    </div>
<<<<<<< HEAD
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-user-graduate"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="editar-especialidad" placeholder="Especialidad" list="listEspecialidades">
                                            <datalist id="listEspecialidades"></datalist>
||||||| merged common ancestors
                                </div>
                                <div class="col-6">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text"><i class="fas fa-id-card"></i></div>
=======
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-id-card"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="editar-usuario" placeholder="usuario">
>>>>>>> origin/MontoyaRosas
                                        </div>
                                    </div>
                                </div>

<<<<<<< HEAD
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-danger" data-dismiss="modal" style="border-radius: 20px;">Cancelar</button>
                                <button id="btn-guardarNavegadora" type="button" class="btn btn-primary" style="border-radius: 20px;">Guardar
                                    Cambios</button>
                            </div>
||||||| merged common ancestors
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger" data-dismiss="modal" style="border-radius: 20px;">Cancelar</button>
                            <button id="btn-guardarNavegadora" type="button"   data-dismiss="modal" class="btn btn-primary" style="border-radius: 20px;">Guardar
                                Cambios</button>
=======
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-danger" data-dismiss="modal" style="border-radius: 20px;">Cancelar</button>
                                <button id="btn-guardarNavegadora" type="button"   data-dismiss="modal" class="btn btn-primary" style="border-radius: 20px;">Guardar
                                    Cambios</button>
                            </div>
>>>>>>> origin/MontoyaRosas
                        </div>
                    </div>
                </div>

                <!-- ********** MODAL AGREGAR NAVEGADORA ********** -->
                <div class="modal fade" id="modalAgregarNavegadora" tabindex="-1" role="dialog" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">Agregar Navegadora</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">

                                <!-- FORMULARIO AGREGAR NAVEGADORA -->
                                <div class="form-group row">
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-user"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-nombreNavegadora"
                                                   placeholder="Nombre">
                                        </div>
                                    </div>

                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-phone"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-telefonoNavegadora"
                                                   placeholder="Telefono">
                                        </div>
                                    </div>

                                </div>

                                <div class="form-group row">
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-user"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-primerApellidoNavegadora"
                                                   placeholder="Primer Apellido">
                                        </div>
                                    </div>

                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-user"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-segundoApellidoNavegadora"
                                                   placeholder="Segundo Apellido">
                                        </div>
                                    </div>
                                </div>


                                <div class="form-group row">
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-at"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-correoNavegadora"
                                                   placeholder="Correo">
                                        </div>
                                    </div>

                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fab fa-slack-hash"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-noEmpleadoNavegadora"
                                                   placeholder="No. empleado">
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-user-graduate"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-especialidadNavegadora"
                                                   placeholder="Especialidad" list="listEspecialidades">
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-id-card"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-cedulaNavegadora"
                                                   placeholder="Cédula Profesional">
                                        </div>
                                    </div>
                                </div>

<<<<<<< HEAD
                                <div class="form-group row">
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-lock"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-passwordNavegadora"
                                                   placeholder="Contraseña">
||||||| merged common ancestors
                            <div class="form-group row">
                                <div class="col-6">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text"><i class="fas fa-lock"></i></div>
=======
                                <div class="form-group row">
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-lock"></i></div>
                                            </div>
                                            <input type="password" class="form-control" id="agregar-passwordNavegadora"
                                                   placeholder="Contraseña">
>>>>>>> origin/MontoyaRosas
                                        </div>
                                    </div>
<<<<<<< HEAD
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-lock"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-password2Navegadora"
                                                   placeholder="Confirmar contraseña">
||||||| merged common ancestors
                                </div>
                                <div class="col-6">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text"><i class="fas fa-lock"></i></div>
=======
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-lock"></i></div>
                                            </div>
                                            <input type="password" class="form-control" id="agregar-password2Navegadora"
                                                   placeholder="Confirmar contraseña">
>>>>>>> origin/MontoyaRosas
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group row justify-content-center">
                                    <div class="col-12 text-center">
                                        <button type="button" class="btn btn-morado-solid mt-2" data-dismiss="modal">Imprimir los términos y condiciones</button>
                                    </div>
                                </div>

                                <div class="form-group row justify-content-center">
                                    <div class="col-12 text-center">
                                        <div class="form-check">
                                            <input class="form-check-input" type="checkbox" id="autoSizingCheck2">
                                            <label class="form-check-label" for="autoSizingCheck2">
                                                La navegadora está informada y aceptó los términos y condiciones
                                            </label>
                                        </div>
                                    </div>
                                </div>

<<<<<<< HEAD
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-danger" style="border-radius:20px;" data-dismiss="modal">Cancelar</button>
                                <button id="btn-agregarNavegadora" type="button" class="btn btn-primary" style="border-radius:20px;">Agregar Navegadora</button>
                            </div>
||||||| merged common ancestors
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger" style="border-radius:20px;" data-dismiss="modal">Cancelar</button>
                            <button id="btn-agregarNavegadora" type="button" class="btn btn-primary" style="border-radius:20px;">Agregar Navegadora</button>
=======
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-danger clearAddNavegadoraModal" style="border-radius:20px;" data-dismiss="modal">Cancelar</button>
                                <button id="btn-agregarNavegadora" type="button" class="btn btn-primary" style="border-radius:20px;">Agregar Navegadora</button>
                            </div>
>>>>>>> origin/MontoyaRosas
                        </div>
                    </div>
                </div>


            </div>
        </div>

    </body>

</html>