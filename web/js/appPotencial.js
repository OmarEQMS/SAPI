

$(document).ready(function () {

    //Esconder mensajes de error en cuenta
    $('#error-correo').hide();
    $('#error-tel').hide();
    $('#error-contraseña').hide();
    $('#error-notEqualPasswords').hide();

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
    $('body').on('change', '.custom-file-input', function () {
        $(this).next('.custom-file-label').addClass("selected").html($(this).val());
    });

    //Esconder menu lateral a presionar click en el menu hamburguesa
    $('#sidebarCollapse').on('click', () => {
        $('#sidebar, #content').toggleClass('active');
        $('.collapse.in').toggleClass('in');
        $('a[aria-expanded=true]').attr('aria-expanded', 'false');
    });

    //Desabilitar los inputs subidos
    //$('#fileIdentificacionSubido').attr('disabled', 'disabled');
    //$('#fileComprobanteDomicilioSubido').attr('disabled', 'disabled');
    //$('#fileCURPSubido').attr('disabled', 'disabled');
    //$('#fileEstudioPrevioMastoSubido').attr('disabled', 'disabled');
    //$('#fileEstudioPrevioUsgSubido').attr('disabled', 'disabled');
    //$('#fileEstudioBiopsiaSubido').attr('disabled', 'disabled');
  


    $("#motivoConsulta").on('change', () => {

        var motivo = $('#motivoConsulta').val();
        console.log(motivo);

        switch (motivo) {
            case "1":
                $('#documentoAdjuntoMotivo').html("");
                $('#otroHospital').html("");
                $('#estudioMotivo').html("");

                var referencia =
                        '<div class="col-3 text-center">'
                        + '<span class="textoDocumento">Referencia</span>'
                        + '</div>'
                        + '<div class="custom-file col-8" id="customFile">'
                        + '<input type="file" class="custom-file-input" name="referenciaArchivo" multiple="multiple" aria-describedby="fileHelp">'
                        + '<label class="custom-file-label">'
                        + 'Adjunta la hoja de referencia de médico.'
                        + '</label>'
                        + '</div>';

                $('#documentoAdjuntoMotivo').html(referencia);
                break;
            case "4":

                $('#documentoAdjuntoMotivo').html("");
                $('#otroHospital').html("");
                $('#estudioMotivo').html("");

                var otroHospital =
                        '<div class="col-3 text-center">'
                        + '<span class="textoDocumento">Hospital</span>'
                        + '</div>'
                        + '<div class="custom-file col-8 p-0 m-0" id="customFile">'
                        + '<input type="text" class="form-control" id="otroHospital" placeholder="Introduce tu hospital de procedencia">'
                        + '</div>';

                var referencia =
                        '<div class="col-3 text-center">'
                        + '<span class="textoDocumento">Referencia</span>'
                        + '</div>'
                        + '<div class="custom-file col-8" id="customFile">'
                        + '<input type="file" class="custom-file-input" name="referenciaArchivo" multiple="multiple" aria-describedby="fileHelp">'
                        + '<label class="custom-file-label">'
                        + 'Adjunta la hoja de referencia de médico del hospital.'
                        + '</label>'
                        + '</div>';
                ;
                $('#documentoAdjuntoMotivo').html(referencia);
                $('#otroHospital').html(otroHospital);
                break;
            case "5":
                console.log("OTRO");
                $('#documentoAdjuntoMotivo').html("");
                $('#otroHospital').html("");
                $('#estudioMotivo').html("");

                var otroHospital =
                        '<div class="col-3 text-center">'
                        + '<span class="textoDocumento">Otro motivo</span>'
                        + '</div>'
                        + '<div class="custom-file col-8 p-0 m-0" id="customFile">'
                        + '<input type="text" class="form-control" id="otro-motivo-consulta" placeholder="Introduce otro motivo">'
                        + '</div>';

                $('#otroHospital').html(otroHospital);
                break;
            case "2":
                $('#documentoAdjuntoMotivo').html("");
                $('#otroHospital').html("");
                $('#estudioMotivo').html("");

                var estudio =
                        '<div class="col-3 text-center">'
                        + '<span class="textoDocumento">Estudios previos</span>'
                        + '</div>'

                        + '<div class="custom-file col-8" id="customFile">'
                        + '<input type="file" class="custom-file-input" multiple="multiple" aria-describedby="fileHelp">'
                        + '<label class="custom-file-label">'
                        + 'Elegir archivos...(Puedes subir mas de uno)'
                        + '</label>'
                        + '</div>'

                        + '<div class="col-1 iconoQuestion align-self-center">'
                        + '<a href="#" class="questionMark" data-tooltip-content="#tooltip_content2"><i'
                        + 'class="fas fa-question-circle"></i></a>'
                        + '</div>'

                        + '<div class="tooltip_templates">'
                        + '<span id="tooltip_content2">'
                        + 'Puedes subir mas de un archivo'
                        + '</span>'
                        + '</div>';

                $('#estudioMotivo').html(estudio);
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

    var m = moment(new Date(fechaPre)).locale('es').format('LL') + ' a las: ' + "<strong>" + moment(new Date(fechaPre)).locale('es').format('LT') + "</strong>";

    $('#fechaCitaPreConsulta').html(m);

    //Navegacion
    var fechaNav = $('#fechaCitaNavegacion').html();

    var m = moment(new Date(fechaNav)).locale('es').format('LL') + ' a las: ' + "<strong>" + moment(new Date(fechaNav)).locale('es').format('LT') + "</strong>";

    $('#fechaCitaNavegacion').html(m);


    //MediaQueries

});