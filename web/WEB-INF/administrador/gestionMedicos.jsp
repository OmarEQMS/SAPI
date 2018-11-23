<%-- 
    Document   : gestionMedicos
    Created on : 13-nov-2018, 21:39:52
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
        <script rel="stylesheet" href="lib/jquery/jquery-ui.min.js"></script>
        <link rel="stylesheet" href="lib/jquery/jquery-ui.css">
        <link rel="stylesheet" href="lib/jquery/jquery-ui.min.css">
        <script src="js/appAdministrador.js"></script>
        <script src="js/ajaxAdministrador.js"></script>
        <script src="js/autocomplete.js"></script>

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
<<<<<<< HEAD
||||||| merged common ancestors
                </div>
=======

                </div>
>>>>>>> origin/MontoyaRosas

<<<<<<< HEAD
                </div>
||||||| merged common ancestors
            </div>
=======
                <div class="profile">
>>>>>>> origin/MontoyaRosas

<<<<<<< HEAD
                <div class="profile">
||||||| merged common ancestors
            <div class="profile">
=======
                    <div class="row">
                        <div class="col-12 mb-2 mt-4">
                            <img src="img/user.png" class="imagenPerfil" alt="">
                        </div>
                    </div>
>>>>>>> origin/MontoyaRosas

<<<<<<< HEAD
                    <div class="row">
                        <div class="col-12 mb-2 mt-4">
                            <img src="img/user.png" class="imagenPerfil" alt="">
                        </div>
||||||| merged common ancestors
                <div class="row">
                    <div class="col-12 mb-2 mt-4">
                        <img src="img/user.png" class="imagenPerfil" alt="">
=======
                    <div class="row justify-content-center mb-2">
                        <div class="col-6 text-center">
                            <span class="textoSidebar m-0">${sessionScope.nombre} ${sessionScope.primerApellido}</span>
                            <span class="textoSidebar userSidebar m-0">@${sessionScope.usuario}</span>
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
                    <div class="row justify-content-center">

                        <div class="col-2 text-center">
                            <a class="iconoSidebar" href="" title="Mi Cuenta"><i class="fas fa-cog"></i></a>
                        </div>

                        <div class="col-2">
                            <a class="iconoSidebar" href="" title="Cerrar Sesión"><i class="fas fa-power-off"></i></a>
                        </div>

>>>>>>> origin/MontoyaRosas
                    </div>
<<<<<<< HEAD
||||||| merged common ancestors
                </div>
=======

                </div>
>>>>>>> origin/MontoyaRosas

<<<<<<< HEAD
                    <div class="row justify-content-center">

                        <div class="col-2 text-center">
                            <a class="iconoSidebar" href="" title="Mi Cuenta"><i class="fas fa-cog"></i></a>
                        </div>

                        <div class="col-2">
                            <a class="iconoSidebar" href="" title="Cerrar Sesión"><i class="fas fa-power-off"></i></a>
                        </div>
||||||| merged common ancestors
                <div class="row justify-content-center">

                    <div class="col-2 text-center">
                        <a class="iconoSidebar" href="" title="Mi Cuenta"><i class="fas fa-cog"></i></a>
                    </div>
=======
                <div class="row justify-content-center">
                    <div class="col-12 text-center">
                        <hr style="background-color:white !important">
                    </div>
                </div>
>>>>>>> origin/MontoyaRosas

<<<<<<< HEAD
                    </div>
||||||| merged common ancestors
                    <div class="col-2">
                        <a class="iconoSidebar" href="" title="Cerrar Sesión"><i class="fas fa-power-off"></i></a>
                    </div>
=======
                <!-- MENU PRINCIPAL ENLACES -->
                <ul class="list-unstyled components">
>>>>>>> origin/MontoyaRosas

                    <li id="irAInicioAdministrador"><a><i class="fas fa-home"></i>Inicio</a></li>

<<<<<<< HEAD
                <div class="row justify-content-center">
                    <div class="col-12 text-center">
                        <hr style="background-color:white !important">
                    </div>
                </div>
||||||| merged common ancestors
            </div>

            <div class="row justify-content-center">
                <div class="col-12 text-center">
                    <hr style="background-color:white !important">
                </div>
            </div>

            <!-- MENU PRINCIPAL ENLACES -->
            <ul class="list-unstyled components">
=======
                    <li id="IrAGestionMedicos"><a><i class="fas fa-briefcase-medical"></i>Médicos</a></li>

                    <li id="IrAGestionNavegadora"><a><i class="fas fa-calendar-alt"></i>Navegadoras</a></li>

                    <li id="IrAGestionPaciente"><a><i class="fas fa-users"></i>Pacientes</a></li>
>>>>>>> origin/MontoyaRosas

<<<<<<< HEAD
                <!-- MENU PRINCIPAL ENLACES -->
                <ul class="list-unstyled components">
||||||| merged common ancestors
                <li id="irAInicioAdministrador"><a><i class="fas fa-home"></i>Inicio</a></li>
                                
                <li id="IrAGestionMedicos"><a><i class="fas fa-briefcase-medical"></i>Gestion médicos</a></li>
=======
                    <li id="IrAGestionAdministrador"><a><i class="fas fa-shield-alt"></i>Administradores</a></li>
