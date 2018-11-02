<%-- 
    Document   : documentos
    Created on : 2/11/2018, 11:15:08 AM
    Author     : feror
--%>

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
    <script src="js/appNavegadora2.js"></script>
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
                        <img src="img/user.png" class="imagenPerfil" alt="">
                    </div>
                </div>

                <div class="row justify-content-center mb-2">
                    <div class="col-6 text-center">
                        <span class="textoSidebar m-0">Shannon Rosas</span>
                        <span class="textoSidebar userSidebar m-0">@shannonrosas</span>
                    </div>
                </div>

                <div class="row justify-content-center">

                    <div class="col-2 text-center">
                        <a class="iconoSidebar" href="" title="Mi Cuenta">
                            <i class="fas fa-cog"></i>
                        </a>
                    </div>

                    <div class="col-2">
                        <a class="iconoSidebar" href="" title="Cerrar Sesión">
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
                    <a href="index.html">
                        <i class="fas fa-home"></i>Inicio</a>
                </li>

                <li>
                    <a href="calendar.html">
                        <i class="fas fa-calendar-alt"></i>Calendario</a>
                </li>
                <li>
                    <a href="rendimiento.html">
                        <i class="fas fa-chart-line"></i>Mi Rendimiento</a>
                </li>


                <li>
                    <a href="cuenta.html">
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
                        <span style="font-weight:700; color:#6c6f80;">Shannon Rosas
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
                    <h6 class="display-4 text-center m-0 text-secondary" id="pacienteSelec" style="font-size:25px;">María Esther Domínguez Mayoral</h6>
                </div>
            </div>

            <div class="row justify-content-center">
                <div class="col-6 text-center">
                    <ul class="list-group">
                        <li class="list-group-item">Estado Civil:
                            <strong>Casada</strong>
                        </li>
                        <li class="list-group-item">Fecha de Nacimiento:
                            <strong>12 de enero de 1989</strong>
                        </li>
                        <li class="list-group-item">Lugar de residencia:
                            <strong>Morelos, Cuernavaca</strong>
                        </li>
                        <li class="list-group-item">Direccion:
                            <strong>Calle del empleado #421, CP. 2345</strong>
                        </li>
                        <li class="list-group-item">Fecha de Registro:
                            <strong>12 de julio de 2018</strong>
                        </li>
                    </ul>
                </div>
                <div class="col-6 text-center">
                    <ul class="list-group">
                        <li class="list-group-item">CURP:
                            <strong>PEFU123567TAM23</strong>
                        </li>
                        <li class="list-group-item">Teléfono:
                            <strong>12344567</strong>
                        </li>
                        <li class="list-group-item">Edad:
                            <strong>29</strong>
                        </li>
                        <li class="list-group-item">Correo:
                            <strong>tam@correo.mx</strong>
                        </li>
                        <li class="list-group-item">Visita:
                            <span class="badge badge-success">Primera vez</span>
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
                            <tr>
                                <td>
                                    <i class="fas fa-comments mr-2 iconoComentarios" data-toggle="modal" data-target="#modalVerComentario"></i>

                                    Identificación oficial
                                    <span class=" ml-2 badge badge-danger">Rechazado</span>
                                </td>
                                <td>
                                    <a href='verDocumento.html' class="btn btn-info" id="btn-ver ">
                                        <i class="far fa-eye "></i>
                                        </button>
                                </td>
                                <td>
                                    <button class="btn btn-primary " id="btn-descargar ">
                                        <i class="fas fa-cloud-download-alt"></i>
                                        </button>
                                </td>
                            </tr>
                            <tr>
                                <td>Comprobante de domicilio
                                    <span class=" ml-2 badge badge-success ">Aceptado</span>
                                </td>
                                <td>
                                    <a href='verDocumento.html' class="btn btn-info" id="btn-ver">
                                        <i class="far fa-eye"></i>
                                    </a>
                                </td>
                                <td>
                                    <button class="btn btn-primary " id="btn-descargar ">
                                        <i class="fas fa-cloud-download-alt"></i>
                                        </button>
                                </td>
                            </tr>
                            <tr>
                                <td>Estudios previos</td>
                                <td>
                                    <button class="btn btn-info " id="btn-ver ">
                                        <i class="far fa-eye "></i>
                                    </button>
                                </td>
                                <td>
                                    <button class="btn btn-primary " id="btn-descargar ">
                                        <i class="fas fa-cloud-download-alt"></i>
                                        </button>
                                </td>
                            </tr>
                            <tr>
                                <td>Motivo de consulta</td>
                                <td>
                                    <button class="btn btn-info " id="btn-ver ">
                                        <i class="far fa-eye "></i>
                                    </button>
                                </td>
                                <td>
                                    <button class="btn btn-primary " id="btn-descargar ">
                                        <i class="fas fa-cloud-download-alt"></i>
                                        </button>
                                </td>
                                
                            </tr>
                            

                        </tbody>
                    </table>

                    <div class="row justify-content-center mt-3">
                        <div class="col-4">
                            <button class="btn btn-outline-primary btn-block" id="enviarObservaciones" style="border-radius: 20px">
                                <i class="fas fa-arrow-alt-circle-right mr-2"></i>Enviar observaciones</button>
                        </div>

                    </div>
                </div>


            </div>

        </div>


        <!-- ********** MODAL VER COMENTARÍO ********** -->
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
                            <div class="col-12 ">
                                <span class="d-block">1.- La imagen esta muy borrosa</span>
                                <span class="d-block">2.- No esta actualizada</span>
                            </div>
                        </div>

                    </div>
                    <div class="modal-footer ">
                        <button type="button" class="btn btn-danger" style="border-radius: 20px" data-dismiss="modal">Cerrar</button>
                        <button type="button" class="btn btn-primary" style="border-radius: 20px" data-dismiss="modal">Aceptar</button>
                    </div>
                </div>
            </div>
        </div>



    </div>
    </div>

</body>

</html>
