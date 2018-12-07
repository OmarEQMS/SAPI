<%-- 
    Document   : verDocumento
    Created on : 2/11/2018, 11:32:19 AM
    Author     : feror, julioguzman, shannonrosas
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <title>SAPI | Ver Documento</title>

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
        <script src="js/autocomplete.js"></script>

    </head>

    <body>

        <div class="cargandoSiguiente" id="loading-screen" style="display: none">
            <img src="img/loading.svg">
            <p class="clear">Cargando próximo documento, por favor espere...</p>
        </div>

        <div class="cargandoListaDocs" id="loading-screen" style="display: none">
            <img src="img/loading.svg">
            <p class="clear">Regresando a la lista de documentos, por favor espere...</p>
        </div>

        <div class="cargandoAceptarDoc" id="loading-screen" style="display: none">
            <img src="img/loading.svg">
            <p class="clear">Aceptando documento, por favor espere...</p>
        </div>

        <div class="cargandoRechazarDoc" id="loading-screen" style="display: none">
            <img src="img/loading.svg">
            <p class="clear">Rechazando documento, por favor espere...</p>
        </div>

        <div class="cargandoIrACalendar" id="loading-screen" style="display: none">
            <img src="img/loading.svg">
            <p class="clear">Cargando el calendario, por favor espere...</p>
        </div>

        <div class="cargandoIrAInicio" id="loading-screen" style="display: none">
            <img src="img/loading.svg">
            <p class="clear">Cargando la lista de paciente, por favor espere...</p>
        </div>

        <div class="cargandoIrAEstadisticas" id="loading-screen" style="display: none">
            <img src="img/loading.svg">
            <p class="clear">Cargando estadísticas, por favor espere..</p>
        </div>

        <div class="cargandoIrACuenta" id="loading-screen" style="display: none">
            <img src="img/loading.svg">
            <p class="clear">Cargando tus datos, por favor espere...</p>
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
                            <a class="iconoSidebar salirCuenta" title="Cerrar Sesión" id="salirCuenta2"><i class="fas fa-power-off"></i></a>
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

                    <li id="irAEstadisticas"><a><i class="fas fa-chart-line"></i>Estadísticas</a></li>

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

                        <input type="hidden" id="idPacientePotencialAtendido" value="${sessionScope.idPacientePotencialAtendido}"/>
                        <input type="hidden" id="idDocumentoInicialVista" value="${sessionScope.idDocumentoInicial}"/>


                        <span class="pull-right d-block"><span style="color:#6c6f80">Hola, </span><span style="font-weight:700; color:#6c6f80;">
                                ${sessionScope.nombre} ${sessionScope.primerApellido}</span>
                        </span></span>

                    </div>
                </nav>

                <!-- **************************************************************** -->
                <!-- ***** A PARTIR DE AQUI ESCRIBEN EL CODIGO QUE QUIERAN..... ***** -->
                <!-- **************************************************************** -->

                <div class="row mb-3">
                    <div class="col-12 text-right">
                        <span class="iconoHome"><i class="fas fa-home"></i></span><span><a class="colorMoradoLight IrAMiIndex"> Inicio</a></span>
                        - <span class="colorGlobal">Documentos</span>
                    </div>
                </div>

                <!-- Jumbotron Titulo -->

                <div class="jumbotron jumbotron-fluid p-2">
                    <div class="container">
                        <h1 class="display-4 tituloPacientes text-center m-0" id="pacienteSelec">${sessionScope.tipoDocumentoInicial} de: </h1>
                        <h6 class="display-4 text-center m-0 text-secondary" id="pacienteSelec" style="font-size:25px;">
                            ${sessionScope.nombrePacientePotencial} ${sessionScope.primerApellidoPacientePotencial} ${sessionScope.segundoApellidoPacientePotencial}</h6>
                    </div>
                </div>

                <!-- Despligue de información -->
                <div class="card">
                    <div class="card-body text-center">
                        <c:choose>
                            <c:when test="${sessionScope.extensionArchivo == 1 }">
                                <img class="mb-4" style="width: 1000px" src="data:image/png;base64,${sessionScope.documentB64}" />
                            </c:when>
                            <c:when test="${sessionScope.extensionArchivo == 2 }">
                                <img class="mb-4" style="width: 1000px" src="data:image/jpeg;base64,${sessionScope.documentB64}" />
                            </c:when>
                            <c:when test="${sessionScope.extensionArchivo == 3 }">
                                <embed type="application/pdf" class="mb-4" style="width:25cm;height:15cm;zoom: 100%" src="data:application/pdf;base64,${sessionScope.documentB64}"></embed>
                            </c:when>
                        </c:choose>


                        <div class="row justify-content-center mt-4">
                            <div class="col-4">
                                <button class="btn btn-outline-primary btn-block" id="btn-aprobar" style="border-radius: 20px">
                                    <i class="fas fa-arrow-alt-circle-right mr-2"></i>Aprobar</button>
                            </div>
                            <div class="col-4">
                                <button class="btn btn-outline-danger btn-block " id="btn-rechazar" data-toggle="modal" data-target="#modalAgregarComentario"
                                        style="border-radius: 20px">
                                    <i class="fas fa-arrow-alt-circle-right mr-2"></i>Rechazar</button>
                            </div>
                            <div class="col-4">
                                <button class="btn btn-outline-success btn-block" style="border-radius: 20px"
                                        id="btn-siguiente"><i class="fas fa-arrow-alt-circle-right mr-2"></i>Siguiente</button>
                            </div>

                        </div>
                    </div>

                </div>


                <!-- ********** MODAL AGREGAR COMENTARÍO ********** -->
                <div class="modal fade" id="modalAgregarComentario" tabindex="-1" data-keyboard="false" data-backdrop="static" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered" role="document">
                        <div class="modal-content" id="modal-rechazo">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Razón de rechazo</h5>
                                <button type="button" class="close clearMotivo" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <div class="col-12 ">
                                    <textarea placeholder="Introduce el motivo de rechazo" class="form-control" id="motivoRechazo" type="text"></textarea>
                                </div>
                                <div class="row mb-3" id="error-camposMotivo">
                                    <div class="col-12 text-center">
                                        <span class="text-danger">Debes escribir un motivo de rechazo.</span>
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-danger clearMotivo" style="border-radius: 20px" data-dismiss="modal">Cancelar</button>
                                <button type="button" class="btn btn-primary" style="border-radius: 20px" id="btn-rechazarDocumento">Guardar cambios</button>
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
