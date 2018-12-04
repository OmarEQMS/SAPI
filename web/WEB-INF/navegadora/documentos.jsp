<%-- 
    Document   : documentos
    Created on : 2/11/2018, 11:15:08 AM
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

        <title>SAPI | Verificar Paciente</title>

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
         <div class="cargandoInicioNav" id="loading-screen" style="display: none">
            <img src="img/loading.svg">
            <p class="clear">Cargando inicio, por favor espere...</p>
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
                            <a class="iconoSidebar" href="" title="Mi Cuenta">
                                <i class="fas fa-cog"></i>
                            </a>
                        </div>

                        <div class="col-2">
                            <a class="iconoSidebar" href="" title="Cerrar Sesión" id="salirCuenta2">
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

                        <span class="pull-right d-block">
                            <span style="color:#6c6f80">Hola, </span>
                            <span style="font-weight:700; color:#6c6f80;">${sessionScope.nombre} ${sessionScope.primerApellido}
                            </span>
                            <img src="img/user.png" class="ml-2" style="width: 30px;" alt=""> </span>

                    </div>
                </nav>

                <!-- ************************************************************** -->
                <!-- *** A PARTIR DE AQUI ESCRIBEN EL CODIGO QUE QUIERAN..... *** -->
                <!-- ************************************************************** -->

                <!--Input hidden -->
                <input type="hidden" value="${sessionScope.idPaciente}" id="hiddenIdPaciente">


                <div class="row mb-3 justify-content-end">
                    <div class="col-3 text-center">
                        <span class="iconoHome mr-2">
                            <i class="fas fa-home"></i>
                        </span>
                        <span>
                            <a href="index.html" class="colorMoradoLight">Inicio</a>
                        </span>
                        -
                        <span class="colorGlobal">Documentos</span>
                    </div>
                </div>

                <!-- Jumbotron Titulo -->

                <div class="jumbotron jumbotron-fluid p-2">
                    <div class="container">
                        <h1 class="display-4 tituloPacientes text-center m-0" id="pacienteSelec">Documentos de: </h1>
                        <h6 class="display-4 text-center m-0 text-secondary" id="pacienteSelec" style="font-size:25px;">
                            ${sessionScope.nombrePacientePotencial} ${sessionScope.primerApellidoPacientePotencial} ${sessionScope.segundoApellidoPacientePotencial}
                        </h6>
                    </div>
                    <div class="form-group row justify-content-center mt-2">
                        <div class="col-12 text-center">

                            <img src="data:image/jpeg;base64,${sessionScope.base64ImgPac}" class="imagenPerfil edit-image" width="150px" height="150px" alt="">

                        </div>
                    </div>
                </div>

                <div class="row justify-content-center">
                    <div class="col-6 text-center">
                        <ul class="list-group">
                            <li class="list-group-item">Estado Civil:
                                <strong>${sessionScope.estadoCivil}</strong>
                            </li>
                            <li class="list-group-item">Fecha de Nacimiento:
                                <strong>${sessionScope.fechaNacimiento}</strong>
                            </li>
                            <li class="list-group-item">Lugar de residencia:
                                <strong>${sessionScope.estado}, ${sessionScope.municipio}</strong>
                            </li>
                            <li class="list-group-item">Direccion:
                                <strong>${sessionScope.calle}, # ${sessionScope.noExterior}, interior ${sessionScope.noInt}, colonia ${sessionScope.colonia}</strong>
                            </li>
                            <li class="list-group-item">Fecha de Registro:
                                <strong>${sessionScope.fechaRegistro}</strong>
                            </li>
                        </ul>
                    </div>
                    <div class="col-6 text-center">
                        <ul class="list-group">
                            <li class="list-group-item">CURP:
                                <strong>${sessionScope.curp}</strong>
                            </li>
                            <li class="list-group-item">Teléfono:
                                <strong>${sessionScope.telefono}</strong>
                            </li>
                            <li class="list-group-item">Motivo:
                                <strong>${sessionScope.motivoPreconsulta}</strong>
                            </li>
                            <li class="list-group-item">Correo:
                                <strong>${sessionScope.correo}</strong>
                            </li>
                            <li class="list-group-item">Visita:
                                <c:choose>
                                    <c:when test="${sessionScope.segundaOpinion==1}">
                                        <span class="badge badge-success">Segunda opinion</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="badge badge-success">Primera vez</span>
                                    </c:otherwise>

                                </c:choose>
                            </li>
                        </ul>
                    </div>
                </div>

                <div class="card mt-3">
                    <div class="card-body">
                        <!--Table-->

                        <table class="table table-striped mt-2" id="tArchivos">
                            <thead>
                                <tr>

                                    <th scope="col">Archivos</th>
                                    <th scope="col">Visualizar </th>
                                    <th scope="col">Descargar </th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${documentos}" var="documento">
                                    <tr>
                                        <td>







                                            <c:choose>
                                                <c:when test="${documento.aprobado==1}">
                                                    <c:out value="${documento.nombreTipo}"/>
                                                    <span class=" ml-2 badge badge-success">Aprobado</span>
                                                </c:when>
                                                <c:when test="${documento.aprobado==-1}">
                                                    <c:out value="${documento.nombreTipo}"/>
                                                    <span class=" ml-2 badge badge-warning">No revisado</span>
                                                </c:when>
                                                <c:otherwise>
                                                    <i class="fas fa-comments mr-2 iconoComentarios verComentario" data-id="${documento.idDocumentoInicial}" data-toggle="modal" data-target="#modalVerComentario" ></i>

                                                    <c:out value="${documento.nombreTipo}"/>
                                                    <span class=" ml-2 badge badge-danger">Rechazado</span>
                                                </c:otherwise>

                                            </c:choose>
                                        </td>
                                        <td>
                                            <a  class="btn btn-info irAVerDocumento" id="btn-ver " data-id="${documento.idDocumentoInicial}">
                                                <i class="far fa-eye "></i>
                                                </button>
                                        </td>
                                        <td>

                                            <form action="NavegadoraController">
                                                <input type="hidden" value="${documento.idDocumentoInicial}" name="idDocumento">
                                                <input type="hidden" value="descargarArchivo" name="key">
                                                <button type="submit" class="btn btn-primary descargarDocumento"  data-id="${documento.idDocumentoInicial}">

                                                    <i class="fas fa-cloud-download-alt"></i>
                                                </button>
                                            </form>
                                        </td>
                                <input type="hidden" value="${documento.comentario}" id="comentario-${documento.idDocumentoInicial}">
                                </tr>
                            </c:forEach>


                            </tbody>
                        </table>



                    </div>
                </div>


            </div>

        </div>


        <!-- ******** MODAL VER COMENTARÍO ******** -->
        <div class="modal fade " id="modalVerComentario" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered " role="document">
                <div class="modal-content ">
                    <div class="modal-header ">
                        <h5 class="modal-title " id="exampleModalLongTitle"> Razón de rechazo</h5>
                        <button type="button" class="close " data-dismiss="modal " aria-label="Close ">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body ">
                        <div class="row ">
                            <div class="col-12 " id="modalComentario">
                                <span class="d-block"> </span>

                            </div>
                        </div>

                    </div>
                    <div class="modal-footer ">
                        <button type="button" id="cerrarModal" class="btn btn-danger" style="border-radius: 20px" data-dismiss="modal">Cerrar</button>
                        <button type="button" id="aceptarModal" class="btn btn-primary" style="border-radius: 20px" data-dismiss="modal">Aceptar</button>
                    </div>
                </div>
            </div>
        </div>



    </div>
</div>

</body>

</html>