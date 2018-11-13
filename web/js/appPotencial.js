$(document).ready(function () {

    console.log("WTF");

    //Esconder mensajes de error en cuenta
    $('#error-correo').hide();
    $('#error-tel').hide();

    //Esconder mensajes de error en index
    $('#error-identificacionOficial').hide();
    $('#error-CURP').hide();
    $('#error-comprobanteDomicilio').hide();
    $('#error-motivoConsulta').hide();
    $('#error-previoMasto').hide();
    $('#error-previoUsg').hide();
    $('#error-biopsia').hide();


    // Inicializar plug in tooltipster
    $('.questionMark').tooltipster({
        theme: 'tooltipster-shadow',
        delay: '140'
    });

    $('[data-toggle="tooltip"]').tooltipster({
        theme: 'tooltipster-shadow',
        delay: '140'
    });

    $('#biopsiaContenedor').hide();
    $('#biopsiaQuestion').hide();


    //Reemplazar el nombre del archivo en el input


    //Esconder menu lateral a presionar click en el menu hamburguesa
    $('#sidebarCollapse').on('click', () => {
        $('#sidebar, #content').toggleClass('active');
        $('.collapse.in').toggleClass('in');
        $('a[aria-expanded=true]').attr('aria-expanded', 'false');
    });

    //Desabilitar los inputs subidos

    /*$('#fileIdentificacionSubido').attr('disabled', 'disabled');
     $('#fileComprobanteDomicilioSubido').attr('disabled', 'disabled');
     $('#fileCURPSubido').attr('disabled', 'disabled');
     $('#fileEstudioPrevioMastoSubido').attr('disabled', 'disabled');
     $('#fileEstudioPrevioUsgSubido').attr('disabled', 'disabled');
     $('#fileEstudioBiopsiaSubido').attr('disabled', 'disabled');
     */


    $("#motivoConsulta").on('change', () => {

        var motivo = $('#motivoConsulta').val();
        console.log(motivo);

        switch (motivo) {
            case "0":
                $('#documentoAdjuntoMotivo').html("");
                $('#otroHospital').html("");
                break;
                
            case "1":
                $('#documentoAdjuntoMotivo').html("");
                $('#otroHospital').html("");

                var referencia =
                        '<div class="col-3 text-center">'
                        + '<span class="textoDocumento">Referencia</span>'
                        + '</div>'
                        + '<div class="custom-file col-8" id="customFile">'
                        + '<input type="file" class="custom-file-input" id="referenciaArchivo" name="referenciaArchivo" multiple="multiple" aria-describedby="fileHelp">'
                        + '<span class="text-danger" id="error-referencia">No es una extensión válida. Puedes subir un archivo .jpg, .jpeg, .png, .pdf o .docx</span>'
                        + '<label class="custom-file-label">'
                        + 'Adjunta la hoja de referencia de médico.'
                        + '</label>'
                        + '</div>';

                $('#documentoAdjuntoMotivo').html(referencia);

                $('#error-referencia').hide();

                break;

            case "3":
                $('#documentoAdjuntoMotivo').html("");
                $('#otroHospital').html("");
                break;

            case "4":

                $('#documentoAdjuntoMotivo').html("");
                $('#otroHospital').html("");

                var otroHospital =
                        '<div class="col-3 text-center">'
                        + '<span class="textoDocumento">Hospital</span>'
                        + '</div>'
                        + '<div class="custom-file col-8 p-0 m-0" id="customFile">'
                        + '<input type="text" class="form-control" id="otroHospital" name="otroHospital" placeholder="Introduce tu hospital de procedencia">'
                        + '</div>';

                var referencia =
                        '<div class="col-3 text-center">'
                        + '<span class="textoDocumento">Referencia</span>'
                        + '</div>'
                        + '<div class="custom-file col-8" id="customFile">'
                        + '<input type="file" class="custom-file-input" id="referenciaArchivo" name="referenciaArchivo" multiple="multiple" aria-describedby="fileHelp">'
                        + '<span class="text-danger" id="error-referencia">No es una extensión válida. Puedes subir un archivo .jpg, .jpeg, .png, .pdf o .docx</span>'
                        + '<label class="custom-file-label">'
                        + 'Adjunta la hoja de referencia de médico del hospital.'
                        + '</label>'
                        + '</div>';
                ;
                $('#documentoAdjuntoMotivo').html(referencia);
                $('#otroHospital').html(otroHospital);
                $('#error-referencia').hide();
                break;

            case "5":
                console.log("OTRO");
                $('#documentoAdjuntoMotivo').html("");
                $('#otroHospital').html("");

                var otroHospital =
                        '<div class="col-3 text-center">'
                        + '<span class="textoDocumento">Otro motivo</span>'
                        + '</div>'
                        + '<div class="custom-file col-8 p-0 m-0" id="customFile">'
                        + '<input type="text" class="form-control" id="otro-motivo-consulta" placeholder="Introduce otro motivo">'
                        + '</div>';

                $('#documentoAdjuntoMotivo').html(otroHospital);
                break;



            default:
                console.log("default");
                break;
        }
    });

    //Checkbox biopsia al cargar la página
    var tieneBiopsia = $('#biopsiaInput').is(':checked') ? 1 : 0;

    switch (tieneBiopsia) {
        case 1:
            $('#biopsiaContenedor').show();
            $('#biopsiaQuestion').show();
            break;
        case 0:
            $('#biopsiaContenedor').hide();
            $('#biopsiaQuestion').hide();
            break;
    }

    //Checkbox biopsia al picar el checkbox
    $('#biopsiaInput').on('change', () => {

        var tieneBiopsia = $('#biopsiaInput').is(':checked') ? 1 : 0;

        switch (tieneBiopsia) {
            case 1:
                $('#biopsiaContenedor').show();
                $('#biopsiaQuestion').show();
                break;
            case 0:
                $('#biopsiaContenedor').hide();
                $('#biopsiaQuestion').hide();
                break;
        }
    });

    //Radio de hombre y mujer
    $('#masculino').on('change', () =>
    {
        var masculino = $('#masculino').is(':checked') ? 1 : 0;

        if (masculino === 1)
        {
            $('#femenino').prop('checked', false);
        }
    });
    $('#femenino').on('change', () =>
    {
        var femenino = $('#femenino').is(':checked') ? 1 : 0;

        if (femenino === 1)
        {
            $('#masculino').prop('checked', false);
        }
    });
    
     $("body").on("click",".myCleaner", function(){
		$("#password").val("");
                $("#password2").val("");
                
                $('#error-contrasena').hide();
                $('#noEqualPasswordsError').hide();
                $('#password').css('border', '');
                $('#password').css('color', '');
                $('#password2').css('border', '');
                $('#password2').css('color', '');
                
	});

    //Cambiar de pestañas al presionar continuar


    $('#btn-continuar').on('click', function () {

        console.log("Presionó continuar")
        $('#nav-bienvenida-tab').removeClass('active');
        $('#nav-solicitud-tab').addClass('active');

        $('#nav-bienvenida').removeClass('show').removeClass('active');
        $('#solicitud').addClass('show').addClass('active');

        $('html, body').animate({
            scrollTop: $("#solicitud").offset().top - 100
        }, 400);

    });

    //Parsear la fechas

    //Preconsulta
    var fechaPre = $('#fechaCitaPreConsulta').html();
    console.log("----------------------");
    console.log("Se parsearon las fechas");
    console.log("----------------------");
    var m = moment(new Date(fechaPre)).locale('es').format('LL') + ' a las: ' + "<strong>" + moment(new Date(fechaPre)).locale('es').format('LT') + "</strong>";

    $('#fechaCitaPreConsulta').html(m);

    //Navegacion
    var fechaNav = $('#fechaCitaNavegacion').html();

    var m = moment(new Date(fechaNav)).locale('es').format('LL') + ' a las: ' + "<strong>" + moment(new Date(fechaNav)).locale('es').format('LT') + "</strong>";

    $('#fechaCitaNavegacion').html(m);


    //MediaQueries

});