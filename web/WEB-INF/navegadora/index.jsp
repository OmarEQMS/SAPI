<%-- 
    Document   : index
    Created on : 01-nov-2018, 14:05:35
    Author     : urieldiaz, julioguzman, shannonrosas
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <%-- Hace rereferencia al conjunto de reglas --%>
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
        <script src="js/ajaxNavegadora.js"></script>


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

                    <div class="row justify-content-center">
                        <div class="col-12 text-center">
                            <hr style="background-color:white !important">
                        </div>
                    </div>


                    <!-- MENU PRINCIPAL ENLACES -->
                    <ul class="list-unstyled components">


                        <li id="irADashboard"><a><i class="fas fa-home"></i>Inicio</a></li>

                        <li id="idACalendario"><a><i class="fas fa-calendar-alt"></i>Calendario</a></li>
                        <li id="irARendimiento"><a><i class="fas fa-chart-line"></i>Mi Rendimiento</a></li>

                        <li id="irACuenta"><a><i class="far fa-user"></i>Mi Cuenta</a></li>

                        <li id="irADocumentos"><a><i class="far fa-user"></i>Documentos</a></li>

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

                        <span class="pull-right d-block"><span style="color:#6c6f80">Bienvenido, </span><span style="font-weight:700; color:#6c6f80;">${sessionScope.nombre} ${sessionScope.primerApellido}

                            </span> <img src="img/user.png" class="ml-2" style="width: 30px;" alt=""> </span>

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


                                                <c:forEach items="${listaPacientes}" var="paciente">
                                                    <tr>                                                                                                                      

                                                        <td>${paciente.nombre}</td>
                                                        <td>${paciente.primerApellido}</td>
                                                        <td>${paciente.segundoApellido}</td>
                                                        <td>${paciente.estadoPaciente}</td>
                                                        <td>${paciente.fechaRegistro}</td>
                                                        <td>${paciente.curp}</td>
                                                        <td>${paciente.telefono}</td>
                                                        <td>
                                                            <button class="btn btn-info btn-ver" data-id="${paciente.idPaciente}" id="btn-ver">
                                                                <i class="far fa-eye"></i>
                                                            </button>

                                                            <c:choose>
                                                                <c:when test="${paciente.estadoPaciente=='Potencial en proceso'}">
                                                                    <button class="btn btn-success btn-aceptar" data-id="${paciente.idPaciente}" data-toggle="modal" data-target="#modalAceptarUsuario">
                                                                        <i class="fas fa-check"></i>
                                                                    </button>
                                                                </c:when>    

                                                            </c:choose>

                                                            <button class="btn btn-primary btn-editar" data-id="${paciente.idPaciente}" id="btn-editar" data-toggle="modal" data-target="#modalEditarUsuario">
                                                                <i class="fas fa-edit"></i>
                                                            </button>
                                                            <button class="btn btn-danger mt-1 btn-eliminar" data-id="${paciente.idPaciente}" id="btn-eliminar" data-toggle="modal" data-target="#modalEliminarUsuario">
                                                                <i class="fas fa-trash-alt"></i>
                                                            </button>
                                                        </td>

                                                    </tr>
                                                </c:forEach>


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

                                                <c:forEach items="${listaPacientesAprobados}" var="pacienteAprobado">
                                                    <c:choose>
                                                        <c:when test="${pacienteAprobado.color==0}">
                                                            <tr class="table-danger">
                                                            </c:when>
                                                            <c:when test="${pacienteAprobado.color==1}">
                                                            <tr class="table-warning">
                                                            </c:when>
                                                            <c:when test="${pacienteAprobado.color==2}">
                                                            <tr class="table-primary">
                                                            </c:when>
                                                            <c:when test="${pacienteAprobado.color==3}">
                                                            <tr class="table-success">
                                                            </c:when>
                                                            <c:otherwise>
                                                            <tr>
                                                            </c:otherwise>
                                                        </c:choose>



                                                        <td>${pacienteAprobado.prz}</td>
                                                        <td>${pacienteAprobado.nombre}</td>
                                                        <td>${pacienteAprobado.primerApellido}</td>
                                                        <td>${pacienteAprobado.segundoApellido}</td>

                                                        <c:choose>
                                                            <c:when test="${pacienteAprobado.tipoPaciente==1}">
                                                                <td>Segunda Opinion</td>
                                                            </c:when>    
                                                            <c:otherwise>
                                                                <td>Primera vez</td>
                                                            </c:otherwise>
                                                        </c:choose>


                                                        <c:choose>
                                                            <c:when test="${pacienteAprobado.tieneResultados==1}">
                                                                <td><span class="badge badge-success">R</span> </td>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <td></td>
                                                            </c:otherwise>
                                                        </c:choose>

                                                        <td>${pacienteAprobado.fechaRegistro}</td>                  
                                                        <td>${pacienteAprobado.telefono}</td>
                                                        <td>
                                                            <button class="btn btn-info btn-ver" data-id="${pacienteAprobado.idPaciente}" id="btn-ver">
                                                                <i class="far fa-eye"></i>
                                                            </button>
                                                            <button class="btn btn-success btn-aceptar" data-id="${pacienteAprobado.idPaciente}" id="btn-aceptar" data-toggle="modal" data-target="#modalAceptarUsuario">
                                                                <i class="fas fa-check"></i>
                                                            </button>
                                                            <button class="btn btn-primary btn-editar" data-id="${pacienteAprobado.idPaciente}" id="btn-editar" data-toggle="modal" data-target="#modalEditarUsuario">
                                                                <i class="fas fa-edit"></i>
                                                            </button>
                                                            <button class="btn btn-danger mt-1 btn-eliminar" data-id="${pacienteAprobado.idPaciente}" id="btn-eliminar" data-toggle="modal" data-target="#modalEliminarUsuario">
                                                                <i class="fas fa-trash-alt"></i>
                                                            </button>
                                                        </td>

                                                    </tr>
                                                </c:forEach>
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
                                        <input type="text" class="form-control" id="nombreNavegadora" name="nombreNavegadora" placeholder="Nombre">
                                        <span class="text-danger" id="errorNombreNavegadora">Formato incorrecto, solo caracteres alfabéticos con un mínimo de 2 y un máximo de 255 caracteres.</span>
                                    </div>
                                </div>

                                <div class="col-6">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fas fa-id-card"></i>
                                            </div>
                                        </div>
                                        <input type="text" class="form-control" id="curpNavegadora" name="curpNavegadora" placeholder="CURP">


                                    </div>

                                    <span class="text-danger" id="errorCurpNavegadora">Formato incorrecto, las letras deben estar en mayúsculas y asegúrate de introducir un CURP válido y sin espacios. Puedes consultarlo 
                                        <a class="text-primary " target="_blank" href="https://www.gob.mx/curp/">aquí.</a>
                                    </span><br>

                                    <span class="text-warning" id="errorCurpRepetidoNavegadora">El curp ya existe.</span>
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
                                               id="cumpleNavegadora" name="cumpleNavegadora">

                                    </div>
                                    <span class="text-danger" id="errorFechaNavegadora">Fecha incorrecta</span>
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
                                        <input type="text" class="form-control" id="primer-apellidoNavegadora" name="primer-apellidoNavegadora" placeholder="Primer Apellido">
                                    </div>
                                    <span class="text-danger" id="errorApellidoPaternoNavegadora">Formato incorrecto, solo caracteres alfabéticos con un mínimo de 2 y un máximo de 127 caracteres.</span>

                                </div>

                                <div class="col-6">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fas fa-user"></i>
                                            </div>
                                        </div>
                                        <input type="text" class="form-control" id="segundo-apellidoNavegadora" name="segundo-apellidoNavegadora" placeholder="Segundo Apellido">
                                        <span class="text-danger" id="errorApellidoMaternoNavegadora">Formato incorrecto, solo caracteres alfabéticos con un mínimo de 2 y un máximo de 127 caracteres.</span>
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
                                        <input type="text" class="form-control" id="usuarioNavegadora" usuario="usuarioNavegadora" placeholder="Usuario">

                                    </div>
                                    <span class="text-danger" id="errorNombreUsuarioNavegadora">Formato incorrecto, solo caracteres alfabéticos con un mínimo de 4 y un máximo de 16 caracteres.</span><br>
                                    <span class="text-warning" id="errorUsuarioRepetidoNavegadora">El usuario ya existe.</span>
                                </div>
                                <div class="col-6">
                                    <div class="input-group">
                                        <select class="form-control" name="estado-civilNavegadora" id="estado-civilNavegadora">                                            
                                            <option disabled selected>Estado Civil</option>
                                            <c:forEach items="${estadoCivil}" var="estadoC">  
                                                <option value='<c:out value="${estadoC.idEstadoCivil}"/>'><c:out value='${estadoC.nombre}'/> </option>
                                            </c:forEach>
                                        </select>

                                    </div>
                                    <span class="text-danger" id="errorECivilNavegadora">Selecciona una opcion</span>
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
                                        <input type="text" class="form-control" id="colNavegadora" placeholder="Colonia">
                                    </div>
                                    <span class="text-danger" id="errorColoniaNavegadora">Formato incorrecto, introducir caracteres alfanuméricos.</span>

                                </div>
                                <div class="col-6">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fas fa-map-marker-alt"></i>
                                            </div>
                                        </div>
                                        <input type="text" class="form-control" id="codigo-postalNavegadora" placeholder="Codigo Postal">

                                    </div>
                                    <span class="text-danger" id="errorCodigoPostalNavegadora">Formato incorrecto, deben ser 5 dígitos.</span><br>
                                    <span class="text-danger" id="error-CPexisteNavegadora" style="font-size:13px;">El codigo postal no existe.</span>
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
                                        <input type="text" class="form-control" id="calleNavegadora" calle="calleNavegadora" placeholder="Calle">
                                    </div>
                                    <span class="text-danger" id="errorCalleNavegadora">Formato incorrecto, introducir caracteres alfanuméricos.</span>

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
                                    <span class="text-danger" id="errorNoInteriorNavegadora">Formato incorrecto, solo dígitos y/o letras.</span>

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
                                    <span class="text-danger" id="errorNoExteriorNavegadora">Formato incorrecto, solo dígitos.</span>

                                </div>
                            </div>

                            <div class="form-group row">
                                <div class="col-6">
                                    <div class="input-group">
                                        <select class="form-control" id="estadoNavegadora">
                                            <option disabled selected>Seleccione estado</option>
                                            <c:forEach items="${estado}" var="estado">  
                                                <option value='<c:out value="${estado.idEstado}"/>'><c:out value='${estado.nombre}'/> </option>
                                            </c:forEach>
                                        </select>

                                    </div>
                                    <span class="text-danger" id="errorEstadoNavegadora">Campo vacío</span>
                                </div>
                                <div class="col-6">
                                    <div class="input-group municipios">
                                        <select class="form-control" id="municipioNavegadora">
                                            <option disabled selected>Seleccione Municipio</option>
                                        </select>

                                    </div>
                                    <span class="text-danger" id="errorMunicipioNavegadora">Campo vacío</span>
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
                                    <span class="text-danger" id="errorTelefonoNavegadora">Formato incorrecto, deben ser 10 dígitos.</span>
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
                                    <span class="text-danger" id="errorCorreoNavegadora">El formato no es correcto, introduce un mínimo de 2 y un máximo de 254 caracteres.</span>

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
                                        <input type="password" class="form-control" id="contraNavegadora" placeholder="Contraseña">
                                        <span class="text-danger" id="errorPass1Navegadora">Formato incorrecto, la contraseña debe tener al menos 1 número, 1 letra minúscula, 1 mayúscula y una extensión de 8 a 14 caracteres.</span>
                                    </div>
                                </div>
                                <div class="col-6">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fas fa-lock"></i>
                                            </div>
                                        </div>
                                        <input type="password" class="form-control" id="confContraNavegadora" placeholder="Confirmar contraseña">
                                        <span class="text-warning" id="noEqualPasswordsErrorNavegadora">Las contraseñas no son iguales.</span>
                                        <span class="text-danger" id="errorPass2Navegadora">Formato incorrecto, la contraseña debe tener al menos 1 número, 1 letra minúscula, 1 mayúscula y una extensión de 8 a 14 caracteres.</span>
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
                                        <input class="form-check-input" type="checkbox" value="0" id="acepto-terminos">
                                        <label class="form-check-label" for="acepto-terminos">
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
                                    <span class="text-danger" id="error-editar-NombreNavegadora">Formato incorrecto, solo caracteres alfabéticos con un mínimo de 2 y un máximo de 255 caracteres.</span>

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
                                    <span class="text-danger" id="error-editar-CurpNavegadora">Formato incorrecto, las letras deben estar en mayúsculas y asegúrate de introducir un CURP válido y sin espacios. Puedes consultarlo 
                                        <a class="text-primary " target="_blank" href="https://www.gob.mx/curp/">aquí.</a>
                                    </span><br>

                                    <span class="text-warning" id="error-editar-CurpRepetidoNavegadora">El curp ya existe.</span>
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
                                    <span class="text-danger" id="error-editar-FechaNavegadora">Fecha incorrecta</span>
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
                                    <span class="text-danger" id="error-editar-ApellidoPaternoNavegadora">Formato incorrecto, solo caracteres alfabéticos con un mínimo de 2 y un máximo de 127 caracteres.</span>

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
                                    <span class="text-danger" id="error-editar-ApellidoMaternoNavegadora">Formato incorrecto, solo caracteres alfabéticos con un mínimo de 2 y un máximo de 127 caracteres.</span>

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
                                    <span class="text-danger" id="error-editar-NombreUsuarioNavegadora">Formato incorrecto, solo caracteres alfabéticos con un mínimo de 4 y un máximo de 16 caracteres.</span><br>
                                    <span class="text-warning" id="error-editar-UsuarioRepetidoNavegadora">El usuario ya existe.</span>
                                </div>
                                <div class="col-6">
                                    <div class="input-group">
                                        <select class="form-control" name="estado-civilNavegadora" id="editarEstado-civilNavegadora">
                                            <option disabled selected>Estado Civil</option>
                                            <c:forEach items="${estadoCivil}" var="estadoC">  
                                                <option value='<c:out value="${estadoC.idEstadoCivil}"/>'><c:out value='${estadoC.nombre}'/> </option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <span class="text-danger" id="error-editar-ECivilNavegadora">Selecciona una opcion</span>
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
                                    <span class="text-danger" id="error-editar-ColoniaNavegadora">Formato incorrecto, introducir caracteres alfanuméricos.</span>

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

                                    <span class="text-danger" id="error-editar-CalleNavegadora">Formato incorrecto, introducir caracteres alfanuméricos.</span>

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
                                    <span class="text-danger" id="error-editar-NoInteriorNavegadora">Formato incorrecto, solo dígitos y/o letras.</span>

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
                                    <span class="text-danger" id="error-editar-NoExteriorNavegadora">Formato incorrecto, solo dígitos y/o letras.</span>

                                </div>
                            </div>

                            <div class="form-group row">
                                <div class="col-6">
                                    <div class="input-group">
                                        <select class="form-control" id="editarEstadoNavegadoraAPaciente">
                                            <option disabled selected>Seleccione estado</option>
                                            <c:forEach items="${estado}" var="estado">  
                                                <option value='<c:out value="${estado.idEstado}"/>'><c:out value='${estado.nombre}'/> </option>
                                            </c:forEach>
                                        </select>
                                    </div>

                                    <span class="text-danger" id="error-editar-EstadoNavegadora">Campo vacío</span>

                                </div>
                                <div class="col-6">
                                    <div class="input-group editarMunicipios">
                                        <select class="form-control" name="" id="editarMunicipioNavegadoraAPaciente">
                                            <option disabled selected>Municipio</option>
                                        </select>
                                    </div>

                                    <span class="text-danger" id="error-editar-MunicipioNavegadora">Campo vacío</span>

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
                                    <span class="text-danger" id="error-editar-TelefonoNavegadora">Formato incorrecto, deben ser 10 dígitos.</span>
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
                                    <span class="text-danger" id="error-editar-CorreoNavegadora">El formato no es correcto, introduce un mínimo de 2 y un máximo de 254 caracteres.</span>

                                </div>

                            </div>



                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger" data-dismiss="modal" style="border-radius:20px">Cancelar</button>
                            <button type="button" class="btn btn-primary" id="btn-guardarCambios" style="border-radius:20px">Guardar Cambios</button>
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
                                    <select class="form-control" id="tipo-paciente">
                                        <option disabled selected>Seleccione un tipo de paciente</option>
                                        <option value="0">Primera vez</option>
                                        <option value="1">Segunda opinión</option>
                                    </select>
                                </div>

                            </div>


                            <input type="hidden" id="hidden-idPaciente">

                        </div>

                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger" style="border-radius:20px" data-dismiss="modal">Cancelar</button>
                            <button type="button" class="btn btn-primary" style="border-radius:20px" id="btn-aceptarDocumento">Aceptar</button>
                        </div>
                    </div>
                </div>
            </div>


        </div>


    </body>

</html>                                                                                                                                                                            </html>