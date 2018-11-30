<%-- 
    Document   : gestionPacientes
    Created on : 15-nov-2018, 2:30:50
    Author     : urieldiaz
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

        <link rel="stylesheet" href="css/styleAdministrador.css">
        <script src="js/appAdministrador.js"></script>
        <script src="js/ajaxAdministrador.js"></script>

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
                            <img src="img/user.png" class="imagenPerfil" alt="">
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
                            <a class="iconoSidebar" href="" title="Cerrar Sesión"><i class="fas fa-power-off"></i></a>
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

                    <li id="IrAGestionMedicos"><a><i class="fas fa-briefcase-medical"></i>Médicos</a></li>

                    <li id="IrAGestionNavegadora"><a><i class="fas fa-calendar-alt"></i>Navegadoras</a></li>

                    <li id="IrAGestionPaciente"><a><i class="fas fa-users"></i>Pacientes</a></li>

                    <li id="IrAGestionAdministrador"><a><i class="fas fa-shield-alt"></i>Administradores</a></li>

                    <li id="IrAMiCuenta"><a><i class="far fa-user"></i>Mi cuenta</a></li>

                    <li id="IrAReasignarMedico"><a><i class="fas fa-sync"></i>Reasignar médico</a></li>

                    <li id="salirCuenta"><a><i class="fas fa-sign-out-alt"></i>Cerrar sesión</a></li>

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

                        <span class="pull-right d-block"><span style="color:#6c6f80">Hola, </span><span style="font-weight:700; color:#6c6f80;">${sessionScope.nombre} ${sessionScope.primerApellido}
                            </span></span>
                    </div>
                </nav>

                <!-- Navegacion -->


                <div class="row mb-3 justify-content-end">
                    <div class="col-3 text-center">
                        <span class="iconoHome mr-2"><i class="fas fa-home"></i></span><span><a id="IrAInicio" class="colorMoradoLight">Inicio</a></span>
                        - <span class="colorGlobal">Gestion de Pacientes</span>
                    </div>
                </div>

                <!-- Jumbotron Titulo -->

                <div class="jumbotron jumbotron-fluid p-2">
                    <div class="container">
                        <h1 class="display-4 tituloMisCitas text-center m-0">Gestión de Pacientes</h1>
                    </div>
                </div>


                <!-- Gestion -->

                <div class="card mt-3">
                    <div class="card-body">

                        <!-- Boton agregar -->

                        <div class="row justify-content-end mt-2">
                            <div class="col-12">
                                <button style="border-radius:20px;" class="btn btn-morado float-right" data-toggle="modal" data-target="#modalAgregarPaciente"><i
                                        class="fas fa-plus-circle mr-2"></i>Agregar Paciente</button>
                            </div>

                        </div>
                        
                        <div class="row">
                            <div class="col-12 centrado mb-3">
                                <button style="border-radius:20px; vertical-align:middle" class="btn-reportePoblacion float-left" id="btn-poblacion"><span> Descargar Reporte de Población</span></button>
                            </div>

                        </div>

                        <!-- Table -->

                        <table class="table table-striped mt-3" id="tablaPacientes">
                            <thead>
                                <tr>
                                    <th scope="col">PRZ</th>
                                    <th scope="col">Nombre</th>
                                    <th scope="col">Tratamiento</th>
                                    <th scope="col">Etapa Clínica</th>
                                    <th scope="col">Teléfono</th>
                                    <th scope="col">Estado</th>
                                    <th scope="col">Médico</th>
                                    <th scope="col">Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${ListaPacientesAdministrador}" var="paciente">
                                    <tr>
                                        <td id="prz-${paciente.idPaciente}" value="${paciente.prz}" > <c:out value="${paciente.prz}"/> </td>
                                        <td id="nombre-${paciente.idPaciente}" value="${paciente.nombre}" > <c:out value="${paciente.nombre} ${paciente.primerApellido} ${paciente.segundoApellido}"/> </td>
                                        <td id="tratamiento-${paciente.idPaciente}" value="${paciente.tratamiento}" > <c:out value="${paciente.tratamiento}"/> </td>
                                        <td id="etapaClinica-${paciente.idPaciente}" value="${paciente.etapaClinica}" > <c:out value="${paciente.etapaClinica}"/> </td>                                
                                        <td id="telefono-${paciente.idPaciente}" value="${paciente.telefono}" > <c:out value="${paciente.telefono}"/> </td>       
                                        <td id="estado-${paciente.idPaciente}" value="${paciente.estado}" > <c:out value="${paciente.estado}"/> </td>
                                        <td id="medico-${paciente.idPaciente}" value="${paciente.medNombre}" > <c:out value="${paciente.medNombre} ${paciente.medPrimerApellido} ${paciente.medSegundoApellido}"/> </td>
                                        <td>

                                            <button class="btn btn-primary btn-editarPaciente m-1" data-toggle="modal" 
                                                    data-target="#modalEditarPaciente" data-id="${paciente.idPaciente}"><i class="fas fa-edit"></i></button>
                                            <button style="color:white;" class="btn btn-warning descargarFormulario m-1" data-id="${paciente.idPaciente}"><i class="fas fa-cloud-download-alt"></i></button>
                                            <button class="btn btn-danger btn-eliminarPaciente m-1" data-id="${paciente.idPaciente}"><i class="fas fa-trash-alt"></i></button>

                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>

                    <!-- ********** MODAL EDITAR PACIENTE ********** -->
                    <div class="modal fade" id="modalEditarPaciente" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
                        <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLongTitle">Editar paciente</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">

                                    <input type="hidden" id="idPacienteAEditar">

                                    <div class="form-group row">
                                        <div class="col-6">
                                            <div class="input-group">
                                                <div class="input-group-prepend">
                                                    <div class="input-group-text">
                                                        <i class="fas fa-user"></i>
                                                    </div>
                                                </div>
                                                <input type="text" class="form-control" id="editarNombreAdministradorAPaciente" placeholder="Nombre">
                                            </div>
                                            <span class="text-danger" id="error-editar-NombrePaciente">Formato incorrecto, solo caracteres alfabéticos con un mínimo de 2 y un máximo de 255 caracteres.</span>

                                        </div>

                                        <div class="col-6">
                                            <div class="input-group">
                                                <div class="input-group-prepend">
                                                    <div class="input-group-text">
                                                        <i class="fas fa-id-card"></i>
                                                    </div>
                                                </div>
                                                <input type="text" class="form-control" id="editarCurpAdministradorAPaciente" placeholder="CURP">
                                            </div>
                                            <span class="text-danger" id="error-editar-CurpPaciente">Formato incorrecto, las letras deben estar en mayúsculas y asegúrate de introducir un CURP válido y sin espacios. Puedes consultarlo 
                                                <a class="text-primary " target="_blank" href="https://www.gob.mx/curp/">aquí.</a>
                                            </span>
                                            <span class="text-warning" id="error-editar-CurpRepetidoPaciente">El curp ya existe.</span>
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
                                                       id="editarCumpleAdministradorAPaciente">
                                            </div>
                                            <span class="text-danger" id="error-editar-FechaPaciente">Fecha incorrecta</span>
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
                                                <input type="text" class="form-control" id="editarPrimer-apellidoAdministradorAPaciente" placeholder="Primer Apellido">
                                            </div>
                                            <span class="text-danger" id="error-editar-ApellidoPaternoPaciente">Formato incorrecto, solo caracteres alfabéticos con un mínimo de 2 y un máximo de 127 caracteres.</span>

                                        </div>

                                        <div class="col-6">
                                            <div class="input-group">
                                                <div class="input-group-prepend">
                                                    <div class="input-group-text">
                                                        <i class="fas fa-user"></i>
                                                    </div>
                                                </div>
                                                <input type="text" class="form-control" id="editarSegundo-apellidoAdministradorAPaciente" placeholder="Segundo Apellido">
                                            </div>
                                            <span class="text-danger" id="error-editar-ApellidoMaternoPaciente">Formato incorrecto, solo caracteres alfabéticos con un mínimo de 2 y un máximo de 127 caracteres.</span>

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
                                                <input type="text" class="form-control" id="editarUsuarioAdministradorAPaciente" placeholder="Usuario">
                                            </div>
                                            <span class="text-danger" id="error-editar-NombreUsuarioPaciente">Formato incorrecto, solo caracteres alfanuméricos con un mínimo de 4 y un máximo de 16 caracteres.</span>
                                            <span class="text-warning" id="error-editar-UsuarioRepetidoPaciente">El usuario ya existe.</span>
                                        </div>
                                        <div class="col-6">
                                            <div class="input-group">
                                                <select class="form-control" name="estado-civilPaciente" id="editarEstado-civilPaciente">
                                                    <option disabled selected>Estado Civil</option>
                                                    <c:forEach items="${estadoCivil}" var="estadoC">  
                                                        <option value='<c:out value="${estadoC.idEstadoCivil}"/>'><c:out value='${estadoC.nombre}'/> </option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <span class="text-danger" id="error-editar-ECivilPaciente">Selecciona una opcion</span>
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
                                                <input type="text" class="form-control" id="editarColAdministradorAPaciente" placeholder="Colonia">
                                            </div>
                                            <span class="text-danger" id="error-editar-ColoniaPaciente">Formato incorrecto, introducir caracteres alfanuméricos.</span>

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
                                                <input type="text" class="form-control" id="editarCalleAdministradorAPaciente" placeholder="Calle">
                                            </div>

                                            <span class="text-danger" id="error-editar-CallePaciente">Formato incorrecto, introducir caracteres alfanuméricos.</span>

                                        </div>
                                        <div class="col-3">
                                            <div class="input-group">
                                                <div class="input-group-prepend">
                                                    <div class="input-group-text">
                                                        <i class="fas fa-map-marker-alt"></i>
                                                    </div>
                                                </div>
                                                <input type="text" class="form-control" id="editarNumIntAdministradorAPaciente" placeholder="No. int">
                                            </div>
                                            <span class="text-danger" id="error-editar-NoInteriorPaciente">Formato incorrecto, solo dígitos y/o letras.</span>

                                        </div>
                                        <div class="col-3">
                                            <div class="input-group">
                                                <div class="input-group-prepend">
                                                    <div class="input-group-text">
                                                        <i class="fas fa-map-marker-alt"></i>
                                                    </div>
                                                </div>
                                                <input type="text" class="form-control" id="editarNumExtAdministradorAPaciente" placeholder="No. ext">
                                            </div>
                                            <span class="text-danger" id="error-editar-NoExteriorPaciente">Formato incorrecto, solo dígitos y/o letras.</span>

                                        </div>
                                    </div>

                                    <div class="form-group row">
                                        <div class="col-6">
                                            <div class="input-group">
                                                <select class="form-control" id="editarEstadoAdministradorAPaciente">
                                                    <option disabled selected>Seleccione estado</option>
                                                    <c:forEach items="${estado}" var="estado">  
                                                        <option value='<c:out value="${estado.idEstado}"/>'><c:out value='${estado.nombre}'/> </option>
                                                    </c:forEach>
                                                </select>
                                            </div>

                                            <span class="text-danger" id="error-editar-EstadoPaciente">Campo vacío</span>

                                        </div>
                                        <div class="col-6">
                                            <div class="input-group editarMunicipios">
                                                <select class="form-control" name="" id="editarMunicipioAdministradorAPaciente">
                                                    <option disabled selected>Municipio</option>
                                                </select>
                                            </div>

                                            <span class="text-danger" id="error-editar-MunicipioPaciente">Campo vacío</span>

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
                                                <input type="text" class="form-control" id="editarTelAdministradorAPaciente" placeholder="Teléfono">
                                            </div>
                                            <span class="text-danger" id="error-editar-TelefonoPaciente">Formato incorrecto, deben ser 10 dígitos.</span>
                                        </div>

                                        <div class="col-6">
                                            <div class="input-group">
                                                <div class="input-group-prepend">
                                                    <div class="input-group-text">
                                                        <i class="fas fa-at"></i>
                                                    </div>
                                                </div>
                                                <input type="text" class="form-control" id="editarCorreoAdministradorAPaciente" placeholder="Correo">
                                            </div>
                                            <span class="text-danger" id="error-editar-CorreoPaciente">El formato no es correcto, introduce un mínimo de 2 y un máximo de 254 caracteres. Ejemplo: ejemplo@ejemplo.com</span>
                                            <span class="text-warning" id="errorEditarPacienteCorreoRepetido">El correo ya existe.</span>
                                        </div>

                                    </div>

                                    <div class="row mb-3" id="error-editarDatosRepetidosPaciente">
                                        <div class="col-12 text-center">
                                            <span class="text-warning">Estás tratando de registrar datos existentes. <br> Revisa de nuevo.</span>
                                        </div>
                                    </div>



                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-danger clearEditPacientesModal" data-dismiss="modal" style="border-radius:20px">Cancelar</button>
                                    <button type="button" class="btn btn-primary" id="btn-guardarCambios" style="border-radius:20px">Guardar Cambios</button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- ********** MODAL AGREGAR PACIENTE ********** -->
                    <div class="modal fade" id="modalAgregarPaciente" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
                        <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title">Agregar Paciente</h5>
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
                                                <input type="text" class="form-control" id="nombrePaciente" name="nombrePaciente" placeholder="Nombre">
                                                <span class="text-danger" id="errorNombrePaciente">Formato incorrecto, solo caracteres alfabéticos con un mínimo de 2 y un máximo de 255 caracteres.</span>
                                            </div>
                                        </div>

                                        <div class="col-6">
                                            <div class="input-group">
                                                <div class="input-group-prepend">
                                                    <div class="input-group-text">
                                                        <i class="fas fa-id-card"></i>
                                                    </div>
                                                </div>
                                                <input type="text" class="form-control" id="curpPaciente" name="curpPaciente" placeholder="CURP">


                                            </div>

                                            <span class="text-danger" id="errorCurpPaciente">Formato incorrecto, las letras deben estar en mayúsculas y asegúrate de introducir un CURP válido y sin espacios. Puedes consultarlo 
                                                <a class="text-primary " target="_blank" href="https://www.gob.mx/curp/">aquí.</a>
                                            </span>

                                            <span class="text-warning" id="errorCurpRepetidoPaciente">El curp ya existe.</span>
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
                                                       id="cumplePaciente" name="cumplePaciente">

                                            </div>
                                            <span class="text-danger" id="errorFechaPaciente">Fecha incorrecta</span>
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
                                                <input type="text" class="form-control" id="primer-apellidoPaciente" name="primer-apellidoPaciente" placeholder="Primer Apellido">
                                            </div>
                                            <span class="text-danger" id="errorApellidoPaternoPaciente">Formato incorrecto, solo caracteres alfabéticos con un mínimo de 2 y un máximo de 127 caracteres.</span>

                                        </div>

                                        <div class="col-6">
                                            <div class="input-group">
                                                <div class="input-group-prepend">
                                                    <div class="input-group-text">
                                                        <i class="fas fa-user"></i>
                                                    </div>
                                                </div>
                                                <input type="text" class="form-control" id="segundo-apellidoPaciente" name="segundo-apellidoPaciente" placeholder="Segundo Apellido">
                                                <span class="text-danger" id="errorApellidoMaternoPaciente">Formato incorrecto, solo caracteres alfabéticos con un mínimo de 2 y un máximo de 127 caracteres.</span>
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
                                                <input type="text" class="form-control" id="usuarioPaciente" usuario="usuarioPaciente" placeholder="Usuario">

                                            </div>
                                            <span class="text-danger" id="errorNombreUsuarioPaciente">Formato incorrecto, solo caracteres alfanuméricos con un mínimo de 4 y un máximo de 16 caracteres.</span>
                                            <span class="text-warning" id="errorUsuarioRepetidoPaciente">El usuario ya existe.</span>
                                        </div>
                                        <div class="col-6">
                                            <div class="input-group">
                                                <select class="form-control" name="estado-civilPaciente" id="estado-civilPaciente">                                            
                                                    <option disabled selected>Estado Civil</option>
                                                    <c:forEach items="${estadoCivil}" var="estadoC">  
                                                        <option value='<c:out value="${estadoC.idEstadoCivil}"/>'><c:out value='${estadoC.nombre}'/> </option>
                                                    </c:forEach>
                                                </select>

                                            </div>
                                            <span class="text-danger" id="errorECivilPaciente">Selecciona una opcion</span>
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
                                                <input type="text" class="form-control" id="colPaciente" placeholder="Colonia">
                                            </div>
                                            <span class="text-danger" id="errorColoniaPaciente">Formato incorrecto, introducir caracteres alfanuméricos.</span>

                                        </div>
                                        <div class="col-6">
                                            <div class="input-group">
                                                <div class="input-group-prepend">
                                                    <div class="input-group-text">
                                                        <i class="fas fa-map-marker-alt"></i>
                                                    </div>
                                                </div>
                                                <input type="text" class="form-control" id="codigo-postalPaciente" placeholder="Codigo Postal">

                                            </div>
                                            <span class="text-danger" id="errorCodigoPostalPaciente">Formato incorrecto, deben ser 5 dígitos.</span><br>
                                            <span class="text-danger" id="error-CPexistePaciente" style="font-size:13px;">El codigo postal no existe.</span>
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
                                                <input type="text" class="form-control" id="callePaciente" calle="callePaciente" placeholder="Calle">
                                            </div>
                                            <span class="text-danger" id="errorCallePaciente">Formato incorrecto, introducir caracteres alfanuméricos.</span>

                                        </div>
                                        <div class="col-3">
                                            <div class="input-group">
                                                <div class="input-group-prepend">
                                                    <div class="input-group-text">
                                                        <i class="fas fa-map-marker-alt"></i>
                                                    </div>
                                                </div>
                                                <input type="text" class="form-control" id="numIntPaciente" placeholder="No. int">
                                            </div>
                                            <span class="text-danger" id="errorNoInteriorPaciente">Formato incorrecto, solo dígitos y/o letras.</span>

                                        </div>
                                        <div class="col-3">
                                            <div class="input-group">
                                                <div class="input-group-prepend">
                                                    <div class="input-group-text">
                                                        <i class="fas fa-map-marker-alt"></i>
                                                    </div>
                                                </div>
                                                <input type="text" class="form-control" id="numExtPaciente" placeholder="No. ext">

                                            </div>
                                            <span class="text-danger" id="errorNoExteriorPaciente">Formato incorrecto, solo dígitos.</span>

                                        </div>
                                    </div>

                                    <div class="form-group row">
                                        <div class="col-6">
                                            <div class="input-group">
                                                <select class="form-control" id="estadoPaciente">
                                                    <option disabled selected>Seleccione estado</option>
                                                    <c:forEach items="${estado}" var="estado">  
                                                        <option value='<c:out value="${estado.idEstado}"/>'><c:out value='${estado.nombre}'/> </option>
                                                    </c:forEach>
                                                </select>

                                            </div>
                                            <span class="text-danger" id="errorEstadoPaciente">Campo vacío</span>
                                        </div>
                                        <div class="col-6">
                                            <div class="input-group municipios">
                                                <select class="form-control" id="municipioPaciente">
                                                    <option disabled selected>Seleccione Municipio</option>
                                                </select>

                                            </div>
                                            <span class="text-danger" id="errorMunicipioPaciente">Campo vacío</span>
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
                                                <input type="text" class="form-control" id="telPaciente" placeholder="Teléfono">

                                            </div>
                                            <span class="text-danger" id="errorTelefonoPaciente">Formato incorrecto, deben ser 10 dígitos.</span>
                                        </div>

                                        <div class="col-6">
                                            <div class="input-group">
                                                <div class="input-group-prepend">
                                                    <div class="input-group-text">
                                                        <i class="fas fa-at"></i>
                                                    </div>
                                                </div>
                                                <input type="text" class="form-control" id="correoPaciente" placeholder="Correo">
                                            </div>
                                            <span class="text-danger" id="errorCorreoPaciente">El formato no es correcto, introduce un mínimo de 2 y un máximo de 254 caracteres. Ejemplo: ejemplo@ejemplo.com</span>
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
                                                <input type="password" class="form-control" id="contraPaciente" placeholder="Contraseña">
                                                <span class="text-danger" id="errorPass1Paciente">Formato incorrecto, la contraseña debe tener al menos 1 número, 1 letra minúscula, 1 mayúscula y una extensión de 8 a 14 caracteres.</span>
                                            </div>
                                        </div>
                                        <div class="col-6">
                                            <div class="input-group">
                                                <div class="input-group-prepend">
                                                    <div class="input-group-text">
                                                        <i class="fas fa-lock"></i>
                                                    </div>
                                                </div>
                                                <input type="password" class="form-control" id="confContraPaciente" placeholder="Confirmar contraseña">
                                                <span class="text-danger" id="errorPass2Paciente">Formato incorrecto, la contraseña debe tener al menos 1 número, 1 letra minúscula, 1 mayúscula y una extensión de 8 a 14 caracteres.</span>
                                            </div>
                                            <span class="text-warning" id="noEqualPasswordsErrorPaciente">Las contraseñas no son iguales.</span>
                                        </div>
                                    </div>

                                    <div class="form-group row justify-content-center">
                                        <div class="col-12 text-center">
                                            <a href="documentos/Terminos-y-Condiciones-de-Venta.pdf" download>
                                                <button type="button" class="btn btn-morado-solid mt-2">Descargar términos y condiciones</button>
                                            </a>
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
                                            <span class="text-danger" id="error-terminos">Para continuar debes de aceptar los términos y condiciones.</span>
                                        </div>
                                    </div>

                                </div>
                                <div class="modal-footer">
                                    <button type="button" style="border-radius: 20px;" class="btn btn-danger clearAddPacientesModal" data-dismiss="modal">Cancelar</button>
                                    <button id="btn-agregarPaciente" type="button" style="border-radius: 20px;" class="btn btn-primary">Agregar
                                        Paciente
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>


                </div>
            </div>

    </body>

</html>