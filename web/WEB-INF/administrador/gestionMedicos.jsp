<%-- 
    Document   : gestionMedicos
    Created on : 13-nov-2018, 21:39:52
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
        <script rel="stylesheet" href="lib/jquery/jquery-ui.min.js"></script>
        <link rel="stylesheet" href="lib/jquery/jquery-ui.css">
        <link rel="stylesheet" href="lib/jquery/jquery-ui.min.css">
        <script src="js/appAdministrador.js"></script>
        <script src="js/ajaxAdministrador.js"></script>
        <script src="js/autocomplete.js"></script>

    </head>

    <body>

        <div class="cargandoAgregarMedico" id="loading-screen" style="display: none">
            <img src="img/loading.svg">
            <p class="clear">Agregando al médico, por favor espere...</p>
        </div>
        
        <div class="cargandoEditarMedico" id="loading-screen" style="display: none">
            <img src="img/loading.svg">
            <p class="clear">Actualizando información del médico, por favor espere...</p>
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

                    <li id="irAInicioAdministrador"><a><i class="fas fa-home"></i>Inicio</a></li>

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
                        - <span class="colorGlobal">Gestion de Médicos</span>
                    </div>
                </div>

                <!-- Jumbotron Titulo -->

                <div class="jumbotron jumbotron-fluid p-2">
                    <div class="container">
                        <h1 class="display-4 tituloMisCitas text-center m-0">Gestión de Médicos</h1>
                    </div>
                </div>

                <!-- Gestion -->

                <div class="card mt-3">
                    <div class="card-body">

                        <!-- Boton agregar -->

                        <div class="row mb-3">
                            <div class="col-12">
                                <button class="btn btn-morado float-right" style="border-radius:20px" data-toggle="modal"
                                        data-target="#modalAgregarMedico"><i class="fas fa-plus-circle mr-2"></i>Agregar Médico</button>
                            </div>
                        </div>


                        <!-- Table -->

                        <table class="table table-striped mt-3" id="tablaMedicos">
                            <thead>
                                <tr>
                                    <th scope="col">Nombre</th>                                
                                    <th scope="col">Correo</th>
                                    <th scope="col">Teléfono</th>
                                    <th scope="col">No. Empledo</th>
                                    <th scope="col">Especialidad</th>
                                    <th scope="col">Cédula Profesional</th>
                                    <th scope="col"></th>
                                </tr>
                            </thead>
                            <tbody>

                                <c:forEach items="${ListaMedicosAdmistrador}" var="medico">
                                    <tr>
                                        <td id="nombre-${medico.idEmpleado}" value="${medico.nombre}" > <c:out value="${medico.nombre} ${medico.primerApellido} ${medico.segundoApellido}"/> </td>
                                        <td id="correo-${medico.idEmpleado}" value="${medico.correo}" > <c:out value="${medico.correo}"/> </td>
                                        <td id="telefono-${medico.idEmpleado}" value="${medico.telefono}" > <c:out value="${medico.telefono}"/> </td>                                
                                        <td id="noEmpleado-${medico.idEmpleado}" value="${medico.noEmpleado}" > <c:out value="${medico.noEmpleado}"/> </td>                                                        
                                        <td id="nombreEspecialidad-${medico.idEmpleado}" value="${medico.nombreEspecialidad}" > <c:out value="${medico.nombreEspecialidad}"/> </td>                                
                                        <td id="cedulaProfesional-${medico.idEmpleado}" value="${medico.cedulaProfesional}" > <c:out value="${medico.cedulaProfesional}"/> </td>

                                        <td>
                                            <button class="btn btn-primary btn-editarMedico m-1" data-toggle="modal" data-id="${medico.idEmpleado}" data-target="#modalEditarMedico"><i
                                                    class="fas fa-edit"></i></button>
                                            <button class="btn btn-danger m-1" id="btn-eliminarMedico" data-id="${medico.idEmpleado}"><i 
                                                    class="fas fa-trash-alt"></i></button>
                                        </td>
                                    </tr>
                                </c:forEach>     

                                <!-- ***** Nota ***** -->
                            <div class="row mb-3 justify-content-center">
                                <div class="col-5 text-center bg-danger" style="border-radius:20px;">
                                    <span style="font-size: 14px;" class="text-white">Nota: Antes de eliminar a un médico adscrito asegúrate de haber reasignado sus pacientes previamente.</span>
                                </div>
                            </div>

                            </tbody>
                        </table>
                    </div>
                </div>


                <!-- ********** MODAL EDITAR MEDICO ********** -->
                <div class="modal fade" id="modalEditarMedico" tabindex="-1" role="dialog" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">Editar Médico</h5>
                                <button type="button" class="close clearCancelEditMedicosModal" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">

                                <input type="hidden" id="idMedico" value="">

                                <!-- FORMULARIO EDITAR MEDICO -->
                                <div class="form-group row">
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text">
                                                    <i class="fas fa-user"></i>
                                                </div>
                                            </div>
                                            <input type="text" id="editar-nombreMedico" class="form-control" placeholder="Nombre">
                                        </div>
                                        <span class="text-danger" id="errorEditarNombreMedico">Formato incorrecto, solo caracteres alfabéticos con un mínimo de 2 y un máximo de 255 caracteres.</span>
                                    </div>
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text">
                                                    <i class="fas fa-user"></i>
                                                </div>
                                            </div>
                                            <input type="text" id="editar-primerApellidoMedico" class="form-control" placeholder="Primer Apellido"> 
                                        </div>
                                        <span class="text-danger" id="errorEditarApellidoPaternoMedico">Formato incorrecto, solo caracteres alfabéticos con un mínimo de 2 y un máximo de 127 caracteres.</span>
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
                                            <input type="text" id="editar-segundoApellidoMedico" class="form-control" placeholder="Segundo Apellido (Opcional)"> 
                                        </div>
                                        <span class="text-danger" id="errorEditarApellidoMaternoMedico">Formato incorrecto, solo caracteres alfabéticos con un mínimo de 2 y un máximo de 127 caracteres.</span>
                                    </div>
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text">
                                                    <i class="fas fa-at"></i>
                                                </div>
                                            </div>
                                            <input type="text" id="editar-correoMedico" class="form-control" placeholder="Correo">
                                        </div>
                                        <span class="text-danger" id="errorEditarCorreoMedico">El formato no es correcto, introduce un mínimo de 2 y un máximo de 254 caracteres. Ejemplo: ejemplo@ejemplo.com</span>
                                        <span class="text-warning" id="errorEditarCorreoRepetido">El correo ya existe.</span>
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
                                            <input type="text" id="editar-telefonoMedico" class="form-control" placeholder="Teléfono">
                                        </div>
                                        <span class="text-danger" id="errorEditarTelefonoMedico">Formato incorrecto, deben ser 10 dígitos.</span>
                                    </div>
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text">
                                                    <i class="fab fa-slack-hash"></i>
                                                </div>
                                            </div>
                                            <input type="text" id="editar-noEmpleadoMedico" class="form-control" placeholder="No. Empleado">
                                        </div>
                                        <span class="text-danger" id="errorEditarNumEmpleado">Formato incorrecto, deben ser 6 dígitos.</span>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend ui-widget">
                                                <div class="input-group-text">
                                                    <i class="fas fa-user-graduate"></i>
                                                </div>
                                            </div>
                                            <input type="text" id="editar-especialidadMedico" class="form-control especialidad" placeholder="Especialidad" list="listEspecialidades">  
                                            <datalist id="listEspecialidades">                                            
                                            </datalist>
                                        </div>
                                        <span class="text-danger" id="errorEditarEspecialidad">Selecciona una especialidad válida.</span>
                                    </div>
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-user-graduate"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="editar-posiciondMedico" list="listPosiciones"
                                                   placeholder="Posicion">
                                            <datalist id="listPosiciones">                                            
                                            </datalist>
                                        </div>
                                        <!-- <span class="text-danger" id="errorEditarPosicion">Selecciona una posición válida.</span> -->
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <div class="col-12">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text">
                                                    <i class="fas fa-user-graduate"></i>
                                                </div>
                                            </div>
                                            <input type="text" id="editar-cedulaProfesionalMedico" class="form-control" placeholder="Cédula Profesional (Opcional)">
                                        </div>
                                        <span class="text-danger" id="errorEditarCedulaMedicos">Formato incorrecto, deben ser 7 dígitos.</span>
                                    </div>
                                </div>

                                <div class="row mb-3" id="error-editarDatosRepetidos">
                                    <div class="col-12 text-center">
                                        <span class="text-warning">Estás tratando de registrar datos existentes. <br> Revisa de nuevo.</span>
                                    </div>
                                </div>

                            </div>
                            <div class="modal-footer">
                                <button type="button" style="border-radius:20px" class="btn btn-danger clearCancelEditMedicosModal" data-dismiss="modal">Cancelar</button>
                                <button id="btn-guardarMedico" type="button" style="border-radius:20px" class="btn btn-primary">Guardar
                                    Cambios
                                </button>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- ********** MODAL AGREGAR MEDICO ********** -->
                <div class="modal fade" id="modalAgregarMedico" tabindex="-1" role="dialog" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">Agregar Médico</h5>
                                <button type="button" class="close clearAddMedicosModal" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">

                                <!-- FORMULARIO AGREGAR MEDICO -->
                                <div class="form-group row">
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-user"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-nombreMedico" placeholder="Nombre">
                                            <span class="text-danger" id="errorNombreMedico">Formato incorrecto, solo caracteres alfabéticos con un mínimo de 2 y un máximo de 255 caracteres.</span>
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-phone"></i></div>
                                            </div> 
                                            <input type="text" class="form-control" id="agregar-telefonoMedico" placeholder="Teléfono">
                                        </div>
                                        <span class="text-danger" id="errorTelefonoMedico">Formato incorrecto, deben ser 10 dígitos.</span>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-user"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-primerApellidoMedico"
                                                   placeholder="Primer Apellido">
                                            <span class="text-danger" id="errorApellidoPaternoMedico">Formato incorrecto, solo caracteres alfabéticos con un mínimo de 2 y un máximo de 127 caracteres.</span>
                                        </div>
                                    </div>

                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-user"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-segundoApellidoMedico"
                                                   placeholder="Segundo Apellido (Opcional)">
                                            <span class="text-danger" id="errorApellidoMaternoMedico">Formato incorrecto, solo caracteres alfabéticos con un mínimo de 2 y un máximo de 127 caracteres.</span>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-at"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-correoMedico" placeholder="Correo">
                                        </div>
                                        <span class="text-danger" id="errorCorreoMedico">El formato no es correcto, introduce un mínimo de 2 y un máximo de 254 caracteres. Ejemplo: ejemplo@ejemplo.com</span>
                                        <span class="text-warning" id="errorCorreoRepetido">El correo ya existe.</span>
                                    </div>

                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fab fa-slack-hash"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-noEmpleadoMedico" placeholder="No. empleado">
                                        </div>
                                        <span class="text-danger" id="errorNumEmpleado">Formato incorrecto, deben ser 6 dígitos.</span>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-user-graduate"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-especialidadMedico"
                                                   placeholder="Especialidad" list="listEspecialidades">
                                            <datalist id="listEspecialidades">                                            
                                            </datalist>
                                        </div>
                                        <span class="text-danger" id="errorAgregarEspecialidad">Selecciona una especialidad válida.</span>
                                    </div>
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-user-graduate"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-posiciondMedico" list="listPosiciones"
                                                   placeholder="Posicion">
                                            <datalist id="listPosiciones">                                            
                                            </datalist>
                                        </div>
                                        <span class="text-danger" id="errorAgregarPosicion">Selecciona una posición válida.</span>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <div class="col-12">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="far fa-id-card"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-cedulaMedico" placeholder="Cédula Profesional (Opcional)">
                                        </div>
                                        <span class="text-danger" id="errorCedulaMedicos">Formato incorrecto, deben ser 7 dígitos.</span>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-lock"></i></div>
                                            </div>
                                            <input type="password" class="form-control" id="agregar-passwordMedico" placeholder="Contraseña">
                                            <div id="medicoContrasena" class="input-group-append bg-white">
                                                <div class="input-group-text border-left-0 rounded-left bg-white"><i class="far fa-eye"></i></div>
                                            </div>
                                        </div>
                                        <span class="text-danger" id="errorPass1Medico">Formato incorrecto, la contraseña debe tener al menos 1 número, 1 letra minúscula, 1 mayúscula y una extensión de 8 a 14 caracteres.</span>
                                    </div>
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-lock"></i></div>
                                            </div>
                                            <input type="password" class="form-control" id="agregar-password2Medico"
                                                   placeholder="Confirmar contraseña">
                                            <div id="medicoContrasenaConfirmacion" class="input-group-append bg-white">
                                                <div class="input-group-text border-left-0 rounded-left bg-white"><i class="far fa-eye"></i></div>
                                            </div>
                                        </div>
                                        <span class="text-warning" id="noEqualPasswordsError">Las contraseñas no son iguales.</span>
                                    </div>
                                </div>

                                <div class="form-group row justify-content-center">
                                    <div class="col-12 text-center">
                                        <a href="documentos/Terminos-y-Condiciones-de-Venta.pdf" download>
                                            <button type="button" class="btn btn-morado-solid mt-2">Descargar los términos y condiciones</button>
                                        </a>
                                    </div>
                                </div>

                                <div class="form-group row justify-content-center">
                                    <div class="col-12 text-center">
                                        <div class="form-check form-check-inline"> 
                                            <label><input class="form-check-input" type="checkbox" id="terminosMedico" /> El médico está informado y aceptó los términos y condiciones</label>
                                        </div>
                                    </div>
                                </div>

                                <div class="row mb-3" id="error-campos">
                                    <div class="col-12 text-center">
                                        <span class="text-danger">Completa todos los campos y asegúrate de aceptar los términos para registrar la cuenta.</span>
                                    </div>
                                </div>

                                <div class="row mb-3" id="error-datosRepetidos">
                                    <div class="col-12 text-center">
                                        <span class="text-warning">Estás tratando de registrar datos existentes. <br> Revisa de nuevo.</span>
                                    </div>
                                </div>

                            </div>
                            <div class="modal-footer">
                                <button type="button" style="border-radius:20px" class="btn btn-danger clearAddMedicosModal" data-dismiss="modal">Cancelar</button>
                                <button id="btn-agregarMedico" type="button" style="border-radius:20px" class="btn btn-primary">Agregar médico</button>
                            </div>
                        </div>
                    </div>
                </div>


            </div>
        </div>

    </body>

</html>