>>>>>>> origin/MontoyaRosas

<<<<<<< HEAD
                    <li id="irAInicioAdministrador"><a><i class="fas fa-home"></i>Inicio</a></li>
||||||| merged common ancestors
                <li id="IrAGestionNavegadora"><a><i class="fas fa-calendar-alt"></i>Gestion navegadoras</a></li>
=======
                    <li id="IrAMiCuenta"><a><i class="far fa-user"></i>Mi cuenta</a></li>
>>>>>>> origin/MontoyaRosas

<<<<<<< HEAD
                    <li id="IrAGestionMedicos"><a><i class="fas fa-briefcase-medical"></i>Gestion médicos</a></li>
||||||| merged common ancestors
                <li id="IrAGestionPaciente"><a><i class="fas fa-users"></i>Gestion pacientes</a></li>
                
                <li id="IrAGestionAdministrador"><a><i class="fas fa-users"></i>Gestion administradores</a></li>
                
                <li id="IrAMiCuenta"><a><i class="fas fa-users"></i>Mi cuenta</a></li>
=======
                    <li id="IrAReasignarMedico"><a><i class="fas fa-sync"></i>Reasignar médico</a></li>
>>>>>>> origin/MontoyaRosas

<<<<<<< HEAD
                    <li id="IrAGestionNavegadora"><a><i class="fas fa-calendar-alt"></i>Gestion navegadoras</a></li>
||||||| merged common ancestors
                <li id="IrAReasignarMedico"><a><i class="fas fa-sync"></i>Reasignar médico</a></li>
                                                
                <li id="salirCuenta"><a><i class="fas fa-sign-out-alt"></i>Cerrar sesión</a></li>
                
            </ul>
=======
                    <li id="salirCuenta"><a><i class="fas fa-sign-out-alt"></i>Cerrar sesión</a></li>
>>>>>>> origin/MontoyaRosas

<<<<<<< HEAD
                    <li id="IrAGestionPaciente"><a><i class="fas fa-users"></i>Gestion pacientes</a></li>
||||||| merged common ancestors
        </nav>
=======
                </ul>
>>>>>>> origin/MontoyaRosas

<<<<<<< HEAD
                    <li id="IrAGestionAdministrador"><a><i class="fas fa-users"></i>Gestion administradores</a></li>
||||||| merged common ancestors
        <!-- CONTENIDO PRINCIPAL  -->
=======
            </nav>
>>>>>>> origin/MontoyaRosas

<<<<<<< HEAD
                    <li id="IrAMiCuenta"><a><i class="fas fa-users"></i>Mi cuenta</a></li>
||||||| merged common ancestors
        <div id="content">
=======
            <!-- CONTENIDO PRINCIPAL  -->
>>>>>>> origin/MontoyaRosas

<<<<<<< HEAD
                    <li id="IrAReasignarMedico"><a><i class="fas fa-sync"></i>Reasignar médico</a></li>
||||||| merged common ancestors
            <!-- MENU -->
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">
=======
            <div id="content">
>>>>>>> origin/MontoyaRosas

<<<<<<< HEAD
                    <li id="salirCuenta"><a><i class="fas fa-sign-out-alt"></i>Cerrar sesión</a></li>
||||||| merged common ancestors
                    <button id="sidebarCollapse" class="btn boton-collapse">
                        <i class="fas fa-align-justify"></i>
                    </button>
=======
                <!-- MENU -->
                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <div class="container-fluid">
>>>>>>> origin/MontoyaRosas

<<<<<<< HEAD
                </ul>
||||||| merged common ancestors
                    <span class="pull-right d-block"><span style="color:#6c6f80">Bienvenido, </span><span style="font-weight:700; color:#6c6f80;">Julio
                            Badillo
                        </span> <img src="img/user.png" class="ml-2" style="width: 30px;" alt=""> </span>
=======
                        <button id="sidebarCollapse" class="btn boton-collapse">
                            <i class="fas fa-align-justify"></i>
                        </button>
>>>>>>> origin/MontoyaRosas

<<<<<<< HEAD
            </nav>
||||||| merged common ancestors
                </div>
            </nav>
=======
                        <span class="pull-right d-block"><span style="color:#6c6f80">Hola, </span><span style="font-weight:700; color:#6c6f80;">${sessionScope.nombre} ${sessionScope.primerApellido}
                            </span></span>
>>>>>>> origin/MontoyaRosas

<<<<<<< HEAD
            <!-- CONTENIDO PRINCIPAL  -->
||||||| merged common ancestors
            <!-- Navegacion -->
=======
                    </div>
                </nav>

                <!-- Navegacion -->
>>>>>>> origin/MontoyaRosas

<<<<<<< HEAD
            <div id="content">
||||||| merged common ancestors
            <div class="row mb-3 justify-content-end">
                <div class="col-3 text-center">
                    <span class="iconoHome mr-2"><i class="fas fa-home"></i></span><span><a href="./index2.html" class="colorMoradoLight">Inicio</a></span>
                    - <span class="colorGlobal">Gestion de Médicos</span>
                </div>
            </div>
=======
                <div class="row mb-3 justify-content-end">
                    <div class="col-3 text-center">
                        <span class="iconoHome mr-2"><i class="fas fa-home"></i></span><span><a id="IrAInicio" class="colorMoradoLight">Inicio</a></span>
                        - <span class="colorGlobal">Gestion de Médicos</span>
                    </div>
                </div>
