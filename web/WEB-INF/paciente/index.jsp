<%-- 
    Document   : index
    Created on : 18-oct-2018, 15:41:04
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
    <script src="https://momentjs.com/downloads/moment-with-locales.min.js"></script>
    <script src='lib/fullcalendar/fullcalendar.js' type="application/javascript"></script>
    <script src="lib/fullcalendar/locale-all.js"></script>
    <script src="lib/sweetalert/dist/sweetalert.min.js"></script>
    <script src="lib/tooltipster/dist/js/tooltipster.bundle.min.js" type="text/javascript"></script>
    <script src="lib/datatables/datatables.min.js" type="text/javascript"></script>

    <link rel="stylesheet" href="css/stylePaciente.css">
    <script src="js/appPaciente.js" type="module"></script>
    <script src="js/calendarPaciente.js"></script>
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
                        <span class="textoSidebar m-0">${sessionScope.nombre} ${sessionScope.primerApellido}</span>
                        <span class="textoSidebar userSidebar m-0">@${sessionScope.usuario}</span>
                    </div>
                </div>

                <div class="row justify-content-center">

                    <div class="col-2 text-center">
                        <a class="iconoSidebar" href="" title="Mi Cuenta"><i class="fas fa-cog"></i></a>
                    </div>

                    <div class="col-2">
                        <a class="iconoSidebar" href="" id="salirCuenta1" title="Cerrar Sesión"><i class="fas fa-power-off"></i></a>
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

                <li><a href="#"><i class="fas fa-home"></i>Mis Citas</a></li>

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
                    
                     <!-- aqui se inyecta la sesion de id-->
                    <input type="hidden" id="idPaciente" value="${sessionScope.idPaciente}" />

                    <span class="pull-right d-block"><span style="color:#6c6f80">Bienvenido, </span><span style="font-weight:700; color:#6c6f80;">
                             <!--Julio Badillo-->
                            ${sessionScope.nombre} ${sessionScope.primerApellido}
                        </span> <img src="img/user.png" class="ml-2" style="width: 30px;" alt=""> </span>

                </div>
            </nav>


            <!-- CONTENIDO -->
            <div class="row mb-3 justify-content-end">
                <div class="col-3 text-center">
                    <span class="iconoHome mr-2"><i class="fas fa-home"></i></span><span><a href="./index2.html" class="colorMoradoLight">Inicio</a></span>
                    - <span class="colorGlobal">Mis Citas</span>
                </div>
            </div>

            <!-- CONTENIDO -->
            <div class="jumbotron jumbotron-fluid p-2">
                <div class="container">
                    <h1 class="display-4 tituloMisCitas text-center m-0">Mis Citas</h1>
                </div>
            </div>

            <!-- Icono info -->

            <div class="row justify-content-end mb-3">
                <div class="col-12">
                    <i class="fas fa-info-circle float-right icono-info" style="font-size:27px" data-toggle="tooltip" data-placement="top" title="¿Tienes algún problema con tu cita? Llama al 01-800-111-11-11">
                    </i>
                </div>
            </div>

            <div class="card">
                <div class="card-body">
                    <div id="calendarCitasPaciente"></div>
                </div>
            </div>
            
            <!-- Id paciente -->
            <input type="hidden" id="idPaciente" value="${sessionScope.idSesion}" />
            
            <div class="card">
                <div class="card-footer">
                    <div class="row justify-content-center text-center">
                        <div class="col-3">
                            <span class="badge badge-secondary"><span class="ocultaBadge">CC</span></span> <span class="">Edificio
                                Antiguo
                            </span> <!-- CAMBIAR COLOR DE ESTE BADGE -->
                        </div>
                        <div class="col-3">
                            <span class="badge badge-info"><span class="ocultaBadge">CC</span></span> <span class="">Planta
                                baja
                            </span>
                        </div>
                        <div class="col-3">
                            <span class="badge badge-warning"><span class="ocultaBadge">CC</span></span> <span class="">Primer
                                piso
                            </span>
                        </div>
                        <div class="col-3">
                            <span><span class="badge badge-danger"><span class=ocultaBadge>CC</span></span> <span class="">Segundo
                                    piso
                                </span>
                        </div>
                    </div>
                </div>
            </div>


        </div>
    </div>

    <!-- Modal VER CITA-->
    <div class="modal fade" id="modalVerCita" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Informacion de cita</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">

                    <div class="row mb-4">
                        <div class="col-12">
                            <h6 class="text-center display-4 tituloCitaModal text-primary" id="titulo-cita"></h6>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-12 text-center">
                            <i class="fas fa-calendar-alt mr-2 text-danger"></i><span style="font-weight:bold; color: #2c2f39">Dia:
                            </span><span id="dia-cita" style="color: #696a6b">28/09/2018</span>
                            <hr>
                        </div>
                    </div>

                    <div class="row mt-1">
                        <div class="col-12 text-center">
                            <i class="fas fa-clock mr-2 text-primary"></i><span style="font-weight:bold; color: #2c2f39">Hora:
                            </span><span id="hora-cita" style="color: #696a6b"></span>
                            
                        </div>
                    </div>

                    <!--<div class="row mt-1">
                        <div class="col-12 text-center">
                            <i class="fas fa-map-marker-alt mr-2 text-info"></i><span style="font-weight:bold; color: #2c2f39">Piso:
                            </span><span style="color: #696a6b">Primer Piso</span>
                        </div>
                    </div>-->

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" style="border-radius:20px;" data-dismiss="modal">Cerrar</button>
                </div>
            </div>
        </div>
    </div>

    <!-- ***** MODAL ***** -->
    <div id="modalAgregarCita" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="modalRegistrarCitaLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
            <div class="modal-content">
                <!-- ***** Titulo ***** -->
                <div class="modal-header">
                    <h5 class="modal-title text-secondary display-4" style="font-size: 25px;" id="modalRegistrarCitaLabel">Registrar
                        Cita para el dia: <span class="text-primary" id="dia-registrarCita"></span>
                    </h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="color: #fff;">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <!-- ***** Contenido ***** -->
                <div class="modal-body">
                    <div class="container-fluid" style="max-height:70vh; overflow-y:auto;">

                        <!-- ***** Nota ***** -->
                        <div class="row mb-3 justify-content-center">
                            <div class="col-10 text-center bg-danger" style="border-radius:20px;">
                                <span style="font-size: 14px;" class="text-white">Nota: El sistema no se encarga de agendar
                                    citas en el INCan. Sólo es un recordatorio para uso personal.</span>
                            </div>
                        </div>

                        <!-- ***** Fecha ***** -->
                        <!--<div class="row mb-3 justify-content-center">
                            <div class="col-1" data-toggle="tooltip" data-placement="top" title="Seleccione la fecha de su cita"><i
                                    class="fas fa-question-circle modalInfo"></i></div>
                            <div class="col-2"> <span class="colorGlobal">Fecha:</span></div>
                            <div class="col-8">
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <div class="input-group-text"><i class="fas fa-calendar-alt"></i></div>
                                    </div>
                                    <input placeholder="Fecha de tu cita" class="form-control" type="text" onfocus="(this.type='date')"
                                        id="RegistrarCita_fecha">    
                                </div>
                                <span class="text-danger" id="error-fecha">No es una fecha válida.</span>
                            </div>
                        </div>-->

                        <!-- ***** Hora ***** -->
                        <div class="row mb-3 justify-content-center">
                            <div class="col-1" data-toggle="tooltip" data-placement="top" title="Seleccione la hora de su cita Horario 07:00 - 19:00"><i
                                    class="fas fa-question-circle modalInfo"></i></div>
                            <div class="col-2"> <span class="colorGlobal">Hora:</span></div>
                            <div class="col-8">
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <div class="input-group-text"><i class="fas fa-clock"></i></div>
                                    </div>
                                    <input class="hora form-control" type="time" id="RegistrarCita_hora" min="07:00" max="18:59" />
                                </div>
                            </div>
                        </div>

                        <!-- ***** Tipo ***** -->
                        <div class="row mb-3 justify-content-center">
                            <div class="col-1" data-toggle="tooltip" data-placement="top" title="Seleccione el tipo de su cita"><i
                                    class="fas fa-question-circle modalInfo"></i></div>
                            <div class="col-2"> <span class="colorGlobal">Tipo:</span> </div>
                            <div class="col-8">
                                <select class="custom-select" id="RegistrarCita_tipo">
                                    <option disabled selected>Seleccione tipo</option>
                                    <option value="Consulta">Consulta</option>
                                    <option value="Preonsulta">Preconsulta</option>
                                    <option value="Tratamiento">Tratamiento</option>
                                    <option value="Estudio">Estudio</option>
                                    <option value="Cirugía">Cirugía</option>
                                </select>
                                <span class="text-danger mr-4" id="error-tipoCita">No has seleccionado un tipo de cita.</span>
                            </div>
                            
                        </div>


                        <!-- ***** Médico ***** -->

                        <div class="row mb-3 justify-content-center">
                            <div class="col-1" data-toggle="tooltip" data-placement="top" title="Seleccione a su médico adscrito"><i
                                    class="fas fa-question-circle modalInfo"></i></div>
                            <div class="col-2"> <span class="colorGlobal">Médico Adscrito:</span></div>
                            <div class="col-8">
                                <select class="custom-select" id="RegistrarCita_medico">
                                    <option disabled selected>Seleccione médico</option>
                                    <option value="Dra. Esparza 1">Dra. Esparza</option>
                                    <option value="Dra. Esparza 2">Dr. Bargalló</option>
                                    <option value="Dra. Esparza 3">Dra. Cabrera</option>
                                </select>
                                <span class="text-danger mr-5" id="error-medico">No has seleccionado un médico.</span>
                            </div>
                            
                        </div>

                        <!-- ***** Edificio *****
                        <div class="row mb-3 justify-content-center">
                            <div class="col-1" data-toggle="tooltip" data-placement="top" title="Seleccione el edificio de su cita"><i
                                    class="fas fa-question-circle modalInfo"></i></div>
                            <div class="col-2"> <span class="colorGlobal">Edificio:</span></div>
                            <div class="col-8">
                                <div>
                                    <div>
                                        <input class="modalRadio1" id="RegistrarCita_edificioAntiguo" type="radio" name="Edificios" value="Edificio antiguo" />
                                        <span class="badge">Edificio antiguo</span>
                                        <i class="fas fa-question-circle modalInfo" id="EdAntiguo"></i>
                                    </div>
                                    <div>
                                        <input class="modalRadio2" id="RegistrarCita_edificioNuevo" type="radio" name="Edificios" value="Torre de nueva hospitalización"  />
                                        <span class="badge">Torre nueva de hospitalización</span>
                                        <i class="fas fa-question-circle modalInfo" id="EdTorre"></i>
                                    </div>
                                </div>
                                <span class="text-danger mr-5" id="error-edificio">No has seleccionado un edificio.</span>
                            </div>  
                        </div> -->

                        <!-- <div class="row mb-3 justify-content-center">
                            <div class="col-10 text-center">


                                
                                <div class="infoEdificios text-center row" id="feedbackEdAntiguo">
                                    <div class="col-12">
                                        <span class="badge badge-secondary mb-3 d-block" style="font-size:15px">Áreas:</span>

                                        <textarea id="t1" readonly="true" style="width: 100%;" rows="6" style="display:none;">

                                                        • Banco de sangre           • Genética
                                                        • Radioterapia                  • Electrocardiograma
                                                        • Psicología                       • Clínica del dolor
                                                        • Cuidados Paliativos
                                        </textarea>
                                    </div>
                                </div>

                  
                                <div class="infoEdificios text-center row" id="feedbackEdTorre">
                                    <div class="col-12">
                                        <span class="badge badge-info mb-2 d-block" style="font-size:15px">Planta baja:</span>

                                        <textarea class="plantaBajaArea" style="width: 100%;" readonly="true" style="display:none;">

                                                        • Rayos- X                                    • Mastografía
                                                        • Ultrasonido                                • Tomografía
                                                        • Resonancia Magnética             • PET-CT
                                                        • MUGA                                        • Gammagrafía ósea
                                                        • Atención inmediata
                                                        </textarea>
                                    </div>


                                    <div class="col-12">
                                        <span class="badge badge-warning mb-2 d-block" style="font-size:15px; color:#fff">1er
                                            Piso:
                                        </span>
                                    </div>


                                    <div class="col-12">
                                        <textarea class="primerPisoArea" style="width: 100% !important;" readonly="true" style="display:none;">

                                                        • Laboratorio                                • Farmacia</textarea>
                                    </div>

                                    <div class="col-12">
                                        <span class="badge badge-danger mb-2 d-block" style="font-size:15px">2do Piso:</span>
                                    </div>

                                    <div class="col-12">
                                        <textarea class="segundoPisoArea" style="width: 100%;" readonly="true" style="display:none;">


                                                        • Clínica de Mama                       • Oncología médica
                                                        • Unidad Funcional Mama          • Cirugía oncológica
                                                        • Cirugía plástica                         •  Ecocardiograma
                                                        • Trabajo Social                           •  Quimioterapia
                                                        • Protocolos                                 •  Nutrición
                                                        • Odontología                              •  M-8                   
                                                        • Programa Mujer Jóven             •  Donaciones
                                                        • Valoración cardiovascular
                                                        • Colocación de catéteres</textarea>
                                    </div>

                                </div>

                                
                            </div>
                        </div> -->


                        <!-- ***** Piso ***** -->

                        <!-- <div class="row mb-3 justify-content-center btns-pisos" id="pisosDiv">
                            <div class="col-1" data-toggle="tooltip" data-placement="top" title="Seleccione el tipo de su cita"><i
                                    class="fas fa-question-circle modalInfo"></i></div>
                            <div class="col-2"> <span class="colorGlobal">Piso:</span></div>

                            <div class="col-8">
                                <div id="RegistrarCita_piso">
                                    <div><input class="modalRadio1" type="radio" name="Pisos" value="Planta Baja" for="piso1"
                                             /> <span class="badge badge-info">Planta baja</span></div>
                                    <div><input class="modalRadio2" type="radio" name="Pisos" value="Piso 1" for="piso2"
                                        />
                                        <span class="badge badge-warning">Primer piso</span></div>
                                    <div><input class="modalRadio3" type="radio" name="Pisos" value="Piso 2" for="piso2"
                                        />
                                        <span class="badge badge-danger">Segundo piso</span></div>
                                </div>
                                <span class="text-danger mr-5" id="error-piso">No has seleccionado un piso.</span>
                            </div>
                        </div> -->

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" style="border-radius:20px;" data-dismiss="modal">Cerrar</button>
                        <button id="btn-citaRegistrar" type="button" class="btn btn-primary" style="border-radius:20px;">Registrar</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
</body>

</html>