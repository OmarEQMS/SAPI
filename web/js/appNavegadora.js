$(document).ready(function () {
    

    //Esconder seguros, mastrografía, ultrasonido y tratamientos en la segunda hoja de la pantalla 2
    $('#tiene-seguro').hide();
    $('#tipoMastografia').hide();
    $('#fechaMasto').hide();
    $('#tipoUltrasonidoMama').hide();
    $('#fechaUsg').hide();

    $('#fechaLlamada').hide();
    $('#motivoLlamada').hide();

    // Inicializar plug in tooltipster
    $('.questionMark').tooltipster({
        theme: 'tooltipster-shadow',
        delay: '140'
    });

    $('[data-toggle="tooltip"]').tooltipster({
        theme: 'tooltipster-shadow',
        delay: '140'
    });

    //Lamiillas
    oculta($('#contenedor-laminillas'));
    oculta($('#contenedor-bloques'));


    $('#plusType').hide();
    $('#plusDate').hide();
    $('#plusBodyPart').hide();

    $('#plusTypeRayos').hide();
    $('#plusDateRayos').hide();

    $('#divCirugia').hide();
    $('#divQuimioterapia').hide();
    $('#divRadioterapia').hide();

    //Esconder Biopsia, Rayos x, Ultrasonido, Medicina Nuclear, Valoración, Espirometria
    // Electro cardiograma, laboratorio, ecocardiograma, trabajo social, programas
    // otros de la Pantalla 3

    oculta($('#biopsiaInit'));
    oculta($('#rayosInit'));
    oculta($('#ultrasonidoInit'));
    oculta($('#medicinaNuclearInit'));
    oculta($('#laboratorioInit'));
    oculta($('#valoracionInit'));
    oculta($('#espirometriaInit'));
    oculta($('#electrocardiogramaInit'));
    oculta($('#ecocardiogramaInit'));
    oculta($('#trabajoSocialInit'));
    oculta($('#programaInit'));
    oculta($('#otroInit'));


    //medico sustituto
    oculta($('.contenedor-sustituto'));

    oculta($('.llamadaInit'));


    //Esconder menu lateral a presionar click en el menu hamburguesa
    $('#sidebarCollapse').on('click', () => {
        $('#sidebar, #content').toggleClass('active');
        $('.collapse.in').toggleClass('in');
        $('a[aria-expanded=true]').attr('aria-expanded', 'false');
    });

    $('[data-toggle="tooltip"]').tooltipster({
        theme: 'tooltipster-shadow',
        delay: '140'
    });

    $('[data-toggle="tooltip"]').tooltipster({
        theme: 'tooltipster-shadow',
        delay: '140'
    });


    //Cambiar de color los botones del calendario y varios textos
    $('.fc-agendaWeek-button').removeClass('btn-primary').addClass('btn-outline-danger');
    $('.fc-month-button').removeClass('btn-primary').addClass('btn-outline-danger');
    $('.fc-agendaDay-button').removeClass('btn-primary').addClass('btn-outline-danger');
    $('.fc-prev-button').removeClass('btn-primary').addClass('btn-outline-danger');
    $('.fc-next-button').removeClass('btn-primary').addClass('btn-outline-danger');
    $('.fc-today-button').removeClass('btn-primary').addClass('btn-outline-danger');
    $('.fc-right h2').addClass('display-4').css({'color': '#696f71', 'font-size': '30px'});


    

    //Cambiar de color los botones del calendario y varios textos
    $('.fc-agendaWeek-button').removeClass('btn-primary').addClass('btn-outline-danger');
    $('.fc-month-button').removeClass('btn-primary').addClass('btn-outline-danger');
    $('.fc-agendaDay-button').removeClass('btn-primary').addClass('btn-outline-danger');
    $('.fc-prev-button').removeClass('btn-primary').addClass('btn-outline-danger');
    $('.fc-next-button').removeClass('btn-primary').addClass('btn-outline-danger');
    $('.fc-today-button').removeClass('btn-primary').addClass('btn-outline-danger');
    $('.fc-right h2').addClass('display-4').css({'color': '#696f71', 'font-size': '30px'});

    var pantalla1 = $('#pantalla1');
    var pantalla2 = $('#pantalla2');
    var pantalla3 = $('#pantalla3');
    var pantalla4 = $('#pantalla4');
    var pantalla5 = $('#pantalla5');


    oculta(pantalla2);
    oculta(pantalla3);
    oculta(pantalla4);
    oculta(pantalla5);

    //ocultar campo de resultado de patologia
    oculta($('#introducirOtro'));
    oculta($('#introducirOtroPatologia'));
    oculta($('#numSeguro'));


    $('#tabla1').DataTable({
        responsive: true,
        searching: true,
        dom: 'lBfrtip',
        buttons: [

            {
                extend: 'excel',
                text: 'Exportar a Excel',
                className: 'btn-outline-success mr-3 btnExcel mt-3'
            },
            {
                extend: 'pdf',
                text: 'Exportar a pdf',
                className: 'btn-outline-info mr-3 btnPDF mt-3 '
            }
        ],
        "language": {

            "sProcessing": "Procesando...",
            "sLengthMenu": "Mostrar _MENU_ registros",
            "sZeroRecords": "No se encontraron resultados",
            "sEmptyTable": "Ningún dato disponible en esta tabla",
            "sInfo": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_",
            "sInfoEmpty": "Mostrando registros del 0 al 0 de un total de 0",
            "sInfoFiltered": "(filtrado de un total de _MAX_ registros)",
            "sInfoPostFix": "",
            "sSearch": "Buscar:",
            "sUrl": "",
            "sInfoThousands": ",",
            "sLoadingRecords": "Cargando...",
            "oPaginate": {
                "sFirst": "Primero",
                "sLast": "Último",
                "sNext": "Siguiente",
                "sPrevious": "Anterior"
            },
            "oAria": {
                "sSortAscending": ": Activar para ordenar la columna de manera ascendente",
                "sSortDescending": ": Activar para ordenar la columna de manera descendente"
            }

        }
    });


    $('#tabla2').DataTable({

        responsive: true,
        dom: 'lBfrtip',
        buttons: [

            {
                extend: 'excel',
                text: 'Exportar a Excel',
                className: 'btn-outline-success mr-3 btnExcel mt-3'
            },
            {
                extend: 'pdf',
                text: 'Exportar a pdf',
                className: 'btn-outline-info mr-3 btnPDF mt-3 '
            }
        ],
        searching: true,
        "language": {

            "sProcessing": "Procesando...",
            "sLengthMenu": "Mostrar _MENU_ registros",
            "sZeroRecords": "No se encontraron resultados",
            "sEmptyTable": "Ningún dato disponible en esta tabla",
            "sInfo": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_",
            "sInfoEmpty": "Mostrando registros del 0 al 0 de un total de 0",
            "sInfoFiltered": "(filtrado de un total de _MAX_ registros)",
            "sInfoPostFix": "",
            "sSearch": "Buscar:",
            "sUrl": "",
            "sInfoThousands": ",",
            "sLoadingRecords": "Cargando...",
            "oPaginate": {
                "sFirst": "Primero",
                "sLast": "Último",
                "sNext": "Siguiente",
                "sPrevious": "Anterior"
            },
            "oAria": {
                "sSortAscending": ": Activar para ordenar la columna de manera ascendente",
                "sSortDescending": ": Activar para ordenar la columna de manera descendente"
            }

        }

    });

    //append y prepend
    $('.btnExcel').prepend("<i class='fas fa-file-excel mr-1'></i>");
    $('.btnPDF').prepend("<i class='far fa-file-pdf mr-1'></i>");

    $('#tArchivos').DataTable({
        ordering: false, //Para cuestiones visuales...sí pero esto NO SE QUEDA ASÍ
        searching: true,
        "language": {

            "sProcessing": "Procesando...",
            "sLengthMenu": "Mostrar _MENU_ registros",
            "sZeroRecords": "No se encontraron resultados",
            "sEmptyTable": "Ningún dato disponible en esta tabla",
            "sInfo": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_",
            "sInfoEmpty": "Mostrando registros del 0 al 0 de un total de 0",
            "sInfoFiltered": "(filtrado de un total de _MAX_ registros)",
            "sInfoPostFix": "",
            "sSearch": "Buscar:",
            "sUrl": "",
            "sInfoThousands": ",",
            "sLoadingRecords": "Cargando...",
            "oPaginate": {
                "sFirst": "Primero",
                "sLast": "Último",
                "sNext": "Siguiente",
                "sPrevious": "Anterior"
            },
            "oAria": {
                "sSortAscending": ": Activar para ordenar la columna de manera ascendente",
                "sSortDescending": ": Activar para ordenar la columna de manera descendente"
            }

        }

    });
    $("body").on("click", ".clearModalAceptarUsuario", function () {
        $("#Fecha-Navegacion").attr("type", "text").val('').attr("placeholder", "Fecha navegación");
        $("#Fecha-Consulta").attr("type", "text").val('').attr("placeholder", "Fecha consulta");
        $("#tipo-paciente").prop('selectedIndex', 0);
    });
    
    //Limpiar campos
    $("body").on("click", ".clearAddPacientesModal", function () {

        $('#nombrePaciente').val("");
        $('#nombrePaciente').css('border', '');
        $('#nombrePaciente').css('color', '');

        $('#curpPaciente').val("");
        $('#curpPaciente').css('border', '');
        $('#curpPaciente').css('color', '');

        $("#cumplePaciente").attr("type", "text").val('').attr("placeholder", "Fecha de nacimiento");
        $('#cumplePaciente').css('border', '');
        $('#cumplePaciente').css('color', '');

        $('#primer-apellidoPaciente').val("");
        $('#primer-apellidoPaciente').css('border', '');
        $('#primer-apellidoPaciente').css('color', '');

        $('#segundo-apellidoPaciente').val("");
        $('#segundo-apellidoPaciente').css('border', '');
        $('#segundo-apellidoPaciente').css('color', '');
        
        $('#codigo-postalPaciente').val("");
        $('#codigo-postalPaciente').css('border', '');
        $('#codigo-postalPaciente').css('color', '');

        $('#usuarioPaciente').val("");
        $('#usuarioPaciente').css('border', '');
        $('#usuarioPaciente').css('color', '');

        $("#estado-civilPaciente").prop('selectedIndex', 0);
        $('#estado-civilPaciente').css('border', '');
        $('#estado-civilPaciente').css('color', '');

        $('#colPaciente').val("");
        $('#colPaciente').css('border', '');
        $('#colPaciente').css('color', '');

        $('#callePaciente').val("");
        $('#callePaciente').css('border', '');
        $('#callePaciente').css('color', '');

        $('#numIntPaciente').val("");
        $('#numIntPaciente').css('border', '');
        $('#numIntPaciente').css('color', '');

        $('#numExtPaciente').val("");
        $('#numExtPaciente').css('border', '');
        $('#numExtPaciente').css('color', '');

        $('#estadoPaciente').prop('selectedIndex', 0);
        $('#estadoPaciente').css('border', '');
        $('#estadoPaciente').css('color', '');

        $('#municipioPaciente').append("<option disabled selected>" + "Seleccione un Municipio" + "</option>");
        $('#municipioPaciente').css('border', '');
        $('#municipioPaciente').css('color', '');
        
        $("#acepto-terminos").prop("checked", false);
        
        
        $('#telPaciente').val("");
        $('#telPaciente').css('border', '');
        $('#telPaciente').css('color', '');

        $('#correoPaciente').val("");
        $('#correoPaciente').css('border', '');
        $('#correoPaciente').css('color', '');
        
        $('#contraPaciente').val("");
        $('#contraPaciente').css('border', '');
        $('#contraPaciente').css('color', '');
        
        $('#confContraPaciente').val("");
        $('#confContraPaciente').css('border', '');
        $('#confContraPaciente').css('color', '');


        $('#errorNombrePaciente').hide();
        $('#errorCurpPaciente').hide();
        $('#errorCurpRepetidoPaciente').hide();
        $('#errorFechaPaciente').hide();
        $('#errorApellidoPaternoPaciente').hide();
        $('#errorApellidoMaternoPaciente').hide();
        $('#errorNombreUsuarioPaciente').hide();
        $('#errorUsuarioRepetidoPaciente').hide();
        $('#errorECivilPaciente').hide();
        $('#errorColoniaPaciente').hide();
        $('#errorCallePaciente').hide();
        $('#errorNoInteriorPaciente').hide();
        $('#errorNoExteriorPaciente').hide();
        $('#errorEstadoPaciente').hide();
        $('#errorMunicipioPaciente').hide();
        $('#errorTelefonoPaciente').hide();
        $('#errorCorreoPaciente').hide();
        $('#errorPasscurpPacientePaciente').hide();
        $('#errorPasscumplePacientePaciente').hide();
        $('#error-CPexistePaciente').hide();
        $('#errorCodigoPostalPaciente').hide();
        $('#errorPass1Paciente').hide();
        $('#noEqualPasswordsErrorPaciente').hide();
        $('#errorCorreoRepetidoPaciente').hide();
        $('#error-terminos').hide();

    });

    $("body").on("click", ".clearEditPacientesModal", function () {

        $('#editarNombreNavegadoraAPaciente').css('border', '');
        $('#editarNombreNavegadoraAPaciente').css('color', '');

        $('#editarCurpNavegadoraAPaciente').css('border', '');
        $('#editarCurpNavegadoraAPaciente').css('color', '');

        $('#editarCumpleNavegadoraAPaciente').css('border', '');
        $('#editarCumpleNavegadoraAPaciente').css('color', '');

        $('#editarPrimer-apellidoNavegadoraAPaciente').css('border', '');
        $('#editarPrimer-apellidoNavegadoraAPaciente').css('color', '');

        $('#editarSegundo-apellidoNavegadoraAPaciente').css('border', '');
        $('#editarSegundo-apellidoNavegadoraAPaciente').css('color', '');

        $('#editarUsuarioNavegadoraAPaciente').css('border', '');
        $('#editarUsuarioNavegadoraAPaciente').css('color', '');

        $('#editarEstado-civilPaciente').css('border', '');
        $('#editarEstado-civilPaciente').css('color', '');

        $('#editarColNavegadoraAPaciente').css('border', '');
        $('#editarColNavegadoraAPaciente').css('color', '');

        $('#editarCalleNavegadoraAPaciente').css('border', '');
        $('#editarCalleNavegadoraAPaciente').css('color', '');

        $('#editarNumIntNavegadoraAPaciente').css('border', '');
        $('#editarNumIntNavegadoraAPaciente').css('color', '');

        $('#editarNumExtNavegadoraAPaciente').css('border', '');
        $('#editarNumExtNavegadoraAPaciente').css('color', '');

        $('#editarEstadoNavegadoraAPaciente').css('border', '');
        $('#editarEstadoNavegadoraAPaciente').css('color', '');

        $('#editarTelNavegadoraAPaciente').css('border', '');
        $('#editarTelNavegadoraAPaciente').css('color', '');

        $('#editarCorreoNavegadoraAPaciente').css('border', '');
        $('#editarCorreoNavegadoraAPaciente').css('color', '');


        $('#error-editar-NombrePaciente').hide();
        $('#error-editar-ApellidoPaternoPaciente').hide();
        $('#error-editar-ApellidoMaternoPaciente').hide();
        $('#error-editar-NombreUsuarioPaciente').hide();
        $('#error-editar-CorreoPaciente').hide();
        $('#error-editar-CurpPaciente').hide();
        $('#error-editar-ColoniaPaciente').hide();
        $('#error-editar-CallePaciente').hide();
        $('#error-editar-NoExteriorPaciente').hide();
        $('#error-editar-NoInteriorPaciente').hide();
        $('#error-editar-CurpRepetidoPaciente').hide();
        $('#error-editar-TelefonoPaciente').hide();
        $('#error-editar-ECivilPaciente').hide();
        $('#error-editar-FechaPaciente').hide();
        $('#error-editar-EstadoPaciente').hide();
        $('#error-editar-MunicipioPaciente').hide();
        $('#error-editar-UsuarioRepetidoPaciente').hide();
        $('#errorEditarPacienteCorreoRepetido').hide();
        $('#error-editarDatosRepetidosPaciente').hide();
        $('#error-camposEditarPaciente').hide();
        
    });


    ////////FUNCIONALIDAD DE PANTALLAS

    //**PANTALLA 1 */
    $('#btn-continue1').on('click', function () {

        oculta(pantalla1);
        muestra(pantalla2);

    });

    //**PANTALLA2 */

    $('#btn-back2').on('click', function () {

        oculta(pantalla2);
        muestra(pantalla1);

    });


    $('#btn-continue2').on('click', function () {

        oculta(pantalla1)
        oculta(pantalla2);
        muestra(pantalla3);

    });

    //**PANTALLA3 */
    $('#btn-back3').on('click', function () {

        oculta(pantalla3);
        oculta(pantalla1);
        muestra(pantalla2);

    });

    $('#btn-continue3').on('click', function () {

        oculta(pantalla1);
        oculta(pantalla3)
        oculta(pantalla2);
        muestra(pantalla4);

    });

    //**PANTALLA4 */
    $('#btn-back4').on('click', function () {

        oculta(pantalla4);
        oculta(pantalla2);
        oculta(pantalla1);

        muestra(pantalla3);

    });

    $('#btn-continue4').on('click', function () {

        oculta(pantalla1);
        oculta(pantalla3)
        oculta(pantalla2);
        oculta(pantalla4);
        muestra(pantalla5);

    });

    //**PANTALLA5 */
    $('#btn-back5').on('click', function () {

        oculta(pantalla3);
        oculta(pantalla2);
        oculta(pantalla1);
        oculta(pantalla5);
        muestra(pantalla4);

    });


    function oculta(campo) {
        campo.hide();
    }

    function muestra(campo) {
        campo.show();
    }

    ////////FUNCIONALIDAD DE AGREGAR INPUTS DINAMICOS

    $('#resultado-patologia').on('change', function () {

        var opcion = $(this).val();

        if (parseInt(opcion) == parseInt("16")) {
            muestra($('#introducirOtro'));
        } else {
            oculta($('#introducirOtro'));
        }


    });



    $('#resultadoAnterior-patologia').on('change', function () {

        var opcion = $(this).val();

        if (parseInt(opcion) == parseInt("16")) {
            muestra($('#introducirOtroPatologia'));
        } else {
            oculta($('#introducirOtroPatologia'));
        }


    });

    //Pantalla 3
    //BOTONES DE AGREGAR

    //agregar biopsia

    $('.add-biopsia').on('click', function () {

        var plantilla =

            `<div class="form-group row mt-2 tuplaBiopsia" data-id="0" data-accion="agregar">


            <!-- tipo biopsia -->
            <div class="col-3">
                <input name="tipo-BipsiaAdded" type="text" class="form-control tipoBiopsia" list="listBiopsia" placeholder="Tipo de biopsiaa">
            </div>

            <!-- fecha biopsia -->
            <div class="col-4">
                <div class="input-group">
                    <div class="input-group-prepend">
                        <div class="input-group-text">
                            <i class="fas fa-calendar-alt"></i>
                        </div>
                    </div>
                    <input name="fecha-BipsiaAdded" placeholder="Fecha de la biopsia" class="form-control fechaBiopsia" type="text" onfocus="(this.type='date')">
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
                    <input name ="parte-BipsiaAdded" type="text" class="form-control parteCuerpoBiopsia" list="listLugarDelCuerpo" placeholder="Parte del cuerpo">
                </div>
            </div>

            <div class="col-2">
                <button type="button" class="btn btn-outline-danger ml-2 remove-biopsia" style="border-radius: 25px;">
                <i class="fas fa-times"></i>
                </button>
            </div>


        </div>`

        $('#biopsia-contenedor').append(plantilla);

    });

    //remover biopsia
    $('body').on('click', '.remove-biopsia', function () {
        $(this).parent().parent().data("accion", "eliminar");
        $(this).parent().parent().remove();
    });

    //agregar rayos
    $('.add-rayosX').on('click', function () {

        var plantilla =

            `
            <div class="form-group row mt-2 tuplaRayosX" data-id="0" data-accion="agregar">


                <!-- tipo rayos -->
                <div class="col-5">

                    <input name="tipo-RayosXAdded" type="text" class="form-control rayosX" list="listRayosX" placeholder="Tipo de rayos X">
                </div>

                <!-- fecha rayos -->
                <div class="col-5">
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <div class="input-group-text">
                                <i class="fas fa-calendar-alt"></i>
                            </div>
                        </div>
                        <input name ="fecha-RayosXAdded" placeholder="Fecha de los Rayos X" class="form-control fechaRayos" type="text" onfocus="(this.type='date')">
                    </div>
                </div>

                <div class="col-2">
                <button type="button" class="btn btn-outline-danger ml-2 remove-biopsia" style="border-radius: 25px;">
                <i class="fas fa-times"></i>
                </button>
            </div>

            </div>
        
     `

        $('#rayos-contenedor').append(plantilla);

    });

    //remover rayos
    $('body').on('click', '.remove-rayos', function () {
        $(this).parent().parent().data("accion", "eliminar");
        $(this).parent().parent().remove();
    });

    $('.add-ultrasonido').on('click', function () {

        var plantilla =

            `
            <div class="form-group row mt-2 tuplaUltrasonido" data-id="0" data-accion="agregar">


               
                <div class="col-5">
                    <input name ="parteCuperpo-USGAdded"type="text" class="form-control parteCuerpoUltrasonido ultraSonido" list="listUltraSonido" placeholder="Parte del cuerpo">
                </div>

            
                <div class="col-5">
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <div class="input-group-text">
                                <i class="fas fa-calendar-alt"></i>
                            </div>
                        </div>
                        <input name ="fecha-USGAdded" placeholder="Fecha de USG" class="form-control fechaUltrasonido" type="text" onfocus="(this.type='date')">
                    </div>
                </div>

                <div class="col-2">
                    <button type="button" class="btn btn-outline-danger ml-2 remove-ultrasonido" style="border-radius: 25px;">
                    <i class="fas fa-times"></i>
                    </button>
                </div>


            </div>
        
     `

        $('#ultrasonido-contenedor').append(plantilla);

    });

    //remover ultrasonidos
    $('body').on('click', '.remove-ultrasonido', function () {
        $(this).parent().parent().data("accion", "eliminar");
        $(this).parent().parent().remove();
    });

    $('.add-medicinaNuclear').on('click', function () {

        var plantilla =

            `
            <div class="form-group row mt-2 tuplaMedicinaNuclear" data-id="0" data-accion="agregar">

    
                    <div class="col-5">
                        <input name ="mNuclearAdded" type="text" class="form-control medicinaNuclear" list="listMedicinaNuclear" placeholder="Introduce medicina nuclear">
                    </div>

      
                    <div class="col-5">
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <div class="input-group-text">
                                    <i class="fas fa-calendar-alt"></i>
                                </div>
                            </div>
                            <input name ="fecha-mNuclearAdded" placeholder="Fecha de medicina nuclear" class="form-control fechaMedicinaNuclear" type="text" onfocus="(this.type='date')">
                        </div>
                    </div>

                    <div class="col-2">
                        <button type="button" class="btn btn-outline-danger ml-2 remove-medicinaNuclear" style="border-radius: 25px;">
                        <i class="fas fa-times"></i>
                        </button>
                    </div>

                </div>
        
     `

        $('#medicinaNuclear-contenedor').append(plantilla);

    });

    //remover rayos
    $('body').on('click', '.remove-medicinaNuclear', function () {
        $(this).parent().parent().data("accion", "eliminar");
        $(this).parent().parent().remove();
    });

    $('.add-laboratorio').on('click', function () {

        var plantilla =

            `
            <div class="form-group row mt-2 tuplaLaboratorio" data-id="0" data-accion="agregar">


                <div class="col-10">
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <div class="input-group-text">
                                <i class="fas fa-calendar-alt"></i>
                            </div>
                        </div>
                        <input name ="fecha-LaboAdded" placeholder="Fecha de laboratorio" class="form-control fechaLaboratorio" type="text" onfocus="(this.type='date')">
                    </div>
                </div>

                <div class="col-2">
                    <button type="button" class="btn btn-outline-danger ml-2 remove-laboratorio" style="border-radius: 25px;">
                    <i class="fas fa-times"></i>
                    </button>
                </div>
                    
            </div>
        
     `

        $('#laboratorio-contenedor').append(plantilla);

    });

    //remover laboratorio
    $('body').on('click', '.remove-laboratorio', function () {
        $(this).parent().parent().data("accion", "eliminar");
        $(this).parent().parent().remove();
    });

    $('.add-valoracion').on('click', function () {

        var plantilla =

            `
            <div class="form-group row mt-2 tuplaValoracion" data-id="0" data-accion="agregar">


       
                <div class="col-5">
                    <input name ="valoracionAdded" type="text" class="form-control valoracion" list="listValoracion" placeholder="Introduce valoración">
                </div>

                <div class="col-5">
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <div class="input-group-text">
                                <i class="fas fa-calendar-alt"></i>
                            </div>
                        </div>
                        <input name ="fecha-valoracionAdded" placeholder="Fecha de valoración" class="form-control fechaValoracion" type="text" onfocus="(this.type='date')">
                    </div>
                </div>

                <div class="col-2">
                    <button type="button" class="btn btn-outline-danger ml-2 remove-valoracion" style="border-radius: 25px;">
                    <i class="fas fa-times"></i>
                    </button>
                </div>

            </div>
        
     `

        $('#valoracion-contenedor').append(plantilla);

    });

    //remover valoracion
    $('body').on('click', '.remove-valoracion', function () {
        $(this).parent().parent().data("accion", "eliminar");
        $(this).parent().parent().remove();
    });

    $('.add-espirometria').on('click', function () {

        var plantilla =

            `
            <div class="form-group row mt-2 tuplaEspirometria" data-id="0" data-accion="agregar">


                <div class="col-10">
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <div class="input-group-text">
                                <i class="fas fa-calendar-alt"></i>
                            </div>
                        </div>
                        <input name="fecha-espilometriaAdded" placeholder="Fecha de espirometría" class="form-control fechaEspirometria" type="text" onfocus="(this.type='date')">
                    </div>
                </div>

                <div class="col-2">
                    <button type="button" class="btn btn-outline-danger ml-2 remove-espirometria" style="border-radius: 25px;">
                    <i class="fas fa-times"></i>
                    </button>
                </div>

            </div>
        
     `

        $('#espirometria-contenedor').append(plantilla);

    });

    //remover valoracion
    $('body').on('click', '.remove-espirometria', function () {
        $(this).parent().parent().data("accion", "eliminar");
        $(this).parent().parent().remove();
    });

    $('.add-electrocardiograma').on('click', function () {

        var plantilla =

            `
            <div class="form-group row mt-2 tuplaElectrocardiograma" data-id="0" data-accion="agregar">


                    <div class="col-10">
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <div class="input-group-text">
                                    <i class="fas fa-calendar-alt"></i>
                                </div>
                            </div>
                            <input name="fecha-ECGAdded" placeholder="Fecha de electrocardiograma" class="form-control fechaElectrocardiograma" type="text" onfocus="(this.type='date')">
                        </div>
                    </div>

                    <div class="col-2">
                        <button type="button" class="btn btn-outline-danger ml-2 remove-electrocardiograma" style="border-radius: 25px;">
                        <i class="fas fa-times"></i>
                        </button>
                    </div>

                </div>
        
     `

        $('#electrocardiograma-contenedor').append(plantilla);

    });

    //remover electrocardiograma
    $('body').on('click', '.remove-electrocardiograma', function () {
        $(this).parent().parent().data("accion", "eliminar");
        $(this).parent().parent().remove();
    });

    $('.add-ecocardiograma').on('click', function () {

        var plantilla =

            `
            <div class="form-group row mt-2 tuplaEcocardiograma" data-id="0" data-accion="agregar">


                    <div class="col-10">
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <div class="input-group-text">
                                    <i class="fas fa-calendar-alt"></i>
                                </div>
                            </div>
                            <input name="fecha-ecoAdded" placeholder="Fecha de ecocardiograma" class="form-control fechaEcocardiograma" type="text" onfocus="(this.type='date')">
                        </div>
                    </div>

                    <div class="col-2">
                        <button type="button" class="btn btn-outline-danger ml-2 remove-ecocardiograma" style="border-radius: 25px;">
                        <i class="fas fa-times"></i>
                        </button>
                    </div>
                    

                </div>
        
     `

        $('#ecocardiograma-contenedor').append(plantilla);

    });

    //remover ecocardiograma
    $('body').on('click', '.remove-ecocardiograma', function () {
        $(this).parent().parent().data("accion", "eliminar");
        $(this).parent().parent().remove();
    });

    $('.add-trabajoSocial').on('click', function () {

        var plantilla =

            `
            <div class="form-group row mt-2 tuplaTrabajoSocial" data-id="0" data-accion="agregar">


                <div class="col-10">
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <div class="input-group-text">
                                <i class="fas fa-calendar-alt"></i>
                            </div>
                        </div>
                        <input name="fecha-tSocilaAdded" placeholder="Fecha de trabajo social" class="form-control fechaTrabajoSocial" type="text" onfocus="(this.type='date')">
                    </div>
                </div>

                <div class="col-2">
                        <button type="button" class="btn btn-outline-danger ml-2 remove-trabajoSocial" style="border-radius: 25px;">
                        <i class="fas fa-times"></i>
                        </button>
                    </div>

            </div>
        
     `

        $('#trabajoSocial-contenedor').append(plantilla);

    });

    //remover trabajoSocial
    $('body').on('click', '.remove-trabajoSocial', function () {
        $(this).parent().parent().data("accion", "eliminar");
        $(this).parent().parent().remove();
    });

    $('.add-programa').on('click', function () {

        var plantilla =

            `
            <div class="form-group row mt-2 tuplaPrograma" data-id="0" data-accion="agregar">



                    <div class="col-5">
                        <input name="programaAdded" type="text" id="tipoPrograma" class="form-control programa" list="listPrograma" placeholder="Introduce programa">
                    </div>

                    <div class="col-5">
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <div class="input-group-text">
                                    <i class="fas fa-calendar-alt"></i>
                                </div>
                            </div>
                            <input name="fecha-programaAdded" placeholder="Fecha del programa" class="form-control fechaPrograma" type="text" onfocus="(this.type='date')">
                        </div>
                    </div>

                    <div class="col-2">
                        <button type="button" class="btn btn-outline-danger ml-2 remove-programa" style="border-radius: 25px;">
                        <i class="fas fa-times"></i>
                        </button>
                    </div>
                    
                </div>
        
     `

        $('#programa-contenedor').append(plantilla);

    });

    //remover trabajoSocial
    $('body').on('click', '.remove-programa', function () {
        $(this).parent().parent().data("accion", "eliminar");
        $(this).parent().parent().remove();
    });

    $('.add-otro').on('click', function () {

        var plantilla =

            `
            <div class="form-group row mt-2 tuplaOtro" data-id="0" data-accion="agregar">


                    <div class="col-5">
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <div class="input-group-text">
                                    <i class="fas fa-calendar-alt"></i>
                                </div>
                            </div>
                            <input name="fecha-otroAdded" placeholder="Fecha de otro" class="form-control fechaOtro" type="text" onfocus="(this.type='date')">
                        </div>
                    </div>

                    <div class="col-5">
                        <input name="otroAdded" type="text" class="form-control otro-estudioPreconsulta" placeholder="Introduce otro">
                    </div>

                    <div class="col-2">
                        <button type="button" class="btn btn-outline-danger ml-2 remove-otro" style="border-radius: 25px;">
                        <i class="fas fa-times"></i>
                        </button>
                    </div>

                </div>
        
     `

        $('#otro-contenedor').append(plantilla);

    });

    //remover trabajoSocial
    $('body').on('click', '.remove-otro', function () {
        $(this).parent().parent().data("accion", "eliminar");
        $(this).parent().parent().remove();
    });

    $('.add-llamada').on('click', function () {

        var plantilla =
                `
            <div class="tuplaLlamada mt-3" data-id="0" data-accion="agregar">
                <div class="row">
                    <div class="col-12">
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <div class="input-group-text">
                                    <i class="fas fa-calendar-alt"></i>
                                </div>
                            </div>
                            <input placeholder="Fecha llamada" class="form-control fecha-llamada" type="text" onfocus="(this.type='date')">
                            <button type="button" class="btn btn-outline-danger ml-3 remove-llamada" style="border-radius: 25px;">
                            <i class="fas fa-times"></i>
                            </button>
                        </div>
                    </div>
                </div>

                <div class="row mt-3">
                    <div class="col-12">
                        <textarea class="form-control comentario-llamada" style="min-height:100px;" placeholder="Introduce el motivo de la llamada "></textarea>
                    </div>
                </div>
            </div>
        
     `

        $('.llamadaInit').append(plantilla);

    });

    //remover trabajoSocial
    $('body').on('click', '.remove-llamada', function () {
        $(this).parent().parent().parent().parent().data("accion", "eliminar");
        $(this).parent().parent().parent().parent().remove();
    });

    //MEDICO RADIOLOGO OTRO
    $('#medico-radiologo').on('change', function () {

        if ($("#medico-radiologo option:selected").val() == 'otro') {
            muestra($('.contenedor-sustituto'));
        } else {
            oculta($('.contenedor-sustituto'));
        }
    });


    //SEGUROS, MASTOGRAFIA, ULTRASONIDO


    $('#tieneSeguroPopular').on('change', function () {

        var opcion1 = $('#tieneSeguroPopular').is(':checked') ? 1 : 0;

        switch (opcion1) {
            case 1:
                muestra($('#tiene-seguro'));
                break;
            case 0:
                oculta($('#numSeguro'));
                oculta($('#tiene-seguro'));
                break;
        }

    });

    $('#seguro').on('change', function () {
        $("#numSeguro").val("");
    });

    $('.tiene-seguro').on('change', function () {

        var opcion = $(this).val();

        if (parseInt(opcion) == parseInt("1")) {
            muestra($('#numSeguro'));
        } else {
            oculta($('#numSeguro'));
        }

    });


    $('#tiene-mastografia').on('change', () => {
        var tieneMastografia = $('#tiene-mastografia').is(':checked') ? 1 : 0;

        switch (tieneMastografia) {
            case 1:
                $('#tipoMastografia').show();
                $('#fechaMasto').show();
                break;
            case 0:
                $('#tipoMastografia').hide();
                $('#fechaMasto').hide();
                break;
        }
    });

    $('#tiene-ultrasonido-mama').on('change', () => {
        var tieneUltrasonido = $('#tiene-ultrasonido-mama').is(':checked') ? 1 : 0;

        switch (tieneUltrasonido) {
            case 1:
                $('#tipoUltrasonidoMama').show();
                $('#fechaUsg').show();
                break;
            case 0:
                $('#tipoUltrasonidoMama').hide();
                $('#fechaUsg').hide();
                break;
        }
    });

    $('#seLlamo').on('change', () => {
        var tieneLlamada = $('#seLlamo').is(':checked') ? 1 : 0;

        switch (tieneLlamada) {
            case 1:
                muestra($('.llamadaInit'));
                muestra($('.add-llamada'));
                break;
            case 0:
                oculta($('.llamadaInit'));
                oculta($('.add-llamada'));
                break;
        }
    });

    $('#entregaLaminillas').on('change', () => {

        var tieneLaminillas = $('#entregaLaminillas').is(':checked') ? 1 : 0;

        switch (tieneLaminillas) {
            case 1:

                muestra($('#contenedor-laminillas'));

                break;
            case 0:

                oculta($('#contenedor-laminillas'));

                break;
        }
    });

    $('#entregaBloques').on('change', () => {

        var tieneBloques = $('#entregaBloques').is(':checked') ? 1 : 0;

        switch (tieneBloques) {

            case 1:

                muestra($('#contenedor-bloques'));

                break;
            case 0:

                oculta($('#contenedor-bloques'));

                break;
        }
    });

    //TRATAMIENTOS

    $('#tiene-cirugia').on('change', () => {

        var tieneCirugia = $('#tiene-cirugia').is(':checked') ? 1 : 0;

        switch (tieneCirugia) {
            case 1:
                $('#divCirugia').show();
                break;
            case 0:
                $('#divCirugia').hide();
                break;
        }

    });

    $('#tiene-quimioterapia').on('change', () => {
        var tieneQuimioterapia = $('#tiene-quimioterapia').is(':checked') ? 1 : 0;

        switch (tieneQuimioterapia) {
            case 1:
                $('#divQuimioterapia').show();
                break;
            case 0:
                $('#divQuimioterapia').hide();
                break;
        }

    });


    $('#tiene-radioterapia').on('change', () => {
        var tieneRadioterapia = $('#tiene-radioterapia').is(':checked') ? 1 : 0;

        switch (tieneRadioterapia) {
            case 1:
                $('#divRadioterapia').show();
                break;
            case 0:
                $('#divRadioterapia').hide();
                break;
        }

    });


    //PANTALLA 3 estudios  //OMAR                                  

    $('#tiene-biopsia').on('change', () => {
        var tieneBiopsia = $('#tiene-biopsia').is(':checked') ? 1 : 0;

        switch (tieneBiopsia) {
            case 1:
                muestra($('#biopsia-contenedor'));
                muestra($('.add-biopsia'));
                break;
            case 0:
                oculta($('#biopsia-contenedor'));
                oculta($('.add-biopsia'));
                break;
        }
    });

    $('#tiene-rayosX').on('change', () => {

        var tieneRayosX = $('#tiene-rayosX').is(':checked') ? 1 : 0;

        switch (tieneRayosX) {
            case 1:
                muestra($('#rayos-contenedor'));
                muestra($('.add-rayosX'));
                break;
            case 0:
                oculta($('#rayos-contenedor'));
                oculta($('.add-rayosX'));
                break;
        }
    });


    $('#tiene-ultrasonido').on('change', () => {

        var tieneUltrasonido = $('#tiene-ultrasonido').is(':checked') ? 1 : 0;

        switch (tieneUltrasonido) {
            case 1:
                muestra($('#ultrasonido-contenedor'));
                muestra($('.add-ultrasonido'));
                break;
            case 0:
                oculta($('#ultrasonido-contenedor'));
                oculta($('.add-ultrasonido'));
                break;
        }
    });

    $('#tiene-medicina-nuclear').on('change', () => {

        var tieneMedicinaNuclear = $('#tiene-medicina-nuclear').is(':checked') ? 1 : 0;

        switch (tieneMedicinaNuclear) {
            case 1:
                muestra($('#medicinaNuclear-contenedor'));
                muestra($('.add-medicinaNuclear'));
                break;
            case 0:
                oculta($('#medicinaNuclear-contenedor'));
                oculta($('.add-medicinaNuclear'));
                break;
        }
    });


    $('#tiene-valoracion').on('change', () => {

        var tieneValoracion = $('#tiene-valoracion').is(':checked') ? 1 : 0;

        switch (tieneValoracion) {
            case 1:
                muestra($('#valoracion-contenedor'));
                muestra($('.add-valoracion'));
                break;
            case 0:
                oculta($('#valoracion-contenedor'));
                oculta($('.add-valoracion'));
                break;
        }
    });

    $('#tiene-espirometria').on('change', () => {

        var tieneEspirometria = $('#tiene-espirometria').is(':checked') ? 1 : 0;

        switch (tieneEspirometria) {
            case 1:
                muestra($('#espirometria-contenedor'));
                muestra($('.add-espirometria'));
                break;
            case 0:
                oculta($('#espirometria-contenedor'));
                oculta($('.add-espirometria'));
                break;
        }
    });


    $('#tiene-electrocardiograma').on('change', () => {

        var tieneElectrocardiograma = $('#tiene-electrocardiograma').is(':checked') ? 1 : 0;

        switch (tieneElectrocardiograma) {
            case 1:
                muestra($('#electrocardiograma-contenedor'));
                muestra($('.add-electrocardiograma'));
                break;
            case 0:
                oculta($('#electrocardiograma-contenedor'));
                oculta($('.add-electrocardiograma'));
                break;
        }
    });

    $('#tiene-laboratorio').on('change', () => {

        var tieneLaboratorio = $('#tiene-laboratorio').is(':checked') ? 1 : 0;

        switch (tieneLaboratorio) {
            case 1:
                muestra($('#laboratorio-contenedor'));
                muestra($('.add-laboratorio'));
                break;
            case 0:
                oculta($('#laboratorio-contenedor'));
                oculta($('.add-laboratorio'));
                break;
        }
    });


    $('#tiene-ecocardiograma').on('change', () => {
        var tieneEcocardiograma = $('#tiene-ecocardiograma').is(':checked') ? 1 : 0;

        switch (tieneEcocardiograma) {
            case 1:
                muestra($('#ecocardiograma-contenedor'));
                muestra($('.add-ecocardiograma'));
                break;
            case 0:
                oculta($('#ecocardiograma-contenedor'));
                oculta($('.add-ecocardiograma'));
                break;
        }
    });

    $('#tiene-trabajo-social').on('change', () => {

        var tieneTrabajoSocial = $('#tiene-trabajo-social').is(':checked') ? 1 : 0;

        switch (tieneTrabajoSocial) {
            case 1:
                muestra($('#trabajoSocial-contenedor'));
                muestra($('.add-trabajoSocial'));
                break;
            case 0:
                oculta($('#trabajoSocial-contenedor'));
                oculta($('.add-trabajoSocial'));
                break;
        }
    });

    $('#tiene-programa').on('change', () => {

        var tienePrograma = $('#tiene-programa').is(':checked') ? 1 : 0;

        switch (tienePrograma) {
            case 1:
                muestra($('#programa-contenedor'));
                muestra($('.add-programa'));
                break;
            case 0:
                oculta($('#programa-contenedor'));
                oculta($('.add-programa'));
                break;
        }
    });

    $('#tiene-otro').on('change', () => {

        var tieneOtro = $('#tiene-otro').is(':checked') ? 1 : 0;

        switch (tieneOtro) {
            case 1:
                muestra($('#otro-contenedor'));
                muestra($('.add-otro'));
                break;
            case 0:
                oculta($('#otro-contenedor'));
                oculta($('.add-otro'));
                break;
        }
    });

    //OMAR

    $('#add-datosLlamada').on('click', () => {
        var nuevosDatos = `<div class="col-5" id="fechaLlamada">
        <div class="input-group">
            <div class="input-group-prepend">
                <div class="input-group-text">
                    <i class="fas fa-calendar-alt"></i>
                </div>
            </div>
            <input placeholder="Fecha llamada" class="selectStyle form-control textbox-n" type="text" onfocus="(this.type='date')"  id="fecha-llamada">                                        
        </div>
    </div>


    <div class="form-group row">
        <div class="col-12 m-3">
            <textarea class="form-control comentario-llamada" id="motivoLlamada" style="min-height:100px;"
                placeholder="Introduce el motivo de la llamada "></textarea>
        </div>
    </div>`;
        $('#datosLlamada').append(nuevosDatos);
    });


    //Ver Comentario navegadora


    $('body').on('click', '.verComentario', function () {

        $(this).data('id')

        var comentario = "<span class='d-block'>" + $("#comentario-" + $(this).data('id')).val() + "</span>";
        $("#modalComentario").append(comentario);


    });
    $("#cerrarModal").on("click", function () {
        $("#modalComentario").empty();
    });

    $("#aceptarModal").on("click", function () {
        $("#modalComentario").empty();
    });
    
    
   $('body').on('click', '.btn-aceptar-potencial', function () {
        $('#hidden-idPaciente').val('');
            console.log("Me estás aceptando "+ $(this).data('id'));        
        $('#hidden-idPaciente').val($(this).data('id'));
    });
    
    $("body").on("click", ".clearMotivo", function () {
        $("#motivoRechazo").attr("type", "text").val('').attr("placeholder", "Introduce el motivo de rechazo");
    });
   
    //Mediaqueries
    $(window).resize(function () {

        if ($(window).width() <= 500) {

            $('#text-save1').html('<span id="text-save1">Guardar y Continuar</span>');
            

        }

    });
    
    $("body").on("click", ".clearPassNavegadora", function () {
        
        $("#password").val("");
        $("#password2").val("");

        $('#error-contrasena').hide();
        $('#noEqualPasswordsError').hide();

        $('#password').css('border', '');
        $('#password').css('color', '');

        $('#password2').css('border', '');
        $('#password2').css('color', '');


    });

    function mostrarContrasena(myButton, myField) {
        myButton.on('mousedown', function () {
            var x = document.getElementById(myField);
            x.type = "text";
        });
        myButton.on('mouseup', function () {
            var x = document.getElementById(myField);
            x.type = "password";
        });
    }

});