>>>>>>> origin/MontoyaRosas

<<<<<<< HEAD
                <!-- MENU -->
                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <div class="container-fluid">
||||||| merged common ancestors
            <!-- Jumbotron Titulo -->
=======
                <!-- Jumbotron Titulo -->
>>>>>>> origin/MontoyaRosas

<<<<<<< HEAD
                        <button id="sidebarCollapse" class="btn boton-collapse">
                            <i class="fas fa-align-justify"></i>
                        </button>
||||||| merged common ancestors
            <div class="jumbotron jumbotron-fluid p-2">
                <div class="container">
                    <h1 class="display-4 tituloMisCitas text-center m-0">Gestión de Médicos</h1>
                </div>
            </div>
=======
                <div class="jumbotron jumbotron-fluid p-2">
                    <div class="container">
                        <h1 class="display-4 tituloMisCitas text-center m-0">Gestión de Médicos</h1>
                    </div>
                </div>
>>>>>>> origin/MontoyaRosas

                        <span class="pull-right d-block"><span style="color:#6c6f80">Bienvenido, </span><span style="font-weight:700; color:#6c6f80;">Julio
                                Badillo
                            </span> <img src="img/user.png" class="ml-2" style="width: 30px;" alt=""> </span>

<<<<<<< HEAD
                    </div>
                </nav>
||||||| merged common ancestors
            <!-- Gestion -->

            <div class="card mt-3">
                <div class="card-body">
=======
                <!-- Gestion -->

                <div class="card mt-3">
                    <div class="card-body">
>>>>>>> origin/MontoyaRosas

<<<<<<< HEAD
                <!-- Navegacion -->
||||||| merged common ancestors
                    <!-- Boton agregar -->
=======
                        <!-- Boton agregar -->
>>>>>>> origin/MontoyaRosas

<<<<<<< HEAD
                <div class="row mb-3 justify-content-end">
                    <div class="col-3 text-center">
                        <span class="iconoHome mr-2"><i class="fas fa-home"></i></span><span><a href="./index2.html" class="colorMoradoLight">Inicio</a></span>
                        - <span class="colorGlobal">Gestion de Médicos</span>
                    </div>
                </div>
||||||| merged common ancestors
                    <div class="row mb-3">
                        <div class="col-12">
                            <button class="btn btn-morado float-right" style="border-radius:20px" data-toggle="modal"
                                data-target="#modalAgregarMedico"><i class="fas fa-plus-circle mr-2"></i>Agregar Médico</button>
                        </div>
                    </div>
=======
                        <div class="row mb-3">
                            <div class="col-12">
                                <button class="btn btn-morado float-right" style="border-radius:20px" data-toggle="modal"
                                        data-target="#modalAgregarMedico"><i class="fas fa-plus-circle mr-2"></i>Agregar Médico</button>
                            </div>
                        </div>
>>>>>>> origin/MontoyaRosas

<<<<<<< HEAD
                <!-- Jumbotron Titulo -->

                <div class="jumbotron jumbotron-fluid p-2">
                    <div class="container">
                        <h1 class="display-4 tituloMisCitas text-center m-0">Gestión de Médicos</h1>
                    </div>
||||||| merged common ancestors
                    <!-- Table -->

                    <table class="table table-striped mt-3" id="tablaMedicos">
                        <thead>
                            <tr>
                                <th scope="col">Nombre</th>                                
                                <th scope="col">Correo</th>
                                <th scope="col">Teléfono</th>
                                <th scope="col">No. Empledo</th>
                                <th scope="col">Especialidad</th>
                                <th scope="col">Cédula Profesional</th>
                                <th scope="col">Usuario</th>                                
                                <th scope="col">Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            
                            <c:forEach items="${ListaMedicosAdmistrador}" var="medico">
                            <tr>
                                <td>${medico.nombre} ${medico.primerApellido} ${medico.segundoApellido}</td>                                
                                <td>${medico.correo}</td>
                                <td>${medico.telefono}</td>                                
                                <td>${medico.noEmpleado}</td>
                                <td>${medico.nombreEspecialidad}</td>                                
                                <td>${medico.cedulaProfesional }</td>
                                <td>${medico.usuario}</td>                                
                                <td>
                                    <button class="btn btn-primary btn-editarMedico" data-toggle="modal" data-id="${medico.idEmpleado}" data-target="#modalEditarMedico"><i
                                            class="fas fa-edit"></i></button>
                                    <button class="btn btn-danger" id="btn-eliminarMedico" data-id="${medico.idEmpleado}"><i 
                                            class="fas fa-trash-alt"></i></button>
                                </td>
                            </tr>
                            </c:forEach>                            
                        
                        </tbody>
                    </table>
