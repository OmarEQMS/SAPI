<%-- 
    Document   : index
    Created on : 01-nov-2018, 14:05:35
    Author     : urieldiaz, julioguzman, shannonrosas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <%-- Hace rereferencia al conjunto de reglas --%>
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


        <link rel="stylesheet" href="css/styleNavegadora.css">
        <link rel="stylesheet" href="css/styleNavegadoraImg.css">
        <script src="js/appNavegadora.js"></script>
        <script src="js/appNavegadora2.js"></script>
        <script src="js/ajaxNavegadora.js"></script>

    </head>

    <body>

        <div class="wrapper">

            <!-- SIDEBAR -->
            <nav id="sidebar">

                <div class="sidebar-header">

                    <div class="row text-center justify-content-center mt-2">
                        <div class="col-12">
                            <img src="../img/logoSapi.png" style="width: 70%; display:block; margin:auto;" alt="">
                        </div>
                    </div>

                </div>

                <div class="profile">

                    <div class="row">
                        <div class="col-12 mb-2 mt-4">
                            <img src="../img/user.png" class="imagenPerfil" alt="">
                        </div>
                    </div>

                    <div class="row justify-content-center mb-2">
                        <div class="col-6 text-center">
                            <span class="textoSidebar m-0">Shannon Rosas</span>
                            <span class="textoSidebar userSidebar m-0">@shannonrosas</span>
                        </div>
                    </div>

                    <div class="row justify-content-center">

                        <div class="col-2 text-center">
                            <a class="iconoSidebar" href="" title="Mi Cuenta">
                                <i class="fas fa-cog"></i>
                            </a>
                        </div>

                        <div class="col-2">
                            <a class="iconoSidebar" href="" title="Cerrar Sesión">
                                <i class="fas fa-power-off"></i>
                            </a>
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

                    <li>
                        <a href="#">
                            <i class="fas fa-home"></i>Inicio</a>
                    </li>

                    <li>
                        <a href="./calendar.html">
                            <i class="fas fa-calendar-alt"></i>Calendario</a>
                    </li>

                    <li>
                        <a href="./rendimiento.html">
                            <i class="fas fa-chart-line"></i>Mi Rendimiento</a>
                    </li>

                    <li>
                        <a href="./cuenta.html">
                            <i class="far fa-user"></i>Mi Cuenta</a>
                    </li>

                    <li>
                        <a href="#">
                            <i class="fas fa-sign-out-alt"></i>Cerrar Sesión</a>
                    </li>

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

                        <span class="pull-right d-block">
                            <span style="color:#6c6f80">Bienvenido, </span>
                            <span style="font-weight:700; color:#6c6f80;">Shannon Rosas
                            </span>
                            <img src="../img/user.png" class="ml-2" style="width: 30px;" alt=""> </span>

                    </div>
                </nav>

                <!-- **************************************************************** -->
                <!-- ***** A PARTIR DE AQUI ESCRIBEN EL CODIGO QUE QUIERAN..... ***** -->
                <!-- **************************************************************** -->

                <div class="row mb-3 justify-content-end">
                    <div class="col-2 text-center">
                        <span class="iconoHome mr-2">
                            <i class="fas fa-home"></i>
                        </span>
                        <span>
                            <a href="./index.html" class="colorMoradoLight">Inicio</a>
                        </span>
                    </div>
                </div>

                <!-- Jumbotron Titulo -->

                <div class="jumbotron jumbotron-fluid p-2">
                    <div class="container">
                        <h1 class="display-4 tituloPacientes text-center m-0">Pacientes</h1>
                    </div>
                </div>

                <!-- CONTENIDO -->

                <!-- CONTENIDO -->

                <div class="card" style="width: 100%;">
                    <div class="card-body">
                        <div class="card" style="width: 100%">

                            <div class="card-body justify-content-center">

                                <!-- navbar -->

                                <nav>
                                    <div class="nav nav-tabs" id="nav-tab" role="tablist">
                                        <a class="nav-item nav-link active text-center titulo-nav text-danger" id="nav-documentacion-tab" data-toggle="tab" href="#documentacion"
                                           role="tab" aria-controls="nav-documentacion" aria-selected="true" style="width:50%">
                                            <i class="fas fa-file-alt mr-2 text-danger"></i>DOCUMENTACIÓN</a>


                                        <a class="nav-item nav-link text-center titulo-nav text-primary" id="nav-formulario-tab" data-toggle="tab" href="#nav-formulario"
                                           role="tab" aria-controls="nav-formulario" aria-selected="false" style="width:50%">
                                            <i class="fas fa-file-signature text-primary mr-2"></i>FORMULARIOS</a>
                                    </div>
                                </nav>

                                <div class="tab-content dark" id="nav-tabContent">

                                    <!-- 1er contenido: Solicitud -->
                                    <div class="tab-pane fade show active white mt-5" id="documentacion" role="tabpanel" aria-labelledby="nav-documentacion-tab">

                                        <div class="row">
                                            <div class="col-12">
                                                <button class="btn btn-morado float-right mb-3" style="border-radius: 20px" data-toggle="modal" data-target="#modalAgregarPaciente">
                                                    <i class="fas fa-user-plus"></i> Agregar Paciente</button>
                                            </div>
                                        </div>

                                        <!--Table-->
                                        <table class="display responsive no-wrap table table-striped mt-3" id="tabla1" width="100%">
                                            <thead>
                                                <tr>
                                                    <th scope="col">Nombre</th>
                                                    <th scope="col">Primer Apellido</th>
                                                    <th scope="col">Segundo Apellido</th>
                                                    <th scope="col">Estado</th>
                                                    <th scope="col">Fecha de Registro</th>
                                                    <th scope="col">CURP</th>
                                                    <th scope="col">Teléfono</th>
                                                    <th scope="col"></th>

                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>María Esther</td>
                                                    <td>Domínguez</td>
                                                    <td>Mayoral</td>
                                                    <td>En proceso</td>
                                                    <td>28 de noviembre 2018</td>
                                                    <td>A01422211</td>
                                                    <td>7774390070</td>
                                                    <td>

                                                        <button onclick="location.href = ' ./documentos.html'" class="btn btn-info" id="btn-ver">
                                                            <i class="far fa-eye"></i>
                                                        </button>
                                                        <button class="btn btn-success" id="btn-aceptar" data-toggle="modal" data-target="#modalAceptarUsuario">
                                                            <i class="fas fa-check"></i>
                                                        </button>
                                                        <button class="btn btn-primary" id="btn-editar" data-toggle="modal" data-target="#modalEditarUsuario">
                                                            <i class="fas fa-edit"></i>
                                                        </button>
                                                        <button class="btn btn-danger mt-1" id="btn-eliminar" data-toggle="modal" data-target="#modalEliminarUsuario">
                                                            <i class="fas fa-trash-alt"></i>
                                                        </button>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Tamara</td>
                                                    <td>Landa</td>
                                                    <td>Lagunas</td>
                                                    <td>Rechazado</td>
                                                    <td>28 de noviembre 2018</td>
                                                    <td>A01422211</td>
                                                    <td>7774390070</td>
                                                    <td>
                                                        <button class="btn btn-info" id="btn-ver">
                                                            <i class="far fa-eye"></i>
                                                        </button>
                                                        <button class="btn btn-success" id="btn-aceptar" data-toggle="modal" data-target="#modalAceptarUsuario">
                                                            <i class="fas fa-check"></i>
                                                        </button>
                                                        <button class="btn btn-primary" id="btn-editar" data-toggle="modal" data-target="#modalEditarUsuario">
                                                            <i class="fas fa-edit"></i>
                                                        </button>
                                                        <button class="btn btn-danger mt-1" id="btn-eliminar" data-toggle="modal" data-target="#modalEliminarUsuario">
                                                            <i class="fas fa-trash-alt"></i>
                                                        </button>
                                                    </td>
                                                </tr>
                                            </tbody>
                                        </table>

                                    </div>

                                    <!-- 2do contenido: APROBACION -->
                                    <div class="tab-pane active fade white mt-4" id="nav-formulario" role="tabpanel" aria-labelledby="nav-formulario-tab">




                                        <!-- Icono info colores -->

                                        <div class="row justify-content-end mt-5">

                                            <div class="col-1 iconoQuestion align-self-center mb-4">
                                                <a href="#" class="questionMark float-right" data-tooltip-content="#tooltip_contentnew"><i
                                                        class="fas fa-question-circle icono-info" style="font-size:25px"></i></a>
                                            </div>


                                            <div class="tooltip_templates">
                                                <span id="tooltip_contentnew">
                                                    <span>Recuerda:</span>
                                                    <ul>
                                                        <li> <span class="badge badge-danger"><span class="ocultaBadge">CC</span></span>
                                                            <span class="">Rojo: Formulario sin empezar.
                                                            </span>
                                                        </li>
                                                        <li> <span class="badge badge-warning"><span class="ocultaBadge">CC</span></span>
                                                            <span class="">Amarillo: Formulario empezado.
                                                            </span>
                                                        </li>
                                                        <li> <span class="badge badge-info"><span class="ocultaBadge">CC</span></span>
                                                            <span class="">Azul: Formulario completo hasta la penúltima página.
                                                            </span>
                                                        </li>
                                                        <li> <span class="badge badge-success"><span class="ocultaBadge">CC</span></span>
                                                            <span class="">Verde: Formulario completo.
                                                            </span>
                                                        </li>
                                                    </ul>
                                                </span>
                                                </span>

                                            </div>


                                        </div>



                                        <!-- segunda tabla -->
                                        <table class="display responsive no-wrap table table-striped mt-3" id="tabla2" width="100%">
                                            <thead>
                                                <tr>
                                                    <th scope="col">PRZ</th>
                                                    <th scope="col">Nombre</th>
                                                    <th scope="col">Primer Apellido</th>
                                                    <th scope="col">Segundo Apellido</th>
                                                    <th scope="col">Tipo de paciente</th>
                                                    <th scope="col"></th>
                                                    <th scope="col">Fecha de navegación</th>
                                                    <th scope="col">Teléfono</th>
                                                    <th scope="col"></th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr class="table-danger">
                                                    <td>A01422211</td>
                                                    <td>Elena</td>
                                                    <td>Loza</td>
                                                    <td>Torres</td>
                                                    <td>Primera vez</td>
                                                    <td><span class="badge badge-success">R</span></td>
                                                    <td>17 agosto 2018</td>
                                                    <td>7774390078</td>
                                                    <td>
                                                        <button onclick="location.href = ' ./form.html'" class="btn btn-info btn-block" id="btn-formulario">
                                                            <i class="fab fa-wpforms"></i>
                                                        </button>
                                                        <button class="btn btn-primary btn-block mt-1" id="btn-editarTabla2" data-toggle="modal" data-target="#modalEditarUsuarioTabla2">
                                                            <i class="fas fa-edit"></i>
                                                        </button>
                                                        <button class="btn btn-danger btn-block mt-1" id="btn-cancelar" data-toggle="modal" data-target="#modalCancelarCitas">
                                                            <i class="fas fa-ban"></i>
                                                        </button>
                                                    </td>
                                                </tr>

                                                <tr class="table-success">
                                                    <td>Nulo</td>
                                                    <td>María</td>
                                                    <td>Torres</td>
                                                    <td>Méndez</td>
                                                    <td>Segunda opinión</td>
                                                    <td></td>
                                                    <td>17/07/2018</td>
                                                    <td>7774390078</td>
                                                    <td>
                                                        <button class="btn btn-info btn-block" id="btn-formulario">
                                                            <i class="fab fa-wpforms"></i>
                                                        </button>
                                                        <button class="btn btn-primary btn-block" id="btn-editarTabla2" data-toggle="modal" data-target="#modalEditarUsuarioTabla2">
                                                            <i class="fas fa-edit"></i>
                                                        </button>

                                                        <button class="btn btn-danger btn-block" id="btn-cancelar" data-toggle="modal" data-target="#modalCancelarCitas">
                                                            <i class="fas fa-ban"></i>
                                                        </button>
                                                    </td>
                                                </tr>

                                                <tr class="table-warning">
                                                    <td>A01422623</td>
                                                    <td>Josefina</td>
                                                    <td>López</td>
                                                    <td>Peña</td>
                                                    <td>Primera vez</td>
                                                    <td><span class="badge badge-success">R</span></td>
                                                    <td>07/01/2018</td>
                                                    <td>7774390078</td>
                                                    <td>
                                                        <button class="btn btn-info btn-block" id="btn-formulario">
                                                            <i class="fab fa-wpforms"></i>
                                                        </button>
                                                        <button class="btn btn-primary btn-block" id="btn-editarTabla2" data-toggle="modal" data-target="#modalEditarUsuarioTabla2">
                                                            <i class="fas fa-edit"></i>
                                                        </button>

                                                        <button class="btn btn-danger btn-block" id="btn-cancelar" data-toggle="modal" data-target="#modalCancelarCitas">
                                                            <i class="fas fa-ban"></i>
                                                        </button>
                                                    </td>
                                                </tr>

                                                <tr class="table-primary">
                                                    <td>A0212546</td>
                                                    <td>Amanda</td>
                                                    <td>Nuñez</td>
                                                    <td>Calderón</td>
                                                    <td>Primera vez</td>
                                                    <td><span class="badge badge-success">R</span></td>
                                                    <td>07/01/2018</td>
                                                    <td>7775468974</td>
                                                    <td>
                                                        <button class="btn btn-info btn-block" id="btn-formulario">
                                                            <i class="fab fa-wpforms"></i>
                                                        </button>
                                                        <button class="btn btn-primary btn-block" id="btn-editarTabla2" data-toggle="modal" data-target="#modalEditarUsuarioTabla2">
                                                            <i class="fas fa-edit"></i>
                                                        </button>

                                                        <button class="btn btn-danger btn-block" id="btn-cancelar" data-toggle="modal" data-target="#modalCancelarCitas">
                                                            <i class="fas fa-ban"></i>
                                                        </button>
                                                    </td>
                                                </tr>


                                            </tbody>
                                        </table>

                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

            <div class="modal fade" id="modalAgregarPaciente" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLongTitle">Agregar paciente</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">

                            <!-- FORMULARIO AGREGAR PACIENTE -->

                            <div class="form-group row">
                                <div class="col-6">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fas fa-user"></i>
                                            </div>
                                        </div>
                                        <input type="text" class="form-control" id="nombreNavegadora" placeholder="Nombre">
                                    </div>
                                </div>

                                <div class="col-6">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fas fa-id-card"></i>
                                            </div>
                                        </div>
                                        <input type="text" class="form-control" id="curpNavegadora" placeholder="CURP">
                                    </div>
                                </div>

                            </div>

                            <div class="form-group row">
                                <div class="col-12">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fas fa-calendar-alt"></i>
                                            </div>
                                        </div>
                                        <input placeholder="Fecha de nacimiento" class="selectStyle form-control textbox-n" type="text" onfocus="(this.type = 'date')"
                                               id="cumpleNavegadora">
                                    </div>
                                </div>
                            </div>

                            <div class="form-group row">
                                <div class="col-6">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fas fa-user"></i>
                                            </div>
                                        </div>
                                        <input type="text" class="form-control" id="primer-apellidoNavegadora" placeholder="Primer Apellido">
                                    </div>
                                </div>

                                <div class="col-6">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fas fa-user"></i>
                                            </div>
                                        </div>
                                        <input type="text" class="form-control" id="segundo-apellidoNavegadora" placeholder="Segundo Apellido">
                                    </div>
                                </div>
                            </div>

                            <div class="form-group row">
                                <div class="col-6">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fas fa-user-circle"></i>
                                            </div>
                                        </div>
                                        <input type="text" class="form-control" id="usuarioNavegadora" placeholder="Usuario">
                                    </div>
                                </div>
                                <div class="col-6">
                                    <div class="input-group">
                                        <select class="form-control" name="" id="">
                                            <option selected disabled>Estado Civil</option>                                            
                                            <c:forEach items="${estadoCivil}" var="estadoC">  
                                                <option value="<c:out value='${estadoC.idEstadoCivil}'/>"><c:out value='${estadoC.nombre}'/></option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group row">
                                <div class="col-6">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fas fa-map-marker-alt"></i>
                                            </div>
                                        </div>
                                        <input type="text" class="form-control" id="calleNavegadora" placeholder="Calle">
                                    </div>
                                </div>
                                <div class="col-3">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fas fa-map-marker-alt"></i>
                                            </div>
                                        </div>
                                        <input type="text" class="form-control" id="numIntNavegadora" placeholder="No. int">
                                    </div>
                                </div>
                                <div class="col-3">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fas fa-map-marker-alt"></i>
                                            </div>
                                        </div>
                                        <input type="text" class="form-control" id="numExtNavegadora" placeholder="No. ext">
                                    </div>
                                </div>
                            </div>

                            <div class="form-group row">
                                <div class="col-6">
                                    <div class="input-group">
                                        <select class="form-control" name="" id="">
                                            <option disabled selected>Estado</option>
                                            <option value=""></option>
                                            <option value=""></option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-6">
                                    <div class="input-group">
                                        <select class="form-control" name="" id="">
                                            <option disabled selected>Ciudad</option>
                                            <option value=""></option>
                                            <option value=""></option>
                                        </select>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group row">
                                <div class="col-6">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fas fa-phone"></i>
                                            </div>
                                        </div>
                                        <input type="text" class="form-control" id="telNavegadora" placeholder="Teléfono">
                                    </div>
                                </div>

                                <div class="col-6">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fas fa-at"></i>
                                            </div>
                                        </div>
                                        <input type="text" class="form-control" id="correoNavegadora" placeholder="Correo">
                                    </div>
                                </div>

                            </div>

                            <div class="form-group row">
                                <div class="col-12">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fas fa-map-marker-alt"></i>
                                            </div>
                                        </div>
                                        <input type="text" class="form-control" id="colNavegadora" placeholder="Colonia">
                                    </div>
                                </div>
                            </div>


                            <div class="form-group row">
                                <div class="col-6">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fas fa-lock"></i>
                                            </div>
                                        </div>
                                        <input type="text" class="form-control" id="contraNavegadora" placeholder="Contraseña">
                                    </div>
                                </div>
                                <div class="col-6">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fas fa-lock"></i>
                                            </div>
                                        </div>
                                        <input type="text" class="form-control" id="confContraNavegadora" placeholder="Confirmar contraseña">
                                    </div>
                                </div>
                            </div>

                            <div class="form-group row justify-content-center">
                                <div class="col-12 text-center">
                                    <button type="button" class="btn btn-morado-solid mt-2" data-dismiss="modal">Imprimir los
                                        términos y condiciones</button>
                                </div>
                            </div>

                            <div class="form-group row justify-content-center">
                                <div class="col-12 text-center">
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox" id="autoSizingCheck2">
                                        <label class="form-check-label" for="autoSizingCheck2">
                                            El paciente está informado y aceptó los términos y condiciones
                                        </label>
                                    </div>
                                </div>
                            </div>


                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger" data-dismiss="modal" style="border-radius:20px">Cerrar</button>
                            <button type="button" id="agregarPaciente" class="btn btn-primary" style="border-radius:20px">Agregar
                                Paciente
                            </button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal fade" id="modalEditarUsuario" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLongTitle">Editar paciente</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <div class="form-group row">
                                <div class="col-6">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fas fa-user"></i>
                                            </div>
                                        </div>
                                        <input type="text" class="form-control" id="editarNombreNavegadoraAPaciente" placeholder="Nombre">
                                    </div>
                                </div>

                                <div class="col-6">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fas fa-id-card"></i>
                                            </div>
                                        </div>
                                        <input type="text" class="form-control" id="editarCurpNavegadoraAPaciente" placeholder="CURP">
                                    </div>
                                </div>

                            </div>

                            <div class="form-group row">
                                <div class="col-6">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fas fa-user"></i>
                                            </div>
                                        </div>
                                        <input type="text" class="form-control" id="editarPrimer-apellidoNavegadoraAPaciente" placeholder="Primer Apellido">
                                    </div>
                                </div>

                                <div class="col-6">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fas fa-user"></i>
                                            </div>
                                        </div>
                                        <input type="text" class="form-control" id="editarSegundo-apellidoNavegadoraAPaciente" placeholder="Segundo Apellido">
                                    </div>
                                </div>
                            </div>

                            <div class="form-group row">
                                <div class="col-12">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fas fa-calendar-alt"></i>
                                            </div>
                                        </div>
                                        <input placeholder="Fecha de nacimiento" class="selectStyle form-control textbox-n" type="text" onfocus="(this.type = 'date')"
                                               id="editarCumpleNavegadoraAPaciente">
                                    </div>
                                </div>
                            </div>

                            <div class="form-group row">
                                <div class="col-6">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fas fa-user-circle"></i>
                                            </div>
                                        </div>
                                        <input type="text" class="form-control" id="editarUsuarioNavegadoraAPaciente" placeholder="Usuario">
                                    </div>
                                </div>
                                <div class="col-6">
                                    <div class="input-group">
                                        <select class="form-control" name="" id="">
                                            <option disabled selected>Estado Civil</option>
                                            <option value=""></option>
                                            <option value=""></option>
                                        </select>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group row">
                                <div class="col-6">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fas fa-map-marker-alt"></i>
                                            </div>
                                        </div>
                                        <input type="text" class="form-control" id="editarCalleNavegadoraAPaciente" placeholder="Calle">
                                    </div>
                                </div>
                                <div class="col-3">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fas fa-map-marker-alt"></i>
                                            </div>
                                        </div>
                                        <input type="text" class="form-control" id="editarNumIntNavegadoraAPaciente" placeholder="No. int">
                                    </div>
                                </div>
                                <div class="col-3">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fas fa-map-marker-alt"></i>
                                            </div>
                                        </div>
                                        <input type="text" class="form-control" id="editarNumExtNavegadoraAPaciente" placeholder="No. ext">
                                    </div>
                                </div>
                            </div>

                            <div class="form-group row">
                                <div class="col-6">
                                    <div class="input-group">
                                        <select class="form-control" name="" id="">
                                            <option disabled selected>Estado</option>
                                            <option value=""></option>
                                            <option value=""></option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-6">
                                    <div class="input-group">
                                        <select class="form-control" name="" id="">
                                            <option disabled selected>Ciudad</option>
                                            <option value=""></option>
                                            <option value=""></option>
                                        </select>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group row">
                                <div class="col-6">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fas fa-phone"></i>
                                            </div>
                                        </div>
                                        <input type="text" class="form-control" id="editarTelNavegadoraAPaciente" placeholder="Teléfono">
                                    </div>
                                </div>

                                <div class="col-6">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fas fa-at"></i>
                                            </div>
                                        </div>
                                        <input type="text" class="form-control" id="editarCorreoNavegadoraAPaciente" placeholder="Correo">
                                    </div>
                                </div>

                            </div>

                            <div class="form-group row">
                                <div class="col-12">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fas fa-map-marker-alt"></i>
                                            </div>
                                        </div>
                                        <input type="text" class="form-control" id="editarColNavegadoraAPaciente" placeholder="Colonia">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger" data-dismiss="modal" style="border-radius:20px">Cancelar</button>
                            <button type="button" class="btn btn-primary" style="border-radius:20px">Guardar Cambios</button>
                        </div>
                    </div>
                </div>
            </div>

            <div class="modal fade" id="modalEditarUsuarioTabla2" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle"
                 aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLongTitle">Editar paciente</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <div class="form-group row">
                                <div class="col-6">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fas fa-user"></i>
                                            </div>
                                        </div>
                                        <input type="text" class="form-control" id="editarNombreNavegadoraAPaciente" placeholder="Nombre">
                                    </div>
                                </div>

                                <div class="col-6">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fas fa-id-card"></i>
                                            </div>
                                        </div>
                                        <input type="text" class="form-control" id="editarCurpNavegadoraAPaciente" placeholder="CURP">
                                    </div>
                                </div>

                            </div>

                            <div class="form-group row">
                                <div class="col-6">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fas fa-user"></i>
                                            </div>
                                        </div>
                                        <input type="text" class="form-control" id="editarPrimer-apellidoNavegadoraAPaciente" placeholder="Primer Apellido">
                                    </div>
                                </div>

                                <div class="col-6">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fas fa-user"></i>
                                            </div>
                                        </div>
                                        <input type="text" class="form-control" id="editarSegundo-apellidoNavegadoraAPaciente" placeholder="Segundo Apellido">
                                    </div>
                                </div>
                            </div>

                            <div class="form-group row">
                                <div class="col-12">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fas fa-calendar-alt"></i>
                                            </div>
                                        </div>
                                        <input placeholder="Fecha de nacimiento" class="selectStyle form-control textbox-n" type="text" onfocus="(this.type = 'date')"
                                               id="editarCumpleNavegadoraAPaciente">
                                    </div>
                                </div>
                            </div>

                            <div class="form-group row">
                                <div class="col-6">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fas fa-user-circle"></i>
                                            </div>
                                        </div>
                                        <input type="text" class="form-control" id="editarUsuarioNavegadoraAPaciente" placeholder="Usuario">
                                    </div>
                                </div>
                                <div class="col-6">
                                    <div class="input-group">
                                        <select class="form-control" name="" id="">
                                            <option disabled selected>Estado Civil</option>
                                            <option value=""></option>
                                            <option value=""></option>
                                        </select>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group row">
                                <div class="col-6">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fas fa-map-marker-alt"></i>
                                            </div>
                                        </div>
                                        <input type="text" class="form-control" id="editarCalleNavegadoraAPaciente" placeholder="Calle">
                                    </div>
                                </div>
                                <div class="col-3">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fas fa-map-marker-alt"></i>
                                            </div>
                                        </div>
                                        <input type="text" class="form-control" id="editarNumIntNavegadoraAPaciente" placeholder="No. int">
                                    </div>
                                </div>
                                <div class="col-3">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fas fa-map-marker-alt"></i>
                                            </div>
                                        </div>
                                        <input type="text" class="form-control" id="editarNumExtNavegadoraAPaciente" placeholder="No. ext">
                                    </div>
                                </div>
                            </div>

                            <div class="form-group row">
                                <div class="col-6">
                                    <div class="input-group">
                                        <select class="form-control" name="" id="">
                                            <option disabled selected>Estado</option>
                                            <option value=""></option>
                                            <option value=""></option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-6">
                                    <div class="input-group">
                                        <select class="form-control" name="" id="">
                                            <option disabled selected>Ciudad</option>
                                            <option value=""></option>
                                            <option value=""></option>
                                        </select>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group row">
                                <div class="col-6">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fas fa-phone"></i>
                                            </div>
                                        </div>
                                        <input type="text" class="form-control" id="editarTelNavegadoraAPaciente" placeholder="Teléfono">
                                    </div>
                                </div>

                                <div class="col-6">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fas fa-at"></i>
                                            </div>
                                        </div>
                                        <input type="text" class="form-control" id="editarCorreoNavegadoraAPaciente" placeholder="Correo">
                                    </div>
                                </div>

                            </div>

                            <div class="form-group row">
                                <div class="col-12">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fas fa-map-marker-alt"></i>
                                            </div>
                                        </div>
                                        <input type="text" class="form-control" id="editarColNavegadoraAPaciente" placeholder="Colonia">
                                    </div>
                                </div>
                            </div>

                            <div class="form-group row text-center">

                                <div class="col-12">
                                    <div class="form-check form-check-inline">
                                        <input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="option1">
                                        <label class="form-check-label" for="inlineCheckbox1">Cambio a paciente</label>
                                    </div>
                                </div>
                            </div>

                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger" data-dismiss="modal" style="border-radius:20px">Cancelar</button>
                            <button type="button" class="btn btn-primary" style="border-radius:20px">Guardar Cambios</button>
                        </div>
                    </div>
                </div>
            </div>

            <div class="modal fade" id="modalAceptarUsuario" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLongTitle">
                                <i class="fas fa-exclamation-triangle"></i> Confirmación</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            ¿Estás segura(o) que quieres aceptar la información de este paciente?

                            <div class="form-group row mt-3">


                                <div class="col-6 ">
                                    <span class="textoFechas1">Fecha navegación:</span>
                                </div>

                                <div class="custom-file col-6" id="fechaNavegacion">
                                    <input placeholder="Fecha navegación" class="selectStyle form-control textbox-n" type="text" onfocus="(this.type = 'date')"
                                           id="Fecha-Navegacion">
                                </div>

                                <div class="col-6 mt-3">
                                    <span class="textoFechas">Fecha preconsulta:</span>
                                </div>

                                <div class="custom-file col-6 mt-3" id="fechaPreconsulta">
                                    <input placeholder="Fecha consulta" class="selectStyle form-control textbox-n" type="text" onfocus="(this.type = 'date')" id="Fecha-Consulta">
                                </div>



                                <div class="col-6 mt-3">
                                    <label for="">Tipo de paciente:</label>

                                </div>

                                <div class="input-group col-6 mt-3">
                                    <div class="input-group-append">
                                        <div class="input-group-text">
                                            <i class="fas fa-user"></i>
                                        </div>
                                    </div>
                                    <select class="form-control" id="tipoPaciente0">
                                        <option disabled selected>Seleccione un tipo de paciente</option>
                                        <option>Primera vez</option>
                                        <option>Segunda opinión</option>
                                    </select>
                                </div>

                            </div>




                        </div>

                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger" style="border-radius:20px" data-dismiss="modal">Cancelar</button>
                            <button type="button" class="btn btn-primary" style="border-radius:20px">Aceptar</button>
                        </div>
                    </div>
                </div>
            </div>


        </div>


    </body>

</html>