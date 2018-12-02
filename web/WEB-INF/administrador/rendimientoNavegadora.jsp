<%-- 
    Document   : rendimientoNavegadora
    Created on : 15-nov-2018, 2:31:35
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

    <title>Rendimiento de: ${sessionScope.nombreNavegadora} ${sessionScope.primerApellidoNavegadora}</title>


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
    <script src="js/rendimiento.js"></script>


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
                        <a class="iconoSidebar IrAMiCuenta" title="Mi Cuenta"><i class="fas fa-cog"></i></a>
                    </div>

                    <div class="col-2">
                        <a class="iconoSidebar salirCuenta" title="Cerrar Sesión"><i class="fas fa-power-off"></i></a>
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

                        <span class="pull-right d-block"><span style="color:#6c6f80">Rendimiento de:</span> ${sessionScope.nombreNavegadora} ${sessionScope.primerApellidoNavegadora}  <span style="font-weight:700; color:#6c6f80;">

                                </div>
                                </nav>

                                <!-- **************************************************************** -->
                                <!-- ***** A PARTIR DE AQUI ESCRIBEN EL CODIGO QUE QUIERAN..... ***** -->
                                <!-- **************************************************************** -->

                                <!-- 1.- TOTAL DE VISITAS POR MES -->
                                <div class="jumbotron jumbotron-fluid p-2">
                                    <div class="container">
                                        <h1 class="display-4 tituloPacientes text-center m-0">Total de visitas por mes</h1>
                                    </div>
                                </div>

                                <div class="row form-group">
                                    <div class="col-6">
                                        <label for="fecha1">Fecha 1</label>
                                        <input type="text" placeholder="Introduce la primer fecha" onfocus="(this.type = 'date')" class="form-control" id="fecha1Mes">
                                    </div>
                                    <div class="col-6">
                                        <label for="fecha 2">Fecha 2</label>
                                        <input type="text" placeholder="Introduce la segunda fecha" onfocus="(this.type = 'date')" class="form-control" id="fecha2Mes">
                                    </div>
                                </div>

                                <div class="row errorFechasMes">
                                    <div class="col-12">
                                        <h6 class="text-danger">Elija un rango de fechas válido</h6>
                                    </div>
                                </div>

                                <div class="card mt-3">
                                    <div class="card-body">
                                        <table class="table totalVisitasMes">
                                            <thead>
                                                <tr>
                                                    <th scope="col">Rango</th>
                                                    <th scope="col">Total de visitas</th>
                                                </tr>
                                            </thead>
                                            <tbody>

                                            </tbody>
                                        </table>

                                    </div>
                                </div>

                                <!-- 2.- CANTIDAD DE VISITAS POR EDADDES -->
                                <div class="jumbotron jumbotron-fluid p-2 mt-4">
                                    <div class="container">
                                        <h1 class="display-4 tituloPacientes text-center m-0">Cantidad de visitas por Edades</h1>
                                    </div>
                                </div>

                                <div class="row form-group">
                                    <div class="col-6">
                                        <label for="fecha1Edad">Fecha 1</label>
                                        <input type="text" placeholder="Introduce la primer fecha" onfocus="(this.type = 'date')" class="form-control" id="fecha1Edad">
                                    </div>
                                    <div class="col-6">
                                        <label for="fecha2Edad">Fecha 2</label>
                                        <input type="text" placeholder="Introduce la segunda fecha" onfocus="(this.type = 'date')" class="form-control" id="fecha2Edad">
                                    </div>

                                </div>
                                
                                <div class="row errorFechasEdad">
                                    <div class="col-12">
                                        <h6 class="text-danger">Elija un rango de fechas válido</h6>
                                    </div>
                                </div>

                                <div class="card mt-3">
                                    <div class="card-body">
                                        <table class="table table-striped cantidadVisitasEdades">
                                            <thead>
                                                <tr>
                                                    <th scope="col">Edad</th>
                                                    <th scope="col">Cantidad</th>
                                                </tr>
                                            </thead>
                                            <tbody>

                                            </tbody>
                                        </table>

                                    </div>
                                </div>

                                <!-- 3.- CANTIDAD DE VISITAS POR ESCOLARIDAD -->
                                <div class="jumbotron jumbotron-fluid p-2 mt-4">
                                    <div class="container">
                                        <h1 class="display-4 tituloPacientes text-center m-0">Cantidad de visitas por Escolaridad</h1>
                                    </div>
                                </div>
                                
                                <div class="row form-group">
                                    <div class="col-6">
                                        <label for="fecha1Escolaridad">Fecha 1</label>
                                        <input type="text" placeholder="Introduce la primer fecha" onfocus="(this.type = 'date')" class="form-control" id="fecha1Escolaridad">
                                    </div>
                                    <div class="col-6">
                                        <label for="fecha2Escolaridad">Fecha 2</label>
                                        <input type="text" placeholder="Introduce la segunda fecha" onfocus="(this.type = 'date')" class="form-control" id="fecha2Escolaridad">
                                    </div>

                                </div>
                                
                                <div class="row errorFechasEscolaridad">
                                    <div class="col-12">
                                        <h6 class="text-danger">Elija un rango de fechas válido</h6>
                                    </div>
                                </div>

                                <div class="card mt-3">
                                    <div class="card-body">
                                        <table class="table table-striped cantidadVisitasEscolaridad">
                                            <thead>
                                                <tr>
                                                    <th scope="col">Escolaridad</th>
                                                    <th scope="col">Cantidad</th>
                                                </tr>
                                            </thead>
                                            <tbody>

                                            </tbody>
                                        </table>

                                    </div>
                                </div>

                                <!-- 4.- CANTIDAD DE VISITAS POR LUGAR DE RESIDENCIA -->
                                <div class="jumbotron jumbotron-fluid p-2 mt-4">
                                    <div class="container">
                                        <h1 class="display-4 tituloPacientes text-center m-0">Cantidad de visitas por lugar de residencia</h1>
                                    </div>
                                </div>
                                
                                <div class="row form-group">
                                    <div class="col-6">
                                        <label for="fecha1Residencia">Fecha 1</label>
                                        <input type="text" placeholder="Introduce la primer fecha" onfocus="(this.type = 'date')" class="form-control" id="fecha1Residencia">
                                    </div>
                                    <div class="col-6">
                                        <label for="fecha2Residencia">Fecha 2</label>
                                        <input type="text" placeholder="Introduce la segunda fecha" onfocus="(this.type = 'date')" class="form-control" id="fecha2Residencia">
                                    </div>

                                </div>
                                
                                <div class="row errorFechasResidencia">
                                    <div class="col-12">
                                        <h6 class="text-danger">Elija un rango de fechas válido</h6>
                                    </div>
                                </div>

                                <div class="card mt-3">
                                    <div class="card-body">
                                        <table class="table table-striped cantidadVisitasResidencia">
                                            <thead>
                                                <tr>
                                                    <th scope="col">Lugar</th>
                                                    <th scope="col">Cantidad</th>
                                                </tr>
                                            </thead>
                                            <tbody>

                                            </tbody>
                                        </table>

                                    </div>
                                </div>

                                <!-- 5.- CANTIDAD DE VISITAS POR NIVEL SOCIOECONOMICO -->
                                <div class="jumbotron jumbotron-fluid p-2 mt-4">
                                    <div class="container">
                                        <h1 class="display-4 tituloPacientes text-center m-0">Cantidad de visitas por nivel socioeconómico</h1>
                                    </div>
                                </div>
                                
                                <div class="row form-group">
                                    <div class="col-6">
                                        <label for="fecha1Economico">Fecha 1</label>
                                        <input type="text" placeholder="Introduce la primer fecha" onfocus="(this.type = 'date')" class="form-control" id="fecha1Economico">
                                    </div>
                                    <div class="col-6">
                                        <label for="fecha2Economico">Fecha 2</label>
                                        <input type="text" placeholder="Introduce la segunda fecha" onfocus="(this.type = 'date')" class="form-control" id="fecha2Economico">
                                    </div>

                                </div>
                                
                                <div class="row errorFechasEconomico">
                                    <div class="col-12">
                                        <h6 class="text-danger">Elija un rango de fechas válido</h6>
                                    </div>
                                </div>

                                <div class="card mt-3">
                                    <div class="card-body">
                                        <table class="table table-striped cantidadVisitasNivel">
                                            <thead>
                                                <tr>
                                                    <th scope="col">Nivel Socioeconómico</th>
                                                    <th scope="col">Cantidad</th>
                                                </tr>
                                            </thead>
                                            <tbody>

                                            </tbody>
                                        </table>

                                    </div>
                                </div>

                                <!-- 6.- CANTIDAD DE VISITAS POR DECISION PRE-CONSULTA -->
                                <div class="jumbotron jumbotron-fluid p-2 mt-4">
                                    <div class="container">
                                        <h1 class="display-4 tituloPacientes text-center m-0">Cantidad de visitas por decision pre-consulta</h1>
                                    </div>
                                </div>
                                
                                <div class="row form-group">
                                    <div class="col-6">
                                        <label for="fecha1Pre">Fecha 1</label>
                                        <input type="text" placeholder="Introduce la primer fecha" onfocus="(this.type = 'date')" class="form-control" id="fecha1Pre">
                                    </div>
                                    <div class="col-6">
                                        <label for="fecha2Pre">Fecha 2</label>
                                        <input type="text" placeholder="Introduce la segunda fecha" onfocus="(this.type = 'date')" class="form-control" id="fecha2Pre">
                                    </div>

                                </div>
                                
                                <div class="row errorFechasPre">
                                    <div class="col-12">
                                        <h6 class="text-danger">Elija un rango de fechas válido</h6>
                                    </div>
                                </div>

                                <div class="card mt-3">
                                    <div class="card-body">
                                        <table class="table table-striped cantidadVisitasPre">
                                            <thead>
                                                <tr>
                                                    <th scope="col">Decisión</th>
                                                    <th scope="col">Cantidad</th>
                                                </tr>
                                            </thead>
                                            <tbody>

                                            </tbody>
                                        </table>

                                    </div>
                                </div>

                                <!-- 7.- CANTIDAD DE VISITAS POR RESULTADO PATOLOGIA -->
                                <div class="jumbotron jumbotron-fluid p-2 mt-4">
                                    <div class="container">
                                        <h1 class="display-4 tituloPacientes text-center m-0">Cantidad de visitas por resultado de patología</h1>
                                    </div>
                                </div>
                                
                                <div class="row form-group">
                                    <div class="col-6">
                                        <label for="fecha1Patologia">Fecha 1</label>
                                        <input type="text" placeholder="Introduce la primer fecha" onfocus="(this.type = 'date')" class="form-control" id="fecha1Patologia">
                                    </div>
                                    <div class="col-6">
                                        <label for="fecha2Patologia">Fecha 2</label>
                                        <input type="text" placeholder="Introduce la segunda fecha" onfocus="(this.type = 'date')" class="form-control" id="fecha2Patologia">
                                    </div>

                                </div>
                                
                                <div class="row errorFechasPatologia">
                                    <div class="col-12">
                                        <h6 class="text-danger">Elija un rango de fechas válido</h6>
                                    </div>
                                </div>

                                <div class="card mt-3">
                                    <div class="card-body">
                                        <table class="table table-striped cantidadVisitasPatologia">
                                            <thead>
                                                <tr>
                                                    <th scope="col">Resultado</th>
                                                    <th scope="col">Cantidad</th>
                                                </tr>
                                            </thead>
                                            <tbody>

                                            </tbody>
                                        </table>

                                    </div>
                                </div>


                                </div>

                                <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.6.0/Chart.min.js"></script>
    </div>

    

</body>

</html>