=======
                        <!-- Table -->

                        <table class="table table-striped mt-3" id="tablaMedicos">
                            <thead>
                                <tr>
                                    <th scope="col">Nombre</th>                                
                                    <th scope="col">Correo</th>
                                    <th scope="col">Teléfono</th>
                                    <th scope="col">No. Empledo</th>
                                    <th scope="col">Especialidad</th>
                                    <th scope="col">Cédula Profesional</th>
                                    <th scope="col">Usuario</th>                                
                                    <th scope="col">Acciones</th>
                                </tr>
                            </thead>
                            <tbody>

                                <c:forEach items="${ListaMedicosAdmistrador}" var="medico">
                                    <tr>
                                        <td>${medico.nombre} ${medico.primerApellido} ${medico.segundoApellido}</td>                                
                                        <td>${medico.correo}</td>
                                        <td>${medico.telefono}</td>                                
                                        <td>${medico.noEmpleado}</td>
                                        <td>${medico.nombreEspecialidad}</td>                                
                                        <td>${medico.cedulaProfesional }</td>
                                        <td>${medico.usuario}</td>                                
                                        <td>
                                            <button class="btn btn-primary btn-editarMedico m-1" data-toggle="modal" data-id="${medico.idEmpleado}" data-target="#modalEditarMedico"><i
                                                    class="fas fa-edit"></i></button>
                                            <button class="btn btn-danger" id="btn-eliminarMedico m-1" data-id="${medico.idEmpleado}"><i 
                                                    class="fas fa-trash-alt"></i></button>
                                        </td>
                                    </tr>
                                </c:forEach>                            

                            </tbody>
                        </table>
                    </div>
>>>>>>> origin/MontoyaRosas
                </div>
<<<<<<< HEAD

||||||| merged common ancestors
            </div>

            <!-- ********** MODAL EDITAR MEDICO ********** -->
            <div class="modal fade" id="modalEditarMedico" tabindex="-1" role="dialog" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">Editar Médico</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
=======
>>>>>>> origin/MontoyaRosas

<<<<<<< HEAD
                <!-- Gestion -->

                <div class="card mt-3">
                    <div class="card-body">

                        <!-- Boton agregar -->

                        <div class="row mb-3">
                            <div class="col-12">
                                <button class="btn btn-morado float-right" style="border-radius:20px" data-toggle="modal"
                                        data-target="#modalAgregarMedico"><i class="fas fa-plus-circle mr-2"></i>Agregar Médico</button>
                            </div>
                        </div>
||||||| merged common ancestors
                            <input type="hidden" id="idMedico" value="">

                            <!-- FORMULARIO EDITAR MEDICO -->
                            <div class="form-group row">
                                <div class="col-12">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fas fa-user"></i>
                                            </div>
                                        </div>
                                        <input type="text" id="editar-nombreMedico" class="form-control" value="Julio">
                                    </div>
                                </div>
                            </div>
=======
                <!-- ********** MODAL EDITAR MEDICO ********** -->
                <div class="modal fade" id="modalEditarMedico" tabindex="-1" role="dialog" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">Editar Médico</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">

                                <input type="hidden" id="idMedico" value="">

                                <!-- FORMULARIO EDITAR MEDICO -->
                                <div class="form-group row">
                                    <div class="col-12">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text">
                                                    <i class="fas fa-user"></i>
                                                </div>
                                            </div>
                                            <input type="text" id="editar-nombreMedico" class="form-control" value="Julio">
                                        </div>
                                    </div>
                                </div>
>>>>>>> origin/MontoyaRosas

<<<<<<< HEAD
                        <!-- Table -->

                        <table class="table table-striped mt-3" id="tablaMedicos">
                            <thead>
                                <tr>
                                    <th scope="col">Nombre</th>                                
                                    <th scope="col">Correo</th>
                                    <th scope="col">Teléfono</th>
                                    <th scope="col">No. Empledo</th>
                                    <th scope="col">Especialidad</th>
                                    <th scope="col">Cédula Profesional</th>
                                    <th scope="col">Acciones</th>
                                </tr>
                            </thead>
                            <tbody>

                                <c:forEach items="${ListaMedicosAdmistrador}" var="medico">
                                    <tr>
                                        <td id="nombre-${medico.idEmpleado}" value="${medico.nombre}" > <c:out value="${medico.nombre} ${medico.primerApellido} ${medico.segundoApellido}"/> </td>
                                        <td id="correo-${medico.idEmpleado}" value="${medico.correo}" > <c:out value="${medico.correo}"/> </td>
                                        <td id="telefono-${medico.idEmpleado}" value="${medico.telefono}" > <c:out value="${medico.telefono}"/> </td>                                
                                        <td id="noEmpleado-${medico.idEmpleado}" value="${medico.noEmpleado}" > <c:out value="${medico.noEmpleado}"/> </td>                                                        
                                        <td id="nombreEspecialidad-${medico.idEmpleado}" value="${medico.nombreEspecialidad}" > <c:out value="${medico.nombreEspecialidad}"/> </td>                                
                                        <td id="cedulaProfesional-${medico.idEmpleado}" value="${medico.cedulaProfesional}" > <c:out value="${medico.cedulaProfesional}"/> </td>

                                        <td>
                                            <button class="btn btn-primary btn-editarMedico" data-toggle="modal" data-id="${medico.idEmpleado}" data-target="#modalEditarMedico"><i
                                                    class="fas fa-edit"></i></button>
                                            <button class="btn btn-danger" id="btn-eliminarMedico" data-id="${medico.idEmpleado}"><i 
                                                    class="fas fa-trash-alt"></i></button>
                                        </td>
                                    </tr>
                                </c:forEach>                            

                            </tbody>
                        </table>
                    </div>
                </div>
