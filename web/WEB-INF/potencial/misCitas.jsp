<%-- 
    Document   : misCitas
    Created on : 25/10/2018, 10:47:49 PM
    Author     : julioguzman, shannonrosas
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <%-- Hace rereferencia al conjunto de reglas --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <title>SAP | Inicio</title>

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

        <link rel="stylesheet" href="css/stylePotencial.css">
        <script src="js/appPotencial.js" type="module"></script>
        <script src="js/calendarPotencial.js"></script>
        <script src="js/ajaxPotencial.js"></script>  

    </head>

    <body>

        <div class="wrapper">

            <!-- SIDEBAR -->
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
                            <a class="iconoSidebar" id="irACuenta1" title="Mi Cuenta"><i class="fas fa-cog"></i></a>
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

                    <li id ="irACitaPreconsulta"><a><i class="fas fa-home"></i>Cita a Preconsulta </a></li>

                    <li id ="irAMisCitas"><a><i class="fas fa-calendar-alt"></i>Mis Citas
                            <c:choose>
                                <c:when test="${sessionScope.estatus>=1}">
                                    <span class="notificacion">1</span>                        
                                </c:when>
                            </c:choose>
                        </a>                    
                    </li>

                    <li id ="irACuenta"><a><i class="far fa-user"></i>Mi Cuenta </a></li>

                    <li id ="irAPreguntasFrecuentes"><a><i class="fas fa-question-circle"></i>Preguntas Frecuentes </a></li>

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

                        <input type="hidden" id="sesionPaciente" value="${sessionScope.idSesion}"/>
                        <input type="hidden" id="idPaciente" value="${sessionScope.idPaciente}"/>

                        <span class="pull-right d-block"><span style="color:#6c6f80">Bienvenido, </span><span style="font-weight:700; color:#6c6f80;">
                                ${sessionScope.nombre} ${sessionScope.primerApellido}

                                </div>
                                </nav>

                                <div class="row mb-3">
                                    <div class="col-12 text-right">
                                        <span class="iconoHome mr-2"><i class="fas fa-home"></i></span><span><a href="./index2.html" class="colorMoradoLight">Inicio</a></span>
                                        - <span class="colorGlobal">Mis Citas</span>
                                    </div>
                                </div>


                                <!-- CONTENIDO -->
                                <div class="jumbotron jumbotron-fluid p-2">
                                    <div class="container">
                                        <h1 class="display-4 tituloMisCitas text-center m-0">Mis Citas</h1>
                                    </div>
                                </div>

                                <c:choose>
                                    <c:when test="${sessionScope.estatus==1}">

                                        <!-- APROBADA -->        

                                        <div class="card bg-info text-white mb-3">
                                            <div class="card-body">
                                                <div class="row">
                                                    <div class="col-12 text-center">
                                                        <h5 class="display-4 textoCitaReservada mb-1">Tu cita de <strong>preconsulta</strong> ha sido reservada para el:</h5>
                                                        <h5 class="display-4 textoCitaReservada m-0 d-inline mr-2" id="fechaCitaPreConsulta">${sessionScope.fechaPreConsulta}</h5>
                                                        <a href="#" class="questionMark pull-right"
                                                                                                                                                                                    title="¿Tienes dudas? Comunicate al: 01-800-1111-111-1"><i class="fas fa-info-circle"></i></a>
                                                    </div>
                                                </div>

                                            </div>
                                        </div>

                                        <div class="card bg-info text-white mb-3">
                                            <div class="card-body">
                                                <div class="row">
                                                    <div class="col-12 text-center">
                                                        <h5 class="display-4 textoCitaReservada mb-1">Tu cita de <strong>navegación</strong> ha sido reservada para el:</h5>
                                                        <h5 class="display-4 textoCitaReservada m-0 d-inline mr-2" id="fechaCitaNavegacion">${sessionScope.fechaNavegacion}</h5>
                                                        <a href="#" class="questionMark pull-right"
                                                                                                                                                                                    title="¿Tienes dudas? Comunicate al: 01-800-1111-111-1"><i class="fas fa-info-circle"></i></a>
                                                    </div>
                                                </div>

                                            </div>
                                        </div>

                                        <div class="card bg-light text-white mb-3">
                                            <div class="card-body">

                                                <div class="row justify-content-center mt-2">
                                                    <div class="col-xl-4 col-lg-4 col-md-4 col-sm-4 text-center">
                                                        <button class="btn btn-danger btn-block btnCancelarCita" id="btn-cancelarPreConsulta1">Cancelar
                                                            Citas
                                                        </button>
                                                    </div>
                                                </div>


                                            </div>
                                        </div>


                                    </c:when>        
                                </c:choose>

                                <c:choose>
                                    <c:when test="${sessionScope.estatus==2}">
                                        <!-- CANCELADA -->
                                        <div class="card bg-danger text-white mb-3">
                                            <div class="card-body">
                                                <div class="row">
                                                    <div class="col-12 text-center">
                                                        <h5 class="display-4 textoCitaReservada mb-1">Tus citas han sido canceladas</h5>

                                                    </div>
                                                </div>

                                            </div>
                                        </div>
                                    </c:when>        
                                </c:choose>


                                <!-- Icono info -->

                                <div class="row justify-content-end mb-3">
                                    <div class="col-12">
                                        <i class="fas fa-info-circle float-right icono-info" style="font-size:27px" data-toggle="tooltip" data-placement="top" title="¿Tienes algún problema con tu cita? Llama al 01-800-1111-111-1"></i>
                                    </div>
                                </div>

                                <div class="card">
                                    <div class="card-body">
                                        <div id="calendarCitas"></div>
                                    </div>
                                </div>

                                <!-- Modal VER CITA-->
                                <div class="modal fade" id="modalVerCitaPreConsulta" tabindex="-1" role="dialog" aria-hidden="true">
                                    <div class="modal-dialog modal-dialog-centered" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title">Informacion de cita</h5>
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body">

                                                <div class="row mb-4">
                                                    <div class="col-12">
                                                        <h6 class="text-center display-4 tituloCitaModal text-primary" style="font-size:25px">Cita
                                                            a Preconsulta</h6>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="col-12 text-center">
                                                        <i class="fas fa-calendar-alt mr-2 text-danger"></i><span style="font-weight:bold; color: #2c2f39">Dia:
                                                        </span><span style="color: #696a6b" id="dia-cita"></span>
                                                        <hr>
                                                    </div>
                                                </div>

                                                <div class="row mt-1">
                                                    <div class="col-12 text-center">
                                                        <i class="fas fa-clock mr-2 text-primary"></i><span style="font-weight:bold; color: #2c2f39">Hora:
                                                        </span><span id="hora-cita" style="color: #696a6b"></span>
                                                        <hr>
                                                    </div>
                                                </div>

                                                <div class="row mt-1 justify-content-center">
                                                    <div class="col-6 text-center">
                                                        <button class="btn btn-danger btn-block" id="btn-cancelarPreConsulta2" style="border-radius: 20px;">Cancelar
                                                            Cita
                                                        </button>
                                                    </div>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <!-- Modal POR QUE DESEA CANCELR SU CITA -->
                                <div class="modal fade" id="modalMotivoCancelacion" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
                                     aria-hidden="true">
                                    <div class="modal-dialog modal-dialog-centered" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title" id="exampleModalLongTitle">¿Por qué desea cancelar su cita?</h5>
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body">
                                                <textarea class="form-control" placeholder="¿Por qué desea cancelar su cita?"></textarea>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-danger" style="border-radius: 20px;" data-dismiss="modal">Cerrar</button>
                                                <button type="button" id="btn-cancelarDefinitivo" class="btn btn-primary" style="border-radius: 20px;">Cancelar Cita</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                </div>
                                </div>
                                <!--<script type="application/javascript" src="js/validaciones.js"></script> -->
                                </body>

                                </html>
