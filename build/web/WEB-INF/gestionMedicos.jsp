<%-- 
    Document   : gestionMedicos
    Created on : 12/09/2018, 09:27:23 AM
    Author     : quint
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="mx.itesm.sapi.bean.Persona"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <%-- Hace rereferencia al conjunto de reglas --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>SAP | Inicio</title>

    <link rel="stylesheet" href="css/tooltipster.bundle.css">
    <link rel="stylesheet" href="css/tooltipster-sideTip-shadow.min.css">
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/style2.css">
    <link rel="stylesheet" href="css/fullcalendar.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ"
        crossorigin="anonymous">
    <script src="js/locale-all.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>

<body>

    <div class="wrapper">

        <!-- SIDEBAR -->
        <nav id="sidebar">

            <div class="sidebar-header">

                <div class="row text-center justify-content-center mt-2">
                    <div class="col-12">
                        <img src="./img/logoSapi.png" style="width: 70%; display:block; margin:auto;" alt="">
                    </div>
                </div>

            </div>

            <div class="profile">

                <div class="row">
                    <div class="col-12 mb-2 mt-4">
                        <img src="./img/user.png" class="imagenPerfil" alt="">
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
                        <a class="iconoSidebar" href="" title="Mi Cuenta"><i class="fas fa-cog"></i></a>
                    </div>

                    <div class="col-2">
                        <a class="iconoSidebar" href="" title="Cerrar Sesión"><i class="fas fa-power-off"></i></a>
                    </div>

                </div>

            </div>

            <!-- MENU PRINCIPAL ENLACES -->
            <ul class="list-unstyled components">

                <li><a href="./index.html"><i class="fas fa-home"></i>Inicio</a></li>

                <li><a href="#"><i class="far fa-user"></i>Mi Cuenta</a></li>

                <li><a href="./gestionMedicos.html"><i class="fas fa-briefcase-medical"></i>Gestion de Medicos</a></li>

                <li><a href="#"><i class="fas fa-calendar-alt"></i>Gestion de Navegadoras</a></li>

                <li><a href="#"><i class="fas fa-users"></i>Gestion de Pacientes</a></li>

                <li><a href="#"><i class="fas fa-sign-out-alt"></i>Cerrar Sesión</a></li>

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

                    <span class="pull-right d-block"><span style="color:#6c6f80">Bienvenido, </span><span style="font-weight:700; color:#6c6f80;">Julio
                            Badillo
                        </span> <img src="./img/user.png" class="ml-2" style="width: 30px;" alt=""> </span>

                </div>
            </nav>

            <!-- Navegacion -->

            <div class="row mb-3 justify-content-end">
                <div class="col-3 text-center">
                    <span class="iconoHome mr-2"><i class="fas fa-home"></i></span><span><a href="./index2.html" class="text-primary">Inicio</a></span>
                    - <span class="colorGlobal">Gestion de Médicos</span>
                </div>
            </div>

            <!-- Jumbotron Titulo -->

            <div class="jumbotron jumbotron-fluid p-2">
                <div class="container">
                    <h1 class="display-4 tituloMisCitas text-center m-0">Gestión de Médicos</h1>
                </div>
            </div>

            <!-- Buscador -->
            <div class="row">
                <div class="col-10">
                    <input type="text" class="form-control buscador" placeholder="Buscar" id="">
                </div>
                <div class="col-2">
                    <button class="btn btn-block btn-outline-primary">Buscar</button>
                </div>
            </div>

            <!-- Gestion -->

            <div class="card mt-3">
                <div class="card-body">

                    <!-- Boton agregar -->

                    <div class="row">
                        <div class="col-9">
                            <button class="btn btn-outline-success">Agregar Médico</button>
                        </div>
                    </div>

                    <!-- Table -->

                    <table class="table table-striped mt-3">
                        <thead>
                            <tr>
                                <th scope="col">Nombre</th>
                                <th scope="col">Apellidos</th>
                                <th scope="col">Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${personas}" var="persona">                    
                            <tr>
                                <td><c:out value="${persona.nombre}"/></td>
                                <td><c:out value="${persona.apellidos}"/></td>
                                <td>
                                    <button class="btn btn-primary btn-editar" data-id="<c:out value="${persona.idPersona}"/>" data-toggle="modal" data-target="#modalEditarUsuario"><i class="fas fa-edit"></i></button>
                                    <button class="btn btn-danger btn-eliminar" data-id="<c:out value="${persona.idPersona}"/>"><i class="fas fa-trash-alt"></i></button>
                                </td>
                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

            <!-- ********** MODAL EDITAR USUARIO ********** -->
            <div class="modal fade" id="modalEditarUsuario" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Editar Médico</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            ...
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                            <button type="button" class="btn btn-primary">Guardar Cambios</button>
                        </div>
                    </div>
                </div>
            </div>


        </div>
    </div>

    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/app.js"></script>
    <script src="js/tooltipster.bundle.min.js"></script>
    <script src="js/moment.min.js"></script>
    <script src="js/fullcalendar.min.js"></script>

</body>

</html>