||||||| merged common ancestors
                            <div class="form-group row">
                                <div class="col-6">
=======
                                <div class="form-group row">
                                    <div class="col-6">
>>>>>>> origin/MontoyaRosas

<<<<<<< HEAD
                <!-- ********** MODAL EDITAR MEDICO ********** -->
                <div class="modal fade" id="modalEditarMedico" tabindex="-1" role="dialog" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">Editar Médico</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">

                                <input type="hidden" id="idMedico" value="">

                                <!-- FORMULARIO EDITAR MEDICO -->
                                <div class="form-group row">
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text">
                                                    <i class="fas fa-user"></i>
                                                </div>
||||||| merged common ancestors
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fas fa-user"></i>
=======
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text">
                                                    <i class="fas fa-user"></i>
                                                </div>
>>>>>>> origin/MontoyaRosas
                                            </div>
<<<<<<< HEAD
                                            <input type="text" id="editar-nombreMedico" class="form-control" value="Julio">
||||||| merged common ancestors
=======
                                            <input type="text" id="editar-primerApellidoMedico" class="form-control" value="Badillo">
>>>>>>> origin/MontoyaRosas
                                        </div>
<<<<<<< HEAD
                                    </div>
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text">
                                                    <i class="fas fa-user"></i>
                                                </div>
||||||| merged common ancestors
                                        <input type="text" id="editar-primerApellidoMedico" class="form-control" value="Badillo">
                                    </div>


                                </div>
                                <div class="col-6">

                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fas fa-user"></i>
=======


                                    </div>
                                    <div class="col-6">

                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text">
                                                    <i class="fas fa-user"></i>
                                                </div>
>>>>>>> origin/MontoyaRosas
                                            </div>
<<<<<<< HEAD
                                            <input type="text" id="editar-primerApellidoMedico" class="form-control" value="Badillo">
||||||| merged common ancestors
=======
                                            <input type="text" id="editar-segundoApellidoMedico" class="form-control" value="Guzman">
>>>>>>> origin/MontoyaRosas
                                        </div>
<<<<<<< HEAD
                                    </div>
||||||| merged common ancestors
                                        <input type="text" id="editar-segundoApellidoMedico" class="form-control" value="Guzman">
                                    </div>


=======


                                    </div>
>>>>>>> origin/MontoyaRosas
                                </div>

<<<<<<< HEAD
                                <div class="form-group row">
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text">
                                                    <i class="fas fa-user"></i>
                                                </div>
||||||| merged common ancestors
                            <div class="form-group row">
                                <div class="col-6">

                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fas fa-at"></i>
=======
                                <div class="form-group row">
                                    <div class="col-6">

                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text">
                                                    <i class="fas fa-at"></i>
                                                </div>
>>>>>>> origin/MontoyaRosas
                                            </div>
<<<<<<< HEAD
                                            <input type="text" id="editar-segundoApellidoMedico" class="form-control" value="Guzman">
||||||| merged common ancestors
=======
                                            <input type="text" id="editar-correoMedico" class="form-control" value="juliobadillo@gmail.com">
>>>>>>> origin/MontoyaRosas
                                        </div>
<<<<<<< HEAD
                                    </div>
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text">
                                                    <i class="fas fa-at"></i>
                                                </div>
||||||| merged common ancestors
                                        <input type="text" id="editar-correoMedico" class="form-control" value="juliobadillo@gmail.com">
                                    </div>


                                </div>
                                <div class="col-6">

                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fas fa-phone"></i>
=======


                                    </div>
                                    <div class="col-6">

                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text">
                                                    <i class="fas fa-phone"></i>
                                                </div>
>>>>>>> origin/MontoyaRosas
                                            </div>
<<<<<<< HEAD
                                            <input type="text" id="editar-correoMedico" class="form-control" value="juliobadillo@gmail.com">
||||||| merged common ancestors
=======
                                            <input type="text" id="editar-telefonoMedico" class="form-control" value="7778998">
>>>>>>> origin/MontoyaRosas
                                        </div>
<<<<<<< HEAD
                                    </div>
||||||| merged common ancestors
                                        <input type="text" id="editar-telefonoMedico" class="form-control" value="7778998">
                                    </div>


=======


                                    </div>
>>>>>>> origin/MontoyaRosas
                                </div>
<<<<<<< HEAD
||||||| merged common ancestors
                            </div>

                            <div class="form-group row">
                                <div class="col-6">
=======

                                <div class="form-group row">
                                    <div class="col-6">
>>>>>>> origin/MontoyaRosas

<<<<<<< HEAD
                                <div class="form-group row">
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text">
                                                    <i class="fas fa-phone"></i>
                                                </div>
||||||| merged common ancestors
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fab fa-slack-hash"></i>
=======
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text">
                                                    <i class="fab fa-slack-hash"></i>
                                                </div>
>>>>>>> origin/MontoyaRosas
                                            </div>
<<<<<<< HEAD
                                            <input type="text" id="editar-telefonoMedico" class="form-control" value="7778998">
||||||| merged common ancestors
=======
                                            <input type="text" id="editar-noEmpleadoMedico" class="form-control" value="HU89K">
