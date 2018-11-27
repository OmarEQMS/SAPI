<%-- 
    Document   : calendar
    Created on : 01-nov-2018, 15:16:42
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
        <script src="js/ajaxNavegadora.js"></script>
        <script src="js/autocomplete.js"></script>
        <script src="js/calendarNavegadora.js"></script>

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
                                                            
                    <li id="irACalendario"><a><i class="fas fa-calendar-alt"></i>Calendario</a></li>

                    <li id="irARendimiento"><a><i class="fas fa-chart-line"></i>Mi Rendimiento</a></li>

                    <li id="irACuenta"><a><i class="far fa-user"></i>Mi Cuenta</a></li>

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

                        <span class="pull-right d-block"><span style="color:#6c6f80">Hola, </span><span style="font-weight:700; color:#6c6f80;">Shannon
                                Rosas
                            </span> <img src="img/user.png" class="ml-2" style="width: 30px;" alt=""> </span>

                    </div>
                </nav>

                <!-- CONTENIDO -->
                <div class="row mb-3 justify-content-end">
                    <div class="col-3 text-center">
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


                <!-- Icono info -->

                <div class="card">
                    <div class="card-body">
                        <div id="calendarCitasPaciente"></div>
                    </div>
                </div>

            </div>
        </div>

        <!-- Modal VER CITA-->
        <div class="modal fade" id="modalVerCita" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Informacion de cita</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">

                        <div class="row">
                            <div class="col-12">
                                <h6 style="font-size:35px;" class="text-center display-4 tituloCitaModal text-primary"><span><strong>Nombre:</strong></span>
                                    María Suárez Piñón</h6>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-12 text-center">
                                <h6 class="display-4 text-secondary" style="font-size:20px;"><span><strong>PRZ: </strong></span>A01422623</h6>
                            </div>
                        </div>

                    </div>

                </div>
            </div>
        </div>

        <!-- ***** MODAL ***** -->
        <div id="modalAgregarCita" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="modalRegistrarCitaLabel"
             aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <!-- ***** Titulo ***** -->
                    <div class="modal-header">
                        <h5 class="modal-title text-secondary display-4" style="font-size: 25px;" id="modalRegistrarCitaLabel">Registrar
                            Cita para el dia: <span class="text-primary" id="dia-cita"></span </h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="color: #fff;">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <!-- ***** Contenido ***** -->
                    <div class="modal-body">
                        <div class="container-fluid">
                            
                            <input type="hidden" id="fechaCita">
                            <input type="hidden" id="tituloCita">
                            
                            <!-- ***** Seleccionar Paciente ***** -->
                            <div class="row mb-3 justify-content-center">
                                <div class="col-12">
                                    <div class="form-group">
                                        <label for="registrarCitaPaciente">Seleccionar Paciente:</label>
                                        <select class="form-control" id="paciente-resultado">
                                            <option disabled selected>Seleccione a un paciente</option>
                                            <c:forEach items="${pacientesResultados}" var="pacienteResultados">  
                                                <option value="<c:out value='${pacienteResultados.idPaciente}'/>"><c:out value='${pacienteResultados.nombre}'/> <c:out value='${pacienteResultados.primerApellido}'/> <c:out value='${pacienteResultados.segundoApellido}'/></option>
                                            </c:forEach>
                                        </select>
                                        
                                    </div>
                                </div>
                                <div class="col-12">
                                    <span class="text-danger mt-3" id="error-pacienteSelected">Seleccione un paciente para agregar la cita</span>
                                </div>
                            </div>

                            <div class="row mb-3 justify-content-center">
                                <div class="col-10 text-center bg-danger" style="border-radius:20px;">
                                    <span style="font-size: 14px;" class="text-white">Nota: El sistema no se encarga de
                                        agendar
                                        citas en el INCan. Sólo es un recordatorio para uso personal.</span>
                                </div>
                            </div>

                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger" style="border-radius: 20px" data-dismiss="modal">Cancelar</button>
                            <button id="btn-registrarCitaResultados" type="button" class="btn btn-primary" style="border-radius: 20px">Aceptar</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </body>

</html>