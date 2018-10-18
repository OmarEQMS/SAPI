<%-- 
    Document   : cuenta
    Created on : 18-oct-2018, 15:41:30
    Author     : urieldiaz
--%>

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

    <link rel="stylesheet" href="css/stylePaciente.css">
    <script src="js/appPaciente.js" type="module"></script>
    <script src="js/calendars.js"></script>
    <script src="js/ajaxPaciente.js"></script>
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
                        <span class="textoSidebar m-0">Julio Badillo</span>
                        <span class="textoSidebar userSidebar m-0">@juliobadillo</span>
                    </div>
                </div>
                <div class="row justify-content-center">
                    <div class="col-2 text-center">
                        <a class="iconoSidebar" href="">
                            <i class="fas fa-cog"></i>
                        </a>
                    </div>
                    <div class="col-2">
                        <a class="iconoSidebar" href="">
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

                <li>
                    <a href="./index.html">
                        <i class="fas fa-home"></i>Mis Citas</a>
                </li>

                <li>
                    <a href="#">
                        <i class="far fa-user"></i>Mi Cuenta</a>
                </li>

                <li>
                    <a href="#">
                        <i class="fas fa-sign-out-alt"></i>Cerrar Sesión</a>
                </li>

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
                        <span style="color:#6c6f80">Bienvenido, </span>
                        <span style="font-weight:700; color:#6c6f80;">Julio Badillo
                        </span>
                        <img src="img/user.png" class="ml-2" style="width: 30px;" alt=""> </span>

                </div>
            </nav>

            <!-- **************************************************************** -->
            <!-- ***** A PARTIR DE AQUI ESCRIBEN EL CODIGO QUE QUIERAN..... ***** -->
            <!-- **************************************************************** -->

            <div class="row mb-3 justify-content-end">
                <div class="col-3 text-center">
                    <span class="iconoHome mr-2">
                        <i class="fas fa-home"></i>
                    </span>
                    <span>
                        <a href="./index.html" class="colorMoradoLight">Inicio</a>
                    </span>
                    -
                    <span class="colorGlobal">Mi Cuenta</span>
                </div>
            </div>

            <!-- Jumbotron Titulo -->

            <div class="jumbotron jumbotron-fluid p-2">
                <div class="container">
                    <h1 class="display-4 tituloMiCuenta text-center m-0">Mi cuenta</h1>
                </div>
            </div>

            <!-- Contenido del contenedor blanco -->
            <div class="card mt-3">
                <div class="card-body">

                    <form>

                        <!-- Imagen -->
                        <div class="form-group row justify-content-center">
                            <div class="col-12 text-center">
                                <label for="file-input">
                                    <img src="img/user.png" class="edit-image" alt="Click aquí" title="Click aquí" width="200px" height="200px">
                                </label>
                                <input type="file" class="editar-imagen" id="file-input" />
                            </div>
                        </div>
                        <div class="row mb-4">
                            <div class="col-12 text-center">
                                <h4 class="FotoPerfil text-secondary" style="font-size:17px;">Edita tu foto de perfil</h4>
                            </div>
                        </div>

                        <!-- 1 -->
                        <div class="form-group row justify-content-center">
                            <div class="col-4">
                                <label for="name">Nombre</label>
                                <input type="text" class="form-control" id="name" value="Diego" readonly />
                            </div>
                            <div class="col-4">
                                <label for="surname1">Primer Apellido</label>
                                <input type="text" class="form-control" id="surname1" value="Montoya" readonly />
                            </div>
                        </div>

                        <!-- 2 -->
                        <div class="form-group row justify-content-center">
                            <div class="col-4">
                                <label for="surname2">Segundo Apellido</label>
                                <input type="text" class="form-control" id="surname2" value="Martínez" readonly />
                            </div>
                            <div class="col-4">
                                <label for="username">Usuario</label>
                                <input type="text" class="form-control" id="username" value="diegommtz" readonly />
                            </div>
                        </div>

                        <!-- 3 -->
                        <div class="form-group row justify-content-center">
                            <div class="col-4">
                                <label for="myEmail">Correo</label>
                                <input type="email" class="form-control" id="myEmail" placeholder="Introduzca su correo" required />
                                <span class="text-danger" id="error-correo">El formato no es correcto, introduce un mínimo de 2 y un máximo de 254 caracteres.</span>
                            </div>
                            <div class="col-4">
                                <label for="numExpediente">Número de Expediente</label>
                                <input type="text" class="form-control" id="numExpediente" placeholder="Introduce numero de expediente" />
                                <span class="text-danger" id="error-noExpediente">El formato no es correcto, deben ser 9 caracteres.</span>
                            </div>
                        </div>

                        <!-- 4 -->
                        <div class="form-group row justify-content-center">
                            <div class="col-4">
                                <label for="telephoneNum">Teléfono</label>
                                <input type="text" class="form-control" id="telephoneNum" placeholder="Introduce teléfono"
                                 required />
                                 <span class="text-danger" id="error-tel">El formato no es correcto, deben ser 10 dígitos.</span>
                            </div>

                            <div class="col-4">

                                <label class="form-check-label" for="etapaClinica">Etapa Clínica</label>
                                <div class="input-group">
                                    <select class="form-control mt-2" id="estapaClinica">
                                        <option disabled selected>Seleccione etapa clínica</option>
                                        <option>Estadio 0</option>
                                        <option>In Situ</option>
                                        <option>Estadio I</option>
                                        <option>Estadio II A</option>
                                        <option>Estadio II B</option>
                                        <option>Estadio III A</option>
                                        <option>Estadio III B</option>
                                        <option>Estadio III C</option>
                                        <option>Estadio IV</option>
                                    </select>
                                </div>

                            </div>
                        </div>

                        <div class="form-group row justify-content-center">
                            <div class="col-4">
                                <label>Tipo de sangre</label>
                                <input type="text" class="form-control" id="tipo-sangre" placeholder="Introduce tipo de sangre" />
                                <span class="text-danger" id="error-tipoSangre">El formato no es correcto.</span>
                            </div>
                            <div class="col-4">
                                <label for="myPRZ">PRZ</label>
                                <input type="text" class="form-control" id="myPRZ" value="UA7AJA8" readonly
                                />
                            </div>
                        </div>


                        <!-- 4 -->
                        <div class="form-group row justify-content-center">
                            <div class="col-7">
                                <label for="tratamiento">Tratamientos</label>
                            </div>
                            <div class="col-1">

                            </div>

                        </div>

                        <div id="tratamientos">
                            <div class="form-group row justify-content-center contenedor-tratamientos">
                                <div class="col-7">
                                    <select id="tratamiento" class="form-control">
                                        <option disabled selected>Elegir Tratamiento</option>
                                        <option value="">Quimioterapia antes de la cirugía</option>
                                        <option value="">Quimioterapia después de la cirugía</option>
                                        <option value="">Radioterapia antes de la cirugía</option>
                                        <option value="">Radioterapia después de la cirugía</option>
                                        <option value="">Hormonoterapia antes de la cirugía</option>
                                        <option value="">Hormonoterapia después de la cirugía</option>
                                        <option value="">Mastectomía</option>
                                        <option value="">Cirugía conservadora</option>
                                        <option value="">Reconstrucción</option>
                                        <option value="">Paliativo</option>
                                        <option value="">Ya terminé tratamiento</option>
                                    </select>
                                </div>
                                <div class="col-1">
                                    <button type="button" id="add-Tratamiento" class="btn btn-morado" style="border-radius: 25px;">
                                        <i class="fas fa-plus"></i>
                                    </button>
                                </div>
                            </div>
                        </div>

                        <!-- 5 -->
                        <div class="form-group row justify-content-center mt-4">
                            <div class="col-4">
                                <button type="button" class="btn btn-outline-success btn-block" style="border-radius:20px">
                                    <i class="fas fa-save mr-1"></i>
                                    Guardar Cambios</button>
                            </div>
                        </div>


                        <!-- 6 -->
                        <div class="form-group row justify-content-center mt-3">
                            <div class="col-4">
                                <button type="button" class="btn btn-outline-info btn-block" id="btn-contraseña" style="border-radius:20px" data-toggle="modal"
                                    data-target="#modalCambiarContraseña">
                                    <i class="fas fa-key mr-1"></i>
                                    Cambiar Contraseña</button>
                            </div>
                        </div>

                        <div class="row justify-content-center">
                            <div class="col-8 text-center">
                                <hr>
                            </div>
                        </div>

                        <div class="form-group row justify-content-center mt-4">
                            <div class="col-4">
                                <button type="button" class="btn btn-outline-danger btn-block" style="border-radius:20px" id="eliminarCuentaPaciente">
                                    <i class="fas fa-trash-alt mr-1"></i>
                                    Eliminar Cuenta</button>
                            </div>
                        </div>

                    </form>

                </div>
            </div>

        </div>

        <!-- ********** MODAL EDITAR CONTRASEÑA **********-->
        <div class="modal fade" id="modalCambiarContraseña" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Cambiar contraseña</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="form-row">
                            <div class="form-group col-12">
                                <label for="name">Contraseña</label>
                                <input type="password" class="form-control" id="password" placeholder="Ingresa tu nueva contraseña" />
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-12">
                                <span class="text-danger" id="error-contraseña">La contraseña debe tener al menos 1 número, 1 letra minúscula, 1 mayúscula y una extensión de 8 a 14 caracteres.</span>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-12">
                                <label for="name">Confirma tu contraseña</label>
                                <input type="password" class="form-control" id="password-confirm" placeholder="Reingresa tu nueva contraseña" />
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-12">
                                <span class="text-danger" id="error-notEqualPasswords">Las contraseñas no son iguales.</span>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" style="border-radius: 20px" data-dismiss="modal">Cancelar</button>
                        <button type="button" class="btn btn-primary" id="btn-updatePassword" style="border-radius: 20px">Cambiar contraseña</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- ******* FIN MODAL EDITAR CONTRASEÑA ********-->

    </div>

    <script type="module" src="../js/validaciones.js"></script>

</body>

</html>