>>>>>>> origin/MontoyaRosas
                                        </div>
<<<<<<< HEAD
                                    </div>
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text">
                                                    <i class="fab fa-slack-hash"></i>
                                                </div>
||||||| merged common ancestors
                                        <input type="text" id="editar-noEmpleadoMedico" class="form-control" value="HU89K">
                                    </div>


                                </div>
                                <div class="col-6">

                                    <div class="input-group">
                                        <div class="input-group-prepend ui-widget">
                                            <div class="input-group-text">
                                                <i class="fas fa-user-graduate"></i>
=======


                                    </div>
                                    <div class="col-6">

                                        <div class="input-group">
                                            <div class="input-group-prepend ui-widget">
                                                <div class="input-group-text">
                                                    <i class="fas fa-user-graduate"></i>
                                                </div>
>>>>>>> origin/MontoyaRosas
                                            </div>
<<<<<<< HEAD
                                            <input type="text" id="editar-noEmpleadoMedico" class="form-control" value="HU89K">
||||||| merged common ancestors
=======
                                            <input type="text" id="editar-especialidadMedico" class="form-control especialidad" value="Especialidad" list="listEspecialidades">  
                                            <datalist id="listEspecialidades">                                            
                                            </datalist>
>>>>>>> origin/MontoyaRosas
                                        </div>
<<<<<<< HEAD
                                    </div>
||||||| merged common ancestors
                                        <input type="text" id="editar-especialidadMedico" class="form-control especialidad" value="Especialidad" list="listEspecialidades">  
                                        <datalist id="listEspecialidades">                                            
                                        </datalist>
                                    </div>


=======


                                    </div>
>>>>>>> origin/MontoyaRosas
                                </div>

<<<<<<< HEAD
                                <div class="form-group row">
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend ui-widget">
                                                <div class="input-group-text">
                                                    <i class="fas fa-user-graduate"></i>
                                                </div>
||||||| merged common ancestors
                            <div class="form-group row">
                                <div class="col-6">

                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fas fa-user-graduate"></i>
=======
                                <div class="form-group row">
                                    <div class="col-6">

                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text">
                                                    <i class="fas fa-user-graduate"></i>
                                                </div>
>>>>>>> origin/MontoyaRosas
                                            </div>
<<<<<<< HEAD
                                            <input type="text" id="editar-especialidadMedico" class="form-control especialidad" value="Especialidad" list="listEspecialidades">  
                                            <datalist id="listEspecialidades">                                            
                                            </datalist>
||||||| merged common ancestors
=======
                                            <input type="text" id="editar-cedulaProfesionalMedico" class="form-control" value="Cédula profesional">
>>>>>>> origin/MontoyaRosas
                                        </div>
<<<<<<< HEAD
                                    </div>
                                    <div class="col-6">
||||||| merged common ancestors
                                        <input type="text" id="editar-cedulaProfesionalMedico" class="form-control" value="Cédula profesional">
                                    </div>
=======
>>>>>>> origin/MontoyaRosas

<<<<<<< HEAD
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text">
                                                    <i class="fas fa-user-graduate"></i>
                                                </div>
||||||| merged common ancestors


                                </div>
                                <div class="col-6">

                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="far fa-id-card"></i>
=======


                                    </div>
                                    <div class="col-6">

                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text">
                                                    <i class="far fa-id-card"></i>
                                                </div>
>>>>>>> origin/MontoyaRosas
                                            </div>
<<<<<<< HEAD
                                            <input type="text" id="editar-cedulaProfesionalMedico" class="form-control" value="Cédula profesional">
||||||| merged common ancestors
=======
                                            <input type="text" id="editar-usuarioMedico" class="form-control"
                                                   value="Usuario">
>>>>>>> origin/MontoyaRosas
                                        </div>
<<<<<<< HEAD
                                    </div>
||||||| merged common ancestors
                                        <input type="text" id="editar-usuarioMedico" class="form-control"
                                            value="Usuario">
                                    </div>


=======


                                    </div>
>>>>>>> origin/MontoyaRosas
                                </div>
<<<<<<< HEAD
                            </div>
                            <div class="modal-footer">
                                <button type="button" style="border-radius:20px" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                                <button id="btn-guardarMedico" type="button" style="border-radius:20px" class="btn btn-primary">Guardar
                                    Cambios
                                </button>
                            </div>
||||||| merged common ancestors
                            </div>

                        </div>
                        <div class="modal-footer">
                            <button type="button" style="border-radius:20px" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                            <button id="btn-guardarMedico" type="button" style="border-radius:20px" class="btn btn-primary" data-dismiss="modal">Guardar
                                Cambios
                            </button>
=======

                            </div>
                            <div class="modal-footer">
                                <button type="button" style="border-radius:20px" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                                <button id="btn-guardarMedico" type="button" style="border-radius:20px" class="btn btn-primary" data-dismiss="modal">Guardar
                                    Cambios
                                </button>
                            </div>
>>>>>>> origin/MontoyaRosas
                        </div>
                    </div>
                </div>

