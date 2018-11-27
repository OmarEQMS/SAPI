<%-- 
    Document   : gestionarAdministradores
    Created on : 15-nov-2018, 2:38:41
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

                <div class="row mb-3 justify-content-end">
                    <div class="col-3 text-center">
                        <span class="iconoHome mr-2"><i class="fas fa-home"></i></span><span><a id="IrAInicio" class="colorMoradoLight">Inicio</a></span></span>
                    </div>
                </div>

                <!-- Jumbotron Titulo -->

                <div class="jumbotron jumbotron-fluid p-2">
                    <div class="container">
                        <h1 class="display-4 tituloMisCitas text-center m-0">Gestión de Administradores</h1>
                    </div>
                </div>

                <!-- Gestion -->

                <div class="card mt-3">
                    <div class="card-body">

                        <!-- Boton agregar -->

                        <div class="row mb-3">
                            <div class="col-12">
                                <button class="btn btn-morado float-right" style="border-radius:20px" data-toggle="modal"
                                        data-target="#modalAgregarAdministrador"><i class="fas fa-plus-circle mr-2"></i>Agregar Administrador</button>
                            </div>
                        </div>


                        <!-- Table -->

                        <table class="table table-striped mt-3" id="tablaAdministradores">
                            <thead>
                                <tr>
                                    <th scope="col">Nombre</th>                                
                                    <th scope="col">Correo</th>
                                    <th scope="col">Teléfono</th>
                                    <th scope="col">No. Empledo</th>
                                    <th scope="col">Especialidad</th>
                                    <th scope="col">Cédula Profesional</th>
                                    <th scope="col">Acciones</th>
                                </tr>
                            </thead>
                            <tbody>



                                <c:forEach items="${ListaAdministradoresAdmistrador}" var="administrador">
                                    <tr>
                                        <td id="nombre-${administrador.idEmpleado}" value="${administrador.nombre}" > <c:out value="${administrador.nombre} ${administrador.primerApellido} ${administrador.segundoApellido}"/> </td>
                                        <td id="correo-${administrador.idEmpleado}" value="${administrador.correo}" > <c:out value="${administrador.correo}"/> </td>
                                        <td id="telefono-${administrador.idEmpleado}" value="${administrador.telefono}" > <c:out value="${administrador.telefono}"/> </td>                                
                                        <td id="noEmpleado-${administrador.idEmpleado}" value="${administrador.noEmpleado}" > <c:out value="${administrador.noEmpleado}"/> </td>                                                        
                                        <td id="nombreEspecialidad-${administrador.idEmpleado}" value="${administrador.nombreEspecialidad}" > <c:out value="${administrador.nombreEspecialidad}"/> </td>                                
                                        <td id="cedulaProfesional-${administrador.idEmpleado}" value="${administrador.cedulaProfesional}" > <c:out value="${administrador.cedulaProfesional}"/> </td>

                                        <td>
                                            <button class="btn btn-primary btn-editarAdministrador" data-toggle="modal" data-id="${administrador.idEmpleado}" data-target="#modalEditarAdministrador"><i
                                                    class="fas fa-edit"></i></button>
                                            <button class="btn btn-danger btn-eliminarAdministrador" id="btn-eliminarAdministrador" data-id="${administrador.idEmpleado}"><i 
                                                    class="fas fa-trash-alt"></i></button>
                                        </td>
                                    </tr>
                                </c:forEach>                            

                            </tbody>
                        </table>
                    </div>
                </div>

                <!-- ********** MODAL AGREGAR ADMINISTRADOR ********** -->
                <div class="modal fade" id="modalAgregarAdministrador" tabindex="-1" role="dialog" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">Agregar Administrador</h5>
                                <button type="button" class="close clearAddMedicosModal" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">

                                <!-- FORMULARIO AGREGAR ADMINISTRADOR -->
                                <div class="form-group row">
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-user"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-nombreAdministrador" placeholder="Nombre">
                                            <span class="text-danger" id="errorNombreAdministrador">Formato incorrecto, solo caracteres alfabéticos con un mínimo de 2 y un máximo de 255 caracteres.</span>
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-phone"></i></div>
                                            </div> 
                                            <input type="text" class="form-control" id="agregar-telefonoAdministrador" placeholder="Teléfono">
                                        </div>
                                        <span class="text-danger" id="errorTelefonoAdministrador">Formato incorrecto, deben ser 10 dígitos.</span>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-user"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-primerApellidoAdministrador"
                                                   placeholder="Primer Apellido">
                                            <span class="text-danger" id="errorApellidoPaternoAdministrador">Formato incorrecto, solo caracteres alfabéticos con un mínimo de 2 y un máximo de 127 caracteres.</span>
                                        </div>
                                    </div>

                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-user"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-segundoApellidoAdministrador"
                                                   placeholder="Segundo Apellido">
                                            <span class="text-danger" id="errorApellidoMaternoAdministrador">Formato incorrecto, solo caracteres alfabéticos con un mínimo de 2 y un máximo de 127 caracteres.</span>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-at"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-correoAdministrador" placeholder="Correo">
                                        </div>
                                        <span class="text-danger" id="errorCorreoAdministrador">El formato no es correcto, introduce un mínimo de 2 y un máximo de 254 caracteres. Ejemplo: example@example.com</span>
                                        <span class="text-warning" id="errorCorreoRepetidoAdministrador">El correo ya existe.</span>
                                    </div>

                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fab fa-slack-hash"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-noEmpleadoAdministrador" placeholder="No. empleado">
                                        </div>
                                        <span class="text-danger" id="errorNumEmpleadoAdministrador">Formato incorrecto, deben ser 6 dígitos.</span>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-user-graduate"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-especialidadAdministrador"
                                                   placeholder="Especialidad" list="listEspecialidades">
                                        </div>
                                        <span class="text-danger" id="errorAgregarEspecialidadAdministrador">Selecciona una especialidad válida.</span>
                                    </div>
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-user-graduate"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-posiciondAdministrador" list="listPosiciones"
                                                   placeholder="Posicion">
                                            <datalist id="listPosiciones">                                            
                                            </datalist>
                                        </div>
                                        <span class="text-danger" id="errorAgregarPosicionAdministrador">Selecciona una posición válida.</span>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <div class="col-12">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="far fa-id-card"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-cedulaAdministrador" placeholder="Cédula Profesional">
                                        </div>
                                        <span class="text-danger" id="errorCedulaAdministrador">Formato incorrecto, deben ser 7 dígitos.</span>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-lock"></i></div>
                                            </div>
                                            <input type="password" class="form-control" id="agregar-passwordAdministrador" placeholder="Contraseña">
                                            <span class="text-danger" id="errorPass1Administrador">Formato incorrecto, la contraseña debe tener al menos 1 número, 1 letra minúscula, 1 mayúscula y una extensión de 8 a 14 caracteres.</span>
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-lock"></i></div>
                                            </div>
                                            <input type="password" class="form-control" id="agregar-password2Administradores"
                                                   placeholder="Confirmar contraseña">
                                        </div>
                                        <span class="text-danger" id="errorPass2Administrador">Formato incorrecto, la contraseña debe tener al menos 1 número, 1 letra minúscula, 1 mayúscula y una extensión de 8 a 14 caracteres.</span>

                                        <span class="text-warning" id="noEqualPasswordsErrorAdministrador">Las contraseñas no son iguales.</span>
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
                                        <div class="form-check">
                                            <input class="form-check-input" type="checkbox" id="terminosAdministrador">
                                            <label class="form-check-label" for="autoSizingCheck2">
                                                El médico está informado y aceptó los términos y condiciones
                                            </label>
                                        </div>
                                        <span class="text-danger" id="errorTerminosAdministrador">Se deben aceptar términos y condiciones.</span>
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
                                <button id="btn-agregarAdministrador" type="button" style="border-radius:20px" class="btn btn-primary">Agregar administrador</button>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- ********** MODAL EDITAR ADMINISTRADOR ********** -->
                <div class="modal fade" id="modalEditarAdministrador" tabindex="-1" role="dialog" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">Editar Administrador</h5>
                                <button type="button" class="close clearCancelEditMedicosModal" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">



                                <input type="hidden" id="idAdministrador" value="">

                                <!-- FORMULARIO EDITAR MEDICO -->
                                <div class="form-group row">
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text">
                                                    <i class="fas fa-user"></i>
                                                </div>
                                            </div>
                                            <input type="text" id="editar-nombreAdministrador" class="form-control" placeholder="Nombre">
                                        </div>
                                        <span class="text-danger" id="errorEditarNombreAdministrador">Formato incorrecto, solo caracteres alfabéticos con un mínimo de 2 y un máximo de 255 caracteres.</span>
                                    </div>
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text">
                                                    <i class="fas fa-user"></i>
                                                </div>
                                            </div>
                                            <input type="text" id="editar-primerApellidoAdministrador" class="form-control" placeholder="Primer Apellido"> 
                                        </div>
                                        <span class="text-danger" id="errorEditarApellidoPaternoAdministrador">Formato incorrecto, solo caracteres alfabéticos con un mínimo de 2 y un máximo de 127 caracteres.</span>
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
                                            <input type="text" id="editar-segundoApellidoAdministrador" class="form-control" placeholder="Segundo Apellido"> 
                                        </div>
                                        <span class="text-danger" id="errorEditarApellidoMaternoAdministrador">Formato incorrecto, solo caracteres alfabéticos con un mínimo de 2 y un máximo de 127 caracteres.</span>
                                    </div>
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text">
                                                    <i class="fas fa-at"></i>
                                                </div>
                                            </div>
                                            <input type="text" id="editar-correoAdministrador" class="form-control" placeholder="Correo">
                                        </div>
                                        <span class="text-danger" id="errorEditarCorreoAdministrador">El formato no es correcto, introduce un mínimo de 2 y un máximo de 254 caracteres. Ejemplo: example@example.com</span>
                                        <span class="text-warning" id="errorEditarCorreoRepetidoAdministrador">El correo ya existe.</span>
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
                                            <input type="text" id="editar-telefonoAdministrador" class="form-control" placeholder="Teléfono">
                                        </div>
                                        <span class="text-danger" id="errorEditarTelefonoAdministrador">Formato incorrecto, deben ser 10 dígitos.</span>
                                    </div>
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text">
                                                    <i class="fab fa-slack-hash"></i>
                                                </div>
                                            </div>
                                            <input type="text" id="editar-noEmpleadoAdministrador" class="form-control" placeholder="No. Empleado">
                                        </div>
                                        <span class="text-danger" id="errorEditarNumEmpleadoAdministrador">Formato incorrecto, deben ser 6 dígitos.</span>
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
                                            <input type="text" id="editar-especialidadAdministrador" class="form-control especialidad" placeholder="Especialidad" list="listEspecialidades">  
                                            <datalist id="listEspecialidades">                                            
                                            </datalist>
                                        </div>
                                        <span class="text-danger" id="errorEditarEspecialidadAdministrador">Selecciona una especialidad válida.</span>
                                    </div>
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-user-graduate"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="editar-posiciondAdministrador" list="listPosiciones"
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
                                            <input type="text" id="editar-cedulaProfesionalAdministrador" class="form-control" placeholder="Cédula Profesional">
                                        </div>
                                        <span class="text-danger" id="errorEditarCedulaAdministrador">Formato incorrecto, deben ser 7 dígitos.</span>
                                    </div>
                                </div>

                                <div class="row mb-3" id="error-editarDatosRepetidosAdministrador">
                                    <div class="col-12 text-center">
                                        <span class="text-warning">Estás tratando de registrar datos existentes. <br> Revisa de nuevo.</span>
                                    </div>
                                </div>

                            </div>
                            <div class="modal-footer">
                                <button type="button" style="border-radius:20px" class="btn btn-danger clearCancelEditMedicosModal" data-dismiss="modal">Cancelar</button>
                                <button id="btn-guardarAdministrador" type="button" style="border-radius:20px" class="btn btn-primary">Guardar
                                    Cambios
                                </button>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>



    </body>

</html>