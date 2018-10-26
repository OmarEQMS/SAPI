
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


        <link rel="stylesheet" href="css/stylePotencial.css">
        <script src="js/appPotencial.js" type="module"></script>
        <script src="js/ajaxPotencial.js"></script>

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
                            <span class="textoSidebar userSidebar m-0">${sessionScope.usuario}</span>
                        </div>
                    </div>

                    <div class="row justify-content-center">
                        <div class="col-2 text-center">
                            <a class="iconoSidebar" href="<" title="Mi Cuenta"><i class="fas fa-cog"></i></a>
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

                    <li id ="irAMisCitas"><a><i class="fas fa-calendar-alt"></i>Mis Citas<span class="notificacion">1</span></a></li>

                    <li id ="irACuenta"><a><i class="far fa-user"></i>Mi Cuenta </a></li>

                    <li id ="irAPreguntasFrecuentes"><a><i class="fas fa-question-circle"></i>Preguntas Frecuentes </a></li>

                    <li id="salirCuenta"><a href="#"><i class="fas fa-sign-out-alt"></i>Cerrar Sesión</a></li>

                </ul>

            </nav>

            <!-- CONTENIDO PRINCIPAL POTENCIAL -->

            <div id="content">

                <!-- MENU -->

                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <div class="container-fluid">

                        <button id="sidebarCollapse" class="btn boton-collapse">
                            <i class="fas fa-align-justify"></i>
                        </button>

                        <!-- aqui se inyecta la sesion de id-->
                        <input type="hidden" id="sesionPaciente" value="${sessionScope.idSesion}" />

                        <span class="pull-right d-block"><span style="color:#6c6f80">Bienvenido, </span><span style="font-weight:700; color:#6c6f80;">
                                <!--Julio Badillo-->
                                ${sessionScope.nombre} ${sessionScope.primerApellido}</span></span>
                    </div>
                </nav>

                <div class="row mb-3">
                    <div class="col-12 text-right">
                        <span class="iconoHome mr-2"><i class="fas fa-home"></i></span></span><span><a href="./index2.html" class="colorMoradoLight">Inicio</a></span>
                    </div>
                </div>

                <!-- CONTENIDO -->

                <div class="card" style="width: 100%;">
                    <div class="card-body">
                        <div class="card" style="width: 100%">

                            <div class="card-body justify-content-center">

                                <!-- navbar -->

                                <nav>
                                    <div class="nav nav-tabs" id="nav-tab" role="tablist">



                                        <c:choose>
                                            <c:when test="${sessionScope.estatus==1}">

                                                <a class="nav-item nav-link active text-center colorMoradoLight texto-tab" id="nav-bienvenida-tab" data-toggle="tab" href="#nav-bienvenida"
                                                   role="tab" aria-controls="nav-bienvenida" aria-selected="false" style="width:33%">INFORMACIÓN</a>

                                                <a class="nav-item nav-link text-center colorMoradoLight texto-tab" id="nav-solicitud-tab" data-toggle="tab" href="#solicitud" role="tab"
                                                   aria-controls="nav-solicitud" aria-selected="true" style="width:33%"><!--<i
                                                        class="fas fa-check-circle text-success mr-2"></i>-->SOLICITUD</a>

                                                <a class="nav-item nav-link text-center colorMoradoLight texto-tab" id="nav-contact-tab" data-toggle="tab" href="#nav-contact" role="tab"
                                                   aria-controls="nav-contact" aria-selected="false" style="width:33%">RESOLUCIÓN</a>
                                            </c:when>

                                            <c:otherwise>
                                                <a class="nav-item nav-link active text-center colorMoradoLight texto-tab" id="nav-bienvenida-tab" data-toggle="tab" href="#nav-bienvenida"
                                                   role="tab" aria-controls="nav-bienvenida" aria-selected="false" style="width:50%">INFORMACIÓN</a>

                                                <a class="nav-item nav-link text-center colorMoradoLight texto-tab" id="nav-solicitud-tab" data-toggle="tab" href="#solicitud" role="tab"
                                                   aria-controls="nav-solicitud" aria-selected="true" style="width:50%"><!--<i
                                                        class="fas fa-check-circle text-success mr-2"></i>-->SOLICITUD</a>
                                                </c:otherwise>

                                        </c:choose>

                                    </div>
                                </nav>

                                <div class="tab-content dark" id="nav-tabContent">

                                    <!-- Solicitud -->

                                    <div class="tab-pane fade white mt-5" id="solicitud" role="tabpanel" aria-labelledby="nav-solicitud-tab">

                                        <!-- Aviso -->
                                        <div class="row justify-content-center">

                                            <div class="col-12 text-center">
                                                <p class="display-4 tituloPreConsulta">Solicitud a preconsulta</p>
                                            </div>

                                            <div class="col-12 text-center">
                                                <p class="display-4 subPreConsulta">Para solicitar una cita a la preconsulta,
                                                    sube todos los documentos que se piden a continuación.</p>
                                                <hr>
                                            </div>

                                        </div>

                                        <form>

                                            <div class="row mt-5">
                                                <div class="col-12">


                                                    <!-- Genero -->
                                                    <div class="row">
                                                        <div class="col-xl-3 col-lg-3 col-md-3 col-sm-12 text-center">
                                                            <span class="textoDocumento">Sexo</span>
                                                        </div>

                                                        <div class="col-xl-8 col-lg-8 col-md-8 col-sm-12 col-12 text-center">
                                                            <div class="form-check form-check-inline">
                                                                <input class="form-check-input" name="generoMasculino" type="radio" id="masculino" value="masculino">
                                                                <label class="form-check-label" for="masculino"><i class="fas fa-male"></i>
                                                                    Hombre</label>
                                                            </div>
                                                            <div class="form-check form-check-inline">
                                                                <input class="form-check-input" name="generoFemenino" type="radio" id="femenino" value="femenino">
                                                                <label class="form-check-label" for="femenino"><i class="fas fa-female"></i>
                                                                    Mujer</label>
                                                            </div>
                                                        </div>
                                                    </div>

                                                    <!-- Necesidades Especiales -->
                                                    <div class="row mt-4">
                                                        <div class="col-xl-3 col-lg-3 col-md-3 col-sm-12 text-center mb-2">
                                                            <span class="textoDocumento">Necesidades Especiales</span>
                                                        </div>

                                                        <div class="col-xl-8 col-lg-8 col-md-8 col-sm-12 col-12 text-center">

                                                            <div class="form-check form-check-inline">

                                                                <input class="form-check-input" name="sillaRuedas" type="checkbox" id="sillaRuedas" value="sillaRuedas">

                                                                <!--<input class="form-check-input" name="sillaRuedas"type="checkbox" id="sillaRuedas" value="sillaRuedas">-->

                                                                <label class="form-check-label" for="sillaRuedas"> <i class="fas fa-wheelchair"></i>
                                                                    Silla de ruedas
                                                                </label>
                                                            </div>

                                                            <div class="form-check form-check-inline">
                                                                <input class="form-check-input" name="camilla" type="checkbox" id="camilla" value="camilla">
                                                                <label class="form-check-label" for="camilla"><img src="data:image/svg+xml;utf8;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iaXNvLTg4NTktMSI/Pgo8IS0tIEdlbmVyYXRvcjogQWRvYmUgSWxsdXN0cmF0b3IgMTguMS4xLCBTVkcgRXhwb3J0IFBsdWctSW4gLiBTVkcgVmVyc2lvbjogNi4wMCBCdWlsZCAwKSAgLS0+CjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB4bWxuczp4bGluaz0iaHR0cDovL3d3dy53My5vcmcvMTk5OS94bGluayIgdmVyc2lvbj0iMS4xIiBpZD0iQ2FwYV8xIiB4PSIwcHgiIHk9IjBweCIgdmlld0JveD0iMCAwIDM5Ni40ODEgMzk2LjQ4MSIgc3R5bGU9ImVuYWJsZS1iYWNrZ3JvdW5kOm5ldyAwIDAgMzk2LjQ4MSAzOTYuNDgxOyIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSIgd2lkdGg9IjI0cHgiIGhlaWdodD0iMjRweCI+CjxnPgoJPGcgaWQ9IkxheWVyXzVfNDdfIj4KCQk8Zz4KCQkJPHBhdGggZD0iTTM0OS41NDEsNjMuNTA4Yy04LjMwNCwwLTE1LjQ5NSw0Ljc3Ny0xOS4wMTYsMTEuNzIyYy0wLjM5LDAuNzctMS4wMTMsMi4zODctMy42NzksMi4zODdoLTk2LjY2NyAgICAgYy0yLjE2NywwLTIuOTU3LTAuOTcxLTMuMzk0LTEuNDM2Yy01LjQxNy01Ljc1Ny0xMy4wOTgtOS4zNTYtMjEuNjA3LTkuMzU2aC0wLjI2NGwtODguMzY5LDYuNjggICAgIGMtMi43LDAuMjQtMi44ODgtMS4wOTMtMy4wMzMtMS43MzJjLTQuNTA4LTE5LjgwMi0yMi4yNDUtMzQuNjI5LTQzLjM5Mi0zNC42MjljLTI0LjU0NCwwLTQ0LjUxMiwxOS45NjgtNDQuNTEyLDQ0LjUxMiAgICAgczE5Ljk2OCw0NC41MTMsNDQuNTEyLDQ0LjUxM2MwLjQ1LDAsMjc4LjYyMiwwLDI3OS40MiwwYzExLjc2MywwLDIxLjMzMy05LjM5NiwyMS4zMzMtMjEuMTZWODQuODQyICAgICBDMzcwLjg3NCw3My4wNzgsMzYxLjMwNCw2My41MDgsMzQ5LjU0MSw2My41MDh6IiBmaWxsPSIjMDAwMDAwIi8+CgkJCTxwYXRoIGQ9Ik0zNzQuMjU3LDE1MS41NUgyMi4yMjRDOS45NywxNTEuNTUsMCwxNjEuNTIsMCwxNzMuNzc0djMwLjQ0NGMwLDEyLjI1NCw5Ljk2OSwyMi4yMjQsMjIuMjI0LDIyLjIyNCAgICAgYzAsMCw4Ni40NjYsMCwxMTUuMjg4LDBjMi4xODgsMCwzLjY4MywxLjM3NywzLjY4MywxLjM3N2wzNi44NDYsMzMuNDNjMCwwLDEuNDEzLDEuNjI3LTAuMTgyLDMuMDY0ICAgICBjLTEzLjg3NywxMi40OTQtNTIuNDQ5LDQ3LjU4MS01Mi40NDksNDcuNTgxYy0yLjQzOSwyLjE4NS01LjIwOSwxLjYwOC02LjY2LDEuNTAzYy0wLjU1Mi0wLjA0LTEuMTA5LTAuMDYxLTEuNjcxLTAuMDYxICAgICBjLTEyLjY4MiwwLTIzLDEwLjMxNy0yMywyM2MwLDEyLjY4MiwxMC4zMTgsMjMsMjMsMjNzMjMtMTAuMzE4LDIzLTIzYzAtMS4yNjUtMC42OTItMy4zNDIsMS43Mi01LjU1MWw1NC43NTQtNDkuNjc3ICAgICBjMCwwLDEuNTk5LTEuNjE1LDMuMzkzLDAuMDE1YzE0Ljc1NCwxMy40MDIsNTQuNzQxLDQ5LjY2OCw1NC43NDEsNDkuNjY4YzEuODY3LDEuNzg3LDEuNzE1LDQuMjgsMS43MTUsNS41NDUgICAgIGMwLDEyLjY4MiwxMC4zMTgsMjMsMjMsMjNzMjMtMTAuMzE4LDIzLTIzYzAtMTIuNjgzLTEwLjMxOC0yMy0yMy0yM2MtMi4wMzksMC01LjI2NSwwLjk5Mi03LjMzOC0wLjUzNmwtNTMuNjYxLTQ4LjY4NiAgICAgYzAsMC0xLjYwNi0xLjMzNiwwLjAxMS0yLjg0YzkuMzY0LTguNzExLDM2LjUyNC0zMy4xMzksMzYuNTI0LTMzLjEzOXMxLjYxNi0xLjY5Myw0LjM2Ni0xLjY5M2MyOC43MzgsMCwxMTQuOTUzLDAsMTE0Ljk1MywwICAgICBjMTIuMjU0LDAsMjIuMjI0LTkuOTcsMjIuMjI0LTIyLjIyNHYtMzAuNDQ0QzM5Ni40ODEsMTYxLjUxOSwzODYuNTEyLDE1MS41NSwzNzQuMjU3LDE1MS41NXogTTE5OC4yNDEsMjQ1LjExOSAgICAgYy0wLjc5MSwwLTEuMjI2LTAuNDExLTEuMjI2LTAuNDExbC0xOC4zOTgtMTYuNjkxYzAsMC0wLjg5Ni0xLjU3NSwxLjQ1OC0xLjU3NWM5Ljg4MSwwLDI3LjQ2OCwwLDM2LjIzMywwICAgICBjMy4yODgsMCwxLjUxNywxLjYwOSwxLjUxNywxLjYwOWwtMTguMzM4LDE2LjYzOEMxOTkuNDg4LDI0NC42ODgsMTk5LjA3NSwyNDUuMTE5LDE5OC4yNDEsMjQ1LjExOXoiIGZpbGw9IiMwMDAwMDAiLz4KCQk8L2c+Cgk8L2c+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPC9zdmc+Cg=="
                                                                                                                   /> Camilla
                                                                </label>
                                                            </div>

                                                            <div class="form-check form-check-inline">
                                                                <input class="form-check-input" name="baston" type="checkbox" id="baston" value="baston">
                                                                <label class="form-check-label" for="baston"> <i class="fas fa-blind"></i>
                                                                    Bastón</label>
                                                            </div>

                                                            <div class="form-check form-check-inline">
                                                                <input class="form-check-input" name="oxigeno" type="checkbox" id="oxigeno" value="oxigeno">
                                                                <label class="form-check-label" for="inlineCheckbox2"> <img src="data:image/svg+xml;utf8;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iaXNvLTg4NTktMSI/Pgo8IS0tIEdlbmVyYXRvcjogQWRvYmUgSWxsdXN0cmF0b3IgMTkuMC4wLCBTVkcgRXhwb3J0IFBsdWctSW4gLiBTVkcgVmVyc2lvbjogNi4wMCBCdWlsZCAwKSAgLS0+CjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB4bWxuczp4bGluaz0iaHR0cDovL3d3dy53My5vcmcvMTk5OS94bGluayIgdmVyc2lvbj0iMS4xIiBpZD0iQ2FwYV8xIiB4PSIwcHgiIHk9IjBweCIgdmlld0JveD0iMCAwIDYwIDYwIiBzdHlsZT0iZW5hYmxlLWJhY2tncm91bmQ6bmV3IDAgMCA2MCA2MDsiIHhtbDpzcGFjZT0icHJlc2VydmUiIHdpZHRoPSIyNHB4IiBoZWlnaHQ9IjI0cHgiPgo8Zz4KCTxwYXRoIGQ9Ik0yMi41LDQ4aC0ydi0xaC0yMHY4Ljk4MUMwLjUsNTguMTk3LDIuMzAzLDYwLDQuNTE4LDYwaDExLjk2NGMyLjIxNSwwLDQuMDE4LTEuODAzLDQuMDE4LTQuMDE5VjUzaDJ2Mi45ODEgICBjMCwyLjIxNiwxLjgwMyw0LjAxOSw0LjAxOCw0LjAxOWgxMS45NjRjMi4yMTUsMCw0LjAxOC0xLjgwMyw0LjAxOC00LjAxOVY0N2gtMjBWNDh6IE0yMi41LDUxaC0ydi0xaDJWNTF6IiBmaWxsPSIjMDAwMDAwIi8+Cgk8cmVjdCB4PSIyMi41IiB5PSIzMyIgd2lkdGg9IjIwIiBoZWlnaHQ9IjEyIiBmaWxsPSIjMDAwMDAwIi8+Cgk8cmVjdCB4PSIwLjUiIHk9IjMzIiB3aWR0aD0iMjAiIGhlaWdodD0iMTIiIGZpbGw9IiMwMDAwMDAiLz4KCTxwYXRoIGQ9Ik01Ni40NzMsNDYuNTM2Yy0wLjE5MS0xLjY1LTEuMzk4LTIuOTg0LTIuOTczLTMuMzkzdi0wLjY5OWMwLjU5MSwwLjM0NCwxLjI2OCwwLjU1NiwyLDAuNTU2YzIuMjA2LDAsNC0xLjc5NCw0LTQgICBzLTEuNzk0LTQtNC00Yy0wLjczMiwwLTEuNDA5LDAuMjEyLTIsMC41NTZWMjFjMC01LjUxNC00LjQ4Ni0xMC0xMC0xMGgtN1Y5aC0zVjcuNDQ0QzM0LjA5MSw3Ljc4OCwzNC43NjgsOCwzNS41LDggICBjMi4yMDYsMCw0LTEuNzk0LDQtNHMtMS43OTQtNC00LTRjLTEuMiwwLTIuMjY2LDAuNTQyLTMsMS4zODJDMzEuNzY2LDAuNTQyLDMwLjcsMCwyOS41LDBjLTIuMjA2LDAtNCwxLjc5NC00LDRzMS43OTQsNCw0LDQgICBjMC43MzIsMCwxLjQwOS0wLjIxMiwyLTAuNTU2VjloLTN2MmgtMTRWOWgtM1Y3LjQ0NEMxMi4wOTEsNy43ODgsMTIuNzY4LDgsMTMuNSw4YzIuMjA2LDAsNC0xLjc5NCw0LTRzLTEuNzk0LTQtNC00ICAgYy0xLjIsMC0yLjI2NiwwLjU0Mi0zLDEuMzgyQzkuNzY2LDAuNTQyLDguNywwLDcuNSwwYy0yLjIwNiwwLTQsMS43OTQtNCw0czEuNzk0LDQsNCw0YzAuNzMyLDAsMS40MDktMC4yMTIsMi0wLjU1NlY5aC0zdjZoMSAgIHYxLjE1OGMtNC4xNiwxLjI5Ny03LDUuMTA5LTcsOS41MzNWMzFoMjB2LTFoMnYxaDIwdi01YzAtNC40OTEtMi45LTguNS03LTkuODNWMTVoMXYtMmg3YzQuNDExLDAsOCwzLjU4OSw4LDh2MjIuMTQzICAgYy0xLjU3NSwwLjQxLTIuNzgyLDEuNzQzLTIuOTczLDMuMzkzQzQ3LjI5Miw0Ny4yMzksNDYuNSw0OC41NTgsNDYuNSw1MHMwLjc5MiwyLjc2MSwyLjAyNywzLjQ2NEM0OC43NTcsNTUuNDUxLDUwLjQ1MSw1Nyw1Mi41LDU3ICAgczMuNzQzLTEuNTQ5LDMuOTczLTMuNTM2QzU3LjcwOCw1Mi43NjEsNTguNSw1MS40NDIsNTguNSw1MFM1Ny43MDgsNDcuMjM5LDU2LjQ3Myw0Ni41MzZ6IE0zNS41LDJjMS4xMDMsMCwyLDAuODk3LDIsMiAgIHMtMC44OTcsMi0yLDJzLTItMC44OTctMi0yUzM0LjM5NywyLDM1LjUsMnogTTEzLjUsMmMxLjEwMywwLDIsMC44OTcsMiwycy0wLjg5NywyLTIsMnMtMi0wLjg5Ny0yLTJTMTIuMzk3LDIsMTMuNSwyeiBNNy41LDYgICBjLTEuMTAzLDAtMi0wLjg5Ny0yLTJzMC44OTctMiwyLTJzMiwwLjg5NywyLDJTOC42MDMsNiw3LjUsNnogTTIyLjUsMjhoLTJ2LTFoMlYyOHogTTI5LjUsMTYuMTU4ICAgYy0zLjk0MSwxLjIyOS02LjY5Myw0LjcxNi02Ljk3Miw4Ljg0MmgtMi4wODFjLTAuMzkzLTQuMDc2LTMuMTU0LTcuNi02Ljk0Ny04LjgzVjE1aDF2LTJoMTR2MmgxVjE2LjE1OHogTTI5LjUsNiAgIGMtMS4xMDMsMC0yLTAuODk3LTItMnMwLjg5Ny0yLDItMnMyLDAuODk3LDIsMlMzMC42MDMsNiwyOS41LDZ6IE01My41LDUyYzAsMC41NTMtMC40NDgsMS0xLDFzLTEtMC40NDctMS0xdi00ICAgYzAtMC41NTMsMC40NDgtMSwxLTFzMSwwLjQ0NywxLDFWNTJ6IiBmaWxsPSIjMDAwMDAwIi8+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPC9zdmc+Cg=="
                                                                                                                            /> Oxígeno
                                                                </label>
                                                            </div>

                                                        </div>
                                                    </div>

                                                    <!-- Identificacion oficial
                                                    -->
                                                    <div class="row mt-4">

                                                        <div class="col-xl-3 col-lg-3 col-md-3 col-sm-12 mb-2 text-center">
                                                            <span class="textoDocumento">Identificación oficial</span>
                                                        </div>

                                                        <div class="custom-file col-xl-8 col-lg-8 col-md-8 col-sm-10 col-10" id="customFile">
                                                            <input type="file" name="fileIdentificacion" class="custom-file-input" id="fileIdentificacion" aria-describedby="fileHelp">
                                                            <span class="text-danger" id="error-identificacionOficial">No es una extensión válida. Puedes subir un archivo .jpg, .jpeg, .png, .pdf o .docx</span>
                                                            <label class="custom-file-label">
                                                                Elegir archivo...
                                                            </label>
                                                        </div>

                                                        <div class="col-xl-1 col-lg-1 col-md-1 col-sm-1 col-1 iconoQuestion align-self-center">
                                                            <a href="#" class="questionMark" data-tooltip-content="#tooltip_content"><i
                                                                    class="fas fa-question-circle"></i></a>
                                                        </div>

                                                        <div class="tooltip_templates">
                                                            <span id="tooltip_content">
                                                                <span>Puedes subir:</span>
                                                                <ul>
                                                                    <li>INE</li>
                                                                    <li>Cartilla del servicio militar</li>
                                                                    <li>Pasaporte</li>
                                                                    <li>Acta de nacimiento</li>
                                                                </ul>
                                                            </span>
                                                        </div>

                                                    </div>

                                                    <!-- CURP
                                                    -->
                                                    <div class="row mt-4">

                                                        <div class="col-xl-3 col-lg-3 col-md-3 col-sm-12 mb-2 text-center">
                                                            <span class="textoDocumento">CURP</span>
                                                            <small id="passwordHelpBlock" class="form-text text-muted">
                                                                Se puede tramitar
                                                                <a class="text-primary" target="_blank" href="https://www.gob.mx/curp/">aquí­</a>
                                                            </small>
                                                        </div>

                                                        <div class="custom-file col-xl-8 col-lg-8 col-md-8 col-sm-12 col-12" id="customFile">
                                                            <input type="file" name="fileCURP" class="custom-file-input centraInput" id="fileCURP" aria-describedby="fileHelp">
                                                            <span class="text-danger" id="error-CURP">No es una extensión válida. Puedes subir un archivo .jpg, .jpeg, .png, .pdf o .docx</span>
                                                            <label class="custom-file-label">
                                                                Elegir archivo...
                                                            </label>
                                                        </div>

                                                    </div>

                                                    <!-- Comprobante de domicilio -->

                                                    <div class="row mt-4">

                                                        <div class="col-xl-3 col-lg-3 col-md-3 col-sm-12 mb-2 text-center">
                                                            <span class="textoDocumento">Comprobante de domicilio</span>
                                                            <small id="passwordHelpBlock" class="form-text text-muted">
                                                                Vigencia no mayor a 3 meses.
                                                            </small>
                                                        </div>

                                                        <div class="custom-file col-xl-8 col-lg-8 col-md-8 col-sm-11 col-11" id="customFile">
                                                            <input type="file" name="fileComprobanteDomicilio" class="custom-file-input" id="fileComprobanteDomicilio" aria-describedby="fileHelp">
                                                            <span class="text-danger" id="error-comprobanteDomicilio">No es una extensión válida. Puedes subir un archivo .jpg, .jpeg, .png, .pdf o .docx</span>
                                                            <label class="custom-file-label">
                                                                Elegir archivo...
                                                            </label>
                                                        </div>

                                                        <div class="col-xl-1 col-lg-1 col-md-1 col-sm-1 col-1 iconoQuestion">
                                                            <a href="#" class="questionMark" data-tooltip-content="#tooltip_content3"><i
                                                                    class="fas fa-question-circle"></i></a>
                                                        </div>

                                                        <div class="tooltip_templates">
                                                            <span id="tooltip_content3">
                                                                <span>Puedes subir:</span>
                                                                <ul>
                                                                    <li>Estado de cuenta</li>
                                                                    <li>Recibo de impuesto predial</li>
                                                                    <li>Recibo de servicio de luz</li>
                                                                    <li>Recibo de servicio de agua</li>
                                                                    <li>Recibo de servicio de teléfono</li>
                                                                    <li>Recibo de servicio de internet</li>
                                                                </ul>

                                                            </span>
                                                        </div>

                                                    </div>

                                                    <!-- Motivo de la consulta -->

                                                    <div class="row mt-4" id="formMotivoConsulta">

                                                        <div class="col-xl-3 col-lg-3 col-md-3 col-sm-12 col-12 text-center">
                                                            <span class="textoDocumento">Motivo de la consulta</span>
                                                        </div>

                                                        <div class="col-xl-8 col-lg-8 col-md-8 col-sm-12 col-12 removePadding">
                                                            <select class="form-control" id="motivoConsulta">
                                                                <option>Seleccione el motivo de la consulta</option>
                                                                <option value="1">Me envió un médico</option>
                                                                <option value="2">Estudio con diagnóstico de cáncer de mama</option>
                                                                <option value="3">Me sentí una bolita en el seno</option>
                                                                <option value="4">Me envían de otro hospital</option>
                                                                <option value="5">Otro</option>
                                                            </select>
                                                            <span class="text-danger ml-3" id="error-motivoConsulta">No seleccionaste un motivo de consulta</span>
                                                        </div>
                                                    </div>

                                                    <div class="row mt-4" id="documentoAdjuntoMotivo">

                                                        <!--
                                                        <div class="col-3 text-center">
                                                                <span class="textoDocumento">Prueba</span>
                                                        </div>
                                                        <div class="custom-file col-8 p-0 m-0" id="customFile">
                                                                <input type="text" class="form-control" placeholder="Introduce tu hospital de procedencia">                                                        
                                                        </div>  
                                                        -->
                                                    </div>

                                                    <div class="row mt-4 mb-4" id="otroHospital">

                                                        <!--
                                                            <div class="col-3 text-center">
                                                                    <span class="textoDocumento">Prueba</span>
                                                            </div>
                                                            <div class="custom-file col-8 p-0 m-0" id="customFile">
                                                                    <input type="text" class="form-control" placeholder="Introduce tu hospital de procedencia">                                                        
                                                            </div>  
                                                        -->
                                                    </div>

                                                    <!-- Estudios previos Mastografí­a-->

                                                    <div class="row mt-1">
                                                        <div class="col-xl-3 col-lg-3 col-md-3 col-sm-12 col-12 mb-2 text-center">
                                                            <span class="textoDocumento">Reporte de resultados de estudios previos
                                                                mastografía
                                                            </span>
                                                        </div>

                                                        <div class="custom-file col-xl-8 col-lg-8 col-md-8 col-sm-11 col-11" id="customFileMasto">
                                                            <input type="file" name="fileEstudioPrevioMasto" class="custom-file-input" id="fileEstudioPrevioMasto" aria-describedby="fileHelp">
                                                            <span class="text-danger" id="error-previoMasto">No es una extensión válida. Puedes subir un archivo .jpg, .jpeg, .png, .pdf o .docx</span>
                                                            <label class="custom-file-label">
                                                                Elegir archivo...
                                                            </label>
                                                        </div>

                                                        <div class="col-1 iconoQuestion align-self-center mb-4">
                                                            <a href="#" class="questionMark" data-tooltip-content="#tooltip_content2"><i
                                                                    class="fas fa-question-circle"></i></a>
                                                        </div>

                                                        <div class="tooltip_templates">
                                                            <span id="tooltip_content2">
                                                                <div class="row">
                                                                    <div class="col-12 text-center">
                                                                        Resultado de mastrografía
                                                                    </div>
                                                                </div>
                                                                <div class="row mt-2">
                                                                    <div class="col-12 text-center">
                                                                        <strong>Ejemplo de reporte de mastografía: </strong>
                                                                    </div>
                                                                </div>
                                                                <div class="row mt-2">
                                                                    <div class="col-12 text-center">
                                                                        <img style="width:280px" src="img/Masto.jpeg" alt="">
                                                                    </div>
                                                                </div>
                                                            </span>

                                                        </div>
                                                    </div>

                                                    <!-- Estudios previos Ultrasonido -->

                                                    <div class="row mt-4">
                                                        <div class="col-xl-3 col-lg-3 col-md-3 col-sm-12 col-12 mb-12 text-center">
                                                            <span class="textoDocumento">Reporte de resultados de estudios previos
                                                                ultrasonido
                                                            </span>
                                                        </div>

                                                        <div class="custom-file col-xl-8 col-lg-8 col-md-8 col-sm-11 col-11" id="customFileUsg">
                                                            <input type="file" name="fileEstudioPrevioUsg" class="custom-file-input" id="fileEstudioPrevioUsg" aria-describedby="fileHelp">
                                                            <span class="text-danger" id="error-previoUsg">No es una extensión válida. Puedes subir un archivo .jpg, .jpeg, .png, .pdf o .docx</span>
                                                            <label class="custom-file-label">
                                                                Elegir archivo...
                                                            </label>
                                                        </div>

                                                        <div class="col-1 iconoQuestion align-self-center mb-4">
                                                            <a href="#" class="questionMark" data-tooltip-content="#tooltip_content6"><i
                                                                    class="fas fa-question-circle"></i></a>
                                                        </div>


                                                        <div class="tooltip_templates">
                                                            <span id="tooltip_content6">
                                                                <div class="row">
                                                                    <div class="col-12 text-center">
                                                                        Resultado de ultrasonido
                                                                    </div>
                                                                </div>
                                                                <div class="row mt-2">
                                                                    <div class="col-12 text-center">
                                                                        <strong>Ejemplo de reporte de ultrasonido: </strong>
                                                                    </div>
                                                                </div>
                                                                <div class="row">
                                                                    <div class="col-12 text-center">
                                                                        <img style="width:280px" src="img/Ultra.jpeg" alt="">
                                                                    </div>
                                                                </div>
                                                            </span>

                                                        </div>
                                                    </div>

                                                    <!-- Biopsia o tratamiento  -->

                                                    <div class="row mt-4">

                                                        <div class="col-xl-3 col-lg-3 col-md-3 col-sm-12 col-12 mb-2 text-center">
                                                            <div class="form-check">
                                                                <input class="form-check-input" name="biopsiaInput" type="checkbox" id="biopsiaInput">
                                                                <label class="form-check-label textoDocumento">
                                                                    ¿Te han hecho una biopsia previamente?
                                                                </label>
                                                            </div>
                                                        </div>

                                                        <div class="custom-file col-xl-8 col-lg-8 col-md-8 col-sm-11 col-11" id="biopsiaContenedor">
                                                            <input type="file" class="custom-file-input" id="fileEstudioBiopsia" name="fileEstudioBiopsia" aria-describedby="fileHelp">
                                                            <span class="text-danger" id="error-biopsia">No es una extensión válida. Puedes subir un archivo .jpg, .jpeg, .png, .pdf o .docx</span>
                                                            <label class="custom-file-label">
                                                                Elegir archivo...
                                                            </label>


                                                        </div>

                                                        <div class="col-1 iconoQuestion align-self-center" id="biopsiaQuestion">
                                                            <a href="#" class="questionMark" data-tooltip-content="#tooltip_content4"><i
                                                                    class="fas fa-question-circle"></i></a>
                                                        </div>


                                                        <div class="tooltip_templates">
                                                            <span id="tooltip_content4">
                                                                <div class="row mt-2">
                                                                    <div class="col-12 text-center">
                                                                        <strong>Ejemplo de reporte de patología: </strong>
                                                                    </div>
                                                                </div>
                                                                <div class="row mt-2">
                                                                    <div class="col-12 text-center">
                                                                        <img style="width:280px" src="img/Biopsia.jpeg" alt="">
                                                                    </div>
                                                                </div>
                                                            </span>
                                                        </div>

                                                    </div>

                                                    <!-- Botones -->

                                                    <div class="row justify-content-center mt-5">
                                                        <div class="col-4 col-xl-4 col-lg-4 col-md-6 col-sm-12 col-12 mb-2">
                                                            <button class="btn btn-morado btn-block" id="btn-enviarSolicitud" style="border-radius:20px"><i
                                                                    class="fas fa-check-circle mr-2"></i>Enviar</button>
                                                        </div>
                                                        <div class="col-xl-4 col-lg-4 col-md-6 col-sm-12 col-12 mb-2">
                                                            <button class="btn btn-guardar-continuar btn-block" style="border-radius:20px"><i
                                                                    class="fas fa-save mr-2"></i>Guardar y Continuar Después</button>
                                                        </div>
                                                    </div>


                                                </div>
                                            </div>
                                        </form>

                                    </div>

                                    <!-- APROBACION -->



                                    <div class="tab-pane fade white mt-4" id="nav-contact" role="tabpanel" aria-labelledby="nav-contact-tab">
                                        <div class="card mb-3">
                                            <img class="card-img-top mt-3" style="width: 100px; display:block; margin:auto;" src="img/success2.png" alt="Card image cap">
                                            <div class="card-body">

                                                <c:choose>
                                                    <c:when test="${sessionScope.estadoPaciente==1}">
                                                        <div class="row">
                                                            <div class="col-12">
                                                                <h5 class="card-title display-4 tituloAprobacion text-center">Tu solicitud
                                                                    ha sido aprobada <br> como paciente de <strong><span class="colorMoradoLight">primera
                                                                            vez
                                                                        </span></strong></h5>
                                                                <p class="card-text text-center subTituloAprobacion">La preconsulta del
                                                                    Departamento de Tumores Mamarios consta de <strong><span class="text-secondary">dos
                                                                            días
                                                                        </span></strong> consecutivos</p>
                                                                <hr>
                                                            </div>
                                                        </div>

                                                        <div class="row">
                                                            <div class="col-12">
                                                                <div class="row justify-content-center mb-2">
                                                                    <div class="col-12 text-center">
                                                                        <i class="fas fa-dollar-sign text-success text-center" style="font-size:100px"></i>
                                                                    </div>
                                                                </div>
                                                                <h5 class="card-title display-4 tituloPago text-center mt-3">Pago</h5>
                                                                <div class="row mb-4">
                                                                    <div class="col-12 text-center">
                                                                        <span class="text-secondary display-4" style="font-size:30px;">Realiza
                                                                            el pago para la preconsulta:</span>
                                                                    </div>
                                                                </div>
                                                                <div class="row">
                                                                    <div class="col-12 text-center">
                                                                        <ul class="text-secondary" style="list-style:none;">
                                                                            <li>-<strong>Banco:</strong> SANTANDER(En ventanilla del
                                                                                banco)
                                                                            </li>
                                                                            <li>-<strong>Costo:</strong> $176.00 MXN </li>
                                                                            <li>-<strong>Cuenta de banco:</strong> 65502136912</li>
                                                                        </ul>
                                                                    </div>
                                                                </div>

                                                                <hr>
                                                            </div>
                                                        </div>

                                                        <div class="row">
                                                            <div class="col-12">
                                                                <div class="row justify-content-center mb-2">
                                                                    <div class="col-12 text-center">
                                                                        <i class="far fa-file-alt text-muted text-center" style="font-size:100px"></i>
                                                                    </div>
                                                                </div>
                                                                <h5 class="card-title display-4 tituloPago text-center">Documentos</h5>
                                                            </div>
                                                        </div>

                                                        <div class="row mb-3">
                                                            <div class="col-12 text-center">
                                                                <span class="text-secondary">Debes traer todos los siguientes documentos:
                                                                </span>
                                                            </div>
                                                        </div>

                                                        <div class="row justify-content-center">
                                                            <div class="col-7 ml-5 text-secondary">
                                                                <ul style="list-style:none">
                                                                    <li>-IFE/INE</li>
                                                                    <li>-Comprobante de domicilio</li>
                                                                    <li>-Poliza de seguro popular (si tienes)</li>
                                                                    <li>-Estudios previos por los que te mandan al INCan, pueden ser:
                                                                        <ul style="list-style:none" class="justificar">
                                                                            <li>
                                                                                <strong>Mastografía:</strong>
                                                                                Imágenes y reporte de resultado.<a class="questionMark icono-info2 fas fa-question-circle"
                                                                                                                   style="background: #fff;" href="#" data-tooltip-content="#tooltip_contentmasto"></a></li>
                                                                            <li><strong>Ultrasonido de mama:</strong>
                                                                                Imágenes y reporte de resultado.<a style="background: #fff;"
                                                                                                                   href="#" class="questionMark icono-info2 fas fa-question-circle"
                                                                                                                   data-tooltip-content="#tooltip_contentultra"></a></li>
                                                                            <li><strong>Biopsia:</strong>
                                                                                Reporte de patología, laminillas y bloques de parafina.<a
                                                                                    style="background: #fff;" href="#" class="questionMark icono-info2 fas fa-question-circle"
                                                                                    data-tooltip-content="#tooltip_contentbiopsia"></a></li>
                                                                        </ul>
                                                                    </li>
                                                                </ul>
                                                            </div>
                                                        </div>

                                                        <div class="row">
                                                            <div class="col-12">
                                                                <hr>
                                                            </div>
                                                        </div>

                                                        <div class="row">
                                                            <div class="col-12">
                                                                <div class="row justify-content-center mb-2">
                                                                    <div class="col-12 text-center">
                                                                        <i class="fas fa-x-ray colorIconos" style="font-size:80px"></i>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>

                                                        <div class="row">
                                                            <div class="col-12">
                                                                <h5 class="card-title display-4 tituloPago text-center">Día Uno
                                                                </h5>
                                                            </div>
                                                        </div>

                                                        <div id="accordion">
                                                            <div class="card">
                                                                <div class="card-header" id="headingOne">
                                                                    <h5 class="mb-0">
                                                                        <button class="btn btn-link colorMoradoLight" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                                                            UBICACIÓN Y HORARIO
                                                                        </button>
                                                                    </h5>
                                                                </div>

                                                                <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordion">
                                                                    <div class="card-body m-3 justificar">
                                                                        Tu cita es a las <strong>7:50 am</strong>, favor de llegar puntual
                                                                        para no perderla.
                                                                        <p>Debes llegar al área de preconsulta, el acceso es por la entrada
                                                                            principal del <a class="text-primary" target="_blank" href="https://goo.gl/maps/q2VdVP2RdMQ2">edificio
                                                                                antiguo (Av. San Fernando #22)</a> , para que te permitan
                                                                            la entrada debes mostrar <strong>tu comprobante de pago
                                                                            </strong>.</p>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="card">
                                                                <div class="card-header" id="headingTwo">
                                                                    <h5 class="mb-0">
                                                                        <button class="btn btn-link colorMoradoLight collapsed" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false"
                                                                                aria-controls="collapseTwo">
                                                                            ¿EN QUÉ CONSISTE?
                                                                        </button>
                                                                    </h5>
                                                                </div>
                                                                <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordion">
                                                                    <div class="card-body m-3 justificar">
                                                                        El primer día nuestro servicio de <strong>navegación</strong>
                                                                        te recibirá¡ en el área de preconsulta, te llamarán por tu nombre y te pedirán estudios previos que tengas. Al terminar, ellas
                                                                        te navegarán por el hospital y te llevarán al servicio de imagenología,
                                                                        donde te harán los estudios de <strong>mastografía</strong>
                                                                        y
                                                                        <strong>ultrasonido de mama</strong>. Es requisito del hospital
                                                                        que estos estudios se hagan aquí, aunque ya te los hayan hecho
                                                                        en otro lugar. También, el médico valorará¡ si necesitas que te
                                                                        realicen una biopsia, si ya te realizaron una biopsia fuera del
                                                                        INCan debes pedir las laminillas y bloques de parafina en el
                                                                        lugar en que te realizaste la biopsia y traerlos para que los
                                                                        vuelvan a analizar aquí.

                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="card">
                                                                <div class="card-header" id="headingThree">
                                                                    <h5 class="mb-0">
                                                                        <button class="btn btn-link colorMoradoLight collapsed" data-toggle="collapse" data-target="#collapseThree" aria-expanded="false"
                                                                                aria-controls="collapseThree">
                                                                            INDICACIONES
                                                                        </button>
                                                                    </h5>
                                                                </div>
                                                                <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordion">
                                                                    <div class="card-body m-3 justificar">
                                                                        <div class="row justify-content-center">
                                                                            <div class="col-9 ml-5">
                                                                                <ul style="list-style:none">
                                                                                    <li>1.- Debes venir depilada de las axilas. No te
                                                                                        apliques ningún producto (cremas, talco, desodorante,
                                                                                        perfume, ungúentos, etc).</li>

                                                                                    <li>2.- Trae dinero para pagar tus estudios:
                                                                                        <ul style="list-style:none" class="justificar">
                                                                                            <li>-El costo de la mastografía y el ultrasonido
                                                                                                es de <strong>$695.00 MXN (Obligatorio)
                                                                                                </strong></li>
                                                                                            <li>-El costo de la biopsia es de
                                                                                                <strong>$1300.00 MXN</strong>
                                                                                                aproximadamente, aunque no es indispensable, es preferible que vengas preparada para que te la realicen ese día. Es muy importante
                                                                                                hacer este estudio lo más pronto posible.</li>
                                                                                        </ul>
                                                                                    </li>
                                                                                </ul>
                                                                            </div>
                                                                        </div>

                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>

                                                        <div class="row mt-4">
                                                            <div class="col-12">
                                                                <hr>
                                                            </div>
                                                        </div>

                                                        <div class="row">
                                                            <div class="col-12">
                                                                <div class="row justify-content-center mb-2">
                                                                    <div class="col-12 text-center">
                                                                        <i class="fas fa-user-md colorIconos" style="font-size:100px"></i>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>

                                                        <div class="row mt-4">
                                                            <div class="col-12">
                                                                <h5 class="card-title display-4 tituloPago text-center">Día Dos
                                                                </h5>
                                                            </div>
                                                        </div>

                                                        <div id="accordion2">
                                                            <div class="card">
                                                                <div class="card-header" id="headingSecondOne">
                                                                    <h5 class="mb-0">
                                                                        <button class="btn btn-link colorMoradoLight" data-toggle="collapse" data-target="#collapseSecondOne" aria-expanded="true"
                                                                                aria-controls="collapseSecondOne">
                                                                            UBICACIÓN Y HORARIO
                                                                        </button>
                                                                    </h5>
                                                                </div>

                                                                <div id="collapseSecondOne" class="collapse show" aria-labelledby="headingSecondOne" data-parent="#accordion2">
                                                                    <div class="card-body m-3 justificar">
                                                                        Tu cita es a las <strong>7:50 am</strong>, favor de llegar puntual
                                                                        para no perderla.
                                                                        <p>Debes llegar al área de preconsulta, el acceso es por la entrada
                                                                            principal del <a class="text-primary" target="_blank" href="https://goo.gl/maps/q2VdVP2RdMQ2">edificio
                                                                                antiguo (Av. San Fernando #22)</a> , para que te permitan
                                                                            la entrada debes mostrar <strong>tu comprobante de pago
                                                                            </strong>.</p>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="card">
                                                                <div class="card-header" id="headingSecondTwo">
                                                                    <h5 class="mb-0">
                                                                        <button class="btn btn-link colorMoradoLight collapsed" data-toggle="collapse" data-target="#collapseSecondTwo" aria-expanded="false"
                                                                                aria-controls="collapseSecondTwo">
                                                                            ¿EN QUÉ CONSISTE?
                                                                        </button>
                                                                    </h5>
                                                                </div>
                                                                <div id="collapseSecondTwo" class="collapse" aria-labelledby="headingSecondTwo" data-parent="#accordion2">
                                                                    <div class="card-body m-3 justificar">
                                                                        El segundo día pasarás a <strong>consulta</strong> con el médico,
                                                                        revisará todos tus estudios, te explicará¡ si necesitas otros
                                                                        y te dirá¡ que sigue. Al igual que el primer día ,nuestro servicio
                                                                        de navegación te recibirá¡ en el área de preconsulta,  nuevamente
                                                                        te pedirán los documentos que entregaste el día anterior. Si
                                                                        te realizaron una biopsia fuera del INCan debes traer dos copias
                                                                        del reporte de patología que contiene los resultados. Al terminar,
                                                                        ellas te solicitarán pasar a la sala de espera mientras el médico
                                                                        te recibe.


                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="card">
                                                                <div class="card-header" id="headingSecondThree">
                                                                    <h5 class="mb-0">
                                                                        <button class="btn btn-link colorMoradoLight collapsed" data-toggle="collapse" data-target="#collapseSecondThree" aria-expanded="false"
                                                                                aria-controls="collapseSecondThree">
                                                                            RECOMENDACIONES
                                                                        </button>
                                                                    </h5>
                                                                </div>
                                                                <div id="collapseSecondThree" class="collapse" aria-labelledby="headingSecondThree" data-parent="#accordion2">
                                                                    <div class="card-body m-3 justificar">
                                                                        El médico decidirá el orden en el que pasen las pacientes, debes venir con disponibilidad de tiempo, desayunada y te recomendamos
                                                                        traer un libro o revista. Al finalizar tu consulta el médico
                                                                        te pude pedir diversos estudios, el costo de estos estudios está
                                                                        entre <strong>$350.00
                                                                            MXN
                                                                        </strong>Â y
                                                                        <strong>$3000.00 MNX</strong>Â te recomendamos vengas preparada con
                                                                        esa cantidad de dinero para que los puedas agendar y agilizar
                                                                        el proceso de tu atención.


                                                                    </div>
                                                                </div>
                                                            </div>

                                                            <hr>
                                                            <div class="row justify-content-center mt-3">
                                                                <div class="col-4 text-center">
                                                                    <a href="documentos/reportePrimeraVez.pdf" download>
                                                                        <button style="border-radius:20px" type="button" class="btn btn-morado btn-block"><i
                                                                                class="fas fa-print"></i> Imprimir información
                                                                        </button>
                                                                    </a>
                                                                </div>
                                                            </div>
                                                        </div>



                                                    </c:when>

                                                    <c:otherwise>

                                                        <div class="row">
                                                            <div class="col-12">
                                                                <h5 class="card-title display-4 tituloAprobacion text-center">Tu solicitud
                                                                    ha sido aprobada <br> como paciente de <strong><span class="colorMoradoLight">segunda opinion
                                                                        </span></strong></h5>
                                                                <p class="card-text text-center subTituloAprobacion">Los mejores resultados para tratar el cáncer de mama se obtienen si recibes atención continua en un solo lugar.</p>
                                                                <p class="card-text text-center subTituloAprobacion">Te recomendamos que si ya estás siendo atendida continúes ahí mismo tu proceso de tratamiento.</p>
                                                                <p class="card-text text-center subTituloAprobacion">Te recordamos que el hospital da prioridad a pacientes que no han tenido la oportunidad de recibir ningún tratamiento</p>
                                                                <hr>
                                                            </div>
                                                        </div>

                                                        <div class="row">
                                                            <div class="col-12">
                                                                <div class="row justify-content-center mb-2">
                                                                    <div class="col-12 text-center">
                                                                        <i class="fas fa-dollar-sign text-success text-center" style="font-size:100px"></i>
                                                                    </div>
                                                                </div>
                                                                <h5 class="card-title display-4 tituloPago text-center mt-3">Pago</h5>
                                                                <div class="row mb-4">
                                                                    <div class="col-12 text-center">
                                                                        <span class="text-secondary display-4" style="font-size:30px;">Realiza
                                                                            el pago para la preconsulta:</span>
                                                                    </div>
                                                                </div>
                                                                <div class="row">
                                                                    <div class="col-12 text-center">
                                                                        <ul class="text-secondary" style="list-style:none;">
                                                                            <li>-<strong>Banco:</strong> SANTANDER(En ventanilla del
                                                                                banco)
                                                                            </li>
                                                                            <li>-<strong>Costo:</strong> $176.00 MXN </li>
                                                                            <li>-<strong>Cuenta de banco:</strong> 65502136912</li>
                                                                        </ul>
                                                                    </div>
                                                                </div>

                                                                <hr>
                                                            </div>
                                                        </div>

                                                        <div class="row">
                                                            <div class="col-12">
                                                                <div class="row justify-content-center mb-2">
                                                                    <div class="col-12 text-center">
                                                                        <i class="far fa-file-alt text-muted text-center" style="font-size:100px"></i>
                                                                    </div>
                                                                </div>
                                                                <h5 class="card-title display-4 tituloPago text-center">Documentos</h5>
                                                            </div>
                                                        </div>

                                                        <div class="row mb-3">
                                                            <div class="col-12 text-center">
                                                                <span class="text-secondary">Debes traer todos los siguientes documentos:
                                                                </span>
                                                            </div>
                                                        </div>

                                                        <div class="row justify-content-center">
                                                            <div class="col-7 ml-5 text-secondary">
                                                                <ul style="list-style:none">
                                                                    <li>-IFE/INE</li>
                                                                    <li>-Comprobante de domicilio</li>
                                                                    <li>-Poliza de seguro popular (si tienes)</li>
                                                                    <li>-Estudios previos por los que te mandan al INCan, pueden ser:
                                                                        <ul style="list-style:none" class="justificar">
                                                                            <li>
                                                                                <strong>Mastografía:</strong>
                                                                                Imágenes y reporte de resultado.<a class="questionMark icono-info2 fas fa-question-circle"
                                                                                                                   style="background: #fff;" href="#" data-tooltip-content="#tooltip_contentmasto"></a></li>
                                                                            <li><strong>Ultrasonido de mama:</strong>
                                                                                Imágenes y reporte de resultado.<a style="background: #fff;"
                                                                                                                   href="#" class="questionMark icono-info2 fas fa-question-circle"
                                                                                                                   data-tooltip-content="#tooltip_contentultra"></a></li>
                                                                            <li><strong>Biopsia:</strong>
                                                                                Reporte de patología, laminillas y bloques de parafina.<a
                                                                                    style="background: #fff;" href="#" class="questionMark icono-info2 fas fa-question-circle"
                                                                                    data-tooltip-content="#tooltip_contentbiopsia"></a></li>
                                                                        </ul>
                                                                    </li>
                                                                </ul>
                                                            </div>
                                                        </div>

                                                        <div class="row">
                                                            <div class="col-12">
                                                                <hr>
                                                            </div>
                                                        </div>


                                                        <div class="row">
                                                            <div class="col-12">
                                                                <div class="row justify-content-center mb-2">
                                                                    <div class="col-12 text-center">
                                                                        <i class="fas fa-user-md colorIconos" style="font-size:100px"></i>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>

                                                        <div class="row">
                                                            <div class="col-12">
                                                                <h5 class="card-title display-4 tituloPago text-center">EL
                                                                    DÍA DE TU CITA </h5>
                                                            </div>
                                                        </div>

                                                        <div id="accordion">
                                                            <div class="card">
                                                                <div class="card-header" id="headingOne">
                                                                    <h5 class="mb-0">
                                                                        <button class="btn btn-link colorMoradoLight" data-toggle="collapse"
                                                                                data-target="#collapseOne" aria-expanded="true"
                                                                                aria-controls="collapseOne">
                                                                            UBICACIÓN Y HORARIO
                                                                        </button>
                                                                    </h5>
                                                                </div>

                                                                <div id="collapseOne" class="collapse show" aria-labelledby="headingOne"
                                                                     data-parent="#accordion">
                                                                    <div class="card-body m-3 justificar">
                                                                        Tu cita es a las
                                                                        <strong>7:50 am</strong>, favor de llegar puntual para no
                                                                        perderla.
                                                                        <p>Debes llegar al área de preconsulta, el acceso es por la
                                                                            entrada
                                                                            principal
                                                                            del
                                                                            <a class="text-primary" target="_blank" href="https://goo.gl/maps/q2VdVP2RdMQ2">edificio
                                                                                antiguo (Av. San Fernando #22)</a> , para que te
                                                                            permitan la entrada debes
                                                                            mostrar
                                                                            <strong>tu comprobante de pago</strong>.</p>
                                                                    </div>
                                                                </div>



                                                            </div>
                                                            <div class="card">
                                                                <div class="card-header" id="headingTwo">
                                                                    <h5 class="mb-0">
                                                                        <button class="btn btn-link collapsed colorMoradoLight"
                                                                                data-toggle="collapse" data-target="#collapseTwo"
                                                                                aria-expanded="false" aria-controls="collapseTwo">
                                                                            ¿EN QUÉ CONSISTE?
                                                                        </button>
                                                                    </h5>
                                                                </div>
                                                                <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
                                                                     data-parent="#accordion">
                                                                    <div class="card-body  m-3 justificar">
                                                                        Nuestro servicio de navegación te recibirá en el área de
                                                                        preconsulta,
                                                                        te llamarán por tu nombre y te pedirán los resultados y
                                                                        estudios previos
                                                                        que tengas. Al terminar, ellas te solicitarán pasar a la
                                                                        sala de espera mientras
                                                                        el médico te recibe.


                                                                    </div>
                                                                </div>
                                                            </div>

                                                            <div class="card">
                                                                <div class="card-header" id="headingThree">
                                                                    <h5 class="mb-0">
                                                                        <button class="btn btn-link collapsed colorMoradoLight"
                                                                                data-toggle="collapse" data-target="#collapseThree"
                                                                                aria-expanded="false" aria-controls="collapseThree">
                                                                            RECOMENDACIONES
                                                                        </button>
                                                                    </h5>
                                                                </div>
                                                                <div id="collapseThree" class="collapse" aria-labelledby="headingThree"
                                                                     data-parent="#accordion">
                                                                    <div class="card-body  m-3 justificar">
                                                                        El médico decidirá el orden en el que pasen las pacientes,
                                                                        debes venir con disponibilidad de tiempo, desayunada y te
                                                                        recomendamos traer un libro o revista.Al finalizar tu
                                                                        consulta el médico te pude pedir diversos estudios, el
                                                                        costo de estos estudios está entre <strong>$350.00 MXN</strong> y <strong>$3000.00
                                                                            MXN</strong> te
                                                                        recomendamos vengas preparada con esa cantidad de dinero
                                                                        para que los puedas agendar y agilizar el proceso de tu
                                                                        atención.

                                                                    </div>
                                                                </div>
                                                            </div>


                                                            <div class="row justify-content-center mt-3">
                                                                <div class="col-4 text-center">
                                                                    <button style="border-radius:20px" type="button" class="btn btn-morado btn-block"><i
                                                                            class="fas fa-print"></i> Imprimir información
                                                                    </button>
                                                                </div>
                                                            </div>

                                                        </div>

                                                    </c:otherwise>
                                                </c:choose>


                                                <!-- questions -->


                                                <div class="tooltip_templates">
                                                    <span id="tooltip_contentmasto">

                                                        <div class="row mt-2">
                                                            <div class="col-12 text-center">
                                                                <strong>Ejemplo de mastografía: </strong>
                                                            </div>
                                                        </div>
                                                        <div class="row mt-2">
                                                            <div class="col-12 text-center">
                                                                <img style="width:280px" src="img/Masto.jpeg" alt="">
                                                            </div>
                                                        </div>
                                                    </span>

                                                </div>

                                                <div class="tooltip_templates">
                                                    <span id="tooltip_contentultra">

                                                        <div class="row mt-2">
                                                            <div class="col-12 text-center">
                                                                <strong>Ejemplo de ultrasonido: </strong>
                                                            </div>
                                                        </div>
                                                        <div class="row mt-2">
                                                            <div class="col-12 text-center">
                                                                <img style="width:280px" src="img/Ultra.jpeg" alt="">
                                                            </div>
                                                        </div>
                                                    </span>

                                                </div>

                                                <div class="tooltip_templates">
                                                    <span id="tooltip_contentbiopsia">
                                                        <div class="row">
                                                            <div class="col-12 text-center">
                                                                Las laminillas y bloques de parafina las debes pedir en el lugar donde te realizaron la biopsia.
                                                            </div>
                                                        </div>
                                                        <div class="row mt-2">
                                                            <div class="col-12 text-center mb-2">
                                                                <strong>Ejemplo de laminillas: </strong>
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-12 text-center">
                                                                <img style="width:180px" src="img/lami.jpeg" alt="">
                                                            </div>
                                                        </div>
                                                        <div class="row mt-2">
                                                            <div class="col-12 text-center">
                                                                <strong>Ejemplo de bloques de parafina: </strong>
                                                            </div>
                                                        </div>
                                                        <div class="row mt-2">
                                                            <div class="col-12 text-center">
                                                                <img style="width:180px" src="img/bloques.jpeg" alt="">
                                                            </div>
                                                        </div>
                                                    </span>

                                                </div>

                                                <!-- sigue -->





                                            </div>
                                        </div>
                                    </div> 

                                    <!-- DOCUMENTACION -->

                                    <div class="tab-pane show active fade white mt-4" id="nav-bienvenida" role="tabpanel" aria-labelledby="nav-bienvenida-tab">
                                        <div class="card mb-3">

                                            <div class="card-body">

                                                <div class="row justify-content-center">
                                                    <div class="col-9">
                                                        <h4 class="display-4 text-secondary mb-3 text-center mt-3 texto-bienvenida">¡BIENVENIDA (O)!
                                                        </h4>
                                                        <p class="justificar">
                                                            Nuestro objetivo es brindar excelente atención médica especializada a pacientes con cáncer de mama.

                                                        </p>
                                                        <p class="justificar">
                                                            Atendemos a pacientes provenientes de todo el país con un servicio de calidad, eficiente y cálido. Lo logramos a través de
                                                            equipos multidisciplinarios que brindan atención médica, realizan
                                                            investigación y forman profesionales de la salud.
                                                        </p>
                                                        <p>
                                                            Tenemos personal calificado que te acompañará¡ durante todo el proceso diagnóstico, de tratamiento, de rehabilitación, seguimiento
                                                            y supervivencia.

                                                        </p>
                                                    </div>

                                                </div>
                                                <hr>

                                                <div class="row">
                                                    <div class="col-12">
                                                        <div class="row justify-content-center mb-2">
                                                            <div class="col-12 text-center">
                                                                <i class="fas fa-exclamation-circle text-danger text-center" style="font-size:100px"></i>
                                                            </div>
                                                        </div>
                                                        <h5 class="card-title display-4 tituloImportante text-center">Importante</h5>
                                                    </div>
                                                </div>

                                                <div class="row mb-3">
                                                    <div class="col-12 text-center">
                                                        <span class="text-secondary">Cosas que debes saber: </span>
                                                    </div>
                                                </div>

                                                <div class="row justify-content-center">
                                                    <div class="col-10">
                                                        <ul style="list-style:none" class="justificar">
                                                            <li>1.- La preconsulta solo es un método para evaluar tu diagnóstico
                                                                y el área médica determinará¡ si eres candidata para ser paciente
                                                                del Instituto. Por lo que es indispensable que tengas un diagnóstico
                                                                oncológico (de cáncer) probable o definitivo.</li>
                                                            <p>
                                                            <li>2.- Los servicios que el Instituto ofrece, son para población
                                                                adulta. La edad mínima es de 16 años cumplidos.
                                                            </li>
                                                            </p>
                                                            <p>
                                                            <li>3.- Debes venir acompañada <strong>solo de un familiar</strong>,
                                                                para que te ayude durante el proceso. Recuerda que no pueden
                                                                entrar menores de edad.</li>
                                                            </p>
                                                            <p>
                                                            <li>4.- El Instituto da prioridad de atención a la población
                                                                que no tiene seguridad social. Si eres derechohabiente de
                                                                IMSS, ISSSTE, PEMEX, o SEDENA te recomendamos busques atención
                                                                a través de ellos.</li>
                                                            </p>
                                                            <p>
                                                            <li>5.- Si ya te están atendiendo en otra institución (ej. Hospital
                                                                General de México, Hospital Juárez), se te recomienda continúes
                                                                tu atención ahí, los mejores resultados para tratar el cáncer
                                                                de mama se obtienen si recibes atención continua en un solo
                                                                lugar. El instituto da prioridad a las pacientes que no han
                                                                tenido la oportunidad de ser atendidas.</li>
                                                            </p>
                                                            <p>
                                                            <li>6.- Si tienes dudas, identifica al personal del Instituto
                                                                por su gafete, ¡están para servirte! No te confíes de las
                                                                indicaciones o recomendaciones de extraños.
                                                            </li>
                                                            </p>
                                                        </ul>
                                                    </div>
                                                </div>

                                                <div class="row justify-content-center mt-3">
                                                    <div class="col-4 text-center">
                                                        <button style="border-radius:20px" type="button" class="btn btn-morado btn-block" id="btn-continuar">Continuar
                                                            <i class="ml-2 fas fa-arrow-right"></i></button>
                                                    </div>
                                                </div>

                                            </div>
                                        </div>
                                    </div>



                                </div>
                            </div>
                        </div>
                    </div>
                </div>


            </div>
        </div>
        <script src="js/validacionesPotencial.js" type="module"></script>
    </body>

</html>