<<<<<<< HEAD
                <!-- ********** MODAL AGREGAR MEDICO ********** -->
                <div class="modal fade" id="modalAgregarMedico" tabindex="-1" role="dialog" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">Agregar Médico</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">

                                <!-- FORMULARIO AGREGAR MEDICO -->
                                <div class="form-group row">
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-user"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-nombreMedico" placeholder="Nombre">
||||||| merged common ancestors
            <!-- ********** MODAL AGREGAR MEDICO ********** -->
            <div class="modal fade" id="modalAgregarMedico" tabindex="-1" role="dialog" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">Agregar Médico</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">

                            <!-- FORMULARIO AGREGAR MEDICO -->
                            <div class="form-group row">
                                <div class="col-6">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text"><i class="fas fa-user"></i></div>
=======
                <!-- ********** MODAL AGREGAR MEDICO ********** -->
                <div class="modal fade" id="modalAgregarMedico" tabindex="-1" role="dialog" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">Agregar Médico</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">

                                <!-- FORMULARIO AGREGAR MEDICO -->
                                <div class="form-group row">
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-user"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-nombreMedico" placeholder="Nombre">
                                            <span class="text-danger" id="errorNombreMedico">Formato incorrecto, solo caracteres alfabéticos con un mínimo de 2 y un máximo de 255 caracteres.</span>
>>>>>>> origin/MontoyaRosas
                                        </div>
                                    </div>
<<<<<<< HEAD
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-phone"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-telefonoMedico" placeholder="Teléfono">
||||||| merged common ancestors
                                </div>
                                <div class="col-6">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text"><i class="fas fa-phone"></i></div>
=======
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-phone"></i></div>
                                            </div> 
                                            <input type="text" class="form-control" id="agregar-telefonoMedico" placeholder="Teléfono">
>>>>>>> origin/MontoyaRosas
                                        </div>
<<<<<<< HEAD
||||||| merged common ancestors
                                        <input type="text" class="form-control" id="agregar-telefonoMedico" placeholder="Teléfono">
=======
                                        <span class="text-danger" id="errorTelefonoMedico">Formato incorrecto, deben ser 10 dígitos.</span>
>>>>>>> origin/MontoyaRosas
                                    </div>
                                </div>

<<<<<<< HEAD
                                <div class="form-group row">
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-user"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-primerApellidoMedico"
                                                   placeholder="Primer Apellido">
||||||| merged common ancestors
                            <div class="form-group row">
                                <div class="col-6">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text"><i class="fas fa-user"></i></div>
=======
                                <div class="form-group row">
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-user"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-primerApellidoMedico"
                                                   placeholder="Primer Apellido">
                                            <span class="text-danger" id="errorApellidoPaternoMedico">Formato incorrecto, solo caracteres alfabéticos con un mínimo de 2 y un máximo de 127 caracteres.</span>
>>>>>>> origin/MontoyaRosas
                                        </div>
                                    </div>

<<<<<<< HEAD
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-user"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-segundoApellidoMedico"
                                                   placeholder="Segundo Apellido">
||||||| merged common ancestors
                                <div class="col-6">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text"><i class="fas fa-user"></i></div>
=======
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-user"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-segundoApellidoMedico"
                                                   placeholder="Segundo Apellido">
                                            <span class="text-danger" id="errorApellidoMaternoMedico">Formato incorrecto, solo caracteres alfabéticos con un mínimo de 2 y un máximo de 127 caracteres.</span>
>>>>>>> origin/MontoyaRosas
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-at"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-correoMedico" placeholder="Correo">
                                        </div>
<<<<<<< HEAD
||||||| merged common ancestors
                                        <input type="text" class="form-control" id="agregar-correoMedico" placeholder="Correo">
=======
                                        <span class="text-danger" id="errorCorreoMedico">El formato no es correcto, introduce un mínimo de 2 y un máximo de 254 caracteres. Ejemplo: example@example.com</span>
                                        <span class="text-warning" id="errorCorreoRepetido">El correo ya existe.</span>
>>>>>>> origin/MontoyaRosas
                                    </div>

<<<<<<< HEAD
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fab fa-slack-hash"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-noEmpleadoMedico"
                                                   placeholder="No. empleado">
||||||| merged common ancestors
                                <div class="col-6">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text"><i class="fab fa-slack-hash"></i></div>
=======
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fab fa-slack-hash"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-noEmpleadoMedico" placeholder="No. empleado">
>>>>>>> origin/MontoyaRosas
                                        </div>
<<<<<<< HEAD
||||||| merged common ancestors
                                        <input type="text" class="form-control" id="agregar-noEmpleadoMedico"
                                            placeholder="No. empleado">
=======
                                        <span class="text-danger" id="errorNumEmpleado">Formato incorrecto, deben ser 6 dígitos.</span>
>>>>>>> origin/MontoyaRosas
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-user-graduate"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-especialidadMedico"
                                                   placeholder="Especialidad" list="listEspecialidades">
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-user-graduate"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-posiciondMedico" list="listPosiciones"
                                                   placeholder="Posicion">
                                            <datalist id="listPosiciones">                                            
                                            </datalist>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <div class="col-12">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="far fa-id-card"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-cedulaMedico" placeholder="Cédula Profesional">
                                        </div>
<<<<<<< HEAD
||||||| merged common ancestors
                                        <input type="text" class="form-control" id="agregar-cedulaMedico" placeholder="Cédula Profesional">
