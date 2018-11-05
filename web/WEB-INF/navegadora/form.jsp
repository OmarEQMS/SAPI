<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>SAPI | Inicio</title>

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
                        <img src="../img/logoSapi.png" style="width: 70%; display:block; margin:auto;" alt="">
                    </div>
                </div>

            </div>

            <div class="profile">

                <div class="row">
                    <div class="col-12 mb-2 mt-4">
                        <img src="../img/user.png" class="imagenPerfil" alt="">
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
                        <a class="iconoSidebar" href="" title="Cerrar Sesi�n">
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
                        <i class="fas fa-home"></i>Inicio</a>
                </li>

                <li>
                    <a href="./calendar.html">
                        <i class="fas fa-calendar-alt"></i>Calendario</a>
                </li>

                <li>
                    <a href="./rendimiento.html">
                        <i class="fas fa-chart-line"></i>Mi Rendimiento</a>
                </li>

                <li>
                    <a href="./cuenta.html">
                        <i class="far fa-user"></i>Mi Cuenta</a>
                </li>

                <li>
                    <a href="#">
                        <i class="fas fa-sign-out-alt"></i>Cerrar Sesi�n</a>
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
                        <img src="../img/user.png" class="ml-2" style="width: 30px;" alt=""> </span>

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
                    <span class="colorGlobal">Formulario</span>
                </div>
            </div>
            <!-- Jumbotron Titulo -->

            <div class="jumbotron jumbotron-fluid p-2">
                <div class="container">
                    <h1 class="display-4 tituloPacientes text-center m-0">Formato de Control Preconsulta Mama</h1>
                </div>
            </div>

            <div class="card mt-3">
                <div class="card-body p-4">

                    <div class="row justify-content-center">
                        <div class="col-10">

                            <!-- FORMULARIO -->
                            <!-- <form> -->

                            <!-- PANTALLA 1 -->

                            <div id="pantalla1">
                                <!-- ***** PRZ ***** -->
                            <form>
                                <div class="form-group row mt-4">

                                    <div class="col-6">
                                        <label for="">PRZ</label>
                                        <div class="input-group mb-2">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text">
                                                    <i class="fas fa-file-alt"></i>
                                                </div>
                                            </div>
                                            <input name="prz-expediente" type="text" class="form-control" id="prz-expediente" placeholder="Introduce PRZ">
                                        </div>
                                    </div>

                                    <div class="col-6">
                                        <label for="">M�dico Adscrito</label>
                                        <div class="input-group">
                                            <div class="input-group-append">
                                                <div class="input-group-text">
                                                    <i class="fas fa-user-md"></i>
                                                </div>
                                            </div>
                                            <select class="form-control" id="medico-adscrito">
                                                <option disabled selected>Seleccione un M�dico Adscrito</option>
                                                <option>Dr. Bargall�</option>
                                                <option>Dra. Esparza</option>
                                                <option>Dra. Shaw</option>
                                                <option>Dra. Stankov</option>
                                                <option>Dr. Robles</option>
                                                <option>Dr. V�zquez</option>
                                                <option>Dra. Villareal</option>
                                            </select>
                                        </div>
                                        <div class="form-check mt-2">
                                            <input name="noAdscrito" class="form-check-input" type="checkbox" value="" id="noAdscrito">
                                            <label class="form-check-label" for="defaultCheck1">
                                                No estuvo el m�dico adscrito
                                            </label>
                                        </div>
                                    </div>



                                </div>

                                <!-- ***** Tipo de paciente y Medico radiologo ***** -->
                                <div class="form-group row mt-4">

                                    <div class="col-6">
                                        <label for="">Tipo de paciente</label>
                                        <div class="input-group">
                                            <select class="form-control" id="tipoPaciente">
                                                <option disabled selected>Seleccione un tipo de paciente</option>
                                                <option>Primera vez</option>
                                                <option>Segunda opini�n</option>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="col-6">
                                        <label for="">M�dico Radi�logo</label>
                                        <div class="input-group">
                                            <div class="input-group-append">
                                                <div class="input-group-text">
                                                    <i class="fas fa-user-md"></i>
                                                </div>
                                            </div>
                                            <select class="form-control" id="medico-radiologo">
                                                <option disabled selected>Seleccione un Radiologo</option>
                                                <option>Dra. Patricia</option>
                                                <option>Dra. Lesvia</option>
                                                <option>Dra. Liliana</option>
                                                <option>Dra. Mara Gonz�lez</option>
                                                <option>Dra. Pav�n</option>
                                                <option value="otro">Otro</option>
                                            </select>

                                        </div>
                                        <div class="form-check mt-2">
                                            <input name="esSustituto" class="form-check-input" type="checkbox" value="" id="esSustituto">
                                            <label class="form-check-label" for="defaultCheck1">
                                                Sustituto
                                            </label>
                                        </div>
                                    </div>

                                </div>

                                <!-- Input Sustituto -->
                                <div class="row contenedor-sustituto justify-content-end">
                                    <div class="col-6">
                                        <input name="sustituto" type="text" class="mt-2 form-control">
                                    </div>
                                </div>

                                <!-- Fecha Navegaci�n -->
                                <div class="form-group row mt-4">

                                    <div class="col-6">
                                        <label for="">Fecha de navegaci�n</label>
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text">
                                                    <i class="fas fa-calendar-alt"></i>
                                                </div>
                                            </div>
                                            <input name= "fechaNavegacion" placeholder="Introduce la fecha de navegaci�n" class="selectStyle form-control textbox-n" type="text" onfocus="(this.type='date')"
                                                id="fechaNavegacion">
                                        </div>
                                    </div>


                                    <!-- M�dico residente -->
                                    <div class="col-6">
                                        <label for="">M�dico Residente</label>
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text">
                                                    <i class="fas fa-user-md"></i>
                                                </div>
                                            </div>
                                            <input name = "medico-residente" type="text" id="medico-residente" class="form-control" class="form-control" placeholder="Introduce M�dico Residente">
                                        </div>
                                    </div>

                                </div>

                                <!-- Fecha Consulta-->
                                <div class="form-group row mt-4 justify-content-center">

                                    <div class="col-12">
                                        <label for="">Fecha de consulta</label>
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text">
                                                    <i class="fas fa-calendar-alt"></i>
                                                </div>
                                            </div>
                                            <input nmae="fechaConsulta" placeholder="Introduce la fecha de consulta" class="selectStyle form-control textbox-n" type="text" onfocus="(this.type='date')"
                                                id="fechaConsulta">
                                        </div>
                                    </div>

                                </div>
                            </form>
                                <!-- Boton guardar y continuar -->
                                <div class="row justify-content-center mt-5">
                                    <div class="col-4">
                                        <button class="btn btn-outline-primary btn-block" style="border-radius:20px">
                                            <i class="fas fa-save mr-2" id="btn-save1"></i>Guardar y Continuar Despu�s</button>
                                    </div>
                                    <div class="col-4">
                                        <button class="btn btn-outline-success btn-block" id="btn-continue1" style="border-radius:20px">
                                            <i class="fas fa-arrow-circle-right mr-2"></i>Continuar</button>
                                    </div>
                                </div>
                                
                            </div>

                            <!-- PANTALLA 2 -->
                            <div id="pantalla2">
                            <form>
                                <!-- Nivel educativo-->
                                <div class="form-group row mt-3">

                                    <div class="col-6">
                                        <label for="">Nivel educativo</label>
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text">
                                                    <i class="fas fa-graduation-cap"></i>
                                                </div>
                                            </div>
                                            <select class="form-control" id="nivelEducativo">
                                                <option disabled selected>Seleccione un nivel educativo</option>
                                                <option>Analfabeta</option>
                                                <option>Primaria</option>
                                                <option>Primaria NT</option>
                                                <option>Secundaria</option>
                                                <option>Preparatoria</option>
                                                <option>Licenciatura</option>
                                                <option>Posgrado</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>

                                <!-- Alergias-->
                                <div class="form-group row mt-3">
                                    <div class="col-6">
                                        <label for="">Alergias</label>
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text">
                                                    <i class="fas fa-file-contract"></i>
                                                </div>
                                            </div>
                                            <input type="text" id="alergias" class="form-control" placeholder="Introduce las alergias separadas por comas ( , )">

                                        </div>
                                    </div>
                                </div>

                                <!-- Estado hormonal-->
                                <div class="form-group row mt-3">

                                    <div class="col-6">
                                        <label for="">Estado hormonal</label>
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text">
                                                    <i class="fas fa-thermometer-three-quarters"></i>
                                                </div>
                                            </div>
                                            <select class="form-control" id="nivelEducativo">
                                                <option disabled selected>Selecciona un estado hormonal</option>
                                                <option>Premenop�usica</option>
                                                <option>Postmenop�usica</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>

                                <!-- Seguro popular-->

                                <div class="form-group row mt-4">

                                    <div class="col-12">
                                        <div class="form-group form-check">
                                            <input type="checkbox" class="form-check-input" id="tieneSeguroPopular">
                                            <label class="form-check-label" for="tieneSeguroP">�Cuentas con alg�n seguro?
                                            </label>
                                        </div>
                                        <div class="input-group">
                                            <select class="form-control" id="tiene-seguro">
                                                <option disabled selected>Seleccione un seguro</option>
                                                <option value="seguroPopular">Seguro Popular</option>
                                                <option>IMSS</option>
                                                <option>ISSSTE</option>
                                                <option>PEMEX</option>
                                                <option>ISSFAM</option>
                                                <option>Particular</option>
                                                <option>Subrogados</option>

                                            </select>
                                        </div>
                                        <input type="text" id="numSeguro" class="form-control mt-2" placeholder="Introduce el numero de tu seguro">
                                    </div>


                                </div>

                                <!-- Mastografia y ultrasonido de mama -->
                                <div class="form-group row">

                                    <div class="col-12">
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="option1">
                                            <label class="form-check-label" for="inlineCheckbox1">Mastograf�a en el INCan
                                                antes de su primera cita</label>
                                        </div>
                                    </div>



                                </div>



                                <div class="row mb-3">
                                    <div class="col-12">
                                        <h6 class="display-4 text-secondary" style="font-size:26px;">Tratamiento previo:
                                        </h6>
                                    </div>
                                </div>

                                <!-- Cirugia -->

                                <div class="form-group row">
                                    <div class="col-12">
                                        <div class="form-group form-check">
                                            <input type="checkbox" class="form-check-input" id="tiene-cirugia">
                                            <label class="form-check-label" for="tiene-cirugia">Cirug�a</label>
                                        </div>
                                    </div>
                                </div>

                                <div id="divCirugia">

                                    <div class="row">
                                        <div class="input-group col-12">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text">
                                                    <i class="fas fa-calendar-alt"></i>
                                                </div>
                                            </div>
                                            <input placeholder="Introduce la fecha de cirug�a" class="selectStyle form-control textbox-n" type="text" onfocus="(this.type='date')"
                                                id="fecha-cirugia">
                                        </div>
                                    </div>

                                    <div class="row mt-3">
                                        <div class="col-12 input-group">
                                            <select class="form-control" id="cirugia">
                                                <option disabled selected>Introduce la cirug�a</option>
                                                <option>Mastectom�a</option>
                                                <option>Cirug�a conservadora</option>
                                                <option>Reconstrucci�n</option>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="row mt-3">
                                        <div class="col-12">
                                            <textarea style="min-height: 150px !important;" class="form-control" id="detalle-cirugia" placeholder="Escribe detalles del tratamiento"></textarea>
                                        </div>
                                    </div>

                                </div>

                                <!-- Quimioterapia -->

                                <div class="form-group row mt-3">
                                    <div class="col-12">
                                        <div class="form-group form-check">
                                            <input type="checkbox" class="form-check-input" id="tiene-quimioterapia">
                                            <label class="form-check-label" for="tiene-quimioterapia">Quimioterapia</label>
                                        </div>
                                    </div>
                                </div>

                                <div id="divQuimioterapia">

                                    <div class="row">
                                        <div class="input-group col-12">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text">
                                                    <i class="fas fa-calendar-alt"></i>
                                                </div>
                                            </div>
                                            <input placeholder="Introduce la fecha de quimioterapia" class="selectStyle form-control textbox-n" type="text" onfocus="(this.type='date')"
                                                id="fecha-quimioterapia">
                                        </div>
                                    </div>

                                    <div class="row mt-3">
                                        <div class="col-12 input-group">
                                            <input type="text" id="quimioterapia" class="form-control" class="form-control" placeholder="Introduce el n�mero de ciclos">
                                        </div>
                                    </div>

                                    <div class="row mt-3">
                                        <div class="col-12">
                                            <textarea style="min-height: 150px !important;" class="form-control" id="detalle-quimioterapia" placeholder="Escribe detalles del tratamiento"></textarea>
                                        </div>
                                    </div>

                                </div>

                                <!-- Radioterapia-->

                                <div class="form-group row mt-3">
                                    <div class="col-12">
                                        <div class="form-group form-check">
                                            <input type="checkbox" class="form-check-input" id="tiene-radioterapia">
                                            <label class="form-check-label" for="tiene-radioterapia">Radioterapia</label>
                                        </div>
                                    </div>
                                </div>

                                <div id="divRadioterapia">

                                    <div class="row">
                                        <div class="input-group col-12">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text">
                                                    <i class="fas fa-calendar-alt"></i>
                                                </div>
                                            </div>
                                            <input placeholder="Introduce la fecha de radioterapia" class="selectStyle form-control textbox-n" type="text" onfocus="(this.type='date')"
                                                id="fecha-radioterapia">
                                        </div>
                                    </div>

                                    <div class="row mt-3">
                                        <div class="col-12 input-group">
                                            <input type="text" id="radioterapia" class="form-control" class="form-control" placeholder="Introduce el n�mero de ciclos">
                                        </div>
                                    </div>

                                    <div class="row mt-3">
                                        <div class="col-12">
                                            <textarea style="min-height: 150px !important;" class="form-control" id="detalle-radioterapia" placeholder="Escribe detalles del tratamiento"></textarea>
                                        </div>
                                    </div>

                                </div>

                                <!-- Estudios previos -->

                                <div class="row mb-3">
                                    <div class="col-12">
                                        <h6 class="display-4 text-secondary" style="font-size:26px;">Estudios previos:
                                        </h6>
                                    </div>
                                </div>

                                <div class="form-group row">

                                    <div class="col-10 mt-2">
                                        <div class="form-group form-check">
                                            <input type="checkbox" class="form-check-input" id="tiene-mastografia">
                                            <label class="form-check-label" for="tiene-mastografia">Mastrograf�a</label>
                                        </div>
                                        <div class="input-group">
                                            <select class="form-control" id="tipoMastografia">
                                                <option disabled selected>Mastrograf�a BI-RADS</option>
                                                <option>BI-RADS 0</option>
                                                <option>BI-RADS 1</option>
                                                <option>BI-RADS 2</option>
                                                <option>BI-RADS 3</option>
                                                <option>BI-RADS 4</option>
                                                <option>BI-RADS 5</option>
                                                <option>BI-RADS 6</option>
                                            </select>

                                            <div class="input-group col-8" id="fechaMasto">
                                                <div class="input-group-prepend">
                                                    <div class="input-group-text">
                                                        <i class="fas fa-calendar-alt"></i>
                                                    </div>
                                                </div>
                                                <input placeholder="Introduce la fecha de mastograf�a" class="selectStyle form-control textbox-n" type="text" onfocus="(this.type='date')"
                                                    id="fechaPreMasto">
                                            </div>
                                        </div>



                                    </div>



                                    <div class="col-10 mt-3">
                                        <div class="form-group form-check">
                                            <input type="checkbox" class="form-check-input" id="tiene-ultrasonido-mama">
                                            <label class="form-check-label" for="tiene-ultrasonido-mama">Ultrasonido de mama</label>
                                        </div>
                                        <div class="input-group">
                                            <select class="form-control" id="tipoUltrasonidoMama">
                                                <option disabled selected>Ultrasonido Mama BI-RADS</option>
                                                <option>BI-RADS 0</option>
                                                <option>BI-RADS 1</option>
                                                <option>BI-RADS 2</option>
                                                <option>BI-RADS 3</option>
                                                <option>BI-RADS 4</option>
                                                <option>BI-RADS 5</option>
                                                <option>BI-RADS 6</option>
                                            </select>

                                            <div class="input-group col-8" id="fechaUsg">
                                                <div class="input-group-prepend">
                                                    <div class="input-group-text">
                                                        <i class="fas fa-calendar-alt"></i>
                                                    </div>
                                                </div>
                                                <input placeholder="Introduce la fecha de ultrasonido" class="selectStyle form-control textbox-n" type="text" onfocus="(this.type='date')"
                                                    id="fechaPreUsg">
                                            </div>
                                        </div>

                                    </div>

                                </div>



                                <!-- Resultado o reporte de patologia -->

                                <div class="row mt-4 mb-3">
                                    <div class="col-12">
                                        <h6 class="display-4 text-secondary" style="font-size:26px;">Resultado o reporte
                                            de patolog�a:</h6>
                                    </div>
                                </div>
                                <div class="input-group">
                                    <select class="form-control" id="resultadoAnterior-patologia">
                                        <option disabled selected>Seleccione Resultado Patolog�a:</option>
                                        <option>Carcinoma ductal in situ</option>
                                        <option>Carcinoma lobulillar in situ</option>
                                        <option>Carcinoma ductal infiltrante</option>
                                        <option>Carcinoma lobulillar infiltrante</option>
                                        <option>Carcinoma tubular</option>
                                        <option>Carcinoma mucinoso</option>
                                        <option>Carcinoma medular</option>
                                        <option>Carcinoma tubulolobulillar</option>
                                        <option>Carcinoma micropapilar</option>
                                        <option>Carcinoma metapl�sico</option>
                                        <option>Carcinoma adenoideo qu�stico</option>
                                        <option>Sarcoma</option>
                                        <option>Hiperplasia ductal con atipia</option>
                                        <option>Hiperplasia lobulillar con atipia</option>
                                        <option>Quiste no proliferativo</option>
                                        <option>Cambios papilares apocrinos</option>
                                        <option>Hiperplasia</option>
                                        <option>Papiloma intraductal</option>
                                        <option>Adenosis esclerosante</option>
                                        <option>Fibroadenoma simple</option>
                                        <option>Tumor phyllodes</option>
                                        <option value="Otro">Otro</option>
                                    </select>

                                </div>

                                <div class="form-group row mt-4" id="introducirOtroPatologia">
                                    <div class="col-12">
                                        <input type="text" class="form-control" placeholder="Introduce otro resultado">
                                    </div>
                                </div>

                                <!-- Entrega de laminillas y bloques -->

                                <div class="form-group row mt-4">
                                    <div class="col-12">
                                        <label class="d-block display-4 text-secondary mb-3" for=""><h6 style="font-size:26px;">Entrega:
                                            </h6></label>
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="checkbox" id="entregaLaminillas" value="laminillas">
                                            <label class="form-check-label" for="entregaLaminillas">Laminillas</label>
                                        </div>
                                    </div>
                                </div>

                                <div class="row" id="contenedor-laminillas">
                                    <div class="col-4">
                                        <input type="text" id="numLaminillas" class="form-control" placeholder="Introduce el n�mero">
                                    </div>
                                    <div class="col-6">
                                        <input type="text" id="serieLaminillas" class="form-control" placeholder="Identificadores separados por ( , )">
                                    </div>
                                </div>

                                <div class="form-group row mt-4">
                                    <div class="col-12">
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="checkbox" id="entregaBloques" value="laminillas">
                                            <label class="form-check-label" for="entregaBloques">Bloques de parafina</label>
                                        </div>
                                    </div>
                                </div>

                                <div class="row" id="contenedor-bloques">
                                    <div class="col-4">
                                        <input type="text" id="numBloques" class="form-control" class="form-control" placeholder="Introduce el n�mero">
                                    </div>
                                    <div class="col-6">
                                        <input type="text" id="serieBloques" class="form-control" placeholder="Identificadores separados por ( , )">
                                    </div>
                                </div>
                            </form>
                                <div class="row justify-content-center mt-5">
                                    <div class="col-4">
                                        <button class="btn btn-outline-danger btn-block" id="btn-back2" style="border-radius:20px">
                                            <i class="fas fa-undo mr-2"></i>Regresar</button>
                                    </div>
                                    <div class="col-4">
                                        <button class="btn btn-outline-primary btn-block" style="border-radius:20px">
                                            <i class="fas fa-save mr-2" id="btn-save2"></i>Guardar y Continuar Despu�s</button>
                                    </div>
                                </div>
                                <div class="row justify-content-center mt-2">
                                    <div class="col-8">
                                        <button class="btn btn-morado btn-block" id="btn-exportar1" style="border-radius:20px">
                                            <i class="fas fa-file-contract"></i> Generar Reporte</button>
                                    </div>
                                </div>
                                <div class="row justify-content-center mt-2">
                                    <div class="col-8">
                                        <button class="btn btn-outline-success btn-block" id="btn-continue2" style="border-radius:20px">
                                            <i class="fas fa-arrow-circle-right mr-2"></i>Continuar</button>
                                    </div>
                                </div>

                            </div>

                            <!-- PANTALLA 3 -->
                            <div id="pantalla3">
                            <form>
                                <div class="row justify-content-center">
                                    <div class="col-12 text-center">
                                        <p class="display-4 tituloPacientes">Estudios Preconsulta</p>
                                    </div>
                                </div>

                               

                                <!-- Biopsia -->

                                <!-- Checkbox biopsia -->
                                <div class="row mt-5 mb-3">
                                    <div class="col-12">
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="checkbox" id="tiene-biopsia">
                                            <label class="form-check-label" for="tiene-biopsia"> Biopsia</label>
                                        </div>
                                    </div>
                                </div>

                                <div id="biopsia-contenedor">

                                    <div class="form-group row mt-2" id="biopsiaInit">

                                        <!-- tipo biopsia -->
                                        <div class="col-3">
                                            <input type="text" class="form-control tipoBiopsia" placeholder="Tipo de biopsia">
                                        </div>

                                        <!-- fecha biopsia -->
                                        <div class="col-4">
                                            <div class="input-group">
                                                <div class="input-group-prepend">
                                                    <div class="input-group-text">
                                                        <i class="fas fa-calendar-alt"></i>
                                                    </div>
                                                </div>
                                                <input placeholder="Fecha de la biopsia" class="form-control fechaBiopsia" type="text" onfocus="(this.type='date')">
                                            </div>
                                        </div>

                                        <!-- parte del cuerpo -->
                                        <div class="col-3">
                                            <div class="input-group text-center">
                                                <div class="input-group-prepend">
                                                    <div class="input-group-text">
                                                        <i class="fas fa-hand-paper"></i>
                                                    </div>
                                                </div>
                                                <input type="text" class="form-control parteCuerpoBiopsia" placeholder="Parte del cuerpo">
                                            </div>
                                        </div>

                                        <!-- boton agregar biopsia -->
                                        <div class="col-2">
                                            <button type="button" class="btn btn-morado ml-2 add-biopsia" style="border-radius: 25px;">
                                                <i class="fas fa-plus"></i>
                                            </button>
                                        </div>


                                    </div>

                                </div>

                                <div class="row">
                                    <div class="col-12">
                                        <hr>
                                    </div>
                                </div>

                                <!-- Rayos X -->

                                <!-- Checkbox rayox x -->
                                <div class="row mt-5 mb-3">
                                    <div class="col-12">
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="checkbox" id="tiene-rayosX">
                                            <label class="form-check-label" for="tiene-rayosX"> Rayos X</label>
                                        </div>
                                    </div>
                                </div>

                                <div id="rayos-contenedor">

                                    <div class="form-group row mt-2" id="rayosInit">

                                        <!-- tipo rayos -->
                                        <div class="col-5">
                                            <input type="text" class="form-control tipoBiopsia" placeholder="Tipo de rayos X">
                                        </div>

                                        <!-- fecha rayos -->
                                        <div class="col-5">
                                            <div class="input-group">
                                                <div class="input-group-prepend">
                                                    <div class="input-group-text">
                                                        <i class="fas fa-calendar-alt"></i>
                                                    </div>
                                                </div>
                                                <input placeholder="Fecha de los Rayos X" class="form-control fechaRayos" type="text" onfocus="(this.type='date')">
                                            </div>
                                        </div>

                                        <!-- boton agregar rayos -->
                                        <div class="col-2">
                                            <button type="button" class="btn btn-morado ml-2 add-rayosX" style="border-radius: 25px;">
                                                <i class="fas fa-plus"></i>
                                            </button>
                                        </div>


                                    </div>

                                </div>


                                <div class="row">
                                    <div class="col-12">
                                        <hr>
                                    </div>
                                </div>

                                <!-- Ultrasonido -->

                                <div class="row mt-5 mb-3">
                                    <div class="col-12">
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="checkbox" id="tiene-ultrasonido">
                                            <label class="form-check-label" for="tiene-ultrasonido"> Ultrasonido</label>
                                        </div>
                                    </div>
                                </div>

                                <div id="ultrasonido-contenedor">

                                    <div class="form-group row mt-2" id="ultrasonidoInit">

                                        <!-- parte del cuerpo -->
                                        <div class="col-5">
                                            <input type="text" class="form-control parteCuerpoUltrasonido" placeholder="Parte del cuerpo">
                                        </div>

                                        <!-- fecha ultrasonido -->
                                        <div class="col-5">
                                            <div class="input-group">
                                                <div class="input-group-prepend">
                                                    <div class="input-group-text">
                                                        <i class="fas fa-calendar-alt"></i>
                                                    </div>
                                                </div>
                                                <input placeholder="Fecha de USG" class="form-control fechaUltrasonido" type="text" onfocus="(this.type='date')">
                                            </div>
                                        </div>

                                        <!-- boton agregar ultrasonido -->
                                        <div class="col-2">
                                            <button type="button" class="btn btn-morado ml-2 add-ultrasonido" style="border-radius: 25px;">
                                                <i class="fas fa-plus"></i>
                                            </button>
                                        </div>


                                    </div>

                                </div>


                                <div class="row">
                                    <div class="col-12">
                                        <hr>
                                    </div>
                                </div>

                                <!-- Medicina Nuclear -->

                                <div class="row mt-5 mb-3">
                                    <div class="col-12">
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="checkbox" id="tiene-medicina-nuclear">
                                            <label class="form-check-label" for="tiene-medicina-nuclear"> Medicina Nuclear</label>
                                        </div>
                                    </div>
                                </div>

                                <div id="medicinaNuclear-contenedor">

                                    <div class="form-group row mt-2" id="medicinaNuclearInit">

                                        <!-- medicina nuclear -->
                                        <div class="col-5">
                                            <input type="text" class="form-control medicinaNuclear" placeholder="Introduce medicina nuclear">
                                        </div>

                                        <!-- fecha medicina nuclear -->
                                        <div class="col-5">
                                            <div class="input-group">
                                                <div class="input-group-prepend">
                                                    <div class="input-group-text">
                                                        <i class="fas fa-calendar-alt"></i>
                                                    </div>
                                                </div>
                                                <input placeholder="Fecha de medicina nuclear" class="form-control fechaMedicinaNuclear" type="text" onfocus="(this.type='date')">
                                            </div>
                                        </div>

                                        <!-- boton agregar medicina nuclear -->
                                        <div class="col-2">
                                            <button type="button" class="btn btn-morado ml-2 add-medicinaNuclear" style="border-radius: 25px;">
                                                <i class="fas fa-plus"></i>
                                            </button>
                                        </div>


                                    </div>

                                </div>

                                <div class="row">
                                    <div class="col-12">
                                        <hr>
                                    </div>
                                </div>

                                <!-- Laboratorio -->

                                <div class="row mt-5 mb-3">
                                    <div class="col-12">
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="checkbox" id="tiene-laboratorio">
                                            <label class="form-check-label" for="tiene-laboratorio"> Laboratorio</label>
                                        </div>
                                    </div>
                                </div>

                                <div id="laboratorio-contenedor">

                                    <div class="form-group row mt-2" id="laboratorioInit">

                                        <!-- fecha laboratorio-->
                                        <div class="col-10">
                                            <div class="input-group">
                                                <div class="input-group-prepend">
                                                    <div class="input-group-text">
                                                        <i class="fas fa-calendar-alt"></i>
                                                    </div>
                                                </div>
                                                <input placeholder="Fecha de laboratorio" class="form-control fechaLaboratorio" type="text" onfocus="(this.type='date')">
                                            </div>
                                        </div>

                                        <!-- boton agregar laboratorio -->
                                        <div class="col-2">
                                            <button type="button" class="btn btn-morado ml-2 add-laboratorio" style="border-radius: 25px;">
                                                <i class="fas fa-plus"></i>
                                            </button>
                                        </div>


                                    </div>

                                </div>


                                <div class="row">
                                    <div class="col-12">
                                        <hr>
                                    </div>
                                </div>

                                <!-- Valoracion -->

                                <div class="row mt-5 mb-3">
                                    <div class="col-12">
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="checkbox" id="tiene-valoracion">
                                            <label class="form-check-label" for="tiene-valoracion"> Valoraci�n</label>
                                        </div>
                                    </div>
                                </div>

                                <div id="valoracion-contenedor">

                                    <div class="form-group row mt-2" id="valoracionInit">

                                        <!-- valoracion -->
                                        <div class="col-5">
                                            <input type="text" class="form-control valoracion" placeholder="Introduce valoraci�n">
                                        </div>

                                        <!-- fecha medicina valoracion -->
                                        <div class="col-5">
                                            <div class="input-group">
                                                <div class="input-group-prepend">
                                                    <div class="input-group-text">
                                                        <i class="fas fa-calendar-alt"></i>
                                                    </div>
                                                </div>
                                                <input placeholder="Fecha de valoraci�n" class="form-control fechaValoracion" type="text" onfocus="(this.type='date')">
                                            </div>
                                        </div>

                                        <!-- boton agregar medicina nuclear -->
                                        <div class="col-2">
                                            <button type="button" class="btn btn-morado ml-2 add-valoracion" style="border-radius: 25px;">
                                                <i class="fas fa-plus"></i>
                                            </button>
                                        </div>


                                    </div>

                                </div>

                                <div class="row">
                                    <div class="col-12">
                                        <hr>
                                    </div>
                                </div>

                                <!-- Espirometria -->

                                <div class="row mt-5 mb-3">
                                    <div class="col-12">
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="checkbox" id="tiene-espirometria">
                                            <label class="form-check-label" for="tiene-espirometria"> Espirometr�a/Inhaloterapia</label>
                                        </div>
                                    </div>
                                </div>

                                <div id="espirometria-contenedor">

                                    <div class="form-group row mt-2" id="espirometriaInit">

                                        <!-- fecha espirometria-->

                                        <div class="col-10">
                                            <div class="input-group">
                                                <div class="input-group-prepend">
                                                    <div class="input-group-text">
                                                        <i class="fas fa-calendar-alt"></i>
                                                    </div>
                                                </div>
                                                <input placeholder="Fecha de espirometr�a" class="form-control fechaEspirometria" type="text" onfocus="(this.type='date')">
                                            </div>
                                        </div>

                                        <!-- boton agregar espirometria -->

                                        <div class="col-2">
                                            <button type="button" class="btn btn-morado ml-2 add-espirometria" style="border-radius: 25px;">
                                                <i class="fas fa-plus"></i>
                                            </button>
                                        </div>


                                    </div>

                                </div>

                                <div class="row">
                                    <div class="col-12">
                                        <hr>
                                    </div>
                                </div>

                                <!-- Electrocardiograma -->

                                <div class="row mt-5 mb-3">
                                    <div class="col-12">
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="checkbox" id="tiene-electrocardiograma">
                                            <label class="form-check-label" for="tiene-electrocardiograma"> Electrocardiograma
                                                (ECG)
                                            </label>
                                        </div>
                                    </div>
                                </div>

                                <div id="electrocardiograma-contenedor">

                                    <div class="form-group row mt-2" id="electrocardiogramaInit">

                                        <!-- fecha electrocardiograma-->

                                        <div class="col-10">
                                            <div class="input-group">
                                                <div class="input-group-prepend">
                                                    <div class="input-group-text">
                                                        <i class="fas fa-calendar-alt"></i>
                                                    </div>
                                                </div>
                                                <input placeholder="Fecha de electrocardiograma" class="form-control fechaElectrocardiograma" type="text" onfocus="(this.type='date')">
                                            </div>
                                        </div>

                                        <!-- boton agregar electrocardiograma -->

                                        <div class="col-2">
                                            <button type="button" class="btn btn-morado ml-2 add-electrocardiograma" style="border-radius: 25px;">
                                                <i class="fas fa-plus"></i>
                                            </button>
                                        </div>


                                    </div>

                                </div>

                                <div class="row">
                                    <div class="col-12">
                                        <hr>
                                    </div>
                                </div>


                                <!-- Ecocardiograma -->

                                <div class="row mt-5 mb-3">
                                    <div class="col-12">
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="checkbox" id="tiene-ecocardiograma">
                                            <label class="form-check-label" for="tiene-ecocardiograma"> Ecocardiograma</label>
                                        </div>
                                    </div>
                                </div>

                                <div id="ecocardiograma-contenedor">

                                    <div class="form-group row mt-2" id="ecocardiogramaInit">

                                        <!-- fecha ecocardiograma-->

                                        <div class="col-10">
                                            <div class="input-group">
                                                <div class="input-group-prepend">
                                                    <div class="input-group-text">
                                                        <i class="fas fa-calendar-alt"></i>
                                                    </div>
                                                </div>
                                                <input placeholder="Fecha de ecocardiograma" class="form-control fechaEcocardiograma" type="text" onfocus="(this.type='date')">
                                            </div>
                                        </div>

                                        <!-- boton agregar ecocardiograma -->

                                        <div class="col-2">
                                            <button type="button" class="btn btn-morado ml-2 add-ecocardiograma" style="border-radius: 25px;">
                                                <i class="fas fa-plus"></i>
                                            </button>
                                        </div>


                                    </div>

                                </div>

                                <div class="row">
                                    <div class="col-12">
                                        <hr>
                                    </div>
                                </div>

                                <!-- Trabajo Social-->

                                <div class="row mt-5 mb-3">
                                    <div class="col-12">
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="checkbox" id="tiene-trabajo-social">
                                            <label class="form-check-label" for="tiene-trabajo-social"> Trabajo Social</label>
                                        </div>
                                    </div>
                                </div>


                                <div id="trabajoSocial-contenedor">

                                    <div class="form-group row mt-2" id="trabajoSocialInit">

                                        <!-- fecha trabajo social-->

                                        <div class="col-10">
                                            <div class="input-group">
                                                <div class="input-group-prepend">
                                                    <div class="input-group-text">
                                                        <i class="fas fa-calendar-alt"></i>
                                                    </div>
                                                </div>
                                                <input placeholder="Fecha de trabajo social" class="form-control fechaTrabajoSocial" type="text" onfocus="(this.type='date')">
                                            </div>
                                        </div>

                                        <!-- boton agregar trabajo social -->

                                        <div class="col-2">
                                            <button type="button" class="btn btn-morado ml-2 add-trabajoSocial" style="border-radius: 25px;">
                                                <i class="fas fa-plus"></i>
                                            </button>
                                        </div>


                                    </div>

                                </div>

                                <div class="row">
                                    <div class="col-12">
                                        <hr>
                                    </div>
                                </div>

                                <!-- Programas -->

                                <div class="row mt-5 mb-3">
                                    <div class="col-12">
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="checkbox" id="tiene-programa">
                                            <label class="form-check-label" for="tiene-programa"> Programa</label>
                                        </div>
                                    </div>
                                </div>

                                <div id="programa-contenedor">

                                    <div class="form-group row mt-2" id="programaInit">

                                        <!-- programas -->

                                        <div class="col-5">
                                            <input type="text" id="tipoPrograma" class="form-control" placeholder="Introduce programa">
                                        </div>

                                        <!-- fecha programa -->

                                        <div class="col-5">
                                            <div class="input-group">
                                                <div class="input-group-prepend">
                                                    <div class="input-group-text">
                                                        <i class="fas fa-calendar-alt"></i>
                                                    </div>
                                                </div>
                                                <input placeholder="Fecha del programa" class="form-control fechaPrograma" type="text" onfocus="(this.type='date')">
                                            </div>
                                        </div>

                                        <!-- boton agregar programa -->

                                        <div class="col-2">
                                            <button type="button" class="btn btn-morado ml-2 add-programa" style="border-radius: 25px;">
                                                <i class="fas fa-plus"></i>
                                            </button>
                                        </div>


                                    </div>

                                </div>


                                <div class="row">
                                    <div class="col-12">
                                        <hr>
                                    </div>
                                </div>

                                <!-- Otro -->

                                <div class="row mt-5 mb-3">
                                    <div class="col-12">
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="checkbox" id="tiene-otro">
                                            <label class="form-check-label" for="tiene-otro"> Otro</label>
                                        </div>
                                    </div>
                                </div>

                                <div id="otro-contenedor">

                                    <div class="form-group row mt-2" id="otroInit">

                                        <!-- fecha otro -->

                                        <div class="col-5">
                                            <div class="input-group">
                                                <div class="input-group-prepend">
                                                    <div class="input-group-text">
                                                        <i class="fas fa-calendar-alt"></i>
                                                    </div>
                                                </div>
                                                <input placeholder="Fecha de otro" class="form-control fechaOtro" type="text" onfocus="(this.type='date')">
                                            </div>
                                        </div>

                                        <div class="col-5">
                                            <input type="text" class="form-control otro-estudioPreconsulta" placeholder="Introduce otro">
                                        </div>

                                        <!-- boton agregar otro -->

                                        <div class="col-2">
                                            <button type="button" class="btn btn-morado ml-2 add-otro" style="border-radius: 25px;">
                                                <i class="fas fa-plus"></i>
                                            </button>
                                        </div>


                                    </div>

                                </div>

                            </form>
                                <div class="row justify-content-center mt-5">
                                    <div class="col-4">
                                        <button class="btn btn-outline-danger btn-block" id="btn-back3" style="border-radius:20px">
                                            <i class="fas fa-undo mr-2"></i>Regresar</button>
                                    </div>
                                    <div class="col-4">
                                        <button class="btn btn-outline-primary btn-block" style="border-radius:20px">
                                            <i class="fas fa-save mr-2" id="btn-save3"></i>Guardar y Continuar Despu�s</button>
                                    </div>
                                    <div class="col-4">
                                        <button class="btn btn-outline-success btn-block" id="btn-continue3" style="border-radius:20px">
                                            <i class="fas fa-arrow-circle-right mr-2"></i>Continuar</button>
                                    </div>
                                </div>

                            </div>

                            <div id="pantalla4">
                            <form>    
                                <div class="row mt-4">
                                    <div class="col-12">
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input mr-3" type="checkbox" id="resultadosCheckbox" value="option1">
                                            <label class="form-check-label" for="resultadosCheckbox">Resultados</label>
                                        </div>
                                    </div>
                                </div>
                                
                                <div class="form-group row mt-4">

                                    <div class="col-3">
                                        <span>Decisi�n preconsulta</span>
                                    </div>

                                    <div class="col-4">

                                        <div class="input-group">
                                            <select class="form-control" id="exampleFormControlSelect1">
                                                <option disabled selected>Seleccione la decisi�n</option>
                                                <option>Unidad funcional</option>
                                                <option>Alta</option>
                                                <option>Alta voluntaria</option>
                                                <option>Finada</option>
                                                <option>Perdida</option>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="col-5">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text">
                                                    <i class="fas fa-calendar-alt"></i>
                                                </div>
                                            </div>
                                            <input placeholder="Fecha decisi�n" class="selectStyle form-control textbox-n" type="text" onfocus="(this.type='date')" id="fecha-decisionPreconsulta">
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group row mt-4">

                                        <div class="col-3">
                                            <span>Nivel socioecon�mico</span>
                                        </div>
    
                                        <div class="col-4">
    
                                            <div class="input-group">
                                                <select class="form-control" id="exampleFormControlSelect1">
                                                    <option disabled selected>Seleccione el nivel socioecon�mico</option>
                                                    <option>1</option>
                                                    <option>2</option>
                                                    <option>3</option>
                                                    <option>4</option>
                                                    <option>5</option>
                                                    <option>6</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>

                                <div class="form-group row mt-4">
                                    <div class="col-3">
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input mr-3" type="checkbox" id="seLlamo" value="option1">
                                            <label class="form-check-label" for="inlineCheckbox1">Llamada al paciente</label>
                                        </div>
                                    </div>

                                </div>

                                <div class="llamadaInit">

                                    <div>
                                        <div class="row">
                                            <div class="col-12">
                                                <div class="input-group">
                                                    <div class="input-group-prepend">
                                                        <div class="input-group-text">
                                                            <i class="fas fa-calendar-alt"></i>
                                                        </div>
                                                    </div>
                                                    <input placeholder="Fecha llamada" class="form-control fecha-llamada" type="text" onfocus="(this.type='date')">
                                                    <button type="button" class="btn btn-morado ml-3 add-llamada" style="border-radius: 25px;">
                                                        <i class="fas fa-plus"></i>
                                                    </button>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="row mt-3">
                                            <div class="col-12">
                                                <textarea class="form-control" style="min-height:100px;" placeholder="Introduce el motivo de la llamada "></textarea>
                                            </div>
                                        </div>
                                    </div>

                                </div>

                                <!-- <div id="datosLlamada">
                    s                <div class="col-5" id="fechaLlamada">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text">
                                                    <i class="fas fa-calendar-alt"></i>
                                                </div>
                                            </div>
                                            <input placeholder="Fecha llamada" class="selectStyle form-control textbox-n" type="text" onfocus="(this.type='date')" id="fecha-llamada">
                                            <button type="button" id="add-datosLlamada" class="btn btn-primary ml-3" style="border-radius: 25px;">
                                                <i class="fas fa-plus-circle"></i>
                                            </button>
                                        </div>
                                    </div>


                                    <div class="form-group row">
                                        <div class="col-12 m-3">
                                            <textarea class="form-control" id="motivoLlamada" style="min-height:100px;" placeholder="Introduce el motivo de la llamada "></textarea>
                                        </div>
                                    </div>
                                </div> -->


                                <div class="row mt-3 mb-3">
                                    <div class="col-12">
                                        <h6 class="display-4 text-secondary" style="font-size:26px;">Comentarios y reporte
                                            de incidencias:</h6>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <div class="col-12">
                                        <textarea class="form-control" id="exampleFormControlTextarea1" style="min-height:200px;" placeholder="Introduce comentarios "></textarea>
                                    </div>
                                </div>

                                <div class="row mt-5 mb-3">
                                    <div class="col-12">
                                        <h6 class="display-4 text-secondary" style="font-size:26px;">Comentarios adicionales
                                            del m�dico:</h6>
                                    </div>
                                </div>
                        </form>
                                <div class="form-group row">
                                    <div class="col-12">
                                        <textarea class="form-control" id="exampleFormControlTextarea1" style="min-height:200px;" placeholder="Introduce comentarios adicionales"></textarea>
                                    </div>
                                </div>

                                <div class="row justify-content-center mt-5">
                                    <div class="col-4">
                                        <button class="btn btn-outline-danger btn-block" id="btn-back4" style="border-radius:20px">
                                            <i class="fas fa-undo mr-2"></i>Regresar</button>
                                    </div>
                                    <div class="col-4">
                                        <button class="btn btn-outline-primary btn-block" style="border-radius:20px">
                                            <i class="fas fa-save mr-2" id="btn-save4"></i>Guardar y Continuar Despu�s</button>
                                    </div>
                                    <div class="col-4">
                                        <button class="btn btn-outline-success btn-block" id="btn-continue4" style="border-radius:20px">
                                            <i class="fas fa-arrow-circle-right mr-2"></i>Continuar</button>
                                    </div>
                                </div>



                            </div>

                            <!-- PANTALLA 5 -->
                            <div id="pantalla5">

                            <form>    
                                <div class="form-group row mt-4">

                                    <div class="col-12">
                                        <div class="form-group">

                                            <label class="form-check-label" for="etapaClinica">Etapa Cl�nica</label>
                                        </div>
                                        <div class="input-group">
                                            <select class="form-control" id="estapaClinica">
                                                <option disabled selected>Seleccione etapa cl�nica</option>
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

                                    <div class="col-6 mt-4">
                                        <label for="">Resultados de mastograf�a</label>
                                        <div class="input-group">
                                            <select class="form-control" id="tipoMastografia">
                                                <option disabled selected>Mastrograf�a BI-RADS</option>
                                                <option>BI-RADS 0</option>
                                                <option>BI-RADS 1</option>
                                                <option>BI-RADS 2</option>
                                                <option>BI-RADS 3</option>
                                                <option>BI-RADS 4</option>
                                                <option>BI-RADS 5</option>
                                                <option>BI-RADS 6</option>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="col-6 mt-4">
                                        <label for="">Resultados del ultrasonido</label>
                                        <div class="input-group">
                                            <select class="form-control" id="tipoMastografia">
                                                <option disabled selected>Mastrograf�a BI-RADS</option>
                                                <option>BI-RADS 0</option>
                                                <option>BI-RADS 1</option>
                                                <option>BI-RADS 2</option>
                                                <option>BI-RADS 3</option>
                                                <option>BI-RADS 4</option>
                                                <option>BI-RADS 5</option>
                                                <option>BI-RADS 6</option>
                                            </select>
                                        </div>
                                    </div>

                                </div>

                                <div class="row mt-5 mb-3">
                                    <div class="col-12">
                                        <h6 class="display-4 text-secondary" style="font-size:26px;">TNM:</h6>
                                    </div>
                                </div>

                                <div class="form-group row">

                                    <div class="col-4">
                                        <div class="form-group">

                                            <label class="form-check-label" for="etapaClinica">T:</label>
                                        </div>
                                        <div class="input-group">
                                            <select class="form-control" id="tumorPrimarioT">
                                                <option disabled selected>Seleccione T:</option>
                                                <option>Tx</option>
                                                <option>T0</option>
                                                <option>Tis</option>
                                                <option>T1mi</option>
                                                <option>T1a</option>
                                                <option>T1b</option>
                                                <option>T1c</option>
                                                <option>T2</option>
                                                <option>T3</option>
                                                <option>T4a</option>
                                                <option>T4b</option>
                                                <option>T4c</option>
                                                <option>T4d</option>
                                            </select>
                                        </div>

                                    </div>

                                    <div class="col-4">
                                        <div class="form-group">

                                            <label class="form-check-label" for="etapaClinica">N:</label>
                                        </div>
                                        <div class="input-group">
                                            <select class="form-control" id="gangliosN">
                                                <option disabled selected>Seleccione N:</option>
                                                <option>N0</option>
                                                <option>N1</option>
                                                <option>N1 mi</option>
                                                <option>N2a</option>
                                                <option>N2b</option>
                                                <option>N3a</option>
                                                <option>N3b</option>
                                                <option>N3c</option>
                                                <option>Nx</option>
                                            </select>
                                        </div>

                                    </div>

                                    <div class="col-4">
                                        <div class="form-group">

                                            <label class="form-check-label" for="etapaClinica">M:</label>
                                        </div>
                                        <div class="input-group">
                                            <select class="form-control" id="metastasisM">
                                                <option disabled selected>Seleccione M:</option>
                                                <option>M0</option>
                                                <option>M1</option>
                                                <option>Mx</option>
                                            </select>
                                        </div>

                                    </div>

                                </div>

                                <div class="form-group row mt-4">

                                    <div class="col-6">
                                        <div class="form-group">

                                            <label class="form-check-label" for="etapaClinica">Resultado Patolog�a:</label>
                                        </div>
                                        <div class="input-group">
                                            <select class="form-control" id="resultado-patologia">
                                                <option disabled selected>Seleccione Resultado Patolog�a:</option>
                                                <option>Carcinoma ductal in situ</option>
                                                <option>Carcinoma lobulillar in situ</option>
                                                <option>Carcinoma ductal infiltrante</option>
                                                <option>Carcinoma lobulillar infiltrante</option>
                                                <option>Carcinoma tubular</option>
                                                <option>Carcinoma mucinoso</option>
                                                <option>Carcinoma medular</option>
                                                <option>Carcinoma tubulolobulillar</option>
                                                <option>Carcinoma micropapilar</option>
                                                <option>Carcinoma metapl�sico</option>
                                                <option>Carcinoma adenoideo qu�stico</option>
                                                <option>Sarcoma</option>
                                                <option>Hiperplasia ductal con atipia</option>
                                                <option>Hiperplasia lobulillar con atipia</option>
                                                <option>Quiste no proliferativo</option>
                                                <option>Cambios papilares apocrinos</option>
                                                <option>Hiperplasia</option>
                                                <option>Papiloma intraductal</option>
                                                <option>Adenosis esclerosante</option>
                                                <option>Fibroadenoma simple</option>
                                                <option>Tumor phyllodes</option>
                                                <option value="Otro">Otro</option>
                                            </select>

                                        </div>

                                    </div>
                                    <div class="col-6">
                                        <div class="form-group">

                                            <label class="form-check-label" for="etapaClinica">Grado Histol�gico:</label>
                                        </div>
                                        <div class="input-group">
                                            <select class="form-control" id="grado-histologico">
                                                <option disabled selected>Seleccione Grado Histol�gico:</option>
                                                <option>G1</option>
                                                <option>G2</option>
                                                <option>G3</option>
                                                <option>Gx</option>
                                            </select>
                                        </div>

                                    </div>
                                </div>

                                <div class="form-group row mt-4" id="introducirOtro">
                                    <div class="col-6">
                                        <input type="text" class="form-control" placeholder="Introduce otro resultado">
                                    </div>
                                </div>

                                <div class="form-group row mt-4">

                                    <div class="col-4">
                                        <div class="form-group">

                                            <label class="form-check-label" for="etapaClinica">Her2:</label>
                                        </div>
                                        <div class="input-group">
                                            <select class="form-control" id="receptor-her2">
                                                <option disabled selected>Seleccione Her2:</option>
                                                <option>+</option>
                                                <option>++</option>
                                                <option>+++</option>
                                                <option>?</option>
                                            </select>
                                        </div>

                                    </div>

                                    <div class="col-4">
                                        <div class="form-group">

                                            <label class="form-check-label" for="etapaClinica">Fish:</label>
                                        </div>
                                        <div class="input-group">
                                            <select class="form-control" id="receptor-fish">
                                                <option disabled selected>Seleccione Fish:</option>
                                                <option>+</option>
                                                <option>-</option>
                                                <option>?</option>
                                            </select>
                                        </div>

                                    </div>

                                    <div class="col-4">
                                        <div class="form-group">

                                            <label class="form-check-label" for="etapaClinica">RE:</label>
                                        </div>
                                        <div class="input-group">
                                            <select class="form-control" id="receptor-re">
                                                <option disabled selected>Seleccione RE:</option>
                                                <option>+</option>
                                                <option>-</option>
                                                <option>?</option>
                                            </select>
                                        </div>

                                    </div>

                                    <div class="col-6 mt-3">
                                        <div class="form-group">

                                            <label class="form-check-label" for="etapaClinica">RP:</label>
                                        </div>
                                        <div class="input-group">
                                            <select class="form-control" id="receptor-rp">
                                                <option disabled selected>Seleccione RP:</option>
                                                <option>+</option>
                                                <option>-</option>
                                                <option>?</option>
                                            </select>
                                        </div>

                                    </div>

                                    <div class="col-6 mt-3">
                                        <div class="form-group">

                                            <label class="form-check-label" for="etapaClinica">Ki67:</label>
                                        </div>
                                        <div class="input-group">
                                            <input type="text" class="form-control" id="ki67" placeholder="Introduce Ki67">
                                            <label type="text" class="ml-2 mt-2">%</label>
                                        </div>

                                    </div>

                                </div>
                            </form>    
                                <div class="row justify-content-center mt-5">
                                    <div class="col-4">
                                        <button class="btn btn-outline-danger btn-block" id="btn-back5" style="border-radius:20px">
                                            <i class="fas fa-undo mr-2"></i>Regresar</button>
                                    </div>
                                    <div class="col-4">
                                        <button class="btn btn-outline-primary btn-block" style="border-radius:20px">
                                            <i class="fas fa-save mr-2" id="btn-save4"></i>Guardar y Continuar Despu�s</button>
                                    </div>

                                </div>

                                <div class="row justify-content-center mt-3">
                                    <div class="col-8">
                                        <button class="btn btn-morado btn-block" id="btn-export2" style="border-radius:20px">
                                            <i class="fas fa-file-contract"></i> Generar Reporte</button>
                                    </div>
                                </div>

                                <div class="row justify-content-center mt-3">
                                    <div class="col-8">
                                        <button class="btn btn-outline-success btn-block" id="btn-sendAll" style="border-radius:20px">
                                            <i class="fas fa-check-circle mr-2"></i>Enviar</button>
                                    </div>
                                </div>

                            </div>
                      
                           

                        </div>
                    </div>



                </div>
            </div>

        </div>
    </div>

</body>

</html>