<%-- 
    Document   : index
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
        <script src="js/appPotencial.js"></script>
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
                        
            <!-- PANTALLAS DE CARGA -->
            <div class="loading-screen" id="loading-screen" style="display: none">
                <img src="img/loading.svg">
                <p class="clear">Cargando, por favor espere...</p>
            </div>
                        
            <div class="loading-screenGuardar" id="loading-screen" style="display: none">
                <img src="img/loading.svg">
                <p class="clear">Guardando tu información, por favor espere...</p>
            </div>
            

            <!-- CONTENIDO PRINCIPAL POTENCIAL-->

            <div id="content">

                <!-- MENU -->

                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <div class="container-fluid">

                        <button id="sidebarCollapse" class="btn boton-collapse">
                            <i class="fas fa-align-justify"></i>
                        </button>

                        <!-- aqui se inyecta la sesion de id-->
                        <input type="hidden" id="sesionPaciente" value="${sessionScope.idSesion}" />
                        <input type="hidden" id="idPaciente" value="${sessionScope.idPaciente}"/>
                        <input type="hidden" id="idMotivoConsulta" value="${sessionScope.idMotivoConsulta}" />

                        <span class="pull-right d-block"><span style="color:#6c6f80">Hola, </span><span style="font-weight:700; color:#6c6f80;">
                                <!--Julio Badillo-->
                                ${sessionScope.nombre} ${sessionScope.primerApellido}</span></span>
                    </div>
                </nav>

                <div class="row mb-3">
                    <div class="col-12 text-right">
                        <span class="iconoHome mr-2"><i class="fas fa-home"></i></span></span><span><a id="irAInicioPotencial" class="colorMoradoLight">Inicio</a></span>
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

                                                <a class="nav-item nav-link text-center colorMoradoLight texto-tab" id="nav-bienvenida-tab" data-toggle="tab" href="#nav-bienvenida"
                                                   role="tab" aria-controls="nav-bienvenida" aria-selected="false" style="width:33%">INFORMACIÓN</a>

                                                <a class="nav-item nav-link text-center colorMoradoLight texto-tab" id="nav-solicitud-tab" data-toggle="tab" href="#solicitud" role="tab"
                                                   aria-controls="nav-solicitud" aria-selected="true" style="width:33%"><!--<i
                                                        class="fas fa-check-circle text-success mr-2"></i>-->SOLICITUD</a>

                                                <a class="nav-item nav-link active text-center colorMoradoLight texto-tab" id="nav-contact-tab" data-toggle="tab" href="#nav-contact" role="tab"
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


                                        <c:choose>
                                            <c:when test="${sessionScope.envioEditable==1}">
                                                <div class="row mt-5">
                                                    <div class="col-12">

                                                        <form>
                                                            <!-- Genero -->
                                                            <div class="row">
                                                                <div class="col-xl-3 col-lg-3 col-md-3 col-sm-12 text-center">
                                                                    <span class="textoDocumento">Sexo<br>
                                                                        <small><strong>Obligatorio</strong></small>
                                                                    </span>
                                                                </div>

                                                                <div class="col-xl-8 col-lg-8 col-md-8 col-sm-12 col-12 text-center">
                                                                    <div class="form-check form-check-inline">
                                                                        <c:choose>                                                                  
                                                                            <c:when test="${sessionScope.idSexo == 2}">
                                                                                <input class="form-check-input" name="generoMasculino" type="radio" id="masculino" value="masculino" checked="checked" disabled>
                                                                            </c:when>
                                                                            <c:otherwise>
                                                                                <input class="form-check-input" name="generoMasculino" type="radio" id="masculino" value="masculino" disabled>
                                                                            </c:otherwise>                                                                                                                                                    
                                                                        </c:choose>                                                                
                                                                        <label class="form-check-label" for="masculino"><i class="fas fa-male"></i>
                                                                            Hombre</label>
                                                                    </div>
                                                                    <div class="form-check form-check-inline">                                                                
                                                                        <c:choose>                                                                   
                                                                            <c:when test="${sessionScope.idSexo == 1}">
                                                                                <input class="form-check-input" name="generoFemenino" type="radio" id="femenino" value="femenino"checked="checked" disabled>
                                                                            </c:when>
                                                                            <c:otherwise>
                                                                                <input class="form-check-input" name="generoFemenino" type="radio" id="femenino" value="femenino" disabled>
                                                                            </c:otherwise>
                                                                        </c:choose>        
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
                                                                        <c:choose>
                                                                            <c:when test="${sessionScope.silla<=0}">
                                                                                <input class="form-check-input" name="sillaRuedas" type="checkbox" id="sillaRuedas" value="sillaRuedas" disabled>
                                                                            </c:when>    
                                                                            <c:otherwise>
                                                                                <input class="form-check-input" name="sillaRuedas" type="checkbox" id="sillaRuedas" value="sillaRuedas" checked disabled>
                                                                            </c:otherwise>
                                                                        </c:choose>
                                                                        <label class="form-check-label" for="sillaRuedas"> <i class="fas fa-wheelchair"></i>
                                                                            Silla de ruedas
                                                                        </label>
                                                                    </div>

                                                                    <div class="form-check form-check-inline">
                                                                        <c:choose>
                                                                            <c:when test="${sessionScope.camilla<=0}">
                                                                                <input class="form-check-input" name="camilla" type="checkbox" id="camilla" value="camilla" disabled>
                                                                            </c:when>    
                                                                            <c:otherwise>
                                                                                <input class="form-check-input" name="camilla" type="checkbox" id="camilla" value="camilla" disabled checked>
                                                                            </c:otherwise>
                                                                        </c:choose>
                                                                        <label class="form-check-label" for="camilla">
                                                                            <i class="fas fa-bed"></i>
                                                                            Camilla
                                                                        </label>
                                                                    </div>

                                                                    <div class="form-check form-check-inline">
                                                                        <c:choose>
                                                                            <c:when test="${sessionScope.baston<=0}">
                                                                                <input class="form-check-input" name="baston" type="checkbox" id="baston" value="baston" disabled>
                                                                            </c:when>    
                                                                            <c:otherwise>
                                                                                <input class="form-check-input" name="baston" type="checkbox" id="baston" value="baston" disabled checked>
                                                                            </c:otherwise>
                                                                        </c:choose>
                                                                        <label class="form-check-label" for="baston"> <i class="fas fa-blind"></i>
                                                                            Bastón</label>
                                                                    </div>

                                                                    <div class="form-check form-check-inline">
                                                                        <c:choose>
                                                                            <c:when test="${sessionScope.oxigeno<=0}">
                                                                                <input class="form-check-input" name="oxigeno" type="checkbox" id="oxigeno" value="oxigeno" disabled>
                                                                            </c:when>    
                                                                            <c:otherwise>
                                                                                <input class="form-check-input" name="oxigeno" type="checkbox" id="oxigeno" value="oxigeno" disabled checked>
                                                                            </c:otherwise>
                                                                        </c:choose>
                                                                        <label class="form-check-label" for="oxigeno"> <i class="fas fa-fire-extinguisher"></i>
                                                                            Oxígeno
                                                                        </label>
                                                                    </div>

                                                                </div>
                                                            </div>

                                                            <!-- Identificacion oficial
                                                            -->




                                                            <div class="row mt-4">

                                                                <c:choose>
                                                                    <c:when test="${sessionScope.identificacionOficial<=0}">
                                                                        <div class="col-xl-3 col-lg-3 col-md-3 col-sm-12 mb-2 text-center">
                                                                            <span class="textoDocumento">Identificación oficial</span>
                                                                        </div>

                                                                        <div class="custom-file col-xl-8 col-lg-8 col-md-8 col-sm-10 col-10" id="customFile">
                                                                            <input type="file" name="fileIdentificacion" class="custom-file-input" id="fileIdentificacion" aria-describedby="fileHelp" disabled>
                                                                            <span class="text-danger" id="error-identificacionOficial">No es una extensión válida. Puedes subir un archivo .jpg, .jpeg, .png o .pdf </span>
                                                                            <label class="custom-file-label">
                                                                                Elegir archivo (obligatorio)...
                                                                            </label>
                                                                        </div>
                                                                    </c:when>    
                                                                    <c:otherwise>
                                                                        <div class="col-xl-3 col-lg-3 col-md-3 col-sm-12 mb-2 text-center">
                                                                            <span class="textoDocumento text-success"><i class="fas fa-check text-success mr-1"></i>Identificación oficial</span><br>
                                                                            <span class="text-success" style="font-size:11px;">Documento subido</span>
                                                                        </div>

                                                                        <div class="custom-file col-xl-8 col-lg-8 col-md-8 col-sm-10 col-10" id="customFile">
                                                                            <input type="file" name="fileIdentificacion" class="custom-file-input" id="fileIdentificacion" aria-describedby="fileHelp" disabled>
                                                                            <span class="text-danger" id="error-identificacionOficial">No es una extensión válida. Puedes subir un archivo .jpg, .jpeg, .png o .pdf </span>
                                                                            <label class="custom-file-label">
                                                                                ${sessionScope.identificacionOficialName}
                                                                            </label>
                                                                        </div>
                                                                    </c:otherwise>
                                                                </c:choose>



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

                                                                <c:choose>
                                                                    <c:when test="${sessionScope.curp<=0}">
                                                                        <div class="col-xl-3 col-lg-3 col-md-3 col-sm-12 mb-2 text-center">
                                                                            <span class="textoDocumento">CURP</span>
                                                                            <small id="passwordHelpBlock" class="form-text text-muted">
                                                                                Se puede tramitar
                                                                                <a class="text-primary" target="_blank" href="https://www.gob.mx/curp/">aquí­</a>
                                                                            </small>
                                                                        </div>

                                                                        <div class="custom-file col-xl-8 col-lg-8 col-md-8 col-sm-12 col-12" id="customFile">
                                                                            <input type="file" name="fileCURP" class="custom-file-input centraInput" id="fileCURP" aria-describedby="fileHelp" disabled>
                                                                            <span class="text-danger" id="error-CURP">No es una extensión válida. Puedes subir un archivo .jpg, .jpeg, .png o .pdf </span>
                                                                            <label class="custom-file-label">
                                                                                Elegir archivo (obligatorio)...
                                                                            </label>
                                                                        </div>

                                                                    </c:when>    
                                                                    <c:otherwise>
                                                                        <div class="col-xl-3 col-lg-3 col-md-3 col-sm-12 mb-2 text-center">                                                                    
                                                                            <span class="textoDocumento text-success"><i class="fas fa-check text-success mr-1"></i>CURP</span><br>
                                                                            <span class="text-success" style="font-size:11px;">Documento subido</span>
                                                                        </div>

                                                                        <div class="custom-file col-xl-8 col-lg-8 col-md-8 col-sm-12 col-12" id="customFile">
                                                                            <input type="file" name="fileCURP" class="custom-file-input centraInput" id="fileCURP" aria-describedby="fileHelp" disabled>
                                                                            <span class="text-danger" id="error-CURP">No es una extensión válida. Puedes subir un archivo .jpg, .jpeg, .png o .pdf </span>
                                                                            <label class="custom-file-label">
                                                                                ${sessionScope.curpName}
                                                                            </label>
                                                                        </div>
                                                                    </c:otherwise>
                                                                </c:choose>






                                                            </div>

                                                            <!-- Comprobante de domicilio -->

                                                            <div class="row mt-4">

                                                                <c:choose>
                                                                    <c:when test="${sessionScope.comprobante<=0}">

                                                                        <div class="col-xl-3 col-lg-3 col-md-3 col-sm-12 mb-2 text-center">
                                                                            <span class="textoDocumento">Comprobante de domicilio</span>
                                                                            <small id="passwordHelpBlock" class="form-text text-muted">
                                                                                Vigencia no mayor a 3 meses.
                                                                            </small>

                                                                        </div>

                                                                        <div class="custom-file col-xl-8 col-lg-8 col-md-8 col-sm-11 col-11" id="customFile">
                                                                            <input type="file" name="fileComprobanteDomicilio" class="custom-file-input" id="fileComprobanteDomicilio" aria-describedby="fileHelp" disabled>
                                                                            <span class="text-danger" id="error-comprobanteDomicilio">No es una extensión válida. Puedes subir un archivo .jpg, .jpeg, .png o .pdf </span>
                                                                            <label class="custom-file-label">
                                                                                Elegir archivo (obligatorio)...
                                                                            </label>
                                                                        </div>

                                                                    </c:when>
                                                                    <c:otherwise>

                                                                        <div class="col-xl-3 col-lg-3 col-md-3 col-sm-12 mb-2 text-center">                                                                    

                                                                            <span class="textoDocumento text-success"><i class="fas fa-check text-success mr-1"></i>Comprobante de domicilio</span><br>
                                                                            <span class="text-success" style="font-size:11px;">Documento subido</span>
                                                                        </div>

                                                                        <div class="custom-file col-xl-8 col-lg-8 col-md-8 col-sm-11 col-11" id="customFile">
                                                                            <input type="file" name="fileComprobanteDomicilio" class="custom-file-input" id="fileComprobanteDomicilioSubido" aria-describedby="fileHelp" disabled>
                                                                            <span class="text-danger" id="error-comprobanteDomicilio">No es una extensión válida. Puedes subir un archivo .jpg, .jpeg, .png o .pdf </span>
                                                                            <label class="custom-file-label">
                                                                                ${sessionScope.comprobanteName}
                                                                            </label>
                                                                        </div>                                                                                                                                

                                                                    </c:otherwise>

                                                                </c:choose>



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

                                                            <!-- Estudios previos Mastografí­a-->
                                                            <div class="row mt-1">

                                                                <c:choose>
                                                                    <c:when test="${sessionScope.resultadoMastografia<=0}">
                                                                        <div class="col-xl-3 col-lg-3 col-md-3 col-sm-12 col-12 mb-2 text-center">
                                                                            <span class="textoDocumento">Reporte de resultados de estudios previos
                                                                                mastografía
                                                                            </span>
                                                                        </div>

                                                                        <div class="custom-file col-xl-8 col-lg-8 col-md-8 col-sm-11 col-11" id="customFileMasto">
                                                                            <input type="file" name="fileEstudioPrevioMasto" class="custom-file-input" id="fileEstudioPrevioMasto" aria-describedby="fileHelp" disabled>
                                                                            <span class="text-danger" id="error-previoMasto">No es una extensión válida. Puedes subir un archivo .jpg, .jpeg, .png o .pdf </span>
                                                                            <label class="custom-file-label">
                                                                                Elegir archivo...
                                                                            </label>
                                                                        </div>
                                                                    </c:when>
                                                                    <c:otherwise>                                                                
                                                                        <div class="col-xl-3 col-lg-3 col-md-3 col-sm-12 col-12 mb-2 text-center">
                                                                            <span class="textoDocumento text-success"><i class="fas fa-check text-success mr-1"></i>Reporte de resultados de estudios previos
                                                                                mastografía
                                                                            </span><br>
                                                                            <span class="text-success" style="font-size:11px;">Documento subido</span>
                                                                        </div>

                                                                        <div class="custom-file col-xl-8 col-lg-8 col-md-8 col-sm-11 col-11" id="customFileMasto">
                                                                            <input type="file" name="fileEstudioPrevioMasto" class="custom-file-input" id="fileEstudioPrevioMastoSubido" aria-describedby="fileHelp" disabled>
                                                                            <span class="text-danger" id="error-previoMasto">No es una extensión válida. Puedes subir un archivo .jpg, .jpeg, .png o .pdf </span>
                                                                            <label class="custom-file-label">
                                                                                ${sessionScope.resultadoMastografiaName}
                                                                            </label>
                                                                        </div>
                                                                    </c:otherwise>
                                                                </c:choose>



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

                                                                <c:choose>
                                                                    <c:when test="${sessionScope.resultadoUltrasonido<=0}">
                                                                        <div class="col-xl-3 col-lg-3 col-md-3 col-sm-12 col-12 mb-12 text-center">
                                                                            <span class="textoDocumento">Reporte de resultados de estudios previos
                                                                                ultrasonido
                                                                            </span>
                                                                        </div>

                                                                        <div class="custom-file col-xl-8 col-lg-8 col-md-8 col-sm-11 col-11" id="customFileUsg">
                                                                            <input type="file" name="fileEstudioPrevioUsg" class="custom-file-input" id="fileEstudioPrevioUsg" aria-describedby="fileHelp" disabled>
                                                                            <span class="text-danger" id="error-previoUsg">No es una extensión válida. Puedes subir un archivo .jpg, .jpeg, .png o .pdf </span>
                                                                            <label class="custom-file-label">
                                                                                Elegir archivo...
                                                                            </label>
                                                                        </div>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <div class="col-xl-3 col-lg-3 col-md-3 col-sm-12 col-12 mb-12 text-center">
                                                                            <span class="textoDocumento text-success"><i class="fas fa-check text-success mr-1"></i>Reporte de resultados de estudios previos ultrasonido</span><br>
                                                                            <span class="text-success" style="font-size:11px;">Documento subido</span>
                                                                        </div>

                                                                        <div class="custom-file col-xl-8 col-lg-8 col-md-8 col-sm-11 col-11" id="customFileUsg">
                                                                            <input type="file" name="fileEstudioPrevioUsg" class="custom-file-input" id="fileEstudioPrevioUsgSubido" aria-describedby="fileHelp" disabled>
                                                                            <span class="text-danger" id="error-previoUsg">No es una extensión válida. Puedes subir un archivo .jpg, .jpeg, .png o .pdf </span>
                                                                            <label class="custom-file-label">
                                                                                ${sessionScope.resultadoUltrasonidoName}
                                                                            </label>
                                                                        </div>                                                                
                                                                    </c:otherwise>
                                                                </c:choose>




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

                                                                <c:choose>
                                                                    <c:when test="${sessionScope.biopsiaPrevia<=0}">
                                                                        <div class="col-xl-3 col-lg-3 col-md-3 col-sm-12 col-12 mb-2 text-center">
                                                                            <div class="form-check">
                                                                                <input class="form-check-input" name="biopsiaInput" type="checkbox" id="biopsiaInput" onclick="return false;">
                                                                                <label class="form-check-label textoDocumento">
                                                                                    ¿Te han hecho una biopsia previamente?
                                                                                </label>
                                                                            </div>
                                                                        </div>

                                                                        <div class="custom-file col-xl-8 col-lg-8 col-md-8 col-sm-11 col-11" id="biopsiaContenedor">
                                                                            <input type="file" class="custom-file-input" id="fileEstudioBiopsia" name="fileEstudioBiopsia" aria-describedby="fileHelp" disabled>
                                                                            <span class="text-danger" id="error-biopsia">No es una extensión válida. Puedes subir un archivo .jpg, .jpeg, .png o .pdf </span>
                                                                            <label class="custom-file-label">
                                                                                Elegir archivo...
                                                                            </label>
                                                                        </div>

                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <div class="col-xl-3 col-lg-3 col-md-3 col-sm-12 col-12 mb-2 text-center">
                                                                            <div class="form-check">
                                                                                <input class="form-check-input" name="biopsiaInput" type="checkbox" onclick="return false;" id="biopsiaInput" checked>
                                                                                <label class="form-check-label textoDocumento text-success">
                                                                                    ¿Te han hecho una biopsia previamente?
                                                                                </label>
                                                                            </div>
                                                                            <span class="text-success" style="font-size:11px">Documento subido</span>
                                                                        </div>

                                                                        <div class="custom-file col-xl-8 col-lg-8 col-md-8 col-sm-11 col-11">
                                                                            <input type="file" class="custom-file-input" id="fileEstudioBiopsiaSubido" name="fileEstudioBiopsia" aria-describedby="fileHelp" disabled>
                                                                            <span class="text-danger" id="error-biopsia">No es una extensión válida. Puedes subir un archivo .jpg, .jpeg, .png o .pdf </span>
                                                                            <label class="custom-file-label">
                                                                                ${sessionScope.biopsiaPreviaName}
                                                                            </label>
                                                                        </div>
                                                                    </c:otherwise>
                                                                </c:choose>



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

                                                            <!-- Motivo de la consulta -->

                                                            <div class="row mt-4" id="formMotivoConsulta">

                                                                <div class="col-xl-3 col-lg-3 col-md-3 col-sm-12 col-12 text-center">
                                                                    <span class="textoDocumento">Motivo de la consulta <br>
                                                                        <small><strong>Obligatorio</strong></small>
                                                                    </span>
                                                                </div>



                                                                <div class="col-xl-8 col-lg-8 col-md-8 col-sm-12 col-12 removePadding">
                                                                    <select class="form-control" id="motivoConsulta" disabled>
                                                                        <option value="0">Seleccione el motivo de la consulta</option>
                                                                        <option value="1">Me envió un médico</option>
                                                                        <option value="3">No he consultado a ningun médico; pero me senti una bolita en el seno</option>
                                                                        <option value="4">Me envían de otro hospital</option>
                                                                        <option value="5">Otro</option>
                                                                    </select>
                                                                    <span class="text-danger ml-3" id="error-motivoConsulta">No seleccionaste un motivo de consulta</span>
                                                                </div>
                                                            </div>

                                                            <c:choose>
                                                                <c:when test="${sessionScope.idMotivoConsulta==1}">
                                                                    <div class="row mt-4" id="documentoAdjuntoMotivo">
                                                                        <div class="col-3 text-center">
                                                                            <span class="textoDocumento">Referencia</span>
                                                                        </div>
                                                                        <div class="custom-file col-8" id="customFile">
                                                                            <input type="file" class="custom-file-input" id="referenciaArchivo" name="referenciaArchivo" multiple="multiple" aria-describedby="fileHelp" disabled>
                                                                            <label class="custom-file-label" id="labelReferencia">
                                                                                ${sessionScope.referenciaName}
                                                                            </label>
                                                                        </div>
                                                                    </div>
                                                                </c:when>
                                                            </c:choose>

                                                            <c:choose>
                                                                <c:when test="${sessionScope.idMotivoConsulta==4}">
                                                                    <div class="row mt-4" id="documentoAdjuntoMotivo">
                                                                        <div class="col-3 text-center">
                                                                            <span class="textoDocumento">Referencia</span>
                                                                        </div>
                                                                        <div class="custom-file col-8" id="customFile">
                                                                            <input type="file" class="custom-file-input" id="referenciaArchivo" name="referenciaArchivo" multiple="multiple" aria-describedby="fileHelp" disabled>
                                                                            <label class="custom-file-label">
                                                                                ${sessionScope.referenciaName}
                                                                            </label>
                                                                        </div>
                                                                    </div>
                                                                    <div class="row mt-4 mb-4" id="otroHospital">
                                                                        <div class="col-3 text-center">
                                                                            <span class="textoDocumento">Hospital</span>
                                                                        </div>
                                                                        <div class="custom-file col-8 p-0 m-0" id="customFile">
                                                                            <input type="text" class="form-control" id="otroHospital" name="otroHospital" placeholder="Introduce tu hospital de procedencia" value="${sessionScope.hospital}" disabled>
                                                                        </div>
                                                                    </div>
                                                                </c:when>
                                                            </c:choose>  

                                                            <c:choose>
                                                                <c:when test="${sessionScope.idMotivoConsulta==5}">
                                                                    <div class="row mt-4 mb-4" id="otroHospital">
                                                                        <div class="col-3 text-center">
                                                                            <span class="textoDocumento">Otro motivo</span>
                                                                        </div>
                                                                        <div class="custom-file col-8 p-0 m-0" id="customFile">
                                                                            <input type="text" class="form-control" id="otro-motivo-consulta" placeholder="Introduce otro motivo" value="${sessionScope.otroMotivo}" disabled>
                                                                        </div>
                                                                    </div>
                                                                </c:when>
                                                            </c:choose>  

                                                        </form>

                                                        <!-- Botones -->



                                                        <div class="row justify-content-center mt-4 mb-3">
                                                            <div class="col-12 text-center">
                                                                <i class="far fa-check-circle text-success" style="font-size:50px"></i>
                                                            </div>
                                                        </div>

                                                        <c:choose>
                                                            <c:when test="${sessionScope.estatus==1}">
                                                                <div class="row justify-content-center">
                                                                    <div class="col-12 text-center">
                                                                        <h4 class="display-4 text-success" style="font-size:30px">Tu solicitud ha aprobada</h4>
                                                                    </div>
                                                                </div>
                                                                <div class="row justify-content-center mt-3">
                                                                    <div class="col-4 text-center">
                                                                        <button style="border-radius:20px" type="button" class="btn btn-outline-primary btn-block" id="btn-continuarAResolucion">Ir a resolución
                                                                            <i class="ml-2 fas fa-arrow-right"></i></button>
                                                                    </div>
                                                                </div>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <div class="row justify-content-center">
                                                                    <div class="col-12 text-center">
                                                                        <h4 class="display-4 text-success" style="font-size:30px">Tu solicitud ha sido enviada correctamente y esta siendo procesada</h4>

                                                                    </div>
                                                                </div>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </div>
                                                </div>
                                            </c:when>
                                            <c:otherwise>
                                                <div class="row mt-5">
                                                    <div class="col-12">

                                                        <form>
                                                            <!-- Genero -->
                                                            <div class="row">
                                                                <div class="col-xl-3 col-lg-3 col-md-3 col-sm-12 text-center">
                                                                    <span class="textoDocumento">Sexo<br>
                                                                        <small><strong>Obligatorio</strong></small>
                                                                    </span>
                                                                </div>

                                                                <div class="col-xl-8 col-lg-8 col-md-8 col-sm-12 col-12 text-center">
                                                                    <div class="form-check form-check-inline">
                                                                        <c:choose>                                                                  
                                                                            <c:when test="${sessionScope.idSexo == 2}">
                                                                                <input class="form-check-input" name="generoMasculino" type="radio" id="masculino" value="masculino" checked="checked">
                                                                            </c:when>
                                                                            <c:otherwise>
                                                                                <input class="form-check-input" name="generoMasculino" type="radio" id="masculino" value="masculino">
                                                                            </c:otherwise>                                                                                                                                                    
                                                                        </c:choose>                                                                
                                                                        <label class="form-check-label" for="masculino"><i class="fas fa-male"></i>
                                                                            Hombre</label>
                                                                    </div>
                                                                    <div class="form-check form-check-inline">                                                                
                                                                        <c:choose>                                                                   
                                                                            <c:when test="${sessionScope.idSexo == 1}">
                                                                                <input class="form-check-input" name="generoFemenino" type="radio" id="femenino" value="femenino"checked="checked">
                                                                            </c:when>
                                                                            <c:otherwise>
                                                                                <input class="form-check-input" name="generoFemenino" type="radio" id="femenino" value="femenino">
                                                                            </c:otherwise>
                                                                        </c:choose>        
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
                                                                        <c:choose>
                                                                            <c:when test="${sessionScope.silla<=0}">
                                                                                <input class="form-check-input" name="sillaRuedas" type="checkbox" id="sillaRuedas" value="sillaRuedas">
                                                                            </c:when>    
                                                                            <c:otherwise>
                                                                                <input class="form-check-input" name="sillaRuedas" type="checkbox" id="sillaRuedas" value="sillaRuedas" checked>
                                                                            </c:otherwise>
                                                                        </c:choose>
                                                                        <label class="form-check-label" for="sillaRuedas"> <i class="fas fa-wheelchair"></i>
                                                                            Silla de ruedas
                                                                        </label>
                                                                    </div>

                                                                    <div class="form-check form-check-inline">
                                                                        <c:choose>
                                                                            <c:when test="${sessionScope.camilla<=0}">
                                                                                <input class="form-check-input" name="camilla" type="checkbox" id="camilla" value="camilla">
                                                                            </c:when>    
                                                                            <c:otherwise>
                                                                                <input class="form-check-input" name="camilla" type="checkbox" id="camilla" value="camilla" checked>
                                                                            </c:otherwise>
                                                                        </c:choose>
                                                                        <label class="form-check-label" for="camilla">
                                                                            <i class="fas fa-bed"></i>
                                                                            Camilla
                                                                        </label>
                                                                    </div>

                                                                    <div class="form-check form-check-inline">
                                                                        <c:choose>
                                                                            <c:when test="${sessionScope.baston<=0}">
                                                                                <input class="form-check-input" name="baston" type="checkbox" id="baston" value="baston">
                                                                            </c:when>    
                                                                            <c:otherwise>
                                                                                <input class="form-check-input" name="baston" type="checkbox" id="baston" value="baston" checked>
                                                                            </c:otherwise>
                                                                        </c:choose>
                                                                        <label class="form-check-label" for="baston"> <i class="fas fa-blind"></i>
                                                                            Bastón</label>
                                                                    </div>

                                                                    <div class="form-check form-check-inline">
                                                                        <c:choose>
                                                                            <c:when test="${sessionScope.oxigeno<=0}">
                                                                                <input class="form-check-input" name="oxigeno" type="checkbox" id="oxigeno" value="oxigeno">
                                                                            </c:when>    
                                                                            <c:otherwise>
                                                                                <input class="form-check-input" name="oxigeno" type="checkbox" id="oxigeno" value="oxigeno" checked>
                                                                            </c:otherwise>
                                                                        </c:choose>
                                                                        <label class="form-check-label" for="oxigeno"> <i class="fas fa-fire-extinguisher"></i>
                                                                            Oxígeno
                                                                        </label>
                                                                    </div>

                                                                </div>
                                                            </div>

                                                            <!-- Identificacion oficial
                                                            -->




                                                            <div class="row mt-4">

                                                                <c:choose>
                                                                    <c:when test="${sessionScope.identificacionOficial<=0}">
                                                                        <div class="col-xl-3 col-lg-3 col-md-3 col-sm-12 mb-2 text-center">
                                                                            <span class="textoDocumento">Identificación oficial</span>
                                                                        </div>

                                                                        <div class="custom-file col-xl-8 col-lg-8 col-md-8 col-sm-10 col-10" id="customFile">
                                                                            <input type="file" name="fileIdentificacion" class="custom-file-input" id="fileIdentificacion" aria-describedby="fileHelp">
                                                                            <span class="text-danger" id="error-identificacionOficial">No es una extensión válida. Puedes subir un archivo .jpg, .jpeg, .png o .pdf </span>
                                                                            <label class="custom-file-label" id="labelIdentificacion">
                                                                                Elegir archivo (obligatorio)...
                                                                            </label>
                                                                        </div>
                                                                    </c:when>    
                                                                    <c:otherwise>
                                                                        <div class="col-xl-3 col-lg-3 col-md-3 col-sm-12 mb-2 text-center">
                                                                            <span class="textoDocumento text-success"><i class="fas fa-check text-success mr-1"></i>Identificación oficial</span><br>
                                                                            <span class="text-success" style="font-size:11px;">Documento subido</span>
                                                                        </div>

                                                                        <div class="custom-file col-xl-8 col-lg-8 col-md-8 col-sm-10 col-10" id="customFile">
                                                                            <input type="file" name="fileIdentificacion" class="custom-file-input" id="fileIdentificacion" aria-describedby="fileHelp">
                                                                            <span class="text-danger" id="error-identificacionOficial">No es una extensión válida. Puedes subir un archivo .jpg, .jpeg, .png o .pdf </span>
                                                                            <label class="custom-file-label" id="labelIdentificacion">
                                                                                ${sessionScope.identificacionOficialName}
                                                                            </label>
                                                                        </div>
                                                                    </c:otherwise>
                                                                </c:choose>



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

                                                                <c:choose>
                                                                    <c:when test="${sessionScope.curp<=0}">
                                                                        <div class="col-xl-3 col-lg-3 col-md-3 col-sm-12 mb-2 text-center">
                                                                            <span class="textoDocumento">CURP</span>
                                                                            <small id="passwordHelpBlock" class="form-text text-muted">
                                                                                Se puede tramitar
                                                                                <a class="text-primary" target="_blank" href="https://www.gob.mx/curp/">aquí­</a>
                                                                            </small>
                                                                        </div>

                                                                        <div class="custom-file col-xl-8 col-lg-8 col-md-8 col-sm-12 col-12" id="customFile">
                                                                            <input type="file" name="fileCURP" class="custom-file-input centraInput" id="fileCURP" aria-describedby="fileHelp">
                                                                            <span class="text-danger" id="error-CURP">No es una extensión válida. Puedes subir un archivo .jpg, .jpeg, .png o .pdf </span>
                                                                            <label class="custom-file-label" id="labelCurp">
                                                                                Elegir archivo (obligatorio)...
                                                                            </label>
                                                                        </div>

                                                                    </c:when>    
                                                                    <c:otherwise>
                                                                        <div class="col-xl-3 col-lg-3 col-md-3 col-sm-12 mb-2 text-center">                                                                    
                                                                            <span class="textoDocumento text-success"><i class="fas fa-check text-success mr-1"></i>CURP</span><br>
                                                                            <span class="text-success" style="font-size:11px;">Documento subido</span>
                                                                        </div>

                                                                        <div class="custom-file col-xl-8 col-lg-8 col-md-8 col-sm-12 col-12" id="customFile">
                                                                            <input type="file" name="fileCURP" class="custom-file-input centraInput" id="fileCURP" aria-describedby="fileHelp">
                                                                            <span class="text-danger" id="error-CURP">No es una extensión válida. Puedes subir un archivo .jpg, .jpeg, .png o .pdf </span>
                                                                            <label class="custom-file-label" id="labelCurp">
                                                                                ${sessionScope.curpName}
                                                                            </label>
                                                                        </div>
                                                                    </c:otherwise>
                                                                </c:choose>






                                                            </div>

                                                            <!-- Comprobante de domicilio -->

                                                            <div class="row mt-4">

                                                                <c:choose>
                                                                    <c:when test="${sessionScope.comprobante<=0}">

                                                                        <div class="col-xl-3 col-lg-3 col-md-3 col-sm-12 mb-2 text-center">
                                                                            <span class="textoDocumento">Comprobante de domicilio</span>
                                                                            <small id="passwordHelpBlock" class="form-text text-muted">
                                                                                Vigencia no mayor a 3 meses.
                                                                            </small>

                                                                        </div>

                                                                        <div class="custom-file col-xl-8 col-lg-8 col-md-8 col-sm-11 col-11" id="customFile">
                                                                            <input type="file" name="fileComprobanteDomicilio" class="custom-file-input" id="fileComprobanteDomicilio" aria-describedby="fileHelp">
                                                                            <span class="text-danger" id="error-comprobanteDomicilio">No es una extensión válida. Puedes subir un archivo .jpg, .jpeg, .png o .pdf </span>
                                                                            <label class="custom-file-label" id="labelComprobante">
                                                                                Elegir archivo (obligatorio)...
                                                                            </label>
                                                                        </div>

                                                                    </c:when>
                                                                    <c:otherwise>

                                                                        <div class="col-xl-3 col-lg-3 col-md-3 col-sm-12 mb-2 text-center">                                                                    

                                                                            <span class="textoDocumento text-success"><i class="fas fa-check text-success mr-1"></i>Comprobante de domicilio</span><br>
                                                                            <span class="text-success" style="font-size:11px;">Documento subido</span>
                                                                        </div>

                                                                        <div class="custom-file col-xl-8 col-lg-8 col-md-8 col-sm-11 col-11" id="customFile">
                                                                            <input type="file" name="fileComprobanteDomicilio" class="custom-file-input" id="fileComprobanteDomicilio" aria-describedby="fileHelp">
                                                                            <span class="text-danger" id="error-comprobanteDomicilio">No es una extensión válida. Puedes subir un archivo .jpg, .jpeg, .png o .pdf </span>
                                                                            <label class="custom-file-label" id="labelComprobante">
                                                                                ${sessionScope.comprobanteName}
                                                                            </label>
                                                                        </div>                                                                                                                                

                                                                    </c:otherwise>

                                                                </c:choose>



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


                                                            <!-- Estudios previos Mastografí­a-->
                                                            <div class="row mt-1">

                                                                <c:choose>
                                                                    <c:when test="${sessionScope.resultadoMastografia<=0}">
                                                                        <div class="col-xl-3 col-lg-3 col-md-3 col-sm-12 col-12 mb-2 text-center">
                                                                            <span class="textoDocumento">Reporte de resultados de estudios previos
                                                                                mastografía
                                                                            </span>
                                                                        </div>

                                                                        <div class="custom-file col-xl-8 col-lg-8 col-md-8 col-sm-11 col-11" id="customFileMasto">
                                                                            <input type="file" name="fileEstudioPrevioMasto" class="custom-file-input" id="fileEstudioPrevioMasto" aria-describedby="fileHelp">
                                                                            <span class="text-danger" id="error-previoMasto">No es una extensión válida. Puedes subir un archivo .jpg, .jpeg, .png o .pdf </span>
                                                                            <label class="custom-file-label" id="labelEstudioMasto">
                                                                                Elegir archivo...
                                                                            </label>
                                                                        </div>
                                                                    </c:when>
                                                                    <c:otherwise>                                                                
                                                                        <div class="col-xl-3 col-lg-3 col-md-3 col-sm-12 col-12 mb-2 text-center">
                                                                            <span class="textoDocumento text-success"><i class="fas fa-check text-success mr-1"></i>Reporte de resultados de estudios previos
                                                                                mastografía
                                                                            </span><br>
                                                                            <span class="text-success" style="font-size:11px;">Documento subido</span>
                                                                        </div>

                                                                        <div class="custom-file col-xl-8 col-lg-8 col-md-8 col-sm-11 col-11" id="customFileMasto">
                                                                            <input type="file" name="fileEstudioPrevioMasto" class="custom-file-input" id="fileEstudioPrevioMasto" aria-describedby="fileHelp">
                                                                            <span class="text-danger" id="error-previoMasto">No es una extensión válida. Puedes subir un archivo .jpg, .jpeg, .png o .pdf </span>
                                                                            <label class="custom-file-label" id="labelEstudioMasto">
                                                                                ${sessionScope.resultadoMastografiaName}
                                                                            </label>
                                                                        </div>
                                                                    </c:otherwise>
                                                                </c:choose>



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

                                                                <c:choose>
                                                                    <c:when test="${sessionScope.resultadoUltrasonido<=0}">
                                                                        <div class="col-xl-3 col-lg-3 col-md-3 col-sm-12 col-12 mb-12 text-center">
                                                                            <span class="textoDocumento">Reporte de resultados de estudios previos
                                                                                ultrasonido
                                                                            </span>
                                                                        </div>

                                                                        <div class="custom-file col-xl-8 col-lg-8 col-md-8 col-sm-11 col-11" id="customFileUsg">
                                                                            <input type="file" name="fileEstudioPrevioUsg" class="custom-file-input" id="fileEstudioPrevioUsg" aria-describedby="fileHelp">
                                                                            <span class="text-danger" id="error-previoUsg">No es una extensión válida. Puedes subir un archivo .jpg, .jpeg, .png o .pdf </span>
                                                                            <label class="custom-file-label" id="labelEstudioUsg">
                                                                                Elegir archivo...
                                                                            </label>
                                                                        </div>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <div class="col-xl-3 col-lg-3 col-md-3 col-sm-12 col-12 mb-12 text-center">
                                                                            <span class="textoDocumento text-success"><i class="fas fa-check text-success mr-1"></i>Reporte de resultados de estudios previos ultrasonido</span><br>
                                                                            <span class="text-success" style="font-size:11px;">Documento subido</span>
                                                                        </div>

                                                                        <div class="custom-file col-xl-8 col-lg-8 col-md-8 col-sm-11 col-11" id="customFileUsg">
                                                                            <input type="file" name="fileEstudioPrevioUsg" class="custom-file-input" id="fileEstudioPrevioUsg" aria-describedby="fileHelp">
                                                                            <span class="text-danger" id="error-previoUsg">No es una extensión válida. Puedes subir un archivo .jpg, .jpeg, .png o .pdf </span>
                                                                            <label class="custom-file-label" id="labelEstudioUsg">
                                                                                ${sessionScope.resultadoUltrasonidoName}
                                                                            </label>
                                                                        </div>                                                                
                                                                    </c:otherwise>
                                                                </c:choose>




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

                                                                <c:choose>
                                                                    <c:when test="${sessionScope.biopsiaPrevia<=0}">
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
                                                                            <span class="text-danger" id="error-biopsia">No es una extensión válida. Puedes subir un archivo .jpg, .jpeg, .png o .pdf </span>
                                                                            <label class="custom-file-label" id="labelEstudioBio">
                                                                                Elegir archivo...
                                                                            </label>
                                                                        </div>

                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <div class="col-xl-3 col-lg-3 col-md-3 col-sm-12 col-12 mb-2 text-center">
                                                                            <div class="form-check">
                                                                                <input class="form-check-input" name="biopsiaInput" type="checkbox" onclick="return false;" id="biopsiaInput" checked>
                                                                                <label class="form-check-label textoDocumento text-success">
                                                                                    ¿Te han hecho una biopsia previamente?
                                                                                </label>
                                                                            </div>
                                                                            <span class="text-success" style="font-size:11px">Documento subido</span>
                                                                        </div>

                                                                        <div class="custom-file col-xl-8 col-lg-8 col-md-8 col-sm-11 col-11">
                                                                            <input type="file" class="custom-file-input" id="fileEstudioBiopsia" name="fileEstudioBiopsia" aria-describedby="fileHelp">
                                                                            <span class="text-danger" id="error-biopsia">No es una extensión válida. Puedes subir un archivo .jpg, .jpeg, .png o .pdf </span>
                                                                            <label class="custom-file-label" id="labelEstudioBio">
                                                                                ${sessionScope.biopsiaPreviaName}
                                                                            </label>
                                                                        </div>
                                                                    </c:otherwise>
                                                                </c:choose>



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

                                                            <!-- Motivo de la consulta -->

                                                            <div class="row mt-4" id="formMotivoConsulta">

                                                                <div class="col-xl-3 col-lg-3 col-md-3 col-sm-12 col-12 text-center">
                                                                    <span class="textoDocumento">Motivo de la consulta<br>
                                                                        <small><strong>Obligatorio</strong></small>
                                                                    </span>
                                                                </div>

                                                                <div class="col-xl-8 col-lg-8 col-md-8 col-sm-12 col-12 removePadding">
                                                                    <select class="form-control" id="motivoConsulta">
                                                                        <option value="0">Seleccione el motivo de la consulta</option>
                                                                        <option value="1">Me envió un médico</option>
                                                                        <option value="3">No he consultado a ningún médico; pero me sentí una bolita en el seno</option>
                                                                        <option value="4">Me envían de otro hospital</option>
                                                                        <option value="5">Otro</option>
                                                                    </select>
                                                                    <span class="text-danger ml-3" id="error-motivoConsulta">No seleccionaste un motivo de consulta</span>
                                                                </div>
                                                            </div>

                                                            <div class="row mt-4" id="documentoAdjuntoMotivo">
                                                            </div>

                                                            <div class="row mt-4 mb-4" id="otroHospital">
                                                            </div>

                                                        </form>



                                                        <!-- Botones -->
                                                        <div class="row justify-content-center mt-5">

                                                            <div class="col-4 col-xl-4 col-lg-4 col-md-6 col-sm-12 col-12 mb-2">
                                                                <button class="btn btn-morado btn-block" id="btn-enviarSolicitud" style="border-radius:20px"><i
                                                                        class="fas fa-check-circle mr-2"></i>Enviar</button>
                                                            </div>
                                                            <div class="col-xl-4 col-lg-4 col-md-6 col-sm-12 col-12 mb-2">
                                                                <button class="btn btn-guardar-continuar btn-outline-primary btn-block" id="btn-GuardarContinuar" style="border-radius:20px"><i
                                                                        class="fas fa-save mr-2"></i>Guardar y Continuar Después</button>
                                                            </div>
                                                        </div>

                                                        <!-- ***** Nota ***** -->
                                                        <div class="row mt-3 justify-content-center">
                                                            <div class="col-7 text-center bg-danger" style="border-radius:20px;">
                                                                <span style="font-size: 14px;" class="text-white">Nota: Asegúrate de que tu motivo de consulta sea lo último
                                                                    que subas, puesto que no es información que puedas guardar y completar después. Debes estar segura(o) que
                                                                    cuando lo subas es porque darás click al botón de envíar para guardar la información.</span>
                                                            </div>
                                                        </div>

                                                    </div>
                                                </div>
                                            </c:otherwise>            
                                        </c:choose>   



                                    </div>

                                    <!-- APROBACION -->

                                    <c:choose>
                                        <c:when test="${sessionScope.estatus==1}">

                                            <div class="tab-pane show active fade white mt-4" id="nav-contact" role="tabpanel" aria-labelledby="nav-contact-tab">
                                                <div class="card mb-3">
                                                    <img class="card-img-top mt-3" style="width: 100px; display:block; margin:auto;" src="img/success2.png" alt="Card image cap">
                                                    <div class="card-body">

                                                        <c:choose>
                                                            <c:when test="${sessionScope.estadoPaciente<=0}">
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
                                                                            <li>-Póliza de seguro popular (si tienes)</li>
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
                                                                                te recibirá en el área de preconsulta, te llamarán por tu nombre y te pedirán estudios previos que tengas. Al terminar, ellas
                                                                                te navegarán por el hospital y te llevarán al servicio de imagenología,
                                                                                donde te harán los estudios de <strong>mastografía</strong>
                                                                                y
                                                                                <strong>ultrasonido de mama</strong>. Es requisito del hospital
                                                                                que estos estudios se hagan aquí, aunque ya te los hayan hecho
                                                                                en otro lugar. También, el médico valorará si necesitas que te
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
                                                                                revisará todos tus estudios, te explicará si necesitas otros
                                                                                y te dirá que sigue. Al igual que el primer día, nuestro servicio
                                                                                de navegación te recibirá en el área de preconsulta, nuevamente
                                                                                te pedirán los documentos que entregaste el día anterior. Si
                                                                                te realizaron una biopsia fuera del INCan debes traer <strong>dos copias</strong> del 
                                                                                reporte de patología que contiene los resultados. Al terminar,
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
                                                                                </strong>y
                                                                                <strong>$3000.00 MXN</strong> te recomendamos vengas preparada con
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
                                                                        <div class="col-4 text-center">
                                                                            <button style="border-radius:20px" type="button" id="irAMisCitas2" class="btn btn-outline-info btn-block"><i class="fas fa-calendar-alt"></i> Ver citas 
                                                                            </button>
                                                                        </div>
                                                                    </div>
                                                                </div>



                                                            </c:when>

                                                            <c:otherwise>

                                                                <div class="row">
                                                                    <div class="col-12">
                                                                        <h5 class="card-title display-4 tituloAprobacion text-center">Tu solicitud
                                                                            ha sido aprobada <br> como paciente de <strong><span class="colorMoradoLight">segunda opinión
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
                                                                            <li>-Póliza de seguro popular (si tienes)</li>
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
                                                                                costo de estos estudios está entre <strong>$350.00 MXN</strong>y <strong>$3000.00
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
                                                                        <div class="col-4 text-center">
                                                                            <button style="border-radius:20px" type="button" id="irAMisCitas2" class="btn btn-outline-info btn-block"><i class="fas fa-calendar-alt"></i> Ver citas 
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

                                            <div class="tab-pane fade white mt-4" id="nav-bienvenida" role="tabpanel" aria-labelledby="nav-bienvenida-tab">
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
                                                                    Tenemos personal calificado que te acompañará durante todo el proceso diagnóstico, de tratamiento, de rehabilitación, seguimiento
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
                                                                        y el área médica determinará si eres candidata para ser paciente
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
                                                                <button style="border-radius:20px" type="button" class="btn btn-morado btn-block" id="btn-continuar">Ir a Solicitud
                                                                    <i class="ml-2 fas fa-arrow-right"></i></button>
                                                            </div>
                                                        </div>

                                                    </div>
                                                </div>
                                            </div>

                                        </c:when>

                                        <c:otherwise>
                                            <div class="tab-pane fade white mt-4" id="nav-contact" role="tabpanel" aria-labelledby="nav-contact-tab">
                                                <div class="card mb-3">
                                                    <img class="card-img-top mt-3" style="width: 100px; display:block; margin:auto;" src="img/success2.png" alt="Card image cap">
                                                    <div class="card-body">

                                                        <c:choose>
                                                            <c:when test="${sessionScope.estadoPaciente<=0}">
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
                                                                            <li>-Póliza de seguro popular (si tienes)</li>
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
                                                                                te recibirá en el área de preconsulta, te llamarán por tu nombre y te pedirán estudios previos que tengas. Al terminar, ellas
                                                                                te navegarán por el hospital y te llevarán al servicio de imagenología,
                                                                                donde te harán los estudios de <strong>mastografía</strong>
                                                                                y
                                                                                <strong>ultrasonido de mama</strong>. Es requisito del hospital
                                                                                que estos estudios se hagan aquí, aunque ya te los hayan hecho
                                                                                en otro lugar. También, el médico valorará si necesitas que te
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
                                                                                revisará todos tus estudios, te explicará si necesitas otros
                                                                                y te dirá que sigue. Al igual que el primer día, nuestro servicio
                                                                                de navegación te recibirá en el área de preconsulta, nuevamente
                                                                                te pedirán los documentos que entregaste el día anterior. Si
                                                                                te realizaron una biopsia fuera del INCan debes traer <strong>dos copias</strong> del 
                                                                                reporte de patología que contiene los resultados. Al terminar,
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
                                                                                </strong>y
                                                                                <strong>$3000.00 MXN</strong> te recomendamos vengas preparada con
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
                                                                        <div class="col-4 text-center">
                                                                            <button style="border-radius:20px" type="button" id="irAMisCitas2" class="btn btn-outline-info btn-block"><i class="fas fa-calendar-alt"></i> Ver citas 
                                                                            </button>
                                                                        </div>
                                                                    </div>
                                                                </div>



                                                            </c:when>

                                                            <c:otherwise>

                                                                <div class="row">
                                                                    <div class="col-12">
                                                                        <h5 class="card-title display-4 tituloAprobacion text-center">Tu solicitud
                                                                            ha sido aprobada <br> como paciente de <strong><span class="colorMoradoLight">segunda opinión
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
                                                                            <li>-Póliza de seguro popular (si tienes)</li>
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
                                                                                costo de estos estudios está entre <strong>$350.00 MXN</strong>y <strong>$3000.00
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
                                                                        <div class="col-4 text-center">
                                                                            <button style="border-radius:20px" type="button" id="irAMisCitas2" class="btn btn-outline-info btn-block"><i class="fas fa-calendar-alt"></i> Ver citas 
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
                                                                    Tenemos personal calificado que te acompañará durante todo el proceso diagnóstico, de tratamiento, de rehabilitación, seguimiento
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
                                                                        y el área médica determinará si eres candidata para ser paciente
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
                                                                <button style="border-radius:20px" type="button" class="btn btn-morado btn-block" id="btn-continuar">Ir a Solicitud
                                                                    <i class="ml-2 fas fa-arrow-right"></i></button>
                                                            </div>
                                                        </div>

                                                    </div>
                                                </div>
                                            </div>
                                        </c:otherwise>

                                    </c:choose>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>


            </div>
        </div>
        <script src="js/validacionesPotencial.js" type="application/javascript"></script>
    </body>

</html>