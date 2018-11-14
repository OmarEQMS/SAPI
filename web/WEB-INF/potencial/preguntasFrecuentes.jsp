<%-- 
    Document   : preguntasFrecuentes
    Created on : 25/10/2018, 10:48:05 PM
    Author     : julioguzman, shannonrosas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <%-- Hace rereferencia al conjunto de reglas --%>

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
        <script src="js/appPotencial.js"></script>
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
                            <img src="data:image/jpeg;base64,${sessionScope.base64Img}" class="imagenPerfil edit-image" width="66px" height="66px" alt="">                        </div>
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
                                <c:when test="${sessionScope.estatus==1}">
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

                        <span class="pull-right d-block"><span style="color:#6c6f80">Hola, </span><span style="font-weight:700; color:#6c6f80;">
                                ${sessionScope.nombre} ${sessionScope.primerApellido}

                                </div>
                                </nav>

                                <div class="row mb-3">
                                    <div class="col-12 text-right">
                                        <span class="iconoHome mr-2"><i class="fas fa-home"></i></span><span><a id="irAInicioPotencial" class="colorMoradoLight">Inicio</a></span>
                                        - <span class="colorGlobal">Preguntas Frecuentes</span>
                                    </div>
                                </div>


                                <!-- CONTENIDO -->
                                <div class="jumbotron jumbotron-fluid p-2">
                                    <div class="container">
                                        <h1 class="display-4 tituloMisCitas text-center m-0">Preguntas Frecuentes</h1>
                                    </div>
                                </div>

                                <div class="card m-3 justificar">
                                    <div class="card-body">
                                        <div class="accordion" id="accordionExample">
                                            <div class="card">
                                                <div class="card-header" id="headingOne">
                                                    <h5 class="mb-0">
                                                        <button class="btn btn-link colorMoradoLight" type="button" data-toggle="collapse"
                                                                data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                                            1.- ¿EL INSTITUTO ATIENDE A PACIENTES DE SEGURO POPULAR?<i class="colorMoradoLight ml-2 fas fa-arrow-down"></i>
                                                        </button>
                                                    </h5>
                                                </div>

                                                <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
                                                    <div class="card-body">
                                                        El instituto atiende a pacientes con seguro popular, solo en el programa de
                                                        fondo de protección contra gastos catastróficos que incluye el cáncer de mama,
                                                        entre otros. La atención y cobertura de estas enfermedades dependerá de la
                                                        valoración médica y de los requisitos establecidos por el seguro popular (gastos
                                                        catastróficos).
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="card">
                                                <div class="card-header" id="headingTwo">
                                                    <h5 class="mb-0">
                                                        <button class="btn btn-link colorMoradoLight collapsed" type="button" data-toggle="collapse"
                                                                data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                                                            2.-¿COSTOS DE TRATAMIENTO?<i class="colorMoradoLight ml-2 fas fa-arrow-down"></i>
                                                        </button>
                                                    </h5>
                                                </div>
                                                <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
                                                    <div class="card-body">
                                                        Los costos varían de acuerdo al tratamiento que necesita cada paciente.
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="card">
                                                <div class="card-header" id="headingThree">
                                                    <h5 class="mb-0">
                                                        <button class="btn btn-link colorMoradoLight collapsed" type="button" data-toggle="collapse"
                                                                data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                                                            3.- SI VOY AL INSTITUTO NACIONAL DE CANCEROLOGIA, ¿ME ATIENDEN EL MISMO DÍA?<i
                                                                class="colorMoradoLight ml-2 fas fa-arrow-down"></i>
                                                        </button>
                                                    </h5>
                                                </div>
                                                <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordionExample">
                                                    <div class="card-body">
                                                        Debes sacar cita con anticipación ya que el instituto no da citas el mismo día.
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="card">
                                                <div class="card-header" id="headingThree">
                                                    <h5 class="mb-0">
                                                        <button class="btn btn-link colorMoradoLight collapsed" type="button" data-toggle="collapse"
                                                                data-target="#collapse4" aria-expanded="false" aria-controls="collapseThree">
                                                            4.- ¿ES NECESARIO PRESENTARSE EN AYUNO A LA CITA?<i class="colorMoradoLight ml-2 fas fa-arrow-down"></i>
                                                        </button>
                                                    </h5>
                                                </div>
                                                <div id="collapse4" class="collapse" aria-labelledby="headingThree" data-parent="#accordionExample">
                                                    <div class="card-body">
                                                        No es necesario que vengas en ayuno. Siempre y cuando tus condiciones de salud lo
                                                        permitan te recomendamos vengas desayunada.
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="card">
                                                <div class="card-header" id="headingThree">
                                                    <h5 class="mb-0">
                                                        <button class="btn btn-link colorMoradoLight collapsed" type="button" data-toggle="collapse"
                                                                data-target="#collapse5" aria-expanded="false" aria-controls="collapseThree">
                                                            5.- ¿SI NO TENGO EXPEDIENTE EN EL INSTITUTO NACIONAL DE CANCEROLOGÍA ME
                                                            ATIENDEN COMO URGENCIA?<i class="colorMoradoLight ml-2 fas fa-arrow-down"></i>
                                                        </button>
                                                    </h5>
                                                </div>
                                                <div id="collapse5" class="collapse" aria-labelledby="headingThree" data-parent="#accordionExample">
                                                    <div class="card-body">
                                                        El INCan no cuenta con servicio de urgencias para personas que no son pacientes.
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                </div>
                                </div>

                                </body>

                                </html>