=======
                                        <span class="text-danger" id="errorCedulaMedicos">Formato incorrecto, deben ser 7 dígitos.</span>
>>>>>>> origin/MontoyaRosas
                                    </div>
                                </div>

<<<<<<< HEAD
                                <div class="form-group row">
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-lock"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-passwordMedico" placeholder="Contraseña">
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
                                            <input type="password" class="form-control" id="agregar-passwordMedico" placeholder="Contraseña">
                                            <span class="text-danger" id="errorPass1Medico">Formato incorrecto, la contraseña debe tener al menos 1 número, 1 letra minúscula, 1 mayúscula y una extensión de 8 a 14 caracteres.</span>
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-lock"></i></div>
                                            </div>
                                            <input type="password" class="form-control" id="agregar-password2Medico"
                                                   placeholder="Confirmar contraseña">
>>>>>>> origin/MontoyaRosas
                                        </div>
<<<<<<< HEAD
||||||| merged common ancestors
                                        <input type="text" class="form-control" id="agregar-passwordMedico" placeholder="Contraseña">
=======
                                        <span class="text-warning" id="noEqualPasswordsError">Las contraseñas no son iguales.</span>
                                    </div>
                                </div>

                                <div class="form-group row justify-content-center">
                                    <div class="col-12 text-center">
                                        <button type="button" class="btn btn-morado-solid mt-2" data-dismiss="modal">Imprimir los términos y condiciones</button>
>>>>>>> origin/MontoyaRosas
                                    </div>
<<<<<<< HEAD
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-lock"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-password2Medico"
                                                   placeholder="Confirmar contraseña">
||||||| merged common ancestors
                                </div>
                                <div class="col-6">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text"><i class="fas fa-lock"></i></div>
=======
                                </div>

                                <div class="form-group row justify-content-center">
                                    <div class="col-12 text-center">
                                        <div class="form-check">
                                            <input class="form-check-input" type="checkbox" id="terminosMedico">
                                            <label class="form-check-label" for="autoSizingCheck2">
                                                El médico está informado y aceptó los términos y condiciones
                                            </label>
>>>>>>> origin/MontoyaRosas
                                        </div>
<<<<<<< HEAD
||||||| merged common ancestors
                                        <input type="text" class="form-control" id="agregar-password2Medico"
                                            placeholder="Confirmar contraseña">
=======
                                        <span class="text-danger" id="errorTerminos">Se deben aceptar términos y condiciones.</span>
>>>>>>> origin/MontoyaRosas
                                    </div>
                                </div>

<<<<<<< HEAD
                                <div class="form-group row justify-content-center">
                                    <div class="col-12 text-center">
                                        <button type="button" class="btn btn-morado-solid mt-2" data-dismiss="modal">Imprimir los términos y condiciones</button>
                                    </div>
||||||| merged common ancestors
                            <div class="form-group row justify-content-center">
                                <div class="col-12 text-center">
                                    <button type="button" class="btn btn-morado-solid mt-2" data-dismiss="modal">Imprimir los términos y condiciones</button>
=======
                                <div class="row mb-3" id="error-campos">
                                    <div class="col-12 text-center">
                                        <span class="text-danger">Completa todos los campos para registrar tu cuenta. </span>
                                    </div>
>>>>>>> origin/MontoyaRosas
                                </div>
<<<<<<< HEAD

                                <div class="form-group row justify-content-center">
                                    <div class="col-12 text-center">
                                        <div class="form-check">
                                            <input class="form-check-input" type="checkbox" id="autoSizingCheck2">
                                            <label class="form-check-label" for="autoSizingCheck2">
                                                El médico está informado y aceptó los términos y condiciones
                                            </label>
                                        </div>
||||||| merged common ancestors
                            </div>
    
                            <div class="form-group row justify-content-center">
                                <div class="col-12 text-center">
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox" id="autoSizingCheck2">
                                        <label class="form-check-label" for="autoSizingCheck2">
                                            El médico está informado y aceptó los términos y condiciones
                                        </label>
=======

                                <div class="row mb-3" id="error-datosRepetidos">
                                    <div class="col-12 text-center">
                                        <span class="text-warning">Estás tratando de registrar datos existentes. <br> Revisa de nuevo.</span>
>>>>>>> origin/MontoyaRosas
                                    </div>
                                </div>

<<<<<<< HEAD
                            </div>
                            <div class="modal-footer">
                                <button type="button" style="border-radius:20px" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                                <button id="btn-agregarMedico" type="button" style="border-radius:20px" class="btn btn-primary">Agregar médico</button>
                            </div>
||||||| merged common ancestors
                        </div>
                        <div class="modal-footer">
                            <button type="button" style="border-radius:20px" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                            <button id="btn-agregarMedico" type="button" style="border-radius:20px" class="btn btn-primary">Agregar médico</button>
=======
                            </div>
                            <div class="modal-footer">
                                <button type="button" style="border-radius:20px" class="btn btn-danger clearAddMedicosModal" data-dismiss="modal">Cancelar</button>
                                <button id="btn-agregarMedico" type="button" style="border-radius:20px" class="btn btn-primary">Agregar médico</button>
                            </div>
>>>>>>> origin/MontoyaRosas
                        </div>
                    </div>
                </div>


            </div>
        </div>

    </body>

</html>