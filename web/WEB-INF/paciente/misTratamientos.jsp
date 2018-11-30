<%-- 
    Document   : misTratamientos
    Author     : feror, julioguzman, shannonrosas
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <link href="lib/tooltipster/dist/css/plugins/tooltipster/sideTip/themes/tooltipster-sideTip-shadow.min.css" rel="stylesheet" />
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

        <link rel="stylesheet" href="css/stylePaciente.css">
        <script src="js/appPaciente.js"></script>
        <script src="js/calendarPaciente.js"></script>
        <script src="js/ajaxPaciente.js"></script>
        <script src="js/validacionesPaciente.js"></script>

    </head>

    <body>
        
        <input type="hidden" value="5" class="idTratamientoPaciente">
        <input type="hidden" value="${sessionScope.fechaNacimiento}" class="fechaNacimientoPaciente">

        <div id="hiddensDiv"></div>
        <div class="wrapper">

            <!-- SIDEBAR -->
            <nav id="sidebar">

                <div class="sidebar-header">

                    <div class="row text-center justify-content-center mt-2">
                        <div class="col-12">
                            <img src="img/logoSapi.png" style="width: 70%; display:block; margin:auto;" alt=""></div>
                    </div>

                </div>

                <div class="profile">
                    <div class="row">
                        <div class="col-12 mb-2 mt-4">
                            <!-- <img src="img/user.png" class="imagenPerfil" alt=""> -->
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
                            <a class="iconoSidebar irACuenta" title="Mi Cuenta"><i class="fas fa-cog"></i></a>
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


                    <li id="irMisCitas"><a><i class="far fa-user"></i>Mis citas</a></li>
                    <li id="irACuenta" class="irACuenta"><a><i class="far fa-user"></i>Mi Cuenta</a></li>
                    <li id="irATratamientos"><a><i class="far fa-user"></i>Mis Tratamientos</a></li>
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
                        </span>

                    </div>
                </nav>

                <div class="row mb-3 justify-content-end">
                    <div class="col-3 text-center">
                        <span class="iconoHome mr-2">
                            <i class="fas fa-home"></i>
                        </span>
                        <span>
                            <a id="irAInicioPaciente" class="colorMoradoLight">Inicio</a>
                        </span>
                        -
                        <span class="colorGlobal">Mis Tratamientos</span>
                    </div>
                </div>

                <!-- Jumbotron Titulo -->

                <div class="jumbotron jumbotron-fluid p-2">
                    <div class="container">
                        <h1 class="display-4 tituloMiCuenta text-center m-0">Mis tratamientos</h1>
                    </div>
                </div>


                <!-- Gestion -->

                <div class="card mt-3">
                    <div class="card-body">

                        <!-- Boton agregar -->

                        <div class="row mb-3">
                            <div class="col-12">
                                <button style="border-radius:20px;" class="btn btn-morado float-right" data-toggle="modal"
                                        data-target="#modalAgregarTratamiento"><i class="fas fa-prescription-bottle-alt"></i>
                                    Agregar
                                    Tratamiento</button>
                            </div>
                        </div>

                        <!-- Table -->

                        <table class="table table-striped tablaTratamientos mt-3" id="tablaTratamientos">
                            <thead>
                                <tr>
                                    <th scope="col">Tratamiento</th>
                                    <th scope="col">Fecha de inicio</th>
                                    <th scope="col">Fecha de fin</th>
                                    <th scope="col">Editar</th>
                                </tr>
                            </thead>
                            <tbody>

                            <c:forEach  items="${UnionTratamientosPaciente}" var="unionTratamientoPaciente">
                                <tr>
                                <input type="hidden" value="${unionTratamientoPaciente.nombre}" id="nombre-${unionTratamientoPaciente.idTratamientoPaciente}">
                                <input type="hidden" value="${unionTratamientoPaciente.fechaInicio}" id="fechaInicio-${unionTratamientoPaciente.idTratamientoPaciente}">
                                <input type="hidden" value="${unionTratamientoPaciente.idTratamientoPaciente}" id="boton-${unionTratamientoPaciente.idTratamientoPaciente}">
                                <td id="nombre-${unionTratamientoPaciente.idTratamientoPaciente}" value="${unionTratamientoPaciente.nombre}" > <c:out value="${unionTratamientoPaciente.nombre}"/> </td>
                                <td id="fechaInicio-${unionTratamientoPaciente.idTratamientoPaciente}" > <c:out value="${unionTratamientoPaciente.fechaInicio}"/> </td>
                                <td id="fecha-${unionTratamientoPaciente.idTratamientoPaciente}"> <c:out value="${unionTratamientoPaciente.fechaFin}"/> </td>
                                <c:choose>
                                    <c:when test="${unionTratamientoPaciente.terminado}">
                                        <td> 
                                            <button class="btn btn-secondary terminarTratamiento" id="modal-${unionTratamientoPaciente.idTratamientoPaciente}" data-id="${unionTratamientoPaciente.idTratamientoPaciente}"
                                                    data-toggle="modal"
                                                    data-target="#modalEditarTerminado" disabled="disabled"><i class="fas fa-edit" ></i></button></td>
                                            </c:when>
                                            <c:otherwise>
                                        <td> 
                                            <button class="btn btn-primary terminarTratamiento" id="modal-${unionTratamientoPaciente.idTratamientoPaciente}" data-id="${unionTratamientoPaciente.idTratamientoPaciente}"
                                                    data-toggle="modal"
                                                    data-target="#modalEditarTerminado" ><i class="fas fa-edit" ></i></button></td>

                                    </c:otherwise>

                                </c:choose>
                                </tr>
                            </c:forEach>
                            <input type="hidden" id="botonHidden">

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <!-- ***** MODAL AGREGAR TRATAMIENTO ***** -->
        <div id="modalAgregarTratamiento" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="modalRegistrarTratamientoLabel"
             aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
                <div class="modal-content">
                    <!-- ***** Titulo ***** -->
                    <div class="modal-header">
                        <h5 class="modal-title tituloCitaModal text-secondary display-4" style="font-size: 25px;" id="modalRegistrarTratamientoLabel">Registrar
                            Tratamiento
                        </h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="color: #fff;">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <!-- ***** Contenido ***** -->
                    <div class="modal-body">
                        <div class="container-fluid" style="max-height:70vh; overflow-y:auto;">

                            <!-- ***** Fecha Inicio ***** -->

                            <div class="row mb-3 justify-content-center">
                                <div class="col-8">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fas fa-calendar-alt"></i>
                                            </div>
                                        </div>
                                        <input placeholder="Introduce la fecha de inicio" class="selectStyle form-control textbox-n fechaInicio"
                                               type="text" onfocus="(this.type = 'date')" id="fechaInicioTratamiento">

                                    </div>
                                    <span class="text-danger error-fecha" id="error-fechaInicio"> Fecha incorrecta. Introduce una fecha posterior a tu fecha de nacimiento y no mayor a 2 meses a partir de hoy.</span>
                                </div>

                            </div>

                            <!-- ***** Tipo ***** -->

                            <!-- ***** Tipo ***** -->
                            <div class="row mb-3 justify-content-center">
                                <div class="col-8">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fas fa-prescription-bottle"></i>
                                            </div>
                                        </div>
                                        <input type="hidden" value="" id="nombreTipoTratamiento"/>
                                        <select class="custom-select tratamiento" id="tipoTratamiento">
                                            <option disabled selected>Elegir Tratamiento</option>
                                            <c:forEach items="${tipoTratamiento}" var="tratamiento"> 

                                                <option value='<c:out value="${tratamiento.idTipoTratamiento}"/>'><c:out value='${tratamiento.nombre}'/> </option>

                                            </c:forEach> 

                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger myCleanerAddTratamientos" style="border-radius:20px;" data-dismiss="modal">Cancelar</button>
                            <button id="btn-agregarTratamiento" type="button" class="btn btn-primary myCleanerAddTratamientos" style="border-radius:20px;">Registrar</button>
                            <!-- ***** este es el bueno***** -->
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- ***** MODAL EDITAR TRATAMIENTO ***** -->
        <div id="modalEditarTerminado" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="modalRegistrarTratamientoLabel"
             aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
                <div class="modal-content">
                    <!-- ***** Titulo ***** -->
                    <div class="modal-header">
                        <h5 class="modal-title tituloModal text-secondary display-4" style="font-size: 25px;" id="modalRegistrarTratamientoLabel">Editar
                            Tratamiento
                        </h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="color: #fff;">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <!-- ***** Contenido ***** -->
                    <div class="modal-body">
                        <div class="container-fluid" style="max-height:70vh; overflow-y:auto;">

                            <!-- ***** Fecha Inicio ***** -->

                            <div class="row mb-3 justify-content-center">
                                <div class="col-8">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fas fa-calendar-alt"></i>
                                            </div>
                                        </div>
                                        <input placeholder="Introduce la fecha de inicio" class="selectStyle form-control textbox-n"
                                               type="text" onfocus="(this.type = 'date')" id="fechaInicioTratamiento2" readonly>
                                    </div>
                                </div>

                            </div>

                            <!-- ***** Tipo ***** -->
                            <div class="row mb-3 justify-content-center">
                                <div class="col-8">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fas fa-prescription-bottle"></i>
                                            </div>
                                        </div>
                                        <input disabled class="form-control" value="" id="tipoTratamiento2"/>
                                    </div>
                                </div>
                            </div>

                            <!-- ***** Fecha Fin ***** -->

                            <div class="row mb-3 justify-content-center">
                                <div class="col-8">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fas fa-calendar-alt"></i>
                                            </div>
                                        </div>
                                        <input placeholder="Introduce la fecha de fin" class="selectStyle form-control textbox-n fechaFin"
                                               type="text" onfocus="(this.type = 'date')" id="fechaFinTratamiento">
                                    </div>
                                    <span class="text-danger error-fechaFin" id="error-fechaFin"> Fecha incorrecta. Introduce una fecha posterior a la fecha de inicio de tu tratamiento y no mayor a la fecha de hoy.</span>
                                </div>

                            </div>

                        </div>
                        <div class="row mt-3 justify-content-center">
                            <div class="col-9 text-center bg-danger" style="border-radius:20px;">
                                <span style="font-size: 14px;" class="text-white"> <strong>Nota:</strong> Ten en cuenta que una vez registrada la fecha de fin de tu tratamiento
                                    no podrás modificarla posteriormente.</span>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger myCleanerAddFinTratamientos" style="border-radius:20px;" data-dismiss="modal">Cancelar</button>
                            <button id="fechaTerminarTratamiento" type="button" class="btn btn-primary myCleanerAddFinTratamientos" style="border-radius:20px;">Registrar</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>



    </body>

</html>